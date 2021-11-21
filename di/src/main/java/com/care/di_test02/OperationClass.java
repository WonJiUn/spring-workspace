package com.care.di_test02;

public class OperationClass {
	public int operation(int num1, int num2, String op) {
		
		if(op.equals("+")) {
			return num1 + num2;
		}else if(op.equals("-")){
			return num1 - num2;
		}else if(op.equals("*")) {
			return num1 * num2;
		}else if(op.equals("/")) {
			return num1 / num2;
		}else {
			return 0;
		}
		
	}
}
