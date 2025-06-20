package androidx.media3.extractor.ts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.d;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.SubtitleTranscodingExtractorOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@UnstableApi
public final class TsExtractor implements Extractor {
    public static final int A = 2;
    public static final int B = 1;
    @Deprecated
    public static final ExtractorsFactory C = new f();
    public static final int D = 188;
    public static final int E = 112800;
    public static final int F = 3;
    public static final int G = 4;
    public static final int H = 15;
    public static final int I = 17;
    public static final int J = 129;
    public static final int K = 138;
    public static final int L = 130;
    public static final int M = 135;
    public static final int N = 172;
    public static final int O = 2;
    public static final int P = 16;
    public static final int Q = 27;
    public static final int R = 36;
    public static final int S = 21;
    public static final int T = 134;
    public static final int U = 89;
    public static final int V = 136;
    public static final int W = 139;
    public static final int X = 128;
    public static final int Y = 257;
    public static final int Z = 71;
    private static final int a0 = 0;
    private static final int b0 = 8192;
    private static final long c0 = 1094921523;
    private static final long d0 = 1161904947;
    private static final long e0 = 1094921524;
    private static final long f0 = 1212503619;
    private static final int g0 = 9400;
    private static final int h0 = 5;
    public static final int y = 0;
    public static final int z = 1;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final int f14503d;

    /* renamed from: e  reason: collision with root package name */
    private final int f14504e;

    /* renamed from: f  reason: collision with root package name */
    private final int f14505f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final List<TimestampAdjuster> f14506g;

    /* renamed from: h  reason: collision with root package name */
    private final ParsableByteArray f14507h;

    /* renamed from: i  reason: collision with root package name */
    private final SparseIntArray f14508i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final TsPayloadReader.Factory f14509j;

    /* renamed from: k  reason: collision with root package name */
    private final SubtitleParser.Factory f14510k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final SparseArray<TsPayloadReader> f14511l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final SparseBooleanArray f14512m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final SparseBooleanArray f14513n;
    private final TsDurationReader o;
    private TsBinarySearchSeeker p;
    /* access modifiers changed from: private */
    public ExtractorOutput q;
    /* access modifiers changed from: private */
    public int r;
    /* access modifiers changed from: private */
    public boolean s;
    private boolean t;
    private boolean u;
    /* access modifiers changed from: private */
    @Nullable
    public TsPayloadReader v;
    private int w;
    /* access modifiers changed from: private */
    public int x;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    private class PatReader implements SectionPayloadReader {

        /* renamed from: a  reason: collision with root package name */
        private final ParsableBitArray f14514a = new ParsableBitArray(new byte[4]);

        public PatReader() {
        }

        public void b(ParsableByteArray parsableByteArray) {
            if (parsableByteArray.L() == 0 && (parsableByteArray.L() & 128) != 0) {
                parsableByteArray.Z(6);
                int a2 = parsableByteArray.a() / 4;
                for (int i2 = 0; i2 < a2; i2++) {
                    parsableByteArray.l(this.f14514a, 4);
                    int h2 = this.f14514a.h(16);
                    this.f14514a.s(3);
                    if (h2 == 0) {
                        this.f14514a.s(13);
                    } else {
                        int h3 = this.f14514a.h(13);
                        if (TsExtractor.this.f14511l.get(h3) == null) {
                            TsExtractor.this.f14511l.put(h3, new SectionReader(new PmtReader(h3)));
                            TsExtractor.n(TsExtractor.this);
                        }
                    }
                }
                if (TsExtractor.this.f14503d != 2) {
                    TsExtractor.this.f14511l.remove(0);
                }
            }
        }

        public void c(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        }
    }

    private class PmtReader implements SectionPayloadReader {

        /* renamed from: f  reason: collision with root package name */
        private static final int f14516f = 5;

        /* renamed from: g  reason: collision with root package name */
        private static final int f14517g = 10;

        /* renamed from: h  reason: collision with root package name */
        private static final int f14518h = 106;

        /* renamed from: i  reason: collision with root package name */
        private static final int f14519i = 111;

        /* renamed from: j  reason: collision with root package name */
        private static final int f14520j = 122;

        /* renamed from: k  reason: collision with root package name */
        private static final int f14521k = 123;

        /* renamed from: l  reason: collision with root package name */
        private static final int f14522l = 127;

        /* renamed from: m  reason: collision with root package name */
        private static final int f14523m = 89;

        /* renamed from: n  reason: collision with root package name */
        private static final int f14524n = 21;
        private static final int o = 14;
        private static final int p = 33;

