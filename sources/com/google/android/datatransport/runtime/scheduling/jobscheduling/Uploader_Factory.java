package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.QualifierMetadata;
import com.google.android.datatransport.runtime.dagger.internal.ScopeMetadata;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.concurrent.Executor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.google.android.datatransport.runtime.time.WallTime", "com.google.android.datatransport.runtime.time.Monotonic"})
public final class Uploader_Factory implements Factory<Uploader> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f19589a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<BackendRegistry> f19590b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<EventStore> f19591c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<WorkScheduler> f19592d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<Executor> f19593e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<SynchronizationGuard> f19594f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<Clock> f19595g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<Clock> f19596h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<ClientHealthMetricsStore> f19597i;

    public Uploader_Factory(Provider<Context> provider, Provider<BackendRegistry> provider2, Provider<EventStore> provider3, Provider<WorkScheduler> provider4, Provider<Executor> provider5, Provider<SynchronizationGuard> provider6, Provider<Clock> provider7, Provider<Clock> provider8, Provider<ClientHealthMetricsStore> provider9) {
        this.f19589a = provider;
        this.f19590b = provider2;
        this.f19591c = provider3;
        this.f19592d = provider4;
        this.f19593e = provider5;
        this.f19594f = provider6;
        this.f19595g = provider7;
        this.f19596h = provider8;
        this.f19597i = provider9;
    }

    public static Uploader_Factory a(Provider<Context> provider, Provider<BackendRegistry> provider2, Provider<EventStore> provider3, Provider<WorkScheduler> provider4, Provider<Executor> provider5, Provider<SynchronizationGuard> provider6, Provider<Clock> provider7, Provider<Clock> provider8, Provider<ClientHealthMetricsStore> provider9) {
        return new Uploader_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static Uploader c(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, Clock clock, Clock clock2, ClientHealthMetricsStore clientHealthMetricsStore) {
        return new Uploader(context, backendRegistry, eventStore, workScheduler, executor, synchronizationGuard, clock, clock2, clientHealthMetricsStore);
    }

    /* renamed from: b */
    public Uploader get() {
        return c(this.f19589a.get(), this.f19590b.get(), this.f19591c.get(), this.f19592d.get(), this.f19593e.get(), this.f19594f.get(), this.f19595g.get(), this.f19596h.get(), this.f19597i.get());
    }
}
