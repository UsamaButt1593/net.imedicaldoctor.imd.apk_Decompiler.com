package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.google.common.base.Ascii;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ExifOrientationStream extends FilterInputStream {
    private static final int X2;
    private static final int Y = 2;
    private static final int Y2;
    private static final byte[] Z;
    private int X;
    private final byte s;

    static {
        byte[] bArr = {-1, -31, 0, Ascii.F, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        Z = bArr;
        int length = bArr.length;
        X2 = length;
        Y2 = length + 2;
    }

    public ExifOrientationStream(InputStream inputStream, int i2) {
        super(inputStream);
        if (i2 < -1 || i2 > 8) {
            throw new IllegalArgumentException("Cannot add invalid orientation: " + i2);
        }
        this.s = (byte) i2;
    }

    public void mark(int i2) {
        throw new UnsupportedOperationException();
    }

    public boolean markSupported() {
        return false;
    }

    public int read() throws IOException {
        int i2;
        int i3 = this.X;
        int read = (i3 < 2 || i3 > (i2 = Y2)) ? super.read() : i3 == i2 ? this.s : Z[i3 - 2] & 255;
        if (read != -1) {
            this.X++;
        }
        return read;
    }

    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    public long skip(long j2) throws IOException {
        long skip = super.skip(j2);
        if (skip > 0) {
            this.X = (int) (((long) this.X) + skip);
        }
        return skip;
    }

    public int read(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5 = this.X;
        int i6 = Y2;
        if (i5 > i6) {
            i4 = super.read(bArr, i2, i3);
        } else if (i5 == i6) {
            bArr[i2] = this.s;
            i4 = 1;
        } else if (i5 < 2) {
            i4 = super.read(bArr, i2, 2 - i5);
        } else {
            int min = Math.min(i6 - i5, i3);
            System.arraycopy(Z, this.X - 2, bArr, i2, min);
            i4 = min;
        }
        if (i4 > 0) {
            this.X += i4;
        }
        return i4;
    }
}
