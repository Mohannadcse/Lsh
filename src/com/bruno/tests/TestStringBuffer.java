package com.bruno.tests;

public class TestStringBuffer {

	public static void main(String[] args) {
		
		int[] x = {1,2,3,4,5};
		
		StringBuffer sb = new StringBuffer();
		
		for(int a : x)
			sb.append(a);
		
		System.out.println(sb.toString());
		
	}
	
}
