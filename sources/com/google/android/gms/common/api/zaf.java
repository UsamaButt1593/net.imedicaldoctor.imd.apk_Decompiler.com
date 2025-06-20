package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BasePendingResult;

final class zaf<R extends Result> extends BasePendingResult<R> {
    private final R r;

    public zaf(R r2) {
        super(Looper.getMainLooper());
        this.r = r2;
    }

    /* access modifiers changed from: protected */
    public final R k(Status status) {
        if (status.I() == this.r.d().I()) {
            return this.r;
        }
        throw new UnsupportedOperationException("Creating failed results is not supported");
    }
}
