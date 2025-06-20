package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.TransformedResult;
import java.util.concurrent.TimeUnit;

@KeepForSdk
public final class OptionalPendingResultImpl<R extends Result> extends OptionalPendingResult<R> {

    /* renamed from: a  reason: collision with root package name */
    private final BasePendingResult<R> f20012a;

    public OptionalPendingResultImpl(@NonNull PendingResult<R> pendingResult) {
        this.f20012a = (BasePendingResult) pendingResult;
    }

    public final void c(@NonNull PendingResult.StatusListener statusListener) {
        this.f20012a.c(statusListener);
    }

    @NonNull
    public final R d() {
        return this.f20012a.d();
    }

    @NonNull
    public final R e(long j2, @NonNull TimeUnit timeUnit) {
        return this.f20012a.e(j2, timeUnit);
    }

    public final void f() {
        this.f20012a.f();
    }

    public final boolean g() {
        return this.f20012a.g();
    }

    public final void h(@NonNull ResultCallback<? super R> resultCallback) {
        this.f20012a.h(resultCallback);
    }

    public final void i(@NonNull ResultCallback<? super R> resultCallback, long j2, @NonNull TimeUnit timeUnit) {
        this.f20012a.i(resultCallback, j2, timeUnit);
    }

    @NonNull
    public final <S extends Result> TransformedResult<S> j(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        return this.f20012a.j(resultTransform);
    }

    @NonNull
    public final R k() {
        if (this.f20012a.m()) {
            return this.f20012a.e(0, TimeUnit.MILLISECONDS);
        }
        throw new IllegalStateException("Result is not available. Check that isDone() returns true before calling get().");
    }

    public final boolean l() {
        return this.f20012a.m();
    }
}
