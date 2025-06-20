package org.apache.commons.httpclient.methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileRequestEntity implements RequestEntity {
    final String contentType;
    final File file;

    public FileRequestEntity(File file2, String str) {
        if (file2 != null) {
            this.file = file2;
            this.contentType = str;
            return;
        }
        throw new IllegalArgumentException("File may not be null");
    }

    public long getContentLength() {
        return this.file.length();
    }

    public String getContentType() {
        return this.contentType;
    }

    public boolean isRepeatable() {
        return true;
    }

    public void writeRequest(OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        FileInputStream fileInputStream = new FileInputStream(this.file);
        while (true) {
            try {
                int read = fileInputStream.read(bArr);
                if (read >= 0) {
                    outputStream.write(bArr, 0, read);
                } else {
                    return;
                }
            } finally {
                fileInputStream.close();
            }
        }
    }
}
