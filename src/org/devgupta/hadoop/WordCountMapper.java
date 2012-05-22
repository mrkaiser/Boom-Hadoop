package org.devgupta.hadoop;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		//we need split the line by space
		String[] splitArray = value.toString().split(" ");
		//for each of the words emit the key (which is the word and the number 1
		for(String el : splitArray){
			context.write(new Text(el), new IntWritable(1));
		}
	}

}
