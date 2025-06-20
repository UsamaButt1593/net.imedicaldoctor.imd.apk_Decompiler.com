package com.google.android.datatransport.runtime.retries;

import androidx.annotation.Nullable;

public interface RetryStrategy<TInput, TResult> {
    @Nullable
    TInput a(TInput tinput, TResult tresult);
}