        /* renamed from: a  reason: collision with root package name */
        private final ParsableBitArray f14525a = new ParsableBitArray(new byte[5]);

        /* renamed from: b  reason: collision with root package name */
        private final SparseArray<TsPayloadReader> f14526b = new SparseArray<>();

        /* renamed from: c  reason: collision with root package name */
        private final SparseIntArray f14527c = new SparseIntArray();

        /* renamed from: d  reason: collision with root package name */
        private final int f14528d;

        public PmtReader(int i2) {
            this.f14528d = i2;
        }

        private TsPayloadReader.EsInfo a(ParsableByteArray parsableByteArray, int i2) {
            ParsableByteArray parsableByteArray2 = parsableByteArray;
            int f2 = parsableByteArray.f();
            int i3 = f2 + i2;
            String str = null;
            ArrayList arrayList = null;
            int i4 = -1;
            int i5 = 0;
            while (parsableByteArray.f() < i3) {
                int L = parsableByteArray.L();
                int f3 = parsableByteArray.f() + parsableByteArray.L();
                if (f3 > i3) {
                    break;
                }
                if (L == 5) {
                    long N = parsableByteArray.N();
                    if (N != TsExtractor.c0) {
                        if (N != TsExtractor.d0) {
                            if (N != TsExtractor.e0) {
                                if (N == TsExtractor.f0) {
                                    i4 = 36;
                                }
                                parsableByteArray2.Z(f3 - parsableByteArray.f());
                            }
                        }
                        i4 = TsExtractor.M;
                        parsableByteArray2.Z(f3 - parsableByteArray.f());
                    }
                    i4 = TsExtractor.J;
                    parsableByteArray2.Z(f3 - parsableByteArray.f());
                } else {
                    if (L != 106) {
                        if (L != 122) {
                            if (L == 127) {
                                int L2 = parsableByteArray.L();
                                if (L2 != 21) {
                                    if (L2 == 14) {
                                        i4 = TsExtractor.V;
                                    } else if (L2 == 33) {
                                        i4 = TsExtractor.W;
                                    }
                                }
                            } else if (L == 123) {
                                i4 = TsExtractor.K;
                            } else if (L == 10) {
                                String trim = parsableByteArray2.I(3).trim();
                                i5 = parsableByteArray.L();
                                str = trim;
                            } else if (L == 89) {
                                ArrayList arrayList2 = new ArrayList();
                                while (parsableByteArray.f() < f3) {
                                    String trim2 = parsableByteArray2.I(3).trim();
                                    int L3 = parsableByteArray.L();
                                    byte[] bArr = new byte[4];
                                    parsableByteArray2.n(bArr, 0, 4);
                                    arrayList2.add(new TsPayloadReader.DvbSubtitleInfo(trim2, L3, bArr));
                                }
                                arrayList = arrayList2;
                                i4 = 89;
                            } else if (L == 111) {
                                i4 = 257;
                            }
                            parsableByteArray2.Z(f3 - parsableByteArray.f());
                        }
                        i4 = TsExtractor.M;
                        parsableByteArray2.Z(f3 - parsableByteArray.f());
                    }
                    i4 = TsExtractor.J;
                    parsableByteArray2.Z(f3 - parsableByteArray.f());
                }
                i4 = TsExtractor.N;
                parsableByteArray2.Z(f3 - parsableByteArray.f());
            }
            parsableByteArray2.Y(i3);
            return new TsPayloadReader.EsInfo(i4, str, i5, arrayList, Arrays.copyOfRange(parsableByteArray.e(), f2, i3));
        }

