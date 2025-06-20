package androidx.media3.exoplayer.source;

import androidx.media3.exoplayer.source.MediaSourceEventListener;

public final /* synthetic */ class r implements Runnable {
    public final /* synthetic */ MediaSourceEventListener X;
    public final /* synthetic */ MediaLoadData Y;
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher s;

    public /* synthetic */ r(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, MediaLoadData mediaLoadData) {
        this.s = eventDispatcher;
        this.X = mediaSourceEventListener;
        this.Y = mediaLoadData;
    }

    public final void run() {
        this.s.j(this.X, this.Y);
    }
}
