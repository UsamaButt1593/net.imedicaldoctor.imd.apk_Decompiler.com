package androidx.media3.extractor.ogg;

import androidx.annotation.Nullable;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.SeekMap;
import java.io.IOException;

interface OggSeeker {
    @Nullable
    SeekMap a();

    long b(ExtractorInput extractorInput) throws IOException;

    void c(long j2);
}
