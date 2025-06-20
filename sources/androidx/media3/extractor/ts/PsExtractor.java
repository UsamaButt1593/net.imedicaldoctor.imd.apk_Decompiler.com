package androidx.media3.extractor.ts;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.d;
import com.google.common.base.Ascii;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public final class PsExtractor implements Extractor {
    public static final int A = 240;
    public static final ExtractorsFactory o = new d();
    static final int p = 442;
    static final int q = 443;
    static final int r = 1;
    static final int s = 441;
    private static final int t = 256;
    private static final long u = 1048576;
    private static final long v = 8192;
    public static final int w = 189;
    public static final int x = 192;
    public static final int y = 224;
    public static final int z = 224;

    /* renamed from: d  reason: collision with root package name */
    private final TimestampAdjuster f14456d;

    /* renamed from: e  reason: collision with root package name */
    private final SparseArray<PesReader> f14457e;

    /* renamed from: f  reason: collision with root package name */
    private final ParsableByteArray f14458f;

    /* renamed from: g  reason: collision with root package name */
    private final PsDurationReader f14459g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f14460h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f14461i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f14462j;

    /* renamed from: k  reason: collision with root package name */
    private long f14463k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private PsBinarySearchSeeker f14464l;

    /* renamed from: m  reason: collision with root package name */
    private ExtractorOutput f14465m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f14466n;

    private static final class PesReader {

        /* renamed from: i  reason: collision with root package name */
        private static final int f14467i = 64;

        /* renamed from: a  reason: collision with root package name */
        private final ElementaryStreamReader f14468a;

        /* renamed from: b  reason: collision with root package name */
        private final TimestampAdjuster f14469b;

        /* renamed from: c  reason: collision with root package name */
        private final ParsableBitArray f14470c = new ParsableBitArray(new byte[64]);

        /* renamed from: d  reason: collision with root package name */
        private boolean f14471d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f14472e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f14473f;

        /* renamed from: g  reason: collision with root package name */
        private int f14474g;

        /* renamed from: h  reason: collision with root package name */
        private long f14475h;

        public PesReader(ElementaryStreamReader elementaryStreamReader, TimestampAdjuster timestampAdjuster) {
            this.f14468a = elementaryStreamReader;
            this.f14469b = timestampAdjuster;
        }

        private void b() {
            this.f14470c.s(8);
            this.f14471d = this.f14470c.g();
            this.f14472e = this.f14470c.g();
            this.f14470c.s(6);
            this.f14474g = this.f14470c.h(8);
        }

        private void c() {
            this.f14475h = 0;
            if (this.f14471d) {
                this.f14470c.s(4);
                this.f14470c.s(1);
                this.f14470c.s(1);
                long h2 = (((long) this.f14470c.h(3)) << 30) | ((long) (this.f14470c.h(15) << 15)) | ((long) this.f14470c.h(15));
                this.f14470c.s(1);
                if (!this.f14473f && this.f14472e) {
                    this.f14470c.s(4);
                    this.f14470c.s(1);
                    this.f14470c.s(1);
                    this.f14470c.s(1);
                    this.f14469b.b((((long) this.f14470c.h(3)) << 30) | ((long) (this.f14470c.h(15) << 15)) | ((long) this.f14470c.h(15)));
                    this.f14473f = true;
                }
                this.f14475h = this.f14469b.b(h2);
            }
        }

        public void a(ParsableByteArray parsableByteArray) throws ParserException {
            parsableByteArray.n(this.f14470c.f9607a, 0, 3);
            this.f14470c.q(0);
            b();
            parsableByteArray.n(this.f14470c.f9607a, 0, this.f14474g);
            this.f14470c.q(0);
            c();
            this.f14468a.e(this.f14475h, 4);
            this.f14468a.b(parsableByteArray);
            this.f14468a.c();
        }

        public void d() {
            this.f14473f = false;
            this.f14468a.a();
        }
    }

    public PsExtractor() {
        this(new TimestampAdjuster(0));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] f() {
        return new Extractor[]{new PsExtractor()};
    }

    @RequiresNonNull({"output"})
    private void g(long j2) {
        ExtractorOutput extractorOutput;
        SeekMap unseekable;
        if (!this.f14466n) {
            this.f14466n = true;
            if (this.f14459g.c() != C.f9084b) {
                PsBinarySearchSeeker psBinarySearchSeeker = new PsBinarySearchSeeker(this.f14459g.d(), this.f14459g.c(), j2);
                this.f14464l = psBinarySearchSeeker;
                extractorOutput = this.f14465m;
                unseekable = psBinarySearchSeeker.b();
            } else {
                extractorOutput = this.f14465m;
                unseekable = new SeekMap.Unseekable(this.f14459g.c());
            }
            extractorOutput.j(unseekable);
        }
    }

    public void a() {
    }

    public void c(long j2, long j3) {
        boolean z2 = true;
        boolean z3 = this.f14456d.f() == C.f9084b;
        if (!z3) {
            long d2 = this.f14456d.d();
            if (d2 == C.f9084b || d2 == 0 || d2 == j3) {
                z2 = false;
            }
            z3 = z2;
        }
        if (z3) {
            this.f14456d.i(j3);
        }
        PsBinarySearchSeeker psBinarySearchSeeker = this.f14464l;
        if (psBinarySearchSeeker != null) {
            psBinarySearchSeeker.h(j3);
        }
        for (int i2 = 0; i2 < this.f14457e.size(); i2++) {
            this.f14457e.valueAt(i2).d();
        }
    }

    public void d(ExtractorOutput extractorOutput) {
        this.f14465m = extractorOutput;
    }

    public /* synthetic */ Extractor e() {
        return d.a(this);
    }

    public boolean h(ExtractorInput extractorInput) throws IOException {
        byte[] bArr = new byte[14];
        extractorInput.s(bArr, 0, 14);
        if (p != (((bArr[0] & 255) << Ascii.B) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        extractorInput.j(bArr[13] & 7);
        extractorInput.s(bArr, 0, 3);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x00f3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int i(androidx.media3.extractor.ExtractorInput r11, androidx.media3.extractor.PositionHolder r12) throws java.io.IOException {
        /*
            r10 = this;
            androidx.media3.extractor.ExtractorOutput r0 = r10.f14465m
            androidx.media3.common.util.Assertions.k(r0)
            long r0 = r11.getLength()
            r2 = -1
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x001e
            androidx.media3.extractor.ts.PsDurationReader r5 = r10.f14459g
            boolean r5 = r5.e()
            if (r5 != 0) goto L_0x001e
            androidx.media3.extractor.ts.PsDurationReader r0 = r10.f14459g
            int r11 = r0.g(r11, r12)
            return r11
        L_0x001e:
            r10.g(r0)
            androidx.media3.extractor.ts.PsBinarySearchSeeker r5 = r10.f14464l
            if (r5 == 0) goto L_0x0032
            boolean r5 = r5.d()
            if (r5 == 0) goto L_0x0032
            androidx.media3.extractor.ts.PsBinarySearchSeeker r0 = r10.f14464l
            int r11 = r0.c(r11, r12)
            return r11
        L_0x0032:
            r11.n()
            if (r4 == 0) goto L_0x003d
            long r4 = r11.i()
            long r0 = r0 - r4
            goto L_0x003e
        L_0x003d:
            r0 = r2
        L_0x003e:
            r12 = -1
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x004a
            r2 = 4
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x004a
            return r12
        L_0x004a:
            androidx.media3.common.util.ParsableByteArray r0 = r10.f14458f
            byte[] r0 = r0.e()
            r1 = 4
            r2 = 0
            r3 = 1
            boolean r0 = r11.h(r0, r2, r1, r3)
            if (r0 != 0) goto L_0x005a
            return r12
        L_0x005a:
            androidx.media3.common.util.ParsableByteArray r0 = r10.f14458f
            r0.Y(r2)
            androidx.media3.common.util.ParsableByteArray r0 = r10.f14458f
            int r0 = r0.s()
            r1 = 441(0x1b9, float:6.18E-43)
            if (r0 != r1) goto L_0x006a
            return r12
        L_0x006a:
            r12 = 442(0x1ba, float:6.2E-43)
            if (r0 != r12) goto L_0x008e
            androidx.media3.common.util.ParsableByteArray r12 = r10.f14458f
            byte[] r12 = r12.e()
            r0 = 10
            r11.s(r12, r2, r0)
            androidx.media3.common.util.ParsableByteArray r12 = r10.f14458f
            r0 = 9
            r12.Y(r0)
            androidx.media3.common.util.ParsableByteArray r12 = r10.f14458f
            int r12 = r12.L()
            r12 = r12 & 7
            int r12 = r12 + 14
        L_0x008a:
            r11.o(r12)
            return r2
        L_0x008e:
            r12 = 443(0x1bb, float:6.21E-43)
            r1 = 2
            r4 = 6
            if (r0 != r12) goto L_0x00aa
            androidx.media3.common.util.ParsableByteArray r12 = r10.f14458f
            byte[] r12 = r12.e()
            r11.s(r12, r2, r1)
            androidx.media3.common.util.ParsableByteArray r12 = r10.f14458f
            r12.Y(r2)
            androidx.media3.common.util.ParsableByteArray r12 = r10.f14458f
            int r12 = r12.R()
            int r12 = r12 + r4
            goto L_0x008a
        L_0x00aa:
            r12 = r0 & -256(0xffffffffffffff00, float:NaN)
            int r12 = r12 >> 8
            if (r12 == r3) goto L_0x00b4
            r11.o(r3)
            return r2
        L_0x00b4:
            r12 = r0 & 255(0xff, float:3.57E-43)
            android.util.SparseArray<androidx.media3.extractor.ts.PsExtractor$PesReader> r5 = r10.f14457e
            java.lang.Object r5 = r5.get(r12)
            androidx.media3.extractor.ts.PsExtractor$PesReader r5 = (androidx.media3.extractor.ts.PsExtractor.PesReader) r5
            boolean r6 = r10.f14460h
            if (r6 != 0) goto L_0x012b
            if (r5 != 0) goto L_0x010b
            r6 = 189(0xbd, float:2.65E-43)
            if (r12 != r6) goto L_0x00d6
            androidx.media3.extractor.ts.Ac3Reader r0 = new androidx.media3.extractor.ts.Ac3Reader
            r0.<init>()
        L_0x00cd:
            r10.f14461i = r3
        L_0x00cf:
            long r6 = r11.getPosition()
            r10.f14463k = r6
            goto L_0x00f1
        L_0x00d6:
            r6 = r0 & 224(0xe0, float:3.14E-43)
            r7 = 192(0xc0, float:2.69E-43)
            if (r6 != r7) goto L_0x00e2
            androidx.media3.extractor.ts.MpegAudioReader r0 = new androidx.media3.extractor.ts.MpegAudioReader
            r0.<init>()
            goto L_0x00cd
        L_0x00e2:
            r0 = r0 & 240(0xf0, float:3.36E-43)
            r6 = 224(0xe0, float:3.14E-43)
            if (r0 != r6) goto L_0x00f0
            androidx.media3.extractor.ts.H262Reader r0 = new androidx.media3.extractor.ts.H262Reader
            r0.<init>()
            r10.f14462j = r3
            goto L_0x00cf
        L_0x00f0:
            r0 = 0
        L_0x00f1:
            if (r0 == 0) goto L_0x010b
            androidx.media3.extractor.ts.TsPayloadReader$TrackIdGenerator r5 = new androidx.media3.extractor.ts.TsPayloadReader$TrackIdGenerator
            r6 = 256(0x100, float:3.59E-43)
            r5.<init>(r12, r6)
            androidx.media3.extractor.ExtractorOutput r6 = r10.f14465m
            r0.d(r6, r5)
            androidx.media3.extractor.ts.PsExtractor$PesReader r5 = new androidx.media3.extractor.ts.PsExtractor$PesReader
            androidx.media3.common.util.TimestampAdjuster r6 = r10.f14456d
            r5.<init>(r0, r6)
            android.util.SparseArray<androidx.media3.extractor.ts.PsExtractor$PesReader> r0 = r10.f14457e
            r0.put(r12, r5)
        L_0x010b:
            boolean r12 = r10.f14461i
            if (r12 == 0) goto L_0x0119
            boolean r12 = r10.f14462j
            if (r12 == 0) goto L_0x0119
            long r6 = r10.f14463k
            r8 = 8192(0x2000, double:4.0474E-320)
            long r6 = r6 + r8
            goto L_0x011c
        L_0x0119:
            r6 = 1048576(0x100000, double:5.180654E-318)
        L_0x011c:
            long r8 = r11.getPosition()
            int r12 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r12 <= 0) goto L_0x012b
            r10.f14460h = r3
            androidx.media3.extractor.ExtractorOutput r12 = r10.f14465m
            r12.o()
        L_0x012b:
            androidx.media3.common.util.ParsableByteArray r12 = r10.f14458f
            byte[] r12 = r12.e()
            r11.s(r12, r2, r1)
            androidx.media3.common.util.ParsableByteArray r12 = r10.f14458f
            r12.Y(r2)
            androidx.media3.common.util.ParsableByteArray r12 = r10.f14458f
            int r12 = r12.R()
            int r12 = r12 + r4
            if (r5 != 0) goto L_0x0146
            r11.o(r12)
            goto L_0x0167
        L_0x0146:
            androidx.media3.common.util.ParsableByteArray r0 = r10.f14458f
            r0.U(r12)
            androidx.media3.common.util.ParsableByteArray r0 = r10.f14458f
            byte[] r0 = r0.e()
            r11.readFully(r0, r2, r12)
            androidx.media3.common.util.ParsableByteArray r11 = r10.f14458f
            r11.Y(r4)
            androidx.media3.common.util.ParsableByteArray r11 = r10.f14458f
            r5.a(r11)
            androidx.media3.common.util.ParsableByteArray r11 = r10.f14458f
            int r12 = r11.b()
            r11.X(r12)
        L_0x0167:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.PsExtractor.i(androidx.media3.extractor.ExtractorInput, androidx.media3.extractor.PositionHolder):int");
    }

    public PsExtractor(TimestampAdjuster timestampAdjuster) {
        this.f14456d = timestampAdjuster;
        this.f14458f = new ParsableByteArray(4096);
        this.f14457e = new SparseArray<>();
        this.f14459g = new PsDurationReader();
    }
}
