package com.google.firebase.components;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

class OptionalProvider<T> implements Provider<T>, Deferred<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Deferred.DeferredHandler<Object> f23414c = new p();

    /* renamed from: d  reason: collision with root package name */
    private static final Provider<Object> f23415d = new q();
    @GuardedBy("this")

    /* renamed from: a  reason: collision with root package name */
    private Deferred.DeferredHandler<T> f23416a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Provider<T> f23417b;

    private OptionalProvider(Deferred.DeferredHandler<T> deferredHandler, Provider<T> provider) {
        this.f23416a = deferredHandler;
        this.f23417b = provider;
    }

    static <T> OptionalProvider<T> e() {
        return new OptionalProvider<>(f23414c, f23415d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void f(Provider provider) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object g() {
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void h(Deferred.DeferredHandler deferredHandler, Deferred.DeferredHandler deferredHandler2, Provider provider) {
        deferredHandler.a(provider);
        deferredHandler2.a(provider);
    }

    static <T> OptionalProvider<T> i(Provider<T> provider) {
        return new OptionalProvider<>((Deferred.DeferredHandler) null, provider);
    }

    public void a(@NonNull Deferred.DeferredHandler<T> deferredHandler) {
        Provider<T> provider;
        Provider<T> provider2;
        Provider<T> provider3 = this.f23417b;
        Provider<Object> provider4 = f23415d;
        if (provider3 != provider4) {
            deferredHandler.a(provider3);
            return;
        }
        synchronized (this) {
            provider = this.f23417b;
            if (provider != provider4) {
                provider2 = provider;
            } else {
                this.f23416a = new C0482r(this.f23416a, deferredHandler);
                provider2 = null;
            }
        }
        if (provider2 != null) {
            deferredHandler.a(provider);
        }
    }

    public T get() {
        return this.f23417b.get();
    }

    /* access modifiers changed from: package-private */
    public void j(Provider<T> provider) {
        Deferred.DeferredHandler<T> deferredHandler;
        if (this.f23417b == f23415d) {
            synchronized (this) {
                deferredHandler = this.f23416a;
                this.f23416a = null;
                this.f23417b = provider;
            }
            deferredHandler.a(provider);
            return;
        }
        throw new IllegalStateException("provide() can be called only once.");
    }
}
