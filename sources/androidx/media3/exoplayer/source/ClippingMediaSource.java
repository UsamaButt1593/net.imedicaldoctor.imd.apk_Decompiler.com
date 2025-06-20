package androidx.media3.exoplayer.source;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

@UnstableApi
public final class ClippingMediaSource extends WrappingMediaSource {
    private final long f3;
    private final long g3;
    private final boolean h3;
    private final boolean i3;
    private final boolean j3;
    private final ArrayList<ClippingMediaPeriod> k3;
    private final Timeline.Window l3;
    @Nullable
    private ClippingTimeline m3;
    @Nullable
    private IllegalClippingException n3;
    private long o3;
    private long p3;

    private static final class ClippingTimeline extends ForwardingTimeline {
        private final long Z2;
        private final long a3;
        private final long b3;
        private final boolean c3;

        public ClippingTimeline(Timeline timeline, long j2, long j3) throws IllegalClippingException {
            super(timeline);
            boolean z = false;
            if (timeline.n() == 1) {
                Timeline.Window u = timeline.u(0, new Timeline.Window());
                long max = Math.max(0, j2);
                if (u.e3 || max == 0 || u.a3) {
                    long max2 = j3 == Long.MIN_VALUE ? u.g3 : Math.max(0, j3);
                    long j4 = u.g3;
                    if (j4 != C.f9084b) {
                        max2 = max2 > j4 ? j4 : max2;
                        if (max > max2) {
                            throw new IllegalClippingException(2);
                        }
                    }
                    this.Z2 = max;
                    this.a3 = max2;
                    int i2 = (max2 > C.f9084b ? 1 : (max2 == C.f9084b ? 0 : -1));
                    this.b3 = i2 == 0 ? -9223372036854775807L : max2 - max;
                    if (u.b3 && (i2 == 0 || (j4 != C.f9084b && max2 == j4))) {
                        z = true;
                    }
                    this.c3 = z;
                    return;
                }
                throw new IllegalClippingException(1);
            }
            throw new IllegalClippingException(0);
        }

        public Timeline.Period l(int i2, Timeline.Period period, boolean z) {
            this.Y2.l(0, period, z);
            long s = period.s() - this.Z2;
            long j2 = this.b3;
            return period.x(period.s, period.X, 0, j2 == C.f9084b ? -9223372036854775807L : j2 - s, s);
        }

        public Timeline.Window v(int i2, Timeline.Window window, long j2) {
            this.Y2.v(0, window, 0);
            long j3 = window.j3;
            long j4 = this.Z2;
            window.j3 = j3 + j4;
            window.g3 = this.b3;
            window.b3 = this.c3;
            long j5 = window.f3;
            if (j5 != C.f9084b) {
                long max = Math.max(j5, j4);
                window.f3 = max;
                long j6 = this.a3;
                if (j6 != C.f9084b) {
                    max = Math.min(max, j6);
                }
                window.f3 = max - this.Z2;
            }
            long H2 = Util.H2(this.Z2);
            long j7 = window.X2;
            if (j7 != C.f9084b) {
                window.X2 = j7 + H2;
            }
            long j8 = window.Y2;
            if (j8 != C.f9084b) {
                window.Y2 = j8 + H2;
            }
            return window;
        }
    }

    public static final class IllegalClippingException extends IOException {
        public static final int X = 0;
        public static final int Y = 1;
        public static final int Z = 2;
        public final int s;

        @Documented
        @Target({ElementType.TYPE_USE})
        @Retention(RetentionPolicy.SOURCE)
        public @interface Reason {
        }

        public IllegalClippingException(int i2) {
            super("Illegal clipping: " + a(i2));
            this.s = i2;
        }

        private static String a(int i2) {
            if (i2 == 0) {
                return "invalid period count";
            }
            if (i2 != 1) {
                return i2 != 2 ? "unknown" : "start exceeds end";
            }
            return "not seekable to start";
        }
    }

    public ClippingMediaSource(MediaSource mediaSource, long j2) {
        this(mediaSource, 0, j2, true, false, true);
    }

    private void W0(Timeline timeline) {
        long j2;
        timeline.u(0, this.l3);
        long i2 = this.l3.i();
        long j4 = Long.MIN_VALUE;
        if (this.m3 == null || this.k3.isEmpty() || this.i3) {
            long j5 = this.f3;
            long j6 = this.g3;
            if (this.j3) {
                long e2 = this.l3.e();
                j5 += e2;
                j6 += e2;
            }
            this.o3 = i2 + j5;
            if (this.g3 != Long.MIN_VALUE) {
                j4 = i2 + j6;
            }
            this.p3 = j4;
            int size = this.k3.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.k3.get(i4).x(this.o3, this.p3);
            }
            j2 = j5;
            j4 = j6;
        } else {
            long j7 = this.o3 - i2;
            if (this.g3 != Long.MIN_VALUE) {
                j4 = this.p3 - i2;
            }
            j2 = j7;
        }
        try {
            ClippingTimeline clippingTimeline = new ClippingTimeline(timeline, j2, j4);
            this.m3 = clippingTimeline;
            t0(clippingTimeline);
        } catch (IllegalClippingException e3) {
            this.n3 = e3;
            for (int i5 = 0; i5 < this.k3.size(); i5++) {
                this.k3.get(i5).v(this.n3);
            }
        }
    }

    public MediaPeriod E(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(this.d3.E(mediaPeriodId, allocator, j2), this.h3, this.o3, this.p3);
        this.k3.add(clippingMediaPeriod);
        return clippingMediaPeriod;
    }

    public void I() throws IOException {
        IllegalClippingException illegalClippingException = this.n3;
        if (illegalClippingException == null) {
            super.I();
            return;
        }
        throw illegalClippingException;
    }

    /* access modifiers changed from: protected */
    public void R0(Timeline timeline) {
        if (this.n3 == null) {
            W0(timeline);
        }
    }

    public boolean S(MediaItem mediaItem) {
        return H().Y2.equals(mediaItem.Y2) && this.d3.S(mediaItem);
    }

    public void X(MediaPeriod mediaPeriod) {
        Assertions.i(this.k3.remove(mediaPeriod));
        this.d3.X(((ClippingMediaPeriod) mediaPeriod).s);
        if (this.k3.isEmpty() && !this.i3) {
            W0(((ClippingTimeline) Assertions.g(this.m3)).Y2);
        }
    }

    /* access modifiers changed from: protected */
    public void u0() {
        super.u0();
        this.n3 = null;
        this.m3 = null;
    }

    public ClippingMediaSource(MediaSource mediaSource, long j2, long j4) {
        this(mediaSource, j2, j4, true, false, false);
    }

    public ClippingMediaSource(MediaSource mediaSource, long j2, long j4, boolean z, boolean z2, boolean z3) {
        super((MediaSource) Assertions.g(mediaSource));
        Assertions.a(j2 >= 0);
        this.f3 = j2;
        this.g3 = j4;
        this.h3 = z;
        this.i3 = z2;
        this.j3 = z3;
        this.k3 = new ArrayList<>();
        this.l3 = new Timeline.Window();
    }
}
