package com.javalbert.biexprtree;

import java.math.BigDecimal;

class DefaultFunctions extends FunctionRegistry {
	public static final DefaultFunctions INSTANCE = new DefaultFunctions();
	
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
		
		// subtract - same types
		//
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", BigDecimal.class, BigDecimal.class),
				this::subtractBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", double.class, double.class),
				this::subtractDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", float.class, float.class),
				this::subtractFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", int.class, int.class),
				this::subtractInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", long.class, long.class),
				this::subtractLong
				));
		
		// subtract - type promotions
		//
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", BigDecimal.class, double.class),
				this::subtractDoubleFromBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", BigDecimal.class, float.class),
				this::subtractFloatFromBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", BigDecimal.class, int.class),
				this::subtractIntFromBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", BigDecimal.class, long.class),
				this::subtractLongFromBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", double.class, BigDecimal.class),
				this::subtractBigDecimalFromDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", double.class, float.class),
				this::subtractFloatFromDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", double.class, int.class),
				this::subtractIntFromDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", double.class, long.class),
				this::subtractLongFromDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", float.class, BigDecimal.class),
				this::subtractBigDecimalFromFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", float.class, double.class),
				this::subtractDoubleFromFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", float.class, int.class),
				this::subtractIntFromFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", float.class, long.class),
				this::subtractLongFromFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", int.class, BigDecimal.class),
				this::subtractBigDecimalFromInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", int.class, double.class),
				this::subtractDoubleFromInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", int.class, float.class),
				this::subtractFloatFromInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", int.class, long.class),
				this::subtractLongFromInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", long.class, BigDecimal.class),
				this::subtractBigDecimalFromLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", long.class, double.class),
				this::subtractDoubleFromLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", long.class, float.class),
				this::subtractFloatFromLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", long.class, int.class),
				this::subtractIntFromLong
				));
		
		// multiply - same types
		//
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("*", BigDecimal.class, BigDecimal.class),
				this::multiplyBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("*", double.class, double.class),
				this::multiplyDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("*", float.class, float.class),
				this::multiplyFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("*", int.class, int.class),
				this::multiplyInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("*", long.class, long.class),
				this::multiplyLong
				));
		
		// multiply - type promotions
		//
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("*", BigDecimal.class, double.class),
				this::multiplyBigDecimalAndDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("*", BigDecimal.class, float.class),
				this::multiplyBigDecimalAndFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("*", BigDecimal.class, int.class),
				this::multiplyBigDecimalAndInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("*", BigDecimal.class, long.class),
				this::multiplyBigDecimalAndLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("*", double.class, float.class),
				this::multiplyDoubleAndFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("*", double.class, int.class),
				this::multiplyDoubleAndInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("*", double.class, long.class),
				this::multiplyDoubleAndLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("*", float.class, int.class),
				this::multiplyFloatAndInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("*", float.class, long.class),
				this::multiplyFloatAndLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("*", long.class, int.class),
				this::multiplyLongAndInt
				));
		
		// divide - same types
		//
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", BigDecimal.class, BigDecimal.class),
				this::divideBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", double.class, double.class),
				this::divideDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", float.class, float.class),
				this::divideFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", int.class, int.class),
				this::divideInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", long.class, long.class),
				this::divideLong
				));

		// divide - type promotions
		//
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", BigDecimal.class, double.class),
				this::divideBigDecimalByDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", BigDecimal.class, float.class),
				this::divideBigDecimalByFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", BigDecimal.class, int.class),
				this::divideBigDecimalByInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", BigDecimal.class, long.class),
				this::divideBigDecimalByLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", double.class, BigDecimal.class),
				this::divideDoubleByBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", double.class, float.class),
				this::divideDoubleByFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", double.class, int.class),
				this::divideDoubleByInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", double.class, long.class),
				this::divideDoubleByLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", float.class, BigDecimal.class),
				this::divideFloatByBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", float.class, double.class),
				this::divideFloatByDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", float.class, int.class),
				this::divideFloatByInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", float.class, long.class),
				this::divideFloatByLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", int.class, BigDecimal.class),
				this::divideIntByBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", int.class, double.class),
				this::divideIntByDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", int.class, float.class),
				this::divideIntByFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", int.class, long.class),
				this::divideIntByLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", long.class, BigDecimal.class),
				this::divideLongByBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", long.class, double.class),
				this::divideLongByDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", long.class, float.class),
				this::divideLongByFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", long.class, int.class),
				this::divideLongByInt
				));

		// modulo - same types
		//
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", BigDecimal.class, BigDecimal.class),
				this::modBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", double.class, double.class),
				this::modDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", float.class, float.class),
				this::modFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", int.class, int.class),
				this::modInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", long.class, long.class),
				this::modLong
				));

		// modulo - type promotions
		//
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", BigDecimal.class, double.class),
				this::bigDecimalModDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", BigDecimal.class, float.class),
				this::bigDecimalModFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", BigDecimal.class, int.class),
				this::bigDecimalModInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", BigDecimal.class, long.class),
				this::bigDecimalModLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", double.class, BigDecimal.class),
				this::doubleModBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", double.class, float.class),
				this::doubleModFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", double.class, int.class),
				this::doubleModInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", double.class, long.class),
				this::doubleModLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", float.class, BigDecimal.class),
				this::floatModBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", float.class, double.class),
				this::floatModDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", float.class, int.class),
				this::floatModInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", float.class, long.class),
				this::floatModLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", int.class, BigDecimal.class),
				this::intModBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", int.class, double.class),
				this::intModDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", int.class, float.class),
				this::intModFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", int.class, long.class),
				this::intModLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", long.class, BigDecimal.class),
				this::longModBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", long.class, double.class),
				this::longModDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", long.class, float.class),
				this::longModFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", long.class, int.class),
				this::longModInt
				));

		// power - same types
		//
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", BigDecimal.class, BigDecimal.class),
				this::powerBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", double.class, double.class),
				this::powerDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", float.class, float.class),
				this::powerFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", int.class, int.class),
				this::powerInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", long.class, long.class),
				this::powerLong
				));

		// power - type promotions
		//
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", BigDecimal.class, double.class),
				this::bigDecimalPowerDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", BigDecimal.class, float.class),
				this::bigDecimalPowerFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", BigDecimal.class, int.class),
				this::bigDecimalPowerInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", BigDecimal.class, long.class),
				this::bigDecimalPowerLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", double.class, BigDecimal.class),
				this::doublePowerBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", double.class, float.class),
				this::doublePowerFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", double.class, int.class),
				this::doublePowerInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", double.class, long.class),
				this::doublePowerLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", float.class, BigDecimal.class),
				this::floatPowerBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", float.class, double.class),
				this::floatPowerDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", float.class, int.class),
				this::floatPowerInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", float.class, long.class),
				this::floatPowerLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", int.class, BigDecimal.class),
				this::intPowerBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", int.class, double.class),
				this::intPowerDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", int.class, float.class),
				this::intPowerFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", int.class, long.class),
				this::intPowerLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", long.class, BigDecimal.class),
				this::longPowerBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", long.class, double.class),
				this::longPowerDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", long.class, float.class),
				this::longPowerFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", long.class, int.class),
				this::longPowerInt
				));
		
		// negate
		//
		super.register(new UnaryFunc<>(
				new UnaryOperatorInfo<>("-", BigDecimal.class),
				this::negateBigDecimal
				));
		super.register(new UnaryFunc<>(
				new UnaryOperatorInfo<>("-", double.class),
				this::negateDouble
				));
		super.register(new UnaryFunc<>(
				new UnaryOperatorInfo<>("-", float.class),
				this::negateFloat
				));
		super.register(new UnaryFunc<>(
				new UnaryOperatorInfo<>("-", int.class),
				this::negateInt
				));
		super.register(new UnaryFunc<>(
				new UnaryOperatorInfo<>("-", long.class),
				this::negateLong
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
		return new Operand<>(BigDecimal.class, a.getValue().add(BigDecimal.valueOf(((IntOperand)b).getIntValue())));
	}
	
	private Operand<BigDecimal> addBigDecimalAndLong(Operand<BigDecimal> a, Operand<Long> b) {
		return new Operand<>(BigDecimal.class, a.getValue().add(BigDecimal.valueOf(((LongOperand)b).getLongValue())));
	}
	
	private Operand<Double> addDoubleAndFloat(Operand<Double> a, Operand<Float> b) {
		return new DoubleOperand(((DoubleOperand)a).getDoubleValue() + ((FloatOperand)b).getFloatValue());
	}
	
	private Operand<Double> addDoubleAndInt(Operand<Double> a, Operand<Integer> b) {
		return new DoubleOperand(((DoubleOperand)a).getDoubleValue() + ((IntOperand)b).getIntValue());
	}
	
	private Operand<Double> addDoubleAndLong(Operand<Double> a, Operand<Long> b) {
		return new DoubleOperand(((DoubleOperand)a).getDoubleValue() + ((LongOperand)b).getLongValue());
	}
	
	private Operand<Float> addFloatAndInt(Operand<Float> a, Operand<Integer> b) {
		return new FloatOperand(((FloatOperand)a).getFloatValue() + ((IntOperand)b).getIntValue());
	}
	
	private Operand<Float> addFloatAndLong(Operand<Float> a, Operand<Long> b) {
		return new FloatOperand(((FloatOperand)a).getFloatValue() + ((LongOperand)b).getLongValue());
	}
	
	private Operand<Long> addLongAndInt(Operand<Long> a, Operand<Integer> b) {
		return new LongOperand(((LongOperand)a).getLongValue() + ((IntOperand)b).getIntValue());
	}
	
	// subtract - same types

	private Operand<BigDecimal> subtractBigDecimal(Operand<BigDecimal> a, Operand<BigDecimal> b) {
		return new Operand<>(BigDecimal.class, a.getValue().subtract(b.getValue()));
	}
	
	private Operand<Double> subtractDouble(Operand<Double> a, Operand<Double> b) {
		return new DoubleOperand(((DoubleOperand)a).getDoubleValue() - ((DoubleOperand)b).getDoubleValue());
	}
	
	private Operand<Float> subtractFloat(Operand<Float> a, Operand<Float> b) {
		return new FloatOperand(((FloatOperand)a).getFloatValue() - ((FloatOperand)b).getFloatValue());
	}
	
	private Operand<Integer> subtractInt(Operand<Integer> a, Operand<Integer> b) {
		return new IntOperand(((IntOperand)a).getIntValue() - ((IntOperand)b).getIntValue());
	}
	
	private Operand<Long> subtractLong(Operand<Long> a, Operand<Long> b) {
		return new LongOperand(((LongOperand)a).getLongValue() - ((LongOperand)b).getLongValue());
	}
	
	// subtract - type promotions
	
	private Operand<BigDecimal> subtractDoubleFromBigDecimal(Operand<BigDecimal> a, Operand<Double> b) {
		return new Operand<>(BigDecimal.class, a.getValue().subtract(BigDecimal.valueOf(((DoubleOperand)b).getDoubleValue()).stripTrailingZeros()));
	}
	
	private Operand<BigDecimal> subtractFloatFromBigDecimal(Operand<BigDecimal> a, Operand<Float> b) {
		return new Operand<>(BigDecimal.class, a.getValue().subtract(BigDecimal.valueOf(((FloatOperand)b).getFloatValue()).stripTrailingZeros()));
	}
	
	private Operand<BigDecimal> subtractIntFromBigDecimal(Operand<BigDecimal> a, Operand<Integer> b) {
		return new Operand<>(BigDecimal.class, a.getValue().subtract(BigDecimal.valueOf(((IntOperand)b).getIntValue())));
	}
	
	private Operand<BigDecimal> subtractLongFromBigDecimal(Operand<BigDecimal> a, Operand<Long> b) {
		return new Operand<>(BigDecimal.class, a.getValue().subtract(BigDecimal.valueOf(((LongOperand)b).getLongValue())));
	}
	
	private Operand<BigDecimal> subtractBigDecimalFromDouble(Operand<Double> a, Operand<BigDecimal> b) {
		return new Operand<>(BigDecimal.class, BigDecimal.valueOf(((DoubleOperand)a).getDoubleValue()).stripTrailingZeros().subtract(b.getValue()));
	}
	
	private Operand<Double> subtractFloatFromDouble(Operand<Double> a, Operand<Float> b) {
		return new DoubleOperand(((DoubleOperand)a).getDoubleValue() - ((FloatOperand)b).getFloatValue());
	}
	
	private Operand<Double> subtractIntFromDouble(Operand<Double> a, Operand<Integer> b) {
		return new DoubleOperand(((DoubleOperand)a).getDoubleValue() - ((IntOperand)b).getIntValue());
	}
	
	private Operand<Double> subtractLongFromDouble(Operand<Double> a, Operand<Long> b) {
		return new DoubleOperand(((DoubleOperand)a).getDoubleValue() - ((LongOperand)b).getLongValue());
	}
	
	private Operand<BigDecimal> subtractBigDecimalFromFloat(Operand<Float> a, Operand<BigDecimal> b) {
		return new Operand<>(BigDecimal.class, BigDecimal.valueOf(((FloatOperand)a).getFloatValue()).stripTrailingZeros().subtract(b.getValue()));
	}
	
	private Operand<Double> subtractDoubleFromFloat(Operand<Float> a, Operand<Double> b) {
		return new DoubleOperand(((FloatOperand)a).getFloatValue() - ((DoubleOperand)b).getDoubleValue());
	}
	
	private Operand<Float> subtractIntFromFloat(Operand<Float> a, Operand<Integer> b) {
		return new FloatOperand(((FloatOperand)a).getFloatValue() - ((IntOperand)b).getIntValue());
	}
	
	private Operand<Float> subtractLongFromFloat(Operand<Float> a, Operand<Long> b) {
		return new FloatOperand(((FloatOperand)a).getFloatValue() - ((LongOperand)b).getLongValue());
	}
	
	private Operand<BigDecimal> subtractBigDecimalFromInt(Operand<Integer> a, Operand<BigDecimal> b) {
		return new Operand<>(BigDecimal.class, BigDecimal.valueOf(((IntOperand)a).getIntValue()).subtract(b.getValue()));
	}
	
	private Operand<Double> subtractDoubleFromInt(Operand<Integer> a, Operand<Double> b) {
		return new DoubleOperand(((IntOperand)a).getIntValue() - ((DoubleOperand)b).getDoubleValue());
	}
	
	private Operand<Float> subtractFloatFromInt(Operand<Integer> a, Operand<Float> b) {
		return new FloatOperand(((IntOperand)a).getIntValue() - ((FloatOperand)b).getFloatValue());
	}
	
	private Operand<Long> subtractLongFromInt(Operand<Integer> a, Operand<Long> b) {
		return new LongOperand(((IntOperand)a).getIntValue() - ((LongOperand)b).getLongValue());
	}
	
	private Operand<BigDecimal> subtractBigDecimalFromLong(Operand<Long> a, Operand<BigDecimal> b) {
		return new Operand<>(BigDecimal.class, BigDecimal.valueOf(((LongOperand)a).getLongValue()).subtract(b.getValue()));
	}
	
	private Operand<Double> subtractDoubleFromLong(Operand<Long> a, Operand<Double> b) {
		return new DoubleOperand(((LongOperand)a).getLongValue() - ((DoubleOperand)b).getDoubleValue());
	}
	
	private Operand<Float> subtractFloatFromLong(Operand<Long> a, Operand<Float> b) {
		return new FloatOperand(((LongOperand)a).getLongValue() - ((FloatOperand)b).getFloatValue());
	}
	
	private Operand<Long> subtractIntFromLong(Operand<Long> a, Operand<Integer> b) {
		return new LongOperand(((LongOperand)a).getLongValue() - ((IntOperand)b).getIntValue());
	}
	
	// multiply - same types
	
	private Operand<BigDecimal> multiplyBigDecimal(Operand<BigDecimal> a, Operand<BigDecimal> b) {
		return new Operand<>(BigDecimal.class, a.getValue().multiply(b.getValue()));
	}
	
	private Operand<Double> multiplyDouble(Operand<Double> a, Operand<Double> b) {
		return new DoubleOperand(((DoubleOperand)a).getDoubleValue() * ((DoubleOperand)b).getDoubleValue());
	}
	
	private Operand<Float> multiplyFloat(Operand<Float> a, Operand<Float> b) {
		return new FloatOperand(((FloatOperand)a).getFloatValue() * ((FloatOperand)b).getFloatValue());
	}
	
	private Operand<Integer> multiplyInt(Operand<Integer> a, Operand<Integer> b) {
		return new IntOperand(((IntOperand)a).getIntValue() * ((IntOperand)b).getIntValue());
	}
	
	private Operand<Long> multiplyLong(Operand<Long> a, Operand<Long> b) {
		return new LongOperand(((LongOperand)a).getLongValue() * ((LongOperand)b).getLongValue());
	}
	
	// multiply - type promotions
	
	private Operand<BigDecimal> multiplyBigDecimalAndDouble(Operand<BigDecimal> a, Operand<Double> b) {
		return new Operand<>(BigDecimal.class, a.getValue().multiply(BigDecimal.valueOf(((DoubleOperand)b).getDoubleValue()).stripTrailingZeros()));
	}
	
	private Operand<BigDecimal> multiplyBigDecimalAndFloat(Operand<BigDecimal> a, Operand<Float> b) {
		return new Operand<>(BigDecimal.class, a.getValue().multiply(BigDecimal.valueOf(((FloatOperand)b).getFloatValue()).stripTrailingZeros()));
	}
	
	private Operand<BigDecimal> multiplyBigDecimalAndInt(Operand<BigDecimal> a, Operand<Integer> b) {
		return new Operand<>(BigDecimal.class, a.getValue().multiply(BigDecimal.valueOf(((IntOperand)b).getIntValue())));
	}
	
	private Operand<BigDecimal> multiplyBigDecimalAndLong(Operand<BigDecimal> a, Operand<Long> b) {
		return new Operand<>(BigDecimal.class, a.getValue().multiply(BigDecimal.valueOf(((LongOperand)b).getLongValue())));
	}
	
	private Operand<Double> multiplyDoubleAndFloat(Operand<Double> a, Operand<Float> b) {
		return new DoubleOperand(((DoubleOperand)a).getDoubleValue() * ((FloatOperand)b).getFloatValue());
	}
	
	private Operand<Double> multiplyDoubleAndInt(Operand<Double> a, Operand<Integer> b) {
		return new DoubleOperand(((DoubleOperand)a).getDoubleValue() * ((IntOperand)b).getIntValue());
	}
	
	private Operand<Double> multiplyDoubleAndLong(Operand<Double> a, Operand<Long> b) {
		return new DoubleOperand(((DoubleOperand)a).getDoubleValue() * ((LongOperand)b).getLongValue());
	}
	
	private Operand<Float> multiplyFloatAndInt(Operand<Float> a, Operand<Integer> b) {
		return new FloatOperand(((FloatOperand)a).getFloatValue() * ((IntOperand)b).getIntValue());
	}
	
	private Operand<Float> multiplyFloatAndLong(Operand<Float> a, Operand<Long> b) {
		return new FloatOperand(((FloatOperand)a).getFloatValue() * ((LongOperand)b).getLongValue());
	}
	
	private Operand<Long> multiplyLongAndInt(Operand<Long> a, Operand<Integer> b) {
		return new LongOperand(((LongOperand)a).getLongValue() * ((IntOperand)b).getIntValue());
	}
	
	// divide - same types

	private Operand<BigDecimal> divideBigDecimal(Operand<BigDecimal> a, Operand<BigDecimal> b) {
		return new Operand<>(BigDecimal.class, a.getValue().divide(b.getValue()));
	}
	
	private Operand<Double> divideDouble(Operand<Double> a, Operand<Double> b) {
		return new DoubleOperand(((DoubleOperand)a).getDoubleValue() / ((DoubleOperand)b).getDoubleValue());
	}
	
	private Operand<Float> divideFloat(Operand<Float> a, Operand<Float> b) {
		return new FloatOperand(((FloatOperand)a).getFloatValue() / ((FloatOperand)b).getFloatValue());
	}
	
	private Operand<Integer> divideInt(Operand<Integer> a, Operand<Integer> b) {
		return new IntOperand(((IntOperand)a).getIntValue() / ((IntOperand)b).getIntValue());
	}
	
	private Operand<Long> divideLong(Operand<Long> a, Operand<Long> b) {
		return new LongOperand(((LongOperand)a).getLongValue() / ((LongOperand)b).getLongValue());
	}
	
	// divide - type promotions
	
	private Operand<BigDecimal> divideBigDecimalByDouble(Operand<BigDecimal> a, Operand<Double> b) {
		return new Operand<>(BigDecimal.class, a.getValue().divide(BigDecimal.valueOf(((DoubleOperand)b).getDoubleValue()).stripTrailingZeros()));
	}
	
	private Operand<BigDecimal> divideBigDecimalByFloat(Operand<BigDecimal> a, Operand<Float> b) {
		return new Operand<>(BigDecimal.class, a.getValue().divide(BigDecimal.valueOf(((FloatOperand)b).getFloatValue()).stripTrailingZeros()));
	}
	
	private Operand<BigDecimal> divideBigDecimalByInt(Operand<BigDecimal> a, Operand<Integer> b) {
		return new Operand<>(BigDecimal.class, a.getValue().divide(BigDecimal.valueOf(((IntOperand)b).getIntValue())));
	}
	
	private Operand<BigDecimal> divideBigDecimalByLong(Operand<BigDecimal> a, Operand<Long> b) {
		return new Operand<>(BigDecimal.class, a.getValue().divide(BigDecimal.valueOf(((LongOperand)b).getLongValue())));
	}
	
	private Operand<BigDecimal> divideDoubleByBigDecimal(Operand<Double> a, Operand<BigDecimal> b) {
		return new Operand<>(BigDecimal.class, BigDecimal.valueOf(((DoubleOperand)a).getDoubleValue()).stripTrailingZeros().divide(b.getValue()));
	}
	
	private Operand<Double> divideDoubleByFloat(Operand<Double> a, Operand<Float> b) {
		return new DoubleOperand(((DoubleOperand)a).getDoubleValue() / ((FloatOperand)b).getFloatValue());
	}
	
	private Operand<Double> divideDoubleByInt(Operand<Double> a, Operand<Integer> b) {
		return new DoubleOperand(((DoubleOperand)a).getDoubleValue() / ((IntOperand)b).getIntValue());
	}
	
	private Operand<Double> divideDoubleByLong(Operand<Double> a, Operand<Long> b) {
		return new DoubleOperand(((DoubleOperand)a).getDoubleValue() / ((LongOperand)b).getLongValue());
	}
	
	private Operand<BigDecimal> divideFloatByBigDecimal(Operand<Float> a, Operand<BigDecimal> b) {
		return new Operand<>(BigDecimal.class, BigDecimal.valueOf(((FloatOperand)a).getFloatValue()).stripTrailingZeros().divide(b.getValue()));
	}
	
	private Operand<Double> divideFloatByDouble(Operand<Float> a, Operand<Double> b) {
		return new DoubleOperand(((FloatOperand)a).getFloatValue() / ((DoubleOperand)b).getDoubleValue());
	}
	
	private Operand<Float> divideFloatByInt(Operand<Float> a, Operand<Integer> b) {
		return new FloatOperand(((FloatOperand)a).getFloatValue() / ((IntOperand)b).getIntValue());
	}
	
	private Operand<Float> divideFloatByLong(Operand<Float> a, Operand<Long> b) {
		return new FloatOperand(((FloatOperand)a).getFloatValue() / ((LongOperand)b).getLongValue());
	}
	
	private Operand<BigDecimal> divideIntByBigDecimal(Operand<Integer> a, Operand<BigDecimal> b) {
		return new Operand<>(BigDecimal.class, BigDecimal.valueOf(((IntOperand)a).getIntValue()).divide(b.getValue()));
	}
	
	private Operand<Double> divideIntByDouble(Operand<Integer> a, Operand<Double> b) {
		return new DoubleOperand(((IntOperand)a).getIntValue() / ((DoubleOperand)b).getDoubleValue());
	}
	
	private Operand<Float> divideIntByFloat(Operand<Integer> a, Operand<Float> b) {
		return new FloatOperand(((IntOperand)a).getIntValue() / ((FloatOperand)b).getFloatValue());
	}
	
	private Operand<Long> divideIntByLong(Operand<Integer> a, Operand<Long> b) {
		return new LongOperand(((IntOperand)a).getIntValue() / ((LongOperand)b).getLongValue());
	}
	
	private Operand<BigDecimal> divideLongByBigDecimal(Operand<Long> a, Operand<BigDecimal> b) {
		return new Operand<>(BigDecimal.class, BigDecimal.valueOf(((LongOperand)a).getLongValue()).divide(b.getValue()));
	}
	
	private Operand<Double> divideLongByDouble(Operand<Long> a, Operand<Double> b) {
		return new DoubleOperand(((LongOperand)a).getLongValue() / ((DoubleOperand)b).getDoubleValue());
	}
	
	private Operand<Float> divideLongByFloat(Operand<Long> a, Operand<Float> b) {
		return new FloatOperand(((LongOperand)a).getLongValue() / ((FloatOperand)b).getFloatValue());
	}
	
	private Operand<Long> divideLongByInt(Operand<Long> a, Operand<Integer> b) {
		return new LongOperand(((LongOperand)a).getLongValue() / ((IntOperand)b).getIntValue());
	}
	
	// modulo - same types

	private Operand<BigDecimal> modBigDecimal(Operand<BigDecimal> a, Operand<BigDecimal> b) {
		return new Operand<>(BigDecimal.class, a.getValue().remainder(b.getValue()));
	}
	
	private Operand<Double> modDouble(Operand<Double> a, Operand<Double> b) {
		return new DoubleOperand(((DoubleOperand)a).getDoubleValue() % ((DoubleOperand)b).getDoubleValue());
	}
	
	private Operand<Float> modFloat(Operand<Float> a, Operand<Float> b) {
		return new FloatOperand(((FloatOperand)a).getFloatValue() % ((FloatOperand)b).getFloatValue());
	}
	
	private Operand<Integer> modInt(Operand<Integer> a, Operand<Integer> b) {
		return new IntOperand(((IntOperand)a).getIntValue() % ((IntOperand)b).getIntValue());
	}
	
	private Operand<Long> modLong(Operand<Long> a, Operand<Long> b) {
		return new LongOperand(((LongOperand)a).getLongValue() % ((LongOperand)b).getLongValue());
	}

	// modulo - type promotions
	
	private Operand<BigDecimal> bigDecimalModDouble(Operand<BigDecimal> a, Operand<Double> b) {
		return new Operand<>(BigDecimal.class, a.getValue().remainder(BigDecimal.valueOf(((DoubleOperand)b).getDoubleValue()).stripTrailingZeros()));
	}
	
	private Operand<BigDecimal> bigDecimalModFloat(Operand<BigDecimal> a, Operand<Float> b) {
		return new Operand<>(BigDecimal.class, a.getValue().remainder(BigDecimal.valueOf(((FloatOperand)b).getFloatValue()).stripTrailingZeros()));
	}
	
	private Operand<BigDecimal> bigDecimalModInt(Operand<BigDecimal> a, Operand<Integer> b) {
		return new Operand<>(BigDecimal.class, a.getValue().remainder(BigDecimal.valueOf(((IntOperand)b).getIntValue())));
	}
	
	private Operand<BigDecimal> bigDecimalModLong(Operand<BigDecimal> a, Operand<Long> b) {
		return new Operand<>(BigDecimal.class, a.getValue().remainder(BigDecimal.valueOf(((LongOperand)b).getLongValue())));
	}
	
	private Operand<BigDecimal> doubleModBigDecimal(Operand<Double> a, Operand<BigDecimal> b) {
		return new Operand<>(BigDecimal.class, BigDecimal.valueOf(((DoubleOperand)a).getDoubleValue()).stripTrailingZeros().remainder(b.getValue()));
	}
	
	private Operand<Double> doubleModFloat(Operand<Double> a, Operand<Float> b) {
		return new DoubleOperand(((DoubleOperand)a).getDoubleValue() % ((FloatOperand)b).getFloatValue());
	}
	
	private Operand<Double> doubleModInt(Operand<Double> a, Operand<Integer> b) {
		return new DoubleOperand(((DoubleOperand)a).getDoubleValue() % ((IntOperand)b).getIntValue());
	}
	
	private Operand<Double> doubleModLong(Operand<Double> a, Operand<Long> b) {
		return new DoubleOperand(((DoubleOperand)a).getDoubleValue() % ((LongOperand)b).getLongValue());
	}
	
	private Operand<BigDecimal> floatModBigDecimal(Operand<Float> a, Operand<BigDecimal> b) {
		return new Operand<>(BigDecimal.class, BigDecimal.valueOf(((FloatOperand)a).getFloatValue()).stripTrailingZeros().remainder(b.getValue()));
	}
	
	private Operand<Double> floatModDouble(Operand<Float> a, Operand<Double> b) {
		return new DoubleOperand(((FloatOperand)a).getFloatValue() % ((DoubleOperand)b).getDoubleValue());
	}
	
	private Operand<Float> floatModInt(Operand<Float> a, Operand<Integer> b) {
		return new FloatOperand(((FloatOperand)a).getFloatValue() % ((IntOperand)b).getIntValue());
	}
	
	private Operand<Float> floatModLong(Operand<Float> a, Operand<Long> b) {
		return new FloatOperand(((FloatOperand)a).getFloatValue() % ((LongOperand)b).getLongValue());
	}
	
	private Operand<BigDecimal> intModBigDecimal(Operand<Integer> a, Operand<BigDecimal> b) {
		return new Operand<>(BigDecimal.class, BigDecimal.valueOf(((IntOperand)a).getIntValue()).remainder(b.getValue()));
	}
	
	private Operand<Double> intModDouble(Operand<Integer> a, Operand<Double> b) {
		return new DoubleOperand(((IntOperand)a).getIntValue() % ((DoubleOperand)b).getDoubleValue());
	}
	
	private Operand<Float> intModFloat(Operand<Integer> a, Operand<Float> b) {
		return new FloatOperand(((IntOperand)a).getIntValue() % ((FloatOperand)b).getFloatValue());
	}
	
	private Operand<Long> intModLong(Operand<Integer> a, Operand<Long> b) {
		return new LongOperand(((IntOperand)a).getIntValue() % ((LongOperand)b).getLongValue());
	}
	
	private Operand<BigDecimal> longModBigDecimal(Operand<Long> a, Operand<BigDecimal> b) {
		return new Operand<>(BigDecimal.class, BigDecimal.valueOf(((LongOperand)a).getLongValue()).remainder(b.getValue()));
	}
	
	private Operand<Double> longModDouble(Operand<Long> a, Operand<Double> b) {
		return new DoubleOperand(((LongOperand)a).getLongValue() % ((DoubleOperand)b).getDoubleValue());
	}
	
	private Operand<Float> longModFloat(Operand<Long> a, Operand<Float> b) {
		return new FloatOperand(((LongOperand)a).getLongValue() % ((FloatOperand)b).getFloatValue());
	}
	
	private Operand<Long> longModInt(Operand<Long> a, Operand<Integer> b) {
		return new LongOperand(((LongOperand)a).getLongValue() % ((IntOperand)b).getIntValue());
	}
	
	// power - same types

	private Operand<BigDecimal> powerBigDecimal(Operand<BigDecimal> a, Operand<BigDecimal> b) {
		return new Operand<>(BigDecimal.class, a.getValue().pow(b.getValue().intValue()));
	}
	
	private Operand<Double> powerDouble(Operand<Double> a, Operand<Double> b) {
		return new DoubleOperand(Math.pow(((DoubleOperand)a).getDoubleValue(), ((DoubleOperand)b).getDoubleValue()));
	}
	
	private Operand<Float> powerFloat(Operand<Float> a, Operand<Float> b) {
		return new FloatOperand((float) Math.pow(((FloatOperand)a).getFloatValue(), ((FloatOperand)b).getFloatValue()));
	}
	
	private Operand<Integer> powerInt(Operand<Integer> a, Operand<Integer> b) {
		return new IntOperand((int) Math.pow(((IntOperand)a).getIntValue(), ((IntOperand)b).getIntValue()));
	}
	
	private Operand<Long> powerLong(Operand<Long> a, Operand<Long> b) {
		return new LongOperand((long) Math.pow(((LongOperand)a).getLongValue(), ((LongOperand)b).getLongValue()));
	}
	
	// power - type promotions
	
	private Operand<BigDecimal> bigDecimalPowerDouble(Operand<BigDecimal> a, Operand<Double> b) {
		return new Operand<>(BigDecimal.class, a.getValue().pow((int) ((DoubleOperand)b).getDoubleValue()));
	}
	
	private Operand<BigDecimal> bigDecimalPowerFloat(Operand<BigDecimal> a, Operand<Float> b) {
		return new Operand<>(BigDecimal.class, a.getValue().pow((int) ((FloatOperand)b).getFloatValue()));
	}
	
	private Operand<BigDecimal> bigDecimalPowerInt(Operand<BigDecimal> a, Operand<Integer> b) {
		return new Operand<>(BigDecimal.class, a.getValue().pow(((IntOperand)b).getIntValue()));
	}
	
	private Operand<BigDecimal> bigDecimalPowerLong(Operand<BigDecimal> a, Operand<Long> b) {
		return new Operand<>(BigDecimal.class, a.getValue().pow((int) ((LongOperand)b).getLongValue()));
	}
	
	private Operand<BigDecimal> doublePowerBigDecimal(Operand<Double> a, Operand<BigDecimal> b) {
		return new Operand<>(BigDecimal.class, BigDecimal.valueOf(Math.pow(((DoubleOperand)a).getDoubleValue(), b.getValue().doubleValue())));
	}
	
	private Operand<Double> doublePowerFloat(Operand<Double> a, Operand<Float> b) {
		return new DoubleOperand(Math.pow(((DoubleOperand)a).getDoubleValue(), ((FloatOperand)b).getFloatValue()));
	}
	
	private Operand<Double> doublePowerInt(Operand<Double> a, Operand<Integer> b) {
		return new DoubleOperand(Math.pow(((DoubleOperand)a).getDoubleValue(), ((IntOperand)b).getIntValue()));
	}
	
	private Operand<Double> doublePowerLong(Operand<Double> a, Operand<Long> b) {
		return new DoubleOperand(Math.pow(((DoubleOperand)a).getDoubleValue(), ((LongOperand)b).getLongValue()));
	}
	
	private Operand<BigDecimal> floatPowerBigDecimal(Operand<Float> a, Operand<BigDecimal> b) {
		return new Operand<>(BigDecimal.class, BigDecimal.valueOf(Math.pow(((FloatOperand)a).getFloatValue(), b.getValue().doubleValue())));
	}
	
	private Operand<Double> floatPowerDouble(Operand<Float> a, Operand<Double> b) {
		return new DoubleOperand(Math.pow(((FloatOperand)a).getFloatValue(), ((DoubleOperand)b).getDoubleValue()));
	}
	
	private Operand<Float> floatPowerInt(Operand<Float> a, Operand<Integer> b) {
		return new FloatOperand((float) Math.pow(((FloatOperand)a).getFloatValue(), ((IntOperand)b).getIntValue()));
	}
	
	private Operand<Float> floatPowerLong(Operand<Float> a, Operand<Long> b) {
		return new FloatOperand((float) Math.pow(((FloatOperand)a).getFloatValue(), ((LongOperand)b).getLongValue()));
	}
	
	private Operand<BigDecimal> intPowerBigDecimal(Operand<Integer> a, Operand<BigDecimal> b) {
		return new Operand<>(BigDecimal.class, BigDecimal.valueOf(Math.pow(((IntOperand)a).getIntValue(), b.getValue().doubleValue())));
	}
	
	private Operand<Double> intPowerDouble(Operand<Integer> a, Operand<Double> b) {
		return new DoubleOperand(Math.pow(((IntOperand)a).getIntValue(), ((DoubleOperand)b).getDoubleValue()));
	}
	
	private Operand<Float> intPowerFloat(Operand<Integer> a, Operand<Float> b) {
		return new FloatOperand((float) Math.pow(((IntOperand)a).getIntValue(), ((FloatOperand)b).getFloatValue()));
	}
	
	private Operand<Long> intPowerLong(Operand<Integer> a, Operand<Long> b) {
		return new LongOperand((long) Math.pow(((IntOperand)a).getIntValue(), ((LongOperand)b).getLongValue()));
	}
	
	private Operand<BigDecimal> longPowerBigDecimal(Operand<Long> a, Operand<BigDecimal> b) {
		return new Operand<>(BigDecimal.class, BigDecimal.valueOf(Math.pow(((LongOperand)a).getLongValue(), b.getValue().doubleValue())));
	}
	
	private Operand<Double> longPowerDouble(Operand<Long> a, Operand<Double> b) {
		return new DoubleOperand(Math.pow(((LongOperand)a).getLongValue(), ((DoubleOperand)b).getDoubleValue()));
	}
	
	private Operand<Float> longPowerFloat(Operand<Long> a, Operand<Float> b) {
		return new FloatOperand((float) Math.pow(((LongOperand)a).getLongValue(), ((FloatOperand)b).getFloatValue()));
	}
	
	private Operand<Long> longPowerInt(Operand<Long> a, Operand<Integer> b) {
		return new LongOperand((long) Math.pow(((LongOperand)a).getLongValue(), ((IntOperand)b).getIntValue()));
	}
	
	// negate
	
	private Operand<BigDecimal> negateBigDecimal(Operand<BigDecimal> x) {
		return new Operand<>(BigDecimal.class, x.getValue().negate());
	}
	
	private Operand<Double> negateDouble(Operand<Double> x) {
		return new DoubleOperand(-((DoubleOperand)x).getDoubleValue());
	}
	
	private Operand<Float> negateFloat(Operand<Float> x) {
		return new FloatOperand(-((FloatOperand)x).getFloatValue());
	}
	
	private Operand<Integer> negateInt(Operand<Integer> x) {
		return new IntOperand(-((IntOperand)x).getIntValue());
	}
	
	private Operand<Long> negateLong(Operand<Long> x) {
		return new LongOperand(-((LongOperand)x).getLongValue());
	}
}
