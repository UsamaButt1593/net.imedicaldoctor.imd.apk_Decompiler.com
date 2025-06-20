package com.google.android.gms.common.api.internal;

import android.os.Bundle;

final class zza implements Runnable {
    final /* synthetic */ String X;
    final /* synthetic */ zzb Y;
    final /* synthetic */ LifecycleCallback s;

    zza(zzb zzb, LifecycleCallback lifecycleCallback, String str) {
        this.Y = zzb;
        this.s = lifecycleCallback;
        this.X = str;
    }

    public final void run() {
        Bundle bundle;
        zzb zzb = this.Y;
        if (zzb.X > 0) {
            LifecycleCallback lifecycleCallback = this.s;
            if (zzb.Y != null) {
                bundle = zzb.Y.getBundle(this.X);
            } else {
                bundle = null;
            }
            lifecycleCallback.g(bundle);
        }
        if (this.Y.X >= 2) {
            this.s.k();
        }
        if (this.Y.X >= 3) {
            this.s.i();
        }
        if (this.Y.X >= 4) {
            this.s.l();
        }
        if (this.Y.X >= 5) {
            this.s.h();
        }
    }
}
