package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;

public final class InstanceFactory<T> implements Factory<T>, Lazy<T> {

    /* renamed from: b  reason: collision with root package name */
    private static final InstanceFactory<Object> f19491b = new InstanceFactory<>((Object) null);

    /* renamed from: a  reason: collision with root package name */
    private final T f19492a;

    private InstanceFactory(T t) {
        this.f19492a = t;
    }

    public static <T> Factory<T> a(T t) {
        return new InstanceFactory(Preconditions.c(t, "instance cannot be null"));
    }

    public static <T> Factory<T> b(T t) {
        return t == null ? c() : new InstanceFactory(t);
    }

    private static <T> InstanceFactory<T> c() {
        return f19491b;
    }

    public T get() {
        return this.f19492a;
    }
}
