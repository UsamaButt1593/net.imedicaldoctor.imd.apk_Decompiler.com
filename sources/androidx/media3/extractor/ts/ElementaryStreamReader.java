package androidx.media3.extractor.ts;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ts.TsPayloadReader;

@UnstableApi
public interface ElementaryStreamReader {
    void a();

    void b(ParsableByteArray parsableByteArray) throws ParserException;

    void c();

    void d(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator);

    void e(long j2, int i2);
}
