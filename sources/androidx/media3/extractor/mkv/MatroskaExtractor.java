package androidx.media3.extractor.mkv;

import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.LongArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.TrueHdSampleRechunker;
import androidx.media3.extractor.d;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.SubtitleTranscodingExtractorOutput;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.pdf.ByteBuffer;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import net.imedicaldoctor.imd.BuildConfig;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public class MatroskaExtractor implements Extractor {
    private static final String A0 = "V_MS/VFW/FOURCC";
    private static final int A1 = 374648427;
    private static final int A2 = 21936;
    private static final String B0 = "V_THEORA";
    private static final int B1 = 174;
    private static final int B2 = 21945;
    private static final String C0 = "A_VORBIS";
    private static final int C1 = 215;
    private static final int C2 = 21938;
    private static final String D0 = "A_OPUS";
    private static final int D1 = 131;
    private static final int D2 = 21946;
    private static final String E0 = "A_AAC";
    private static final int E1 = 136;
    private static final int E2 = 21947;
    private static final String F0 = "A_MPEG/L2";
    private static final int F1 = 21930;
    private static final int F2 = 21948;
    private static final String G0 = "A_MPEG/L3";
    private static final int G1 = 2352003;
    private static final int G2 = 21949;
    private static final String H0 = "A_AC3";
    private static final int H1 = 21998;
    private static final int H2 = 21968;
    private static final String I0 = "A_EAC3";
    private static final int I1 = 16868;
    private static final int I2 = 21969;
    private static final String J0 = "A_TRUEHD";
    private static final int J1 = 16871;
    private static final int J2 = 21970;
    private static final String K0 = "A_DTS";
    private static final int K1 = 16877;
    private static final int K2 = 21971;
    private static final String L0 = "A_DTS/EXPRESS";
    private static final int L1 = 21358;
    private static final int L2 = 21972;
    private static final String M0 = "A_DTS/LOSSLESS";
    private static final int M1 = 134;
    private static final int M2 = 21973;
    private static final String N0 = "A_FLAC";
    private static final int N1 = 25506;
    private static final int N2 = 21974;
    private static final String O0 = "A_MS/ACM";
    private static final int O1 = 22186;
    private static final int O2 = 21975;
    private static final String P0 = "A_PCM/INT/LIT";
    private static final int P1 = 22203;
    private static final int P2 = 21976;
    private static final String Q0 = "A_PCM/INT/BIG";
    private static final int Q1 = 30114;
    private static final int Q2 = 21977;
    private static final String R0 = "A_PCM/FLOAT/IEEE";
    private static final int R1 = 224;
    private static final int R2 = 21978;
    private static final String S0 = "S_TEXT/UTF8";
    private static final int S1 = 176;
    private static final int S2 = 4;
    private static final String T0 = "S_TEXT/ASS";
    private static final int T1 = 186;
    private static final int T2 = 1685480259;
    private static final String U0 = "S_TEXT/WEBVTT";
    private static final int U1 = 21680;
    private static final int U2 = 1685485123;
    private static final String V0 = "S_VOBSUB";
    private static final int V1 = 21690;
    private static final int V2 = 0;
    private static final String W0 = "S_HDMV/PGS";
    private static final int W1 = 21682;
    private static final int W2 = 1;
    private static final String X0 = "S_DVBSUB";
    private static final int X1 = 225;
    private static final int X2 = 2;
    private static final int Y0 = 8192;
    private static final int Y1 = 159;
    private static final int Y2 = 3;
    private static final int Z0 = 5760;
    private static final int Z1 = 25188;
    private static final int Z2 = 1482049860;
    private static final int a1 = 8;
    private static final int a2 = 181;
    private static final int a3 = 859189832;
    private static final int b1 = 2;
    private static final int b2 = 28032;
    private static final int b3 = 826496599;
    private static final int c1 = 440786851;
    private static final int c2 = 25152;
    private static final byte[] c3 = {49, 10, ByteBuffer.X2, ByteBuffer.X2, 58, ByteBuffer.X2, ByteBuffer.X2, 58, ByteBuffer.X2, ByteBuffer.X2, 44, ByteBuffer.X2, ByteBuffer.X2, ByteBuffer.X2, 32, 45, 45, DocWriter.f3, 32, ByteBuffer.X2, ByteBuffer.X2, 58, ByteBuffer.X2, ByteBuffer.X2, 58, ByteBuffer.X2, ByteBuffer.X2, 44, ByteBuffer.X2, ByteBuffer.X2, ByteBuffer.X2, 10};
    private static final int d1 = 17143;
    private static final int d2 = 20529;
    private static final int d3 = 19;
    private static final int e1 = 17026;
    private static final int e2 = 20530;
    private static final long e3 = 1000;
    private static final int f1 = 17029;
    private static final int f2 = 20532;
    private static final String f3 = "%02d:%02d:%02d,%03d";
    private static final int g1 = 408125543;
    private static final int g2 = 16980;
    /* access modifiers changed from: private */
    public static final byte[] g3 = Util.R0("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    public static final int h0 = 1;
    private static final int h1 = 357149030;
    private static final int h2 = 16981;
    private static final byte[] h3 = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, ByteBuffer.X2, 58, ByteBuffer.X2, ByteBuffer.X2, 58, ByteBuffer.X2, ByteBuffer.X2, 58, ByteBuffer.X2, ByteBuffer.X2, 44, ByteBuffer.X2, 58, ByteBuffer.X2, ByteBuffer.X2, 58, ByteBuffer.X2, ByteBuffer.X2, 58, ByteBuffer.X2, ByteBuffer.X2, 44};
    public static final int i0 = 2;
    private static final int i1 = 290298740;
    private static final int i2 = 20533;
    private static final int i3 = 21;
    @Deprecated
    public static final ExtractorsFactory j0 = new b();
    private static final int j1 = 19899;
    private static final int j2 = 18401;
    private static final long j3 = 10000;
    private static final String k0 = "MatroskaExtractor";
    private static final int k1 = 21419;
    private static final int k2 = 18402;
    private static final String k3 = "%01d:%02d:%02d:%02d";
    private static final int l0 = -1;
    private static final int l1 = 21420;
    private static final int l2 = 18407;
    private static final byte[] l3 = {87, 69, 66, 86, 84, 84, 10, 10, ByteBuffer.X2, ByteBuffer.X2, 58, ByteBuffer.X2, ByteBuffer.X2, 58, ByteBuffer.X2, ByteBuffer.X2, 46, ByteBuffer.X2, ByteBuffer.X2, ByteBuffer.X2, 32, 45, 45, DocWriter.f3, 32, ByteBuffer.X2, ByteBuffer.X2, 58, ByteBuffer.X2, ByteBuffer.X2, 58, ByteBuffer.X2, ByteBuffer.X2, 46, ByteBuffer.X2, ByteBuffer.X2, ByteBuffer.X2, 10};
    private static final int m0 = 0;
    private static final int m1 = 357149030;
    private static final int m2 = 18408;
    private static final int m3 = 25;
    private static final int n0 = 1;
    private static final int n1 = 2807729;
    private static final int n2 = 475249515;
    private static final long n3 = 1000;
    private static final int o0 = 2;
    private static final int o1 = 17545;
    private static final int o2 = 187;
    private static final String o3 = "%02d:%02d:%02d.%03d";
    private static final String p0 = "matroska";
    private static final int p1 = 524531317;
    private static final int p2 = 179;
    private static final int p3 = 18;
    private static final String q0 = "webm";
    private static final int q1 = 231;
    private static final int q2 = 183;
    private static final int q3 = 65534;
    private static final String r0 = "V_VP8";
    private static final int r1 = 163;
    private static final int r2 = 241;
    private static final int r3 = 1;
    private static final String s0 = "V_VP9";
    private static final int s1 = 160;
    private static final int s2 = 2274716;
    /* access modifiers changed from: private */
    public static final UUID s3 = new UUID(72057594037932032L, -9223371306706625679L);
    private static final String t0 = "V_AV1";
    private static final int t1 = 161;
    private static final int t2 = 30320;
    /* access modifiers changed from: private */
    public static final Map<String, Integer> t3;
    private static final String u0 = "V_MPEG2";
    private static final int u1 = 155;
    private static final int u2 = 30321;
    private static final String v0 = "V_MPEG4/ISO/SP";
    private static final int v1 = 30113;
    private static final int v2 = 30322;
    private static final String w0 = "V_MPEG4/ISO/ASP";
    private static final int w1 = 166;
    private static final int w2 = 30323;
    private static final String x0 = "V_MPEG4/ISO/AP";
    private static final int x1 = 238;
    private static final int x2 = 30324;
    private static final String y0 = "V_MPEG4/ISO/AVC";
    private static final int y1 = 165;
    private static final int y2 = 30325;
    private static final String z0 = "V_MPEGH/ISO/HEVC";
    private static final int z1 = 251;
    private static final int z2 = 21432;
    private boolean A;
    private int B;
    private long C;
    private boolean D;
    private long E;
    private long F;
    private long G;
    @Nullable
    private LongArray H;
    @Nullable
    private LongArray I;
    private boolean J;
    private boolean K;
    private int L;
    private long M;
    private long N;
    private int O;
    private int P;
    private int[] Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private boolean V;
    private long W;
    private int X;
    private int Y;
    private int Z;
    private boolean a0;
    private boolean b0;
    private boolean c0;

    /* renamed from: d  reason: collision with root package name */
    private final EbmlReader f13418d;
    private int d0;

    /* renamed from: e  reason: collision with root package name */
    private final VarintReader f13419e;
    private byte e0;

    /* renamed from: f  reason: collision with root package name */
    private final SparseArray<Track> f13420f;
    private boolean f0;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f13421g;
    private ExtractorOutput g0;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f13422h;

    /* renamed from: i  reason: collision with root package name */
    private final SubtitleParser.Factory f13423i;

    /* renamed from: j  reason: collision with root package name */
    private final ParsableByteArray f13424j;

    /* renamed from: k  reason: collision with root package name */
    private final ParsableByteArray f13425k;

    /* renamed from: l  reason: collision with root package name */
    private final ParsableByteArray f13426l;

    /* renamed from: m  reason: collision with root package name */
    private final ParsableByteArray f13427m;

    /* renamed from: n  reason: collision with root package name */
    private final ParsableByteArray f13428n;
    private final ParsableByteArray o;
    private final ParsableByteArray p;
    private final ParsableByteArray q;
    private final ParsableByteArray r;
    private final ParsableByteArray s;
    private java.nio.ByteBuffer t;
    private long u;
    private long v;
    private long w;
    private long x;
    private long y;
    @Nullable
    private Track z;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    private final class InnerEbmlProcessor implements EbmlProcessor {
        private InnerEbmlProcessor() {
        }

        public void a(int i2) throws ParserException {
            MatroskaExtractor.this.r(i2);
        }

        public int b(int i2) {
            return MatroskaExtractor.this.x(i2);
        }

        public boolean c(int i2) {
            return MatroskaExtractor.this.C(i2);
        }

        public void d(int i2, String str) throws ParserException {
            MatroskaExtractor.this.M(i2, str);
        }

        public void e(int i2, double d2) throws ParserException {
            MatroskaExtractor.this.u(i2, d2);
        }

        public void f(int i2, int i3, ExtractorInput extractorInput) throws IOException {
            MatroskaExtractor.this.o(i2, i3, extractorInput);
        }

        public void g(int i2, long j2, long j3) throws ParserException {
            MatroskaExtractor.this.L(i2, j2, j3);
        }

        public void h(int i2, long j2) throws ParserException {
            MatroskaExtractor.this.A(i2, j2);
        }
    }

    protected static final class Track {
        private static final int a0 = 0;
        private static final int b0 = 50000;
        private static final int c0 = 1000;
        private static final int d0 = 200;
        public int A = -1;
        public int B = -1;
        public int C = 1000;
        public int D = 200;
        public float E = -1.0f;
        public float F = -1.0f;
        public float G = -1.0f;
        public float H = -1.0f;
        public float I = -1.0f;
        public float J = -1.0f;
        public float K = -1.0f;
        public float L = -1.0f;
        public float M = -1.0f;
        public float N = -1.0f;
        public byte[] O;
        public int P = 1;
        public int Q = -1;
        public int R = 8000;
        public long S = 0;
        public long T = 0;
        public TrueHdSampleRechunker U;
        public boolean V;
        public boolean W = true;
        /* access modifiers changed from: private */
        public String X = "eng";
        public TrackOutput Y;
        public int Z;

        /* renamed from: a  reason: collision with root package name */
        public String f13430a;

        /* renamed from: b  reason: collision with root package name */
        public String f13431b;

        /* renamed from: c  reason: collision with root package name */
        public int f13432c;

        /* renamed from: d  reason: collision with root package name */
        public int f13433d;

        /* renamed from: e  reason: collision with root package name */
        public int f13434e;

        /* renamed from: f  reason: collision with root package name */
        public int f13435f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int f13436g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f13437h;

        /* renamed from: i  reason: collision with root package name */
        public byte[] f13438i;

        /* renamed from: j  reason: collision with root package name */
        public TrackOutput.CryptoData f13439j;

        /* renamed from: k  reason: collision with root package name */
        public byte[] f13440k;

        /* renamed from: l  reason: collision with root package name */
        public DrmInitData f13441l;

        /* renamed from: m  reason: collision with root package name */
        public int f13442m = -1;

        /* renamed from: n  reason: collision with root package name */
        public int f13443n = -1;
        public int o = -1;
        public int p = -1;
        public int q = -1;
        public int r = 0;
        public int s = -1;
        public float t = 0.0f;
        public float u = 0.0f;
        public float v = 0.0f;
        public byte[] w = null;
        public int x = -1;
        public boolean y = false;
        public int z = -1;

        protected Track() {
        }

        /* access modifiers changed from: private */
        @EnsuresNonNull({"output"})
        public void f() {
            Assertions.g(this.Y);
        }

        @EnsuresNonNull({"codecPrivate"})
        private byte[] g(String str) throws ParserException {
            byte[] bArr = this.f13440k;
            if (bArr != null) {
                return bArr;
            }
            throw ParserException.a("Missing CodecPrivate for codec " + str, (Throwable) null);
        }

        @Nullable
        private byte[] h() {
            if (this.E == -1.0f || this.F == -1.0f || this.G == -1.0f || this.H == -1.0f || this.I == -1.0f || this.J == -1.0f || this.K == -1.0f || this.L == -1.0f || this.M == -1.0f || this.N == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            java.nio.ByteBuffer order = java.nio.ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            order.put((byte) 0);
            order.putShort((short) ((int) ((this.E * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.F * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.G * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.H * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.I * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.J * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.K * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.L * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) (this.M + 0.5f)));
            order.putShort((short) ((int) (this.N + 0.5f)));
            order.putShort((short) this.C);
            order.putShort((short) this.D);
            return bArr;
        }

        private static Pair<String, List<byte[]>> k(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                parsableByteArray.Z(16);
                long A2 = parsableByteArray.A();
                if (A2 == 1482049860) {
                    return new Pair<>(MimeTypes.u, (Object) null);
                }
                if (A2 == 859189832) {
                    return new Pair<>(MimeTypes.f9234i, (Object) null);
                }
                if (A2 == 826496599) {
                    byte[] e2 = parsableByteArray.e();
                    for (int f2 = parsableByteArray.f() + 20; f2 < e2.length - 4; f2++) {
                        if (e2[f2] == 0 && e2[f2 + 1] == 0 && e2[f2 + 2] == 1 && e2[f2 + 3] == 15) {
                            return new Pair<>(MimeTypes.t, Collections.singletonList(Arrays.copyOfRange(e2, f2, e2.length)));
                        }
                    }
                    throw ParserException.a("Failed to find FourCC VC1 initialization data", (Throwable) null);
                }
                Log.n(MatroskaExtractor.k0, "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair<>(MimeTypes.D, (Object) null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.a("Error parsing FourCC private data", (Throwable) null);
            }
        }

        private static boolean l(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                int D2 = parsableByteArray.D();
                if (D2 == 1) {
                    return true;
                }
                if (D2 != 65534) {
                    return false;
                }
                parsableByteArray.Y(24);
                return parsableByteArray.E() == MatroskaExtractor.s3.getMostSignificantBits() && parsableByteArray.E() == MatroskaExtractor.s3.getLeastSignificantBits();
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.a("Error parsing MS/ACM codec private", (Throwable) null);
            }
        }

        private static List<byte[]> m(byte[] bArr) throws ParserException {
            byte b2;
            byte b3;
            try {
                if (bArr[0] == 2) {
                    int i2 = 1;
                    int i3 = 0;
                    while (true) {
                        b2 = bArr[i2];
                        if ((b2 & 255) != 255) {
                            break;
                        }
                        i3 += 255;
                        i2++;
                    }
                    int i4 = i2 + 1;
                    int i5 = i3 + (b2 & 255);
                    int i6 = 0;
                    while (true) {
                        b3 = bArr[i4];
                        if ((b3 & 255) != 255) {
                            break;
                        }
                        i6 += 255;
                        i4++;
                    }
                    int i7 = i4 + 1;
                    int i8 = i6 + (b3 & 255);
                    if (bArr[i7] == 1) {
                        byte[] bArr2 = new byte[i5];
                        System.arraycopy(bArr, i7, bArr2, 0, i5);
                        int i9 = i7 + i5;
                        if (bArr[i9] == 3) {
                            int i10 = i9 + i8;
                            if (bArr[i10] == 5) {
                                byte[] bArr3 = new byte[(bArr.length - i10)];
                                System.arraycopy(bArr, i10, bArr3, 0, bArr.length - i10);
                                ArrayList arrayList = new ArrayList(2);
                                arrayList.add(bArr2);
                                arrayList.add(bArr3);
                                return arrayList;
                            }
                            throw ParserException.a("Error parsing vorbis codec private", (Throwable) null);
                        }
                        throw ParserException.a("Error parsing vorbis codec private", (Throwable) null);
                    }
                    throw ParserException.a("Error parsing vorbis codec private", (Throwable) null);
                }
                throw ParserException.a("Error parsing vorbis codec private", (Throwable) null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.a("Error parsing vorbis codec private", (Throwable) null);
            }
        }

        /* access modifiers changed from: private */
        public boolean o(boolean z2) {
            if (MatroskaExtractor.D0.equals(this.f13431b)) {
                return z2;
            }
            return this.f13435f > 0;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v12, resolved type: java.lang.String} */
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:106:0x0229, code lost:
            r14 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:0x0238, code lost:
            r2 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:0x0239, code lost:
            r5 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:110:0x023a, code lost:
            r6 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:112:0x023e, code lost:
            r1 = null;
            r2 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:117:0x0267, code lost:
            r5 = 0;
            r6 = -1;
            r14 = -1;
            r18 = r2;
            r2 = r1;
            r1 = r18;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:122:0x0292, code lost:
            r1.append(r2);
            r1.append(r0.Q);
            r1.append(". Setting mimeType to ");
            r1.append(androidx.media3.common.MimeTypes.l0);
            androidx.media3.common.util.Log.n(androidx.media3.extractor.mkv.MatroskaExtractor.k0, r1.toString());
            r1 = null;
            r2 = null;
            r16 = androidx.media3.common.MimeTypes.l0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:124:0x02ad, code lost:
            r1 = null;
            r2 = null;
            r5 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:125:0x02b0, code lost:
            r6 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:154:0x0368, code lost:
            r2 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:157:0x0389, code lost:
            r1 = null;
            r2 = null;
            r6 = 4096;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:175:0x0410, code lost:
            if (r0.O == null) goto L_0x0423;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:176:0x0412, code lost:
            r4 = androidx.media3.extractor.DolbyVisionConfig.a(new androidx.media3.common.util.ParsableByteArray(r0.O));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:177:0x041d, code lost:
            if (r4 == null) goto L_0x0423;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:178:0x041f, code lost:
            r2 = r4.f13014c;
            r16 = androidx.media3.common.MimeTypes.w;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:179:0x0423, code lost:
            r4 = r16;
            r15 = r0.W;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:180:0x0429, code lost:
            if (r0.V == false) goto L_0x042d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:181:0x042b, code lost:
            r3 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:182:0x042d, code lost:
            r3 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:183:0x042e, code lost:
            r3 = r3 | r15;
            r15 = new androidx.media3.common.Format.Builder();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:184:0x0438, code lost:
            if (androidx.media3.common.MimeTypes.p(r4) == false) goto L_0x044c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:185:0x043a, code lost:
            r15.L(r0.P).l0(r0.R).e0(r14);
            r5 = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:187:0x0450, code lost:
            if (androidx.media3.common.MimeTypes.t(r4) == false) goto L_0x0548;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:189:0x0454, code lost:
            if (r0.r != 0) goto L_0x0468;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:190:0x0456, code lost:
            r7 = r0.p;
            r8 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:191:0x0459, code lost:
            if (r7 != -1) goto L_0x045d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:192:0x045b, code lost:
            r7 = r0.f13442m;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:193:0x045d, code lost:
            r0.p = r7;
            r7 = r0.q;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:194:0x0461, code lost:
            if (r7 != -1) goto L_0x0465;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:195:0x0463, code lost:
            r7 = r0.f13443n;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:196:0x0465, code lost:
            r0.q = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:197:0x0468, code lost:
            r8 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:198:0x0469, code lost:
            r7 = r0.p;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:199:0x046b, code lost:
            if (r7 == r8) goto L_0x047d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:200:0x046d, code lost:
            r9 = r0.q;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:201:0x046f, code lost:
            if (r9 == r8) goto L_0x047d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:202:0x0471, code lost:
            r7 = ((float) (r0.f13443n * r7)) / ((float) (r0.f13442m * r9));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:203:0x047d, code lost:
            r7 = -1.0f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:205:0x0481, code lost:
            if (r0.y == false) goto L_0x04b2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:206:0x0483, code lost:
            r10 = new androidx.media3.common.ColorInfo.Builder().d(r0.z).c(r0.B).e(r0.A).f(h()).g(r0.o).b(r0.o).a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:208:0x04b4, code lost:
            if (r0.f13430a == null) goto L_0x04d2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:210:0x04c0, code lost:
            if (androidx.media3.extractor.mkv.MatroskaExtractor.j().containsKey(r0.f13430a) == false) goto L_0x04d2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:211:0x04c2, code lost:
            r8 = ((java.lang.Integer) androidx.media3.extractor.mkv.MatroskaExtractor.j().get(r0.f13430a)).intValue();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:213:0x04d4, code lost:
            if (r0.s != 0) goto L_0x0522;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:215:0x04dd, code lost:
            if (java.lang.Float.compare(r0.t, 0.0f) != 0) goto L_0x0522;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:217:0x04e5, code lost:
            if (java.lang.Float.compare(r0.u, 0.0f) != 0) goto L_0x0522;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:219:0x04ed, code lost:
            if (java.lang.Float.compare(r0.v, 0.0f) != 0) goto L_0x04f0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:221:0x04f8, code lost:
            if (java.lang.Float.compare(r0.v, 90.0f) != 0) goto L_0x04fd;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:222:0x04fa, code lost:
            r5 = 90;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:224:0x0505, code lost:
            if (java.lang.Float.compare(r0.v, -180.0f) == 0) goto L_0x051f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:226:0x050f, code lost:
            if (java.lang.Float.compare(r0.v, 180.0f) != 0) goto L_0x0512;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:228:0x051a, code lost:
            if (java.lang.Float.compare(r0.v, -90.0f) != 0) goto L_0x0522;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:229:0x051c, code lost:
            r5 = com.itextpdf.text.pdf.codec.TIFFConstants.e0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:230:0x051f, code lost:
            r5 = net.imedicaldoctor.imd.BuildConfig.f29478d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:231:0x0522, code lost:
            r5 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:232:0x0523, code lost:
            r15.r0(r0.f13442m).V(r0.f13443n).g0(r7).j0(r5).h0(r0.w).n0(r0.x).N(r10);
            r5 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:234:0x054c, code lost:
            if (androidx.media3.common.MimeTypes.y0.equals(r4) != false) goto L_0x0574;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:236:0x0552, code lost:
            if (androidx.media3.common.MimeTypes.n0.equals(r4) != false) goto L_0x0574;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:238:0x0558, code lost:
            if (androidx.media3.common.MimeTypes.m0.equals(r4) != false) goto L_0x0574;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:240:0x055e, code lost:
            if (androidx.media3.common.MimeTypes.E0.equals(r4) != false) goto L_0x0574;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:242:0x0564, code lost:
            if (androidx.media3.common.MimeTypes.F0.equals(r4) != false) goto L_0x0574;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:244:0x056a, code lost:
            if (androidx.media3.common.MimeTypes.J0.equals(r4) == false) goto L_0x056d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:246:0x0573, code lost:
            throw androidx.media3.common.ParserException.a("Unexpected MIME type.", (java.lang.Throwable) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:247:0x0574, code lost:
            r5 = 3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:249:0x0577, code lost:
            if (r0.f13430a == null) goto L_0x058a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:251:0x0583, code lost:
            if (androidx.media3.extractor.mkv.MatroskaExtractor.j().containsKey(r0.f13430a) != false) goto L_0x058a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:252:0x0585, code lost:
            r15.Z(r0.f13430a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:253:0x058a, code lost:
            r1 = r15.W(r21).k0(r4).c0(r6).b0(r0.X).m0(r3).Y(r1).M(r2).R(r0.f13441l).I();
            r2 = r20.d(r0.f13432c, r5);
            r0.Y = r2;
            r2.e(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:254:0x05c1, code lost:
            return;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        @org.checkerframework.checker.nullness.qual.RequiresNonNull({"codecId"})
        @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"this.output"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void i(androidx.media3.extractor.ExtractorOutput r20, int r21) throws androidx.media3.common.ParserException {
            /*
                r19 = this;
                r0 = r19
                r2 = 16
                java.lang.String r5 = r0.f13431b
                r5.hashCode()
                java.lang.String r7 = "application/dvbsubs"
                java.lang.String r8 = "application/vobsub"
                java.lang.String r9 = "application/pgs"
                java.lang.String r11 = "text/x-ssa"
                java.lang.String r12 = "text/vtt"
                java.lang.String r13 = "application/x-subrip"
                r15 = 8
                r3 = 3
                java.lang.String r6 = ". Setting mimeType to "
                java.lang.String r16 = "audio/raw"
                java.lang.String r4 = "MatroskaExtractor"
                java.lang.String r14 = "audio/x-unknown"
                r10 = 0
                int r17 = r5.hashCode()
                switch(r17) {
                    case -2095576542: goto L_0x01d4;
                    case -2095575984: goto L_0x01c8;
                    case -1985379776: goto L_0x01bc;
                    case -1784763192: goto L_0x01b0;
                    case -1730367663: goto L_0x01a4;
                    case -1482641358: goto L_0x0198;
                    case -1482641357: goto L_0x018c;
                    case -1373388978: goto L_0x0180;
                    case -933872740: goto L_0x0172;
                    case -538363189: goto L_0x0164;
                    case -538363109: goto L_0x0156;
                    case -425012669: goto L_0x0148;
                    case -356037306: goto L_0x013a;
                    case 62923557: goto L_0x012c;
                    case 62923603: goto L_0x011e;
                    case 62927045: goto L_0x0110;
                    case 82318131: goto L_0x0102;
                    case 82338133: goto L_0x00f4;
                    case 82338134: goto L_0x00e6;
                    case 99146302: goto L_0x00d8;
                    case 444813526: goto L_0x00ca;
                    case 542569478: goto L_0x00bc;
                    case 635596514: goto L_0x00ae;
                    case 725948237: goto L_0x00a0;
                    case 725957860: goto L_0x0093;
                    case 738597099: goto L_0x0086;
                    case 855502857: goto L_0x0079;
                    case 1045209816: goto L_0x006c;
                    case 1422270023: goto L_0x005f;
                    case 1809237540: goto L_0x0052;
                    case 1950749482: goto L_0x0045;
                    case 1950789798: goto L_0x0038;
                    case 1951062397: goto L_0x002b;
                    default: goto L_0x0028;
                }
            L_0x0028:
                r1 = -1
                goto L_0x01df
            L_0x002b:
                java.lang.String r1 = "A_OPUS"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x0034
                goto L_0x0028
            L_0x0034:
                r1 = 32
                goto L_0x01df
            L_0x0038:
                java.lang.String r1 = "A_FLAC"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x0041
                goto L_0x0028
            L_0x0041:
                r1 = 31
                goto L_0x01df
            L_0x0045:
                java.lang.String r1 = "A_EAC3"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x004e
                goto L_0x0028
            L_0x004e:
                r1 = 30
                goto L_0x01df
            L_0x0052:
                java.lang.String r1 = "V_MPEG2"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x005b
                goto L_0x0028
            L_0x005b:
                r1 = 29
                goto L_0x01df
            L_0x005f:
                java.lang.String r1 = "S_TEXT/UTF8"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x0068
                goto L_0x0028
            L_0x0068:
                r1 = 28
                goto L_0x01df
            L_0x006c:
                java.lang.String r1 = "S_TEXT/WEBVTT"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x0075
                goto L_0x0028
            L_0x0075:
                r1 = 27
                goto L_0x01df
            L_0x0079:
                java.lang.String r1 = "V_MPEGH/ISO/HEVC"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x0082
                goto L_0x0028
            L_0x0082:
                r1 = 26
                goto L_0x01df
            L_0x0086:
                java.lang.String r1 = "S_TEXT/ASS"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x008f
                goto L_0x0028
            L_0x008f:
                r1 = 25
                goto L_0x01df
            L_0x0093:
                java.lang.String r1 = "A_PCM/INT/LIT"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x009c
                goto L_0x0028
            L_0x009c:
                r1 = 24
                goto L_0x01df
            L_0x00a0:
                java.lang.String r1 = "A_PCM/INT/BIG"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x00aa
                goto L_0x0028
            L_0x00aa:
                r1 = 23
                goto L_0x01df
            L_0x00ae:
                java.lang.String r1 = "A_PCM/FLOAT/IEEE"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x00b8
                goto L_0x0028
            L_0x00b8:
                r1 = 22
                goto L_0x01df
            L_0x00bc:
                java.lang.String r1 = "A_DTS/EXPRESS"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x00c6
                goto L_0x0028
            L_0x00c6:
                r1 = 21
                goto L_0x01df
            L_0x00ca:
                java.lang.String r1 = "V_THEORA"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x00d4
                goto L_0x0028
            L_0x00d4:
                r1 = 20
                goto L_0x01df
            L_0x00d8:
                java.lang.String r1 = "S_HDMV/PGS"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x00e2
                goto L_0x0028
            L_0x00e2:
                r1 = 19
                goto L_0x01df
            L_0x00e6:
                java.lang.String r1 = "V_VP9"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x00f0
                goto L_0x0028
            L_0x00f0:
                r1 = 18
                goto L_0x01df
            L_0x00f4:
                java.lang.String r1 = "V_VP8"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x00fe
                goto L_0x0028
            L_0x00fe:
                r1 = 17
                goto L_0x01df
            L_0x0102:
                java.lang.String r1 = "V_AV1"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x010c
                goto L_0x0028
            L_0x010c:
                r1 = 16
                goto L_0x01df
            L_0x0110:
                java.lang.String r1 = "A_DTS"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x011a
                goto L_0x0028
            L_0x011a:
                r1 = 15
                goto L_0x01df
            L_0x011e:
                java.lang.String r1 = "A_AC3"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x0128
                goto L_0x0028
            L_0x0128:
                r1 = 14
                goto L_0x01df
            L_0x012c:
                java.lang.String r1 = "A_AAC"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x0136
                goto L_0x0028
            L_0x0136:
                r1 = 13
                goto L_0x01df
            L_0x013a:
                java.lang.String r1 = "A_DTS/LOSSLESS"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x0144
                goto L_0x0028
            L_0x0144:
                r1 = 12
                goto L_0x01df
            L_0x0148:
                java.lang.String r1 = "S_VOBSUB"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x0152
                goto L_0x0028
            L_0x0152:
                r1 = 11
                goto L_0x01df
            L_0x0156:
                java.lang.String r1 = "V_MPEG4/ISO/AVC"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x0160
                goto L_0x0028
            L_0x0160:
                r1 = 10
                goto L_0x01df
            L_0x0164:
                java.lang.String r1 = "V_MPEG4/ISO/ASP"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x016e
                goto L_0x0028
            L_0x016e:
                r1 = 9
                goto L_0x01df
            L_0x0172:
                java.lang.String r1 = "S_DVBSUB"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x017c
                goto L_0x0028
            L_0x017c:
                r1 = 8
                goto L_0x01df
            L_0x0180:
                java.lang.String r1 = "V_MS/VFW/FOURCC"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x018a
                goto L_0x0028
            L_0x018a:
                r1 = 7
                goto L_0x01df
            L_0x018c:
                java.lang.String r1 = "A_MPEG/L3"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x0196
                goto L_0x0028
            L_0x0196:
                r1 = 6
                goto L_0x01df
            L_0x0198:
                java.lang.String r1 = "A_MPEG/L2"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x01a2
                goto L_0x0028
            L_0x01a2:
                r1 = 5
                goto L_0x01df
            L_0x01a4:
                java.lang.String r1 = "A_VORBIS"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x01ae
                goto L_0x0028
            L_0x01ae:
                r1 = 4
                goto L_0x01df
            L_0x01b0:
                java.lang.String r1 = "A_TRUEHD"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x01ba
                goto L_0x0028
            L_0x01ba:
                r1 = 3
                goto L_0x01df
            L_0x01bc:
                java.lang.String r1 = "A_MS/ACM"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x01c6
                goto L_0x0028
            L_0x01c6:
                r1 = 2
                goto L_0x01df
            L_0x01c8:
                java.lang.String r1 = "V_MPEG4/ISO/SP"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x01d2
                goto L_0x0028
            L_0x01d2:
                r1 = 1
                goto L_0x01df
            L_0x01d4:
                java.lang.String r1 = "V_MPEG4/ISO/AP"
                boolean r1 = r5.equals(r1)
                if (r1 != 0) goto L_0x01de
                goto L_0x0028
            L_0x01de:
                r1 = 0
            L_0x01df:
                switch(r1) {
                    case 0: goto L_0x03ff;
                    case 1: goto L_0x03ff;
                    case 2: goto L_0x03b3;
                    case 3: goto L_0x03a5;
                    case 4: goto L_0x0393;
                    case 5: goto L_0x038f;
                    case 6: goto L_0x0386;
                    case 7: goto L_0x036b;
                    case 8: goto L_0x0355;
                    case 9: goto L_0x03ff;
                    case 10: goto L_0x033a;
                    case 11: goto L_0x032c;
                    case 12: goto L_0x0328;
                    case 13: goto L_0x030a;
                    case 14: goto L_0x0306;
                    case 15: goto L_0x0302;
                    case 16: goto L_0x02fe;
                    case 17: goto L_0x02fa;
                    case 18: goto L_0x02f6;
                    case 19: goto L_0x02f2;
                    case 20: goto L_0x02ee;
                    case 21: goto L_0x0302;
                    case 22: goto L_0x02d9;
                    case 23: goto L_0x02b3;
                    case 24: goto L_0x0283;
                    case 25: goto L_0x0271;
                    case 26: goto L_0x024e;
                    case 27: goto L_0x0249;
                    case 28: goto L_0x0244;
                    case 29: goto L_0x0241;
                    case 30: goto L_0x023c;
                    case 31: goto L_0x022c;
                    case 32: goto L_0x01e9;
                    default: goto L_0x01e2;
                }
            L_0x01e2:
                java.lang.String r1 = "Unrecognized codec identifier."
                androidx.media3.common.ParserException r1 = androidx.media3.common.ParserException.a(r1, r10)
                throw r1
            L_0x01e9:
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>(r3)
                java.lang.String r2 = r0.f13431b
                byte[] r2 = r0.g(r2)
                r1.add(r2)
                java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r15)
                java.nio.ByteOrder r4 = java.nio.ByteOrder.LITTLE_ENDIAN
                java.nio.ByteBuffer r2 = r2.order(r4)
                long r5 = r0.S
                java.nio.ByteBuffer r2 = r2.putLong(r5)
                byte[] r2 = r2.array()
                r1.add(r2)
                java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r15)
                java.nio.ByteBuffer r2 = r2.order(r4)
                long r4 = r0.T
                java.nio.ByteBuffer r2 = r2.putLong(r4)
                byte[] r2 = r2.array()
                r1.add(r2)
                java.lang.String r16 = "audio/opus"
                r6 = 5760(0x1680, float:8.071E-42)
                r2 = r10
                r5 = 0
            L_0x0229:
                r14 = -1
                goto L_0x040e
            L_0x022c:
                java.lang.String r1 = r0.f13431b
                byte[] r1 = r0.g(r1)
                java.util.List r1 = java.util.Collections.singletonList(r1)
                java.lang.String r16 = "audio/flac"
            L_0x0238:
                r2 = r10
            L_0x0239:
                r5 = 0
            L_0x023a:
                r6 = -1
                goto L_0x0229
            L_0x023c:
                java.lang.String r16 = "audio/eac3"
            L_0x023e:
                r1 = r10
                r2 = r1
                goto L_0x0239
            L_0x0241:
                java.lang.String r16 = "video/mpeg2"
                goto L_0x023e
            L_0x0244:
                r1 = r10
                r2 = r1
                r16 = r13
                goto L_0x0239
            L_0x0249:
                r1 = r10
                r2 = r1
                r16 = r12
                goto L_0x0239
            L_0x024e:
                androidx.media3.common.util.ParsableByteArray r1 = new androidx.media3.common.util.ParsableByteArray
                java.lang.String r2 = r0.f13431b
                byte[] r2 = r0.g(r2)
                r1.<init>((byte[]) r2)
                androidx.media3.extractor.HevcConfig r1 = androidx.media3.extractor.HevcConfig.a(r1)
                java.util.List<byte[]> r2 = r1.f13071a
                int r4 = r1.f13072b
                r0.Z = r4
                java.lang.String r1 = r1.f13081k
                java.lang.String r16 = "video/hevc"
            L_0x0267:
                r5 = 0
                r6 = -1
                r14 = -1
                r18 = r2
                r2 = r1
                r1 = r18
                goto L_0x040e
            L_0x0271:
                byte[] r1 = androidx.media3.extractor.mkv.MatroskaExtractor.g3
                java.lang.String r2 = r0.f13431b
                byte[] r2 = r0.g(r2)
                com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.L(r1, r2)
                r2 = r10
                r16 = r11
                goto L_0x0239
            L_0x0283:
                int r1 = r0.Q
                int r1 = androidx.media3.common.util.Util.C0(r1)
                if (r1 != 0) goto L_0x02ac
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Unsupported little endian PCM bit depth: "
            L_0x0292:
                r1.append(r2)
                int r2 = r0.Q
                r1.append(r2)
                r1.append(r6)
                r1.append(r14)
                java.lang.String r1 = r1.toString()
                androidx.media3.common.util.Log.n(r4, r1)
                r1 = r10
                r2 = r1
                r16 = r14
                goto L_0x0239
            L_0x02ac:
                r14 = r1
            L_0x02ad:
                r1 = r10
                r2 = r1
                r5 = 0
            L_0x02b0:
                r6 = -1
                goto L_0x040e
            L_0x02b3:
                int r1 = r0.Q
                if (r1 != r15) goto L_0x02be
                r1 = r10
                r2 = r1
                r5 = 0
                r6 = -1
                r14 = 3
                goto L_0x040e
            L_0x02be:
                if (r1 != r2) goto L_0x02c3
                r14 = 268435456(0x10000000, float:2.5243549E-29)
                goto L_0x02ad
            L_0x02c3:
                r2 = 24
                if (r1 != r2) goto L_0x02ca
                r14 = 1342177280(0x50000000, float:8.5899346E9)
                goto L_0x02ad
            L_0x02ca:
                r2 = 32
                if (r1 != r2) goto L_0x02d1
                r14 = 1610612736(0x60000000, float:3.6893488E19)
                goto L_0x02ad
            L_0x02d1:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Unsupported big endian PCM bit depth: "
                goto L_0x0292
            L_0x02d9:
                int r1 = r0.Q
                r2 = 32
                if (r1 != r2) goto L_0x02e6
                r1 = r10
                r2 = r1
                r5 = 0
                r6 = -1
                r14 = 4
                goto L_0x040e
            L_0x02e6:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Unsupported floating point PCM bit depth: "
                goto L_0x0292
            L_0x02ee:
                java.lang.String r16 = "video/x-unknown"
                goto L_0x023e
            L_0x02f2:
                r16 = r9
                goto L_0x023e
            L_0x02f6:
                java.lang.String r16 = "video/x-vnd.on2.vp9"
                goto L_0x023e
            L_0x02fa:
                java.lang.String r16 = "video/x-vnd.on2.vp8"
                goto L_0x023e
            L_0x02fe:
                java.lang.String r16 = "video/av01"
                goto L_0x023e
            L_0x0302:
                java.lang.String r16 = "audio/vnd.dts"
                goto L_0x023e
            L_0x0306:
                java.lang.String r16 = "audio/ac3"
                goto L_0x023e
            L_0x030a:
                java.lang.String r1 = r0.f13431b
                byte[] r1 = r0.g(r1)
                java.util.List r1 = java.util.Collections.singletonList(r1)
                byte[] r2 = r0.f13440k
                androidx.media3.extractor.AacUtil$Config r2 = androidx.media3.extractor.AacUtil.f(r2)
                int r4 = r2.f12885a
                r0.R = r4
                int r4 = r2.f12886b
                r0.P = r4
                java.lang.String r2 = r2.f12887c
                java.lang.String r16 = "audio/mp4a-latm"
                goto L_0x0239
            L_0x0328:
                java.lang.String r16 = "audio/vnd.dts.hd"
                goto L_0x023e
            L_0x032c:
                java.lang.String r1 = r0.f13431b
                byte[] r1 = r0.g(r1)
                com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.K(r1)
                r16 = r8
                goto L_0x0238
            L_0x033a:
                androidx.media3.common.util.ParsableByteArray r1 = new androidx.media3.common.util.ParsableByteArray
                java.lang.String r2 = r0.f13431b
                byte[] r2 = r0.g(r2)
                r1.<init>((byte[]) r2)
                androidx.media3.extractor.AvcConfig r1 = androidx.media3.extractor.AvcConfig.b(r1)
                java.util.List<byte[]> r2 = r1.f12924a
                int r4 = r1.f12925b
                r0.Z = r4
                java.lang.String r1 = r1.f12934k
                java.lang.String r16 = "video/avc"
                goto L_0x0267
            L_0x0355:
                r1 = 4
                byte[] r2 = new byte[r1]
                java.lang.String r4 = r0.f13431b
                byte[] r4 = r0.g(r4)
                r5 = 0
                java.lang.System.arraycopy(r4, r5, r2, r5, r1)
                com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.K(r2)
                r16 = r7
            L_0x0368:
                r2 = r10
                goto L_0x023a
            L_0x036b:
                r5 = 0
                androidx.media3.common.util.ParsableByteArray r1 = new androidx.media3.common.util.ParsableByteArray
                java.lang.String r2 = r0.f13431b
                byte[] r2 = r0.g(r2)
                r1.<init>((byte[]) r2)
                android.util.Pair r1 = k(r1)
                java.lang.Object r2 = r1.first
                r16 = r2
                java.lang.String r16 = (java.lang.String) r16
                java.lang.Object r1 = r1.second
                java.util.List r1 = (java.util.List) r1
                goto L_0x0368
            L_0x0386:
                r5 = 0
                java.lang.String r16 = "audio/mpeg"
            L_0x0389:
                r1 = r10
                r2 = r1
                r6 = 4096(0x1000, float:5.74E-42)
                goto L_0x0229
            L_0x038f:
                r5 = 0
                java.lang.String r16 = "audio/mpeg-L2"
                goto L_0x0389
            L_0x0393:
                r5 = 0
                java.lang.String r1 = r0.f13431b
                byte[] r1 = r0.g(r1)
                java.util.List r1 = m(r1)
                java.lang.String r16 = "audio/vorbis"
                r6 = 8192(0x2000, float:1.14794E-41)
                r2 = r10
                goto L_0x0229
            L_0x03a5:
                r5 = 0
                androidx.media3.extractor.TrueHdSampleRechunker r1 = new androidx.media3.extractor.TrueHdSampleRechunker
                r1.<init>()
                r0.U = r1
                java.lang.String r16 = "audio/true-hd"
                r1 = r10
                r2 = r1
                goto L_0x023a
            L_0x03b3:
                r5 = 0
                androidx.media3.common.util.ParsableByteArray r1 = new androidx.media3.common.util.ParsableByteArray
                java.lang.String r2 = r0.f13431b
                byte[] r2 = r0.g(r2)
                r1.<init>((byte[]) r2)
                boolean r1 = l(r1)
                if (r1 == 0) goto L_0x03f4
                int r1 = r0.Q
                int r1 = androidx.media3.common.util.Util.C0(r1)
                if (r1 != 0) goto L_0x03ef
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Unsupported PCM bit depth: "
                r1.append(r2)
                int r2 = r0.Q
                r1.append(r2)
                r1.append(r6)
            L_0x03df:
                r1.append(r14)
                java.lang.String r1 = r1.toString()
                androidx.media3.common.util.Log.n(r4, r1)
                r1 = r10
                r2 = r1
                r16 = r14
                goto L_0x023a
            L_0x03ef:
                r14 = r1
                r1 = r10
                r2 = r1
                goto L_0x02b0
            L_0x03f4:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Non-PCM MS/ACM is unsupported. Setting mimeType to "
                r1.append(r2)
                goto L_0x03df
            L_0x03ff:
                r5 = 0
                byte[] r1 = r0.f13440k
                if (r1 != 0) goto L_0x0406
                r1 = r10
                goto L_0x040a
            L_0x0406:
                java.util.List r1 = java.util.Collections.singletonList(r1)
            L_0x040a:
                java.lang.String r16 = "video/mp4v-es"
                goto L_0x0368
            L_0x040e:
                byte[] r4 = r0.O
                if (r4 == 0) goto L_0x0423
                androidx.media3.common.util.ParsableByteArray r4 = new androidx.media3.common.util.ParsableByteArray
                byte[] r15 = r0.O
                r4.<init>((byte[]) r15)
                androidx.media3.extractor.DolbyVisionConfig r4 = androidx.media3.extractor.DolbyVisionConfig.a(r4)
                if (r4 == 0) goto L_0x0423
                java.lang.String r2 = r4.f13014c
                java.lang.String r16 = "video/dolby-vision"
            L_0x0423:
                r4 = r16
                boolean r15 = r0.W
                boolean r3 = r0.V
                if (r3 == 0) goto L_0x042d
                r3 = 2
                goto L_0x042e
            L_0x042d:
                r3 = 0
            L_0x042e:
                r3 = r3 | r15
                androidx.media3.common.Format$Builder r15 = new androidx.media3.common.Format$Builder
                r15.<init>()
                boolean r16 = androidx.media3.common.MimeTypes.p(r4)
                if (r16 == 0) goto L_0x044c
                int r5 = r0.P
                androidx.media3.common.Format$Builder r5 = r15.L(r5)
                int r7 = r0.R
                androidx.media3.common.Format$Builder r5 = r5.l0(r7)
                r5.e0(r14)
                r5 = 1
                goto L_0x0575
            L_0x044c:
                boolean r14 = androidx.media3.common.MimeTypes.t(r4)
                if (r14 == 0) goto L_0x0548
                int r7 = r0.r
                if (r7 != 0) goto L_0x0468
                int r7 = r0.p
                r8 = -1
                if (r7 != r8) goto L_0x045d
                int r7 = r0.f13442m
            L_0x045d:
                r0.p = r7
                int r7 = r0.q
                if (r7 != r8) goto L_0x0465
                int r7 = r0.f13443n
            L_0x0465:
                r0.q = r7
                goto L_0x0469
            L_0x0468:
                r8 = -1
            L_0x0469:
                int r7 = r0.p
                if (r7 == r8) goto L_0x047d
                int r9 = r0.q
                if (r9 == r8) goto L_0x047d
                int r11 = r0.f13443n
                int r11 = r11 * r7
                float r7 = (float) r11
                int r11 = r0.f13442m
                int r11 = r11 * r9
                float r9 = (float) r11
                float r7 = r7 / r9
                goto L_0x047f
            L_0x047d:
                r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            L_0x047f:
                boolean r9 = r0.y
                if (r9 == 0) goto L_0x04b2
                byte[] r9 = r19.h()
                androidx.media3.common.ColorInfo$Builder r10 = new androidx.media3.common.ColorInfo$Builder
                r10.<init>()
                int r11 = r0.z
                androidx.media3.common.ColorInfo$Builder r10 = r10.d(r11)
                int r11 = r0.B
                androidx.media3.common.ColorInfo$Builder r10 = r10.c(r11)
                int r11 = r0.A
                androidx.media3.common.ColorInfo$Builder r10 = r10.e(r11)
                androidx.media3.common.ColorInfo$Builder r9 = r10.f(r9)
                int r10 = r0.o
                androidx.media3.common.ColorInfo$Builder r9 = r9.g(r10)
                int r10 = r0.o
                androidx.media3.common.ColorInfo$Builder r9 = r9.b(r10)
                androidx.media3.common.ColorInfo r10 = r9.a()
            L_0x04b2:
                java.lang.String r9 = r0.f13430a
                if (r9 == 0) goto L_0x04d2
                java.util.Map r9 = androidx.media3.extractor.mkv.MatroskaExtractor.t3
                java.lang.String r11 = r0.f13430a
                boolean r9 = r9.containsKey(r11)
                if (r9 == 0) goto L_0x04d2
                java.util.Map r8 = androidx.media3.extractor.mkv.MatroskaExtractor.t3
                java.lang.String r9 = r0.f13430a
                java.lang.Object r8 = r8.get(r9)
                java.lang.Integer r8 = (java.lang.Integer) r8
                int r8 = r8.intValue()
            L_0x04d2:
                int r9 = r0.s
                if (r9 != 0) goto L_0x0522
                float r9 = r0.t
                r11 = 0
                int r9 = java.lang.Float.compare(r9, r11)
                if (r9 != 0) goto L_0x0522
                float r9 = r0.u
                int r9 = java.lang.Float.compare(r9, r11)
                if (r9 != 0) goto L_0x0522
                float r9 = r0.v
                int r9 = java.lang.Float.compare(r9, r11)
                if (r9 != 0) goto L_0x04f0
                goto L_0x0523
            L_0x04f0:
                float r5 = r0.v
                r9 = 1119092736(0x42b40000, float:90.0)
                int r5 = java.lang.Float.compare(r5, r9)
                if (r5 != 0) goto L_0x04fd
                r5 = 90
                goto L_0x0523
            L_0x04fd:
                float r5 = r0.v
                r9 = -1020002304(0xffffffffc3340000, float:-180.0)
                int r5 = java.lang.Float.compare(r5, r9)
                if (r5 == 0) goto L_0x051f
                float r5 = r0.v
                r9 = 1127481344(0x43340000, float:180.0)
                int r5 = java.lang.Float.compare(r5, r9)
                if (r5 != 0) goto L_0x0512
                goto L_0x051f
            L_0x0512:
                float r5 = r0.v
                r9 = -1028390912(0xffffffffc2b40000, float:-90.0)
                int r5 = java.lang.Float.compare(r5, r9)
                if (r5 != 0) goto L_0x0522
                r5 = 270(0x10e, float:3.78E-43)
                goto L_0x0523
            L_0x051f:
                r5 = 180(0xb4, float:2.52E-43)
                goto L_0x0523
            L_0x0522:
                r5 = r8
            L_0x0523:
                int r8 = r0.f13442m
                androidx.media3.common.Format$Builder r8 = r15.r0(r8)
                int r9 = r0.f13443n
                androidx.media3.common.Format$Builder r8 = r8.V(r9)
                androidx.media3.common.Format$Builder r7 = r8.g0(r7)
                androidx.media3.common.Format$Builder r5 = r7.j0(r5)
                byte[] r7 = r0.w
                androidx.media3.common.Format$Builder r5 = r5.h0(r7)
                int r7 = r0.x
                androidx.media3.common.Format$Builder r5 = r5.n0(r7)
                r5.N(r10)
                r5 = 2
                goto L_0x0575
            L_0x0548:
                boolean r5 = r13.equals(r4)
                if (r5 != 0) goto L_0x0574
                boolean r5 = r11.equals(r4)
                if (r5 != 0) goto L_0x0574
                boolean r5 = r12.equals(r4)
                if (r5 != 0) goto L_0x0574
                boolean r5 = r8.equals(r4)
                if (r5 != 0) goto L_0x0574
                boolean r5 = r9.equals(r4)
                if (r5 != 0) goto L_0x0574
                boolean r5 = r7.equals(r4)
                if (r5 == 0) goto L_0x056d
                goto L_0x0574
            L_0x056d:
                java.lang.String r1 = "Unexpected MIME type."
                androidx.media3.common.ParserException r1 = androidx.media3.common.ParserException.a(r1, r10)
                throw r1
            L_0x0574:
                r5 = 3
            L_0x0575:
                java.lang.String r7 = r0.f13430a
                if (r7 == 0) goto L_0x058a
                java.util.Map r7 = androidx.media3.extractor.mkv.MatroskaExtractor.t3
                java.lang.String r8 = r0.f13430a
                boolean r7 = r7.containsKey(r8)
                if (r7 != 0) goto L_0x058a
                java.lang.String r7 = r0.f13430a
                r15.Z(r7)
            L_0x058a:
                r7 = r21
                androidx.media3.common.Format$Builder r7 = r15.W(r7)
                androidx.media3.common.Format$Builder r4 = r7.k0(r4)
                androidx.media3.common.Format$Builder r4 = r4.c0(r6)
                java.lang.String r6 = r0.X
                androidx.media3.common.Format$Builder r4 = r4.b0(r6)
                androidx.media3.common.Format$Builder r3 = r4.m0(r3)
                androidx.media3.common.Format$Builder r1 = r3.Y(r1)
                androidx.media3.common.Format$Builder r1 = r1.M(r2)
                androidx.media3.common.DrmInitData r2 = r0.f13441l
                androidx.media3.common.Format$Builder r1 = r1.R(r2)
                androidx.media3.common.Format r1 = r1.I()
                int r2 = r0.f13432c
                r3 = r20
                androidx.media3.extractor.TrackOutput r2 = r3.d(r2, r5)
                r0.Y = r2
                r2.e(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mkv.MatroskaExtractor.Track.i(androidx.media3.extractor.ExtractorOutput, int):void");
        }

        @RequiresNonNull({"output"})
        public void j() {
            TrueHdSampleRechunker trueHdSampleRechunker = this.U;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.a(this.Y, this.f13439j);
            }
        }

        public void n() {
            TrueHdSampleRechunker trueHdSampleRechunker = this.U;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.b();
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", Integer.valueOf(BuildConfig.f29478d));
        hashMap.put("htc_video_rotA-270", Integer.valueOf(TIFFConstants.e0));
        t3 = Collections.unmodifiableMap(hashMap);
    }

    @Deprecated
    public MatroskaExtractor() {
        this(new DefaultEbmlReader(), 2, SubtitleParser.Factory.f13783a);
    }

    private static boolean B(String str) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -2095576542:
                if (str.equals(x0)) {
                    c4 = 0;
                    break;
                }
                break;
            case -2095575984:
                if (str.equals(v0)) {
                    c4 = 1;
                    break;
                }
                break;
            case -1985379776:
                if (str.equals(O0)) {
                    c4 = 2;
                    break;
                }
                break;
            case -1784763192:
                if (str.equals(J0)) {
                    c4 = 3;
                    break;
                }
                break;
            case -1730367663:
                if (str.equals(C0)) {
                    c4 = 4;
                    break;
                }
                break;
            case -1482641358:
                if (str.equals(F0)) {
                    c4 = 5;
                    break;
                }
                break;
            case -1482641357:
                if (str.equals(G0)) {
                    c4 = 6;
                    break;
                }
                break;
            case -1373388978:
                if (str.equals(A0)) {
                    c4 = 7;
                    break;
                }
                break;
            case -933872740:
                if (str.equals(X0)) {
                    c4 = 8;
                    break;
                }
                break;
            case -538363189:
                if (str.equals(w0)) {
                    c4 = 9;
                    break;
                }
                break;
            case -538363109:
                if (str.equals(y0)) {
                    c4 = 10;
                    break;
                }
                break;
            case -425012669:
                if (str.equals(V0)) {
                    c4 = 11;
                    break;
                }
                break;
            case -356037306:
                if (str.equals(M0)) {
                    c4 = 12;
                    break;
                }
                break;
            case 62923557:
                if (str.equals(E0)) {
                    c4 = 13;
                    break;
                }
                break;
            case 62923603:
                if (str.equals(H0)) {
                    c4 = 14;
                    break;
                }
                break;
            case 62927045:
                if (str.equals(K0)) {
                    c4 = 15;
                    break;
                }
                break;
            case 82318131:
                if (str.equals(t0)) {
                    c4 = 16;
                    break;
                }
                break;
            case 82338133:
                if (str.equals(r0)) {
                    c4 = 17;
                    break;
                }
                break;
            case 82338134:
                if (str.equals(s0)) {
                    c4 = 18;
                    break;
                }
                break;
            case 99146302:
                if (str.equals(W0)) {
                    c4 = 19;
                    break;
                }
                break;
            case 444813526:
                if (str.equals(B0)) {
                    c4 = 20;
                    break;
                }
                break;
            case 542569478:
                if (str.equals(L0)) {
                    c4 = 21;
                    break;
                }
                break;
            case 635596514:
                if (str.equals(R0)) {
                    c4 = 22;
                    break;
                }
                break;
            case 725948237:
                if (str.equals(Q0)) {
                    c4 = 23;
                    break;
                }
                break;
            case 725957860:
                if (str.equals(P0)) {
                    c4 = 24;
                    break;
                }
                break;
            case 738597099:
                if (str.equals(T0)) {
                    c4 = 25;
                    break;
                }
                break;
            case 855502857:
                if (str.equals(z0)) {
                    c4 = 26;
                    break;
                }
                break;
            case 1045209816:
                if (str.equals(U0)) {
                    c4 = 27;
                    break;
                }
                break;
            case 1422270023:
                if (str.equals(S0)) {
                    c4 = 28;
                    break;
                }
                break;
            case 1809237540:
                if (str.equals(u0)) {
                    c4 = 29;
                    break;
                }
                break;
            case 1950749482:
                if (str.equals(I0)) {
                    c4 = 30;
                    break;
                }
                break;
            case 1950789798:
                if (str.equals(N0)) {
                    c4 = 31;
                    break;
                }
                break;
            case 1951062397:
                if (str.equals(D0)) {
                    c4 = ' ';
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case ' ':
                return true;
            default:
                return false;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] D(SubtitleParser.Factory factory) {
        return new Extractor[]{new MatroskaExtractor(factory)};
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] E() {
        return new Extractor[]{new MatroskaExtractor(SubtitleParser.Factory.f13783a, 2)};
    }

    private boolean F(PositionHolder positionHolder, long j4) {
        if (this.D) {
            this.F = j4;
            positionHolder.f13111a = this.E;
            this.D = false;
            return true;
        }
        if (this.A) {
            long j5 = this.F;
            if (j5 != -1) {
                positionHolder.f13111a = j5;
                this.F = -1;
                return true;
            }
        }
        return false;
    }

    public static ExtractorsFactory G(SubtitleParser.Factory factory) {
        return new a(factory);
    }

    private void H(ExtractorInput extractorInput, int i4) throws IOException {
        if (this.f13426l.g() < i4) {
            if (this.f13426l.b() < i4) {
                ParsableByteArray parsableByteArray = this.f13426l;
                parsableByteArray.c(Math.max(parsableByteArray.b() * 2, i4));
            }
            extractorInput.readFully(this.f13426l.e(), this.f13426l.g(), i4 - this.f13426l.g());
            this.f13426l.X(i4);
        }
    }

    private void I() {
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.a0 = false;
        this.b0 = false;
        this.c0 = false;
        this.d0 = 0;
        this.e0 = 0;
        this.f0 = false;
        this.o.U(0);
    }

    private long J(long j4) throws ParserException {
        long j5 = this.w;
        if (j5 != C.f9084b) {
            return Util.c2(j4, j5, 1000);
        }
        throw ParserException.a("Can't scale timecode prior to timecodeScale being set.", (Throwable) null);
    }

    private static void K(String str, long j4, byte[] bArr) {
        int i4;
        byte[] bArr2;
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case 738597099:
                if (str.equals(T0)) {
                    c4 = 0;
                    break;
                }
                break;
            case 1045209816:
                if (str.equals(U0)) {
                    c4 = 1;
                    break;
                }
                break;
            case 1422270023:
                if (str.equals(S0)) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                bArr2 = v(j4, k3, j3);
                i4 = 21;
                break;
            case 1:
                bArr2 = v(j4, o3, 1000);
                i4 = 25;
                break;
            case 2:
                bArr2 = v(j4, f3, 1000);
                i4 = 19;
                break;
            default:
                throw new IllegalArgumentException();
        }
        System.arraycopy(bArr2, 0, bArr, i4, bArr2.length);
    }

    @RequiresNonNull({"#2.output"})
    private int N(ExtractorInput extractorInput, Track track, int i4, boolean z3) throws IOException {
        int i5;
        if (S0.equals(track.f13431b)) {
            O(extractorInput, c3, i4);
        } else if (T0.equals(track.f13431b)) {
            O(extractorInput, h3, i4);
        } else if (U0.equals(track.f13431b)) {
            O(extractorInput, l3, i4);
        } else {
            TrackOutput trackOutput = track.Y;
            boolean z4 = true;
            if (!this.a0) {
                if (track.f13437h) {
                    this.T &= -1073741825;
                    int i6 = 128;
                    if (!this.b0) {
                        extractorInput.readFully(this.f13426l.e(), 0, 1);
                        this.X++;
                        if ((this.f13426l.e()[0] & 128) != 128) {
                            this.e0 = this.f13426l.e()[0];
                            this.b0 = true;
                        } else {
                            throw ParserException.a("Extension bit is set in signal byte", (Throwable) null);
                        }
                    }
                    byte b4 = this.e0;
                    if ((b4 & 1) == 1) {
                        boolean z5 = (b4 & 2) == 2;
                        this.T |= 1073741824;
                        if (!this.f0) {
                            extractorInput.readFully(this.q.e(), 0, 8);
                            this.X += 8;
                            this.f0 = true;
                            byte[] e4 = this.f13426l.e();
                            if (!z5) {
                                i6 = 0;
                            }
                            e4[0] = (byte) (i6 | 8);
                            this.f13426l.Y(0);
                            trackOutput.a(this.f13426l, 1, 1);
                            this.Y++;
                            this.q.Y(0);
                            trackOutput.a(this.q, 8, 1);
                            this.Y += 8;
                        }
                        if (z5) {
                            if (!this.c0) {
                                extractorInput.readFully(this.f13426l.e(), 0, 1);
                                this.X++;
                                this.f13426l.Y(0);
                                this.d0 = this.f13426l.L();
                                this.c0 = true;
                            }
                            int i7 = this.d0 * 4;
                            this.f13426l.U(i7);
                            extractorInput.readFully(this.f13426l.e(), 0, i7);
                            this.X += i7;
                            short s4 = (short) ((this.d0 / 2) + 1);
                            int i8 = (s4 * 6) + 2;
                            java.nio.ByteBuffer byteBuffer = this.t;
                            if (byteBuffer == null || byteBuffer.capacity() < i8) {
                                this.t = java.nio.ByteBuffer.allocate(i8);
                            }
                            this.t.position(0);
                            this.t.putShort(s4);
                            int i9 = 0;
                            int i10 = 0;
                            while (true) {
                                i5 = this.d0;
                                if (i9 >= i5) {
                                    break;
                                }
                                int P3 = this.f13426l.P();
                                if (i9 % 2 == 0) {
                                    this.t.putShort((short) (P3 - i10));
                                } else {
                                    this.t.putInt(P3 - i10);
                                }
                                i9++;
                                i10 = P3;
                            }
                            int i11 = (i4 - this.X) - i10;
                            int i12 = i5 % 2;
                            java.nio.ByteBuffer byteBuffer2 = this.t;
                            if (i12 == 1) {
                                byteBuffer2.putInt(i11);
                            } else {
                                byteBuffer2.putShort((short) i11);
                                this.t.putInt(0);
                            }
                            this.r.W(this.t.array(), i8);
                            trackOutput.a(this.r, i8, 1);
                            this.Y += i8;
                        }
                    }
                } else {
                    byte[] bArr = track.f13438i;
                    if (bArr != null) {
                        this.o.W(bArr, bArr.length);
                    }
                }
                if (track.o(z3)) {
                    this.T |= 268435456;
                    this.s.U(0);
                    int g4 = (this.o.g() + i4) - this.X;
                    this.f13426l.U(4);
                    this.f13426l.e()[0] = (byte) ((g4 >> 24) & 255);
                    this.f13426l.e()[1] = (byte) ((g4 >> 16) & 255);
                    this.f13426l.e()[2] = (byte) ((g4 >> 8) & 255);
                    this.f13426l.e()[3] = (byte) (g4 & 255);
                    trackOutput.a(this.f13426l, 4, 2);
                    this.Y += 4;
                }
                this.a0 = true;
            }
            int g5 = i4 + this.o.g();
            if (!y0.equals(track.f13431b) && !z0.equals(track.f13431b)) {
                if (track.U != null) {
                    if (this.o.g() != 0) {
                        z4 = false;
                    }
                    Assertions.i(z4);
                    track.U.d(extractorInput);
                }
                while (true) {
                    int i13 = this.X;
                    if (i13 >= g5) {
                        break;
                    }
                    int P4 = P(extractorInput, trackOutput, g5 - i13);
                    this.X += P4;
                    this.Y += P4;
                }
            } else {
                byte[] e5 = this.f13425k.e();
                e5[0] = 0;
                e5[1] = 0;
                e5[2] = 0;
                int i14 = track.Z;
                int i15 = 4 - i14;
                while (this.X < g5) {
                    int i16 = this.Z;
                    if (i16 == 0) {
                        Q(extractorInput, e5, i15, i14);
                        this.X += i14;
                        this.f13425k.Y(0);
                        this.Z = this.f13425k.P();
                        this.f13424j.Y(0);
                        trackOutput.d(this.f13424j, 4);
                        this.Y += 4;
                    } else {
                        int P5 = P(extractorInput, trackOutput, i16);
                        this.X += P5;
                        this.Y += P5;
                        this.Z -= P5;
                    }
                }
            }
            if (C0.equals(track.f13431b)) {
                this.f13427m.Y(0);
                trackOutput.d(this.f13427m, 4);
                this.Y += 4;
            }
            return t();
        }
        return t();
    }

    private void O(ExtractorInput extractorInput, byte[] bArr, int i4) throws IOException {
        int length = bArr.length + i4;
        if (this.p.b() < length) {
            this.p.V(Arrays.copyOf(bArr, length + i4));
        } else {
            System.arraycopy(bArr, 0, this.p.e(), 0, bArr.length);
        }
        extractorInput.readFully(this.p.e(), bArr.length, i4);
        this.p.Y(0);
        this.p.X(length);
    }

    private int P(ExtractorInput extractorInput, TrackOutput trackOutput, int i4) throws IOException {
        int a4 = this.o.a();
        if (a4 <= 0) {
            return trackOutput.b(extractorInput, i4, false);
        }
        int min = Math.min(i4, a4);
        trackOutput.d(this.o, min);
        return min;
    }

    private void Q(ExtractorInput extractorInput, byte[] bArr, int i4, int i5) throws IOException {
        int min = Math.min(i5, this.o.a());
        extractorInput.readFully(bArr, i4 + min, i5 - min);
        if (min > 0) {
            this.o.n(bArr, i4, min);
        }
    }

    @EnsuresNonNull({"cueTimesUs", "cueClusterPositions"})
    private void l(int i4) throws ParserException {
        if (this.H == null || this.I == null) {
            throw ParserException.a("Element " + i4 + " must be in a Cues", (Throwable) null);
        }
    }

    @EnsuresNonNull({"currentTrack"})
    private void m(int i4) throws ParserException {
        if (this.z == null) {
            throw ParserException.a("Element " + i4 + " must be in a TrackEntry", (Throwable) null);
        }
    }

    @EnsuresNonNull({"extractorOutput"})
    private void n() {
        Assertions.k(this.g0);
    }

    private SeekMap p(@Nullable LongArray longArray, @Nullable LongArray longArray2) {
        int i4;
        if (this.v == -1 || this.y == C.f9084b || longArray == null || longArray.c() == 0 || longArray2 == null || longArray2.c() != longArray.c()) {
            return new SeekMap.Unseekable(this.y);
        }
        int c4 = longArray.c();
        int[] iArr = new int[c4];
        long[] jArr = new long[c4];
        long[] jArr2 = new long[c4];
        long[] jArr3 = new long[c4];
        int i5 = 0;
        for (int i6 = 0; i6 < c4; i6++) {
            jArr3[i6] = longArray.b(i6);
            jArr[i6] = this.v + longArray2.b(i6);
        }
        while (true) {
            i4 = c4 - 1;
            if (i5 >= i4) {
                break;
            }
            int i7 = i5 + 1;
            iArr[i5] = (int) (jArr[i7] - jArr[i5]);
            jArr2[i5] = jArr3[i7] - jArr3[i5];
            i5 = i7;
        }
        iArr[i4] = (int) ((this.v + this.u) - jArr[i4]);
        long j4 = this.y - jArr3[i4];
        jArr2[i4] = j4;
        if (j4 <= 0) {
            Log.n(k0, "Discarding last cue point with unexpected duration: " + j4);
            iArr = Arrays.copyOf(iArr, i4);
            jArr = Arrays.copyOf(jArr, i4);
            jArr2 = Arrays.copyOf(jArr2, i4);
            jArr3 = Arrays.copyOf(jArr3, i4);
        }
        return new ChunkIndex(iArr, jArr, jArr2, jArr3);
    }

    @RequiresNonNull({"#1.output"})
    private void q(Track track, long j4, int i4, int i5, int i6) {
        String str;
        TrueHdSampleRechunker trueHdSampleRechunker = track.U;
        if (trueHdSampleRechunker != null) {
            trueHdSampleRechunker.c(track.Y, j4, i4, i5, i6, track.f13439j);
        } else {
            if (S0.equals(track.f13431b) || T0.equals(track.f13431b) || U0.equals(track.f13431b)) {
                if (this.P > 1) {
                    str = "Skipping subtitle sample in laced block.";
                } else {
                    long j5 = this.N;
                    if (j5 == C.f9084b) {
                        str = "Skipping subtitle sample with no duration.";
                    } else {
                        K(track.f13431b, j5, this.p.e());
                        int f4 = this.p.f();
                        while (true) {
                            if (f4 >= this.p.g()) {
                                break;
                            } else if (this.p.e()[f4] == 0) {
                                this.p.X(f4);
                                break;
                            } else {
                                f4++;
                            }
                        }
                        TrackOutput trackOutput = track.Y;
                        ParsableByteArray parsableByteArray = this.p;
                        trackOutput.d(parsableByteArray, parsableByteArray.g());
                        i5 += this.p.g();
                    }
                }
                Log.n(k0, str);
            }
            if ((268435456 & i4) != 0) {
                if (this.P > 1) {
                    this.s.U(0);
                } else {
                    int g4 = this.s.g();
                    track.Y.a(this.s, g4, 2);
                    i5 += g4;
                }
            }
            track.Y.f(j4, i4, i5, i6, track.f13439j);
        }
        this.K = true;
    }

    private static int[] s(@Nullable int[] iArr, int i4) {
        if (iArr == null) {
            return new int[i4];
        }
        return iArr.length >= i4 ? iArr : new int[Math.max(iArr.length * 2, i4)];
    }

    private int t() {
        int i4 = this.Y;
        I();
        return i4;
    }

    private static byte[] v(long j4, String str, long j5) {
        Assertions.a(j4 != C.f9084b);
        int i4 = (int) (j4 / 3600000000L);
        long j6 = j4 - (((long) i4) * 3600000000L);
        int i5 = (int) (j6 / 60000000);
        long j7 = j6 - (((long) i5) * 60000000);
        int i6 = (int) (j7 / 1000000);
        return Util.R0(String.format(Locale.US, str, new Object[]{Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf((int) ((j7 - (((long) i6) * 1000000)) / j5))}));
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void A(int i4, long j4) throws ParserException {
        if (i4 != d2) {
            if (i4 != e2) {
                boolean z3 = false;
                switch (i4) {
                    case D1 /*131*/:
                        w(i4).f13433d = (int) j4;
                        return;
                    case 136:
                        Track w3 = w(i4);
                        if (j4 == 1) {
                            z3 = true;
                        }
                        w3.W = z3;
                        return;
                    case u1 /*155*/:
                        this.N = J(j4);
                        return;
                    case Y1 /*159*/:
                        w(i4).P = (int) j4;
                        return;
                    case S1 /*176*/:
                        w(i4).f13442m = (int) j4;
                        return;
                    case p2 /*179*/:
                        l(i4);
                        this.H.a(J(j4));
                        return;
                    case T1 /*186*/:
                        w(i4).f13443n = (int) j4;
                        return;
                    case C1 /*215*/:
                        w(i4).f13432c = (int) j4;
                        return;
                    case q1 /*231*/:
                        this.G = J(j4);
                        return;
                    case 238:
                        this.U = (int) j4;
                        return;
                    case r2 /*241*/:
                        if (!this.J) {
                            l(i4);
                            this.I.a(j4);
                            this.J = true;
                            return;
                        }
                        return;
                    case z1 /*251*/:
                        this.V = true;
                        return;
                    case J1 /*16871*/:
                        int unused = w(i4).f13436g = (int) j4;
                        return;
                    case g2 /*16980*/:
                        if (j4 != 3) {
                            throw ParserException.a("ContentCompAlgo " + j4 + " not supported", (Throwable) null);
                        }
                        return;
                    case f1 /*17029*/:
                        if (j4 < 1 || j4 > 2) {
                            throw ParserException.a("DocTypeReadVersion " + j4 + " not supported", (Throwable) null);
                        }
                        return;
                    case d1 /*17143*/:
                        if (j4 != 1) {
                            throw ParserException.a("EBMLReadVersion " + j4 + " not supported", (Throwable) null);
                        }
                        return;
                    case j2 /*18401*/:
                        if (j4 != 5) {
                            throw ParserException.a("ContentEncAlgo " + j4 + " not supported", (Throwable) null);
                        }
                        return;
                    case m2 /*18408*/:
                        if (j4 != 1) {
                            throw ParserException.a("AESSettingsCipherMode " + j4 + " not supported", (Throwable) null);
                        }
                        return;
                    case l1 /*21420*/:
                        this.C = j4 + this.v;
                        return;
                    case z2 /*21432*/:
                        int i5 = (int) j4;
                        m(i4);
                        if (i5 == 0) {
                            this.z.x = 0;
                            return;
                        } else if (i5 == 1) {
                            this.z.x = 2;
                            return;
                        } else if (i5 == 3) {
                            this.z.x = 1;
                            return;
                        } else if (i5 == 15) {
                            this.z.x = 3;
                            return;
                        } else {
                            return;
                        }
                    case U1 /*21680*/:
                        w(i4).p = (int) j4;
                        return;
                    case W1 /*21682*/:
                        w(i4).r = (int) j4;
                        return;
                    case V1 /*21690*/:
                        w(i4).q = (int) j4;
                        return;
                    case F1 /*21930*/:
                        Track w4 = w(i4);
                        if (j4 == 1) {
                            z3 = true;
                        }
                        w4.V = z3;
                        return;
                    case C2 /*21938*/:
                        m(i4);
                        Track track = this.z;
                        track.y = true;
                        track.o = (int) j4;
                        return;
                    case H1 /*21998*/:
                        w(i4).f13435f = (int) j4;
                        return;
                    case O1 /*22186*/:
                        w(i4).S = j4;
                        return;
                    case P1 /*22203*/:
                        w(i4).T = j4;
                        return;
                    case Z1 /*25188*/:
                        w(i4).Q = (int) j4;
                        return;
                    case Q1 /*30114*/:
                        this.W = j4;
                        return;
                    case u2 /*30321*/:
                        m(i4);
                        int i6 = (int) j4;
                        if (i6 == 0) {
                            this.z.s = 0;
                            return;
                        } else if (i6 == 1) {
                            this.z.s = 1;
                            return;
                        } else if (i6 == 2) {
                            this.z.s = 2;
                            return;
                        } else if (i6 == 3) {
                            this.z.s = 3;
                            return;
                        } else {
                            return;
                        }
                    case G1 /*2352003*/:
                        w(i4).f13434e = (int) j4;
                        return;
                    case n1 /*2807729*/:
                        this.w = j4;
                        return;
                    default:
                        switch (i4) {
                            case B2 /*21945*/:
                                m(i4);
                                int i7 = (int) j4;
                                if (i7 == 1) {
                                    this.z.B = 2;
                                    return;
                                } else if (i7 == 2) {
                                    this.z.B = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case D2 /*21946*/:
                                m(i4);
                                int n4 = ColorInfo.n((int) j4);
                                if (n4 != -1) {
                                    this.z.A = n4;
                                    return;
                                }
                                return;
                            case E2 /*21947*/:
                                m(i4);
                                this.z.y = true;
                                int m4 = ColorInfo.m((int) j4);
                                if (m4 != -1) {
                                    this.z.z = m4;
                                    return;
                                }
                                return;
                            case F2 /*21948*/:
                                w(i4).C = (int) j4;
                                return;
                            case G2 /*21949*/:
                                w(i4).D = (int) j4;
                                return;
                            default:
                                return;
                        }
                }
            } else if (j4 != 1) {
                throw ParserException.a("ContentEncodingScope " + j4 + " not supported", (Throwable) null);
            }
        } else if (j4 != 0) {
            throw ParserException.a("ContentEncodingOrder " + j4 + " not supported", (Throwable) null);
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public boolean C(int i4) {
        return i4 == 357149030 || i4 == p1 || i4 == n2 || i4 == A1;
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void L(int i4, long j4, long j5) throws ParserException {
        n();
        if (i4 == s1) {
            this.V = false;
            this.W = 0;
        } else if (i4 == B1) {
            this.z = new Track();
        } else if (i4 == o2) {
            this.J = false;
        } else if (i4 == j1) {
            this.B = -1;
            this.C = -1;
        } else if (i4 == i2) {
            w(i4).f13437h = true;
        } else if (i4 == H2) {
            w(i4).y = true;
        } else if (i4 == g1) {
            long j6 = this.v;
            if (j6 == -1 || j6 == j4) {
                this.v = j4;
                this.u = j5;
                return;
            }
            throw ParserException.a("Multiple Segment elements not supported", (Throwable) null);
        } else if (i4 == n2) {
            this.H = new LongArray();
            this.I = new LongArray();
        } else if (i4 != p1 || this.A) {
        } else {
            if (!this.f13421g || this.E == -1) {
                this.g0.j(new SeekMap.Unseekable(this.y));
                this.A = true;
                return;
            }
            this.D = true;
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void M(int i4, String str) throws ParserException {
        if (i4 == 134) {
            w(i4).f13431b = str;
        } else if (i4 != 17026) {
            if (i4 == L1) {
                w(i4).f13430a = str;
            } else if (i4 == s2) {
                String unused = w(i4).X = str;
            }
        } else if (!q0.equals(str) && !p0.equals(str)) {
            throw ParserException.a("DocType " + str + " not supported", (Throwable) null);
        }
    }

    public final void a() {
    }

    @CallSuper
    public void c(long j4, long j5) {
        this.G = C.f9084b;
        this.L = 0;
        this.f13418d.reset();
        this.f13419e.e();
        I();
        for (int i4 = 0; i4 < this.f13420f.size(); i4++) {
            this.f13420f.valueAt(i4).n();
        }
    }

    public final void d(ExtractorOutput extractorOutput) {
        this.g0 = extractorOutput;
        if (this.f13422h) {
            extractorOutput = new SubtitleTranscodingExtractorOutput(extractorOutput, this.f13423i);
        }
        this.g0 = extractorOutput;
    }

    public /* synthetic */ Extractor e() {
        return d.a(this);
    }

    public final boolean h(ExtractorInput extractorInput) throws IOException {
        return new Sniffer().b(extractorInput);
    }

    public final int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        this.K = false;
        boolean z3 = true;
        while (z3 && !this.K) {
            z3 = this.f13418d.b(extractorInput);
            if (z3 && F(positionHolder, extractorInput.getPosition())) {
                return 1;
            }
        }
        if (z3) {
            return 0;
        }
        for (int i4 = 0; i4 < this.f13420f.size(); i4++) {
            Track valueAt = this.f13420f.valueAt(i4);
            valueAt.f();
            valueAt.j();
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0231, code lost:
        throw androidx.media3.common.ParserException.a("EBML lacing sample size out of range.", (java.lang.Throwable) null);
     */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0280  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0282  */
    @androidx.annotation.CallSuper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void o(int r22, int r23, androidx.media3.extractor.ExtractorInput r24) throws java.io.IOException {
        /*
            r21 = this;
            r7 = r21
            r0 = r22
            r1 = r23
            r8 = r24
            r2 = 161(0xa1, float:2.26E-43)
            r3 = 163(0xa3, float:2.28E-43)
            r4 = 0
            r5 = 2
            r9 = 0
            r10 = 1
            if (r0 == r2) goto L_0x00c5
            if (r0 == r3) goto L_0x00c5
            r2 = 165(0xa5, float:2.31E-43)
            if (r0 == r2) goto L_0x00af
            r2 = 16877(0x41ed, float:2.365E-41)
            if (r0 == r2) goto L_0x00a6
            r2 = 16981(0x4255, float:2.3795E-41)
            if (r0 == r2) goto L_0x0098
            r2 = 18402(0x47e2, float:2.5787E-41)
            if (r0 == r2) goto L_0x0086
            r2 = 21419(0x53ab, float:3.0014E-41)
            if (r0 == r2) goto L_0x0062
            r2 = 25506(0x63a2, float:3.5742E-41)
            if (r0 == r2) goto L_0x0054
            r2 = 30322(0x7672, float:4.249E-41)
            if (r0 != r2) goto L_0x003e
            r21.m(r22)
            androidx.media3.extractor.mkv.MatroskaExtractor$Track r0 = r7.z
            byte[] r2 = new byte[r1]
            r0.w = r2
            r8.readFully(r2, r9, r1)
            goto L_0x02ed
        L_0x003e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unexpected id: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            androidx.media3.common.ParserException r0 = androidx.media3.common.ParserException.a(r0, r4)
            throw r0
        L_0x0054:
            r21.m(r22)
            androidx.media3.extractor.mkv.MatroskaExtractor$Track r0 = r7.z
            byte[] r2 = new byte[r1]
            r0.f13440k = r2
            r8.readFully(r2, r9, r1)
            goto L_0x02ed
        L_0x0062:
            androidx.media3.common.util.ParsableByteArray r0 = r7.f13428n
            byte[] r0 = r0.e()
            java.util.Arrays.fill(r0, r9)
            androidx.media3.common.util.ParsableByteArray r0 = r7.f13428n
            byte[] r0 = r0.e()
            int r2 = 4 - r1
            r8.readFully(r0, r2, r1)
            androidx.media3.common.util.ParsableByteArray r0 = r7.f13428n
            r0.Y(r9)
            androidx.media3.common.util.ParsableByteArray r0 = r7.f13428n
            long r0 = r0.N()
            int r1 = (int) r0
            r7.B = r1
            goto L_0x02ed
        L_0x0086:
            byte[] r2 = new byte[r1]
            r8.readFully(r2, r9, r1)
            androidx.media3.extractor.mkv.MatroskaExtractor$Track r0 = r21.w(r22)
            androidx.media3.extractor.TrackOutput$CryptoData r1 = new androidx.media3.extractor.TrackOutput$CryptoData
            r1.<init>(r10, r2, r9, r9)
            r0.f13439j = r1
            goto L_0x02ed
        L_0x0098:
            r21.m(r22)
            androidx.media3.extractor.mkv.MatroskaExtractor$Track r0 = r7.z
            byte[] r2 = new byte[r1]
            r0.f13438i = r2
            r8.readFully(r2, r9, r1)
            goto L_0x02ed
        L_0x00a6:
            androidx.media3.extractor.mkv.MatroskaExtractor$Track r0 = r21.w(r22)
            r7.y(r0, r8, r1)
            goto L_0x02ed
        L_0x00af:
            int r0 = r7.L
            if (r0 == r5) goto L_0x00b4
            return
        L_0x00b4:
            android.util.SparseArray<androidx.media3.extractor.mkv.MatroskaExtractor$Track> r0 = r7.f13420f
            int r2 = r7.R
            java.lang.Object r0 = r0.get(r2)
            androidx.media3.extractor.mkv.MatroskaExtractor$Track r0 = (androidx.media3.extractor.mkv.MatroskaExtractor.Track) r0
            int r2 = r7.U
            r7.z(r0, r2, r8, r1)
            goto L_0x02ed
        L_0x00c5:
            int r2 = r7.L
            r6 = 8
            if (r2 != 0) goto L_0x00ea
            androidx.media3.extractor.mkv.VarintReader r2 = r7.f13419e
            long r11 = r2.d(r8, r9, r10, r6)
            int r2 = (int) r11
            r7.R = r2
            androidx.media3.extractor.mkv.VarintReader r2 = r7.f13419e
            int r2 = r2.b()
            r7.S = r2
            r11 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7.N = r11
            r7.L = r10
            androidx.media3.common.util.ParsableByteArray r2 = r7.f13426l
            r2.U(r9)
        L_0x00ea:
            android.util.SparseArray<androidx.media3.extractor.mkv.MatroskaExtractor$Track> r2 = r7.f13420f
            int r11 = r7.R
            java.lang.Object r2 = r2.get(r11)
            r11 = r2
            androidx.media3.extractor.mkv.MatroskaExtractor$Track r11 = (androidx.media3.extractor.mkv.MatroskaExtractor.Track) r11
            if (r11 != 0) goto L_0x0101
            int r0 = r7.S
            int r0 = r1 - r0
            r8.o(r0)
            r7.L = r9
            return
        L_0x0101:
            r11.f()
            int r2 = r7.L
            if (r2 != r10) goto L_0x02a3
            r2 = 3
            r7.H(r8, r2)
            androidx.media3.common.util.ParsableByteArray r12 = r7.f13426l
            byte[] r12 = r12.e()
            byte r12 = r12[r5]
            r12 = r12 & 6
            int r12 = r12 >> r10
            r13 = 255(0xff, float:3.57E-43)
            if (r12 != 0) goto L_0x012f
            r7.P = r10
            int[] r4 = r7.Q
            int[] r4 = s(r4, r10)
            r7.Q = r4
            int r12 = r7.S
            int r1 = r1 - r12
            int r1 = r1 - r2
            r4[r9] = r1
        L_0x012b:
            r18 = r11
            goto L_0x0246
        L_0x012f:
            r14 = 4
            r7.H(r8, r14)
            androidx.media3.common.util.ParsableByteArray r15 = r7.f13426l
            byte[] r15 = r15.e()
            byte r15 = r15[r2]
            r15 = r15 & r13
            int r15 = r15 + r10
            r7.P = r15
            int[] r3 = r7.Q
            int[] r3 = s(r3, r15)
            r7.Q = r3
            if (r12 != r5) goto L_0x0154
            int r2 = r7.S
            int r1 = r1 - r2
            int r1 = r1 - r14
            int r2 = r7.P
            int r1 = r1 / r2
            java.util.Arrays.fill(r3, r9, r2, r1)
            goto L_0x012b
        L_0x0154:
            if (r12 != r10) goto L_0x018b
            r2 = 0
            r3 = 0
        L_0x0158:
            int r4 = r7.P
            int r12 = r4 + -1
            if (r2 >= r12) goto L_0x0180
            int[] r4 = r7.Q
            r4[r2] = r9
        L_0x0162:
            int r4 = r14 + 1
            r7.H(r8, r4)
            androidx.media3.common.util.ParsableByteArray r12 = r7.f13426l
            byte[] r12 = r12.e()
            byte r12 = r12[r14]
            r12 = r12 & r13
            int[] r14 = r7.Q
            r15 = r14[r2]
            int r15 = r15 + r12
            r14[r2] = r15
            if (r12 == r13) goto L_0x017e
            int r3 = r3 + r15
            int r2 = r2 + 1
            r14 = r4
            goto L_0x0158
        L_0x017e:
            r14 = r4
            goto L_0x0162
        L_0x0180:
            int[] r2 = r7.Q
            int r4 = r4 - r10
            int r12 = r7.S
            int r1 = r1 - r12
            int r1 = r1 - r14
            int r1 = r1 - r3
            r2[r4] = r1
            goto L_0x012b
        L_0x018b:
            if (r12 != r2) goto L_0x028d
            r2 = 0
            r3 = 0
        L_0x018f:
            int r12 = r7.P
            int r15 = r12 + -1
            if (r2 >= r15) goto L_0x0239
            int[] r12 = r7.Q
            r12[r2] = r9
            int r12 = r14 + 1
            r7.H(r8, r12)
            androidx.media3.common.util.ParsableByteArray r15 = r7.f13426l
            byte[] r15 = r15.e()
            byte r15 = r15[r14]
            if (r15 == 0) goto L_0x0232
            r15 = 0
        L_0x01a9:
            if (r15 >= r6) goto L_0x01ff
            int r16 = 7 - r15
            int r5 = r10 << r16
            androidx.media3.common.util.ParsableByteArray r9 = r7.f13426l
            byte[] r9 = r9.e()
            byte r9 = r9[r14]
            r9 = r9 & r5
            if (r9 == 0) goto L_0x01f5
            int r12 = r12 + r15
            r7.H(r8, r12)
            androidx.media3.common.util.ParsableByteArray r9 = r7.f13426l
            byte[] r9 = r9.e()
            int r17 = r14 + 1
            byte r9 = r9[r14]
            r9 = r9 & r13
            int r5 = ~r5
            r5 = r5 & r9
            r18 = r11
            long r10 = (long) r5
            r5 = r17
        L_0x01d0:
            if (r5 >= r12) goto L_0x01e5
            long r10 = r10 << r6
            androidx.media3.common.util.ParsableByteArray r14 = r7.f13426l
            byte[] r14 = r14.e()
            int r17 = r5 + 1
            byte r5 = r14[r5]
            r5 = r5 & r13
            long r13 = (long) r5
            long r10 = r10 | r13
            r5 = r17
            r13 = 255(0xff, float:3.57E-43)
            goto L_0x01d0
        L_0x01e5:
            if (r2 <= 0) goto L_0x01f3
            int r15 = r15 * 7
            int r15 = r15 + 6
            r13 = 1
            long r19 = r13 << r15
            long r19 = r19 - r13
            long r10 = r10 - r19
        L_0x01f3:
            r14 = r12
            goto L_0x0204
        L_0x01f5:
            r18 = r11
            int r15 = r15 + 1
            r5 = 2
            r9 = 0
            r10 = 1
            r13 = 255(0xff, float:3.57E-43)
            goto L_0x01a9
        L_0x01ff:
            r18 = r11
            r10 = 0
            goto L_0x01f3
        L_0x0204:
            r12 = -2147483648(0xffffffff80000000, double:NaN)
            int r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r5 < 0) goto L_0x022b
            r12 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r5 > 0) goto L_0x022b
            int r5 = (int) r10
            int[] r10 = r7.Q
            if (r2 != 0) goto L_0x0218
            goto L_0x021d
        L_0x0218:
            int r11 = r2 + -1
            r11 = r10[r11]
            int r5 = r5 + r11
        L_0x021d:
            r10[r2] = r5
            int r3 = r3 + r5
            int r2 = r2 + 1
            r11 = r18
            r5 = 2
            r9 = 0
            r10 = 1
            r13 = 255(0xff, float:3.57E-43)
            goto L_0x018f
        L_0x022b:
            java.lang.String r0 = "EBML lacing sample size out of range."
            androidx.media3.common.ParserException r0 = androidx.media3.common.ParserException.a(r0, r4)
            throw r0
        L_0x0232:
            java.lang.String r0 = "No valid varint length mask found"
            androidx.media3.common.ParserException r0 = androidx.media3.common.ParserException.a(r0, r4)
            throw r0
        L_0x0239:
            r18 = r11
            int[] r2 = r7.Q
            r4 = 1
            int r12 = r12 - r4
            int r4 = r7.S
            int r1 = r1 - r4
            int r1 = r1 - r14
            int r1 = r1 - r3
            r2[r12] = r1
        L_0x0246:
            androidx.media3.common.util.ParsableByteArray r1 = r7.f13426l
            byte[] r1 = r1.e()
            r2 = 0
            byte r1 = r1[r2]
            int r1 = r1 << r6
            androidx.media3.common.util.ParsableByteArray r2 = r7.f13426l
            byte[] r2 = r2.e()
            r3 = 1
            byte r2 = r2[r3]
            r3 = 255(0xff, float:3.57E-43)
            r2 = r2 & r3
            r1 = r1 | r2
            long r2 = r7.G
            long r4 = (long) r1
            long r4 = r7.J(r4)
            long r2 = r2 + r4
            r7.M = r2
            r10 = r18
            int r1 = r10.f13433d
            r2 = 2
            if (r1 == r2) goto L_0x0282
            r1 = 163(0xa3, float:2.28E-43)
            if (r0 != r1) goto L_0x0280
            androidx.media3.common.util.ParsableByteArray r1 = r7.f13426l
            byte[] r1 = r1.e()
            byte r1 = r1[r2]
            r3 = 128(0x80, float:1.794E-43)
            r1 = r1 & r3
            if (r1 != r3) goto L_0x0280
            goto L_0x0282
        L_0x0280:
            r1 = 0
            goto L_0x0283
        L_0x0282:
            r1 = 1
        L_0x0283:
            r7.T = r1
            r7.L = r2
            r1 = 0
            r7.O = r1
        L_0x028a:
            r1 = 163(0xa3, float:2.28E-43)
            goto L_0x02a5
        L_0x028d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unexpected lacing value: "
            r0.append(r1)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            androidx.media3.common.ParserException r0 = androidx.media3.common.ParserException.a(r0, r4)
            throw r0
        L_0x02a3:
            r10 = r11
            goto L_0x028a
        L_0x02a5:
            if (r0 != r1) goto L_0x02d6
        L_0x02a7:
            int r0 = r7.O
            int r1 = r7.P
            if (r0 >= r1) goto L_0x02d2
            int[] r1 = r7.Q
            r0 = r1[r0]
            r1 = 0
            int r5 = r7.N(r8, r10, r0, r1)
            long r0 = r7.M
            int r2 = r7.O
            int r3 = r10.f13434e
            int r2 = r2 * r3
            int r2 = r2 / 1000
            long r2 = (long) r2
            long r2 = r2 + r0
            int r4 = r7.T
            r6 = 0
            r0 = r21
            r1 = r10
            r0.q(r1, r2, r4, r5, r6)
            int r0 = r7.O
            r1 = 1
            int r0 = r0 + r1
            r7.O = r0
            goto L_0x02a7
        L_0x02d2:
            r0 = 0
            r7.L = r0
            goto L_0x02ed
        L_0x02d6:
            r1 = 1
        L_0x02d7:
            int r0 = r7.O
            int r2 = r7.P
            if (r0 >= r2) goto L_0x02ed
            int[] r2 = r7.Q
            r3 = r2[r0]
            int r3 = r7.N(r8, r10, r3, r1)
            r2[r0] = r3
            int r0 = r7.O
            int r0 = r0 + r1
            r7.O = r0
            goto L_0x02d7
        L_0x02ed:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mkv.MatroskaExtractor.o(int, int, androidx.media3.extractor.ExtractorInput):void");
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void r(int i4) throws ParserException {
        n();
        if (i4 != s1) {
            if (i4 == B1) {
                Track track = (Track) Assertions.k(this.z);
                String str = track.f13431b;
                if (str != null) {
                    if (B(str)) {
                        track.i(this.g0, track.f13432c);
                        this.f13420f.put(track.f13432c, track);
                    }
                    this.z = null;
                    return;
                }
                throw ParserException.a("CodecId is missing in TrackEntry element", (Throwable) null);
            } else if (i4 == j1) {
                int i5 = this.B;
                if (i5 != -1) {
                    long j4 = this.C;
                    if (j4 != -1) {
                        if (i5 == n2) {
                            this.E = j4;
                            return;
                        }
                        return;
                    }
                }
                throw ParserException.a("Mandatory element SeekID or SeekPosition not found", (Throwable) null);
            } else if (i4 == c2) {
                m(i4);
                Track track2 = this.z;
                if (!track2.f13437h) {
                    return;
                }
                if (track2.f13439j != null) {
                    track2.f13441l = new DrmInitData(new DrmInitData.SchemeData(C.h2, MimeTypes.f9233h, this.z.f13439j.f13136b));
                    return;
                }
                throw ParserException.a("Encrypted Track found but ContentEncKeyID was not found", (Throwable) null);
            } else if (i4 == b2) {
                m(i4);
                Track track3 = this.z;
                if (track3.f13437h && track3.f13438i != null) {
                    throw ParserException.a("Combining encryption and compression is not supported", (Throwable) null);
                }
            } else if (i4 == 357149030) {
                if (this.w == C.f9084b) {
                    this.w = 1000000;
                }
                long j5 = this.x;
                if (j5 != C.f9084b) {
                    this.y = J(j5);
                }
            } else if (i4 != A1) {
                if (i4 == n2) {
                    if (!this.A) {
                        this.g0.j(p(this.H, this.I));
                        this.A = true;
                    }
                    this.H = null;
                    this.I = null;
                }
            } else if (this.f13420f.size() != 0) {
                this.g0.o();
            } else {
                throw ParserException.a("No valid tracks were found", (Throwable) null);
            }
        } else if (this.L == 2) {
            Track track4 = this.f13420f.get(this.R);
            track4.f();
            if (this.W > 0 && D0.equals(track4.f13431b)) {
                this.s.V(java.nio.ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.W).array());
            }
            int i6 = 0;
            for (int i7 = 0; i7 < this.P; i7++) {
                i6 += this.Q[i7];
            }
            int i8 = 0;
            while (i8 < this.P) {
                long j6 = this.M + ((long) ((track4.f13434e * i8) / 1000));
                int i9 = this.T;
                if (i8 == 0 && !this.V) {
                    i9 |= 1;
                }
                int i10 = this.Q[i8];
                int i11 = i6 - i10;
                q(track4, j6, i9, i10, i11);
                i8++;
                i6 = i11;
            }
            this.L = 0;
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void u(int i4, double d4) throws ParserException {
        if (i4 == a2) {
            w(i4).R = (int) d4;
        } else if (i4 != o1) {
            switch (i4) {
                case I2 /*21969*/:
                    w(i4).E = (float) d4;
                    return;
                case J2 /*21970*/:
                    w(i4).F = (float) d4;
                    return;
                case K2 /*21971*/:
                    w(i4).G = (float) d4;
                    return;
                case L2 /*21972*/:
                    w(i4).H = (float) d4;
                    return;
                case M2 /*21973*/:
                    w(i4).I = (float) d4;
                    return;
                case N2 /*21974*/:
                    w(i4).J = (float) d4;
                    return;
                case O2 /*21975*/:
                    w(i4).K = (float) d4;
                    return;
                case P2 /*21976*/:
                    w(i4).L = (float) d4;
                    return;
                case Q2 /*21977*/:
                    w(i4).M = (float) d4;
                    return;
                case R2 /*21978*/:
                    w(i4).N = (float) d4;
                    return;
                default:
                    switch (i4) {
                        case w2 /*30323*/:
                            w(i4).t = (float) d4;
                            return;
                        case x2 /*30324*/:
                            w(i4).u = (float) d4;
                            return;
                        case y2 /*30325*/:
                            w(i4).v = (float) d4;
                            return;
                        default:
                            return;
                    }
            }
        } else {
            this.x = (long) d4;
        }
    }

    /* access modifiers changed from: protected */
    public Track w(int i4) throws ParserException {
        m(i4);
        return this.z;
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public int x(int i4) {
        switch (i4) {
            case D1 /*131*/:
            case 136:
            case u1 /*155*/:
            case Y1 /*159*/:
            case S1 /*176*/:
            case p2 /*179*/:
            case T1 /*186*/:
            case C1 /*215*/:
            case q1 /*231*/:
            case 238:
            case r2 /*241*/:
            case z1 /*251*/:
            case J1 /*16871*/:
            case g2 /*16980*/:
            case f1 /*17029*/:
            case d1 /*17143*/:
            case j2 /*18401*/:
            case m2 /*18408*/:
            case d2 /*20529*/:
            case e2 /*20530*/:
            case l1 /*21420*/:
            case z2 /*21432*/:
            case U1 /*21680*/:
            case W1 /*21682*/:
            case V1 /*21690*/:
            case F1 /*21930*/:
            case C2 /*21938*/:
            case B2 /*21945*/:
            case D2 /*21946*/:
            case E2 /*21947*/:
            case F2 /*21948*/:
            case G2 /*21949*/:
            case H1 /*21998*/:
            case O1 /*22186*/:
            case P1 /*22203*/:
            case Z1 /*25188*/:
            case Q1 /*30114*/:
            case u2 /*30321*/:
            case G1 /*2352003*/:
            case n1 /*2807729*/:
                return 2;
            case 134:
            case 17026:
            case L1 /*21358*/:
            case s2 /*2274716*/:
                return 3;
            case s1 /*160*/:
            case w1 /*166*/:
            case B1 /*174*/:
            case q2 /*183*/:
            case o2 /*187*/:
            case 224:
            case X1 /*225*/:
            case I1 /*16868*/:
            case l2 /*18407*/:
            case j1 /*19899*/:
            case f2 /*20532*/:
            case i2 /*20533*/:
            case A2 /*21936*/:
            case H2 /*21968*/:
            case c2 /*25152*/:
            case b2 /*28032*/:
            case v1 /*30113*/:
            case t2 /*30320*/:
            case i1 /*290298740*/:
            case 357149030:
            case A1 /*374648427*/:
            case g1 /*408125543*/:
            case c1 /*440786851*/:
            case n2 /*475249515*/:
            case p1 /*524531317*/:
                return 1;
            case t1 /*161*/:
            case r1 /*163*/:
            case y1 /*165*/:
            case K1 /*16877*/:
            case h2 /*16981*/:
            case k2 /*18402*/:
            case k1 /*21419*/:
            case N1 /*25506*/:
            case v2 /*30322*/:
                return 4;
            case a2 /*181*/:
            case o1 /*17545*/:
            case I2 /*21969*/:
            case J2 /*21970*/:
            case K2 /*21971*/:
            case L2 /*21972*/:
            case M2 /*21973*/:
            case N2 /*21974*/:
            case O2 /*21975*/:
            case P2 /*21976*/:
            case Q2 /*21977*/:
            case R2 /*21978*/:
            case w2 /*30323*/:
            case x2 /*30324*/:
            case y2 /*30325*/:
                return 5;
            default:
                return 0;
        }
    }

    /* access modifiers changed from: protected */
    public void y(Track track, ExtractorInput extractorInput, int i4) throws IOException {
        if (track.f13436g == 1685485123 || track.f13436g == 1685480259) {
            byte[] bArr = new byte[i4];
            track.O = bArr;
            extractorInput.readFully(bArr, 0, i4);
            return;
        }
        extractorInput.o(i4);
    }

    /* access modifiers changed from: protected */
    public void z(Track track, int i4, ExtractorInput extractorInput, int i5) throws IOException {
        if (i4 != 4 || !s0.equals(track.f13431b)) {
            extractorInput.o(i5);
            return;
        }
        this.s.U(i5);
        extractorInput.readFully(this.s.e(), 0, i5);
    }

    @Deprecated
    public MatroskaExtractor(int i4) {
        this(new DefaultEbmlReader(), i4 | 2, SubtitleParser.Factory.f13783a);
    }

    MatroskaExtractor(EbmlReader ebmlReader, int i4, SubtitleParser.Factory factory) {
        this.v = -1;
        this.w = C.f9084b;
        this.x = C.f9084b;
        this.y = C.f9084b;
        this.E = -1;
        this.F = -1;
        this.G = C.f9084b;
        this.f13418d = ebmlReader;
        ebmlReader.a(new InnerEbmlProcessor());
        this.f13423i = factory;
        boolean z3 = false;
        this.f13421g = (i4 & 1) == 0;
        this.f13422h = (i4 & 2) == 0 ? true : z3;
        this.f13419e = new VarintReader();
        this.f13420f = new SparseArray<>();
        this.f13426l = new ParsableByteArray(4);
        this.f13427m = new ParsableByteArray(java.nio.ByteBuffer.allocate(4).putInt(-1).array());
        this.f13428n = new ParsableByteArray(4);
        this.f13424j = new ParsableByteArray(NalUnitUtil.f9675j);
        this.f13425k = new ParsableByteArray(4);
        this.o = new ParsableByteArray();
        this.p = new ParsableByteArray();
        this.q = new ParsableByteArray(8);
        this.r = new ParsableByteArray();
        this.s = new ParsableByteArray();
        this.Q = new int[1];
    }

    public MatroskaExtractor(SubtitleParser.Factory factory) {
        this(new DefaultEbmlReader(), 0, factory);
    }

    public MatroskaExtractor(SubtitleParser.Factory factory, int i4) {
        this(new DefaultEbmlReader(), i4, factory);
    }
}
