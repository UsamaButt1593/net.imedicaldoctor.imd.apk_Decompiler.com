package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.TransformedResult;
import java.util.concurrent.TimeUnit;

@KeepForSdk
public abstract class PendingResultFacade<A extends Result, B extends Result> extends PendingResult<B> {
    public final void c(@NonNull PendingResult.StatusListener statusListener) {
        throw null;
    }

    @NonNull
    public final B d() {
        throw null;
    }

    @NonNull
    public final B e(long j2, @NonNull TimeUnit timeUnit) {
        throw null;
    }

    public final void f() {
        throw null;
    }

    public final boolean g() {
        throw null;
    }

    public final void h(@NonNull ResultCallback<? super B> resultCallback) {
        throw null;
    }

    public final void i(@NonNull ResultCallback<? super B> resultCallback, long j2, @NonNull TimeUnit timeUnit) {
        throw null;
    }

    @NonNull
    public final <S extends Result> TransformedResult<S> j(@NonNull ResultTransform<? super B, ? extends S> resultTransform) {
        throw null;
    }
}
