package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Result;

public abstract class TransformedResult<R extends Result> {
    public abstract void b(@NonNull ResultCallbacks<? super R> resultCallbacks);

    @NonNull
    public abstract <S extends Result> TransformedResult<S> c(@NonNull ResultTransform<? super R, ? extends S> resultTransform);
}
