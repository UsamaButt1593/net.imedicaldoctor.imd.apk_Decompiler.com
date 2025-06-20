package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

class ActivityFragmentLifecycle implements Lifecycle {

    /* renamed from: a  reason: collision with root package name */
    private final Set<LifecycleListener> f18413a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private boolean f18414b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18415c;

    ActivityFragmentLifecycle() {
    }

    public void a(@NonNull LifecycleListener lifecycleListener) {
        this.f18413a.add(lifecycleListener);
        if (this.f18415c) {
            lifecycleListener.b();
        } else if (this.f18414b) {
            lifecycleListener.a();
        } else {
            lifecycleListener.d();
        }
    }

    public void b(@NonNull LifecycleListener lifecycleListener) {
        this.f18413a.remove(lifecycleListener);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f18415c = true;
        for (T b2 : Util.k(this.f18413a)) {
            b2.b();
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f18414b = true;
        for (T a2 : Util.k(this.f18413a)) {
            a2.a();
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f18414b = false;
        for (T d2 : Util.k(this.f18413a)) {
            d2.d();
        }
    }
}
