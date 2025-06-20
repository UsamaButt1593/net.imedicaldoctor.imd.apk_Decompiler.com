package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.BackendRegistryModule;
import com.google.android.datatransport.runtime.dagger.BindsInstance;
import com.google.android.datatransport.runtime.dagger.Component;
import com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule;
import com.google.android.datatransport.runtime.time.TimeModule;
import java.io.Closeable;
import java.io.IOException;
import javax.inject.Singleton;

@Singleton
@Component(modules = {BackendRegistryModule.class, EventStoreModule.class, ExecutionModule.class, SchedulingModule.class, SchedulingConfigModule.class, TimeModule.class})
abstract class TransportRuntimeComponent implements Closeable {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder a(Context context);

        TransportRuntimeComponent build();
    }

    TransportRuntimeComponent() {
    }

    /* access modifiers changed from: package-private */
    public abstract EventStore b();

    /* access modifiers changed from: package-private */
    public abstract TransportRuntime c();

    public void close() throws IOException {
        b().close();
    }
}
