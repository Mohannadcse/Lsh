package com.bruno.helper;

public class MyParser {

	public static String parseElement(String element) {
		return element.replaceAll("[^a-zA-Z0-9]", " ");
	}

}
