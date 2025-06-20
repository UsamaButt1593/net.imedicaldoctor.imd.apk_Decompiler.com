package com.google.common.cache;

import java.util.concurrent.Executor;

public final /* synthetic */ class e implements RemovalListener {
    public final /* synthetic */ RemovalListener X;
    public final /* synthetic */ Executor s;

    public /* synthetic */ e(Executor executor, RemovalListener removalListener) {
        this.s = executor;
        this.X = removalListener;
    }

    public final void a(RemovalNotification removalNotification) {
        this.s.execute(new d(this.X, removalNotification));
    }
}
