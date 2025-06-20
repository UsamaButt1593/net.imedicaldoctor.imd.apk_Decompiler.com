package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.proto.Protobuf;

public final class GlobalMetrics {

    /* renamed from: b  reason: collision with root package name */
    private static final GlobalMetrics f19502b = new Builder().a();

    /* renamed from: a  reason: collision with root package name */
    private final StorageMetrics f19503a;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private StorageMetrics f19504a = null;

        Builder() {
        }

        public GlobalMetrics a() {
            return new GlobalMetrics(this.f19504a);
        }

        public Builder b(StorageMetrics storageMetrics) {
            this.f19504a = storageMetrics;
            return this;
        }
    }

    GlobalMetrics(StorageMetrics storageMetrics) {
        this.f19503a = storageMetrics;
    }

    public static GlobalMetrics a() {
        return f19502b;
    }

    public static Builder d() {
        return new Builder();
    }

    @Encodable.Ignore
    public StorageMetrics b() {
        StorageMetrics storageMetrics = this.f19503a;
        return storageMetrics == null ? StorageMetrics.b() : storageMetrics;
    }

    @Protobuf(tag = 1)
    @Encodable.Field(name = "storageMetrics")
    public StorageMetrics c() {
        return this.f19503a;
    }
}
