package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class l implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f19624a;

    public /* synthetic */ l(Uploader uploader) {
        this.f19624a = uploader;
    }

    public final Object execute() {
        return this.f19624a.p();
    }
}
