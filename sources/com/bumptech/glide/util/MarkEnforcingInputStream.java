package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MarkEnforcingInputStream extends FilterInputStream {
    private static final int X = Integer.MIN_VALUE;
    private static final int Y = -1;
    private int s = Integer.MIN_VALUE;

    public MarkEnforcingInputStream(@NonNull InputStream inputStream) {
        super(inputStream);
    }

    private long b(long j2) {
        int i2 = this.s;
        if (i2 == 0) {
            return -1;
        }
        return (i2 == Integer.MIN_VALUE || j2 <= ((long) i2)) ? j2 : (long) i2;
    }

    private void c(long j2) {
        int i2 = this.s;
        if (i2 != Integer.MIN_VALUE && j2 != -1) {
            this.s = (int) (((long) i2) - j2);
        }
    }

    public int available() throws IOException {
        int i2 = this.s;
        return i2 == Integer.MIN_VALUE ? super.available() : Math.min(i2, super.available());
    }

    public synchronized void mark(int i2) {
        super.mark(i2);
        this.s = i2;
    }

    public int read() throws IOException {
        if (b(1) == -1) {
            return -1;
        }
        int read = super.read();
        c(1);
        return read;
    }

    public synchronized void reset() throws IOException {
        super.reset();
        this.s = Integer.MIN_VALUE;
    }

    public long skip(long j2) throws IOException {
        long b2 = b(j2);
        if (b2 == -1) {
            return 0;
        }
        long skip = super.skip(b2);
        c(skip);
        return skip;
    }

    public int read(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int b2 = (int) b((long) i3);
        if (b2 == -1) {
            return -1;
        }
        int read = super.read(bArr, i2, b2);
        c((long) read);
        return read;
    }
}
