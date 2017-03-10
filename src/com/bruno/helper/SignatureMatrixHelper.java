package com.bruno.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.bruno.model.Document;

public class SignatureMatrixHelper {

	public static int[][] build(List<Document> documents, int totalHashFunctions){
		
		int signature[][] = new int[totalHashFunctions][documents.size()];
		for (int i = 0; i < totalHashFunctions; i++) {
			for (int j = 0; j < documents.size(); j++) {
				signature[i][j] = Integer.MAX_VALUE;
			}
		}
		
		
		
		
		for (int i = 0; i < documents.size(); i++) {
			
			Random rand = new Random();
			int a = rand.nextInt(60000) + 0;
			int b = rand.nextInt(60000) + 0;
			int p  = 62383;
			
			
			
			byte[] document = documents.get(i).getBitVector();
			int valueHash1 = calculateHash(document, 1);// document, hash function id
			//int valueHash2 = calculateHash(document, 2);// document, hash function id
			
			//int valueHash1 = calculateHash(document, a, b, p);// document, hash function id
			//int valueHash2 = calculateHash(document, a, b, p);// document, hash function id

			signature = updateSigMatrix(valueHash1, 1, signature, i);// value, hash function id
			//signature = updateSigMatrix(valueHash2, 2, signature, i);// value, hash function id

		}
		
		for (int i = 0; i < documents.size(); i++) {
			
			Random rand = new Random();
			int a = rand.nextInt(60000) + 0;
			int b = rand.nextInt(60000) + 0;
			int p  = 62383;
			
			
			
			byte[] document = documents.get(i).getBitVector();
			//int valueHash1 = calculateHash(document, 1);// document, hash function id
			int valueHash2 = calculateHash(document, 2);// document, hash function id
			
			//int valueHash1 = calculateHash(document, a, b, p);// document, hash function id
			//int valueHash2 = calculateHash(document, a, b, p);// document, hash function id

			//signature = updateSigMatrix(valueHash1, 1, signature, i);// value, hash function id
			signature = updateSigMatrix(valueHash2, 2, signature, i);// value, hash function id

		}
		
		return signature;
	}
	
	private static int calculateHash(byte[] document, int hashId) {

		int minHash = Integer.MAX_VALUE;
		
		
		
		/*for (int i = 0; i < document.length; i++) {
			if (document[i] == 1) {
				int hashValue = (a*i + b) % p;

				if (hashValue < minHash) {
					minHash = hashValue;
				}
			}
		}*/
		
		if (hashId == 1) {

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
		}

		return minHash;
	}

	private static int[][] updateSigMatrix(int valueHash, int hashId, int[][] signature, int documentColumn) {

		signature[hashId - 1][documentColumn] = valueHash;

		return signature;
	}
	
}
