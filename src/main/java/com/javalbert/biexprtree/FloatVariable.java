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

public class FloatVariable implements Variable<Float> {
	private final String name;
	private float value;
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public Class<Float> getType() {
		return float.class;
	}

	@Override
	public Float getValue() {
		return value;
	}

	@Override
	public void setValue(Float value) {
		this.value = value;
	}
	
	public float getFloat() {
		return value;
	}
	
	public void setFloat(float f) {
		value = f;
	}
	
	public FloatVariable(String name) {
		this(name, 0.0f);
	}
	
	public FloatVariable(String name, float f) {
		this.name = Variables.validateName(name);
		value = f;
	}

	@Override
	public Operand<Float> toOperand() {
		return new FloatOperand(value);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(value);
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
		FloatVariable other = (FloatVariable) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(value) != Float.floatToIntBits(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "float " + name + " = " + value;
	}
}
