package com.javalbert.biexprtree;

public class LongOperand extends Operand<Long> {
	private long longValue;
	
	@Override
	public Long getValue() {
		return longValue;
	}
	
	@Override
	public void setValue(Long value) {
		longValue = value;
	}
	
	public long getLongValue() {
		return longValue;
	}
	
	public void setLongValue(long longValue) {
		this.longValue = longValue;
	}

	public LongOperand(long longValue) {
		super(long.class, null);
		this.longValue = longValue;
	}
}
