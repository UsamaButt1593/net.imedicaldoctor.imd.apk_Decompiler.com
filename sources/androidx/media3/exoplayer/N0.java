package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.exoplayer.MediaSourceList;

public final /* synthetic */ class N0 implements Runnable {
    public final /* synthetic */ Pair X;
    public final /* synthetic */ Exception Y;
    public final /* synthetic */ MediaSourceList.ForwardingEventListener s;

    public /* synthetic */ N0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, Exception exc) {
        this.s = forwardingEventListener;
        this.X = pair;
        this.Y = exc;
    }

    public final void run() {
        this.s.U(this.X, this.Y);
    }
}
