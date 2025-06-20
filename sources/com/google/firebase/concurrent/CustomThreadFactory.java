package com.google.firebase.concurrent;

import android.os.Process;
import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;

class CustomThreadFactory implements ThreadFactory {
    private static final ThreadFactory X2 = Executors.defaultThreadFactory();
    private final String X;
    private final int Y;
    private final StrictMode.ThreadPolicy Z;
    private final AtomicLong s = new AtomicLong();

    CustomThreadFactory(String str, int i2, @Nullable StrictMode.ThreadPolicy threadPolicy) {
        this.X = str;
        this.Y = i2;
        this.Z = threadPolicy;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(Runnable runnable) {
        Process.setThreadPriority(this.Y);
        StrictMode.ThreadPolicy threadPolicy = this.Z;
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        runnable.run();
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = X2.newThread(new C0483a(this, runnable));
        newThread.setName(String.format(Locale.ROOT, "%s Thread #%d", new Object[]{this.X, Long.valueOf(this.s.getAndIncrement())}));
        return newThread;
    }
}
