package androidx.media3.extractor.mkv;

import androidx.media3.extractor.ExtractorInput;
import java.io.IOException;

interface EbmlReader {
    void a(EbmlProcessor ebmlProcessor);

    boolean b(ExtractorInput extractorInput) throws IOException;

    void reset();
}
