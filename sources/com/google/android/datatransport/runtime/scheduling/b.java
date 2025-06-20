package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class b implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultScheduler f19543a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f19544b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ EventInternal f19545c;

    public /* synthetic */ b(DefaultScheduler defaultScheduler, TransportContext transportContext, EventInternal eventInternal) {
        this.f19543a = defaultScheduler;
        this.f19544b = transportContext;
        this.f19545c = eventInternal;
    }

    public final Object execute() {
        return this.f19543a.d(this.f19544b, this.f19545c);
    }
}
