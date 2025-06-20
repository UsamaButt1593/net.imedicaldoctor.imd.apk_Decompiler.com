package androidx.media3.extractor.text;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.text.SubtitleParser;
import java.io.IOException;

@UnstableApi
public class SubtitleTranscodingExtractor implements Extractor {

    /* renamed from: d  reason: collision with root package name */
    private final Extractor f13787d;

    /* renamed from: e  reason: collision with root package name */
    private final SubtitleParser.Factory f13788e;

    /* renamed from: f  reason: collision with root package name */
    private SubtitleTranscodingExtractorOutput f13789f;

    public SubtitleTranscodingExtractor(Extractor extractor, SubtitleParser.Factory factory) {
        this.f13787d = extractor;
        this.f13788e = factory;
    }

    public void a() {
        this.f13787d.a();
    }

    public void c(long j2, long j3) {
        SubtitleTranscodingExtractorOutput subtitleTranscodingExtractorOutput = this.f13789f;
        if (subtitleTranscodingExtractorOutput != null) {
            subtitleTranscodingExtractorOutput.a();
        }
        this.f13787d.c(j2, j3);
    }

    public void d(ExtractorOutput extractorOutput) {
        SubtitleTranscodingExtractorOutput subtitleTranscodingExtractorOutput = new SubtitleTranscodingExtractorOutput(extractorOutput, this.f13788e);
        this.f13789f = subtitleTranscodingExtractorOutput;
        this.f13787d.d(subtitleTranscodingExtractorOutput);
    }

    public Extractor e() {
        return this.f13787d;
    }

    public boolean h(ExtractorInput extractorInput) throws IOException {
        return this.f13787d.h(extractorInput);
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        return this.f13787d.i(extractorInput, positionHolder);
    }
}
