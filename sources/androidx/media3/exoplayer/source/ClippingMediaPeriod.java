package androidx.media3.exoplayer.source;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.ClippingMediaSource;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import java.io.IOException;
import java.util.List;

@UnstableApi
public final class ClippingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    @Nullable
    private MediaPeriod.Callback X;
    long X2;
    private ClippingSampleStream[] Y = new ClippingSampleStream[0];
    long Y2;
    private long Z;
    @Nullable
    private ClippingMediaSource.IllegalClippingException Z2;
    public final MediaPeriod s;

    private final class ClippingSampleStream implements SampleStream {
        private boolean X;
        public final SampleStream s;

        public ClippingSampleStream(SampleStream sampleStream) {
            this.s = sampleStream;
        }

        public void a() {
            this.X = false;
        }

        public void b() throws IOException {
            this.s.b();
        }

        public boolean d() {
            return !ClippingMediaPeriod.this.p() && this.s.d();
        }

        public int j(long j2) {
            if (ClippingMediaPeriod.this.p()) {
                return -3;
            }
            return this.s.j(j2);
        }

        public int o(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            if (ClippingMediaPeriod.this.p()) {
                return -3;
            }
            if (this.X) {
                decoderInputBuffer.p(4);
                return -4;
            }
            long g2 = ClippingMediaPeriod.this.g();
            int o = this.s.o(formatHolder, decoderInputBuffer, i2);
            if (o == -5) {
                Format format = (Format) Assertions.g(formatHolder.f10226b);
                int i3 = format.v3;
                if (!(i3 == 0 && format.w3 == 0)) {
                    ClippingMediaPeriod clippingMediaPeriod = ClippingMediaPeriod.this;
                    int i4 = 0;
                    if (clippingMediaPeriod.X2 != 0) {
                        i3 = 0;
                    }
                    if (clippingMediaPeriod.Y2 == Long.MIN_VALUE) {
                        i4 = format.w3;
                    }
                    formatHolder.f10226b = format.c().S(i3).T(i4).I();
                }
                return -5;
            }
            long j2 = ClippingMediaPeriod.this.Y2;
            if (j2 == Long.MIN_VALUE || ((o != -4 || decoderInputBuffer.Y2 < j2) && (o != -3 || g2 != Long.MIN_VALUE || decoderInputBuffer.X2))) {
                return o;
            }
            decoderInputBuffer.g();
            decoderInputBuffer.p(4);
            this.X = true;
            return -4;
        }
    }

    public ClippingMediaPeriod(MediaPeriod mediaPeriod, boolean z, long j2, long j3) {
        this.s = mediaPeriod;
        this.Z = z ? j2 : C.f9084b;
        this.X2 = j2;
        this.Y2 = j3;
    }

    private SeekParameters d(long j2, SeekParameters seekParameters) {
        long x = Util.x(seekParameters.f10452a, 0, j2 - this.X2);
        long j3 = seekParameters.f10453b;
        long j4 = this.Y2;
        long x2 = Util.x(j3, 0, j4 == Long.MIN_VALUE ? Long.MAX_VALUE : j4 - j2);
        return (x == seekParameters.f10452a && x2 == seekParameters.f10453b) ? seekParameters : new SeekParameters(x, x2);
    }

    private static boolean w(long j2, ExoTrackSelection[] exoTrackSelectionArr) {
        if (j2 != 0) {
            for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
                if (exoTrackSelection != null) {
                    Format o = exoTrackSelection.o();
                    if (!MimeTypes.a(o.f3, o.c3)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean a(LoadingInfo loadingInfo) {
        return this.s.a(loadingInfo);
    }

    public boolean c() {
        return this.s.c();
    }

    public long e() {
        long e2 = this.s.e();
        if (e2 != Long.MIN_VALUE) {
            long j2 = this.Y2;
            if (j2 == Long.MIN_VALUE || e2 < j2) {
                return e2;
            }
        }
        return Long.MIN_VALUE;
    }

    public long f(long j2, SeekParameters seekParameters) {
        long j3 = this.X2;
        if (j2 == j3) {
            return j3;
        }
        return this.s.f(j2, d(j2, seekParameters));
    }

    public long g() {
        long g2 = this.s.g();
        if (g2 != Long.MIN_VALUE) {
            long j2 = this.Y2;
            if (j2 == Long.MIN_VALUE || g2 < j2) {
                return g2;
            }
        }
        return Long.MIN_VALUE;
    }

    public void h(long j2) {
        this.s.h(j2);
    }

    public void i(MediaPeriod mediaPeriod) {
        if (this.Z2 == null) {
            ((MediaPeriod.Callback) Assertions.g(this.X)).i(this);
        }
    }

    public List<StreamKey> k(List<ExoTrackSelection> list) {
        return this.s.k(list);
    }

    public void l() throws IOException {
        ClippingMediaSource.IllegalClippingException illegalClippingException = this.Z2;
        if (illegalClippingException == null) {
            this.s.l();
            return;
        }
        throw illegalClippingException;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (r0 > r7) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long m(long r7) {
        /*
            r6 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6.Z = r0
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream[] r0 = r6.Y
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x000c:
            if (r3 >= r1) goto L_0x0018
            r4 = r0[r3]
            if (r4 == 0) goto L_0x0015
            r4.a()
        L_0x0015:
            int r3 = r3 + 1
            goto L_0x000c
        L_0x0018:
            androidx.media3.exoplayer.source.MediaPeriod r0 = r6.s
            long r0 = r0.m(r7)
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0034
            long r7 = r6.X2
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 < 0) goto L_0x0035
            long r7 = r6.Y2
            r3 = -9223372036854775808
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0034
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 > 0) goto L_0x0035
        L_0x0034:
            r2 = 1
        L_0x0035:
            androidx.media3.common.util.Assertions.i(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.ClippingMediaPeriod.m(long):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005e, code lost:
        if (r2 > r4) goto L_0x0061;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long n(androidx.media3.exoplayer.trackselection.ExoTrackSelection[] r13, boolean[] r14, androidx.media3.exoplayer.source.SampleStream[] r15, boolean[] r16, long r17) {
        /*
            r12 = this;
            r0 = r12
            r1 = r15
            int r2 = r1.length
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream[] r2 = new androidx.media3.exoplayer.source.ClippingMediaPeriod.ClippingSampleStream[r2]
            r0.Y = r2
            int r2 = r1.length
            androidx.media3.exoplayer.source.SampleStream[] r9 = new androidx.media3.exoplayer.source.SampleStream[r2]
            r10 = 0
            r2 = 0
        L_0x000c:
            int r3 = r1.length
            r11 = 0
            if (r2 >= r3) goto L_0x0021
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream[] r3 = r0.Y
            r4 = r1[r2]
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream r4 = (androidx.media3.exoplayer.source.ClippingMediaPeriod.ClippingSampleStream) r4
            r3[r2] = r4
            if (r4 == 0) goto L_0x001c
            androidx.media3.exoplayer.source.SampleStream r11 = r4.s
        L_0x001c:
            r9[r2] = r11
            int r2 = r2 + 1
            goto L_0x000c
        L_0x0021:
            androidx.media3.exoplayer.source.MediaPeriod r2 = r0.s
            r3 = r13
            r4 = r14
            r5 = r9
            r6 = r16
            r7 = r17
            long r2 = r2.n(r3, r4, r5, r6, r7)
            boolean r4 = r12.p()
            if (r4 == 0) goto L_0x0043
            long r4 = r0.X2
            int r6 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0043
            r6 = r13
            boolean r4 = w(r4, r13)
            if (r4 == 0) goto L_0x0043
            r4 = r2
            goto L_0x0048
        L_0x0043:
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0048:
            r0.Z = r4
            int r4 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r4 == 0) goto L_0x0063
            long r4 = r0.X2
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 < 0) goto L_0x0061
            long r4 = r0.Y2
            r6 = -9223372036854775808
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0063
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x0061
            goto L_0x0063
        L_0x0061:
            r4 = 0
            goto L_0x0064
        L_0x0063:
            r4 = 1
        L_0x0064:
            androidx.media3.common.util.Assertions.i(r4)
        L_0x0067:
            int r4 = r1.length
            if (r10 >= r4) goto L_0x008d
            r4 = r9[r10]
            if (r4 != 0) goto L_0x0073
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream[] r4 = r0.Y
            r4[r10] = r11
            goto L_0x0084
        L_0x0073:
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream[] r5 = r0.Y
            r6 = r5[r10]
            if (r6 == 0) goto L_0x007d
            androidx.media3.exoplayer.source.SampleStream r6 = r6.s
            if (r6 == r4) goto L_0x0084
        L_0x007d:
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream r6 = new androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream
            r6.<init>(r4)
            r5[r10] = r6
        L_0x0084:
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream[] r4 = r0.Y
            r4 = r4[r10]
            r1[r10] = r4
            int r10 = r10 + 1
            goto L_0x0067
        L_0x008d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.ClippingMediaPeriod.n(androidx.media3.exoplayer.trackselection.ExoTrackSelection[], boolean[], androidx.media3.exoplayer.source.SampleStream[], boolean[], long):long");
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        return this.Z != C.f9084b;
    }

    public long q() {
        if (p()) {
            long j2 = this.Z;
            this.Z = C.f9084b;
            long q = q();
            return q != C.f9084b ? q : j2;
        }
        long q2 = this.s.q();
        if (q2 == C.f9084b) {
            return C.f9084b;
        }
        boolean z = false;
        Assertions.i(q2 >= this.X2);
        long j3 = this.Y2;
        if (j3 == Long.MIN_VALUE || q2 <= j3) {
            z = true;
        }
        Assertions.i(z);
        return q2;
    }

    public void r(MediaPeriod.Callback callback, long j2) {
        this.X = callback;
        this.s.r(this, j2);
    }

    public TrackGroupArray s() {
        return this.s.s();
    }

    public void t(long j2, boolean z) {
        this.s.t(j2, z);
    }

    /* renamed from: u */
    public void j(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Assertions.g(this.X)).j(this);
    }

    public void v(ClippingMediaSource.IllegalClippingException illegalClippingException) {
        this.Z2 = illegalClippingException;
    }

    public void x(long j2, long j3) {
        this.X2 = j2;
        this.Y2 = j3;
    }
}
