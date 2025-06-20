package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.os.SystemClock;

public final class LogTime {

    /* renamed from: a  reason: collision with root package name */
    private static final double f18531a = (1.0d / Math.pow(10.0d, 6.0d));

    private LogTime() {
    }

    public static double a(long j2) {
        return ((double) (b() - j2)) * f18531a;
    }

    @TargetApi(17)
    public static long b() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
