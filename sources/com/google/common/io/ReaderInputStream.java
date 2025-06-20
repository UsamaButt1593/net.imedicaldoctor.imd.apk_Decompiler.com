package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
final class ReaderInputStream extends InputStream {
    private final CharsetEncoder X;
    private ByteBuffer X2;
    private final byte[] Y;
    private boolean Y2;
    private CharBuffer Z;
    private boolean Z2;
    private boolean a3;
    private final Reader s;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    ReaderInputStream(java.io.Reader r2, java.nio.charset.Charset r3, int r4) {
        /*
            r1 = this;
            java.nio.charset.CharsetEncoder r3 = r3.newEncoder()
            java.nio.charset.CodingErrorAction r0 = java.nio.charset.CodingErrorAction.REPLACE
            java.nio.charset.CharsetEncoder r3 = r3.onMalformedInput(r0)
            java.nio.charset.CharsetEncoder r3 = r3.onUnmappableCharacter(r0)
            r1.<init>((java.io.Reader) r2, (java.nio.charset.CharsetEncoder) r3, (int) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.ReaderInputStream.<init>(java.io.Reader, java.nio.charset.Charset, int):void");
    }

    private static int b(Buffer buffer) {
        return buffer.capacity() - buffer.limit();
    }

    private int c(byte[] bArr, int i2, int i3) {
        int min = Math.min(i3, this.X2.remaining());
        this.X2.get(bArr, i2, min);
        return min;
    }

    private static CharBuffer d(CharBuffer charBuffer) {
        CharBuffer wrap = CharBuffer.wrap(Arrays.copyOf(charBuffer.array(), charBuffer.capacity() * 2));
        Java8Compatibility.e(wrap, charBuffer.position());
        Java8Compatibility.c(wrap, charBuffer.limit());
        return wrap;
    }

    private void e() throws IOException {
        if (b(this.Z) == 0) {
            if (this.Z.position() > 0) {
                Java8Compatibility.b(this.Z.compact());
            } else {
                this.Z = d(this.Z);
            }
        }
        int limit = this.Z.limit();
        int read = this.s.read(this.Z.array(), limit, b(this.Z));
        if (read == -1) {
            this.Y2 = true;
        } else {
            Java8Compatibility.c(this.Z, limit + read);
        }
    }

    private void f(boolean z) {
        Java8Compatibility.b(this.X2);
        if (!z || this.X2.remaining() != 0) {
            this.Z2 = true;
        } else {
            this.X2 = ByteBuffer.allocate(this.X2.capacity() * 2);
        }
    }

    public void close() throws IOException {
        this.s.close();
    }

    public int read() throws IOException {
        if (read(this.Y) == 1) {
            return UnsignedBytes.p(this.Y[0]);
        }
        return -1;
    }

    ReaderInputStream(Reader reader, CharsetEncoder charsetEncoder, int i2) {
        boolean z = true;
        this.Y = new byte[1];
        this.s = (Reader) Preconditions.E(reader);
        this.X = (CharsetEncoder) Preconditions.E(charsetEncoder);
        Preconditions.k(i2 <= 0 ? false : z, "bufferSize must be positive: %s", i2);
        charsetEncoder.reset();
        CharBuffer allocate = CharBuffer.allocate(i2);
        this.Z = allocate;
        Java8Compatibility.b(allocate);
        this.X2 = ByteBuffer.allocate(i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002c A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read(byte[] r8, int r9, int r10) throws java.io.IOException {
        /*
            r7 = this;
            int r0 = r9 + r10
            int r1 = r8.length
            com.google.common.base.Preconditions.f0(r9, r0, r1)
            r0 = 0
            if (r10 != 0) goto L_0x000a
            return r0
        L_0x000a:
            boolean r1 = r7.Y2
            r2 = 0
        L_0x000d:
            boolean r3 = r7.Z2
            if (r3 == 0) goto L_0x002e
            int r3 = r9 + r2
            int r4 = r10 - r2
            int r3 = r7.c(r8, r3, r4)
            int r2 = r2 + r3
            if (r2 == r10) goto L_0x0029
            boolean r3 = r7.a3
            if (r3 == 0) goto L_0x0021
            goto L_0x0029
        L_0x0021:
            r7.Z2 = r0
            java.nio.ByteBuffer r3 = r7.X2
            com.google.common.io.Java8Compatibility.a(r3)
            goto L_0x002e
        L_0x0029:
            if (r2 <= 0) goto L_0x002c
            goto L_0x002d
        L_0x002c:
            r2 = -1
        L_0x002d:
            return r2
        L_0x002e:
            boolean r3 = r7.a3
            if (r3 == 0) goto L_0x0035
            java.nio.charset.CoderResult r3 = java.nio.charset.CoderResult.UNDERFLOW
            goto L_0x004a
        L_0x0035:
            java.nio.charset.CharsetEncoder r3 = r7.X
            if (r1 == 0) goto L_0x0040
            java.nio.ByteBuffer r4 = r7.X2
            java.nio.charset.CoderResult r3 = r3.flush(r4)
            goto L_0x004a
        L_0x0040:
            java.nio.CharBuffer r4 = r7.Z
            java.nio.ByteBuffer r5 = r7.X2
            boolean r6 = r7.Y2
            java.nio.charset.CoderResult r3 = r3.encode(r4, r5, r6)
        L_0x004a:
            boolean r4 = r3.isOverflow()
            r5 = 1
            if (r4 == 0) goto L_0x0055
            r7.f(r5)
            goto L_0x000d
        L_0x0055:
            boolean r4 = r3.isUnderflow()
            if (r4 == 0) goto L_0x006d
            if (r1 == 0) goto L_0x0063
            r7.a3 = r5
            r7.f(r0)
            goto L_0x000d
        L_0x0063:
            boolean r3 = r7.Y2
            if (r3 == 0) goto L_0x0069
            r1 = 1
            goto L_0x002e
        L_0x0069:
            r7.e()
            goto L_0x002e
        L_0x006d:
            boolean r4 = r3.isError()
            if (r4 == 0) goto L_0x002e
            r3.throwException()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.ReaderInputStream.read(byte[], int, int):int");
    }
}
