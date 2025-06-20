package androidx.media3.exoplayer;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.SampleStream;
import java.io.IOException;

@UnstableApi
public abstract class BaseRenderer implements Renderer, RendererCapabilities {
    private final int X;
    private int X2;
    private final FormatHolder Y;
    private PlayerId Y2;
    @Nullable
    private RendererConfiguration Z;
    private Clock Z2;
    private int a3;
    @Nullable
    private SampleStream b3;
    @Nullable
    private Format[] c3;
    private long d3;
    private long e3;
    private long f3;
    private boolean g3;
    private boolean h3;
    private Timeline i3;
    @GuardedBy("lock")
    @Nullable
    private RendererCapabilities.Listener j3;
    private final Object s = new Object();

    public BaseRenderer(int i2) {
        this.X = i2;
        this.Y = new FormatHolder();
        this.f3 = Long.MIN_VALUE;
        this.i3 = Timeline.s;
    }

    private void e0(long j2, boolean z) throws ExoPlaybackException {
        this.g3 = false;
        this.e3 = j2;
        this.f3 = j2;
        V(j2, z);
    }

    public final void A(Format[] formatArr, SampleStream sampleStream, long j2, long j4, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException {
        Assertions.i(!this.g3);
        this.b3 = sampleStream;
        if (this.f3 == Long.MIN_VALUE) {
            this.f3 = j2;
        }
        this.c3 = formatArr;
        this.d3 = j4;
        b0(formatArr, j2, j4, mediaPeriodId);
    }

    public final void B() throws IOException {
        ((SampleStream) Assertions.g(this.b3)).b();
    }

    public final long C() {
        return this.f3;
    }

    public final void E(long j2) throws ExoPlaybackException {
        e0(j2, false);
    }

    public final boolean F() {
        return this.g3;
    }

    @Nullable
    public MediaClock G() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final ExoPlaybackException H(Throwable th, @Nullable Format format, int i2) {
        return I(th, format, false, i2);
    }

    /* access modifiers changed from: protected */
    public final ExoPlaybackException I(Throwable th, @Nullable Format format, boolean z, int i2) {
        int i4;
        if (format != null && !this.h3) {
            this.h3 = true;
            try {
                int k2 = V0.k(b(format));
                this.h3 = false;
                i4 = k2;
            } catch (ExoPlaybackException unused) {
                this.h3 = false;
            } catch (Throwable th2) {
                this.h3 = false;
                throw th2;
            }
            return ExoPlaybackException.l(th, getName(), M(), format, i4, z, i2);
        }
        i4 = 4;
        return ExoPlaybackException.l(th, getName(), M(), format, i4, z, i2);
    }

    /* access modifiers changed from: protected */
    public final Clock J() {
        return (Clock) Assertions.g(this.Z2);
    }

    /* access modifiers changed from: protected */
    public final RendererConfiguration K() {
        return (RendererConfiguration) Assertions.g(this.Z);
    }

    /* access modifiers changed from: protected */
    public final FormatHolder L() {
        this.Y.a();
        return this.Y;
    }

    /* access modifiers changed from: protected */
    public final int M() {
        return this.X2;
    }

    /* access modifiers changed from: protected */
    public final long N() {
        return this.e3;
    }

    /* access modifiers changed from: protected */
    public final PlayerId O() {
        return (PlayerId) Assertions.g(this.Y2);
    }

    /* access modifiers changed from: protected */
    public final Format[] P() {
        return (Format[]) Assertions.g(this.c3);
    }

    /* access modifiers changed from: protected */
    public final Timeline Q() {
        return this.i3;
    }

    /* access modifiers changed from: protected */
    public final boolean R() {
        return l() ? this.g3 : ((SampleStream) Assertions.g(this.b3)).d();
    }

    /* access modifiers changed from: protected */
    public void S() {
    }

    /* access modifiers changed from: protected */
    public void T(boolean z, boolean z2) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void U() {
    }

    /* access modifiers changed from: protected */
    public void V(long j2, boolean z) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void W() {
    }

    /* access modifiers changed from: protected */
    public final void X() {
        RendererCapabilities.Listener listener;
        synchronized (this.s) {
            listener = this.j3;
        }
        if (listener != null) {
            listener.a(this);
        }
    }

    /* access modifiers changed from: protected */
    public void Y() {
    }

    /* access modifiers changed from: protected */
    public void Z() throws ExoPlaybackException {
    }

    public final void a() {
        Assertions.i(this.a3 == 0);
        W();
    }

    /* access modifiers changed from: protected */
    public void a0() {
    }

    /* access modifiers changed from: protected */
    public void b0(Format[] formatArr, long j2, long j4, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void c0(Timeline timeline) {
    }

    /* access modifiers changed from: protected */
    public final int d0(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
        int o = ((SampleStream) Assertions.g(this.b3)).o(formatHolder, decoderInputBuffer, i2);
        if (o == -4) {
            if (decoderInputBuffer.l()) {
                this.f3 = Long.MIN_VALUE;
                return this.g3 ? -4 : -3;
            }
            long j2 = decoderInputBuffer.Y2 + this.d3;
            decoderInputBuffer.Y2 = j2;
            this.f3 = Math.max(this.f3, j2);
        } else if (o == -5) {
            Format format = (Format) Assertions.g(formatHolder.f10226b);
            if (format.j3 != Long.MAX_VALUE) {
                formatHolder.f10226b = format.c().o0(format.j3 + this.d3).I();
            }
        }
        return o;
    }

    @Nullable
    public final SampleStream e() {
        return this.b3;
    }

    /* access modifiers changed from: protected */
    public int f0(long j2) {
        return ((SampleStream) Assertions.g(this.b3)).j(j2 - this.d3);
    }

    public final int getState() {
        return this.a3;
    }

    public final void h() {
        boolean z = true;
        if (this.a3 != 1) {
            z = false;
        }
        Assertions.i(z);
        this.Y.a();
        this.a3 = 0;
        this.b3 = null;
        this.c3 = null;
        this.g3 = false;
        S();
    }

    public final int i() {
        return this.X;
    }

    public final void k() {
        synchronized (this.s) {
            this.j3 = null;
        }
    }

    public final boolean l() {
        return this.f3 == Long.MIN_VALUE;
    }

    public final void m(Timeline timeline) {
        if (!Util.g(this.i3, timeline)) {
            this.i3 = timeline;
            c0(timeline);
        }
    }

    public final void n(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j2, boolean z, boolean z2, long j4, long j5, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException {
        boolean z3 = z;
        Assertions.i(this.a3 == 0);
        this.Z = rendererConfiguration;
        this.a3 = 1;
        T(z3, z2);
        A(formatArr, sampleStream, j4, j5, mediaPeriodId);
        e0(j4, z3);
    }

    public final void o(int i2, PlayerId playerId, Clock clock) {
        this.X2 = i2;
        this.Y2 = playerId;
        this.Z2 = clock;
        U();
    }

    public /* synthetic */ void p() {
        U0.a(this);
    }

    public final void q() {
        this.g3 = true;
    }

    public final void reset() {
        Assertions.i(this.a3 == 0);
        this.Y.a();
        Y();
    }

    public final RendererCapabilities s() {
        return this;
    }

    public final void start() throws ExoPlaybackException {
        boolean z = true;
        if (this.a3 != 1) {
            z = false;
        }
        Assertions.i(z);
        this.a3 = 2;
        Z();
    }

    public final void stop() {
        Assertions.i(this.a3 == 2);
        this.a3 = 1;
        a0();
    }

    public final void t(RendererCapabilities.Listener listener) {
        synchronized (this.s) {
            this.j3 = listener;
        }
    }

    public /* synthetic */ void v(float f2, float f4) {
        U0.c(this, f2, f4);
    }

    public int y() throws ExoPlaybackException {
        return 0;
    }

    public void z(int i2, @Nullable Object obj) throws ExoPlaybackException {
    }
}
