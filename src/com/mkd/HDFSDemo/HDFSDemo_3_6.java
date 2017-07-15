package com.mkd.HDFSDemo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Cluster;
import org.junit.Before;
import scala.reflect.io.File;

import java.io.IOException;
import java.net.URI;

/**
 * Created by MKD on 2017/7/14.
 * 列出文件，文件元数据ListStatus
 */
public class HDFSDemo_3_6 {
    public static void main(String[] args) throws Exception{
        String url = args[0];
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(url),conf);

        Path[] paths = new Path[args.length];
        for(int i = 0;i<paths.length;i++){
            paths[i] = new Path(args[i]);
        }
        FileStatus[] status = fs.listStatus(paths);
        Path[] listedPaths = FileUtil.stat2Paths(status);//将FileStatus对象数组转换成Path对象数组
        for(Path p:listedPaths){
            System.out.println(p);
        }
    }
}
