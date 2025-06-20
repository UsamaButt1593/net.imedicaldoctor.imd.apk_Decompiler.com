package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.QualifierMetadata;
import com.google.android.datatransport.runtime.dagger.internal.ScopeMetadata;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DefaultScheduler_Factory implements Factory<DefaultScheduler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Executor> f19533a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<BackendRegistry> f19534b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<WorkScheduler> f19535c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<EventStore> f19536d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<SynchronizationGuard> f19537e;

    public DefaultScheduler_Factory(Provider<Executor> provider, Provider<BackendRegistry> provider2, Provider<WorkScheduler> provider3, Provider<EventStore> provider4, Provider<SynchronizationGuard> provider5) {
        this.f19533a = provider;
        this.f19534b = provider2;
        this.f19535c = provider3;
        this.f19536d = provider4;
        this.f19537e = provider5;
    }

    public static DefaultScheduler_Factory a(Provider<Executor> provider, Provider<BackendRegistry> provider2, Provider<WorkScheduler> provider3, Provider<EventStore> provider4, Provider<SynchronizationGuard> provider5) {
        return new DefaultScheduler_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static DefaultScheduler c(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        return new DefaultScheduler(executor, backendRegistry, workScheduler, eventStore, synchronizationGuard);
    }

    /* renamed from: b */
    public DefaultScheduler get() {
        return c(this.f19533a.get(), this.f19534b.get(), this.f19535c.get(), this.f19536d.get(), this.f19537e.get());
    }
}
