package com.javalbert.biexprtree;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FunctionRegistry {
	private final Map<OperatorInfo, Func> functions = new HashMap<>();
	
	public Map<OperatorInfo, Func> getFunctions() {
		return Collections.unmodifiableMap(functions);
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
