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
public final class Ac4Extractor implements Extractor {

    /* renamed from: g  reason: collision with root package name */
    public static final ExtractorsFactory f14187g = new b();

    /* renamed from: h  reason: collision with root package name */
    private static final int f14188h = 8192;

    /* renamed from: i  reason: collision with root package name */
    private static final int f14189i = 16384;

    /* renamed from: j  reason: collision with root package name */
    private static final int f14190j = 7;

    /* renamed from: d  reason: collision with root package name */
    private final Ac4Reader f14191d = new Ac4Reader();

    /* renamed from: e  reason: collision with root package name */
    private final ParsableByteArray f14192e = new ParsableByteArray(16384);

    /* renamed from: f  reason: collision with root package name */
    private boolean f14193f;

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] f() {
        return new Extractor[]{new Ac4Extractor()};
    }

    public void a() {
    }

    public void c(long j2, long j3) {
        this.f14193f = false;
        this.f14191d.a();
    }

    public void d(ExtractorOutput extractorOutput) {
        this.f14191d.d(extractorOutput, new TsPayloadReader.TrackIdGenerator(0, 1));
        extractorOutput.o();
        extractorOutput.j(new SeekMap.Unseekable(C.f9084b));
    }

    public /* synthetic */ Extractor e() {
        return d.a(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0046, code lost:
        if ((r4 - r3) < 8192) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0048, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003d, code lost:
        r9.n();
        r4 = r4 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean h(androidx.media3.extractor.ExtractorInput r9) throws java.io.IOException {
        /*
            r8 = this;
            androidx.media3.common.util.ParsableByteArray r0 = new androidx.media3.common.util.ParsableByteArray
            r1 = 10
            r0.<init>((int) r1)
            r2 = 0
            r3 = 0
        L_0x0009:
            byte[] r4 = r0.e()
            r9.s(r4, r2, r1)
            r0.Y(r2)
            int r4 = r0.O()
            r5 = 4801587(0x494433, float:6.728456E-39)
            if (r4 == r5) goto L_0x0065
            r9.n()
            r9.j(r3)
            r4 = r3
        L_0x0023:
            r1 = 0
        L_0x0024:
            byte[] r5 = r0.e()
            r6 = 7
            r9.s(r5, r2, r6)
            r0.Y(r2)
            int r5 = r0.R()
            r6 = 44096(0xac40, float:6.1792E-41)
            if (r5 == r6) goto L_0x004d
            r6 = 44097(0xac41, float:6.1793E-41)
            if (r5 == r6) goto L_0x004d
            r9.n()
            int r4 = r4 + 1
            int r1 = r4 - r3
            r5 = 8192(0x2000, float:1.14794E-41)
            if (r1 < r5) goto L_0x0049
            return r2
        L_0x0049:
            r9.j(r4)
            goto L_0x0023
        L_0x004d:
            r6 = 1
            int r1 = r1 + r6
            r7 = 4
            if (r1 < r7) goto L_0x0053
            return r6
        L_0x0053:
            byte[] r6 = r0.e()
            int r5 = androidx.media3.extractor.Ac4Util.e(r6, r5)
            r6 = -1
            if (r5 != r6) goto L_0x005f
            return r2
        L_0x005f:
            int r5 = r5 + -7
            r9.j(r5)
            goto L_0x0024
        L_0x0065:
            r4 = 3
            r0.Z(r4)
            int r4 = r0.K()
            int r5 = r4 + 10
            int r3 = r3 + r5
            r9.j(r4)
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.Ac4Extractor.h(androidx.media3.extractor.ExtractorInput):boolean");
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int read = extractorInput.read(this.f14192e.e(), 0, 16384);
        if (read == -1) {
            return -1;
        }
        this.f14192e.Y(0);
        this.f14192e.X(read);
        if (!this.f14193f) {
            this.f14191d.e(0, 4);
            this.f14193f = true;
        }
        this.f14191d.b(this.f14192e);
        return 0;
    }
}
