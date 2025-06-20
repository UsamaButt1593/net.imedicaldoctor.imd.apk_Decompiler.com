package androidx.media3.exoplayer.source.ads;

import androidx.media3.common.Timeline;
import com.google.common.collect.ImmutableMap;

public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ ImmutableMap X;
    public final /* synthetic */ Timeline Y;
    public final /* synthetic */ ServerSideAdInsertionMediaSource s;

    public /* synthetic */ g(ServerSideAdInsertionMediaSource serverSideAdInsertionMediaSource, ImmutableMap immutableMap, Timeline timeline) {
        this.s = serverSideAdInsertionMediaSource;
        this.X = immutableMap;
        this.Y = timeline;
    }

    public final void run() {
        this.s.G0(this.X, this.Y);
    }
}
