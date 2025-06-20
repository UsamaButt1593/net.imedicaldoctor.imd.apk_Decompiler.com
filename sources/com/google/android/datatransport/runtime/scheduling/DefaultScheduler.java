package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import javax.inject.Inject;

public class DefaultScheduler implements Scheduler {

    /* renamed from: f  reason: collision with root package name */
    private static final Logger f19527f = Logger.getLogger(TransportRuntime.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final WorkScheduler f19528a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f19529b;

    /* renamed from: c  reason: collision with root package name */
    private final BackendRegistry f19530c;

    /* renamed from: d  reason: collision with root package name */
    private final EventStore f19531d;

    /* renamed from: e  reason: collision with root package name */
    private final SynchronizationGuard f19532e;

    @Inject
    public DefaultScheduler(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        this.f19529b = executor;
        this.f19530c = backendRegistry;
        this.f19528a = workScheduler;
        this.f19531d = eventStore;
        this.f19532e = synchronizationGuard;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object d(TransportContext transportContext, EventInternal eventInternal) {
        this.f19531d.b2(transportContext, eventInternal);
        this.f19528a.a(transportContext, 1);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(TransportContext transportContext, TransportScheduleCallback transportScheduleCallback, EventInternal eventInternal) {
        try {
            TransportBackend i2 = this.f19530c.i(transportContext.b());
            if (i2 == null) {
                String format = String.format("Transport backend '%s' is not registered", new Object[]{transportContext.b()});
                f19527f.warning(format);
                transportScheduleCallback.a(new IllegalArgumentException(format));
                return;
            }
            this.f19532e.c(new b(this, transportContext, i2.b(eventInternal)));
            transportScheduleCallback.a((Exception) null);
        } catch (Exception e2) {
            Logger logger = f19527f;
            logger.warning("Error scheduling event " + e2.getMessage());
            transportScheduleCallback.a(e2);
        }
    }

    public void a(TransportContext transportContext, EventInternal eventInternal, TransportScheduleCallback transportScheduleCallback) {
        this.f19529b.execute(new a(this, transportContext, transportScheduleCallback, eventInternal));
    }
}
