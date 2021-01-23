/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robin.parcel;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author robin
 */
public class Voucher {

	public Object getVoucherDiscount(String voucher) {
		try {
			StringBuilder urlBuilder = new StringBuilder("http://mynt-exam.mocklab.io/voucher/");
			urlBuilder
				.append(voucher)
				.append("?key=apikey");

			URL url = new URL(urlBuilder.toString());

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");



			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			String outputJson = "";

			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				outputJson += output;
			}
			
			conn.disconnect();

			ObjectMapper objectMapper = new ObjectMapper();
			VoucherItem vItem = objectMapper.readValue(outputJson, VoucherItem.class);	
			return vItem;
			
		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		
		return null;
	}
}
