package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class UnionVector extends BaseVector {
    public UnionVector f(int i2, int i3, ByteBuffer byteBuffer) {
        b(i2, i3, byteBuffer);
        return this;
    }

    public Table g(Table table, int i2) {
        return Table.k(table, a(i2), this.f7692d);
    }
}
