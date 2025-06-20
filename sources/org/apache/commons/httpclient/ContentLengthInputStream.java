package org.apache.commons.httpclient;

import java.io.IOException;
import java.io.InputStream;

public class ContentLengthInputStream extends InputStream {
    private boolean closed;
    private long contentLength;
    private long pos;
    private InputStream wrappedStream;

    public ContentLengthInputStream(InputStream inputStream, int i2) {
        this(inputStream, (long) i2);
    }

    public int available() throws IOException {
        if (this.closed) {
            return 0;
        }
        int available = this.wrappedStream.available();
        long j2 = this.pos;
        long j3 = this.contentLength;
        return ((long) available) + j2 > j3 ? (int) (j3 - j2) : available;
    }

    public void close() throws IOException {
        if (!this.closed) {
            try {
                ChunkedInputStream.exhaustInputStream(this);
            } finally {
                this.closed = true;
            }
        }
    }

    public int read() throws IOException {
        if (!this.closed) {
            long j2 = this.pos;
            if (j2 >= this.contentLength) {
                return -1;
            }
            this.pos = j2 + 1;
            return this.wrappedStream.read();
        }
        throw new IOException("Attempted read from closed stream.");
    }

    public long skip(long j2) throws IOException {
        long skip = this.wrappedStream.skip(Math.min(j2, this.contentLength - this.pos));
        if (skip > 0) {
            this.pos += skip;
        }
        return skip;
    }

    public ContentLengthInputStream(InputStream inputStream, long j2) {
        this.pos = 0;
        this.closed = false;
        this.wrappedStream = inputStream;
        this.contentLength = j2;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.closed) {
            long j2 = this.pos;
            long j3 = this.contentLength;
            if (j2 >= j3) {
                return -1;
            }
            if (((long) i3) + j2 > j3) {
                i3 = (int) (j3 - j2);
            }
            int read = this.wrappedStream.read(bArr, i2, i3);
            this.pos += (long) read;
            return read;
        }
        throw new IOException("Attempted read from closed stream.");
    }
}
