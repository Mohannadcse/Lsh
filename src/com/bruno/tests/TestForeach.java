package com.bruno.tests;

public class TestForeach {

	public static void main(String[] args) {

		String s[] = { "one", "two", "three", "four", "five" };

		boolean flag = false;
		
		for(int i = 0; i < 3; i++){
			for (String str : s) {

				if ("four".equals(str)) {
					break;
				}

				System.out.println(str);

			}
		}

	}

}
