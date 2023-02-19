package org.steeveen.yasframework.core.io;

import cn.hutool.core.lang.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * 加载网络资源
 * @author steeveen
 * @date 2023/2/19 22:09
 */
public class UrlResource implements Resource{
    private final URL url;

    public UrlResource(URL url) {
        Assert.notNull(url,"URL must not be null");
        this.url = url;
    }


    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection conn=this.url.openConnection();
        try{

            return conn.getInputStream();
        }catch (IOException ioe){
            //发生异常后，尽量看是否可以关闭连接，并将异常继续上抛
            if (conn instanceof HttpURLConnection){
                ((HttpURLConnection) conn).disconnect();
            }
            throw ioe;
        }
    }
}
