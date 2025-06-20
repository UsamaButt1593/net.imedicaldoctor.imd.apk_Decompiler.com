package com.google.common.util.concurrent;

import com.google.common.base.Supplier;

public final /* synthetic */ class E implements Supplier {
    public final /* synthetic */ int s;

    public /* synthetic */ E(int i2) {
        this.s = i2;
    }

    public final Object get() {
        return Striped.n(this.s);
    }
}
