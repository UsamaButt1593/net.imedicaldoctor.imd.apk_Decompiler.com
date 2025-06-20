package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public abstract class ByteSink {

    private final class AsCharSink extends CharSink {

        /* renamed from: a  reason: collision with root package name */
        private final Charset f22752a;

        private AsCharSink(Charset charset) {
            this.f22752a = (Charset) Preconditions.E(charset);
        }

        public Writer b() throws IOException {
            return new OutputStreamWriter(ByteSink.this.c(), this.f22752a);
        }

        public String toString() {
            return ByteSink.this.toString() + ".asCharSink(" + this.f22752a + ")";
        }
    }

    protected ByteSink() {
    }

    public CharSink a(Charset charset) {
        return new AsCharSink(charset);
    }

    public OutputStream b() throws IOException {
        OutputStream c2 = c();
        return c2 instanceof BufferedOutputStream ? (BufferedOutputStream) c2 : new BufferedOutputStream(c2);
    }

    public abstract OutputStream c() throws IOException;

    public void d(byte[] bArr) throws IOException {
        Preconditions.E(bArr);
        Closer b2 = Closer.b();
        try {
            OutputStream outputStream = (OutputStream) b2.c(c());
            outputStream.write(bArr);
            outputStream.flush();
            b2.close();
        } catch (Throwable th) {
            b2.close();
            throw th;
        }
    }

    @CanIgnoreReturnValue
    public long e(InputStream inputStream) throws IOException {
        Preconditions.E(inputStream);
        Closer b2 = Closer.b();
        try {
            OutputStream outputStream = (OutputStream) b2.c(c());
            long b3 = ByteStreams.b(inputStream, outputStream);
            outputStream.flush();
            b2.close();
            return b3;
        } catch (Throwable th) {
            b2.close();
            throw th;
        }
    }
}
