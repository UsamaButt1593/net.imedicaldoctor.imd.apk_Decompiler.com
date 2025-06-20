package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

final class zacq implements Runnable {
    final /* synthetic */ zact s;

    zacq(zact zact) {
        this.s = zact;
    }

    public final void run() {
        this.s.r.b(new ConnectionResult(4));
    }
}