        public void b(ParsableByteArray parsableByteArray) {
            TimestampAdjuster timestampAdjuster;
            ParsableByteArray parsableByteArray2 = parsableByteArray;
            if (parsableByteArray.L() == 2) {
                if (TsExtractor.this.f14503d == 1 || TsExtractor.this.f14503d == 2 || TsExtractor.this.r == 1) {
                    timestampAdjuster = (TimestampAdjuster) TsExtractor.this.f14506g.get(0);
                } else {
                    timestampAdjuster = new TimestampAdjuster(((TimestampAdjuster) TsExtractor.this.f14506g.get(0)).d());
                    TsExtractor.this.f14506g.add(timestampAdjuster);
                }
                if ((parsableByteArray.L() & 128) != 0) {
                    parsableByteArray2.Z(1);
                    int R = parsableByteArray.R();
                    int i2 = 3;
                    parsableByteArray2.Z(3);
                    parsableByteArray2.l(this.f14525a, 2);
                    this.f14525a.s(3);
                    int i3 = 13;
                    int unused = TsExtractor.this.x = this.f14525a.h(13);
                    parsableByteArray2.l(this.f14525a, 2);
                    int i4 = 4;
                    this.f14525a.s(4);
                    parsableByteArray2.Z(this.f14525a.h(12));
                    if (TsExtractor.this.f14503d == 2 && TsExtractor.this.v == null) {
                        TsPayloadReader.EsInfo esInfo = new TsPayloadReader.EsInfo(21, (String) null, 0, (List<TsPayloadReader.DvbSubtitleInfo>) null, Util.f9651f);
                        TsExtractor tsExtractor = TsExtractor.this;
                        TsPayloadReader unused2 = tsExtractor.v = tsExtractor.f14509j.a(21, esInfo);
                        if (TsExtractor.this.v != null) {
                            TsExtractor.this.v.c(timestampAdjuster, TsExtractor.this.q, new TsPayloadReader.TrackIdGenerator(R, 21, 8192));
                        }
                    }
                    this.f14526b.clear();
                    this.f14527c.clear();
                    int a2 = parsableByteArray.a();
                    while (a2 > 0) {
                        parsableByteArray2.l(this.f14525a, 5);
                        int h2 = this.f14525a.h(8);
                        this.f14525a.s(i2);
                        int h3 = this.f14525a.h(i3);
                        this.f14525a.s(i4);
                        int h4 = this.f14525a.h(12);
                        TsPayloadReader.EsInfo a3 = a(parsableByteArray2, h4);
                        if (h2 == 6 || h2 == 5) {
                            h2 = a3.f14540a;
                        }
                        a2 -= h4 + 5;
                        int i5 = TsExtractor.this.f14503d == 2 ? h2 : h3;
                        if (!TsExtractor.this.f14512m.get(i5)) {
                            TsPayloadReader r = (TsExtractor.this.f14503d == 2 && h2 == 21) ? TsExtractor.this.v : TsExtractor.this.f14509j.a(h2, a3);
                            if (TsExtractor.this.f14503d != 2 || h3 < this.f14527c.get(i5, 8192)) {
                                this.f14527c.put(i5, h3);
                                this.f14526b.put(i5, r);
                            }
                        }
                        i2 = 3;
                        i4 = 4;
                        i3 = 13;
                    }
                    int size = this.f14527c.size();
                    for (int i6 = 0; i6 < size; i6++) {
                        int keyAt = this.f14527c.keyAt(i6);
                        int valueAt = this.f14527c.valueAt(i6);
                        TsExtractor.this.f14512m.put(keyAt, true);
                        TsExtractor.this.f14513n.put(valueAt, true);
                        TsPayloadReader valueAt2 = this.f14526b.valueAt(i6);
                        if (valueAt2 != null) {
                            if (valueAt2 != TsExtractor.this.v) {
                                valueAt2.c(timestampAdjuster, TsExtractor.this.q, new TsPayloadReader.TrackIdGenerator(R, keyAt, 8192));
                            }
                            TsExtractor.this.f14511l.put(valueAt, valueAt2);
                        }
                    }
                    if (TsExtractor.this.f14503d != 2) {
                        TsExtractor.this.f14511l.remove(this.f14528d);
                        TsExtractor tsExtractor2 = TsExtractor.this;
                        int unused3 = tsExtractor2.r = tsExtractor2.f14503d == 1 ? 0 : TsExtractor.this.r - 1;
                        if (TsExtractor.this.r == 0) {
                            TsExtractor.this.q.o();
                        } else {
                            return;
                        }
                    } else if (!TsExtractor.this.s) {
                        TsExtractor.this.q.o();
                        int unused4 = TsExtractor.this.r = 0;
                    } else {
                        return;
                    }
                    boolean unused5 = TsExtractor.this.s = true;
                }
            }
        }

        public void c(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        }
    }

    @Deprecated
    public TsExtractor() {
        this(1, 1, SubtitleParser.Factory.f13783a, new TimestampAdjuster(0), new DefaultTsPayloadReaderFactory(0), E);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] A() {
        return new Extractor[]{new TsExtractor(1, SubtitleParser.Factory.f13783a)};
    }

