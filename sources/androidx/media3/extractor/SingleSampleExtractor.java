package androidx.media3.extractor;

import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.TrackOutput;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public final class SingleSampleExtractor implements Extractor {

    /* renamed from: k  reason: collision with root package name */
    private static final int f13119k = 1;

    /* renamed from: l  reason: collision with root package name */
    private static final int f13120l = 2;

    /* renamed from: m  reason: collision with root package name */
    public static final int f13121m = 1024;

    /* renamed from: n  reason: collision with root package name */
    private static final int f13122n = 1024;

    /* renamed from: d  reason: collision with root package name */
    private final int f13123d;

    /* renamed from: e  reason: collision with root package name */
    private final int f13124e;

    /* renamed from: f  reason: collision with root package name */
    private final String f13125f;

    /* renamed from: g  reason: collision with root package name */
    private int f13126g;

    /* renamed from: h  reason: collision with root package name */
    private int f13127h;

    /* renamed from: i  reason: collision with root package name */
    private ExtractorOutput f13128i;

    /* renamed from: j  reason: collision with root package name */
    private TrackOutput f13129j;

    public SingleSampleExtractor(int i2, int i3, String str) {
        this.f13123d = i2;
        this.f13124e = i3;
        this.f13125f = str;
    }

    @RequiresNonNull({"this.extractorOutput"})
    private void b(String str) {
        TrackOutput d2 = this.f13128i.d(1024, 4);
        this.f13129j = d2;
        d2.e(new Format.Builder().k0(str).I());
        this.f13128i.o();
        this.f13128i.j(new SingleSampleSeekMap(C.f9084b));
        this.f13127h = 1;
    }

    private void f(ExtractorInput extractorInput) throws IOException {
        int b2 = ((TrackOutput) Assertions.g(this.f13129j)).b(extractorInput, 1024, true);
        if (b2 == -1) {
            this.f13127h = 2;
            this.f13129j.f(0, 1, this.f13126g, 0, (TrackOutput.CryptoData) null);
            this.f13126g = 0;
            return;
        }
        this.f13126g += b2;
    }

    public void a() {
    }

    public void c(long j2, long j3) {
        if (j2 == 0 || this.f13127h == 1) {
            this.f13127h = 1;
            this.f13126g = 0;
        }
    }

    public void d(ExtractorOutput extractorOutput) {
        this.f13128i = extractorOutput;
        b(this.f13125f);
    }

    public /* synthetic */ Extractor e() {
        return d.a(this);
    }

    public boolean h(ExtractorInput extractorInput) throws IOException {
        Assertions.i((this.f13123d == -1 || this.f13124e == -1) ? false : true);
        ParsableByteArray parsableByteArray = new ParsableByteArray(this.f13124e);
        extractorInput.s(parsableByteArray.e(), 0, this.f13124e);
        return parsableByteArray.R() == this.f13123d;
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i2 = this.f13127h;
        if (i2 == 1) {
            f(extractorInput);
            return 0;
        } else if (i2 == 2) {
            return -1;
        } else {
            throw new IllegalStateException();
        }
    }
}
