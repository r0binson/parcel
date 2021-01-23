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
public class SmallParcelRule extends Rule{

	public SmallParcelRule(int priority) {
		super(priority);
		super.ruleName = "Small Parcel";
	}
	
	@Override
	public boolean isRuleConditionTrue(Dimension dimension) {
		return dimension.getVolume() < 1500;
	}

	@Override
	public double applyCost(Dimension dimension) throws Exception {
		return 0.03 * dimension.getVolume();
	}
	
}
