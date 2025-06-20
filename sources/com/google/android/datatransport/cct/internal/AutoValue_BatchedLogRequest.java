package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

final class AutoValue_BatchedLogRequest extends BatchedLogRequest {

    /* renamed from: a  reason: collision with root package name */
    private final List<LogRequest> f19319a;

    AutoValue_BatchedLogRequest(List<LogRequest> list) {
        if (list != null) {
            this.f19319a = list;
            return;
        }
        throw new NullPointerException("Null logRequests");
    }

    @NonNull
    @Encodable.Field(name = "logRequest")
    public List<LogRequest> c() {
        return this.f19319a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BatchedLogRequest) {
            return this.f19319a.equals(((BatchedLogRequest) obj).c());
        }
        return false;
    }

    public int hashCode() {
        return this.f19319a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.f19319a + "}";
    }
}
