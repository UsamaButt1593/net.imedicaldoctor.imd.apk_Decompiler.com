package com.google.android.gms.tasks;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

final class zzo implements Runnable {
    final /* synthetic */ zzp X;
    final /* synthetic */ Task s;

    zzo(zzp zzp, Task task) {
        this.X = zzp;
        this.s = task;
    }

    public final void run() {
        try {
            Task a2 = this.X.f20556b.a(this.s.r());
            if (a2 == null) {
                this.X.e(new NullPointerException("Continuation returned null"));
                return;
            }
            zzp zzp = this.X;
            Executor executor = TaskExecutors.f20523b;
            a2.l(executor, zzp);
            a2.i(executor, this.X);
            a2.c(executor, this.X);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                this.X.e((Exception) e2.getCause());
            } else {
                this.X.e(e2);
            }
        } catch (CancellationException unused) {
            this.X.c();
        } catch (Exception e3) {
            this.X.e(e3);
        }
    }
}
