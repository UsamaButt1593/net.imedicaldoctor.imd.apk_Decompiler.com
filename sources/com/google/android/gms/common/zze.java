package com.google.android.gms.common;

import java.util.concurrent.Callable;

public final /* synthetic */ class zze implements Callable {
    public final /* synthetic */ String X;
    public final /* synthetic */ zzj Y;
    public final /* synthetic */ boolean s;

    public /* synthetic */ zze(boolean z, String str, zzj zzj) {
        this.s = z;
        this.X = str;
        this.Y = zzj;
    }

    public final Object call() {
        return zzn.d(this.s, this.X, this.Y);
    }
}
