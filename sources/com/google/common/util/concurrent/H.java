package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final /* synthetic */ class H implements Supplier {
    public final Object get() {
        return new ReentrantReadWriteLock();
    }
}
