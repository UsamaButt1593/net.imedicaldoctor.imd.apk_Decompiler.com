package androidx.media3.exoplayer;

import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.SampleStream;
import java.io.IOException;

@UnstableApi
public abstract class NoSampleRenderer implements Renderer, RendererCapabilities {
    private int X;
    private boolean X2;
    private int Y;
    @Nullable
    private SampleStream Z;
    private RendererConfiguration s;

    public final void A(Format[] formatArr, SampleStream sampleStream, long j2, long j3, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException {
        Assertions.i(!this.X2);
        this.Z = sampleStream;
        x(j3);
    }

    public final void B() throws IOException {
    }

    public long C() {
        return Long.MIN_VALUE;
    }

    /* access modifiers changed from: protected */
    public void D() {
    }

    public final void E(long j2) throws ExoPlaybackException {
        this.X2 = false;
        w(j2, false);
    }

    public final boolean F() {
        return this.X2;
    }

    @Nullable
    public MediaClock G() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void H() throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void I() {
    }

    public /* synthetic */ void a() {
        U0.b(this);
    }

    public int b(Format format) throws ExoPlaybackException {
        return V0.c(0);
    }

    public boolean c() {
        return true;
    }

    public boolean d() {
        return true;
    }

    @Nullable
    public final SampleStream e() {
        return this.Z;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final RendererConfiguration f() {
        return this.s;
    }

    public final int getState() {
        return this.Y;
    }

    public final void h() {
        boolean z = true;
        if (this.Y != 1) {
            z = false;
        }
        Assertions.i(z);
        this.Y = 0;
        this.Z = null;
        this.X2 = false;
        r();
    }

    public final int i() {
        return -2;
    }

    /* access modifiers changed from: protected */
    public final int j() {
        return this.X;
    }

    public /* synthetic */ void k() {
        V0.a(this);
    }

    public final boolean l() {
        return true;
    }

    public void m(Timeline timeline) {
    }

    public final void n(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j2, boolean z, boolean z2, long j3, long j4, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException {
        boolean z3 = z;
        Assertions.i(this.Y == 0);
        this.s = rendererConfiguration;
        this.Y = 1;
        u(z3);
        A(formatArr, sampleStream, j3, j4, mediaPeriodId);
        long j5 = j2;
        w(j2, z3);
    }

    public final void o(int i2, PlayerId playerId, Clock clock) {
        this.X = i2;
    }

    public /* synthetic */ void p() {
        U0.a(this);
    }

    public final void q() {
        this.X2 = true;
    }

    /* access modifiers changed from: protected */
    public void r() {
    }

    public final void reset() {
        Assertions.i(this.Y == 0);
        D();
    }

    public final RendererCapabilities s() {
        return this;
    }

    public final void start() throws ExoPlaybackException {
        boolean z = true;
        if (this.Y != 1) {
            z = false;
        }
        Assertions.i(z);
        this.Y = 2;
        H();
    }

    public final void stop() {
        Assertions.i(this.Y == 2);
        this.Y = 1;
        I();
    }

    public /* synthetic */ void t(RendererCapabilities.Listener listener) {
        V0.b(this, listener);
    }

    /* access modifiers changed from: protected */
    public void u(boolean z) throws ExoPlaybackException {
    }

    public /* synthetic */ void v(float f2, float f3) {
        U0.c(this, f2, f3);
    }

    /* access modifiers changed from: protected */
    public void w(long j2, boolean z) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void x(long j2) throws ExoPlaybackException {
    }

    public int y() throws ExoPlaybackException {
        return 0;
    }

    public void z(int i2, @Nullable Object obj) throws ExoPlaybackException {
    }
}
