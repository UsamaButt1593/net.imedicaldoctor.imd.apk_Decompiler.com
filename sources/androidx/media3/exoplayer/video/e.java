package androidx.media3.exoplayer.video;

import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.exoplayer.video.VideoSink;

public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ VideoSink.Listener X;
    public final /* synthetic */ VideoFrameProcessingException Y;
    public final /* synthetic */ CompositingVideoSinkProvider s;

    public /* synthetic */ e(CompositingVideoSinkProvider compositingVideoSinkProvider, VideoSink.Listener listener, VideoFrameProcessingException videoFrameProcessingException) {
        this.s = compositingVideoSinkProvider;
        this.X = listener;
        this.Y = videoFrameProcessingException;
    }

    public final void run() {
        this.s.O(this.X, this.Y);
    }
}
