package androidx.media3.extractor.heif;

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
public final class HeifExtractor implements Extractor {

    /* renamed from: f  reason: collision with root package name */
    private static final int f13311f = 1718909296;

    /* renamed from: g  reason: collision with root package name */
    private static final int f13312g = 1751476579;

    /* renamed from: h  reason: collision with root package name */
    private static final int f13313h = 4;

    /* renamed from: d  reason: collision with root package name */
    private final ParsableByteArray f13314d = new ParsableByteArray(4);

    /* renamed from: e  reason: collision with root package name */
    private final SingleSampleExtractor f13315e = new SingleSampleExtractor(-1, -1, MimeTypes.S0);

    private boolean b(ExtractorInput extractorInput, int i2) throws IOException {
        this.f13314d.U(4);
        extractorInput.s(this.f13314d.e(), 0, 4);
        return this.f13314d.N() == ((long) i2);
    }

    public void a() {
    }

    public void c(long j2, long j3) {
        this.f13315e.c(j2, j3);
    }

    public void d(ExtractorOutput extractorOutput) {
        this.f13315e.d(extractorOutput);
    }

    public /* synthetic */ Extractor e() {
        return d.a(this);
    }

    public boolean h(ExtractorInput extractorInput) throws IOException {
        extractorInput.j(4);
        return b(extractorInput, 1718909296) && b(extractorInput, 1751476579);
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        return this.f13315e.i(extractorInput, positionHolder);
    }
}
