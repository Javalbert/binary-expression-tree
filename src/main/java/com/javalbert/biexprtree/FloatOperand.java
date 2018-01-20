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

public class FloatOperand extends Operand<Float> {
	private float floatValue;
	
	@Override
	public Float getValue() {
		return floatValue;
	}
	
	@Override
	public void setValue(Float value) {
		floatValue = value;
	}
	
	public float getFloatValue() {
		return floatValue;
	}
	
	public void setFloatValue(float floatValue) {
		this.floatValue = floatValue;
	}

	public FloatOperand(float floatValue) {
		super(float.class, null);
		this.floatValue = floatValue;
	}
	
	@Override
	public String toString() {
		return "[FloatOperand " + Float.toString(floatValue) + "]";
	}
}
