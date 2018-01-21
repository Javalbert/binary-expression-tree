/*
   Copyright 2018 Albert Shun-Dat Chan

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */
package com.javalbert.biexprtree;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.apache.commons.lang3.StringUtils;

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
				new BinaryOperatorInfo<>("+", BigInteger.class, BigInteger.class),
				this::addBigInteger
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
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("+", String.class, String.class),
				this::concatStrings
				));
		
		// add - type promotions
		//
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("+", BigDecimal.class, BigInteger.class),
				this::addBigDecimalAndBigInteger
				));
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
				new BinaryOperatorInfo<>("+", BigInteger.class, int.class),
				this::addBigIntegerAndInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("+", BigInteger.class, long.class),
				this::addBigIntegerAndLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("+", double.class, BigInteger.class),
				this::addDoubleAndBigInteger
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
				new BinaryOperatorInfo<>("+", float.class, BigInteger.class),
				this::addFloatAndBigInteger
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
				new BinaryOperatorInfo<>("-", BigInteger.class, BigInteger.class),
				this::subtractBigInteger
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
				new BinaryOperatorInfo<>("-", BigDecimal.class, BigInteger.class),
				this::subtractBigIntegerFromBigDecimal
				));
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
				new BinaryOperatorInfo<>("-", BigInteger.class, BigDecimal.class),
				this::subtractBigDecimalFromBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", BigInteger.class, double.class),
				this::subtractDoubleFromBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", BigInteger.class, float.class),
				this::subtractFloatFromBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", BigInteger.class, int.class),
				this::subtractIntFromBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", BigInteger.class, long.class),
				this::subtractLongFromBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", double.class, BigDecimal.class),
				this::subtractBigDecimalFromDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("-", double.class, BigInteger.class),
				this::subtractBigIntegerFromDouble
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
				new BinaryOperatorInfo<>("-", float.class, BigInteger.class),
				this::subtractBigIntegerFromFloat
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
				new BinaryOperatorInfo<>("-", int.class, BigInteger.class),
				this::subtractBigIntegerFromInt
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
				new BinaryOperatorInfo<>("-", long.class, BigInteger.class),
				this::subtractBigIntegerFromLong
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
				new BinaryOperatorInfo<>("*", BigInteger.class, BigInteger.class),
				this::multiplyBigInteger
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
				new BinaryOperatorInfo<>("*", BigDecimal.class, BigInteger.class),
				this::multiplyBigDecimalAndBigInteger
				));
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
				new BinaryOperatorInfo<>("*", BigInteger.class, int.class),
				this::multiplyBigIntegerAndInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("*", BigInteger.class, long.class),
				this::multiplyBigIntegerAndLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("*", double.class, BigInteger.class),
				this::multiplyDoubleAndBigInteger
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
				new BinaryOperatorInfo<>("*", float.class, BigInteger.class),
				this::multiplyFloatAndBigInteger
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
				new BinaryOperatorInfo<>("/", BigInteger.class, BigInteger.class),
				this::divideBigInteger
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
				new BinaryOperatorInfo<>("/", BigDecimal.class, BigInteger.class),
				this::divideBigDecimalByBigInteger
				));
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
				new BinaryOperatorInfo<>("/", BigInteger.class, BigDecimal.class),
				this::divideBigIntegerByBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", BigInteger.class, double.class),
				this::divideBigIntegerByDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", BigInteger.class, float.class),
				this::divideBigIntegerByFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", BigInteger.class, int.class),
				this::divideBigIntegerByInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", BigInteger.class, long.class),
				this::divideBigIntegerByLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", double.class, BigDecimal.class),
				this::divideDoubleByBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("/", double.class, BigInteger.class),
				this::divideDoubleByBigInteger
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
				new BinaryOperatorInfo<>("/", float.class, BigInteger.class),
				this::divideFloatByBigInteger
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
				new BinaryOperatorInfo<>("/", int.class, BigInteger.class),
				this::divideIntByBigInteger
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
				new BinaryOperatorInfo<>("/", long.class, BigInteger.class),
				this::divideLongByBigInteger
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
				new BinaryOperatorInfo<>("%", BigInteger.class, BigInteger.class),
				this::modBigInteger
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
				new BinaryOperatorInfo<>("%", BigDecimal.class, BigInteger.class),
				this::bigDecimalModBigInteger
				));
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
				new BinaryOperatorInfo<>("%", BigInteger.class, BigDecimal.class),
				this::bigIntegerModBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", BigInteger.class, double.class),
				this::bigIntegerModDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", BigInteger.class, float.class),
				this::bigIntegerModFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", BigInteger.class, int.class),
				this::bigIntegerModInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", BigInteger.class, long.class),
				this::bigIntegerModLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", double.class, BigDecimal.class),
				this::doubleModBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("%", double.class, BigInteger.class),
				this::doubleModBigInteger
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
				new BinaryOperatorInfo<>("%", float.class, BigInteger.class),
				this::floatModBigInteger
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
				new BinaryOperatorInfo<>("%", int.class, BigInteger.class),
				this::intModBigInteger
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
				new BinaryOperatorInfo<>("%", long.class, BigInteger.class),
				this::longModBigInteger
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
				new BinaryOperatorInfo<>("**", BigInteger.class, BigInteger.class),
				this::powerBigInteger
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
				new BinaryOperatorInfo<>("**", BigDecimal.class, BigInteger.class),
				this::bigDecimalPowerBigInteger
				));
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
				new BinaryOperatorInfo<>("**", BigInteger.class, BigDecimal.class),
				this::bigIntegerPowerBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", BigInteger.class, double.class),
				this::bigIntegerPowerDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", BigInteger.class, float.class),
				this::bigIntegerPowerFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", BigInteger.class, int.class),
				this::bigIntegerPowerInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", BigInteger.class, long.class),
				this::bigIntegerPowerLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", double.class, BigDecimal.class),
				this::doublePowerBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("**", double.class, BigInteger.class),
				this::doublePowerBigInteger
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
				new BinaryOperatorInfo<>("**", float.class, BigInteger.class),
				this::floatPowerBigInteger
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
				new BinaryOperatorInfo<>("**", int.class, BigInteger.class),
				this::intPowerBigInteger
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
				new BinaryOperatorInfo<>("**", long.class, BigInteger.class),
				this::longPowerBigInteger
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
				new UnaryOperatorInfo<>("-", BigInteger.class),
				this::negateBigInteger
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
		
		// equals - same types
		//
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("=", BigDecimal.class, BigDecimal.class),
				this::bigDecimalsAreEqual
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("=", BigInteger.class, BigInteger.class),
				this::bigIntegersAreEqual
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("=", double.class, double.class),
				this::doublesAreEqual
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("=", float.class, float.class),
				this::floatsAreEqual
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("=", int.class, int.class),
				this::intsAreEqual
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("=", long.class, long.class),
				this::longsAreEqual
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("=", String.class, String.class),
				this::stringsAreEqual
				));
		
		// equals - type promotions
		//
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("=", BigDecimal.class, BigInteger.class),
				this::bigDecimalEqualsToBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("=", BigDecimal.class, double.class),
				this::bigDecimalEqualsToDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("=", BigDecimal.class, float.class),
				this::bigDecimalEqualsToFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("=", BigDecimal.class, int.class),
				this::bigDecimalEqualsToInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("=", BigDecimal.class, long.class),
				this::bigDecimalEqualsToLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("=", double.class, BigInteger.class),
				this::doubleEqualsToBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("=", double.class, float.class),
				this::doubleEqualsToFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("=", double.class, int.class),
				this::doubleEqualsToInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("=", double.class, long.class),
				this::doubleEqualsToLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("=", float.class, BigInteger.class),
				this::floatEqualsToBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("=", float.class, int.class),
				this::floatEqualsToInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("=", float.class, long.class),
				this::floatEqualsToLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("=", BigInteger.class, int.class),
				this::bigIntegerEqualsToInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("=", BigInteger.class, long.class),
				this::bigIntegerEqualsToLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("=", long.class, int.class),
				this::longEqualsToInt
				));
		
		// not equals - same types
		//
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("!=", BigDecimal.class, BigDecimal.class),
				this::bigDecimalsAreNotEqual
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("!=", BigInteger.class, BigInteger.class),
				this::bigIntegersAreNotEqual
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("!=", double.class, double.class),
				this::doublesAreNotEqual
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("!=", float.class, float.class),
				this::floatsAreNotEqual
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("!=", int.class, int.class),
				this::intsAreNotEqual
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("!=", long.class, long.class),
				this::longsAreNotEqual
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("!=", String.class, String.class),
				this::stringsAreNotEqual
				));
		
		// not equals - type promotions
		//
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("!=", BigDecimal.class, BigInteger.class),
				this::bigDecimalNotEqualToBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("!=", BigDecimal.class, double.class),
				this::bigDecimalNotEqualToDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("!=", BigDecimal.class, float.class),
				this::bigDecimalNotEqualToFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("!=", BigDecimal.class, int.class),
				this::bigDecimalNotEqualToInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("!=", BigDecimal.class, long.class),
				this::bigDecimalNotEqualToLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("!=", double.class, BigInteger.class),
				this::doubleNotEqualToBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("!=", double.class, float.class),
				this::doubleNotEqualToFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("!=", double.class, int.class),
				this::doubleNotEqualToInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("!=", double.class, long.class),
				this::doubleNotEqualToLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("!=", float.class, BigInteger.class),
				this::floatNotEqualToBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("!=", float.class, int.class),
				this::floatNotEqualToInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("!=", float.class, long.class),
				this::floatNotEqualToLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("!=", BigInteger.class, int.class),
				this::bigIntegerNotEqualToInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("!=", BigInteger.class, long.class),
				this::bigIntegerNotEqualToLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("!=", long.class, int.class),
				this::longNotEqualToInt
				));
		
		// less than - same types
		//
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", BigDecimal.class, BigDecimal.class),
				this::lessThanBigDecimals
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", BigInteger.class, BigInteger.class),
				this::lessThanBigIntegers
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", double.class, double.class),
				this::lessThanDoubles
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", float.class, float.class),
				this::lessThanFloats
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", int.class, int.class),
				this::lessThanInts
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", long.class, long.class),
				this::lessThanLongs
				));

		// less than - type promotions
		//
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", BigDecimal.class, BigInteger.class),
				this::bigDecimalLessThanBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", BigDecimal.class, double.class),
				this::bigDecimalLessThanDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", BigDecimal.class, float.class),
				this::bigDecimalLessThanFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", BigDecimal.class, int.class),
				this::bigDecimalLessThanInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", BigDecimal.class, long.class),
				this::bigDecimalLessThanLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", BigInteger.class, BigDecimal.class),
				this::bigIntegerLessThanBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", BigInteger.class, double.class),
				this::bigIntegerLessThanDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", BigInteger.class, float.class),
				this::bigIntegerLessThanFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", BigInteger.class, int.class),
				this::bigIntegerLessThanInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", BigInteger.class, long.class),
				this::bigIntegerLessThanLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", double.class, BigDecimal.class),
				this::doubleLessThanBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", double.class, BigInteger.class),
				this::doubleLessThanBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", double.class, float.class),
				this::doubleLessThanFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", double.class, int.class),
				this::doubleLessThanInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", double.class, long.class),
				this::doubleLessThanLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", float.class, BigDecimal.class),
				this::floatLessThanBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", float.class, BigInteger.class),
				this::floatLessThanBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", float.class, double.class),
				this::floatLessThanDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", float.class, int.class),
				this::floatLessThanInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", float.class, long.class),
				this::floatLessThanLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", int.class, BigDecimal.class),
				this::intLessThanBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", int.class, BigInteger.class),
				this::intLessThanBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", int.class, double.class),
				this::intLessThanDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", int.class, float.class),
				this::intLessThanFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", int.class, long.class),
				this::intLessThanLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", long.class, BigDecimal.class),
				this::longLessThanBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", long.class, BigInteger.class),
				this::longLessThanBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", long.class, double.class),
				this::longLessThanDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", long.class, float.class),
				this::longLessThanFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<", long.class, int.class),
				this::longLessThanInt
				));
		
		// less than equal - same types
		//
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", BigDecimal.class, BigDecimal.class),
				this::lessThanEqualBigDecimals
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", BigInteger.class, BigInteger.class),
				this::lessThanEqualBigIntegers
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", double.class, double.class),
				this::lessThanEqualDoubles
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", float.class, float.class),
				this::lessThanEqualFloats
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", int.class, int.class),
				this::lessThanEqualInts
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", long.class, long.class),
				this::lessThanEqualLongs
				));

		// less than equal - type promotions
		//
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", BigDecimal.class, BigInteger.class),
				this::bigDecimalLessThanEqualBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", BigDecimal.class, double.class),
				this::bigDecimalLessThanEqualDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", BigDecimal.class, float.class),
				this::bigDecimalLessThanEqualFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", BigDecimal.class, int.class),
				this::bigDecimalLessThanEqualInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", BigDecimal.class, long.class),
				this::bigDecimalLessThanEqualLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", BigInteger.class, BigDecimal.class),
				this::bigIntegerLessThanEqualBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", BigInteger.class, double.class),
				this::bigIntegerLessThanEqualDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", BigInteger.class, float.class),
				this::bigIntegerLessThanEqualFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", BigInteger.class, int.class),
				this::bigIntegerLessThanEqualInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", BigInteger.class, long.class),
				this::bigIntegerLessThanEqualLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", double.class, BigDecimal.class),
				this::doubleLessThanEqualBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", double.class, BigInteger.class),
				this::doubleLessThanEqualBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", double.class, float.class),
				this::doubleLessThanEqualFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", double.class, int.class),
				this::doubleLessThanEqualInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", double.class, long.class),
				this::doubleLessThanEqualLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", float.class, BigDecimal.class),
				this::floatLessThanEqualBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", float.class, BigInteger.class),
				this::floatLessThanEqualBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", float.class, double.class),
				this::floatLessThanEqualDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", float.class, int.class),
				this::floatLessThanEqualInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", float.class, long.class),
				this::floatLessThanEqualLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", int.class, BigDecimal.class),
				this::intLessThanEqualBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", int.class, BigInteger.class),
				this::intLessThanEqualBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", int.class, double.class),
				this::intLessThanEqualDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", int.class, float.class),
				this::intLessThanEqualFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", int.class, long.class),
				this::intLessThanEqualLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", long.class, BigDecimal.class),
				this::longLessThanEqualBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", long.class, BigInteger.class),
				this::longLessThanEqualBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", long.class, double.class),
				this::longLessThanEqualDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", long.class, float.class),
				this::longLessThanEqualFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("<=", long.class, int.class),
				this::longLessThanEqualInt
				));
		
		// greater than - same types
		//
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", BigDecimal.class, BigDecimal.class),
				this::greaterThanBigDecimals
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", BigInteger.class, BigInteger.class),
				this::greaterThanBigIntegers
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", double.class, double.class),
				this::greaterThanDoubles
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", float.class, float.class),
				this::greaterThanFloats
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", int.class, int.class),
				this::greaterThanInts
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", long.class, long.class),
				this::greaterThanLongs
				));

		// greater than - type promotions
		//
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", BigDecimal.class, BigInteger.class),
				this::bigDecimalGreaterThanBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", BigDecimal.class, double.class),
				this::bigDecimalGreaterThanDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", BigDecimal.class, float.class),
				this::bigDecimalGreaterThanFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", BigDecimal.class, int.class),
				this::bigDecimalGreaterThanInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", BigDecimal.class, long.class),
				this::bigDecimalGreaterThanLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", BigInteger.class, BigDecimal.class),
				this::bigIntegerGreaterThanBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", BigInteger.class, double.class),
				this::bigIntegerGreaterThanDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", BigInteger.class, float.class),
				this::bigIntegerGreaterThanFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", BigInteger.class, int.class),
				this::bigIntegerGreaterThanInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", BigInteger.class, long.class),
				this::bigIntegerGreaterThanLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", double.class, BigDecimal.class),
				this::doubleGreaterThanBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", double.class, BigInteger.class),
				this::doubleGreaterThanBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", double.class, float.class),
				this::doubleGreaterThanFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", double.class, int.class),
				this::doubleGreaterThanInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", double.class, long.class),
				this::doubleGreaterThanLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", float.class, BigDecimal.class),
				this::floatGreaterThanBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", float.class, BigInteger.class),
				this::floatGreaterThanBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", float.class, double.class),
				this::floatGreaterThanDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", float.class, int.class),
				this::floatGreaterThanInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", float.class, long.class),
				this::floatGreaterThanLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", int.class, BigDecimal.class),
				this::intGreaterThanBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", int.class, BigInteger.class),
				this::intGreaterThanBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", int.class, double.class),
				this::intGreaterThanDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", int.class, float.class),
				this::intGreaterThanFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", int.class, long.class),
				this::intGreaterThanLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", long.class, BigDecimal.class),
				this::longGreaterThanBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", long.class, BigInteger.class),
				this::longGreaterThanBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", long.class, double.class),
				this::longGreaterThanDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", long.class, float.class),
				this::longGreaterThanFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">", long.class, int.class),
				this::longGreaterThanInt
				));
		
		// greater than equal - same types
		//
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", BigDecimal.class, BigDecimal.class),
				this::greaterThanEqualBigDecimals
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", BigInteger.class, BigInteger.class),
				this::greaterThanEqualBigIntegers
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", double.class, double.class),
				this::greaterThanEqualDoubles
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", float.class, float.class),
				this::greaterThanEqualFloats
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", int.class, int.class),
				this::greaterThanEqualInts
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", long.class, long.class),
				this::greaterThanEqualLongs
				));

		// greater than equal - type promotions
		//
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", BigDecimal.class, BigInteger.class),
				this::bigDecimalGreaterThanEqualBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", BigDecimal.class, double.class),
				this::bigDecimalGreaterThanEqualDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", BigDecimal.class, float.class),
				this::bigDecimalGreaterThanEqualFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", BigDecimal.class, int.class),
				this::bigDecimalGreaterThanEqualInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", BigDecimal.class, long.class),
				this::bigDecimalGreaterThanEqualLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", BigInteger.class, BigDecimal.class),
				this::bigIntegerGreaterThanEqualBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", BigInteger.class, double.class),
				this::bigIntegerGreaterThanEqualDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", BigInteger.class, float.class),
				this::bigIntegerGreaterThanEqualFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", BigInteger.class, int.class),
				this::bigIntegerGreaterThanEqualInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", BigInteger.class, long.class),
				this::bigIntegerGreaterThanEqualLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", double.class, BigDecimal.class),
				this::doubleGreaterThanEqualBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", double.class, BigInteger.class),
				this::doubleGreaterThanEqualBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", double.class, float.class),
				this::doubleGreaterThanEqualFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", double.class, int.class),
				this::doubleGreaterThanEqualInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", double.class, long.class),
				this::doubleGreaterThanEqualLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", float.class, BigDecimal.class),
				this::floatGreaterThanEqualBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", float.class, BigInteger.class),
				this::floatGreaterThanEqualBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", float.class, double.class),
				this::floatGreaterThanEqualDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", float.class, int.class),
				this::floatGreaterThanEqualInt
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", float.class, long.class),
				this::floatGreaterThanEqualLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", int.class, BigDecimal.class),
				this::intGreaterThanEqualBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", int.class, BigInteger.class),
				this::intGreaterThanEqualBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", int.class, double.class),
				this::intGreaterThanEqualDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", int.class, float.class),
				this::intGreaterThanEqualFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", int.class, long.class),
				this::intGreaterThanEqualLong
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", long.class, BigDecimal.class),
				this::longGreaterThanEqualBigDecimal
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", long.class, BigInteger.class),
				this::longGreaterThanEqualBigInteger
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", long.class, double.class),
				this::longGreaterThanEqualDouble
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", long.class, float.class),
				this::longGreaterThanEqualFloat
				));
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>(">=", long.class, int.class),
				this::longGreaterThanEqualInt
				));
		
		// and
		//
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("&&", boolean.class, boolean.class),
				this::logicalAnd
				));
		
		// or
		//
		super.register(new BinaryFunc<>(
				new BinaryOperatorInfo<>("||", boolean.class, boolean.class),
				this::logicalOr
				));
		
		// not
		//
		super.register(new UnaryFunc<>(
				new UnaryOperatorInfo<>("!", boolean.class),
				this::logicalNot
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
	
	private Operand<BigInteger> addBigInteger(Operand<BigInteger> a, Operand<BigInteger> b) {
		return new Operand<>(BigInteger.class, a.getValue().add(b.getValue()));
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
	
	private Operand<String> concatStrings(Operand<String> a, Operand<String> b) {
		return new Operand<>(String.class, a.getValue() + b.getValue());
	}
	
	// add - type promotions
	
	private Operand<BigDecimal> addBigDecimalAndBigInteger(Operand<BigDecimal> a, Operand<BigInteger> b) {
		return new Operand<>(BigDecimal.class, a.getValue().add(new BigDecimal(b.getValue())));
	}
	
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
	
	private Operand<BigInteger> addBigIntegerAndInt(Operand<BigInteger> a, Operand<Integer> b) {
		return new Operand<>(BigInteger.class, a.getValue().add(BigInteger.valueOf(((IntOperand)b).getIntValue())));
	}
	
	private Operand<BigInteger> addBigIntegerAndLong(Operand<BigInteger> a, Operand<Long> b) {
		return new Operand<>(BigInteger.class, a.getValue().add(BigInteger.valueOf(((LongOperand)b).getLongValue())));
	}
	
	private Operand<Double> addDoubleAndBigInteger(Operand<Double> a, Operand<BigInteger> b) {
		return new DoubleOperand(((DoubleOperand)a).getDoubleValue() + b.getValue().doubleValue());
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
	
	private Operand<Float> addFloatAndBigInteger(Operand<Float> a, Operand<BigInteger> b) {
		return new FloatOperand(((FloatOperand)a).getFloatValue() + a.getValue().floatValue());
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
	
	private Operand<BigInteger> subtractBigInteger(Operand<BigInteger> a, Operand<BigInteger> b) {
		return new Operand<>(BigInteger.class, a.getValue().subtract(b.getValue()));
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
	
	private Operand<BigDecimal> subtractBigIntegerFromBigDecimal(Operand<BigDecimal> a, Operand<BigInteger> b) {
		return new Operand<>(BigDecimal.class, a.getValue().subtract(new BigDecimal(b.getValue())));
	}
	
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
	
	private Operand<BigDecimal> subtractBigDecimalFromBigInteger(Operand<BigInteger> a, Operand<BigDecimal> b) {
		return new Operand<>(BigDecimal.class, new BigDecimal(a.getValue()).subtract(b.getValue()));
	}
	
	private Operand<Double> subtractDoubleFromBigInteger(Operand<BigInteger> a, Operand<Double> b) {
		return new DoubleOperand(a.getValue().doubleValue() - ((DoubleOperand)b).getDoubleValue());
	}
	
	private Operand<Float> subtractFloatFromBigInteger(Operand<BigInteger> a, Operand<Float> b) {
		return new FloatOperand(a.getValue().floatValue() - ((FloatOperand)b).getFloatValue());
	}
	
	private Operand<BigInteger> subtractIntFromBigInteger(Operand<BigInteger> a, Operand<Integer> b) {
		return new Operand<>(BigInteger.class, a.getValue().subtract(BigInteger.valueOf(((IntOperand)b).getIntValue())));
	}
	
	private Operand<BigInteger> subtractLongFromBigInteger(Operand<BigInteger> a, Operand<Long> b) {
		return new Operand<>(BigInteger.class, a.getValue().subtract(BigInteger.valueOf(((LongOperand)b).getLongValue())));
	}
	
	private Operand<BigDecimal> subtractBigDecimalFromDouble(Operand<Double> a, Operand<BigDecimal> b) {
		return new Operand<>(BigDecimal.class, BigDecimal.valueOf(((DoubleOperand)a).getDoubleValue()).stripTrailingZeros().subtract(b.getValue()));
	}
	
	private Operand<Double> subtractBigIntegerFromDouble(Operand<Double> a, Operand<BigInteger> b) {
		return new DoubleOperand(((DoubleOperand)a).getValue() - b.getValue().doubleValue());
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
	
	private Operand<Float> subtractBigIntegerFromFloat(Operand<Float> a, Operand<BigInteger> b) {
		return new FloatOperand(((FloatOperand)a).getFloatValue() - b.getValue().floatValue());
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
	
	private Operand<BigInteger> subtractBigIntegerFromInt(Operand<Integer> a, Operand<BigInteger> b) {
		return new Operand<>(BigInteger.class, BigInteger.valueOf(((IntOperand)a).getIntValue()).subtract(b.getValue()));
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
	
	private Operand<BigInteger> subtractBigIntegerFromLong(Operand<Long> a, Operand<BigInteger> b) {
		return new Operand<>(BigInteger.class, BigInteger.valueOf(((LongOperand)a).getLongValue()).subtract(b.getValue()));
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
	
	private Operand<BigInteger> multiplyBigInteger(Operand<BigInteger> a, Operand<BigInteger> b) {
		return new Operand<>(BigInteger.class, a.getValue().multiply(b.getValue()));
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
	
	private Operand<BigDecimal> multiplyBigDecimalAndBigInteger(Operand<BigDecimal> a, Operand<BigInteger> b) {
		return new Operand<>(BigDecimal.class, a.getValue().multiply(new BigDecimal(b.getValue())));
	}
	
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
	
	private Operand<BigInteger> multiplyBigIntegerAndInt(Operand<BigInteger> a, Operand<Integer> b) {
		return new Operand<>(BigInteger.class, a.getValue().multiply(BigInteger.valueOf(((IntOperand)b).getIntValue())));
	}
	
	private Operand<BigInteger> multiplyBigIntegerAndLong(Operand<BigInteger> a, Operand<Long> b) {
		return new Operand<>(BigInteger.class, a.getValue().multiply(BigInteger.valueOf(((LongOperand)b).getLongValue())));
	}
	
	private Operand<Double> multiplyDoubleAndBigInteger(Operand<Double> a, Operand<BigInteger> b) {
		return new DoubleOperand(((DoubleOperand)a).getDoubleValue() * b.getValue().doubleValue());
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
	
	private Operand<Float> multiplyFloatAndBigInteger(Operand<Float> a, Operand<BigInteger> b) {
		return new FloatOperand(((FloatOperand)a).getFloatValue() * a.getValue().floatValue());
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
	
	private Operand<BigInteger> divideBigInteger(Operand<BigInteger> a, Operand<BigInteger> b) {
		return new Operand<>(BigInteger.class, a.getValue().divide(b.getValue()));
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
	
	private Operand<BigDecimal> divideBigDecimalByBigInteger(Operand<BigDecimal> a, Operand<BigInteger> b) {
		return new Operand<>(BigDecimal.class, a.getValue().divide(new BigDecimal(b.getValue())));
	}
	
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
	
	private Operand<BigDecimal> divideBigIntegerByBigDecimal(Operand<BigInteger> a, Operand<BigDecimal> b) {
		return new Operand<>(BigDecimal.class, new BigDecimal(a.getValue()).divide(b.getValue()));
	}
	
	private Operand<Double> divideBigIntegerByDouble(Operand<BigInteger> a, Operand<Double> b) {
		return new DoubleOperand(a.getValue().doubleValue() / ((DoubleOperand)b).getDoubleValue());
	}
	
	private Operand<Float> divideBigIntegerByFloat(Operand<BigInteger> a, Operand<Float> b) {
		return new FloatOperand(a.getValue().floatValue() / ((FloatOperand)b).getFloatValue());
	}
	
	private Operand<BigInteger> divideBigIntegerByInt(Operand<BigInteger> a, Operand<Integer> b) {
		return new Operand<>(BigInteger.class, a.getValue().divide(BigInteger.valueOf(((IntOperand)b).getIntValue())));
	}
	
	private Operand<BigInteger> divideBigIntegerByLong(Operand<BigInteger> a, Operand<Long> b) {
		return new Operand<>(BigInteger.class, a.getValue().divide(BigInteger.valueOf(((LongOperand)b).getLongValue())));
	}
	
	private Operand<BigDecimal> divideDoubleByBigDecimal(Operand<Double> a, Operand<BigDecimal> b) {
		return new Operand<>(BigDecimal.class, BigDecimal.valueOf(((DoubleOperand)a).getDoubleValue()).stripTrailingZeros().divide(b.getValue()));
	}
	
	private Operand<Double> divideDoubleByBigInteger(Operand<Double> a, Operand<BigInteger> b) {
		return new DoubleOperand(((DoubleOperand)a).getValue() / b.getValue().doubleValue());
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
	
	private Operand<Float> divideFloatByBigInteger(Operand<Float> a, Operand<BigInteger> b) {
		return new FloatOperand(((FloatOperand)a).getFloatValue() / b.getValue().floatValue());
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
	
	private Operand<BigInteger> divideIntByBigInteger(Operand<Integer> a, Operand<BigInteger> b) {
		return new Operand<>(BigInteger.class, BigInteger.valueOf(((IntOperand)a).getIntValue()).divide(b.getValue()));
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
	
	private Operand<BigInteger> divideLongByBigInteger(Operand<Long> a, Operand<BigInteger> b) {
		return new Operand<>(BigInteger.class, BigInteger.valueOf(((LongOperand)a).getLongValue()).divide(b.getValue()));
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
	
	private Operand<BigInteger> modBigInteger(Operand<BigInteger> a, Operand<BigInteger> b) {
		return new Operand<>(BigInteger.class, a.getValue().remainder(b.getValue()));
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
	
	private Operand<BigDecimal> bigDecimalModBigInteger(Operand<BigDecimal> a, Operand<BigInteger> b) {
		return new Operand<>(BigDecimal.class, a.getValue().remainder(new BigDecimal(b.getValue())));
	}
	
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
	
	private Operand<BigDecimal> bigIntegerModBigDecimal(Operand<BigInteger> a, Operand<BigDecimal> b) {
		return new Operand<>(BigDecimal.class, new BigDecimal(a.getValue()).remainder(b.getValue()));
	}
	
	private Operand<Double> bigIntegerModDouble(Operand<BigInteger> a, Operand<Double> b) {
		return new DoubleOperand(a.getValue().doubleValue() % ((DoubleOperand)b).getDoubleValue());
	}
	
	private Operand<Float> bigIntegerModFloat(Operand<BigInteger> a, Operand<Float> b) {
		return new FloatOperand(a.getValue().floatValue() % ((FloatOperand)b).getFloatValue());
	}
	
	private Operand<BigInteger> bigIntegerModInt(Operand<BigInteger> a, Operand<Integer> b) {
		return new Operand<>(BigInteger.class, a.getValue().remainder(BigInteger.valueOf(((IntOperand)b).getIntValue())));
	}
	
	private Operand<BigInteger> bigIntegerModLong(Operand<BigInteger> a, Operand<Long> b) {
		return new Operand<>(BigInteger.class, a.getValue().remainder(BigInteger.valueOf(((LongOperand)b).getLongValue())));
	}
	
	private Operand<BigDecimal> doubleModBigDecimal(Operand<Double> a, Operand<BigDecimal> b) {
		return new Operand<>(BigDecimal.class, BigDecimal.valueOf(((DoubleOperand)a).getDoubleValue()).stripTrailingZeros().remainder(b.getValue()));
	}
	
	private Operand<Double> doubleModBigInteger(Operand<Double> a, Operand<BigInteger> b) {
		return new DoubleOperand(((DoubleOperand)a).getValue() % b.getValue().doubleValue());
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
	
	private Operand<Float> floatModBigInteger(Operand<Float> a, Operand<BigInteger> b) {
		return new FloatOperand(((FloatOperand)a).getFloatValue() % b.getValue().floatValue());
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
	
	private Operand<BigInteger> intModBigInteger(Operand<Integer> a, Operand<BigInteger> b) {
		return new Operand<>(BigInteger.class, BigInteger.valueOf(((IntOperand)a).getIntValue()).remainder(b.getValue()));
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
	
	private Operand<BigInteger> longModBigInteger(Operand<Long> a, Operand<BigInteger> b) {
		return new Operand<>(BigInteger.class, BigInteger.valueOf(((LongOperand)a).getLongValue()).remainder(b.getValue()));
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
	
	private Operand<BigInteger> powerBigInteger(Operand<BigInteger> a, Operand<BigInteger> b) {
		return new Operand<>(BigInteger.class, a.getValue().pow(b.getValue().intValue()));
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
	
	private Operand<BigDecimal> bigDecimalPowerBigInteger(Operand<BigDecimal> a, Operand<BigInteger> b) {
		return new Operand<>(BigDecimal.class, a.getValue().pow(b.getValue().intValue()));
	}
	
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
	
	private Operand<BigDecimal> bigIntegerPowerBigDecimal(Operand<BigInteger> a, Operand<BigDecimal> b) {
		return new Operand<>(BigDecimal.class, new BigDecimal(a.getValue()).pow(b.getValue().intValue()));
	}
	
	private Operand<Double> bigIntegerPowerDouble(Operand<BigInteger> a, Operand<Double> b) {
		return new DoubleOperand(Math.pow(a.getValue().doubleValue(), ((DoubleOperand)b).getDoubleValue()));
	}
	
	private Operand<Float> bigIntegerPowerFloat(Operand<BigInteger> a, Operand<Float> b) {
		return new FloatOperand((float) Math.pow(a.getValue().floatValue(), ((FloatOperand)b).getFloatValue()));
	}
	
	private Operand<BigInteger> bigIntegerPowerInt(Operand<BigInteger> a, Operand<Integer> b) {
		return new Operand<>(BigInteger.class, a.getValue().pow(((IntOperand)b).getIntValue()));
	}
	
	private Operand<BigInteger> bigIntegerPowerLong(Operand<BigInteger> a, Operand<Long> b) {
		return new Operand<>(BigInteger.class, a.getValue().pow((int) ((LongOperand)b).getLongValue()));
	}
	
	private Operand<Double> doublePowerFloat(Operand<Double> a, Operand<Float> b) {
		return new DoubleOperand(Math.pow(((DoubleOperand)a).getDoubleValue(), ((FloatOperand)b).getFloatValue()));
	}
	
	private Operand<Double> doublePowerBigInteger(Operand<Double> a, Operand<BigInteger> b) {
		return new DoubleOperand(Math.pow(((DoubleOperand)a).getValue(), b.getValue().doubleValue()));
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
	
	private Operand<Float> floatPowerBigInteger(Operand<Float> a, Operand<BigInteger> b) {
		return new FloatOperand((float) Math.pow(((FloatOperand)a).getFloatValue(), b.getValue().floatValue()));
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
	
	private Operand<BigInteger> intPowerBigInteger(Operand<Integer> a, Operand<BigInteger> b) {
		return new Operand<>(BigInteger.class, BigInteger.valueOf((long) Math.pow(((IntOperand)a).getIntValue(), b.getValue().doubleValue())));
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
	
	private Operand<BigInteger> longPowerBigInteger(Operand<Long> a, Operand<BigInteger> b) {
		return new Operand<>(BigInteger.class, BigInteger.valueOf((long) Math.pow(((LongOperand)a).getLongValue(), b.getValue().doubleValue())));
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
	
	private Operand<BigInteger> negateBigInteger(Operand<BigInteger> x) {
		return new Operand<>(BigInteger.class, x.getValue().negate());
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
	
	// equals - same types
	
	private BooleanOperand bigDecimalsAreEqual(Operand<BigDecimal> a, Operand<BigDecimal> b) {
		return new BooleanOperand(a.getValue().compareTo(b.getValue()) == 0);
	}
	
	private BooleanOperand bigIntegersAreEqual(Operand<BigInteger> a, Operand<BigInteger> b) {
		return new BooleanOperand(a.getValue().compareTo(b.getValue()) == 0);
	}
	
	private BooleanOperand doublesAreEqual(Operand<Double> a, Operand<Double> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() == ((DoubleOperand)b).getDoubleValue());
	}
	
	private BooleanOperand floatsAreEqual(Operand<Float> a, Operand<Float> b) {
		return new BooleanOperand(((FloatOperand)a).getFloatValue() == ((FloatOperand)b).getFloatValue());
	}
	
	private BooleanOperand intsAreEqual(Operand<Integer> a, Operand<Integer> b) {
		return new BooleanOperand(((IntOperand)a).getIntValue() == ((IntOperand)b).getIntValue());
	}
	
	private BooleanOperand longsAreEqual(Operand<Long> a, Operand<Long> b) {
		return new BooleanOperand(((LongOperand)a).getLongValue() == ((LongOperand)b).getLongValue());
	}
	
	private BooleanOperand stringsAreEqual(Operand<String> a, Operand<String> b) {
		return new BooleanOperand(StringUtils.equals(a.getValue(), b.getValue()));
	}
	
	// equals - type promotions
	
	private BooleanOperand bigDecimalEqualsToBigInteger(Operand<BigDecimal> a, Operand<BigInteger> b) {
		return new BooleanOperand(a.getValue().compareTo(new BigDecimal(b.getValue())) == 0);
	}
	
	private BooleanOperand bigDecimalEqualsToDouble(Operand<BigDecimal> a, Operand<Double> b) {
		return new BooleanOperand(a.getValue().compareTo(BigDecimal.valueOf(((DoubleOperand)b).getDoubleValue()).stripTrailingZeros()) == 0);
	}
	
	private BooleanOperand bigDecimalEqualsToFloat(Operand<BigDecimal> a, Operand<Float> b) {
		return new BooleanOperand(a.getValue().compareTo(BigDecimal.valueOf(((FloatOperand)b).getFloatValue()).stripTrailingZeros()) == 0);
	}
	
	private BooleanOperand bigDecimalEqualsToInt(Operand<BigDecimal> a, Operand<Integer> b) {
		return new BooleanOperand(a.getValue().compareTo(BigDecimal.valueOf(((IntOperand)b).getIntValue())) == 0);
	}
	
	private BooleanOperand bigDecimalEqualsToLong(Operand<BigDecimal> a, Operand<Long> b) {
		return new BooleanOperand(a.getValue().compareTo(BigDecimal.valueOf(((LongOperand)b).getLongValue())) == 0);
	}
	
	private BooleanOperand doubleEqualsToBigInteger(Operand<Double> a, Operand<BigInteger> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() == b.getValue().doubleValue());
	}
	
	private BooleanOperand doubleEqualsToFloat(Operand<Double> a, Operand<Float> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() == ((FloatOperand)b).getFloatValue());
	}
	
	private BooleanOperand doubleEqualsToInt(Operand<Double> a, Operand<Integer> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() == ((IntOperand)b).getIntValue());
	}
	
	private BooleanOperand doubleEqualsToLong(Operand<Double> a, Operand<Long> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() == ((LongOperand)b).getLongValue());
	}
	
	private BooleanOperand floatEqualsToBigInteger(Operand<Float> a, Operand<BigInteger> b) {
		return new BooleanOperand(((FloatOperand)a).getFloatValue() == b.getValue().floatValue());
	}
	
	private BooleanOperand floatEqualsToInt(Operand<Float> a, Operand<Integer> b) {
		return new BooleanOperand(((FloatOperand)a).getFloatValue() == ((IntOperand)b).getIntValue());
	}
	
	private BooleanOperand floatEqualsToLong(Operand<Float> a, Operand<Long> b) {
		return new BooleanOperand(((FloatOperand)a).getFloatValue() == ((LongOperand)b).getLongValue());
	}
	
	private BooleanOperand bigIntegerEqualsToInt(Operand<BigInteger> a, Operand<Integer> b) {
		return new BooleanOperand(a.getValue().compareTo(BigInteger.valueOf(((IntOperand)b).getIntValue())) == 0);
	}
	
	private BooleanOperand bigIntegerEqualsToLong(Operand<BigInteger> a, Operand<Long> b) {
		return new BooleanOperand(a.getValue().compareTo(BigInteger.valueOf(((LongOperand)b).getLongValue())) == 0);
	}
	
	private BooleanOperand longEqualsToInt(Operand<Long> a, Operand<Integer> b) {
		return new BooleanOperand(((LongOperand)a).getLongValue() == ((IntOperand)b).getIntValue());
	}
	
	// not equals - same types
	
	private BooleanOperand bigDecimalsAreNotEqual(Operand<BigDecimal> a, Operand<BigDecimal> b) {
		return new BooleanOperand(a.getValue().compareTo(b.getValue()) != 0);
	}
	
	private BooleanOperand bigIntegersAreNotEqual(Operand<BigInteger> a, Operand<BigInteger> b) {
		return new BooleanOperand(a.getValue().compareTo(b.getValue()) != 0);
	}
	
	private BooleanOperand doublesAreNotEqual(Operand<Double> a, Operand<Double> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() != ((DoubleOperand)b).getDoubleValue());
	}
	
	private BooleanOperand floatsAreNotEqual(Operand<Float> a, Operand<Float> b) {
		return new BooleanOperand(((FloatOperand)a).getFloatValue() != ((FloatOperand)b).getFloatValue());
	}
	
	private BooleanOperand intsAreNotEqual(Operand<Integer> a, Operand<Integer> b) {
		return new BooleanOperand(((IntOperand)a).getIntValue() != ((IntOperand)b).getIntValue());
	}
	
	private BooleanOperand longsAreNotEqual(Operand<Long> a, Operand<Long> b) {
		return new BooleanOperand(((LongOperand)a).getLongValue() != ((LongOperand)b).getLongValue());
	}
	
	private BooleanOperand stringsAreNotEqual(Operand<String> a, Operand<String> b) {
		return new BooleanOperand(!StringUtils.equals(a.getValue(), b.getValue()));
	}
	
	// not equals - type promotions
	
	private BooleanOperand bigDecimalNotEqualToBigInteger(Operand<BigDecimal> a, Operand<BigInteger> b) {
		return new BooleanOperand(a.getValue().compareTo(new BigDecimal(b.getValue())) != 0);
	}
	
	private BooleanOperand bigDecimalNotEqualToDouble(Operand<BigDecimal> a, Operand<Double> b) {
		return new BooleanOperand(a.getValue().compareTo(BigDecimal.valueOf(((DoubleOperand)b).getDoubleValue()).stripTrailingZeros()) != 0);
	}
	
	private BooleanOperand bigDecimalNotEqualToFloat(Operand<BigDecimal> a, Operand<Float> b) {
		return new BooleanOperand(a.getValue().compareTo(BigDecimal.valueOf(((FloatOperand)b).getFloatValue()).stripTrailingZeros()) != 0);
	}
	
	private BooleanOperand bigDecimalNotEqualToInt(Operand<BigDecimal> a, Operand<Integer> b) {
		return new BooleanOperand(a.getValue().compareTo(BigDecimal.valueOf(((IntOperand)b).getIntValue())) != 0);
	}
	
	private BooleanOperand bigDecimalNotEqualToLong(Operand<BigDecimal> a, Operand<Long> b) {
		return new BooleanOperand(a.getValue().compareTo(BigDecimal.valueOf(((LongOperand)b).getLongValue())) != 0);
	}
	
	private BooleanOperand doubleNotEqualToBigInteger(Operand<Double> a, Operand<BigInteger> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() != b.getValue().doubleValue());
	}
	
	private BooleanOperand doubleNotEqualToFloat(Operand<Double> a, Operand<Float> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() != ((FloatOperand)b).getFloatValue());
	}
	
	private BooleanOperand doubleNotEqualToInt(Operand<Double> a, Operand<Integer> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() != ((IntOperand)b).getIntValue());
	}
	
	private BooleanOperand doubleNotEqualToLong(Operand<Double> a, Operand<Long> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() != ((LongOperand)b).getLongValue());
	}
	
	private BooleanOperand floatNotEqualToBigInteger(Operand<Float> a, Operand<BigInteger> b) {
		return new BooleanOperand(((FloatOperand)a).getFloatValue() != b.getValue().floatValue());
	}
	
	private BooleanOperand floatNotEqualToInt(Operand<Float> a, Operand<Integer> b) {
		return new BooleanOperand(((FloatOperand)a).getFloatValue() != ((IntOperand)b).getIntValue());
	}
	
	private BooleanOperand floatNotEqualToLong(Operand<Float> a, Operand<Long> b) {
		return new BooleanOperand(((FloatOperand)a).getFloatValue() != ((LongOperand)b).getLongValue());
	}
	
	private BooleanOperand bigIntegerNotEqualToInt(Operand<BigInteger> a, Operand<Integer> b) {
		return new BooleanOperand(a.getValue().compareTo(BigInteger.valueOf(((IntOperand)b).getIntValue())) != 0);
	}
	
	private BooleanOperand bigIntegerNotEqualToLong(Operand<BigInteger> a, Operand<Long> b) {
		return new BooleanOperand(a.getValue().compareTo(BigInteger.valueOf(((LongOperand)b).getLongValue())) != 0);
	}
	
	private BooleanOperand longNotEqualToInt(Operand<Long> a, Operand<Integer> b) {
		return new BooleanOperand(((LongOperand)a).getLongValue() != ((IntOperand)b).getIntValue());
	}
	
	// less than - same types

	private BooleanOperand lessThanBigDecimals(Operand<BigDecimal> a, Operand<BigDecimal> b) {
		return new BooleanOperand(a.getValue().compareTo(b.getValue()) < 0);
	}
	
	private BooleanOperand lessThanBigIntegers(Operand<BigInteger> a, Operand<BigInteger> b) {
		return new BooleanOperand(a.getValue().compareTo(b.getValue()) < 0);
	}
	
	private BooleanOperand lessThanDoubles(Operand<Double> a, Operand<Double> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() < ((DoubleOperand)b).getDoubleValue());
	}
	
	private BooleanOperand lessThanFloats(Operand<Float> a, Operand<Float> b) {
		return new BooleanOperand(((FloatOperand)a).getFloatValue() < ((FloatOperand)b).getFloatValue());
	}
	
	private BooleanOperand lessThanInts(Operand<Integer> a, Operand<Integer> b) {
		return new BooleanOperand(((IntOperand)a).getIntValue() < ((IntOperand)b).getIntValue());
	}
	
	private BooleanOperand lessThanLongs(Operand<Long> a, Operand<Long> b) {
		return new BooleanOperand(((LongOperand)a).getLongValue() < ((LongOperand)b).getLongValue());
	}
	
	// less than - type promotions
	
	private BooleanOperand bigDecimalLessThanBigInteger(Operand<BigDecimal> a, Operand<BigInteger> b) {
		return new BooleanOperand(a.getValue().compareTo(new BigDecimal(b.getValue())) < 0);
	}
	
	private BooleanOperand bigDecimalLessThanDouble(Operand<BigDecimal> a, Operand<Double> b) {
		return new BooleanOperand(a.getValue().compareTo(BigDecimal.valueOf(((DoubleOperand)b).getDoubleValue()).stripTrailingZeros()) < 0);
	}
	
	private BooleanOperand bigDecimalLessThanFloat(Operand<BigDecimal> a, Operand<Float> b) {
		return new BooleanOperand(a.getValue().compareTo(BigDecimal.valueOf(((FloatOperand)b).getFloatValue()).stripTrailingZeros()) < 0);
	}
	
	private BooleanOperand bigDecimalLessThanInt(Operand<BigDecimal> a, Operand<Integer> b) {
		return new BooleanOperand(a.getValue().compareTo(BigDecimal.valueOf(((IntOperand)b).getIntValue())) < 0);
	}
	
	private BooleanOperand bigDecimalLessThanLong(Operand<BigDecimal> a, Operand<Long> b) {
		return new BooleanOperand(a.getValue().compareTo(BigDecimal.valueOf(((LongOperand)b).getLongValue())) < 0);
	}
	
	private BooleanOperand bigIntegerLessThanBigDecimal(Operand<BigInteger> a, Operand<BigDecimal> b) {
		return new BooleanOperand(new BigDecimal(a.getValue()).compareTo(b.getValue()) < 0);
	}
	
	private BooleanOperand bigIntegerLessThanDouble(Operand<BigInteger> a, Operand<Double> b) {
		return new BooleanOperand(a.getValue().doubleValue() < ((DoubleOperand)b).getDoubleValue());
	}
	
	private BooleanOperand bigIntegerLessThanFloat(Operand<BigInteger> a, Operand<Float> b) {
		return new BooleanOperand(a.getValue().floatValue() < ((FloatOperand)b).getFloatValue());
	}
	
	private BooleanOperand bigIntegerLessThanInt(Operand<BigInteger> a, Operand<Integer> b) {
		return new BooleanOperand(a.getValue().compareTo(BigInteger.valueOf(((IntOperand)b).getIntValue())) < 0);
	}
	
	private BooleanOperand bigIntegerLessThanLong(Operand<BigInteger> a, Operand<Long> b) {
		return new BooleanOperand(a.getValue().compareTo(BigInteger.valueOf(((LongOperand)b).getLongValue())) < 0);
	}
	
	private BooleanOperand doubleLessThanBigDecimal(Operand<Double> a, Operand<BigDecimal> b) {
		return new BooleanOperand(BigDecimal.valueOf(((DoubleOperand)a).getDoubleValue()).stripTrailingZeros().compareTo(b.getValue()) < 0);
	}
	
	private BooleanOperand doubleLessThanBigInteger(Operand<Double> a, Operand<BigInteger> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() < b.getValue().doubleValue());
	}
	
	private BooleanOperand doubleLessThanFloat(Operand<Double> a, Operand<Float> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() < ((FloatOperand)b).getFloatValue());
	}
	
	private BooleanOperand doubleLessThanInt(Operand<Double> a, Operand<Integer> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() < ((IntOperand)b).getIntValue());
	}
	
	private BooleanOperand doubleLessThanLong(Operand<Double> a, Operand<Long> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() < ((LongOperand)b).getLongValue());
	}
	
	private BooleanOperand floatLessThanBigDecimal(Operand<Float> a, Operand<BigDecimal> b) {
		return new BooleanOperand(BigDecimal.valueOf(((FloatOperand)a).getFloatValue()).stripTrailingZeros().compareTo(b.getValue()) < 0);
	}
	
	private BooleanOperand floatLessThanBigInteger(Operand<Float> a, Operand<BigInteger> b) {
		return new BooleanOperand(((FloatOperand)a).getFloatValue() < b.getValue().floatValue());
	}
	
	private BooleanOperand floatLessThanDouble(Operand<Float> a, Operand<Double> b) {
		return new BooleanOperand(((FloatOperand)a).getFloatValue() < ((DoubleOperand)b).getDoubleValue());
	}
	
	private BooleanOperand floatLessThanInt(Operand<Float> a, Operand<Integer> b) {
		return new BooleanOperand(((FloatOperand)a).getFloatValue() < ((IntOperand)b).getIntValue());
	}
	
	private BooleanOperand floatLessThanLong(Operand<Float> a, Operand<Long> b) {
		return new BooleanOperand(((FloatOperand)a).getFloatValue() < ((LongOperand)b).getLongValue());
	}
	
	private BooleanOperand intLessThanBigDecimal(Operand<Integer> a, Operand<BigDecimal> b) {
		return new BooleanOperand(BigDecimal.valueOf(((IntOperand)a).getIntValue()).compareTo(b.getValue()) < 0);
	}
	
	private BooleanOperand intLessThanBigInteger(Operand<Integer> a, Operand<BigInteger> b) {
		return new BooleanOperand(BigInteger.valueOf(((IntOperand)a).getIntValue()).compareTo(b.getValue()) < 0);
	}
	
	private BooleanOperand intLessThanDouble(Operand<Integer> a, Operand<Double> b) {
		return new BooleanOperand(((IntOperand)a).getIntValue() < ((DoubleOperand)b).getDoubleValue());
	}
	
	private BooleanOperand intLessThanFloat(Operand<Integer> a, Operand<Float> b) {
		return new BooleanOperand(((IntOperand)a).getIntValue() < ((FloatOperand)b).getFloatValue());
	}
	
	private BooleanOperand intLessThanLong(Operand<Integer> a, Operand<Long> b) {
		return new BooleanOperand(((IntOperand)a).getIntValue() < ((LongOperand)b).getLongValue());
	}
	
	private BooleanOperand longLessThanBigDecimal(Operand<Long> a, Operand<BigDecimal> b) {
		return new BooleanOperand(BigDecimal.valueOf(((LongOperand)a).getLongValue()).stripTrailingZeros().compareTo(b.getValue()) < 0);
	}
	
	private BooleanOperand longLessThanBigInteger(Operand<Long> a, Operand<BigInteger> b) {
		return new BooleanOperand(BigInteger.valueOf(((LongOperand)a).getLongValue()).compareTo(b.getValue()) < 0);
	}
	
	private BooleanOperand longLessThanDouble(Operand<Long> a, Operand<Double> b) {
		return new BooleanOperand(((LongOperand)a).getLongValue() < ((DoubleOperand)b).getDoubleValue());
	}
	
	private BooleanOperand longLessThanFloat(Operand<Long> a, Operand<Float> b) {
		return new BooleanOperand(((LongOperand)a).getLongValue() < ((FloatOperand)b).getFloatValue());
	}
	
	private BooleanOperand longLessThanInt(Operand<Long> a, Operand<Integer> b) {
		return new BooleanOperand(((LongOperand)a).getLongValue() < ((IntOperand)b).getIntValue());
	}
	
	// less than equal - same types

	private BooleanOperand lessThanEqualBigDecimals(Operand<BigDecimal> a, Operand<BigDecimal> b) {
		return new BooleanOperand(a.getValue().compareTo(b.getValue()) <= 0);
	}
	
	private BooleanOperand lessThanEqualBigIntegers(Operand<BigInteger> a, Operand<BigInteger> b) {
		return new BooleanOperand(a.getValue().compareTo(b.getValue()) <= 0);
	}
	
	private BooleanOperand lessThanEqualDoubles(Operand<Double> a, Operand<Double> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() <= ((DoubleOperand)b).getDoubleValue());
	}
	
	private BooleanOperand lessThanEqualFloats(Operand<Float> a, Operand<Float> b) {
		return new BooleanOperand(((FloatOperand)a).getFloatValue() <= ((FloatOperand)b).getFloatValue());
	}
	
	private BooleanOperand lessThanEqualInts(Operand<Integer> a, Operand<Integer> b) {
		return new BooleanOperand(((IntOperand)a).getIntValue() <= ((IntOperand)b).getIntValue());
	}
	
	private BooleanOperand lessThanEqualLongs(Operand<Long> a, Operand<Long> b) {
		return new BooleanOperand(((LongOperand)a).getLongValue() <= ((LongOperand)b).getLongValue());
	}
	
	// less than equal - type promotions
	
	private BooleanOperand bigDecimalLessThanEqualBigInteger(Operand<BigDecimal> a, Operand<BigInteger> b) {
		return new BooleanOperand(a.getValue().compareTo(new BigDecimal(b.getValue())) <= 0);
	}
	
	private BooleanOperand bigDecimalLessThanEqualDouble(Operand<BigDecimal> a, Operand<Double> b) {
		return new BooleanOperand(a.getValue().compareTo(BigDecimal.valueOf(((DoubleOperand)b).getDoubleValue()).stripTrailingZeros()) <= 0);
	}
	
	private BooleanOperand bigDecimalLessThanEqualFloat(Operand<BigDecimal> a, Operand<Float> b) {
		return new BooleanOperand(a.getValue().compareTo(BigDecimal.valueOf(((FloatOperand)b).getFloatValue()).stripTrailingZeros()) <= 0);
	}
	
	private BooleanOperand bigDecimalLessThanEqualInt(Operand<BigDecimal> a, Operand<Integer> b) {
		return new BooleanOperand(a.getValue().compareTo(BigDecimal.valueOf(((IntOperand)b).getIntValue())) <= 0);
	}
	
	private BooleanOperand bigDecimalLessThanEqualLong(Operand<BigDecimal> a, Operand<Long> b) {
		return new BooleanOperand(a.getValue().compareTo(BigDecimal.valueOf(((LongOperand)b).getLongValue())) <= 0);
	}
	
	private BooleanOperand bigIntegerLessThanEqualBigDecimal(Operand<BigInteger> a, Operand<BigDecimal> b) {
		return new BooleanOperand(new BigDecimal(a.getValue()).compareTo(b.getValue()) <= 0);
	}
	
	private BooleanOperand bigIntegerLessThanEqualDouble(Operand<BigInteger> a, Operand<Double> b) {
		return new BooleanOperand(a.getValue().doubleValue() <= ((DoubleOperand)b).getDoubleValue());
	}
	
	private BooleanOperand bigIntegerLessThanEqualFloat(Operand<BigInteger> a, Operand<Float> b) {
		return new BooleanOperand(a.getValue().floatValue() <= ((FloatOperand)b).getFloatValue());
	}
	
	private BooleanOperand bigIntegerLessThanEqualInt(Operand<BigInteger> a, Operand<Integer> b) {
		return new BooleanOperand(a.getValue().compareTo(BigInteger.valueOf(((IntOperand)b).getIntValue())) <= 0);
	}
	
	private BooleanOperand bigIntegerLessThanEqualLong(Operand<BigInteger> a, Operand<Long> b) {
		return new BooleanOperand(a.getValue().compareTo(BigInteger.valueOf(((LongOperand)b).getLongValue())) <= 0);
	}
	
	private BooleanOperand doubleLessThanEqualBigDecimal(Operand<Double> a, Operand<BigDecimal> b) {
		return new BooleanOperand(BigDecimal.valueOf(((DoubleOperand)a).getDoubleValue()).stripTrailingZeros().compareTo(b.getValue()) <= 0);
	}
	
	private BooleanOperand doubleLessThanEqualBigInteger(Operand<Double> a, Operand<BigInteger> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() <= b.getValue().doubleValue());
	}
	
	private BooleanOperand doubleLessThanEqualFloat(Operand<Double> a, Operand<Float> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() <= ((FloatOperand)b).getFloatValue());
	}
	
	private BooleanOperand doubleLessThanEqualInt(Operand<Double> a, Operand<Integer> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() <= ((IntOperand)b).getIntValue());
	}
	
	private BooleanOperand doubleLessThanEqualLong(Operand<Double> a, Operand<Long> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() <= ((LongOperand)b).getLongValue());
	}
	
	private BooleanOperand floatLessThanEqualBigDecimal(Operand<Float> a, Operand<BigDecimal> b) {
		return new BooleanOperand(BigDecimal.valueOf(((FloatOperand)a).getFloatValue()).stripTrailingZeros().compareTo(b.getValue()) <= 0);
	}
	
	private BooleanOperand floatLessThanEqualBigInteger(Operand<Float> a, Operand<BigInteger> b) {
		return new BooleanOperand(((FloatOperand)a).getFloatValue() <= b.getValue().floatValue());
	}
	
	private BooleanOperand floatLessThanEqualDouble(Operand<Float> a, Operand<Double> b) {
		return new BooleanOperand(((FloatOperand)a).getFloatValue() <= ((DoubleOperand)b).getDoubleValue());
	}
	
	private BooleanOperand floatLessThanEqualInt(Operand<Float> a, Operand<Integer> b) {
		return new BooleanOperand(((FloatOperand)a).getFloatValue() <= ((IntOperand)b).getIntValue());
	}
	
	private BooleanOperand floatLessThanEqualLong(Operand<Float> a, Operand<Long> b) {
		return new BooleanOperand(((FloatOperand)a).getFloatValue() <= ((LongOperand)b).getLongValue());
	}
	
	private BooleanOperand intLessThanEqualBigDecimal(Operand<Integer> a, Operand<BigDecimal> b) {
		return new BooleanOperand(BigDecimal.valueOf(((IntOperand)a).getIntValue()).compareTo(b.getValue()) <= 0);
	}
	
	private BooleanOperand intLessThanEqualBigInteger(Operand<Integer> a, Operand<BigInteger> b) {
		return new BooleanOperand(BigInteger.valueOf(((IntOperand)a).getIntValue()).compareTo(b.getValue()) <= 0);
	}
	
	private BooleanOperand intLessThanEqualDouble(Operand<Integer> a, Operand<Double> b) {
		return new BooleanOperand(((IntOperand)a).getIntValue() <= ((DoubleOperand)b).getDoubleValue());
	}
	
	private BooleanOperand intLessThanEqualFloat(Operand<Integer> a, Operand<Float> b) {
		return new BooleanOperand(((IntOperand)a).getIntValue() <= ((FloatOperand)b).getFloatValue());
	}
	
	private BooleanOperand intLessThanEqualLong(Operand<Integer> a, Operand<Long> b) {
		return new BooleanOperand(((IntOperand)a).getIntValue() <= ((LongOperand)b).getLongValue());
	}
	
	private BooleanOperand longLessThanEqualBigDecimal(Operand<Long> a, Operand<BigDecimal> b) {
		return new BooleanOperand(BigDecimal.valueOf(((LongOperand)a).getLongValue()).stripTrailingZeros().compareTo(b.getValue()) <= 0);
	}
	
	private BooleanOperand longLessThanEqualBigInteger(Operand<Long> a, Operand<BigInteger> b) {
		return new BooleanOperand(BigInteger.valueOf(((LongOperand)a).getLongValue()).compareTo(b.getValue()) <= 0);
	}
	
	private BooleanOperand longLessThanEqualDouble(Operand<Long> a, Operand<Double> b) {
		return new BooleanOperand(((LongOperand)a).getLongValue() <= ((DoubleOperand)b).getDoubleValue());
	}
	
	private BooleanOperand longLessThanEqualFloat(Operand<Long> a, Operand<Float> b) {
		return new BooleanOperand(((LongOperand)a).getLongValue() <= ((FloatOperand)b).getFloatValue());
	}
	
	private BooleanOperand longLessThanEqualInt(Operand<Long> a, Operand<Integer> b) {
		return new BooleanOperand(((LongOperand)a).getLongValue() <= ((IntOperand)b).getIntValue());
	}
	
	// greater than - same types

	private BooleanOperand greaterThanBigDecimals(Operand<BigDecimal> a, Operand<BigDecimal> b) {
		return new BooleanOperand(a.getValue().compareTo(b.getValue()) > 0);
	}
	
	private BooleanOperand greaterThanBigIntegers(Operand<BigInteger> a, Operand<BigInteger> b) {
		return new BooleanOperand(a.getValue().compareTo(b.getValue()) > 0);
	}
	
	private BooleanOperand greaterThanDoubles(Operand<Double> a, Operand<Double> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() > ((DoubleOperand)b).getDoubleValue());
	}
	
	private BooleanOperand greaterThanFloats(Operand<Float> a, Operand<Float> b) {
		return new BooleanOperand(((FloatOperand)a).getFloatValue() > ((FloatOperand)b).getFloatValue());
	}
	
	private BooleanOperand greaterThanInts(Operand<Integer> a, Operand<Integer> b) {
		return new BooleanOperand(((IntOperand)a).getIntValue() > ((IntOperand)b).getIntValue());
	}
	
	private BooleanOperand greaterThanLongs(Operand<Long> a, Operand<Long> b) {
		return new BooleanOperand(((LongOperand)a).getLongValue() > ((LongOperand)b).getLongValue());
	}
	
	// greater than - type promotions
	
	private BooleanOperand bigDecimalGreaterThanBigInteger(Operand<BigDecimal> a, Operand<BigInteger> b) {
		return new BooleanOperand(a.getValue().compareTo(new BigDecimal(b.getValue())) > 0);
	}
	
	private BooleanOperand bigDecimalGreaterThanDouble(Operand<BigDecimal> a, Operand<Double> b) {
		return new BooleanOperand(a.getValue().compareTo(BigDecimal.valueOf(((DoubleOperand)b).getDoubleValue()).stripTrailingZeros()) > 0);
	}
	
	private BooleanOperand bigDecimalGreaterThanFloat(Operand<BigDecimal> a, Operand<Float> b) {
		return new BooleanOperand(a.getValue().compareTo(BigDecimal.valueOf(((FloatOperand)b).getFloatValue()).stripTrailingZeros()) > 0);
	}
	
	private BooleanOperand bigDecimalGreaterThanInt(Operand<BigDecimal> a, Operand<Integer> b) {
		return new BooleanOperand(a.getValue().compareTo(BigDecimal.valueOf(((IntOperand)b).getIntValue())) > 0);
	}
	
	private BooleanOperand bigDecimalGreaterThanLong(Operand<BigDecimal> a, Operand<Long> b) {
		return new BooleanOperand(a.getValue().compareTo(BigDecimal.valueOf(((LongOperand)b).getLongValue())) > 0);
	}
	
	private BooleanOperand bigIntegerGreaterThanBigDecimal(Operand<BigInteger> a, Operand<BigDecimal> b) {
		return new BooleanOperand(new BigDecimal(a.getValue()).compareTo(b.getValue()) > 0);
	}
	
	private BooleanOperand bigIntegerGreaterThanDouble(Operand<BigInteger> a, Operand<Double> b) {
		return new BooleanOperand(a.getValue().doubleValue() > ((DoubleOperand)b).getDoubleValue());
	}
	
	private BooleanOperand bigIntegerGreaterThanFloat(Operand<BigInteger> a, Operand<Float> b) {
		return new BooleanOperand(a.getValue().floatValue() > ((FloatOperand)b).getFloatValue());
	}
	
	private BooleanOperand bigIntegerGreaterThanInt(Operand<BigInteger> a, Operand<Integer> b) {
		return new BooleanOperand(a.getValue().compareTo(BigInteger.valueOf(((IntOperand)b).getIntValue())) > 0);
	}
	
	private BooleanOperand bigIntegerGreaterThanLong(Operand<BigInteger> a, Operand<Long> b) {
		return new BooleanOperand(a.getValue().compareTo(BigInteger.valueOf(((LongOperand)b).getLongValue())) > 0);
	}

	private BooleanOperand doubleGreaterThanBigDecimal(Operand<Double> a, Operand<BigDecimal> b) {
		return new BooleanOperand(BigDecimal.valueOf(((DoubleOperand)a).getDoubleValue()).stripTrailingZeros().compareTo(b.getValue()) > 0);
	}
	
	private BooleanOperand doubleGreaterThanBigInteger(Operand<Double> a, Operand<BigInteger> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() > b.getValue().doubleValue());
	}
	
	private BooleanOperand doubleGreaterThanFloat(Operand<Double> a, Operand<Float> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() > ((FloatOperand)b).getFloatValue());
	}
	
	private BooleanOperand doubleGreaterThanInt(Operand<Double> a, Operand<Integer> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() > ((IntOperand)b).getIntValue());
	}
	
	private BooleanOperand doubleGreaterThanLong(Operand<Double> a, Operand<Long> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() > ((LongOperand)b).getLongValue());
	}
	
	private BooleanOperand floatGreaterThanBigDecimal(Operand<Float> a, Operand<BigDecimal> b) {
		return new BooleanOperand(BigDecimal.valueOf(((FloatOperand)a).getFloatValue()).stripTrailingZeros().compareTo(b.getValue()) > 0);
	}
	
	private BooleanOperand floatGreaterThanBigInteger(Operand<Float> a, Operand<BigInteger> b) {
		return new BooleanOperand(((FloatOperand)a).getFloatValue() > b.getValue().floatValue());
	}
	
	private BooleanOperand floatGreaterThanDouble(Operand<Float> a, Operand<Double> b) {
		return new BooleanOperand(((FloatOperand)a).getFloatValue() > ((DoubleOperand)b).getDoubleValue());
	}
	
	private BooleanOperand floatGreaterThanInt(Operand<Float> a, Operand<Integer> b) {
		return new BooleanOperand(((FloatOperand)a).getFloatValue() > ((IntOperand)b).getIntValue());
	}
	
	private BooleanOperand floatGreaterThanLong(Operand<Float> a, Operand<Long> b) {
		return new BooleanOperand(((FloatOperand)a).getFloatValue() > ((LongOperand)b).getLongValue());
	}
	
	private BooleanOperand intGreaterThanBigDecimal(Operand<Integer> a, Operand<BigDecimal> b) {
		return new BooleanOperand(BigDecimal.valueOf(((IntOperand)a).getIntValue()).compareTo(b.getValue()) > 0);
	}
	
	private BooleanOperand intGreaterThanBigInteger(Operand<Integer> a, Operand<BigInteger> b) {
		return new BooleanOperand(BigInteger.valueOf(((IntOperand)a).getIntValue()).compareTo(b.getValue()) > 0);
	}
	
	private BooleanOperand intGreaterThanDouble(Operand<Integer> a, Operand<Double> b) {
		return new BooleanOperand(((IntOperand)a).getIntValue() > ((DoubleOperand)b).getDoubleValue());
	}
	
	private BooleanOperand intGreaterThanFloat(Operand<Integer> a, Operand<Float> b) {
		return new BooleanOperand(((IntOperand)a).getIntValue() > ((FloatOperand)b).getFloatValue());
	}
	
	private BooleanOperand intGreaterThanLong(Operand<Integer> a, Operand<Long> b) {
		return new BooleanOperand(((IntOperand)a).getIntValue() > ((LongOperand)b).getLongValue());
	}
	
	private BooleanOperand longGreaterThanBigDecimal(Operand<Long> a, Operand<BigDecimal> b) {
		return new BooleanOperand(BigDecimal.valueOf(((LongOperand)a).getLongValue()).stripTrailingZeros().compareTo(b.getValue()) > 0);
	}
	
	private BooleanOperand longGreaterThanBigInteger(Operand<Long> a, Operand<BigInteger> b) {
		return new BooleanOperand(BigInteger.valueOf(((LongOperand)a).getLongValue()).compareTo(b.getValue()) > 0);
	}
	
	private BooleanOperand longGreaterThanDouble(Operand<Long> a, Operand<Double> b) {
		return new BooleanOperand(((LongOperand)a).getLongValue() > ((DoubleOperand)b).getDoubleValue());
	}
	
	private BooleanOperand longGreaterThanFloat(Operand<Long> a, Operand<Float> b) {
		return new BooleanOperand(((LongOperand)a).getLongValue() > ((FloatOperand)b).getFloatValue());
	}
	
	private BooleanOperand longGreaterThanInt(Operand<Long> a, Operand<Integer> b) {
		return new BooleanOperand(((LongOperand)a).getLongValue() > ((IntOperand)b).getIntValue());
	}
	
	// greater than equal - same types

	private BooleanOperand greaterThanEqualBigDecimals(Operand<BigDecimal> a, Operand<BigDecimal> b) {
		return new BooleanOperand(a.getValue().compareTo(b.getValue()) >= 0);
	}
	
	private BooleanOperand greaterThanEqualBigIntegers(Operand<BigInteger> a, Operand<BigInteger> b) {
		return new BooleanOperand(a.getValue().compareTo(b.getValue()) >= 0);
	}
	
	private BooleanOperand greaterThanEqualDoubles(Operand<Double> a, Operand<Double> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() >= ((DoubleOperand)b).getDoubleValue());
	}
	
	private BooleanOperand greaterThanEqualFloats(Operand<Float> a, Operand<Float> b) {
		return new BooleanOperand(((FloatOperand)a).getFloatValue() >= ((FloatOperand)b).getFloatValue());
	}
	
	private BooleanOperand greaterThanEqualInts(Operand<Integer> a, Operand<Integer> b) {
		return new BooleanOperand(((IntOperand)a).getIntValue() >= ((IntOperand)b).getIntValue());
	}
	
	private BooleanOperand greaterThanEqualLongs(Operand<Long> a, Operand<Long> b) {
		return new BooleanOperand(((LongOperand)a).getLongValue() >= ((LongOperand)b).getLongValue());
	}
	
	// greater than equal - type promotions
	
	private BooleanOperand bigDecimalGreaterThanEqualBigInteger(Operand<BigDecimal> a, Operand<BigInteger> b) {
		return new BooleanOperand(a.getValue().compareTo(new BigDecimal(b.getValue())) >= 0);
	}
	
	private BooleanOperand bigDecimalGreaterThanEqualDouble(Operand<BigDecimal> a, Operand<Double> b) {
		return new BooleanOperand(a.getValue().compareTo(BigDecimal.valueOf(((DoubleOperand)b).getDoubleValue()).stripTrailingZeros()) >= 0);
	}
	
	private BooleanOperand bigDecimalGreaterThanEqualFloat(Operand<BigDecimal> a, Operand<Float> b) {
		return new BooleanOperand(a.getValue().compareTo(BigDecimal.valueOf(((FloatOperand)b).getFloatValue()).stripTrailingZeros()) >= 0);
	}
	
	private BooleanOperand bigDecimalGreaterThanEqualInt(Operand<BigDecimal> a, Operand<Integer> b) {
		return new BooleanOperand(a.getValue().compareTo(BigDecimal.valueOf(((IntOperand)b).getIntValue())) >= 0);
	}
	
	private BooleanOperand bigDecimalGreaterThanEqualLong(Operand<BigDecimal> a, Operand<Long> b) {
		return new BooleanOperand(a.getValue().compareTo(BigDecimal.valueOf(((LongOperand)b).getLongValue())) >= 0);
	}
	
	private BooleanOperand bigIntegerGreaterThanEqualBigDecimal(Operand<BigInteger> a, Operand<BigDecimal> b) {
		return new BooleanOperand(new BigDecimal(a.getValue()).compareTo(b.getValue()) >= 0);
	}
	
	private BooleanOperand bigIntegerGreaterThanEqualDouble(Operand<BigInteger> a, Operand<Double> b) {
		return new BooleanOperand(a.getValue().doubleValue() >= ((DoubleOperand)b).getDoubleValue());
	}
	
	private BooleanOperand bigIntegerGreaterThanEqualFloat(Operand<BigInteger> a, Operand<Float> b) {
		return new BooleanOperand(a.getValue().floatValue() >= ((FloatOperand)b).getFloatValue());
	}
	
	private BooleanOperand bigIntegerGreaterThanEqualInt(Operand<BigInteger> a, Operand<Integer> b) {
		return new BooleanOperand(a.getValue().compareTo(BigInteger.valueOf(((IntOperand)b).getIntValue())) >= 0);
	}
	
	private BooleanOperand bigIntegerGreaterThanEqualLong(Operand<BigInteger> a, Operand<Long> b) {
		return new BooleanOperand(a.getValue().compareTo(BigInteger.valueOf(((LongOperand)b).getLongValue())) >= 0);
	}
	
	private BooleanOperand doubleGreaterThanEqualBigDecimal(Operand<Double> a, Operand<BigDecimal> b) {
		return new BooleanOperand(BigDecimal.valueOf(((DoubleOperand)a).getDoubleValue()).stripTrailingZeros().compareTo(b.getValue()) >= 0);
	}
	
	private BooleanOperand doubleGreaterThanEqualBigInteger(Operand<Double> a, Operand<BigInteger> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() >= b.getValue().doubleValue());
	}
	
	private BooleanOperand doubleGreaterThanEqualFloat(Operand<Double> a, Operand<Float> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() >= ((FloatOperand)b).getFloatValue());
	}
	
	private BooleanOperand doubleGreaterThanEqualInt(Operand<Double> a, Operand<Integer> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() >= ((IntOperand)b).getIntValue());
	}
	
	private BooleanOperand doubleGreaterThanEqualLong(Operand<Double> a, Operand<Long> b) {
		return new BooleanOperand(((DoubleOperand)a).getDoubleValue() >= ((LongOperand)b).getLongValue());
	}
	
	private BooleanOperand floatGreaterThanEqualBigDecimal(Operand<Float> a, Operand<BigDecimal> b) {
		return new BooleanOperand(BigDecimal.valueOf(((FloatOperand)a).getFloatValue()).stripTrailingZeros().compareTo(b.getValue()) >= 0);
	}
	
	private BooleanOperand floatGreaterThanEqualBigInteger(Operand<Float> a, Operand<BigInteger> b) {
		return new BooleanOperand(((FloatOperand)a).getFloatValue() >= b.getValue().floatValue());
	}
	
	private BooleanOperand floatGreaterThanEqualDouble(Operand<Float> a, Operand<Double> b) {
		return new BooleanOperand(((FloatOperand)a).getFloatValue() >= ((DoubleOperand)b).getDoubleValue());
	}
	
	private BooleanOperand floatGreaterThanEqualInt(Operand<Float> a, Operand<Integer> b) {
		return new BooleanOperand(((FloatOperand)a).getFloatValue() >= ((IntOperand)b).getIntValue());
	}
	
	private BooleanOperand floatGreaterThanEqualLong(Operand<Float> a, Operand<Long> b) {
		return new BooleanOperand(((FloatOperand)a).getFloatValue() >= ((LongOperand)b).getLongValue());
	}
	
	private BooleanOperand intGreaterThanEqualBigDecimal(Operand<Integer> a, Operand<BigDecimal> b) {
		return new BooleanOperand(BigDecimal.valueOf(((IntOperand)a).getIntValue()).compareTo(b.getValue()) >= 0);
	}
	
	private BooleanOperand intGreaterThanEqualBigInteger(Operand<Integer> a, Operand<BigInteger> b) {
		return new BooleanOperand(BigInteger.valueOf(((IntOperand)a).getIntValue()).compareTo(b.getValue()) >= 0);
	}
	
	private BooleanOperand intGreaterThanEqualDouble(Operand<Integer> a, Operand<Double> b) {
		return new BooleanOperand(((IntOperand)a).getIntValue() >= ((DoubleOperand)b).getDoubleValue());
	}
	
	private BooleanOperand intGreaterThanEqualFloat(Operand<Integer> a, Operand<Float> b) {
		return new BooleanOperand(((IntOperand)a).getIntValue() >= ((FloatOperand)b).getFloatValue());
	}
	
	private BooleanOperand intGreaterThanEqualLong(Operand<Integer> a, Operand<Long> b) {
		return new BooleanOperand(((IntOperand)a).getIntValue() >= ((LongOperand)b).getLongValue());
	}
	
	private BooleanOperand longGreaterThanEqualBigDecimal(Operand<Long> a, Operand<BigDecimal> b) {
		return new BooleanOperand(BigDecimal.valueOf(((LongOperand)a).getLongValue()).stripTrailingZeros().compareTo(b.getValue()) >= 0);
	}
	
	private BooleanOperand longGreaterThanEqualBigInteger(Operand<Long> a, Operand<BigInteger> b) {
		return new BooleanOperand(BigInteger.valueOf(((LongOperand)a).getLongValue()).compareTo(b.getValue()) >= 0);
	}
	
	private BooleanOperand longGreaterThanEqualDouble(Operand<Long> a, Operand<Double> b) {
		return new BooleanOperand(((LongOperand)a).getLongValue() >= ((DoubleOperand)b).getDoubleValue());
	}
	
	private BooleanOperand longGreaterThanEqualFloat(Operand<Long> a, Operand<Float> b) {
		return new BooleanOperand(((LongOperand)a).getLongValue() >= ((FloatOperand)b).getFloatValue());
	}
	
	private BooleanOperand longGreaterThanEqualInt(Operand<Long> a, Operand<Integer> b) {
		return new BooleanOperand(((LongOperand)a).getLongValue() >= ((IntOperand)b).getIntValue());
	}
	
	// and
	
	private BooleanOperand logicalAnd(Operand<Boolean> a, Operand<Boolean> b) {
		return new BooleanOperand(((BooleanOperand)a).getBooleanValue() && ((BooleanOperand)b).getBooleanValue());
	}
	
	// or
	
	private BooleanOperand logicalOr(Operand<Boolean> a, Operand<Boolean> b) {
		return new BooleanOperand(((BooleanOperand)a).getBooleanValue() || ((BooleanOperand)b).getBooleanValue());
	}
	
	// not
	
	private BooleanOperand logicalNot(Operand<Boolean> x) {
		return new BooleanOperand(!((BooleanOperand)x).getBooleanValue());
	}
}
