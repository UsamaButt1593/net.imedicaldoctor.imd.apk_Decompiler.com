package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class h implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f19614a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f19615b;

    public /* synthetic */ h(Uploader uploader, TransportContext transportContext) {
        this.f19614a = uploader;
        this.f19615b = transportContext;
    }

    public final Object execute() {
        return this.f19614a.l(this.f19615b);
    }
}
