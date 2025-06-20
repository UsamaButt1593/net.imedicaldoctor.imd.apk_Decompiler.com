package androidx.media3.extractor.ts;

import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.ConstantBitrateSeekMap;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.d;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public final class AdtsExtractor implements Extractor {
    public static final ExtractorsFactory p = new c();
    public static final int q = 1;
    public static final int r = 2;
    private static final int s = 2048;
    private static final int t = 8192;
    private static final int u = 1000;

    /* renamed from: d  reason: collision with root package name */
    private final int f14208d;

    /* renamed from: e  reason: collision with root package name */
    private final AdtsReader f14209e;

    /* renamed from: f  reason: collision with root package name */
    private final ParsableByteArray f14210f;

    /* renamed from: g  reason: collision with root package name */
    private final ParsableByteArray f14211g;

    /* renamed from: h  reason: collision with root package name */
    private final ParsableBitArray f14212h;

    /* renamed from: i  reason: collision with root package name */
    private ExtractorOutput f14213i;

    /* renamed from: j  reason: collision with root package name */
    private long f14214j;

    /* renamed from: k  reason: collision with root package name */
    private long f14215k;

    /* renamed from: l  reason: collision with root package name */
    private int f14216l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f14217m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f14218n;
    private boolean o;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public AdtsExtractor() {
        this(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void f(androidx.media3.extractor.ExtractorInput r10) throws java.io.IOException {
        /*
            r9 = this;
            boolean r0 = r9.f14217m
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = -1
            r9.f14216l = r0
            r10.n()
            long r1 = r10.getPosition()
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0018
            r9.m(r10)
        L_0x0018:
            r1 = 0
            r2 = 0
        L_0x001a:
            r5 = 1
            androidx.media3.common.util.ParsableByteArray r6 = r9.f14211g     // Catch:{ EOFException -> 0x006c }
            byte[] r6 = r6.e()     // Catch:{ EOFException -> 0x006c }
            r7 = 2
            boolean r6 = r10.h(r6, r1, r7, r5)     // Catch:{ EOFException -> 0x006c }
            if (r6 == 0) goto L_0x0078
            androidx.media3.common.util.ParsableByteArray r6 = r9.f14211g     // Catch:{ EOFException -> 0x006c }
            r6.Y(r1)     // Catch:{ EOFException -> 0x006c }
            androidx.media3.common.util.ParsableByteArray r6 = r9.f14211g     // Catch:{ EOFException -> 0x006c }
            int r6 = r6.R()     // Catch:{ EOFException -> 0x006c }
            boolean r6 = androidx.media3.extractor.ts.AdtsReader.m(r6)     // Catch:{ EOFException -> 0x006c }
            if (r6 != 0) goto L_0x003a
            goto L_0x0079
        L_0x003a:
            androidx.media3.common.util.ParsableByteArray r6 = r9.f14211g     // Catch:{ EOFException -> 0x006c }
            byte[] r6 = r6.e()     // Catch:{ EOFException -> 0x006c }
            r7 = 4
            boolean r6 = r10.h(r6, r1, r7, r5)     // Catch:{ EOFException -> 0x006c }
            if (r6 != 0) goto L_0x0048
            goto L_0x0078
        L_0x0048:
            androidx.media3.common.util.ParsableBitArray r6 = r9.f14212h     // Catch:{ EOFException -> 0x006c }
            r7 = 14
            r6.q(r7)     // Catch:{ EOFException -> 0x006c }
            androidx.media3.common.util.ParsableBitArray r6 = r9.f14212h     // Catch:{ EOFException -> 0x006c }
            r7 = 13
            int r6 = r6.h(r7)     // Catch:{ EOFException -> 0x006c }
            r7 = 6
            if (r6 <= r7) goto L_0x006e
            long r7 = (long) r6     // Catch:{ EOFException -> 0x006c }
            long r3 = r3 + r7
            int r2 = r2 + 1
            r7 = 1000(0x3e8, float:1.401E-42)
            if (r2 != r7) goto L_0x0063
            goto L_0x006b
        L_0x0063:
            int r6 = r6 + -6
            boolean r6 = r10.q(r6, r5)     // Catch:{ EOFException -> 0x006c }
            if (r6 != 0) goto L_0x001a
        L_0x006b:
            goto L_0x0078
        L_0x006c:
            goto L_0x0078
        L_0x006e:
            r9.f14217m = r5     // Catch:{ EOFException -> 0x006c }
            java.lang.String r1 = "Malformed ADTS stream"
            r6 = 0
            androidx.media3.common.ParserException r1 = androidx.media3.common.ParserException.a(r1, r6)     // Catch:{ EOFException -> 0x006c }
            throw r1     // Catch:{ EOFException -> 0x006c }
        L_0x0078:
            r1 = r2
        L_0x0079:
            r10.n()
            if (r1 <= 0) goto L_0x0084
            long r0 = (long) r1
            long r3 = r3 / r0
            int r10 = (int) r3
            r9.f14216l = r10
            goto L_0x0086
        L_0x0084:
            r9.f14216l = r0
        L_0x0086:
            r9.f14217m = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.AdtsExtractor.f(androidx.media3.extractor.ExtractorInput):void");
    }

    private static int g(int i2, long j2) {
        return (int) ((((long) i2) * 8000000) / j2);
    }

    private SeekMap j(long j2, boolean z) {
        return new ConstantBitrateSeekMap(j2, this.f14215k, g(this.f14216l, this.f14209e.k()), this.f14216l, z);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] k() {
        return new Extractor[]{new AdtsExtractor()};
    }

    @RequiresNonNull({"extractorOutput"})
    private void l(long j2, boolean z) {
        if (!this.o) {
            boolean z2 = false;
            boolean z3 = (this.f14208d & 1) != 0 && this.f14216l > 0;
            if (!z3 || this.f14209e.k() != C.f9084b || z) {
                if (!z3 || this.f14209e.k() == C.f9084b) {
                    this.f14213i.j(new SeekMap.Unseekable(C.f9084b));
                } else {
                    ExtractorOutput extractorOutput = this.f14213i;
                    if ((this.f14208d & 2) != 0) {
                        z2 = true;
                    }
                    extractorOutput.j(j(j2, z2));
                }
                this.o = true;
            }
        }
    }

    private int m(ExtractorInput extractorInput) throws IOException {
        int i2 = 0;
        while (true) {
            extractorInput.s(this.f14211g.e(), 0, 10);
            this.f14211g.Y(0);
            if (this.f14211g.O() != 4801587) {
                break;
            }
            this.f14211g.Z(3);
            int K = this.f14211g.K();
            i2 += K + 10;
            extractorInput.j(K);
        }
        extractorInput.n();
        extractorInput.j(i2);
        if (this.f14215k == -1) {
            this.f14215k = (long) i2;
        }
        return i2;
    }

    public void a() {
    }

    public void c(long j2, long j3) {
        this.f14218n = false;
        this.f14209e.a();
        this.f14214j = j3;
    }

    public void d(ExtractorOutput extractorOutput) {
        this.f14213i = extractorOutput;
        this.f14209e.d(extractorOutput, new TsPayloadReader.TrackIdGenerator(0, 1));
        extractorOutput.o();
    }

    public /* synthetic */ Extractor e() {
        return d.a(this);
    }

    public boolean h(ExtractorInput extractorInput) throws IOException {
        int m2 = m(extractorInput);
        int i2 = m2;
        int i3 = 0;
        int i4 = 0;
        do {
            extractorInput.s(this.f14211g.e(), 0, 2);
            this.f14211g.Y(0);
            if (AdtsReader.m(this.f14211g.R())) {
                i3++;
                if (i3 >= 4 && i4 > 188) {
                    return true;
                }
                extractorInput.s(this.f14211g.e(), 0, 4);
                this.f14212h.q(14);
                int h2 = this.f14212h.h(13);
                if (h2 > 6) {
                    extractorInput.j(h2 - 6);
                    i4 += h2;
                }
            }
            i2++;
            extractorInput.n();
            extractorInput.j(i2);
            i3 = 0;
            i4 = 0;
        } while (i2 - m2 < 8192);
        return false;
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        Assertions.k(this.f14213i);
        long length = extractorInput.getLength();
        int i2 = this.f14208d;
        if (!((i2 & 2) == 0 && ((i2 & 1) == 0 || length == -1))) {
            f(extractorInput);
        }
        int read = extractorInput.read(this.f14210f.e(), 0, 2048);
        boolean z = read == -1;
        l(length, z);
        if (z) {
            return -1;
        }
        this.f14210f.Y(0);
        this.f14210f.X(read);
        if (!this.f14218n) {
            this.f14209e.e(this.f14214j, 4);
            this.f14218n = true;
        }
        this.f14209e.b(this.f14210f);
        return 0;
    }

    public AdtsExtractor(int i2) {
        this.f14208d = (i2 & 2) != 0 ? i2 | 1 : i2;
        this.f14209e = new AdtsReader(true);
        this.f14210f = new ParsableByteArray(2048);
        this.f14216l = -1;
        this.f14215k = -1;
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        this.f14211g = parsableByteArray;
        this.f14212h = new ParsableBitArray(parsableByteArray.e());
    }
}
