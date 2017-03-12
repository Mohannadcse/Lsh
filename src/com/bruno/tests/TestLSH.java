package com.bruno.tests;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bruno.methods.Lsh;
import com.bruno.model.Document;


public class TestLSH {

	public static void main(String[] args) {
		//int[][] signature = { { 1, 4, 1, 4 }, { 2, 5, 2, 5 }, { 3, 6, 3, 6 }, { 5, 7, 5, 7 }, { 6, 4, 6, 4 }, { 8, 3, 8, 3 }, { 7, 2, 7, 3 }, { 6, 1, 6, 3 }, { 8, 4, 8, 2 }, { 5, 5, 5, 1 } };
		
		//int[][] signature = {{1,3,0,1},{0,2,0,0}};
		int[][] signature = {{17506, 41966, 4043, 17506}, {27849, 48679, 7126, 27849}};
		Document d1 = new Document();
		d1.setName("d1");
		Set<String> w1 = new HashSet<String>();
		w1.add(signature[0][0]+"");w1.add(signature[1][0]+"");
		
		Document d2 = new Document();
		d2.setName("d2");
		Set<String> w2 = new HashSet<String>();
		w1.add(signature[0][1]+"");w2.add(signature[1][1]+"");
		
		Document d3 = new Document();
		d3.setName("d3");
		Set<String> w3 = new HashSet<String>();
		w1.add(signature[0][2]+"");w3.add(signature[1][2]+"");
		
		Document d4 = new Document();
		d4.setName("d4");
		Set<String> w4 = new HashSet<String>();
		w1.add(signature[0][3]+"");w4.add(signature[1][3]+"");
		
		List<Document> list = new ArrayList<Document>();
		list.add(d1);
		list.add(d2);
		list.add(d3);
		list.add(d4);
		
		Lsh.calculate(list, signature);
		
		//printMatrix(signature);
		//printBends(signature);
		//throwInBuckets(signature, names);
	}

}
