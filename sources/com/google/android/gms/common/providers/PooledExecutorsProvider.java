package com.google.android.gms.common.providers;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ScheduledExecutorService;

@KeepForSdk
@Deprecated
public class PooledExecutorsProvider {

    /* renamed from: a  reason: collision with root package name */
    private static PooledExecutorFactory f20336a;

    public interface PooledExecutorFactory {
        @NonNull
        @KeepForSdk
        @Deprecated
        ScheduledExecutorService a();
    }

    private PooledExecutorsProvider() {
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static synchronized PooledExecutorFactory a() {
        PooledExecutorFactory pooledExecutorFactory;
        synchronized (PooledExecutorsProvider.class) {
            try {
                if (f20336a == null) {
                    f20336a = new zza();
                }
                pooledExecutorFactory = f20336a;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return pooledExecutorFactory;
    }
}
