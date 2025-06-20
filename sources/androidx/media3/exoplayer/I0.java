package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.exoplayer.MediaSourceList;
import androidx.media3.exoplayer.source.MediaLoadData;

public final /* synthetic */ class I0 implements Runnable {
    public final /* synthetic */ Pair X;
    public final /* synthetic */ MediaLoadData Y;
    public final /* synthetic */ MediaSourceList.ForwardingEventListener s;

    public /* synthetic */ I0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, MediaLoadData mediaLoadData) {
        this.s = forwardingEventListener;
        this.X = pair;
        this.Y = mediaLoadData;
    }

    public final void run() {
        this.s.b0(this.X, this.Y);
    }
}
