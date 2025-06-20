package androidx.media3.exoplayer.source;

import androidx.media3.common.Timeline;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public abstract class ForwardingTimeline extends Timeline {
    protected final Timeline Y2;

    public ForwardingTimeline(Timeline timeline) {
        this.Y2 = timeline;
    }

    public int f(boolean z) {
        return this.Y2.f(z);
    }

    public int g(Object obj) {
        return this.Y2.g(obj);
    }

    public int h(boolean z) {
        return this.Y2.h(z);
    }

    public int j(int i2, int i3, boolean z) {
        return this.Y2.j(i2, i3, z);
    }

    public Timeline.Period l(int i2, Timeline.Period period, boolean z) {
        return this.Y2.l(i2, period, z);
    }

    public int n() {
        return this.Y2.n();
    }

    public int s(int i2, int i3, boolean z) {
        return this.Y2.s(i2, i3, z);
    }

    public Object t(int i2) {
        return this.Y2.t(i2);
    }

    public Timeline.Window v(int i2, Timeline.Window window, long j2) {
        return this.Y2.v(i2, window, j2);
    }

    public int w() {
        return this.Y2.w();
    }
}
