package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class k implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f19622a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Iterable f19623b;

    public /* synthetic */ k(Uploader uploader, Iterable iterable) {
        this.f19622a = uploader;
        this.f19623b = iterable;
    }

    public final Object execute() {
        return this.f19622a.o(this.f19623b);
    }
}
