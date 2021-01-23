/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robin.parcel.rules;

import com.robin.parcel.Dimension;

/**
 *
 * @author robin
 */
public class HeavyParcelRule extends Rule{

	public HeavyParcelRule(int priority) {
		super(priority);
		this.ruleName = "Heavy Parcel";
	}

	@Override
	public boolean isRuleConditionTrue(Dimension dimension) {
		return dimension.getWeight() > 10;
	}

	@Override
	public double applyCost(Dimension dimension) throws Exception {
		//Implement Voucher discount later
		return 20 * dimension.getWeight();
	}
	
}
