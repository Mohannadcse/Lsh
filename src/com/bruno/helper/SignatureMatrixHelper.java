package com.bruno.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.bruno.model.Document;

public class SignatureMatrixHelper {
	
	private static int P = 62383;
	
	public static int[][] build(List<Document> documents, int totalHashFunctions){
		
		int signature[][] = new int[totalHashFunctions][documents.size()];
		for (int i = 0; i < totalHashFunctions; i++) {
			for (int j = 0; j < documents.size(); j++) {
				signature[i][j] = Integer.MAX_VALUE;
			}
		}
		
		int valuesA[] = generateRandomValues(totalHashFunctions);
		int valuesB[] = generateRandomValues(totalHashFunctions);
		
		for(int hashId = 0; hashId < totalHashFunctions; hashId++){
			
			for (int i = 0; i < documents.size(); i++) {
				
				byte[] document = documents.get(i).getBitVector();
				int valueHash1 = calculateHash(document, valuesA[hashId], valuesB[hashId]);// document, hash function id
				signature = updateSigMatrix(valueHash1, hashId, signature, i);// value, hash function id
			}
			
		}

		return signature;
	}
	
	private static int[] generateRandomValues(int totalHashFunctions) {
		
		Random rand = new Random();
		int randomValues[] = new int[totalHashFunctions];
		
		for(int i = 0; i < totalHashFunctions; i++){
			randomValues[i] = rand.nextInt(600) + 0;
		}
		
		return randomValues;
	}

	private static int calculateHash(byte[] document, int a, int b) {

		int minHash = Integer.MAX_VALUE;
		
		for (int i = 0; i < document.length; i++) {
			if (document[i] == 1) {
				int hashValue = (a*i + b) % P;

				if (hashValue < minHash) {
					minHash = hashValue;
				}
			}
		}

		return minHash;
	}

	private static int[][] updateSigMatrix(int valueHash, int hashId, int[][] signature, int documentColumn) {

		//signature[hashId - 1][documentColumn] = valueHash;
		signature[hashId][documentColumn] = valueHash;

		return signature;
	}
	
}
