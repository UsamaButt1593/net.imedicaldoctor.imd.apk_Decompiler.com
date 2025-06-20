package com.google.android.datatransport.runtime.scheduling.persistence;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import java.io.Closeable;

@WorkerThread
public interface EventStore extends Closeable {
    void B2(Iterable<PersistedEvent> iterable);

    void D(Iterable<PersistedEvent> iterable);

    Iterable<PersistedEvent> X(TransportContext transportContext);

    @Nullable
    PersistedEvent b2(TransportContext transportContext, EventInternal eventInternal);

    void f0(TransportContext transportContext, long j2);

    long m2(TransportContext transportContext);

    int o();

    Iterable<TransportContext> t0();

    boolean u2(TransportContext transportContext);
}
