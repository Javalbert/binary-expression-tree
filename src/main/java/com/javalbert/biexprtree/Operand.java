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
