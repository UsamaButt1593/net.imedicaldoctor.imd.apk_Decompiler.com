package androidx.media3.extractor.webp;

import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SingleSampleExtractor;
import androidx.media3.extractor.d;
import java.io.IOException;

@UnstableApi
public final class WebpExtractor implements Extractor {

    /* renamed from: f  reason: collision with root package name */
    private static final int f14604f = 4;

    /* renamed from: g  reason: collision with root package name */
    private static final int f14605g = 1380533830;

    /* renamed from: h  reason: collision with root package name */
    private static final int f14606h = 1464156752;

    /* renamed from: d  reason: collision with root package name */
    private final ParsableByteArray f14607d = new ParsableByteArray(4);

    /* renamed from: e  reason: collision with root package name */
    private final SingleSampleExtractor f14608e = new SingleSampleExtractor(-1, -1, MimeTypes.U0);

    public void a() {
    }

    public void c(long j2, long j3) {
        this.f14608e.c(j2, j3);
    }

    public void d(ExtractorOutput extractorOutput) {
        this.f14608e.d(extractorOutput);
    }

    public /* synthetic */ Extractor e() {
        return d.a(this);
    }

    public boolean h(ExtractorInput extractorInput) throws IOException {
        this.f14607d.U(4);
        extractorInput.s(this.f14607d.e(), 0, 4);
        if (this.f14607d.N() != 1380533830) {
            return false;
        }
        extractorInput.j(4);
        this.f14607d.U(4);
        extractorInput.s(this.f14607d.e(), 0, 4);
        return this.f14607d.N() == 1464156752;
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        return this.f14608e.i(extractorInput, positionHolder);
    }
}
