package com.google.firebase.concurrent;

import com.google.firebase.components.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

class LimitedConcurrencyExecutor implements Executor {
    private final Semaphore X;
    private final LinkedBlockingQueue<Runnable> Y = new LinkedBlockingQueue<>();
    private final Executor s;

    LimitedConcurrencyExecutor(Executor executor, int i2) {
        Preconditions.a(i2 > 0, "concurrency must be positive.");
        this.s = executor;
        this.X = new Semaphore(i2, true);
    }

    private Runnable b(Runnable runnable) {
        return new x(this, runnable);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(Runnable runnable) {
        try {
            runnable.run();
        } finally {
            this.X.release();
            d();
        }
    }

    private void d() {
        while (this.X.tryAcquire()) {
            Runnable poll = this.Y.poll();
            if (poll != null) {
                this.s.execute(b(poll));
            } else {
                this.X.release();
                return;
            }
        }
    }

    public void execute(Runnable runnable) {
        this.Y.offer(runnable);
        d();
    }
}
