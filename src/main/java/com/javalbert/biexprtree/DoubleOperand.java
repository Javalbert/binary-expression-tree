package com.javalbert.biexprtree;

public class DoubleOperand extends Operand<Double> {
	private double doubleValue;
	
	@Override
	public Double getValue() {
		return doubleValue;
	}
	
	@Override
	public void setValue(Double value) {
		doubleValue = value;
	}
	
	public double getDoubleValue() {
		return doubleValue;
	}
	
	public void setDoubleValue(double doubleValue) {
		this.doubleValue = doubleValue;
	}

	public DoubleOperand(double doubleValue) {
		super(double.class, null);
		this.doubleValue = doubleValue;
	}
	
	@Override
	public String toString() {
		return "[DoubleOperand " + Double.toString(doubleValue) + "]";
	}
}
