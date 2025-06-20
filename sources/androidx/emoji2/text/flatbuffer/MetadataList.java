package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.MetadataItem;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class MetadataList extends Table {

    public static final class Vector extends BaseVector {
        public Vector f(int i2, int i3, ByteBuffer byteBuffer) {
            b(i2, i3, byteBuffer);
            return this;
        }

        public MetadataList g(int i2) {
            return h(new MetadataList(), i2);
        }

        public MetadataList h(MetadataList metadataList, int i2) {
            return metadataList.v(Table.c(a(i2), this.f7692d), this.f7692d);
        }
    }

    public static void A(FlatBufferBuilder flatBufferBuilder, int i2) {
        flatBufferBuilder.k(0, i2, 0);
    }

    public static int B(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.h0(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.n(iArr[length]);
        }
        return flatBufferBuilder.E();
    }

    public static int C(FlatBufferBuilder flatBufferBuilder, int i2, int i3, int i4) {
        flatBufferBuilder.g0(3);
        z(flatBufferBuilder, i4);
        y(flatBufferBuilder, i3);
        A(flatBufferBuilder, i2);
        return D(flatBufferBuilder);
    }

    public static int D(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.D();
    }

    public static void E(FlatBufferBuilder flatBufferBuilder, int i2) {
        flatBufferBuilder.F(i2);
    }

    public static void F(FlatBufferBuilder flatBufferBuilder, int i2) {
        flatBufferBuilder.J(i2);
    }

    public static MetadataList G(ByteBuffer byteBuffer) {
        return H(byteBuffer, new MetadataList());
    }

    public static MetadataList H(ByteBuffer byteBuffer, MetadataList metadataList) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return metadataList.v(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public static void Q(FlatBufferBuilder flatBufferBuilder, int i2) {
        flatBufferBuilder.h0(4, i2, 4);
    }

    public static void R(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.g0(3);
    }

    public static void u() {
        Constants.a();
    }

    public static void y(FlatBufferBuilder flatBufferBuilder, int i2) {
        flatBufferBuilder.o(1, i2, 0);
    }

    public static void z(FlatBufferBuilder flatBufferBuilder, int i2) {
        flatBufferBuilder.o(2, i2, 0);
    }

    public MetadataItem I(int i2) {
        return J(new MetadataItem(), i2);
    }

    public MetadataItem J(MetadataItem metadataItem, int i2) {
        int d2 = d(6);
        if (d2 != 0) {
            return metadataItem.v(b(l(d2) + (i2 * 4)), this.f7773b);
        }
        return null;
    }

    public int K() {
        int d2 = d(6);
        if (d2 != 0) {
            return o(d2);
        }
        return 0;
    }

    public MetadataItem.Vector L() {
        return M(new MetadataItem.Vector());
    }

    public MetadataItem.Vector M(MetadataItem.Vector vector) {
        int d2 = d(6);
        if (d2 != 0) {
            return vector.f(l(d2), 4, this.f7773b);
        }
        return null;
    }

    public String N() {
        int d2 = d(8);
        if (d2 != 0) {
            return h(d2 + this.f7772a);
        }
        return null;
    }

    public ByteBuffer O() {
        return m(8, 1);
    }

    public ByteBuffer P(ByteBuffer byteBuffer) {
        return n(byteBuffer, 8, 1);
    }

    public int S() {
        int d2 = d(4);
        if (d2 != 0) {
            return this.f7773b.getInt(d2 + this.f7772a);
        }
        return 0;
    }

    public MetadataList v(int i2, ByteBuffer byteBuffer) {
        w(i2, byteBuffer);
        return this;
    }

    public void w(int i2, ByteBuffer byteBuffer) {
        g(i2, byteBuffer);
    }
}
