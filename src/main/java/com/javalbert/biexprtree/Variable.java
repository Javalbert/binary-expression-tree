package com.javalbert.biexprtree;

public interface Variable<T> {
	String getName();
	Class<T> getType();
	T getValue();
	void setValue(T value);
}
