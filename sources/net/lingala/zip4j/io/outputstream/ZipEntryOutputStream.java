package net.lingala.zip4j.io.outputstream;

import java.io.IOException;
import java.io.OutputStream;

class ZipEntryOutputStream extends OutputStream {
    private OutputStream X;
    private boolean Y;
    private long s = 0;

    public ZipEntryOutputStream(OutputStream outputStream) {
        this.X = outputStream;
        this.Y = false;
    }

    public void b() throws IOException {
        this.Y = true;
    }

    public long c() {
        return this.s;
    }

    public void close() throws IOException {
    }

    public void write(int i2) throws IOException {
        write(new byte[]{(byte) i2});
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.Y) {
            this.X.write(bArr, i2, i3);
            this.s += (long) i3;
            return;
        }
        throw new IllegalStateException("ZipEntryOutputStream is closed");
    }
}
