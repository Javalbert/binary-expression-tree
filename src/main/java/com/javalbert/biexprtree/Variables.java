package com.javalbert.biexprtree;

import java.util.Objects;
import java.util.regex.Pattern;

public final class Variables {
	private static final Pattern INVALID_NAME = Pattern.compile("[^a-zA-Z0-9_$]|^[0-9]");
	
	public static IntVariable intVar(String name) {
		return new IntVariable(name);
	}
	
	public static IntVariable intVar(String name, int i) {
		return new IntVariable(name, i);
	}
	
	public static <T> RefVariable<T> refVar(String name, Class<T> type) {
		return new RefVariable<T>(type, name);
	}
	
	public static <T> RefVariable<T> refVar(String name, Class<T> type, T value) {
		return new RefVariable<T>(type, name, value);
	}

	static String validateName(String name) {
		Objects.requireNonNull(name);
		
		if ("".equals(name) || INVALID_NAME.matcher(name).find()) {
			throw new IllegalArgumentException(
					"Variable names must contain only alphanumeric, underscore, or dollar sign"
					+ " characters, and must not start with a number"
					);
		}
		return name;
	}
	
	private Variables() {}
}
