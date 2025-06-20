package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Preconditions;
import com.dd.plist.ASCIIPropertyListParser;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class LruArrayPool implements ArrayPool {

    /* renamed from: h  reason: collision with root package name */
    private static final int f17985h = 4194304;
    @VisibleForTesting

    /* renamed from: i  reason: collision with root package name */
    static final int f17986i = 8;

    /* renamed from: j  reason: collision with root package name */
    private static final int f17987j = 2;

    /* renamed from: b  reason: collision with root package name */
    private final GroupedLinkedMap<Key, Object> f17988b;

    /* renamed from: c  reason: collision with root package name */
    private final KeyPool f17989c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f17990d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<Class<?>, ArrayAdapterInterface<?>> f17991e;

    /* renamed from: f  reason: collision with root package name */
    private final int f17992f;

    /* renamed from: g  reason: collision with root package name */
    private int f17993g;

    private static final class Key implements Poolable {

        /* renamed from: a  reason: collision with root package name */
        private final KeyPool f17994a;

        /* renamed from: b  reason: collision with root package name */
        int f17995b;

        /* renamed from: c  reason: collision with root package name */
        private Class<?> f17996c;

        Key(KeyPool keyPool) {
            this.f17994a = keyPool;
        }

        public void a() {
            this.f17994a.c(this);
        }

        /* access modifiers changed from: package-private */
        public void b(int i2, Class<?> cls) {
            this.f17995b = i2;
            this.f17996c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return this.f17995b == key.f17995b && this.f17996c == key.f17996c;
        }

        public int hashCode() {
            int i2 = this.f17995b * 31;
            Class<?> cls = this.f17996c;
            return i2 + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.f17995b + "array=" + this.f17996c + ASCIIPropertyListParser.f18653k;
        }
    }

    private static final class KeyPool extends BaseKeyPool<Key> {
        KeyPool() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public Key a() {
            return new Key(this);
        }

        /* access modifiers changed from: package-private */
        public Key e(int i2, Class<?> cls) {
            Key key = (Key) b();
            key.b(i2, cls);
            return key;
        }
    }

    @VisibleForTesting
    public LruArrayPool() {
        this.f17988b = new GroupedLinkedMap<>();
        this.f17989c = new KeyPool();
        this.f17990d = new HashMap();
        this.f17991e = new HashMap();
        this.f17992f = 4194304;
    }

    private void a(int i2, Class<?> cls) {
        NavigableMap<Integer, Integer> n2 = n(cls);
        Integer num = n2.get(Integer.valueOf(i2));
        if (num != null) {
            int intValue = num.intValue();
            Integer valueOf = Integer.valueOf(i2);
            if (intValue == 1) {
                n2.remove(valueOf);
            } else {
                n2.put(valueOf, Integer.valueOf(num.intValue() - 1));
            }
        } else {
            throw new NullPointerException("Tried to decrement empty size, size: " + i2 + ", this: " + this);
        }
    }

    private void g() {
        h(this.f17992f);
    }

    private void h(int i2) {
        while (this.f17993g > i2) {
            Object f2 = this.f17988b.f();
            Preconditions.d(f2);
            ArrayAdapterInterface i3 = i(f2);
            this.f17993g -= i3.b(f2) * i3.a();
            a(i3.b(f2), f2.getClass());
            if (Log.isLoggable(i3.n(), 2)) {
                Log.v(i3.n(), "evicted: " + i3.b(f2));
            }
        }
    }

    private <T> ArrayAdapterInterface<T> i(T t) {
        return j(t.getClass());
    }

    private <T> ArrayAdapterInterface<T> j(Class<T> cls) {
        ArrayAdapterInterface<T> arrayAdapterInterface = this.f17991e.get(cls);
        if (arrayAdapterInterface == null) {
            if (cls.equals(int[].class)) {
                arrayAdapterInterface = new IntegerArrayAdapter();
            } else if (cls.equals(byte[].class)) {
                arrayAdapterInterface = new ByteArrayAdapter();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.f17991e.put(cls, arrayAdapterInterface);
        }
        return arrayAdapterInterface;
    }

    @Nullable
    private <T> T k(Key key) {
        return this.f17988b.a(key);
    }

    private <T> T m(Key key, Class<T> cls) {
        ArrayAdapterInterface<T> j2 = j(cls);
        T k2 = k(key);
        if (k2 != null) {
            this.f17993g -= j2.b(k2) * j2.a();
            a(j2.b(k2), cls);
        }
        if (k2 != null) {
            return k2;
        }
        if (Log.isLoggable(j2.n(), 2)) {
            Log.v(j2.n(), "Allocated " + key.f17995b + " bytes");
        }
        return j2.newArray(key.f17995b);
    }

    private NavigableMap<Integer, Integer> n(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f17990d.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f17990d.put(cls, treeMap);
        return treeMap;
    }

    private boolean o() {
        int i2 = this.f17993g;
        return i2 == 0 || this.f17992f / i2 >= 2;
    }

    private boolean p(int i2) {
        return i2 <= this.f17992f / 2;
    }

    private boolean q(int i2, Integer num) {
        return num != null && (o() || num.intValue() <= i2 * 8);
    }

    public synchronized void b(int i2) {
        if (i2 >= 40) {
            try {
                c();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        } else if (i2 >= 20 || i2 == 15) {
            h(this.f17992f / 2);
        }
    }

    public synchronized void c() {
        h(0);
    }

    public synchronized <T> T d(int i2, Class<T> cls) {
        return m(this.f17989c.e(i2, cls), cls);
    }

    @Deprecated
    public <T> void e(T t, Class<T> cls) {
        put(t);
    }

    public synchronized <T> T f(int i2, Class<T> cls) {
        Integer ceilingKey;
        try {
            ceilingKey = n(cls).ceilingKey(Integer.valueOf(i2));
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return m(q(i2, ceilingKey) ? this.f17989c.e(ceilingKey.intValue(), cls) : this.f17989c.e(i2, cls), cls);
    }

    /* access modifiers changed from: package-private */
    public int l() {
        int i2 = 0;
        for (Class next : this.f17990d.keySet()) {
            for (Integer num : this.f17990d.get(next).keySet()) {
                i2 += num.intValue() * ((Integer) this.f17990d.get(next).get(num)).intValue() * j(next).a();
            }
        }
        return i2;
    }

    public synchronized <T> void put(T t) {
        Class<?> cls = t.getClass();
        ArrayAdapterInterface<?> j2 = j(cls);
        int b2 = j2.b(t);
        int a2 = j2.a() * b2;
        if (p(a2)) {
            Key e2 = this.f17989c.e(b2, cls);
            this.f17988b.d(e2, t);
            NavigableMap<Integer, Integer> n2 = n(cls);
            Integer num = n2.get(Integer.valueOf(e2.f17995b));
            Integer valueOf = Integer.valueOf(e2.f17995b);
            int i2 = 1;
            if (num != null) {
                i2 = 1 + num.intValue();
            }
            n2.put(valueOf, Integer.valueOf(i2));
            this.f17993g += a2;
            g();
        }
    }

    public LruArrayPool(int i2) {
        this.f17988b = new GroupedLinkedMap<>();
        this.f17989c = new KeyPool();
        this.f17990d = new HashMap();
        this.f17991e = new HashMap();
        this.f17992f = i2;
    }
}
