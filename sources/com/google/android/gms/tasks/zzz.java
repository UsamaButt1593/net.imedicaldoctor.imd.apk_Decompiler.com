package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

final class zzz implements Runnable {
    final /* synthetic */ Callable X;
    final /* synthetic */ zzw s;

    zzz(zzw zzw, Callable callable) {
        this.s = zzw;
        this.X = callable;
    }

    public final void run() {
        try {
            this.s.z(this.X.call());
        } catch (Exception e2) {
            this.s.y(e2);
        } catch (Throwable th) {
            this.s.y(new RuntimeException(th));
        }
    }
}
