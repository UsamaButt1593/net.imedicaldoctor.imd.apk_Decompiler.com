package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.exoplayer.MediaSourceList;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;

public final /* synthetic */ class O0 implements Runnable {
    public final /* synthetic */ Pair X;
    public final /* synthetic */ LoadEventInfo Y;
    public final /* synthetic */ MediaLoadData Z;
    public final /* synthetic */ MediaSourceList.ForwardingEventListener s;

    public /* synthetic */ O0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.s = forwardingEventListener;
        this.X = pair;
        this.Y = loadEventInfo;
        this.Z = mediaLoadData;
    }

    public final void run() {
        this.s.a0(this.X, this.Y, this.Z);
    }
}
