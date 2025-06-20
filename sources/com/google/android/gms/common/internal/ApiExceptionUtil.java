package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;

@KeepForSdk
public class ApiExceptionUtil {
    @NonNull
    @KeepForSdk
    public static ApiException a(@NonNull Status status) {
        return status.O() ? new ResolvableApiException(status) : new ApiException(status);
    }
}
