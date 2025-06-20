package androidx.media3.extractor.mp4;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.Ac4Util;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.TrueHdSampleRechunker;
import androidx.media3.extractor.d;
import androidx.media3.extractor.metadata.mp4.MotionPhotoMetadata;
import androidx.media3.extractor.mp4.Atom;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.SubtitleTranscodingExtractorOutput;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

@UnstableApi
public final class Mp4Extractor implements Extractor, SeekMap {
    public static final int D = 1;
    public static final int E = 2;
    public static final int F = 4;
    public static final int G = 8;
    public static final int H = 16;
    @Deprecated
    public static final ExtractorsFactory I = new f();
    private static final int J = 0;
    private static final int K = 1;
    private static final int L = 2;
    private static final int M = 3;
    private static final int N = 0;
    private static final int O = 1;
    private static final int P = 2;
    private static final long Q = 262144;
    private static final long R = 10485760;
    private long A;
    private int B;
    @Nullable
    private MotionPhotoMetadata C;

    /* renamed from: d  reason: collision with root package name */
    private final SubtitleParser.Factory f13605d;

    /* renamed from: e  reason: collision with root package name */
    private final int f13606e;

    /* renamed from: f  reason: collision with root package name */
    private final ParsableByteArray f13607f;

    /* renamed from: g  reason: collision with root package name */
    private final ParsableByteArray f13608g;

    /* renamed from: h  reason: collision with root package name */
    private final ParsableByteArray f13609h;

    /* renamed from: i  reason: collision with root package name */
    private final ParsableByteArray f13610i;

    /* renamed from: j  reason: collision with root package name */
    private final ArrayDeque<Atom.ContainerAtom> f13611j;

    /* renamed from: k  reason: collision with root package name */
    private final SefReader f13612k;

    /* renamed from: l  reason: collision with root package name */
    private final List<Metadata.Entry> f13613l;

    /* renamed from: m  reason: collision with root package name */
    private int f13614m;

    /* renamed from: n  reason: collision with root package name */
    private int f13615n;
    private long o;
    private int p;
    @Nullable
    private ParsableByteArray q;
    private int r;
    private int s;
    private int t;
    private int u;
    private boolean v;
    private ExtractorOutput w;
    private Mp4Track[] x;
    private long[][] y;
    private int z;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    private static final class Mp4Track {

        /* renamed from: a  reason: collision with root package name */
        public final Track f13616a;

        /* renamed from: b  reason: collision with root package name */
        public final TrackSampleTable f13617b;

        /* renamed from: c  reason: collision with root package name */
        public final TrackOutput f13618c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public final TrueHdSampleRechunker f13619d;

        /* renamed from: e  reason: collision with root package name */
        public int f13620e;

        public Mp4Track(Track track, TrackSampleTable trackSampleTable, TrackOutput trackOutput) {
            this.f13616a = track;
            this.f13617b = trackSampleTable;
            this.f13618c = trackOutput;
            this.f13619d = MimeTypes.U.equals(track.f13663f.f3) ? new TrueHdSampleRechunker() : null;
        }
    }

    @Deprecated
    public Mp4Extractor() {
        this(SubtitleParser.Factory.f13783a, 16);
    }

    public static ExtractorsFactory A(SubtitleParser.Factory factory) {
        return new e(factory);
    }

    private void B(long j2) throws ParserException {
        while (!this.f13611j.isEmpty() && this.f13611j.peek().G1 == j2) {
            Atom.ContainerAtom pop = this.f13611j.pop();
            if (pop.f13510a == 1836019574) {
                E(pop);
                this.f13611j.clear();
                this.f13614m = 2;
            } else if (!this.f13611j.isEmpty()) {
                this.f13611j.peek().d(pop);
            }
        }
        if (this.f13614m != 2) {
            r();
        }
    }

    private void C() {
        Metadata metadata;
        if (this.B == 2 && (this.f13606e & 2) != 0) {
            TrackOutput d2 = this.w.d(0, 4);
            if (this.C == null) {
                metadata = null;
            } else {
                metadata = new Metadata(this.C);
            }
            d2.e(new Format.Builder().d0(metadata).I());
            this.w.o();
            this.w.j(new SeekMap.Unseekable(C.f9084b));
        }
    }

