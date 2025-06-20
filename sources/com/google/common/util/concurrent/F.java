package com.google.common.util.concurrent;

import com.google.common.base.Supplier;

public final /* synthetic */ class F implements Supplier {
    public final /* synthetic */ int s;

    public /* synthetic */ F(int i2) {
        this.s = i2;
    }

    public final Object get() {
        return Striped.m(this.s);
    }
}
