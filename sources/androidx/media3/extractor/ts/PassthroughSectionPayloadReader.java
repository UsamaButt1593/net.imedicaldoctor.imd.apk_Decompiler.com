package androidx.media3.extractor.ts;

import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

@UnstableApi
public final class PassthroughSectionPayloadReader implements SectionPayloadReader {

    /* renamed from: a  reason: collision with root package name */
    private Format f14427a;

    /* renamed from: b  reason: collision with root package name */
    private TimestampAdjuster f14428b;

    /* renamed from: c  reason: collision with root package name */
    private TrackOutput f14429c;

    public PassthroughSectionPayloadReader(String str) {
        this.f14427a = new Format.Builder().k0(str).I();
    }

    @EnsuresNonNull({"timestampAdjuster", "output"})
    private void a() {
        Assertions.k(this.f14428b);
        Util.o(this.f14429c);
    }

    public void b(ParsableByteArray parsableByteArray) {
        a();
        long e2 = this.f14428b.e();
        long f2 = this.f14428b.f();
        if (e2 != C.f9084b && f2 != C.f9084b) {
            Format format = this.f14427a;
            if (f2 != format.j3) {
                Format I = format.c().o0(f2).I();
                this.f14427a = I;
                this.f14429c.e(I);
            }
            int a2 = parsableByteArray.a();
            this.f14429c.d(parsableByteArray, a2);
            this.f14429c.f(e2, 1, a2, 0, (TrackOutput.CryptoData) null);
        }
    }

    public void c(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.f14428b = timestampAdjuster;
        trackIdGenerator.a();
        TrackOutput d2 = extractorOutput.d(trackIdGenerator.c(), 5);
        this.f14429c = d2;
        d2.e(this.f14427a);
    }
}
