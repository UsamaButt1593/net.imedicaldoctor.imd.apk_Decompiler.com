package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.exoplayer.MediaSourceList;

public final /* synthetic */ class T0 implements Runnable {
    public final /* synthetic */ Pair X;
    public final /* synthetic */ int Y;
    public final /* synthetic */ MediaSourceList.ForwardingEventListener s;

    public /* synthetic */ T0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, int i2) {
        this.s = forwardingEventListener;
        this.X = pair;
        this.Y = i2;
    }

    public final void run() {
        this.s.S(this.X, this.Y);
    }
}
