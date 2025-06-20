package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
class AppendableWriter extends Writer {
    private boolean X;
    private final Appendable s;

    AppendableWriter(Appendable appendable) {
        this.s = (Appendable) Preconditions.E(appendable);
    }

    private void b() throws IOException {
        if (this.X) {
            throw new IOException("Cannot write to a closed writer.");
        }
    }

    public Writer append(char c2) throws IOException {
        b();
        this.s.append(c2);
        return this;
    }

    public void close() throws IOException {
        this.X = true;
        Appendable appendable = this.s;
        if (appendable instanceof Closeable) {
            ((Closeable) appendable).close();
        }
    }

    public void flush() throws IOException {
        b();
        Appendable appendable = this.s;
        if (appendable instanceof Flushable) {
            ((Flushable) appendable).flush();
        }
    }

    public void write(int i2) throws IOException {
        b();
        this.s.append((char) i2);
    }

    public Writer append(@CheckForNull CharSequence charSequence) throws IOException {
        b();
        this.s.append(charSequence);
        return this;
    }

    public void write(String str) throws IOException {
        Preconditions.E(str);
        b();
        this.s.append(str);
    }

    public Writer append(@CheckForNull CharSequence charSequence, int i2, int i3) throws IOException {
        b();
        this.s.append(charSequence, i2, i3);
        return this;
    }

    public void write(String str, int i2, int i3) throws IOException {
        Preconditions.E(str);
        b();
        this.s.append(str, i2, i3 + i2);
    }

    public void write(char[] cArr, int i2, int i3) throws IOException {
        b();
        this.s.append(new String(cArr, i2, i3));
    }
}
