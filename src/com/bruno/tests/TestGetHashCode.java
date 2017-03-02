package com.bruno.tests;

public class TestGetHashCode {

	public static void main(String[] args) {
		
		String s1 = "hi";
		String s2 = "he";
		String s3 = "hi";
		
		System.out.println("Strings");
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		System.out.println();
		
		//Here I create my own hashCode
		MyObject obj1 = new MyObject(2, "Bruno");
		MyObject obj2 = new MyObject(2, "Bruno");
		MyObject obj3 = new MyObject(1, "Bruna");
		MyObject obj4 = new MyObject(1, "Bruno");
		System.out.println("XOR: " + (obj1.hashCode() ^ obj2.hashCode()));
		
		System.out.println("Objects");
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		System.out.println(obj3.hashCode());
		System.out.println(obj4.hashCode());
		System.out.println();
		
		Integer n1 = 1;
		Integer n2 = 2;
		Integer n3 = 3;
		Integer n4 = 1;
		
		System.out.println("Integer");
		System.out.println(n1.hashCode());
		System.out.println(n2.hashCode());
		System.out.println(n3.hashCode());
		System.out.println(n4.hashCode());
		System.out.println();
		
	}
	
}
