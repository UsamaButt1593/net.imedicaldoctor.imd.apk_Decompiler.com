package kotlinx.coroutines.android;

import android.view.Choreographer;
import kotlinx.coroutines.CancellableContinuation;

public final /* synthetic */ class b implements Choreographer.FrameCallback {
    public final /* synthetic */ CancellableContinuation s;

    public /* synthetic */ b(CancellableContinuation cancellableContinuation) {
        this.s = cancellableContinuation;
    }

    public final void doFrame(long j2) {
        HandlerDispatcherKt.k(this.s, j2);
    }
}
