package androidx.media3.exoplayer.hls;

import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import java.io.IOException;

final class UnexpectedSampleTimestampException extends IOException {
    public final long X;
    public final long Y;
    public final MediaChunk s;

    public UnexpectedSampleTimestampException(MediaChunk mediaChunk, long j2, long j3) {
        super("Unexpected sample timestamp: " + Util.H2(j3) + " in chunk [" + mediaChunk.f12284g + ", " + mediaChunk.f12285h + "]");
        this.s = mediaChunk;
        this.X = j2;
        this.Y = j3;
    }
}
