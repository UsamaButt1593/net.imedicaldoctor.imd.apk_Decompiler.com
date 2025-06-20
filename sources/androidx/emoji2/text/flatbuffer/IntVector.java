package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import net.lingala.zip4j.util.InternalZipConstants;

public final class IntVector extends BaseVector {
    public IntVector f(int i2, ByteBuffer byteBuffer) {
        b(i2, 4, byteBuffer);
        return this;
    }

    public int g(int i2) {
        return this.f7692d.getInt(a(i2));
    }

    public long h(int i2) {
        return ((long) g(i2)) & InternalZipConstants.f30717k;
    }
}
