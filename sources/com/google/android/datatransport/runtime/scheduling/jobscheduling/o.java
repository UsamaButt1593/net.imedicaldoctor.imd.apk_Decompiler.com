package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class o implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkInitializer f19627a;

    public /* synthetic */ o(WorkInitializer workInitializer) {
        this.f19627a = workInitializer;
    }

    public final Object execute() {
        return this.f19627a.d();
    }
}
