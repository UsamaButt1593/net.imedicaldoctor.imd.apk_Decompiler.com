package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;

public final class Internal {

    /* renamed from: a  reason: collision with root package name */
    static final Charset f7166a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    static final Charset f7167b = Charset.forName("ISO-8859-1");

    /* renamed from: c  reason: collision with root package name */
    private static final int f7168c = 4096;

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f7169d;

    /* renamed from: e  reason: collision with root package name */
    public static final ByteBuffer f7170e;

    /* renamed from: f  reason: collision with root package name */
    public static final CodedInputStream f7171f;

    public interface BooleanList extends ProtobufList<Boolean> {
        boolean A(int i2, boolean z);

        void c1(boolean z);

        BooleanList f(int i2);

        boolean v(int i2);
    }

    public interface DoubleList extends ProtobufList<Double> {
        DoubleList f(int i2);

        double getDouble(int i2);

        void k1(double d2);

        double p(int i2, double d2);
    }

    public interface EnumLite {
        int d();
    }

    public interface EnumLiteMap<T extends EnumLite> {
        T a(int i2);
    }

    public interface EnumVerifier {
        boolean a(int i2);
    }

    public interface FloatList extends ProtobufList<Float> {
        void J(float f2);

        FloatList f(int i2);

        float getFloat(int i2);

        float w(int i2, float f2);
    }

    public interface IntList extends ProtobufList<Integer> {
        IntList f(int i2);

        int getInt(int i2);

        void h0(int i2);

        int s(int i2, int i3);
    }

    public static class ListAdapter<F, T> extends AbstractList<T> {
        private final Converter<F, T> X;
        private final List<F> s;

        public interface Converter<F, T> {
            T a(F f2);
        }

        public ListAdapter(List<F> list, Converter<F, T> converter) {
            this.s = list;
            this.X = converter;
        }

        public T get(int i2) {
            return this.X.a(this.s.get(i2));
        }

        public int size() {
            return this.s.size();
        }
    }

    public interface LongList extends ProtobufList<Long> {
        void S0(long j2);

        LongList f(int i2);

        long getLong(int i2);

        long y(int i2, long j2);
    }

    public static class MapAdapter<K, V, RealValue> extends AbstractMap<K, V> {
        /* access modifiers changed from: private */
        public final Converter<RealValue, V> X;
        private final Map<K, RealValue> s;

        public interface Converter<A, B> {
            B a(A a2);

            A b(B b2);
        }

        private class EntryAdapter implements Map.Entry<K, V> {
            private final Map.Entry<K, RealValue> s;

            public EntryAdapter(Map.Entry<K, RealValue> entry) {
                this.s = entry;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                return (obj instanceof Map.Entry) && getKey().equals(((Map.Entry) obj).getKey()) && getValue().equals(getValue());
            }

            public K getKey() {
                return this.s.getKey();
            }

            public V getValue() {
                return MapAdapter.this.X.a(this.s.getValue());
            }

            public int hashCode() {
                return this.s.hashCode();
            }

            public V setValue(V v) {
                RealValue value = this.s.setValue(MapAdapter.this.X.b(v));
                if (value == null) {
                    return null;
                }
                return MapAdapter.this.X.a(value);
            }
        }

        private class IteratorAdapter implements Iterator<Map.Entry<K, V>> {
            private final Iterator<Map.Entry<K, RealValue>> s;

            public IteratorAdapter(Iterator<Map.Entry<K, RealValue>> it2) {
                this.s = it2;
            }

            /* renamed from: a */
            public Map.Entry<K, V> next() {
                return new EntryAdapter(this.s.next());
            }

            public boolean hasNext() {
                return this.s.hasNext();
            }

            public void remove() {
                this.s.remove();
            }
        }

        private class SetAdapter extends AbstractSet<Map.Entry<K, V>> {
            private final Set<Map.Entry<K, RealValue>> s;

            public SetAdapter(Set<Map.Entry<K, RealValue>> set) {
                this.s = set;
            }

            public Iterator<Map.Entry<K, V>> iterator() {
                return new IteratorAdapter(this.s.iterator());
            }

            public int size() {
                return this.s.size();
            }
        }

        public MapAdapter(Map<K, RealValue> map, Converter<RealValue, V> converter) {
            this.s = map;
            this.X = converter;
        }

        public static <T extends EnumLite> Converter<Integer, T> b(final EnumLiteMap<T> enumLiteMap, final T t) {
            return new Converter<Integer, T>() {
                /* renamed from: c */
                public Integer b(T t) {
                    return Integer.valueOf(t.d());
                }

                /* renamed from: d */
                public T a(Integer num) {
                    T a2 = enumLiteMap.a(num.intValue());
                    return a2 == null ? t : a2;
                }
            };
        }

