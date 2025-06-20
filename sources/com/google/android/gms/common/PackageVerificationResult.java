package com.google.android.gms.common;

import androidx.annotation.NonNull;
import com.google.errorprone.annotations.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
public class PackageVerificationResult {

    /* renamed from: a  reason: collision with root package name */
    private final String f19899a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f19900b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final String f19901c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final Throwable f19902d;

    private PackageVerificationResult(String str, int i2, boolean z, @Nullable String str2, @Nullable Throwable th) {
        this.f19899a = str;
        this.f19900b = z;
        this.f19901c = str2;
        this.f19902d = th;
    }

    @NonNull
    public static PackageVerificationResult a(@NonNull String str, @NonNull String str2, @Nullable Throwable th) {
        return new PackageVerificationResult(str, 1, false, str2, th);
    }

    @NonNull
    public static PackageVerificationResult d(@NonNull String str, int i2) {
        return new PackageVerificationResult(str, i2, true, (String) null, (Throwable) null);
    }

    public final void b() {
        if (!this.f19900b) {
            String str = this.f19901c;
            Throwable th = this.f19902d;
            String concat = "PackageVerificationRslt: ".concat(String.valueOf(str));
            if (th != null) {
                throw new SecurityException(concat, th);
            }
            throw new SecurityException(concat);
        }
    }

    public final boolean c() {
        return this.f19900b;
    }
}
