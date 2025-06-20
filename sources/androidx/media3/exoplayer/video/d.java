package androidx.media3.exoplayer.video;

import androidx.media3.common.util.HandlerWrapper;
import java.util.concurrent.Executor;

public final /* synthetic */ class d implements Executor {
    public final /* synthetic */ HandlerWrapper s;

    public /* synthetic */ d(HandlerWrapper handlerWrapper) {
        this.s = handlerWrapper;
    }

    public final void execute(Runnable runnable) {
        this.s.e(runnable);
    }
}
