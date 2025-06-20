package com.google.firebase;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;

@KeepForSdk
public class FirebaseExceptionMapper implements StatusExceptionMapper {
    @NonNull
    public final Exception a(@NonNull Status status) {
        return status.I() == 8 ? new FirebaseException(status.W()) : new FirebaseApiNotAvailableException(status.W());
    }
}
