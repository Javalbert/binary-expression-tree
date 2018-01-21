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

public class CharVariable implements Variable<Character> {
	private final String name;
	private char value;
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public Class<Character> getType() {
		return char.class;
	}
	
	@Override
	public Character getValue() {
		return value;
	}
	
	@Override
	public void setValue(Character value) {
		this.value = value;
	}
	
	public char getChar() {
		return value;
	}
	
	public void setChar(char c) {
		value = c;
	}
	
	public CharVariable(String name) {
		this(name, '\u0000');
	}
	
	public CharVariable(String name, char c) {
		this.name = Variables.validateName(name);
		value = c;
	}
	
	@Override
	public Operand<Character> toOperand() {
		return new CharOperand(value);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + value;
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
		CharVariable other = (CharVariable) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (value != other.value)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "char " + name + " = " + value;
	}
}
