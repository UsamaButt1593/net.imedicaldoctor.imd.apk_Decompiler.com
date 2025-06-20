package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.TransportRuntimeComponent;
import com.google.android.datatransport.runtime.backends.CreationContextFactory_Factory;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry_Factory;
import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.DoubleCheck;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler_Factory;
import com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule_ConfigFactory;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule_WorkSchedulerFactory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_DbNameFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_PackageNameFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_SchemaVersionFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_StoreConfigFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore_Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager_Factory;
import com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory;
import com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory;
import java.util.concurrent.Executor;
import javax.inject.Provider;

@DaggerGenerated
final class DaggerTransportRuntimeComponent {

    private static final class Builder implements TransportRuntimeComponent.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Context f19437a;

        private Builder() {
        }

        /* renamed from: b */
        public Builder a(Context context) {
            this.f19437a = (Context) Preconditions.b(context);
            return this;
        }

        public TransportRuntimeComponent build() {
            Preconditions.a(this.f19437a, Context.class);
            return new TransportRuntimeComponentImpl(this.f19437a);
        }
    }

    private static final class TransportRuntimeComponentImpl extends TransportRuntimeComponent {
        private Provider<Executor> X;
        private Provider X2;
        private Provider<Context> Y;
        private Provider Y2;
        private Provider Z;
        private Provider<String> Z2;
        private Provider<SQLiteEventStore> a3;
        private Provider<SchedulerConfig> b3;
        private Provider<WorkScheduler> c3;
        private Provider<DefaultScheduler> d3;
        private Provider<Uploader> e3;
        private Provider<WorkInitializer> f3;
        private Provider<TransportRuntime> g3;
        private final TransportRuntimeComponentImpl s;

        private TransportRuntimeComponentImpl(Context context) {
            this.s = this;
            d(context);
        }

        private void d(Context context) {
            this.X = DoubleCheck.b(ExecutionModule_ExecutorFactory.a());
            Factory a2 = InstanceFactory.a(context);
            this.Y = a2;
            CreationContextFactory_Factory a4 = CreationContextFactory_Factory.a(a2, TimeModule_EventClockFactory.a(), TimeModule_UptimeClockFactory.a());
            this.Z = a4;
            this.X2 = DoubleCheck.b(MetadataBackendRegistry_Factory.a(this.Y, a4));
            this.Y2 = SchemaManager_Factory.a(this.Y, EventStoreModule_DbNameFactory.a(), EventStoreModule_SchemaVersionFactory.a());
            this.Z2 = DoubleCheck.b(EventStoreModule_PackageNameFactory.a(this.Y));
            this.a3 = DoubleCheck.b(SQLiteEventStore_Factory.a(TimeModule_EventClockFactory.a(), TimeModule_UptimeClockFactory.a(), EventStoreModule_StoreConfigFactory.a(), this.Y2, this.Z2));
            SchedulingConfigModule_ConfigFactory b2 = SchedulingConfigModule_ConfigFactory.b(TimeModule_EventClockFactory.a());
            this.b3 = b2;
            SchedulingModule_WorkSchedulerFactory a5 = SchedulingModule_WorkSchedulerFactory.a(this.Y, this.a3, b2, TimeModule_UptimeClockFactory.a());
            this.c3 = a5;
            Provider<Executor> provider = this.X;
            Provider provider2 = this.X2;
            Provider<SQLiteEventStore> provider3 = this.a3;
            this.d3 = DefaultScheduler_Factory.a(provider, provider2, a5, provider3, provider3);
            Provider<Context> provider4 = this.Y;
            Provider provider5 = this.X2;
            Provider<SQLiteEventStore> provider6 = this.a3;
            this.e3 = Uploader_Factory.a(provider4, provider5, provider6, this.c3, this.X, provider6, TimeModule_EventClockFactory.a(), TimeModule_UptimeClockFactory.a(), this.a3);
            Provider<Executor> provider7 = this.X;
            Provider<SQLiteEventStore> provider8 = this.a3;
            this.f3 = WorkInitializer_Factory.a(provider7, provider8, this.c3, provider8);
            this.g3 = DoubleCheck.b(TransportRuntime_Factory.a(TimeModule_EventClockFactory.a(), TimeModule_UptimeClockFactory.a(), this.d3, this.e3, this.f3));
        }

        /* access modifiers changed from: package-private */
        public EventStore b() {
            return this.a3.get();
        }

        /* access modifiers changed from: package-private */
        public TransportRuntime c() {
            return this.g3.get();
        }
    }

    private DaggerTransportRuntimeComponent() {
    }

    public static TransportRuntimeComponent.Builder a() {
        return new Builder();
    }
}
