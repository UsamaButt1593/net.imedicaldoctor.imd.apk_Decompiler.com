package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import com.dd.plist.ASCIIPropertyListParser;

class EngineResource<Z> implements Resource<Z> {
    private final boolean X;
    private final Key X2;
    private final Resource<Z> Y;
    private int Y2;
    private final ResourceListener Z;
    private boolean Z2;
    private final boolean s;

    interface ResourceListener {
        void d(Key key, EngineResource<?> engineResource);
    }

    EngineResource(Resource<Z> resource, boolean z, boolean z2, Key key, ResourceListener resourceListener) {
        this.Y = (Resource) Preconditions.d(resource);
        this.s = z;
        this.X = z2;
        this.X2 = key;
        this.Z = (ResourceListener) Preconditions.d(resourceListener);
    }

    public int a() {
        return this.Y.a();
    }

    /* access modifiers changed from: package-private */
    public synchronized void b() {
        if (!this.Z2) {
            this.Y2++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    @NonNull
    public Class<Z> c() {
        return this.Y.c();
    }

    /* access modifiers changed from: package-private */
    public Resource<Z> d() {
        return this.Y;
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        return this.s;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        boolean z;
        synchronized (this) {
            int i2 = this.Y2;
            if (i2 > 0) {
                z = true;
                int i3 = i2 - 1;
                this.Y2 = i3;
                if (i3 != 0) {
                    z = false;
                }
            } else {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
        }
        if (z) {
            this.Z.d(this.X2, this);
        }
    }

    @NonNull
    public Z get() {
        return this.Y.get();
    }

    public synchronized void recycle() {
        if (this.Y2 > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (!this.Z2) {
            this.Z2 = true;
            if (this.X) {
                this.Y.recycle();
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.s + ", listener=" + this.Z + ", key=" + this.X2 + ", acquired=" + this.Y2 + ", isRecycled=" + this.Z2 + ", resource=" + this.Y + ASCIIPropertyListParser.f18653k;
    }
}
