package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;

final class zzk implements Runnable {
    final /* synthetic */ zzl X;
    final /* synthetic */ Task s;

    zzk(zzl zzl, Task task) {
        this.X = zzl;
        this.s = task;
    }

    public final void run() {
        synchronized (this.X.f20550b) {
            try {
                zzl zzl = this.X;
                if (zzl.f20551c != null) {
                    zzl.f20551c.e((Exception) Preconditions.r(this.s.q()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
