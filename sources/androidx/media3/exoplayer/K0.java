package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.exoplayer.MediaSourceList;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import java.io.IOException;

public final /* synthetic */ class K0 implements Runnable {
    public final /* synthetic */ Pair X;
    public final /* synthetic */ IOException X2;
    public final /* synthetic */ LoadEventInfo Y;
    public final /* synthetic */ boolean Y2;
    public final /* synthetic */ MediaLoadData Z;
    public final /* synthetic */ MediaSourceList.ForwardingEventListener s;

    public /* synthetic */ K0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        this.s = forwardingEventListener;
        this.X = pair;
        this.Y = loadEventInfo;
        this.Z = mediaLoadData;
        this.X2 = iOException;
        this.Y2 = z;
    }

    public final void run() {
        this.s.Z(this.X, this.Y, this.Z, this.X2, this.Y2);
    }
}
