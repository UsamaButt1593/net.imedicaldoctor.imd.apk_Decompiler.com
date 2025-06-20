package androidx.media3.exoplayer.source;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.IdentityHashMap;

@UnstableApi
public final class ConcatenatingMediaSource2 extends CompositeMediaSource<Integer> {
    private static final int i3 = 0;
    private final ImmutableList<MediaSourceHolder> d3;
    private final IdentityHashMap<MediaPeriod, MediaSourceHolder> e3;
    @Nullable
    private Handler f3;
    private boolean g3;
    @GuardedBy("this")
    private MediaItem h3;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final ImmutableList.Builder<MediaSourceHolder> f12100a = ImmutableList.r();

        /* renamed from: b  reason: collision with root package name */
        private int f12101b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private MediaItem f12102c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private MediaSource.Factory f12103d;

        @CanIgnoreReturnValue
        public Builder a(MediaItem mediaItem) {
            return b(mediaItem, C.f9084b);
        }

        @CanIgnoreReturnValue
        public Builder b(MediaItem mediaItem, long j2) {
            Assertions.g(mediaItem);
            if (j2 == C.f9084b) {
                MediaItem.ClippingConfiguration clippingConfiguration = mediaItem.Y2;
                if (clippingConfiguration.Y != Long.MIN_VALUE) {
                    j2 = Util.H2(clippingConfiguration.Z - clippingConfiguration.X);
                }
            }
            Assertions.l(this.f12103d, "Must use useDefaultMediaSourceFactory or setMediaSourceFactory first.");
            return d(this.f12103d.c(mediaItem), j2);
        }

        @CanIgnoreReturnValue
        public Builder c(MediaSource mediaSource) {
            return d(mediaSource, C.f9084b);
        }

        @CanIgnoreReturnValue
        public Builder d(MediaSource mediaSource, long j2) {
            Assertions.g(mediaSource);
            Assertions.j(!(mediaSource instanceof ProgressiveMediaSource) || j2 != C.f9084b, "Progressive media source must define an initial placeholder duration.");
            ImmutableList.Builder<MediaSourceHolder> builder = this.f12100a;
            int i2 = this.f12101b;
            this.f12101b = i2 + 1;
            builder.g(new MediaSourceHolder(mediaSource, i2, Util.I1(j2)));
            return this;
        }

        public ConcatenatingMediaSource2 e() {
            Assertions.b(this.f12101b > 0, "Must add at least one source to the concatenation.");
            if (this.f12102c == null) {
                this.f12102c = MediaItem.d(Uri.EMPTY);
            }
            return new ConcatenatingMediaSource2(this.f12102c, this.f12100a.e());
        }

