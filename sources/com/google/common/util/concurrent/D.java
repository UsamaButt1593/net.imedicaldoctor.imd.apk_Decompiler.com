package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Striped;

public final /* synthetic */ class D implements Supplier {
    public final Object get() {
        return new Striped.PaddedLock();
    }
}
