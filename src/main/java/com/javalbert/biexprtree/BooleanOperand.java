package com.javalbert.biexprtree;

public class BooleanOperand extends Operand<Boolean> {
	private boolean booleanValue;
	
	@Override
	public Boolean getValue() {
		return booleanValue;
	}
	
	@Override
	public void setValue(Boolean value) {
		booleanValue = value;
	}
	
	public boolean getBooleanValue() {
		return booleanValue;
	}
	
	public void setBooleanValue(boolean booleanValue) {
		this.booleanValue = booleanValue;
	}

	public BooleanOperand(boolean booleanValue) {
		super(boolean.class, null);
		this.booleanValue = booleanValue;
	}
}
