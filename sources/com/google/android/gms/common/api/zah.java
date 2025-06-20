package com.google.android.gms.common.api;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BasePendingResult;

final class zah<R extends Result> extends BasePendingResult<R> {
    public zah(@Nullable GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* access modifiers changed from: protected */
    public final R k(Status status) {
        throw new UnsupportedOperationException("Creating failed results is not supported");
    }
}
