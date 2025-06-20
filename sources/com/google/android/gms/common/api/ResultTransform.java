package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zacp;

public abstract class ResultTransform<R extends Result, S extends Result> {
    @NonNull
    public final PendingResult<S> a(@NonNull Status status) {
        return new zacp(status);
    }

    @NonNull
    public Status b(@NonNull Status status) {
        return status;
    }

    @WorkerThread
    @Nullable
    public abstract PendingResult<S> c(@NonNull R r);
}
