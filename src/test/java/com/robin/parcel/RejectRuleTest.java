/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robin.parcel;

import com.robin.parcel.rules.RejectRule;
import com.robin.parcel.rules.Rule;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author robin
 */
public class RejectRuleTest {
	
	public RejectRuleTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}

	 @Test
	 public void testWhenPackageWeightIsGreaterThan50Kg() {
		 //Given
		 Dimension dimension = new Dimension(51, 10, 20, 30);
		 Rule rejectRule = new RejectRule(1);
		 
		 //When
		 boolean isCondition = rejectRule.isRuleConditionTrue(dimension);
		 
		//Then
		 Assertions.assertTrue(isCondition);
		 		 
	 }


	 @Test
	 public void testWhenPackageWeightIsLessThan50Kg() {
		 //Given
		 Dimension dimension = new Dimension(49, 10, 20, 30);
		 Rule rejectRule = new RejectRule(1);
		 
		 //When
		 boolean isCondition = rejectRule.isRuleConditionTrue(dimension);
		 
		//Then
		 Assertions.assertFalse(isCondition);
		 		 
	 }

}
