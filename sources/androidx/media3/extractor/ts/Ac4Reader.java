package androidx.media3.extractor.ts;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.Ac4Util;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public final class Ac4Reader implements ElementaryStreamReader {
    private static final int o = 0;
    private static final int p = 1;
    private static final int q = 2;

    /* renamed from: a  reason: collision with root package name */
    private final ParsableBitArray f14194a;

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f14195b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final String f14196c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14197d;

    /* renamed from: e  reason: collision with root package name */
    private String f14198e;

    /* renamed from: f  reason: collision with root package name */
    private TrackOutput f14199f;

    /* renamed from: g  reason: collision with root package name */
    private int f14200g;

    /* renamed from: h  reason: collision with root package name */
    private int f14201h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f14202i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f14203j;

    /* renamed from: k  reason: collision with root package name */
    private long f14204k;

    /* renamed from: l  reason: collision with root package name */
    private Format f14205l;

    /* renamed from: m  reason: collision with root package name */
    private int f14206m;

    /* renamed from: n  reason: collision with root package name */
    private long f14207n;

    public Ac4Reader() {
        this((String) null, 0);
    }

    private boolean f(ParsableByteArray parsableByteArray, byte[] bArr, int i2) {
        int min = Math.min(parsableByteArray.a(), i2 - this.f14201h);
        parsableByteArray.n(bArr, this.f14201h, min);
        int i3 = this.f14201h + min;
        this.f14201h = i3;
        return i3 == i2;
    }

    @RequiresNonNull({"output"})
    private void g() {
        this.f14194a.q(0);
        Ac4Util.SyncFrameInfo d2 = Ac4Util.d(this.f14194a);
        Format format = this.f14205l;
        if (format == null || d2.f12921c != format.s3 || d2.f12920b != format.t3 || !MimeTypes.T.equals(format.f3)) {
            Format I = new Format.Builder().X(this.f14198e).k0(MimeTypes.T).L(d2.f12921c).l0(d2.f12920b).b0(this.f14196c).i0(this.f14197d).I();
            this.f14205l = I;
            this.f14199f.e(I);
        }
        this.f14206m = d2.f12922d;
        this.f14204k = (((long) d2.f12923e) * 1000000) / ((long) this.f14205l.t3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean h(androidx.media3.common.util.ParsableByteArray r6) {
        /*
            r5 = this;
        L_0x0000:
            int r0 = r6.a()
            r1 = 0
            if (r0 <= 0) goto L_0x0031
            boolean r0 = r5.f14202i
            r2 = 172(0xac, float:2.41E-43)
            r3 = 1
            if (r0 != 0) goto L_0x0018
            int r0 = r6.L()
            if (r0 != r2) goto L_0x0015
            r1 = 1
        L_0x0015:
            r5.f14202i = r1
            goto L_0x0000
        L_0x0018:
            int r0 = r6.L()
            if (r0 != r2) goto L_0x0020
            r2 = 1
            goto L_0x0021
        L_0x0020:
            r2 = 0
        L_0x0021:
            r5.f14202i = r2
            r2 = 64
            r4 = 65
            if (r0 == r2) goto L_0x002b
            if (r0 != r4) goto L_0x0000
        L_0x002b:
            if (r0 != r4) goto L_0x002e
            r1 = 1
        L_0x002e:
            r5.f14203j = r1
            return r3
        L_0x0031:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.Ac4Reader.h(androidx.media3.common.util.ParsableByteArray):boolean");
    }

    public void a() {
        this.f14200g = 0;
        this.f14201h = 0;
        this.f14202i = false;
        this.f14203j = false;
        this.f14207n = C.f9084b;
    }

    public void b(ParsableByteArray parsableByteArray) {
        Assertions.k(this.f14199f);
        while (parsableByteArray.a() > 0) {
            int i2 = this.f14200g;
            boolean z = true;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        int min = Math.min(parsableByteArray.a(), this.f14206m - this.f14201h);
                        this.f14199f.d(parsableByteArray, min);
                        int i3 = this.f14201h + min;
                        this.f14201h = i3;
                        if (i3 == this.f14206m) {
                            if (this.f14207n == C.f9084b) {
                                z = false;
                            }
                            Assertions.i(z);
                            this.f14199f.f(this.f14207n, 1, this.f14206m, 0, (TrackOutput.CryptoData) null);
                            this.f14207n += this.f14204k;
                            this.f14200g = 0;
                        }
                    }
                } else if (f(parsableByteArray, this.f14195b.e(), 16)) {
                    g();
                    this.f14195b.Y(0);
                    this.f14199f.d(this.f14195b, 16);
                    this.f14200g = 2;
                }
            } else if (h(parsableByteArray)) {
                this.f14200g = 1;
                this.f14195b.e()[0] = -84;
                this.f14195b.e()[1] = (byte) (this.f14203j ? 65 : 64);
                this.f14201h = 2;
            }
        }
    }

    public void c() {
    }

    public void d(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f14198e = trackIdGenerator.b();
        this.f14199f = extractorOutput.d(trackIdGenerator.c(), 1);
    }

    public void e(long j2, int i2) {
        this.f14207n = j2;
    }

    public Ac4Reader(@Nullable String str, int i2) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(new byte[16]);
        this.f14194a = parsableBitArray;
        this.f14195b = new ParsableByteArray(parsableBitArray.f9607a);
        this.f14200g = 0;
        this.f14201h = 0;
        this.f14202i = false;
        this.f14203j = false;
        this.f14207n = C.f9084b;
        this.f14196c = str;
        this.f14197d = i2;
    }
}
