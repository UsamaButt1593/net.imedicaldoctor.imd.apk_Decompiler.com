package androidx.media3.common.util;

import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;

public final /* synthetic */ class A implements Runnable {
    public final /* synthetic */ SettableFuture X;
    public final /* synthetic */ AsyncFunction Y;
    public final /* synthetic */ ListenableFuture s;

    public /* synthetic */ A(ListenableFuture listenableFuture, SettableFuture settableFuture, AsyncFunction asyncFunction) {
        this.s = listenableFuture;
        this.X = settableFuture;
        this.Y = asyncFunction;
    }

    public final void run() {
        Util.w1(this.s, this.X, this.Y);
    }
}
