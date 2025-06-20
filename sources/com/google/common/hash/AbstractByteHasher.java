package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@ElementTypesAreNonnullByDefault
abstract class AbstractByteHasher extends AbstractHasher {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f22653a = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);

    AbstractByteHasher() {
    }

    @CanIgnoreReturnValue
    private Hasher p(int i2) {
        try {
            t(this.f22653a.array(), 0, i2);
            return this;
        } finally {
            Java8Compatibility.a(this.f22653a);
        }
    }

    @CanIgnoreReturnValue
    public Hasher b(short s) {
        this.f22653a.putShort(s);
        return p(2);
    }

    @CanIgnoreReturnValue
    public Hasher e(int i2) {
        this.f22653a.putInt(i2);
        return p(4);
    }

    @CanIgnoreReturnValue
    public Hasher f(long j2) {
        this.f22653a.putLong(j2);
        return p(8);
    }

    @CanIgnoreReturnValue
    public Hasher g(byte[] bArr) {
        Preconditions.E(bArr);
        s(bArr);
        return this;
    }

    @CanIgnoreReturnValue
    public Hasher h(byte b2) {
        q(b2);
        return this;
    }

    @CanIgnoreReturnValue
    public Hasher j(byte[] bArr, int i2, int i3) {
        Preconditions.f0(i2, i2 + i3, bArr.length);
        t(bArr, i2, i3);
        return this;
    }

    @CanIgnoreReturnValue
    public Hasher k(char c2) {
        this.f22653a.putChar(c2);
        return p(2);
    }

    @CanIgnoreReturnValue
    public Hasher l(ByteBuffer byteBuffer) {
        r(byteBuffer);
        return this;
    }

    /* access modifiers changed from: protected */
    public abstract void q(byte b2);

    /* access modifiers changed from: protected */
    public void r(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            t(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            Java8Compatibility.d(byteBuffer, byteBuffer.limit());
            return;
        }
        for (int remaining = byteBuffer.remaining(); remaining > 0; remaining--) {
            q(byteBuffer.get());
        }
    }

    /* access modifiers changed from: protected */
    public void s(byte[] bArr) {
        t(bArr, 0, bArr.length);
    }

    /* access modifiers changed from: protected */
    public void t(byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            q(bArr[i4]);
        }
    }
}
