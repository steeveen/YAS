package org.steeveen.yasframework.core.io;

/**
 * 对资源进行加载
 *
 * @author steeveen
 * @date 2023/2/19 22:17
 */
public interface ResourceLoader {
    //加载类路径时，需要使用的前缀
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
