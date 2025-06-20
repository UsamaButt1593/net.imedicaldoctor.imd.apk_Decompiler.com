package androidx.media3.exoplayer.source;

import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;

public final /* synthetic */ class w implements Runnable {
    public final /* synthetic */ MediaSourceEventListener X;
    public final /* synthetic */ MediaSource.MediaPeriodId Y;
    public final /* synthetic */ MediaLoadData Z;
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher s;

    public /* synthetic */ w(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        this.s = eventDispatcher;
        this.X = mediaSourceEventListener;
        this.Y = mediaPeriodId;
        this.Z = mediaLoadData;
    }

    public final void run() {
        this.s.o(this.X, this.Y, this.Z);
    }
}
