package com.google.android.gms.common.api.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

public final /* synthetic */ class zabk implements Executor {
    public final /* synthetic */ Handler s;

    public /* synthetic */ zabk(Handler handler) {
        this.s = handler;
    }

    public final void execute(Runnable runnable) {
        this.s.post(runnable);
    }
}
