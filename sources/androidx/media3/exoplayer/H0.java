package androidx.media3.exoplayer;

import androidx.media3.common.Timeline;
import androidx.media3.exoplayer.source.MediaSource;

public final /* synthetic */ class H0 implements MediaSource.MediaSourceCaller {
    public final /* synthetic */ MediaSourceList s;

    public /* synthetic */ H0(MediaSourceList mediaSourceList) {
        this.s = mediaSourceList;
    }

    public final void W(MediaSource mediaSource, Timeline timeline) {
        this.s.v(mediaSource, timeline);
    }
}
