package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;

final class LockedResource<Z> implements Resource<Z>, FactoryPools.Poolable {
    private static final Pools.Pool<LockedResource<?>> X2 = FactoryPools.e(20, new FactoryPools.Factory<LockedResource<?>>() {
        /* renamed from: b */
        public LockedResource<?> a() {
            return new LockedResource<>();
        }
    });
    private Resource<Z> X;
    private boolean Y;
    private boolean Z;
    private final StateVerifier s = StateVerifier.a();

    LockedResource() {
    }

    private void d(Resource<Z> resource) {
        this.Z = false;
        this.Y = true;
        this.X = resource;
    }

    @NonNull
    static <Z> LockedResource<Z> e(Resource<Z> resource) {
        LockedResource<Z> lockedResource = (LockedResource) Preconditions.d(X2.b());
        lockedResource.d(resource);
        return lockedResource;
    }

    private void f() {
        this.X = null;
        X2.c(this);
    }

    public int a() {
        return this.X.a();
    }

    @NonNull
    public StateVerifier b() {
        return this.s;
    }

    @NonNull
    public Class<Z> c() {
        return this.X.c();
    }

    /* access modifiers changed from: package-private */
    public synchronized void g() {
        this.s.c();
        if (this.Y) {
            this.Y = false;
            if (this.Z) {
                recycle();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    @NonNull
    public Z get() {
        return this.X.get();
    }

    public synchronized void recycle() {
        this.s.c();
        this.Z = true;
        if (!this.Y) {
            this.X.recycle();
            f();
        }
    }
}
