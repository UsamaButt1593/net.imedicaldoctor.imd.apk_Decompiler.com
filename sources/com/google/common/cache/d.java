package com.google.common.cache;

public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ RemovalNotification X;
    public final /* synthetic */ RemovalListener s;

    public /* synthetic */ d(RemovalListener removalListener, RemovalNotification removalNotification) {
        this.s = removalListener;
        this.X = removalNotification;
    }

    public final void run() {
        this.s.a(this.X);
    }
}
