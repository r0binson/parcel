/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robin.parcel;

import com.robin.parcel.rules.HeavyParcelRule;
import com.robin.parcel.rules.RejectRule;
import com.robin.parcel.rules.Rule;
import com.robin.parcel.rules.SmallParcelRule;
import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author robin
 */
public class SortListTest {
	
	public SortListTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}

	
	 @Test
	 public void testRulesListIsSortedByPriority() {
		 //Given
 		List<Rule> rules = new ArrayList();
		Rule rejectRule = new RejectRule(1);
		Rule heavyParcelRule = new HeavyParcelRule(2);
		Rule smallParcelRule = new SmallParcelRule(3);
		
		rules.add(smallParcelRule);
		rules.add(heavyParcelRule);
		rules.add(rejectRule);

		Rule expected = rejectRule;
		Rule actual;
		
		//When
		rules.sort((Rule rule1, Rule rule2) -> {
			return Integer.compare(rule1.getPriority(), rule2.getPriority());
		});
		actual = rules.get(0);

		
		//Then
		Assertions.assertEquals(expected.getPriority(), actual.getPriority());
		 
	 }
}
