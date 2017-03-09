package com.bruno.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestMinhashBookExample {

	private static final int TOTAL_HASH_FUNCTIONS = 2;
	private static final int TOTAL_DOCUMENTS = 4;

	public static void main(String[] args) {
		/*
		 * int document1[] = new int[TOTAL_SHINGLE_VOCABULARY]; int document2[]
		 * = new int[TOTAL_SHINGLE_VOCABULARY]; int document3[] = new
		 * int[TOTAL_SHINGLE_VOCABULARY]; int document4[] = new
		 * int[TOTAL_SHINGLE_VOCABULARY];
		 */

		int signature[][] = new int[TOTAL_HASH_FUNCTIONS][TOTAL_DOCUMENTS];
		for (int i = 0; i < TOTAL_HASH_FUNCTIONS; i++) {
			for (int j = 0; j < TOTAL_DOCUMENTS; j++) {
				signature[i][j] = Integer.MAX_VALUE;
			}
		}

		int document1[] = { 1, 0, 0, 1, 0 };
		int document2[] = { 0, 0, 1, 0, 0 };
		int document3[] = { 0, 1, 0, 1, 1 };
		int document4[] = { 1, 0, 1, 1, 0 };

		List<int[]> listDocuments = new ArrayList<int[]>();
		listDocuments.add(document1);
		listDocuments.add(document2);
		listDocuments.add(document3);
		listDocuments.add(document4);

		for (int i = 0; i < listDocuments.size(); i++) {
			
			Random rand = new Random();
			int a = rand.nextInt(60000) + 0;
			int b = rand.nextInt(60000) + 0;
			int p  = 62383;
			
			int[] document = listDocuments.get(i);
			//int valueHash1 = calculateHash(document, 1);// document, hash function id
			//int valueHash2 = calculateHash(document, 2);// document, hash function id
			
			int valueHash1 = calculateHash(document, a, b, p);// document, hash function id
			int valueHash2 = calculateHash(document, a, b, p);// document, hash function id

			signature = updateSigMatrix(valueHash1, 1, signature, i);// value, hash function id
			signature = updateSigMatrix(valueHash2, 2, signature, i);// value, hash function id

		}
		
		for(int i = 0; i < TOTAL_HASH_FUNCTIONS; i++){
			for(int j = 0; j < TOTAL_DOCUMENTS; j++){
				System.out.print(signature[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static int calculateHash(int[] document, int a, int b, int p) {

		int minHash = Integer.MAX_VALUE;
		
		
		
		for (int i = 0; i < document.length; i++) {
			if (document[i] == 1) {
				int hashValue = (a*i + b) % p;

				if (hashValue < minHash) {
					minHash = hashValue;
				}
			}
		}
		
		/*if (hashId == 1) {

			for (int i = 0; i < document.length; i++) {
				if (document[i] == 1) {
					int hashValue = (i + 1) % 5;

					if (hashValue < minHash) {
						minHash = hashValue;
					}
				}
			}

		} else if (hashId == 2) {
			for (int i = 0; i < document.length; i++) {
				if (document[i] == 1) {
					int hashValue = (3 * i + 1) % 5;

					if (hashValue < minHash) {
						minHash = hashValue;
					}
				}
			}
		}*/

		return minHash;
	}

	private static int[][] updateSigMatrix(int valueHash, int hashId, int[][] signature, int documentColumn) {

		signature[hashId - 1][documentColumn] = valueHash;

		return signature;
	}

}
