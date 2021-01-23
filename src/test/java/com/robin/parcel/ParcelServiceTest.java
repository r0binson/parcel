/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robin.parcel;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author robin
 */
public class ParcelServiceTest {

	public ParcelServiceTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@Test
	public void testWhenParcelIsTooHeavy() {

		//Given
		double weight = 51;
		double length = 10;
		double width = 20;
		double height = 30;
		String expectedMesssage = "N/A - Weight Exceeds 50Kg";
		String actualMessage;

		Dimension dimension = new Dimension(weight, length, width, height);
		ParcelService parcelService = new ParcelServiceImpl();
		
		//When 
		Exception exception = Assertions.assertThrows(Exception.class, () -> {
			Parcel parcel = parcelService.getCost(dimension);			
		});
		
		actualMessage = exception.getMessage();
		
		//Then
		 Assertions.assertTrue(actualMessage.contains(expectedMesssage));
	}


	@Test
	public void testWhenParcelWeightExceeds10Kg() {

		//Given
		double weight = 50;
		double length = 10;
		double width = 20;
		double height = 30;
		double expectedCost = 1000;
		double actualCost = 0;

		Dimension dimension = new Dimension(weight, length, width, height);
		ParcelService parcelService = new ParcelServiceImpl();

		//When 
		try {
			Parcel parcel = parcelService.getCost(dimension);
			actualCost = parcel.getFinalCost();			
		} catch (Exception e) {}
		
		//Then
		 Assertions.assertEquals(expectedCost, actualCost);
	}


	@Test
	public void testWhenParcelWeightIsLessThan1500cubicCM() {

		//Given
		double weight = 9;
		double length = 10;
		double width = 20;
		double height = 3;
		double expectedCost = 18;
		double actualCost = 0;

		//weight should be less than 10Kg to trigger the priority 3 rule
		Dimension dimension = new Dimension(weight, length, width, height);
		ParcelService parcelService = new ParcelServiceImpl();
		
		//When 
		try {
			Parcel parcel = parcelService.getCost(dimension);
			actualCost = parcel.getFinalCost();
		} catch (Exception e) {}
		
		//Then
		 Assertions.assertEquals(expectedCost, actualCost);
	}

	@Test
	public void testWhenParcelWeightIsLarge() {

		//Given
		double weight = 9;
		double length = 10;
		double width = 15;
		double height = 20;
		double expectedCost = 150;
		double actualCost = 0;
		
		//weight should be less than 10Kg to trigger the priority 3 to 5 rule
		Dimension dimension = new Dimension(weight, length, width, height);
		ParcelService parcelService = new ParcelServiceImpl();

		//When 
		try {
			Parcel parcel = parcelService.getCost(dimension);
			actualCost = parcel.getFinalCost();
		} catch (Exception e) {}
		
		//Then
		 Assertions.assertEquals(expectedCost, actualCost);
	}
	

	@Test
	public void testWhenParcelWeightIsLessThan2500cubicCM() {

		//Given
		double weight = 9;
		double length = 10;
		double width = 10;
		double height = 20;
		double expectedCost = 80;
		double actualCost = 0;
		
		//weight should be less than 10Kg to trigger the priority 3 to 5 rule
		Dimension dimension = new Dimension(weight, length, width, height);
		ParcelService parcelService = new ParcelServiceImpl();
		
		//When 
		try {
			Parcel parcel = parcelService.getCost(dimension);
			actualCost = parcel.getFinalCost();
		} catch (Exception e) {}
		
		//Then
		 Assertions.assertEquals(expectedCost, actualCost);
	}
	
	@Test
	public void testWhenParcelIsMediumWithVoucher() {

		//Given
		double weight = 9;
		double length = 10;
		double width = 15;
		double height = 15;
		String voucher = "MYNT";
		double expectedCost = 78.975;
		double actualCost = 0;

		//weight should be less than 10Kg to trigger the priority 3 to 5 rule
		Dimension dimension = new Dimension(weight, length, width, height);
		ParcelService parcelService = new ParcelServiceImpl();
		
		//When 
		try {
			Parcel parcel = parcelService.getCost(dimension, voucher);
			actualCost = parcel.getFinalCost();
		} catch (Exception e) {}
		
		//Then
		 Assertions.assertEquals(expectedCost, actualCost);
	}


	@Test
	public void testWhenParcelIsLargeWithVoucher() {

		//Given
		double weight = 9;
		double length = 10;
		double width = 15;
		double height = 20;
		String voucher = "MYNT";
		double expectedCost = 131.625;
		double actualCost = 0;

		//weight should be less than 10Kg to trigger the priority 3 to 5 rule
		Dimension dimension = new Dimension(weight, length, width, height);
		ParcelService parcelService = new ParcelServiceImpl();
		
		//When 
		try {
			Parcel parcel = parcelService.getCost(dimension, voucher);
			actualCost = parcel.getFinalCost();
		} catch (Exception e) {}
		
		//Then
		 Assertions.assertEquals(expectedCost, actualCost);
	}
	
}
