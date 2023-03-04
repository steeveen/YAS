package org.steeveen.yasframework.core.io;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author steeveen
 * @date 2023/2/19 22:19
 */
public class DefaultResourceLoader implements ResourceLoader{
    /**
     * 工厂模式，根据传入的路径不同，创建不同的Resource返回
     * @param location
     * @return
     */
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location,"Location must not be null");
        if (location.startsWith(CLASSPATH_URL_PREFIX)){
            //如果是包含了”classPath:“的类路径，那么在创建ClassPathResource时，去掉前缀
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }else{
            try{
                //用url的方式尝试加载
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                //如果加载失败，再用文件系统方式进行尝试
                return new FileSystemResource(location);
            }
        }
    }
}