    private static int D(ParsableByteArray parsableByteArray) {
        parsableByteArray.Y(8);
        int p2 = p(parsableByteArray.s());
        if (p2 != 0) {
            return p2;
        }
        parsableByteArray.Z(4);
        while (parsableByteArray.a() > 0) {
            int p3 = p(parsableByteArray.s());
            if (p3 != 0) {
                return p3;
            }
        }
        return 0;
    }

    private void E(Atom.ContainerAtom containerAtom) throws ParserException {
        Metadata metadata;
        List<TrackSampleTable> list;
        int i2;
        int i3;
        GaplessInfoHolder gaplessInfoHolder;
        int i4;
        Atom.ContainerAtom containerAtom2 = containerAtom;
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        boolean z2 = this.B == 1;
        GaplessInfoHolder gaplessInfoHolder2 = new GaplessInfoHolder();
        Atom.LeafAtom h2 = containerAtom2.h(Atom.f1);
        if (h2 != null) {
            Metadata C2 = AtomParsers.C(h2);
            gaplessInfoHolder2.c(C2);
            metadata = C2;
        } else {
            metadata = null;
        }
        Atom.ContainerAtom g2 = containerAtom2.g(Atom.g1);
        Metadata p2 = g2 != null ? AtomParsers.p(g2) : null;
        Metadata metadata2 = new Metadata(AtomParsers.r(((Atom.LeafAtom) Assertions.g(containerAtom2.h(Atom.j0))).G1));
        boolean z3 = (this.f13606e & 1) != 0;
        d dVar = new d();
        long j2 = C.f9084b;
        Metadata metadata3 = metadata2;
        Metadata metadata4 = p2;
        List<TrackSampleTable> B2 = AtomParsers.B(containerAtom, gaplessInfoHolder2, C.f9084b, (DrmInitData) null, z3, z2, dVar);
        long j3 = -9223372036854775807L;
        int i6 = 0;
        int i7 = -1;
        while (i6 < B2.size()) {
            TrackSampleTable trackSampleTable = B2.get(i6);
            if (trackSampleTable.f13690b == 0) {
                list = B2;
                i2 = i5;
                gaplessInfoHolder = gaplessInfoHolder2;
                i3 = 1;
            } else {
                Track track = trackSampleTable.f13689a;
                GaplessInfoHolder gaplessInfoHolder3 = gaplessInfoHolder2;
                long j4 = track.f13662e;
                if (j4 == j2) {
                    j4 = trackSampleTable.f13696h;
                }
                j3 = Math.max(j3, j4);
                i2 = i5 + 1;
                list = B2;
                Mp4Track mp4Track = new Mp4Track(track, trackSampleTable, this.w.d(i5, track.f13659b));
                int i8 = MimeTypes.U.equals(track.f13663f.f3) ? trackSampleTable.f13693e * 16 : trackSampleTable.f13693e + 30;
                Format.Builder c2 = track.f13663f.c();
                c2.c0(i8);
                if (track.f13659b == 2) {
                    if ((this.f13606e & 8) != 0) {
                        c2.i0(track.f13663f.Y2 | (i7 == -1 ? 1 : 2));
                    }
                    if (j4 > 0 && (i4 = trackSampleTable.f13690b) > 0) {
                        c2.U(((float) i4) / (((float) j4) / 1000000.0f));
                    }
                }
                gaplessInfoHolder = gaplessInfoHolder3;
                MetadataUtil.k(track.f13659b, gaplessInfoHolder, c2);
                MetadataUtil.l(track.f13659b, metadata4, c2, this.f13613l.isEmpty() ? null : new Metadata((List<? extends Metadata.Entry>) this.f13613l), metadata, metadata3);
                mp4Track.f13618c.e(c2.I());
                if (track.f13659b == 2) {
                    if (i7 == -1) {
                        i7 = arrayList.size();
                    }
                }
                arrayList.add(mp4Track);
                i3 = 1;
            }
            i6 += i3;
            gaplessInfoHolder2 = gaplessInfoHolder;
            i5 = i2;
            B2 = list;
            j2 = C.f9084b;
        }
        this.z = i7;
        this.A = j3;
        Mp4Track[] mp4TrackArr = (Mp4Track[]) arrayList.toArray(new Mp4Track[0]);
        this.x = mp4TrackArr;
        this.y = q(mp4TrackArr);
        this.w.o();
        this.w.j(this);
    }

