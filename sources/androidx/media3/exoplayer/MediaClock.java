package androidx.media3.exoplayer;

import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public interface MediaClock {
    void f(PlaybackParameters playbackParameters);

    PlaybackParameters r();

    long u();

    boolean x();
}
