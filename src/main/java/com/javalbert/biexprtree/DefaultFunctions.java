package com.javalbert.biexprtree;

public class DefaultFunctions extends FunctionRegistry {
	public static final DefaultFunctions INSTANCE = new DefaultFunctions();
	
	public FunctionRegistry newRegistry() {
		FunctionRegistry reg = new FunctionRegistry();
		INSTANCE.getFunctions()
		.values()
		.stream()
		.forEach(reg::register);
		return reg;
	}
	
	private DefaultFunctions() {
		register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("+", Integer.class, Integer.class),
				this::add
				));
	}
	
	@Override
	void register(Func func) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public <T, U> void register(BinaryFunc<T, U> bifunc) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public <T> void register(UnaryFunc<T> ufunc) {
		throw new UnsupportedOperationException();
	}
	
	private Operand<Integer> add(Operand<Integer> a, Operand<Integer> b) {
		return null;//a + b;
	}
}
