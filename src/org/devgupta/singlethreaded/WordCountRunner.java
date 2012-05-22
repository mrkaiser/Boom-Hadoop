package org.devgupta.singlethreaded;
import java.io.File;
import java.io.IOException;
import java.util.Date;


public class WordCountRunner {

	
	public static void main(String[] args){
		long startTime= new Date().getTime();
		
		try {
			WordCounter counter = new WordCounter(new File("pg16452.txt"));
			counter.count();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long endTime = new Date().getTime();
		System.out.println("Elapsed Time:"+ (endTime - startTime));
	}
	
}
