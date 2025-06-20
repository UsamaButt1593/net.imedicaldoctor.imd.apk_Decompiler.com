package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;

public final class UnsupportedApiCallException extends UnsupportedOperationException {
    private final Feature s;

    @KeepForSdk
    public UnsupportedApiCallException(@NonNull Feature feature) {
        this.s = feature;
    }

    @NonNull
    public String getMessage() {
        return "Missing ".concat(String.valueOf(this.s));
    }
}
