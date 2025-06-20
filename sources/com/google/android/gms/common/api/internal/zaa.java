package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;

@VisibleForTesting(otherwise = 2)
final class zaa extends LifecycleCallback {
    private List<Runnable> X = new ArrayList();

    private zaa(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.s.c("LifecycleObserverOnStop", this);
    }

    static /* bridge */ /* synthetic */ zaa m(Activity activity) {
        zaa zaa;
        synchronized (activity) {
            try {
                LifecycleFragment c2 = LifecycleCallback.c(activity);
                zaa = (zaa) c2.d("LifecycleObserverOnStop", zaa.class);
                if (zaa == null) {
                    zaa = new zaa(c2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zaa;
    }

    /* access modifiers changed from: private */
    public final synchronized void o(Runnable runnable) {
        this.X.add(runnable);
    }

    @MainThread
    public final void l() {
        List<Runnable> list;
        synchronized (this) {
            list = this.X;
            this.X = new ArrayList();
        }
        for (Runnable run : list) {
            run.run();
        }
    }
}
