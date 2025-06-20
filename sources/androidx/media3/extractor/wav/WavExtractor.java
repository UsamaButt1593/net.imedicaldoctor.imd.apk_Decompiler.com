package androidx.media3.extractor.wav;

import android.util.Pair;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.d;
import androidx.media3.extractor.ts.TsExtractor;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.io.IOException;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.httpclient.HttpStatus;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

@UnstableApi
public final class WavExtractor implements Extractor {

    /* renamed from: k  reason: collision with root package name */
    private static final String f14555k = "WavExtractor";

    /* renamed from: l  reason: collision with root package name */
    private static final int f14556l = 10;

    /* renamed from: m  reason: collision with root package name */
    public static final ExtractorsFactory f14557m = new a();

    /* renamed from: n  reason: collision with root package name */
    private static final int f14558n = 0;
    private static final int o = 1;
    private static final int p = 2;
    private static final int q = 3;
    private static final int r = 4;

    /* renamed from: d  reason: collision with root package name */
    private ExtractorOutput f14559d;

    /* renamed from: e  reason: collision with root package name */
    private TrackOutput f14560e;

    /* renamed from: f  reason: collision with root package name */
    private int f14561f = 0;

    /* renamed from: g  reason: collision with root package name */
    private long f14562g = -1;

    /* renamed from: h  reason: collision with root package name */
    private OutputWriter f14563h;

    /* renamed from: i  reason: collision with root package name */
    private int f14564i = -1;

    /* renamed from: j  reason: collision with root package name */
    private long f14565j = -1;

    private static final class ImaAdPcmOutputWriter implements OutputWriter {

        /* renamed from: m  reason: collision with root package name */
        private static final int[] f14566m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

        /* renamed from: n  reason: collision with root package name */
        private static final int[] f14567n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, TsExtractor.L, 143, 157, 173, 190, 209, 230, 253, TIFFConstants.t0, 307, TIFFConstants.G1, 371, HttpStatus.SC_REQUEST_TIMEOUT, 449, 494, MetaDo.N, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

        /* renamed from: a  reason: collision with root package name */
        private final ExtractorOutput f14568a;

        /* renamed from: b  reason: collision with root package name */
        private final TrackOutput f14569b;

        /* renamed from: c  reason: collision with root package name */
        private final WavFormat f14570c;

        /* renamed from: d  reason: collision with root package name */
        private final int f14571d;

        /* renamed from: e  reason: collision with root package name */
        private final byte[] f14572e;

        /* renamed from: f  reason: collision with root package name */
        private final ParsableByteArray f14573f;

        /* renamed from: g  reason: collision with root package name */
        private final int f14574g;

        /* renamed from: h  reason: collision with root package name */
        private final Format f14575h;

        /* renamed from: i  reason: collision with root package name */
        private int f14576i;

        /* renamed from: j  reason: collision with root package name */
        private long f14577j;

        /* renamed from: k  reason: collision with root package name */
        private int f14578k;

        /* renamed from: l  reason: collision with root package name */
        private long f14579l;

        public ImaAdPcmOutputWriter(ExtractorOutput extractorOutput, TrackOutput trackOutput, WavFormat wavFormat) throws ParserException {
            this.f14568a = extractorOutput;
            this.f14569b = trackOutput;
            this.f14570c = wavFormat;
            int max = Math.max(1, wavFormat.f14590c / 10);
            this.f14574g = max;
            ParsableByteArray parsableByteArray = new ParsableByteArray(wavFormat.f14594g);
            parsableByteArray.D();
            int D = parsableByteArray.D();
            this.f14571d = D;
            int i2 = wavFormat.f14589b;
            int i3 = (((wavFormat.f14592e - (i2 * 4)) * 8) / (wavFormat.f14593f * i2)) + 1;
            if (D == i3) {
                int q = Util.q(max, D);
                this.f14572e = new byte[(wavFormat.f14592e * q)];
                this.f14573f = new ParsableByteArray(q * h(D, i2));
                int i4 = ((wavFormat.f14590c * wavFormat.f14592e) * 8) / D;
                this.f14575h = new Format.Builder().k0(MimeTypes.N).K(i4).f0(i4).c0(h(max, i2)).L(wavFormat.f14589b).l0(wavFormat.f14590c).e0(2).I();
                return;
            }
            throw ParserException.a("Expected frames per block: " + i3 + "; got: " + D, (Throwable) null);
        }

