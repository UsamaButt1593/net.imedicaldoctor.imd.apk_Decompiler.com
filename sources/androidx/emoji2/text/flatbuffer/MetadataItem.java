package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class MetadataItem extends Table {

    public static final class Vector extends BaseVector {
        public Vector f(int i2, int i3, ByteBuffer byteBuffer) {
            b(i2, i3, byteBuffer);
            return this;
        }

        public MetadataItem g(int i2) {
            return h(new MetadataItem(), i2);
        }

        public MetadataItem h(MetadataItem metadataItem, int i2) {
            return metadataItem.v(Table.c(a(i2), this.f7692d), this.f7692d);
        }
    }

    public static void A(FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.b(1, z, false);
    }

    public static void B(FlatBufferBuilder flatBufferBuilder, short s) {
        flatBufferBuilder.p(5, s, 0);
    }

    public static void C(FlatBufferBuilder flatBufferBuilder, int i2) {
        flatBufferBuilder.k(0, i2, 0);
    }

    public static void D(FlatBufferBuilder flatBufferBuilder, short s) {
        flatBufferBuilder.p(2, s, 0);
    }

    public static void E(FlatBufferBuilder flatBufferBuilder, short s) {
        flatBufferBuilder.p(4, s, 0);
    }

    public static int M(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.h0(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.j(iArr[length]);
        }
        return flatBufferBuilder.E();
    }

    public static int N(FlatBufferBuilder flatBufferBuilder, int i2, boolean z, short s, short s2, short s3, short s4, int i3) {
        flatBufferBuilder.g0(7);
        y(flatBufferBuilder, i3);
        C(flatBufferBuilder, i2);
        B(flatBufferBuilder, s4);
        E(flatBufferBuilder, s3);
        z(flatBufferBuilder, s2);
        D(flatBufferBuilder, s);
        A(flatBufferBuilder, z);
        return P(flatBufferBuilder);
    }

    public static int P(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.D();
    }

    public static MetadataItem Q(ByteBuffer byteBuffer) {
        return R(byteBuffer, new MetadataItem());
    }

    public static MetadataItem R(ByteBuffer byteBuffer, MetadataItem metadataItem) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return metadataItem.v(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public static void V(FlatBufferBuilder flatBufferBuilder, int i2) {
        flatBufferBuilder.h0(4, i2, 4);
    }

    public static void W(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.g0(7);
    }

    public static void u() {
        Constants.a();
    }

    public static void y(FlatBufferBuilder flatBufferBuilder, int i2) {
        flatBufferBuilder.o(6, i2, 0);
    }

    public static void z(FlatBufferBuilder flatBufferBuilder, short s) {
        flatBufferBuilder.p(3, s, 0);
    }

    public int F(int i2) {
        int d2 = d(16);
        if (d2 != 0) {
            return this.f7773b.getInt(l(d2) + (i2 * 4));
        }
        return 0;
    }

    public ByteBuffer G() {
        return m(16, 4);
    }

    public ByteBuffer H(ByteBuffer byteBuffer) {
        return n(byteBuffer, 16, 4);
    }

    public int I() {
        int d2 = d(16);
        if (d2 != 0) {
            return o(d2);
        }
        return 0;
    }

    public IntVector J() {
        return K(new IntVector());
    }

    public IntVector K(IntVector intVector) {
        int d2 = d(16);
        if (d2 != 0) {
            return intVector.f(l(d2), this.f7773b);
        }
        return null;
    }

    public short L() {
        int d2 = d(10);
        if (d2 != 0) {
            return this.f7773b.getShort(d2 + this.f7772a);
        }
        return 0;
    }

    public boolean O() {
        int d2 = d(6);
        return (d2 == 0 || this.f7773b.get(d2 + this.f7772a) == 0) ? false : true;
    }

    public short S() {
        int d2 = d(14);
        if (d2 != 0) {
            return this.f7773b.getShort(d2 + this.f7772a);
        }
        return 0;
    }

    public int T() {
        int d2 = d(4);
        if (d2 != 0) {
            return this.f7773b.getInt(d2 + this.f7772a);
        }
        return 0;
    }

    public short U() {
        int d2 = d(8);
        if (d2 != 0) {
            return this.f7773b.getShort(d2 + this.f7772a);
        }
        return 0;
    }

    public short X() {
        int d2 = d(12);
        if (d2 != 0) {
            return this.f7773b.getShort(d2 + this.f7772a);
        }
        return 0;
    }

    public MetadataItem v(int i2, ByteBuffer byteBuffer) {
        w(i2, byteBuffer);
        return this;
    }

    public void w(int i2, ByteBuffer byteBuffer) {
        g(i2, byteBuffer);
    }
}
