package com.google.android.gms.common.util.concurrent;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@KeepForSdk
public class NamedThreadFactory implements ThreadFactory {
    private final ThreadFactory X = Executors.defaultThreadFactory();
    private final String s;

    @KeepForSdk
    public NamedThreadFactory(@NonNull String str) {
        Preconditions.s(str, "Name must not be null");
        this.s = str;
    }

    @NonNull
    public final Thread newThread(@NonNull Runnable runnable) {
        Thread newThread = this.X.newThread(new zza(runnable, 0));
        newThread.setName(this.s);
        return newThread;
    }
}
