package androidx.media3.extractor.mp4;

import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.Ac4Util;
import androidx.media3.extractor.CeaUtil;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.d;
import androidx.media3.extractor.metadata.emsg.EventMessageEncoder;
import androidx.media3.extractor.mp4.Atom;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.SubtitleTranscodingExtractorOutput;
import androidx.media3.extractor.ts.PsExtractor;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@UnstableApi
public class FragmentedMp4Extractor implements Extractor {
    public static final int M = 1;
    public static final int N = 2;
    public static final int O = 4;
    public static final int P = 16;
    public static final int Q = 32;
    @Deprecated
    public static final ExtractorsFactory R = new a();
    private static final String S = "FragmentedMp4Extractor";
    private static final int T = 1936025959;
    private static final byte[] U = {-94, 57, 79, 82, 90, -101, 79, Ascii.x, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final Format V = new Format.Builder().k0(MimeTypes.I0).I();
    private static final int W = 100;
    private static final int X = 0;
    private static final int Y = 1;
    private static final int Z = 2;
    private static final int a0 = 3;
    private static final int b0 = 4;
    private long A;
    private long B;
    private long C;
    @Nullable
    private TrackBundle D;
    private int E;
    private int F;
    private int G;
    private boolean H;
    private ExtractorOutput I;
    private TrackOutput[] J;
    private TrackOutput[] K;
    private boolean L;

    /* renamed from: d  reason: collision with root package name */
    private final SubtitleParser.Factory f13564d;

    /* renamed from: e  reason: collision with root package name */
    private final int f13565e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final Track f13566f;

    /* renamed from: g  reason: collision with root package name */
    private final List<Format> f13567g;

    /* renamed from: h  reason: collision with root package name */
    private final SparseArray<TrackBundle> f13568h;

    /* renamed from: i  reason: collision with root package name */
    private final ParsableByteArray f13569i;

    /* renamed from: j  reason: collision with root package name */
    private final ParsableByteArray f13570j;

    /* renamed from: k  reason: collision with root package name */
    private final ParsableByteArray f13571k;

    /* renamed from: l  reason: collision with root package name */
    private final byte[] f13572l;

    /* renamed from: m  reason: collision with root package name */
    private final ParsableByteArray f13573m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private final TimestampAdjuster f13574n;
    private final EventMessageEncoder o;
    private final ParsableByteArray p;
    private final ArrayDeque<Atom.ContainerAtom> q;
    private final ArrayDeque<MetadataSampleInfo> r;
    @Nullable
    private final TrackOutput s;
    private int t;
    private int u;
    private long v;
    private int w;
    @Nullable
    private ParsableByteArray x;
    private long y;
    private int z;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    private static final class MetadataSampleInfo {

        /* renamed from: a  reason: collision with root package name */
        public final long f13575a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f13576b;

        /* renamed from: c  reason: collision with root package name */
        public final int f13577c;

        public MetadataSampleInfo(long j2, boolean z, int i2) {
            this.f13575a = j2;
            this.f13576b = z;
            this.f13577c = i2;
        }
    }

    private static final class TrackBundle {

        /* renamed from: m  reason: collision with root package name */
        private static final int f13578m = 8;

        /* renamed from: a  reason: collision with root package name */
        public final TrackOutput f13579a;

        /* renamed from: b  reason: collision with root package name */
        public final TrackFragment f13580b = new TrackFragment();

        /* renamed from: c  reason: collision with root package name */
        public final ParsableByteArray f13581c = new ParsableByteArray();

        /* renamed from: d  reason: collision with root package name */
        public TrackSampleTable f13582d;

        /* renamed from: e  reason: collision with root package name */
        public DefaultSampleValues f13583e;

        /* renamed from: f  reason: collision with root package name */
        public int f13584f;

        /* renamed from: g  reason: collision with root package name */
        public int f13585g;

        /* renamed from: h  reason: collision with root package name */
        public int f13586h;

        /* renamed from: i  reason: collision with root package name */
        public int f13587i;

        /* renamed from: j  reason: collision with root package name */
        private final ParsableByteArray f13588j = new ParsableByteArray(1);

        /* renamed from: k  reason: collision with root package name */
        private final ParsableByteArray f13589k = new ParsableByteArray();
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public boolean f13590l;

        public TrackBundle(TrackOutput trackOutput, TrackSampleTable trackSampleTable, DefaultSampleValues defaultSampleValues) {
            this.f13579a = trackOutput;
            this.f13582d = trackSampleTable;
            this.f13583e = defaultSampleValues;
            j(trackSampleTable, defaultSampleValues);
        }

        public int c() {
            int i2 = !this.f13590l ? this.f13582d.f13695g[this.f13584f] : this.f13580b.f13685k[this.f13584f] ? 1 : 0;
            return g() != null ? i2 | 1073741824 : i2;
        }

        public long d() {
            return !this.f13590l ? this.f13582d.f13691c[this.f13584f] : this.f13580b.f13681g[this.f13586h];
        }

        public long e() {
            return !this.f13590l ? this.f13582d.f13694f[this.f13584f] : this.f13580b.c(this.f13584f);
        }

        public int f() {
            return !this.f13590l ? this.f13582d.f13692d[this.f13584f] : this.f13580b.f13683i[this.f13584f];
        }

        @Nullable
        public TrackEncryptionBox g() {
            if (!this.f13590l) {
                return null;
            }
            int i2 = ((DefaultSampleValues) Util.o(this.f13580b.f13675a)).f13553a;
            TrackEncryptionBox trackEncryptionBox = this.f13580b.f13688n;
            if (trackEncryptionBox == null) {
                trackEncryptionBox = this.f13582d.f13689a.b(i2);
            }
            if (trackEncryptionBox == null || !trackEncryptionBox.f13670a) {
                return null;
            }
            return trackEncryptionBox;
        }

        public boolean h() {
            this.f13584f++;
            if (!this.f13590l) {
                return false;
            }
            int i2 = this.f13585g + 1;
            this.f13585g = i2;
            int[] iArr = this.f13580b.f13682h;
            int i3 = this.f13586h;
            if (i2 != iArr[i3]) {
                return true;
            }
            this.f13586h = i3 + 1;
            this.f13585g = 0;
            return false;
        }

        public int i(int i2, int i3) {
            ParsableByteArray parsableByteArray;
            TrackEncryptionBox g2 = g();
            if (g2 == null) {
                return 0;
            }
            int i4 = g2.f13673d;
            if (i4 != 0) {
                parsableByteArray = this.f13580b.o;
            } else {
                byte[] bArr = (byte[]) Util.o(g2.f13674e);
                this.f13589k.W(bArr, bArr.length);
                ParsableByteArray parsableByteArray2 = this.f13589k;
                i4 = bArr.length;
                parsableByteArray = parsableByteArray2;
            }
            boolean g3 = this.f13580b.g(this.f13584f);
            boolean z = g3 || i3 != 0;
            this.f13588j.e()[0] = (byte) ((z ? 128 : 0) | i4);
            this.f13588j.Y(0);
            this.f13579a.a(this.f13588j, 1, 1);
            this.f13579a.a(parsableByteArray, i4, 1);
            if (!z) {
                return i4 + 1;
            }
            if (!g3) {
                this.f13581c.U(8);
                byte[] e2 = this.f13581c.e();
                e2[0] = 0;
                e2[1] = 1;
                e2[2] = (byte) ((i3 >> 8) & 255);
                e2[3] = (byte) (i3 & 255);
                e2[4] = (byte) ((i2 >> 24) & 255);
                e2[5] = (byte) ((i2 >> 16) & 255);
                e2[6] = (byte) ((i2 >> 8) & 255);
                e2[7] = (byte) (i2 & 255);
                this.f13579a.a(this.f13581c, 8, 1);
                return i4 + 9;
            }
            ParsableByteArray parsableByteArray3 = this.f13580b.o;
            int R = parsableByteArray3.R();
            parsableByteArray3.Z(-2);
            int i5 = (R * 6) + 2;
            if (i3 != 0) {
                this.f13581c.U(i5);
                byte[] e3 = this.f13581c.e();
                parsableByteArray3.n(e3, 0, i5);
                int i6 = (((e3[2] & 255) << 8) | (e3[3] & 255)) + i3;
                e3[2] = (byte) ((i6 >> 8) & 255);
                e3[3] = (byte) (i6 & 255);
                parsableByteArray3 = this.f13581c;
            }
            this.f13579a.a(parsableByteArray3, i5, 1);
            return i4 + 1 + i5;
        }

        public void j(TrackSampleTable trackSampleTable, DefaultSampleValues defaultSampleValues) {
            this.f13582d = trackSampleTable;
            this.f13583e = defaultSampleValues;
            this.f13579a.e(trackSampleTable.f13689a.f13663f);
            k();
        }

        public void k() {
            this.f13580b.f();
            this.f13584f = 0;
            this.f13586h = 0;
            this.f13585g = 0;
            this.f13587i = 0;
            this.f13590l = false;
        }

        public void l(long j2) {
            int i2 = this.f13584f;
            while (true) {
                TrackFragment trackFragment = this.f13580b;
                if (i2 < trackFragment.f13680f && trackFragment.c(i2) <= j2) {
                    if (this.f13580b.f13685k[i2]) {
                        this.f13587i = i2;
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }

        public void m() {
            TrackEncryptionBox g2 = g();
            if (g2 != null) {
                ParsableByteArray parsableByteArray = this.f13580b.o;
                int i2 = g2.f13673d;
                if (i2 != 0) {
                    parsableByteArray.Z(i2);
                }
                if (this.f13580b.g(this.f13584f)) {
                    parsableByteArray.Z(parsableByteArray.R() * 6);
                }
            }
        }

        public void n(DrmInitData drmInitData) {
            TrackEncryptionBox b2 = this.f13582d.f13689a.b(((DefaultSampleValues) Util.o(this.f13580b.f13675a)).f13553a);
            this.f13579a.e(this.f13582d.f13689a.f13663f.c().R(drmInitData.c(b2 != null ? b2.f13671b : null)).I());
        }
    }

    @Deprecated
    public FragmentedMp4Extractor() {
        this(SubtitleParser.Factory.f13783a, 32, (TimestampAdjuster) null, (Track) null, ImmutableList.I(), (TrackOutput) null);
    }

    private static void A(Atom.ContainerAtom containerAtom, SparseArray<TrackBundle> sparseArray, boolean z2, int i2, byte[] bArr) throws ParserException {
        int size = containerAtom.I1.size();
        for (int i3 = 0; i3 < size; i3++) {
            Atom.ContainerAtom containerAtom2 = containerAtom.I1.get(i3);
            if (containerAtom2.f13510a == 1953653094) {
                J(containerAtom2, sparseArray, z2, i2, bArr);
            }
        }
    }

    private static void B(ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        parsableByteArray.Y(8);
        int s2 = parsableByteArray.s();
        if ((Atom.b(s2) & 1) == 1) {
            parsableByteArray.Z(8);
        }
        int P2 = parsableByteArray.P();
        if (P2 == 1) {
            trackFragment.f13678d += Atom.c(s2) == 0 ? parsableByteArray.N() : parsableByteArray.Q();
            return;
        }
        throw ParserException.a("Unexpected saio entry count: " + P2, (Throwable) null);
    }

    private static void C(TrackEncryptionBox trackEncryptionBox, ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        int i2;
        int i3 = trackEncryptionBox.f13673d;
        parsableByteArray.Y(8);
        boolean z2 = true;
        if ((Atom.b(parsableByteArray.s()) & 1) == 1) {
            parsableByteArray.Z(8);
        }
        int L2 = parsableByteArray.L();
        int P2 = parsableByteArray.P();
        if (P2 <= trackFragment.f13680f) {
            if (L2 == 0) {
                boolean[] zArr = trackFragment.f13687m;
                i2 = 0;
                for (int i4 = 0; i4 < P2; i4++) {
                    int L3 = parsableByteArray.L();
                    i2 += L3;
                    zArr[i4] = L3 > i3;
                }
            } else {
                if (L2 <= i3) {
                    z2 = false;
                }
                i2 = L2 * P2;
                Arrays.fill(trackFragment.f13687m, 0, P2, z2);
            }
            Arrays.fill(trackFragment.f13687m, P2, trackFragment.f13680f, false);
            if (i2 > 0) {
                trackFragment.d(i2);
                return;
            }
            return;
        }
        throw ParserException.a("Saiz sample count " + P2 + " is greater than fragment sample count" + trackFragment.f13680f, (Throwable) null);
    }

    private static void D(Atom.ContainerAtom containerAtom, @Nullable String str, TrackFragment trackFragment) throws ParserException {
        Atom.ContainerAtom containerAtom2 = containerAtom;
        TrackFragment trackFragment2 = trackFragment;
        byte[] bArr = null;
        ParsableByteArray parsableByteArray = null;
        ParsableByteArray parsableByteArray2 = null;
        for (int i2 = 0; i2 < containerAtom2.H1.size(); i2++) {
            Atom.LeafAtom leafAtom = containerAtom2.H1.get(i2);
            ParsableByteArray parsableByteArray3 = leafAtom.G1;
            int i3 = leafAtom.f13510a;
            if (i3 == 1935828848) {
                parsableByteArray3.Y(12);
                if (parsableByteArray3.s() == T) {
                    parsableByteArray = parsableByteArray3;
                }
            } else if (i3 == 1936158820) {
                parsableByteArray3.Y(12);
                if (parsableByteArray3.s() == T) {
                    parsableByteArray2 = parsableByteArray3;
                }
            }
        }
        if (parsableByteArray != null && parsableByteArray2 != null) {
            parsableByteArray.Y(8);
            int c2 = Atom.c(parsableByteArray.s());
            parsableByteArray.Z(4);
            if (c2 == 1) {
                parsableByteArray.Z(4);
            }
            if (parsableByteArray.s() == 1) {
                parsableByteArray2.Y(8);
                int c3 = Atom.c(parsableByteArray2.s());
                parsableByteArray2.Z(4);
                if (c3 == 1) {
                    if (parsableByteArray2.N() == 0) {
                        throw ParserException.e("Variable length description in sgpd found (unsupported)");
                    }
                } else if (c3 >= 2) {
                    parsableByteArray2.Z(4);
                }
                if (parsableByteArray2.N() == 1) {
                    parsableByteArray2.Z(1);
                    int L2 = parsableByteArray2.L();
                    int i4 = (L2 & PsExtractor.A) >> 4;
                    int i5 = L2 & 15;
                    boolean z2 = parsableByteArray2.L() == 1;
                    if (z2) {
                        int L3 = parsableByteArray2.L();
                        byte[] bArr2 = new byte[16];
                        parsableByteArray2.n(bArr2, 0, 16);
                        if (L3 == 0) {
                            int L4 = parsableByteArray2.L();
                            bArr = new byte[L4];
                            parsableByteArray2.n(bArr, 0, L4);
                        }
                        trackFragment2.f13686l = true;
                        trackFragment2.f13688n = new TrackEncryptionBox(z2, str, L3, bArr2, i4, i5, bArr);
                        return;
                    }
                    return;
                }
                throw ParserException.e("Entry count in sgpd != 1 (unsupported).");
            }
            throw ParserException.e("Entry count in sbgp != 1 (unsupported).");
        }
    }

    private static void E(ParsableByteArray parsableByteArray, int i2, TrackFragment trackFragment) throws ParserException {
        parsableByteArray.Y(i2 + 8);
        int b2 = Atom.b(parsableByteArray.s());
        if ((b2 & 1) == 0) {
            boolean z2 = (b2 & 2) != 0;
            int P2 = parsableByteArray.P();
            if (P2 == 0) {
                Arrays.fill(trackFragment.f13687m, 0, trackFragment.f13680f, false);
            } else if (P2 == trackFragment.f13680f) {
                Arrays.fill(trackFragment.f13687m, 0, P2, z2);
                trackFragment.d(parsableByteArray.a());
                trackFragment.a(parsableByteArray);
            } else {
                throw ParserException.a("Senc sample count " + P2 + " is different from fragment sample count" + trackFragment.f13680f, (Throwable) null);
            }
        } else {
            throw ParserException.e("Overriding TrackEncryptionBox parameters is unsupported.");
        }
    }

    private static void F(ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        E(parsableByteArray, 0, trackFragment);
    }

    private static Pair<Long, ChunkIndex> G(ParsableByteArray parsableByteArray, long j2) throws ParserException {
        long Q2;
        long Q3;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        parsableByteArray2.Y(8);
        int c2 = Atom.c(parsableByteArray.s());
        parsableByteArray2.Z(4);
        long N2 = parsableByteArray.N();
        if (c2 == 0) {
            Q2 = parsableByteArray.N();
            Q3 = parsableByteArray.N();
        } else {
            Q2 = parsableByteArray.Q();
            Q3 = parsableByteArray.Q();
        }
        long j3 = Q2;
        long j4 = j2 + Q3;
        long c22 = Util.c2(j3, 1000000, N2);
        parsableByteArray2.Z(2);
        int R2 = parsableByteArray.R();
        int[] iArr = new int[R2];
        long[] jArr = new long[R2];
        long[] jArr2 = new long[R2];
        long[] jArr3 = new long[R2];
        long j5 = j3;
        long j6 = c22;
        int i2 = 0;
        while (i2 < R2) {
            int s2 = parsableByteArray.s();
            if ((s2 & Integer.MIN_VALUE) == 0) {
                long N3 = parsableByteArray.N();
                iArr[i2] = s2 & Integer.MAX_VALUE;
                jArr[i2] = j4;
                jArr3[i2] = j6;
                long j7 = j5 + N3;
                long[] jArr4 = jArr2;
                long[] jArr5 = jArr3;
                int i3 = R2;
                int[] iArr2 = iArr;
                long c23 = Util.c2(j7, 1000000, N2);
                jArr4[i2] = c23 - jArr5[i2];
                parsableByteArray2.Z(4);
                j4 += (long) iArr2[i2];
                i2++;
                iArr = iArr2;
                jArr3 = jArr5;
                jArr2 = jArr4;
                jArr = jArr;
                R2 = i3;
                long j8 = c23;
                j5 = j7;
                j6 = j8;
            } else {
                throw ParserException.a("Unhandled indirect reference", (Throwable) null);
            }
        }
        return Pair.create(Long.valueOf(c22), new ChunkIndex(iArr, jArr, jArr2, jArr3));
    }

    private static long H(ParsableByteArray parsableByteArray) {
        parsableByteArray.Y(8);
        return Atom.c(parsableByteArray.s()) == 1 ? parsableByteArray.Q() : parsableByteArray.N();
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [android.util.SparseArray, android.util.SparseArray<androidx.media3.extractor.mp4.FragmentedMp4Extractor$TrackBundle>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.media3.extractor.mp4.FragmentedMp4Extractor.TrackBundle I(androidx.media3.common.util.ParsableByteArray r4, android.util.SparseArray<androidx.media3.extractor.mp4.FragmentedMp4Extractor.TrackBundle> r5, boolean r6) {
        /*
            r0 = 8
            r4.Y(r0)
            int r0 = r4.s()
            int r0 = androidx.media3.extractor.mp4.Atom.b(r0)
            int r1 = r4.s()
            if (r6 == 0) goto L_0x001b
            r6 = 0
            java.lang.Object r5 = r5.valueAt(r6)
        L_0x0018:
            androidx.media3.extractor.mp4.FragmentedMp4Extractor$TrackBundle r5 = (androidx.media3.extractor.mp4.FragmentedMp4Extractor.TrackBundle) r5
            goto L_0x0020
        L_0x001b:
            java.lang.Object r5 = r5.get(r1)
            goto L_0x0018
        L_0x0020:
            if (r5 != 0) goto L_0x0024
            r4 = 0
            return r4
        L_0x0024:
            r6 = r0 & 1
            if (r6 == 0) goto L_0x0032
            long r1 = r4.Q()
            androidx.media3.extractor.mp4.TrackFragment r6 = r5.f13580b
            r6.f13677c = r1
            r6.f13678d = r1
        L_0x0032:
            androidx.media3.extractor.mp4.DefaultSampleValues r6 = r5.f13583e
            r1 = r0 & 2
            if (r1 == 0) goto L_0x003f
            int r1 = r4.s()
            int r1 = r1 + -1
            goto L_0x0041
        L_0x003f:
            int r1 = r6.f13553a
        L_0x0041:
            r2 = r0 & 8
            if (r2 == 0) goto L_0x004a
            int r2 = r4.s()
            goto L_0x004c
        L_0x004a:
            int r2 = r6.f13554b
        L_0x004c:
            r3 = r0 & 16
            if (r3 == 0) goto L_0x0055
            int r3 = r4.s()
            goto L_0x0057
        L_0x0055:
            int r3 = r6.f13555c
        L_0x0057:
            r0 = r0 & 32
            if (r0 == 0) goto L_0x0060
            int r4 = r4.s()
            goto L_0x0062
        L_0x0060:
            int r4 = r6.f13556d
        L_0x0062:
            androidx.media3.extractor.mp4.TrackFragment r6 = r5.f13580b
            androidx.media3.extractor.mp4.DefaultSampleValues r0 = new androidx.media3.extractor.mp4.DefaultSampleValues
            r0.<init>(r1, r2, r3, r4)
            r6.f13675a = r0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.FragmentedMp4Extractor.I(androidx.media3.common.util.ParsableByteArray, android.util.SparseArray, boolean):androidx.media3.extractor.mp4.FragmentedMp4Extractor$TrackBundle");
    }

    private static void J(Atom.ContainerAtom containerAtom, SparseArray<TrackBundle> sparseArray, boolean z2, int i2, byte[] bArr) throws ParserException {
        TrackBundle I2 = I(((Atom.LeafAtom) Assertions.g(containerAtom.h(Atom.d0))).G1, sparseArray, z2);
        if (I2 != null) {
            TrackFragment trackFragment = I2.f13580b;
            long j2 = trackFragment.q;
            boolean z3 = trackFragment.r;
            I2.k();
            boolean unused = I2.f13590l = true;
            Atom.LeafAtom h2 = containerAtom.h(Atom.c0);
            if (h2 == null || (i2 & 2) != 0) {
                trackFragment.q = j2;
                trackFragment.r = z3;
            } else {
                trackFragment.q = H(h2.G1);
                trackFragment.r = true;
            }
            M(containerAtom, I2, i2);
            TrackEncryptionBox b2 = I2.f13582d.f13689a.b(((DefaultSampleValues) Assertions.g(trackFragment.f13675a)).f13553a);
            Atom.LeafAtom h3 = containerAtom.h(Atom.H0);
            if (h3 != null) {
                C((TrackEncryptionBox) Assertions.g(b2), h3.G1, trackFragment);
            }
            Atom.LeafAtom h4 = containerAtom.h(Atom.I0);
            if (h4 != null) {
                B(h4.G1, trackFragment);
            }
            Atom.LeafAtom h5 = containerAtom.h(Atom.M0);
            if (h5 != null) {
                F(h5.G1, trackFragment);
            }
            D(containerAtom, b2 != null ? b2.f13671b : null, trackFragment);
            int size = containerAtom.H1.size();
            for (int i3 = 0; i3 < size; i3++) {
                Atom.LeafAtom leafAtom = containerAtom.H1.get(i3);
                if (leafAtom.f13510a == 1970628964) {
                    N(leafAtom.G1, trackFragment, bArr);
                }
            }
        }
    }

    private static Pair<Integer, DefaultSampleValues> K(ParsableByteArray parsableByteArray) {
        parsableByteArray.Y(12);
        return Pair.create(Integer.valueOf(parsableByteArray.s()), new DefaultSampleValues(parsableByteArray.s() - 1, parsableByteArray.s(), parsableByteArray.s(), parsableByteArray.s()));
    }

    private static int L(TrackBundle trackBundle, int i2, int i3, ParsableByteArray parsableByteArray, int i4) throws ParserException {
        boolean z2;
        int i5;
        boolean z3;
        int i6;
        boolean z4;
        boolean z5;
        boolean z6;
        int i7;
        TrackBundle trackBundle2 = trackBundle;
        parsableByteArray.Y(8);
        int b2 = Atom.b(parsableByteArray.s());
        Track track = trackBundle2.f13582d.f13689a;
        TrackFragment trackFragment = trackBundle2.f13580b;
        DefaultSampleValues defaultSampleValues = (DefaultSampleValues) Util.o(trackFragment.f13675a);
        trackFragment.f13682h[i2] = parsableByteArray.P();
        long[] jArr = trackFragment.f13681g;
        long j2 = trackFragment.f13677c;
        jArr[i2] = j2;
        if ((b2 & 1) != 0) {
            jArr[i2] = j2 + ((long) parsableByteArray.s());
        }
        boolean z7 = (b2 & 4) != 0;
        int i8 = defaultSampleValues.f13556d;
        if (z7) {
            i8 = parsableByteArray.s();
        }
        boolean z8 = (b2 & 256) != 0;
        boolean z9 = (b2 & 512) != 0;
        boolean z10 = (b2 & 1024) != 0;
        boolean z11 = (b2 & 2048) != 0;
        long j3 = o(track) ? ((long[]) Util.o(track.f13666i))[0] : 0;
        int[] iArr = trackFragment.f13683i;
        long[] jArr2 = trackFragment.f13684j;
        boolean[] zArr = trackFragment.f13685k;
        int i9 = i8;
        boolean z12 = track.f13659b == 2 && (i3 & 1) != 0;
        int i10 = i4 + trackFragment.f13682h[i2];
        boolean z13 = z12;
        long[] jArr3 = jArr2;
        boolean[] zArr2 = zArr;
        long j4 = track.f13660c;
        long j5 = trackFragment.q;
        int i11 = i4;
        while (i11 < i10) {
            int g2 = g(z8 ? parsableByteArray.s() : defaultSampleValues.f13554b);
            if (z9) {
                i5 = parsableByteArray.s();
                z2 = z8;
            } else {
                z2 = z8;
                i5 = defaultSampleValues.f13555c;
            }
            int g3 = g(i5);
            if (z10) {
                z3 = z7;
                i6 = parsableByteArray.s();
            } else if (i11 != 0 || !z7) {
                z3 = z7;
                i6 = defaultSampleValues.f13556d;
            } else {
                z3 = z7;
                i6 = i9;
            }
            if (z11) {
                z6 = z11;
                z5 = z9;
                z4 = z10;
                i7 = parsableByteArray.s();
            } else {
                z6 = z11;
                z5 = z9;
                z4 = z10;
                i7 = 0;
            }
            long c2 = Util.c2((((long) i7) + j5) - j3, 1000000, j4);
            jArr3[i11] = c2;
            if (!trackFragment.r) {
                jArr3[i11] = c2 + trackBundle2.f13582d.f13696h;
            }
            iArr[i11] = g3;
            zArr2[i11] = ((i6 >> 16) & 1) == 0 && (!z13 || i11 == 0);
            j5 += (long) g2;
            i11++;
            trackBundle2 = trackBundle;
            z8 = z2;
            z7 = z3;
            z11 = z6;
            z9 = z5;
            z10 = z4;
        }
        trackFragment.q = j5;
        return i10;
    }

    private static void M(Atom.ContainerAtom containerAtom, TrackBundle trackBundle, int i2) throws ParserException {
        List<Atom.LeafAtom> list = containerAtom.H1;
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            Atom.LeafAtom leafAtom = list.get(i5);
            if (leafAtom.f13510a == 1953658222) {
                ParsableByteArray parsableByteArray = leafAtom.G1;
                parsableByteArray.Y(12);
                int P2 = parsableByteArray.P();
                if (P2 > 0) {
                    i4 += P2;
                    i3++;
                }
            }
        }
        trackBundle.f13586h = 0;
        trackBundle.f13585g = 0;
        trackBundle.f13584f = 0;
        trackBundle.f13580b.e(i3, i4);
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            Atom.LeafAtom leafAtom2 = list.get(i8);
            if (leafAtom2.f13510a == 1953658222) {
                i7 = L(trackBundle, i6, i2, leafAtom2.G1, i7);
                i6++;
            }
        }
    }

    private static void N(ParsableByteArray parsableByteArray, TrackFragment trackFragment, byte[] bArr) throws ParserException {
        parsableByteArray.Y(8);
        parsableByteArray.n(bArr, 0, 16);
        if (Arrays.equals(bArr, U)) {
            E(parsableByteArray, 16, trackFragment);
        }
    }

    private void O(long j2) throws ParserException {
        while (!this.q.isEmpty() && this.q.peek().G1 == j2) {
            t(this.q.pop());
        }
        j();
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0155  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean P(androidx.media3.extractor.ExtractorInput r12) throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11.w
            r1 = 8
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x002c
            androidx.media3.common.util.ParsableByteArray r0 = r11.p
            byte[] r0 = r0.e()
            boolean r0 = r12.d(r0, r2, r1, r3)
            if (r0 != 0) goto L_0x0015
            return r2
        L_0x0015:
            r11.w = r1
            androidx.media3.common.util.ParsableByteArray r0 = r11.p
            r0.Y(r2)
            androidx.media3.common.util.ParsableByteArray r0 = r11.p
            long r4 = r0.N()
            r11.v = r4
            androidx.media3.common.util.ParsableByteArray r0 = r11.p
            int r0 = r0.s()
            r11.u = r0
        L_0x002c:
            long r4 = r11.v
            r6 = 1
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x004b
            androidx.media3.common.util.ParsableByteArray r0 = r11.p
            byte[] r0 = r0.e()
            r12.readFully(r0, r1, r1)
            int r0 = r11.w
            int r0 = r0 + r1
            r11.w = r0
            androidx.media3.common.util.ParsableByteArray r0 = r11.p
            long r4 = r0.Q()
        L_0x0048:
            r11.v = r4
            goto L_0x007b
        L_0x004b:
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x007b
            long r4 = r12.getLength()
            r6 = -1
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x006d
            java.util.ArrayDeque<androidx.media3.extractor.mp4.Atom$ContainerAtom> r0 = r11.q
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x006d
            java.util.ArrayDeque<androidx.media3.extractor.mp4.Atom$ContainerAtom> r0 = r11.q
            java.lang.Object r0 = r0.peek()
            androidx.media3.extractor.mp4.Atom$ContainerAtom r0 = (androidx.media3.extractor.mp4.Atom.ContainerAtom) r0
            long r4 = r0.G1
        L_0x006d:
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x007b
            long r6 = r12.getPosition()
            long r4 = r4 - r6
            int r0 = r11.w
            long r6 = (long) r0
            long r4 = r4 + r6
            goto L_0x0048
        L_0x007b:
            long r4 = r11.v
            int r0 = r11.w
            long r6 = (long) r0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 < 0) goto L_0x0155
            long r4 = r12.getPosition()
            int r0 = r11.w
            long r6 = (long) r0
            long r4 = r4 - r6
            int r0 = r11.u
            r6 = 1835295092(0x6d646174, float:4.4175247E27)
            r7 = 1836019558(0x6d6f6f66, float:4.6313494E27)
            if (r0 == r7) goto L_0x0098
            if (r0 != r6) goto L_0x00aa
        L_0x0098:
            boolean r0 = r11.L
            if (r0 != 0) goto L_0x00aa
            androidx.media3.extractor.ExtractorOutput r0 = r11.I
            androidx.media3.extractor.SeekMap$Unseekable r8 = new androidx.media3.extractor.SeekMap$Unseekable
            long r9 = r11.B
            r8.<init>(r9, r4)
            r0.j(r8)
            r11.L = r3
        L_0x00aa:
            int r0 = r11.u
            if (r0 != r7) goto L_0x00ca
            android.util.SparseArray<androidx.media3.extractor.mp4.FragmentedMp4Extractor$TrackBundle> r0 = r11.f13568h
            int r0 = r0.size()
            r7 = 0
        L_0x00b5:
            if (r7 >= r0) goto L_0x00ca
            android.util.SparseArray<androidx.media3.extractor.mp4.FragmentedMp4Extractor$TrackBundle> r8 = r11.f13568h
            java.lang.Object r8 = r8.valueAt(r7)
            androidx.media3.extractor.mp4.FragmentedMp4Extractor$TrackBundle r8 = (androidx.media3.extractor.mp4.FragmentedMp4Extractor.TrackBundle) r8
            androidx.media3.extractor.mp4.TrackFragment r8 = r8.f13580b
            r8.f13676b = r4
            r8.f13678d = r4
            r8.f13677c = r4
            int r7 = r7 + 1
            goto L_0x00b5
        L_0x00ca:
            int r0 = r11.u
            r7 = 0
            if (r0 != r6) goto L_0x00da
            r11.D = r7
            long r0 = r11.v
            long r4 = r4 + r0
            r11.y = r4
            r12 = 2
            r11.t = r12
            return r3
        L_0x00da:
            boolean r0 = T(r0)
            if (r0 == 0) goto L_0x0107
            long r0 = r12.getPosition()
            long r4 = r11.v
            long r0 = r0 + r4
            r4 = 8
            long r0 = r0 - r4
            java.util.ArrayDeque<androidx.media3.extractor.mp4.Atom$ContainerAtom> r12 = r11.q
            androidx.media3.extractor.mp4.Atom$ContainerAtom r2 = new androidx.media3.extractor.mp4.Atom$ContainerAtom
            int r4 = r11.u
            r2.<init>(r4, r0)
            r12.push(r2)
            long r4 = r11.v
            int r12 = r11.w
            long r6 = (long) r12
            int r12 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r12 != 0) goto L_0x0103
            r11.O(r0)
            goto L_0x014d
        L_0x0103:
            r11.j()
            goto L_0x014d
        L_0x0107:
            int r12 = r11.u
            boolean r12 = U(r12)
            r4 = 2147483647(0x7fffffff, double:1.060997895E-314)
            if (r12 == 0) goto L_0x0144
            int r12 = r11.w
            if (r12 != r1) goto L_0x013d
            long r6 = r11.v
            int r12 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r12 > 0) goto L_0x0136
            androidx.media3.common.util.ParsableByteArray r12 = new androidx.media3.common.util.ParsableByteArray
            long r4 = r11.v
            int r0 = (int) r4
            r12.<init>((int) r0)
            androidx.media3.common.util.ParsableByteArray r0 = r11.p
            byte[] r0 = r0.e()
            byte[] r4 = r12.e()
            java.lang.System.arraycopy(r0, r2, r4, r2, r1)
            r11.x = r12
        L_0x0133:
            r11.t = r3
            goto L_0x014d
        L_0x0136:
            java.lang.String r12 = "Leaf atom with length > 2147483647 (unsupported)."
            androidx.media3.common.ParserException r12 = androidx.media3.common.ParserException.e(r12)
            throw r12
        L_0x013d:
            java.lang.String r12 = "Leaf atom defines extended atom size (unsupported)."
            androidx.media3.common.ParserException r12 = androidx.media3.common.ParserException.e(r12)
            throw r12
        L_0x0144:
            long r0 = r11.v
            int r12 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r12 > 0) goto L_0x014e
            r11.x = r7
            goto L_0x0133
        L_0x014d:
            return r3
        L_0x014e:
            java.lang.String r12 = "Skipping atom with length > 2147483647 (unsupported)."
            androidx.media3.common.ParserException r12 = androidx.media3.common.ParserException.e(r12)
            throw r12
        L_0x0155:
            java.lang.String r12 = "Atom size less than header length (unsupported)."
            androidx.media3.common.ParserException r12 = androidx.media3.common.ParserException.e(r12)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.FragmentedMp4Extractor.P(androidx.media3.extractor.ExtractorInput):boolean");
    }

    private void Q(ExtractorInput extractorInput) throws IOException {
        int i2 = ((int) this.v) - this.w;
        ParsableByteArray parsableByteArray = this.x;
        if (parsableByteArray != null) {
            extractorInput.readFully(parsableByteArray.e(), 8, i2);
            v(new Atom.LeafAtom(this.u, parsableByteArray), extractorInput.getPosition());
        } else {
            extractorInput.o(i2);
        }
        O(extractorInput.getPosition());
    }

    private void R(ExtractorInput extractorInput) throws IOException {
        int size = this.f13568h.size();
        long j2 = Long.MAX_VALUE;
        TrackBundle trackBundle = null;
        for (int i2 = 0; i2 < size; i2++) {
            TrackFragment trackFragment = this.f13568h.valueAt(i2).f13580b;
            if (trackFragment.p) {
                long j3 = trackFragment.f13678d;
                if (j3 < j2) {
                    trackBundle = this.f13568h.valueAt(i2);
                    j2 = j3;
                }
            }
        }
        if (trackBundle == null) {
            this.t = 3;
            return;
        }
        int position = (int) (j2 - extractorInput.getPosition());
        if (position >= 0) {
            extractorInput.o(position);
            trackBundle.f13580b.b(extractorInput);
            return;
        }
        throw ParserException.a("Offset to encryption data was negative.", (Throwable) null);
    }

    private boolean S(ExtractorInput extractorInput) throws IOException {
        int i2;
        int i3;
        ExtractorInput extractorInput2 = extractorInput;
        TrackBundle trackBundle = this.D;
        Throwable th = null;
        if (trackBundle == null) {
            trackBundle = m(this.f13568h);
            if (trackBundle == null) {
                int position = (int) (this.y - extractorInput.getPosition());
                if (position >= 0) {
                    extractorInput2.o(position);
                    j();
                    return false;
                }
                throw ParserException.a("Offset to end of mdat was negative.", (Throwable) null);
            }
            int d2 = (int) (trackBundle.d() - extractorInput.getPosition());
            if (d2 < 0) {
                Log.n(S, "Ignoring negative offset to sample data.");
                d2 = 0;
            }
            extractorInput2.o(d2);
            this.D = trackBundle;
        }
        int i4 = 4;
        int i5 = 1;
        if (this.t == 3) {
            int f2 = trackBundle.f();
            this.E = f2;
            if (trackBundle.f13584f < trackBundle.f13587i) {
                extractorInput2.o(f2);
                trackBundle.m();
                if (!trackBundle.h()) {
                    this.D = null;
                }
                this.t = 3;
                return true;
            }
            if (trackBundle.f13582d.f13689a.f13664g == 1) {
                this.E = f2 - 8;
                extractorInput2.o(8);
            }
            if (MimeTypes.T.equals(trackBundle.f13582d.f13689a.f13663f.f3)) {
                this.F = trackBundle.i(this.E, 7);
                Ac4Util.a(this.E, this.f13573m);
                trackBundle.f13579a.d(this.f13573m, 7);
                i3 = this.F + 7;
            } else {
                i3 = trackBundle.i(this.E, 0);
            }
            this.F = i3;
            this.E += this.F;
            this.t = 4;
            this.G = 0;
        }
        Track track = trackBundle.f13582d.f13689a;
        TrackOutput trackOutput = trackBundle.f13579a;
        long e2 = trackBundle.e();
        TimestampAdjuster timestampAdjuster = this.f13574n;
        if (timestampAdjuster != null) {
            e2 = timestampAdjuster.a(e2);
        }
        long j2 = e2;
        if (track.f13667j == 0) {
            while (true) {
                int i6 = this.F;
                int i7 = this.E;
                if (i6 >= i7) {
                    break;
                }
                this.F += trackOutput.b(extractorInput2, i7 - i6, false);
            }
        } else {
            byte[] e3 = this.f13570j.e();
            e3[0] = 0;
            e3[1] = 0;
            e3[2] = 0;
            int i8 = track.f13667j;
            int i9 = i8 + 1;
            int i10 = 4 - i8;
            while (this.F < this.E) {
                int i11 = this.G;
                if (i11 == 0) {
                    extractorInput2.readFully(e3, i10, i9);
                    this.f13570j.Y(0);
                    int s2 = this.f13570j.s();
                    if (s2 >= i5) {
                        this.G = s2 - 1;
                        this.f13569i.Y(0);
                        trackOutput.d(this.f13569i, i4);
                        trackOutput.d(this.f13570j, i5);
                        this.H = this.K.length > 0 && NalUnitUtil.g(track.f13663f.f3, e3[i4]);
                        this.F += 5;
                        this.E += i10;
                    } else {
                        throw ParserException.a("Invalid NAL length", th);
                    }
                } else {
                    if (this.H) {
                        this.f13571k.U(i11);
                        extractorInput2.readFully(this.f13571k.e(), 0, this.G);
                        trackOutput.d(this.f13571k, this.G);
                        i2 = this.G;
                        int q2 = NalUnitUtil.q(this.f13571k.e(), this.f13571k.g());
                        this.f13571k.Y(MimeTypes.f9236k.equals(track.f13663f.f3) ? 1 : 0);
                        this.f13571k.X(q2);
                        CeaUtil.a(j2, this.f13571k, this.K);
                    } else {
                        i2 = trackOutput.b(extractorInput2, i11, false);
                    }
                    this.F += i2;
                    this.G -= i2;
                    th = null;
                    i4 = 4;
                    i5 = 1;
                }
            }
        }
        int c2 = trackBundle.c();
        TrackEncryptionBox g2 = trackBundle.g();
        trackOutput.f(j2, c2, this.E, 0, g2 != null ? g2.f13672c : null);
        y(j2);
        if (!trackBundle.h()) {
            this.D = null;
        }
        this.t = 3;
        return true;
    }

    private static boolean T(int i2) {
        return i2 == 1836019574 || i2 == 1953653099 || i2 == 1835297121 || i2 == 1835626086 || i2 == 1937007212 || i2 == 1836019558 || i2 == 1953653094 || i2 == 1836475768 || i2 == 1701082227;
    }

    private static boolean U(int i2) {
        return i2 == 1751411826 || i2 == 1835296868 || i2 == 1836476516 || i2 == 1936286840 || i2 == 1937011556 || i2 == 1937011827 || i2 == 1668576371 || i2 == 1937011555 || i2 == 1937011578 || i2 == 1937013298 || i2 == 1937007471 || i2 == 1668232756 || i2 == 1937011571 || i2 == 1952867444 || i2 == 1952868452 || i2 == 1953196132 || i2 == 1953654136 || i2 == 1953658222 || i2 == 1886614376 || i2 == 1935763834 || i2 == 1935763823 || i2 == 1936027235 || i2 == 1970628964 || i2 == 1935828848 || i2 == 1936158820 || i2 == 1701606260 || i2 == 1835362404 || i2 == 1701671783;
    }

    private static int g(int i2) throws ParserException {
        if (i2 >= 0) {
            return i2;
        }
        throw ParserException.a("Unexpected negative value: " + i2, (Throwable) null);
    }

    private void j() {
        this.t = 0;
        this.w = 0;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.util.SparseArray, android.util.SparseArray<androidx.media3.extractor.mp4.DefaultSampleValues>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.media3.extractor.mp4.DefaultSampleValues k(android.util.SparseArray<androidx.media3.extractor.mp4.DefaultSampleValues> r3, int r4) {
        /*
            r2 = this;
            int r0 = r3.size()
            r1 = 1
            if (r0 != r1) goto L_0x000f
            r4 = 0
            java.lang.Object r3 = r3.valueAt(r4)
        L_0x000c:
            androidx.media3.extractor.mp4.DefaultSampleValues r3 = (androidx.media3.extractor.mp4.DefaultSampleValues) r3
            return r3
        L_0x000f:
            java.lang.Object r3 = r3.get(r4)
            androidx.media3.extractor.mp4.DefaultSampleValues r3 = (androidx.media3.extractor.mp4.DefaultSampleValues) r3
            java.lang.Object r3 = androidx.media3.common.util.Assertions.g(r3)
            goto L_0x000c
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.FragmentedMp4Extractor.k(android.util.SparseArray, int):androidx.media3.extractor.mp4.DefaultSampleValues");
    }

    @Nullable
    private static DrmInitData l(List<Atom.LeafAtom> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            Atom.LeafAtom leafAtom = list.get(i2);
            if (leafAtom.f13510a == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] e2 = leafAtom.G1.e();
                UUID f2 = PsshAtomUtil.f(e2);
                if (f2 == null) {
                    Log.n(S, "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(f2, MimeTypes.f9231f, e2));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData((List<DrmInitData.SchemeData>) arrayList);
    }

    @Nullable
    private static TrackBundle m(SparseArray<TrackBundle> sparseArray) {
        int size = sparseArray.size();
        TrackBundle trackBundle = null;
        long j2 = Long.MAX_VALUE;
        for (int i2 = 0; i2 < size; i2++) {
            TrackBundle valueAt = sparseArray.valueAt(i2);
            if ((valueAt.f13590l || valueAt.f13584f != valueAt.f13582d.f13690b) && (!valueAt.f13590l || valueAt.f13586h != valueAt.f13580b.f13679e)) {
                long d2 = valueAt.d();
                if (d2 < j2) {
                    trackBundle = valueAt;
                    j2 = d2;
                }
            }
        }
        return trackBundle;
    }

    private void n() {
        int i2;
        TrackOutput[] trackOutputArr = new TrackOutput[2];
        this.J = trackOutputArr;
        TrackOutput trackOutput = this.s;
        int i3 = 0;
        if (trackOutput != null) {
            trackOutputArr[0] = trackOutput;
            i2 = 1;
        } else {
            i2 = 0;
        }
        int i4 = 100;
        if ((this.f13565e & 4) != 0) {
            trackOutputArr[i2] = this.I.d(100, 5);
            i4 = 101;
            i2++;
        }
        TrackOutput[] trackOutputArr2 = (TrackOutput[]) Util.O1(this.J, i2);
        this.J = trackOutputArr2;
        for (TrackOutput e2 : trackOutputArr2) {
            e2.e(V);
        }
        this.K = new TrackOutput[this.f13567g.size()];
        while (i3 < this.K.length) {
            TrackOutput d2 = this.I.d(i4, 3);
            d2.e(this.f13567g.get(i3));
            this.K[i3] = d2;
            i3++;
            i4++;
        }
    }

    private static boolean o(Track track) {
        long[] jArr;
        long[] jArr2 = track.f13665h;
        if (jArr2 == null || jArr2.length != 1 || (jArr = track.f13666i) == null) {
            return false;
        }
        long j2 = jArr2[0];
        return j2 == 0 || Util.c2(j2 + jArr[0], 1000000, track.f13661d) >= track.f13662e;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] p(SubtitleParser.Factory factory) {
        return new Extractor[]{new FragmentedMp4Extractor(factory)};
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] q() {
        return new Extractor[]{new FragmentedMp4Extractor(SubtitleParser.Factory.f13783a, 32)};
    }

    public static ExtractorsFactory s(SubtitleParser.Factory factory) {
        return new c(factory);
    }

    private void t(Atom.ContainerAtom containerAtom) throws ParserException {
        int i2 = containerAtom.f13510a;
        if (i2 == 1836019574) {
            x(containerAtom);
        } else if (i2 == 1836019558) {
            w(containerAtom);
        } else if (!this.q.isEmpty()) {
            this.q.peek().d(containerAtom);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void u(androidx.media3.common.util.ParsableByteArray r28) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            androidx.media3.extractor.TrackOutput[] r2 = r0.J
            int r2 = r2.length
            if (r2 != 0) goto L_0x000a
            return
        L_0x000a:
            r2 = 8
            r1.Y(r2)
            int r2 = r28.s()
            int r2 = androidx.media3.extractor.mp4.Atom.c(r2)
            r3 = 1
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r2 == 0) goto L_0x0074
            if (r2 == r3) goto L_0x0038
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Skipping unsupported emsg version: "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "FragmentedMp4Extractor"
            androidx.media3.common.util.Log.n(r2, r1)
            return
        L_0x0038:
            long r12 = r28.N()
            long r6 = r28.Q()
            r8 = 1000000(0xf4240, double:4.940656E-318)
            r10 = r12
            long r14 = androidx.media3.common.util.Util.c2(r6, r8, r10)
            long r6 = r28.N()
            r8 = 1000(0x3e8, double:4.94E-321)
            long r6 = androidx.media3.common.util.Util.c2(r6, r8, r10)
            long r8 = r28.N()
            java.lang.String r2 = r28.F()
            java.lang.Object r2 = androidx.media3.common.util.Assertions.g(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r10 = r28.F()
            java.lang.Object r10 = androidx.media3.common.util.Assertions.g(r10)
            java.lang.String r10 = (java.lang.String) r10
            r20 = r2
            r22 = r6
            r24 = r8
            r21 = r10
            r8 = r4
            goto L_0x00be
        L_0x0074:
            java.lang.String r2 = r28.F()
            java.lang.Object r2 = androidx.media3.common.util.Assertions.g(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r6 = r28.F()
            java.lang.Object r6 = androidx.media3.common.util.Assertions.g(r6)
            r10 = r6
            java.lang.String r10 = (java.lang.String) r10
            long r6 = r28.N()
            long r11 = r28.N()
            r13 = 1000000(0xf4240, double:4.940656E-318)
            r15 = r6
            long r8 = androidx.media3.common.util.Util.c2(r11, r13, r15)
            long r11 = r0.C
            int r13 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x00a3
            long r11 = r11 + r8
            r17 = r11
            goto L_0x00a5
        L_0x00a3:
            r17 = r4
        L_0x00a5:
            long r11 = r28.N()
            r13 = 1000(0x3e8, double:4.94E-321)
            r15 = r6
            long r6 = androidx.media3.common.util.Util.c2(r11, r13, r15)
            long r11 = r28.N()
            r20 = r2
            r22 = r6
            r21 = r10
            r24 = r11
            r14 = r17
        L_0x00be:
            int r2 = r28.a()
            byte[] r2 = new byte[r2]
            int r6 = r28.a()
            r7 = 0
            r1.n(r2, r7, r6)
            androidx.media3.extractor.metadata.emsg.EventMessage r1 = new androidx.media3.extractor.metadata.emsg.EventMessage
            r19 = r1
            r26 = r2
            r19.<init>(r20, r21, r22, r24, r26)
            androidx.media3.common.util.ParsableByteArray r2 = new androidx.media3.common.util.ParsableByteArray
            androidx.media3.extractor.metadata.emsg.EventMessageEncoder r6 = r0.o
            byte[] r1 = r6.a(r1)
            r2.<init>((byte[]) r1)
            int r1 = r2.a()
            androidx.media3.extractor.TrackOutput[] r6 = r0.J
            int r10 = r6.length
            r11 = 0
        L_0x00e8:
            if (r11 >= r10) goto L_0x00f5
            r12 = r6[r11]
            r2.Y(r7)
            r12.d(r2, r1)
            int r11 = r11 + 1
            goto L_0x00e8
        L_0x00f5:
            int r2 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x0109
            java.util.ArrayDeque<androidx.media3.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo> r2 = r0.r
            androidx.media3.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo r4 = new androidx.media3.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo
            r4.<init>(r8, r3, r1)
            r2.addLast(r4)
        L_0x0103:
            int r2 = r0.z
            int r2 = r2 + r1
            r0.z = r2
            goto L_0x014d
        L_0x0109:
            java.util.ArrayDeque<androidx.media3.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo> r2 = r0.r
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x011c
            java.util.ArrayDeque<androidx.media3.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo> r2 = r0.r
            androidx.media3.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo r3 = new androidx.media3.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo
            r3.<init>(r14, r7, r1)
        L_0x0118:
            r2.addLast(r3)
            goto L_0x0103
        L_0x011c:
            androidx.media3.common.util.TimestampAdjuster r2 = r0.f13574n
            if (r2 == 0) goto L_0x012e
            boolean r2 = r2.g()
            if (r2 != 0) goto L_0x012e
            java.util.ArrayDeque<androidx.media3.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo> r2 = r0.r
            androidx.media3.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo r3 = new androidx.media3.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo
            r3.<init>(r14, r7, r1)
            goto L_0x0118
        L_0x012e:
            androidx.media3.common.util.TimestampAdjuster r2 = r0.f13574n
            if (r2 == 0) goto L_0x0136
            long r14 = r2.a(r14)
        L_0x0136:
            androidx.media3.extractor.TrackOutput[] r2 = r0.J
            int r3 = r2.length
        L_0x0139:
            if (r7 >= r3) goto L_0x014d
            r16 = r2[r7]
            r21 = 0
            r22 = 0
            r19 = 1
            r17 = r14
            r20 = r1
            r16.f(r17, r19, r20, r21, r22)
            int r7 = r7 + 1
            goto L_0x0139
        L_0x014d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.FragmentedMp4Extractor.u(androidx.media3.common.util.ParsableByteArray):void");
    }

    private void v(Atom.LeafAtom leafAtom, long j2) throws ParserException {
        if (!this.q.isEmpty()) {
            this.q.peek().e(leafAtom);
            return;
        }
        int i2 = leafAtom.f13510a;
        if (i2 == 1936286840) {
            Pair<Long, ChunkIndex> G2 = G(leafAtom.G1, j2);
            this.C = ((Long) G2.first).longValue();
            this.I.j((SeekMap) G2.second);
            this.L = true;
        } else if (i2 == 1701671783) {
            u(leafAtom.G1);
        }
    }

    private void w(Atom.ContainerAtom containerAtom) throws ParserException {
        A(containerAtom, this.f13568h, this.f13566f != null, this.f13565e, this.f13572l);
        DrmInitData l2 = l(containerAtom.H1);
        if (l2 != null) {
            int size = this.f13568h.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f13568h.valueAt(i2).n(l2);
            }
        }
        if (this.A != C.f9084b) {
            int size2 = this.f13568h.size();
            for (int i3 = 0; i3 < size2; i3++) {
                this.f13568h.valueAt(i3).l(this.A);
            }
            this.A = C.f9084b;
        }
    }

    private void x(Atom.ContainerAtom containerAtom) throws ParserException {
        int i2 = 0;
        boolean z2 = true;
        Assertions.j(this.f13566f == null, "Unexpected moov box.");
        DrmInitData l2 = l(containerAtom.H1);
        Atom.ContainerAtom containerAtom2 = (Atom.ContainerAtom) Assertions.g(containerAtom.g(Atom.r0));
        SparseArray sparseArray = new SparseArray();
        int size = containerAtom2.H1.size();
        long j2 = -9223372036854775807L;
        for (int i3 = 0; i3 < size; i3++) {
            Atom.LeafAtom leafAtom = containerAtom2.H1.get(i3);
            int i4 = leafAtom.f13510a;
            if (i4 == 1953654136) {
                Pair<Integer, DefaultSampleValues> K2 = K(leafAtom.G1);
                sparseArray.put(((Integer) K2.first).intValue(), (DefaultSampleValues) K2.second);
            } else if (i4 == 1835362404) {
                j2 = z(leafAtom.G1);
            }
        }
        List<TrackSampleTable> B2 = AtomParsers.B(containerAtom, new GaplessInfoHolder(), j2, l2, (this.f13565e & 16) != 0, false, new b(this));
        int size2 = B2.size();
        if (this.f13568h.size() == 0) {
            while (i2 < size2) {
                TrackSampleTable trackSampleTable = B2.get(i2);
                Track track = trackSampleTable.f13689a;
                this.f13568h.put(track.f13658a, new TrackBundle(this.I.d(i2, track.f13659b), trackSampleTable, k(sparseArray, track.f13658a)));
                this.B = Math.max(this.B, track.f13662e);
                i2++;
            }
            this.I.o();
            return;
        }
        if (this.f13568h.size() != size2) {
            z2 = false;
        }
        Assertions.i(z2);
        while (i2 < size2) {
            TrackSampleTable trackSampleTable2 = B2.get(i2);
            Track track2 = trackSampleTable2.f13689a;
            this.f13568h.get(track2.f13658a).j(trackSampleTable2, k(sparseArray, track2.f13658a));
            i2++;
        }
    }

    private void y(long j2) {
        while (!this.r.isEmpty()) {
            MetadataSampleInfo removeFirst = this.r.removeFirst();
            this.z -= removeFirst.f13577c;
            long j3 = removeFirst.f13575a;
            if (removeFirst.f13576b) {
                j3 += j2;
            }
            TimestampAdjuster timestampAdjuster = this.f13574n;
            if (timestampAdjuster != null) {
                j3 = timestampAdjuster.a(j3);
            }
            for (TrackOutput f2 : this.J) {
                f2.f(j3, 1, removeFirst.f13577c, this.z, (TrackOutput.CryptoData) null);
            }
        }
    }

    private static long z(ParsableByteArray parsableByteArray) {
        parsableByteArray.Y(8);
        return Atom.c(parsableByteArray.s()) == 0 ? parsableByteArray.N() : parsableByteArray.Q();
    }

    public void a() {
    }

    public void c(long j2, long j3) {
        int size = this.f13568h.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f13568h.valueAt(i2).k();
        }
        this.r.clear();
        this.z = 0;
        this.A = j3;
        this.q.clear();
        j();
    }

    public void d(ExtractorOutput extractorOutput) {
        this.I = (this.f13565e & 32) == 0 ? new SubtitleTranscodingExtractorOutput(extractorOutput, this.f13564d) : extractorOutput;
        j();
        n();
        Track track = this.f13566f;
        if (track != null) {
            this.f13568h.put(0, new TrackBundle(extractorOutput.d(0, track.f13659b), new TrackSampleTable(this.f13566f, new long[0], new int[0], 0, new long[0], new int[0], 0), new DefaultSampleValues(0, 0, 0, 0)));
            this.I.o();
        }
    }

    public /* synthetic */ Extractor e() {
        return d.a(this);
    }

    public boolean h(ExtractorInput extractorInput) throws IOException {
        return Sniffer.b(extractorInput);
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        while (true) {
            int i2 = this.t;
            if (i2 != 0) {
                if (i2 == 1) {
                    Q(extractorInput);
                } else if (i2 == 2) {
                    R(extractorInput);
                } else if (S(extractorInput)) {
                    return 0;
                }
            } else if (!P(extractorInput)) {
                return -1;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Track r(@Nullable Track track) {
        return track;
    }

    @Deprecated
    public FragmentedMp4Extractor(int i2) {
        this(SubtitleParser.Factory.f13783a, i2 | 32, (TimestampAdjuster) null, (Track) null, ImmutableList.I(), (TrackOutput) null);
    }

    @Deprecated
    public FragmentedMp4Extractor(int i2, @Nullable TimestampAdjuster timestampAdjuster) {
        this(SubtitleParser.Factory.f13783a, i2 | 32, timestampAdjuster, (Track) null, ImmutableList.I(), (TrackOutput) null);
    }

    @Deprecated
    public FragmentedMp4Extractor(int i2, @Nullable TimestampAdjuster timestampAdjuster, @Nullable Track track) {
        this(SubtitleParser.Factory.f13783a, i2 | 32, timestampAdjuster, track, ImmutableList.I(), (TrackOutput) null);
    }

    @Deprecated
    public FragmentedMp4Extractor(int i2, @Nullable TimestampAdjuster timestampAdjuster, @Nullable Track track, List<Format> list) {
        this(SubtitleParser.Factory.f13783a, i2 | 32, timestampAdjuster, track, list, (TrackOutput) null);
    }

    @Deprecated
    public FragmentedMp4Extractor(int i2, @Nullable TimestampAdjuster timestampAdjuster, @Nullable Track track, List<Format> list, @Nullable TrackOutput trackOutput) {
        this(SubtitleParser.Factory.f13783a, i2 | 32, timestampAdjuster, track, list, trackOutput);
    }

    public FragmentedMp4Extractor(SubtitleParser.Factory factory) {
        this(factory, 0, (TimestampAdjuster) null, (Track) null, ImmutableList.I(), (TrackOutput) null);
    }

    public FragmentedMp4Extractor(SubtitleParser.Factory factory, int i2) {
        this(factory, i2, (TimestampAdjuster) null, (Track) null, ImmutableList.I(), (TrackOutput) null);
    }

    public FragmentedMp4Extractor(SubtitleParser.Factory factory, int i2, @Nullable TimestampAdjuster timestampAdjuster, @Nullable Track track, List<Format> list, @Nullable TrackOutput trackOutput) {
        this.f13564d = factory;
        this.f13565e = i2;
        this.f13574n = timestampAdjuster;
        this.f13566f = track;
        this.f13567g = Collections.unmodifiableList(list);
        this.s = trackOutput;
        this.o = new EventMessageEncoder();
        this.p = new ParsableByteArray(16);
        this.f13569i = new ParsableByteArray(NalUnitUtil.f9675j);
        this.f13570j = new ParsableByteArray(5);
        this.f13571k = new ParsableByteArray();
        byte[] bArr = new byte[16];
        this.f13572l = bArr;
        this.f13573m = new ParsableByteArray(bArr);
        this.q = new ArrayDeque<>();
        this.r = new ArrayDeque<>();
        this.f13568h = new SparseArray<>();
        this.B = C.f9084b;
        this.A = C.f9084b;
        this.C = C.f9084b;
        this.I = ExtractorOutput.b0;
        this.J = new TrackOutput[0];
        this.K = new TrackOutput[0];
    }
}
