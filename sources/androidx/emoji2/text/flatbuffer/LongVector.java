package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class LongVector extends BaseVector {
    public LongVector f(int i2, ByteBuffer byteBuffer) {
        b(i2, 8, byteBuffer);
        return this;
    }

    public long g(int i2) {
        return this.f7692d.getLong(a(i2));
    }
}
