package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import kotlin.UShort;

public final class ShortVector extends BaseVector {
    public ShortVector f(int i2, ByteBuffer byteBuffer) {
        b(i2, 2, byteBuffer);
        return this;
    }

    public short g(int i2) {
        return this.f7692d.getShort(a(i2));
    }

    public int h(int i2) {
        return g(i2) & UShort.Z;
    }
}
