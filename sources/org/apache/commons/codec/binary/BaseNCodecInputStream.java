package org.apache.commons.codec.binary;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.codec.binary.BaseNCodec;

public class BaseNCodecInputStream extends FilterInputStream {
    private final BaseNCodec baseNCodec;
    private final BaseNCodec.Context context = new BaseNCodec.Context();
    private final boolean doEncode;
    private final byte[] singleByte = new byte[1];

    protected BaseNCodecInputStream(InputStream inputStream, BaseNCodec baseNCodec2, boolean z) {
        super(inputStream);
        this.doEncode = z;
        this.baseNCodec = baseNCodec2;
    }

    public int available() throws IOException {
        return this.context.eof ^ true ? 1 : 0;
    }

    public synchronized void mark(int i2) {
    }

    public boolean markSupported() {
        return false;
    }

    public int read() throws IOException {
        int read = read(this.singleByte, 0, 1);
        while (read == 0) {
            read = read(this.singleByte, 0, 1);
        }
        if (read <= 0) {
            return -1;
        }
        byte b2 = this.singleByte[0];
        return b2 < 0 ? b2 + 256 : b2;
    }

    public synchronized void reset() throws IOException {
        throw new IOException("mark/reset not supported");
    }

    public long skip(long j2) throws IOException {
        int read;
        if (j2 >= 0) {
            byte[] bArr = new byte[512];
            long j3 = j2;
            while (j3 > 0 && (read = read(bArr, 0, (int) Math.min((long) 512, j3))) != -1) {
                j3 -= (long) read;
            }
            return j2 - j3;
        }
        throw new IllegalArgumentException("Negative skip length: " + j2);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        bArr.getClass();
        if (i2 < 0 || i3 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i2 > bArr.length || i2 + i3 > bArr.length) {
            throw new IndexOutOfBoundsException();
        } else if (i3 == 0) {
            return 0;
        } else {
            int i4 = 0;
            while (i4 == 0) {
                if (!this.baseNCodec.hasData(this.context)) {
                    byte[] bArr2 = new byte[(this.doEncode ? 4096 : 8192)];
                    int read = this.in.read(bArr2);
                    if (this.doEncode) {
                        this.baseNCodec.encode(bArr2, 0, read, this.context);
                    } else {
                        this.baseNCodec.decode(bArr2, 0, read, this.context);
                    }
                }
                i4 = this.baseNCodec.readResults(bArr, i2, i3, this.context);
            }
            return i4;
        }
    }
}
