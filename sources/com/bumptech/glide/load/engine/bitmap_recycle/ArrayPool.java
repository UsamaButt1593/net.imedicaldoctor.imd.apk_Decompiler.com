package com.bumptech.glide.load.engine.bitmap_recycle;

public interface ArrayPool {

    /* renamed from: a  reason: collision with root package name */
    public static final int f17968a = 65536;

    void b(int i2);

    void c();

    <T> T d(int i2, Class<T> cls);

    @Deprecated
    <T> void e(T t, Class<T> cls);

    <T> T f(int i2, Class<T> cls);

    <T> void put(T t);
}
