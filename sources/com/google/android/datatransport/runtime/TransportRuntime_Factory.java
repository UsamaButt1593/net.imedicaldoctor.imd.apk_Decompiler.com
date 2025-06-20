package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.QualifierMetadata;
import com.google.android.datatransport.runtime.dagger.internal.ScopeMetadata;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"com.google.android.datatransport.runtime.time.WallTime", "com.google.android.datatransport.runtime.time.Monotonic"})
public final class TransportRuntime_Factory implements Factory<TransportRuntime> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Clock> f19456a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Clock> f19457b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Scheduler> f19458c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<Uploader> f19459d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<WorkInitializer> f19460e;

    public TransportRuntime_Factory(Provider<Clock> provider, Provider<Clock> provider2, Provider<Scheduler> provider3, Provider<Uploader> provider4, Provider<WorkInitializer> provider5) {
        this.f19456a = provider;
        this.f19457b = provider2;
        this.f19458c = provider3;
        this.f19459d = provider4;
        this.f19460e = provider5;
    }

    public static TransportRuntime_Factory a(Provider<Clock> provider, Provider<Clock> provider2, Provider<Scheduler> provider3, Provider<Uploader> provider4, Provider<WorkInitializer> provider5) {
        return new TransportRuntime_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static TransportRuntime c(Clock clock, Clock clock2, Scheduler scheduler, Uploader uploader, WorkInitializer workInitializer) {
        return new TransportRuntime(clock, clock2, scheduler, uploader, workInitializer);
    }

    /* renamed from: b */
    public TransportRuntime get() {
        return c(this.f19456a.get(), this.f19457b.get(), this.f19458c.get(), this.f19459d.get(), this.f19460e.get());
    }
}
