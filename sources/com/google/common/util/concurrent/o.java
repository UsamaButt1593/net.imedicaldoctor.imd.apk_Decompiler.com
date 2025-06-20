package com.google.common.util.concurrent;

import java.util.concurrent.Callable;

public final /* synthetic */ class o implements Callable {
    public final /* synthetic */ Object s;

    public /* synthetic */ o(Object obj) {
        this.s = obj;
    }

    public final Object call() {
        return Callables.g(this.s);
    }
}
