package org.steeveen.yasframework.test;

import cn.hutool.core.io.IoUtil;
import org.junit.Before;
import org.junit.Test;
import org.steeveen.yasframework.core.io.DefaultResourceLoader;
import org.steeveen.yasframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author steeveen
 * @date 2023/3/4 17:51
 */
public class PropertiesParseTest {
    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }


//    @Test
//    public void test_url() throws IOException {
//        Resource resource = resourceLoader.getResource("https://github.com.fuzhengwei/small-spring/important.properties");
//        InputStream inputStream = resource.getInputStream();
//        String content = IoUtil.readUtf8(inputStream);
//        System.out.println(content);
//    }
}
