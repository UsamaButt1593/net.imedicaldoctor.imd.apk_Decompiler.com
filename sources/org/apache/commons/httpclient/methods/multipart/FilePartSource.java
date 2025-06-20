package org.apache.commons.httpclient.methods.multipart;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FilePartSource implements PartSource {
    private File file;
    private String fileName;

    public FilePartSource(File file2) throws FileNotFoundException {
        this.fileName = null;
        this.file = file2;
        if (file2 == null) {
            return;
        }
        if (!file2.isFile()) {
            throw new FileNotFoundException("File is not a normal file.");
        } else if (file2.canRead()) {
            this.fileName = file2.getName();
        } else {
            throw new FileNotFoundException("File is not readable.");
        }
    }

    public InputStream createInputStream() throws IOException {
        return this.file != null ? new FileInputStream(this.file) : new ByteArrayInputStream(new byte[0]);
    }

    public String getFileName() {
        String str = this.fileName;
        return str == null ? "noname" : str;
    }

    public long getLength() {
        File file2 = this.file;
        if (file2 != null) {
            return file2.length();
        }
        return 0;
    }

    public FilePartSource(String str, File file2) throws FileNotFoundException {
        this(file2);
        if (str != null) {
            this.fileName = str;
        }
    }
}
