package net.lingala.zip4j.io.inputstream;

import java.io.IOException;
import java.io.InputStream;

class ZipEntryInputStream extends InputStream {
    private static final int X2 = 15;
    private long X = 0;
    private byte[] Y = new byte[1];
    private long Z;
    private InputStream s;

    public ZipEntryInputStream(InputStream inputStream, long j2) {
        this.s = inputStream;
        this.Z = j2;
    }

    private int d(byte[] bArr, int i2) throws IOException {
        int length = bArr.length - i2;
        int i3 = 0;
        int i4 = 0;
        while (i2 < bArr.length && i3 != -1 && i4 < 15) {
            i3 += this.s.read(bArr, i2, length);
            if (i3 > 0) {
                i2 += i3;
                length -= i3;
            }
            i4++;
        }
        return i2;
    }

    public long b() {
        return this.X;
    }

    public int c(byte[] bArr) throws IOException {
        int read = this.s.read(bArr);
        if (read == bArr.length || (read = d(bArr, read)) == bArr.length) {
            return read;
        }
        throw new IOException("Cannot read fully into byte buffer");
    }

    public void close() throws IOException {
        this.s.close();
    }

    public int read() throws IOException {
        if (read(this.Y) == -1) {
            return -1;
        }
        return this.Y[0];
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        long j2 = this.Z;
        if (j2 != -1) {
            long j3 = this.X;
            if (j3 >= j2) {
                return -1;
            }
            if (((long) i3) > j2 - j3) {
                i3 = (int) (j2 - j3);
            }
        }
        int read = this.s.read(bArr, i2, i3);
        if (read > 0) {
            this.X += (long) read;
        }
        return read;
    }
}
