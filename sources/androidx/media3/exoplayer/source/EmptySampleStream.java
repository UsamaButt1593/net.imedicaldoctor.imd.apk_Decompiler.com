package androidx.media3.exoplayer.source;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;

@UnstableApi
public final class EmptySampleStream implements SampleStream {
    public void b() {
    }

    public boolean d() {
        return true;
    }

    public int j(long j2) {
        return 0;
    }

    public int o(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
        decoderInputBuffer.p(4);
        return -4;
    }
}
