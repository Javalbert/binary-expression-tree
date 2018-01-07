package com.javalbert.biexprtree;

public class DefaultFunctions extends FunctionRegistry {
	public static final DefaultFunctions INSTANCE = new DefaultFunctions();
	
	private DefaultFunctions() {
		register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("+", Integer.class, Integer.class),
				this::add
				));
	}
	
	private Integer add(Integer a, Integer b) {
		return a + b;
	}
}
