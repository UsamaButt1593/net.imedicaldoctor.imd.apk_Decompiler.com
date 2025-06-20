package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.Binds;
import com.google.android.datatransport.runtime.dagger.Module;
import com.google.android.datatransport.runtime.dagger.Provides;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import javax.inject.Named;
import javax.inject.Singleton;

@Module
public abstract class EventStoreModule {
    @Provides
    @Named("SQLITE_DB_NAME")
    static String b() {
        return "com.google.android.datatransport.events";
    }

    @Singleton
    @Provides
    @Named("PACKAGE_NAME")
    static String d(Context context) {
        return context.getPackageName();
    }

    @Provides
    @Named("SCHEMA_VERSION")
    static int e() {
        return SchemaManager.l3;
    }

    @Provides
    static EventStoreConfig f() {
        return EventStoreConfig.f19647f;
    }

    /* access modifiers changed from: package-private */
    @Binds
    public abstract ClientHealthMetricsStore a(SQLiteEventStore sQLiteEventStore);

    /* access modifiers changed from: package-private */
    @Binds
    public abstract EventStore c(SQLiteEventStore sQLiteEventStore);

    /* access modifiers changed from: package-private */
    @Binds
    public abstract SynchronizationGuard g(SQLiteEventStore sQLiteEventStore);
}
