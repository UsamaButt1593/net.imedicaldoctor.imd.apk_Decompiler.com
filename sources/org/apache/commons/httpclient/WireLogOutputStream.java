package org.apache.commons.httpclient;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class WireLogOutputStream extends FilterOutputStream {
    private OutputStream out;
    private Wire wire;

    public WireLogOutputStream(OutputStream outputStream, Wire wire2) {
        super(outputStream);
        this.out = outputStream;
        this.wire = wire2;
    }

    public void write(int i2) throws IOException {
        this.out.write(i2);
        this.wire.output(i2);
    }

    public void write(byte[] bArr) throws IOException {
        this.out.write(bArr);
        this.wire.output(bArr);
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        this.out.write(bArr, i2, i3);
        this.wire.output(bArr, i2, i3);
    }
}
