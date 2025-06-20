package androidx.media3.extractor.amr;

import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ConstantBitrateSeekMap;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.d;
import java.io.EOFException;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public final class AmrExtractor implements Extractor {
    private static final int A = 20;
    private static final int B = 16000;
    private static final int C = 8000;
    private static final int D = 20000;
    public static final ExtractorsFactory s = new a();
    public static final int t = 1;
    public static final int u = 2;
    private static final int[] v = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    private static final int[] w;
    private static final byte[] x = Util.R0("#!AMR\n");
    private static final byte[] y = Util.R0("#!AMR-WB\n");
    private static final int z;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f13180d;

    /* renamed from: e  reason: collision with root package name */
    private final int f13181e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f13182f;

    /* renamed from: g  reason: collision with root package name */
    private long f13183g;

    /* renamed from: h  reason: collision with root package name */
    private int f13184h;

    /* renamed from: i  reason: collision with root package name */
    private int f13185i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f13186j;

    /* renamed from: k  reason: collision with root package name */
    private long f13187k;

    /* renamed from: l  reason: collision with root package name */
    private int f13188l;

    /* renamed from: m  reason: collision with root package name */
    private int f13189m;

    /* renamed from: n  reason: collision with root package name */
    private long f13190n;
    private ExtractorOutput o;
    private TrackOutput p;
    private SeekMap q;
    private boolean r;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        w = iArr;
        z = iArr[8];
    }

    public AmrExtractor() {
        this(0);
    }

    static byte[] f() {
        byte[] bArr = x;
        return Arrays.copyOf(bArr, bArr.length);
    }

    static byte[] g() {
        byte[] bArr = y;
        return Arrays.copyOf(bArr, bArr.length);
    }

    @EnsuresNonNull({"extractorOutput", "trackOutput"})
    private void j() {
        Assertions.k(this.p);
        Util.o(this.o);
    }

    static int k(int i2) {
        return v[i2];
    }

    static int l(int i2) {
        return w[i2];
    }

    private static int m(int i2, long j2) {
        return (int) ((((long) i2) * 8000000) / j2);
    }

    private SeekMap n(long j2, boolean z2) {
        return new ConstantBitrateSeekMap(j2, this.f13187k, m(this.f13188l, 20000), this.f13188l, z2);
    }

    private int o(int i2) throws ParserException {
        if (q(i2)) {
            return this.f13182f ? w[i2] : v[i2];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Illegal AMR ");
        sb.append(this.f13182f ? "WB" : "NB");
        sb.append(" frame type ");
        sb.append(i2);
        throw ParserException.a(sb.toString(), (Throwable) null);
    }

    private boolean p(int i2) {
        return !this.f13182f && (i2 < 12 || i2 > 14);
    }

    private boolean q(int i2) {
        return i2 >= 0 && i2 <= 15 && (r(i2) || p(i2));
    }

    private boolean r(int i2) {
        return this.f13182f && (i2 < 10 || i2 > 13);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] s() {
        return new Extractor[]{new AmrExtractor()};
    }

    @RequiresNonNull({"trackOutput"})
    private void t() {
        if (!this.r) {
            this.r = true;
            boolean z2 = this.f13182f;
            this.p.e(new Format.Builder().k0(z2 ? MimeTypes.d0 : MimeTypes.c0).c0(z).L(1).l0(z2 ? 16000 : 8000).I());
        }
    }

    @RequiresNonNull({"extractorOutput"})
    private void u(long j2, int i2) {
        SeekMap unseekable;
        int i3;
        if (!this.f13186j) {
            int i4 = this.f13181e;
            if ((i4 & 1) == 0 || j2 == -1 || !((i3 = this.f13188l) == -1 || i3 == this.f13184h)) {
                unseekable = new SeekMap.Unseekable(C.f9084b);
            } else if (this.f13189m >= 20 || i2 == -1) {
                unseekable = n(j2, (i4 & 2) != 0);
            } else {
                return;
            }
            this.q = unseekable;
            this.o.j(unseekable);
            this.f13186j = true;
        }
    }

    private static boolean v(ExtractorInput extractorInput, byte[] bArr) throws IOException {
        extractorInput.n();
        byte[] bArr2 = new byte[bArr.length];
        extractorInput.s(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    private int w(ExtractorInput extractorInput) throws IOException {
        extractorInput.n();
        extractorInput.s(this.f13180d, 0, 1);
        byte b2 = this.f13180d[0];
        if ((b2 & 131) <= 0) {
            return o((b2 >> 3) & 15);
        }
        throw ParserException.a("Invalid padding bits for frame header " + b2, (Throwable) null);
    }

    private boolean x(ExtractorInput extractorInput) throws IOException {
        int length;
        byte[] bArr = x;
        if (v(extractorInput, bArr)) {
            this.f13182f = false;
            length = bArr.length;
        } else {
            byte[] bArr2 = y;
            if (!v(extractorInput, bArr2)) {
                return false;
            }
            this.f13182f = true;
            length = bArr2.length;
        }
        extractorInput.o(length);
        return true;
    }

    @RequiresNonNull({"trackOutput"})
    private int y(ExtractorInput extractorInput) throws IOException {
        if (this.f13185i == 0) {
            try {
                int w2 = w(extractorInput);
                this.f13184h = w2;
                this.f13185i = w2;
                if (this.f13188l == -1) {
                    this.f13187k = extractorInput.getPosition();
                    this.f13188l = this.f13184h;
                }
                if (this.f13188l == this.f13184h) {
                    this.f13189m++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int b2 = this.p.b(extractorInput, this.f13185i, true);
        if (b2 == -1) {
            return -1;
        }
        int i2 = this.f13185i - b2;
        this.f13185i = i2;
        if (i2 > 0) {
            return 0;
        }
        this.p.f(this.f13190n + this.f13183g, 1, this.f13184h, 0, (TrackOutput.CryptoData) null);
        this.f13183g += 20000;
        return 0;
    }

    public void a() {
    }

    public void c(long j2, long j3) {
        this.f13183g = 0;
        this.f13184h = 0;
        this.f13185i = 0;
        if (j2 != 0) {
            SeekMap seekMap = this.q;
            if (seekMap instanceof ConstantBitrateSeekMap) {
                this.f13190n = ((ConstantBitrateSeekMap) seekMap).c(j2);
                return;
            }
        }
        this.f13190n = 0;
    }

    public void d(ExtractorOutput extractorOutput) {
        this.o = extractorOutput;
        this.p = extractorOutput.d(0, 1);
        extractorOutput.o();
    }

    public /* synthetic */ Extractor e() {
        return d.a(this);
    }

    public boolean h(ExtractorInput extractorInput) throws IOException {
        return x(extractorInput);
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        j();
        if (extractorInput.getPosition() != 0 || x(extractorInput)) {
            t();
            int y2 = y(extractorInput);
            u(extractorInput.getLength(), y2);
            return y2;
        }
        throw ParserException.a("Could not find AMR header.", (Throwable) null);
    }

    public AmrExtractor(int i2) {
        this.f13181e = (i2 & 2) != 0 ? i2 | 1 : i2;
        this.f13180d = new byte[1];
        this.f13188l = -1;
    }
}
