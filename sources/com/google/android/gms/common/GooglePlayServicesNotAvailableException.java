package com.google.android.gms.common;

public final class GooglePlayServicesNotAvailableException extends Exception {
    public final int s;

    public GooglePlayServicesNotAvailableException(int i2) {
        this.s = i2;
    }
}
