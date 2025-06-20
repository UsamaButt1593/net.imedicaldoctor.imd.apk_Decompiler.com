package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
final class MultiInputStream extends InputStream {
    @CheckForNull
    private InputStream X;
    private Iterator<? extends ByteSource> s;

    public MultiInputStream(Iterator<? extends ByteSource> it2) throws IOException {
        this.s = (Iterator) Preconditions.E(it2);
        b();
    }

    private void b() throws IOException {
        close();
        if (this.s.hasNext()) {
            this.X = ((ByteSource) this.s.next()).m();
        }
    }

    public int available() throws IOException {
        InputStream inputStream = this.X;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    public void close() throws IOException {
        InputStream inputStream = this.X;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.X = null;
            }
        }
    }

    public boolean markSupported() {
        return false;
    }

    public int read() throws IOException {
        while (true) {
            InputStream inputStream = this.X;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read();
            if (read != -1) {
                return read;
            }
            b();
        }
    }

    public long skip(long j2) throws IOException {
        InputStream inputStream = this.X;
        if (inputStream == null || j2 <= 0) {
            return 0;
        }
        long skip = inputStream.skip(j2);
        if (skip != 0) {
            return skip;
        }
        if (read() == -1) {
            return 0;
        }
        return this.X.skip(j2 - 1) + 1;
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        Preconditions.E(bArr);
        while (true) {
            InputStream inputStream = this.X;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read(bArr, i2, i3);
            if (read != -1) {
                return read;
            }
            b();
        }
    }
}
