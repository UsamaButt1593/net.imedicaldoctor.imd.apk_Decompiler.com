package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AbstractExecutionThreadService;

/* renamed from: com.google.common.util.concurrent.b  reason: case insensitive filesystem */
public final /* synthetic */ class C0473b implements Supplier {
    public final /* synthetic */ AbstractExecutionThreadService.AnonymousClass1 s;

    public /* synthetic */ C0473b(AbstractExecutionThreadService.AnonymousClass1 r1) {
        this.s = r1;
    }

    public final Object get() {
        return this.s.B();
    }
}
