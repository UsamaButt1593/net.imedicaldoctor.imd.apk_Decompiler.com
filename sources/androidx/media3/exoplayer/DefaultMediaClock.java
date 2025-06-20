package androidx.media3.exoplayer;

import androidx.annotation.Nullable;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;

final class DefaultMediaClock implements MediaClock {
    private final PlaybackParametersListener X;
    private boolean X2 = true;
    @Nullable
    private Renderer Y;
    private boolean Y2;
    @Nullable
    private MediaClock Z;
    private final StandaloneMediaClock s;

    public interface PlaybackParametersListener {
        void k(PlaybackParameters playbackParameters);
    }

    public DefaultMediaClock(PlaybackParametersListener playbackParametersListener, Clock clock) {
        this.X = playbackParametersListener;
        this.s = new StandaloneMediaClock(clock);
    }

    private boolean d(boolean z) {
        Renderer renderer = this.Y;
        return renderer == null || renderer.c() || (z && this.Y.getState() != 2) || (!this.Y.d() && (z || this.Y.l()));
    }

    private void i(boolean z) {
        if (d(z)) {
            this.X2 = true;
            if (this.Y2) {
                this.s.b();
                return;
            }
            return;
        }
        MediaClock mediaClock = (MediaClock) Assertions.g(this.Z);
        long u = mediaClock.u();
        if (this.X2) {
            if (u < this.s.u()) {
                this.s.c();
                return;
            }
            this.X2 = false;
            if (this.Y2) {
                this.s.b();
            }
        }
        this.s.a(u);
        PlaybackParameters r = mediaClock.r();
        if (!r.equals(this.s.r())) {
            this.s.f(r);
            this.X.k(r);
        }
    }

    public void a(Renderer renderer) {
        if (renderer == this.Y) {
            this.Z = null;
            this.Y = null;
            this.X2 = true;
        }
    }

    public void b(Renderer renderer) throws ExoPlaybackException {
        MediaClock mediaClock;
        MediaClock G = renderer.G();
        if (G != null && G != (mediaClock = this.Z)) {
            if (mediaClock == null) {
                this.Z = G;
                this.Y = renderer;
                G.f(this.s.r());
                return;
            }
            throw ExoPlaybackException.o(new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
        }
    }

    public void c(long j2) {
        this.s.a(j2);
    }

    public void e() {
        this.Y2 = true;
        this.s.b();
    }

    public void f(PlaybackParameters playbackParameters) {
        MediaClock mediaClock = this.Z;
        if (mediaClock != null) {
            mediaClock.f(playbackParameters);
            playbackParameters = this.Z.r();
        }
        this.s.f(playbackParameters);
    }

    public void g() {
        this.Y2 = false;
        this.s.c();
    }

    public long h(boolean z) {
        i(z);
        return u();
    }

    public PlaybackParameters r() {
        MediaClock mediaClock = this.Z;
        return mediaClock != null ? mediaClock.r() : this.s.r();
    }

    public long u() {
        return this.X2 ? this.s.u() : ((MediaClock) Assertions.g(this.Z)).u();
    }

    public boolean x() {
        return this.X2 ? this.s.x() : ((MediaClock) Assertions.g(this.Z)).x();
    }
}
