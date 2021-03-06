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

import java.util.Objects;
import java.util.function.BiFunction;

public class BinaryFunc<T, U> implements Func {
	private final BiFunction<Operand<T>, Operand<U>, Operand<?>> function;
	private final OperatorInfo operatorInfo;

	@Override
	public OperatorInfo getOperatorInfo() {
		return operatorInfo;
	}
	
	public BiFunction getFunction() {
		return function;
	}
	
	public BinaryFunc(BinaryOperatorInfo<T, U> operatorInfo, BiFunction<Operand<T>, Operand<U>, Operand<?>> function) {
		this.operatorInfo = Objects.requireNonNull(operatorInfo, "operatorInfo must not be null");
		this.function = Objects.requireNonNull(function, "function must not be null");
	}
}
