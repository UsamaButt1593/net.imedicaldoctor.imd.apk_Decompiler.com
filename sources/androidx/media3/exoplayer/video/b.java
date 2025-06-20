package androidx.media3.exoplayer.video;

import androidx.media3.common.VideoSize;
import androidx.media3.exoplayer.video.CompositingVideoSinkProvider;
import androidx.media3.exoplayer.video.VideoSink;

public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ CompositingVideoSinkProvider.VideoSinkImpl X;
    public final /* synthetic */ VideoSize Y;
    public final /* synthetic */ VideoSink.Listener s;

    public /* synthetic */ b(VideoSink.Listener listener, CompositingVideoSinkProvider.VideoSinkImpl videoSinkImpl, VideoSize videoSize) {
        this.s = listener;
        this.X = videoSinkImpl;
        this.Y = videoSize;
    }

    public final void run() {
        this.s.b(this.X, this.Y);
    }
}
