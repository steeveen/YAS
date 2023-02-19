package org.steeveen.yasframework.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 加载文件系统下的资源
 * @author steeveen
 * @date 2023/2/19 22:05
 */
public class FileSystemResource implements Resource{
    private final File file;
    private final String  path;

    public FileSystemResource(File file) {
        this.file = file;
        this.path=file.getPath();
    }


    public FileSystemResource(String path) {
        this.file=new File(path);
        this.path = path;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    public final String getPath() {
        return path;
    }
}
