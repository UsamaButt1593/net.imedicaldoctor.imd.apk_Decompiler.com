package androidx.media3.extractor.ts;

import androidx.media3.common.C;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.d;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.io.IOException;

@UnstableApi
public final class Ac3Extractor implements Extractor {

    /* renamed from: g  reason: collision with root package name */
    public static final ExtractorsFactory f14166g = new a();

    /* renamed from: h  reason: collision with root package name */
    private static final int f14167h = 8192;

    /* renamed from: i  reason: collision with root package name */
    private static final int f14168i = 2935;

    /* renamed from: j  reason: collision with root package name */
    private static final int f14169j = 2786;

    /* renamed from: d  reason: collision with root package name */
    private final Ac3Reader f14170d = new Ac3Reader();

    /* renamed from: e  reason: collision with root package name */
    private final ParsableByteArray f14171e = new ParsableByteArray((int) f14169j);

    /* renamed from: f  reason: collision with root package name */
    private boolean f14172f;

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] f() {
        return new Extractor[]{new Ac3Extractor()};
    }

    public void a() {
    }

    public void c(long j2, long j3) {
        this.f14172f = false;
        this.f14170d.a();
    }

    public void d(ExtractorOutput extractorOutput) {
        this.f14170d.d(extractorOutput, new TsPayloadReader.TrackIdGenerator(0, 1));
        extractorOutput.o();
        extractorOutput.j(new SeekMap.Unseekable(C.f9084b));
    }

    public /* synthetic */ Extractor e() {
        return d.a(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0037, code lost:
        r8.n();
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0040, code lost:
        if ((r4 - r3) < 8192) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0042, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean h(androidx.media3.extractor.ExtractorInput r8) throws java.io.IOException {
        /*
            r7 = this;
            androidx.media3.common.util.ParsableByteArray r0 = new androidx.media3.common.util.ParsableByteArray
            r1 = 10
            r0.<init>((int) r1)
            r2 = 0
            r3 = 0
        L_0x0009:
            byte[] r4 = r0.e()
            r8.s(r4, r2, r1)
            r0.Y(r2)
            int r4 = r0.O()
            r5 = 4801587(0x494433, float:6.728456E-39)
            if (r4 == r5) goto L_0x005f
            r8.n()
            r8.j(r3)
            r4 = r3
        L_0x0023:
            r1 = 0
        L_0x0024:
            byte[] r5 = r0.e()
            r6 = 6
            r8.s(r5, r2, r6)
            r0.Y(r2)
            int r5 = r0.R()
            r6 = 2935(0xb77, float:4.113E-42)
            if (r5 == r6) goto L_0x0047
            r8.n()
            int r4 = r4 + 1
            int r1 = r4 - r3
            r5 = 8192(0x2000, float:1.14794E-41)
            if (r1 < r5) goto L_0x0043
            return r2
        L_0x0043:
            r8.j(r4)
            goto L_0x0023
        L_0x0047:
            r5 = 1
            int r1 = r1 + r5
            r6 = 4
            if (r1 < r6) goto L_0x004d
            return r5
        L_0x004d:
            byte[] r5 = r0.e()
            int r5 = androidx.media3.extractor.Ac3Util.g(r5)
            r6 = -1
            if (r5 != r6) goto L_0x0059
            return r2
        L_0x0059:
            int r5 = r5 + -6
            r8.j(r5)
            goto L_0x0024
        L_0x005f:
            r4 = 3
            r0.Z(r4)
            int r4 = r0.K()
            int r5 = r4 + 10
            int r3 = r3 + r5
            r8.j(r4)
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.Ac3Extractor.h(androidx.media3.extractor.ExtractorInput):boolean");
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int read = extractorInput.read(this.f14171e.e(), 0, f14169j);
        if (read == -1) {
            return -1;
        }
        this.f14171e.Y(0);
        this.f14171e.X(read);
        if (!this.f14172f) {
            this.f14170d.e(0, 4);
            this.f14172f = true;
        }
        this.f14170d.b(this.f14171e);
        return 0;
    }
}
