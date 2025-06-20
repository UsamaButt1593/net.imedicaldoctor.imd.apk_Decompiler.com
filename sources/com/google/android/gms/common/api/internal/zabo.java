package com.google.android.gms.common.api.internal;

final class zabo implements Runnable {
    final /* synthetic */ zabp s;

    zabo(zabp zabp) {
        this.s = zabp;
    }

    public final void run() {
        zabq zabq = this.s.f20105a;
        zabq.f20107m.g(zabq.f20107m.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
