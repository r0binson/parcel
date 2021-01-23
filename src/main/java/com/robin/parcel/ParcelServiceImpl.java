/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robin.parcel;

import com.robin.parcel.rules.HeavyParcelRule;
import com.robin.parcel.rules.LargeParcelRule;
import com.robin.parcel.rules.MediumParcelRule;
import com.robin.parcel.rules.RejectRule;
import com.robin.parcel.rules.Rule;
import com.robin.parcel.rules.SmallParcelRule;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author robin
 */
@Component("ParcelServiceImpl")
public class ParcelServiceImpl implements ParcelService {

	private final List<Rule> sortedRulesByPriority = loadRules();

	@Override
	public Parcel getCost(Dimension dimension) throws Exception {
		double parcelCost = getParcelCost(dimension);
		
		Parcel parcel = new Parcel();
		parcel.setDimension(dimension);
		parcel.setFinalCost(parcelCost);		
		return parcel;
	}

	@Override
	public ParcelWithVoucher getCost(Dimension dimension, String voucher) throws Exception {
		double parcelCost = getParcelCost(dimension);
		float voucherDiscount = getVoucherDiscount(voucher);
		double finalCost = applyDiscount(parcelCost, voucherDiscount);
		
		ParcelWithVoucher parcelWithVoucher = new ParcelWithVoucher();
		parcelWithVoucher.setDimension(dimension);
		parcelWithVoucher.setVoucher(voucher);
		parcelWithVoucher.setDiscount(voucherDiscount);
		parcelWithVoucher.setParcelCost(parcelCost);
		parcelWithVoucher.setFinalCost(finalCost);
		
		return parcelWithVoucher;
	}

	private double applyDiscount(double parcelCost, float voucherDiscount) {
		return parcelCost * ((100.0 - voucherDiscount)/100);
	}

	private double getParcelCost(Dimension dimension) throws Exception {
		for (Rule rule : sortedRulesByPriority) {
			if (rule.isRuleConditionTrue(dimension)) {
				return rule.applyCost(dimension);
			};
		}
		throw new Exception("No Rules was Applied.");
	}

	private List<Rule> sortRulesByPriority(List<Rule> rules) {
		rules.sort((Rule rule1, Rule rule2) -> {
			return Integer.compare(rule1.getPriority(), rule2.getPriority());
		});
		return rules;
	}

	private float getVoucherDiscount(String voucherCode) throws MalformedURLException, ProtocolException, IOException {
		Voucher voucher = new Voucher();
		VoucherItem vItem = (VoucherItem)voucher.getVoucherDiscount(voucherCode);
		return vItem.getDiscount();
	}


	private List<Rule> loadRules() {
		List rules = new ArrayList();
		rules.add(new RejectRule(1));
		rules.add(new HeavyParcelRule(2));
		rules.add(new SmallParcelRule(3));
		rules.add(new MediumParcelRule(4));
		rules.add(new LargeParcelRule(5));
		return sortRulesByPriority(rules);
	}

}
