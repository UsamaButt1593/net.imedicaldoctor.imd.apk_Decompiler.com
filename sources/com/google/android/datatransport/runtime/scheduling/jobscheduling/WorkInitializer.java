package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.inject.Inject;

public class WorkInitializer {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f19598a;

    /* renamed from: b  reason: collision with root package name */
    private final EventStore f19599b;

    /* renamed from: c  reason: collision with root package name */
    private final WorkScheduler f19600c;

    /* renamed from: d  reason: collision with root package name */
    private final SynchronizationGuard f19601d;

    @Inject
    WorkInitializer(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        this.f19598a = executor;
        this.f19599b = eventStore;
        this.f19600c = workScheduler;
        this.f19601d = synchronizationGuard;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object d() {
        for (TransportContext a2 : this.f19599b.t0()) {
            this.f19600c.a(a2, 1);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.f19601d.c(new o(this));
    }

    public void c() {
        this.f19598a.execute(new n(this));
    }
}
