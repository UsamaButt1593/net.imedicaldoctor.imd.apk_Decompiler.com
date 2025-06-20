package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.dagger.internal.QualifierMetadata;
import com.google.android.datatransport.runtime.dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class EventStoreModule_StoreConfigFactory implements Factory<EventStoreConfig> {

    private static final class InstanceHolder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final EventStoreModule_StoreConfigFactory f19651a = new EventStoreModule_StoreConfigFactory();

        private InstanceHolder() {
        }
    }

    public static EventStoreModule_StoreConfigFactory a() {
        return InstanceHolder.f19651a;
    }

    public static EventStoreConfig c() {
        return (EventStoreConfig) Preconditions.f(EventStoreModule.f());
    }

    /* renamed from: b */
    public EventStoreConfig get() {
        return c();
    }
}
