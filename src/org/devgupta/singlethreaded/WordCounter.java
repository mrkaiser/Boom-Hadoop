package org.devgupta.singlethreaded;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;


public class WordCounter {
	
	protected File file;
	
	public WordCounter(File file) throws IOException{
		this.file = file;
		
	}
	
	public void count() throws IOException{
		countWordsAndOutputFile();
	}
	
	
	private void countWordsAndOutputFile() throws IOException{
		BufferedReader lineReader = openFile();
		HashMap<String,Integer> countedWords = countWords(lineReader);
		writeFile(countedWords);
	}
	
	protected BufferedReader openFile() throws FileNotFoundException{
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		return bufferedReader;
		
	}
	
	protected HashMap<String,Integer> countWords(BufferedReader reader) throws IOException{
		//we can't get an iterator from lines
		String readLine = reader.readLine();
		HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
		do{
			//call a split
			String[] splitString = readLine.split(" ");
			//iterate over the
			for(String el : splitString){
				//the following should work because no string should be null (null string can only be explicit
				hashMap.put(el, (hashMap.get(el) == null ? 1 : hashMap.get(el).intValue() + 1));
			}
		}while((readLine = reader.readLine())!= null);
		return  hashMap;
	}
	
	protected void writeFile(HashMap<String,Integer> hashMap) throws IOException{
		//build a file writer
		FileWriter fileWriter = new FileWriter(new File("output.txt"));
		//grab the Key Set
		Set<String> keysOpenDoors = hashMap.keySet();
		for(String key: keysOpenDoors){
			//grab the value and write it to the file then write a new line
			Integer value = hashMap.get(key);
			fileWriter.write(key+ ":"+value + "\n");
		}
		fileWriter.close();
		
	}

}
