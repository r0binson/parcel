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
public abstract class Rule {
	private int priority ;
	protected String ruleName;
	
	public Rule(int priority){
		this.priority = priority;
	}
	
	public abstract boolean isRuleConditionTrue(Dimension dimension);
	public abstract double applyCost(Dimension dimension) throws Exception;

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @return the ruleName
	 */
	public String getRuleName() {
		return ruleName;
	}
}
