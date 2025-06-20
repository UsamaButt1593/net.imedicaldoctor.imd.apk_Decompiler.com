package com.google.common.eventbus;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ Object X;
    public final /* synthetic */ Subscriber s;

    public /* synthetic */ a(Subscriber subscriber, Object obj) {
        this.s = subscriber;
        this.X = obj;
    }

    public final void run() {
        this.s.g(this.X);
    }
}
