package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@ElementTypesAreNonnullByDefault
abstract class AbstractStreamingHasher extends AbstractHasher {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f22658a;

    /* renamed from: b  reason: collision with root package name */
    private final int f22659b;

    /* renamed from: c  reason: collision with root package name */
    private final int f22660c;

    protected AbstractStreamingHasher(int i2) {
        this(i2, i2);
    }

    private void q() {
        Java8Compatibility.b(this.f22658a);
        while (this.f22658a.remaining() >= this.f22660c) {
            s(this.f22658a);
        }
        this.f22658a.compact();
    }

    private void r() {
        if (this.f22658a.remaining() < 8) {
            q();
        }
    }

    @CanIgnoreReturnValue
    private Hasher u(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.f22658a.remaining()) {
            this.f22658a.put(byteBuffer);
            r();
            return this;
        }
        int position = this.f22659b - this.f22658a.position();
        for (int i2 = 0; i2 < position; i2++) {
            this.f22658a.put(byteBuffer.get());
        }
        q();
        while (byteBuffer.remaining() >= this.f22660c) {
            s(byteBuffer);
        }
        this.f22658a.put(byteBuffer);
        return this;
    }

    @CanIgnoreReturnValue
    public final Hasher b(short s) {
        this.f22658a.putShort(s);
        r();
        return this;
    }

    @CanIgnoreReturnValue
    public final Hasher e(int i2) {
        this.f22658a.putInt(i2);
        r();
        return this;
    }

    @CanIgnoreReturnValue
    public final Hasher f(long j2) {
        this.f22658a.putLong(j2);
        r();
        return this;
    }

    @CanIgnoreReturnValue
    public final Hasher h(byte b2) {
        this.f22658a.put(b2);
        r();
        return this;
    }

    @CanIgnoreReturnValue
    public final Hasher j(byte[] bArr, int i2, int i3) {
        return u(ByteBuffer.wrap(bArr, i2, i3).order(ByteOrder.LITTLE_ENDIAN));
    }

    @CanIgnoreReturnValue
    public final Hasher k(char c2) {
        this.f22658a.putChar(c2);
        r();
        return this;
    }

    /* JADX INFO: finally extract failed */
    @CanIgnoreReturnValue
    public final Hasher l(ByteBuffer byteBuffer) {
        ByteOrder order = byteBuffer.order();
        try {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            Hasher u = u(byteBuffer);
            byteBuffer.order(order);
            return u;
        } catch (Throwable th) {
            byteBuffer.order(order);
            throw th;
        }
    }

    public final HashCode o() {
        q();
        Java8Compatibility.b(this.f22658a);
        if (this.f22658a.remaining() > 0) {
            t(this.f22658a);
            ByteBuffer byteBuffer = this.f22658a;
            Java8Compatibility.d(byteBuffer, byteBuffer.limit());
        }
        return p();
    }

    /* access modifiers changed from: protected */
    public abstract HashCode p();

    /* access modifiers changed from: protected */
    public abstract void s(ByteBuffer byteBuffer);

    /* access modifiers changed from: protected */
    public void t(ByteBuffer byteBuffer) {
        Java8Compatibility.d(byteBuffer, byteBuffer.limit());
        Java8Compatibility.c(byteBuffer, this.f22660c + 7);
        while (true) {
            int position = byteBuffer.position();
            int i2 = this.f22660c;
            if (position < i2) {
                byteBuffer.putLong(0);
            } else {
                Java8Compatibility.c(byteBuffer, i2);
                Java8Compatibility.b(byteBuffer);
                s(byteBuffer);
                return;
            }
        }
    }

    protected AbstractStreamingHasher(int i2, int i3) {
        Preconditions.d(i3 % i2 == 0);
        this.f22658a = ByteBuffer.allocate(i3 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.f22659b = i3;
        this.f22660c = i2;
    }
}
