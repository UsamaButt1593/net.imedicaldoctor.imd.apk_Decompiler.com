package androidx.activity;

import androidx.activity.ComponentActivity;

public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ ComponentActivity.ReportFullyDrawnExecutorApi16Impl s;

    public /* synthetic */ e(ComponentActivity.ReportFullyDrawnExecutorApi16Impl reportFullyDrawnExecutorApi16Impl) {
        this.s = reportFullyDrawnExecutorApi16Impl;
    }

    public final void run() {
        this.s.b();
    }
}
