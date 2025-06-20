package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import kotlin.UShort;
import net.lingala.zip4j.util.InternalZipConstants;

public class FlexBuffers {
    public static final int A = 26;
    public static final int B = 36;
    /* access modifiers changed from: private */
    public static final ReadBuf C = new ArrayReadWriteBuf(new byte[]{0}, 1);
    static final /* synthetic */ boolean D = false;

    /* renamed from: a  reason: collision with root package name */
    public static final int f7717a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f7718b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f7719c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f7720d = 3;

    /* renamed from: e  reason: collision with root package name */
    public static final int f7721e = 4;

    /* renamed from: f  reason: collision with root package name */
    public static final int f7722f = 5;

    /* renamed from: g  reason: collision with root package name */
    public static final int f7723g = 6;

    /* renamed from: h  reason: collision with root package name */
    public static final int f7724h = 7;

    /* renamed from: i  reason: collision with root package name */
    public static final int f7725i = 8;

    /* renamed from: j  reason: collision with root package name */
    public static final int f7726j = 9;

    /* renamed from: k  reason: collision with root package name */
    public static final int f7727k = 10;

    /* renamed from: l  reason: collision with root package name */
    public static final int f7728l = 11;

    /* renamed from: m  reason: collision with root package name */
    public static final int f7729m = 12;

    /* renamed from: n  reason: collision with root package name */
    public static final int f7730n = 13;
    public static final int o = 14;
    public static final int p = 15;
    public static final int q = 16;
    public static final int r = 17;
    public static final int s = 18;
    public static final int t = 19;
    public static final int u = 20;
    public static final int v = 21;
    public static final int w = 22;
    public static final int x = 23;
    public static final int y = 24;
    public static final int z = 25;

    public static class Blob extends Sized {

        /* renamed from: e  reason: collision with root package name */
        static final Blob f7731e = new Blob(FlexBuffers.C, 1, 1);

        /* renamed from: f  reason: collision with root package name */
        static final /* synthetic */ boolean f7732f = false;

        Blob(ReadBuf readBuf, int i2, int i3) {
            super(readBuf, i2, i3);
        }

        public static Blob d() {
            return f7731e;
        }

        public StringBuilder a(StringBuilder sb) {
            sb.append('\"');
            sb.append(this.f7736a.j(this.f7737b, b()));
            sb.append('\"');
            return sb;
        }

        public /* bridge */ /* synthetic */ int b() {
            return super.b();
        }

        public ByteBuffer c() {
            ByteBuffer wrap = ByteBuffer.wrap(this.f7736a.i());
            wrap.position(this.f7737b);
            wrap.limit(this.f7737b + b());
            return wrap.asReadOnlyBuffer().slice();
        }

        public byte e(int i2) {
            return this.f7736a.get(this.f7737b + i2);
        }

        public byte[] f() {
            int b2 = b();
            byte[] bArr = new byte[b2];
            for (int i2 = 0; i2 < b2; i2++) {
                bArr[i2] = this.f7736a.get(this.f7737b + i2);
            }
            return bArr;
        }

        public String toString() {
            return this.f7736a.j(this.f7737b, b());
        }
    }

    public static class FlexBufferException extends RuntimeException {
        FlexBufferException(String str) {
            super(str);
        }
    }

    public static class Key extends Object {
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public static final Key f7733d = new Key(FlexBuffers.C, 0, 0);

        Key(ReadBuf readBuf, int i2, int i3) {
            super(readBuf, i2, i3);
        }

        public static Key d() {
            return f7733d;
        }

        public StringBuilder a(StringBuilder sb) {
            sb.append(toString());
            return sb;
        }

        /* access modifiers changed from: package-private */
        public int c(byte[] bArr) {
            byte b2;
            byte b3;
            int i2 = this.f7737b;
            int i3 = 0;
            do {
                b2 = this.f7736a.get(i2);
                b3 = bArr[i3];
                if (b2 == 0) {
                    return b2 - b3;
                }
                i2++;
                i3++;
                if (i3 == bArr.length) {
                    return b2 - b3;
                }
            } while (b2 == b3);
            return b2 - b3;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return key.f7737b == this.f7737b && key.f7738c == this.f7738c;
        }

