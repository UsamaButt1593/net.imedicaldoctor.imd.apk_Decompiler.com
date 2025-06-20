package kotlinx.coroutines.android;

import kotlinx.coroutines.DisposableHandle;

public final /* synthetic */ class a implements DisposableHandle {
    public final /* synthetic */ Runnable X;
    public final /* synthetic */ HandlerContext s;

    public /* synthetic */ a(HandlerContext handlerContext, Runnable runnable) {
        this.s = handlerContext;
        this.X = runnable;
    }

    public final void m() {
        HandlerContext.D0(this.s, this.X);
    }
}
