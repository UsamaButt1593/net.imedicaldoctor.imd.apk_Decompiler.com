package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import java.util.concurrent.Callable;

public final /* synthetic */ class m implements Callable {
    public final /* synthetic */ Callable X;
    public final /* synthetic */ Supplier s;

    public /* synthetic */ m(Supplier supplier, Callable callable) {
        this.s = supplier;
        this.X = callable;
    }

    public final Object call() {
        return Callables.h(this.s, this.X);
    }
}
