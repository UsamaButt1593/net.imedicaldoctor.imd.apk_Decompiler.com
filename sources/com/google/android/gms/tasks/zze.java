package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zze implements Runnable {
    final /* synthetic */ zzf X;
    final /* synthetic */ Task s;

    zze(zzf zzf, Task task) {
        this.X = zzf;
        this.s = task;
    }

    public final void run() {
        try {
            Task task = (Task) this.X.f20541b.a(this.s);
            if (task == null) {
                this.X.e(new NullPointerException("Continuation returned null"));
                return;
            }
            zzf zzf = this.X;
            Executor executor = TaskExecutors.f20523b;
            task.l(executor, zzf);
            task.i(executor, this.X);
            task.c(executor, this.X);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                this.X.f20542c.y((Exception) e2.getCause());
            } else {
                this.X.f20542c.y(e2);
            }
        } catch (Exception e3) {
            this.X.f20542c.y(e3);
        }
    }
}
