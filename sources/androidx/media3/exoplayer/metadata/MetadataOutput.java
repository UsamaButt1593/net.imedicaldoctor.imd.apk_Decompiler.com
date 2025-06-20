package androidx.media3.exoplayer.metadata;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public interface MetadataOutput {
    void q(Metadata metadata);
}