    private void F(long j2) {
        if (this.f13615n == 1836086884) {
            int i2 = this.p;
            this.C = new MotionPhotoMetadata(0, j2, C.f9084b, j2 + ((long) i2), this.o - ((long) i2));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0109  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean G(androidx.media3.extractor.ExtractorInput r9) throws java.io.IOException {
        /*
            r8 = this;
            int r0 = r8.p
            r1 = 1
            r2 = 8
            r3 = 0
            if (r0 != 0) goto L_0x002f
            androidx.media3.common.util.ParsableByteArray r0 = r8.f13610i
            byte[] r0 = r0.e()
            boolean r0 = r9.d(r0, r3, r2, r1)
            if (r0 != 0) goto L_0x0018
            r8.C()
            return r3
        L_0x0018:
            r8.p = r2
            androidx.media3.common.util.ParsableByteArray r0 = r8.f13610i
            r0.Y(r3)
            androidx.media3.common.util.ParsableByteArray r0 = r8.f13610i
            long r4 = r0.N()
            r8.o = r4
            androidx.media3.common.util.ParsableByteArray r0 = r8.f13610i
            int r0 = r0.s()
            r8.f13615n = r0
        L_0x002f:
            long r4 = r8.o
            r6 = 1
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x004e
            androidx.media3.common.util.ParsableByteArray r0 = r8.f13610i
            byte[] r0 = r0.e()
            r9.readFully(r0, r2, r2)
            int r0 = r8.p
            int r0 = r0 + r2
            r8.p = r0
            androidx.media3.common.util.ParsableByteArray r0 = r8.f13610i
            long r4 = r0.Q()
        L_0x004b:
            r8.o = r4
            goto L_0x0078
        L_0x004e:
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x0078
            long r4 = r9.getLength()
            r6 = -1
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x006a
            java.util.ArrayDeque<androidx.media3.extractor.mp4.Atom$ContainerAtom> r0 = r8.f13611j
            java.lang.Object r0 = r0.peek()
            androidx.media3.extractor.mp4.Atom$ContainerAtom r0 = (androidx.media3.extractor.mp4.Atom.ContainerAtom) r0
            if (r0 == 0) goto L_0x006a
            long r4 = r0.G1
        L_0x006a:
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0078
            long r6 = r9.getPosition()
            long r4 = r4 - r6
            int r0 = r8.p
            long r6 = (long) r0
            long r4 = r4 + r6
            goto L_0x004b
        L_0x0078:
            long r4 = r8.o
            int r0 = r8.p
            long r6 = (long) r0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 < 0) goto L_0x0109
            int r0 = r8.f13615n
            boolean r0 = K(r0)
            if (r0 == 0) goto L_0x00c0
            long r2 = r9.getPosition()
            long r4 = r8.o
            long r2 = r2 + r4
            int r0 = r8.p
            long r6 = (long) r0
            long r2 = r2 - r6
            long r6 = (long) r0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x00a3
            int r0 = r8.f13615n
            r4 = 1835365473(0x6d657461, float:4.4382975E27)
            if (r0 != r4) goto L_0x00a3
            r8.z(r9)
        L_0x00a3:
            java.util.ArrayDeque<androidx.media3.extractor.mp4.Atom$ContainerAtom> r9 = r8.f13611j
            androidx.media3.extractor.mp4.Atom$ContainerAtom r0 = new androidx.media3.extractor.mp4.Atom$ContainerAtom
            int r4 = r8.f13615n
            r0.<init>(r4, r2)
            r9.push(r0)
            long r4 = r8.o
            int r9 = r8.p
            long r6 = (long) r9
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 != 0) goto L_0x00bc
            r8.B(r2)
            goto L_0x0108
        L_0x00bc:
            r8.r()
            goto L_0x0108
        L_0x00c0:
            int r0 = r8.f13615n
            boolean r0 = L(r0)
            if (r0 == 0) goto L_0x00fb
            int r9 = r8.p
            if (r9 != r2) goto L_0x00ce
            r9 = 1
            goto L_0x00cf
        L_0x00ce:
            r9 = 0
        L_0x00cf:
            androidx.media3.common.util.Assertions.i(r9)
            long r4 = r8.o
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 > 0) goto L_0x00dd
            r9 = 1
            goto L_0x00de
        L_0x00dd:
            r9 = 0
        L_0x00de:
            androidx.media3.common.util.Assertions.i(r9)
            androidx.media3.common.util.ParsableByteArray r9 = new androidx.media3.common.util.ParsableByteArray
            long r4 = r8.o
            int r0 = (int) r4
            r9.<init>((int) r0)
            androidx.media3.common.util.ParsableByteArray r0 = r8.f13610i
            byte[] r0 = r0.e()
            byte[] r4 = r9.e()
            java.lang.System.arraycopy(r0, r3, r4, r3, r2)
        L_0x00f6:
            r8.q = r9
            r8.f13614m = r1
            goto L_0x0108
        L_0x00fb:
            long r2 = r9.getPosition()
            int r9 = r8.p
            long r4 = (long) r9
            long r2 = r2 - r4
            r8.F(r2)
            r9 = 0
            goto L_0x00f6
        L_0x0108:
            return r1
        L_0x0109:
            java.lang.String r9 = "Atom size less than header length (unsupported)."
            androidx.media3.common.ParserException r9 = androidx.media3.common.ParserException.e(r9)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.Mp4Extractor.G(androidx.media3.extractor.ExtractorInput):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0073 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean H(androidx.media3.extractor.ExtractorInput r10, androidx.media3.extractor.PositionHolder r11) throws java.io.IOException {
        /*
            r9 = this;
            long r0 = r9.o
            int r2 = r9.p
            long r2 = (long) r2
            long r0 = r0 - r2
            long r2 = r10.getPosition()
            long r2 = r2 + r0
            androidx.media3.common.util.ParsableByteArray r4 = r9.q
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0046
            byte[] r11 = r4.e()
            int r7 = r9.p
            int r1 = (int) r0
            r10.readFully(r11, r7, r1)
            int r10 = r9.f13615n
            r11 = 1718909296(0x66747970, float:2.8862439E23)
            if (r10 != r11) goto L_0x002b
            r9.v = r5
            int r10 = D(r4)
            r9.B = r10
            goto L_0x005e
        L_0x002b:
            java.util.ArrayDeque<androidx.media3.extractor.mp4.Atom$ContainerAtom> r10 = r9.f13611j
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto L_0x005e
            java.util.ArrayDeque<androidx.media3.extractor.mp4.Atom$ContainerAtom> r10 = r9.f13611j
            java.lang.Object r10 = r10.peek()
            androidx.media3.extractor.mp4.Atom$ContainerAtom r10 = (androidx.media3.extractor.mp4.Atom.ContainerAtom) r10
            androidx.media3.extractor.mp4.Atom$LeafAtom r11 = new androidx.media3.extractor.mp4.Atom$LeafAtom
            int r0 = r9.f13615n
            r11.<init>(r0, r4)
            r10.e(r11)
            goto L_0x005e
        L_0x0046:
            boolean r4 = r9.v
            if (r4 != 0) goto L_0x0053
            int r4 = r9.f13615n
            r7 = 1835295092(0x6d646174, float:4.4175247E27)
            if (r4 != r7) goto L_0x0053
            r9.B = r5
        L_0x0053:
            r7 = 262144(0x40000, double:1.295163E-318)
            int r4 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r4 >= 0) goto L_0x0060
            int r11 = (int) r0
            r10.o(r11)
        L_0x005e:
            r10 = 0
            goto L_0x0068
        L_0x0060:
            long r7 = r10.getPosition()
            long r7 = r7 + r0
            r11.f13111a = r7
            r10 = 1
        L_0x0068:
            r9.B(r2)
            if (r10 == 0) goto L_0x0073
            int r10 = r9.f13614m
            r11 = 2
            if (r10 == r11) goto L_0x0073
            goto L_0x0074
        L_0x0073:
            r5 = 0
        L_0x0074:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.Mp4Extractor.H(androidx.media3.extractor.ExtractorInput, androidx.media3.extractor.PositionHolder):boolean");
    }

    private int I(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i2;
        PositionHolder positionHolder2;
        ExtractorInput extractorInput2 = extractorInput;
        long position = extractorInput.getPosition();
        if (this.r == -1) {
            int u2 = u(position);
            this.r = u2;
            if (u2 == -1) {
                return -1;
            }
        }
        Mp4Track mp4Track = this.x[this.r];
        TrackOutput trackOutput = mp4Track.f13618c;
        int i3 = mp4Track.f13620e;
        TrackSampleTable trackSampleTable = mp4Track.f13617b;
        long j2 = trackSampleTable.f13691c[i3];
        int i4 = trackSampleTable.f13692d[i3];
        TrueHdSampleRechunker trueHdSampleRechunker = mp4Track.f13619d;
        long j3 = (j2 - position) + ((long) this.s);
        if (j3 < 0) {
            i2 = 1;
            positionHolder2 = positionHolder;
        } else if (j3 >= 262144) {
            positionHolder2 = positionHolder;
            i2 = 1;
        } else {
            if (mp4Track.f13616a.f13664g == 1) {
                j3 += 8;
                i4 -= 8;
            }
            extractorInput2.o((int) j3);
            Track track = mp4Track.f13616a;
            if (track.f13667j == 0) {
                if (MimeTypes.T.equals(track.f13663f.f3)) {
                    if (this.t == 0) {
                        Ac4Util.a(i4, this.f13609h);
                        trackOutput.d(this.f13609h, 7);
                        this.t += 7;
                    }
                    i4 += 7;
                } else if (trueHdSampleRechunker != null) {
                    trueHdSampleRechunker.d(extractorInput2);
                }
                while (true) {
                    int i5 = this.t;
                    if (i5 >= i4) {
                        break;
                    }
                    int b2 = trackOutput.b(extractorInput2, i4 - i5, false);
                    this.s += b2;
                    this.t += b2;
                    this.u -= b2;
                }
            } else {
                byte[] e2 = this.f13608g.e();
                e2[0] = 0;
                e2[1] = 0;
                e2[2] = 0;
                int i6 = mp4Track.f13616a.f13667j;
                int i7 = 4 - i6;
                while (this.t < i4) {
                    int i8 = this.u;
                    if (i8 == 0) {
                        extractorInput2.readFully(e2, i7, i6);
                        this.s += i6;
                        this.f13608g.Y(0);
                        int s2 = this.f13608g.s();
                        if (s2 >= 0) {
                            this.u = s2;
                            this.f13607f.Y(0);
                            trackOutput.d(this.f13607f, 4);
                            this.t += 4;
                            i4 += i7;
                        } else {
                            throw ParserException.a("Invalid NAL length", (Throwable) null);
                        }
                    } else {
                        int b3 = trackOutput.b(extractorInput2, i8, false);
                        this.s += b3;
                        this.t += b3;
                        this.u -= b3;
                    }
                }
            }
            int i9 = i4;
            TrackSampleTable trackSampleTable2 = mp4Track.f13617b;
            long j4 = trackSampleTable2.f13694f[i3];
            int i10 = trackSampleTable2.f13695g[i3];
            if (trueHdSampleRechunker != null) {
                int i11 = i9;
                TrueHdSampleRechunker trueHdSampleRechunker2 = trueHdSampleRechunker;
                trueHdSampleRechunker.c(trackOutput, j4, i10, i11, 0, (TrackOutput.CryptoData) null);
                if (i3 + 1 == mp4Track.f13617b.f13690b) {
                    trueHdSampleRechunker2.a(trackOutput, (TrackOutput.CryptoData) null);
                }
            } else {
                trackOutput.f(j4, i10, i9, 0, (TrackOutput.CryptoData) null);
            }
            mp4Track.f13620e++;
            this.r = -1;
            this.s = 0;
            this.t = 0;
            this.u = 0;
            return 0;
        }
        positionHolder2.f13111a = j2;
        return i2;
    }

    private int J(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int c2 = this.f13612k.c(extractorInput, positionHolder, this.f13613l);
        if (c2 == 1 && positionHolder.f13111a == 0) {
            r();
        }
        return c2;
    }

    private static boolean K(int i2) {
        return i2 == 1836019574 || i2 == 1953653099 || i2 == 1835297121 || i2 == 1835626086 || i2 == 1937007212 || i2 == 1701082227 || i2 == 1835365473;
    }

    private static boolean L(int i2) {
        return i2 == 1835296868 || i2 == 1836476516 || i2 == 1751411826 || i2 == 1937011556 || i2 == 1937011827 || i2 == 1937011571 || i2 == 1668576371 || i2 == 1701606260 || i2 == 1937011555 || i2 == 1937011578 || i2 == 1937013298 || i2 == 1937007471 || i2 == 1668232756 || i2 == 1953196132 || i2 == 1718909296 || i2 == 1969517665 || i2 == 1801812339 || i2 == 1768715124;
    }

    private void M(Mp4Track mp4Track, long j2) {
        TrackSampleTable trackSampleTable = mp4Track.f13617b;
        int a2 = trackSampleTable.a(j2);
        if (a2 == -1) {
            a2 = trackSampleTable.b(j2);
        }
        mp4Track.f13620e = a2;
    }

    private static int p(int i2) {
        if (i2 != 1751476579) {
            return i2 != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private static long[][] q(Mp4Track[] mp4TrackArr) {
        long[][] jArr = new long[mp4TrackArr.length][];
        int[] iArr = new int[mp4TrackArr.length];
        long[] jArr2 = new long[mp4TrackArr.length];
        boolean[] zArr = new boolean[mp4TrackArr.length];
        for (int i2 = 0; i2 < mp4TrackArr.length; i2++) {
            jArr[i2] = new long[mp4TrackArr[i2].f13617b.f13690b];
            jArr2[i2] = mp4TrackArr[i2].f13617b.f13694f[0];
        }
        long j2 = 0;
        int i3 = 0;
        while (i3 < mp4TrackArr.length) {
            long j3 = Long.MAX_VALUE;
            int i4 = -1;
            for (int i5 = 0; i5 < mp4TrackArr.length; i5++) {
                if (!zArr[i5]) {
                    long j4 = jArr2[i5];
                    if (j4 <= j3) {
                        i4 = i5;
                        j3 = j4;
                    }
                }
            }
            int i6 = iArr[i4];
            long[] jArr3 = jArr[i4];
            jArr3[i6] = j2;
            TrackSampleTable trackSampleTable = mp4TrackArr[i4].f13617b;
            j2 += (long) trackSampleTable.f13692d[i6];
            int i7 = i6 + 1;
            iArr[i4] = i7;
            if (i7 < jArr3.length) {
                jArr2[i4] = trackSampleTable.f13694f[i7];
            } else {
                zArr[i4] = true;
                i3++;
            }
        }
        return jArr;
    }

    private void r() {
        this.f13614m = 0;
        this.p = 0;
    }

    private static int t(TrackSampleTable trackSampleTable, long j2) {
        int a2 = trackSampleTable.a(j2);
        return a2 == -1 ? trackSampleTable.b(j2) : a2;
    }

    private int u(long j2) {
        int i2 = -1;
        int i3 = -1;
        int i4 = 0;
        long j3 = Long.MAX_VALUE;
        boolean z2 = true;
        long j4 = Long.MAX_VALUE;
        boolean z3 = true;
        long j5 = Long.MAX_VALUE;
        while (true) {
            Mp4Track[] mp4TrackArr = this.x;
            if (i4 >= mp4TrackArr.length) {
                break;
            }
            Mp4Track mp4Track = mp4TrackArr[i4];
            int i5 = mp4Track.f13620e;
            TrackSampleTable trackSampleTable = mp4Track.f13617b;
            if (i5 != trackSampleTable.f13690b) {
                long j6 = trackSampleTable.f13691c[i5];
                long j7 = ((long[][]) Util.o(this.y))[i4][i5];
                long j8 = j6 - j2;
                boolean z4 = j8 < 0 || j8 >= 262144;
                if ((!z4 && z3) || (z4 == z3 && j8 < j5)) {
                    z3 = z4;
                    j5 = j8;
                    i3 = i4;
                    j4 = j7;
                }
                if (j7 < j3) {
                    z2 = z4;
                    i2 = i4;
                    j3 = j7;
                }
            }
            i4++;
        }
        return (j3 == Long.MAX_VALUE || !z2 || j4 < j3 + R) ? i3 : i2;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] v(SubtitleParser.Factory factory) {
        return new Extractor[]{new Mp4Extractor(factory)};
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Track w(Track track) {
        return track;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] x() {
        return new Extractor[]{new Mp4Extractor(SubtitleParser.Factory.f13783a, 16)};
    }

    private static long y(TrackSampleTable trackSampleTable, long j2, long j3) {
        int t2 = t(trackSampleTable, j2);
        return t2 == -1 ? j3 : Math.min(trackSampleTable.f13691c[t2], j3);
    }

    private void z(ExtractorInput extractorInput) throws IOException {
        this.f13609h.U(8);
        extractorInput.s(this.f13609h.e(), 0, 8);
        AtomParsers.f(this.f13609h);
        extractorInput.o(this.f13609h.f());
        extractorInput.n();
    }

    public void a() {
    }

    public void c(long j2, long j3) {
        this.f13611j.clear();
        this.p = 0;
        this.r = -1;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        if (j2 != 0) {
            for (Mp4Track mp4Track : this.x) {
                M(mp4Track, j3);
                TrueHdSampleRechunker trueHdSampleRechunker = mp4Track.f13619d;
                if (trueHdSampleRechunker != null) {
                    trueHdSampleRechunker.b();
                }
            }
        } else if (this.f13614m != 3) {
            r();
        } else {
            this.f13612k.g();
            this.f13613l.clear();
        }
    }

    public void d(ExtractorOutput extractorOutput) {
        if ((this.f13606e & 16) == 0) {
            extractorOutput = new SubtitleTranscodingExtractorOutput(extractorOutput, this.f13605d);
        }
        this.w = extractorOutput;
    }

    public /* synthetic */ Extractor e() {
        return d.a(this);
    }

    public boolean g() {
        return true;
    }

    public boolean h(ExtractorInput extractorInput) throws IOException {
        return Sniffer.e(extractorInput, (this.f13606e & 2) != 0);
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        while (true) {
            int i2 = this.f13614m;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        return I(extractorInput, positionHolder);
                    }
                    if (i2 == 3) {
                        return J(extractorInput, positionHolder);
                    }
                    throw new IllegalStateException();
                } else if (H(extractorInput, positionHolder)) {
                    return 1;
                }
            } else if (!G(extractorInput)) {
                return -1;
            }
        }
    }

