package com.javalbert.biexprtree;

public class RefVariable<T> implements Variable<T> {
	private final String name;
	private final Class<T> type;
	private T value;
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public Class<T> getType() {
		return type;
	}
	
	@Override
	public T getValue() {
		return value;
	}
	
	@Override
	public void setValue(T value) {
		if (value != null && !type.isAssignableFrom(value.getClass())) {
			throw new IllegalArgumentException(
					"Wrong type. Expected " + type
					+ " but instead got " + value.getClass()
					);
		}
		this.value = value;
	}

	public RefVariable(Class<T> type, String name) {
		this(type, name, null);
	}
	
	public RefVariable(Class<T> type, String name, T value) {
		this.name = Variables.validateName(name);
		this.type = type;
		setValue(value);
	}
}
