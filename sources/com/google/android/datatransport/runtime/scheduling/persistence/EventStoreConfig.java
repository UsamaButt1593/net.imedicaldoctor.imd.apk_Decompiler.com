package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_EventStoreConfig;
import com.google.auto.value.AutoValue;

@AutoValue
abstract class EventStoreConfig {

    /* renamed from: a  reason: collision with root package name */
    private static final long f19642a = 10485760;

    /* renamed from: b  reason: collision with root package name */
    private static final int f19643b = 200;

    /* renamed from: c  reason: collision with root package name */
    private static final int f19644c = 10000;

    /* renamed from: d  reason: collision with root package name */
    private static final long f19645d = 604800000;

    /* renamed from: e  reason: collision with root package name */
    private static final int f19646e = 81920;

    /* renamed from: f  reason: collision with root package name */
    static final EventStoreConfig f19647f = a().f(f19642a).d(200).b(10000).c(f19645d).e(f19646e).a();

    @AutoValue.Builder
    static abstract class Builder {
        Builder() {
        }

        /* access modifiers changed from: package-private */
        public abstract EventStoreConfig a();

        /* access modifiers changed from: package-private */
        public abstract Builder b(int i2);

        /* access modifiers changed from: package-private */
        public abstract Builder c(long j2);

        /* access modifiers changed from: package-private */
        public abstract Builder d(int i2);

        /* access modifiers changed from: package-private */
        public abstract Builder e(int i2);

        /* access modifiers changed from: package-private */
        public abstract Builder f(long j2);
    }

    EventStoreConfig() {
    }

    static Builder a() {
        return new AutoValue_EventStoreConfig.Builder();
    }

    /* access modifiers changed from: package-private */
    public abstract int b();

    /* access modifiers changed from: package-private */
    public abstract long c();

    /* access modifiers changed from: package-private */
    public abstract int d();

    /* access modifiers changed from: package-private */
    public abstract int e();

    /* access modifiers changed from: package-private */
    public abstract long f();

    /* access modifiers changed from: package-private */
    public Builder g() {
        return a().f(f()).d(d()).b(b()).c(c()).e(e());
    }
}
