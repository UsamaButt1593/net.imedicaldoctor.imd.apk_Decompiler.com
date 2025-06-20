package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Executor;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public abstract class CacheLoader<K, V> {

    private static final class FunctionToCacheLoader<K, V> extends CacheLoader<K, V> implements Serializable {
        private static final long X = 0;
        private final Function<K, V> s;

        public FunctionToCacheLoader(Function<K, V> function) {
            this.s = (Function) Preconditions.E(function);
        }

        public V d(K k2) {
            return this.s.apply(Preconditions.E(k2));
        }
    }

    public static final class InvalidCacheLoadException extends RuntimeException {
        public InvalidCacheLoadException(String str) {
            super(str);
        }
    }

    private static final class SupplierToCacheLoader<V> extends CacheLoader<Object, V> implements Serializable {
        private static final long X = 0;
        private final Supplier<V> s;

        public SupplierToCacheLoader(Supplier<V> supplier) {
            this.s = (Supplier) Preconditions.E(supplier);
        }

        public V d(Object obj) {
            Preconditions.E(obj);
            return this.s.get();
        }
    }

    public static final class UnsupportedLoadingOperationException extends UnsupportedOperationException {
        UnsupportedLoadingOperationException() {
        }
    }

    protected CacheLoader() {
    }

    @GwtIncompatible
    public static <K, V> CacheLoader<K, V> a(CacheLoader<K, V> cacheLoader, final Executor executor) {
        Preconditions.E(cacheLoader);
        Preconditions.E(executor);
        return new CacheLoader<K, V>() {
            public V d(K k2) throws Exception {
                return CacheLoader.this.d(k2);
            }

            public Map<K, V> e(Iterable<? extends K> iterable) throws Exception {
                return CacheLoader.this.e(iterable);
            }

            public ListenableFuture<V> f(K k2, V v) {
                ListenableFutureTask b2 = ListenableFutureTask.b(new a(CacheLoader.this, k2, v));
                executor.execute(b2);
                return b2;
            }
        };
    }

    public static <K, V> CacheLoader<K, V> b(Function<K, V> function) {
        return new FunctionToCacheLoader(function);
    }

    public static <V> CacheLoader<Object, V> c(Supplier<V> supplier) {
        return new SupplierToCacheLoader(supplier);
    }

    public abstract V d(K k2) throws Exception;

    public Map<K, V> e(Iterable<? extends K> iterable) throws Exception {
        throw new UnsupportedLoadingOperationException();
    }

    @GwtIncompatible
    public ListenableFuture<V> f(K k2, V v) throws Exception {
        Preconditions.E(k2);
        Preconditions.E(v);
        return Futures.o(d(k2));
    }
}
