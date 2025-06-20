package com.google.android.gms.common.api.internal;

import androidx.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;

public final class zab extends ActivityLifecycleObserver {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<zaa> f20080a;

    @VisibleForTesting(otherwise = 2)
    zab(zaa zaa) {
        this.f20080a = new WeakReference<>(zaa);
    }

    public final ActivityLifecycleObserver b(Runnable runnable) {
        zaa zaa = this.f20080a.get();
        if (zaa != null) {
            zaa.o(runnable);
            return this;
        }
        throw new IllegalStateException("The target activity has already been GC'd");
    }
}
