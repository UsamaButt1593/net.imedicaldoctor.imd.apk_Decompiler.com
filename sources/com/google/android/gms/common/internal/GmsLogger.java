package com.google.android.gms.common.internal;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.FormatMethod;
import com.google.errorprone.annotations.FormatString;

@KeepForSdk
public final class GmsLogger {

    /* renamed from: a  reason: collision with root package name */
    private final String f20246a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final String f20247b;

    @KeepForSdk
    public GmsLogger(@NonNull String str) {
        this(str, (String) null);
    }

    private final String r(String str) {
        String str2 = this.f20247b;
        return str2 == null ? str : str2.concat(str);
    }

    @FormatMethod
    private final String s(String str, Object... objArr) {
        String str2 = this.f20247b;
        String format = String.format(str, objArr);
        return str2 == null ? format : str2.concat(format);
    }

    @KeepForSdk
    public boolean a(int i2) {
        return Log.isLoggable(this.f20246a, i2);
    }

    @KeepForSdk
    public boolean b() {
        return false;
    }

    @KeepForSdk
    public void c(@NonNull String str, @NonNull String str2) {
        if (a(3)) {
            Log.d(str, r(str2));
        }
    }

    @KeepForSdk
    public void d(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (a(3)) {
            Log.d(str, r(str2), th);
        }
    }

    @KeepForSdk
    public void e(@NonNull String str, @NonNull String str2) {
        if (a(6)) {
            Log.e(str, r(str2));
        }
    }

    @KeepForSdk
    public void f(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (a(6)) {
            Log.e(str, r(str2), th);
        }
    }

    @FormatMethod
    @KeepForSdk
    public void g(@NonNull String str, @FormatString @NonNull String str2, @NonNull Object... objArr) {
        if (a(6)) {
            Log.e(str, s(str2, objArr));
        }
    }

    @KeepForSdk
    public void h(@NonNull String str, @NonNull String str2) {
        if (a(4)) {
            Log.i(str, r(str2));
        }
    }

    @KeepForSdk
    public void i(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (a(4)) {
            Log.i(str, r(str2), th);
        }
    }

    @KeepForSdk
    public void j(@NonNull String str, @NonNull String str2) {
    }

    @KeepForSdk
    public void k(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
    }

    @KeepForSdk
    public void l(@NonNull String str, @NonNull String str2) {
        if (a(2)) {
            Log.v(str, r(str2));
        }
    }

    @KeepForSdk
    public void m(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (a(2)) {
            Log.v(str, r(str2), th);
        }
    }

    @KeepForSdk
    public void n(@NonNull String str, @NonNull String str2) {
        if (a(5)) {
            Log.w(str, r(str2));
        }
    }

    @KeepForSdk
    public void o(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (a(5)) {
            Log.w(str, r(str2), th);
        }
    }

    @FormatMethod
    @KeepForSdk
    public void p(@NonNull String str, @FormatString @NonNull String str2, @NonNull Object... objArr) {
        if (a(5)) {
            Log.w(this.f20246a, s(str2, objArr));
        }
    }

    @KeepForSdk
    public void q(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (a(7)) {
            Log.e(str, r(str2), th);
            Log.wtf(str, r(str2), th);
        }
    }

    @KeepForSdk
    public GmsLogger(@NonNull String str, @Nullable String str2) {
        Preconditions.s(str, "log tag cannot be null");
        Preconditions.c(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.f20246a = str;
        this.f20247b = (str2 == null || str2.length() <= 0) ? null : str2;
    }
}
