package com.bruno.model;

import java.util.List;

import com.bruno.methods.Shingle;

public class Document {

	private String name;
	private List<String> words;
	private byte[] bitVector;
	private int[] minHash;
	
	public Document(){}

	public String getName() {
		return name;
	}

	public Document setName(String name) {
		this.name = name;
		return this;
	}

	public List<String> getValidWords() {
		return words;
	}

	public Document setValidWords(List<String> words) {
		this.words = words;
		return this;
	}

	public byte[] getBitVector() {
		return bitVector;
	}

	public Document setBitVector(byte[] bitVector) {
		this.bitVector = bitVector;
		return this;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

	public void initializeBitVector(int size) {
		this.bitVector = new byte[size];
	}

	public void updateBitVector(byte value, int position) {
		this.bitVector[position] = value;
		
	}
	
	public void updateMinHash(int value, int position){
		this.minHash[position] = value;
	}
	
}
