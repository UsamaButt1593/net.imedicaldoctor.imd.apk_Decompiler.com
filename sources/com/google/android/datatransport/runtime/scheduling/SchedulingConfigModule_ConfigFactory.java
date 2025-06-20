package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.dagger.internal.QualifierMetadata;
import com.google.android.datatransport.runtime.dagger.internal.ScopeMetadata;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.google.android.datatransport.runtime.time.WallTime"})
public final class SchedulingConfigModule_ConfigFactory implements Factory<SchedulerConfig> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Clock> f19538a;

    public SchedulingConfigModule_ConfigFactory(Provider<Clock> provider) {
        this.f19538a = provider;
    }

    public static SchedulerConfig a(Clock clock) {
        return (SchedulerConfig) Preconditions.f(SchedulingConfigModule.a(clock));
    }

    public static SchedulingConfigModule_ConfigFactory b(Provider<Clock> provider) {
        return new SchedulingConfigModule_ConfigFactory(provider);
    }

    /* renamed from: c */
    public SchedulerConfig get() {
        return a(this.f19538a.get());
    }
}
