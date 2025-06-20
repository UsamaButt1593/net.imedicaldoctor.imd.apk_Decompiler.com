package androidx.emoji2.text.flatbuffer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class FlatBufferBuilder {
    static final /* synthetic */ boolean o = false;

    /* renamed from: a  reason: collision with root package name */
    ByteBuffer f7702a;

    /* renamed from: b  reason: collision with root package name */
    int f7703b;

    /* renamed from: c  reason: collision with root package name */
    int f7704c;

    /* renamed from: d  reason: collision with root package name */
    int[] f7705d;

    /* renamed from: e  reason: collision with root package name */
    int f7706e;

    /* renamed from: f  reason: collision with root package name */
    boolean f7707f;

    /* renamed from: g  reason: collision with root package name */
    boolean f7708g;

    /* renamed from: h  reason: collision with root package name */
    int f7709h;

    /* renamed from: i  reason: collision with root package name */
    int[] f7710i;

    /* renamed from: j  reason: collision with root package name */
    int f7711j;

    /* renamed from: k  reason: collision with root package name */
    int f7712k;

    /* renamed from: l  reason: collision with root package name */
    boolean f7713l;

    /* renamed from: m  reason: collision with root package name */
    ByteBufferFactory f7714m;

    /* renamed from: n  reason: collision with root package name */
    final Utf8 f7715n;

    static class ByteBufferBackedInputStream extends InputStream {
        ByteBuffer s;

        public ByteBufferBackedInputStream(ByteBuffer byteBuffer) {
            this.s = byteBuffer;
        }

        public int read() throws IOException {
            try {
                return this.s.get() & 255;
            } catch (BufferUnderflowException unused) {
                return -1;
            }
        }
    }

    public static abstract class ByteBufferFactory {
        public abstract ByteBuffer a(int i2);

        public void b(ByteBuffer byteBuffer) {
        }
    }

    public static final class HeapByteBufferFactory extends ByteBufferFactory {

        /* renamed from: a  reason: collision with root package name */
        public static final HeapByteBufferFactory f7716a = new HeapByteBufferFactory();

        public ByteBuffer a(int i2) {
            return ByteBuffer.allocate(i2).order(ByteOrder.LITTLE_ENDIAN);
        }
    }

    public FlatBufferBuilder() {
        this(1024);
    }

    @Deprecated
    private int C() {
        L();
        return this.f7703b;
    }

    static ByteBuffer N(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        int capacity = byteBuffer.capacity();
        if ((-1073741824 & capacity) == 0) {
            int i2 = capacity == 0 ? 1 : capacity << 1;
            byteBuffer.position(0);
            ByteBuffer a2 = byteBufferFactory.a(i2);
            a2.position(a2.clear().capacity() - capacity);
            a2.put(byteBuffer);
            return a2;
        }
        throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
    }

    public static boolean P(Table table, int i2) {
        return table.d(i2) != 0;
    }

    public int A(int[] iArr) {
        Q();
        h0(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            n(iArr[length]);
        }
        return E();
    }

    public ByteBuffer B() {
        L();
        return this.f7702a;
    }

    public int D() {
        int i2;
        if (this.f7705d == null || !this.f7707f) {
            throw new AssertionError("FlatBuffers: endTable called without startTable");
        }
        j(0);
        int R = R();
        int i3 = this.f7706e - 1;
        while (i3 >= 0 && this.f7705d[i3] == 0) {
            i3--;
        }
        for (int i4 = i3; i4 >= 0; i4--) {
            int i5 = this.f7705d[i4];
            q((short) (i5 != 0 ? R - i5 : 0));
        }
        q((short) (R - this.f7709h));
        q((short) ((i3 + 3) * 2));
        int i6 = 0;
        loop2:
        while (true) {
            if (i6 >= this.f7711j) {
                i2 = 0;
                break;
            }
            int capacity = this.f7702a.capacity() - this.f7710i[i6];
            int i7 = this.f7703b;
            short s = this.f7702a.getShort(capacity);
            if (s == this.f7702a.getShort(i7)) {
                int i8 = 2;
                while (i8 < s) {
                    if (this.f7702a.getShort(capacity + i8) == this.f7702a.getShort(i7 + i8)) {
                        i8 += 2;
                    }
                }
                i2 = this.f7710i[i6];
                break loop2;
            }
            i6++;
        }
        if (i2 != 0) {
            int capacity2 = this.f7702a.capacity() - R;
            this.f7703b = capacity2;
            this.f7702a.putInt(capacity2, i2 - R);
        } else {
            int i9 = this.f7711j;
            int[] iArr = this.f7710i;
            if (i9 == iArr.length) {
                this.f7710i = Arrays.copyOf(iArr, i9 * 2);
            }
            int[] iArr2 = this.f7710i;
            int i10 = this.f7711j;
            this.f7711j = i10 + 1;
            iArr2[i10] = R();
            ByteBuffer byteBuffer = this.f7702a;
            byteBuffer.putInt(byteBuffer.capacity() - R, R() - R);
        }
        this.f7707f = false;
        return R;
    }

    public int E() {
        if (this.f7707f) {
            this.f7707f = false;
            Y(this.f7712k);
            return R();
        }
        throw new AssertionError("FlatBuffers: endVector called without startVector");
    }

    public void F(int i2) {
        I(i2, false);
    }

    public void G(int i2, String str) {
        H(i2, str, false);
    }

    /* access modifiers changed from: protected */
    public void H(int i2, String str, boolean z) {
        T(this.f7704c, (z ? 4 : 0) + 8);
        if (str.length() == 4) {
            for (int i3 = 3; i3 >= 0; i3--) {
                d((byte) str.charAt(i3));
            }
            I(i2, z);
            return;
        }
        throw new AssertionError("FlatBuffers: file identifier must be length 4");
    }

    /* access modifiers changed from: protected */
    public void I(int i2, boolean z) {
        T(this.f7704c, (z ? 4 : 0) + 4);
        n(i2);
        if (z) {
            j(this.f7702a.capacity() - this.f7703b);
        }
        this.f7702a.position(this.f7703b);
        this.f7708g = true;
    }

    public void J(int i2) {
        I(i2, true);
    }

    public void K(int i2, String str) {
        H(i2, str, true);
    }

    public void L() {
        if (!this.f7708g) {
            throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        }
    }

    public FlatBufferBuilder M(boolean z) {
        this.f7713l = z;
        return this;
    }

    public FlatBufferBuilder O(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        this.f7714m = byteBufferFactory;
        this.f7702a = byteBuffer;
        byteBuffer.clear();
        this.f7702a.order(ByteOrder.LITTLE_ENDIAN);
        this.f7704c = 1;
        this.f7703b = this.f7702a.capacity();
        this.f7706e = 0;
        this.f7707f = false;
        this.f7708g = false;
        this.f7709h = 0;
        this.f7711j = 0;
        this.f7712k = 0;
        return this;
    }

    public void Q() {
        if (this.f7707f) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    public int R() {
        return this.f7702a.capacity() - this.f7703b;
    }

    public void S(int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            ByteBuffer byteBuffer = this.f7702a;
            int i4 = this.f7703b - 1;
            this.f7703b = i4;
            byteBuffer.put(i4, (byte) 0);
        }
    }

    public void T(int i2, int i3) {
        if (i2 > this.f7704c) {
            this.f7704c = i2;
        }
        int i4 = ((~((this.f7702a.capacity() - this.f7703b) + i3)) + 1) & (i2 - 1);
        while (this.f7703b < i4 + i2 + i3) {
            int capacity = this.f7702a.capacity();
            ByteBuffer byteBuffer = this.f7702a;
            ByteBuffer N = N(byteBuffer, this.f7714m);
            this.f7702a = N;
            if (byteBuffer != N) {
                this.f7714m.b(byteBuffer);
            }
            this.f7703b += this.f7702a.capacity() - capacity;
        }
        S(i4);
    }

    public void U(boolean z) {
        ByteBuffer byteBuffer = this.f7702a;
        int i2 = this.f7703b - 1;
        this.f7703b = i2;
        byteBuffer.put(i2, z ? (byte) 1 : 0);
    }

    public void V(byte b2) {
        ByteBuffer byteBuffer = this.f7702a;
        int i2 = this.f7703b - 1;
        this.f7703b = i2;
        byteBuffer.put(i2, b2);
    }

    public void W(double d2) {
        ByteBuffer byteBuffer = this.f7702a;
        int i2 = this.f7703b - 8;
        this.f7703b = i2;
        byteBuffer.putDouble(i2, d2);
    }

    public void X(float f2) {
        ByteBuffer byteBuffer = this.f7702a;
        int i2 = this.f7703b - 4;
        this.f7703b = i2;
        byteBuffer.putFloat(i2, f2);
    }

    public void Y(int i2) {
        ByteBuffer byteBuffer = this.f7702a;
        int i3 = this.f7703b - 4;
        this.f7703b = i3;
        byteBuffer.putInt(i3, i2);
    }

    public void Z(long j2) {
        ByteBuffer byteBuffer = this.f7702a;
        int i2 = this.f7703b - 8;
        this.f7703b = i2;
        byteBuffer.putLong(i2, j2);
    }

    public void a(int i2) {
        if (i2 != R()) {
            throw new AssertionError("FlatBuffers: struct must be serialized inline.");
        }
    }

    public void a0(short s) {
        ByteBuffer byteBuffer = this.f7702a;
        int i2 = this.f7703b - 2;
        this.f7703b = i2;
        byteBuffer.putShort(i2, s);
    }

    public void b(int i2, boolean z, boolean z2) {
        if (this.f7713l || z != z2) {
            c(z);
            f0(i2);
        }
    }

    public void b0(int i2, int i3) {
        int capacity = this.f7702a.capacity() - i2;
        if (this.f7702a.getShort((capacity - this.f7702a.getInt(capacity)) + i3) == 0) {
            throw new AssertionError("FlatBuffers: field " + i3 + " must be set");
        }
    }

    public void c(boolean z) {
        T(1, 0);
        U(z);
    }

    public byte[] c0() {
        return d0(this.f7703b, this.f7702a.capacity() - this.f7703b);
    }

    public void d(byte b2) {
        T(1, 0);
        V(b2);
    }

    public byte[] d0(int i2, int i3) {
        L();
        byte[] bArr = new byte[i3];
        this.f7702a.position(i2);
        this.f7702a.get(bArr);
        return bArr;
    }

    public void e(int i2, byte b2, int i3) {
        if (this.f7713l || b2 != i3) {
            d(b2);
            f0(i2);
        }
    }

    public InputStream e0() {
        L();
        ByteBuffer duplicate = this.f7702a.duplicate();
        duplicate.position(this.f7703b);
        duplicate.limit(this.f7702a.capacity());
        return new ByteBufferBackedInputStream(duplicate);
    }

    public void f(double d2) {
        T(8, 0);
        W(d2);
    }

    public void f0(int i2) {
        this.f7705d[i2] = R();
    }

    public void g(int i2, double d2, double d3) {
        if (this.f7713l || d2 != d3) {
            f(d2);
            f0(i2);
        }
    }

    public void g0(int i2) {
        Q();
        int[] iArr = this.f7705d;
        if (iArr == null || iArr.length < i2) {
            this.f7705d = new int[i2];
        }
        this.f7706e = i2;
        Arrays.fill(this.f7705d, 0, i2, 0);
        this.f7707f = true;
        this.f7709h = R();
    }

    public void h(float f2) {
        T(4, 0);
        X(f2);
    }

    public void h0(int i2, int i3, int i4) {
        Q();
        this.f7712k = i3;
        int i5 = i2 * i3;
        T(4, i5);
        T(i4, i5);
        this.f7707f = true;
    }

    public void i(int i2, float f2, double d2) {
        if (this.f7713l || ((double) f2) != d2) {
            h(f2);
            f0(i2);
        }
    }

    public void j(int i2) {
        T(4, 0);
        Y(i2);
    }

    public void k(int i2, int i3, int i4) {
        if (this.f7713l || i3 != i4) {
            j(i3);
            f0(i2);
        }
    }

    public void l(int i2, long j2, long j3) {
        if (this.f7713l || j2 != j3) {
            m(j2);
            f0(i2);
        }
    }

    public void m(long j2) {
        T(8, 0);
        Z(j2);
    }

    public void n(int i2) {
        T(4, 0);
        Y((R() - i2) + 4);
    }

    public void o(int i2, int i3, int i4) {
        if (this.f7713l || i3 != i4) {
            n(i3);
            f0(i2);
        }
    }

    public void p(int i2, short s, int i3) {
        if (this.f7713l || s != i3) {
            q(s);
            f0(i2);
        }
    }

    public void q(short s) {
        T(2, 0);
        a0(s);
    }

    public void r(int i2, int i3, int i4) {
        if (i3 != i4) {
            a(i3);
            f0(i2);
        }
    }

    public void s() {
        this.f7703b = this.f7702a.capacity();
        this.f7702a.clear();
        this.f7704c = 1;
        while (true) {
            int i2 = this.f7706e;
            if (i2 > 0) {
                int[] iArr = this.f7705d;
                int i3 = i2 - 1;
                this.f7706e = i3;
                iArr[i3] = 0;
            } else {
                this.f7706e = 0;
                this.f7707f = false;
                this.f7708g = false;
                this.f7709h = 0;
                this.f7711j = 0;
                this.f7712k = 0;
                return;
            }
        }
    }

    public int t(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        h0(1, remaining, 1);
        ByteBuffer byteBuffer2 = this.f7702a;
        int i2 = this.f7703b - remaining;
        this.f7703b = i2;
        byteBuffer2.position(i2);
        this.f7702a.put(byteBuffer);
        return E();
    }

    public int u(byte[] bArr) {
        int length = bArr.length;
        h0(1, length, 1);
        ByteBuffer byteBuffer = this.f7702a;
        int i2 = this.f7703b - length;
        this.f7703b = i2;
        byteBuffer.position(i2);
        this.f7702a.put(bArr);
        return E();
    }

    public int v(byte[] bArr, int i2, int i3) {
        h0(1, i3, 1);
        ByteBuffer byteBuffer = this.f7702a;
        int i4 = this.f7703b - i3;
        this.f7703b = i4;
        byteBuffer.position(i4);
        this.f7702a.put(bArr, i2, i3);
        return E();
    }

    public <T extends Table> int w(T t, int[] iArr) {
        t.t(iArr, this.f7702a);
        return A(iArr);
    }

    public int x(CharSequence charSequence) {
        int c2 = this.f7715n.c(charSequence);
        d((byte) 0);
        h0(1, c2, 1);
        ByteBuffer byteBuffer = this.f7702a;
        int i2 = this.f7703b - c2;
        this.f7703b = i2;
        byteBuffer.position(i2);
        this.f7715n.b(charSequence, this.f7702a);
        return E();
    }

    public int y(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        d((byte) 0);
        h0(1, remaining, 1);
        ByteBuffer byteBuffer2 = this.f7702a;
        int i2 = this.f7703b - remaining;
        this.f7703b = i2;
        byteBuffer2.position(i2);
        this.f7702a.put(byteBuffer);
        return E();
    }

    public ByteBuffer z(int i2, int i3, int i4) {
        int i5 = i2 * i3;
        h0(i2, i3, i4);
        ByteBuffer byteBuffer = this.f7702a;
        int i6 = this.f7703b - i5;
        this.f7703b = i6;
        byteBuffer.position(i6);
        ByteBuffer order = this.f7702a.slice().order(ByteOrder.LITTLE_ENDIAN);
        order.limit(i5);
        return order;
    }

    public FlatBufferBuilder(int i2) {
        this(i2, HeapByteBufferFactory.f7716a, (ByteBuffer) null, Utf8.d());
    }

    public FlatBufferBuilder(int i2, ByteBufferFactory byteBufferFactory) {
        this(i2, byteBufferFactory, (ByteBuffer) null, Utf8.d());
    }

    public FlatBufferBuilder(int i2, ByteBufferFactory byteBufferFactory, ByteBuffer byteBuffer, Utf8 utf8) {
        this.f7704c = 1;
        this.f7705d = null;
        this.f7706e = 0;
        this.f7707f = false;
        this.f7708g = false;
        this.f7710i = new int[16];
        this.f7711j = 0;
        this.f7712k = 0;
        this.f7713l = false;
        i2 = i2 <= 0 ? 1 : i2;
        this.f7714m = byteBufferFactory;
        if (byteBuffer != null) {
            this.f7702a = byteBuffer;
            byteBuffer.clear();
            this.f7702a.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f7702a = byteBufferFactory.a(i2);
        }
        this.f7715n = utf8;
        this.f7703b = this.f7702a.capacity();
    }

    public FlatBufferBuilder(ByteBuffer byteBuffer) {
        this(byteBuffer, (ByteBufferFactory) new HeapByteBufferFactory());
    }

    public FlatBufferBuilder(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        this(byteBuffer.capacity(), byteBufferFactory, byteBuffer, Utf8.d());
    }
}
