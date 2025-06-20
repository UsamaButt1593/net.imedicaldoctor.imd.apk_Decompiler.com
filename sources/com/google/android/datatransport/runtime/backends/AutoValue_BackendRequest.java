package com.google.android.datatransport.runtime.backends;

import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import java.util.Arrays;

final class AutoValue_BackendRequest extends BackendRequest {

    /* renamed from: a  reason: collision with root package name */
    private final Iterable<EventInternal> f19461a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f19462b;

    static final class Builder extends BackendRequest.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Iterable<EventInternal> f19463a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f19464b;

        Builder() {
        }

        public BackendRequest a() {
            String str = "";
            if (this.f19463a == null) {
                str = str + " events";
            }
            if (str.isEmpty()) {
                return new AutoValue_BackendRequest(this.f19463a, this.f19464b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public BackendRequest.Builder b(Iterable<EventInternal> iterable) {
            if (iterable != null) {
                this.f19463a = iterable;
                return this;
            }
            throw new NullPointerException("Null events");
        }

        public BackendRequest.Builder c(@Nullable byte[] bArr) {
            this.f19464b = bArr;
            return this;
        }
    }

    private AutoValue_BackendRequest(Iterable<EventInternal> iterable, @Nullable byte[] bArr) {
        this.f19461a = iterable;
        this.f19462b = bArr;
    }

    public Iterable<EventInternal> c() {
        return this.f19461a;
    }

    @Nullable
    public byte[] d() {
        return this.f19462b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendRequest)) {
            return false;
        }
        BackendRequest backendRequest = (BackendRequest) obj;
        if (this.f19461a.equals(backendRequest.c())) {
            if (Arrays.equals(this.f19462b, backendRequest instanceof AutoValue_BackendRequest ? ((AutoValue_BackendRequest) backendRequest).f19462b : backendRequest.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f19461a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f19462b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f19461a + ", extras=" + Arrays.toString(this.f19462b) + "}";
    }
}
