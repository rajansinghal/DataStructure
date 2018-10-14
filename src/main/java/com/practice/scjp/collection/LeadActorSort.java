package com.practice.scjp.collection;

import java.util.Comparator;

public class LeadActorSort implements Comparator<DVDInfo> {

	
	public int compare(DVDInfo a , DVDInfo b){
		
		return a.getLeadActor().compareTo(b.getLeadActor());
	}
	
}
