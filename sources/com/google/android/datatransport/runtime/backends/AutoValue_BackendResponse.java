package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.BackendResponse;

final class AutoValue_BackendResponse extends BackendResponse {

    /* renamed from: a  reason: collision with root package name */
    private final BackendResponse.Status f19465a;

    /* renamed from: b  reason: collision with root package name */
    private final long f19466b;

    AutoValue_BackendResponse(BackendResponse.Status status, long j2) {
        if (status != null) {
            this.f19465a = status;
            this.f19466b = j2;
            return;
        }
        throw new NullPointerException("Null status");
    }

    public long b() {
        return this.f19466b;
    }

    public BackendResponse.Status c() {
        return this.f19465a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendResponse)) {
            return false;
        }
        BackendResponse backendResponse = (BackendResponse) obj;
        return this.f19465a.equals(backendResponse.c()) && this.f19466b == backendResponse.b();
    }

    public int hashCode() {
        long j2 = this.f19466b;
        return ((this.f19465a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.f19465a + ", nextRequestWaitMillis=" + this.f19466b + "}";
    }
}
