package com.google.android.gms.common.api;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.OptionalPendingResultImpl;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;

public final class PendingResults {
    @KeepForSdk
    private PendingResults() {
    }

    @NonNull
    public static PendingResult<Status> a() {
        StatusPendingResult statusPendingResult = new StatusPendingResult(Looper.getMainLooper());
        statusPendingResult.f();
        return statusPendingResult;
    }

    @NonNull
    public static <R extends Result> PendingResult<R> b(@NonNull R r) {
        Preconditions.s(r, "Result must not be null");
        Preconditions.b(r.d().I() == 16, "Status code must be CommonStatusCodes.CANCELED");
        zaf zaf = new zaf(r);
        zaf.f();
        return zaf;
    }

    @NonNull
    @KeepForSdk
    public static <R extends Result> PendingResult<R> c(@NonNull R r, @NonNull GoogleApiClient googleApiClient) {
        Preconditions.s(r, "Result must not be null");
        Preconditions.b(!r.d().R(), "Status code must not be SUCCESS");
        zag zag = new zag(googleApiClient, r);
        zag.o(r);
        return zag;
    }

    @NonNull
    @KeepForSdk
    public static <R extends Result> OptionalPendingResult<R> d(@NonNull R r) {
        Preconditions.s(r, "Result must not be null");
        zah zah = new zah((GoogleApiClient) null);
        zah.o(r);
        return new OptionalPendingResultImpl(zah);
    }

    @NonNull
    @KeepForSdk
    public static <R extends Result> OptionalPendingResult<R> e(@NonNull R r, @NonNull GoogleApiClient googleApiClient) {
        Preconditions.s(r, "Result must not be null");
        zah zah = new zah(googleApiClient);
        zah.o(r);
        return new OptionalPendingResultImpl(zah);
    }

    @NonNull
    @KeepForSdk
    public static PendingResult<Status> f(@NonNull Status status) {
        Preconditions.s(status, "Result must not be null");
        StatusPendingResult statusPendingResult = new StatusPendingResult(Looper.getMainLooper());
        statusPendingResult.o(status);
        return statusPendingResult;
    }

    @NonNull
    @KeepForSdk
    public static PendingResult<Status> g(@NonNull Status status, @NonNull GoogleApiClient googleApiClient) {
        Preconditions.s(status, "Result must not be null");
        StatusPendingResult statusPendingResult = new StatusPendingResult(googleApiClient);
        statusPendingResult.o(status);
        return statusPendingResult;
    }
}
