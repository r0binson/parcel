/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robin.parcel;

import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParcelController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@Resource(name = "ParcelServiceImpl")
	private ParcelService parcelService; 
	
		
	@GetMapping("/")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@GetMapping("/cost/{weight}/{length}/{width}/{height}/{voucher}")
	public ResponseEntity costWithVoucher(
		@PathVariable double weight, @PathVariable double height,
		@PathVariable double width, @PathVariable double length,
		@PathVariable String voucher) {

		Dimension parcelDimensions = new Dimension(weight, length, width, height);		
		
		try {
			return ResponseEntity.ok(parcelService.getCost(parcelDimensions, voucher));			
		} catch (Exception e) {
			return ResponseEntity.ok( e.getMessage());
		}
	}

	@GetMapping("/cost/{weight}/{length}/{width}/{height}/")
	public ResponseEntity cost(@PathVariable double weight, @PathVariable double height,
		@PathVariable double width, @PathVariable double length) {

		Dimension parcelDimensions = new Dimension(weight, length, width, height);		
	
		try {
			return ResponseEntity.ok(parcelService.getCost(parcelDimensions));			
		} catch (Exception e) {
			return ResponseEntity.ok( e.getMessage());
		}		
	}	
}
