package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
public abstract class CharSink {
    protected CharSink() {
    }

    public Writer a() throws IOException {
        Writer b2 = b();
        return b2 instanceof BufferedWriter ? (BufferedWriter) b2 : new BufferedWriter(b2);
    }

    public abstract Writer b() throws IOException;

    public void c(CharSequence charSequence) throws IOException {
        Preconditions.E(charSequence);
        Closer b2 = Closer.b();
        try {
            Writer writer = (Writer) b2.c(b());
            writer.append(charSequence);
            writer.flush();
            b2.close();
        } catch (Throwable th) {
            b2.close();
            throw th;
        }
    }

    @CanIgnoreReturnValue
    public long d(Readable readable) throws IOException {
        Preconditions.E(readable);
        Closer b2 = Closer.b();
        try {
            Writer writer = (Writer) b2.c(b());
            long b3 = CharStreams.b(readable, writer);
            writer.flush();
            b2.close();
            return b3;
        } catch (Throwable th) {
            b2.close();
            throw th;
        }
    }

    public void e(Iterable<? extends CharSequence> iterable) throws IOException {
        f(iterable, System.getProperty("line.separator"));
    }

    public void f(Iterable<? extends CharSequence> iterable, String str) throws IOException {
        Preconditions.E(iterable);
        Preconditions.E(str);
        Closer b2 = Closer.b();
        try {
            Writer writer = (Writer) b2.c(a());
            for (CharSequence append : iterable) {
                writer.append(append).append(str);
            }
            writer.flush();
            b2.close();
        } catch (Throwable th) {
            b2.close();
            throw th;
        }
    }
}
