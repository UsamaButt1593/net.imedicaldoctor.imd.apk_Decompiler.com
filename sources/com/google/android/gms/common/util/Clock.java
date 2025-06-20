package com.google.android.gms.common.util;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
@KeepForSdk
public interface Clock {

    /* renamed from: com.google.android.gms.common.util.Clock$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        @KeepForSdk
        public static long a(@NonNull Clock clock) {
            return SystemClock.currentThreadTimeMillis();
        }
    }

    @KeepForSdk
    long a();

    @KeepForSdk
    long b();

    @KeepForSdk
    long c();

    @KeepForSdk
    long d();
}
