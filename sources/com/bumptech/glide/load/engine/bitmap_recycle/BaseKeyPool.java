package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import com.bumptech.glide.util.Util;
import java.util.Queue;

abstract class BaseKeyPool<T extends Poolable> {

    /* renamed from: b  reason: collision with root package name */
    private static final int f17975b = 20;

    /* renamed from: a  reason: collision with root package name */
    private final Queue<T> f17976a = Util.f(20);

    BaseKeyPool() {
    }

    /* access modifiers changed from: package-private */
    public abstract T a();

    /* access modifiers changed from: package-private */
    public T b() {
        T t = (Poolable) this.f17976a.poll();
        return t == null ? a() : t;
    }

    public void c(T t) {
        if (this.f17976a.size() < 20) {
            this.f17976a.offer(t);
        }
    }
}
