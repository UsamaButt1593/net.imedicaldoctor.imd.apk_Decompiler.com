package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BasePendingResult;

final class zag<R extends Result> extends BasePendingResult<R> {
    private final R r;

    public zag(GoogleApiClient googleApiClient, R r2) {
        super(googleApiClient);
        this.r = r2;
    }

    /* access modifiers changed from: protected */
    public final R k(Status status) {
        return this.r;
    }
}
