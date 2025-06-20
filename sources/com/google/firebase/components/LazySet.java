package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class LazySet<T> implements Provider<Set<T>> {

    /* renamed from: a  reason: collision with root package name */
    private volatile Set<Provider<T>> f23412a = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: b  reason: collision with root package name */
    private volatile Set<T> f23413b = null;

    LazySet(Collection<Provider<T>> collection) {
        this.f23412a.addAll(collection);
    }

    static LazySet<?> b(Collection<Provider<?>> collection) {
        return new LazySet<>((Set) collection);
    }

    private synchronized void d() {
        try {
            for (Provider<T> provider : this.f23412a) {
                this.f23413b.add(provider.get());
            }
            this.f23412a = null;
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(Provider<T> provider) {
        Set set;
        T t;
        try {
            if (this.f23413b == null) {
                set = this.f23412a;
                t = provider;
            } else {
                set = this.f23413b;
                t = provider.get();
            }
            set.add(t);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* renamed from: c */
    public Set<T> get() {
        if (this.f23413b == null) {
            synchronized (this) {
                try {
                    if (this.f23413b == null) {
                        this.f23413b = Collections.newSetFromMap(new ConcurrentHashMap());
                        d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return Collections.unmodifiableSet(this.f23413b);
    }
}
