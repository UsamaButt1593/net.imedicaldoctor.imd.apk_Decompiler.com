package androidx.media3.extractor.ogg;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.d;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

@UnstableApi
public class OggExtractor implements Extractor {

    /* renamed from: g  reason: collision with root package name */
    public static final ExtractorsFactory f13718g = new a();

    /* renamed from: h  reason: collision with root package name */
    private static final int f13719h = 8;

    /* renamed from: d  reason: collision with root package name */
    private ExtractorOutput f13720d;

    /* renamed from: e  reason: collision with root package name */
    private StreamReader f13721e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f13722f;

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] f() {
        return new Extractor[]{new OggExtractor()};
    }

    private static ParsableByteArray g(ParsableByteArray parsableByteArray) {
        parsableByteArray.Y(0);
        return parsableByteArray;
    }

    @EnsuresNonNullIf(expression = {"streamReader"}, result = true)
    private boolean j(ExtractorInput extractorInput) throws IOException {
        StreamReader opusReader;
        OggPageHeader oggPageHeader = new OggPageHeader();
        if (oggPageHeader.a(extractorInput, true) && (oggPageHeader.f13732b & 2) == 2) {
            int min = Math.min(oggPageHeader.f13739i, 8);
            ParsableByteArray parsableByteArray = new ParsableByteArray(min);
            extractorInput.s(parsableByteArray.e(), 0, min);
            if (FlacReader.p(g(parsableByteArray))) {
                opusReader = new FlacReader();
            } else if (VorbisReader.r(g(parsableByteArray))) {
                opusReader = new VorbisReader();
            } else if (OpusReader.o(g(parsableByteArray))) {
                opusReader = new OpusReader();
            }
            this.f13721e = opusReader;
            return true;
        }
        return false;
    }

    public void a() {
    }

    public void c(long j2, long j3) {
        StreamReader streamReader = this.f13721e;
        if (streamReader != null) {
            streamReader.m(j2, j3);
        }
    }

    public void d(ExtractorOutput extractorOutput) {
        this.f13720d = extractorOutput;
    }

    public /* synthetic */ Extractor e() {
        return d.a(this);
    }

    public boolean h(ExtractorInput extractorInput) throws IOException {
        try {
            return j(extractorInput);
        } catch (ParserException unused) {
            return false;
        }
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        Assertions.k(this.f13720d);
        if (this.f13721e == null) {
            if (j(extractorInput)) {
                extractorInput.n();
            } else {
                throw ParserException.a("Failed to determine bitstream type", (Throwable) null);
            }
        }
        if (!this.f13722f) {
            TrackOutput d2 = this.f13720d.d(0, 1);
            this.f13720d.o();
            this.f13721e.d(this.f13720d, d2);
            this.f13722f = true;
        }
        return this.f13721e.g(extractorInput, positionHolder);
    }
}
