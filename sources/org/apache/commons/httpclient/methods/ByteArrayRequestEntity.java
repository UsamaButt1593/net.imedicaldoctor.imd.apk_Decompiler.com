package org.apache.commons.httpclient.methods;

import java.io.IOException;
import java.io.OutputStream;

public class ByteArrayRequestEntity implements RequestEntity {
    private byte[] content;
    private String contentType;

    public ByteArrayRequestEntity(byte[] bArr) {
        this(bArr, (String) null);
    }

    public byte[] getContent() {
        return this.content;
    }

    public long getContentLength() {
        return (long) this.content.length;
    }

    public String getContentType() {
        return this.contentType;
    }

    public boolean isRepeatable() {
        return true;
    }

    public void writeRequest(OutputStream outputStream) throws IOException {
        outputStream.write(this.content);
    }

    public ByteArrayRequestEntity(byte[] bArr, String str) {
        if (bArr != null) {
            this.content = bArr;
            this.contentType = str;
            return;
        }
        throw new IllegalArgumentException("The content cannot be null");
    }
}
