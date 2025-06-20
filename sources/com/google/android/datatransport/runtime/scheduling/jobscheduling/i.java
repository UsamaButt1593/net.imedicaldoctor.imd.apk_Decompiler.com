package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class i implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f19616a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f19617b;

    public /* synthetic */ i(Uploader uploader, TransportContext transportContext) {
        this.f19616a = uploader;
        this.f19617b = transportContext;
    }

    public final Object execute() {
        return this.f19616a.m(this.f19617b);
    }
}
