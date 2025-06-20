package androidx.media3.exoplayer.hls;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import java.io.IOException;

@UnstableApi
public interface HlsMediaChunkExtractor {
    boolean b(ExtractorInput extractorInput) throws IOException;

    void d(ExtractorOutput extractorOutput);

    void e();

    boolean f();

    boolean g();

    HlsMediaChunkExtractor h();
}
