package androidx.media3.extractor.bmp;

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
public final class BmpExtractor implements Extractor {

    /* renamed from: e  reason: collision with root package name */
    private static final int f13238e = 2;

    /* renamed from: f  reason: collision with root package name */
    private static final int f13239f = 16973;

    /* renamed from: d  reason: collision with root package name */
    private final SingleSampleExtractor f13240d = new SingleSampleExtractor(f13239f, 2, MimeTypes.T0);

    public void a() {
    }

    public void c(long j2, long j3) {
        this.f13240d.c(j2, j3);
    }

    public void d(ExtractorOutput extractorOutput) {
        this.f13240d.d(extractorOutput);
    }

    public /* synthetic */ Extractor e() {
        return d.a(this);
    }

    public boolean h(ExtractorInput extractorInput) throws IOException {
        return this.f13240d.h(extractorInput);
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        return this.f13240d.i(extractorInput, positionHolder);
    }
}
