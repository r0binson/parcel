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
public interface ParcelService {	
	public ParcelWithVoucher getCost(Dimension dimension, String voucher) throws Exception;
	public Parcel getCost(Dimension dimension) throws Exception;
} 
