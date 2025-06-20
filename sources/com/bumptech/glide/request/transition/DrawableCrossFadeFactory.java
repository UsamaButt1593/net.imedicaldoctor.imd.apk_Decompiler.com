package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

public class DrawableCrossFadeFactory implements TransitionFactory<Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private final int f18496a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f18497b;

    /* renamed from: c  reason: collision with root package name */
    private DrawableCrossFadeTransition f18498c;

    public static class Builder {

        /* renamed from: c  reason: collision with root package name */
        private static final int f18499c = 300;

        /* renamed from: a  reason: collision with root package name */
        private final int f18500a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f18501b;

        public Builder() {
            this(300);
        }

        public DrawableCrossFadeFactory a() {
            return new DrawableCrossFadeFactory(this.f18500a, this.f18501b);
        }

        public Builder b(boolean z) {
            this.f18501b = z;
            return this;
        }

        public Builder(int i2) {
            this.f18500a = i2;
        }
    }

    protected DrawableCrossFadeFactory(int i2, boolean z) {
        this.f18496a = i2;
        this.f18497b = z;
    }

    private Transition<Drawable> b() {
        if (this.f18498c == null) {
            this.f18498c = new DrawableCrossFadeTransition(this.f18496a, this.f18497b);
        }
        return this.f18498c;
    }

    public Transition<Drawable> a(DataSource dataSource, boolean z) {
        return dataSource == DataSource.MEMORY_CACHE ? NoTransition.b() : b();
    }
}
