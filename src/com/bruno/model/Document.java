package com.bruno.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bruno.methods.Shingle;

public class Document {

	private String name;
	private Set<String> words;
	private byte[] bitVector;
	private int[] minHash;
	
	public Document(){
		words = new HashSet<String>();
	}

	public String getName() {
		return name;
	}

	public Document setName(String name) {
		this.name = name;
		return this;
	}

	public Set<String> getValidWords() {
		return words;
	}

	public Document setValidWords(Set<String> words) {
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

	public boolean hasWord(String word) {
		
		if(words.contains(word))
			return true;
		
		return false;
	}
	
}
