package org.apache.commons.httpclient;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

class WireLogInputStream extends FilterInputStream {
    private InputStream in;
    private Wire wire;

    public WireLogInputStream(InputStream inputStream, Wire wire2) {
        super(inputStream);
        this.in = inputStream;
        this.wire = wire2;
    }

    public int read() throws IOException {
        int read = this.in.read();
        if (read > 0) {
            this.wire.input(read);
        }
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        int read = this.in.read(bArr);
        if (read > 0) {
            this.wire.input(bArr, 0, read);
        }
        return read;
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int read = this.in.read(bArr, i2, i3);
        if (read > 0) {
            this.wire.input(bArr, i2, read);
        }
        return read;
    }
}
