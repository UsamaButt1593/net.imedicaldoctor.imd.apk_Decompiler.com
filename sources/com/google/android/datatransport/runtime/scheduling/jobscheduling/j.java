package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class j implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f19618a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Iterable f19619b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TransportContext f19620c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f19621d;

    public /* synthetic */ j(Uploader uploader, Iterable iterable, TransportContext transportContext, long j2) {
        this.f19618a = uploader;
        this.f19619b = iterable;
        this.f19620c = transportContext;
        this.f19621d = j2;
    }

    public final Object execute() {
        return this.f19618a.n(this.f19619b, this.f19620c, this.f19621d);
    }
}
