package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;

public final /* synthetic */ class zacb implements Runnable {
    public final /* synthetic */ ListenerHolder.Notifier X;
    public final /* synthetic */ ListenerHolder s;

    public /* synthetic */ zacb(ListenerHolder listenerHolder, ListenerHolder.Notifier notifier) {
        this.s = listenerHolder;
        this.X = notifier;
    }

    public final void run() {
        this.s.e(this.X);
    }
}
