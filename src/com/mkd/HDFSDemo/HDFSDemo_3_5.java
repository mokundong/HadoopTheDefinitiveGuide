package com.mkd.HDFSDemo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.mapreduce.Cluster;
import org.apache.hadoop.util.Progressable;
import org.junit.Before;

import java.io.*;
import java.net.URI;

/**
 * Created by MKD on 2017/7/14.
 * 查询文件，文件元数据FileStatus
 */
public class HDFSDemo_3_5 {
    private Cluster cluster;
    private FileSystem fs;

    @Before
    public void setUp() throws IOException{
        Configuration conf = new Configuration();
        if(System.getProperty("test.build.data") == null){

        }
    }
}
