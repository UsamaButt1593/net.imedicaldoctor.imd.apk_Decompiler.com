package com.google.android.datatransport.runtime.scheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.dagger.internal.QualifierMetadata;
import com.google.android.datatransport.runtime.dagger.internal.ScopeMetadata;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.google.android.datatransport.runtime.time.Monotonic"})
public final class SchedulingModule_WorkSchedulerFactory implements Factory<WorkScheduler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f19539a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<EventStore> f19540b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<SchedulerConfig> f19541c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<Clock> f19542d;

    public SchedulingModule_WorkSchedulerFactory(Provider<Context> provider, Provider<EventStore> provider2, Provider<SchedulerConfig> provider3, Provider<Clock> provider4) {
        this.f19539a = provider;
        this.f19540b = provider2;
        this.f19541c = provider3;
        this.f19542d = provider4;
    }

    public static SchedulingModule_WorkSchedulerFactory a(Provider<Context> provider, Provider<EventStore> provider2, Provider<SchedulerConfig> provider3, Provider<Clock> provider4) {
        return new SchedulingModule_WorkSchedulerFactory(provider, provider2, provider3, provider4);
    }

    public static WorkScheduler c(Context context, EventStore eventStore, SchedulerConfig schedulerConfig, Clock clock) {
        return (WorkScheduler) Preconditions.f(SchedulingModule.b(context, eventStore, schedulerConfig, clock));
    }

    /* renamed from: b */
    public WorkScheduler get() {
        return c(this.f19539a.get(), this.f19540b.get(), this.f19541c.get(), this.f19542d.get());
    }
}
