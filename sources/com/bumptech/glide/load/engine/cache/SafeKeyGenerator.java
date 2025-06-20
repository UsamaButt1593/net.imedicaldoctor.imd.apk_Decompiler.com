package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SafeKeyGenerator {

    /* renamed from: a  reason: collision with root package name */
    private final LruCache<Key, String> f18080a = new LruCache<>(1000);

    /* renamed from: b  reason: collision with root package name */
    private final Pools.Pool<PoolableDigestContainer> f18081b = FactoryPools.e(10, new FactoryPools.Factory<PoolableDigestContainer>() {
        /* renamed from: b */
        public PoolableDigestContainer a() {
            try {
                return new PoolableDigestContainer(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
    });

    private static final class PoolableDigestContainer implements FactoryPools.Poolable {
        private final StateVerifier X = StateVerifier.a();
        final MessageDigest s;

        PoolableDigestContainer(MessageDigest messageDigest) {
            this.s = messageDigest;
        }

        @NonNull
        public StateVerifier b() {
            return this.X;
        }
    }

    private String a(Key key) {
        PoolableDigestContainer poolableDigestContainer = (PoolableDigestContainer) Preconditions.d(this.f18081b.b());
        try {
            key.a(poolableDigestContainer.s);
            return Util.w(poolableDigestContainer.s.digest());
        } finally {
            this.f18081b.c(poolableDigestContainer);
        }
    }

    public String b(Key key) {
        String k2;
        synchronized (this.f18080a) {
            k2 = this.f18080a.k(key);
        }
        if (k2 == null) {
            k2 = a(key);
        }
        synchronized (this.f18080a) {
            this.f18080a.o(key, k2);
        }
        return k2;
    }
}
