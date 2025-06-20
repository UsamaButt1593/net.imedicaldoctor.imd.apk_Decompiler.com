package androidx.media3.exoplayer.source;

import androidx.media3.common.Timeline;
import androidx.media3.exoplayer.source.MediaSource;

/* renamed from: androidx.media3.exoplayer.source.a  reason: case insensitive filesystem */
public final /* synthetic */ class C0335a implements MediaSource.MediaSourceCaller {
    public final /* synthetic */ Object X;
    public final /* synthetic */ CompositeMediaSource s;

    public /* synthetic */ C0335a(CompositeMediaSource compositeMediaSource, Object obj) {
        this.s = compositeMediaSource;
        this.X = obj;
    }

    public final void W(MediaSource mediaSource, Timeline timeline) {
        this.s.F0(this.X, mediaSource, timeline);
    }
}
