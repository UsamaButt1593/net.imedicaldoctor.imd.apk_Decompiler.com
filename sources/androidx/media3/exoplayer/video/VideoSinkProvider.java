package androidx.media3.exoplayer.video;

import android.view.Surface;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.video.VideoSink;
import java.util.List;

@UnstableApi
public interface VideoSinkProvider {
    void K(List<Effect> list);

    void a();

    void b(VideoFrameMetadataListener videoFrameMetadataListener);

    void h(Surface surface, Size size);

    void i(Clock clock);

    void j(VideoFrameReleaseControl videoFrameReleaseControl);

    boolean m();

    void n();

    VideoFrameReleaseControl o();

    VideoSink p();

    void q(List<Effect> list);

    void r(long j2);

    void s(Format format) throws VideoSink.VideoSinkException;
}
