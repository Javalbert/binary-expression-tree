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

public class BooleanOperand extends Operand<Boolean> {
	private boolean booleanValue;
	
	@Override
	public Boolean getValue() {
		return booleanValue;
	}
	
	@Override
	public void setValue(Boolean value) {
		booleanValue = value;
	}
	
	public boolean getBooleanValue() {
		return booleanValue;
	}
	
	public void setBooleanValue(boolean booleanValue) {
		this.booleanValue = booleanValue;
	}

	public BooleanOperand(boolean booleanValue) {
		super(boolean.class, null);
		this.booleanValue = booleanValue;
	}
	
	@Override
	public String toString() {
		return "[BooleanOperand " + String.valueOf(booleanValue) + "]";
	}
}
