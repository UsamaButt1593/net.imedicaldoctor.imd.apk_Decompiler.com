package com.google.android.gms.common.util;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class DefaultClock implements Clock {

    /* renamed from: a  reason: collision with root package name */
    private static final DefaultClock f20361a = new DefaultClock();

    private DefaultClock() {
    }

    @NonNull
    @KeepForSdk
    public static Clock e() {
        return f20361a;
    }

    public final long a() {
        return System.currentTimeMillis();
    }

    public final long b() {
        return SystemClock.elapsedRealtime();
    }

    public final long c() {
        return System.nanoTime();
    }

    public final long d() {
        return SystemClock.currentThreadTimeMillis();
    }
}
