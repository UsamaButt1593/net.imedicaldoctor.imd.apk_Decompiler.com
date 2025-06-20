package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class BooleanVector extends BaseVector {
    public BooleanVector f(int i2, ByteBuffer byteBuffer) {
        b(i2, 1, byteBuffer);
        return this;
    }

    public boolean g(int i2) {
        return this.f7692d.get(a(i2)) != 0;
    }
}
