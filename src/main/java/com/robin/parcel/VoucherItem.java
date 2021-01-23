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
public class VoucherItem {
	private String code;
	private float discount;
	private String expiry;

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * @return the date
	 */
	public String  getExpiry() {
		return expiry;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String expiry) {
		this.expiry = expiry;
	}
}
