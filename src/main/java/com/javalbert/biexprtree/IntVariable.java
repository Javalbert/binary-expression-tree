package com.javalbert.biexprtree;

public class IntVariable implements Variable<Integer> {
	private String name;
	private int value;
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public Class<Integer> getType() {
		return int.class;
	}

	@Override
	public Integer getValue() {
		return value;
	}

	@Override
	public void setValue(Integer value) {
		this.value = value;
	}
	
	public int getInt() {
		return value;
	}
	
	public void setInt(int i) {
		value = i;
	}
	
	public IntVariable(String name) {
		this(name, 0);
	}
	
	public IntVariable(String name, int i) {
		this.name = Variables.validateName(name);
		value = i;
	}
}
