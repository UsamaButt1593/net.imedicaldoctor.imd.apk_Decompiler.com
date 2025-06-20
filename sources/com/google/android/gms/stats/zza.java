package com.google.android.gms.stats;

public final /* synthetic */ class zza implements Runnable {
    public final /* synthetic */ WakeLock s;

    public /* synthetic */ zza(WakeLock wakeLock) {
        this.s = wakeLock;
    }

    public final void run() {
        WakeLock.e(this.s);
    }
}
