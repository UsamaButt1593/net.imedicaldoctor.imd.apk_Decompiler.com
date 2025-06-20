package kotlinx.coroutines.android;

import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "kotlinx/coroutines/RunnableKt$Runnable$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1 implements Runnable {
    final /* synthetic */ HandlerContext X;
    final /* synthetic */ CancellableContinuation s;

    public HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1(CancellableContinuation cancellableContinuation, HandlerContext handlerContext) {
        this.s = cancellableContinuation;
        this.X = handlerContext;
    }

    public final void run() {
        this.s.S(this.X, Unit.f28779a);
    }
}
