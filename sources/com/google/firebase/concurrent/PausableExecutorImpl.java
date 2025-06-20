package com.google.firebase.concurrent;

import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

final class PausableExecutorImpl implements PausableExecutor {
    private final Executor X;
    @VisibleForTesting
    final LinkedBlockingQueue<Runnable> Y = new LinkedBlockingQueue<>();
    private volatile boolean s;

    PausableExecutorImpl(boolean z, Executor executor) {
        this.s = z;
        this.X = executor;
    }

    private void a() {
        if (this.s) {
            return;
        }
        while (true) {
            Runnable poll = this.Y.poll();
            while (true) {
                if (poll != null) {
                    this.X.execute(poll);
                    if (this.s) {
                        poll = null;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean A0() {
        return this.s;
    }

    public void P() {
        this.s = false;
        a();
    }

    public void execute(Runnable runnable) {
        this.Y.offer(runnable);
        a();
    }

    public void h() {
        this.s = true;
    }
}
