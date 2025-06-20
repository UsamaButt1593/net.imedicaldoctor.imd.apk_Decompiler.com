package com.google.android.gms.common.wrappers;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class Wrappers {

    /* renamed from: b  reason: collision with root package name */
    private static final Wrappers f20410b = new Wrappers();
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private PackageManagerWrapper f20411a = null;

    @NonNull
    @KeepForSdk
    public static PackageManagerWrapper a(@NonNull Context context) {
        return f20410b.b(context);
    }

    @VisibleForTesting
    @NonNull
    public final synchronized PackageManagerWrapper b(@NonNull Context context) {
        try {
            if (this.f20411a == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                this.f20411a = new PackageManagerWrapper(context);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.f20411a;
    }
}
