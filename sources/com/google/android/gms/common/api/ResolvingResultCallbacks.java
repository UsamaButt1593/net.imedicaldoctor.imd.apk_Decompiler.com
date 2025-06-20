package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.IntentSender;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.Preconditions;

public abstract class ResolvingResultCallbacks<R extends Result> extends ResultCallbacks<R> {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f19978a;

    /* renamed from: b  reason: collision with root package name */
    private final int f19979b;

    protected ResolvingResultCallbacks(@NonNull Activity activity, int i2) {
        Preconditions.s(activity, "Activity must not be null");
        this.f19978a = activity;
        this.f19979b = i2;
    }

    @KeepForSdk
    public final void b(@NonNull Status status) {
        if (status.O()) {
            try {
                status.S(this.f19978a, this.f19979b);
            } catch (IntentSender.SendIntentException e2) {
                Log.e("ResolvingResultCallback", "Failed to start resolution", e2);
                d(new Status(8));
            }
        } else {
            d(status);
        }
    }

    public abstract void c(@NonNull R r);

    public abstract void d(@NonNull Status status);
}