    public SeekMap.SeekPoints j(long j2) {
        return s(j2, -1);
    }

    public long l() {
        return this.A;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.media3.extractor.SeekMap.SeekPoints s(long r17, int r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r19
            androidx.media3.extractor.mp4.Mp4Extractor$Mp4Track[] r4 = r0.x
            int r5 = r4.length
            if (r5 != 0) goto L_0x0013
            androidx.media3.extractor.SeekMap$SeekPoints r1 = new androidx.media3.extractor.SeekMap$SeekPoints
            androidx.media3.extractor.SeekPoint r2 = androidx.media3.extractor.SeekPoint.f13116c
            r1.<init>(r2)
            return r1
        L_0x0013:
            r5 = -1
            if (r3 == r5) goto L_0x0018
            r6 = r3
            goto L_0x001a
        L_0x0018:
            int r6 = r0.z
        L_0x001a:
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r9 = -1
            if (r6 == r5) goto L_0x0058
            r4 = r4[r6]
            androidx.media3.extractor.mp4.TrackSampleTable r4 = r4.f13617b
            int r6 = t(r4, r1)
            if (r6 != r5) goto L_0x0035
            androidx.media3.extractor.SeekMap$SeekPoints r1 = new androidx.media3.extractor.SeekMap$SeekPoints
            androidx.media3.extractor.SeekPoint r2 = androidx.media3.extractor.SeekPoint.f13116c
            r1.<init>(r2)
            return r1
        L_0x0035:
            long[] r11 = r4.f13694f
            r12 = r11[r6]
            long[] r11 = r4.f13691c
            r14 = r11[r6]
            int r11 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r11 >= 0) goto L_0x005e
            int r11 = r4.f13690b
            int r11 = r11 + -1
            if (r6 >= r11) goto L_0x005e
            int r1 = r4.b(r1)
            if (r1 == r5) goto L_0x005e
            if (r1 == r6) goto L_0x005e
            long[] r2 = r4.f13694f
            r9 = r2[r1]
            long[] r2 = r4.f13691c
            r1 = r2[r1]
            goto L_0x0060
        L_0x0058:
            r14 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r12 = r1
        L_0x005e:
            r1 = r9
            r9 = r7
        L_0x0060:
            if (r3 != r5) goto L_0x0080
            r3 = 0
        L_0x0063:
            androidx.media3.extractor.mp4.Mp4Extractor$Mp4Track[] r4 = r0.x
            int r5 = r4.length
            if (r3 >= r5) goto L_0x0080
            int r5 = r0.z
            if (r3 == r5) goto L_0x007d
            r4 = r4[r3]
            androidx.media3.extractor.mp4.TrackSampleTable r4 = r4.f13617b
            long r5 = y(r4, r12, r14)
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L_0x007c
            long r1 = y(r4, r9, r1)
        L_0x007c:
            r14 = r5
        L_0x007d:
            int r3 = r3 + 1
            goto L_0x0063
        L_0x0080:
            androidx.media3.extractor.SeekPoint r3 = new androidx.media3.extractor.SeekPoint
            r3.<init>(r12, r14)
            int r4 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r4 != 0) goto L_0x008f
            androidx.media3.extractor.SeekMap$SeekPoints r1 = new androidx.media3.extractor.SeekMap$SeekPoints
            r1.<init>(r3)
            return r1
        L_0x008f:
            androidx.media3.extractor.SeekPoint r4 = new androidx.media3.extractor.SeekPoint
            r4.<init>(r9, r1)
            androidx.media3.extractor.SeekMap$SeekPoints r1 = new androidx.media3.extractor.SeekMap$SeekPoints
            r1.<init>(r3, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.Mp4Extractor.s(long, int):androidx.media3.extractor.SeekMap$SeekPoints");
    }

    @Deprecated
    public Mp4Extractor(int i2) {
        this(SubtitleParser.Factory.f13783a, i2);
    }

    public Mp4Extractor(SubtitleParser.Factory factory) {
        this(factory, 0);
    }

    public Mp4Extractor(SubtitleParser.Factory factory, int i2) {
        this.f13605d = factory;
        this.f13606e = i2;
        this.f13614m = (i2 & 4) != 0 ? 3 : 0;
        this.f13612k = new SefReader();
        this.f13613l = new ArrayList();
        this.f13610i = new ParsableByteArray(16);
        this.f13611j = new ArrayDeque<>();
        this.f13607f = new ParsableByteArray(NalUnitUtil.f9675j);
        this.f13608g = new ParsableByteArray(4);
        this.f13609h = new ParsableByteArray();
        this.r = -1;
        this.w = ExtractorOutput.b0;
        this.x = new Mp4Track[0];
    }
}
