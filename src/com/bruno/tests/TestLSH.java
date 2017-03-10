package com.bruno.tests;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;


public class TestLSH {

	private static final int B = 2;
	private static final int R = 1;
	private static final int TOTAL_DOCUMENTS = 4;
	private static final int TOTAL_HASH = 2;
	

	public static void main(String[] args) {
		//int[][] signature = { { 1, 4, 1, 4 }, { 2, 5, 2, 5 }, { 3, 6, 3, 6 }, { 5, 7, 5, 7 }, { 6, 4, 6, 4 }, { 8, 3, 8, 3 }, { 7, 2, 7, 3 }, { 6, 1, 6, 3 }, { 8, 4, 8, 2 }, { 5, 5, 5, 1 } };
		
		int[][] signature = {{1,3,0,1},{0,2,0,0}};
		String names[] = {"d1", "d2", "d3", "d4"};
		
		//printMatrix(signature);
		//printBends(signature);
		throwInBuckets(signature, names);
	}

	private static void throwInBuckets(int[][] signature, String names[]) {
		
		List<HashMap<String, List<String>>> bucketsAllBands = new ArrayList<HashMap<String, List<String>>>();
		
		for (int bend = 0; bend < B; bend++) {
			
			HashMap<String, List<String>> buckets = new HashMap<String, List<String>>();
			
			for (int col = 0; col < TOTAL_DOCUMENTS; col++) {
				int counter = 0;
				
				int array[] = new int[R];
				String s = "";
				
				for (int row = R * bend; counter < R; row++, counter++) {
					array[counter] = signature[row][col];
					s += signature[row][col];
					//System.out.print(signature[row][col] + " ");
					
				}
				
				if(buckets.containsKey(s)){
					List<String> namesToBucket = buckets.get(s);
					namesToBucket.add(names[col]);
					buckets.put(s, namesToBucket);
					//System.out.println("hashed with: " + Arrays.toString(array));
				}
				else{
					//System.out.println("added: " + Arrays.toString(array));
					List<String> namesToBucket = new ArrayList<String>();
					namesToBucket.add(names[col]);
					buckets.put(s, namesToBucket);
				}
			}
			
			bucketsAllBands.add(bend, buckets);
		}
		
		for(int i = 0; i < bucketsAllBands.size(); i++ ){
			
			HashMap<String, List<String>> hashMap = bucketsAllBands.get(i);
			Set<String> keysBuckets = hashMap.keySet();
			
			System.out.println("Band: " + i);
			
			for(String key : keysBuckets){
				System.out.println("Bucket: " + key);
				
				for(String docs : hashMap.get(key)){
					System.out.print(docs + ", ");
				}
				System.out.println();
			}
			System.out.println();
		}

	}

	private static void printBends(int[][] signature) {

		for (int bend = 0; bend < B; bend++) {
			int counter = 0;
			System.out.println();
			for (int row = R * bend; counter < R; row++, counter++) {
				for (int col = 0; col < TOTAL_DOCUMENTS; col++) {
					System.out.print(signature[row][col] + " ");
				}
				System.out.println();
			}
		}
	}

	private static void printMatrix(int[][] signature) {

		for (int row = 0; row < TOTAL_HASH; row++) {
			for (int col = 0; col < TOTAL_DOCUMENTS; col++) {
				System.out.print(signature[row][col] + " ");
			}
			System.out.println();
		}

	}

}
