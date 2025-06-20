package androidx.media3.common.audio;

import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public interface AudioProcessorChain {
    long a(long j2);

    long b();

    boolean c(boolean z);

    AudioProcessor[] d();

    PlaybackParameters e(PlaybackParameters playbackParameters);
}
