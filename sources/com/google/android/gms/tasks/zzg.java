package com.google.android.gms.tasks;

final class zzg implements Runnable {
    final /* synthetic */ zzh s;

    zzg(zzh zzh) {
        this.s = zzh;
    }

    public final void run() {
        synchronized (this.s.f20544b) {
            try {
                zzh zzh = this.s;
                if (zzh.f20545c != null) {
                    zzh.f20545c.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
