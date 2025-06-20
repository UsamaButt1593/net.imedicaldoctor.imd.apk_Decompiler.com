package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Comparator;

public class Table {

    /* renamed from: a  reason: collision with root package name */
    protected int f7772a;

    /* renamed from: b  reason: collision with root package name */
    protected ByteBuffer f7773b;

    /* renamed from: c  reason: collision with root package name */
    private int f7774c;

    /* renamed from: d  reason: collision with root package name */
    private int f7775d;

    /* renamed from: e  reason: collision with root package name */
    Utf8 f7776e = Utf8.d();

    protected static boolean a(ByteBuffer byteBuffer, String str) {
        if (str.length() == 4) {
            for (int i2 = 0; i2 < 4; i2++) {
                if (str.charAt(i2) != ((char) byteBuffer.get(byteBuffer.position() + 4 + i2))) {
                    return false;
                }
            }
            return true;
        }
        throw new AssertionError("FlatBuffers: file identifier must be length 4");
    }

    /* access modifiers changed from: protected */
    public static int c(int i2, ByteBuffer byteBuffer) {
        return i2 + byteBuffer.getInt(i2);
    }

    protected static int e(int i2, int i3, ByteBuffer byteBuffer) {
        int capacity = byteBuffer.capacity() - i3;
        return byteBuffer.getShort((i2 + capacity) - byteBuffer.getInt(capacity)) + capacity;
    }

    protected static String i(int i2, ByteBuffer byteBuffer, Utf8 utf8) {
        int i3 = i2 + byteBuffer.getInt(i2);
        return utf8.a(byteBuffer, i3 + 4, byteBuffer.getInt(i3));
    }

    protected static Table k(Table table, int i2, ByteBuffer byteBuffer) {
        table.g(c(i2, byteBuffer), byteBuffer);
        return table;
    }

    protected static int p(int i2, int i3, ByteBuffer byteBuffer) {
        int i4 = i2 + byteBuffer.getInt(i2);
        int i5 = i3 + byteBuffer.getInt(i3);
        int i6 = byteBuffer.getInt(i4);
        int i7 = byteBuffer.getInt(i5);
        int i8 = i4 + 4;
        int i9 = i5 + 4;
        int min = Math.min(i6, i7);
        for (int i10 = 0; i10 < min; i10++) {
            int i11 = i10 + i8;
            int i12 = i10 + i9;
            if (byteBuffer.get(i11) != byteBuffer.get(i12)) {
                return byteBuffer.get(i11) - byteBuffer.get(i12);
            }
        }
        return i6 - i7;
    }

    protected static int q(int i2, byte[] bArr, ByteBuffer byteBuffer) {
        int i3 = i2 + byteBuffer.getInt(i2);
        int i4 = byteBuffer.getInt(i3);
        int length = bArr.length;
        int i5 = i3 + 4;
        int min = Math.min(i4, length);
        for (int i6 = 0; i6 < min; i6++) {
            int i7 = i6 + i5;
            if (byteBuffer.get(i7) != bArr[i6]) {
                return byteBuffer.get(i7) - bArr[i6];
            }
        }
        return i4 - length;
    }

    /* access modifiers changed from: protected */
    public int b(int i2) {
        return i2 + this.f7773b.getInt(i2);
    }

    /* access modifiers changed from: protected */
    public int d(int i2) {
        if (i2 < this.f7775d) {
            return this.f7773b.getShort(this.f7774c + i2);
        }
        return 0;
    }

    public void f() {
        g(0, (ByteBuffer) null);
    }

    /* access modifiers changed from: protected */
    public void g(int i2, ByteBuffer byteBuffer) {
        short s;
        this.f7773b = byteBuffer;
        if (byteBuffer != null) {
            this.f7772a = i2;
            int i3 = i2 - byteBuffer.getInt(i2);
            this.f7774c = i3;
            s = this.f7773b.getShort(i3);
        } else {
            s = 0;
            this.f7772a = 0;
            this.f7774c = 0;
        }
        this.f7775d = s;
    }

    /* access modifiers changed from: protected */
    public String h(int i2) {
        return i(i2, this.f7773b, this.f7776e);
    }

    /* access modifiers changed from: protected */
    public Table j(Table table, int i2) {
        return k(table, i2, this.f7773b);
    }

    /* access modifiers changed from: protected */
    public int l(int i2) {
        int i3 = i2 + this.f7772a;
        return i3 + this.f7773b.getInt(i3) + 4;
    }

    /* access modifiers changed from: protected */
    public ByteBuffer m(int i2, int i3) {
        int d2 = d(i2);
        if (d2 == 0) {
            return null;
        }
        ByteBuffer order = this.f7773b.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        int l2 = l(d2);
        order.position(l2);
        order.limit(l2 + (o(d2) * i3));
        return order;
    }

    /* access modifiers changed from: protected */
    public ByteBuffer n(ByteBuffer byteBuffer, int i2, int i3) {
        int d2 = d(i2);
        if (d2 == 0) {
            return null;
        }
        int l2 = l(d2);
        byteBuffer.rewind();
        byteBuffer.limit((o(d2) * i3) + l2);
        byteBuffer.position(l2);
        return byteBuffer;
    }

    /* access modifiers changed from: protected */
    public int o(int i2) {
        int i3 = i2 + this.f7772a;
        return this.f7773b.getInt(i3 + this.f7773b.getInt(i3));
    }

    public ByteBuffer r() {
        return this.f7773b;
    }

    /* access modifiers changed from: protected */
    public int s(Integer num, Integer num2, ByteBuffer byteBuffer) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void t(int[] iArr, final ByteBuffer byteBuffer) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            numArr[i2] = Integer.valueOf(iArr[i2]);
        }
        Arrays.sort(numArr, new Comparator<Integer>() {
            /* renamed from: a */
            public int compare(Integer num, Integer num2) {
                return Table.this.s(num, num2, byteBuffer);
            }
        });
        for (int i3 = 0; i3 < iArr.length; i3++) {
            iArr[i3] = numArr[i3].intValue();
        }
    }
}
