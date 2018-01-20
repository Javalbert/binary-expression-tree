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

public class IntOperand extends Operand<Integer> {
	private int intValue;
	
	@Override
	public Integer getValue() {
		return intValue;
	}
	
	@Override
	public void setValue(Integer value) {
		intValue = value;
	}
	
	public int getIntValue() {
		return intValue;
	}
	
	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}

	public IntOperand(int intValue) {
		super(int.class, null);
		this.intValue = intValue;
	}
	
	@Override
	public String toString() {
		return "[IntOperand " + Integer.toString(intValue) + "]";
	}
}
