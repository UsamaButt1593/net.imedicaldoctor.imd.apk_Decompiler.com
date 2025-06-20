package androidx.media3.exoplayer.video;

import androidx.media3.exoplayer.video.CompositingVideoSinkProvider;
import androidx.media3.exoplayer.video.VideoSink;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ CompositingVideoSinkProvider.VideoSinkImpl X;
    public final /* synthetic */ VideoSink.Listener s;

    public /* synthetic */ a(VideoSink.Listener listener, CompositingVideoSinkProvider.VideoSinkImpl videoSinkImpl) {
        this.s = listener;
        this.X = videoSinkImpl;
    }

    public final void run() {
        this.s.a(this.X);
    }
}
