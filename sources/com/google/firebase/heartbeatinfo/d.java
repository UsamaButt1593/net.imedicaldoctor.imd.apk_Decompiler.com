package com.google.firebase.heartbeatinfo;

import java.util.concurrent.Callable;

public final /* synthetic */ class d implements Callable {
    public final /* synthetic */ DefaultHeartBeatController s;

    public /* synthetic */ d(DefaultHeartBeatController defaultHeartBeatController) {
        this.s = defaultHeartBeatController;
    }

    public final Object call() {
        return this.s.k();
    }
}
