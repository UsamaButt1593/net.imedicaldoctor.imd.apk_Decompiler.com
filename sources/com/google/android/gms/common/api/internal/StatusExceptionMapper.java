package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;

@KeepForSdk
public interface StatusExceptionMapper {
    @NonNull
    @KeepForSdk
    Exception a(@NonNull Status status);
}
