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
		StringBuilder builder = new StringBuilder("[Operand ");
		
		boolean quote = String.class.isAssignableFrom(operandClass) && value != null;
		if (quote) {
			builder.append("\"");
		}
		builder.append(value);
		if (quote) {
			builder.append("\"");
		}
		return builder.append("]").toString();
	}
}
