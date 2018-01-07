package com.javalbert.biexprtree;

public class IntOperand extends Operand<Integer> {
	private int intValue;
	
	@Override
	public Integer getValue() {
		return intValue;
	}
	
	@Override
	public void setValue(Integer value) {
		intValue = value;
	}
	
	public int getIntValue() {
		return intValue;
	}
	
	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}

	public IntOperand(int intValue) {
		super(int.class, null);
		this.intValue = intValue;
	}
}
