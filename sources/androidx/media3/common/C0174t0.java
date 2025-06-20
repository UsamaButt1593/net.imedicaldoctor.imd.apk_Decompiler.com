package androidx.media3.common;

import com.google.common.util.concurrent.ListenableFuture;

/* renamed from: androidx.media3.common.t0  reason: case insensitive filesystem */
public final /* synthetic */ class C0174t0 implements Runnable {
    public final /* synthetic */ ListenableFuture X;
    public final /* synthetic */ SimpleBasePlayer s;

    public /* synthetic */ C0174t0(SimpleBasePlayer simpleBasePlayer, ListenableFuture listenableFuture) {
        this.s = simpleBasePlayer;
        this.X = listenableFuture;
    }

    public final void run() {
        this.s.e6(this.X);
    }
}
