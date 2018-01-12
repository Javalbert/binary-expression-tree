package com.javalbert.biexprtree;

import java.util.Objects;

public class Operand<T> implements Node {
	private final Class<T> operandClass;
	private T value;

	public Class<T> getOperandClass() {
		return operandClass;
	}
	
	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}

	public Operand(Class<T> operandClass, T value) {
		this.operandClass = Objects.requireNonNull(operandClass, "operandClass must not be null");
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value != null ? value.toString() : "null";
	}
}
