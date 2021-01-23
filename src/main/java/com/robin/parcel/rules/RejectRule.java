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
public class RejectRule extends Rule {

	public RejectRule(int priority) {
			super(priority);
			this.ruleName = "REJECT";
	}

	
	@Override
	public boolean isRuleConditionTrue(Dimension dimension) {
		return dimension.getWeight()>50;
	}

	@Override
	public double applyCost(Dimension dimension) throws Exception {
		throw new Exception("N/A - Weight Exceeds 50Kg"); 
	}
	
}