        public Set<Map.Entry<K, V>> entrySet() {
            return new SetAdapter(this.s.entrySet());
        }

        public V get(Object obj) {
            RealValue realvalue = this.s.get(obj);
            if (realvalue == null) {
                return null;
            }
            return this.X.a(realvalue);
        }

        public V put(K k2, V v) {
            RealValue put = this.s.put(k2, this.X.b(v));
            if (put == null) {
                return null;
            }
            return this.X.a(put);
        }
    }

    public interface ProtobufList<E> extends List<E>, RandomAccess {
        boolean P2();

        void S();

        ProtobufList<E> f(int i2);
    }

    static {
        byte[] bArr = new byte[0];
        f7169d = bArr;
        f7170e = ByteBuffer.wrap(bArr);
        f7171f = CodedInputStream.p(bArr);
    }

    private Internal() {
    }

    public static byte[] a(String str) {
        return str.getBytes(f7167b);
    }

    public static ByteBuffer b(String str) {
        return ByteBuffer.wrap(a(str));
    }

    public static ByteString c(String str) {
        return ByteString.x(str.getBytes(f7167b));
    }

    static <T> T d(T t) {
        t.getClass();
        return t;
    }

    static <T> T e(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static ByteBuffer f(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.clear();
        ByteBuffer allocate = ByteBuffer.allocate(duplicate.capacity());
        allocate.put(duplicate);
        allocate.clear();
        return allocate;
    }

    public static boolean g(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!Arrays.equals(list.get(i2), list2.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean h(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (byteBuffer.capacity() != byteBuffer2.capacity()) {
            return false;
        }
        return byteBuffer.duplicate().clear().equals(byteBuffer2.duplicate().clear());
    }

    public static boolean i(List<ByteBuffer> list, List<ByteBuffer> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!h(list.get(i2), list2.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public static <T extends MessageLite> T j(Class<T> cls) {
        try {
            Method method = cls.getMethod("getDefaultInstance", (Class[]) null);
            return (MessageLite) method.invoke(method, (Object[]) null);
        } catch (Exception e2) {
            throw new RuntimeException("Failed to get default instance for " + cls, e2);
        }
    }

    public static int k(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int l(List<byte[]> list) {
        int i2 = 1;
        for (byte[] m2 : list) {
            i2 = (i2 * 31) + m(m2);
        }
        return i2;
    }

    public static int m(byte[] bArr) {
        return n(bArr, 0, bArr.length);
    }

    static int n(byte[] bArr, int i2, int i3) {
        int w = w(i3, bArr, i2, i3);
        if (w == 0) {
            return 1;
        }
        return w;
    }

    public static int o(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            int w = w(byteBuffer.capacity(), byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
            if (w == 0) {
                return 1;
            }
            return w;
        }
        int i2 = 4096;
        if (byteBuffer.capacity() <= 4096) {
            i2 = byteBuffer.capacity();
        }
        byte[] bArr = new byte[i2];
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.clear();
        int capacity = byteBuffer.capacity();
        while (duplicate.remaining() > 0) {
            int remaining = duplicate.remaining() <= i2 ? duplicate.remaining() : i2;
            duplicate.get(bArr, 0, remaining);
            capacity = w(capacity, bArr, 0, remaining);
        }
        if (capacity == 0) {
            return 1;
        }
        return capacity;
    }

    public static int p(List<ByteBuffer> list) {
        int i2 = 1;
        for (ByteBuffer o : list) {
            i2 = (i2 * 31) + o(o);
        }
        return i2;
    }

    public static int q(EnumLite enumLite) {
        return enumLite.d();
    }

    public static int r(List<? extends EnumLite> list) {
        int i2 = 1;
        for (EnumLite q : list) {
            i2 = (i2 * 31) + q(q);
        }
        return i2;
    }

    public static int s(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    public static boolean t(ByteString byteString) {
        return byteString.N();
    }

    public static boolean u(byte[] bArr) {
        return Utf8.t(bArr);
    }

    static Object v(Object obj, Object obj2) {
        return ((MessageLite) obj).E().P((MessageLite) obj2).M1();
    }

    static int w(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            i2 = (i2 * 31) + bArr[i5];
        }
        return i2;
    }

    public static String x(String str) {
        return new String(str.getBytes(f7167b), f7166a);
    }

    public static byte[] y(String str) {
        return str.getBytes(f7166a);
    }

    public static String z(byte[] bArr) {
        return new String(bArr, f7166a);
    }
}
