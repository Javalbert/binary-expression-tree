package com.javalbert.biexprtree;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionRegistry {
	private final Map<OperatorInfo, Func> functions = new HashMap<>();
	
	public Map<OperatorInfo, Func> getFunctions() {
		return Collections.unmodifiableMap(functions);
	}
	
	public BiFunction getBinaryFunction(BinaryOperatorInfo operatorInfo) {
		BinaryFunc func = (BinaryFunc)functions.get(operatorInfo);
		return func != null ? func.getFunction() : null;
	}
	
	public Function getUnaryFunction(UnaryOperatorInfo operatorInfo) {
		UnaryFunc func = (UnaryFunc)functions.get(operatorInfo);
		return func != null ? func.getFunction() : null;
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
