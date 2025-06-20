package androidx.profileinstaller;

import android.view.Choreographer;

public final /* synthetic */ class h implements Choreographer.FrameCallback {
    public final /* synthetic */ Runnable s;

    public /* synthetic */ h(Runnable runnable) {
        this.s = runnable;
    }

    public final void doFrame(long j2) {
        this.s.run();
    }
}
