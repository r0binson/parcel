/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robin.parcel;

/**
 *
 * @author robin
 */
public class ParcelWithVoucher extends Parcel {

	private String voucher;
	private float discount;
	private double parcelCost;

	/**
	 * @return the voucher
	 */
	public String getVoucher() {
		return voucher;
	}

	/**
	 * @param voucher the voucher to set
	 */
	public void setVoucher(String voucher) {
		this.voucher = voucher;
	}

	/**
	 * @return the discount
	 */
	public float getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(float discount) {
		this.discount = discount;
	}

	/**
	 * @return the parcelCost
	 */
	public double getParcelCost() {
		return parcelCost;
	}

	/**
	 * @param parcelCost the parcelCost to set
	 */
	public void setParcelCost(double parcelCost) {
		this.parcelCost = parcelCost;
	}

}
