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
public class LargeParcelRule extends Rule{

	public LargeParcelRule(int priority) {
		super(priority);
		this.ruleName = "Large Parcel";
	}

	@Override
	public boolean isRuleConditionTrue(Dimension dimension) {
		return true;
	}

	@Override
	public double applyCost(Dimension dimension) throws Exception {
		return 0.05 * dimension.getVolume();
	}
	
}
