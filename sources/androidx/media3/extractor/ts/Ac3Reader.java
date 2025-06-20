package androidx.media3.extractor.ts;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.Ac3Util;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public final class Ac3Reader implements ElementaryStreamReader {

    /* renamed from: n  reason: collision with root package name */
    private static final int f14173n = 0;
    private static final int o = 1;
    private static final int p = 2;
    private static final int q = 128;

    /* renamed from: a  reason: collision with root package name */
    private final ParsableBitArray f14174a;

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f14175b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final String f14176c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14177d;

    /* renamed from: e  reason: collision with root package name */
    private String f14178e;

    /* renamed from: f  reason: collision with root package name */
    private TrackOutput f14179f;

    /* renamed from: g  reason: collision with root package name */
    private int f14180g;

    /* renamed from: h  reason: collision with root package name */
    private int f14181h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f14182i;

    /* renamed from: j  reason: collision with root package name */
    private long f14183j;

    /* renamed from: k  reason: collision with root package name */
    private Format f14184k;

    /* renamed from: l  reason: collision with root package name */
    private int f14185l;

    /* renamed from: m  reason: collision with root package name */
    private long f14186m;

    public Ac3Reader() {
        this((String) null, 0);
    }

    private boolean f(ParsableByteArray parsableByteArray, byte[] bArr, int i2) {
        int min = Math.min(parsableByteArray.a(), i2 - this.f14181h);
        parsableByteArray.n(bArr, this.f14181h, min);
        int i3 = this.f14181h + min;
        this.f14181h = i3;
        return i3 == i2;
    }

    @RequiresNonNull({"output"})
    private void g() {
        this.f14174a.q(0);
        Ac3Util.SyncFrameInfo f2 = Ac3Util.f(this.f14174a);
        Format format = this.f14184k;
        if (format == null || f2.f12908d != format.s3 || f2.f12907c != format.t3 || !Util.g(f2.f12905a, format.f3)) {
            Format.Builder f0 = new Format.Builder().X(this.f14178e).k0(f2.f12905a).L(f2.f12908d).l0(f2.f12907c).b0(this.f14176c).i0(this.f14177d).f0(f2.f12911g);
            if (MimeTypes.Q.equals(f2.f12905a)) {
                f0.K(f2.f12911g);
            }
            Format I = f0.I();
            this.f14184k = I;
            this.f14179f.e(I);
        }
        this.f14185l = f2.f12909e;
        this.f14183j = (((long) f2.f12910f) * 1000000) / ((long) this.f14184k.t3);
    }

    private boolean h(ParsableByteArray parsableByteArray) {
        while (true) {
            boolean z = false;
            if (parsableByteArray.a() <= 0) {
                return false;
            }
            if (this.f14182i) {
                int L = parsableByteArray.L();
                if (L == 119) {
                    this.f14182i = false;
                    return true;
                } else if (L != 11) {
                    this.f14182i = z;
                }
            } else if (parsableByteArray.L() != 11) {
                this.f14182i = z;
            }
            z = true;
            this.f14182i = z;
        }
    }

    public void a() {
        this.f14180g = 0;
        this.f14181h = 0;
        this.f14182i = false;
        this.f14186m = C.f9084b;
    }

    public void b(ParsableByteArray parsableByteArray) {
        Assertions.k(this.f14179f);
        while (parsableByteArray.a() > 0) {
            int i2 = this.f14180g;
            boolean z = true;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        int min = Math.min(parsableByteArray.a(), this.f14185l - this.f14181h);
                        this.f14179f.d(parsableByteArray, min);
                        int i3 = this.f14181h + min;
                        this.f14181h = i3;
                        if (i3 == this.f14185l) {
                            if (this.f14186m == C.f9084b) {
                                z = false;
                            }
                            Assertions.i(z);
                            this.f14179f.f(this.f14186m, 1, this.f14185l, 0, (TrackOutput.CryptoData) null);
                            this.f14186m += this.f14183j;
                            this.f14180g = 0;
                        }
                    }
                } else if (f(parsableByteArray, this.f14175b.e(), 128)) {
                    g();
                    this.f14175b.Y(0);
                    this.f14179f.d(this.f14175b, 128);
                    this.f14180g = 2;
                }
            } else if (h(parsableByteArray)) {
                this.f14180g = 1;
                this.f14175b.e()[0] = 11;
                this.f14175b.e()[1] = 119;
                this.f14181h = 2;
            }
        }
    }

    public void c() {
    }

    public void d(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f14178e = trackIdGenerator.b();
        this.f14179f = extractorOutput.d(trackIdGenerator.c(), 1);
    }

    public void e(long j2, int i2) {
        this.f14186m = j2;
    }

    public Ac3Reader(@Nullable String str, int i2) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(new byte[128]);
        this.f14174a = parsableBitArray;
        this.f14175b = new ParsableByteArray(parsableBitArray.f9607a);
        this.f14180g = 0;
        this.f14186m = C.f9084b;
        this.f14176c = str;
        this.f14177d = i2;
    }
}
