package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class e implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f19610a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f19611b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f19612c;

    public /* synthetic */ e(Uploader uploader, TransportContext transportContext, int i2) {
        this.f19610a = uploader;
        this.f19611b = transportContext;
        this.f19612c = i2;
    }

    public final Object execute() {
        return this.f19610a.s(this.f19611b, this.f19612c);
    }
}
