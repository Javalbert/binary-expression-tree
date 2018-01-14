package com.javalbert.biexprtree;

public class FloatOperand extends Operand<Float> {
	private float floatValue;
	
	@Override
	public Float getValue() {
		return floatValue;
	}
	
	@Override
	public void setValue(Float value) {
		floatValue = value;
	}
	
	public float getFloatValue() {
		return floatValue;
	}
	
	public void setFloatValue(float floatValue) {
		this.floatValue = floatValue;
	}

	public FloatOperand(float floatValue) {
		super(float.class, null);
		this.floatValue = floatValue;
	}
	
	@Override
	public String toString() {
		return "[FloatOperand " + Float.toString(floatValue) + "]";
	}
}
