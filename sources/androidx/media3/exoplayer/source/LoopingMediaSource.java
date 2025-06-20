package androidx.media3.exoplayer.source;

import androidx.annotation.Nullable;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.AbstractConcatenatedTimeline;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ShuffleOrder;
import androidx.media3.exoplayer.upstream.Allocator;
import java.util.HashMap;
import java.util.Map;

@UnstableApi
@Deprecated
public final class LoopingMediaSource extends WrappingMediaSource {
    private final int f3;
    private final Map<MediaSource.MediaPeriodId, MediaSource.MediaPeriodId> g3;
    private final Map<MediaPeriod, MediaSource.MediaPeriodId> h3;

    private static final class InfinitelyLoopingTimeline extends ForwardingTimeline {
        public InfinitelyLoopingTimeline(Timeline timeline) {
            super(timeline);
        }

        public int j(int i2, int i3, boolean z) {
            int j2 = this.Y2.j(i2, i3, z);
            return j2 == -1 ? f(z) : j2;
        }

        public int s(int i2, int i3, boolean z) {
            int s = this.Y2.s(i2, i3, z);
            return s == -1 ? h(z) : s;
        }
    }

    private static final class LoopingTimeline extends AbstractConcatenatedTimeline {
        private final Timeline b3;
        private final int c3;
        private final int d3;
        private final int e3;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoopingTimeline(Timeline timeline, int i2) {
            super(false, new ShuffleOrder.UnshuffledShuffleOrder(i2));
            boolean z = false;
            this.b3 = timeline;
            int n2 = timeline.n();
            this.c3 = n2;
            this.d3 = timeline.w();
            this.e3 = i2;
            if (n2 > 0) {
                Assertions.j(i2 <= Integer.MAX_VALUE / n2 ? true : z, "LoopingMediaSource contains too many periods");
            }
        }

        /* access modifiers changed from: protected */
        public int A(int i2) {
            return i2 / this.c3;
        }

        /* access modifiers changed from: protected */
        public int B(int i2) {
            return i2 / this.d3;
        }

        /* access modifiers changed from: protected */
        public Object E(int i2) {
            return Integer.valueOf(i2);
        }

        /* access modifiers changed from: protected */
        public int G(int i2) {
            return i2 * this.c3;
        }

        /* access modifiers changed from: protected */
        public int H(int i2) {
            return i2 * this.d3;
        }

        /* access modifiers changed from: protected */
        public Timeline K(int i2) {
            return this.b3;
        }

        public int n() {
            return this.c3 * this.e3;
        }

        public int w() {
            return this.d3 * this.e3;
        }

        /* access modifiers changed from: protected */
        public int z(Object obj) {
            if (!(obj instanceof Integer)) {
                return -1;
            }
            return ((Integer) obj).intValue();
        }
    }

    public LoopingMediaSource(MediaSource mediaSource) {
        this(mediaSource, Integer.MAX_VALUE);
    }

    public MediaPeriod E(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        if (this.f3 == Integer.MAX_VALUE) {
            return this.d3.E(mediaPeriodId, allocator, j2);
        }
        MediaSource.MediaPeriodId a2 = mediaPeriodId.a(AbstractConcatenatedTimeline.C(mediaPeriodId.f12163a));
        this.g3.put(a2, mediaPeriodId);
        MediaPeriod E = this.d3.E(a2, allocator, j2);
        this.h3.put(E, a2);
        return E;
    }

    public boolean K() {
        return false;
    }

    @Nullable
    public Timeline L() {
        MaskingMediaSource maskingMediaSource = (MaskingMediaSource) this.d3;
        return this.f3 != Integer.MAX_VALUE ? new LoopingTimeline(maskingMediaSource.Z0(), this.f3) : new InfinitelyLoopingTimeline(maskingMediaSource.Z0());
    }

    /* access modifiers changed from: protected */
    @Nullable
    public MediaSource.MediaPeriodId L0(MediaSource.MediaPeriodId mediaPeriodId) {
        return this.f3 != Integer.MAX_VALUE ? this.g3.get(mediaPeriodId) : mediaPeriodId;
    }

    /* access modifiers changed from: protected */
    public void R0(Timeline timeline) {
        t0(this.f3 != Integer.MAX_VALUE ? new LoopingTimeline(timeline, this.f3) : new InfinitelyLoopingTimeline(timeline));
    }

    public void X(MediaPeriod mediaPeriod) {
        this.d3.X(mediaPeriod);
        MediaSource.MediaPeriodId remove = this.h3.remove(mediaPeriod);
        if (remove != null) {
            this.g3.remove(remove);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoopingMediaSource(MediaSource mediaSource, int i2) {
        super(new MaskingMediaSource(mediaSource, false));
        boolean z = false;
        Assertions.a(i2 > 0 ? true : z);
        this.f3 = i2;
        this.g3 = new HashMap();
        this.h3 = new HashMap();
    }
}
