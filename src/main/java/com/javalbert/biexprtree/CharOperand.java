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

public class CharOperand extends Operand<Character> {
	private char charValue;
	
	@Override
	public Character getValue() {
		return charValue;
	}
	
	@Override
	public void setValue(Character value) {
		charValue = value;
	}
	
	public char getCharValue() {
		return charValue;
	}
	
	public void setCharValue(char charValue) {
		this.charValue = charValue;
	}

	public CharOperand(char charValue) {
		super(char.class, null);
		this.charValue = charValue;
	}
	
	@Override
	public String toString() {
		return "[CharOperand " + String.valueOf(charValue) + "]";
	}
}
