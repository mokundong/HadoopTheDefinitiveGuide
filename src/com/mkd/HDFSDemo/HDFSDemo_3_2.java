package com.mkd.HDFSDemo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.InputStream;
import java.net.URI;

/**
 * Created by MKD on 2017/7/14.
 */
public class HDFSDemo_3_2 {
    public static void main(String[] args) throws Exception{
        String url = "hdfs://192.168.64.100:8020/user/hadoop/words.txt";
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(url),conf);
        InputStream in = null;
        try{
            in = fs.open(new Path(url));
            IOUtils.copyBytes(in,System.out,4096,false);
        }finally {
            IOUtils.closeStream(in);
        }
    }
}
