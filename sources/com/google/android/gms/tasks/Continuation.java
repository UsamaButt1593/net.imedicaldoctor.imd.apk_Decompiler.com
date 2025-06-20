package com.google.android.gms.tasks;

import androidx.annotation.NonNull;

public interface Continuation<TResult, TContinuationResult> {
    TContinuationResult a(@NonNull Task<TResult> task) throws Exception;
}
