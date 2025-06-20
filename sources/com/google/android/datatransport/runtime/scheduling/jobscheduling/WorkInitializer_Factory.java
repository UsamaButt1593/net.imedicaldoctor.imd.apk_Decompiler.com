package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.QualifierMetadata;
import com.google.android.datatransport.runtime.dagger.internal.ScopeMetadata;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class WorkInitializer_Factory implements Factory<WorkInitializer> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Executor> f19602a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<EventStore> f19603b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<WorkScheduler> f19604c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<SynchronizationGuard> f19605d;

    public WorkInitializer_Factory(Provider<Executor> provider, Provider<EventStore> provider2, Provider<WorkScheduler> provider3, Provider<SynchronizationGuard> provider4) {
        this.f19602a = provider;
        this.f19603b = provider2;
        this.f19604c = provider3;
        this.f19605d = provider4;
    }

    public static WorkInitializer_Factory a(Provider<Executor> provider, Provider<EventStore> provider2, Provider<WorkScheduler> provider3, Provider<SynchronizationGuard> provider4) {
        return new WorkInitializer_Factory(provider, provider2, provider3, provider4);
    }

    public static WorkInitializer c(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        return new WorkInitializer(executor, eventStore, workScheduler, synchronizationGuard);
    }

    /* renamed from: b */
    public WorkInitializer get() {
        return c(this.f19602a.get(), this.f19603b.get(), this.f19604c.get(), this.f19605d.get());
    }
}
