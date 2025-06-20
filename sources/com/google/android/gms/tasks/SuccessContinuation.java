package com.google.android.gms.tasks;

import androidx.annotation.NonNull;

public interface SuccessContinuation<TResult, TContinuationResult> {
    @NonNull
    Task<TContinuationResult> a(TResult tresult) throws Exception;
}
