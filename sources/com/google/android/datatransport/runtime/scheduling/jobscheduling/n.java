package com.google.android.datatransport.runtime.scheduling.jobscheduling;

public final /* synthetic */ class n implements Runnable {
    public final /* synthetic */ WorkInitializer s;

    public /* synthetic */ n(WorkInitializer workInitializer) {
        this.s = workInitializer;
    }

    public final void run() {
        this.s.e();
    }
}
