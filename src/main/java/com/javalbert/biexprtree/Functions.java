package com.javalbert.biexprtree;

import java.util.Objects;

public final class Functions {
	public static String validateOperator(String operator) {
		Objects.requireNonNull(operator, "operator must not be null");
		if ("".equals(operator)) {
			throw new IllegalArgumentException("operator cannot be an empty string");
		}
		return operator;
	}
	
	private Functions() {}
}
