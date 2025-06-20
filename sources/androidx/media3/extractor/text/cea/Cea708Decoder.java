package androidx.media3.extractor.text.cea;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleDecoderException;
import androidx.media3.extractor.text.SubtitleInputBuffer;
import androidx.media3.extractor.text.SubtitleOutputBuffer;
import com.google.common.primitives.SignedBytes;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.text.Typography;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import okio.Utf8;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public final class Cea708Decoder extends CeaDecoder {
    private static final int A = 159;
    private static final int A0 = 49;
    private static final int B = 255;
    private static final int B0 = 50;
    private static final int C = 31;
    private static final int C0 = 51;
    private static final int D = 127;
    private static final int D0 = 52;
    private static final int E = 159;
    private static final int E0 = 53;
    private static final int F = 255;
    private static final int F0 = 57;
    private static final int G = 0;
    private static final int G0 = 58;
    private static final int H = 3;
    private static final int H0 = 60;
    private static final int I = 8;
    private static final int I0 = 61;
    private static final int J = 12;
    private static final int J0 = 63;
    private static final int K = 13;
    private static final int K0 = 118;
    private static final int L = 14;
    private static final int L0 = 119;
    private static final int M = 16;
    private static final int M0 = 120;
    private static final int N = 17;
    private static final int N0 = 121;
    private static final int O = 23;
    private static final int O0 = 122;
    private static final int P = 24;
    private static final int P0 = 123;
    private static final int Q = 31;
    private static final int Q0 = 124;
    private static final int R = 128;
    private static final int R0 = 125;
    private static final int S = 129;
    private static final int S0 = 126;
    private static final int T = 130;
    private static final int T0 = 127;
    private static final int U = 131;
    private static final int V = 132;
    private static final int W = 133;
    private static final int X = 134;
    private static final int Y = 135;
    private static final int Z = 136;
    private static final int a0 = 137;
    private static final int b0 = 138;
    private static final int c0 = 139;
    private static final int d0 = 140;
    private static final int e0 = 141;
    private static final int f0 = 142;
    private static final int g0 = 143;
    private static final int h0 = 144;
    private static final int i0 = 145;
    private static final int j0 = 146;
    private static final int k0 = 151;
    private static final int l0 = 152;
    private static final int m0 = 153;
    private static final int n0 = 154;
    private static final int o0 = 155;
    private static final int p0 = 156;
    private static final int q0 = 157;
    private static final int r0 = 158;
    private static final int s0 = 159;
    private static final String t = "Cea708Decoder";
    private static final int t0 = 127;
    private static final int u = 8;
    private static final int u0 = 32;
    private static final int v = 2;
    private static final int v0 = 33;
    private static final int w = 3;
    private static final int w0 = 37;
    private static final int x = 4;
    private static final int x0 = 42;
    private static final int y = 31;
    private static final int y0 = 44;
    private static final int z = 127;
    private static final int z0 = 48;

    /* renamed from: i  reason: collision with root package name */
    private final ParsableByteArray f13819i = new ParsableByteArray();

    /* renamed from: j  reason: collision with root package name */
    private final ParsableBitArray f13820j = new ParsableBitArray();

    /* renamed from: k  reason: collision with root package name */
    private int f13821k = -1;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f13822l;

    /* renamed from: m  reason: collision with root package name */
    private final int f13823m;

    /* renamed from: n  reason: collision with root package name */
    private final CueInfoBuilder[] f13824n;
    private CueInfoBuilder o;
    @Nullable
    private List<Cue> p;
    @Nullable
    private List<Cue> q;
    @Nullable
    private DtvCcPacket r;
    private int s;

    private static final class Cea708CueInfo {
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public static final Comparator<Cea708CueInfo> f13825c = new a();

        /* renamed from: a  reason: collision with root package name */
        public final Cue f13826a;

        /* renamed from: b  reason: collision with root package name */
        public final int f13827b;

        public Cea708CueInfo(CharSequence charSequence, Layout.Alignment alignment, float f2, int i2, int i3, float f3, int i4, float f4, boolean z, int i5, int i6) {
            Cue.Builder z2 = new Cue.Builder().A(charSequence).B(alignment).t(f2, i2).u(i3).w(f3).x(i4).z(f4);
            if (z) {
                z2.E(i5);
            }
            this.f13826a = z2.a();
            this.f13827b = i6;
        }
    }

    private static final class CueInfoBuilder {
        private static final int A = 15;
        private static final int B = 0;
        private static final int C = 1;
        private static final int D = 2;
        private static final int E = 3;
        private static final int F = 0;
        private static final int G = 1;
        private static final int H = 2;
        private static final int I = 3;
        private static final int J = 0;
        private static final int K = 3;
        public static final int L = h(2, 2, 2, 0);
        public static final int M;
        public static final int N;
        private static final int O = 1;
        private static final int P = 0;
        private static final int Q = 1;
        private static final int R = 2;
        private static final int S = 3;
        private static final int T = 4;
        private static final int U = 1;
        private static final int[] V = {0, 0, 0, 0, 0, 2, 0};
        private static final int[] W = {0, 0, 0, 0, 0, 0, 2};
        private static final int[] X = {3, 3, 3, 3, 3, 3, 1};
        private static final boolean[] Y = {false, false, false, true, true, true, false};
        private static final int[] Z;
        private static final int[] a0 = {0, 1, 2, 3, 4, 3, 4};
        private static final int[] b0 = {0, 0, 0, 0, 0, 3, 3};
        private static final int[] c0;
        private static final int w = 99;
        private static final int x = 74;
        private static final int y = 209;
        private static final int z = 4;

        /* renamed from: a  reason: collision with root package name */
        private final List<SpannableString> f13828a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final SpannableStringBuilder f13829b = new SpannableStringBuilder();

        /* renamed from: c  reason: collision with root package name */
        private boolean f13830c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f13831d;

        /* renamed from: e  reason: collision with root package name */
        private int f13832e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f13833f;

        /* renamed from: g  reason: collision with root package name */
        private int f13834g;

        /* renamed from: h  reason: collision with root package name */
        private int f13835h;

        /* renamed from: i  reason: collision with root package name */
        private int f13836i;

        /* renamed from: j  reason: collision with root package name */
        private int f13837j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f13838k;

        /* renamed from: l  reason: collision with root package name */
        private int f13839l;

        /* renamed from: m  reason: collision with root package name */
        private int f13840m;

        /* renamed from: n  reason: collision with root package name */
        private int f13841n;
        private int o;
        private int p;
        private int q;
        private int r;
        private int s;
        private int t;
        private int u;
        private int v;

        static {
            int h2 = h(0, 0, 0, 0);
            M = h2;
            int h3 = h(0, 0, 0, 3);
            N = h3;
            int i2 = h2;
            int i3 = h2;
            Z = new int[]{h2, h3, i2, i3, h3, h2, h2};
            c0 = new int[]{h2, h2, i2, i3, h2, h3, h3};
        }

        public CueInfoBuilder() {
            l();
        }

        public static int g(int i2, int i3, int i4) {
            return h(i2, i3, i4, 0);
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0024  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x002a  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x002d  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0030  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int h(int r4, int r5, int r6, int r7) {
            /*
                r0 = 0
                r1 = 4
                androidx.media3.common.util.Assertions.c(r4, r0, r1)
                androidx.media3.common.util.Assertions.c(r5, r0, r1)
                androidx.media3.common.util.Assertions.c(r6, r0, r1)
                androidx.media3.common.util.Assertions.c(r7, r0, r1)
                r1 = 1
                r2 = 255(0xff, float:3.57E-43)
                if (r7 == 0) goto L_0x001b
                if (r7 == r1) goto L_0x001b
                r3 = 2
                if (r7 == r3) goto L_0x0020
                r3 = 3
                if (r7 == r3) goto L_0x001e
            L_0x001b:
                r7 = 255(0xff, float:3.57E-43)
                goto L_0x0022
            L_0x001e:
                r7 = 0
                goto L_0x0022
            L_0x0020:
                r7 = 127(0x7f, float:1.78E-43)
            L_0x0022:
                if (r4 <= r1) goto L_0x0027
                r4 = 255(0xff, float:3.57E-43)
                goto L_0x0028
            L_0x0027:
                r4 = 0
            L_0x0028:
                if (r5 <= r1) goto L_0x002d
                r5 = 255(0xff, float:3.57E-43)
                goto L_0x002e
            L_0x002d:
                r5 = 0
            L_0x002e:
                if (r6 <= r1) goto L_0x0032
                r0 = 255(0xff, float:3.57E-43)
            L_0x0032:
                int r4 = android.graphics.Color.argb(r7, r4, r5, r0)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.cea.Cea708Decoder.CueInfoBuilder.h(int, int, int, int):int");
        }

        public void a(char c2) {
            if (c2 == 10) {
                this.f13828a.add(d());
                this.f13829b.clear();
                if (this.p != -1) {
                    this.p = 0;
                }
                if (this.q != -1) {
                    this.q = 0;
                }
                if (this.r != -1) {
                    this.r = 0;
                }
                if (this.t != -1) {
                    this.t = 0;
                }
                while (true) {
                    if ((this.f13838k && this.f13828a.size() >= this.f13837j) || this.f13828a.size() >= 15) {
                        this.f13828a.remove(0);
                    } else {
                        return;
                    }
                }
            } else {
                this.f13829b.append(c2);
            }
        }

        public void b() {
            int length = this.f13829b.length();
            if (length > 0) {
                this.f13829b.delete(length - 1, length);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0071  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0092  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0094  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x009f  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00a1  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00ad  */
        @androidx.annotation.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.media3.extractor.text.cea.Cea708Decoder.Cea708CueInfo c() {
            /*
                r15 = this;
                boolean r0 = r15.j()
                if (r0 == 0) goto L_0x0008
                r0 = 0
                return r0
            L_0x0008:
                android.text.SpannableStringBuilder r2 = new android.text.SpannableStringBuilder
                r2.<init>()
                r0 = 0
                r1 = 0
            L_0x000f:
                java.util.List<android.text.SpannableString> r3 = r15.f13828a
                int r3 = r3.size()
                if (r1 >= r3) goto L_0x002a
                java.util.List<android.text.SpannableString> r3 = r15.f13828a
                java.lang.Object r3 = r3.get(r1)
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                r2.append(r3)
                r3 = 10
                r2.append(r3)
                int r1 = r1 + 1
                goto L_0x000f
            L_0x002a:
                android.text.SpannableString r1 = r15.d()
                r2.append(r1)
                int r1 = r15.f13839l
                r3 = 2
                r4 = 3
                r5 = 1
                if (r1 == 0) goto L_0x005f
                if (r1 == r5) goto L_0x005c
                if (r1 == r3) goto L_0x0058
                if (r1 != r4) goto L_0x003f
                goto L_0x005f
            L_0x003f:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Unexpected justification value: "
                r1.append(r2)
                int r2 = r15.f13839l
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0058:
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_CENTER
            L_0x005a:
                r6 = r1
                goto L_0x0062
            L_0x005c:
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_OPPOSITE
                goto L_0x005a
            L_0x005f:
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_NORMAL
                goto L_0x005a
            L_0x0062:
                boolean r1 = r15.f13833f
                if (r1 == 0) goto L_0x0071
                int r1 = r15.f13835h
                float r1 = (float) r1
                r7 = 1120272384(0x42c60000, float:99.0)
                float r1 = r1 / r7
                int r8 = r15.f13834g
                float r8 = (float) r8
                float r8 = r8 / r7
                goto L_0x007e
            L_0x0071:
                int r1 = r15.f13835h
                float r1 = (float) r1
                r7 = 1129381888(0x43510000, float:209.0)
                float r1 = r1 / r7
                int r7 = r15.f13834g
                float r7 = (float) r7
                r8 = 1116995584(0x42940000, float:74.0)
                float r8 = r7 / r8
            L_0x007e:
                r7 = 1063675494(0x3f666666, float:0.9)
                float r1 = r1 * r7
                r9 = 1028443341(0x3d4ccccd, float:0.05)
                float r10 = r1 + r9
                float r8 = r8 * r7
                float r7 = r8 + r9
                int r1 = r15.f13836i
                int r8 = r1 / 3
                if (r8 != 0) goto L_0x0094
                r8 = 0
                goto L_0x009b
            L_0x0094:
                int r8 = r1 / 3
                if (r8 != r5) goto L_0x009a
                r8 = 1
                goto L_0x009b
            L_0x009a:
                r8 = 2
            L_0x009b:
                int r9 = r1 % 3
                if (r9 != 0) goto L_0x00a1
                r9 = 0
                goto L_0x00a7
            L_0x00a1:
                int r1 = r1 % r4
                if (r1 != r5) goto L_0x00a6
                r9 = 1
                goto L_0x00a7
            L_0x00a6:
                r9 = 2
            L_0x00a7:
                int r1 = r15.o
                int r3 = M
                if (r1 == r3) goto L_0x00ae
                r0 = 1
            L_0x00ae:
                androidx.media3.extractor.text.cea.Cea708Decoder$Cea708CueInfo r13 = new androidx.media3.extractor.text.cea.Cea708Decoder$Cea708CueInfo
                int r11 = r15.o
                int r12 = r15.f13832e
                r5 = 0
                r14 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
                r1 = r13
                r3 = r6
                r4 = r7
                r6 = r8
                r7 = r10
                r8 = r9
                r9 = r14
                r10 = r0
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.cea.Cea708Decoder.CueInfoBuilder.c():androidx.media3.extractor.text.cea.Cea708Decoder$Cea708CueInfo");
        }

        public SpannableString d() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f13829b);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.p != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.p, length, 33);
                }
                if (this.q != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.q, length, 33);
                }
                if (this.r != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.s), this.r, length, 33);
                }
                if (this.t != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.u), this.t, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void e() {
            this.f13828a.clear();
            this.f13829b.clear();
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.t = -1;
            this.v = 0;
        }

        public void f(boolean z2, boolean z3, boolean z4, int i2, boolean z5, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            boolean z6 = z3;
            int i10 = i8;
            int i11 = i9;
            this.f13830c = true;
            this.f13831d = z2;
            this.f13838k = z6;
            this.f13832e = i2;
            this.f13833f = z5;
            this.f13834g = i3;
            this.f13835h = i4;
            this.f13836i = i7;
            int i12 = i5 + 1;
            if (this.f13837j != i12) {
                this.f13837j = i12;
                while (true) {
                    if ((!z6 || this.f13828a.size() < this.f13837j) && this.f13828a.size() < 15) {
                        break;
                    }
                    this.f13828a.remove(0);
                }
            }
            if (!(i10 == 0 || this.f13840m == i10)) {
                this.f13840m = i10;
                int i13 = i10 - 1;
                q(Z[i13], N, Y[i13], 0, W[i13], X[i13], V[i13]);
            }
            if (i11 != 0 && this.f13841n != i11) {
                this.f13841n = i11;
                int i14 = i11 - 1;
                m(0, 1, 1, false, false, b0[i14], a0[i14]);
                n(L, c0[i14], M);
            }
        }

        public boolean i() {
            return this.f13830c;
        }

        public boolean j() {
            return !i() || (this.f13828a.isEmpty() && this.f13829b.length() == 0);
        }

        public boolean k() {
            return this.f13831d;
        }

        public void l() {
            e();
            this.f13830c = false;
            this.f13831d = false;
            this.f13832e = 4;
            this.f13833f = false;
            this.f13834g = 0;
            this.f13835h = 0;
            this.f13836i = 0;
            this.f13837j = 15;
            this.f13838k = true;
            this.f13839l = 0;
            this.f13840m = 0;
            this.f13841n = 0;
            int i2 = M;
            this.o = i2;
            this.s = L;
            this.u = i2;
        }

        public void m(int i2, int i3, int i4, boolean z2, boolean z3, int i5, int i6) {
            if (this.p != -1) {
                if (!z2) {
                    this.f13829b.setSpan(new StyleSpan(2), this.p, this.f13829b.length(), 33);
                    this.p = -1;
                }
            } else if (z2) {
                this.p = this.f13829b.length();
            }
            if (this.q != -1) {
                if (!z3) {
                    this.f13829b.setSpan(new UnderlineSpan(), this.q, this.f13829b.length(), 33);
                    this.q = -1;
                }
            } else if (z3) {
                this.q = this.f13829b.length();
            }
        }

        public void n(int i2, int i3, int i4) {
            if (!(this.r == -1 || this.s == i2)) {
                this.f13829b.setSpan(new ForegroundColorSpan(this.s), this.r, this.f13829b.length(), 33);
            }
            if (i2 != L) {
                this.r = this.f13829b.length();
                this.s = i2;
            }
            if (!(this.t == -1 || this.u == i3)) {
                this.f13829b.setSpan(new BackgroundColorSpan(this.u), this.t, this.f13829b.length(), 33);
            }
            if (i3 != M) {
                this.t = this.f13829b.length();
                this.u = i3;
            }
        }

        public void o(int i2, int i3) {
            if (this.v != i2) {
                a(10);
            }
            this.v = i2;
        }

        public void p(boolean z2) {
            this.f13831d = z2;
        }

        public void q(int i2, int i3, boolean z2, int i4, int i5, int i6, int i7) {
            this.o = i2;
            this.f13839l = i7;
        }
    }

    private static final class DtvCcPacket {

        /* renamed from: a  reason: collision with root package name */
        public final int f13842a;

        /* renamed from: b  reason: collision with root package name */
        public final int f13843b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f13844c;

        /* renamed from: d  reason: collision with root package name */
        int f13845d = 0;

        public DtvCcPacket(int i2, int i3) {
            this.f13842a = i2;
            this.f13843b = i3;
            this.f13844c = new byte[((i3 * 2) - 1)];
        }
    }

    public Cea708Decoder(int i2, @Nullable List<byte[]> list) {
        boolean z2 = true;
        this.f13823m = i2 == -1 ? 1 : i2;
        this.f13822l = (list == null || !CodecSpecificDataUtil.i(list)) ? false : z2;
        this.f13824n = new CueInfoBuilder[8];
        for (int i3 = 0; i3 < 8; i3++) {
            this.f13824n[i3] = new CueInfoBuilder();
        }
        this.o = this.f13824n[0];
    }

    private void A(int i2) {
        CueInfoBuilder cueInfoBuilder;
        char c2 = ' ';
        if (i2 == 32) {
            cueInfoBuilder = this.o;
        } else if (i2 == 33) {
            cueInfoBuilder = this.o;
            c2 = Typography.f29120g;
        } else if (i2 == 37) {
            cueInfoBuilder = this.o;
            c2 = Typography.F;
        } else if (i2 == 42) {
            cueInfoBuilder = this.o;
            c2 = 352;
        } else if (i2 == 44) {
            cueInfoBuilder = this.o;
            c2 = 338;
        } else if (i2 == 63) {
            cueInfoBuilder = this.o;
            c2 = 376;
        } else if (i2 == 57) {
            cueInfoBuilder = this.o;
            c2 = Typography.J;
        } else if (i2 == 58) {
            cueInfoBuilder = this.o;
            c2 = 353;
        } else if (i2 == 60) {
            cueInfoBuilder = this.o;
            c2 = 339;
        } else if (i2 != 61) {
            switch (i2) {
                case 48:
                    cueInfoBuilder = this.o;
                    c2 = 9608;
                    break;
                case 49:
                    cueInfoBuilder = this.o;
                    c2 = Typography.w;
                    break;
                case 50:
                    cueInfoBuilder = this.o;
                    c2 = Typography.x;
                    break;
                case 51:
                    cueInfoBuilder = this.o;
                    c2 = Typography.z;
                    break;
                case 52:
                    cueInfoBuilder = this.o;
                    c2 = Typography.A;
                    break;
                case 53:
                    cueInfoBuilder = this.o;
                    c2 = Typography.E;
                    break;
                default:
                    switch (i2) {
                        case 118:
                            cueInfoBuilder = this.o;
                            c2 = 8539;
                            break;
                        case 119:
                            cueInfoBuilder = this.o;
                            c2 = 8540;
                            break;
                        case 120:
                            cueInfoBuilder = this.o;
                            c2 = 8541;
                            break;
                        case 121:
                            cueInfoBuilder = this.o;
                            c2 = 8542;
                            break;
                        case 122:
                            cueInfoBuilder = this.o;
                            c2 = 9474;
                            break;
                        case 123:
                            cueInfoBuilder = this.o;
                            c2 = 9488;
                            break;
                        case 124:
                            cueInfoBuilder = this.o;
                            c2 = 9492;
                            break;
                        case 125:
                            cueInfoBuilder = this.o;
                            c2 = 9472;
                            break;
                        case 126:
                            cueInfoBuilder = this.o;
                            c2 = 9496;
                            break;
                        case WorkQueueKt.f29430c /*127*/:
                            cueInfoBuilder = this.o;
                            c2 = 9484;
                            break;
                        default:
                            Log.n(t, "Invalid G2 character: " + i2);
                            return;
                    }
            }
        } else {
            cueInfoBuilder = this.o;
            c2 = 8480;
        }
        cueInfoBuilder.a(c2);
    }

    private void B(int i2) {
        CueInfoBuilder cueInfoBuilder;
        char c2;
        if (i2 == 160) {
            cueInfoBuilder = this.o;
            c2 = 13252;
        } else {
            Log.n(t, "Invalid G3 character: " + i2);
            cueInfoBuilder = this.o;
            c2 = '_';
        }
        cueInfoBuilder.a(c2);
    }

    private void C() {
        this.o.m(this.f13820j.h(4), this.f13820j.h(2), this.f13820j.h(2), this.f13820j.g(), this.f13820j.g(), this.f13820j.h(3), this.f13820j.h(3));
    }

    private void D() {
        int h2 = CueInfoBuilder.h(this.f13820j.h(2), this.f13820j.h(2), this.f13820j.h(2), this.f13820j.h(2));
        int h3 = CueInfoBuilder.h(this.f13820j.h(2), this.f13820j.h(2), this.f13820j.h(2), this.f13820j.h(2));
        this.f13820j.s(2);
        this.o.n(h2, h3, CueInfoBuilder.g(this.f13820j.h(2), this.f13820j.h(2), this.f13820j.h(2)));
    }

    private void E() {
        this.f13820j.s(4);
        int h2 = this.f13820j.h(4);
        this.f13820j.s(2);
        this.o.o(h2, this.f13820j.h(6));
    }

    private void F() {
        int h2 = CueInfoBuilder.h(this.f13820j.h(2), this.f13820j.h(2), this.f13820j.h(2), this.f13820j.h(2));
        int h3 = this.f13820j.h(2);
        int g2 = CueInfoBuilder.g(this.f13820j.h(2), this.f13820j.h(2), this.f13820j.h(2));
        if (this.f13820j.g()) {
            h3 |= 4;
        }
        boolean g3 = this.f13820j.g();
        int h4 = this.f13820j.h(2);
        int h5 = this.f13820j.h(2);
        int h6 = this.f13820j.h(2);
        this.f13820j.s(8);
        this.o.q(h2, g2, g3, h3, h4, h5, h6);
    }

    @RequiresNonNull({"currentDtvCcPacket"})
    private void G() {
        StringBuilder sb;
        String str;
        DtvCcPacket dtvCcPacket = this.r;
        if (dtvCcPacket.f13845d != (dtvCcPacket.f13843b * 2) - 1) {
            Log.b(t, "DtvCcPacket ended prematurely; size is " + ((this.r.f13843b * 2) - 1) + ", but current index is " + this.r.f13845d + " (sequence number " + this.r.f13842a + ");");
        }
        ParsableBitArray parsableBitArray = this.f13820j;
        DtvCcPacket dtvCcPacket2 = this.r;
        parsableBitArray.p(dtvCcPacket2.f13844c, dtvCcPacket2.f13845d);
        boolean z2 = false;
        while (true) {
            if (this.f13820j.b() <= 0) {
                break;
            }
            int h2 = this.f13820j.h(3);
            int h3 = this.f13820j.h(5);
            if (h2 == 7) {
                this.f13820j.s(2);
                h2 = this.f13820j.h(6);
                if (h2 < 7) {
                    Log.n(t, "Invalid extended service number: " + h2);
                }
            }
            if (h3 == 0) {
                if (h2 != 0) {
                    Log.n(t, "serviceNumber is non-zero (" + h2 + ") when blockSize is 0");
                }
            } else if (h2 != this.f13823m) {
                this.f13820j.t(h3);
            } else {
                int e2 = this.f13820j.e() + (h3 * 8);
                while (this.f13820j.e() < e2) {
                    int h4 = this.f13820j.h(8);
                    if (h4 == 16) {
                        h4 = this.f13820j.h(8);
                        if (h4 <= 31) {
                            v(h4);
                        } else if (h4 <= 127) {
                            A(h4);
                        } else if (h4 <= 159) {
                            w(h4);
                        } else if (h4 <= 255) {
                            B(h4);
                        } else {
                            sb = new StringBuilder();
                            str = "Invalid extended command: ";
                            sb.append(str);
                            sb.append(h4);
                            Log.n(t, sb.toString());
                        }
                    } else if (h4 <= 31) {
                        t(h4);
                    } else if (h4 <= 127) {
                        y(h4);
                    } else if (h4 <= 159) {
                        u(h4);
                    } else if (h4 <= 255) {
                        z(h4);
                    } else {
                        sb = new StringBuilder();
                        str = "Invalid base command: ";
                        sb.append(str);
                        sb.append(h4);
                        Log.n(t, sb.toString());
                    }
                    z2 = true;
                }
            }
        }
        if (z2) {
            this.p = s();
        }
    }

    private void H() {
        for (int i2 = 0; i2 < 8; i2++) {
            this.f13824n[i2].l();
        }
    }

    private void r() {
        if (this.r != null) {
            G();
            this.r = null;
        }
    }

    private List<Cue> s() {
        Cea708CueInfo c2;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 8; i2++) {
            if (!this.f13824n[i2].j() && this.f13824n[i2].k() && (c2 = this.f13824n[i2].c()) != null) {
                arrayList.add(c2);
            }
        }
        Collections.sort(arrayList, Cea708CueInfo.f13825c);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            arrayList2.add(((Cea708CueInfo) arrayList.get(i3)).f13826a);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    private void t(int i2) {
        ParsableBitArray parsableBitArray;
        if (i2 == 0) {
            return;
        }
        if (i2 != 3) {
            int i3 = 8;
            if (i2 != 8) {
                switch (i2) {
                    case 12:
                        H();
                        return;
                    case 13:
                        this.o.a(10);
                        return;
                    case 14:
                        return;
                    default:
                        if (i2 >= 17 && i2 <= 23) {
                            Log.n(t, "Currently unsupported COMMAND_EXT1 Command: " + i2);
                            parsableBitArray = this.f13820j;
                        } else if (i2 < 24 || i2 > 31) {
                            Log.n(t, "Invalid C0 command: " + i2);
                            return;
                        } else {
                            Log.n(t, "Currently unsupported COMMAND_P16 Command: " + i2);
                            parsableBitArray = this.f13820j;
                            i3 = 16;
                        }
                        parsableBitArray.s(i3);
                        return;
                }
            } else {
                this.o.b();
            }
        } else {
            this.p = s();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003f, code lost:
        r5.s(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0051, code lost:
        r5 = r4.f13820j;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0085, code lost:
        if (r2 > 8) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008d, code lost:
        if (r4.f13820j.g() == false) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008f, code lost:
        r4.f13824n[8 - r2].l();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0098, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b7, code lost:
        if (r2 > 8) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00bf, code lost:
        if (r4.f13820j.g() == false) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c1, code lost:
        r4.f13824n[8 - r2].p(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00cb, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e5, code lost:
        if (r2 > 8) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ed, code lost:
        if (r4.f13820j.g() == false) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ef, code lost:
        r4.f13824n[8 - r2].e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00f8, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002f, code lost:
        r4.o = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void u(int r5) {
        /*
            r4 = this;
            r0 = 16
            r1 = 8
            r2 = 1
            switch(r5) {
                case 128: goto L_0x00fb;
                case 129: goto L_0x00fb;
                case 130: goto L_0x00fb;
                case 131: goto L_0x00fb;
                case 132: goto L_0x00fb;
                case 133: goto L_0x00fb;
                case 134: goto L_0x00fb;
                case 135: goto L_0x00fb;
                case 136: goto L_0x00e5;
                case 137: goto L_0x00ce;
                case 138: goto L_0x00b7;
                case 139: goto L_0x009b;
                case 140: goto L_0x0085;
                case 141: goto L_0x007e;
                case 142: goto L_0x0109;
                case 143: goto L_0x0079;
                case 144: goto L_0x006b;
                case 145: goto L_0x0059;
                case 146: goto L_0x0049;
                case 147: goto L_0x0008;
                case 148: goto L_0x0008;
                case 149: goto L_0x0008;
                case 150: goto L_0x0008;
                case 151: goto L_0x0033;
                case 152: goto L_0x0020;
                case 153: goto L_0x0020;
                case 154: goto L_0x0020;
                case 155: goto L_0x0020;
                case 156: goto L_0x0020;
                case 157: goto L_0x0020;
                case 158: goto L_0x0020;
                case 159: goto L_0x0020;
                default: goto L_0x0008;
            }
        L_0x0008:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid C1 command: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            java.lang.String r0 = "Cea708Decoder"
            androidx.media3.common.util.Log.n(r0, r5)
            goto L_0x0109
        L_0x0020:
            int r5 = r5 + -152
            r4.x(r5)
            int r0 = r4.s
            if (r0 == r5) goto L_0x0109
            r4.s = r5
            androidx.media3.extractor.text.cea.Cea708Decoder$CueInfoBuilder[] r0 = r4.f13824n
            r5 = r0[r5]
        L_0x002f:
            r4.o = r5
            goto L_0x0109
        L_0x0033:
            androidx.media3.extractor.text.cea.Cea708Decoder$CueInfoBuilder r5 = r4.o
            boolean r5 = r5.i()
            if (r5 != 0) goto L_0x0044
            androidx.media3.common.util.ParsableBitArray r5 = r4.f13820j
            r0 = 32
        L_0x003f:
            r5.s(r0)
            goto L_0x0109
        L_0x0044:
            r4.F()
            goto L_0x0109
        L_0x0049:
            androidx.media3.extractor.text.cea.Cea708Decoder$CueInfoBuilder r5 = r4.o
            boolean r5 = r5.i()
            if (r5 != 0) goto L_0x0054
        L_0x0051:
            androidx.media3.common.util.ParsableBitArray r5 = r4.f13820j
            goto L_0x003f
        L_0x0054:
            r4.E()
            goto L_0x0109
        L_0x0059:
            androidx.media3.extractor.text.cea.Cea708Decoder$CueInfoBuilder r5 = r4.o
            boolean r5 = r5.i()
            if (r5 != 0) goto L_0x0066
            androidx.media3.common.util.ParsableBitArray r5 = r4.f13820j
            r0 = 24
            goto L_0x003f
        L_0x0066:
            r4.D()
            goto L_0x0109
        L_0x006b:
            androidx.media3.extractor.text.cea.Cea708Decoder$CueInfoBuilder r5 = r4.o
            boolean r5 = r5.i()
            if (r5 != 0) goto L_0x0074
            goto L_0x0051
        L_0x0074:
            r4.C()
            goto L_0x0109
        L_0x0079:
            r4.H()
            goto L_0x0109
        L_0x007e:
            androidx.media3.common.util.ParsableBitArray r5 = r4.f13820j
            r5.s(r1)
            goto L_0x0109
        L_0x0085:
            if (r2 > r1) goto L_0x0109
            androidx.media3.common.util.ParsableBitArray r5 = r4.f13820j
            boolean r5 = r5.g()
            if (r5 == 0) goto L_0x0098
            androidx.media3.extractor.text.cea.Cea708Decoder$CueInfoBuilder[] r5 = r4.f13824n
            int r0 = 8 - r2
            r5 = r5[r0]
            r5.l()
        L_0x0098:
            int r2 = r2 + 1
            goto L_0x0085
        L_0x009b:
            r5 = 1
        L_0x009c:
            if (r5 > r1) goto L_0x0109
            androidx.media3.common.util.ParsableBitArray r0 = r4.f13820j
            boolean r0 = r0.g()
            if (r0 == 0) goto L_0x00b4
            androidx.media3.extractor.text.cea.Cea708Decoder$CueInfoBuilder[] r0 = r4.f13824n
            int r3 = 8 - r5
            r0 = r0[r3]
            boolean r3 = r0.k()
            r3 = r3 ^ r2
            r0.p(r3)
        L_0x00b4:
            int r5 = r5 + 1
            goto L_0x009c
        L_0x00b7:
            if (r2 > r1) goto L_0x0109
            androidx.media3.common.util.ParsableBitArray r5 = r4.f13820j
            boolean r5 = r5.g()
            if (r5 == 0) goto L_0x00cb
            androidx.media3.extractor.text.cea.Cea708Decoder$CueInfoBuilder[] r5 = r4.f13824n
            int r0 = 8 - r2
            r5 = r5[r0]
            r0 = 0
            r5.p(r0)
        L_0x00cb:
            int r2 = r2 + 1
            goto L_0x00b7
        L_0x00ce:
            r5 = 1
        L_0x00cf:
            if (r5 > r1) goto L_0x0109
            androidx.media3.common.util.ParsableBitArray r0 = r4.f13820j
            boolean r0 = r0.g()
            if (r0 == 0) goto L_0x00e2
            androidx.media3.extractor.text.cea.Cea708Decoder$CueInfoBuilder[] r0 = r4.f13824n
            int r3 = 8 - r5
            r0 = r0[r3]
            r0.p(r2)
        L_0x00e2:
            int r5 = r5 + 1
            goto L_0x00cf
        L_0x00e5:
            if (r2 > r1) goto L_0x0109
            androidx.media3.common.util.ParsableBitArray r5 = r4.f13820j
            boolean r5 = r5.g()
            if (r5 == 0) goto L_0x00f8
            androidx.media3.extractor.text.cea.Cea708Decoder$CueInfoBuilder[] r5 = r4.f13824n
            int r0 = 8 - r2
            r5 = r5[r0]
            r5.e()
        L_0x00f8:
            int r2 = r2 + 1
            goto L_0x00e5
        L_0x00fb:
            int r5 = r5 + -128
            int r0 = r4.s
            if (r0 == r5) goto L_0x0109
            r4.s = r5
            androidx.media3.extractor.text.cea.Cea708Decoder$CueInfoBuilder[] r0 = r4.f13824n
            r5 = r0[r5]
            goto L_0x002f
        L_0x0109:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.cea.Cea708Decoder.u(int):void");
    }

    private void v(int i2) {
        ParsableBitArray parsableBitArray;
        int i3;
        if (i2 > 7) {
            if (i2 <= 15) {
                parsableBitArray = this.f13820j;
                i3 = 8;
            } else if (i2 <= 23) {
                parsableBitArray = this.f13820j;
                i3 = 16;
            } else if (i2 <= 31) {
                parsableBitArray = this.f13820j;
                i3 = 24;
            } else {
                return;
            }
            parsableBitArray.s(i3);
        }
    }

    private void w(int i2) {
        ParsableBitArray parsableBitArray;
        int i3;
        if (i2 <= 135) {
            parsableBitArray = this.f13820j;
            i3 = 32;
        } else if (i2 <= g0) {
            parsableBitArray = this.f13820j;
            i3 = 40;
        } else if (i2 <= 159) {
            this.f13820j.s(2);
            this.f13820j.s(this.f13820j.h(6) * 8);
            return;
        } else {
            return;
        }
        parsableBitArray.s(i3);
    }

    private void x(int i2) {
        CueInfoBuilder cueInfoBuilder = this.f13824n[i2];
        this.f13820j.s(2);
        boolean g2 = this.f13820j.g();
        boolean g3 = this.f13820j.g();
        boolean g4 = this.f13820j.g();
        int h2 = this.f13820j.h(3);
        boolean g5 = this.f13820j.g();
        int h3 = this.f13820j.h(7);
        int h4 = this.f13820j.h(8);
        int h5 = this.f13820j.h(4);
        int h6 = this.f13820j.h(4);
        this.f13820j.s(2);
        int h7 = this.f13820j.h(6);
        this.f13820j.s(2);
        cueInfoBuilder.f(g2, g3, g4, h2, g5, h3, h4, h6, h7, h5, this.f13820j.h(3), this.f13820j.h(3));
    }

    private void y(int i2) {
        if (i2 == 127) {
            this.o.a(9835);
        } else {
            this.o.a((char) (i2 & 255));
        }
    }

    private void z(int i2) {
        this.o.a((char) (i2 & 255));
    }

    public /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    public /* bridge */ /* synthetic */ void e(long j2) {
        super.e(j2);
    }

    public void flush() {
        super.flush();
        this.p = null;
        this.q = null;
        this.s = 0;
        this.o = this.f13824n[0];
        H();
        this.r = null;
    }

    public String getName() {
        return t;
    }

    /* access modifiers changed from: protected */
    public Subtitle h() {
        List<Cue> list = this.p;
        this.q = list;
        return new CeaSubtitle((List) Assertions.g(list));
    }

    /* access modifiers changed from: protected */
    public void i(SubtitleInputBuffer subtitleInputBuffer) {
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.g(subtitleInputBuffer.Z);
        this.f13819i.W(byteBuffer.array(), byteBuffer.limit());
        while (this.f13819i.a() >= 3) {
            int L2 = this.f13819i.L();
            int i2 = L2 & 3;
            boolean z2 = false;
            boolean z3 = (L2 & 4) == 4;
            byte L3 = (byte) this.f13819i.L();
            byte L4 = (byte) this.f13819i.L();
            if ((i2 == 2 || i2 == 3) && z3) {
                if (i2 == 3) {
                    r();
                    int i3 = (L3 & 192) >> 6;
                    int i4 = this.f13821k;
                    if (!(i4 == -1 || i3 == (i4 + 1) % 4)) {
                        H();
                        Log.n(t, "Sequence number discontinuity. previous=" + this.f13821k + " current=" + i3);
                    }
                    this.f13821k = i3;
                    byte b2 = L3 & Utf8.f31404a;
                    if (b2 == 0) {
                        b2 = SignedBytes.f22967a;
                    }
                    DtvCcPacket dtvCcPacket = new DtvCcPacket(i3, b2);
                    this.r = dtvCcPacket;
                    byte[] bArr = dtvCcPacket.f13844c;
                    int i5 = dtvCcPacket.f13845d;
                    dtvCcPacket.f13845d = i5 + 1;
                    bArr[i5] = L4;
                } else {
                    if (i2 == 2) {
                        z2 = true;
                    }
                    Assertions.a(z2);
                    DtvCcPacket dtvCcPacket2 = this.r;
                    if (dtvCcPacket2 == null) {
                        Log.d(t, "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                    } else {
                        byte[] bArr2 = dtvCcPacket2.f13844c;
                        int i6 = dtvCcPacket2.f13845d;
                        int i7 = i6 + 1;
                        dtvCcPacket2.f13845d = i7;
                        bArr2[i6] = L3;
                        dtvCcPacket2.f13845d = i6 + 2;
                        bArr2[i7] = L4;
                    }
                }
                DtvCcPacket dtvCcPacket3 = this.r;
                if (dtvCcPacket3.f13845d == (dtvCcPacket3.f13843b * 2) - 1) {
                    r();
                }
            }
        }
    }

    @Nullable
    public /* bridge */ /* synthetic */ SubtitleInputBuffer j() throws SubtitleDecoderException {
        return super.f();
    }

    @Nullable
    public /* bridge */ /* synthetic */ SubtitleOutputBuffer k() throws SubtitleDecoderException {
        return super.b();
    }

    /* access modifiers changed from: protected */
    public boolean n() {
        return this.p != this.q;
    }

    public /* bridge */ /* synthetic */ void o(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        super.c(subtitleInputBuffer);
    }
}
