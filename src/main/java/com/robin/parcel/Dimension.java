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
public class Dimension {
	private double weight;
	private double height;
	private double width;
	private double length;

	
	public Dimension (double weightInKg, double lengthInCm, double widthInCm, double heightInCm) {
		this.weight = weightInKg;
		this.height = heightInCm;
		this.width = widthInCm;
		this.length = lengthInCm;
	}
	
	public double getVolume() {
		return height * width * length;
	}
	
	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * @return the length
	 */
	public double getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(double length) {
		this.length = length;
	}
}
