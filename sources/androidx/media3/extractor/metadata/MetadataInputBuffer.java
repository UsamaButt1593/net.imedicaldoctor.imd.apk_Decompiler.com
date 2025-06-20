package androidx.media3.extractor.metadata;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.DecoderInputBuffer;

@UnstableApi
public final class MetadataInputBuffer extends DecoderInputBuffer {
    public long f3;

    public MetadataInputBuffer() {
        super(1);
    }
}
