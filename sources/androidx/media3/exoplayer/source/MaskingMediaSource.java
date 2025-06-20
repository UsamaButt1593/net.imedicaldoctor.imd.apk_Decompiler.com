package androidx.media3.exoplayer.source;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.C;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public final class MaskingMediaSource extends WrappingMediaSource {
    private final boolean f3;
    private final Timeline.Window g3;
    private final Timeline.Period h3;
    private MaskingTimeline i3;
    @Nullable
    private MaskingMediaPeriod j3;
    private boolean k3;
    private boolean l3;
    private boolean m3;

    private static final class MaskingTimeline extends ForwardingTimeline {
        public static final Object b3 = new Object();
        @Nullable
        private final Object Z2;
        /* access modifiers changed from: private */
        @Nullable
        public final Object a3;

        private MaskingTimeline(Timeline timeline, @Nullable Object obj, @Nullable Object obj2) {
            super(timeline);
            this.Z2 = obj;
            this.a3 = obj2;
        }

        public static MaskingTimeline B(MediaItem mediaItem) {
            return new MaskingTimeline(new PlaceholderTimeline(mediaItem), Timeline.Window.k3, b3);
        }

        public static MaskingTimeline C(Timeline timeline, @Nullable Object obj, @Nullable Object obj2) {
            return new MaskingTimeline(timeline, obj, obj2);
        }

        public MaskingTimeline A(Timeline timeline) {
            return new MaskingTimeline(timeline, this.Z2, this.a3);
        }

        public int g(Object obj) {
            Object obj2;
            Timeline timeline = this.Y2;
            if (b3.equals(obj) && (obj2 = this.a3) != null) {
                obj = obj2;
            }
            return timeline.g(obj);
        }

        public Timeline.Period l(int i2, Timeline.Period period, boolean z) {
            this.Y2.l(i2, period, z);
            if (Util.g(period.X, this.a3) && z) {
                period.X = b3;
            }
            return period;
        }

        public Object t(int i2) {
            Object t = this.Y2.t(i2);
            return Util.g(t, this.a3) ? b3 : t;
        }

        public Timeline.Window v(int i2, Timeline.Window window, long j2) {
            this.Y2.v(i2, window, j2);
            if (Util.g(window.s, this.Z2)) {
                window.s = Timeline.Window.k3;
            }
            return window;
        }
    }

    @VisibleForTesting
    public static final class PlaceholderTimeline extends Timeline {
        private final MediaItem Y2;

        public PlaceholderTimeline(MediaItem mediaItem) {
            this.Y2 = mediaItem;
        }

        public int g(Object obj) {
            return obj == MaskingTimeline.b3 ? 0 : -1;
        }

        public Timeline.Period l(int i2, Timeline.Period period, boolean z) {
            Object obj = null;
            Integer num = z ? 0 : null;
            if (z) {
                obj = MaskingTimeline.b3;
            }
            period.y(num, obj, 0, C.f9084b, 0, AdPlaybackState.e3, true);
            return period;
        }

        public int n() {
            return 1;
        }

        public Object t(int i2) {
            return MaskingTimeline.b3;
        }

        public Timeline.Window v(int i2, Timeline.Window window, long j2) {
            Timeline.Window window2 = window;
            window.k(Timeline.Window.k3, this.Y2, (Object) null, C.f9084b, C.f9084b, C.f9084b, false, true, (MediaItem.LiveConfiguration) null, 0, C.f9084b, 0, 0, 0);
            Timeline.Window window3 = window;
            window3.e3 = true;
            return window3;
        }

        public int w() {
            return 1;
        }
    }

    public MaskingMediaSource(MediaSource mediaSource, boolean z) {
        super(mediaSource);
        this.f3 = z && mediaSource.K();
        this.g3 = new Timeline.Window();
        this.h3 = new Timeline.Period();
        Timeline L = mediaSource.L();
        if (L != null) {
            this.i3 = MaskingTimeline.C(L, (Object) null, (Object) null);
            this.m3 = true;
            return;
        }
        this.i3 = MaskingTimeline.B(mediaSource.H());
    }

    private Object X0(Object obj) {
        return (this.i3.a3 == null || !this.i3.a3.equals(obj)) ? obj : MaskingTimeline.b3;
    }

    private Object Y0(Object obj) {
        return (this.i3.a3 == null || !obj.equals(MaskingTimeline.b3)) ? obj : this.i3.a3;
    }

    @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    private void a1(long j2) {
        MaskingMediaPeriod maskingMediaPeriod = this.j3;
        int g2 = this.i3.g(maskingMediaPeriod.s.f12163a);
        if (g2 != -1) {
            long j4 = this.i3.k(g2, this.h3).Z;
            if (j4 != C.f9084b && j2 >= j4) {
                j2 = Math.max(0, j4 - 1);
            }
            maskingMediaPeriod.x(j2);
        }
    }

    public void I() {
    }

    /* access modifiers changed from: protected */
    @Nullable
    public MediaSource.MediaPeriodId L0(MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId.a(X0(mediaPeriodId.f12163a));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void R0(androidx.media3.common.Timeline r15) {
        /*
            r14 = this;
            boolean r0 = r14.l3
            if (r0 == 0) goto L_0x0019
            androidx.media3.exoplayer.source.MaskingMediaSource$MaskingTimeline r0 = r14.i3
            androidx.media3.exoplayer.source.MaskingMediaSource$MaskingTimeline r15 = r0.A(r15)
            r14.i3 = r15
            androidx.media3.exoplayer.source.MaskingMediaPeriod r15 = r14.j3
            if (r15 == 0) goto L_0x00ae
            long r0 = r15.p()
            r14.a1(r0)
            goto L_0x00ae
        L_0x0019:
            boolean r0 = r15.x()
            if (r0 == 0) goto L_0x0036
            boolean r0 = r14.m3
            if (r0 == 0) goto L_0x002a
            androidx.media3.exoplayer.source.MaskingMediaSource$MaskingTimeline r0 = r14.i3
            androidx.media3.exoplayer.source.MaskingMediaSource$MaskingTimeline r15 = r0.A(r15)
            goto L_0x0032
        L_0x002a:
            java.lang.Object r0 = androidx.media3.common.Timeline.Window.k3
            java.lang.Object r1 = androidx.media3.exoplayer.source.MaskingMediaSource.MaskingTimeline.b3
            androidx.media3.exoplayer.source.MaskingMediaSource$MaskingTimeline r15 = androidx.media3.exoplayer.source.MaskingMediaSource.MaskingTimeline.C(r15, r0, r1)
        L_0x0032:
            r14.i3 = r15
            goto L_0x00ae
        L_0x0036:
            androidx.media3.common.Timeline$Window r0 = r14.g3
            r1 = 0
            r15.u(r1, r0)
            androidx.media3.common.Timeline$Window r0 = r14.g3
            long r2 = r0.e()
            androidx.media3.common.Timeline$Window r0 = r14.g3
            java.lang.Object r0 = r0.s
            androidx.media3.exoplayer.source.MaskingMediaPeriod r4 = r14.j3
            if (r4 == 0) goto L_0x0074
            long r4 = r4.u()
            androidx.media3.exoplayer.source.MaskingMediaSource$MaskingTimeline r6 = r14.i3
            androidx.media3.exoplayer.source.MaskingMediaPeriod r7 = r14.j3
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r7 = r7.s
            java.lang.Object r7 = r7.f12163a
            androidx.media3.common.Timeline$Period r8 = r14.h3
            r6.m(r7, r8)
            androidx.media3.common.Timeline$Period r6 = r14.h3
            long r6 = r6.s()
            long r6 = r6 + r4
            androidx.media3.exoplayer.source.MaskingMediaSource$MaskingTimeline r4 = r14.i3
            androidx.media3.common.Timeline$Window r5 = r14.g3
            androidx.media3.common.Timeline$Window r1 = r4.u(r1, r5)
            long r4 = r1.e()
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x0074
            r12 = r6
            goto L_0x0075
        L_0x0074:
            r12 = r2
        L_0x0075:
            androidx.media3.common.Timeline$Window r9 = r14.g3
            androidx.media3.common.Timeline$Period r10 = r14.h3
            r11 = 0
            r8 = r15
            android.util.Pair r1 = r8.q(r9, r10, r11, r12)
            java.lang.Object r2 = r1.first
            java.lang.Object r1 = r1.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r3 = r1.longValue()
            boolean r1 = r14.m3
            if (r1 == 0) goto L_0x0094
            androidx.media3.exoplayer.source.MaskingMediaSource$MaskingTimeline r0 = r14.i3
            androidx.media3.exoplayer.source.MaskingMediaSource$MaskingTimeline r15 = r0.A(r15)
            goto L_0x0098
        L_0x0094:
            androidx.media3.exoplayer.source.MaskingMediaSource$MaskingTimeline r15 = androidx.media3.exoplayer.source.MaskingMediaSource.MaskingTimeline.C(r15, r0, r2)
        L_0x0098:
            r14.i3 = r15
            androidx.media3.exoplayer.source.MaskingMediaPeriod r15 = r14.j3
            if (r15 == 0) goto L_0x00ae
            r14.a1(r3)
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r15 = r15.s
            java.lang.Object r0 = r15.f12163a
            java.lang.Object r0 = r14.Y0(r0)
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r15 = r15.a(r0)
            goto L_0x00af
        L_0x00ae:
            r15 = 0
        L_0x00af:
            r0 = 1
            r14.m3 = r0
            r14.l3 = r0
            androidx.media3.exoplayer.source.MaskingMediaSource$MaskingTimeline r0 = r14.i3
            r14.t0(r0)
            if (r15 == 0) goto L_0x00c6
            androidx.media3.exoplayer.source.MaskingMediaPeriod r0 = r14.j3
            java.lang.Object r0 = androidx.media3.common.util.Assertions.g(r0)
            androidx.media3.exoplayer.source.MaskingMediaPeriod r0 = (androidx.media3.exoplayer.source.MaskingMediaPeriod) r0
            r0.d(r15)
        L_0x00c6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.MaskingMediaSource.R0(androidx.media3.common.Timeline):void");
    }

    public boolean S(MediaItem mediaItem) {
        return this.d3.S(mediaItem);
    }

    public void U0() {
        if (!this.f3) {
            this.k3 = true;
            T0();
        }
    }

    /* renamed from: W0 */
    public MaskingMediaPeriod E(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(mediaPeriodId, allocator, j2);
        maskingMediaPeriod.z(this.d3);
        if (this.l3) {
            maskingMediaPeriod.d(mediaPeriodId.a(Y0(mediaPeriodId.f12163a)));
        } else {
            this.j3 = maskingMediaPeriod;
            if (!this.k3) {
                this.k3 = true;
                T0();
            }
        }
        return maskingMediaPeriod;
    }

    public void X(MediaPeriod mediaPeriod) {
        ((MaskingMediaPeriod) mediaPeriod).y();
        if (mediaPeriod == this.j3) {
            this.j3 = null;
        }
    }

    public Timeline Z0() {
        return this.i3;
    }

    public void k(MediaItem mediaItem) {
        this.i3 = this.m3 ? this.i3.A(new TimelineWithUpdatedMediaItem(this.i3.Y2, mediaItem)) : MaskingTimeline.B(mediaItem);
        this.d3.k(mediaItem);
    }

    public void u0() {
        this.l3 = false;
        this.k3 = false;
        super.u0();
    }
}
