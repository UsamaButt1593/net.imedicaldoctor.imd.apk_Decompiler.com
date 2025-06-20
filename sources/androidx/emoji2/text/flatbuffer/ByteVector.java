package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class ByteVector extends BaseVector {
    public ByteVector f(int i2, ByteBuffer byteBuffer) {
        b(i2, 1, byteBuffer);
        return this;
    }

    public byte g(int i2) {
        return this.f7692d.get(a(i2));
    }

    public int h(int i2) {
        return g(i2) & 255;
    }
}
