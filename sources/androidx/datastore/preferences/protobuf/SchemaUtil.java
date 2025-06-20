package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.FieldSet;
import androidx.datastore.preferences.protobuf.Internal;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class SchemaUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f7242a = D();

    /* renamed from: b  reason: collision with root package name */
    private static final UnknownFieldSchema<?, ?> f7243b = F(false);

    /* renamed from: c  reason: collision with root package name */
    private static final UnknownFieldSchema<?, ?> f7244c = F(true);

    /* renamed from: d  reason: collision with root package name */
    private static final UnknownFieldSchema<?, ?> f7245d = new UnknownFieldSetLiteSchema();

    /* renamed from: e  reason: collision with root package name */
    private static final int f7246e = 40;

    private SchemaUtil() {
    }

    static int A(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.b1(longArrayList.getLong(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + CodedOutputStream.b1(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    private static void A0(int i2, String str, Writer writer) throws IOException {
        if (str != null && !str.isEmpty()) {
            writer.o(i2, str);
        }
    }

    static <UT, UB> UB B(int i2, List<Integer> list, Internal.EnumLiteMap<?> enumLiteMap, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumLiteMap == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                Integer num = list.get(i4);
                int intValue = num.intValue();
                if (enumLiteMap.a(intValue) != null) {
                    if (i4 != i3) {
                        list.set(i3, num);
                    }
                    i3++;
                } else {
                    ub = Q(i2, intValue, ub, unknownFieldSchema);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
        } else {
            Iterator<Integer> it2 = list.iterator();
            while (it2.hasNext()) {
                int intValue2 = it2.next().intValue();
                if (enumLiteMap.a(intValue2) == null) {
                    ub = Q(i2, intValue2, ub, unknownFieldSchema);
                    it2.remove();
                }
            }
        }
        return ub;
    }

    public static void B0(int i2, List<String> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.l(i2, list);
        }
    }

    static <UT, UB> UB C(int i2, List<Integer> list, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumVerifier == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                Integer num = list.get(i4);
                int intValue = num.intValue();
                if (enumVerifier.a(intValue)) {
                    if (i4 != i3) {
                        list.set(i3, num);
                    }
                    i3++;
                } else {
                    ub = Q(i2, intValue, ub, unknownFieldSchema);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
        } else {
            Iterator<Integer> it2 = list.iterator();
            while (it2.hasNext()) {
                int intValue2 = it2.next().intValue();
                if (!enumVerifier.a(intValue2)) {
                    ub = Q(i2, intValue2, ub, unknownFieldSchema);
                    it2.remove();
                }
            }
        }
        return ub;
    }

    public static void C0(int i2, int i3, Writer writer) throws IOException {
        if (i3 != 0) {
            writer.b(i2, i3);
        }
    }

    private static Class<?> D() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void D0(int i2, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.F(i2, list, z);
        }
    }

    static Object E(Class<?> cls, String str) {
        try {
            Field[] declaredFields = Class.forName(cls.getName() + "$" + R(str, true) + "DefaultEntryHolder").getDeclaredFields();
            if (declaredFields.length == 1) {
                return UnsafeUtil.Q(declaredFields[0]);
            }
            throw new IllegalStateException("Unable to look up map field default entry holder class for " + str + " in " + cls.getName());
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public static void E0(int i2, long j2, Writer writer) throws IOException {
        if (j2 != 0) {
            writer.p(i2, j2);
        }
    }

    private static UnknownFieldSchema<?, ?> F(boolean z) {
        try {
            Class<?> G = G();
            if (G == null) {
                return null;
            }
            return (UnknownFieldSchema) G.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void F0(int i2, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.g(i2, list, z);
        }
    }

    private static Class<?> G() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static <T, FT extends FieldSet.FieldDescriptorLite<FT>> void H(ExtensionSchema<FT> extensionSchema, T t, T t2) {
        FieldSet<FT> c2 = extensionSchema.c(t2);
        if (!c2.C()) {
            extensionSchema.d(t).J(c2);
        }
    }

    static <T> void I(MapFieldSchema mapFieldSchema, T t, T t2, long j2) {
        UnsafeUtil.q0(t, j2, mapFieldSchema.a(UnsafeUtil.O(t, j2), UnsafeUtil.O(t2, j2)));
    }

    static <T, UT, UB> void J(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t, T t2) {
        unknownFieldSchema.p(t, unknownFieldSchema.k(unknownFieldSchema.g(t), unknownFieldSchema.g(t2)));
    }

    public static UnknownFieldSchema<?, ?> K() {
        return f7243b;
    }

    public static UnknownFieldSchema<?, ?> L() {
        return f7244c;
    }

    public static void M(Class<?> cls) {
        Class<?> cls2;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = f7242a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static boolean N(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean O(int i2, int i3, int i4) {
        if (i3 < 40) {
            return true;
        }
        long j2 = ((long) i3) - ((long) i2);
        long j3 = (long) i4;
        return j2 + 10 <= ((2 * j3) + 3) + ((j3 + 3) * 3);
    }

    public static boolean P(FieldInfo[] fieldInfoArr) {
        if (fieldInfoArr.length == 0) {
            return false;
        }
        return O(fieldInfoArr[0].p(), fieldInfoArr[fieldInfoArr.length - 1].p(), fieldInfoArr.length);
    }

    static <UT, UB> UB Q(int i2, int i3, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (ub == null) {
            ub = unknownFieldSchema.n();
        }
        unknownFieldSchema.e(ub, i2, (long) i3);
        return ub;
    }

    static String R(String str, boolean z) {
        int i2;
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if ('a' <= charAt && charAt <= 'z') {
                if (z) {
                    i2 = charAt - ' ';
                }
                sb.append(charAt);
                z = false;
            } else if ('A' > charAt || charAt > 'Z') {
                if ('0' <= charAt && charAt <= '9') {
                    sb.append(charAt);
                }
                z = true;
            } else {
                if (i3 == 0 && !z) {
                    i2 = charAt + ' ';
                }
                sb.append(charAt);
                z = false;
            }
            sb.append((char) i2);
            z = false;
        }
        return sb.toString();
    }

    public static UnknownFieldSchema<?, ?> S() {
        return f7245d;
    }

    public static void T(int i2, boolean z, Writer writer) throws IOException {
        if (z) {
            writer.t(i2, true);
        }
    }

    public static void U(int i2, List<Boolean> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.D(i2, list, z);
        }
    }

    public static void V(int i2, ByteString byteString, Writer writer) throws IOException {
        if (byteString != null && !byteString.isEmpty()) {
            writer.z(i2, byteString);
        }
    }

    public static void W(int i2, List<ByteString> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.R(i2, list);
        }
    }

    public static void X(int i2, double d2, Writer writer) throws IOException {
        if (Double.compare(d2, 0.0d) != 0) {
            writer.e(i2, d2);
        }
    }

    public static void Y(int i2, List<Double> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.O(i2, list, z);
        }
    }

    public static void Z(int i2, int i3, Writer writer) throws IOException {
        if (i3 != 0) {
            writer.L(i2, i3);
        }
    }

    static int a(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z ? CodedOutputStream.X0(i2) + CodedOutputStream.D0(size) : size * CodedOutputStream.a0(i2, true);
    }

    public static void a0(int i2, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.N(i2, list, z);
        }
    }

    static int b(List<?> list) {
        return list.size();
    }

    public static void b0(int i2, int i3, Writer writer) throws IOException {
        if (i3 != 0) {
            writer.d(i2, i3);
        }
    }

    static int c(int i2, List<ByteString> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int X0 = size * CodedOutputStream.X0(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            X0 += CodedOutputStream.h0(list.get(i3));
        }
        return X0;
    }

    public static void c0(int i2, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.B(i2, list, z);
        }
    }

    static int d(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e2 = e(list);
        int X0 = CodedOutputStream.X0(i2);
        return z ? X0 + CodedOutputStream.D0(e2) : e2 + (size * X0);
    }

    public static void d0(int i2, long j2, Writer writer) throws IOException {
        if (j2 != 0) {
            writer.i(i2, j2);
        }
    }

    static int e(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.l0(intArrayList.getInt(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + CodedOutputStream.l0(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    public static void e0(int i2, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.x(i2, list, z);
        }
    }

    static int f(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z ? CodedOutputStream.X0(i2) + CodedOutputStream.D0(size * 4) : size * CodedOutputStream.m0(i2, 0);
    }

    public static void f0(int i2, float f2, Writer writer) throws IOException {
        if (Float.compare(f2, 0.0f) != 0) {
            writer.I(i2, f2);
        }
    }

    static int g(List<?> list) {
        return list.size() * 4;
    }

    public static void g0(int i2, List<Float> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.a(i2, list, z);
        }
    }

    static int h(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z ? CodedOutputStream.X0(i2) + CodedOutputStream.D0(size * 8) : size * CodedOutputStream.o0(i2, 0);
    }

    public static void h0(int i2, List<?> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.h(i2, list);
        }
    }

    static int i(List<?> list) {
        return list.size() * 8;
    }

    public static void i0(int i2, List<?> list, Writer writer, Schema schema) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.m(i2, list, schema);
        }
    }

    static int j(int i2, List<MessageLite> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += CodedOutputStream.s0(i2, list.get(i4));
        }
        return i3;
    }

    public static void j0(int i2, int i3, Writer writer) throws IOException {
        if (i3 != 0) {
            writer.w(i2, i3);
        }
    }

    static int k(int i2, List<MessageLite> list, Schema schema) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += CodedOutputStream.t0(i2, list.get(i4), schema);
        }
        return i3;
    }

    public static void k0(int i2, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.r(i2, list, z);
        }
    }

    static int l(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int m2 = m(list);
        int X0 = CodedOutputStream.X0(i2);
        return z ? X0 + CodedOutputStream.D0(m2) : m2 + (size * X0);
    }

    public static void l0(int i2, long j2, Writer writer) throws IOException {
        if (j2 != 0) {
            writer.s(i2, j2);
        }
    }

    static int m(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.x0(intArrayList.getInt(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + CodedOutputStream.x0(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    public static void m0(int i2, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.M(i2, list, z);
        }
    }

    static int n(int i2, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        int o = o(list);
        return z ? CodedOutputStream.X0(i2) + CodedOutputStream.D0(o) : o + (list.size() * CodedOutputStream.X0(i2));
    }

    public static void n0(int i2, List<?> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            Iterator<?> it2 = list.iterator();
            while (it2.hasNext()) {
                ((LazyFieldLite) it2.next()).o(writer, i2);
            }
        }
    }

    static int o(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.z0(longArrayList.getLong(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + CodedOutputStream.z0(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    public static void o0(int i2, Object obj, Writer writer) throws IOException {
        if (obj != null) {
            writer.q(i2, obj);
        }
    }

    static int p(int i2, Object obj, Schema schema) {
        return obj instanceof LazyFieldLite ? CodedOutputStream.B0(i2, (LazyFieldLite) obj) : CodedOutputStream.G0(i2, (MessageLite) obj, schema);
    }

    public static void p0(int i2, List<?> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.n(i2, list);
        }
    }

    static int q(int i2, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int X0 = CodedOutputStream.X0(i2) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            X0 += obj instanceof LazyFieldLite ? CodedOutputStream.C0((LazyFieldLite) obj) : CodedOutputStream.H0((MessageLite) obj);
        }
        return X0;
    }

    public static void q0(int i2, List<?> list, Writer writer, Schema schema) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.k(i2, list, schema);
        }
    }

    static int r(int i2, List<?> list, Schema schema) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int X0 = CodedOutputStream.X0(i2) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            X0 += obj instanceof LazyFieldLite ? CodedOutputStream.C0((LazyFieldLite) obj) : CodedOutputStream.I0((MessageLite) obj, schema);
        }
        return X0;
    }

    public static void r0(int i2, int i3, Writer writer) throws IOException {
        if (i3 != 0) {
            writer.u(i2, i3);
        }
    }

    static int s(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int t = t(list);
        int X0 = CodedOutputStream.X0(i2);
        return z ? X0 + CodedOutputStream.D0(t) : t + (size * X0);
    }

    public static void s0(int i2, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.y(i2, list, z);
        }
    }

    static int t(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.S0(intArrayList.getInt(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + CodedOutputStream.S0(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    public static void t0(int i2, long j2, Writer writer) throws IOException {
        if (j2 != 0) {
            writer.A(i2, j2);
        }
    }

    static int u(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int v = v(list);
        int X0 = CodedOutputStream.X0(i2);
        return z ? X0 + CodedOutputStream.D0(v) : v + (size * X0);
    }

    public static void u0(int i2, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.f(i2, list, z);
        }
    }

    static int v(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.U0(longArrayList.getLong(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + CodedOutputStream.U0(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    public static void v0(int i2, int i3, Writer writer) throws IOException {
        if (i3 != 0) {
            writer.Q(i2, i3);
        }
    }

    static int w(int i2, List<?> list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        int X0 = CodedOutputStream.X0(i2) * size;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i3 < size) {
                Object w2 = lazyStringList.w2(i3);
                X0 += w2 instanceof ByteString ? CodedOutputStream.h0((ByteString) w2) : CodedOutputStream.W0((String) w2);
                i3++;
            }
        } else {
            while (i3 < size) {
                Object obj = list.get(i3);
                X0 += obj instanceof ByteString ? CodedOutputStream.h0((ByteString) obj) : CodedOutputStream.W0((String) obj);
                i3++;
            }
        }
        return X0;
    }

    public static void w0(int i2, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.K(i2, list, z);
        }
    }

    static int x(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int y = y(list);
        int X0 = CodedOutputStream.X0(i2);
        return z ? X0 + CodedOutputStream.D0(y) : y + (size * X0);
    }

    public static void x0(int i2, long j2, Writer writer) throws IOException {
        if (j2 != 0) {
            writer.H(i2, j2);
        }
    }

    static int y(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.Z0(intArrayList.getInt(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + CodedOutputStream.Z0(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    public static void y0(int i2, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.G(i2, list, z);
        }
    }

    static int z(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int A = A(list);
        int X0 = CodedOutputStream.X0(i2);
        return z ? X0 + CodedOutputStream.D0(A) : A + (size * X0);
    }

    public static void z0(int i2, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            A0(i2, (String) obj, writer);
        } else {
            V(i2, (ByteString) obj, writer);
        }
    }
}
