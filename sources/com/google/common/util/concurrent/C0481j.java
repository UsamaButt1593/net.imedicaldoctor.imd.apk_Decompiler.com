package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService;

/* renamed from: com.google.common.util.concurrent.j  reason: case insensitive filesystem */
public final /* synthetic */ class C0481j implements Runnable {
    public final /* synthetic */ AbstractScheduledService.ServiceDelegate s;

    public /* synthetic */ C0481j(AbstractScheduledService.ServiceDelegate serviceDelegate) {
        this.s = serviceDelegate;
    }

    public final void run() {
        this.s.G();
    }
}
