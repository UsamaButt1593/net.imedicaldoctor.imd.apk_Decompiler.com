package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import javax.inject.Provider;

public final class DoubleCheck<T> implements Provider<T>, Lazy<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f19487c = new Object();

    /* renamed from: d  reason: collision with root package name */
    static final /* synthetic */ boolean f19488d = false;

    /* renamed from: a  reason: collision with root package name */
    private volatile Provider<T> f19489a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f19490b = f19487c;

    private DoubleCheck(Provider<T> provider) {
        this.f19489a = provider;
    }

    public static <P extends Provider<T>, T> Lazy<T> a(P p) {
        return p instanceof Lazy ? (Lazy) p : new DoubleCheck((Provider) Preconditions.b(p));
    }

    public static <P extends Provider<T>, T> Provider<T> b(P p) {
        Preconditions.b(p);
        return p instanceof DoubleCheck ? p : new DoubleCheck(p);
    }

    private static Object c(Object obj, Object obj2) {
        if (obj == f19487c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    public T get() {
        T t = this.f19490b;
        T t2 = f19487c;
        if (t == t2) {
            synchronized (this) {
                try {
                    t = this.f19490b;
                    if (t == t2) {
                        t = this.f19489a.get();
                        this.f19490b = c(this.f19490b, t);
                        this.f19489a = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return t;
    }
}
