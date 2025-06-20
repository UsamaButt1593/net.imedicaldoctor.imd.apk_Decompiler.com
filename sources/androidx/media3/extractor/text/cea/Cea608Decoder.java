package androidx.media3.extractor.text.cea;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleDecoderException;
import androidx.media3.extractor.text.SubtitleInputBuffer;
import androidx.media3.extractor.text.SubtitleOutputBuffer;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.common.base.Ascii;
import com.itextpdf.text.Jpeg;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.httpclient.HttpStatus;

@UnstableApi
public final class Cea608Decoder extends CeaDecoder {
    public static final long A = 16000;
    private static final String B = "Cea608Decoder";
    private static final int C = 4;
    private static final int D = 2;
    private static final int E = 1;
    private static final int F = 0;
    private static final int G = 1;
    private static final int H = 0;
    private static final int I = 1;
    private static final int J = 0;
    private static final int K = 1;
    private static final int L = 2;
    private static final int M = 3;
    private static final int[] N = {11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] O = {0, 4, 8, 12, 16, 20, 24, 28};
    /* access modifiers changed from: private */
    public static final int[] P = {-1, -16711936, -16776961, -16711681, SupportMenu.f5941c, InputDeviceCompat.u, -65281};
    private static final int Q = 7;
    private static final int R = 8;
    private static final int S = 4;
    private static final byte T = -4;
    private static final byte U = 32;
    private static final byte V = 33;
    private static final byte W = 36;
    private static final byte X = 37;
    private static final byte Y = 38;
    private static final byte Z = 39;
    private static final byte a0 = 41;
    private static final byte b0 = 42;
    private static final byte c0 = 43;
    private static final byte d0 = 44;
    private static final byte e0 = 45;
    private static final byte f0 = 46;
    private static final byte g0 = 47;
    private static final int[] h0 = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, Jpeg.X4, 243, ItemTouchHelper.Callback.f15380c, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, MetaDo.s0, 209, 241, 9632};
    private static final int[] i0 = {174, 176, PsExtractor.w, 191, 8482, 162, 163, 9834, 224, 32, 232, Jpeg.V4, 234, Jpeg.W4, 244, 251};
    private static final int[] j0 = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, PsExtractor.x, 194, 199, 200, 202, 203, 235, HttpStatus.SC_PARTIAL_CONTENT, HttpStatus.SC_MULTI_STATUS, 239, 212, 217, 249, 219, 171, 187};
    private static final int[] k0 = {195, 227, HttpStatus.SC_RESET_CONTENT, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    private static final boolean[] l0 = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};

    /* renamed from: i  reason: collision with root package name */
    private final ParsableByteArray f13800i = new ParsableByteArray();

    /* renamed from: j  reason: collision with root package name */
    private final int f13801j;

    /* renamed from: k  reason: collision with root package name */
    private final int f13802k;

    /* renamed from: l  reason: collision with root package name */
    private final int f13803l;

    /* renamed from: m  reason: collision with root package name */
    private final long f13804m;

    /* renamed from: n  reason: collision with root package name */
    private final ArrayList<CueBuilder> f13805n = new ArrayList<>();
    private CueBuilder o = new CueBuilder(0, 4);
    @Nullable
    private List<Cue> p;
    @Nullable
    private List<Cue> q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private byte v;
    private byte w;
    private int x = 0;
    private boolean y;
    private long z;

    private static final class CueBuilder {

        /* renamed from: i  reason: collision with root package name */
        private static final int f13806i = 32;

        /* renamed from: j  reason: collision with root package name */
        private static final int f13807j = 15;

        /* renamed from: a  reason: collision with root package name */
        private final List<CueStyle> f13808a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final List<SpannableString> f13809b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private final StringBuilder f13810c = new StringBuilder();
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f13811d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f13812e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f13813f;

        /* renamed from: g  reason: collision with root package name */
        private int f13814g;

        /* renamed from: h  reason: collision with root package name */
        private int f13815h;

        private static class CueStyle {

            /* renamed from: a  reason: collision with root package name */
            public final int f13816a;

            /* renamed from: b  reason: collision with root package name */
            public final boolean f13817b;

            /* renamed from: c  reason: collision with root package name */
            public int f13818c;

            public CueStyle(int i2, boolean z, int i3) {
                this.f13816a = i2;
                this.f13817b = z;
                this.f13818c = i3;
            }
        }

        public CueBuilder(int i2, int i3) {
            j(i2);
            this.f13815h = i3;
        }

        private SpannableString h() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f13810c);
            int length = spannableStringBuilder.length();
            int i2 = 0;
            int i3 = -1;
            int i4 = -1;
            int i5 = 0;
            int i6 = -1;
            int i7 = -1;
            boolean z = false;
            while (i2 < this.f13808a.size()) {
                CueStyle cueStyle = this.f13808a.get(i2);
                boolean z2 = cueStyle.f13817b;
                int i8 = cueStyle.f13816a;
                if (i8 != 8) {
                    boolean z3 = i8 == 7;
                    if (i8 != 7) {
                        i7 = Cea608Decoder.P[i8];
                    }
                    z = z3;
                }
                int i9 = cueStyle.f13818c;
                i2++;
                if (i9 != (i2 < this.f13808a.size() ? this.f13808a.get(i2).f13818c : length)) {
                    if (i3 != -1 && !z2) {
                        q(spannableStringBuilder, i3, i9);
                        i3 = -1;
                    } else if (i3 == -1 && z2) {
                        i3 = i9;
                    }
                    if (i4 != -1 && !z) {
                        o(spannableStringBuilder, i4, i9);
                        i4 = -1;
                    } else if (i4 == -1 && z) {
                        i4 = i9;
                    }
                    if (i7 != i6) {
                        n(spannableStringBuilder, i5, i9, i6);
                        i6 = i7;
                        i5 = i9;
                    }
                }
            }
            if (!(i3 == -1 || i3 == length)) {
                q(spannableStringBuilder, i3, length);
            }
            if (!(i4 == -1 || i4 == length)) {
                o(spannableStringBuilder, i4, length);
            }
            if (i5 != length) {
                n(spannableStringBuilder, i5, length, i6);
            }
            return new SpannableString(spannableStringBuilder);
        }

        private static void n(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4) {
            if (i4 != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(i4), i2, i3, 33);
            }
        }

        private static void o(SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i2, i3, 33);
        }

        private static void q(SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i2, i3, 33);
        }

        public void e(char c2) {
            if (this.f13810c.length() < 32) {
                this.f13810c.append(c2);
            }
        }

        public void f() {
            int length = this.f13810c.length();
            if (length > 0) {
                this.f13810c.delete(length - 1, length);
                int size = this.f13808a.size() - 1;
                while (size >= 0) {
                    CueStyle cueStyle = this.f13808a.get(size);
                    int i2 = cueStyle.f13818c;
                    if (i2 == length) {
                        cueStyle.f13818c = i2 - 1;
                        size--;
                    } else {
                        return;
                    }
                }
            }
        }

        @Nullable
        public Cue g(int i2) {
            float f2;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i3 = 0; i3 < this.f13809b.size(); i3++) {
                spannableStringBuilder.append(this.f13809b.get(i3));
                spannableStringBuilder.append(10);
            }
            spannableStringBuilder.append(h());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int i4 = this.f13812e + this.f13813f;
            int length = (32 - i4) - spannableStringBuilder.length();
            int i5 = i4 - length;
            if (i2 == Integer.MIN_VALUE) {
                i2 = (this.f13814g != 2 || (Math.abs(i5) >= 3 && length >= 0)) ? (this.f13814g != 2 || i5 <= 0) ? 0 : 2 : 1;
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    i4 = 32 - length;
                }
                f2 = ((((float) i4) / 32.0f) * 0.8f) + 0.1f;
            } else {
                f2 = 0.5f;
            }
            int i6 = this.f13811d;
            if (i6 > 7) {
                i6 -= 17;
            } else if (this.f13814g == 1) {
                i6 -= this.f13815h - 1;
            }
            return new Cue.Builder().A(spannableStringBuilder).B(Layout.Alignment.ALIGN_NORMAL).t((float) i6, 1).w(f2).x(i2).a();
        }

        public boolean i() {
            return this.f13808a.isEmpty() && this.f13809b.isEmpty() && this.f13810c.length() == 0;
        }

        public void j(int i2) {
            this.f13814g = i2;
            this.f13808a.clear();
            this.f13809b.clear();
            this.f13810c.setLength(0);
            this.f13811d = 15;
            this.f13812e = 0;
            this.f13813f = 0;
        }

        public void k() {
            this.f13809b.add(h());
            this.f13810c.setLength(0);
            this.f13808a.clear();
            int min = Math.min(this.f13815h, this.f13811d);
            while (this.f13809b.size() >= min) {
                this.f13809b.remove(0);
            }
        }

        public void l(int i2) {
            this.f13814g = i2;
        }

        public void m(int i2) {
            this.f13815h = i2;
        }

        public void p(int i2, boolean z) {
            this.f13808a.add(new CueStyle(i2, z, this.f13810c.length()));
        }
    }

    public Cea608Decoder(String str, int i2, long j2) {
        this.f13804m = j2 > 0 ? j2 * 1000 : -9223372036854775807L;
        this.f13801j = MimeTypes.C0.equals(str) ? 2 : 3;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    this.f13803l = 0;
                } else if (i2 != 4) {
                    Log.n(B, "Invalid channel. Defaulting to CC1.");
                } else {
                    this.f13803l = 1;
                }
                this.f13802k = 1;
                P(0);
                O();
                this.y = true;
                this.z = C.f9084b;
            }
            this.f13803l = 1;
            this.f13802k = 0;
            P(0);
            O();
            this.y = true;
            this.z = C.f9084b;
        }
        this.f13803l = 0;
        this.f13802k = 0;
        P(0);
        O();
        this.y = true;
        this.z = C.f9084b;
    }

    private void A(byte b2) {
        if (b2 == 32) {
            P(2);
        } else if (b2 != 41) {
            switch (b2) {
                case 37:
                    P(1);
                    Q(2);
                    return;
                case 38:
                    P(1);
                    Q(3);
                    return;
                case 39:
                    P(1);
                    Q(4);
                    return;
                default:
                    int i2 = this.r;
                    if (i2 != 0) {
                        if (b2 != 33) {
                            switch (b2) {
                                case 44:
                                    this.p = Collections.emptyList();
                                    int i3 = this.r;
                                    if (!(i3 == 1 || i3 == 3)) {
                                        return;
                                    }
                                case 45:
                                    if (i2 == 1 && !this.o.i()) {
                                        this.o.k();
                                        return;
                                    }
                                    return;
                                case 46:
                                    break;
                                case 47:
                                    this.p = u();
                                    break;
                                default:
                                    return;
                            }
                            O();
                            return;
                        }
                        this.o.f();
                        return;
                    }
                    return;
            }
        } else {
            P(3);
        }
    }

    private void B(byte b2, byte b3) {
        int i2 = N[b2 & 7];
        if ((b3 & 32) != 0) {
            i2++;
        }
        if (i2 != this.o.f13811d) {
            if (this.r != 1 && !this.o.i()) {
                CueBuilder cueBuilder = new CueBuilder(this.r, this.s);
                this.o = cueBuilder;
                this.f13805n.add(cueBuilder);
            }
            int unused = this.o.f13811d = i2;
        }
        boolean z2 = false;
        boolean z3 = (b3 & 16) == 16;
        if ((b3 & 1) == 1) {
            z2 = true;
        }
        int i3 = (b3 >> 1) & 7;
        this.o.p(z3 ? 8 : i3, z2);
        if (z3) {
            int unused2 = this.o.f13812e = O[i3];
        }
    }

    private static boolean C(byte b2) {
        return (b2 & 224) == 0;
    }

    private static boolean D(byte b2, byte b3) {
        return (b2 & 246) == 18 && (b3 & 224) == 32;
    }

    private static boolean E(byte b2, byte b3) {
        return (b2 & 247) == 17 && (b3 & 240) == 32;
    }

    private static boolean F(byte b2, byte b3) {
        return (b2 & 246) == 20 && (b3 & 240) == 32;
    }

    private static boolean G(byte b2, byte b3) {
        return (b2 & 240) == 16 && (b3 & 192) == 64;
    }

    private static boolean H(byte b2) {
        return (b2 & 240) == 16;
    }

    private boolean I(boolean z2, byte b2, byte b3) {
        if (!z2 || !H(b2)) {
            this.u = false;
        } else if (this.u && this.v == b2 && this.w == b3) {
            this.u = false;
            return true;
        } else {
            this.u = true;
            this.v = b2;
            this.w = b3;
        }
        return false;
    }

    private static boolean J(byte b2) {
        return (b2 & 246) == 20;
    }

    private static boolean K(byte b2, byte b3) {
        return (b2 & 247) == 17 && (b3 & 240) == 48;
    }

    private static boolean L(byte b2, byte b3) {
        return (b2 & 247) == 23 && b3 >= 33 && b3 <= 35;
    }

    private static boolean M(byte b2) {
        return 1 <= b2 && b2 <= 15;
    }

    private void N(byte b2, byte b3) {
        if (!M(b2)) {
            if (J(b2)) {
                if (!(b3 == 32 || b3 == 47)) {
                    switch (b3) {
                        case 37:
                        case 38:
                        case 39:
                            break;
                        default:
                            switch (b3) {
                                case 41:
                                    break;
                                case 42:
                                case 43:
                                    break;
                                default:
                                    return;
                            }
                    }
                }
                this.y = true;
                return;
            }
            return;
        }
        this.y = false;
    }

    private void O() {
        this.o.j(this.r);
        this.f13805n.clear();
        this.f13805n.add(this.o);
    }

    private void P(int i2) {
        int i3 = this.r;
        if (i3 != i2) {
            this.r = i2;
            if (i2 == 3) {
                for (int i4 = 0; i4 < this.f13805n.size(); i4++) {
                    this.f13805n.get(i4).l(i2);
                }
                return;
            }
            O();
            if (i3 == 3 || i2 == 1 || i2 == 0) {
                this.p = Collections.emptyList();
            }
        }
    }

    private void Q(int i2) {
        this.s = i2;
        this.o.m(i2);
    }

    private boolean R() {
        return (this.f13804m == C.f9084b || this.z == C.f9084b || m() - this.z < this.f13804m) ? false : true;
    }

    private boolean S(byte b2) {
        if (C(b2)) {
            this.x = t(b2);
        }
        return this.x == this.f13803l;
    }

    private static char s(byte b2) {
        return (char) h0[(b2 & Byte.MAX_VALUE) - 32];
    }

    private static int t(byte b2) {
        return (b2 >> 3) & 1;
    }

    private List<Cue> u() {
        int size = this.f13805n.size();
        ArrayList arrayList = new ArrayList(size);
        int i2 = 2;
        for (int i3 = 0; i3 < size; i3++) {
            Cue g2 = this.f13805n.get(i3).g(Integer.MIN_VALUE);
            arrayList.add(g2);
            if (g2 != null) {
                i2 = Math.min(i2, g2.b3);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i4 = 0; i4 < size; i4++) {
            Cue cue = (Cue) arrayList.get(i4);
            if (cue != null) {
                if (cue.b3 != i2) {
                    cue = (Cue) Assertions.g(this.f13805n.get(i4).g(i2));
                }
                arrayList2.add(cue);
            }
        }
        return arrayList2;
    }

    private static char v(byte b2) {
        return (char) j0[b2 & Ascii.I];
    }

    private static char w(byte b2) {
        return (char) k0[b2 & Ascii.I];
    }

    private static char x(byte b2, byte b3) {
        return (b2 & 1) == 0 ? v(b3) : w(b3);
    }

    private static char y(byte b2) {
        return (char) i0[b2 & 15];
    }

    private void z(byte b2) {
        this.o.e(' ');
        this.o.p((b2 >> 1) & 7, (b2 & 1) == 1);
    }

    public void a() {
    }

    public /* bridge */ /* synthetic */ void e(long j2) {
        super.e(j2);
    }

    public void flush() {
        super.flush();
        this.p = null;
        this.q = null;
        P(0);
        Q(4);
        O();
        this.t = false;
        this.u = false;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = true;
        this.z = C.f9084b;
    }

    public String getName() {
        return B;
    }

    /* access modifiers changed from: protected */
    public Subtitle h() {
        List<Cue> list = this.p;
        this.q = list;
        return new CeaSubtitle((List) Assertions.g(list));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0017 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i(androidx.media3.extractor.text.SubtitleInputBuffer r10) {
        /*
            r9 = this;
            java.nio.ByteBuffer r10 = r10.Z
            java.lang.Object r10 = androidx.media3.common.util.Assertions.g(r10)
            java.nio.ByteBuffer r10 = (java.nio.ByteBuffer) r10
            androidx.media3.common.util.ParsableByteArray r0 = r9.f13800i
            byte[] r1 = r10.array()
            int r10 = r10.limit()
            r0.W(r1, r10)
            r10 = 0
            r0 = 0
        L_0x0017:
            androidx.media3.common.util.ParsableByteArray r1 = r9.f13800i
            int r1 = r1.a()
            int r2 = r9.f13801j
            r3 = 1
            if (r1 < r2) goto L_0x00ef
            r1 = 2
            if (r2 != r1) goto L_0x0027
            r1 = -4
            goto L_0x002d
        L_0x0027:
            androidx.media3.common.util.ParsableByteArray r1 = r9.f13800i
            int r1 = r1.L()
        L_0x002d:
            androidx.media3.common.util.ParsableByteArray r2 = r9.f13800i
            int r2 = r2.L()
            androidx.media3.common.util.ParsableByteArray r4 = r9.f13800i
            int r4 = r4.L()
            r5 = r1 & 2
            if (r5 == 0) goto L_0x003e
            goto L_0x0017
        L_0x003e:
            r5 = r1 & 1
            int r6 = r9.f13802k
            if (r5 == r6) goto L_0x0045
            goto L_0x0017
        L_0x0045:
            r5 = r2 & 127(0x7f, float:1.78E-43)
            byte r5 = (byte) r5
            r6 = r4 & 127(0x7f, float:1.78E-43)
            byte r6 = (byte) r6
            if (r5 != 0) goto L_0x0050
            if (r6 != 0) goto L_0x0050
            goto L_0x0017
        L_0x0050:
            boolean r7 = r9.t
            r1 = r1 & 4
            r8 = 4
            if (r1 != r8) goto L_0x0063
            boolean[] r1 = l0
            boolean r2 = r1[r2]
            if (r2 == 0) goto L_0x0063
            boolean r1 = r1[r4]
            if (r1 == 0) goto L_0x0063
            r1 = 1
            goto L_0x0064
        L_0x0063:
            r1 = 0
        L_0x0064:
            r9.t = r1
            boolean r1 = r9.I(r1, r5, r6)
            if (r1 == 0) goto L_0x006d
            goto L_0x0017
        L_0x006d:
            boolean r1 = r9.t
            if (r1 != 0) goto L_0x0078
            if (r7 == 0) goto L_0x0017
            r9.O()
        L_0x0076:
            r0 = 1
            goto L_0x0017
        L_0x0078:
            r9.N(r5, r6)
            boolean r1 = r9.y
            if (r1 != 0) goto L_0x0080
            goto L_0x0017
        L_0x0080:
            boolean r1 = r9.S(r5)
            if (r1 != 0) goto L_0x0087
            goto L_0x0017
        L_0x0087:
            boolean r0 = C(r5)
            if (r0 == 0) goto L_0x00db
            boolean r0 = K(r5, r6)
            if (r0 == 0) goto L_0x009d
            androidx.media3.extractor.text.cea.Cea608Decoder$CueBuilder r0 = r9.o
            char r1 = y(r6)
        L_0x0099:
            r0.e(r1)
            goto L_0x0076
        L_0x009d:
            boolean r0 = D(r5, r6)
            if (r0 == 0) goto L_0x00af
            androidx.media3.extractor.text.cea.Cea608Decoder$CueBuilder r0 = r9.o
            r0.f()
            androidx.media3.extractor.text.cea.Cea608Decoder$CueBuilder r0 = r9.o
            char r1 = x(r5, r6)
            goto L_0x0099
        L_0x00af:
            boolean r0 = E(r5, r6)
            if (r0 == 0) goto L_0x00b9
            r9.z(r6)
            goto L_0x0076
        L_0x00b9:
            boolean r0 = G(r5, r6)
            if (r0 == 0) goto L_0x00c3
            r9.B(r5, r6)
            goto L_0x0076
        L_0x00c3:
            boolean r0 = L(r5, r6)
            if (r0 == 0) goto L_0x00d1
            androidx.media3.extractor.text.cea.Cea608Decoder$CueBuilder r0 = r9.o
            int r6 = r6 + -32
            int unused = r0.f13813f = r6
            goto L_0x0076
        L_0x00d1:
            boolean r0 = F(r5, r6)
            if (r0 == 0) goto L_0x0076
            r9.A(r6)
            goto L_0x0076
        L_0x00db:
            androidx.media3.extractor.text.cea.Cea608Decoder$CueBuilder r0 = r9.o
            char r1 = s(r5)
            r0.e(r1)
            r0 = r6 & 224(0xe0, float:3.14E-43)
            if (r0 == 0) goto L_0x0076
            androidx.media3.extractor.text.cea.Cea608Decoder$CueBuilder r0 = r9.o
            char r1 = s(r6)
            goto L_0x0099
        L_0x00ef:
            if (r0 == 0) goto L_0x0104
            int r10 = r9.r
            if (r10 == r3) goto L_0x00f8
            r0 = 3
            if (r10 != r0) goto L_0x0104
        L_0x00f8:
            java.util.List r10 = r9.u()
            r9.p = r10
            long r0 = r9.m()
            r9.z = r0
        L_0x0104:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.cea.Cea608Decoder.i(androidx.media3.extractor.text.SubtitleInputBuffer):void");
    }

    @Nullable
    public /* bridge */ /* synthetic */ SubtitleInputBuffer j() throws SubtitleDecoderException {
        return super.f();
    }

    @Nullable
    /* renamed from: k */
    public SubtitleOutputBuffer b() throws SubtitleDecoderException {
        SubtitleOutputBuffer l2;
        SubtitleOutputBuffer k2 = super.b();
        if (k2 != null) {
            return k2;
        }
        if (!R() || (l2 = l()) == null) {
            return null;
        }
        this.p = Collections.emptyList();
        this.z = C.f9084b;
        SubtitleOutputBuffer subtitleOutputBuffer = l2;
        subtitleOutputBuffer.r(m(), h(), Long.MAX_VALUE);
        return l2;
    }

    /* access modifiers changed from: protected */
    public boolean n() {
        return this.p != this.q;
    }

    public /* bridge */ /* synthetic */ void o(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        super.c(subtitleInputBuffer);
    }
}
