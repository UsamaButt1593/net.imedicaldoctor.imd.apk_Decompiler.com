package com.google.firebase.components;

import androidx.annotation.VisibleForTesting;
import com.google.firebase.inject.Provider;

public class Lazy<T> implements Provider<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f23409c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private volatile Object f23410a = f23409c;

    /* renamed from: b  reason: collision with root package name */
    private volatile Provider<T> f23411b;

    public Lazy(Provider<T> provider) {
        this.f23411b = provider;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean a() {
        return this.f23410a != f23409c;
    }

    public T get() {
        T t = this.f23410a;
        T t2 = f23409c;
        if (t == t2) {
            synchronized (this) {
                try {
                    t = this.f23410a;
                    if (t == t2) {
                        t = this.f23411b.get();
                        this.f23410a = t;
                        this.f23411b = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return t;
    }

    Lazy(T t) {
        this.f23410a = t;
    }
}
