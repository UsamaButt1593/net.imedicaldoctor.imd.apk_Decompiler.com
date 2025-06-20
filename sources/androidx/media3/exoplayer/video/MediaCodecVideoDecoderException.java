package androidx.media3.exoplayer.video;

import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.mediacodec.MediaCodecDecoderException;
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo;

@UnstableApi
public class MediaCodecVideoDecoderException extends MediaCodecDecoderException {
    public final int Y;
    public final boolean Z;

    public MediaCodecVideoDecoderException(Throwable th, @Nullable MediaCodecInfo mediaCodecInfo, @Nullable Surface surface) {
        super(th, mediaCodecInfo);
        this.Y = System.identityHashCode(surface);
        this.Z = surface == null || surface.isValid();
    }
}
