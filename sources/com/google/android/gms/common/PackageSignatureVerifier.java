package com.google.android.gms.common;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.RestrictedInheritance;

@RestrictedInheritance(allowedOnPath = ".*javatests.*/com/google/android/gms/common/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
@ShowFirstParty
@KeepForSdk
@CheckReturnValue
public class PackageSignatureVerifier {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private static zzad f19897a;
    @VisibleForTesting
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    static volatile zzac f19898b;

    private static zzad c(Context context) {
        zzad zzad;
        synchronized (PackageSignatureVerifier.class) {
            try {
                if (f19897a == null) {
                    f19897a = new zzad(context);
                }
                zzad = f19897a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzad;
    }

    @ShowFirstParty
    @NonNull
    @KeepForSdk
    public PackageVerificationResult a(@NonNull Context context, @NonNull String str) {
        boolean k2 = GooglePlayServicesUtilLight.k(context);
        c(context);
        if (zzn.f()) {
            String concat = String.valueOf(str).concat(true != k2 ? "-0" : "-1");
            if (f19898b == null || !f19898b.f20419a.equals(concat)) {
                c(context);
                zzx c2 = zzn.c(str, k2, false, false);
                if (c2.f20435a) {
                    f19898b = new zzac(concat, PackageVerificationResult.d(str, c2.f20438d));
                } else {
                    Preconditions.r(c2.f20436b);
                    return PackageVerificationResult.a(str, c2.f20436b, c2.f20437c);
                }
            }
            return f19898b.f20420b;
        }
        throw new zzae();
    }

    @ShowFirstParty
    @NonNull
    @KeepForSdk
    public PackageVerificationResult b(@NonNull Context context, @NonNull String str) {
        try {
            PackageVerificationResult a2 = a(context, str);
            a2.b();
            return a2;
        } catch (SecurityException e2) {
            PackageVerificationResult a3 = a(context, str);
            if (!a3.c()) {
                return a3;
            }
            Log.e("PkgSignatureVerifier", "Got flaky result during package signature verification", e2);
            return a3;
        }
    }
}
