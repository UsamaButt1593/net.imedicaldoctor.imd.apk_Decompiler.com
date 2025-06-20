package com.google.android.gms.common;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.errorprone.annotations.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
class zzx {

    /* renamed from: e  reason: collision with root package name */
    private static final zzx f20434e = new zzx(true, 3, 1, (String) null, (Throwable) null);

    /* renamed from: a  reason: collision with root package name */
    final boolean f20435a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    final String f20436b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    final Throwable f20437c;

    /* renamed from: d  reason: collision with root package name */
    final int f20438d;

    private zzx(boolean z, int i2, int i3, @Nullable String str, @Nullable Throwable th) {
        this.f20435a = z;
        this.f20438d = i2;
        this.f20436b = str;
        this.f20437c = th;
    }

    @Deprecated
    static zzx b() {
        return f20434e;
    }

    static zzx c(@NonNull String str) {
        return new zzx(false, 1, 5, str, (Throwable) null);
    }

    static zzx d(@NonNull String str, @NonNull Throwable th) {
        return new zzx(false, 1, 5, str, th);
    }

    static zzx f(int i2) {
        return new zzx(true, i2, 1, (String) null, (Throwable) null);
    }

    static zzx g(int i2, int i3, @NonNull String str, @Nullable Throwable th) {
        return new zzx(false, i2, i3, str, th);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public String a() {
        return this.f20436b;
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        if (!this.f20435a && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            if (this.f20437c != null) {
                Log.d("GoogleCertificatesRslt", a(), this.f20437c);
            } else {
                Log.d("GoogleCertificatesRslt", a());
            }
        }
    }

    /* synthetic */ zzx(boolean z, int i2, int i3, String str, Throwable th, zzw zzw) {
        this(false, 1, 5, (String) null, (Throwable) null);
    }
}
