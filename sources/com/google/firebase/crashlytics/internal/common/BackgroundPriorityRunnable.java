package com.google.firebase.crashlytics.internal.common;

import android.os.Process;

public abstract class BackgroundPriorityRunnable implements Runnable {
    /* access modifiers changed from: protected */
    public abstract void a();

    public final void run() {
        Process.setThreadPriority(10);
        a();
    }
}
