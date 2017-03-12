package com.bruno.model;



import java.util.HashSet;
import java.util.Set;


public class Document {

	private String name;

	private Set<String> words;
	private byte[] bitVector;
	
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

	public boolean hasWord(String word) {
		
		if(words.contains(word))
			return true;
		
		return false;
	}
	
}
