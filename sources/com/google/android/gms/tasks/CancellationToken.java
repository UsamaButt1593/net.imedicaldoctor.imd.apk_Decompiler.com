package com.google.android.gms.tasks;

import androidx.annotation.NonNull;

public abstract class CancellationToken {
    public abstract boolean a();

    @NonNull
    public abstract CancellationToken b(@NonNull OnTokenCanceledListener onTokenCanceledListener);
}
