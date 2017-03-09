package com.bruno.tests;

import java.util.HashMap;

public class TestLSH {

	private static final int B = 2;
	private static final int R = 5;

	public static void main(String[] args) {
		int[][] signature = { { 1, 4, 1, 4 }, { 2, 5, 2, 5 }, { 3, 6, 3, 6 }, { 5, 7, 5, 7 }, { 6, 4, 6, 4 },
				{ 8, 3, 8, 3 }, { 7, 2, 7, 3 }, { 6, 1, 6, 3 }, { 8, 4, 8, 2 }, { 5, 5, 5, 1 } };

		// printMatrix(signature);
		//printBends(signature);
		throwInBuckets(signature);
	}

	private static void throwInBuckets(int[][] signature) {
		
		HashMap<int[], int[]> buckets = new HashMap<int[], int[]>(4);
		
		for (int bend = 0; bend < B; bend++) {
			
			System.out.println();

			for (int col = 0; col < 4; col++) {
				int counter = 0;
				
				int array[] = new int[R];
				
				for (int row = R * bend; counter < R; row++, counter++) {
					array[counter] = signature[row][col];
					//System.out.print(signature[row][col] + " ");
					
					
					if(buckets.containsKey(array)){
						System.out.println("hashed with: " + array);
					}
					else{
						System.out.println("added: " + array);
						buckets.put(array, array);
					}
					
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
				for (int col = 0; col < 4; col++) {
					System.out.print(signature[row][col] + " ");
				}
				System.out.println();
			}
		}
	}

	private static void printMatrix(int[][] signature) {

		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 4; col++) {
				System.out.print(signature[row][col] + " ");
			}
			System.out.println();
		}

	}

}
