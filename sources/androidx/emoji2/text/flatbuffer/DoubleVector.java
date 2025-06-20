package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class DoubleVector extends BaseVector {
    public DoubleVector f(int i2, ByteBuffer byteBuffer) {
        b(i2, 8, byteBuffer);
        return this;
    }

    public double g(int i2) {
        return this.f7692d.getDouble(a(i2));
    }
}
