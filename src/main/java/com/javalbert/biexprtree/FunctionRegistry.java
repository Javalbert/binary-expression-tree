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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FunctionRegistry {
	private final Map<OperatorInfo, Func> functions = new HashMap<>();
	
	public Map<OperatorInfo, Func> getFunctions() {
		return Collections.unmodifiableMap(functions);
	}
	
	public BinaryFunc getBinaryFunc(BinaryOperatorInfo operatorInfo) {
		return (BinaryFunc)functions.get(operatorInfo);
	}
	
	public UnaryFunc getUnaryFunc(UnaryOperatorInfo operatorInfo) {
		return (UnaryFunc)functions.get(operatorInfo);
	}
	
	public <T, U> void register(BinaryFunc<T, U> bifunc) {
		functions.put(bifunc.getOperatorInfo(), bifunc);
	}
	
	public <T> void register(UnaryFunc<T> ufunc) {
		functions.put(ufunc.getOperatorInfo(), ufunc);
	}
	
	void register(Func func) {
		functions.put(func.getOperatorInfo(), func);
	}
}
