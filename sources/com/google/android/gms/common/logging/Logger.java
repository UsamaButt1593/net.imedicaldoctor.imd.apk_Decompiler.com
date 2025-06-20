package com.google.android.gms.common.logging;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;

@KeepForSdk
public class Logger {

    /* renamed from: a  reason: collision with root package name */
    private final String f20332a;

    /* renamed from: b  reason: collision with root package name */
    private final String f20333b;

    /* renamed from: c  reason: collision with root package name */
    private final GmsLogger f20334c;

    /* renamed from: d  reason: collision with root package name */
    private final int f20335d;

    @KeepForSdk
    public Logger(@NonNull String str, @NonNull String... strArr) {
        String str2;
        if (r0 == 0) {
            str2 = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (String str3 : strArr) {
                if (sb.length() > 1) {
                    sb.append(",");
                }
                sb.append(str3);
            }
            sb.append("] ");
            str2 = sb.toString();
        }
        this.f20333b = str2;
        this.f20332a = str;
        this.f20334c = new GmsLogger(str);
        int i2 = 2;
        while (i2 <= 7 && !Log.isLoggable(this.f20332a, i2)) {
            i2++;
        }
        this.f20335d = i2;
    }

    @KeepForSdk
    public void a(@NonNull String str, @NonNull Object... objArr) {
        if (g(3)) {
            Log.d(this.f20332a, d(str, objArr));
        }
    }

    @KeepForSdk
    public void b(@NonNull String str, @NonNull Throwable th, @NonNull Object... objArr) {
        Log.e(this.f20332a, d(str, objArr), th);
    }

    @KeepForSdk
    public void c(@NonNull String str, @NonNull Object... objArr) {
        Log.e(this.f20332a, d(str, objArr));
    }

    /* access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public String d(@NonNull String str, @NonNull Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.f20333b.concat(str);
    }

    @NonNull
    @KeepForSdk
    public String e() {
        return this.f20332a;
    }

    @KeepForSdk
    public void f(@NonNull String str, @NonNull Object... objArr) {
        Log.i(this.f20332a, d(str, objArr));
    }

    @KeepForSdk
    public boolean g(int i2) {
        return this.f20335d <= i2;
    }

    @KeepForSdk
    public void h(@NonNull String str, @NonNull Throwable th, @NonNull Object... objArr) {
        if (g(2)) {
            Log.v(this.f20332a, d(str, objArr), th);
        }
    }

    @KeepForSdk
    public void i(@NonNull String str, @NonNull Object... objArr) {
        if (g(2)) {
            Log.v(this.f20332a, d(str, objArr));
        }
    }

    @KeepForSdk
    public void j(@NonNull String str, @NonNull Object... objArr) {
        Log.w(this.f20332a, d(str, objArr));
    }

    @KeepForSdk
    public void k(@NonNull String str, @NonNull Throwable th, @NonNull Object... objArr) {
        Log.wtf(this.f20332a, d(str, objArr), th);
    }

    @KeepForSdk
    public void l(@NonNull Throwable th) {
        Log.wtf(this.f20332a, th);
    }
}
