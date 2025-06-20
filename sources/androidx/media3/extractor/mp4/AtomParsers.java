package androidx.media3.extractor.mp4;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.Mp4LocationData;
import androidx.media3.container.Mp4TimestampData;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.Ac3Util;
import androidx.media3.extractor.Ac4Util;
import androidx.media3.extractor.ExtractorUtil;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.OpusUtil;
import androidx.media3.extractor.VorbisUtil;
import androidx.media3.extractor.mp4.Atom;
import androidx.media3.extractor.ts.PsExtractor;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import net.imedicaldoctor.imd.BuildConfig;

final class AtomParsers {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13511a = "AtomParsers";

    /* renamed from: b  reason: collision with root package name */
    private static final int f13512b = 1668047728;

    /* renamed from: c  reason: collision with root package name */
    private static final int f13513c = 1835299937;

    /* renamed from: d  reason: collision with root package name */
    private static final int f13514d = 1835365473;

    /* renamed from: e  reason: collision with root package name */
    private static final int f13515e = 1852009571;

    /* renamed from: f  reason: collision with root package name */
    private static final int f13516f = 1852009592;

    /* renamed from: g  reason: collision with root package name */
    private static final int f13517g = 1935832172;

    /* renamed from: h  reason: collision with root package name */
    private static final int f13518h = 1936684398;

    /* renamed from: i  reason: collision with root package name */
    private static final int f13519i = 1937072756;

    /* renamed from: j  reason: collision with root package name */
    private static final int f13520j = 1952807028;

    /* renamed from: k  reason: collision with root package name */
    private static final int f13521k = 1986618469;

    /* renamed from: l  reason: collision with root package name */
    private static final int f13522l = 4;

    /* renamed from: m  reason: collision with root package name */
    private static final byte[] f13523m = Util.R0("OpusHead");

    private static final class ChunkIterator {

        /* renamed from: a  reason: collision with root package name */
        public final int f13524a;

        /* renamed from: b  reason: collision with root package name */
        public int f13525b;

        /* renamed from: c  reason: collision with root package name */
        public int f13526c;

        /* renamed from: d  reason: collision with root package name */
        public long f13527d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f13528e;

        /* renamed from: f  reason: collision with root package name */
        private final ParsableByteArray f13529f;

        /* renamed from: g  reason: collision with root package name */
        private final ParsableByteArray f13530g;

        /* renamed from: h  reason: collision with root package name */
        private int f13531h;

        /* renamed from: i  reason: collision with root package name */
        private int f13532i;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z) throws ParserException {
            this.f13530g = parsableByteArray;
            this.f13529f = parsableByteArray2;
            this.f13528e = z;
            parsableByteArray2.Y(12);
            this.f13524a = parsableByteArray2.P();
            parsableByteArray.Y(12);
            this.f13532i = parsableByteArray.P();
            ExtractorUtil.a(parsableByteArray.s() != 1 ? false : true, "first_chunk must be 1");
            this.f13525b = -1;
        }

