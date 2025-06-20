package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
public final class CountingInputStream extends FilterInputStream {
    private long X = -1;
    private long s;

    public CountingInputStream(InputStream inputStream) {
        super((InputStream) Preconditions.E(inputStream));
    }

    public long b() {
        return this.s;
    }

    public synchronized void mark(int i2) {
        this.in.mark(i2);
        this.X = this.s;
    }

    public int read() throws IOException {
        int read = this.in.read();
        if (read != -1) {
            this.s++;
        }
        return read;
    }

    public synchronized void reset() throws IOException {
        if (!this.in.markSupported()) {
            throw new IOException("Mark not supported");
        } else if (this.X != -1) {
            this.in.reset();
            this.s = this.X;
        } else {
            throw new IOException("Mark not set");
        }
    }

    public long skip(long j2) throws IOException {
        long skip = this.in.skip(j2);
        this.s += skip;
        return skip;
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int read = this.in.read(bArr, i2, i3);
        if (read != -1) {
            this.s += (long) read;
        }
        return read;
    }
}
