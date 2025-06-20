package com.google.firebase.crashlytics.internal.send;

import java.util.concurrent.CountDownLatch;

public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ CountDownLatch X;
    public final /* synthetic */ ReportQueue s;

    public /* synthetic */ b(ReportQueue reportQueue, CountDownLatch countDownLatch) {
        this.s = reportQueue;
        this.X = countDownLatch;
    }

    public final void run() {
        this.s.m(this.X);
    }
}
