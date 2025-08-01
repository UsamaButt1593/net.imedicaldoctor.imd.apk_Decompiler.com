package com.google.android.gms.common.util.concurrent;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.common.zzi;
import java.util.concurrent.Executor;

@KeepForSdk
public class HandlerExecutor implements Executor {
    private final Handler s;

    @KeepForSdk
    public HandlerExecutor(@NonNull Looper looper) {
        this.s = new zzi(looper);
    }

    public final void execute(@NonNull Runnable runnable) {
        this.s.post(runnable);
    }
}
