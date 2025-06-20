package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@ElementTypesAreNonnullByDefault
@Beta
public final class HashingOutputStream extends FilterOutputStream {
    private final Hasher s;

    public HashingOutputStream(HashFunction hashFunction, OutputStream outputStream) {
        super((OutputStream) Preconditions.E(outputStream));
        this.s = (Hasher) Preconditions.E(hashFunction.b());
    }

    public HashCode b() {
        return this.s.o();
    }

    public void close() throws IOException {
        this.out.close();
    }

    public void write(int i2) throws IOException {
        this.s.h((byte) i2);
        this.out.write(i2);
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        this.s.j(bArr, i2, i3);
        this.out.write(bArr, i2, i3);
    }
}
