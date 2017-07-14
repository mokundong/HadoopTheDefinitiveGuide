package com.mkd.HDFSDemo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

/**
 * Created by MKD on 2017/7/14.
 * FileCopyWithProgress
 */
public class HDFSDemo_3_4 {
    public static void main(String[] args) throws Exception{
        String localurl = "D://work//JData//data//JData_Comment.csv";
        String dfsurl = "hdfs://192.168.64.100:8020/user/hadoop/JData_Comment.csv";
        InputStream in = new BufferedInputStream(new FileInputStream(localurl));
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(dfsurl),conf);
        OutputStream out = fs.create(new Path(dfsurl), new Progressable() {
            public void progress() {

            }
        });
        IOUtils.copyBytes(in,out,4096,true);
        System.out.println("over");
    }
}
