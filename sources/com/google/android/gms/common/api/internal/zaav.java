package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;

abstract class zaav implements Runnable {
    final /* synthetic */ zaaw s;

    /* synthetic */ zaav(zaaw zaaw, zaau zaau) {
        this.s = zaaw;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public abstract void a();

    @WorkerThread
    public final void run() {
        this.s.f20063b.lock();
        try {
            if (!Thread.interrupted()) {
                a();
            }
        } catch (RuntimeException e2) {
            this.s.f20062a.u(e2);
        } catch (Throwable th) {
            this.s.f20063b.unlock();
            throw th;
        }
        this.s.f20063b.unlock();
    }
}
