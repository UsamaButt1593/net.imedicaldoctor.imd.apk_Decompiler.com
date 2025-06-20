package com.google.android.gms.tasks;

import android.app.Activity;
import androidx.annotation.MainThread;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

final class zzv extends LifecycleCallback {
    private final List X = new ArrayList();

    private zzv(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.s.c("TaskOnStopCallback", this);
    }

    public static zzv m(Activity activity) {
        zzv zzv;
        LifecycleFragment c2 = LifecycleCallback.c(activity);
        synchronized (c2) {
            try {
                zzv = (zzv) c2.d("TaskOnStopCallback", zzv.class);
                if (zzv == null) {
                    zzv = new zzv(c2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzv;
    }

    @MainThread
    public final void l() {
        synchronized (this.X) {
            try {
                for (WeakReference weakReference : this.X) {
                    zzq zzq = (zzq) weakReference.get();
                    if (zzq != null) {
                        zzq.b();
                    }
                }
                this.X.clear();
            } finally {
            }
        }
    }

    public final void n(zzq zzq) {
        synchronized (this.X) {
            this.X.add(new WeakReference(zzq));
        }
    }
}
