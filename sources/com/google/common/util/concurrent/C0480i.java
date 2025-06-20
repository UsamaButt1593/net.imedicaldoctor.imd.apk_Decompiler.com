package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService;

/* renamed from: com.google.common.util.concurrent.i  reason: case insensitive filesystem */
public final /* synthetic */ class C0480i implements Runnable {
    public final /* synthetic */ AbstractScheduledService.ServiceDelegate s;

    public /* synthetic */ C0480i(AbstractScheduledService.ServiceDelegate serviceDelegate) {
        this.s = serviceDelegate;
    }

    public final void run() {
        this.s.F();
    }
}
