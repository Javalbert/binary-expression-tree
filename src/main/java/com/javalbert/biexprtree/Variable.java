package com.javalbert.biexprtree;

import java.util.Objects;
import java.util.regex.Pattern;

public class Variable<T> {
	private static final Pattern INVALID_NAME = Pattern.compile("[^a-zA-Z0-9_]");
	
	private final String name;
	private final Class<T> type;
	private T value;
	
	public String getName() {
		return name;
	}
	public Class<T> getType() {
		return type;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		if (value != null && !type.isAssignableFrom(value.getClass())) {
			throw new IllegalArgumentException(
					"Wrong type. Expected " + type
					+ " but instead got " + value.getClass()
					);
		}
		this.value = value;
	}

	public Variable(Class<T> type, String name) {
		this(type, name, null);
	}
	
	public Variable(Class<T> type, String name, T value) {
		this.name = validateName(name);
		this.type = type;
		setValue(value);
	}
	
	private String validateName(String name) {
		Objects.requireNonNull(name);
		
		if (INVALID_NAME.matcher(name).find()) {
			throw new IllegalArgumentException(
					"Variable names can only contain alphanumeric"
					+ " characters or underscore"
					);
		}
		return name;
	}
}
