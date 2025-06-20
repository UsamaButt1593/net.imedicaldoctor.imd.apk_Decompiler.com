package com.google.android.gms.common;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public class GooglePlayServicesManifestException extends IllegalStateException {
    private final int s;

    public GooglePlayServicesManifestException(int i2, @NonNull String str) {
        super(str);
        this.s = i2;
    }

    public int a() {
        return this.s;
    }

    public int b() {
        return GoogleApiAvailabilityLight.f19873a;
    }
}
