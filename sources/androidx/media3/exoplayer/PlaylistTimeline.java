package androidx.media3.exoplayer;

import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.ForwardingTimeline;
import androidx.media3.exoplayer.source.ShuffleOrder;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

final class PlaylistTimeline extends AbstractConcatenatedTimeline {
    private final int b3;
    private final int c3;
    private final int[] d3;
    private final int[] e3;
    private final Timeline[] f3;
    private final Object[] g3;
    private final HashMap<Object, Integer> h3;

    public PlaylistTimeline(Collection<? extends MediaSourceInfoHolder> collection, ShuffleOrder shuffleOrder) {
        this(N(collection), O(collection), shuffleOrder);
    }

    private static Timeline[] N(Collection<? extends MediaSourceInfoHolder> collection) {
        Timeline[] timelineArr = new Timeline[collection.size()];
        int i2 = 0;
        for (MediaSourceInfoHolder a2 : collection) {
            timelineArr[i2] = a2.a();
            i2++;
        }
        return timelineArr;
    }

    private static Object[] O(Collection<? extends MediaSourceInfoHolder> collection) {
        Object[] objArr = new Object[collection.size()];
        int i2 = 0;
        for (MediaSourceInfoHolder b2 : collection) {
            objArr[i2] = b2.b();
            i2++;
        }
        return objArr;
    }

    /* access modifiers changed from: protected */
    public int A(int i2) {
        return Util.m(this.d3, i2 + 1, false, false);
    }

    /* access modifiers changed from: protected */
    public int B(int i2) {
        return Util.m(this.e3, i2 + 1, false, false);
    }

    /* access modifiers changed from: protected */
    public Object E(int i2) {
        return this.g3[i2];
    }

    /* access modifiers changed from: protected */
    public int G(int i2) {
        return this.d3[i2];
    }

    /* access modifiers changed from: protected */
    public int H(int i2) {
        return this.e3[i2];
    }

    /* access modifiers changed from: protected */
    public Timeline K(int i2) {
        return this.f3[i2];
    }

    public PlaylistTimeline L(ShuffleOrder shuffleOrder) {
        Timeline[] timelineArr = new Timeline[this.f3.length];
        int i2 = 0;
        while (true) {
            Timeline[] timelineArr2 = this.f3;
            if (i2 >= timelineArr2.length) {
                return new PlaylistTimeline(timelineArr, this.g3, shuffleOrder);
            }
            timelineArr[i2] = new ForwardingTimeline(timelineArr2[i2]) {
                private final Timeline.Window Z2 = new Timeline.Window();

                public Timeline.Period l(int i2, Timeline.Period period, boolean z) {
                    Timeline.Period l2 = super.l(i2, period, z);
                    if (super.u(l2.Y, this.Z2).j()) {
                        l2.y(period.s, period.X, period.Y, period.Z, period.X2, AdPlaybackState.e3, true);
                    } else {
                        l2.Y2 = true;
                    }
                    return l2;
                }
            };
            i2++;
        }
    }

    /* access modifiers changed from: package-private */
    public List<Timeline> M() {
        return Arrays.asList(this.f3);
    }

    public int n() {
        return this.c3;
    }

    public int w() {
        return this.b3;
    }

    /* access modifiers changed from: protected */
    public int z(Object obj) {
        Integer num = this.h3.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private PlaylistTimeline(Timeline[] timelineArr, Object[] objArr, ShuffleOrder shuffleOrder) {
        super(false, shuffleOrder);
        int i2 = 0;
        int length = timelineArr.length;
        this.f3 = timelineArr;
        this.d3 = new int[length];
        this.e3 = new int[length];
        this.g3 = objArr;
        this.h3 = new HashMap<>();
        int length2 = timelineArr.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 < length2) {
            Timeline timeline = timelineArr[i2];
            this.f3[i5] = timeline;
            this.e3[i5] = i3;
            this.d3[i5] = i4;
            i3 += timeline.w();
            i4 += this.f3[i5].n();
            this.h3.put(objArr[i5], Integer.valueOf(i5));
            i2++;
            i5++;
        }
        this.b3 = i3;
        this.c3 = i4;
    }
}
