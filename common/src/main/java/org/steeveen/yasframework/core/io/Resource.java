package org.steeveen.yasframework.core.io;

import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 对一切的配置资源进行表征
 * @author steeveen
 * @date 2023/2/19 21:52
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
