package org.devgupta.hadoop;

import java.util.Date;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class WordCountJob extends Configured implements Tool {

	@Override
	public int run(String[] args) throws Exception {
		Job job = new Job();
		job.setJarByClass(WordCountJob.class);
		job.setJobName("Word Count Test");
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.setMapperClass(WordCountMapper.class);
		job.setCombinerClass(WordCountReducer.class);
		job.setReducerClass(WordCountReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		return job.waitForCompletion(true) ? 0 : 1;
	}
	
	public static void main(String[] args){
		long startTime = new Date().getTime();
		String[] someArgs = {"pg16452.txt","output"};
		try{
			ToolRunner.run(new Configuration(), new WordCountJob(),someArgs);
		}catch(Exception e){
			e.printStackTrace();
		}
		long endTime = new Date().getTime();
		System.out.println("Elapsed Time:"+ (endTime - startTime));
	}

}
