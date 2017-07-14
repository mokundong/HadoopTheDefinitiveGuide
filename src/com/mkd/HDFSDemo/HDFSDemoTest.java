package com.mkd.HDFSDemo;
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 通过api访问hdfs文件系统
 */
public class HDFSDemoTest {
    static {
        //注册协议处理器工厂，让java程序能够识别hdfs协议
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
    }
    public static void main(String[] args) throws Exception {
        //定义url地址
        String url = "hdfs://192.168.64.100:8020/user/hadoop/words.txt";
        //URL对象
        URL u = new URL(url);
        //URL链接
        URLConnection conn = u.openConnection();
        //打开输入流
        InputStream is = conn.getInputStream();
        //输出流
        FileOutputStream fos = new FileOutputStream("D:\\work\\HadoopTheDefinitiveGuide\\out\\words.txt");
        //对拷贝
        byte[] buf = new byte[1024];
        int len = -1;
        while((len = is.read(buf)) != -1){
            fos.write(buf,0,len);
        }
        is.close();
        fos.close();
        System.out.println("over");
    }
}

