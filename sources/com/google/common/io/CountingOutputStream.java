package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
public final class CountingOutputStream extends FilterOutputStream {
    private long s;

    public CountingOutputStream(OutputStream outputStream) {
        super((OutputStream) Preconditions.E(outputStream));
    }

    public long b() {
        return this.s;
    }

    public void close() throws IOException {
        this.out.close();
    }

    public void write(int i2) throws IOException {
        this.out.write(i2);
        this.s++;
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        this.out.write(bArr, i2, i3);
        this.s += (long) i3;
    }
}
