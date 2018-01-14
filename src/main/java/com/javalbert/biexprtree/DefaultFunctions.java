package com.javalbert.biexprtree;

import java.math.BigDecimal;

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
		// add - same types
		//
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("+", BigDecimal.class, BigDecimal.class),
				this::addBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("+", double.class, double.class),
				this::addDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("+", float.class, float.class),
				this::addFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("+", int.class, int.class),
				this::addInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("+", long.class, long.class),
				this::addLong
				));
		
		// add - type promotions
		//
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("+", BigDecimal.class, double.class),
				this::addBigDecimalAndDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("+", BigDecimal.class, float.class),
				this::addBigDecimalAndFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("+", BigDecimal.class, int.class),
				this::addBigDecimalAndInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("+", BigDecimal.class, long.class),
				this::addBigDecimalAndLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("+", double.class, float.class),
				this::addDoubleAndFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("+", double.class, int.class),
				this::addDoubleAndInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("+", double.class, long.class),
				this::addDoubleAndLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("+", float.class, int.class),
				this::addFloatAndInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("+", float.class, long.class),
				this::addFloatAndLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("+", long.class, int.class),
				this::addLongAndInt
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
	
	// add - same types
	
	private Operand<BigDecimal> addBigDecimal(Operand<BigDecimal> a, Operand<BigDecimal> b) {
		return new Operand<>(BigDecimal.class, a.getValue().add(b.getValue()));
	}
	
	private Operand<Double> addDouble(Operand<Double> a, Operand<Double> b) {
		return new DoubleOperand(((DoubleOperand)a).getDoubleValue() + ((DoubleOperand)b).getDoubleValue());
	}
	
	private Operand<Float> addFloat(Operand<Float> a, Operand<Float> b) {
		return new FloatOperand(((FloatOperand)a).getFloatValue() + ((FloatOperand)b).getFloatValue());
	}
	
	private Operand<Integer> addInt(Operand<Integer> a, Operand<Integer> b) {
		return new IntOperand(((IntOperand)a).getIntValue() + ((IntOperand)b).getIntValue());
	}
	
	private Operand<Long> addLong(Operand<Long> a, Operand<Long> b) {
		return new LongOperand(((LongOperand)a).getLongValue() + ((LongOperand)b).getLongValue());
	}
	
	// add - type promotions
	
	private Operand<BigDecimal> addBigDecimalAndDouble(Operand<BigDecimal> a, Operand<Double> b) {
		return new Operand<>(BigDecimal.class, a.getValue().add(BigDecimal.valueOf(((DoubleOperand)b).getDoubleValue()).stripTrailingZeros()));
	}
	
	private Operand<BigDecimal> addBigDecimalAndFloat(Operand<BigDecimal> a, Operand<Float> b) {
		return new Operand<>(BigDecimal.class, a.getValue().add(BigDecimal.valueOf(((FloatOperand)b).getFloatValue()).stripTrailingZeros()));
	}
	
	private Operand<BigDecimal> addBigDecimalAndInt(Operand<BigDecimal> a, Operand<Integer> b) {
		return new Operand<>(BigDecimal.class, a.getValue().add(BigDecimal.valueOf(((IntOperand)b).getIntValue()).stripTrailingZeros()));
	}
	
	private Operand<BigDecimal> addBigDecimalAndLong(Operand<BigDecimal> a, Operand<Long> b) {
		return new Operand<>(BigDecimal.class, a.getValue().add(BigDecimal.valueOf(((LongOperand)b).getLongValue()).stripTrailingZeros()));
	}
	
	private Operand<Double> addDoubleAndFloat(Operand<Double> a, Operand<Float> b) {
		return new DoubleOperand(a.getValue() + b.getValue());
	}
	
	private Operand<Double> addDoubleAndInt(Operand<Double> a, Operand<Integer> b) {
		return new DoubleOperand(a.getValue() + b.getValue());
	}
	
	private Operand<Double> addDoubleAndLong(Operand<Double> a, Operand<Long> b) {
		return new DoubleOperand(a.getValue() + b.getValue());
	}
	
	private Operand<Float> addFloatAndInt(Operand<Float> a, Operand<Integer> b) {
		return new FloatOperand(a.getValue() + b.getValue());
	}
	
	private Operand<Float> addFloatAndLong(Operand<Float> a, Operand<Long> b) {
		return new FloatOperand(a.getValue() + b.getValue());
	}
	
	private Operand<Long> addLongAndInt(Operand<Long> a, Operand<Integer> b) {
		return new LongOperand(a.getValue() + b.getValue());
	}
}
