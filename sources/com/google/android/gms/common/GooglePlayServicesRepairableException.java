package com.google.android.gms.common;

import android.content.Intent;
import androidx.annotation.NonNull;

public class GooglePlayServicesRepairableException extends UserRecoverableException {
    private final int X;

    public GooglePlayServicesRepairableException(int i2, @NonNull String str, @NonNull Intent intent) {
        super(str, intent);
        this.X = i2;
    }

    public int b() {
        return this.X;
    }
}
