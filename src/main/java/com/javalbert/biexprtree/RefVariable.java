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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		RefVariable other = (RefVariable) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return type.getSimpleName() + " " + name + " = " + value;
	}
}
