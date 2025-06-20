package androidx.media3.exoplayer.video;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.VideoDecoderOutputBuffer;

@UnstableApi
public interface VideoDecoderOutputBufferRenderer {
    void setOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer);
}
