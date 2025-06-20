package com.google.android.gms.tasks;

final class zzm implements Runnable {
    final /* synthetic */ zzn X;
    final /* synthetic */ Task s;

    zzm(zzn zzn, Task task) {
        this.X = zzn;
        this.s = task;
    }

    public final void run() {
        synchronized (this.X.f20553b) {
            try {
                zzn zzn = this.X;
                if (zzn.f20554c != null) {
                    zzn.f20554c.a(this.s.r());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
