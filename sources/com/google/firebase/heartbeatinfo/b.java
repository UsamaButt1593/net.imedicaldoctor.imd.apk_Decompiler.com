package com.google.firebase.heartbeatinfo;

import java.util.concurrent.Callable;

public final /* synthetic */ class b implements Callable {
    public final /* synthetic */ DefaultHeartBeatController s;

    public /* synthetic */ b(DefaultHeartBeatController defaultHeartBeatController) {
        this.s = defaultHeartBeatController;
    }

    public final Object call() {
        return this.s.i();
    }
}
