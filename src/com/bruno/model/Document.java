package com.bruno.model;

import java.util.List;

import com.bruno.methods.Shingle;

public class Document {

	private String name;
	private List<String> shingles;
	private int[] bitVector;
	private int[] minHash;
	
	public Document(){}

	public String getName() {
		return name;
	}

	public Document setName(String name) {
		this.name = name;
		return this;
	}

	public List<String> getShingles() {
		return shingles;
	}

	public Document setShingles(List<String> shingles) {
		this.shingles = shingles;
		return this;
	}

	public int[] getBitVector() {
		return bitVector;
	}

	public Document setBitVector(int[] bitVector) {
		this.bitVector = bitVector;
		return this;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

	public void initializeBitVector(int size) {
		this.bitVector = new int[size];
	}

	public void updateBitVector(int value, int position) {
		this.bitVector[position] = value;
		
	}
	
	public void updateMinHash(int value, int position){
		this.minHash[position] = value;
	}
	
}
