package org.devgupta.hadoop;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class WordCountReducer extends
		Reducer<Text, IntWritable, Text, IntWritable> {

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Context context)
			throws IOException, InterruptedException {
		Integer output = 0;
		for(IntWritable value: values){
			output += value.get();
		}
		context.write(key,new IntWritable(output));
	}
	

}
