package androidx.media3.extractor.png;

import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SingleSampleExtractor;
import androidx.media3.extractor.d;
import java.io.IOException;

@UnstableApi
public final class PngExtractor implements Extractor {

    /* renamed from: e  reason: collision with root package name */
    private static final int f13763e = 35152;

    /* renamed from: f  reason: collision with root package name */
    private static final int f13764f = 2;

    /* renamed from: d  reason: collision with root package name */
    private final SingleSampleExtractor f13765d = new SingleSampleExtractor(f13763e, 2, MimeTypes.R0);

    public void a() {
    }

    public void c(long j2, long j3) {
        this.f13765d.c(j2, j3);
    }

    public void d(ExtractorOutput extractorOutput) {
        this.f13765d.d(extractorOutput);
    }

    public /* synthetic */ Extractor e() {
        return d.a(this);
    }

    public boolean h(ExtractorInput extractorInput) throws IOException {
        return this.f13765d.h(extractorInput);
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        return this.f13765d.i(extractorInput, positionHolder);
    }
}
