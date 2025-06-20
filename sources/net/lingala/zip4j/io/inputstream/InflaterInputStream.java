package net.lingala.zip4j.io.inputstream;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class InflaterInputStream extends DecompressedInputStream {
    private byte[] X2 = new byte[1];
    private Inflater Y = new Inflater(true);
    private int Y2;
    private byte[] Z = new byte[4096];

    public InflaterInputStream(CipherInputStream cipherInputStream) {
        super(cipherInputStream);
    }

    private void e() throws IOException {
        byte[] bArr = this.Z;
        int read = super.read(bArr, 0, bArr.length);
        this.Y2 = read;
        if (read != -1) {
            this.Y.setInput(this.Z, 0, read);
            return;
        }
        throw new EOFException("Unexpected end of input stream");
    }

    public void b(InputStream inputStream) throws IOException {
        Inflater inflater = this.Y;
        if (inflater != null) {
            inflater.end();
            this.Y = null;
        }
        super.b(inputStream);
    }

    public void close() throws IOException {
        Inflater inflater = this.Y;
        if (inflater != null) {
            inflater.end();
        }
        super.close();
    }

    public void d(PushbackInputStream pushbackInputStream) throws IOException {
        int remaining = this.Y.getRemaining();
        if (remaining > 0) {
            pushbackInputStream.unread(c(), this.Y2 - remaining, remaining);
        }
    }

    public int read() throws IOException {
        if (read(this.X2) == -1) {
            return -1;
        }
        return this.X2[0];
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        while (true) {
            try {
                int inflate = this.Y.inflate(bArr, i2, i3);
                if (inflate != 0) {
                    return inflate;
                }
                if (this.Y.finished()) {
                    return -1;
                }
                if (this.Y.needsDictionary()) {
                    return -1;
                }
                if (this.Y.needsInput()) {
                    e();
                }
            } catch (DataFormatException e2) {
                throw new IOException(e2);
            }
        }
    }
}
