package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.TimeUnit;

public final class BatchResult implements Result {
    private final PendingResult<?>[] X;
    private final Status s;

    BatchResult(Status status, PendingResult<?>[] pendingResultArr) {
        this.s = status;
        this.X = pendingResultArr;
    }

    @NonNull
    public <R extends Result> R a(@NonNull BatchResultToken<R> batchResultToken) {
        Preconditions.b(batchResultToken.f19928a < this.X.length, "The result token does not belong to this batch");
        return this.X[batchResultToken.f19928a].e(0, TimeUnit.MILLISECONDS);
    }

    @NonNull
    public Status d() {
        return this.s;
    }
}
