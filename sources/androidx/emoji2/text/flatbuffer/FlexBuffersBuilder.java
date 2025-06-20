package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.FlexBuffers;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class FlexBuffersBuilder {

    /* renamed from: h  reason: collision with root package name */
    public static final int f7749h = 0;

    /* renamed from: i  reason: collision with root package name */
    public static final int f7750i = 1;

    /* renamed from: j  reason: collision with root package name */
    public static final int f7751j = 2;

    /* renamed from: k  reason: collision with root package name */
    public static final int f7752k = 3;

    /* renamed from: l  reason: collision with root package name */
    public static final int f7753l = 4;

    /* renamed from: m  reason: collision with root package name */
    public static final int f7754m = 7;

    /* renamed from: n  reason: collision with root package name */
    private static final int f7755n = 0;
    private static final int o = 1;
    private static final int p = 2;
    private static final int q = 3;
    static final /* synthetic */ boolean r = false;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ReadWriteBuf f7756a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<Value> f7757b;

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, Integer> f7758c;

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, Integer> f7759d;

    /* renamed from: e  reason: collision with root package name */
    private final int f7760e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7761f;

    /* renamed from: g  reason: collision with root package name */
    private Comparator<Value> f7762g;

    private static class Value {

        /* renamed from: f  reason: collision with root package name */
        static final /* synthetic */ boolean f7763f = false;

        /* renamed from: a  reason: collision with root package name */
        final int f7764a;

        /* renamed from: b  reason: collision with root package name */
        final int f7765b;

        /* renamed from: c  reason: collision with root package name */
        final double f7766c;

        /* renamed from: d  reason: collision with root package name */
        long f7767d;

        /* renamed from: e  reason: collision with root package name */
        int f7768e;

        Value(int i2, int i3, int i4, double d2) {
            this.f7768e = i2;
            this.f7764a = i3;
            this.f7765b = i4;
            this.f7766c = d2;
            this.f7767d = Long.MIN_VALUE;
        }

        static Value f(int i2, int i3, int i4, int i5) {
            return new Value(i2, i4, i5, (long) i3);
        }

        static Value g(int i2, boolean z) {
            return new Value(i2, 26, 0, z ? 1 : 0);
        }

        /* access modifiers changed from: private */
        public int h(int i2, int i3) {
            return i(this.f7764a, this.f7765b, this.f7767d, i2, i3);
        }

        /* access modifiers changed from: private */
        public static int i(int i2, int i3, long j2, int i4, int i5) {
            if (FlexBuffers.j(i2)) {
                return i3;
            }
            for (int i6 = 1; i6 <= 32; i6 *= 2) {
                int E = FlexBuffersBuilder.E((long) ((int) (((long) ((q(i4, i6) + i4) + (i5 * i6))) - j2)));
                if ((1 << E) == ((long) i6)) {
                    return E;
                }
            }
            return 3;
        }

        static Value j(int i2, float f2) {
            return new Value(i2, 3, 2, (double) f2);
        }

        static Value k(int i2, double d2) {
            return new Value(i2, 3, 3, d2);
        }

        static Value l(int i2, int i3) {
            return new Value(i2, 1, 1, (long) i3);
        }

        static Value m(int i2, int i3) {
            return new Value(i2, 1, 2, (long) i3);
        }

        static Value n(int i2, long j2) {
            return new Value(i2, 1, 3, j2);
        }

        static Value o(int i2, int i3) {
            return new Value(i2, 1, 0, (long) i3);
        }

        private static byte p(int i2, int i3) {
            return (byte) (i2 | (i3 << 2));
        }

        /* access modifiers changed from: private */
        public static int q(int i2, int i3) {
            return ((~i2) + 1) & (i3 - 1);
        }

        /* access modifiers changed from: private */
        public byte r() {
            return s(0);
        }

        /* access modifiers changed from: private */
        public byte s(int i2) {
            return p(t(i2), this.f7764a);
        }

        private int t(int i2) {
            return FlexBuffers.j(this.f7764a) ? Math.max(this.f7765b, i2) : this.f7765b;
        }

        static Value u(int i2, int i3) {
            return new Value(i2, 2, 1, (long) i3);
        }

        static Value v(int i2, int i3) {
            return new Value(i2, 2, 2, (long) i3);
        }

        static Value w(int i2, long j2) {
            return new Value(i2, 2, 3, j2);
        }

        static Value x(int i2, int i3) {
            return new Value(i2, 2, 0, (long) i3);
        }

        Value(int i2, int i3, int i4, long j2) {
            this.f7768e = i2;
            this.f7764a = i3;
            this.f7765b = i4;
            this.f7767d = j2;
            this.f7766c = Double.MIN_VALUE;
        }
    }

    public FlexBuffersBuilder() {
        this(256);
    }

    private void A(String str, long j2) {
        this.f7757b.add(Value.w(u(str), j2));
    }

    static int E(long j2) {
        if (j2 <= ((long) FlexBuffers.Unsigned.a((byte) -1))) {
            return 0;
        }
        if (j2 <= ((long) FlexBuffers.Unsigned.c(-1))) {
            return 1;
        }
        return j2 <= FlexBuffers.Unsigned.b(-1) ? 2 : 3;
    }

    private void F(Value value, int i2) {
        int i3 = value.f7764a;
        if (!(i3 == 0 || i3 == 1 || i3 == 2)) {
            if (i3 == 3) {
                H(value.f7766c, i2);
                return;
            } else if (i3 != 26) {
                J(value.f7767d, i2);
                return;
            }
        }
        I(value.f7767d, i2);
    }

    private Value G(int i2, byte[] bArr, int i3, boolean z) {
        int E = E((long) bArr.length);
        I((long) bArr.length, b(E));
        int n2 = this.f7756a.n();
        this.f7756a.o(bArr, 0, bArr.length);
        if (z) {
            this.f7756a.q((byte) 0);
        }
        return Value.f(i2, n2, i3, E);
    }

    private void H(double d2, int i2) {
        if (i2 == 4) {
            this.f7756a.d((float) d2);
        } else if (i2 == 8) {
            this.f7756a.a(d2);
        }
    }

    private void I(long j2, int i2) {
        if (i2 == 1) {
            this.f7756a.q((byte) ((int) j2));
        } else if (i2 == 2) {
            this.f7756a.b((short) ((int) j2));
        } else if (i2 == 4) {
            this.f7756a.e((int) j2);
        } else if (i2 == 8) {
            this.f7756a.f(j2);
        }
    }

    private void J(long j2, int i2) {
        I((long) ((int) (((long) this.f7756a.n()) - j2)), i2);
    }

    private Value K(int i2, String str) {
        return G(i2, str.getBytes(StandardCharsets.UTF_8), 5, true);
    }

    private int b(int i2) {
        int i3 = 1 << i2;
        int a2 = Value.q(this.f7756a.n(), i3);
        while (true) {
            int i4 = a2 - 1;
            if (a2 == 0) {
                return i3;
            }
            this.f7756a.q((byte) 0);
            a2 = i4;
        }
    }

    private Value c(int i2, int i3) {
        long j2 = (long) i3;
        int max = Math.max(0, E(j2));
        int i4 = i2;
        while (i4 < this.f7757b.size()) {
            i4++;
            max = Math.max(max, Value.i(4, 0, (long) this.f7757b.get(i4).f7768e, this.f7756a.n(), i4));
        }
        int b2 = b(max);
        I(j2, b2);
        int n2 = this.f7756a.n();
        while (i2 < this.f7757b.size()) {
            int i5 = this.f7757b.get(i2).f7768e;
            J((long) this.f7757b.get(i2).f7768e, b2);
            i2++;
        }
        return new Value(-1, FlexBuffers.q(4, 0), max, (long) n2);
    }

    private Value d(int i2, int i3, int i4, boolean z, boolean z2, Value value) {
        int i5;
        int i6;
        Value value2 = value;
        int i7 = i4;
        long j2 = (long) i7;
        int max = Math.max(0, E(j2));
        if (value2 != null) {
            max = Math.max(max, value2.h(this.f7756a.n(), 0));
            i5 = 3;
        } else {
            i5 = 1;
        }
        int i8 = 4;
        int i9 = max;
        for (int i10 = i3; i10 < this.f7757b.size(); i10++) {
            i9 = Math.max(i9, this.f7757b.get(i10).h(this.f7756a.n(), i10 + i5));
            int i11 = i3;
            if (z && i10 == i11) {
                i8 = this.f7757b.get(i10).f7764a;
                if (!FlexBuffers.l(i8)) {
                    throw new FlexBuffers.FlexBufferException("TypedVector does not support this element type");
                }
            }
        }
        int i12 = i3;
        int b2 = b(i9);
        if (value2 != null) {
            J(value2.f7767d, b2);
            I(1 << value2.f7765b, b2);
        }
        if (!z2) {
            I(j2, b2);
        }
        int n2 = this.f7756a.n();
        for (int i13 = i12; i13 < this.f7757b.size(); i13++) {
            F(this.f7757b.get(i13), b2);
        }
        if (!z) {
            while (i12 < this.f7757b.size()) {
                this.f7756a.q(this.f7757b.get(i12).s(i9));
                i12++;
            }
        }
        if (value2 != null) {
            i6 = 9;
        } else if (z) {
            if (!z2) {
                i7 = 0;
            }
            i6 = FlexBuffers.q(i8, i7);
        } else {
            i6 = 10;
        }
        return new Value(i2, i6, i9, (long) n2);
    }

    private int u(String str) {
        if (str == null) {
            return -1;
        }
        int n2 = this.f7756a.n();
        if ((this.f7760e & 1) != 0) {
            Integer num = this.f7758c.get(str);
            if (num != null) {
                return num.intValue();
            }
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            this.f7756a.o(bytes, 0, bytes.length);
        } else {
            byte[] bytes2 = str.getBytes(StandardCharsets.UTF_8);
            this.f7756a.o(bytes2, 0, bytes2.length);
        }
        this.f7756a.q((byte) 0);
        this.f7758c.put(str, Integer.valueOf(n2));
        return n2;
    }

    private void z(String str, long j2) {
        int u = u(str);
        int E = E(j2);
        this.f7757b.add(E == 0 ? Value.x(u, (int) j2) : E == 1 ? Value.u(u, (int) j2) : E == 2 ? Value.v(u, (int) j2) : Value.w(u, j2));
    }

    public void B(BigInteger bigInteger) {
        A((String) null, bigInteger.longValue());
    }

    public int C() {
        return this.f7757b.size();
    }

    public int D() {
        return this.f7757b.size();
    }

    public int e(String str, int i2) {
        int u = u(str);
        ArrayList<Value> arrayList = this.f7757b;
        Collections.sort(arrayList.subList(i2, arrayList.size()), this.f7762g);
        int i3 = i2;
        Value d2 = d(u, i3, this.f7757b.size() - i2, false, false, c(i2, this.f7757b.size() - i2));
        while (this.f7757b.size() > i2) {
            ArrayList<Value> arrayList2 = this.f7757b;
            arrayList2.remove(arrayList2.size() - 1);
        }
        this.f7757b.add(d2);
        return (int) d2.f7767d;
    }

    public int f(String str, int i2, boolean z, boolean z2) {
        Value d2 = d(u(str), i2, this.f7757b.size() - i2, z, z2, (Value) null);
        while (this.f7757b.size() > i2) {
            ArrayList<Value> arrayList = this.f7757b;
            arrayList.remove(arrayList.size() - 1);
        }
        this.f7757b.add(d2);
        return (int) d2.f7767d;
    }

    public ByteBuffer g() {
        int b2 = b(this.f7757b.get(0).h(this.f7756a.n(), 0));
        F(this.f7757b.get(0), b2);
        this.f7756a.q(this.f7757b.get(0).r());
        this.f7756a.q((byte) b2);
        this.f7761f = true;
        return ByteBuffer.wrap(this.f7756a.i(), 0, this.f7756a.n());
    }

    public ReadWriteBuf h() {
        return this.f7756a;
    }

    public int i(String str, byte[] bArr) {
        Value G = G(u(str), bArr, 25, false);
        this.f7757b.add(G);
        return (int) G.f7767d;
    }

    public int j(byte[] bArr) {
        return i((String) null, bArr);
    }

    public void k(String str, boolean z) {
        this.f7757b.add(Value.g(u(str), z));
    }

    public void l(boolean z) {
        k((String) null, z);
    }

    public void m(double d2) {
        o((String) null, d2);
    }

    public void n(float f2) {
        p((String) null, f2);
    }

    public void o(String str, double d2) {
        this.f7757b.add(Value.k(u(str), d2));
    }

    public void p(String str, float f2) {
        this.f7757b.add(Value.j(u(str), f2));
    }

    public void q(int i2) {
        s((String) null, i2);
    }

    public void r(long j2) {
        t((String) null, j2);
    }

    public void s(String str, int i2) {
        t(str, (long) i2);
    }

    public void t(String str, long j2) {
        ArrayList<Value> arrayList;
        Value n2;
        int u = u(str);
        if (-128 <= j2 && j2 <= 127) {
            arrayList = this.f7757b;
            n2 = Value.o(u, (int) j2);
        } else if (-32768 <= j2 && j2 <= 32767) {
            arrayList = this.f7757b;
            n2 = Value.l(u, (int) j2);
        } else if (-2147483648L > j2 || j2 > 2147483647L) {
            arrayList = this.f7757b;
            n2 = Value.n(u, j2);
        } else {
            arrayList = this.f7757b;
            n2 = Value.m(u, (int) j2);
        }
        arrayList.add(n2);
    }

    public int v(String str) {
        return w((String) null, str);
    }

    public int w(String str, String str2) {
        Value K;
        int u = u(str);
        if ((this.f7760e & 2) != 0) {
            Integer num = this.f7759d.get(str2);
            if (num == null) {
                K = K(u, str2);
                this.f7759d.put(str2, Integer.valueOf((int) K.f7767d));
            } else {
                this.f7757b.add(Value.f(u, num.intValue(), 5, E((long) str2.length())));
                return num.intValue();
            }
        } else {
            K = K(u, str2);
        }
        this.f7757b.add(K);
        return (int) K.f7767d;
    }

    public void x(int i2) {
        z((String) null, (long) i2);
    }

    public void y(long j2) {
        z((String) null, j2);
    }

    public FlexBuffersBuilder(int i2) {
        this((ReadWriteBuf) new ArrayReadWriteBuf(i2), 1);
    }

    public FlexBuffersBuilder(ReadWriteBuf readWriteBuf, int i2) {
        this.f7757b = new ArrayList<>();
        this.f7758c = new HashMap<>();
        this.f7759d = new HashMap<>();
        this.f7761f = false;
        this.f7762g = new Comparator<Value>() {
            /* renamed from: a */
            public int compare(Value value, Value value2) {
                byte b2;
                byte b3;
                int i2 = value.f7768e;
                int i3 = value2.f7768e;
                do {
                    b2 = FlexBuffersBuilder.this.f7756a.get(i2);
                    b3 = FlexBuffersBuilder.this.f7756a.get(i3);
                    if (b2 == 0) {
                        return b2 - b3;
                    }
                    i2++;
                    i3++;
                } while (b2 == b3);
                return b2 - b3;
            }
        };
        this.f7756a = readWriteBuf;
        this.f7760e = i2;
    }

    public FlexBuffersBuilder(ByteBuffer byteBuffer) {
        this(byteBuffer, 1);
    }

    @Deprecated
    public FlexBuffersBuilder(ByteBuffer byteBuffer, int i2) {
        this((ReadWriteBuf) new ArrayReadWriteBuf(byteBuffer.array()), i2);
    }
}
