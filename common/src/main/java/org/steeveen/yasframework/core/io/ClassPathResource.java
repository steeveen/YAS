package org.steeveen.yasframework.core.io;

import cn.hutool.core.lang.Assert;
import org.steeveen.yasframework.utils.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 加载类路径下的资源
 * @author steeveen
 * @date 2023/2/19 21:53
 */
public class ClassPathResource implements Resource {
    private final String path;
    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);
        if (is == null) {
            throw new FileNotFoundException(this.path + " 的路径不存在");
        }
        return is;
    }
}
