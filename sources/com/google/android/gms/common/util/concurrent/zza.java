package com.google.android.gms.common.util.concurrent;

import android.os.Process;

final class zza implements Runnable {
    private final Runnable s;

    public zza(Runnable runnable, int i2) {
        this.s = runnable;
    }

    public final void run() {
        Process.setThreadPriority(0);
        this.s.run();
    }
}
