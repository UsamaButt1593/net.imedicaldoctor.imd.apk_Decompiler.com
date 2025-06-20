package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public final class TargetTracker implements LifecycleListener {
    private final Set<Target<?>> s = Collections.newSetFromMap(new WeakHashMap());

    public void a() {
        for (T a2 : Util.k(this.s)) {
            a2.a();
        }
    }

    public void b() {
        for (T b2 : Util.k(this.s)) {
            b2.b();
        }
    }

    public void d() {
        for (T d2 : Util.k(this.s)) {
            d2.d();
        }
    }

    public void f() {
        this.s.clear();
    }

    @NonNull
    public List<Target<?>> g() {
        return Util.k(this.s);
    }

    public void h(@NonNull Target<?> target) {
        this.s.add(target);
    }

    public void i(@NonNull Target<?> target) {
        this.s.remove(target);
    }
}
