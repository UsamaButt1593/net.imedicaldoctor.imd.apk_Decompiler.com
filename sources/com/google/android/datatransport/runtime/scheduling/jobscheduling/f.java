package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;

public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ TransportContext X;
    public final /* synthetic */ int Y;
    public final /* synthetic */ Runnable Z;
    public final /* synthetic */ Uploader s;

    public /* synthetic */ f(Uploader uploader, TransportContext transportContext, int i2, Runnable runnable) {
        this.s = uploader;
        this.X = transportContext;
        this.Y = i2;
        this.Z = runnable;
    }

    public final void run() {
        this.s.t(this.X, this.Y, this.Z);
    }
}
