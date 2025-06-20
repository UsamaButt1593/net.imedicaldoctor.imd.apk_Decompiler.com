package androidx.media3.extractor.metadata;

import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import java.nio.ByteBuffer;

@UnstableApi
public abstract class SimpleMetadataDecoder implements MetadataDecoder {
    @Nullable
    public final Metadata a(MetadataInputBuffer metadataInputBuffer) {
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.g(metadataInputBuffer.Z);
        Assertions.a(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        return b(metadataInputBuffer, byteBuffer);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public abstract Metadata b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer);
}
