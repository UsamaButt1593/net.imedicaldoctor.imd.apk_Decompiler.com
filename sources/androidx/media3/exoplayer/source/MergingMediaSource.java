package androidx.media3.exoplayer.source;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@UnstableApi
public final class MergingMediaSource extends CompositeMediaSource<Integer> {
    private static final int o3 = -1;
    private static final MediaItem p3 = new MediaItem.Builder().E("MergingMediaSource").a();
    private final boolean d3;
    private final boolean e3;
    private final MediaSource[] f3;
    private final Timeline[] g3;
    private final ArrayList<MediaSource> h3;
    private final CompositeSequenceableLoaderFactory i3;
    private final Map<Object, Long> j3;
    private final Multimap<Object, ClippingMediaPeriod> k3;
    private int l3;
    private long[][] m3;
    @Nullable
    private IllegalMergeException n3;

    private static final class ClippedTimeline extends ForwardingTimeline {
        private final long[] Z2;
        private final long[] a3;

        public ClippedTimeline(Timeline timeline, Map<Object, Long> map) {
            super(timeline);
            int w = timeline.w();
            this.a3 = new long[timeline.w()];
            Timeline.Window window = new Timeline.Window();
            for (int i2 = 0; i2 < w; i2++) {
                this.a3[i2] = timeline.u(i2, window).g3;
            }
            int n2 = timeline.n();
            this.Z2 = new long[n2];
            Timeline.Period period = new Timeline.Period();
            for (int i3 = 0; i3 < n2; i3++) {
                timeline.l(i3, period, true);
                long longValue = ((Long) Assertions.g(map.get(period.X))).longValue();
                long[] jArr = this.Z2;
                longValue = longValue == Long.MIN_VALUE ? period.Z : longValue;
                jArr[i3] = longValue;
                long j2 = period.Z;
                if (j2 != C.f9084b) {
                    long[] jArr2 = this.a3;
                    int i4 = period.Y;
                    jArr2[i4] = jArr2[i4] - (j2 - longValue);
                }
            }
        }

        public Timeline.Period l(int i2, Timeline.Period period, boolean z) {
            super.l(i2, period, z);
            period.Z = this.Z2[i2];
            return period;
        }

        public Timeline.Window v(int i2, Timeline.Window window, long j2) {
            long j3;
            super.v(i2, window, j2);
            long j4 = this.a3[i2];
            window.g3 = j4;
            if (j4 != C.f9084b) {
                long j5 = window.f3;
                if (j5 != C.f9084b) {
                    j3 = Math.min(j5, j4);
                    window.f3 = j3;
                    return window;
                }
            }
            j3 = window.f3;
            window.f3 = j3;
            return window;
        }
    }

    public static final class IllegalMergeException extends IOException {
        public static final int X = 0;
        public final int s;

        @Documented
        @Target({ElementType.TYPE_USE})
        @Retention(RetentionPolicy.SOURCE)
        public @interface Reason {
        }

        public IllegalMergeException(int i2) {
            this.s = i2;
        }
    }

    public MergingMediaSource(boolean z, boolean z2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, MediaSource... mediaSourceArr) {
        this.d3 = z;
        this.e3 = z2;
        this.f3 = mediaSourceArr;
        this.i3 = compositeSequenceableLoaderFactory;
        this.h3 = new ArrayList<>(Arrays.asList(mediaSourceArr));
        this.l3 = -1;
        this.g3 = new Timeline[mediaSourceArr.length];
        this.m3 = new long[0][];
        this.j3 = new HashMap();
        this.k3 = MultimapBuilder.d().a().a();
    }

    private void J0() {
        Timeline.Period period = new Timeline.Period();
        for (int i2 = 0; i2 < this.l3; i2++) {
            long j2 = -this.g3[0].k(i2, period).s();
            int i4 = 1;
            while (true) {
                Timeline[] timelineArr = this.g3;
                if (i4 >= timelineArr.length) {
                    break;
                }
                this.m3[i2][i4] = j2 - (-timelineArr[i4].k(i2, period).s());
                i4++;
            }
        }
    }

    private void M0() {
        Timeline[] timelineArr;
        Timeline.Period period = new Timeline.Period();
        for (int i2 = 0; i2 < this.l3; i2++) {
            long j2 = Long.MIN_VALUE;
            int i4 = 0;
            while (true) {
                timelineArr = this.g3;
                if (i4 >= timelineArr.length) {
                    break;
                }
                long o = timelineArr[i4].k(i2, period).o();
                if (o != C.f9084b) {
                    long j4 = o + this.m3[i2][i4];
                    if (j2 == Long.MIN_VALUE || j4 < j2) {
                        j2 = j4;
                    }
                }
                i4++;
            }
            Object t = timelineArr[0].t(i2);
            this.j3.put(t, Long.valueOf(j2));
            for (ClippingMediaPeriod x : this.k3.get(t)) {
                x.x(0, j2);
            }
        }
    }

