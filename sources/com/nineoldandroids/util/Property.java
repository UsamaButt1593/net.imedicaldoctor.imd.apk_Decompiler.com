package com.nineoldandroids.util;

public abstract class Property<T, V> {

    /* renamed from: a  reason: collision with root package name */
    private final String f27901a;

    /* renamed from: b  reason: collision with root package name */
    private final Class<V> f27902b;

    public Property(Class<V> cls, String str) {
        this.f27901a = str;
        this.f27902b = cls;
    }

    public static <T, V> Property<T, V> e(Class<T> cls, Class<V> cls2, String str) {
        return new ReflectiveProperty(cls, cls2, str);
    }

    public abstract V a(T t);

    public String b() {
        return this.f27901a;
    }

    public Class<V> c() {
        return this.f27902b;
    }

    public boolean d() {
        return false;
    }

    public void f(T t, V v) {
        throw new UnsupportedOperationException("Property " + b() + " is read-only");
    }
}
