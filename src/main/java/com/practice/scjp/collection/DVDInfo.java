package com.practice.scjp.collection;

public class DVDInfo implements Comparable<DVDInfo>{
	private String title;
	private String genre;
	private String leadActor;
	
	DVDInfo(String t, String g, String a) {

		this.title = t; 
		this.genre = g; 
		this.leadActor = a;
	}
	public String toString() {
		return title + " | " + genre + " |" + leadActor + "\n";
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLeadActor() {
		return leadActor;
	}
	public void setLeadActor(String leadActor) {
		this.leadActor = leadActor;
	}
	
	public int compareTo(DVDInfo d) {
		// TODO Auto-generated method stub
	
		return this.title.compareTo(d.getTitle());
	}
	
	
}