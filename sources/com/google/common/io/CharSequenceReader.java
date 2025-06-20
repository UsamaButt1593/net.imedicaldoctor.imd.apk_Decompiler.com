package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.Objects;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
final class CharSequenceReader extends Reader {
    private int X;
    private int Y;
    @CheckForNull
    private CharSequence s;

    public CharSequenceReader(CharSequence charSequence) {
        this.s = (CharSequence) Preconditions.E(charSequence);
    }

    private void b() throws IOException {
        if (this.s == null) {
            throw new IOException("reader closed");
        }
    }

    private boolean c() {
        return d() > 0;
    }

    private int d() {
        Objects.requireNonNull(this.s);
        return this.s.length() - this.X;
    }

    public synchronized void close() throws IOException {
        this.s = null;
    }

    public synchronized void mark(int i2) throws IOException {
        Preconditions.k(i2 >= 0, "readAheadLimit (%s) may not be negative", i2);
        b();
        this.Y = this.X;
    }

    public boolean markSupported() {
        return true;
    }

    public synchronized int read() throws IOException {
        char c2;
        b();
        Objects.requireNonNull(this.s);
        if (c()) {
            CharSequence charSequence = this.s;
            int i2 = this.X;
            this.X = i2 + 1;
            c2 = charSequence.charAt(i2);
        } else {
            c2 = 65535;
        }
        return c2;
    }

    public synchronized boolean ready() throws IOException {
        b();
        return true;
    }

    public synchronized void reset() throws IOException {
        b();
        this.X = this.Y;
    }

    public synchronized long skip(long j2) throws IOException {
        int min;
        Preconditions.p(j2 >= 0, "n (%s) may not be negative", j2);
        b();
        min = (int) Math.min((long) d(), j2);
        this.X += min;
        return (long) min;
    }

    public synchronized int read(CharBuffer charBuffer) throws IOException {
        Preconditions.E(charBuffer);
        b();
        Objects.requireNonNull(this.s);
        if (!c()) {
            return -1;
        }
        int min = Math.min(charBuffer.remaining(), d());
        for (int i2 = 0; i2 < min; i2++) {
            CharSequence charSequence = this.s;
            int i3 = this.X;
            this.X = i3 + 1;
            charBuffer.put(charSequence.charAt(i3));
        }
        return min;
    }

    public synchronized int read(char[] cArr, int i2, int i3) throws IOException {
        Preconditions.f0(i2, i2 + i3, cArr.length);
        b();
        Objects.requireNonNull(this.s);
        if (!c()) {
            return -1;
        }
        int min = Math.min(i3, d());
        for (int i4 = 0; i4 < min; i4++) {
            CharSequence charSequence = this.s;
            int i5 = this.X;
            this.X = i5 + 1;
            cArr[i2 + i4] = charSequence.charAt(i5);
        }
        return min;
    }
}
