package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;

@KeepForSdk
@Deprecated
public class WakeLockTracker {

    /* renamed from: a  reason: collision with root package name */
    private static final WakeLockTracker f20358a = new WakeLockTracker();

    @NonNull
    @KeepForSdk
    public static WakeLockTracker a() {
        return f20358a;
    }

    @KeepForSdk
    public void b(@NonNull Context context, @NonNull Intent intent, @NonNull String str, @NonNull String str2, @NonNull String str3, int i2, @NonNull String str4) {
    }

    @KeepForSdk
    public void c(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull String str3, int i2, @NonNull List<String> list, boolean z, long j2) {
    }

    @KeepForSdk
    public void d(@NonNull Context context, @NonNull String str, int i2, @NonNull String str2, @NonNull String str3, @NonNull String str4, int i3, @NonNull List<String> list) {
    }

    @KeepForSdk
    public void e(@NonNull Context context, @NonNull String str, int i2, @NonNull String str2, @NonNull String str3, @NonNull String str4, int i3, @NonNull List<String> list, long j2) {
    }

    @KeepForSdk
    public void f(@NonNull Context context, @NonNull Intent intent) {
    }
}
