package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.Map;

public final /* synthetic */ class m implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f19625a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f19626b;

    public /* synthetic */ m(Uploader uploader, Map map) {
        this.f19625a = uploader;
        this.f19626b = map;
    }

    public final Object execute() {
        return this.f19625a.q(this.f19626b);
    }
}
