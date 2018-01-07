package com.javalbert.biexprtree;

import java.util.Objects;

public class BinaryOperatorInfo<T, U> implements OperatorInfo {
	private final String operator;
	private final Class<T> aClass;
	private final Class<U> bClass;
	
	@Override
	public FunctionType getFunctionType() {
		return FunctionType.BINARY;
	}
	
	@Override
	public String getOperator() {
		return operator;
	}
	
	public Class<T> getAClass() {
		return aClass;
	}
	
	public Class<U> getBClass() {
		return bClass;
	}

	public BinaryOperatorInfo(String operator, Class<T> aClass, Class<U> bClass) {
		this.operator = Functions.validateOperator(operator);
		this.aClass = Objects.requireNonNull(aClass, "aClass must not be null");
		this.bClass = Objects.requireNonNull(bClass, "bClass must not be null");
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aClass == null) ? 0 : aClass.hashCode());
		result = prime * result + ((bClass == null) ? 0 : bClass.hashCode());
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
		if (aClass == null) {
			if (other.aClass != null)
				return false;
		} else if (!aClass.equals(other.aClass))
			return false;
		if (bClass == null) {
			if (other.bClass != null)
				return false;
		} else if (!bClass.equals(other.bClass))
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		return true;
	}
}
