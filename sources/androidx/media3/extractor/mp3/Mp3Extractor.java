package androidx.media3.extractor.mp3;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.DummyTrackOutput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.Id3Peeker;
import androidx.media3.extractor.MpegAudioUtil;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.d;
import androidx.media3.extractor.metadata.id3.Id3Decoder;
import androidx.media3.extractor.metadata.id3.MlltFrame;
import androidx.media3.extractor.metadata.id3.TextInformationFrame;
import java.io.EOFException;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public final class Mp3Extractor implements Extractor {
    public static final int A = 4;
    public static final int B = 8;
    private static final Id3Decoder.FramePredicate C = new b();
    private static final int D = 131072;
    private static final int E = 32768;
    private static final int F = 10;
    private static final int G = -128000;
    private static final int H = 1483304551;
    private static final int I = 1231971951;
    private static final int J = 1447187017;
    private static final int K = 0;
    public static final ExtractorsFactory x = new a();
    public static final int y = 1;
    public static final int z = 2;

    /* renamed from: d  reason: collision with root package name */
    private final int f13465d;

    /* renamed from: e  reason: collision with root package name */
    private final long f13466e;

    /* renamed from: f  reason: collision with root package name */
    private final ParsableByteArray f13467f;

    /* renamed from: g  reason: collision with root package name */
    private final MpegAudioUtil.Header f13468g;

    /* renamed from: h  reason: collision with root package name */
    private final GaplessInfoHolder f13469h;

    /* renamed from: i  reason: collision with root package name */
    private final Id3Peeker f13470i;

    /* renamed from: j  reason: collision with root package name */
    private final TrackOutput f13471j;

    /* renamed from: k  reason: collision with root package name */
    private ExtractorOutput f13472k;

    /* renamed from: l  reason: collision with root package name */
    private TrackOutput f13473l;

    /* renamed from: m  reason: collision with root package name */
    private TrackOutput f13474m;

    /* renamed from: n  reason: collision with root package name */
    private int f13475n;
    @Nullable
    private Metadata o;
    private long p;
    private long q;
    private long r;
    private int s;
    private Seeker t;
    private boolean u;
    private boolean v;
    private long w;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public Mp3Extractor() {
        this(0);
    }

    @EnsuresNonNull({"extractorOutput", "realTrackOutput"})
    private void g() {
        Assertions.k(this.f13473l);
        Util.o(this.f13472k);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: androidx.media3.extractor.mp3.Seeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: androidx.media3.extractor.mp3.MlltSeeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: androidx.media3.extractor.mp3.IndexSeeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: androidx.media3.extractor.mp3.IndexSeeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: androidx.media3.extractor.mp3.IndexSeeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: androidx.media3.extractor.mp3.IndexSeeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: androidx.media3.extractor.mp3.IndexSeeker} */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004e, code lost:
        if (r0 == null) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        r0 = null;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.media3.extractor.mp3.Seeker j(androidx.media3.extractor.ExtractorInput r12) throws java.io.IOException {
        /*
            r11 = this;
            androidx.media3.extractor.mp3.Seeker r0 = r11.u(r12)
            androidx.media3.common.Metadata r1 = r11.o
            long r2 = r12.getPosition()
            androidx.media3.extractor.mp3.MlltSeeker r1 = t(r1, r2)
            boolean r2 = r11.u
            if (r2 == 0) goto L_0x0018
            androidx.media3.extractor.mp3.Seeker$UnseekableSeeker r12 = new androidx.media3.extractor.mp3.Seeker$UnseekableSeeker
            r12.<init>()
            return r12
        L_0x0018:
            int r2 = r11.f13465d
            r2 = r2 & 4
            if (r2 == 0) goto L_0x004a
            if (r1 == 0) goto L_0x002b
            long r2 = r1.l()
            long r0 = r1.f()
        L_0x0028:
            r9 = r0
            r5 = r2
            goto L_0x003f
        L_0x002b:
            if (r0 == 0) goto L_0x0036
            long r2 = r0.l()
            long r0 = r0.f()
            goto L_0x0028
        L_0x0036:
            androidx.media3.common.Metadata r0 = r11.o
            long r2 = o(r0)
            r0 = -1
            goto L_0x0028
        L_0x003f:
            androidx.media3.extractor.mp3.IndexSeeker r0 = new androidx.media3.extractor.mp3.IndexSeeker
            long r7 = r12.getPosition()
            r4 = r0
            r4.<init>(r5, r7, r9)
            goto L_0x0052
        L_0x004a:
            if (r1 == 0) goto L_0x004e
            r0 = r1
            goto L_0x0052
        L_0x004e:
            if (r0 == 0) goto L_0x0051
            goto L_0x0052
        L_0x0051:
            r0 = 0
        L_0x0052:
            r1 = 1
            if (r0 == 0) goto L_0x0060
            boolean r2 = r0.g()
            if (r2 != 0) goto L_0x006c
            int r2 = r11.f13465d
            r2 = r2 & r1
            if (r2 == 0) goto L_0x006c
        L_0x0060:
            int r0 = r11.f13465d
            r0 = r0 & 2
            if (r0 == 0) goto L_0x0067
            goto L_0x0068
        L_0x0067:
            r1 = 0
        L_0x0068:
            androidx.media3.extractor.mp3.Seeker r0 = r11.n(r12, r1)
        L_0x006c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp3.Mp3Extractor.j(androidx.media3.extractor.ExtractorInput):androidx.media3.extractor.mp3.Seeker");
    }

    private long k(long j2) {
        return this.p + ((j2 * 1000000) / ((long) this.f13468g.f13103d));
    }

    private Seeker m(ExtractorInput extractorInput, long j2, boolean z2) throws IOException {
        extractorInput.s(this.f13467f.e(), 0, 4);
        this.f13467f.Y(0);
        this.f13468g.a(this.f13467f.s());
        if (extractorInput.getLength() != -1) {
            j2 = extractorInput.getLength();
        }
        return new ConstantBitrateSeeker(j2, extractorInput.getPosition(), this.f13468g, z2);
    }

    private Seeker n(ExtractorInput extractorInput, boolean z2) throws IOException {
        return m(extractorInput, -1, z2);
    }

    private static long o(@Nullable Metadata metadata) {
        if (metadata == null) {
            return C.f9084b;
        }
        int g2 = metadata.g();
        for (int i2 = 0; i2 < g2; i2++) {
            Metadata.Entry d2 = metadata.d(i2);
            if (d2 instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) d2;
                if (textInformationFrame.s.equals("TLEN")) {
                    return Util.I1(Long.parseLong(textInformationFrame.Z.get(0)));
                }
            }
        }
        return C.f9084b;
    }

    private static int p(ParsableByteArray parsableByteArray, int i2) {
        if (parsableByteArray.g() >= i2 + 4) {
            parsableByteArray.Y(i2);
            int s2 = parsableByteArray.s();
            if (s2 == H || s2 == I) {
                return s2;
            }
        }
        if (parsableByteArray.g() < 40) {
            return 0;
        }
        parsableByteArray.Y(36);
        if (parsableByteArray.s() == J) {
            return J;
        }
        return 0;
    }

    private static boolean q(int i2, long j2) {
        return ((long) (i2 & G)) == (j2 & -128000);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] r() {
        return new Extractor[]{new Mp3Extractor()};
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean s(int i2, int i3, int i4, int i5, int i6) {
        return (i3 == 67 && i4 == 79 && i5 == 77 && (i6 == 77 || i2 == 2)) || (i3 == 77 && i4 == 76 && i5 == 76 && (i6 == 84 || i2 == 2));
    }

    @Nullable
    private static MlltSeeker t(@Nullable Metadata metadata, long j2) {
        if (metadata == null) {
            return null;
        }
        int g2 = metadata.g();
        for (int i2 = 0; i2 < g2; i2++) {
            Metadata.Entry d2 = metadata.d(i2);
            if (d2 instanceof MlltFrame) {
                return MlltSeeker.a(j2, (MlltFrame) d2, o(metadata));
            }
        }
        return null;
    }

    @Nullable
    private Seeker u(ExtractorInput extractorInput) throws IOException {
        int i2;
        int i3;
        ParsableByteArray parsableByteArray = new ParsableByteArray(this.f13468g.f13102c);
        extractorInput.s(parsableByteArray.e(), 0, this.f13468g.f13102c);
        MpegAudioUtil.Header header = this.f13468g;
        int i4 = header.f13100a & 1;
        int i5 = 21;
        int i6 = header.f13104e;
        if (i4 != 0) {
            if (i6 != 1) {
                i5 = 36;
            }
        } else if (i6 == 1) {
            i5 = 13;
        }
        int p2 = p(parsableByteArray, i5);
        if (p2 != I) {
            if (p2 == J) {
                VbriSeeker a2 = VbriSeeker.a(extractorInput.getLength(), extractorInput.getPosition(), this.f13468g, parsableByteArray);
                extractorInput.o(this.f13468g.f13102c);
                return a2;
            } else if (p2 != H) {
                extractorInput.n();
                return null;
            }
        }
        XingFrame a3 = XingFrame.a(this.f13468g, parsableByteArray);
        if (!(this.f13469h.a() || (i2 = a3.f13486d) == -1 || (i3 = a3.f13487e) == -1)) {
            GaplessInfoHolder gaplessInfoHolder = this.f13469h;
            gaplessInfoHolder.f13068a = i2;
            gaplessInfoHolder.f13069b = i3;
        }
        long position = extractorInput.getPosition();
        extractorInput.o(this.f13468g.f13102c);
        if (p2 == H) {
            return XingSeeker.a(extractorInput.getLength(), a3, position);
        }
        long j2 = a3.f13485c;
        long j3 = -1;
        if (j2 != -1) {
            j3 = position + j2;
        }
        return m(extractorInput, j3, false);
    }

    private boolean v(ExtractorInput extractorInput) throws IOException {
        Seeker seeker = this.t;
        if (seeker != null) {
            long f2 = seeker.f();
            if (f2 != -1 && extractorInput.i() > f2 - 4) {
                return true;
            }
        }
        try {
            return !extractorInput.h(this.f13467f.e(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    @RequiresNonNull({"extractorOutput", "realTrackOutput"})
    private int w(ExtractorInput extractorInput) throws IOException {
        if (this.f13475n == 0) {
            try {
                y(extractorInput, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.t == null) {
            Seeker j2 = j(extractorInput);
            this.t = j2;
            this.f13472k.j(j2);
            Format.Builder d0 = new Format.Builder().k0(this.f13468g.f13101b).c0(4096).L(this.f13468g.f13104e).l0(this.f13468g.f13103d).S(this.f13469h.f13068a).T(this.f13469h.f13069b).d0((this.f13465d & 8) != 0 ? null : this.o);
            if (this.t.k() != -2147483647) {
                d0.K(this.t.k());
            }
            this.f13474m.e(d0.I());
            this.r = extractorInput.getPosition();
        } else if (this.r != 0) {
            long position = extractorInput.getPosition();
            long j3 = this.r;
            if (position < j3) {
                extractorInput.o((int) (j3 - position));
            }
        }
        return x(extractorInput);
    }

    @RequiresNonNull({"realTrackOutput", "seeker"})
    private int x(ExtractorInput extractorInput) throws IOException {
        if (this.s == 0) {
            extractorInput.n();
            if (v(extractorInput)) {
                return -1;
            }
            this.f13467f.Y(0);
            int s2 = this.f13467f.s();
            if (!q(s2, (long) this.f13475n) || MpegAudioUtil.j(s2) == -1) {
                extractorInput.o(1);
                this.f13475n = 0;
                return 0;
            }
            this.f13468g.a(s2);
            if (this.p == C.f9084b) {
                this.p = this.t.b(extractorInput.getPosition());
                if (this.f13466e != C.f9084b) {
                    this.p += this.f13466e - this.t.b(0);
                }
            }
            MpegAudioUtil.Header header = this.f13468g;
            this.s = header.f13102c;
            Seeker seeker = this.t;
            if (seeker instanceof IndexSeeker) {
                IndexSeeker indexSeeker = (IndexSeeker) seeker;
                indexSeeker.c(k(this.q + ((long) header.f13106g)), extractorInput.getPosition() + ((long) this.f13468g.f13102c));
                if (this.v && indexSeeker.a(this.w)) {
                    this.v = false;
                    this.f13474m = this.f13473l;
                }
            }
        }
        int b2 = this.f13474m.b(extractorInput, this.s, true);
        if (b2 == -1) {
            return -1;
        }
        int i2 = this.s - b2;
        this.s = i2;
        if (i2 > 0) {
            return 0;
        }
        this.f13474m.f(k(this.q), 1, this.f13468g.f13102c, 0, (TrackOutput.CryptoData) null);
        this.q += (long) this.f13468g.f13106g;
        this.s = 0;
        return 0;
    }

    private boolean y(ExtractorInput extractorInput, boolean z2) throws IOException {
        int i2;
        int i3;
        int j2;
        int i4 = z2 ? 32768 : 131072;
        extractorInput.n();
        if (extractorInput.getPosition() == 0) {
            Metadata a2 = this.f13470i.a(extractorInput, (this.f13465d & 8) == 0 ? null : C);
            this.o = a2;
            if (a2 != null) {
                this.f13469h.c(a2);
            }
            i3 = (int) extractorInput.i();
            if (!z2) {
                extractorInput.o(i3);
            }
            i2 = 0;
        } else {
            i2 = 0;
            i3 = 0;
        }
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (!v(extractorInput)) {
                this.f13467f.Y(0);
                int s2 = this.f13467f.s();
                if ((i2 == 0 || q(s2, (long) i2)) && (j2 = MpegAudioUtil.j(s2)) != -1) {
                    i5++;
                    if (i5 != 1) {
                        if (i5 == 4) {
                            break;
                        }
                    } else {
                        this.f13468g.a(s2);
                        i2 = s2;
                    }
                    extractorInput.j(j2 - 4);
                } else {
                    int i7 = i6 + 1;
                    if (i6 != i4) {
                        if (z2) {
                            extractorInput.n();
                            extractorInput.j(i3 + i7);
                        } else {
                            extractorInput.o(1);
                        }
                        i6 = i7;
                        i2 = 0;
                        i5 = 0;
                    } else if (z2) {
                        return false;
                    } else {
                        throw ParserException.a("Searched too many bytes.", (Throwable) null);
                    }
                }
            } else if (i5 <= 0) {
                throw new EOFException();
            }
        }
        if (z2) {
            extractorInput.o(i3 + i6);
        } else {
            extractorInput.n();
        }
        this.f13475n = i2;
        return true;
    }

    public void a() {
    }

    public void c(long j2, long j3) {
        this.f13475n = 0;
        this.p = C.f9084b;
        this.q = 0;
        this.s = 0;
        this.w = j3;
        Seeker seeker = this.t;
        if ((seeker instanceof IndexSeeker) && !((IndexSeeker) seeker).a(j3)) {
            this.v = true;
            this.f13474m = this.f13471j;
        }
    }

    public void d(ExtractorOutput extractorOutput) {
        this.f13472k = extractorOutput;
        TrackOutput d2 = extractorOutput.d(0, 1);
        this.f13473l = d2;
        this.f13474m = d2;
        this.f13472k.o();
    }

    public /* synthetic */ Extractor e() {
        return d.a(this);
    }

    public boolean h(ExtractorInput extractorInput) throws IOException {
        return y(extractorInput, true);
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        g();
        int w2 = w(extractorInput);
        if (w2 == -1 && (this.t instanceof IndexSeeker)) {
            long k2 = k(this.q);
            if (this.t.l() != k2) {
                ((IndexSeeker) this.t).d(k2);
                this.f13472k.j(this.t);
            }
        }
        return w2;
    }

    public void l() {
        this.u = true;
    }

    public Mp3Extractor(int i2) {
        this(i2, C.f9084b);
    }

    public Mp3Extractor(int i2, long j2) {
        this.f13465d = (i2 & 2) != 0 ? i2 | 1 : i2;
        this.f13466e = j2;
        this.f13467f = new ParsableByteArray(10);
        this.f13468g = new MpegAudioUtil.Header();
        this.f13469h = new GaplessInfoHolder();
        this.p = C.f9084b;
        this.f13470i = new Id3Peeker();
        DummyTrackOutput dummyTrackOutput = new DummyTrackOutput();
        this.f13471j = dummyTrackOutput;
        this.f13474m = dummyTrackOutput;
    }
}