        private void d(byte[] bArr, int i2, ParsableByteArray parsableByteArray) {
            for (int i3 = 0; i3 < i2; i3++) {
                for (int i4 = 0; i4 < this.f14570c.f14589b; i4++) {
                    e(bArr, i3, i4, parsableByteArray.e());
                }
            }
            int g2 = g(this.f14571d * i2);
            parsableByteArray.Y(0);
            parsableByteArray.X(g2);
        }

        private void e(byte[] bArr, int i2, int i3, byte[] bArr2) {
            WavFormat wavFormat = this.f14570c;
            int i4 = wavFormat.f14592e;
            int i5 = wavFormat.f14589b;
            int i6 = (i2 * i4) + (i3 * 4);
            int i7 = (i5 * 4) + i6;
            int i8 = (i4 / i5) - 4;
            int i9 = (short) (((bArr[i6 + 1] & 255) << 8) | (bArr[i6] & 255));
            int min = Math.min(bArr[i6 + 2] & 255, 88);
            int i10 = f14567n[min];
            int i11 = ((i2 * this.f14571d * i5) + i3) * 2;
            bArr2[i11] = (byte) (i9 & 255);
            bArr2[i11 + 1] = (byte) (i9 >> 8);
            for (int i12 = 0; i12 < i8 * 2; i12++) {
                byte b2 = bArr[((i12 / 8) * i5 * 4) + i7 + ((i12 / 2) % 4)];
                int i13 = i12 % 2 == 0 ? b2 & 15 : (b2 & 255) >> 4;
                int i14 = ((((i13 & 7) * 2) + 1) * i10) >> 3;
                if ((i13 & 8) != 0) {
                    i14 = -i14;
                }
                i9 = Util.w(i9 + i14, -32768, 32767);
                i11 += i5 * 2;
                bArr2[i11] = (byte) (i9 & 255);
                bArr2[i11 + 1] = (byte) (i9 >> 8);
                int i15 = min + f14566m[i13];
                int[] iArr = f14567n;
                min = Util.w(i15, 0, iArr.length - 1);
                i10 = iArr[min];
            }
        }

        private int f(int i2) {
            return i2 / (this.f14570c.f14589b * 2);
        }

        private int g(int i2) {
            return h(i2, this.f14570c.f14589b);
        }

        private static int h(int i2, int i3) {
            return i2 * 2 * i3;
        }

        private void i(int i2) {
            long c2 = this.f14577j + Util.c2(this.f14579l, 1000000, (long) this.f14570c.f14590c);
            int g2 = g(i2);
            this.f14569b.f(c2, 1, g2, this.f14578k - g2, (TrackOutput.CryptoData) null);
            this.f14579l += (long) i2;
            this.f14578k -= g2;
        }

