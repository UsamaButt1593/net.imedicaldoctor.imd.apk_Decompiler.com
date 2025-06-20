package androidx.media3.exoplayer.source;

import androidx.media3.exoplayer.source.MediaSourceEventListener;
import java.io.IOException;

public final /* synthetic */ class u implements Runnable {
    public final /* synthetic */ MediaSourceEventListener X;
    public final /* synthetic */ IOException X2;
    public final /* synthetic */ LoadEventInfo Y;
    public final /* synthetic */ boolean Y2;
    public final /* synthetic */ MediaLoadData Z;
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher s;

    public /* synthetic */ u(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        this.s = eventDispatcher;
        this.X = mediaSourceEventListener;
        this.Y = loadEventInfo;
        this.Z = mediaLoadData;
        this.X2 = iOException;
        this.Y2 = z;
    }

    public final void run() {
        this.s.m(this.X, this.Y, this.Z, this.X2, this.Y2);
    }
}
