package com.bruno.tests;

public class TestLSH {

	private static final int B = 2;
	private static final int R = 5;
	
	public static void main(String[] args) {
		int[][] signature = {{1,4,1,4}, {2,5,2,5}, {3,6,3,6}, {5,7,5,7}, {6,4,6,4}, {8,3,8,3}, {7,2,7,3}, {6,1,6,3}, {8,4,8,2}, {5,5,5,1}};
		
		//printMatrix(signature);
		printBends(signature);
	}
	
	private static void printBends(int[][] signature) {
		
		for(int bend = 0; bend < B; bend++){
			int counter = 0;
			System.out.println();
			for(int row = R*bend; counter < R; row++, counter++){
				for(int col = 0; col < 4; col++){
					System.out.print(signature[row][col] + " ");
				}
				System.out.println();
			}
		}
	}

	private static void printMatrix(int[][] signature) {
		
		for(int row = 0; row < 10; row++){
			for(int col = 0; col < 4; col++){
				System.out.print(signature[row][col] + " ");
			}
			System.out.println();
		}
		
	}
	
}
