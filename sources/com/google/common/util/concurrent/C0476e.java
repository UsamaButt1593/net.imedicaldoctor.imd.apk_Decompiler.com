package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

/* renamed from: com.google.common.util.concurrent.e  reason: case insensitive filesystem */
public final /* synthetic */ class C0476e implements Executor {
    public final /* synthetic */ AbstractIdleService s;

    public /* synthetic */ C0476e(AbstractIdleService abstractIdleService) {
        this.s = abstractIdleService;
    }

    public final void execute(Runnable runnable) {
        this.s.m(runnable);
    }
}