        public void a(long j2) {
            this.f14576i = 0;
            this.f14577j = j2;
            this.f14578k = 0;
            this.f14579l = 0;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x003f A[EDGE_INSN: B:22:0x003f->B:10:0x003f ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:5:0x0021  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean b(androidx.media3.extractor.ExtractorInput r7, long r8) throws java.io.IOException {
            /*
                r6 = this;
                int r0 = r6.f14574g
                int r1 = r6.f14578k
                int r1 = r6.f(r1)
                int r0 = r0 - r1
                int r1 = r6.f14571d
                int r0 = androidx.media3.common.util.Util.q(r0, r1)
                androidx.media3.extractor.wav.WavFormat r1 = r6.f14570c
                int r1 = r1.f14592e
                int r0 = r0 * r1
                r1 = 0
                r3 = 1
                int r4 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                if (r4 != 0) goto L_0x001e
            L_0x001c:
                r1 = 1
                goto L_0x001f
            L_0x001e:
                r1 = 0
            L_0x001f:
                if (r1 != 0) goto L_0x003f
                int r2 = r6.f14576i
                if (r2 >= r0) goto L_0x003f
                int r2 = r0 - r2
                long r4 = (long) r2
                long r4 = java.lang.Math.min(r4, r8)
                int r2 = (int) r4
                byte[] r4 = r6.f14572e
                int r5 = r6.f14576i
                int r2 = r7.read(r4, r5, r2)
                r4 = -1
                if (r2 != r4) goto L_0x0039
                goto L_0x001c
            L_0x0039:
                int r4 = r6.f14576i
                int r4 = r4 + r2
                r6.f14576i = r4
                goto L_0x001f
            L_0x003f:
                int r7 = r6.f14576i
                androidx.media3.extractor.wav.WavFormat r8 = r6.f14570c
                int r8 = r8.f14592e
                int r7 = r7 / r8
                if (r7 <= 0) goto L_0x0077
                byte[] r8 = r6.f14572e
                androidx.media3.common.util.ParsableByteArray r9 = r6.f14573f
                r6.d(r8, r7, r9)
                int r8 = r6.f14576i
                androidx.media3.extractor.wav.WavFormat r9 = r6.f14570c
                int r9 = r9.f14592e
                int r7 = r7 * r9
                int r8 = r8 - r7
                r6.f14576i = r8
                androidx.media3.common.util.ParsableByteArray r7 = r6.f14573f
                int r7 = r7.g()
                androidx.media3.extractor.TrackOutput r8 = r6.f14569b
                androidx.media3.common.util.ParsableByteArray r9 = r6.f14573f
                r8.d(r9, r7)
                int r8 = r6.f14578k
                int r8 = r8 + r7
                r6.f14578k = r8
                int r7 = r6.f(r8)
                int r8 = r6.f14574g
                if (r7 < r8) goto L_0x0077
                r6.i(r8)
            L_0x0077:
                if (r1 == 0) goto L_0x0084
                int r7 = r6.f14578k
                int r7 = r6.f(r7)
                if (r7 <= 0) goto L_0x0084
                r6.i(r7)
            L_0x0084:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.wav.WavExtractor.ImaAdPcmOutputWriter.b(androidx.media3.extractor.ExtractorInput, long):boolean");
        }

        public void c(int i2, long j2) {
            this.f14568a.j(new WavSeekMap(this.f14570c, this.f14571d, (long) i2, j2));
            this.f14569b.e(this.f14575h);
        }
    }

    private interface OutputWriter {
        void a(long j2);

        boolean b(ExtractorInput extractorInput, long j2) throws IOException;

        void c(int i2, long j2) throws ParserException;
    }

    private static final class PassthroughOutputWriter implements OutputWriter {

        /* renamed from: a  reason: collision with root package name */
        private final ExtractorOutput f14580a;

        /* renamed from: b  reason: collision with root package name */
        private final TrackOutput f14581b;

        /* renamed from: c  reason: collision with root package name */
        private final WavFormat f14582c;

        /* renamed from: d  reason: collision with root package name */
        private final Format f14583d;

        /* renamed from: e  reason: collision with root package name */
        private final int f14584e;

        /* renamed from: f  reason: collision with root package name */
        private long f14585f;

        /* renamed from: g  reason: collision with root package name */
        private int f14586g;

        /* renamed from: h  reason: collision with root package name */
        private long f14587h;

        public PassthroughOutputWriter(ExtractorOutput extractorOutput, TrackOutput trackOutput, WavFormat wavFormat, String str, int i2) throws ParserException {
            this.f14580a = extractorOutput;
            this.f14581b = trackOutput;
            this.f14582c = wavFormat;
            int i3 = (wavFormat.f14589b * wavFormat.f14593f) / 8;
            if (wavFormat.f14592e == i3) {
                int i4 = wavFormat.f14590c;
                int i5 = i4 * i3 * 8;
                int max = Math.max(i3, (i4 * i3) / 10);
                this.f14584e = max;
                this.f14583d = new Format.Builder().k0(str).K(i5).f0(i5).c0(max).L(wavFormat.f14589b).l0(wavFormat.f14590c).e0(i2).I();
                return;
            }
            throw ParserException.a("Expected block size: " + i3 + "; got: " + wavFormat.f14592e, (Throwable) null);
        }

        public void a(long j2) {
            this.f14585f = j2;
            this.f14586g = 0;
            this.f14587h = 0;
        }

        public boolean b(ExtractorInput extractorInput, long j2) throws IOException {
            int i2;
            int i3;
            int i4;
            long j3 = j2;
            while (true) {
                i2 = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
                if (i2 <= 0 || (i3 = this.f14586g) >= (i4 = this.f14584e)) {
                    WavFormat wavFormat = this.f14582c;
                    int i5 = wavFormat.f14592e;
                    int i6 = this.f14586g / i5;
                } else {
                    int b2 = this.f14581b.b(extractorInput, (int) Math.min((long) (i4 - i3), j3), true);
                    if (b2 == -1) {
                        j3 = 0;
                    } else {
                        this.f14586g += b2;
                        j3 -= (long) b2;
                    }
                }
            }
            WavFormat wavFormat2 = this.f14582c;
            int i52 = wavFormat2.f14592e;
            int i62 = this.f14586g / i52;
            if (i62 > 0) {
                int i7 = i62 * i52;
                int i8 = this.f14586g - i7;
                this.f14581b.f(this.f14585f + Util.c2(this.f14587h, 1000000, (long) wavFormat2.f14590c), 1, i7, i8, (TrackOutput.CryptoData) null);
                this.f14587h += (long) i62;
                this.f14586g = i8;
            }
            return i2 <= 0;
        }

        public void c(int i2, long j2) {
            this.f14580a.j(new WavSeekMap(this.f14582c, 1, (long) i2, j2));
            this.f14581b.e(this.f14583d);
        }
    }

    @EnsuresNonNull({"extractorOutput", "trackOutput"})
    private void f() {
        Assertions.k(this.f14560e);
        Util.o(this.f14559d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] g() {
        return new Extractor[]{new WavExtractor()};
    }

    private void j(ExtractorInput extractorInput) throws IOException {
        Assertions.i(extractorInput.getPosition() == 0);
        int i2 = this.f14564i;
        if (i2 != -1) {
            extractorInput.o(i2);
            this.f14561f = 4;
        } else if (WavHeaderReader.a(extractorInput)) {
            extractorInput.o((int) (extractorInput.i() - extractorInput.getPosition()));
            this.f14561f = 1;
        } else {
            throw ParserException.a("Unsupported or unrecognized wav file type.", (Throwable) null);
        }
    }

    /* JADX WARNING: type inference failed for: r7v10, types: [androidx.media3.extractor.wav.WavExtractor$ImaAdPcmOutputWriter] */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"extractorOutput", "trackOutput"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void k(androidx.media3.extractor.ExtractorInput r7) throws java.io.IOException {
        /*
            r6 = this;
            androidx.media3.extractor.wav.WavFormat r3 = androidx.media3.extractor.wav.WavHeaderReader.b(r7)
            int r7 = r3.f14588a
            r0 = 17
            if (r7 != r0) goto L_0x0016
            androidx.media3.extractor.wav.WavExtractor$ImaAdPcmOutputWriter r7 = new androidx.media3.extractor.wav.WavExtractor$ImaAdPcmOutputWriter
            androidx.media3.extractor.ExtractorOutput r0 = r6.f14559d
            androidx.media3.extractor.TrackOutput r1 = r6.f14560e
            r7.<init>(r0, r1, r3)
        L_0x0013:
            r6.f14563h = r7
            goto L_0x004d
        L_0x0016:
            r0 = 6
            if (r7 != r0) goto L_0x0027
            androidx.media3.extractor.wav.WavExtractor$PassthroughOutputWriter r7 = new androidx.media3.extractor.wav.WavExtractor$PassthroughOutputWriter
            androidx.media3.extractor.ExtractorOutput r1 = r6.f14559d
            androidx.media3.extractor.TrackOutput r2 = r6.f14560e
            java.lang.String r4 = "audio/g711-alaw"
            r5 = -1
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x0013
        L_0x0027:
            r0 = 7
            if (r7 != r0) goto L_0x0038
            androidx.media3.extractor.wav.WavExtractor$PassthroughOutputWriter r7 = new androidx.media3.extractor.wav.WavExtractor$PassthroughOutputWriter
            androidx.media3.extractor.ExtractorOutput r1 = r6.f14559d
            androidx.media3.extractor.TrackOutput r2 = r6.f14560e
            java.lang.String r4 = "audio/g711-mlaw"
            r5 = -1
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x0013
        L_0x0038:
            int r0 = r3.f14593f
            int r5 = androidx.media3.extractor.WavUtil.a(r7, r0)
            if (r5 == 0) goto L_0x0051
            androidx.media3.extractor.wav.WavExtractor$PassthroughOutputWriter r7 = new androidx.media3.extractor.wav.WavExtractor$PassthroughOutputWriter
            androidx.media3.extractor.ExtractorOutput r1 = r6.f14559d
            androidx.media3.extractor.TrackOutput r2 = r6.f14560e
            java.lang.String r4 = "audio/raw"
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x0013
        L_0x004d:
            r7 = 3
            r6.f14561f = r7
            return
        L_0x0051:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Unsupported WAV format type: "
            r7.append(r0)
            int r0 = r3.f14588a
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            androidx.media3.common.ParserException r7 = androidx.media3.common.ParserException.e(r7)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.wav.WavExtractor.k(androidx.media3.extractor.ExtractorInput):void");
    }

    private void l(ExtractorInput extractorInput) throws IOException {
        this.f14562g = WavHeaderReader.c(extractorInput);
        this.f14561f = 2;
    }

    private int m(ExtractorInput extractorInput) throws IOException {
        Assertions.i(this.f14565j != -1);
        return ((OutputWriter) Assertions.g(this.f14563h)).b(extractorInput, this.f14565j - extractorInput.getPosition()) ? -1 : 0;
    }

    private void n(ExtractorInput extractorInput) throws IOException {
        Pair<Long, Long> e2 = WavHeaderReader.e(extractorInput);
        this.f14564i = ((Long) e2.first).intValue();
        long longValue = ((Long) e2.second).longValue();
        long j2 = this.f14562g;
        if (j2 != -1 && longValue == InternalZipConstants.f30717k) {
            longValue = j2;
        }
        this.f14565j = ((long) this.f14564i) + longValue;
        long length = extractorInput.getLength();
        if (length != -1 && this.f14565j > length) {
            Log.n(f14555k, "Data exceeds input length: " + this.f14565j + ", " + length);
            this.f14565j = length;
        }
        ((OutputWriter) Assertions.g(this.f14563h)).c(this.f14564i, this.f14565j);
        this.f14561f = 4;
    }

    public void a() {
    }

    public void c(long j2, long j3) {
        this.f14561f = j2 == 0 ? 0 : 4;
        OutputWriter outputWriter = this.f14563h;
        if (outputWriter != null) {
            outputWriter.a(j3);
        }
    }

    public void d(ExtractorOutput extractorOutput) {
        this.f14559d = extractorOutput;
        this.f14560e = extractorOutput.d(0, 1);
        extractorOutput.o();
    }

    public /* synthetic */ Extractor e() {
        return d.a(this);
    }

    public boolean h(ExtractorInput extractorInput) throws IOException {
        return WavHeaderReader.a(extractorInput);
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        f();
        int i2 = this.f14561f;
        if (i2 == 0) {
            j(extractorInput);
            return 0;
        } else if (i2 == 1) {
            l(extractorInput);
            return 0;
        } else if (i2 == 2) {
            k(extractorInput);
            return 0;
        } else if (i2 == 3) {
            n(extractorInput);
            return 0;
        } else if (i2 == 4) {
            return m(extractorInput);
        } else {
            throw new IllegalStateException();
        }
    }
}
