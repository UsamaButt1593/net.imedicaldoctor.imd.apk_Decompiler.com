package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.QualifierMetadata;
import com.google.android.datatransport.runtime.dagger.internal.ScopeMetadata;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"com.google.android.datatransport.runtime.time.WallTime", "com.google.android.datatransport.runtime.time.Monotonic", "javax.inject.Named"})
public final class SQLiteEventStore_Factory implements Factory<SQLiteEventStore> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Clock> f19654a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Clock> f19655b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<EventStoreConfig> f19656c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<SchemaManager> f19657d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<String> f19658e;

    public SQLiteEventStore_Factory(Provider<Clock> provider, Provider<Clock> provider2, Provider<EventStoreConfig> provider3, Provider<SchemaManager> provider4, Provider<String> provider5) {
        this.f19654a = provider;
        this.f19655b = provider2;
        this.f19656c = provider3;
        this.f19657d = provider4;
        this.f19658e = provider5;
    }

    public static SQLiteEventStore_Factory a(Provider<Clock> provider, Provider<Clock> provider2, Provider<EventStoreConfig> provider3, Provider<SchemaManager> provider4, Provider<String> provider5) {
        return new SQLiteEventStore_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static SQLiteEventStore c(Clock clock, Clock clock2, Object obj, Object obj2, Provider<String> provider) {
        return new SQLiteEventStore(clock, clock2, (EventStoreConfig) obj, (SchemaManager) obj2, provider);
    }

    /* renamed from: b */
    public SQLiteEventStore get() {
        return c(this.f19654a.get(), this.f19655b.get(), this.f19656c.get(), this.f19657d.get(), this.f19658e);
    }
}
