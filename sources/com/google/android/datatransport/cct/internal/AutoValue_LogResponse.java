package com.google.android.datatransport.cct.internal;

final class AutoValue_LogResponse extends LogResponse {

    /* renamed from: b  reason: collision with root package name */
    private final long f19368b;

    AutoValue_LogResponse(long j2) {
        this.f19368b = j2;
    }

    public long c() {
        return this.f19368b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof LogResponse) && this.f19368b == ((LogResponse) obj).c();
    }

    public int hashCode() {
        long j2 = this.f19368b;
        return 1000003 ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f19368b + "}";
    }
}
