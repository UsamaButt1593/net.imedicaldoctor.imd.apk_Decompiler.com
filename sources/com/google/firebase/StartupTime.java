package com.google.firebase;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class StartupTime {
    @NonNull
    public static StartupTime a(long j2, long j3, long j4) {
        return new AutoValue_StartupTime(j2, j3, j4);
    }

    @NonNull
    public static StartupTime e() {
        return a(System.currentTimeMillis(), SystemClock.elapsedRealtime(), SystemClock.uptimeMillis());
    }

    public abstract long b();

    public abstract long c();

    public abstract long d();
}
