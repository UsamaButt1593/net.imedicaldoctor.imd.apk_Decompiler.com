package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.exoplayer.MediaSourceList;

public final /* synthetic */ class M0 implements Runnable {
    public final /* synthetic */ Pair X;
    public final /* synthetic */ MediaSourceList.ForwardingEventListener s;

    public /* synthetic */ M0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair) {
        this.s = forwardingEventListener;
        this.X = pair;
    }

    public final void run() {
        this.s.N(this.X);
    }
}
