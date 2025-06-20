package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractIdleService;

/* renamed from: com.google.common.util.concurrent.g  reason: case insensitive filesystem */
public final /* synthetic */ class C0478g implements Runnable {
    public final /* synthetic */ AbstractIdleService.DelegateService s;

    public /* synthetic */ C0478g(AbstractIdleService.DelegateService delegateService) {
        this.s = delegateService;
    }

    public final void run() {
        this.s.B();
    }
}
