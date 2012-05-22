package org.devgupta.singlethreaded;
import java.io.File;
import java.io.IOException;


public class WordCountRunner {

	
	public static void main(String[] args){
		try {
			WordCounter counter = new WordCounter(new File("input.txt"));
			counter.count();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
