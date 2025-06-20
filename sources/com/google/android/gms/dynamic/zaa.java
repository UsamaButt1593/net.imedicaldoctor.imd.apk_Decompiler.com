package com.google.android.gms.dynamic;

import java.util.Iterator;

final class zaa implements OnDelegateCreatedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DeferredLifecycleHelper f20452a;

    zaa(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.f20452a = deferredLifecycleHelper;
    }

    public final void a(LifecycleDelegate lifecycleDelegate) {
        this.f20452a.f20443a = lifecycleDelegate;
        Iterator it2 = this.f20452a.f20445c.iterator();
        while (it2.hasNext()) {
            ((zah) it2.next()).a(this.f20452a.f20443a);
        }
        this.f20452a.f20445c.clear();
        this.f20452a.f20444b = null;
    }
}
