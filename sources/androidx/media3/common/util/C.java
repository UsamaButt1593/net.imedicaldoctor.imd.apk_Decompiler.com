package androidx.media3.common.util;

import com.google.common.util.concurrent.SettableFuture;

public final /* synthetic */ class C implements Runnable {
    public final /* synthetic */ Runnable X;
    public final /* synthetic */ Object Y;
    public final /* synthetic */ SettableFuture s;

    public /* synthetic */ C(SettableFuture settableFuture, Runnable runnable, Object obj) {
        this.s = settableFuture;
        this.X = runnable;
        this.Y = obj;
    }

    public final void run() {
        Util.u1(this.s, this.X, this.Y);
    }
}
