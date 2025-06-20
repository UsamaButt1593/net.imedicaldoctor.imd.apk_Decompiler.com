package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.Protobuf;

public final class StorageMetrics {

    /* renamed from: c  reason: collision with root package name */
    private static final StorageMetrics f19515c = new Builder().a();

    /* renamed from: a  reason: collision with root package name */
    private final long f19516a;

    /* renamed from: b  reason: collision with root package name */
    private final long f19517b;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private long f19518a = 0;

        /* renamed from: b  reason: collision with root package name */
        private long f19519b = 0;

        Builder() {
        }

        public StorageMetrics a() {
            return new StorageMetrics(this.f19518a, this.f19519b);
        }

        public Builder b(long j2) {
            this.f19518a = j2;
            return this;
        }

        public Builder c(long j2) {
            this.f19519b = j2;
            return this;
        }
    }

    StorageMetrics(long j2, long j3) {
        this.f19516a = j2;
        this.f19517b = j3;
    }

    public static StorageMetrics b() {
        return f19515c;
    }

    public static Builder d() {
        return new Builder();
    }

    @Protobuf(tag = 1)
    public long a() {
        return this.f19516a;
    }

    @Protobuf(tag = 2)
    public long c() {
        return this.f19517b;
    }
}
