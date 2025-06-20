package com.google.android.gms.common.api.internal;

import android.os.Bundle;

final class zzc implements Runnable {
    final /* synthetic */ String X;
    final /* synthetic */ zzd Y;
    final /* synthetic */ LifecycleCallback s;

    zzc(zzd zzd, LifecycleCallback lifecycleCallback, String str) {
        this.Y = zzd;
        this.s = lifecycleCallback;
        this.X = str;
    }

    public final void run() {
        Bundle bundle;
        zzd zzd = this.Y;
        if (zzd.f4 > 0) {
            LifecycleCallback lifecycleCallback = this.s;
            if (zzd.g4 != null) {
                bundle = zzd.g4.getBundle(this.X);
            } else {
                bundle = null;
            }
            lifecycleCallback.g(bundle);
        }
        if (this.Y.f4 >= 2) {
            this.s.k();
        }
        if (this.Y.f4 >= 3) {
            this.s.i();
        }
        if (this.Y.f4 >= 4) {
            this.s.l();
        }
        if (this.Y.f4 >= 5) {
            this.s.h();
        }
    }
}
