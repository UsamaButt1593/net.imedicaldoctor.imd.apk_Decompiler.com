package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public final class SinglePeriodTimeline extends Timeline {
    private static final Object l3 = new Object();
    private static final MediaItem m3 = new MediaItem.Builder().E("SinglePeriodTimeline").M(Uri.EMPTY).a();
    private final long Y2;
    private final long Z2;
    private final long a3;
    private final long b3;
    private final long c3;
    private final long d3;
    private final long e3;
    private final boolean f3;
    private final boolean g3;
    private final boolean h3;
    @Nullable
    private final Object i3;
    @Nullable
    private final MediaItem j3;
    @Nullable
    private final MediaItem.LiveConfiguration k3;

    @Deprecated
    public SinglePeriodTimeline(long j2, long j4, long j5, long j6, long j7, long j8, long j9, boolean z, boolean z2, @Nullable Object obj, MediaItem mediaItem, @Nullable MediaItem.LiveConfiguration liveConfiguration) {
        this(j2, j4, j5, j6, j7, j8, j9, z, z2, false, obj, mediaItem, liveConfiguration);
    }

    public int g(Object obj) {
        return l3.equals(obj) ? 0 : -1;
    }

    public Timeline.Period l(int i2, Timeline.Period period, boolean z) {
        Assertions.c(i2, 0, 1);
        return period.x((Object) null, z ? l3 : null, 0, this.b3, -this.d3);
    }

    public int n() {
        return 1;
    }

    public Object t(int i2) {
        Assertions.c(i2, 0, 1);
        return l3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r1 > r3) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.media3.common.Timeline.Window v(int r25, androidx.media3.common.Timeline.Window r26, long r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = 0
            r2 = 1
            r3 = r25
            androidx.media3.common.util.Assertions.c(r3, r1, r2)
            long r1 = r0.e3
            boolean r14 = r0.g3
            if (r14 == 0) goto L_0x002e
            boolean r3 = r0.h3
            if (r3 != 0) goto L_0x002e
            r3 = 0
            int r5 = (r27 > r3 ? 1 : (r27 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x002e
            long r3 = r0.c3
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0027
        L_0x0024:
            r16 = r5
            goto L_0x0030
        L_0x0027:
            long r1 = r1 + r27
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 <= 0) goto L_0x002e
            goto L_0x0024
        L_0x002e:
            r16 = r1
        L_0x0030:
            java.lang.Object r4 = androidx.media3.common.Timeline.Window.k3
            androidx.media3.common.MediaItem r5 = r0.j3
            java.lang.Object r6 = r0.i3
            long r7 = r0.Y2
            long r9 = r0.Z2
            long r11 = r0.a3
            boolean r13 = r0.f3
            androidx.media3.common.MediaItem$LiveConfiguration r15 = r0.k3
            long r1 = r0.c3
            r18 = r1
            r21 = 0
            long r1 = r0.d3
            r22 = r1
            r20 = 0
            r3 = r26
            androidx.media3.common.Timeline$Window r1 = r3.k(r4, r5, r6, r7, r9, r11, r13, r14, r15, r16, r18, r20, r21, r22)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.SinglePeriodTimeline.v(int, androidx.media3.common.Timeline$Window, long):androidx.media3.common.Timeline$Window");
    }

    public int w() {
        return 1;
    }

    public SinglePeriodTimeline(long j2, long j4, long j5, long j6, long j7, long j8, long j9, boolean z, boolean z2, boolean z3, @Nullable Object obj, MediaItem mediaItem, @Nullable MediaItem.LiveConfiguration liveConfiguration) {
        this.Y2 = j2;
        this.Z2 = j4;
        this.a3 = j5;
        this.b3 = j6;
        this.c3 = j7;
        this.d3 = j8;
        this.e3 = j9;
        this.f3 = z;
        this.g3 = z2;
        this.h3 = z3;
        this.i3 = obj;
        this.j3 = (MediaItem) Assertions.g(mediaItem);
        this.k3 = liveConfiguration;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SinglePeriodTimeline(long r24, long r26, long r28, long r30, long r32, long r34, long r36, boolean r38, boolean r39, boolean r40, @androidx.annotation.Nullable java.lang.Object r41, @androidx.annotation.Nullable java.lang.Object r42) {
        /*
            r23 = this;
            androidx.media3.common.MediaItem r0 = m3
            androidx.media3.common.MediaItem$Builder r1 = r0.b()
            r2 = r42
            androidx.media3.common.MediaItem$Builder r1 = r1.L(r2)
            androidx.media3.common.MediaItem r21 = r1.a()
            if (r40 == 0) goto L_0x0017
            androidx.media3.common.MediaItem$LiveConfiguration r0 = r0.Z
        L_0x0014:
            r22 = r0
            goto L_0x0019
        L_0x0017:
            r0 = 0
            goto L_0x0014
        L_0x0019:
            r19 = 0
            r2 = r23
            r3 = r24
            r5 = r26
            r7 = r28
            r9 = r30
            r11 = r32
            r13 = r34
            r15 = r36
            r17 = r38
            r18 = r39
            r20 = r41
            r2.<init>(r3, r5, r7, r9, r11, r13, r15, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.SinglePeriodTimeline.<init>(long, long, long, long, long, long, long, boolean, boolean, boolean, java.lang.Object, java.lang.Object):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SinglePeriodTimeline(long j2, long j4, long j5, long j6, boolean z, boolean z2, boolean z3, @Nullable Object obj, MediaItem mediaItem) {
        this(C.f9084b, C.f9084b, C.f9084b, j2, j4, j5, j6, z, z2, false, obj, mediaItem, z3 ? mediaItem.Z : null);
    }

    @Deprecated
    public SinglePeriodTimeline(long j2, long j4, long j5, long j6, boolean z, boolean z2, boolean z3, @Nullable Object obj, @Nullable Object obj2) {
        this((long) C.f9084b, (long) C.f9084b, (long) C.f9084b, j2, j4, j5, j6, z, z2, z3, obj, obj2);
    }

    public SinglePeriodTimeline(long j2, boolean z, boolean z2, boolean z3, @Nullable Object obj, MediaItem mediaItem) {
        this(j2, j2, 0, 0, z, z2, z3, obj, mediaItem);
    }

    @Deprecated
    public SinglePeriodTimeline(long j2, boolean z, boolean z2, boolean z3, @Nullable Object obj, @Nullable Object obj2) {
        this(j2, j2, 0, 0, z, z2, z3, obj, obj2);
    }
}
