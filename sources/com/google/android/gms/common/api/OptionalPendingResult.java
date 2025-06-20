package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Result;

public abstract class OptionalPendingResult<R extends Result> extends PendingResult<R> {
    @NonNull
    public abstract R k();

    public abstract boolean l();
}
