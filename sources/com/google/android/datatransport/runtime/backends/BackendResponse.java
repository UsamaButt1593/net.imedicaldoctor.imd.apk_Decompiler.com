package com.google.android.datatransport.runtime.backends;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class BackendResponse {

    public enum Status {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR,
        INVALID_PAYLOAD
    }

    public static BackendResponse a() {
        return new AutoValue_BackendResponse(Status.FATAL_ERROR, -1);
    }

    public static BackendResponse d() {
        return new AutoValue_BackendResponse(Status.INVALID_PAYLOAD, -1);
    }

    public static BackendResponse e(long j2) {
        return new AutoValue_BackendResponse(Status.OK, j2);
    }

    public static BackendResponse f() {
        return new AutoValue_BackendResponse(Status.TRANSIENT_ERROR, -1);
    }

    public abstract long b();

    public abstract Status c();
}
