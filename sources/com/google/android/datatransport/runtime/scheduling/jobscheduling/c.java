package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class c implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EventStore f19606a;

    public /* synthetic */ c(EventStore eventStore) {
        this.f19606a = eventStore;
    }

    public final Object execute() {
        return Integer.valueOf(this.f19606a.o());
    }
}
