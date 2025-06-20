package androidx.media3.extractor.ts;

import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;

@UnstableApi
public final class Id3Reader implements ElementaryStreamReader {

    /* renamed from: g  reason: collision with root package name */
    private static final String f14387g = "Id3Reader";

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f14388a = new ParsableByteArray(10);

    /* renamed from: b  reason: collision with root package name */
    private TrackOutput f14389b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14390c;

    /* renamed from: d  reason: collision with root package name */
    private long f14391d = C.f9084b;

    /* renamed from: e  reason: collision with root package name */
    private int f14392e;

    /* renamed from: f  reason: collision with root package name */
    private int f14393f;

    public void a() {
        this.f14390c = false;
        this.f14391d = C.f9084b;
    }

    public void b(ParsableByteArray parsableByteArray) {
        Assertions.k(this.f14389b);
        if (this.f14390c) {
            int a2 = parsableByteArray.a();
            int i2 = this.f14393f;
            if (i2 < 10) {
                int min = Math.min(a2, 10 - i2);
                System.arraycopy(parsableByteArray.e(), parsableByteArray.f(), this.f14388a.e(), this.f14393f, min);
                if (this.f14393f + min == 10) {
                    this.f14388a.Y(0);
                    if (73 == this.f14388a.L() && 68 == this.f14388a.L() && 51 == this.f14388a.L()) {
                        this.f14388a.Z(3);
                        this.f14392e = this.f14388a.K() + 10;
                    } else {
                        Log.n(f14387g, "Discarding invalid ID3 tag");
                        this.f14390c = false;
                        return;
                    }
                }
            }
            int min2 = Math.min(a2, this.f14392e - this.f14393f);
            this.f14389b.d(parsableByteArray, min2);
            this.f14393f += min2;
        }
    }

    public void c() {
        int i2;
        Assertions.k(this.f14389b);
        if (this.f14390c && (i2 = this.f14392e) != 0 && this.f14393f == i2) {
            Assertions.i(this.f14391d != C.f9084b);
            this.f14389b.f(this.f14391d, 1, this.f14392e, 0, (TrackOutput.CryptoData) null);
            this.f14390c = false;
        }
    }

    public void d(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        TrackOutput d2 = extractorOutput.d(trackIdGenerator.c(), 5);
        this.f14389b = d2;
        d2.e(new Format.Builder().X(trackIdGenerator.b()).k0(MimeTypes.v0).I());
    }

    public void e(long j2, int i2) {
        if ((i2 & 4) != 0) {
            this.f14390c = true;
            this.f14391d = j2;
            this.f14392e = 0;
            this.f14393f = 0;
        }
    }
}