        public int hashCode() {
            return this.f7737b ^ this.f7738c;
        }

        public String toString() {
            int i2 = this.f7737b;
            while (this.f7736a.get(i2) != 0) {
                i2++;
            }
            int i3 = this.f7737b;
            return this.f7736a.j(i3, i2 - i3);
        }
    }

    public static class KeyVector {

        /* renamed from: a  reason: collision with root package name */
        private final TypedVector f7734a;

        KeyVector(TypedVector typedVector) {
            this.f7734a = typedVector;
        }

        public Key a(int i2) {
            if (i2 >= b()) {
                return Key.f7733d;
            }
            TypedVector typedVector = this.f7734a;
            TypedVector typedVector2 = this.f7734a;
            ReadBuf readBuf = typedVector2.f7736a;
            return new Key(readBuf, FlexBuffers.i(readBuf, typedVector.f7737b + (i2 * typedVector.f7738c), typedVector2.f7738c), 1);
        }

        public int b() {
            return this.f7734a.b();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (int i2 = 0; i2 < this.f7734a.b(); i2++) {
                this.f7734a.d(i2).z(sb);
                if (i2 != this.f7734a.b() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static class Map extends Vector {

        /* renamed from: f  reason: collision with root package name */
        private static final Map f7735f = new Map(FlexBuffers.C, 1, 1);

        Map(ReadBuf readBuf, int i2, int i3) {
            super(readBuf, i2, i3);
        }

        private int f(KeyVector keyVector, byte[] bArr) {
            int b2 = keyVector.b() - 1;
            int i2 = 0;
            while (i2 <= b2) {
                int i3 = (i2 + b2) >>> 1;
                int c2 = keyVector.a(i3).c(bArr);
                if (c2 < 0) {
                    i2 = i3 + 1;
                } else if (c2 <= 0) {
                    return i3;
                } else {
                    b2 = i3 - 1;
                }
            }
            return -(i2 + 1);
        }

        public static Map g() {
            return f7735f;
        }

        public StringBuilder a(StringBuilder sb) {
            sb.append("{ ");
            KeyVector j2 = j();
            int b2 = b();
            Vector k2 = k();
            for (int i2 = 0; i2 < b2; i2++) {
                sb.append('\"');
                sb.append(j2.a(i2).toString());
                sb.append("\" : ");
                sb.append(k2.d(i2).toString());
                if (i2 != b2 - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" }");
            return sb;
        }

        public Reference h(String str) {
            return i(str.getBytes(StandardCharsets.UTF_8));
        }

        public Reference i(byte[] bArr) {
            KeyVector j2 = j();
            int b2 = j2.b();
            int f2 = f(j2, bArr);
            return (f2 < 0 || f2 >= b2) ? Reference.f7739f : d(f2);
        }

        public KeyVector j() {
            int i2 = this.f7737b - (this.f7738c * 3);
            ReadBuf readBuf = this.f7736a;
            int c2 = FlexBuffers.i(readBuf, i2, this.f7738c);
            ReadBuf readBuf2 = this.f7736a;
            int i3 = this.f7738c;
            return new KeyVector(new TypedVector(readBuf, c2, FlexBuffers.n(readBuf2, i2 + i3, i3), 4));
        }

        public Vector k() {
            return new Vector(this.f7736a, this.f7737b, this.f7738c);
        }
    }

    private static abstract class Object {

        /* renamed from: a  reason: collision with root package name */
        ReadBuf f7736a;

        /* renamed from: b  reason: collision with root package name */
        int f7737b;

        /* renamed from: c  reason: collision with root package name */
        int f7738c;

        Object(ReadBuf readBuf, int i2, int i3) {
            this.f7736a = readBuf;
            this.f7737b = i2;
            this.f7738c = i3;
        }

        public abstract StringBuilder a(StringBuilder sb);

        public String toString() {
            return a(new StringBuilder(128)).toString();
        }
    }

    public static class Reference {
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public static final Reference f7739f = new Reference(FlexBuffers.C, 0, 1, 0);

        /* renamed from: a  reason: collision with root package name */
        private ReadBuf f7740a;

        /* renamed from: b  reason: collision with root package name */
        private int f7741b;

        /* renamed from: c  reason: collision with root package name */
        private int f7742c;

        /* renamed from: d  reason: collision with root package name */
        private int f7743d;

        /* renamed from: e  reason: collision with root package name */
        private int f7744e;

        Reference(ReadBuf readBuf, int i2, int i3, int i4) {
            this(readBuf, i2, i3, 1 << (i4 & 3), i4 >> 2);
        }

        public Blob b() {
            if (!m() && !v()) {
                return Blob.d();
            }
            ReadBuf readBuf = this.f7740a;
            return new Blob(readBuf, FlexBuffers.i(readBuf, this.f7741b, this.f7742c), this.f7743d);
        }

        public boolean c() {
            return n() ? this.f7740a.get(this.f7741b) != 0 : j() != 0;
        }

        public double d() {
            int i2 = this.f7744e;
            if (i2 == 3) {
                return FlexBuffers.m(this.f7740a, this.f7741b, this.f7742c);
            }
            if (i2 == 1) {
                return (double) FlexBuffers.n(this.f7740a, this.f7741b, this.f7742c);
            }
            if (i2 != 2) {
                if (i2 == 5) {
                    return Double.parseDouble(i());
                }
                if (i2 == 6) {
                    ReadBuf readBuf = this.f7740a;
                    return (double) FlexBuffers.n(readBuf, FlexBuffers.i(readBuf, this.f7741b, this.f7742c), this.f7743d);
                } else if (i2 == 7) {
                    ReadBuf readBuf2 = this.f7740a;
                    return (double) FlexBuffers.p(readBuf2, FlexBuffers.i(readBuf2, this.f7741b, this.f7742c), this.f7743d);
                } else if (i2 == 8) {
                    ReadBuf readBuf3 = this.f7740a;
                    return FlexBuffers.m(readBuf3, FlexBuffers.i(readBuf3, this.f7741b, this.f7742c), this.f7743d);
                } else if (i2 == 10) {
                    return (double) k().b();
                } else {
                    if (i2 != 26) {
                        return 0.0d;
                    }
                }
            }
            return (double) FlexBuffers.p(this.f7740a, this.f7741b, this.f7742c);
        }

        public int e() {
            ReadBuf readBuf;
            int i2;
            int i3 = this.f7744e;
            if (i3 == 1) {
                return FlexBuffers.n(this.f7740a, this.f7741b, this.f7742c);
            }
            if (i3 == 2) {
                readBuf = this.f7740a;
                i2 = this.f7741b;
            } else if (i3 == 3) {
                return (int) FlexBuffers.m(this.f7740a, this.f7741b, this.f7742c);
            } else {
                if (i3 == 5) {
                    return Integer.parseInt(i());
                }
                if (i3 == 6) {
                    ReadBuf readBuf2 = this.f7740a;
                    return FlexBuffers.n(readBuf2, FlexBuffers.i(readBuf2, this.f7741b, this.f7742c), this.f7743d);
                } else if (i3 == 7) {
                    readBuf = this.f7740a;
                    i2 = FlexBuffers.i(readBuf, this.f7741b, this.f7742c);
                } else if (i3 == 8) {
                    ReadBuf readBuf3 = this.f7740a;
                    return (int) FlexBuffers.m(readBuf3, FlexBuffers.i(readBuf3, this.f7741b, this.f7742c), this.f7743d);
                } else if (i3 == 10) {
                    return k().b();
                } else {
                    if (i3 != 26) {
                        return 0;
                    }
                    return FlexBuffers.n(this.f7740a, this.f7741b, this.f7742c);
                }
            }
            return (int) FlexBuffers.p(readBuf, i2, this.f7742c);
        }

        public Key f() {
            if (!r()) {
                return Key.d();
            }
            ReadBuf readBuf = this.f7740a;
            return new Key(readBuf, FlexBuffers.i(readBuf, this.f7741b, this.f7742c), this.f7743d);
        }

        public long g() {
            int i2 = this.f7744e;
            if (i2 == 1) {
                return FlexBuffers.o(this.f7740a, this.f7741b, this.f7742c);
            }
            if (i2 == 2) {
                return FlexBuffers.p(this.f7740a, this.f7741b, this.f7742c);
            }
            if (i2 == 3) {
                return (long) FlexBuffers.m(this.f7740a, this.f7741b, this.f7742c);
            }
            if (i2 == 5) {
                try {
                    return Long.parseLong(i());
                } catch (NumberFormatException unused) {
                    return 0;
                }
            } else if (i2 == 6) {
                ReadBuf readBuf = this.f7740a;
                return FlexBuffers.o(readBuf, FlexBuffers.i(readBuf, this.f7741b, this.f7742c), this.f7743d);
            } else if (i2 == 7) {
                ReadBuf readBuf2 = this.f7740a;
                return FlexBuffers.p(readBuf2, FlexBuffers.i(readBuf2, this.f7741b, this.f7742c), this.f7742c);
            } else if (i2 == 8) {
                ReadBuf readBuf3 = this.f7740a;
                return (long) FlexBuffers.m(readBuf3, FlexBuffers.i(readBuf3, this.f7741b, this.f7742c), this.f7743d);
            } else if (i2 == 10) {
                return (long) k().b();
            } else {
                if (i2 != 26) {
                    return 0;
                }
                return (long) FlexBuffers.n(this.f7740a, this.f7741b, this.f7742c);
            }
        }

        public Map h() {
            if (!s()) {
                return Map.g();
            }
            ReadBuf readBuf = this.f7740a;
            return new Map(readBuf, FlexBuffers.i(readBuf, this.f7741b, this.f7742c), this.f7743d);
        }

        public String i() {
            if (v()) {
                int c2 = FlexBuffers.i(this.f7740a, this.f7741b, this.f7742c);
                ReadBuf readBuf = this.f7740a;
                int i2 = this.f7743d;
                return this.f7740a.j(c2, (int) FlexBuffers.p(readBuf, c2 - i2, i2));
            } else if (!r()) {
                return "";
            } else {
                int c3 = FlexBuffers.i(this.f7740a, this.f7741b, this.f7743d);
                int i3 = c3;
                while (this.f7740a.get(i3) != 0) {
                    i3++;
                }
                return this.f7740a.j(c3, i3 - c3);
            }
        }

        public long j() {
            int i2 = this.f7744e;
            if (i2 == 2) {
                return FlexBuffers.p(this.f7740a, this.f7741b, this.f7742c);
            }
            if (i2 == 1) {
                return FlexBuffers.o(this.f7740a, this.f7741b, this.f7742c);
            }
            if (i2 == 3) {
                return (long) FlexBuffers.m(this.f7740a, this.f7741b, this.f7742c);
            }
            if (i2 == 10) {
                return (long) k().b();
            }
            if (i2 == 26) {
                return (long) FlexBuffers.n(this.f7740a, this.f7741b, this.f7742c);
            }
            if (i2 == 5) {
                return Long.parseLong(i());
            }
            if (i2 == 6) {
                ReadBuf readBuf = this.f7740a;
                return FlexBuffers.o(readBuf, FlexBuffers.i(readBuf, this.f7741b, this.f7742c), this.f7743d);
            } else if (i2 == 7) {
                ReadBuf readBuf2 = this.f7740a;
                return FlexBuffers.p(readBuf2, FlexBuffers.i(readBuf2, this.f7741b, this.f7742c), this.f7743d);
            } else if (i2 != 8) {
                return 0;
            } else {
                ReadBuf readBuf3 = this.f7740a;
                return (long) FlexBuffers.m(readBuf3, FlexBuffers.i(readBuf3, this.f7741b, this.f7742c), this.f7742c);
            }
        }

        public Vector k() {
            if (y()) {
                ReadBuf readBuf = this.f7740a;
                return new Vector(readBuf, FlexBuffers.i(readBuf, this.f7741b, this.f7742c), this.f7743d);
            }
            int i2 = this.f7744e;
            if (i2 == 15) {
                ReadBuf readBuf2 = this.f7740a;
                return new TypedVector(readBuf2, FlexBuffers.i(readBuf2, this.f7741b, this.f7742c), this.f7743d, 4);
            } else if (!FlexBuffers.k(i2)) {
                return Vector.c();
            } else {
                ReadBuf readBuf3 = this.f7740a;
                return new TypedVector(readBuf3, FlexBuffers.i(readBuf3, this.f7741b, this.f7742c), this.f7743d, FlexBuffers.r(this.f7744e));
            }
        }

        public int l() {
            return this.f7744e;
        }

        public boolean m() {
            return this.f7744e == 25;
        }

        public boolean n() {
            return this.f7744e == 26;
        }

        public boolean o() {
            int i2 = this.f7744e;
            return i2 == 3 || i2 == 8;
        }

        public boolean p() {
            int i2 = this.f7744e;
            return i2 == 1 || i2 == 6;
        }

        public boolean q() {
            return p() || x();
        }

        public boolean r() {
            return this.f7744e == 4;
        }

        public boolean s() {
            return this.f7744e == 9;
        }

        public boolean t() {
            return this.f7744e == 0;
        }

        public String toString() {
            return z(new StringBuilder(128)).toString();
        }

        public boolean u() {
            return q() || o();
        }

        public boolean v() {
            return this.f7744e == 5;
        }

        public boolean w() {
            return FlexBuffers.k(this.f7744e);
        }

        public boolean x() {
            int i2 = this.f7744e;
            return i2 == 2 || i2 == 7;
        }

        public boolean y() {
            int i2 = this.f7744e;
            return i2 == 10 || i2 == 9;
        }

        /* access modifiers changed from: package-private */
        public StringBuilder z(StringBuilder sb) {
            int i2 = this.f7744e;
            if (i2 != 36) {
                switch (i2) {
                    case 0:
                        sb.append("null");
                        return sb;
                    case 1:
                    case 6:
                        sb.append(g());
                        return sb;
                    case 2:
                    case 7:
                        sb.append(j());
                        return sb;
                    case 3:
                    case 8:
                        sb.append(d());
                        return sb;
                    case 4:
                        Key f2 = f();
                        sb.append('\"');
                        StringBuilder a2 = f2.a(sb);
                        a2.append('\"');
                        return a2;
                    case 5:
                        sb.append('\"');
                        sb.append(i());
                        sb.append('\"');
                        return sb;
                    case 9:
                        return h().a(sb);
                    case 10:
                        return k().a(sb);
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        break;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        throw new FlexBufferException("not_implemented:" + this.f7744e);
                    case 25:
                        return b().a(sb);
                    case 26:
                        sb.append(c());
                        return sb;
                    default:
                        return sb;
                }
            }
            sb.append(k());
            return sb;
        }

        Reference(ReadBuf readBuf, int i2, int i3, int i4, int i5) {
            this.f7740a = readBuf;
            this.f7741b = i2;
            this.f7742c = i3;
            this.f7743d = i4;
            this.f7744e = i5;
        }
    }

    private static abstract class Sized extends Object {

        /* renamed from: d  reason: collision with root package name */
        protected final int f7745d;

        Sized(ReadBuf readBuf, int i2, int i3) {
            super(readBuf, i2, i3);
            this.f7745d = FlexBuffers.n(this.f7736a, i2 - i3, i3);
        }

        public int b() {
            return this.f7745d;
        }
    }

    public static class TypedVector extends Vector {

        /* renamed from: g  reason: collision with root package name */
        private static final TypedVector f7746g = new TypedVector(FlexBuffers.C, 1, 1, 1);

        /* renamed from: f  reason: collision with root package name */
        private final int f7747f;

        TypedVector(ReadBuf readBuf, int i2, int i3, int i4) {
            super(readBuf, i2, i3);
            this.f7747f = i4;
        }

        public static TypedVector f() {
            return f7746g;
        }

        public Reference d(int i2) {
            if (i2 >= b()) {
                return Reference.f7739f;
            }
            return new Reference(this.f7736a, this.f7737b + (i2 * this.f7738c), this.f7738c, 1, this.f7747f);
        }

        public int g() {
            return this.f7747f;
        }

        public boolean h() {
            return this == f7746g;
        }
    }

    static class Unsigned {
        Unsigned() {
        }

        static int a(byte b2) {
            return b2 & 255;
        }

        static long b(int i2) {
            return ((long) i2) & InternalZipConstants.f30717k;
        }

        static int c(short s) {
            return s & UShort.Z;
        }
    }

    public static class Vector extends Sized {

        /* renamed from: e  reason: collision with root package name */
        private static final Vector f7748e = new Vector(FlexBuffers.C, 1, 1);

        Vector(ReadBuf readBuf, int i2, int i3) {
            super(readBuf, i2, i3);
        }

        public static Vector c() {
            return f7748e;
        }

        public StringBuilder a(StringBuilder sb) {
            sb.append("[ ");
            int b2 = b();
            for (int i2 = 0; i2 < b2; i2++) {
                d(i2).z(sb);
                if (i2 != b2 - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" ]");
            return sb;
        }

        public /* bridge */ /* synthetic */ int b() {
            return super.b();
        }

        public Reference d(int i2) {
            long b2 = (long) b();
            long j2 = (long) i2;
            if (j2 >= b2) {
                return Reference.f7739f;
            }
            int a2 = Unsigned.a(this.f7736a.get((int) (((long) this.f7737b) + (b2 * ((long) this.f7738c)) + j2)));
            return new Reference(this.f7736a, this.f7737b + (i2 * this.f7738c), this.f7738c, a2);
        }

        public boolean e() {
            return this == f7748e;
        }

        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    public static Reference g(ReadBuf readBuf) {
        int g2 = readBuf.g();
        byte b2 = readBuf.get(g2 - 1);
        int i2 = g2 - 2;
        return new Reference(readBuf, i2 - b2, b2, Unsigned.a(readBuf.get(i2)));
    }

    @Deprecated
    public static Reference h(ByteBuffer byteBuffer) {
        return g(byteBuffer.hasArray() ? new ArrayReadWriteBuf(byteBuffer.array(), byteBuffer.limit()) : new ByteBufferReadWriteBuf(byteBuffer));
    }

    /* access modifiers changed from: private */
    public static int i(ReadBuf readBuf, int i2, int i3) {
        return (int) (((long) i2) - p(readBuf, i2, i3));
    }

    static boolean j(int i2) {
        return i2 <= 3 || i2 == 26;
    }

    static boolean k(int i2) {
        return (i2 >= 11 && i2 <= 15) || i2 == 36;
    }

    static boolean l(int i2) {
        return (i2 >= 1 && i2 <= 4) || i2 == 26;
    }

    /* access modifiers changed from: private */
    public static double m(ReadBuf readBuf, int i2, int i3) {
        if (i3 == 4) {
            return (double) readBuf.getFloat(i2);
        }
        if (i3 != 8) {
            return -1.0d;
        }
        return readBuf.getDouble(i2);
    }

    /* access modifiers changed from: private */
    public static int n(ReadBuf readBuf, int i2, int i3) {
        return (int) o(readBuf, i2, i3);
    }

    /* access modifiers changed from: private */
    public static long o(ReadBuf readBuf, int i2, int i3) {
        int i4;
        if (i3 == 1) {
            i4 = readBuf.get(i2);
        } else if (i3 == 2) {
            i4 = readBuf.getShort(i2);
        } else if (i3 == 4) {
            i4 = readBuf.getInt(i2);
        } else if (i3 != 8) {
            return -1;
        } else {
            return readBuf.getLong(i2);
        }
        return (long) i4;
    }

    /* access modifiers changed from: private */
    public static long p(ReadBuf readBuf, int i2, int i3) {
        if (i3 == 1) {
            return (long) Unsigned.a(readBuf.get(i2));
        }
        if (i3 == 2) {
            return (long) Unsigned.c(readBuf.getShort(i2));
        }
        if (i3 == 4) {
            return Unsigned.b(readBuf.getInt(i2));
        }
        if (i3 != 8) {
            return -1;
        }
        return readBuf.getLong(i2);
    }

    static int q(int i2, int i3) {
        if (i3 == 0) {
            return i2 + 10;
        }
        if (i3 == 2) {
            return i2 + 15;
        }
        if (i3 == 3) {
            return i2 + 18;
        }
        if (i3 != 4) {
            return 0;
        }
        return i2 + 21;
    }

    static int r(int i2) {
        return i2 - 10;
    }
}
