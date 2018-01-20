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

public class BinaryOperatorInfo<T, U> implements OperatorInfo {
	private String operator;
	private Class<T> leftOperandClass;
	private Class<U> rightOperandClass;
	
	@Override
	public String getOperator() {
		return operator;
	}
	
	public Class<T> getLeftOperandClass() {
		return leftOperandClass;
	}
	
	public Class<U> getRightOperandClass() {
		return rightOperandClass;
	}
	
	public BinaryOperatorInfo(
			String operator,
			Class<T> leftOperandClass,
			Class<U> rightOperandClass) {
		this.operator = Functions.validateOperator(operator);
		this.leftOperandClass = Objects.requireNonNull(leftOperandClass, "leftOperandClass must not be null");
		this.rightOperandClass = Objects.requireNonNull(rightOperandClass, "rightOperandClass must not be null");
	}
	
	BinaryOperatorInfo() {
		this.operator = null;
		this.leftOperandClass = null;
		this.rightOperandClass = null;
	}

	void forHash(BinaryOperatorNode nodeWithOperator, Operand leftOperand, Operand rightOperand) {
		operator = nodeWithOperator.getOperator();
		leftOperandClass = leftOperand.getOperandClass();
		rightOperandClass = rightOperand.getOperandClass();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((leftOperandClass == null) ? 0 : leftOperandClass.hashCode());
		result = prime * result + ((rightOperandClass == null) ? 0 : rightOperandClass.hashCode());
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
		BinaryOperatorInfo other = (BinaryOperatorInfo) obj;
		if (leftOperandClass == null) {
			if (other.leftOperandClass != null)
				return false;
		} else if (!leftOperandClass.equals(other.leftOperandClass))
			return false;
		if (rightOperandClass == null) {
			if (other.rightOperandClass != null)
				return false;
		} else if (!rightOperandClass.equals(other.rightOperandClass))
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		return true;
	}
}