        public boolean a() {
            int i2 = this.f13525b + 1;
            this.f13525b = i2;
            if (i2 == this.f13524a) {
                return false;
            }
            this.f13527d = this.f13528e ? this.f13529f.Q() : this.f13529f.N();
            if (this.f13525b == this.f13531h) {
                this.f13526c = this.f13530g.P();
                this.f13530g.Z(4);
                int i3 = this.f13532i - 1;
                this.f13532i = i3;
                this.f13531h = i3 > 0 ? this.f13530g.P() - 1 : -1;
            }
            return true;
        }
    }

    private static final class EsdsData {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f13533a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f13534b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final long f13535c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final long f13536d;

        public EsdsData(String str, byte[] bArr, long j2, long j3) {
            this.f13533a = str;
            this.f13534b = bArr;
            this.f13535c = j2;
            this.f13536d = j3;
        }
    }

    private interface SampleSizeBox {
        int a();

        int b();

        int c();
    }

    private static final class StsdData {

        /* renamed from: e  reason: collision with root package name */
        public static final int f13537e = 8;

        /* renamed from: a  reason: collision with root package name */
        public final TrackEncryptionBox[] f13538a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public Format f13539b;

        /* renamed from: c  reason: collision with root package name */
        public int f13540c;

        /* renamed from: d  reason: collision with root package name */
        public int f13541d = 0;

        public StsdData(int i2) {
            this.f13538a = new TrackEncryptionBox[i2];
        }
    }

    static final class StszSampleSizeBox implements SampleSizeBox {

        /* renamed from: a  reason: collision with root package name */
        private final int f13542a;

        /* renamed from: b  reason: collision with root package name */
        private final int f13543b;

        /* renamed from: c  reason: collision with root package name */
        private final ParsableByteArray f13544c;

        public StszSampleSizeBox(Atom.LeafAtom leafAtom, Format format) {
            ParsableByteArray parsableByteArray = leafAtom.G1;
            this.f13544c = parsableByteArray;
            parsableByteArray.Y(12);
            int P = parsableByteArray.P();
            if (MimeTypes.N.equals(format.f3)) {
                int F0 = Util.F0(format.u3, format.s3);
                if (P == 0 || P % F0 != 0) {
                    Log.n(AtomParsers.f13511a, "Audio sample size mismatch. stsd sample size: " + F0 + ", stsz sample size: " + P);
                    P = F0;
                }
            }
            this.f13542a = P == 0 ? -1 : P;
            this.f13543b = parsableByteArray.P();
        }

        public int a() {
            return this.f13542a;
        }

        public int b() {
            return this.f13543b;
        }

        public int c() {
            int i2 = this.f13542a;
            return i2 == -1 ? this.f13544c.P() : i2;
        }
    }

    static final class Stz2SampleSizeBox implements SampleSizeBox {

        /* renamed from: a  reason: collision with root package name */
        private final ParsableByteArray f13545a;

        /* renamed from: b  reason: collision with root package name */
        private final int f13546b;

        /* renamed from: c  reason: collision with root package name */
        private final int f13547c;

        /* renamed from: d  reason: collision with root package name */
        private int f13548d;

        /* renamed from: e  reason: collision with root package name */
        private int f13549e;

        public Stz2SampleSizeBox(Atom.LeafAtom leafAtom) {
            ParsableByteArray parsableByteArray = leafAtom.G1;
            this.f13545a = parsableByteArray;
            parsableByteArray.Y(12);
            this.f13547c = parsableByteArray.P() & 255;
            this.f13546b = parsableByteArray.P();
        }

        public int a() {
            return -1;
        }

        public int b() {
            return this.f13546b;
        }

        public int c() {
            int i2 = this.f13547c;
            if (i2 == 8) {
                return this.f13545a.L();
            }
            if (i2 == 16) {
                return this.f13545a.R();
            }
            int i3 = this.f13548d;
            this.f13548d = i3 + 1;
            if (i3 % 2 != 0) {
                return this.f13549e & 15;
            }
            int L = this.f13545a.L();
            this.f13549e = L;
            return (L & PsExtractor.A) >> 4;
        }
    }

    private static final class TkhdData {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f13550a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long f13551b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final int f13552c;

        public TkhdData(int i2, long j2, int i3) {
            this.f13550a = i2;
            this.f13551b = j2;
            this.f13552c = i3;
        }
    }

    private AtomParsers() {
    }

    @Nullable
    private static Track A(Atom.ContainerAtom containerAtom, Atom.LeafAtom leafAtom, long j2, @Nullable DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        long j3;
        Atom.LeafAtom leafAtom2;
        long[] jArr;
        long[] jArr2;
        Atom.ContainerAtom g2;
        Pair<long[], long[]> j4;
        Atom.ContainerAtom containerAtom2 = containerAtom;
        Atom.ContainerAtom containerAtom3 = (Atom.ContainerAtom) Assertions.g(containerAtom2.g(Atom.l0));
        int e2 = e(m(((Atom.LeafAtom) Assertions.g(containerAtom3.h(Atom.x0))).G1));
        if (e2 == -1) {
            return null;
        }
        TkhdData z3 = z(((Atom.LeafAtom) Assertions.g(containerAtom2.h(Atom.t0))).G1);
        long j5 = C.f9084b;
        if (j2 == C.f9084b) {
            leafAtom2 = leafAtom;
            j3 = z3.f13551b;
        } else {
            leafAtom2 = leafAtom;
            j3 = j2;
        }
        long j6 = r(leafAtom2.G1).Y;
        if (j3 != C.f9084b) {
            j5 = Util.c2(j3, 1000000, j6);
        }
        long j7 = j5;
        Pair<Long, String> o = o(((Atom.LeafAtom) Assertions.g(containerAtom3.h(Atom.w0))).G1);
        Atom.LeafAtom h2 = ((Atom.ContainerAtom) Assertions.g(((Atom.ContainerAtom) Assertions.g(containerAtom3.g(Atom.m0))).g(Atom.n0))).h(Atom.y0);
        if (h2 != null) {
            StsdData x = x(h2.G1, z3.f13550a, z3.f13552c, (String) o.second, drmInitData, z2);
            if (z || (g2 = containerAtom2.g(Atom.u0)) == null || (j4 = j(g2)) == null) {
                jArr2 = null;
                jArr = null;
            } else {
                jArr = (long[]) j4.second;
                jArr2 = (long[]) j4.first;
            }
            if (x.f13539b == null) {
                return null;
            }
            return new Track(z3.f13550a, e2, ((Long) o.first).longValue(), j6, j7, x.f13539b, x.f13541d, x.f13538a, x.f13540c, jArr2, jArr);
        }
        throw ParserException.a("Malformed sample table (stbl) missing sample description (stsd)", (Throwable) null);
    }

    public static List<TrackSampleTable> B(Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder, long j2, @Nullable DrmInitData drmInitData, boolean z, boolean z2, Function<Track, Track> function) throws ParserException {
        Atom.ContainerAtom containerAtom2 = containerAtom;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < containerAtom2.I1.size(); i2++) {
            Atom.ContainerAtom containerAtom3 = containerAtom2.I1.get(i2);
            if (containerAtom3.f13510a != 1953653099) {
                GaplessInfoHolder gaplessInfoHolder2 = gaplessInfoHolder;
                Function<Track, Track> function2 = function;
            } else {
                Track apply = function.apply(A(containerAtom3, (Atom.LeafAtom) Assertions.g(containerAtom.h(Atom.j0)), j2, drmInitData, z, z2));
                if (apply == null) {
                    GaplessInfoHolder gaplessInfoHolder3 = gaplessInfoHolder;
                } else {
                    GaplessInfoHolder gaplessInfoHolder4 = gaplessInfoHolder;
                    arrayList.add(w(apply, (Atom.ContainerAtom) Assertions.g(((Atom.ContainerAtom) Assertions.g(((Atom.ContainerAtom) Assertions.g(containerAtom3.g(Atom.l0))).g(Atom.m0))).g(Atom.n0)), gaplessInfoHolder));
                }
            }
        }
        return arrayList;
    }

    public static Metadata C(Atom.LeafAtom leafAtom) {
        Metadata F;
        ParsableByteArray parsableByteArray = leafAtom.G1;
        parsableByteArray.Y(8);
        Metadata metadata = new Metadata(new Metadata.Entry[0]);
        while (parsableByteArray.a() >= 8) {
            int f2 = parsableByteArray.f();
            int s = parsableByteArray.s();
            int s2 = parsableByteArray.s();
            if (s2 == 1835365473) {
                parsableByteArray.Y(f2);
                F = D(parsableByteArray, f2 + s);
            } else if (s2 == 1936553057) {
                parsableByteArray.Y(f2);
                F = SmtaAtomUtil.b(parsableByteArray, f2 + s);
            } else if (s2 == -1451722374) {
                F = F(parsableByteArray);
            } else {
                parsableByteArray.Y(f2 + s);
            }
            metadata = metadata.b(F);
            parsableByteArray.Y(f2 + s);
        }
        return metadata;
    }

    @Nullable
    private static Metadata D(ParsableByteArray parsableByteArray, int i2) {
        parsableByteArray.Z(8);
        f(parsableByteArray);
        while (parsableByteArray.f() < i2) {
            int f2 = parsableByteArray.f();
            int s = parsableByteArray.s();
            if (parsableByteArray.s() == 1768715124) {
                parsableByteArray.Y(f2);
                return n(parsableByteArray, f2 + s);
            }
            parsableByteArray.Y(f2 + s);
        }
        return null;
    }

    /* JADX WARNING: type inference failed for: r2v34, types: [java.util.List<byte[]>] */
    /* JADX WARNING: type inference failed for: r8v20, types: [java.util.List<byte[]>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void E(androidx.media3.common.util.ParsableByteArray r37, int r38, int r39, int r40, int r41, int r42, @androidx.annotation.Nullable androidx.media3.common.DrmInitData r43, androidx.media3.extractor.mp4.AtomParsers.StsdData r44, int r45) throws androidx.media3.common.ParserException {
        /*
            r0 = r37
            r1 = r39
            r2 = r40
            r3 = r43
            r4 = r44
            int r5 = r1 + 16
            r0.Y(r5)
            r5 = 16
            r0.Z(r5)
            int r5 = r37.R()
            int r6 = r37.R()
            r7 = 50
            r0.Z(r7)
            int r7 = r37.f()
            r8 = 1701733238(0x656e6376, float:7.035987E22)
            r10 = r38
            if (r10 != r8) goto L_0x0053
            android.util.Pair r8 = u(r0, r1, r2)
            if (r8 == 0) goto L_0x0050
            java.lang.Object r10 = r8.first
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            if (r3 != 0) goto L_0x003e
            r3 = 0
            goto L_0x0048
        L_0x003e:
            java.lang.Object r11 = r8.second
            androidx.media3.extractor.mp4.TrackEncryptionBox r11 = (androidx.media3.extractor.mp4.TrackEncryptionBox) r11
            java.lang.String r11 = r11.f13671b
            androidx.media3.common.DrmInitData r3 = r3.c(r11)
        L_0x0048:
            androidx.media3.extractor.mp4.TrackEncryptionBox[] r11 = r4.f13538a
            java.lang.Object r8 = r8.second
            androidx.media3.extractor.mp4.TrackEncryptionBox r8 = (androidx.media3.extractor.mp4.TrackEncryptionBox) r8
            r11[r45] = r8
        L_0x0050:
            r0.Y(r7)
        L_0x0053:
            r8 = 1831958048(0x6d317620, float:3.4326032E27)
            java.lang.String r11 = "video/3gpp"
            if (r10 != r8) goto L_0x005d
            java.lang.String r8 = "video/mpeg"
            goto L_0x0065
        L_0x005d:
            r8 = 1211250227(0x48323633, float:182488.8)
            if (r10 != r8) goto L_0x0064
            r8 = r11
            goto L_0x0065
        L_0x0064:
            r8 = 0
        L_0x0065:
            r14 = 1065353216(0x3f800000, float:1.0)
            r15 = 8
            r13 = 8
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = -1
            r20 = -1
            r21 = -1
            r22 = -1
            r23 = 0
            r24 = 0
            r25 = 0
        L_0x007f:
            int r12 = r7 - r1
            if (r12 >= r2) goto L_0x009a
            r0.Y(r7)
            int r12 = r37.f()
            int r9 = r37.s()
            if (r9 != 0) goto L_0x00a9
            int r26 = r37.f()
            r45 = r11
            int r11 = r26 - r1
            if (r11 != r2) goto L_0x00ab
        L_0x009a:
            r30 = r3
            r28 = r13
            r35 = r14
            r29 = r15
            r1 = r20
            r4 = r22
            r2 = 0
            goto L_0x0395
        L_0x00a9:
            r45 = r11
        L_0x00ab:
            if (r9 <= 0) goto L_0x00af
            r11 = 1
            goto L_0x00b0
        L_0x00af:
            r11 = 0
        L_0x00b0:
            java.lang.String r1 = "childAtomSize must be positive"
            androidx.media3.extractor.ExtractorUtil.a(r11, r1)
            int r1 = r37.s()
            r11 = 1635148611(0x61766343, float:2.8406573E20)
            if (r1 != r11) goto L_0x0100
            r1 = 0
            if (r8 != 0) goto L_0x00c3
            r11 = 1
            goto L_0x00c4
        L_0x00c3:
            r11 = 0
        L_0x00c4:
            androidx.media3.extractor.ExtractorUtil.a(r11, r1)
            int r12 = r12 + 8
            r0.Y(r12)
            androidx.media3.extractor.AvcConfig r1 = androidx.media3.extractor.AvcConfig.b(r37)
            java.util.List<byte[]> r8 = r1.f12924a
            int r11 = r1.f12925b
            r4.f13540c = r11
            if (r25 != 0) goto L_0x00da
            float r14 = r1.f12933j
        L_0x00da:
            java.lang.String r11 = r1.f12934k
            int r12 = r1.f12930g
            int r13 = r1.f12931h
            int r15 = r1.f12932i
            int r2 = r1.f12928e
            int r1 = r1.f12929f
            java.lang.String r16 = "video/avc"
            r30 = r3
            r27 = r10
            r17 = r11
            r20 = r12
            r21 = r13
            r22 = r15
            r3 = -1
            r13 = r1
            r15 = r2
            r2 = 0
            r36 = r16
            r16 = r8
        L_0x00fc:
            r8 = r36
            goto L_0x0386
        L_0x0100:
            r2 = 1752589123(0x68766343, float:4.6541328E24)
            if (r1 != r2) goto L_0x0144
            r1 = 0
            if (r8 != 0) goto L_0x010a
            r11 = 1
            goto L_0x010b
        L_0x010a:
            r11 = 0
        L_0x010b:
            androidx.media3.extractor.ExtractorUtil.a(r11, r1)
            int r12 = r12 + 8
            r0.Y(r12)
            androidx.media3.extractor.HevcConfig r1 = androidx.media3.extractor.HevcConfig.a(r37)
            java.util.List<byte[]> r2 = r1.f13071a
            int r8 = r1.f13072b
            r4.f13540c = r8
            if (r25 != 0) goto L_0x0121
            float r14 = r1.f13080j
        L_0x0121:
            java.lang.String r8 = r1.f13081k
            int r11 = r1.f13077g
            int r12 = r1.f13078h
            int r13 = r1.f13079i
            int r15 = r1.f13075e
            int r1 = r1.f13076f
            java.lang.String r16 = "video/hevc"
            r30 = r3
            r17 = r8
            r27 = r10
            r20 = r11
            r21 = r12
            r22 = r13
            r8 = r16
            r3 = -1
            r13 = r1
            r16 = r2
            r2 = 0
            goto L_0x0386
        L_0x0144:
            r2 = 1685480259(0x64766343, float:1.8180206E22)
            if (r1 == r2) goto L_0x014e
            r2 = 1685485123(0x64767643, float:1.8185683E22)
            if (r1 != r2) goto L_0x0160
        L_0x014e:
            r30 = r3
            r27 = r10
            r28 = r13
            r35 = r14
            r29 = r15
            r1 = r20
            r4 = r22
            r2 = 0
            r3 = -1
            goto L_0x0378
        L_0x0160:
            r2 = 1987076931(0x76706343, float:1.21891066E33)
            r11 = 2
            if (r1 != r2) goto L_0x01b1
            if (r8 != 0) goto L_0x016b
            r1 = 1
        L_0x0169:
            r2 = 0
            goto L_0x016d
        L_0x016b:
            r1 = 0
            goto L_0x0169
        L_0x016d:
            androidx.media3.extractor.ExtractorUtil.a(r1, r2)
            r1 = 1987063864(0x76703038, float:1.21789965E33)
            if (r10 != r1) goto L_0x0178
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            goto L_0x017a
        L_0x0178:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
        L_0x017a:
            int r12 = r12 + 12
            r0.Y(r12)
            r0.Z(r11)
            int r2 = r37.L()
            int r8 = r2 >> 4
            r12 = 1
            r2 = r2 & r12
            if (r2 == 0) goto L_0x018e
            r2 = 1
            goto L_0x018f
        L_0x018e:
            r2 = 0
        L_0x018f:
            int r12 = r37.L()
            int r13 = r37.L()
            int r20 = androidx.media3.common.ColorInfo.m(r12)
            if (r2 == 0) goto L_0x01a0
            r21 = 1
            goto L_0x01a2
        L_0x01a0:
            r21 = 2
        L_0x01a2:
            int r22 = androidx.media3.common.ColorInfo.n(r13)
            r30 = r3
            r13 = r8
            r15 = r13
            r27 = r10
            r2 = 0
            r3 = -1
            r8 = r1
            goto L_0x0386
        L_0x01b1:
            r2 = 1635135811(0x61763143, float:2.8384055E20)
            if (r1 != r2) goto L_0x01dd
            int r12 = r12 + 8
            r0.Y(r12)
            androidx.media3.common.ColorInfo r1 = h(r37)
            int r2 = r1.X2
            int r8 = r1.Y2
            int r11 = r1.s
            int r12 = r1.X
            int r1 = r1.Y
            java.lang.String r13 = "video/av01"
            r22 = r1
            r15 = r2
            r30 = r3
            r27 = r10
            r20 = r11
            r21 = r12
            r2 = 0
            r3 = -1
            r36 = r13
            r13 = r8
            goto L_0x00fc
        L_0x01dd:
            r2 = 1668050025(0x636c6c69, float:4.3612434E21)
            if (r1 != r2) goto L_0x0207
            if (r23 != 0) goto L_0x01e8
            java.nio.ByteBuffer r23 = a()
        L_0x01e8:
            r1 = r23
            r2 = 21
            r1.position(r2)
            short r2 = r37.H()
            r1.putShort(r2)
            short r2 = r37.H()
            r1.putShort(r2)
            r23 = r1
            r30 = r3
            r27 = r10
        L_0x0203:
            r2 = 0
        L_0x0204:
            r3 = -1
            goto L_0x0386
        L_0x0207:
            r2 = 1835295606(0x6d646376, float:4.4176764E27)
            if (r1 != r2) goto L_0x027b
            if (r23 != 0) goto L_0x0212
            java.nio.ByteBuffer r23 = a()
        L_0x0212:
            r1 = r23
            short r2 = r37.H()
            short r11 = r37.H()
            short r12 = r37.H()
            r27 = r10
            short r10 = r37.H()
            short r4 = r37.H()
            r28 = r13
            short r13 = r37.H()
            r29 = r15
            short r15 = r37.H()
            r30 = r3
            short r3 = r37.H()
            long r31 = r37.N()
            long r33 = r37.N()
            r35 = r14
            r14 = 1
            r1.position(r14)
            r1.putShort(r4)
            r1.putShort(r13)
            r1.putShort(r2)
            r1.putShort(r11)
            r1.putShort(r12)
            r1.putShort(r10)
            r1.putShort(r15)
            r1.putShort(r3)
            r2 = 10000(0x2710, double:4.9407E-320)
            long r10 = r31 / r2
            int r4 = (int) r10
            short r4 = (short) r4
            r1.putShort(r4)
            long r2 = r33 / r2
            int r3 = (int) r2
            short r2 = (short) r3
            r1.putShort(r2)
            r23 = r1
            r13 = r28
            r15 = r29
            r14 = r35
            goto L_0x0203
        L_0x027b:
            r30 = r3
            r27 = r10
            r28 = r13
            r35 = r14
            r29 = r15
            r2 = 1681012275(0x64323633, float:1.3149704E22)
            if (r1 != r2) goto L_0x029d
            r2 = 0
            if (r8 != 0) goto L_0x028f
            r11 = 1
            goto L_0x0290
        L_0x028f:
            r11 = 0
        L_0x0290:
            androidx.media3.extractor.ExtractorUtil.a(r11, r2)
            r8 = r45
        L_0x0295:
            r13 = r28
            r15 = r29
            r14 = r35
            goto L_0x0204
        L_0x029d:
            r2 = 0
            r3 = 1702061171(0x65736473, float:7.183675E22)
            if (r1 != r3) goto L_0x02bf
            if (r8 != 0) goto L_0x02a7
            r11 = 1
            goto L_0x02a8
        L_0x02a7:
            r11 = 0
        L_0x02a8:
            androidx.media3.extractor.ExtractorUtil.a(r11, r2)
            androidx.media3.extractor.mp4.AtomParsers$EsdsData r24 = k(r0, r12)
            java.lang.String r1 = r24.f13533a
            byte[] r3 = r24.f13534b
            if (r3 == 0) goto L_0x02bd
            com.google.common.collect.ImmutableList r16 = com.google.common.collect.ImmutableList.K(r3)
        L_0x02bd:
            r8 = r1
            goto L_0x0295
        L_0x02bf:
            r3 = 1885434736(0x70617370, float:2.7909473E29)
            if (r1 != r3) goto L_0x02d2
            float r1 = s(r0, r12)
            r14 = r1
            r13 = r28
            r15 = r29
            r3 = -1
            r25 = 1
            goto L_0x0386
        L_0x02d2:
            r3 = 1937126244(0x73763364, float:1.9506033E31)
            if (r1 != r3) goto L_0x02dc
            byte[] r18 = t(r0, r12, r9)
            goto L_0x0295
        L_0x02dc:
            r3 = 1936995172(0x73743364, float:1.9347576E31)
            if (r1 != r3) goto L_0x0305
            int r1 = r37.L()
            r3 = 3
            r0.Z(r3)
            if (r1 != 0) goto L_0x0295
            int r1 = r37.L()
            if (r1 == 0) goto L_0x0302
            r12 = 1
            if (r1 == r12) goto L_0x02ff
            if (r1 == r11) goto L_0x02fc
            if (r1 == r3) goto L_0x02f9
            goto L_0x0295
        L_0x02f9:
            r19 = 3
            goto L_0x0295
        L_0x02fc:
            r19 = 2
            goto L_0x0295
        L_0x02ff:
            r19 = 1
            goto L_0x0295
        L_0x0302:
            r19 = 0
            goto L_0x0295
        L_0x0305:
            r12 = 1
            r3 = 1668246642(0x636f6c72, float:4.4165861E21)
            if (r1 != r3) goto L_0x036e
            r1 = r20
            r3 = -1
            r4 = r22
            if (r1 != r3) goto L_0x0373
            if (r4 != r3) goto L_0x0373
            int r10 = r37.s()
            r13 = 1852009592(0x6e636c78, float:1.7596057E28)
            if (r10 == r13) goto L_0x033e
            r13 = 1852009571(0x6e636c63, float:1.7596032E28)
            if (r10 != r13) goto L_0x0323
            goto L_0x033e
        L_0x0323:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Unsupported color type: "
            r11.append(r12)
            java.lang.String r10 = androidx.media3.extractor.mp4.Atom.a(r10)
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            java.lang.String r11 = "AtomParsers"
            androidx.media3.common.util.Log.n(r11, r10)
            goto L_0x0373
        L_0x033e:
            int r1 = r37.R()
            int r4 = r37.R()
            r0.Z(r11)
            r10 = 19
            if (r9 != r10) goto L_0x0357
            int r10 = r37.L()
            r10 = r10 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0357
            r10 = 1
            goto L_0x0358
        L_0x0357:
            r10 = 0
        L_0x0358:
            int r20 = androidx.media3.common.ColorInfo.m(r1)
            if (r10 == 0) goto L_0x0361
            r21 = 1
            goto L_0x0363
        L_0x0361:
            r21 = 2
        L_0x0363:
            int r22 = androidx.media3.common.ColorInfo.n(r4)
        L_0x0367:
            r13 = r28
            r15 = r29
            r14 = r35
            goto L_0x0386
        L_0x036e:
            r1 = r20
            r4 = r22
            r3 = -1
        L_0x0373:
            r20 = r1
            r22 = r4
            goto L_0x0367
        L_0x0378:
            androidx.media3.extractor.DolbyVisionConfig r10 = androidx.media3.extractor.DolbyVisionConfig.a(r37)
            if (r10 == 0) goto L_0x0373
            java.lang.String r8 = r10.f13014c
            java.lang.String r10 = "video/dolby-vision"
            r17 = r8
            r8 = r10
            goto L_0x0373
        L_0x0386:
            int r7 = r7 + r9
            r1 = r39
            r2 = r40
            r4 = r44
            r11 = r45
            r10 = r27
            r3 = r30
            goto L_0x007f
        L_0x0395:
            if (r8 != 0) goto L_0x0398
            return
        L_0x0398:
            androidx.media3.common.Format$Builder r0 = new androidx.media3.common.Format$Builder
            r0.<init>()
            r3 = r41
            androidx.media3.common.Format$Builder r0 = r0.W(r3)
            androidx.media3.common.Format$Builder r0 = r0.k0(r8)
            r9 = r17
            androidx.media3.common.Format$Builder r0 = r0.M(r9)
            androidx.media3.common.Format$Builder r0 = r0.r0(r5)
            androidx.media3.common.Format$Builder r0 = r0.V(r6)
            r14 = r35
            androidx.media3.common.Format$Builder r0 = r0.g0(r14)
            r3 = r42
            androidx.media3.common.Format$Builder r0 = r0.j0(r3)
            r9 = r18
            androidx.media3.common.Format$Builder r0 = r0.h0(r9)
            r12 = r19
            androidx.media3.common.Format$Builder r0 = r0.n0(r12)
            r9 = r16
            androidx.media3.common.Format$Builder r0 = r0.Y(r9)
            r3 = r30
            androidx.media3.common.Format$Builder r0 = r0.R(r3)
            androidx.media3.common.ColorInfo$Builder r3 = new androidx.media3.common.ColorInfo$Builder
            r3.<init>()
            androidx.media3.common.ColorInfo$Builder r1 = r3.d(r1)
            r12 = r21
            androidx.media3.common.ColorInfo$Builder r1 = r1.c(r12)
            androidx.media3.common.ColorInfo$Builder r1 = r1.e(r4)
            if (r23 == 0) goto L_0x03f3
            byte[] r9 = r23.array()
            goto L_0x03f4
        L_0x03f3:
            r9 = r2
        L_0x03f4:
            androidx.media3.common.ColorInfo$Builder r1 = r1.f(r9)
            r15 = r29
            androidx.media3.common.ColorInfo$Builder r1 = r1.g(r15)
            r13 = r28
            androidx.media3.common.ColorInfo$Builder r1 = r1.b(r13)
            androidx.media3.common.ColorInfo r1 = r1.a()
            androidx.media3.common.Format$Builder r0 = r0.N(r1)
            if (r24 == 0) goto L_0x0425
            long r1 = r24.f13535c
            int r1 = com.google.common.primitives.Ints.z(r1)
            androidx.media3.common.Format$Builder r1 = r0.K(r1)
            long r2 = r24.f13536d
            int r2 = com.google.common.primitives.Ints.z(r2)
            r1.f0(r2)
        L_0x0425:
            androidx.media3.common.Format r0 = r0.I()
            r1 = r44
            r1.f13539b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.AtomParsers.E(androidx.media3.common.util.ParsableByteArray, int, int, int, int, int, androidx.media3.common.DrmInitData, androidx.media3.extractor.mp4.AtomParsers$StsdData, int):void");
    }

    @Nullable
    private static Metadata F(ParsableByteArray parsableByteArray) {
        short H = parsableByteArray.H();
        parsableByteArray.Z(2);
        String I = parsableByteArray.I(H);
        int max = Math.max(I.lastIndexOf(43), I.lastIndexOf(45));
        try {
            return new Metadata(new Mp4LocationData(Float.parseFloat(I.substring(0, max)), Float.parseFloat(I.substring(max, I.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    private static ByteBuffer a() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    private static boolean b(long[] jArr, long j2, long j3, long j4) {
        int length = jArr.length - 1;
        return jArr[0] <= j3 && j3 < jArr[Util.w(4, 0, length)] && jArr[Util.w(jArr.length - 4, 0, length)] < j4 && j4 <= j2;
    }

    private static boolean c(int i2) {
        return i2 != 1;
    }

    private static int d(ParsableByteArray parsableByteArray, int i2, int i3, int i4) throws ParserException {
        int f2 = parsableByteArray.f();
        ExtractorUtil.a(f2 >= i3, (String) null);
        while (f2 - i3 < i4) {
            parsableByteArray.Y(f2);
            int s = parsableByteArray.s();
            ExtractorUtil.a(s > 0, "childAtomSize must be positive");
            if (parsableByteArray.s() == i2) {
                return f2;
            }
            f2 += s;
        }
        return -1;
    }

    private static int e(int i2) {
        if (i2 == f13518h) {
            return 1;
        }
        if (i2 == f13521k) {
            return 2;
        }
        if (i2 == f13520j || i2 == f13517g || i2 == f13519i || i2 == f13512b) {
            return 3;
        }
        return i2 == 1835365473 ? 5 : -1;
    }

    public static void f(ParsableByteArray parsableByteArray) {
        int f2 = parsableByteArray.f();
        parsableByteArray.Z(4);
        if (parsableByteArray.s() != 1751411826) {
            f2 += 4;
        }
        parsableByteArray.Y(f2);
    }

    private static void g(ParsableByteArray parsableByteArray, int i2, int i3, int i4, int i5, String str, boolean z, @Nullable DrmInitData drmInitData, StsdData stsdData, int i6) throws ParserException {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        String str2;
        String str3;
        Format b2;
        int i12;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i13 = i3;
        int i14 = i4;
        int i15 = i5;
        String str4 = str;
        DrmInitData drmInitData2 = drmInitData;
        StsdData stsdData2 = stsdData;
        parsableByteArray2.Y(i13 + 16);
        if (z) {
            i7 = parsableByteArray.R();
            parsableByteArray2.Z(6);
        } else {
            parsableByteArray2.Z(8);
            i7 = 0;
        }
        if (i7 == 0 || i7 == 1) {
            i9 = parsableByteArray.R();
            parsableByteArray2.Z(6);
            i10 = parsableByteArray.M();
            parsableByteArray2.Y(parsableByteArray.f() - 4);
            i8 = parsableByteArray.s();
            if (i7 == 1) {
                parsableByteArray2.Z(16);
            }
            i11 = -1;
        } else if (i7 == 2) {
            parsableByteArray2.Z(16);
            i10 = (int) Math.round(parsableByteArray.q());
            i9 = parsableByteArray.P();
            parsableByteArray2.Z(4);
            int P = parsableByteArray.P();
            int P2 = parsableByteArray.P();
            boolean z2 = (P2 & 1) != 0;
            boolean z3 = (P2 & 2) != 0;
            if (!z2) {
                if (P == 8) {
                    i11 = 3;
                } else if (P == 16) {
                    i11 = z3 ? 268435456 : 2;
                } else if (P == 24) {
                    i11 = z3 ? C.D : 21;
                } else if (P == 32) {
                    i11 = z3 ? C.F : 22;
                }
                parsableByteArray2.Z(8);
                i8 = 0;
            } else if (P == 32) {
                i11 = 4;
                parsableByteArray2.Z(8);
                i8 = 0;
            }
            i11 = -1;
            parsableByteArray2.Z(8);
            i8 = 0;
        } else {
            return;
        }
        int f2 = parsableByteArray.f();
        int i16 = i2;
        if (i16 == 1701733217) {
            Pair<Integer, TrackEncryptionBox> u = u(parsableByteArray2, i13, i14);
            if (u != null) {
                i16 = ((Integer) u.first).intValue();
                drmInitData2 = drmInitData2 == null ? null : drmInitData2.c(((TrackEncryptionBox) u.second).f13671b);
                stsdData2.f13538a[i6] = (TrackEncryptionBox) u.second;
            }
            parsableByteArray2.Y(f2);
        }
        String str5 = MimeTypes.M;
        if (i16 == 1633889587) {
            str2 = MimeTypes.Q;
        } else if (i16 == 1700998451) {
            str2 = MimeTypes.R;
        } else if (i16 == 1633889588) {
            str2 = MimeTypes.T;
        } else if (i16 == 1685353315) {
            str2 = MimeTypes.V;
        } else if (i16 == 1685353320 || i16 == 1685353324) {
            str2 = MimeTypes.W;
        } else if (i16 == 1685353317) {
            str2 = MimeTypes.X;
        } else if (i16 == 1685353336) {
            str2 = MimeTypes.Y;
        } else if (i16 == 1935764850) {
            str2 = MimeTypes.c0;
        } else if (i16 == 1935767394) {
            str2 = MimeTypes.d0;
        } else {
            if (i16 != 1936684916) {
                if (i16 == 1953984371) {
                    str2 = MimeTypes.N;
                    i11 = 268435456;
                } else if (i16 != 1819304813) {
                    str2 = (i16 == 778924082 || i16 == 778924083) ? MimeTypes.I : i16 == 1835557169 ? MimeTypes.L : i16 == 1835560241 ? str5 : i16 == 1634492771 ? MimeTypes.f0 : i16 == 1634492791 ? MimeTypes.O : i16 == 1970037111 ? MimeTypes.P : i16 == 1332770163 ? MimeTypes.a0 : i16 == 1716281667 ? MimeTypes.e0 : i16 == 1835823201 ? MimeTypes.U : null;
                } else if (i11 != -1) {
                    str2 = MimeTypes.N;
                }
            }
            str2 = MimeTypes.N;
            i11 = 2;
        }
        int i17 = i11;
        String str6 = null;
        List list = null;
        EsdsData esdsData = null;
        while (f2 - i13 < i14) {
            parsableByteArray2.Y(f2);
            int s = parsableByteArray.s();
            ExtractorUtil.a(s > 0, "childAtomSize must be positive");
            int s2 = parsableByteArray.s();
            if (s2 == 1835557187) {
                parsableByteArray2.Y(f2 + 8);
                parsableByteArray2.Z(1);
                int L = parsableByteArray.L();
                parsableByteArray2.Z(1);
                if (Objects.equals(str2, str5)) {
                    i12 = 0;
                    str6 = String.format("mhm1.%02X", new Object[]{Integer.valueOf(L)});
                    str3 = str5;
                } else {
                    i12 = 0;
                    str3 = str5;
                    str6 = String.format("mha1.%02X", new Object[]{Integer.valueOf(L)});
                }
                int R = parsableByteArray.R();
                byte[] bArr = new byte[R];
                parsableByteArray2.n(bArr, i12, R);
                list = list == null ? ImmutableList.K(bArr) : ImmutableList.L(bArr, (byte[]) list.get(i12));
            } else {
                str3 = str5;
                if (s2 == 1835557200) {
                    parsableByteArray2.Y(f2 + 8);
                    int L2 = parsableByteArray.L();
                    if (L2 > 0) {
                        byte[] bArr2 = new byte[L2];
                        parsableByteArray2.n(bArr2, 0, L2);
                        list = list == null ? ImmutableList.K(bArr2) : ImmutableList.L((byte[]) list.get(0), bArr2);
                    }
                } else if (s2 == 1702061171 || (z && s2 == 2002876005)) {
                    int d2 = s2 == 1702061171 ? f2 : d(parsableByteArray2, Atom.o0, f2, s);
                    if (d2 != -1) {
                        esdsData = k(parsableByteArray2, d2);
                        str2 = esdsData.f13533a;
                        byte[] b3 = esdsData.f13534b;
                        if (b3 != null) {
                            if (MimeTypes.Z.equals(str2)) {
                                list = VorbisUtil.e(b3);
                            } else {
                                if (MimeTypes.F.equals(str2)) {
                                    AacUtil.Config f3 = AacUtil.f(b3);
                                    int i18 = f3.f12885a;
                                    i9 = f3.f12886b;
                                    int i19 = i18;
                                    str6 = f3.f12887c;
                                    i10 = i19;
                                }
                                list = ImmutableList.K(b3);
                            }
                        }
                    }
                    f2 += s;
                    i13 = i3;
                    i14 = i4;
                    str5 = str3;
                } else {
                    if (s2 == 1684103987) {
                        parsableByteArray2.Y(f2 + 8);
                        b2 = Ac3Util.d(parsableByteArray2, Integer.toString(i5), str4, drmInitData2);
                    } else if (s2 == 1684366131) {
                        parsableByteArray2.Y(f2 + 8);
                        b2 = Ac3Util.h(parsableByteArray2, Integer.toString(i5), str4, drmInitData2);
                    } else if (s2 == 1684103988) {
                        parsableByteArray2.Y(f2 + 8);
                        b2 = Ac4Util.b(parsableByteArray2, Integer.toString(i5), str4, drmInitData2);
                    } else if (s2 == 1684892784) {
                        if (i8 > 0) {
                            i10 = i8;
                            i9 = 2;
                            f2 += s;
                            i13 = i3;
                            i14 = i4;
                            str5 = str3;
                        } else {
                            throw ParserException.a("Invalid sample rate for Dolby TrueHD MLP stream: " + i8, (Throwable) null);
                        }
                    } else if (s2 == 1684305011 || s2 == 1969517683) {
                        stsdData2.f13539b = new Format.Builder().W(i15).k0(str2).L(i9).l0(i10).R(drmInitData2).b0(str4).I();
                        f2 += s;
                        i13 = i3;
                        i14 = i4;
                        str5 = str3;
                    } else {
                        if (s2 == 1682927731) {
                            int i20 = s - 8;
                            byte[] bArr3 = f13523m;
                            byte[] copyOf = Arrays.copyOf(bArr3, bArr3.length + i20);
                            parsableByteArray2.Y(f2 + 8);
                            parsableByteArray2.n(copyOf, bArr3.length, i20);
                            list = OpusUtil.a(copyOf);
                        } else if (s2 == 1684425825) {
                            byte[] bArr4 = new byte[(s - 8)];
                            bArr4[0] = 102;
                            bArr4[1] = 76;
                            bArr4[2] = 97;
                            bArr4[3] = 67;
                            parsableByteArray2.Y(f2 + 12);
                            parsableByteArray2.n(bArr4, 4, s - 12);
                            list = ImmutableList.K(bArr4);
                        } else if (s2 == 1634492771) {
                            int i21 = s - 12;
                            byte[] bArr5 = new byte[i21];
                            parsableByteArray2.Y(f2 + 12);
                            parsableByteArray2.n(bArr5, 0, i21);
                            Pair<Integer, Integer> h2 = CodecSpecificDataUtil.h(bArr5);
                            int intValue = ((Integer) h2.first).intValue();
                            i9 = ((Integer) h2.second).intValue();
                            int i22 = intValue;
                            list = ImmutableList.K(bArr5);
                            i10 = i22;
                        }
                        f2 += s;
                        i13 = i3;
                        i14 = i4;
                        str5 = str3;
                    }
                    stsdData2.f13539b = b2;
                    f2 += s;
                    i13 = i3;
                    i14 = i4;
                    str5 = str3;
                }
            }
            f2 += s;
            i13 = i3;
            i14 = i4;
            str5 = str3;
        }
        if (stsdData2.f13539b == null && str2 != null) {
            Format.Builder b0 = new Format.Builder().W(i15).k0(str2).M(str6).L(i9).l0(i10).e0(i17).Y(list).R(drmInitData2).b0(str4);
            if (esdsData != null) {
                b0.K(Ints.z(esdsData.f13535c)).f0(Ints.z(esdsData.f13536d));
            }
            stsdData2.f13539b = b0.I();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.media3.common.ColorInfo h(androidx.media3.common.util.ParsableByteArray r15) {
        /*
            androidx.media3.common.ColorInfo$Builder r0 = new androidx.media3.common.ColorInfo$Builder
            r0.<init>()
            androidx.media3.common.util.ParsableBitArray r1 = new androidx.media3.common.util.ParsableBitArray
            byte[] r2 = r15.e()
            r1.<init>(r2)
            int r15 = r15.f()
            r2 = 8
            int r15 = r15 * 8
            r1.q(r15)
            r15 = 1
            r1.t(r15)
            r3 = 3
            int r4 = r1.h(r3)
            r5 = 6
            r1.s(r5)
            boolean r5 = r1.g()
            boolean r6 = r1.g()
            r7 = 12
            r8 = 10
            r9 = 2
            if (r4 != r9) goto L_0x0049
            if (r5 == 0) goto L_0x0049
            if (r6 == 0) goto L_0x003c
            r4 = 12
            goto L_0x003e
        L_0x003c:
            r4 = 10
        L_0x003e:
            r0.g(r4)
            if (r6 == 0) goto L_0x0045
            r8 = 12
        L_0x0045:
            r0.b(r8)
            goto L_0x005b
        L_0x0049:
            if (r4 > r9) goto L_0x005b
            if (r5 == 0) goto L_0x0050
            r4 = 10
            goto L_0x0052
        L_0x0050:
            r4 = 8
        L_0x0052:
            r0.g(r4)
            if (r5 == 0) goto L_0x0058
            goto L_0x0045
        L_0x0058:
            r8 = 8
            goto L_0x0045
        L_0x005b:
            r4 = 13
            r1.s(r4)
            r1.r()
            r5 = 4
            int r6 = r1.h(r5)
            java.lang.String r8 = "AtomParsers"
            if (r6 == r15) goto L_0x0085
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r1 = "Unsupported obu_type: "
            r15.append(r1)
            r15.append(r6)
            java.lang.String r15 = r15.toString()
        L_0x007d:
            androidx.media3.common.util.Log.h(r8, r15)
            androidx.media3.common.ColorInfo r15 = r0.a()
            return r15
        L_0x0085:
            boolean r6 = r1.g()
            if (r6 == 0) goto L_0x008e
            java.lang.String r15 = "Unsupported obu_extension_flag"
            goto L_0x007d
        L_0x008e:
            boolean r6 = r1.g()
            r1.r()
            if (r6 == 0) goto L_0x00a2
            int r6 = r1.h(r2)
            r10 = 127(0x7f, float:1.78E-43)
            if (r6 <= r10) goto L_0x00a2
            java.lang.String r15 = "Excessive obu_size"
            goto L_0x007d
        L_0x00a2:
            int r6 = r1.h(r3)
            r1.r()
            boolean r10 = r1.g()
            if (r10 == 0) goto L_0x00b2
            java.lang.String r15 = "Unsupported reduced_still_picture_header"
            goto L_0x007d
        L_0x00b2:
            boolean r10 = r1.g()
            if (r10 == 0) goto L_0x00bb
            java.lang.String r15 = "Unsupported timing_info_present_flag"
            goto L_0x007d
        L_0x00bb:
            boolean r10 = r1.g()
            if (r10 == 0) goto L_0x00c4
            java.lang.String r15 = "Unsupported initial_display_delay_present_flag"
            goto L_0x007d
        L_0x00c4:
            r8 = 5
            int r10 = r1.h(r8)
            r11 = 0
            r12 = 0
        L_0x00cb:
            r13 = 7
            if (r12 > r10) goto L_0x00dd
            r1.s(r7)
            int r14 = r1.h(r8)
            if (r14 <= r13) goto L_0x00da
            r1.r()
        L_0x00da:
            int r12 = r12 + 1
            goto L_0x00cb
        L_0x00dd:
            int r7 = r1.h(r5)
            int r5 = r1.h(r5)
            int r7 = r7 + r15
            r1.s(r7)
            int r5 = r5 + r15
            r1.s(r5)
            boolean r5 = r1.g()
            if (r5 == 0) goto L_0x00f6
            r1.s(r13)
        L_0x00f6:
            r1.s(r13)
            boolean r5 = r1.g()
            if (r5 == 0) goto L_0x0102
            r1.s(r9)
        L_0x0102:
            boolean r7 = r1.g()
            if (r7 == 0) goto L_0x010a
            r7 = 2
            goto L_0x010e
        L_0x010a:
            int r7 = r1.h(r15)
        L_0x010e:
            if (r7 <= 0) goto L_0x0119
            boolean r7 = r1.g()
            if (r7 != 0) goto L_0x0119
            r1.s(r15)
        L_0x0119:
            if (r5 == 0) goto L_0x011e
            r1.s(r3)
        L_0x011e:
            r1.s(r3)
            boolean r3 = r1.g()
            if (r6 != r9) goto L_0x012c
            if (r3 == 0) goto L_0x012c
            r1.r()
        L_0x012c:
            if (r6 == r15) goto L_0x0135
            boolean r3 = r1.g()
            if (r3 == 0) goto L_0x0135
            r11 = 1
        L_0x0135:
            boolean r3 = r1.g()
            if (r3 == 0) goto L_0x016c
            int r3 = r1.h(r2)
            int r5 = r1.h(r2)
            int r2 = r1.h(r2)
            if (r11 != 0) goto L_0x0151
            if (r3 != r15) goto L_0x0151
            if (r5 != r4) goto L_0x0151
            if (r2 != 0) goto L_0x0151
            r1 = 1
            goto L_0x0155
        L_0x0151:
            int r1 = r1.h(r15)
        L_0x0155:
            int r2 = androidx.media3.common.ColorInfo.m(r3)
            androidx.media3.common.ColorInfo$Builder r2 = r0.d(r2)
            if (r1 != r15) goto L_0x0160
            goto L_0x0161
        L_0x0160:
            r15 = 2
        L_0x0161:
            androidx.media3.common.ColorInfo$Builder r15 = r2.c(r15)
            int r1 = androidx.media3.common.ColorInfo.n(r5)
            r15.e(r1)
        L_0x016c:
            androidx.media3.common.ColorInfo r15 = r0.a()
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.AtomParsers.h(androidx.media3.common.util.ParsableByteArray):androidx.media3.common.ColorInfo");
    }

    @Nullable
    static Pair<Integer, TrackEncryptionBox> i(ParsableByteArray parsableByteArray, int i2, int i3) throws ParserException {
        int i4 = i2 + 8;
        boolean z = false;
        String str = null;
        Integer num = null;
        int i5 = -1;
        int i6 = 0;
        while (i4 - i2 < i3) {
            parsableByteArray.Y(i4);
            int s = parsableByteArray.s();
            int s2 = parsableByteArray.s();
            if (s2 == 1718775137) {
                num = Integer.valueOf(parsableByteArray.s());
            } else if (s2 == 1935894637) {
                parsableByteArray.Z(4);
                str = parsableByteArray.I(4);
            } else if (s2 == 1935894633) {
                i5 = i4;
                i6 = s;
            }
            i4 += s;
        }
        if (!C.d2.equals(str) && !C.e2.equals(str) && !C.f2.equals(str) && !C.g2.equals(str)) {
            return null;
        }
        ExtractorUtil.a(num != null, "frma atom is mandatory");
        ExtractorUtil.a(i5 != -1, "schi atom is mandatory");
        TrackEncryptionBox v = v(parsableByteArray, i5, i6, str);
        if (v != null) {
            z = true;
        }
        ExtractorUtil.a(z, "tenc atom is mandatory");
        return Pair.create(num, (TrackEncryptionBox) Util.o(v));
    }

    @Nullable
    private static Pair<long[], long[]> j(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom h2 = containerAtom.h(Atom.v0);
        if (h2 == null) {
            return null;
        }
        ParsableByteArray parsableByteArray = h2.G1;
        parsableByteArray.Y(8);
        int c2 = Atom.c(parsableByteArray.s());
        int P = parsableByteArray.P();
        long[] jArr = new long[P];
        long[] jArr2 = new long[P];
        int i2 = 0;
        while (i2 < P) {
            jArr[i2] = c2 == 1 ? parsableByteArray.Q() : parsableByteArray.N();
            jArr2[i2] = c2 == 1 ? parsableByteArray.E() : (long) parsableByteArray.s();
            if (parsableByteArray.H() == 1) {
                parsableByteArray.Z(2);
                i2++;
            } else {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
        }
        return Pair.create(jArr, jArr2);
    }

    private static EsdsData k(ParsableByteArray parsableByteArray, int i2) {
        parsableByteArray.Y(i2 + 12);
        parsableByteArray.Z(1);
        l(parsableByteArray);
        parsableByteArray.Z(2);
        int L = parsableByteArray.L();
        if ((L & 128) != 0) {
            parsableByteArray.Z(2);
        }
        if ((L & 64) != 0) {
            parsableByteArray.Z(parsableByteArray.L());
        }
        if ((L & 32) != 0) {
            parsableByteArray.Z(2);
        }
        parsableByteArray.Z(1);
        l(parsableByteArray);
        String h2 = MimeTypes.h(parsableByteArray.L());
        if (MimeTypes.I.equals(h2) || MimeTypes.V.equals(h2) || MimeTypes.W.equals(h2)) {
            return new EsdsData(h2, (byte[]) null, -1, -1);
        }
        parsableByteArray.Z(4);
        long N = parsableByteArray.N();
        long N2 = parsableByteArray.N();
        parsableByteArray.Z(1);
        int l2 = l(parsableByteArray);
        byte[] bArr = new byte[l2];
        parsableByteArray.n(bArr, 0, l2);
        long j2 = -1;
        long j3 = N2 > 0 ? N2 : -1;
        if (N > 0) {
            j2 = N;
        }
        return new EsdsData(h2, bArr, j3, j2);
    }

    private static int l(ParsableByteArray parsableByteArray) {
        int L = parsableByteArray.L();
        int i2 = L & WorkQueueKt.f29430c;
        while ((L & 128) == 128) {
            L = parsableByteArray.L();
            i2 = (i2 << 7) | (L & WorkQueueKt.f29430c);
        }
        return i2;
    }

    private static int m(ParsableByteArray parsableByteArray) {
        parsableByteArray.Y(16);
        return parsableByteArray.s();
    }

    @Nullable
    private static Metadata n(ParsableByteArray parsableByteArray, int i2) {
        parsableByteArray.Z(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray.f() < i2) {
            Metadata.Entry c2 = MetadataUtil.c(parsableByteArray);
            if (c2 != null) {
                arrayList.add(c2);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    private static Pair<Long, String> o(ParsableByteArray parsableByteArray) {
        int i2 = 8;
        parsableByteArray.Y(8);
        int c2 = Atom.c(parsableByteArray.s());
        parsableByteArray.Z(c2 == 0 ? 8 : 16);
        long N = parsableByteArray.N();
        if (c2 == 0) {
            i2 = 4;
        }
        parsableByteArray.Z(i2);
        int R = parsableByteArray.R();
        return Pair.create(Long.valueOf(N), "" + ((char) (((R >> 10) & 31) + 96)) + ((char) (((R >> 5) & 31) + 96)) + ((char) ((R & 31) + 96)));
    }

    @Nullable
    public static Metadata p(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom h2 = containerAtom.h(Atom.x0);
        Atom.LeafAtom h3 = containerAtom.h(Atom.l1);
        Atom.LeafAtom h4 = containerAtom.h(Atom.m1);
        if (h2 == null || h3 == null || h4 == null || m(h2.G1) != f13513c) {
            return null;
        }
        ParsableByteArray parsableByteArray = h3.G1;
        parsableByteArray.Y(12);
        int s = parsableByteArray.s();
        String[] strArr = new String[s];
        for (int i2 = 0; i2 < s; i2++) {
            int s2 = parsableByteArray.s();
            parsableByteArray.Z(4);
            strArr[i2] = parsableByteArray.I(s2 - 8);
        }
        ParsableByteArray parsableByteArray2 = h4.G1;
        parsableByteArray2.Y(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray2.a() > 8) {
            int f2 = parsableByteArray2.f();
            int s3 = parsableByteArray2.s();
            int s4 = parsableByteArray2.s() - 1;
            if (s4 < 0 || s4 >= s) {
                Log.n(f13511a, "Skipped metadata with unknown key index: " + s4);
            } else {
                MdtaMetadataEntry f3 = MetadataUtil.f(parsableByteArray2, f2 + s3, strArr[s4]);
                if (f3 != null) {
                    arrayList.add(f3);
                }
            }
            parsableByteArray2.Y(f2 + s3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    private static void q(ParsableByteArray parsableByteArray, int i2, int i3, int i4, StsdData stsdData) {
        parsableByteArray.Y(i3 + 16);
        if (i2 == 1835365492) {
            parsableByteArray.F();
            String F = parsableByteArray.F();
            if (F != null) {
                stsdData.f13539b = new Format.Builder().W(i4).k0(F).I();
            }
        }
    }

    public static Mp4TimestampData r(ParsableByteArray parsableByteArray) {
        long E;
        long E2;
        parsableByteArray.Y(8);
        if (Atom.c(parsableByteArray.s()) == 0) {
            E = parsableByteArray.N();
            E2 = parsableByteArray.N();
        } else {
            E = parsableByteArray.E();
            E2 = parsableByteArray.E();
        }
        return new Mp4TimestampData(E, E2, parsableByteArray.N());
    }

    private static float s(ParsableByteArray parsableByteArray, int i2) {
        parsableByteArray.Y(i2 + 8);
        return ((float) parsableByteArray.P()) / ((float) parsableByteArray.P());
    }

    @Nullable
    private static byte[] t(ParsableByteArray parsableByteArray, int i2, int i3) {
        int i4 = i2 + 8;
        while (i4 - i2 < i3) {
            parsableByteArray.Y(i4);
            int s = parsableByteArray.s();
            if (parsableByteArray.s() == 1886547818) {
                return Arrays.copyOfRange(parsableByteArray.e(), i4, s + i4);
            }
            i4 += s;
        }
        return null;
    }

    @Nullable
    private static Pair<Integer, TrackEncryptionBox> u(ParsableByteArray parsableByteArray, int i2, int i3) throws ParserException {
        Pair<Integer, TrackEncryptionBox> i4;
        int f2 = parsableByteArray.f();
        while (f2 - i2 < i3) {
            parsableByteArray.Y(f2);
            int s = parsableByteArray.s();
            ExtractorUtil.a(s > 0, "childAtomSize must be positive");
            if (parsableByteArray.s() == 1936289382 && (i4 = i(parsableByteArray, f2, s)) != null) {
                return i4;
            }
            f2 += s;
        }
        return null;
    }

    @Nullable
    private static TrackEncryptionBox v(ParsableByteArray parsableByteArray, int i2, int i3, String str) {
        int i4;
        int i5;
        int i6 = i2 + 8;
        while (true) {
            byte[] bArr = null;
            if (i6 - i2 >= i3) {
                return null;
            }
            parsableByteArray.Y(i6);
            int s = parsableByteArray.s();
            if (parsableByteArray.s() == 1952804451) {
                int c2 = Atom.c(parsableByteArray.s());
                parsableByteArray.Z(1);
                if (c2 == 0) {
                    parsableByteArray.Z(1);
                    i5 = 0;
                    i4 = 0;
                } else {
                    int L = parsableByteArray.L();
                    i4 = L & 15;
                    i5 = (L & PsExtractor.A) >> 4;
                }
                boolean z = parsableByteArray.L() == 1;
                int L2 = parsableByteArray.L();
                byte[] bArr2 = new byte[16];
                parsableByteArray.n(bArr2, 0, 16);
                if (z && L2 == 0) {
                    int L3 = parsableByteArray.L();
                    bArr = new byte[L3];
                    parsableByteArray.n(bArr, 0, L3);
                }
                return new TrackEncryptionBox(z, str, L2, bArr2, i5, i4, bArr);
            }
            i6 += s;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x0288  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x028b  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x02af  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x02bf  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0371  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x03ad  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0132  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.media3.extractor.mp4.TrackSampleTable w(androidx.media3.extractor.mp4.Track r37, androidx.media3.extractor.mp4.Atom.ContainerAtom r38, androidx.media3.extractor.GaplessInfoHolder r39) throws androidx.media3.common.ParserException {
        /*
            r1 = r37
            r0 = r38
            r2 = r39
            r3 = 1937011578(0x7374737a, float:1.936741E31)
            androidx.media3.extractor.mp4.Atom$LeafAtom r3 = r0.h(r3)
            if (r3 == 0) goto L_0x0017
            androidx.media3.extractor.mp4.AtomParsers$StszSampleSizeBox r5 = new androidx.media3.extractor.mp4.AtomParsers$StszSampleSizeBox
            androidx.media3.common.Format r6 = r1.f13663f
            r5.<init>(r3, r6)
            goto L_0x0025
        L_0x0017:
            r3 = 1937013298(0x73747a32, float:1.9369489E31)
            androidx.media3.extractor.mp4.Atom$LeafAtom r3 = r0.h(r3)
            if (r3 == 0) goto L_0x0525
            androidx.media3.extractor.mp4.AtomParsers$Stz2SampleSizeBox r5 = new androidx.media3.extractor.mp4.AtomParsers$Stz2SampleSizeBox
            r5.<init>(r3)
        L_0x0025:
            int r3 = r5.b()
            r6 = 0
            if (r3 != 0) goto L_0x0040
            androidx.media3.extractor.mp4.TrackSampleTable r9 = new androidx.media3.extractor.mp4.TrackSampleTable
            long[] r2 = new long[r6]
            int[] r3 = new int[r6]
            long[] r5 = new long[r6]
            int[] r6 = new int[r6]
            r7 = 0
            r4 = 0
            r0 = r9
            r1 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x0040:
            r7 = 1937007471(0x7374636f, float:1.9362445E31)
            androidx.media3.extractor.mp4.Atom$LeafAtom r7 = r0.h(r7)
            r8 = 1
            if (r7 != 0) goto L_0x0059
            r7 = 1668232756(0x636f3634, float:4.4126776E21)
            androidx.media3.extractor.mp4.Atom$LeafAtom r7 = r0.h(r7)
            java.lang.Object r7 = androidx.media3.common.util.Assertions.g(r7)
            androidx.media3.extractor.mp4.Atom$LeafAtom r7 = (androidx.media3.extractor.mp4.Atom.LeafAtom) r7
            r9 = 1
            goto L_0x005a
        L_0x0059:
            r9 = 0
        L_0x005a:
            androidx.media3.common.util.ParsableByteArray r7 = r7.G1
            r10 = 1937011555(0x73747363, float:1.9367382E31)
            androidx.media3.extractor.mp4.Atom$LeafAtom r10 = r0.h(r10)
            java.lang.Object r10 = androidx.media3.common.util.Assertions.g(r10)
            androidx.media3.extractor.mp4.Atom$LeafAtom r10 = (androidx.media3.extractor.mp4.Atom.LeafAtom) r10
            androidx.media3.common.util.ParsableByteArray r10 = r10.G1
            r11 = 1937011827(0x73747473, float:1.9367711E31)
            androidx.media3.extractor.mp4.Atom$LeafAtom r11 = r0.h(r11)
            java.lang.Object r11 = androidx.media3.common.util.Assertions.g(r11)
            androidx.media3.extractor.mp4.Atom$LeafAtom r11 = (androidx.media3.extractor.mp4.Atom.LeafAtom) r11
            androidx.media3.common.util.ParsableByteArray r11 = r11.G1
            r12 = 1937011571(0x73747373, float:1.9367401E31)
            androidx.media3.extractor.mp4.Atom$LeafAtom r12 = r0.h(r12)
            if (r12 == 0) goto L_0x0086
            androidx.media3.common.util.ParsableByteArray r12 = r12.G1
            goto L_0x0087
        L_0x0086:
            r12 = 0
        L_0x0087:
            r13 = 1668576371(0x63747473, float:4.5093966E21)
            androidx.media3.extractor.mp4.Atom$LeafAtom r0 = r0.h(r13)
            if (r0 == 0) goto L_0x0093
            androidx.media3.common.util.ParsableByteArray r0 = r0.G1
            goto L_0x0094
        L_0x0093:
            r0 = 0
        L_0x0094:
            androidx.media3.extractor.mp4.AtomParsers$ChunkIterator r13 = new androidx.media3.extractor.mp4.AtomParsers$ChunkIterator
            r13.<init>(r10, r7, r9)
            r7 = 12
            r11.Y(r7)
            int r9 = r11.P()
            int r9 = r9 - r8
            int r10 = r11.P()
            int r14 = r11.P()
            if (r0 == 0) goto L_0x00b5
            r0.Y(r7)
            int r15 = r0.P()
            goto L_0x00b6
        L_0x00b5:
            r15 = 0
        L_0x00b6:
            r4 = -1
            if (r12 == 0) goto L_0x00cd
            r12.Y(r7)
            int r7 = r12.P()
            if (r7 <= 0) goto L_0x00c9
            int r16 = r12.P()
            int r16 = r16 + -1
            goto L_0x00cf
        L_0x00c9:
            r12 = 0
        L_0x00ca:
            r16 = -1
            goto L_0x00cf
        L_0x00cd:
            r7 = 0
            goto L_0x00ca
        L_0x00cf:
            int r6 = r5.a()
            androidx.media3.common.Format r8 = r1.f13663f
            java.lang.String r8 = r8.f3
            if (r6 == r4) goto L_0x00fb
            java.lang.String r4 = "audio/raw"
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x00f1
            java.lang.String r4 = "audio/g711-mlaw"
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x00f1
            java.lang.String r4 = "audio/g711-alaw"
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x00fb
        L_0x00f1:
            if (r9 != 0) goto L_0x00fb
            if (r15 != 0) goto L_0x00fb
            if (r7 != 0) goto L_0x00fb
            r38 = r7
            r4 = 1
            goto L_0x00fe
        L_0x00fb:
            r38 = r7
            r4 = 0
        L_0x00fe:
            if (r4 == 0) goto L_0x0132
            int r0 = r13.f13524a
            long[] r4 = new long[r0]
            int[] r0 = new int[r0]
        L_0x0106:
            boolean r5 = r13.a()
            if (r5 == 0) goto L_0x0117
            int r5 = r13.f13525b
            long r9 = r13.f13527d
            r4[r5] = r9
            int r9 = r13.f13526c
            r0[r5] = r9
            goto L_0x0106
        L_0x0117:
            long r9 = (long) r14
            androidx.media3.extractor.mp4.FixedSampleSizeRechunker$Results r0 = androidx.media3.extractor.mp4.FixedSampleSizeRechunker.a(r6, r4, r0, r9)
            long[] r4 = r0.f13558a
            int[] r5 = r0.f13559b
            int r6 = r0.f13560c
            long[] r9 = r0.f13561d
            int[] r10 = r0.f13562e
            long r11 = r0.f13563f
            r14 = r1
            r0 = r3
            r2 = r4
            r3 = r5
            r4 = r6
            r13 = r10
            r15 = r11
            r12 = r9
            goto L_0x029e
        L_0x0132:
            long[] r4 = new long[r3]
            int[] r6 = new int[r3]
            long[] r7 = new long[r3]
            int[] r8 = new int[r3]
            r24 = r11
            r2 = r16
            r1 = 0
            r11 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r16 = r15
            r15 = r14
            r14 = r10
            r36 = r9
            r9 = r38
        L_0x0152:
            r38 = r36
            java.lang.String r10 = "AtomParsers"
            if (r1 >= r3) goto L_0x0217
            r28 = r27
            r27 = r22
            r22 = 1
        L_0x015e:
            if (r27 != 0) goto L_0x017b
            boolean r22 = r13.a()
            if (r22 == 0) goto L_0x017b
            r30 = r14
            r31 = r15
            long r14 = r13.f13527d
            r32 = r3
            int r3 = r13.f13526c
            r27 = r3
            r28 = r14
            r14 = r30
            r15 = r31
            r3 = r32
            goto L_0x015e
        L_0x017b:
            r32 = r3
            r30 = r14
            r31 = r15
            if (r22 != 0) goto L_0x019f
            java.lang.String r2 = "Unexpected end of chunk data"
            androidx.media3.common.util.Log.n(r10, r2)
            long[] r4 = java.util.Arrays.copyOf(r4, r1)
            int[] r6 = java.util.Arrays.copyOf(r6, r1)
            long[] r7 = java.util.Arrays.copyOf(r7, r1)
            int[] r8 = java.util.Arrays.copyOf(r8, r1)
            r3 = r1
            r2 = r21
            r1 = r27
            goto L_0x021f
        L_0x019f:
            if (r0 == 0) goto L_0x01b2
        L_0x01a1:
            if (r23 != 0) goto L_0x01b0
            if (r16 <= 0) goto L_0x01b0
            int r23 = r0.P()
            int r21 = r0.s()
            int r16 = r16 + -1
            goto L_0x01a1
        L_0x01b0:
            int r23 = r23 + -1
        L_0x01b2:
            r3 = r21
            r4[r1] = r28
            int r10 = r5.c()
            r6[r1] = r10
            if (r10 <= r11) goto L_0x01bf
            r11 = r10
        L_0x01bf:
            long r14 = (long) r3
            long r14 = r25 + r14
            r7[r1] = r14
            if (r12 != 0) goto L_0x01c8
            r10 = 1
            goto L_0x01c9
        L_0x01c8:
            r10 = 0
        L_0x01c9:
            r8[r1] = r10
            if (r1 != r2) goto L_0x01df
            r10 = 1
            r8[r1] = r10
            int r9 = r9 + -1
            if (r9 <= 0) goto L_0x01df
            java.lang.Object r2 = androidx.media3.common.util.Assertions.g(r12)
            androidx.media3.common.util.ParsableByteArray r2 = (androidx.media3.common.util.ParsableByteArray) r2
            int r2 = r2.P()
            int r2 = r2 - r10
        L_0x01df:
            r15 = r2
            r10 = r3
            r14 = r31
            long r2 = (long) r14
            long r25 = r25 + r2
            int r2 = r30 + -1
            if (r2 != 0) goto L_0x01f9
            if (r38 <= 0) goto L_0x01f9
            int r2 = r24.P()
            int r3 = r24.s()
            int r14 = r38 + -1
        L_0x01f6:
            r38 = r2
            goto L_0x01fd
        L_0x01f9:
            r3 = r14
            r14 = r38
            goto L_0x01f6
        L_0x01fd:
            r2 = r6[r1]
            r21 = r3
            long r2 = (long) r2
            long r2 = r28 + r2
            int r22 = r27 + -1
            int r1 = r1 + 1
            r27 = r2
            r2 = r15
            r15 = r21
            r3 = r32
            r21 = r10
            r36 = r14
            r14 = r38
            goto L_0x0152
        L_0x0217:
            r32 = r3
            r30 = r14
            r2 = r21
            r1 = r22
        L_0x021f:
            long r12 = (long) r2
            long r12 = r25 + r12
            if (r0 == 0) goto L_0x0234
        L_0x0224:
            if (r16 <= 0) goto L_0x0234
            int r2 = r0.P()
            if (r2 == 0) goto L_0x022e
            r0 = 0
            goto L_0x0235
        L_0x022e:
            r0.s()
            int r16 = r16 + -1
            goto L_0x0224
        L_0x0234:
            r0 = 1
        L_0x0235:
            if (r9 != 0) goto L_0x0247
            if (r30 != 0) goto L_0x0247
            if (r1 != 0) goto L_0x0247
            if (r38 != 0) goto L_0x0247
            r2 = r23
            if (r2 != 0) goto L_0x0249
            if (r0 != 0) goto L_0x0244
            goto L_0x0249
        L_0x0244:
            r14 = r37
            goto L_0x0297
        L_0x0247:
            r2 = r23
        L_0x0249:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r14 = "Inconsistent stbl box for track "
            r5.append(r14)
            r14 = r37
            int r15 = r14.f13658a
            r5.append(r15)
            java.lang.String r15 = ": remainingSynchronizationSamples "
            r5.append(r15)
            r5.append(r9)
            java.lang.String r9 = ", remainingSamplesAtTimestampDelta "
            r5.append(r9)
            r9 = r30
            r5.append(r9)
            java.lang.String r9 = ", remainingSamplesInChunk "
            r5.append(r9)
            r5.append(r1)
            java.lang.String r1 = ", remainingTimestampDeltaChanges "
            r5.append(r1)
            r9 = r38
            r5.append(r9)
            java.lang.String r1 = ", remainingSamplesAtTimestampOffset "
            r5.append(r1)
            r5.append(r2)
            if (r0 != 0) goto L_0x028b
            java.lang.String r0 = ", ctts invalid"
            goto L_0x028d
        L_0x028b:
            java.lang.String r0 = ""
        L_0x028d:
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            androidx.media3.common.util.Log.n(r10, r0)
        L_0x0297:
            r0 = r3
            r2 = r4
            r3 = r6
            r4 = r11
            r15 = r12
            r12 = r7
            r13 = r8
        L_0x029e:
            r7 = 1000000(0xf4240, double:4.940656E-318)
            long r9 = r14.f13660c
            r5 = r15
            long r7 = androidx.media3.common.util.Util.c2(r5, r7, r9)
            long[] r1 = r14.f13665h
            r10 = 1000000(0xf4240, double:4.940656E-318)
            if (r1 != 0) goto L_0x02bf
            long r0 = r14.f13660c
            androidx.media3.common.util.Util.e2(r12, r10, r0)
            androidx.media3.extractor.mp4.TrackSampleTable r9 = new androidx.media3.extractor.mp4.TrackSampleTable
            r0 = r9
            r1 = r37
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x02bf:
            int r1 = r1.length
            r5 = 1
            if (r1 != r5) goto L_0x035f
            int r1 = r14.f13659b
            if (r1 != r5) goto L_0x035f
            int r1 = r12.length
            r5 = 2
            if (r1 < r5) goto L_0x035f
            long[] r1 = r14.f13666i
            java.lang.Object r1 = androidx.media3.common.util.Assertions.g(r1)
            long[] r1 = (long[]) r1
            r5 = 0
            r21 = r1[r5]
            long[] r1 = r14.f13665h
            r23 = r1[r5]
            long r5 = r14.f13660c
            long r7 = r14.f13661d
            r25 = r5
            r27 = r7
            long r5 = androidx.media3.common.util.Util.c2(r23, r25, r27)
            long r23 = r21 + r5
            r5 = r12
            r6 = r15
            r8 = r21
            r25 = r0
            r0 = r10
            r10 = r23
            boolean r5 = b(r5, r6, r8, r10)
            if (r5 == 0) goto L_0x035c
            long r6 = r15 - r23
            r5 = 0
            r8 = r12[r5]
            long r26 = r21 - r8
            androidx.media3.common.Format r5 = r14.f13663f
            int r5 = r5.t3
            long r8 = (long) r5
            long r10 = r14.f13660c
            r28 = r8
            r30 = r10
            long r10 = androidx.media3.common.util.Util.c2(r26, r28, r30)
            androidx.media3.common.Format r5 = r14.f13663f
            int r5 = r5.t3
            long r8 = (long) r5
            long r0 = r14.f13660c
            r38 = r4
            r4 = r10
            r10 = r0
            long r0 = androidx.media3.common.util.Util.c2(r6, r8, r10)
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0326
            int r8 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0362
        L_0x0326:
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 > 0) goto L_0x0362
            int r8 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r8 > 0) goto L_0x0362
            int r5 = (int) r4
            r4 = r39
            r4.f13068a = r5
            int r1 = (int) r0
            r4.f13069b = r1
            long r0 = r14.f13660c
            r4 = 1000000(0xf4240, double:4.940656E-318)
            androidx.media3.common.util.Util.e2(r12, r4, r0)
            long[] r0 = r14.f13665h
            r1 = 0
            r4 = r0[r1]
            r6 = 1000000(0xf4240, double:4.940656E-318)
            long r8 = r14.f13661d
            long r7 = androidx.media3.common.util.Util.c2(r4, r6, r8)
            androidx.media3.extractor.mp4.TrackSampleTable r9 = new androidx.media3.extractor.mp4.TrackSampleTable
            r0 = r9
            r1 = r37
            r4 = r38
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x035c:
            r38 = r4
            goto L_0x0362
        L_0x035f:
            r25 = r0
            goto L_0x035c
        L_0x0362:
            long[] r0 = r14.f13665h
            int r1 = r0.length
            r4 = 1
            if (r1 != r4) goto L_0x03ad
            r1 = 0
            r4 = r0[r1]
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x03ad
            long[] r0 = r14.f13666i
            java.lang.Object r0 = androidx.media3.common.util.Assertions.g(r0)
            long[] r0 = (long[]) r0
            r4 = r0[r1]
            r6 = 0
        L_0x037c:
            int r0 = r12.length
            if (r6 >= r0) goto L_0x0393
            r0 = r12[r6]
            long r17 = r0 - r4
            r19 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r14.f13660c
            r21 = r0
            long r0 = androidx.media3.common.util.Util.c2(r17, r19, r21)
            r12[r6] = r0
            int r6 = r6 + 1
            goto L_0x037c
        L_0x0393:
            long r17 = r15 - r4
            r19 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r14.f13660c
            r21 = r0
            long r7 = androidx.media3.common.util.Util.c2(r17, r19, r21)
            androidx.media3.extractor.mp4.TrackSampleTable r9 = new androidx.media3.extractor.mp4.TrackSampleTable
            r0 = r9
            r1 = r37
            r4 = r38
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x03ad:
            int r1 = r14.f13659b
            r4 = 1
            if (r1 != r4) goto L_0x03b4
            r10 = 1
            goto L_0x03b5
        L_0x03b4:
            r10 = 0
        L_0x03b5:
            int r1 = r0.length
            int[] r1 = new int[r1]
            int r0 = r0.length
            int[] r0 = new int[r0]
            long[] r4 = r14.f13666i
            java.lang.Object r4 = androidx.media3.common.util.Assertions.g(r4)
            long[] r4 = (long[]) r4
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x03c7:
            long[] r9 = r14.f13665h
            int r11 = r9.length
            if (r5 >= r11) goto L_0x0428
            r11 = r2
            r15 = r3
            r2 = r4[r5]
            r21 = -1
            int r16 = (r2 > r21 ? 1 : (r2 == r21 ? 0 : -1))
            if (r16 == 0) goto L_0x0417
            r26 = r9[r5]
            r16 = r8
            long r8 = r14.f13660c
            r39 = r6
            r21 = r7
            long r6 = r14.f13661d
            r28 = r8
            r30 = r6
            long r6 = androidx.media3.common.util.Util.c2(r26, r28, r30)
            r8 = 1
            int r9 = androidx.media3.common.util.Util.n(r12, r2, r8, r8)
            r1[r5] = r9
            long r2 = r2 + r6
            r6 = 0
            int r2 = androidx.media3.common.util.Util.j(r12, r2, r10, r6)
            r0[r5] = r2
        L_0x03f9:
            r2 = r1[r5]
            r3 = r0[r5]
            if (r2 >= r3) goto L_0x0409
            r7 = r13[r2]
            r7 = r7 & r8
            if (r7 != 0) goto L_0x0409
            int r2 = r2 + 1
            r1[r5] = r2
            goto L_0x03f9
        L_0x0409:
            int r7 = r3 - r2
            int r7 = r21 + r7
            r9 = r16
            if (r9 == r2) goto L_0x0413
            r2 = 1
            goto L_0x0414
        L_0x0413:
            r2 = 0
        L_0x0414:
            r2 = r39 | r2
            goto L_0x0421
        L_0x0417:
            r39 = r6
            r21 = r7
            r9 = r8
            r6 = 0
            r8 = 1
            r2 = r39
            r3 = r9
        L_0x0421:
            int r5 = r5 + 1
            r6 = r2
            r8 = r3
            r2 = r11
            r3 = r15
            goto L_0x03c7
        L_0x0428:
            r11 = r2
            r15 = r3
            r39 = r6
            r3 = r25
            r6 = 0
            r8 = 1
            if (r7 == r3) goto L_0x0433
            goto L_0x0434
        L_0x0433:
            r8 = 0
        L_0x0434:
            r2 = r39 | r8
            if (r2 == 0) goto L_0x043b
            long[] r3 = new long[r7]
            goto L_0x043c
        L_0x043b:
            r3 = r11
        L_0x043c:
            if (r2 == 0) goto L_0x0441
            int[] r4 = new int[r7]
            goto L_0x0442
        L_0x0441:
            r4 = r15
        L_0x0442:
            if (r2 == 0) goto L_0x0446
            r5 = 0
            goto L_0x0448
        L_0x0446:
            r5 = r38
        L_0x0448:
            if (r2 == 0) goto L_0x044d
            int[] r8 = new int[r7]
            goto L_0x044e
        L_0x044d:
            r8 = r13
        L_0x044e:
            long[] r7 = new long[r7]
            r39 = r5
            r38 = r15
            r9 = 0
            r15 = 0
        L_0x0457:
            long[] r5 = r14.f13665h
            int r5 = r5.length
            if (r6 >= r5) goto L_0x0501
            long[] r5 = r14.f13666i
            r16 = r5[r6]
            r5 = r1[r6]
            r18 = r1
            r1 = r0[r6]
            r27 = r0
            if (r2 == 0) goto L_0x047a
            int r0 = r1 - r5
            java.lang.System.arraycopy(r11, r5, r3, r15, r0)
            r28 = r11
            r11 = r38
            java.lang.System.arraycopy(r11, r5, r4, r15, r0)
            java.lang.System.arraycopy(r13, r5, r8, r15, r0)
            goto L_0x047e
        L_0x047a:
            r28 = r11
            r11 = r38
        L_0x047e:
            r0 = r39
        L_0x0480:
            if (r5 >= r1) goto L_0x04db
            r23 = 1000000(0xf4240, double:4.940656E-318)
            r29 = r0
            r38 = r1
            long r0 = r14.f13661d
            r21 = r9
            r25 = r0
            long r0 = androidx.media3.common.util.Util.c2(r21, r23, r25)
            r21 = r12[r5]
            long r30 = r21 - r16
            r32 = 1000000(0xf4240, double:4.940656E-318)
            r21 = r12
            r22 = r13
            long r12 = r14.f13660c
            r34 = r12
            long r12 = androidx.media3.common.util.Util.c2(r30, r32, r34)
            r30 = r8
            int r8 = r14.f13659b
            boolean r8 = c(r8)
            r23 = r9
            if (r8 == 0) goto L_0x04b9
            r8 = 0
            long r12 = java.lang.Math.max(r8, r12)
            goto L_0x04bb
        L_0x04b9:
            r8 = 0
        L_0x04bb:
            long r0 = r0 + r12
            r7[r15] = r0
            if (r2 == 0) goto L_0x04c9
            r0 = r4[r15]
            r1 = r29
            if (r0 <= r1) goto L_0x04cb
            r0 = r11[r5]
            goto L_0x04cc
        L_0x04c9:
            r1 = r29
        L_0x04cb:
            r0 = r1
        L_0x04cc:
            int r15 = r15 + 1
            int r5 = r5 + 1
            r1 = r38
            r12 = r21
            r13 = r22
            r9 = r23
            r8 = r30
            goto L_0x0480
        L_0x04db:
            r1 = r0
            r30 = r8
            r23 = r9
            r21 = r12
            r22 = r13
            r8 = 0
            long[] r0 = r14.f13665h
            r12 = r0[r6]
            long r12 = r23 + r12
            int r6 = r6 + 1
            r39 = r1
            r38 = r11
            r9 = r12
            r1 = r18
            r12 = r21
            r13 = r22
            r0 = r27
            r11 = r28
            r8 = r30
            goto L_0x0457
        L_0x0501:
            r30 = r8
            r23 = r9
            r0 = 1000000(0xf4240, double:4.940656E-318)
            long r5 = r14.f13661d
            r21 = r23
            r23 = r0
            r25 = r5
            long r8 = androidx.media3.common.util.Util.c2(r21, r23, r25)
            androidx.media3.extractor.mp4.TrackSampleTable r10 = new androidx.media3.extractor.mp4.TrackSampleTable
            r0 = r10
            r1 = r37
            r2 = r3
            r3 = r4
            r4 = r39
            r5 = r7
            r6 = r30
            r7 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r10
        L_0x0525:
            java.lang.String r0 = "Track has no sample table size information"
            r1 = 0
            androidx.media3.common.ParserException r0 = androidx.media3.common.ParserException.a(r0, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.AtomParsers.w(androidx.media3.extractor.mp4.Track, androidx.media3.extractor.mp4.Atom$ContainerAtom, androidx.media3.extractor.GaplessInfoHolder):androidx.media3.extractor.mp4.TrackSampleTable");
    }

    private static StsdData x(ParsableByteArray parsableByteArray, int i2, int i3, String str, @Nullable DrmInitData drmInitData, boolean z) throws ParserException {
        int i4;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i5 = i2;
        parsableByteArray2.Y(12);
        int s = parsableByteArray.s();
        StsdData stsdData = new StsdData(s);
        for (int i6 = 0; i6 < s; i6++) {
            int f2 = parsableByteArray.f();
            int s2 = parsableByteArray.s();
            ExtractorUtil.a(s2 > 0, "childAtomSize must be positive");
            int s3 = parsableByteArray.s();
            if (s3 == 1635148593 || s3 == 1635148595 || s3 == 1701733238 || s3 == 1831958048 || s3 == 1836070006 || s3 == 1752589105 || s3 == 1751479857 || s3 == 1932670515 || s3 == 1211250227 || s3 == 1987063864 || s3 == 1987063865 || s3 == 1635135537 || s3 == 1685479798 || s3 == 1685479729 || s3 == 1685481573 || s3 == 1685481521) {
                i4 = f2;
                E(parsableByteArray, s3, i4, s2, i2, i3, drmInitData, stsdData, i6);
            } else if (s3 == 1836069985 || s3 == 1701733217 || s3 == 1633889587 || s3 == 1700998451 || s3 == 1633889588 || s3 == 1835823201 || s3 == 1685353315 || s3 == 1685353317 || s3 == 1685353320 || s3 == 1685353324 || s3 == 1685353336 || s3 == 1935764850 || s3 == 1935767394 || s3 == 1819304813 || s3 == 1936684916 || s3 == 1953984371 || s3 == 778924082 || s3 == 778924083 || s3 == 1835557169 || s3 == 1835560241 || s3 == 1634492771 || s3 == 1634492791 || s3 == 1970037111 || s3 == 1332770163 || s3 == 1716281667) {
                i4 = f2;
                g(parsableByteArray, s3, f2, s2, i2, str, z, drmInitData, stsdData, i6);
            } else {
                if (s3 == 1414810956 || s3 == 1954034535 || s3 == 2004251764 || s3 == 1937010800 || s3 == 1664495672) {
                    y(parsableByteArray, s3, f2, s2, i2, str, stsdData);
                } else if (s3 == 1835365492) {
                    q(parsableByteArray2, s3, f2, i5, stsdData);
                } else if (s3 == 1667329389) {
                    stsdData.f13539b = new Format.Builder().W(i5).k0(MimeTypes.H0).I();
                }
                i4 = f2;
            }
            parsableByteArray2.Y(i4 + s2);
        }
        return stsdData;
    }

    private static void y(ParsableByteArray parsableByteArray, int i2, int i3, int i4, int i5, String str, StsdData stsdData) {
        parsableByteArray.Y(i3 + 16);
        String str2 = MimeTypes.z0;
        ImmutableList immutableList = null;
        long j2 = Long.MAX_VALUE;
        if (i2 != 1414810956) {
            if (i2 == 1954034535) {
                int i6 = i4 - 16;
                byte[] bArr = new byte[i6];
                parsableByteArray.n(bArr, 0, i6);
                immutableList = ImmutableList.K(bArr);
                str2 = MimeTypes.A0;
            } else if (i2 == 2004251764) {
                str2 = MimeTypes.B0;
            } else if (i2 == 1937010800) {
                j2 = 0;
            } else if (i2 == 1664495672) {
                stsdData.f13541d = 1;
                str2 = MimeTypes.C0;
            } else {
                throw new IllegalStateException();
            }
        }
        stsdData.f13539b = new Format.Builder().W(i5).k0(str2).b0(str).o0(j2).Y(immutableList).I();
    }

    private static TkhdData z(ParsableByteArray parsableByteArray) {
        long j2;
        int i2 = 8;
        parsableByteArray.Y(8);
        int c2 = Atom.c(parsableByteArray.s());
        parsableByteArray.Z(c2 == 0 ? 8 : 16);
        int s = parsableByteArray.s();
        parsableByteArray.Z(4);
        int f2 = parsableByteArray.f();
        if (c2 == 0) {
            i2 = 4;
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            j2 = C.f9084b;
            if (i4 >= i2) {
                parsableByteArray.Z(i2);
                break;
            } else if (parsableByteArray.e()[f2 + i4] != -1) {
                long N = c2 == 0 ? parsableByteArray.N() : parsableByteArray.Q();
                if (N != 0) {
                    j2 = N;
                }
            } else {
                i4++;
            }
        }
        parsableByteArray.Z(16);
        int s2 = parsableByteArray.s();
        int s3 = parsableByteArray.s();
        parsableByteArray.Z(4);
        int s4 = parsableByteArray.s();
        int s5 = parsableByteArray.s();
        if (s2 == 0 && s3 == 65536 && s4 == -65536 && s5 == 0) {
            i3 = 90;
        } else if (s2 == 0 && s3 == -65536 && s4 == 65536 && s5 == 0) {
            i3 = TIFFConstants.e0;
        } else if (s2 == -65536 && s3 == 0 && s4 == 0 && s5 == -65536) {
            i3 = BuildConfig.f29478d;
        }
        return new TkhdData(s, j2, i3);
    }
}
