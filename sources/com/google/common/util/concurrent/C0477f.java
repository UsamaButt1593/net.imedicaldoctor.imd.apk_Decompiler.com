package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractIdleService;

/* renamed from: com.google.common.util.concurrent.f  reason: case insensitive filesystem */
public final /* synthetic */ class C0477f implements Runnable {
    public final /* synthetic */ AbstractIdleService.DelegateService s;

    public /* synthetic */ C0477f(AbstractIdleService.DelegateService delegateService) {
        this.s = delegateService;
    }

    public final void run() {
        this.s.C();
    }
}
