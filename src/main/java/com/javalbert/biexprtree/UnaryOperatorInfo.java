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
