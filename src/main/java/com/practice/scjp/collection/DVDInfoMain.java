package com.practice.scjp.collection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DVDInfoMain   {
	
	public static void main(String arr[]){
		List<DVDInfo> listOfDVD = new ArrayList<DVDInfo>();
		BufferedReader br = null;
		try{
			
			//Set<String> tsr = new TreeSet<String>();
			String currentLine=null;
			br = new BufferedReader(new FileReader("C:/WorkspacePractice/Practice/src/main/resources/dvdinfo.txt"));
			while((currentLine = br.readLine()) != null){
				
				String str[] = currentLine.split("/");
				listOfDVD.add(new DVDInfo(str[0],str[1],str[2]));
				
			}
			System.out.println("_______________________________________\nNormal output with any sorting\n___________________________________________");
			for(DVDInfo dvdinfo : listOfDVD){
				System.out.println(dvdinfo);
			}
			System.out.println("_________________________________________\n Sorted on title using Comparable\n_______________________________________");
			Collections.sort(listOfDVD);
			for(DVDInfo dvdinfo : listOfDVD){
				System.out.println(dvdinfo);
			}
			System.out.println("_________________________________________\n Sorted on genre using Comparator\n_______________________________________");
			Collections.sort(listOfDVD, new GenreSort());
			for(DVDInfo dvdinfo : listOfDVD){
				System.out.println(dvdinfo);
			}
			System.out.println("_________________________________________\n Sorted on lead Actor using Comparator\n_______________________________________");
			Collections.sort(listOfDVD, new LeadActorSort());
			for(DVDInfo dvdinfo : listOfDVD){
				System.out.println(dvdinfo);
			}
		}
		catch(Exception ex){
			
			ex.printStackTrace();
		}
		finally{
			
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}
