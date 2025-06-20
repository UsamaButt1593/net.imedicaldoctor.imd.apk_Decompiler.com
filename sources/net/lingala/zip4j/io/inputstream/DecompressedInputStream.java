package net.lingala.zip4j.io.inputstream;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

abstract class DecompressedInputStream extends InputStream {
    protected byte[] X = new byte[1];
    private CipherInputStream s;

    public DecompressedInputStream(CipherInputStream cipherInputStream) {
        this.s = cipherInputStream;
    }

    public void b(InputStream inputStream) throws IOException {
        this.s.c(inputStream);
    }

    /* access modifiers changed from: protected */
    public byte[] c() {
        return this.s.e();
    }

    public void close() throws IOException {
        this.s.close();
    }

    public void d(PushbackInputStream pushbackInputStream) throws IOException {
    }

    public int read() throws IOException {
        if (read(this.X) == -1) {
            return -1;
        }
        return this.X[0];
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        return this.s.read(bArr, i2, i3);
    }
}
