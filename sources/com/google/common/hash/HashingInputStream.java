package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@ElementTypesAreNonnullByDefault
@Beta
public final class HashingInputStream extends FilterInputStream {
    private final Hasher s;

    public HashingInputStream(HashFunction hashFunction, InputStream inputStream) {
        super((InputStream) Preconditions.E(inputStream));
        this.s = (Hasher) Preconditions.E(hashFunction.b());
    }

    public HashCode b() {
        return this.s.o();
    }

    public void mark(int i2) {
    }

    public boolean markSupported() {
        return false;
    }

    @CanIgnoreReturnValue
    public int read() throws IOException {
        int read = this.in.read();
        if (read != -1) {
            this.s.h((byte) read);
        }
        return read;
    }

    public void reset() throws IOException {
        throw new IOException("reset not supported");
    }

    @CanIgnoreReturnValue
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int read = this.in.read(bArr, i2, i3);
        if (read != -1) {
            this.s.j(bArr, i2, read);
        }
        return read;
    }
}
