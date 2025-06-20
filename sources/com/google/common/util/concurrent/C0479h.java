package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AbstractScheduledService;

/* renamed from: com.google.common.util.concurrent.h  reason: case insensitive filesystem */
public final /* synthetic */ class C0479h implements Supplier {
    public final /* synthetic */ AbstractScheduledService.ServiceDelegate s;

    public /* synthetic */ C0479h(AbstractScheduledService.ServiceDelegate serviceDelegate) {
        this.s = serviceDelegate;
    }

    public final Object get() {
        return this.s.E();
    }
}
