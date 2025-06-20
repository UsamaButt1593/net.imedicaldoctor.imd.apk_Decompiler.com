package androidx.media3.extractor.flv;

import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.d;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public final class FlvExtractor implements Extractor {
    private static final int A = 8;
    private static final int B = 9;
    private static final int C = 18;
    private static final int D = 4607062;
    public static final ExtractorsFactory t = new a();
    private static final int u = 1;
    private static final int v = 2;
    private static final int w = 3;
    private static final int x = 4;
    private static final int y = 9;
    private static final int z = 11;

    /* renamed from: d  reason: collision with root package name */
    private final ParsableByteArray f13275d = new ParsableByteArray(4);

    /* renamed from: e  reason: collision with root package name */
    private final ParsableByteArray f13276e = new ParsableByteArray(9);

    /* renamed from: f  reason: collision with root package name */
    private final ParsableByteArray f13277f = new ParsableByteArray(11);

    /* renamed from: g  reason: collision with root package name */
    private final ParsableByteArray f13278g = new ParsableByteArray();

    /* renamed from: h  reason: collision with root package name */
    private final ScriptTagPayloadReader f13279h = new ScriptTagPayloadReader();

    /* renamed from: i  reason: collision with root package name */
    private ExtractorOutput f13280i;

    /* renamed from: j  reason: collision with root package name */
    private int f13281j = 1;

    /* renamed from: k  reason: collision with root package name */
    private boolean f13282k;

    /* renamed from: l  reason: collision with root package name */
    private long f13283l;

    /* renamed from: m  reason: collision with root package name */
    private int f13284m;

    /* renamed from: n  reason: collision with root package name */
    private int f13285n;
    private int o;
    private long p;
    private boolean q;
    private AudioTagPayloadReader r;
    private VideoTagPayloadReader s;

    @RequiresNonNull({"extractorOutput"})
    private void f() {
        if (!this.q) {
            this.f13280i.j(new SeekMap.Unseekable(C.f9084b));
            this.q = true;
        }
    }

    private long g() {
        if (this.f13282k) {
            return this.f13283l + this.p;
        }
        if (this.f13279h.e() == C.f9084b) {
            return 0;
        }
        return this.p;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] j() {
        return new Extractor[]{new FlvExtractor()};
    }

    private ParsableByteArray k(ExtractorInput extractorInput) throws IOException {
        if (this.o > this.f13278g.b()) {
            ParsableByteArray parsableByteArray = this.f13278g;
            parsableByteArray.W(new byte[Math.max(parsableByteArray.b() * 2, this.o)], 0);
        } else {
            this.f13278g.Y(0);
        }
        this.f13278g.X(this.o);
        extractorInput.readFully(this.f13278g.e(), 0, this.o);
        return this.f13278g;
    }

    @RequiresNonNull({"extractorOutput"})
    private boolean l(ExtractorInput extractorInput) throws IOException {
        boolean z2 = false;
        if (!extractorInput.d(this.f13276e.e(), 0, 9, true)) {
            return false;
        }
        this.f13276e.Y(0);
        this.f13276e.Z(4);
        int L = this.f13276e.L();
        boolean z3 = (L & 4) != 0;
        if ((L & 1) != 0) {
            z2 = true;
        }
        if (z3 && this.r == null) {
            this.r = new AudioTagPayloadReader(this.f13280i.d(8, 1));
        }
        if (z2 && this.s == null) {
            this.s = new VideoTagPayloadReader(this.f13280i.d(9, 2));
        }
        this.f13280i.o();
        this.f13284m = this.f13276e.s() - 5;
        this.f13281j = 2;
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0083  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"extractorOutput"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m(androidx.media3.extractor.ExtractorInput r10) throws java.io.IOException {
        /*
            r9 = this;
            long r0 = r9.g()
            int r2 = r9.f13285n
            r3 = 8
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = 1
            if (r2 != r3) goto L_0x0023
            androidx.media3.extractor.flv.AudioTagPayloadReader r3 = r9.r
            if (r3 == 0) goto L_0x0023
            r9.f()
            androidx.media3.extractor.flv.AudioTagPayloadReader r2 = r9.r
        L_0x0019:
            androidx.media3.common.util.ParsableByteArray r10 = r9.k(r10)
            boolean r10 = r2.a(r10, r0)
        L_0x0021:
            r0 = 1
            goto L_0x006d
        L_0x0023:
            r3 = 9
            if (r2 != r3) goto L_0x0031
            androidx.media3.extractor.flv.VideoTagPayloadReader r3 = r9.s
            if (r3 == 0) goto L_0x0031
            r9.f()
            androidx.media3.extractor.flv.VideoTagPayloadReader r2 = r9.s
            goto L_0x0019
        L_0x0031:
            r3 = 18
            if (r2 != r3) goto L_0x0066
            boolean r2 = r9.q
            if (r2 != 0) goto L_0x0066
            androidx.media3.extractor.flv.ScriptTagPayloadReader r2 = r9.f13279h
            androidx.media3.common.util.ParsableByteArray r10 = r9.k(r10)
            boolean r10 = r2.a(r10, r0)
            androidx.media3.extractor.flv.ScriptTagPayloadReader r0 = r9.f13279h
            long r0 = r0.e()
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0021
            androidx.media3.extractor.ExtractorOutput r2 = r9.f13280i
            androidx.media3.extractor.IndexSeekMap r3 = new androidx.media3.extractor.IndexSeekMap
            androidx.media3.extractor.flv.ScriptTagPayloadReader r7 = r9.f13279h
            long[] r7 = r7.f()
            androidx.media3.extractor.flv.ScriptTagPayloadReader r8 = r9.f13279h
            long[] r8 = r8.g()
            r3.<init>(r7, r8, r0)
            r2.j(r3)
            r9.q = r6
            goto L_0x0021
        L_0x0066:
            int r0 = r9.o
            r10.o(r0)
            r10 = 0
            r0 = 0
        L_0x006d:
            boolean r1 = r9.f13282k
            if (r1 != 0) goto L_0x0087
            if (r10 == 0) goto L_0x0087
            r9.f13282k = r6
            androidx.media3.extractor.flv.ScriptTagPayloadReader r10 = r9.f13279h
            long r1 = r10.e()
            int r10 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r10 != 0) goto L_0x0083
            long r1 = r9.p
            long r1 = -r1
            goto L_0x0085
        L_0x0083:
            r1 = 0
        L_0x0085:
            r9.f13283l = r1
        L_0x0087:
            r10 = 4
            r9.f13284m = r10
            r10 = 2
            r9.f13281j = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.flv.FlvExtractor.m(androidx.media3.extractor.ExtractorInput):boolean");
    }

    private boolean n(ExtractorInput extractorInput) throws IOException {
        if (!extractorInput.d(this.f13277f.e(), 0, 11, true)) {
            return false;
        }
        this.f13277f.Y(0);
        this.f13285n = this.f13277f.L();
        this.o = this.f13277f.O();
        this.p = (long) this.f13277f.O();
        this.p = (((long) (this.f13277f.L() << 24)) | this.p) * 1000;
        this.f13277f.Z(3);
        this.f13281j = 4;
        return true;
    }

    private void o(ExtractorInput extractorInput) throws IOException {
        extractorInput.o(this.f13284m);
        this.f13284m = 0;
        this.f13281j = 3;
    }

    public void a() {
    }

    public void c(long j2, long j3) {
        if (j2 == 0) {
            this.f13281j = 1;
            this.f13282k = false;
        } else {
            this.f13281j = 3;
        }
        this.f13284m = 0;
    }

    public void d(ExtractorOutput extractorOutput) {
        this.f13280i = extractorOutput;
    }

    public /* synthetic */ Extractor e() {
        return d.a(this);
    }

    public boolean h(ExtractorInput extractorInput) throws IOException {
        extractorInput.s(this.f13275d.e(), 0, 3);
        this.f13275d.Y(0);
        if (this.f13275d.O() != D) {
            return false;
        }
        extractorInput.s(this.f13275d.e(), 0, 2);
        this.f13275d.Y(0);
        if ((this.f13275d.R() & ItemTouchHelper.Callback.f15380c) != 0) {
            return false;
        }
        extractorInput.s(this.f13275d.e(), 0, 4);
        this.f13275d.Y(0);
        int s2 = this.f13275d.s();
        extractorInput.n();
        extractorInput.j(s2);
        extractorInput.s(this.f13275d.e(), 0, 4);
        this.f13275d.Y(0);
        return this.f13275d.s() == 0;
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        Assertions.k(this.f13280i);
        while (true) {
            int i2 = this.f13281j;
            if (i2 != 1) {
                if (i2 == 2) {
                    o(extractorInput);
                } else if (i2 != 3) {
                    if (i2 != 4) {
                        throw new IllegalStateException();
                    } else if (m(extractorInput)) {
                        return 0;
                    }
                } else if (!n(extractorInput)) {
                    return -1;
                }
            } else if (!l(extractorInput)) {
                return -1;
            }
        }
    }
}
