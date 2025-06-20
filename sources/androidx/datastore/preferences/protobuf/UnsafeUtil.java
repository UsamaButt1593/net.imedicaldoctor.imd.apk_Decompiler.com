package androidx.datastore.preferences.protobuf;

import com.itextpdf.tool.xml.html.HTML;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class UnsafeUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f7278a = Logger.getLogger(UnsafeUtil.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private static final Unsafe f7279b = R();

    /* renamed from: c  reason: collision with root package name */
    private static final Class<?> f7280c = Android.b();

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f7281d = q(Long.TYPE);

    /* renamed from: e  reason: collision with root package name */
    private static final boolean f7282e = q(Integer.TYPE);

    /* renamed from: f  reason: collision with root package name */
    private static final MemoryAccessor f7283f = N();

    /* renamed from: g  reason: collision with root package name */
    private static final boolean f7284g = t0();

    /* renamed from: h  reason: collision with root package name */
    private static final boolean f7285h = s0();

    /* renamed from: i  reason: collision with root package name */
    static final long f7286i;

    /* renamed from: j  reason: collision with root package name */
    private static final long f7287j;

    /* renamed from: k  reason: collision with root package name */
    private static final long f7288k;

    /* renamed from: l  reason: collision with root package name */
    private static final long f7289l;

    /* renamed from: m  reason: collision with root package name */
    private static final long f7290m;

    /* renamed from: n  reason: collision with root package name */
    private static final long f7291n;
    private static final long o;
    private static final long p;
    private static final long q;
    private static final long r;
    private static final long s;
    private static final long t;
    private static final long u;
    private static final long v = s(m());
    private static final int w = 8;
    private static final int x = 7;
    private static final int y;
    static final boolean z = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    private static final class Android32MemoryAccessor extends MemoryAccessor {

        /* renamed from: b  reason: collision with root package name */
        private static final long f7292b = -1;

        Android32MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        private static int A(long j2) {
            return (int) j2;
        }

        public void c(long j2, byte[] bArr, long j3, long j4) {
            throw new UnsupportedOperationException();
        }

        public void d(byte[] bArr, long j2, long j3, long j4) {
            throw new UnsupportedOperationException();
        }

        public boolean e(Object obj, long j2) {
            return UnsafeUtil.z ? UnsafeUtil.w(obj, j2) : UnsafeUtil.x(obj, j2);
        }

        public byte f(long j2) {
            throw new UnsupportedOperationException();
        }

        public byte g(Object obj, long j2) {
            return UnsafeUtil.z ? UnsafeUtil.B(obj, j2) : UnsafeUtil.C(obj, j2);
        }

        public double h(Object obj, long j2) {
            return Double.longBitsToDouble(m(obj, j2));
        }

        public float i(Object obj, long j2) {
            return Float.intBitsToFloat(k(obj, j2));
        }

        public int j(long j2) {
            throw new UnsupportedOperationException();
        }

        public long l(long j2) {
            throw new UnsupportedOperationException();
        }

        public Object o(Field field) {
            try {
                return field.get((Object) null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        public void q(Object obj, long j2, boolean z) {
            if (UnsafeUtil.z) {
                UnsafeUtil.Z(obj, j2, z);
            } else {
                UnsafeUtil.a0(obj, j2, z);
            }
        }

        public void r(long j2, byte b2) {
            throw new UnsupportedOperationException();
        }

        public void s(Object obj, long j2, byte b2) {
            if (UnsafeUtil.z) {
                UnsafeUtil.e0(obj, j2, b2);
            } else {
                UnsafeUtil.f0(obj, j2, b2);
            }
        }

        public void t(Object obj, long j2, double d2) {
            y(obj, j2, Double.doubleToLongBits(d2));
        }

        public void u(Object obj, long j2, float f2) {
            w(obj, j2, Float.floatToIntBits(f2));
        }

        public void v(long j2, int i2) {
            throw new UnsupportedOperationException();
        }

        public void x(long j2, long j3) {
            throw new UnsupportedOperationException();
        }
    }

    private static final class Android64MemoryAccessor extends MemoryAccessor {
        Android64MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        public void c(long j2, byte[] bArr, long j3, long j4) {
            throw new UnsupportedOperationException();
        }

        public void d(byte[] bArr, long j2, long j3, long j4) {
            throw new UnsupportedOperationException();
        }

        public boolean e(Object obj, long j2) {
            return UnsafeUtil.z ? UnsafeUtil.w(obj, j2) : UnsafeUtil.x(obj, j2);
        }

        public byte f(long j2) {
            throw new UnsupportedOperationException();
        }

        public byte g(Object obj, long j2) {
            return UnsafeUtil.z ? UnsafeUtil.B(obj, j2) : UnsafeUtil.C(obj, j2);
        }

        public double h(Object obj, long j2) {
            return Double.longBitsToDouble(m(obj, j2));
        }

        public float i(Object obj, long j2) {
            return Float.intBitsToFloat(k(obj, j2));
        }

        public int j(long j2) {
            throw new UnsupportedOperationException();
        }

        public long l(long j2) {
            throw new UnsupportedOperationException();
        }

        public Object o(Field field) {
            try {
                return field.get((Object) null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        public void q(Object obj, long j2, boolean z) {
            if (UnsafeUtil.z) {
                UnsafeUtil.Z(obj, j2, z);
            } else {
                UnsafeUtil.a0(obj, j2, z);
            }
        }

        public void r(long j2, byte b2) {
            throw new UnsupportedOperationException();
        }

        public void s(Object obj, long j2, byte b2) {
            if (UnsafeUtil.z) {
                UnsafeUtil.e0(obj, j2, b2);
            } else {
                UnsafeUtil.f0(obj, j2, b2);
            }
        }

        public void t(Object obj, long j2, double d2) {
            y(obj, j2, Double.doubleToLongBits(d2));
        }

        public void u(Object obj, long j2, float f2) {
            w(obj, j2, Float.floatToIntBits(f2));
        }

        public void v(long j2, int i2) {
            throw new UnsupportedOperationException();
        }

        public void x(long j2, long j3) {
            throw new UnsupportedOperationException();
        }
    }

    private static final class JvmMemoryAccessor extends MemoryAccessor {
        JvmMemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        public void c(long j2, byte[] bArr, long j3, long j4) {
            this.f7293a.copyMemory((Object) null, j2, bArr, UnsafeUtil.f7286i + j3, j4);
        }

        public void d(byte[] bArr, long j2, long j3, long j4) {
            this.f7293a.copyMemory(bArr, UnsafeUtil.f7286i + j2, (Object) null, j3, j4);
        }

        public boolean e(Object obj, long j2) {
            return this.f7293a.getBoolean(obj, j2);
        }

        public byte f(long j2) {
            return this.f7293a.getByte(j2);
        }

        public byte g(Object obj, long j2) {
            return this.f7293a.getByte(obj, j2);
        }

        public double h(Object obj, long j2) {
            return this.f7293a.getDouble(obj, j2);
        }

        public float i(Object obj, long j2) {
            return this.f7293a.getFloat(obj, j2);
        }

        public int j(long j2) {
            return this.f7293a.getInt(j2);
        }

        public long l(long j2) {
            return this.f7293a.getLong(j2);
        }

        public Object o(Field field) {
            return n(this.f7293a.staticFieldBase(field), this.f7293a.staticFieldOffset(field));
        }

        public void q(Object obj, long j2, boolean z) {
            this.f7293a.putBoolean(obj, j2, z);
        }

        public void r(long j2, byte b2) {
            this.f7293a.putByte(j2, b2);
        }

        public void s(Object obj, long j2, byte b2) {
            this.f7293a.putByte(obj, j2, b2);
        }

        public void t(Object obj, long j2, double d2) {
            this.f7293a.putDouble(obj, j2, d2);
        }

        public void u(Object obj, long j2, float f2) {
            this.f7293a.putFloat(obj, j2, f2);
        }

        public void v(long j2, int i2) {
            this.f7293a.putInt(j2, i2);
        }

        public void x(long j2, long j3) {
            this.f7293a.putLong(j2, j3);
        }
    }

    private static abstract class MemoryAccessor {

        /* renamed from: a  reason: collision with root package name */
        Unsafe f7293a;

        MemoryAccessor(Unsafe unsafe) {
            this.f7293a = unsafe;
        }

        public final int a(Class<?> cls) {
            return this.f7293a.arrayBaseOffset(cls);
        }

        public final int b(Class<?> cls) {
            return this.f7293a.arrayIndexScale(cls);
        }

        public abstract void c(long j2, byte[] bArr, long j3, long j4);

        public abstract void d(byte[] bArr, long j2, long j3, long j4);

        public abstract boolean e(Object obj, long j2);

        public abstract byte f(long j2);

        public abstract byte g(Object obj, long j2);

        public abstract double h(Object obj, long j2);

        public abstract float i(Object obj, long j2);

        public abstract int j(long j2);

        public final int k(Object obj, long j2) {
            return this.f7293a.getInt(obj, j2);
        }

        public abstract long l(long j2);

        public final long m(Object obj, long j2) {
            return this.f7293a.getLong(obj, j2);
        }

        public final Object n(Object obj, long j2) {
            return this.f7293a.getObject(obj, j2);
        }

        public abstract Object o(Field field);

        public final long p(Field field) {
            return this.f7293a.objectFieldOffset(field);
        }

        public abstract void q(Object obj, long j2, boolean z);

        public abstract void r(long j2, byte b2);

        public abstract void s(Object obj, long j2, byte b2);

        public abstract void t(Object obj, long j2, double d2);

        public abstract void u(Object obj, long j2, float f2);

        public abstract void v(long j2, int i2);

        public final void w(Object obj, long j2, int i2) {
            this.f7293a.putInt(obj, j2, i2);
        }

        public abstract void x(long j2, long j3);

        public final void y(Object obj, long j2, long j3) {
            this.f7293a.putLong(obj, j2, j3);
        }

        public final void z(Object obj, long j2, Object obj2) {
            this.f7293a.putObject(obj, j2, obj2);
        }
    }

    static {
        long k2 = (long) k(byte[].class);
        f7286i = k2;
        Class<boolean[]> cls = boolean[].class;
        f7287j = (long) k(cls);
        f7288k = (long) l(cls);
        Class<int[]> cls2 = int[].class;
        f7289l = (long) k(cls2);
        f7290m = (long) l(cls2);
        Class<long[]> cls3 = long[].class;
        f7291n = (long) k(cls3);
        o = (long) l(cls3);
        Class<float[]> cls4 = float[].class;
        p = (long) k(cls4);
        q = (long) l(cls4);
        Class<double[]> cls5 = double[].class;
        r = (long) k(cls5);
        s = (long) l(cls5);
        Class<Object[]> cls6 = Object[].class;
        t = (long) k(cls6);
        u = (long) l(cls6);
        y = (int) (k2 & 7);
    }

    private UnsafeUtil() {
    }

    static byte A(byte[] bArr, long j2) {
        return f7283f.g(bArr, f7286i + j2);
    }

    /* access modifiers changed from: private */
    public static byte B(Object obj, long j2) {
        return (byte) ((I(obj, -4 & j2) >>> ((int) (((~j2) & 3) << 3))) & 255);
    }

    /* access modifiers changed from: private */
    public static byte C(Object obj, long j2) {
        return (byte) ((I(obj, -4 & j2) >>> ((int) ((j2 & 3) << 3))) & 255);
    }

    static double D(Object obj, long j2) {
        return f7283f.h(obj, j2);
    }

    static double E(double[] dArr, long j2) {
        return f7283f.h(dArr, r + (j2 * s));
    }

    static float F(Object obj, long j2) {
        return f7283f.i(obj, j2);
    }

    static float G(float[] fArr, long j2) {
        return f7283f.i(fArr, p + (j2 * q));
    }

    static int H(long j2) {
        return f7283f.j(j2);
    }

    static int I(Object obj, long j2) {
        return f7283f.k(obj, j2);
    }

    static int J(int[] iArr, long j2) {
        return f7283f.k(iArr, f7289l + (j2 * f7290m));
    }

    static long K(long j2) {
        return f7283f.l(j2);
    }

    static long L(Object obj, long j2) {
        return f7283f.m(obj, j2);
    }

    static long M(long[] jArr, long j2) {
        return f7283f.m(jArr, f7291n + (j2 * o));
    }

    private static MemoryAccessor N() {
        Unsafe unsafe = f7279b;
        if (unsafe == null) {
            return null;
        }
        if (!Android.c()) {
            return new JvmMemoryAccessor(unsafe);
        }
        if (f7281d) {
            return new Android64MemoryAccessor(unsafe);
        }
        if (f7282e) {
            return new Android32MemoryAccessor(unsafe);
        }
        return null;
    }

    static Object O(Object obj, long j2) {
        return f7283f.n(obj, j2);
    }

    static Object P(Object[] objArr, long j2) {
        return f7283f.n(objArr, t + (j2 * u));
    }

    static Object Q(Field field) {
        return f7283f.o(field);
    }

    static Unsafe R() {
        try {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() {
                /* renamed from: a */
                public Unsafe run() throws Exception {
                    Class<Unsafe> cls = Unsafe.class;
                    for (Field field : cls.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get((Object) null);
                        if (cls.isInstance(obj)) {
                            return cls.cast(obj);
                        }
                    }
                    return null;
                }
            });
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean S() {
        return f7285h;
    }

    static boolean T() {
        return f7284g;
    }

    static boolean U() {
        return f7281d;
    }

    static int V(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        if (i2 < 0 || i3 < 0 || i4 < 0 || i2 + i4 > bArr.length || i3 + i4 > bArr2.length) {
            throw new IndexOutOfBoundsException();
        }
        int i5 = 0;
        if (f7285h) {
            int i6 = (y + i2) & 7;
            while (i5 < i4 && (i6 & 7) != 0) {
                if (bArr[i2 + i5] != bArr2[i3 + i5]) {
                    return i5;
                }
                i5++;
                i6++;
            }
            int i7 = ((i4 - i5) & -8) + i5;
            while (i5 < i7) {
                long j2 = f7286i;
                long j3 = (long) i5;
                long L = L(bArr, ((long) i2) + j2 + j3);
                long L2 = L(bArr2, j2 + ((long) i3) + j3);
                if (L != L2) {
                    return i5 + t(L, L2);
                }
                i5 += 8;
            }
        }
        while (i5 < i4) {
            if (bArr[i2 + i5] != bArr2[i3 + i5]) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    static long W(Field field) {
        return f7283f.p(field);
    }

    static void X(Object obj, long j2, boolean z2) {
        f7283f.q(obj, j2, z2);
    }

    static void Y(boolean[] zArr, long j2, boolean z2) {
        f7283f.q(zArr, f7287j + (j2 * f7288k), z2);
    }

    /* access modifiers changed from: private */
    public static void Z(Object obj, long j2, boolean z2) {
        e0(obj, j2, z2 ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    public static void a0(Object obj, long j2, boolean z2) {
        f0(obj, j2, z2 ? (byte) 1 : 0);
    }

    static void b0(long j2, byte b2) {
        f7283f.r(j2, b2);
    }

    static void c0(Object obj, long j2, byte b2) {
        f7283f.s(obj, j2, b2);
    }

    static void d0(byte[] bArr, long j2, byte b2) {
        f7283f.s(bArr, f7286i + j2, b2);
    }

    /* access modifiers changed from: private */
    public static void e0(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int I = I(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        l0(obj, j3, ((255 & b2) << i2) | (I & (~(255 << i2))));
    }

    /* access modifiers changed from: private */
    public static void f0(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int i2 = (((int) j2) & 3) << 3;
        l0(obj, j3, ((255 & b2) << i2) | (I(obj, j3) & (~(255 << i2))));
    }

    static void g0(Object obj, long j2, double d2) {
        f7283f.t(obj, j2, d2);
    }

    static void h0(double[] dArr, long j2, double d2) {
        f7283f.t(dArr, r + (j2 * s), d2);
    }

    static long i(ByteBuffer byteBuffer) {
        return f7283f.m(byteBuffer, v);
    }

    static void i0(Object obj, long j2, float f2) {
        f7283f.u(obj, j2, f2);
    }

    static <T> T j(Class<T> cls) {
        try {
            return f7279b.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    static void j0(float[] fArr, long j2, float f2) {
        f7283f.u(fArr, p + (j2 * q), f2);
    }

    private static int k(Class<?> cls) {
        if (f7285h) {
            return f7283f.a(cls);
        }
        return -1;
    }

    static void k0(long j2, int i2) {
        f7283f.v(j2, i2);
    }

    private static int l(Class<?> cls) {
        if (f7285h) {
            return f7283f.b(cls);
        }
        return -1;
    }

    static void l0(Object obj, long j2, int i2) {
        f7283f.w(obj, j2, i2);
    }

    private static Field m() {
        Field r2;
        Class<Buffer> cls = Buffer.class;
        if (Android.c() && (r2 = r(cls, "effectiveDirectAddress")) != null) {
            return r2;
        }
        Field r3 = r(cls, HTML.Tag.F);
        if (r3 == null || r3.getType() != Long.TYPE) {
            return null;
        }
        return r3;
    }

    static void m0(int[] iArr, long j2, int i2) {
        f7283f.w(iArr, f7289l + (j2 * f7290m), i2);
    }

    static void n(long j2, byte[] bArr, long j3, long j4) {
        f7283f.c(j2, bArr, j3, j4);
    }

    static void n0(long j2, long j3) {
        f7283f.x(j2, j3);
    }

    static void o(byte[] bArr, long j2, long j3, long j4) {
        f7283f.d(bArr, j2, j3, j4);
    }

    static void o0(Object obj, long j2, long j3) {
        f7283f.y(obj, j2, j3);
    }

    static void p(byte[] bArr, long j2, byte[] bArr2, long j3, long j4) {
        System.arraycopy(bArr, (int) j2, bArr2, (int) j3, (int) j4);
    }

    static void p0(long[] jArr, long j2, long j3) {
        f7283f.y(jArr, f7291n + (j2 * o), j3);
    }

    private static boolean q(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!Android.c()) {
            return false;
        }
        try {
            Class<?> cls3 = f7280c;
            Class cls4 = Boolean.TYPE;
            cls3.getMethod("peekLong", new Class[]{cls, cls4});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, cls4});
            Class cls5 = Integer.TYPE;
            cls3.getMethod("pokeInt", new Class[]{cls, cls5, cls4});
            cls3.getMethod("peekInt", new Class[]{cls, cls4});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, cls5, cls5});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, cls5, cls5});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static void q0(Object obj, long j2, Object obj2) {
        f7283f.z(obj, j2, obj2);
    }

    private static Field r(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static void r0(Object[] objArr, long j2, Object obj) {
        f7283f.z(objArr, t + (j2 * u), obj);
    }

    private static long s(Field field) {
        MemoryAccessor memoryAccessor;
        if (field == null || (memoryAccessor = f7283f) == null) {
            return -1;
        }
        return memoryAccessor.p(field);
    }

    private static boolean s0() {
        Class<Class> cls = Class.class;
        Class<Object> cls2 = Object.class;
        Unsafe unsafe = f7279b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls3 = unsafe.getClass();
            cls3.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls3.getMethod("arrayBaseOffset", new Class[]{cls});
            cls3.getMethod("arrayIndexScale", new Class[]{cls});
            Class cls4 = Long.TYPE;
            cls3.getMethod("getInt", new Class[]{cls2, cls4});
            cls3.getMethod("putInt", new Class[]{cls2, cls4, Integer.TYPE});
            cls3.getMethod("getLong", new Class[]{cls2, cls4});
            cls3.getMethod("putLong", new Class[]{cls2, cls4, cls4});
            cls3.getMethod("getObject", new Class[]{cls2, cls4});
            cls3.getMethod("putObject", new Class[]{cls2, cls4, cls2});
            if (Android.c()) {
                return true;
            }
            cls3.getMethod("getByte", new Class[]{cls2, cls4});
            cls3.getMethod("putByte", new Class[]{cls2, cls4, Byte.TYPE});
            cls3.getMethod("getBoolean", new Class[]{cls2, cls4});
            cls3.getMethod("putBoolean", new Class[]{cls2, cls4, Boolean.TYPE});
            cls3.getMethod("getFloat", new Class[]{cls2, cls4});
            cls3.getMethod("putFloat", new Class[]{cls2, cls4, Float.TYPE});
            cls3.getMethod("getDouble", new Class[]{cls2, cls4});
            cls3.getMethod("putDouble", new Class[]{cls2, cls4, Double.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger = f7278a;
            Level level = Level.WARNING;
            logger.log(level, "platform method missing - proto runtime falling back to safer methods: " + th);
            return false;
        }
    }

    private static int t(long j2, long j3) {
        long j4 = j2 ^ j3;
        return (z ? Long.numberOfLeadingZeros(j4) : Long.numberOfTrailingZeros(j4)) >> 3;
    }

    private static boolean t0() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = f7279b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls2 = unsafe.getClass();
            cls2.getMethod("objectFieldOffset", new Class[]{Field.class});
            Class cls3 = Long.TYPE;
            cls2.getMethod("getLong", new Class[]{cls, cls3});
            if (m() == null) {
                return false;
            }
            if (Android.c()) {
                return true;
            }
            cls2.getMethod("getByte", new Class[]{cls3});
            cls2.getMethod("putByte", new Class[]{cls3, Byte.TYPE});
            cls2.getMethod("getInt", new Class[]{cls3});
            cls2.getMethod("putInt", new Class[]{cls3, Integer.TYPE});
            cls2.getMethod("getLong", new Class[]{cls3});
            cls2.getMethod("putLong", new Class[]{cls3, cls3});
            cls2.getMethod("copyMemory", new Class[]{cls3, cls3, cls3});
            cls2.getMethod("copyMemory", new Class[]{cls, cls3, cls, cls3, cls3});
            return true;
        } catch (Throwable th) {
            Logger logger = f7278a;
            Level level = Level.WARNING;
            logger.log(level, "platform method missing - proto runtime falling back to safer methods: " + th);
            return false;
        }
    }

    static boolean u(Object obj, long j2) {
        return f7283f.e(obj, j2);
    }

    static boolean v(boolean[] zArr, long j2) {
        return f7283f.e(zArr, f7287j + (j2 * f7288k));
    }

    /* access modifiers changed from: private */
    public static boolean w(Object obj, long j2) {
        return B(obj, j2) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean x(Object obj, long j2) {
        return C(obj, j2) != 0;
    }

    static byte y(long j2) {
        return f7283f.f(j2);
    }

    static byte z(Object obj, long j2) {
        return f7283f.g(obj, j2);
    }
}
