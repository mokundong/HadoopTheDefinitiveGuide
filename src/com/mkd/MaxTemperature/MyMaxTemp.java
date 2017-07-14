package com.mkd.MaxTemperature;


import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * Created by MKD on 2017/7/13.
 */

public class MyMaxTemp {
    public static void main(String[] args) throws Exception{
        if(args.length != 2){
            System.err.println("Usage:MaxTemperture <input path> <output path>");
            System.exit(-1);
        }
        Job job = Job.getInstance();
        job.setJarByClass(MyMaxTemp.class);
        job.setJobName("MyMaxTemputer");//设置作业名称

        FileInputFormat.addInputPath(job,new Path(args[0]));//输入路径
        FileOutputFormat.setOutputPath(job,new Path(args[1]));//输出路径

        job.setMapperClass(MyMaxTempMapper.class);//设置mapper类型
        job.setReducerClass(MyMaxTempReducer.class);//设置reduce类型

        job.setOutputKeyClass(Text.class);//设置输出key类型
        job.setOutputValueClass(IntWritable.class);//设置输出value类型

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}



