package androidx.media3.exoplayer.hls;

import androidx.annotation.VisibleForTesting;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.mp3.Mp3Extractor;
import androidx.media3.extractor.mp4.FragmentedMp4Extractor;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.ts.Ac3Extractor;
import androidx.media3.extractor.ts.Ac4Extractor;
import androidx.media3.extractor.ts.AdtsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import java.io.IOException;

@UnstableApi
public final class BundledHlsMediaChunkExtractor implements HlsMediaChunkExtractor {

    /* renamed from: f  reason: collision with root package name */
    private static final PositionHolder f11369f = new PositionHolder();
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    final Extractor f11370a;

    /* renamed from: b  reason: collision with root package name */
    private final Format f11371b;

    /* renamed from: c  reason: collision with root package name */
    private final TimestampAdjuster f11372c;

    /* renamed from: d  reason: collision with root package name */
    private final SubtitleParser.Factory f11373d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f11374e;

    public BundledHlsMediaChunkExtractor(Extractor extractor, Format format, TimestampAdjuster timestampAdjuster) {
        this(extractor, format, timestampAdjuster, SubtitleParser.Factory.f13783a, false);
    }

    public boolean b(ExtractorInput extractorInput) throws IOException {
        return this.f11370a.i(extractorInput, f11369f) == 0;
    }

    public void d(ExtractorOutput extractorOutput) {
        this.f11370a.d(extractorOutput);
    }

    public void e() {
        this.f11370a.c(0, 0);
    }

    public boolean f() {
        Extractor e2 = this.f11370a.e();
        return (e2 instanceof AdtsExtractor) || (e2 instanceof Ac3Extractor) || (e2 instanceof Ac4Extractor) || (e2 instanceof Mp3Extractor);
    }

    public boolean g() {
        Extractor e2 = this.f11370a.e();
        return (e2 instanceof TsExtractor) || (e2 instanceof FragmentedMp4Extractor);
    }

    public HlsMediaChunkExtractor h() {
        Extractor mp3Extractor;
        boolean z = true;
        Assertions.i(!g());
        if (this.f11370a.e() != this.f11370a) {
            z = false;
        }
        Assertions.j(z, "Can't recreate wrapped extractors. Outer type: " + this.f11370a.getClass());
        Extractor extractor = this.f11370a;
        if (extractor instanceof WebvttExtractor) {
            mp3Extractor = new WebvttExtractor(this.f11371b.Z, this.f11372c, this.f11373d, this.f11374e);
        } else if (extractor instanceof AdtsExtractor) {
            mp3Extractor = new AdtsExtractor();
        } else if (extractor instanceof Ac3Extractor) {
            mp3Extractor = new Ac3Extractor();
        } else if (extractor instanceof Ac4Extractor) {
            mp3Extractor = new Ac4Extractor();
        } else if (extractor instanceof Mp3Extractor) {
            mp3Extractor = new Mp3Extractor();
        } else {
            throw new IllegalStateException("Unexpected extractor type for recreation: " + this.f11370a.getClass().getSimpleName());
        }
        return new BundledHlsMediaChunkExtractor(mp3Extractor, this.f11371b, this.f11372c, this.f11373d, this.f11374e);
    }

    BundledHlsMediaChunkExtractor(Extractor extractor, Format format, TimestampAdjuster timestampAdjuster, SubtitleParser.Factory factory, boolean z) {
        this.f11370a = extractor;
        this.f11371b = format;
        this.f11372c = timestampAdjuster;
        this.f11373d = factory;
        this.f11374e = z;
    }
}
