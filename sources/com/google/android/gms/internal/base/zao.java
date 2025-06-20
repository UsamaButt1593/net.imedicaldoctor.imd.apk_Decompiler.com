package com.google.android.gms.internal.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class zao implements zam {
    private zao() {
    }

    public final ExecutorService zaa(ThreadFactory threadFactory, int i2) {
        return zac(1, threadFactory, 1);
    }

    public final ExecutorService zab(int i2, int i3) {
        return zac(4, Executors.defaultThreadFactory(), 2);
    }

    public final ExecutorService zac(int i2, ThreadFactory threadFactory, int i3) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    /* synthetic */ zao(zan zan) {
    }
}
