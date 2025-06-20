package androidx.media3.common;

import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class Q0 implements AsyncFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ListenableFuture f9267a;

    public /* synthetic */ Q0(ListenableFuture listenableFuture) {
        this.f9267a = listenableFuture;
    }

    public final ListenableFuture apply(Object obj) {
        return SimpleBasePlayer.Y4(this.f9267a, obj);
    }
}
