package com.bruno.methods;

import java.util.HashSet;
import java.util.Set;

import com.bruno.model.Document;

public class Jaccard {

	public boolean isSimilar(Document doc1, Document doc2, double threshold){
		
		int intersection = getIntersection(doc1, doc2);
		int union = getUnion(doc1, doc2);
		
		double similarity = 0;
		
		similarity = intersection / union;
		
		if(similarity >= threshold)
			return true;
		
		return false;
	}

	private int getIntersection(Document doc1, Document doc2) {
		
		int counter = 0;
		
		for(String word : doc1.getValidWords()){
			if(doc2.getValidWords().contains(word)){
				counter = counter + 1;
			}
		}
		
		return counter;
	}
	
	private int getUnion(Document doc1, Document doc2){
		
		int counter = 0;
		
		Set<String> union = new HashSet<String>();
		
		for(String s : doc1.getValidWords()){
			union.add(s);
		}
		
		for(String s : doc2.getValidWords()){
			union.add(s);
		}
		
		return union.size();
	}
	
}
