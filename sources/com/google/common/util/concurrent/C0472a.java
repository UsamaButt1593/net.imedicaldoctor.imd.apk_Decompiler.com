package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

/* renamed from: com.google.common.util.concurrent.a  reason: case insensitive filesystem */
public final /* synthetic */ class C0472a implements Executor {
    public final /* synthetic */ AbstractExecutionThreadService s;

    public /* synthetic */ C0472a(AbstractExecutionThreadService abstractExecutionThreadService) {
        this.s = abstractExecutionThreadService;
    }

    public final void execute(Runnable runnable) {
        this.s.m(runnable);
    }
}
