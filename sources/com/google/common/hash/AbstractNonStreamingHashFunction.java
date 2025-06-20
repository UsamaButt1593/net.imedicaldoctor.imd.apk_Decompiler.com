package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;

@ElementTypesAreNonnullByDefault
@Immutable
abstract class AbstractNonStreamingHashFunction extends AbstractHashFunction {

    private final class BufferingHasher extends AbstractHasher {

        /* renamed from: a  reason: collision with root package name */
        final ExposedByteArrayOutputStream f22656a;

        BufferingHasher(int i2) {
            this.f22656a = new ExposedByteArrayOutputStream(i2);
        }

        public Hasher h(byte b2) {
            this.f22656a.write(b2);
            return this;
        }

        public Hasher j(byte[] bArr, int i2, int i3) {
            this.f22656a.write(bArr, i2, i3);
            return this;
        }

        public Hasher l(ByteBuffer byteBuffer) {
            this.f22656a.d(byteBuffer);
            return this;
        }

        public HashCode o() {
            return AbstractNonStreamingHashFunction.this.j(this.f22656a.b(), 0, this.f22656a.c());
        }
    }

    private static final class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        ExposedByteArrayOutputStream(int i2) {
            super(i2);
        }

        /* access modifiers changed from: package-private */
        public byte[] b() {
            return this.buf;
        }

        /* access modifiers changed from: package-private */
        public int c() {
            return this.count;
        }

        /* access modifiers changed from: package-private */
        public void d(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            int i2 = this.count;
            int i3 = i2 + remaining;
            byte[] bArr = this.buf;
            if (i3 > bArr.length) {
                this.buf = Arrays.copyOf(bArr, i2 + remaining);
            }
            byteBuffer.get(this.buf, this.count, remaining);
            this.count += remaining;
        }
    }

    AbstractNonStreamingHashFunction() {
    }

    public Hasher b() {
        return k(32);
    }

    public HashCode c(int i2) {
        return a(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i2).array());
    }

    public HashCode e(CharSequence charSequence, Charset charset) {
        return a(charSequence.toString().getBytes(charset));
    }

    public HashCode f(ByteBuffer byteBuffer) {
        return k(byteBuffer.remaining()).l(byteBuffer).o();
    }

    public HashCode g(CharSequence charSequence) {
        int length = charSequence.length();
        ByteBuffer order = ByteBuffer.allocate(length * 2).order(ByteOrder.LITTLE_ENDIAN);
        for (int i2 = 0; i2 < length; i2++) {
            order.putChar(charSequence.charAt(i2));
        }
        return a(order.array());
    }

    public HashCode i(long j2) {
        return a(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(j2).array());
    }

    public abstract HashCode j(byte[] bArr, int i2, int i3);

    public Hasher k(int i2) {
        Preconditions.d(i2 >= 0);
        return new BufferingHasher(i2);
    }
}
