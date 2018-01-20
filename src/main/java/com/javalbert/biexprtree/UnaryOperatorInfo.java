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

public class UnaryOperatorInfo<T> implements OperatorInfo {
	private String operator;
	private Class<T> operandClass;
	
	@Override
	public String getOperator() {
		return operator;
	}
	
	public Class<T> getOperandClass() {
		return operandClass;
	}

	public UnaryOperatorInfo(String operator, Class<T> operandClass) {
		this.operator = Functions.validateOperator(operator);
		this.operandClass = Objects.requireNonNull(operandClass, "operandClass must not be null");
	}
	
	UnaryOperatorInfo() {
		operator = null;
		operandClass = null;
	}

	void forHash(UnaryOperatorNode unaryNode, Operand operand) {
		operator = unaryNode.getOperator();
		operandClass = operand.getOperandClass();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((operandClass == null) ? 0 : operandClass.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnaryOperatorInfo other = (UnaryOperatorInfo) obj;
		if (operandClass == null) {
			if (other.operandClass != null)
				return false;
		} else if (!operandClass.equals(other.operandClass))
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		return true;
	}
}
