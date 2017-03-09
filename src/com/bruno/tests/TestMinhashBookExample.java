package com.bruno.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.bruno.helper.SignatureMatrixHelper;
import com.bruno.model.Document;

public class TestMinhashBookExample {

	private static final int TOTAL_HASH_FUNCTIONS = 2;
	private static final int TOTAL_DOCUMENTS = 4;

	public static void main(String[] args) {

		byte document1[] = { 1, 0, 0, 1, 0 };
		byte document2[] = { 0, 0, 1, 0, 0 };
		byte document3[] = { 0, 1, 0, 1, 1 };
		byte document4[] = { 1, 0, 1, 1, 0 };
		
		Document d1 = new Document();
		d1.setBitVector(document1);
		
		Document d2 = new Document();
		d2.setBitVector(document2);
		
		Document d3 = new Document();
		d3.setBitVector(document3);
		
		Document d4 = new Document();
		d4.setBitVector(document4);
		
		List<Document> listDocuments = new ArrayList<Document>();
		listDocuments.add(d1);
		listDocuments.add(d2);
		listDocuments.add(d3);
		listDocuments.add(d4);

		int signature[][] = SignatureMatrixHelper.build(listDocuments, TOTAL_HASH_FUNCTIONS);
		
		for(int i = 0; i < TOTAL_HASH_FUNCTIONS; i++){
			for(int j = 0; j < TOTAL_DOCUMENTS; j++){
				System.out.print(signature[i][j] + " ");
			}
			System.out.println();
		}

	}

}
