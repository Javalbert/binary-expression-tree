package com.javalbert.biexprtree

import spock.lang.Specification

class DefaultFunctionsSpec extends Specification {
	// add - same types
	
	def 'Add BigDecimals'() {
		given: 'two BigDecimal Operands with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to add two BigDecimals'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('+', BigDecimal, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 2'
		result.getValue() == new BigDecimal('2')
	}
	
	def 'Add BigIntegers'() {
		given: 'two BigInteger Operands with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to add two BigIntegers'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('+', BigInteger, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 2'
		result.getValue() == new BigInteger('2')
	}
	
	def 'Add doubles'() {
		given: 'two DoubleOperands with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to add two doubles'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('+', double, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 2.0d'
		result.getValue() == 2.0d
	}
	
	def 'Add floats'() {
		given: 'two FloatOperands with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to add two floats'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('+', float, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 2.0f'
		result.getValue() == 2.0f
	}
	
	def 'Add ints'() {
		given: 'two IntOperands with a value of 1'
		Operand t = new IntOperand(1)
		Operand u = new IntOperand(1)
		
		and: 'function to add two ints'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('+', int, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 2'
		result.getValue() == 2
	}
	
	def 'Add longs'() {
		given: 'two LongOperands with a value of 1'
		Operand t = new LongOperand(1L)
		Operand u = new LongOperand(1L)
		
		and: 'function to add two longs'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('+', long, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 2L'
		result.getValue() == 2L
	}
	
	def 'Concatenate strings'() {
		given: 'two Strings "foo" and "bar"'
		Operand t = new Operand(String, 'foo')
		Operand u = new Operand(String, 'bar')
		
		and: 'function to concatenate two strings'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('+', String, String))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is "foobar"'
		result.getValue() == 'foobar'
	}
	
	// add - type promotions
	
	def 'Add BigDecimal and BigInteger'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('+', BigDecimal, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 2'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('2')
	}
	
	def 'Add BigDecimal and double'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a DoubleOperand with a value of 1.0d'
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('+', BigDecimal, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 2'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('2')
	}
	
	def 'Add BigDecimal and float'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a FloatOperand with a value of 1.0f'
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('+', BigDecimal, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 2'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('2')
	}
	
	def 'Add BigDecimal and int'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('+', BigDecimal, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 2'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('2')
	}
	
	def 'Add BigDecimal and long'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('+', BigDecimal, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 2'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('2')
	}
	
	def 'Add BigInteger and int'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('+', BigInteger, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigInteger 2'
		result.getValue() instanceof BigInteger
		result.getValue() == new BigInteger('2')
	}
	
	def 'Add BigInteger and long'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('+', BigInteger, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigInteger 2'
		result.getValue() instanceof BigInteger
		result.getValue() == new BigInteger('2')
	}
	
	def 'Add double and BigInteger'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('+', double, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 2.0d'
		result.getValue() == 2.0d
	}
	
	def 'Add double and float'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'a FloatOperand with a value of 1.0f'
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('+', double, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 2.0d'
		result.getValue() == 2.0d
	}
	
	def 'Add double and int'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('+', double, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 2.0d'
		result.getValue() == 2.0d
	}
	
	def 'Add double and long'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('+', double, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 2.0d'
		result.getValue() == 2.0d
	}
	
	def 'Add float and BigInteger'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('+', float, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is float 2.0f'
		result.getValue() == 2.0f
	}
	
	def 'Add float and int'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'an IntOperand Operand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('+', float, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is float 2.0f'
		result.getValue() == 2.0f
	}
	
	def 'Add float and long'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'a LongOperand Operand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('+', float, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is float 2.0f'
		result.getValue() == 2.0f
	}
	
	def 'Add long and int'() {
		given: 'a LongOperand with a value of 1L'
		Operand t = new LongOperand(1L)
		
		and: 'an IntOperand Operand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('+', long, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is long 2L'
		result.getValue() == 2L
	}
	
	// subtract - same types
	
	def 'Subtract BigDecimals'() {
		given: 'two BigDecimal Operands with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to subtract two BigDecimals'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', BigDecimal, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 0'
		result.getValue() == new BigDecimal('0')
	}
	
	def 'Subtract BigIntegers'() {
		given: 'two BigInteger Operands with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to subtract two BigIntegers'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', BigInteger, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 0'
		result.getValue() == new BigInteger('0')
	}
	
	def 'Subtract doubles'() {
		given: 'two DoubleOperands with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to subtract two doubles'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', double, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 0.0d'
		result.getValue() == 0.0d
	}
	
	def 'Subtract floats'() {
		given: 'two FloatOperands with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to subtract two floats'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', float, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 0.0f'
		result.getValue() == 0.0f
	}
	
	def 'Subtract ints'() {
		given: 'two IntOperands with a value of 1'
		Operand t = new IntOperand(1)
		Operand u = new IntOperand(1)
		
		and: 'function to subtract two ints'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', int, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 0'
		result.getValue() == 0
	}
	
	def 'Subtract longs'() {
		given: 'two LongOperands with a value of 1'
		Operand t = new LongOperand(1L)
		Operand u = new LongOperand(1L)
		
		and: 'function to subtract two longs'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', long, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 0L'
		result.getValue() == 0L
	}
	
	// subtract - type promotions
	
	def 'BigDecimal subtract BigInteger'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', BigDecimal, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 0'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('0')
	}
	
	def 'BigDecimal subtract double'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a DoubleOperand with a value of 1.0d'
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', BigDecimal, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 0'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('0')
	}
	
	def 'BigDecimal subtract float'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a FloatOperand with a value of 1.0f'
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', BigDecimal, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 0'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('0')
	}
	
