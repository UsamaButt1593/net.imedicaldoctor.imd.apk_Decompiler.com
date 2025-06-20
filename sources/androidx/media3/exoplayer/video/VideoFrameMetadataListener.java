package androidx.media3.exoplayer.video;

import android.media.MediaFormat;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public interface VideoFrameMetadataListener {
    void j(long j2, long j3, Format format, @Nullable MediaFormat mediaFormat);
}
