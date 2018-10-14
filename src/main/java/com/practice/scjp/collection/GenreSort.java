package com.practice.scjp.collection;

import java.util.Comparator;

public class GenreSort implements Comparator<DVDInfo> {

	
	public int compare(DVDInfo a , DVDInfo b){
		
		return a.getGenre().compareTo(b.getGenre());
	}
	
}