    public MediaPeriod E(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        int length = this.f3.length;
        MediaPeriod[] mediaPeriodArr = new MediaPeriod[length];
        int g2 = this.g3[0].g(mediaPeriodId.f12163a);
        for (int i2 = 0; i2 < length; i2++) {
            mediaPeriodArr[i2] = this.f3[i2].E(mediaPeriodId.a(this.g3[i2].t(g2)), allocator, j2 - this.m3[g2][i2]);
        }
        MergingMediaPeriod mergingMediaPeriod = new MergingMediaPeriod(this.i3, this.m3[g2], mediaPeriodArr);
        if (!this.e3) {
            return mergingMediaPeriod;
        }
        ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(mergingMediaPeriod, true, 0, ((Long) Assertions.g(this.j3.get(mediaPeriodId.f12163a))).longValue());
        this.k3.put(mediaPeriodId.f12163a, clippingMediaPeriod);
        return clippingMediaPeriod;
    }

    public MediaItem H() {
        MediaSource[] mediaSourceArr = this.f3;
        return mediaSourceArr.length > 0 ? mediaSourceArr[0].H() : p3;
    }

    public void I() throws IOException {
        IllegalMergeException illegalMergeException = this.n3;
        if (illegalMergeException == null) {
            super.I();
            return;
        }
        throw illegalMergeException;
    }

    /* access modifiers changed from: protected */
    @Nullable
    /* renamed from: K0 */
    public MediaSource.MediaPeriodId C0(Integer num, MediaSource.MediaPeriodId mediaPeriodId) {
        if (num.intValue() == 0) {
            return mediaPeriodId;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: L0 */
    public void G0(Integer num, MediaSource mediaSource, Timeline timeline) {
        if (this.n3 == null) {
            if (this.l3 == -1) {
                this.l3 = timeline.n();
            } else if (timeline.n() != this.l3) {
                this.n3 = new IllegalMergeException(0);
                return;
            }
            if (this.m3.length == 0) {
                int i2 = this.l3;
                int[] iArr = new int[2];
                iArr[1] = this.g3.length;
                iArr[0] = i2;
                this.m3 = (long[][]) Array.newInstance(Long.TYPE, iArr);
            }
            this.h3.remove(mediaSource);
            this.g3[num.intValue()] = timeline;
            if (this.h3.isEmpty()) {
                if (this.d3) {
                    J0();
                }
                ClippedTimeline clippedTimeline = this.g3[0];
                if (this.e3) {
                    M0();
                    clippedTimeline = new ClippedTimeline(clippedTimeline, this.j3);
                }
                t0(clippedTimeline);
            }
        }
    }

    public boolean S(MediaItem mediaItem) {
        MediaSource[] mediaSourceArr = this.f3;
        return mediaSourceArr.length > 0 && mediaSourceArr[0].S(mediaItem);
    }

    public void X(MediaPeriod mediaPeriod) {
        if (this.e3) {
            ClippingMediaPeriod clippingMediaPeriod = (ClippingMediaPeriod) mediaPeriod;
            Iterator<Map.Entry<Object, ClippingMediaPeriod>> it2 = this.k3.j().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry next = it2.next();
                if (((ClippingMediaPeriod) next.getValue()).equals(clippingMediaPeriod)) {
                    this.k3.remove(next.getKey(), next.getValue());
                    break;
                }
            }
            mediaPeriod = clippingMediaPeriod.s;
        }
        MergingMediaPeriod mergingMediaPeriod = (MergingMediaPeriod) mediaPeriod;
        int i2 = 0;
        while (true) {
            MediaSource[] mediaSourceArr = this.f3;
            if (i2 < mediaSourceArr.length) {
                mediaSourceArr[i2].X(mergingMediaPeriod.p(i2));
                i2++;
            } else {
                return;
            }
        }
    }

    public void k(MediaItem mediaItem) {
        this.f3[0].k(mediaItem);
    }

    /* access modifiers changed from: protected */
    public void s0(@Nullable TransferListener transferListener) {
        super.s0(transferListener);
        for (int i2 = 0; i2 < this.f3.length; i2++) {
            H0(Integer.valueOf(i2), this.f3[i2]);
        }
    }

    /* access modifiers changed from: protected */
    public void u0() {
        super.u0();
        Arrays.fill(this.g3, (Object) null);
        this.l3 = -1;
        this.n3 = null;
        this.h3.clear();
        Collections.addAll(this.h3, this.f3);
    }

    public MergingMediaSource(boolean z, boolean z2, MediaSource... mediaSourceArr) {
        this(z, z2, new DefaultCompositeSequenceableLoaderFactory(), mediaSourceArr);
    }

    public MergingMediaSource(boolean z, MediaSource... mediaSourceArr) {
        this(z, false, mediaSourceArr);
    }

    public MergingMediaSource(MediaSource... mediaSourceArr) {
        this(false, mediaSourceArr);
    }
}
