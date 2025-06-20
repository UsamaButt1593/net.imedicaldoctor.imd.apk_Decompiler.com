package com.google.android.gms.tasks;

final class zzc implements Runnable {
    final /* synthetic */ zzd X;
    final /* synthetic */ Task s;

    zzc(zzd zzd, Task task) {
        this.X = zzd;
        this.s = task;
    }

    public final void run() {
        if (this.s.t()) {
            this.X.f20539c.A();
            return;
        }
        try {
            this.X.f20539c.z(this.X.f20538b.a(this.s));
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                this.X.f20539c.y((Exception) e2.getCause());
            } else {
                this.X.f20539c.y(e2);
            }
        } catch (Exception e3) {
            this.X.f20539c.y(e3);
        }
    }
}
