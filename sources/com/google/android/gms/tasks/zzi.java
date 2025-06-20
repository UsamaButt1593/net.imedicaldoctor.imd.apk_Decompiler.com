package com.google.android.gms.tasks;

final class zzi implements Runnable {
    final /* synthetic */ zzj X;
    final /* synthetic */ Task s;

    zzi(zzj zzj, Task task) {
        this.X = zzj;
        this.s = task;
    }

    public final void run() {
        synchronized (this.X.f20547b) {
            try {
                zzj zzj = this.X;
                if (zzj.f20548c != null) {
                    zzj.f20548c.a(this.s);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