	def 'BigDecimal subtract int'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', BigDecimal, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 0'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('0')
	}
	
	def 'BigDecimal subtract long'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', BigDecimal, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 0'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('0')
	}
	
	def 'BigInteger subtract BigDecimal'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'a BigDecimal Operand with a value of 1'
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', BigInteger, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 0'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('0')
	}
	
	def 'BigInteger subtract double'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'a DoubleOperand with a value of 1.0d'
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', BigInteger, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 0.0d'
		result.getValue() == 0.0d
	}
	
	def 'BigInteger subtract float'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'a FloatOperand with a value of 1.0f'
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', BigInteger, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is float 0.0f'
		result.getValue() == 0.0f
	}
	
	def 'BigInteger subtract int'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', BigInteger, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigInteger 0'
		result.getValue() instanceof BigInteger
		result.getValue() == new BigInteger('0')
	}
	
	def 'BigInteger subtract long'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', BigInteger, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigInteger 0'
		result.getValue() instanceof BigInteger
		result.getValue() == new BigInteger('0')
	}
	
	def 'double subtract BigDecimal'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'a BigDecimal Operand with a value of 1'
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', double, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 0'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('0')
	}
	
	def 'double subtract BigInteger'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', double, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 0.0d'
		result.getValue() == 0.0d
	}
	
	def 'double subtract float'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'a FloatOperand with a value of 1.0f'
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', double, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 0.0d'
		result.getValue() == 0.0d
	}
	
	def 'double subtract int'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', double, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 0.0d'
		result.getValue() == 0.0d
	}
	
	def 'double subtract long'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', double, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 0.0d'
		result.getValue() == 0.0d
	}
	
	def 'float subtract BigDecimal'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'a BigDecimal Operand with a value of 1'
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', float, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 0'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('0')
	}
	
	def 'float subtract BigInteger'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', float, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is float 0.0f'
		result.getValue() == 0.0f
	}
	
	def 'float subtract double'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'a DoubleOperand with a value of 1.0d'
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', float, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 0.0d'
		result.getValue() == 0.0d
	}
	
	def 'float subtract int'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', float, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is float 0.0f'
		result.getValue() == 0.0f
	}
	
	def 'float subtract long'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', float, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is float 0.0f'
		result.getValue() == 0.0f
	}
	
	def 'int subtract BigDecimal'() {
		given: 'an IntOperand with a value of 1'
		Operand t = new IntOperand(1)
		
		and: 'a BigDecimal Operand with a value of 1'
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', int, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 0'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('0')
	}
	
	def 'int subtract BigInteger'() {
		given: 'an IntOperand with a value of 1'
		Operand t = new IntOperand(1)
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', int, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigInteger 0'
		result.getValue() instanceof BigInteger
		result.getValue() == new BigInteger('0')
	}
	
	def 'int subtract double'() {
		given: 'an IntOperand with a value of 1'
		Operand t = new IntOperand(1)
		
		and: 'a DoubleOperand with a value of 1.0d'
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', int, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 0.0d'
		result.getValue() == 0.0d
	}
	
	def 'int subtract float'() {
		given: 'an IntOperand with a value of 1'
		Operand t = new IntOperand(1)
		
		and: 'a FloatOperand with a value of 1.0f'
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', int, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is float 0.0f'
		result.getValue() == 0.0f
	}
	
	def 'int subtract long'() {
		given: 'an IntOperand with a value of 1'
		Operand t = new IntOperand(1)
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', int, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is long 0L'
		result.getValue() == 0L
	}
	
	def 'long subtract BigDecimal'() {
		given: 'a LongOperand with a value of 1L'
		Operand t = new LongOperand(1L)
		
		and: 'a BigDecimal Operand with a value of 1'
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', long, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 0'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('0')
	}
	
	def 'long subtract BigInteger'() {
		given: 'a LongOperand with a value of 1L'
		Operand t = new LongOperand(1L)
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', long, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigInteger 0'
		result.getValue() instanceof BigInteger
		result.getValue() == new BigInteger('0')
	}
	
	def 'long subtract double'() {
		given: 'a LongOperand with a value of 1L'
		Operand t = new LongOperand(1L)
		
		and: 'a DoubleOperand with a value of 1.0d'
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', long, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 0.0d'
		result.getValue() == 0.0d
	}
	
	def 'long subtract float'() {
		given: 'a LongOperand with a value of 1L'
		Operand t = new LongOperand(1L)
		
		and: 'a FloatOperand with a value of 1.0f'
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', long, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is float 0.0f'
		result.getValue() == 0.0f
	}
	
	def 'long subtract int'() {
		given: 'a LongOperand with a value of 1L'
		Operand t = new LongOperand(1L)
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to subtract'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('-', long, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is long 0L'
		result.getValue() == 0L
	}
	
	// multiply - same types
	
	def 'Multiply BigDecimals'() {
		given: 'two BigDecimal Operands with a value of 2'
		Operand t = new Operand(BigDecimal, new BigDecimal('2'))
		Operand u = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'function to add two BigDecimals'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('*', BigDecimal, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 4'
		result.getValue() == new BigDecimal('4')
	}
	
	def 'Multiply BigIntegers'() {
		given: 'two BigInteger Operands with a value of 2'
		Operand t = new Operand(BigInteger, new BigInteger('2'))
		Operand u = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'function to add two BigIntegers'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('*', BigInteger, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 4'
		result.getValue() == new BigInteger('4')
	}
	
	def 'Multiply doubles'() {
		given: 'two DoubleOperands with a value of 2.0d'
		Operand t = new DoubleOperand(2.0d)
		Operand u = new DoubleOperand(2.0d)
		
		and: 'function to add two doubles'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('*', double, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 4.0d'
		result.getValue() == 4.0d
	}
	
	def 'Multiply floats'() {
		given: 'two FloatOperands with a value of 2.0f'
		Operand t = new FloatOperand(2.0f)
		Operand u = new FloatOperand(2.0f)
		
		and: 'function to add two floats'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('*', float, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 4.0f'
		result.getValue() == 4.0f
	}
	
	def 'Multiply ints'() {
		given: 'two IntOperands with a value of 2'
		Operand t = new IntOperand(2)
		Operand u = new IntOperand(2)
		
		and: 'function to add two ints'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('*', int, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 4'
		result.getValue() == 4
	}
	
	def 'Multiply longs'() {
		given: 'two LongOperands with a value of 2'
		Operand t = new LongOperand(2L)
		Operand u = new LongOperand(2L)
		
		and: 'function to add two longs'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('*', long, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 4L'
		result.getValue() == 4L
	}
	
	// multiply - type promotions
	
	def 'Multiply BigDecimal and BigInteger'() {
		given: 'a BigDecimal Operand with a value of 2'
		Operand t = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'a BigInteger Operand with a value of 2'
		Operand u = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('*', BigDecimal, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 4'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('4')
	}
	
	def 'Multiply BigDecimal and double'() {
		given: 'a BigDecimal Operand with a value of 2'
		Operand t = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'a DoubleOperand with a value of 2.0d'
		Operand u = new DoubleOperand(2.0d)
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('*', BigDecimal, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 4'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('4')
	}
	
	def 'Multiply BigDecimal and float'() {
		given: 'a BigDecimal Operand with a value of 2'
		Operand t = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'a FloatOperand with a value of 2.0f'
		Operand u = new FloatOperand(2.0f)
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('*', BigDecimal, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 4'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('4')
	}
	
	def 'Multiply BigDecimal and int'() {
		given: 'a BigDecimal Operand with a value of 2'
		Operand t = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'an IntOperand with a value of 2'
		Operand u = new IntOperand(2)
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('*', BigDecimal, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 4'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('4')
	}
	
	def 'Multiply BigDecimal and long'() {
		given: 'a BigDecimal Operand with a value of 2'
		Operand t = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'a LongOperand with a value of 2L'
		Operand u = new LongOperand(2L)
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('*', BigDecimal, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 4'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('4')
	}
	
	def 'Multiply BigInteger and int'() {
		given: 'a BigInteger Operand with a value of 2'
		Operand t = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'an IntOperand with a value of 2'
		Operand u = new IntOperand(2)
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('*', BigInteger, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigInteger 4'
		result.getValue() instanceof BigInteger
		result.getValue() == new BigInteger('4')
	}
	
	def 'Multiply BigInteger and long'() {
		given: 'a BigInteger Operand with a value of 2'
		Operand t = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'a LongOperand with a value of 2L'
		Operand u = new LongOperand(2L)
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('*', BigInteger, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigInteger 4'
		result.getValue() instanceof BigInteger
		result.getValue() == new BigInteger('4')
	}
	
	def 'Multiply double and BigInteger'() {
		given: 'a DoubleOperand with a value of 2.0d'
		Operand t = new DoubleOperand(2.0d)
		
		and: 'a BigInteger Operand with a value of 2'
		Operand u = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('*', double, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 4.0d'
		result.getValue() == 4.0d
	}
	
	def 'Multiply double and float'() {
		given: 'a DoubleOperand with a value of 2.0d'
		Operand t = new DoubleOperand(2.0d)
		
		and: 'a FloatOperand with a value of 2.0f'
		Operand u = new FloatOperand(2.0f)
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('*', double, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 4.0d'
		result.getValue() == 4.0d
	}
	
	def 'Multiply double and int'() {
		given: 'a DoubleOperand with a value of 2.0d'
		Operand t = new DoubleOperand(2.0d)
		
		and: 'an IntOperand with a value of 2'
		Operand u = new IntOperand(2)
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('*', double, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 4.0d'
		result.getValue() == 4.0d
	}
	
	def 'Multiply double and long'() {
		given: 'a DoubleOperand with a value of 2.0d'
		Operand t = new DoubleOperand(2.0d)
		
		and: 'a LongOperand with a value of 2L'
		Operand u = new LongOperand(2L)
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('*', double, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 4.0d'
		result.getValue() == 4.0d
	}
	
	def 'Multiply float and BigInteger'() {
		given: 'a FloatOperand with a value of 2.0f'
		Operand t = new FloatOperand(2.0f)
		
		and: 'a BigInteger Operand with a value of 2'
		Operand u = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('*', float, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is float 4.0f'
		result.getValue() == 4.0f
	}
	
	def 'Multiply float and int'() {
		given: 'a FloatOperand with a value of 2.0f'
		Operand t = new FloatOperand(2.0f)
		
		and: 'an IntOperand Operand with a value of 2'
		Operand u = new IntOperand(2)
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('*', float, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is float 4.0f'
		result.getValue() == 4.0f
	}
	
	def 'Multiply float and long'() {
		given: 'a FloatOperand with a value of 2.0f'
		Operand t = new FloatOperand(2.0f)
		
		and: 'a LongOperand Operand with a value of 2L'
		Operand u = new LongOperand(2L)
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('*', float, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is float 4.0f'
		result.getValue() == 4.0f
	}
	
	def 'Multiply long and int'() {
		given: 'a LongOperand with a value of 2L'
		Operand t = new LongOperand(2L)
		
		and: 'an IntOperand Operand with a value of 2'
		Operand u = new IntOperand(2)
		
		and: 'function to add'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('*', long, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is long 4L'
		result.getValue() == 4L
	}
	
	// divide - same types
	
	def 'Divide BigDecimals'() {
		given: 'two BigDecimal Operands with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to divide two BigDecimals'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', BigDecimal, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 1'
		result.getValue() == new BigDecimal('1')
	}
	
	def 'Divide BigIntegers'() {
		given: 'two BigInteger Operands with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to divide two BigIntegers'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', BigInteger, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 1'
		result.getValue() == new BigInteger('1')
	}
	
	def 'Divide doubles'() {
		given: 'two DoubleOperands with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to divide two doubles'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', double, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 1.0d'
		result.getValue() == 1.0d
	}
	
	def 'Divide floats'() {
		given: 'two FloatOperands with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to divide two floats'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', float, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 1.0f'
		result.getValue() == 1.0f
	}
	
	def 'Divide ints'() {
		given: 'two IntOperands with a value of 1'
		Operand t = new IntOperand(1)
		Operand u = new IntOperand(1)
		
		and: 'function to divide two ints'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', int, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 1'
		result.getValue() == 1
	}
	
	def 'Divide longs'() {
		given: 'two LongOperands with a value of 1'
		Operand t = new LongOperand(1L)
		Operand u = new LongOperand(1L)
		
		and: 'function to divide two longs'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', long, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 1L'
		result.getValue() == 1L
	}
	
	// divide - type promotions
	
	def 'BigDecimal divided by BigInteger'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', BigDecimal, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 1'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('1')
	}
	
	def 'BigDecimal divided by double'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a DoubleOperand with a value of 1.0d'
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', BigDecimal, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 1'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('1')
	}
	
	def 'BigDecimal divided by float'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a FloatOperand with a value of 1.0f'
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', BigDecimal, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 1'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('1')
	}
	
	def 'BigDecimal divided by int'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', BigDecimal, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 1'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('1')
	}
	
	def 'BigDecimal divided by long'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', BigDecimal, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 1'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('1')
	}
	
	def 'BigInteger divided by BigDecimal'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'a BigDecimal Operand with a value of 1'
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', BigInteger, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 1'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('1')
	}
	
	def 'BigInteger divided by double'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'a DoubleOperand with a value of 1.0d'
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', BigInteger, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 1.0d'
		result.getValue() == 1.0d
	}
	
	def 'BigInteger divided by float'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'a FloatOperand with a value of 1.0f'
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', BigInteger, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is float 1.0f'
		result.getValue() == 1.0f
	}
	
	def 'BigInteger divided by int'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', BigInteger, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigInteger 1'
		result.getValue() instanceof BigInteger
		result.getValue() == new BigInteger('1')
	}
	
	def 'BigInteger divided by long'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', BigInteger, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigInteger 1'
		result.getValue() instanceof BigInteger
		result.getValue() == new BigInteger('1')
	}
	
	def 'double divided by BigDecimal'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'a BigDecimal Operand with a value of 1'
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', double, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 1'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('1')
	}
	
	def 'double divided by BigInteger'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', double, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 1.0d'
		result.getValue() == 1.0d
	}
	
	def 'double divided by float'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'a FloatOperand with a value of 1.0f'
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', double, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 1.0d'
		result.getValue() == 1.0d
	}
	
	def 'double divided by int'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', double, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 1.0d'
		result.getValue() == 1.0d
	}
	
	def 'double divided by long'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', double, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 1.0d'
		result.getValue() == 1.0d
	}
	
	def 'float divided by BigDecimal'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'a BigDecimal Operand with a value of 1'
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', float, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 1'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('1')
	}
	
	def 'float divided by BigInteger'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', float, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is float 1.0f'
		result.getValue() == 1.0f
	}
	
	def 'float divided by double'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'a DoubleOperand with a value of 1.0d'
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', float, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 1.0d'
		result.getValue() == 1.0d
	}
	
	def 'float divided by int'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', float, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is float 1.0f'
		result.getValue() == 1.0f
	}
	
	def 'float divided by long'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', float, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is float 1.0f'
		result.getValue() == 1.0f
	}
	
	def 'int divided by BigDecimal'() {
		given: 'an IntOperand with a value of 1'
		Operand t = new IntOperand(1)
		
		and: 'a BigDecimal Operand with a value of 1'
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', int, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 1'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('1')
	}
	
	def 'int divided by BigInteger'() {
		given: 'an IntOperand with a value of 1'
		Operand t = new IntOperand(1)
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', int, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigInteger 1'
		result.getValue() instanceof BigInteger
		result.getValue() == new BigInteger('1')
	}
	
	def 'int divided by double'() {
		given: 'an IntOperand with a value of 1'
		Operand t = new IntOperand(1)
		
		and: 'a DoubleOperand with a value of 1.0d'
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', int, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 1.0d'
		result.getValue() == 1.0d
	}
	
	def 'int divided by float'() {
		given: 'an IntOperand with a value of 1'
		Operand t = new IntOperand(1)
		
		and: 'a FloatOperand with a value of 1.0f'
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', int, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is float 1.0f'
		result.getValue() == 1.0f
	}
	
	def 'int divided by long'() {
		given: 'an IntOperand with a value of 1'
		Operand t = new IntOperand(1)
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', int, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is long 1L'
		result.getValue() == 1L
	}
	
	def 'long divided by BigDecimal'() {
		given: 'a LongOperand with a value of 1L'
		Operand t = new LongOperand(1L)
		
		and: 'a BigDecimal Operand with a value of 1'
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', long, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 1'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('1')
	}
	
	def 'long divided by BigInteger'() {
		given: 'a LongOperand with a value of 1L'
		Operand t = new LongOperand(1L)
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', long, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigInteger 1'
		result.getValue() instanceof BigInteger
		result.getValue() == new BigInteger('1')
	}
	
	def 'long divided by double'() {
		given: 'a LongOperand with a value of 1L'
		Operand t = new LongOperand(1L)
		
		and: 'a DoubleOperand with a value of 1.0d'
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', long, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 1.0d'
		result.getValue() == 1.0d
	}
	
	def 'long divided by float'() {
		given: 'a LongOperand with a value of 1L'
		Operand t = new LongOperand(1L)
		
		and: 'a FloatOperand with a value of 1.0f'
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', long, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is float 1.0f'
		result.getValue() == 1.0f
	}
	
	def 'long divided by int'() {
		given: 'a LongOperand with a value of 1L'
		Operand t = new LongOperand(1L)
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to divide'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('/', long, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is long 1L'
		result.getValue() == 1L
	}
	
	// modulo - same types
	
	def 'Modulo BigDecimals'() {
		given: 'two BigDecimal Operands with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to mod two BigDecimals'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', BigDecimal, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 0'
		result.getValue() == new BigDecimal('0')
	}
	
	def 'Modulo BigIntegers'() {
		given: 'two BigInteger Operands with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to mod two BigIntegers'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', BigInteger, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 0'
		result.getValue() == new BigInteger('0')
	}
	
	def 'Modulo doubles'() {
		given: 'two DoubleOperands with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to mod two doubles'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', double, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 0.0d'
		result.getValue() == 0.0d
	}
	
	def 'Modulo floats'() {
		given: 'two FloatOperands with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to mod two floats'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', float, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 0.0f'
		result.getValue() == 0.0f
	}
	
	def 'Modulo ints'() {
		given: 'two IntOperands with a value of 1'
		Operand t = new IntOperand(1)
		Operand u = new IntOperand(1)
		
		and: 'function to mod two ints'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', int, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 0'
		result.getValue() == 0
	}
	
	def 'Modulo longs'() {
		given: 'two LongOperands with a value of 1'
		Operand t = new LongOperand(1L)
		Operand u = new LongOperand(1L)
		
		and: 'function to mod two longs'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', long, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 0L'
		result.getValue() == 0L
	}
	
	// modulo - type promotions
	
	def 'BigDecimal mod BigInteger'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', BigDecimal, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 0'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('0')
	}
	
	def 'BigDecimal mod double'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a DoubleOperand with a value of 1.0d'
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', BigDecimal, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 0'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('0')
	}
	
	def 'BigDecimal mod float'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a FloatOperand with a value of 1.0f'
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', BigDecimal, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 0'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('0')
	}
	
	def 'BigDecimal mod int'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', BigDecimal, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 0'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('0')
	}
	
	def 'BigDecimal mod long'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', BigDecimal, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 0'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('0')
	}
	
	def 'BigInteger mod BigDecimal'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'a BigDecimal Operand with a value of 1'
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', BigInteger, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 0'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('0')
	}
	
	def 'BigInteger mod double'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'a DoubleOperand with a value of 1.0d'
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', BigInteger, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 0.0d'
		result.getValue() == 0.0d
	}
	
	def 'BigInteger mod float'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'a FloatOperand with a value of 1.0f'
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', BigInteger, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is float 0.0f'
		result.getValue() == 0.0f
	}
	
	def 'BigInteger mod int'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', BigInteger, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigInteger 0'
		result.getValue() instanceof BigInteger
		result.getValue() == new BigInteger('0')
	}
	
	def 'BigInteger mod long'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', BigInteger, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigInteger 0'
		result.getValue() instanceof BigInteger
		result.getValue() == new BigInteger('0')
	}
	
	def 'double mod BigDecimal'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'a BigDecimal Operand with a value of 1'
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', double, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 0'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('0')
	}
	
	def 'double mod BigInteger'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', double, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 0.0d'
		result.getValue() == 0.0d
	}
	
	def 'double mod float'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'a FloatOperand with a value of 1.0f'
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', double, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 0.0d'
		result.getValue() == 0.0d
	}
	
	def 'double mod int'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', double, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 0.0d'
		result.getValue() == 0.0d
	}
	
	def 'double mod long'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', double, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 0.0d'
		result.getValue() == 0.0d
	}
	
	def 'float mod BigDecimal'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'a BigDecimal Operand with a value of 1'
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', float, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 0'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('0')
	}
	
	def 'float mod BigInteger'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', float, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is float 0.0f'
		result.getValue() == 0.0f
	}
	
	def 'float mod double'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'a DoubleOperand with a value of 1.0d'
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', float, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 0.0d'
		result.getValue() == 0.0d
	}
	
	def 'float mod int'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', float, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is float 0.0f'
		result.getValue() == 0.0f
	}
	
	def 'float mod long'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', float, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is float 0.0f'
		result.getValue() == 0.0f
	}
	
	def 'int mod BigDecimal'() {
		given: 'an IntOperand with a value of 1'
		Operand t = new IntOperand(1)
		
		and: 'a BigDecimal Operand with a value of 1'
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', int, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 0'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('0')
	}
	
	def 'int mod BigInteger'() {
		given: 'an IntOperand with a value of 1'
		Operand t = new IntOperand(1)
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', int, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigInteger 0'
		result.getValue() instanceof BigInteger
		result.getValue() == new BigInteger('0')
	}
	
	def 'int mod double'() {
		given: 'an IntOperand with a value of 1'
		Operand t = new IntOperand(1)
		
		and: 'a DoubleOperand with a value of 1.0d'
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', int, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 0.0d'
		result.getValue() == 0.0d
	}
	
	def 'int mod float'() {
		given: 'an IntOperand with a value of 1'
		Operand t = new IntOperand(1)
		
		and: 'a FloatOperand with a value of 1.0f'
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', int, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is float 0.0f'
		result.getValue() == 0.0f
	}
	
	def 'int mod long'() {
		given: 'an IntOperand with a value of 1'
		Operand t = new IntOperand(1)
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', int, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is long 0L'
		result.getValue() == 0L
	}
	
	def 'long mod BigDecimal'() {
		given: 'a LongOperand with a value of 1L'
		Operand t = new LongOperand(1L)
		
		and: 'a BigDecimal Operand with a value of 1'
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', long, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigDecimal 0'
		result.getValue() instanceof BigDecimal
		result.getValue() == new BigDecimal('0')
	}
	
	def 'long mod BigInteger'() {
		given: 'a LongOperand with a value of 1L'
		Operand t = new LongOperand(1L)
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', long, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is BigInteger 0'
		result.getValue() instanceof BigInteger
		result.getValue() == new BigInteger('0')
	}
	
	def 'long mod double'() {
		given: 'a LongOperand with a value of 1L'
		Operand t = new LongOperand(1L)
		
		and: 'a DoubleOperand with a value of 1.0d'
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', long, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is double 0.0d'
		result.getValue() == 0.0d
	}
	
	def 'long mod float'() {
		given: 'a LongOperand with a value of 1L'
		Operand t = new LongOperand(1L)
		
		and: 'a FloatOperand with a value of 1.0f'
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', long, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is float 0.0f'
		result.getValue() == 0.0f
	}
	
	def 'long mod int'() {
		given: 'a LongOperand with a value of 1L'
		Operand t = new LongOperand(1L)
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to mod'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('%', long, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is long 0L'
		result.getValue() == 0L
	}
	
	// power - same types
	
	def 'Power BigDecimals'() {
		given: 'two BigDecimal Operands with a value of 2'
		Operand t = new Operand(BigDecimal, new BigDecimal('2'))
		Operand u = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'function to mod two BigDecimals'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('**', BigDecimal, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 4'
		result.getValue() == new BigDecimal('4')
	}
	
	def 'Power BigIntegers'() {
		given: 'two BigInteger Operands with a value of 2'
		Operand t = new Operand(BigInteger, new BigInteger('2'))
		Operand u = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'function to mod two BigIntegers'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('**', BigInteger, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 4'
		result.getValue() == new BigInteger('4')
	}
	
	def 'Power doubles'() {
		given: 'two DoubleOperands with a value of 2.0d'
		Operand t = new DoubleOperand(2.0d)
		Operand u = new DoubleOperand(2.0d)
		
		and: 'function to mod two doubles'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('**', double, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 4.0d'
		result.getValue() == 4.0d
	}
	
	def 'Power floats'() {
		given: 'two FloatOperands with a value of 2.0f'
		Operand t = new FloatOperand(2.0f)
		Operand u = new FloatOperand(2.0f)
		
		and: 'function to mod two floats'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('**', float, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 4.0f'
		result.getValue() == 4.0f
	}
	
	def 'Power ints'() {
		given: 'two IntOperands with a value of 2'
		Operand t = new IntOperand(2)
		Operand u = new IntOperand(2)
		
		and: 'function to mod two ints'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('**', int, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 4'
		result.getValue() == 4
	}
	
	def 'Power longs'() {
		given: 'two LongOperands with a value of 2'
		Operand t = new LongOperand(2L)
		Operand u = new LongOperand(2L)
		
		and: 'function to mod two longs'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('**', long, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is 4L'
		result.getValue() == 4L
	}
	
	// power - type promotions (ignored)
	
	// negate
	
	def 'Negate BigDecimal'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'additive inverse function'
		UnaryFunc unaryFunc = DefaultFunctions.INSTANCE.getUnaryFunc(
			new UnaryOperatorInfo('-', BigDecimal))
		
		when: 'function is executed'
		Operand result = unaryFunc.getFunction().apply(t)
		
		then: 'result is -1'
		result.getValue() == new BigDecimal('-1')
	}
	
	def 'Negate BigInteger'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'additive inverse function'
		UnaryFunc unaryFunc = DefaultFunctions.INSTANCE.getUnaryFunc(
			new UnaryOperatorInfo('-', BigInteger))
		
		when: 'function is executed'
		Operand result = unaryFunc.getFunction().apply(t)
		
		then: 'result is -1'
		result.getValue() == new BigInteger('-1')
	}
	
	def 'Negate double'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'additive inverse function'
		UnaryFunc unaryFunc = DefaultFunctions.INSTANCE.getUnaryFunc(
			new UnaryOperatorInfo('-', double))
		
		when: 'function is executed'
		Operand result = unaryFunc.getFunction().apply(t)
		
		then: 'result is -1.0d'
		result.getValue() == -1.0d
	}
	
	def 'Negate float'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'additive inverse function'
		UnaryFunc unaryFunc = DefaultFunctions.INSTANCE.getUnaryFunc(
			new UnaryOperatorInfo('-', float))
		
		when: 'function is executed'
		Operand result = unaryFunc.getFunction().apply(t)
		
		then: 'result is -1.0f'
		result.getValue() == -1.0f
	}
	
	def 'Negate int'() {
		given: 'a IntOperand with a value of 1'
		Operand t = new IntOperand(1)
		
		and: 'additive inverse function'
		UnaryFunc unaryFunc = DefaultFunctions.INSTANCE.getUnaryFunc(
			new UnaryOperatorInfo('-', int))
		
		when: 'function is executed'
		Operand result = unaryFunc.getFunction().apply(t)
		
		then: 'result is -1'
		result.getValue() == -1
	}
	
	def 'Negate long'() {
		given: 'a LongOperand with a value of 1L'
		Operand t = new LongOperand(1L)
		
		and: 'additive inverse function'
		UnaryFunc unaryFunc = DefaultFunctions.INSTANCE.getUnaryFunc(
			new UnaryOperatorInfo('-', long))
		
		when: 'function is executed'
		Operand result = unaryFunc.getFunction().apply(t)
		
		then: 'result is -1L'
		result.getValue() == -1L
	}
	
	// equals - same types
	
	def 'BigDecimals are equal'() {
		given: 'two BigDecimal Operands with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to check equality of two BigDecimals'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('=', BigDecimal, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigIntegers are equal'() {
		given: 'two BigInteger Operands with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to check equality of two BigIntegers'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('=', BigInteger, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'doubles are equal'() {
		given: 'two DoubleOperands with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to check equality of two doubles'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('=', double, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'floats are equal'() {
		given: 'two FloatOperands with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to check equality of two floats'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('=', float, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'ints are equal'() {
		given: 'two IntOperands with a value of 1'
		Operand t = new IntOperand(1)
		Operand u = new IntOperand(1)
		
		and: 'function to check equality of two ints'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('=', int, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'longs are equal'() {
		given: 'two LongOperands with a value of 1'
		Operand t = new LongOperand(1L)
		Operand u = new LongOperand(1L)
		
		and: 'function to check equality of two longs'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('=', long, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'Strings are equal'() {
		given: 'two Strings "foo" and "foo"'
		Operand t = new Operand(String, 'foo')
		Operand u = new Operand(String, 'foo')
		
		and: 'function to check equality of two strings'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('=', String, String))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	// equals - type promotions
	
	def 'BigDecimal and BigInteger are equal'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to check equality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('=', BigDecimal, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigDecimal and double are equal'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a DoubleOperand with a value of 1.0d'
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to check equality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('=', BigDecimal, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigDecimal and float are equal'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a FloatOperand with a value of 1.0f'
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to check equality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('=', BigDecimal, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigDecimal and int are equal'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to check equality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('=', BigDecimal, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigDecimal and long are equal'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to check equality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('=', BigDecimal, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigInteger and int are equal'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to check equality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('=', BigInteger, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigInteger and long are equal'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to check equality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('=', BigInteger, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'double and BigInteger are equal'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to check equality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('=', double, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'double and float are equal'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'a FloatOperand with a value of 1.0f'
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to check equality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('=', double, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'double and int are equal'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to check equality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('=', double, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'double and long are equal'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to check equality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('=', double, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'float and BigInteger are equal'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to check equality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('=', float, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'float and int are equal'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'an IntOperand Operand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to check equality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('=', float, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'float and long are equal'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'a LongOperand Operand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to check equality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('=', float, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'long and int are equal'() {
		given: 'a LongOperand with a value of 1L'
		Operand t = new LongOperand(1L)
		
		and: 'an IntOperand Operand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to check equality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('=', long, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	// not equals - same types
	
	def 'BigDecimals are not equal'() {
		given: 'two BigDecimal Operands with values 1 and 2'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		Operand u = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'function to check inequality of two BigDecimals'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('!=', BigDecimal, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigIntegers are not equal'() {
		given: 'two BigInteger Operands with values 1 and 2'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		Operand u = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'function to check inequality of two BigIntegers'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('!=', BigInteger, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'doubles are not equal'() {
		given: 'two DoubleOperands with values 1.0d and 2.0d'
		Operand t = new DoubleOperand(1.0d)
		Operand u = new DoubleOperand(2.0d)
		
		and: 'function to check inequality of two doubles'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('!=', double, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'floats are not equal'() {
		given: 'two FloatOperands with values 1.0f and 2.0f'
		Operand t = new FloatOperand(1.0f)
		Operand u = new FloatOperand(2.0f)
		
		and: 'function to check inequality of two floats'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('!=', float, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'ints are not equal'() {
		given: 'two IntOperands with values 1 and 2'
		Operand t = new IntOperand(1)
		Operand u = new IntOperand(2)
		
		and: 'function to check inequality of two ints'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('!=', int, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'longs are not equal'() {
		given: 'two LongOperands with values 1L and 2L'
		Operand t = new LongOperand(1L)
		Operand u = new LongOperand(2L)
		
		and: 'function to check inequality of two longs'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('!=', long, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'Strings are not equal'() {
		given: 'two Strings "foo" and "bar"'
		Operand t = new Operand(String, 'foo')
		Operand u = new Operand(String, 'bar')
		
		and: 'function to check inequality of two strings'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('!=', String, String))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	// not equals - type promotions
	
	def 'BigDecimal and BigInteger are not equal'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a BigInteger Operand with a value of 2'
		Operand u = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'function to check inequality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('!=', BigDecimal, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigDecimal and double are not equal'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a DoubleOperand with a value of 2.0d'
		Operand u = new DoubleOperand(2.0d)
		
		and: 'function to check inequality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('!=', BigDecimal, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigDecimal and float are not equal'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a FloatOperand with a value of 2.0f'
		Operand u = new FloatOperand(2.0f)
		
		and: 'function to check inequality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('!=', BigDecimal, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigDecimal and int are not equal'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'an IntOperand with a value of 2'
		Operand u = new IntOperand(2)
		
		and: 'function to check inequality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('!=', BigDecimal, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigDecimal and long are not equal'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a LongOperand with a value of 2L'
		Operand u = new LongOperand(2L)
		
		and: 'function to check inequality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('!=', BigDecimal, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigInteger and int are not equal'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'an IntOperand with a value of 2'
		Operand u = new IntOperand(2)
		
		and: 'function to check inequality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('!=', BigInteger, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigInteger and long are not equal'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'a LongOperand with a value of 2L'
		Operand u = new LongOperand(2L)
		
		and: 'function to check inequality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('!=', BigInteger, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'double and BigInteger are not equal'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'a BigInteger Operand with a value of 2'
		Operand u = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'function to check inequality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('!=', double, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'double and float are not equal'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'a FloatOperand with a value of 2.0f'
		Operand u = new FloatOperand(2.0f)
		
		and: 'function to check inequality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('!=', double, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'double and int are not equal'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'an IntOperand with a value of 2'
		Operand u = new IntOperand(2)
		
		and: 'function to check inequality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('!=', double, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'double and long are not equal'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'a LongOperand with a value of 2L'
		Operand u = new LongOperand(2L)
		
		and: 'function to check inequality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('!=', double, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'float and BigInteger are not equal'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'a BigInteger Operand with a value of 2'
		Operand u = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'function to check inequality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('!=', float, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'float and int are not equal'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'an IntOperand Operand with a value of 2'
		Operand u = new IntOperand(2)
		
		and: 'function to check inequality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('!=', float, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'float and long are not equal'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'a LongOperand Operand with a value of 2L'
		Operand u = new LongOperand(2L)
		
		and: 'function to check inequality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('!=', float, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'long and int are not equal'() {
		given: 'a LongOperand with a value of 1L'
		Operand t = new LongOperand(1L)
		
		and: 'an IntOperand Operand with a value of 2'
		Operand u = new IntOperand(2)
		
		and: 'function to check inequality'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('!=', long, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	// less than - same types
	
	def 'BigDecimals less than the other'() {
		given: 'two BigDecimal Operands with values 1 and 2'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		Operand u = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'function to check if one is less than another of two BigDecimals'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', BigDecimal, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigIntegers less than the other'() {
		given: 'two BigInteger Operands with values 1 and 2'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		Operand u = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'function to check if one is less than another of two BigIntegers'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', BigInteger, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'doubles less than the other'() {
		given: 'two DoubleOperands with values 1.0d and 2.0d'
		Operand t = new DoubleOperand(1.0d)
		Operand u = new DoubleOperand(2.0d)
		
		and: 'function to check if one is less than another of two doubles'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', double, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'floats less than the other'() {
		given: 'two FloatOperands with values 1.0f and 2.0f'
		Operand t = new FloatOperand(1.0f)
		Operand u = new FloatOperand(2.0f)
		
		and: 'function to check if one is less than another of two floats'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', float, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'ints less than the other'() {
		given: 'two IntOperands with values 1 and 2'
		Operand t = new IntOperand(1)
		Operand u = new IntOperand(2)
		
		and: 'function to check if one is less than another of two ints'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', int, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'longs less than the other'() {
		given: 'two LongOperands with values 1L and 2L'
		Operand t = new LongOperand(1L)
		Operand u = new LongOperand(2L)
		
		and: 'function to check if one is less than another of two longs'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', long, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	// less than - type promotions
	
	def 'BigDecimal less than BigInteger'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a BigInteger Operand with a value of 2'
		Operand u = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', BigDecimal, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigDecimal less than double'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a DoubleOperand with a value of 2.0d'
		Operand u = new DoubleOperand(2.0d)
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', BigDecimal, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigDecimal less than float'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a FloatOperand with a value of 2.0f'
		Operand u = new FloatOperand(2.0f)
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', BigDecimal, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigDecimal less than int'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'an IntOperand with a value of 2'
		Operand u = new IntOperand(2)
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', BigDecimal, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigDecimal less than long'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a LongOperand with a value of 2L'
		Operand u = new LongOperand(2L)
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', BigDecimal, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigInteger less than BigDecimal'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'a BigDecimal Operand with a value of 2'
		Operand u = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', BigInteger, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigInteger less than double'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'a DoubleOperand with a value of 2.0d'
		Operand u = new DoubleOperand(2.0d)
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', BigInteger, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigInteger less than float'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'a FloatOperand with a value of 2.0f'
		Operand u = new FloatOperand(2.0f)
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', BigInteger, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigInteger less than int'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'an IntOperand with a value of 2'
		Operand u = new IntOperand(2)
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', BigInteger, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigInteger less than long'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'a LongOperand with a value of 2L'
		Operand u = new LongOperand(2L)
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', BigInteger, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'double less than BigDecimal'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'a BigDecimal Operand with a value of 2'
		Operand u = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', double, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'double less than BigInteger'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'a BigInteger Operand with a value of 2'
		Operand u = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', double, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'double less than float'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'a FloatOperand with a value of 2.0f'
		Operand u = new FloatOperand(2.0f)
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', double, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'double less than int'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'an IntOperand with a value of 2'
		Operand u = new IntOperand(2)
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', double, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'double less than long'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'a LongOperand with a value of 2L'
		Operand u = new LongOperand(2L)
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', double, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'float less than BigDecimal'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'a BigDecimal Operand with a value of 2'
		Operand u = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', float, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'float less than BigInteger'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'a BigInteger Operand with a value of 2'
		Operand u = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', float, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'float less than double'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'a DoubleOperand with a value of 2.0d'
		Operand u = new DoubleOperand(2.0d)
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', float, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'float less than int'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'an IntOperand with a value of 2'
		Operand u = new IntOperand(2)
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', float, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'float less than long'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'a LongOperand with a value of 2L'
		Operand u = new LongOperand(2L)
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', float, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'int less than BigDecimal'() {
		given: 'an IntOperand with a value of 1'
		Operand t = new IntOperand(1)
		
		and: 'a BigDecimal Operand with a value of 2'
		Operand u = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', int, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'int less than BigInteger'() {
		given: 'an IntOperand with a value of 1'
		Operand t = new IntOperand(1)
		
		and: 'a BigInteger Operand with a value of 2'
		Operand u = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', int, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'int less than double'() {
		given: 'an IntOperand with a value of 1'
		Operand t = new IntOperand(1)
		
		and: 'a DoubleOperand with a value of 2.0d'
		Operand u = new DoubleOperand(2.0d)
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', int, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'int less than float'() {
		given: 'an IntOperand with a value of 1'
		Operand t = new IntOperand(1)
		
		and: 'a FloatOperand with a value of 2.0f'
		Operand u = new FloatOperand(2.0f)
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', int, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'int less than long'() {
		given: 'an IntOperand with a value of 1'
		Operand t = new IntOperand(1)
		
		and: 'a LongOperand with a value of 2L'
		Operand u = new LongOperand(2L)
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', int, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'long less than BigDecimal'() {
		given: 'a LongOperand with a value of 1L'
		Operand t = new LongOperand(1L)
		
		and: 'a BigDecimal Operand with a value of 2'
		Operand u = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', long, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'long less than BigInteger'() {
		given: 'a LongOperand with a value of 1L'
		Operand t = new LongOperand(1L)
		
		and: 'a BigInteger Operand with a value of 2'
		Operand u = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', long, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'long less than double'() {
		given: 'a LongOperand with a value of 1L'
		Operand t = new LongOperand(1L)
		
		and: 'a DoubleOperand with a value of 2.0d'
		Operand u = new DoubleOperand(2.0d)
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', long, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'long less than float'() {
		given: 'a LongOperand with a value of 1L'
		Operand t = new LongOperand(1L)
		
		and: 'a FloatOperand with a value of 2.0f'
		Operand u = new FloatOperand(2.0f)
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', long, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'long less than int'() {
		given: 'a LongOperand with a value of 1L'
		Operand t = new LongOperand(1L)
		
		and: 'an IntOperand with a value of 2'
		Operand u = new IntOperand(2)
		
		and: 'function to check if one is less than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<', long, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	// less than equal - same types
	
	def 'BigDecimals less than or equal to the other'() {
		given: 'two BigDecimal Operands with values 1 and 2'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		Operand u = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'function to check if one is less than or equal to another of two BigDecimals'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', BigDecimal, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(new BigDecimal('2'))
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'BigIntegers less than or equal to the other'() {
		given: 'two BigInteger Operands with values 1 and 2'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		Operand u = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'function to check if one is less than or equal to another of two BigIntegers'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', BigInteger, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(new BigInteger('2'))
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'doubles less than or equal to the other'() {
		given: 'two DoubleOperands with values 1.0d and 2.0d'
		Operand t = new DoubleOperand(1.0d)
		Operand u = new DoubleOperand(2.0d)
		
		and: 'function to check if one is less than or equal to another of two doubles'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', double, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(2.0d)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'floats less than or equal to the other'() {
		given: 'two FloatOperands with values 1.0f and 2.0f'
		Operand t = new FloatOperand(1.0f)
		Operand u = new FloatOperand(2.0f)
		
		and: 'function to check if one is less than or equal to another of two floats'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', float, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(2.0f)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'ints less than or equal to the other'() {
		given: 'two IntOperands with values 1 and 2'
		Operand t = new IntOperand(1)
		Operand u = new IntOperand(2)
		
		and: 'function to check if one is less than or equal to another of two ints'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', int, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(2)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'longs less than or equal to the other'() {
		given: 'two LongOperands with values 1L and 2L'
		Operand t = new LongOperand(1L)
		Operand u = new LongOperand(2L)
		
		and: 'function to check if one is less than or equal to another of two longs'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', long, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(2L)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	// less than equal - type promotions
	
	def 'BigDecimal less than or equal to BigInteger'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a BigInteger Operand with a value of 2'
		Operand u = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', BigDecimal, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(new BigDecimal('2'))
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'BigDecimal less than or equal to double'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a DoubleOperand with a value of 2.0d'
		Operand u = new DoubleOperand(2.0d)
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', BigDecimal, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(new BigDecimal('2'))
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'BigDecimal less than or equal to float'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a FloatOperand with a value of 2.0f'
		Operand u = new FloatOperand(2.0f)
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', BigDecimal, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(new BigDecimal('2'))
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'BigDecimal less than or equal to int'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'an IntOperand with a value of 2'
		Operand u = new IntOperand(2)
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', BigDecimal, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(new BigDecimal('2'))
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'BigDecimal less than or equal to long'() {
		given: 'a BigDecimal Operand with a value of 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'a LongOperand with a value of 2L'
		Operand u = new LongOperand(2L)
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', BigDecimal, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(new BigDecimal('2'))
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'BigInteger less than or equal to BigDecimal'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'a BigDecimal Operand with a value of 2'
		Operand u = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', BigInteger, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(new BigInteger('2'))
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'BigInteger less than or equal to double'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'a DoubleOperand with a value of 2.0d'
		Operand u = new DoubleOperand(2.0d)
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', BigInteger, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(new BigInteger('2'))
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'BigInteger less than or equal to float'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'a FloatOperand with a value of 2.0f'
		Operand u = new FloatOperand(2.0f)
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', BigInteger, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(new BigInteger('2'))
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'BigInteger less than or equal to int'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'an IntOperand with a value of 2'
		Operand u = new IntOperand(2)
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', BigInteger, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(new BigInteger('2'))
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'BigInteger less than or equal to long'() {
		given: 'a BigInteger Operand with a value of 1'
		Operand t = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'a LongOperand with a value of 2L'
		Operand u = new LongOperand(2L)
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', BigInteger, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(new BigInteger('2'))
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'double less than or equal to BigDecimal'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'a BigDecimal Operand with a value of 2'
		Operand u = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', double, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(2.0d)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'double less than or equal to BigInteger'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'a BigInteger Operand with a value of 2'
		Operand u = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', double, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(2.0d)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'double less than or equal to float'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'a FloatOperand with a value of 2.0f'
		Operand u = new FloatOperand(2.0f)
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', double, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(2.0d)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'double less than or equal to int'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'an IntOperand with a value of 2'
		Operand u = new IntOperand(2)
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', double, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(2.0d)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'double less than or equal to long'() {
		given: 'a DoubleOperand with a value of 1.0d'
		Operand t = new DoubleOperand(1.0d)
		
		and: 'a LongOperand with a value of 2L'
		Operand u = new LongOperand(2L)
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', double, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(2.0d)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'float less than or equal to BigDecimal'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'a BigDecimal Operand with a value of 2'
		Operand u = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', float, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(2.0f)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'float less than or equal to BigInteger'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'a BigInteger Operand with a value of 2'
		Operand u = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', float, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(2.0f)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'float less than or equal to double'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'a DoubleOperand with a value of 2.0d'
		Operand u = new DoubleOperand(2.0d)
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', float, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(2.0f)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'float less than or equal to int'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'an IntOperand with a value of 2'
		Operand u = new IntOperand(2)
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', float, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(2.0f)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'float less than or equal to long'() {
		given: 'a FloatOperand with a value of 1.0f'
		Operand t = new FloatOperand(1.0f)
		
		and: 'a LongOperand with a value of 2L'
		Operand u = new LongOperand(2L)
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', float, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(2.0f)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'int less than or equal to BigDecimal'() {
		given: 'an IntOperand with a value of 1'
		Operand t = new IntOperand(1)
		
		and: 'a BigDecimal Operand with a value of 2'
		Operand u = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', int, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(2)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'int less than or equal to BigInteger'() {
		given: 'an IntOperand with a value of 1'
		Operand t = new IntOperand(1)
		
		and: 'a BigInteger Operand with a value of 2'
		Operand u = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', int, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(2)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'int less than or equal to double'() {
		given: 'an IntOperand with a value of 1'
		Operand t = new IntOperand(1)
		
		and: 'a DoubleOperand with a value of 2.0d'
		Operand u = new DoubleOperand(2.0d)
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', int, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(2)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'int less than or equal to float'() {
		given: 'an IntOperand with a value of 1'
		Operand t = new IntOperand(1)
		
		and: 'a FloatOperand with a value of 2.0f'
		Operand u = new FloatOperand(2.0f)
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', int, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(2)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'int less than or equal to long'() {
		given: 'an IntOperand with a value of 1'
		Operand t = new IntOperand(1)
		
		and: 'a LongOperand with a value of 2L'
		Operand u = new LongOperand(2L)
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', int, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(2)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'long less than or equal to BigDecimal'() {
		given: 'a LongOperand with a value of 1L'
		Operand t = new LongOperand(1L)
		
		and: 'a BigDecimal Operand with a value of 2'
		Operand u = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', long, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(2L)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'long less than or equal to BigInteger'() {
		given: 'a LongOperand with a value of 1L'
		Operand t = new LongOperand(1L)
		
		and: 'a BigInteger Operand with a value of 2'
		Operand u = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', long, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(2L)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'long less than or equal to double'() {
		given: 'a LongOperand with a value of 1L'
		Operand t = new LongOperand(1L)
		
		and: 'a DoubleOperand with a value of 2.0d'
		Operand u = new DoubleOperand(2.0d)
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', long, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(2L)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'long less than or equal to float'() {
		given: 'a LongOperand with a value of 1L'
		Operand t = new LongOperand(1L)
		
		and: 'a FloatOperand with a value of 2.0f'
		Operand u = new FloatOperand(2.0f)
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', long, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(2L)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'long less than or equal to int'() {
		given: 'a LongOperand with a value of 1L'
		Operand t = new LongOperand(1L)
		
		and: 'an IntOperand with a value of 2'
		Operand u = new IntOperand(2)
		
		and: 'function to check if one is less than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('<=', long, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(2L)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	// greater than - same types
	
	def 'BigDecimals greater than the other'() {
		given: 'two BigDecimal Operands with values 2 and 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('2'))
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to check if one is greater than another of two BigDecimals'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', BigDecimal, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigIntegers greater than the other'() {
		given: 'two BigInteger Operands with values 2 and 1'
		Operand t = new Operand(BigInteger, new BigInteger('2'))
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to check if one is greater than another of two BigIntegers'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', BigInteger, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'doubles greater than the other'() {
		given: 'two DoubleOperands with values 2.0d and 1.0d'
		Operand t = new DoubleOperand(2.0d)
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to check if one is greater than another of two doubles'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', double, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'floats greater than the other'() {
		given: 'two FloatOperands with values 2.0f and 1.0f'
		Operand t = new FloatOperand(2.0f)
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to check if one is greater than another of two floats'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', float, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'ints greater than the other'() {
		given: 'two IntOperands with values 2 and 1'
		Operand t = new IntOperand(2)
		Operand u = new IntOperand(1)
		
		and: 'function to check if one is greater than another of two ints'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', int, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'longs greater than the other'() {
		given: 'two LongOperands with values 2L and 1L'
		Operand t = new LongOperand(2L)
		Operand u = new LongOperand(1L)
		
		and: 'function to check if one is greater than another of two longs'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', long, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	// greater than - type promotions
	
	def 'BigDecimal greater than BigInteger'() {
		given: 'a BigDecimal Operand with a value of 2'
		Operand t = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', BigDecimal, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigDecimal greater than double'() {
		given: 'a BigDecimal Operand with a value of 2'
		Operand t = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'a DoubleOperand with a value of 1.0d'
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', BigDecimal, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigDecimal greater than float'() {
		given: 'a BigDecimal Operand with a value of 2'
		Operand t = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'a FloatOperand with a value of 1.0f'
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', BigDecimal, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigDecimal greater than int'() {
		given: 'a BigDecimal Operand with a value of 2'
		Operand t = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', BigDecimal, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigDecimal greater than long'() {
		given: 'a BigDecimal Operand with a value of 2'
		Operand t = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', BigDecimal, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigInteger greater than BigDecimal'() {
		given: 'a BigInteger Operand with a value of 2'
		Operand t = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'a BigDecimal Operand with a value of 1'
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', BigInteger, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigInteger greater than double'() {
		given: 'a BigInteger Operand with a value of 2'
		Operand t = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'a DoubleOperand with a value of 1.0d'
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', BigInteger, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigInteger greater than float'() {
		given: 'a BigInteger Operand with a value of 2'
		Operand t = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'a FloatOperand with a value of 1.0f'
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', BigInteger, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigInteger greater than int'() {
		given: 'a BigInteger Operand with a value of 2'
		Operand t = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', BigInteger, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'BigInteger greater than long'() {
		given: 'a BigInteger Operand with a value of 2'
		Operand t = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', BigInteger, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'double greater than BigDecimal'() {
		given: 'a DoubleOperand with a value of 2.0d'
		Operand t = new DoubleOperand(2.0d)
		
		and: 'a BigDecimal Operand with a value of 1'
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', double, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'double greater than BigInteger'() {
		given: 'a DoubleOperand with a value of 2.0d'
		Operand t = new DoubleOperand(2.0d)
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', double, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'double greater than float'() {
		given: 'a DoubleOperand with a value of 2.0d'
		Operand t = new DoubleOperand(2.0d)
		
		and: 'a FloatOperand with a value of 1.0f'
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', double, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'double greater than int'() {
		given: 'a DoubleOperand with a value of 2.0d'
		Operand t = new DoubleOperand(2.0d)
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', double, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'double greater than long'() {
		given: 'a DoubleOperand with a value of 2.0d'
		Operand t = new DoubleOperand(2.0d)
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', double, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'float greater than BigDecimal'() {
		given: 'a FloatOperand with a value of 2.0f'
		Operand t = new FloatOperand(2.0f)
		
		and: 'a BigDecimal Operand with a value of 1'
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', float, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'float greater than BigInteger'() {
		given: 'a FloatOperand with a value of 2.0f'
		Operand t = new FloatOperand(2.0f)
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', float, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'float greater than double'() {
		given: 'a FloatOperand with a value of 2.0f'
		Operand t = new FloatOperand(2.0f)
		
		and: 'a DoubleOperand with a value of 1.0d'
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', float, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'float greater than int'() {
		given: 'a FloatOperand with a value of 2.0f'
		Operand t = new FloatOperand(2.0f)
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', float, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'float greater than long'() {
		given: 'a FloatOperand with a value of 2.0f'
		Operand t = new FloatOperand(2.0f)
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', float, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'int greater than BigDecimal'() {
		given: 'an IntOperand with a value of 2'
		Operand t = new IntOperand(2)
		
		and: 'a BigDecimal Operand with a value of 1'
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', int, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'int greater than BigInteger'() {
		given: 'an IntOperand with a value of 2'
		Operand t = new IntOperand(2)
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', int, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'int greater than double'() {
		given: 'an IntOperand with a value of 2'
		Operand t = new IntOperand(2)
		
		and: 'a DoubleOperand with a value of 1.0d'
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', int, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'int greater than float'() {
		given: 'an IntOperand with a value of 2'
		Operand t = new IntOperand(2)
		
		and: 'a FloatOperand with a value of 1.0f'
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', int, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'int greater than long'() {
		given: 'an IntOperand with a value of 2'
		Operand t = new IntOperand(2)
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', int, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'long greater than BigDecimal'() {
		given: 'a LongOperand with a value of 2L'
		Operand t = new LongOperand(2L)
		
		and: 'a BigDecimal Operand with a value of 1'
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', long, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'long greater than BigInteger'() {
		given: 'a LongOperand with a value of 2L'
		Operand t = new LongOperand(2L)
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', long, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'long greater than double'() {
		given: 'a LongOperand with a value of 2L'
		Operand t = new LongOperand(2L)
		
		and: 'a DoubleOperand with a value of 1.0d'
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', long, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'long greater than float'() {
		given: 'a LongOperand with a value of 2L'
		Operand t = new LongOperand(2L)
		
		and: 'a FloatOperand with a value of 1.0f'
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', long, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'long greater than int'() {
		given: 'a LongOperand with a value of 2L'
		Operand t = new LongOperand(2L)
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to check if one is greater than another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>', long, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	// greater than equal - same types
	
	def 'BigDecimals greater than or equal to the other'() {
		given: 'two BigDecimal Operands with values 2 and 1'
		Operand t = new Operand(BigDecimal, new BigDecimal('2'))
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to check if one is greater than or equal to another of two BigDecimals'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', BigDecimal, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(new BigDecimal('1'))
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'BigIntegers greater than or equal to the other'() {
		given: 'two BigInteger Operands with values 2 and 1'
		Operand t = new Operand(BigInteger, new BigInteger('2'))
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to check if one is greater than or equal to another of two BigIntegers'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', BigInteger, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(new BigInteger('1'))
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'doubles greater than or equal to the other'() {
		given: 'two DoubleOperands with values 2.0d and 1.0d'
		Operand t = new DoubleOperand(2.0d)
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to check if one is greater than or equal to another of two doubles'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', double, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(1.0d)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'floats greater than or equal to the other'() {
		given: 'two FloatOperands with values 2.0f and 1.0f'
		Operand t = new FloatOperand(2.0f)
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to check if one is greater than or equal to another of two floats'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', float, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(1.0f)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'ints greater than or equal to the other'() {
		given: 'two IntOperands with values 2 and 1'
		Operand t = new IntOperand(2)
		Operand u = new IntOperand(1)
		
		and: 'function to check if one is greater than or equal to another of two ints'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', int, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(1)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'longs greater than or equal to the other'() {
		given: 'two LongOperands with values 1L and 2L'
		Operand t = new LongOperand(2L)
		Operand u = new LongOperand(1L)
		
		and: 'function to check if one is greater than or equal to another of two longs'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', long, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(1L)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	// greater than equal - type promotions
	
	def 'BigDecimal greater than or equal to BigInteger'() {
		given: 'a BigDecimal Operand with a value of 2'
		Operand t = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', BigDecimal, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(new BigDecimal('1'))
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'BigDecimal greater than or equal to double'() {
		given: 'a BigDecimal Operand with a value of 2'
		Operand t = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'a DoubleOperand with a value of 1.0d'
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', BigDecimal, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(new BigDecimal('1'))
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'BigDecimal greater than or equal to float'() {
		given: 'a BigDecimal Operand with a value of 2'
		Operand t = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'a FloatOperand with a value of 1.0f'
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', BigDecimal, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(new BigDecimal('1'))
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'BigDecimal greater than or equal to int'() {
		given: 'a BigDecimal Operand with a value of 2'
		Operand t = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', BigDecimal, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(new BigDecimal('1'))
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'BigDecimal greater than or equal to long'() {
		given: 'a BigDecimal Operand with a value of 2'
		Operand t = new Operand(BigDecimal, new BigDecimal('2'))
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', BigDecimal, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(new BigDecimal('1'))
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'BigInteger greater than or equal to BigDecimal'() {
		given: 'a BigInteger Operand with a value of 2'
		Operand t = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'a BigDecimal Operand with a value of 1'
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', BigInteger, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(new BigInteger('1'))
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'BigInteger greater than or equal to double'() {
		given: 'a BigInteger Operand with a value of 2'
		Operand t = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'a DoubleOperand with a value of 1.0d'
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', BigInteger, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(new BigInteger('1'))
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'BigInteger greater than or equal to float'() {
		given: 'a BigInteger Operand with a value of 2'
		Operand t = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'a FloatOperand with a value of 1.0f'
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', BigInteger, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(new BigInteger('1'))
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'BigInteger greater than or equal to int'() {
		given: 'a BigInteger Operand with a value of 2'
		Operand t = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', BigInteger, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(new BigInteger('1'))
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'BigInteger greater than or equal to long'() {
		given: 'a BigInteger Operand with a value of 2'
		Operand t = new Operand(BigInteger, new BigInteger('2'))
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', BigInteger, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(new BigInteger('1'))
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'double greater than or equal to BigDecimal'() {
		given: 'a DoubleOperand with a value of 2.0d'
		Operand t = new DoubleOperand(2.0d)
		
		and: 'a BigDecimal Operand with a value of 1'
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', double, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(1.0d)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'double greater than or equal to BigInteger'() {
		given: 'a DoubleOperand with a value of 2.0d'
		Operand t = new DoubleOperand(2.0d)
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', double, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(1.0d)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'double greater than or equal to float'() {
		given: 'a DoubleOperand with a value of 2.0d'
		Operand t = new DoubleOperand(2.0d)
		
		and: 'a FloatOperand with a value of 1.0f'
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', double, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(1.0d)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'double greater than or equal to int'() {
		given: 'a DoubleOperand with a value of 2.0d'
		Operand t = new DoubleOperand(2.0d)
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', double, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(1.0d)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'double greater than or equal to long'() {
		given: 'a DoubleOperand with a value of 2.0d'
		Operand t = new DoubleOperand(2.0d)
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', double, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(1.0d)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'float greater than or equal to BigDecimal'() {
		given: 'a FloatOperand with a value of 2.0f'
		Operand t = new FloatOperand(2.0f)
		
		and: 'a BigDecimal Operand with a value of 1'
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', float, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(1.0f)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'float greater than or equal to BigInteger'() {
		given: 'a FloatOperand with a value of 2.0f'
		Operand t = new FloatOperand(2.0f)
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', float, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(1.0f)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'float greater than or equal to double'() {
		given: 'a FloatOperand with a value of 2.0f'
		Operand t = new FloatOperand(2.0f)
		
		and: 'a DoubleOperand with a value of 1.0d'
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', float, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(1.0f)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'float greater than or equal to int'() {
		given: 'a FloatOperand with a value of 2.0f'
		Operand t = new FloatOperand(2.0f)
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', float, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(1.0f)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'float greater than or equal to long'() {
		given: 'a FloatOperand with a value of 2.0f'
		Operand t = new FloatOperand(2.0f)
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', float, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(1.0f)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'int greater than or equal to BigDecimal'() {
		given: 'an IntOperand with a value of 2'
		Operand t = new IntOperand(2)
		
		and: 'a BigDecimal Operand with a value of 1'
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', int, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(1)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'int greater than or equal to BigInteger'() {
		given: 'an IntOperand with a value of 2'
		Operand t = new IntOperand(2)
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', int, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(1)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'int greater than or equal to double'() {
		given: 'an IntOperand with a value of 2'
		Operand t = new IntOperand(2)
		
		and: 'a DoubleOperand with a value of 1.0d'
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', int, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(1)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'int greater than or equal to float'() {
		given: 'an IntOperand with a value of 2'
		Operand t = new IntOperand(2)
		
		and: 'a FloatOperand with a value of 1.0f'
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', int, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(1)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'int greater than or equal to long'() {
		given: 'an IntOperand with a value of 2'
		Operand t = new IntOperand(2)
		
		and: 'a LongOperand with a value of 1L'
		Operand u = new LongOperand(1L)
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', int, long))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(1)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'long greater than or equal to BigDecimal'() {
		given: 'a LongOperand with a value of 2L'
		Operand t = new LongOperand(2L)
		
		and: 'a BigDecimal Operand with a value of 1'
		Operand u = new Operand(BigDecimal, new BigDecimal('1'))
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', long, BigDecimal))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(1L)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'long greater than or equal to BigInteger'() {
		given: 'a LongOperand with a value of 2L'
		Operand t = new LongOperand(2L)
		
		and: 'a BigInteger Operand with a value of 1'
		Operand u = new Operand(BigInteger, new BigInteger('1'))
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', long, BigInteger))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(1L)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'long greater than or equal to double'() {
		given: 'a LongOperand with a value of 2L'
		Operand t = new LongOperand(2L)
		
		and: 'a DoubleOperand with a value of 1.0d'
		Operand u = new DoubleOperand(1.0d)
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', long, double))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(1L)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'long greater than or equal to float'() {
		given: 'a LongOperand with a value of 2L'
		Operand t = new LongOperand(2L)
		
		and: 'a FloatOperand with a value of 1.0f'
		Operand u = new FloatOperand(1.0f)
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', long, float))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(1L)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	def 'long greater than or equal to int'() {
		given: 'a LongOperand with a value of 2L'
		Operand t = new LongOperand(2L)
		
		and: 'an IntOperand with a value of 1'
		Operand u = new IntOperand(1)
		
		and: 'function to check if one is greater than or equal to another'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('>=', long, int))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
		
		when: 'set to the same value'
		t.setValue(1L)
		result = binaryFunc.getFunction().apply(t, u)
		
		then: 'both are equal'
		result.getValue() == true
	}
	
	// and
	
	def 'Logical AND returns true'() {
		given: 'two BooleanOperands with values true and true'
		Operand t = new BooleanOperand(true)
		Operand u = new BooleanOperand(true)
		
		and: 'function to logical AND\'d two booleans'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('&&', boolean, boolean))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'Logical AND returns false'() {
		given: 'two BooleanOperands with values true and false'
		Operand t = new BooleanOperand(true)
		Operand u = new BooleanOperand(false)
		
		and: 'function to logical AND\'d two booleans'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('&&', boolean, boolean))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is false'
		result.getValue() == false
	}
	
	// or
	
	def 'Logical OR returns true when both sides are true'() {
		given: 'two BooleanOperands with values true and true'
		Operand t = new BooleanOperand(true)
		Operand u = new BooleanOperand(true)
		
		and: 'function to logical OR\'d two booleans'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('||', boolean, boolean))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'Logical OR returns true when only one side is true'() {
		given: 'two BooleanOperands with values true and true'
		Operand t = new BooleanOperand(false)
		Operand u = new BooleanOperand(true)
		
		and: 'function to logical OR\'d two booleans'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('||', boolean, boolean))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'Logical OR returns false when both sides are false'() {
		given: 'two BooleanOperands with values false and true'
		Operand t = new BooleanOperand(false)
		Operand u = new BooleanOperand(false)
		
		and: 'function to logical OR\'d two booleans'
		BinaryFunc binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(
			new BinaryOperatorInfo('||', boolean, boolean))
		
		when: 'function is executed'
		Operand result = binaryFunc.getFunction().apply(t, u)
		
		then: 'result is false'
		result.getValue() == false
	}
	
	// not
	
	def 'Logical NOT returns true when operand is false'() {
		given: 'a BooleanOperand set to false'
		Operand t = new BooleanOperand(false)
		
		and: 'function to logical NOT\'d a boolean'
		UnaryFunc unaryFunc = DefaultFunctions.INSTANCE.getUnaryFunc(
			new UnaryOperatorInfo('!', boolean))
		
		when: 'function is executed'
		Operand result = unaryFunc.getFunction().apply(t)
		
		then: 'result is true'
		result.getValue() == true
	}
	
	def 'Logical NOT returns false when operand is true'() {
		given: 'a BooleanOperand set to true'
		Operand t = new BooleanOperand(true)
		
		and: 'function to logical NOT\'d a boolean'
		UnaryFunc unaryFunc = DefaultFunctions.INSTANCE.getUnaryFunc(
			new UnaryOperatorInfo('!', boolean))
		
		when: 'function is executed'
		Operand result = unaryFunc.getFunction().apply(t)
		
		then: 'result is false'
		result.getValue() == false
	}
}
