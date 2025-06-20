package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.dagger.internal.QualifierMetadata;
import com.google.android.datatransport.runtime.dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class EventStoreModule_DbNameFactory implements Factory<String> {

    private static final class InstanceHolder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final EventStoreModule_DbNameFactory f19648a = new EventStoreModule_DbNameFactory();

        private InstanceHolder() {
        }
    }

    public static EventStoreModule_DbNameFactory a() {
        return InstanceHolder.f19648a;
    }

    public static String b() {
        return (String) Preconditions.f(EventStoreModule.b());
    }

    /* renamed from: c */
    public String get() {
        return b();
    }
}
