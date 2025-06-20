package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig;

final class AutoValue_EventStoreConfig extends EventStoreConfig {

    /* renamed from: g  reason: collision with root package name */
    private final long f19628g;

    /* renamed from: h  reason: collision with root package name */
    private final int f19629h;

    /* renamed from: i  reason: collision with root package name */
    private final int f19630i;

    /* renamed from: j  reason: collision with root package name */
    private final long f19631j;

    /* renamed from: k  reason: collision with root package name */
    private final int f19632k;

    static final class Builder extends EventStoreConfig.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Long f19633a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f19634b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f19635c;

        /* renamed from: d  reason: collision with root package name */
        private Long f19636d;

        /* renamed from: e  reason: collision with root package name */
        private Integer f19637e;

        Builder() {
        }

        /* access modifiers changed from: package-private */
        public EventStoreConfig a() {
            String str = "";
            if (this.f19633a == null) {
                str = str + " maxStorageSizeInBytes";
            }
            if (this.f19634b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f19635c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f19636d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f19637e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new AutoValue_EventStoreConfig(this.f19633a.longValue(), this.f19634b.intValue(), this.f19635c.intValue(), this.f19636d.longValue(), this.f19637e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* access modifiers changed from: package-private */
        public EventStoreConfig.Builder b(int i2) {
            this.f19635c = Integer.valueOf(i2);
            return this;
        }

        /* access modifiers changed from: package-private */
        public EventStoreConfig.Builder c(long j2) {
            this.f19636d = Long.valueOf(j2);
            return this;
        }

        /* access modifiers changed from: package-private */
        public EventStoreConfig.Builder d(int i2) {
            this.f19634b = Integer.valueOf(i2);
            return this;
        }

        /* access modifiers changed from: package-private */
        public EventStoreConfig.Builder e(int i2) {
            this.f19637e = Integer.valueOf(i2);
            return this;
        }

        /* access modifiers changed from: package-private */
        public EventStoreConfig.Builder f(long j2) {
            this.f19633a = Long.valueOf(j2);
            return this;
        }
    }

    private AutoValue_EventStoreConfig(long j2, int i2, int i3, long j3, int i4) {
        this.f19628g = j2;
        this.f19629h = i2;
        this.f19630i = i3;
        this.f19631j = j3;
        this.f19632k = i4;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f19630i;
    }

    /* access modifiers changed from: package-private */
    public long c() {
        return this.f19631j;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f19629h;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f19632k;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventStoreConfig)) {
            return false;
        }
        EventStoreConfig eventStoreConfig = (EventStoreConfig) obj;
        return this.f19628g == eventStoreConfig.f() && this.f19629h == eventStoreConfig.d() && this.f19630i == eventStoreConfig.b() && this.f19631j == eventStoreConfig.c() && this.f19632k == eventStoreConfig.e();
    }

    /* access modifiers changed from: package-private */
    public long f() {
        return this.f19628g;
    }

    public int hashCode() {
        long j2 = this.f19628g;
        long j3 = this.f19631j;
        return this.f19632k ^ ((((((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ this.f19629h) * 1000003) ^ this.f19630i) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003);
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f19628g + ", loadBatchSize=" + this.f19629h + ", criticalSectionEnterTimeoutMs=" + this.f19630i + ", eventCleanUpAge=" + this.f19631j + ", maxBlobByteSizePerRow=" + this.f19632k + "}";
    }
}
