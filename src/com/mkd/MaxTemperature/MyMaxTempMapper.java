package com.mkd.MaxTemperature;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

/**
 * Created by MKD on 2017/7/13.
 */
public class MyMaxTempMapper extends Mapper<LongWritable,Text,Text,IntWritable> {
    private static final int MISSING = 9999;
    @Override
    public void map(LongWritable key,Text value,Context context)
            throws IOException,InterruptedException{
        String line = value.toString();
        String year = line.substring(15,19);
        int airTemperature;
        //提取气温 + / -
        if(line.charAt(87) == '+'){
            airTemperature = Integer.parseInt(line.substring(88,92));//将string转化成int
        }else{
            airTemperature = Integer.parseInt(line.substring(87,92));
        }
        //质量
        String quality = line.substring(92,93);
        //判断气温有效性
        if(airTemperature != MISSING && quality.matches("[01459]")){
            context.write(new Text(year),new IntWritable(airTemperature));
        }
    }
}

