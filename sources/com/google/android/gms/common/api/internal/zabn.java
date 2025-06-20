package com.google.android.gms.common.api.internal;

final class zabn implements Runnable {
    final /* synthetic */ zabq X;
    final /* synthetic */ int s;

    zabn(zabq zabq, int i2) {
        this.X = zabq;
        this.s = i2;
    }

    public final void run() {
        this.X.j(this.s);
    }
}
