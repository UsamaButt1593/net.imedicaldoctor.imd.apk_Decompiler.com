package androidx.media3.exoplayer.source;

import androidx.media3.exoplayer.source.MediaSourceEventListener;

public final /* synthetic */ class s implements Runnable {
    public final /* synthetic */ MediaSourceEventListener X;
    public final /* synthetic */ LoadEventInfo Y;
    public final /* synthetic */ MediaLoadData Z;
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher s;

    public /* synthetic */ s(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.s = eventDispatcher;
        this.X = mediaSourceEventListener;
        this.Y = loadEventInfo;
        this.Z = mediaLoadData;
    }

    public final void run() {
        this.s.n(this.X, this.Y, this.Z);
    }
}
