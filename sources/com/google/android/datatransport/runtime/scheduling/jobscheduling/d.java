package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class d implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f19607a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f19608b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f19609c;

    public /* synthetic */ d(Uploader uploader, TransportContext transportContext, long j2) {
        this.f19607a = uploader;
        this.f19608b = transportContext;
        this.f19609c = j2;
    }

    public final Object execute() {
        return this.f19607a.r(this.f19608b, this.f19609c);
    }
}
