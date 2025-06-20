package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class FloatVector extends BaseVector {
    public FloatVector f(int i2, ByteBuffer byteBuffer) {
        b(i2, 4, byteBuffer);
        return this;
    }

    public float g(int i2) {
        return this.f7692d.getFloat(a(i2));
    }
}
