package androidx.media3.common.util;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;

public final /* synthetic */ class z implements Runnable {
    public final /* synthetic */ ListenableFuture X;
    public final /* synthetic */ SettableFuture s;

    public /* synthetic */ z(SettableFuture settableFuture, ListenableFuture listenableFuture) {
        this.s = settableFuture;
        this.X = listenableFuture;
    }

    public final void run() {
        Util.v1(this.s, this.X);
    }
}
