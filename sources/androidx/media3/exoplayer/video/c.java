package androidx.media3.exoplayer.video;

import androidx.media3.exoplayer.video.VideoSink;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ VideoSink.Listener X;
    public final /* synthetic */ CompositingVideoSinkProvider s;

    public /* synthetic */ c(CompositingVideoSinkProvider compositingVideoSinkProvider, VideoSink.Listener listener) {
        this.s = compositingVideoSinkProvider;
        this.X = listener;
    }

    public final void run() {
        this.s.N(this.X);
    }
}
