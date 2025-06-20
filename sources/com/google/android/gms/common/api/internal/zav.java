package com.google.android.gms.common.api.internal;

final class zav implements Runnable {
    final /* synthetic */ zaaa s;

    zav(zaaa zaaa) {
        this.s = zaaa;
    }

    public final void run() {
        this.s.x.lock();
        try {
            zaaa.C(this.s);
        } finally {
            this.s.x.unlock();
        }
    }
}
