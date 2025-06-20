package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
class MultiReader extends Reader {
    @CheckForNull
    private Reader X;
    private final Iterator<? extends CharSource> s;

    MultiReader(Iterator<? extends CharSource> it2) throws IOException {
        this.s = it2;
        b();
    }

    private void b() throws IOException {
        close();
        if (this.s.hasNext()) {
            this.X = ((CharSource) this.s.next()).m();
        }
    }

    public void close() throws IOException {
        Reader reader = this.X;
        if (reader != null) {
            try {
                reader.close();
            } finally {
                this.X = null;
            }
        }
    }

    public int read(char[] cArr, int i2, int i3) throws IOException {
        Preconditions.E(cArr);
        Reader reader = this.X;
        if (reader == null) {
            return -1;
        }
        int read = reader.read(cArr, i2, i3);
        if (read != -1) {
            return read;
        }
        b();
        return read(cArr, i2, i3);
    }

    public boolean ready() throws IOException {
        Reader reader = this.X;
        return reader != null && reader.ready();
    }

    public long skip(long j2) throws IOException {
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        Preconditions.e(i2 >= 0, "n is negative");
        if (i2 > 0) {
            while (true) {
                Reader reader = this.X;
                if (reader == null) {
                    break;
                }
                long skip = reader.skip(j2);
                if (skip > 0) {
                    return skip;
                }
                b();
            }
        }
        return 0;
    }
}
