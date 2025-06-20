package com.bumptech.glide.util.pool;

import androidx.annotation.NonNull;

public abstract class StateVerifier {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f18554a = false;

    private static class DebugStateVerifier extends StateVerifier {

        /* renamed from: b  reason: collision with root package name */
        private volatile RuntimeException f18555b;

        DebugStateVerifier() {
            super();
        }

        /* access modifiers changed from: package-private */
        public void b(boolean z) {
            this.f18555b = z ? new RuntimeException("Released") : null;
        }

        public void c() {
            if (this.f18555b != null) {
                throw new IllegalStateException("Already released", this.f18555b);
            }
        }
    }

    private static class DefaultStateVerifier extends StateVerifier {

        /* renamed from: b  reason: collision with root package name */
        private volatile boolean f18556b;

        DefaultStateVerifier() {
            super();
        }

        public void b(boolean z) {
            this.f18556b = z;
        }

        public void c() {
            if (this.f18556b) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    private StateVerifier() {
    }

    @NonNull
    public static StateVerifier a() {
        return new DefaultStateVerifier();
    }

    /* access modifiers changed from: package-private */
    public abstract void b(boolean z);

    public abstract void c();
}
