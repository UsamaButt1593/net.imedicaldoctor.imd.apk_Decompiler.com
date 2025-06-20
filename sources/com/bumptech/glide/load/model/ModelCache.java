package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.Queue;

public class ModelCache<A, B> {

    /* renamed from: b  reason: collision with root package name */
    private static final int f18157b = 250;

    /* renamed from: a  reason: collision with root package name */
    private final LruCache<ModelKey<A>, B> f18158a;

    @VisibleForTesting
    static final class ModelKey<A> {

        /* renamed from: d  reason: collision with root package name */
        private static final Queue<ModelKey<?>> f18160d = Util.f(0);

        /* renamed from: a  reason: collision with root package name */
        private int f18161a;

        /* renamed from: b  reason: collision with root package name */
        private int f18162b;

        /* renamed from: c  reason: collision with root package name */
        private A f18163c;

        private ModelKey() {
        }

        static <A> ModelKey<A> a(A a2, int i2, int i3) {
            ModelKey<A> poll;
            Queue<ModelKey<?>> queue = f18160d;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new ModelKey<>();
            }
            poll.b(a2, i2, i3);
            return poll;
        }

        private void b(A a2, int i2, int i3) {
            this.f18163c = a2;
            this.f18162b = i2;
            this.f18161a = i3;
        }

        public void c() {
            Queue<ModelKey<?>> queue = f18160d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ModelKey)) {
                return false;
            }
            ModelKey modelKey = (ModelKey) obj;
            return this.f18162b == modelKey.f18162b && this.f18161a == modelKey.f18161a && this.f18163c.equals(modelKey.f18163c);
        }

        public int hashCode() {
            return (((this.f18161a * 31) + this.f18162b) * 31) + this.f18163c.hashCode();
        }
    }

    public ModelCache() {
        this(250);
    }

    public void a() {
        this.f18158a.c();
    }

    @Nullable
    public B b(A a2, int i2, int i3) {
        ModelKey a3 = ModelKey.a(a2, i2, i3);
        B k2 = this.f18158a.k(a3);
        a3.c();
        return k2;
    }

    public void c(A a2, int i2, int i3, B b2) {
        this.f18158a.o(ModelKey.a(a2, i2, i3), b2);
    }

    public ModelCache(long j2) {
        this.f18158a = new LruCache<ModelKey<A>, B>(j2) {
            /* access modifiers changed from: protected */
            /* renamed from: r */
            public void n(@NonNull ModelKey<A> modelKey, @Nullable B b2) {
                modelKey.c();
            }
        };
    }
}
