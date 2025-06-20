package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

public final /* synthetic */ class z implements Callable {
    public final /* synthetic */ Object X;
    public final /* synthetic */ Runnable s;

    public /* synthetic */ z(Runnable runnable, Object obj) {
        this.s = runnable;
        this.X = obj;
    }

    public final Object call() {
        return this.s.run();
    }
}
