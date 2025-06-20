package net.lingala.zip4j.io.outputstream;

import java.io.IOException;
import java.io.OutputStream;

abstract class CompressedOutputStream extends OutputStream {
    private CipherOutputStream s;

    public CompressedOutputStream(CipherOutputStream cipherOutputStream) {
        this.s = cipherOutputStream;
    }

    /* access modifiers changed from: protected */
    public void b() throws IOException {
        this.s.b();
    }

    public long c() {
        return this.s.d();
    }

    public void close() throws IOException {
        this.s.close();
    }

    public void write(int i2) throws IOException {
        write(new byte[]{(byte) i2});
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        this.s.write(bArr, i2, i3);
    }
}
