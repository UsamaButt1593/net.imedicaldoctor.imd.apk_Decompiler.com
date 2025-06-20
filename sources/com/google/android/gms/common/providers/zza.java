package com.google.android.gms.common.providers;

import com.google.android.gms.common.providers.PooledExecutorsProvider;
import com.google.android.gms.internal.common.zzh;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class zza implements PooledExecutorsProvider.PooledExecutorFactory {
    zza() {
    }

    public final ScheduledExecutorService a() {
        zzh.zza();
        return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
    }
}
