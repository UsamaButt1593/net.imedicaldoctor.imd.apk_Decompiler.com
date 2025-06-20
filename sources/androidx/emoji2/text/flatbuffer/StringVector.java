package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class StringVector extends BaseVector {

    /* renamed from: e  reason: collision with root package name */
    private Utf8 f7769e = Utf8.d();

    public StringVector f(int i2, int i3, ByteBuffer byteBuffer) {
        b(i2, i3, byteBuffer);
        return this;
    }

    public String g(int i2) {
        return Table.i(a(i2), this.f7692d, this.f7769e);
    }
}
