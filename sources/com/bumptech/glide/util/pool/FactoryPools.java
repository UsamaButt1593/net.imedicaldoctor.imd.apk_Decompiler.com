package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

public final class FactoryPools {

    /* renamed from: a  reason: collision with root package name */
    private static final String f18546a = "FactoryPools";

    /* renamed from: b  reason: collision with root package name */
    private static final int f18547b = 20;

    /* renamed from: c  reason: collision with root package name */
    private static final Resetter<Object> f18548c = new Resetter<Object>() {
        public void a(@NonNull Object obj) {
        }
    };

    public interface Factory<T> {
        T a();
    }

    private static final class FactoryPool<T> implements Pools.Pool<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Factory<T> f18549a;

        /* renamed from: b  reason: collision with root package name */
        private final Resetter<T> f18550b;

        /* renamed from: c  reason: collision with root package name */
        private final Pools.Pool<T> f18551c;

        FactoryPool(@NonNull Pools.Pool<T> pool, @NonNull Factory<T> factory, @NonNull Resetter<T> resetter) {
            this.f18551c = pool;
            this.f18549a = factory;
            this.f18550b = resetter;
        }

        public T b() {
            T b2 = this.f18551c.b();
            if (b2 == null) {
                b2 = this.f18549a.a();
                if (Log.isLoggable(FactoryPools.f18546a, 2)) {
                    Log.v(FactoryPools.f18546a, "Created new " + b2.getClass());
                }
            }
            if (b2 instanceof Poolable) {
                ((Poolable) b2).b().b(false);
            }
            return b2;
        }

        public boolean c(@NonNull T t) {
            if (t instanceof Poolable) {
                ((Poolable) t).b().b(true);
            }
            this.f18550b.a(t);
            return this.f18551c.c(t);
        }
    }

    public interface Poolable {
        @NonNull
        StateVerifier b();
    }

    public interface Resetter<T> {
        void a(@NonNull T t);
    }

    private FactoryPools() {
    }

    @NonNull
    private static <T extends Poolable> Pools.Pool<T> a(@NonNull Pools.Pool<T> pool, @NonNull Factory<T> factory) {
        return b(pool, factory, c());
    }

    @NonNull
    private static <T> Pools.Pool<T> b(@NonNull Pools.Pool<T> pool, @NonNull Factory<T> factory, @NonNull Resetter<T> resetter) {
        return new FactoryPool(pool, factory, resetter);
    }

    @NonNull
    private static <T> Resetter<T> c() {
        return f18548c;
    }

    @NonNull
    public static <T extends Poolable> Pools.Pool<T> d(int i2, @NonNull Factory<T> factory) {
        return a(new Pools.SimplePool(i2), factory);
    }

    @NonNull
    public static <T extends Poolable> Pools.Pool<T> e(int i2, @NonNull Factory<T> factory) {
        return a(new Pools.SynchronizedPool(i2), factory);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> f() {
        return g(20);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> g(int i2) {
        return b(new Pools.SynchronizedPool(i2), new Factory<List<T>>() {
            @NonNull
            /* renamed from: b */
            public List<T> a() {
                return new ArrayList();
            }
        }, new Resetter<List<T>>() {
            /* renamed from: b */
            public void a(@NonNull List<T> list) {
                list.clear();
            }
        });
    }
}