        @CanIgnoreReturnValue
        public Builder f(MediaItem mediaItem) {
            this.f12102c = mediaItem;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder g(MediaSource.Factory factory) {
            this.f12103d = (MediaSource.Factory) Assertions.g(factory);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder h(Context context) {
            return g(new DefaultMediaSourceFactory(context));
        }
    }

    private static final class ConcatenatedTimeline extends Timeline {
        private final MediaItem Y2;
        private final ImmutableList<Timeline> Z2;
        private final ImmutableList<Integer> a3;
        private final ImmutableList<Long> b3;
        private final boolean c3;
        private final boolean d3;
        private final long e3;
        private final long f3;
        @Nullable
        private final Object g3;

        public ConcatenatedTimeline(MediaItem mediaItem, ImmutableList<Timeline> immutableList, ImmutableList<Integer> immutableList2, ImmutableList<Long> immutableList3, boolean z, boolean z2, long j2, long j3, @Nullable Object obj) {
            this.Y2 = mediaItem;
            this.Z2 = immutableList;
            this.a3 = immutableList2;
            this.b3 = immutableList3;
            this.c3 = z;
            this.d3 = z2;
            this.e3 = j2;
            this.f3 = j3;
            this.g3 = obj;
        }

        private long A(Timeline.Period period, int i2) {
            if (period.Z == C.f9084b) {
                return C.f9084b;
            }
            return (i2 == this.b3.size() + -1 ? this.e3 : this.b3.get(i2 + 1).longValue()) - this.b3.get(i2).longValue();
        }

        private int z(int i2) {
            return Util.l(this.a3, Integer.valueOf(i2 + 1), false, false);
        }

        public int g(Object obj) {
            if (!(obj instanceof Pair) || !(((Pair) obj).first instanceof Integer)) {
                return -1;
            }
            int K0 = ConcatenatingMediaSource2.O0(obj);
            int g2 = this.Z2.get(K0).g(ConcatenatingMediaSource2.Q0(obj));
            if (g2 == -1) {
                return -1;
            }
            return this.a3.get(K0).intValue() + g2;
        }

        public Timeline.Period l(int i2, Timeline.Period period, boolean z) {
            int z2 = z(i2);
            this.Z2.get(z2).l(i2 - this.a3.get(z2).intValue(), period, z);
            period.Y = 0;
            period.X2 = this.b3.get(i2).longValue();
            period.Z = A(period, i2);
            if (z) {
                period.X = ConcatenatingMediaSource2.U0(z2, Assertions.g(period.X));
            }
            return period;
        }

        public Timeline.Period m(Object obj, Timeline.Period period) {
            int K0 = ConcatenatingMediaSource2.O0(obj);
            Object L0 = ConcatenatingMediaSource2.Q0(obj);
            Timeline timeline = this.Z2.get(K0);
            int intValue = this.a3.get(K0).intValue() + timeline.g(L0);
            timeline.m(L0, period);
            period.Y = 0;
            period.X2 = this.b3.get(intValue).longValue();
            period.Z = A(period, intValue);
            period.X = obj;
            return period;
        }

        public int n() {
            return this.b3.size();
        }

        public Object t(int i2) {
            int z = z(i2);
            return ConcatenatingMediaSource2.U0(z, this.Z2.get(z).t(i2 - this.a3.get(z).intValue()));
        }

        public Timeline.Window v(int i2, Timeline.Window window, long j2) {
            return window.k(Timeline.Window.k3, this.Y2, this.g3, C.f9084b, C.f9084b, C.f9084b, this.c3, this.d3, (MediaItem.LiveConfiguration) null, this.f3, this.e3, 0, n() - 1, -this.b3.get(0).longValue());
        }

        public int w() {
            return 1;
        }
    }

    static final class MediaSourceHolder {

        /* renamed from: a  reason: collision with root package name */
        public final MaskingMediaSource f12104a;

        /* renamed from: b  reason: collision with root package name */
        public final int f12105b;

        /* renamed from: c  reason: collision with root package name */
        public final long f12106c;

        /* renamed from: d  reason: collision with root package name */
        public final HashMap<Object, Long> f12107d = new HashMap<>();

        /* renamed from: e  reason: collision with root package name */
        public int f12108e;

        public MediaSourceHolder(MediaSource mediaSource, int i2, long j2) {
            this.f12104a = new MaskingMediaSource(mediaSource, false);
            this.f12105b = i2;
            this.f12106c = j2;
        }
    }

    private ConcatenatingMediaSource2(MediaItem mediaItem, ImmutableList<MediaSourceHolder> immutableList) {
        this.h3 = mediaItem;
        this.d3 = immutableList;
        this.e3 = new IdentityHashMap<>();
    }

    private void N0() {
        for (int i2 = 0; i2 < this.d3.size(); i2++) {
            MediaSourceHolder mediaSourceHolder = this.d3.get(i2);
            if (mediaSourceHolder.f12108e == 0) {
                A0(Integer.valueOf(mediaSourceHolder.f12105b));
            }
        }
    }

    /* access modifiers changed from: private */
    public static int O0(Object obj) {
        return ((Integer) ((Pair) obj).first).intValue();
    }

    private static int P0(long j2, int i2) {
        return (int) (j2 % ((long) i2));
    }

    /* access modifiers changed from: private */
    public static Object Q0(Object obj) {
        return ((Pair) obj).second;
    }

    private static long R0(long j2, int i2, int i4) {
        return (j2 * ((long) i2)) + ((long) i4);
    }

    /* access modifiers changed from: private */
    public static Object U0(int i2, Object obj) {
        return Pair.create(Integer.valueOf(i2), obj);
    }

    private static long W0(long j2, int i2) {
        return j2 / ((long) i2);
    }

    /* access modifiers changed from: private */
    public boolean X0(Message message) {
        if (message.what != 0) {
            return true;
        }
        b1();
        return true;
    }

    @Nullable
    private ConcatenatedTimeline Y0() {
        int i2;
        boolean z;
        boolean z2;
        Object obj;
        Timeline timeline;
        Object obj2;
        long j2;
        Timeline.Period period;
        boolean z3;
        ConcatenatingMediaSource2 concatenatingMediaSource2 = this;
        Timeline.Window window = new Timeline.Window();
        Timeline.Period period2 = new Timeline.Period();
        ImmutableList.Builder r = ImmutableList.r();
        ImmutableList.Builder r2 = ImmutableList.r();
        ImmutableList.Builder r3 = ImmutableList.r();
        int size = concatenatingMediaSource2.d3.size();
        boolean z4 = true;
        int i4 = 0;
        boolean z5 = true;
        Object obj3 = null;
        int i5 = 0;
        boolean z6 = false;
        boolean z7 = true;
        boolean z8 = false;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        while (i4 < size) {
            MediaSourceHolder mediaSourceHolder = concatenatingMediaSource2.d3.get(i4);
            Timeline Z0 = mediaSourceHolder.f12104a.Z0();
            Assertions.b(Z0.x() ^ z4, "Can't concatenate empty child Timeline.");
            r.g(Z0);
            r2.g(Integer.valueOf(i5));
            i5 += Z0.n();
            int i6 = 0;
            while (i6 < Z0.w()) {
                Z0.u(i6, window);
                if (!z6) {
                    obj3 = window.Z;
                    z6 = true;
                }
                if (!z5 || !Util.g(obj3, window.Z)) {
                    i2 = i4;
                    z = false;
                } else {
                    i2 = i4;
                    z = true;
                }
                long j6 = window.g3;
                if (j6 == C.f9084b) {
                    j6 = mediaSourceHolder.f12106c;
                    if (j6 == C.f9084b) {
                        return null;
                    }
                }
                j3 += j6;
                if (mediaSourceHolder.f12105b == 0 && i6 == 0) {
                    z2 = z;
                    obj = obj3;
                    j4 = window.f3;
                    j5 = -window.j3;
                } else {
                    z2 = z;
                    obj = obj3;
                }
                z7 &= window.a3 || window.e3;
                z8 |= window.b3;
                int i7 = window.h3;
                while (i7 <= window.i3) {
                    r3.g(Long.valueOf(j5));
                    Z0.l(i7, period2, true);
                    int i8 = i5;
                    long j7 = period2.Z;
                    if (j7 == C.f9084b) {
                        Assertions.b(window.h3 == window.i3, "Can't apply placeholder duration to multiple periods with unknown duration in a single window.");
                        j7 = window.j3 + j6;
                    }
                    if (i7 != window.h3 || ((mediaSourceHolder.f12105b == 0 && i6 == 0) || j7 == C.f9084b)) {
                        obj2 = obj;
                        timeline = Z0;
                        j2 = 0;
                    } else {
                        Timeline timeline2 = Z0;
                        obj2 = obj;
                        j2 = -window.j3;
                        j7 += j2;
                        timeline = timeline2;
                    }
                    Object g2 = Assertions.g(period2.X);
                    Timeline.Window window2 = window;
                    if (mediaSourceHolder.f12108e == 0 || !mediaSourceHolder.f12107d.containsKey(g2)) {
                        period = period2;
                    } else {
                        period = period2;
                        if (!mediaSourceHolder.f12107d.get(g2).equals(Long.valueOf(j2))) {
                            z3 = false;
                            Assertions.b(z3, "Can't handle windows with changing offset in first period.");
                            mediaSourceHolder.f12107d.put(g2, Long.valueOf(j2));
                            j5 += j7;
                            i7++;
                            i5 = i8;
                            obj = obj2;
                            Z0 = timeline;
                            window = window2;
                            period2 = period;
                        }
                    }
                    z3 = true;
                    Assertions.b(z3, "Can't handle windows with changing offset in first period.");
                    mediaSourceHolder.f12107d.put(g2, Long.valueOf(j2));
                    j5 += j7;
                    i7++;
                    i5 = i8;
                    obj = obj2;
                    Z0 = timeline;
                    window = window2;
                    period2 = period;
                }
                Timeline.Window window3 = window;
                Timeline.Period period3 = period2;
                Timeline timeline3 = Z0;
                int i9 = i5;
                i6++;
                i4 = i2;
                z5 = z2;
                obj3 = obj;
            }
            Timeline.Window window4 = window;
            Timeline.Period period4 = period2;
            int i10 = i5;
            i4++;
            z4 = true;
            concatenatingMediaSource2 = this;
        }
        return new ConcatenatedTimeline(H(), r.e(), r2.e(), r3.e(), z7, z8, j3, j4, z5 ? obj3 : null);
    }

    private void a1() {
        if (!this.g3) {
            ((Handler) Assertions.g(this.f3)).obtainMessage(0).sendToTarget();
            this.g3 = true;
        }
    }

    private void b1() {
        this.g3 = false;
        ConcatenatedTimeline Y0 = Y0();
        if (Y0 != null) {
            t0(Y0);
        }
    }

    public MediaPeriod E(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        MediaSourceHolder mediaSourceHolder = this.d3.get(O0(mediaPeriodId.f12163a));
        MediaSource.MediaPeriodId b2 = mediaPeriodId.a(Q0(mediaPeriodId.f12163a)).b(R0(mediaPeriodId.f12166d, this.d3.size(), mediaSourceHolder.f12105b));
        B0(Integer.valueOf(mediaSourceHolder.f12105b));
        mediaSourceHolder.f12108e++;
        long longValue = mediaPeriodId.c() ? 0 : ((Long) Assertions.g(mediaSourceHolder.f12107d.get(b2.f12163a))).longValue();
        TimeOffsetMediaPeriod timeOffsetMediaPeriod = new TimeOffsetMediaPeriod(mediaSourceHolder.f12104a.E(b2, allocator, j2 - longValue), longValue);
        this.e3.put(timeOffsetMediaPeriod, mediaSourceHolder);
        N0();
        return timeOffsetMediaPeriod;
    }

    public synchronized MediaItem H() {
        return this.h3;
    }

    @Nullable
    public Timeline L() {
        return Y0();
    }

    public boolean S(MediaItem mediaItem) {
        return true;
    }

    /* access modifiers changed from: protected */
    @Nullable
    /* renamed from: S0 */
    public MediaSource.MediaPeriodId C0(Integer num, MediaSource.MediaPeriodId mediaPeriodId) {
        if (num.intValue() != P0(mediaPeriodId.f12166d, this.d3.size())) {
            return null;
        }
        return mediaPeriodId.a(U0(num.intValue(), mediaPeriodId.f12163a)).b(W0(mediaPeriodId.f12166d, this.d3.size()));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        r4 = r3.d3.get(r4.intValue()).f12107d.get(r7.f12163a);
     */
    /* renamed from: T0 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long D0(java.lang.Integer r4, long r5, @androidx.annotation.Nullable androidx.media3.exoplayer.source.MediaSource.MediaPeriodId r7) {
        /*
            r3 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x0034
            if (r7 == 0) goto L_0x0034
            boolean r0 = r7.c()
            if (r0 == 0) goto L_0x0012
            goto L_0x0034
        L_0x0012:
            com.google.common.collect.ImmutableList<androidx.media3.exoplayer.source.ConcatenatingMediaSource2$MediaSourceHolder> r0 = r3.d3
            int r4 = r4.intValue()
            java.lang.Object r4 = r0.get(r4)
            androidx.media3.exoplayer.source.ConcatenatingMediaSource2$MediaSourceHolder r4 = (androidx.media3.exoplayer.source.ConcatenatingMediaSource2.MediaSourceHolder) r4
            java.util.HashMap<java.lang.Object, java.lang.Long> r4 = r4.f12107d
            java.lang.Object r7 = r7.f12163a
            java.lang.Object r4 = r4.get(r7)
            java.lang.Long r4 = (java.lang.Long) r4
            if (r4 != 0) goto L_0x002b
            return r5
        L_0x002b:
            long r0 = r4.longValue()
            long r0 = androidx.media3.common.util.Util.H2(r0)
            long r5 = r5 + r0
        L_0x0034:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.ConcatenatingMediaSource2.D0(java.lang.Integer, long, androidx.media3.exoplayer.source.MediaSource$MediaPeriodId):long");
    }

    /* access modifiers changed from: protected */
    /* renamed from: V0 */
    public int E0(Integer num, int i2) {
        return 0;
    }

    public void X(MediaPeriod mediaPeriod) {
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) Assertions.g(this.e3.remove(mediaPeriod));
        mediaSourceHolder.f12104a.X(((TimeOffsetMediaPeriod) mediaPeriod).d());
        mediaSourceHolder.f12108e--;
        if (!this.e3.isEmpty()) {
            N0();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: Z0 */
    public void G0(Integer num, MediaSource mediaSource, Timeline timeline) {
        a1();
    }

    /* access modifiers changed from: protected */
    public void j0() {
    }

    public synchronized void k(MediaItem mediaItem) {
        this.h3 = mediaItem;
    }

    /* access modifiers changed from: protected */
    public void s0(@Nullable TransferListener transferListener) {
        super.s0(transferListener);
        this.f3 = new Handler(new C0337c(this));
        for (int i2 = 0; i2 < this.d3.size(); i2++) {
            H0(Integer.valueOf(i2), this.d3.get(i2).f12104a);
        }
        a1();
    }

    /* access modifiers changed from: protected */
    public void u0() {
        super.u0();
        Handler handler = this.f3;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f3 = null;
        }
        this.g3 = false;
    }
}
