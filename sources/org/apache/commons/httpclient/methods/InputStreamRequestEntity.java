package org.apache.commons.httpclient.methods;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class InputStreamRequestEntity implements RequestEntity {
    public static final int CONTENT_LENGTH_AUTO = -2;
    private static final Log LOG;
    static /* synthetic */ Class class$org$apache$commons$httpclient$methods$InputStreamRequestEntity;
    private byte[] buffer;
    private InputStream content;
    private long contentLength;
    private String contentType;

    static {
        Class cls = class$org$apache$commons$httpclient$methods$InputStreamRequestEntity;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.methods.InputStreamRequestEntity");
            class$org$apache$commons$httpclient$methods$InputStreamRequestEntity = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    public InputStreamRequestEntity(InputStream inputStream) {
        this(inputStream, (String) null);
    }

    private void bufferContent() {
        if (this.buffer == null && this.content != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = this.content.read(bArr);
                    if (read >= 0) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        this.buffer = byteArray;
                        this.content = null;
                        this.contentLength = (long) byteArray.length;
                        return;
                    }
                }
            } catch (IOException e2) {
                LOG.error(e2.getMessage(), e2);
                this.buffer = null;
                this.content = null;
                this.contentLength = 0;
            }
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public InputStream getContent() {
        return this.content;
    }

    public long getContentLength() {
        if (this.contentLength == -2 && this.buffer == null) {
            bufferContent();
        }
        return this.contentLength;
    }

    public String getContentType() {
        return this.contentType;
    }

    public boolean isRepeatable() {
        return this.buffer != null;
    }

    public void writeRequest(OutputStream outputStream) throws IOException {
        if (this.content != null) {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = this.content.read(bArr);
                if (read >= 0) {
                    outputStream.write(bArr, 0, read);
                } else {
                    return;
                }
            }
        } else {
            byte[] bArr2 = this.buffer;
            if (bArr2 != null) {
                outputStream.write(bArr2);
                return;
            }
            throw new IllegalStateException("Content must be set before entity is written");
        }
    }

    public InputStreamRequestEntity(InputStream inputStream, long j2) {
        this(inputStream, j2, (String) null);
    }

    public InputStreamRequestEntity(InputStream inputStream, long j2, String str) {
        this.buffer = null;
        if (inputStream != null) {
            this.content = inputStream;
            this.contentLength = j2;
            this.contentType = str;
            return;
        }
        throw new IllegalArgumentException("The content cannot be null");
    }

    public InputStreamRequestEntity(InputStream inputStream, String str) {
        this(inputStream, -2, str);
    }
}
