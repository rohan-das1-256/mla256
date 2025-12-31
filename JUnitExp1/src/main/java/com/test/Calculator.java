package com.test;

import java.util.List;

public class Calculator {

	public int add(int x, int y) {
		return x+y;
	}
	
	public int sub(int x, int y) {
		return x-y;
	}
	
	public int mul(int x, int y) {
		return x*y;
	}

	
	//	public int div(int x, int y) {
//		return x/y;
//	}
	
	public List<String> listNames(List<String> names){
		return names;
	}
	
	public String greetUser(String msg) {
		return msg;
	}
	
	public boolean isEmpty(String str) {
		return str ==null || str.isEmpty();
	}
	
	public void checkAge(int age) {
		if(age<0) {
			throw new IllegalArgumentException("Age must be greater than Zero");
		}
	}
}