    private void B(long j2) {
        ExtractorOutput extractorOutput;
        SeekMap unseekable;
        if (!this.t) {
            this.t = true;
            if (this.o.b() != C.f9084b) {
                TsBinarySearchSeeker tsBinarySearchSeeker = new TsBinarySearchSeeker(this.o.c(), this.o.b(), j2, this.x, this.f14505f);
                this.p = tsBinarySearchSeeker;
                extractorOutput = this.q;
                unseekable = tsBinarySearchSeeker.b();
            } else {
                extractorOutput = this.q;
                unseekable = new SeekMap.Unseekable(this.o.b());
            }
            extractorOutput.j(unseekable);
        }
    }

    public static ExtractorsFactory C(SubtitleParser.Factory factory) {
        return new e(factory);
    }

    private void D() {
        this.f14512m.clear();
        this.f14511l.clear();
        SparseArray<TsPayloadReader> b2 = this.f14509j.b();
        int size = b2.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f14511l.put(b2.keyAt(i2), b2.valueAt(i2));
        }
        this.f14511l.put(0, new SectionReader(new PatReader()));
        this.v = null;
    }

    private boolean E(int i2) {
        return this.f14503d == 2 || this.s || !this.f14513n.get(i2, false);
    }

    static /* synthetic */ int n(TsExtractor tsExtractor) {
        int i2 = tsExtractor.r;
        tsExtractor.r = i2 + 1;
        return i2;
    }

    private boolean x(ExtractorInput extractorInput) throws IOException {
        byte[] e2 = this.f14507h.e();
        if (9400 - this.f14507h.f() < 188) {
            int a2 = this.f14507h.a();
            if (a2 > 0) {
                System.arraycopy(e2, this.f14507h.f(), e2, 0, a2);
            }
            this.f14507h.W(e2, a2);
        }
        while (this.f14507h.a() < 188) {
            int g2 = this.f14507h.g();
            int read = extractorInput.read(e2, g2, 9400 - g2);
            if (read == -1) {
                return false;
            }
            this.f14507h.X(g2 + read);
        }
        return true;
    }

    private int y() throws ParserException {
        int f2 = this.f14507h.f();
        int g2 = this.f14507h.g();
        int a2 = TsUtil.a(this.f14507h.e(), f2, g2);
        this.f14507h.Y(a2);
        int i2 = a2 + D;
        if (i2 > g2) {
            int i3 = this.w + (a2 - f2);
            this.w = i3;
            if (this.f14503d == 2 && i3 > 376) {
                throw ParserException.a("Cannot find sync byte. Most likely not a Transport Stream.", (Throwable) null);
            }
        } else {
            this.w = 0;
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] z(SubtitleParser.Factory factory) {
        return new Extractor[]{new TsExtractor(factory)};
    }

    public void a() {
    }

    public void c(long j2, long j3) {
        TsBinarySearchSeeker tsBinarySearchSeeker;
        Assertions.i(this.f14503d != 2);
        int size = this.f14506g.size();
        for (int i2 = 0; i2 < size; i2++) {
            TimestampAdjuster timestampAdjuster = this.f14506g.get(i2);
            boolean z2 = timestampAdjuster.f() == C.f9084b;
            if (!z2) {
                long d2 = timestampAdjuster.d();
                z2 = (d2 == C.f9084b || d2 == 0 || d2 == j3) ? false : true;
            }
            if (z2) {
                timestampAdjuster.i(j3);
            }
        }
        if (!(j3 == 0 || (tsBinarySearchSeeker = this.p) == null)) {
            tsBinarySearchSeeker.h(j3);
        }
        this.f14507h.U(0);
        this.f14508i.clear();
        for (int i3 = 0; i3 < this.f14511l.size(); i3++) {
            this.f14511l.valueAt(i3).a();
        }
        this.w = 0;
    }

    public void d(ExtractorOutput extractorOutput) {
        if ((this.f14504e & 1) == 0) {
            extractorOutput = new SubtitleTranscodingExtractorOutput(extractorOutput, this.f14510k);
        }
        this.q = extractorOutput;
    }

    public /* synthetic */ Extractor e() {
        return d.a(this);
    }

    public boolean h(ExtractorInput extractorInput) throws IOException {
        byte[] e2 = this.f14507h.e();
        extractorInput.s(e2, 0, 940);
        int i2 = 0;
        while (i2 < 188) {
            int i3 = 0;
            while (i3 < 5) {
                if (e2[(i3 * D) + i2] != 71) {
                    i2++;
                } else {
                    i3++;
                }
            }
            extractorInput.o(i2);
            return true;
        }
        return false;
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        ExtractorInput extractorInput2 = extractorInput;
        PositionHolder positionHolder2 = positionHolder;
        long length = extractorInput.getLength();
        if (this.s) {
            if (length != -1 && this.f14503d != 2 && !this.o.d()) {
                return this.o.e(extractorInput2, positionHolder2, this.x);
            }
            B(length);
            if (this.u) {
                this.u = false;
                c(0, 0);
                if (extractorInput.getPosition() != 0) {
                    positionHolder2.f13111a = 0;
                    return 1;
                }
            }
            TsBinarySearchSeeker tsBinarySearchSeeker = this.p;
            if (tsBinarySearchSeeker != null && tsBinarySearchSeeker.d()) {
                return this.p.c(extractorInput2, positionHolder2);
            }
        }
        if (!x(extractorInput)) {
            return -1;
        }
        int y2 = y();
        int g2 = this.f14507h.g();
        if (y2 > g2) {
            return 0;
        }
        int s2 = this.f14507h.s();
        if ((8388608 & s2) == 0) {
            int i2 = (4194304 & s2) != 0 ? 1 : 0;
            int i3 = (2096896 & s2) >> 8;
            boolean z2 = (s2 & 32) != 0;
            TsPayloadReader tsPayloadReader = (s2 & 16) != 0 ? this.f14511l.get(i3) : null;
            if (tsPayloadReader != null) {
                if (this.f14503d != 2) {
                    int i4 = s2 & 15;
                    int i5 = this.f14508i.get(i3, i4 - 1);
                    this.f14508i.put(i3, i4);
                    if (i5 != i4) {
                        if (i4 != ((i5 + 1) & 15)) {
                            tsPayloadReader.a();
                        }
                    }
                }
                if (z2) {
                    int L2 = this.f14507h.L();
                    i2 |= (this.f14507h.L() & 64) != 0 ? 2 : 0;
                    this.f14507h.Z(L2 - 1);
                }
                boolean z3 = this.s;
                if (E(i3)) {
                    this.f14507h.X(y2);
                    tsPayloadReader.b(this.f14507h, i2);
                    this.f14507h.X(g2);
                }
                if (this.f14503d != 2 && !z3 && this.s && length != -1) {
                    this.u = true;
                }
            }
        }
        this.f14507h.Y(y2);
        return 0;
    }

    @Deprecated
    public TsExtractor(int i2) {
        this(1, 1, SubtitleParser.Factory.f13783a, new TimestampAdjuster(0), new DefaultTsPayloadReaderFactory(i2), E);
    }

    @Deprecated
    public TsExtractor(int i2, int i3, int i4) {
        this(i2, 1, SubtitleParser.Factory.f13783a, new TimestampAdjuster(0), new DefaultTsPayloadReaderFactory(i3), i4);
    }

    public TsExtractor(int i2, int i3, SubtitleParser.Factory factory, TimestampAdjuster timestampAdjuster, TsPayloadReader.Factory factory2, int i4) {
        this.f14509j = (TsPayloadReader.Factory) Assertions.g(factory2);
        this.f14505f = i4;
        this.f14503d = i2;
        this.f14504e = i3;
        this.f14510k = factory;
        if (i2 == 1 || i2 == 2) {
            this.f14506g = Collections.singletonList(timestampAdjuster);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f14506g = arrayList;
            arrayList.add(timestampAdjuster);
        }
        this.f14507h = new ParsableByteArray(new byte[g0], 0);
        this.f14512m = new SparseBooleanArray();
        this.f14513n = new SparseBooleanArray();
        this.f14511l = new SparseArray<>();
        this.f14508i = new SparseIntArray();
        this.o = new TsDurationReader(i4);
        this.q = ExtractorOutput.b0;
        this.x = -1;
        D();
    }

    @Deprecated
    public TsExtractor(int i2, TimestampAdjuster timestampAdjuster, TsPayloadReader.Factory factory) {
        this(i2, 1, SubtitleParser.Factory.f13783a, timestampAdjuster, factory, E);
    }

    @Deprecated
    public TsExtractor(int i2, TimestampAdjuster timestampAdjuster, TsPayloadReader.Factory factory, int i3) {
        this(i2, 1, SubtitleParser.Factory.f13783a, timestampAdjuster, factory, i3);
    }

    public TsExtractor(int i2, SubtitleParser.Factory factory) {
        this(1, i2, factory, new TimestampAdjuster(0), new DefaultTsPayloadReaderFactory(0), E);
    }

    public TsExtractor(SubtitleParser.Factory factory) {
        this(1, 0, factory, new TimestampAdjuster(0), new DefaultTsPayloadReaderFactory(0), E);
    }
}
