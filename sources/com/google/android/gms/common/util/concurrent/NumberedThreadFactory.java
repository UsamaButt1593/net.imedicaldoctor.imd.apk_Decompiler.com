package com.google.android.gms.common.util.concurrent;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@KeepForSdk
public class NumberedThreadFactory implements ThreadFactory {
    private final AtomicInteger X = new AtomicInteger();
    private final ThreadFactory Y = Executors.defaultThreadFactory();
    private final String s;

    @KeepForSdk
    public NumberedThreadFactory(@NonNull String str) {
        Preconditions.s(str, "Name must not be null");
        this.s = str;
    }

    @NonNull
    public final Thread newThread(@NonNull Runnable runnable) {
        Thread newThread = this.Y.newThread(new zza(runnable, 0));
        int andIncrement = this.X.getAndIncrement();
        newThread.setName(this.s + "[" + andIncrement + "]");
        return newThread;
    }
}
