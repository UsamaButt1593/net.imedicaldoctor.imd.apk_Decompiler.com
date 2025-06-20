package androidx.media3.exoplayer;

import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
public final class StandaloneMediaClock implements MediaClock {
    private boolean X;
    private PlaybackParameters X2 = PlaybackParameters.Z;
    private long Y;
    private long Z;
    private final Clock s;

    public StandaloneMediaClock(Clock clock) {
        this.s = clock;
    }

    public void a(long j2) {
        this.Y = j2;
        if (this.X) {
            this.Z = this.s.b();
        }
    }

    public void b() {
        if (!this.X) {
            this.Z = this.s.b();
            this.X = true;
        }
    }

    public void c() {
        if (this.X) {
            a(u());
            this.X = false;
        }
    }

    public void f(PlaybackParameters playbackParameters) {
        if (this.X) {
            a(u());
        }
        this.X2 = playbackParameters;
    }

    public PlaybackParameters r() {
        return this.X2;
    }

    public long u() {
        long j2 = this.Y;
        if (!this.X) {
            return j2;
        }
        long b2 = this.s.b() - this.Z;
        PlaybackParameters playbackParameters = this.X2;
        return j2 + (playbackParameters.s == 1.0f ? Util.I1(b2) : playbackParameters.c(b2));
    }

    public /* synthetic */ boolean x() {
        return F0.a(this);
    }
}
