package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.R;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.internal.zzah;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import com.google.errorprone.annotations.concurrent.GuardedBy;

@KeepForSdk
@Deprecated
public final class GoogleServices {

    /* renamed from: e  reason: collision with root package name */
    private static final Object f19999e = new Object();
    @Nullable
    @GuardedBy("lock")

    /* renamed from: f  reason: collision with root package name */
    private static GoogleServices f20000f;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final String f20001a;

    /* renamed from: b  reason: collision with root package name */
    private final Status f20002b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f20003c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f20004d;

    @VisibleForTesting
    @KeepForSdk
    GoogleServices(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", TypedValues.Custom.f3949b, resources.getResourcePackageName(R.string.f19905a));
        boolean z = true;
        if (identifier != 0) {
            int integer = resources.getInteger(identifier);
            boolean z2 = integer == 0;
            z = integer == 0 ? false : z;
            this.f20004d = z2;
        } else {
            this.f20004d = false;
        }
        this.f20003c = z;
        String b2 = zzah.b(context);
        b2 = b2 == null ? new StringResourceValueReader(context).a("google_app_id") : b2;
        if (TextUtils.isEmpty(b2)) {
            this.f20002b = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.f20001a = null;
            return;
        }
        this.f20001a = b2;
        this.f20002b = Status.Y2;
    }

    @KeepForSdk
    private static GoogleServices b(String str) {
        GoogleServices googleServices;
        synchronized (f19999e) {
            try {
                googleServices = f20000f;
                if (googleServices == null) {
                    throw new IllegalStateException("Initialize must be called before " + str + ".");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return googleServices;
    }

    @VisibleForTesting
    @KeepForSdk
    static void c() {
        synchronized (f19999e) {
            f20000f = null;
        }
    }

    @KeepForSdk
    @Nullable
    public static String d() {
        return b("getGoogleAppId").f20001a;
    }

    @NonNull
    @KeepForSdk
    public static Status e(@NonNull Context context) {
        Status status;
        Preconditions.s(context, "Context must not be null.");
        synchronized (f19999e) {
            try {
                if (f20000f == null) {
                    f20000f = new GoogleServices(context);
                }
                status = f20000f.f20002b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return status;
    }

    @ResultIgnorabilityUnspecified
    @NonNull
    @KeepForSdk
    public static Status f(@NonNull Context context, @NonNull String str, boolean z) {
        Preconditions.s(context, "Context must not be null.");
        Preconditions.m(str, "App ID must be nonempty.");
        synchronized (f19999e) {
            try {
                GoogleServices googleServices = f20000f;
                if (googleServices != null) {
                    Status a2 = googleServices.a(str);
                    return a2;
                }
                GoogleServices googleServices2 = new GoogleServices(str, z);
                f20000f = googleServices2;
                Status status = googleServices2.f20002b;
                return status;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @KeepForSdk
    public static boolean g() {
        GoogleServices b2 = b("isMeasurementEnabled");
        return b2.f20002b.R() && b2.f20003c;
    }

    @KeepForSdk
    public static boolean h() {
        return b("isMeasurementExplicitlyDisabled").f20004d;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @KeepForSdk
    public Status a(String str) {
        String str2 = this.f20001a;
        if (str2 == null || str2.equals(str)) {
            return Status.Y2;
        }
        String str3 = this.f20001a;
        return new Status(10, "Initialize was called with two different Google App IDs.  Only the first app ID will be used: '" + str3 + "'.");
    }

    @VisibleForTesting
    @KeepForSdk
    GoogleServices(String str, boolean z) {
        this.f20001a = str;
        this.f20002b = Status.Y2;
        this.f20003c = z;
        this.f20004d = !z;
    }
}
