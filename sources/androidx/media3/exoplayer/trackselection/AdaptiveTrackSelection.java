package androidx.media3.exoplayer.trackselection;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunkIterator;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@UnstableApi
public class AdaptiveTrackSelection extends BaseTrackSelection {
    public static final int A = 10000;
    public static final int B = 25000;
    public static final int C = 25000;
    public static final int D = 1279;
    public static final int E = 719;
    public static final float F = 0.7f;
    public static final float G = 0.75f;
    private static final long H = 1000;
    private static final String z = "AdaptiveTrackSelection";

    /* renamed from: j  reason: collision with root package name */
    private final BandwidthMeter f12348j;

    /* renamed from: k  reason: collision with root package name */
    private final long f12349k;

    /* renamed from: l  reason: collision with root package name */
    private final long f12350l;

    /* renamed from: m  reason: collision with root package name */
    private final long f12351m;

    /* renamed from: n  reason: collision with root package name */
    private final int f12352n;
    private final int o;
    private final float p;
    private final float q;
    private final ImmutableList<AdaptationCheckpoint> r;
    private final Clock s;
    private float t;
    private int u;
    private int v;
    private long w;
    @Nullable
    private MediaChunk x;
    private long y;

    public static final class AdaptationCheckpoint {

        /* renamed from: a  reason: collision with root package name */
        public final long f12353a;

        /* renamed from: b  reason: collision with root package name */
        public final long f12354b;

        public AdaptationCheckpoint(long j2, long j3) {
            this.f12353a = j2;
            this.f12354b = j3;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AdaptationCheckpoint)) {
                return false;
            }
            AdaptationCheckpoint adaptationCheckpoint = (AdaptationCheckpoint) obj;
            return this.f12353a == adaptationCheckpoint.f12353a && this.f12354b == adaptationCheckpoint.f12354b;
        }

        public int hashCode() {
            return (((int) this.f12353a) * 31) + ((int) this.f12354b);
        }
    }

    public static class Factory implements ExoTrackSelection.Factory {

        /* renamed from: a  reason: collision with root package name */
        private final int f12355a;

        /* renamed from: b  reason: collision with root package name */
        private final int f12356b;

        /* renamed from: c  reason: collision with root package name */
        private final int f12357c;

        /* renamed from: d  reason: collision with root package name */
        private final int f12358d;

        /* renamed from: e  reason: collision with root package name */
        private final int f12359e;

        /* renamed from: f  reason: collision with root package name */
        private final float f12360f;

        /* renamed from: g  reason: collision with root package name */
        private final float f12361g;

        /* renamed from: h  reason: collision with root package name */
        private final Clock f12362h;

        public Factory() {
            this(10000, 25000, 25000, 0.7f);
        }

        public final ExoTrackSelection[] a(ExoTrackSelection.Definition[] definitionArr, BandwidthMeter bandwidthMeter, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
            ExoTrackSelection exoTrackSelection;
            ImmutableList y = AdaptiveTrackSelection.C(definitionArr);
            ExoTrackSelection[] exoTrackSelectionArr = new ExoTrackSelection[definitionArr.length];
            for (int i2 = 0; i2 < definitionArr.length; i2++) {
                ExoTrackSelection.Definition definition = definitionArr[i2];
                if (definition != null) {
                    int[] iArr = definition.f12390b;
                    if (iArr.length != 0) {
                        if (iArr.length == 1) {
                            exoTrackSelection = new FixedTrackSelection(definition.f12389a, iArr[0], definition.f12391c);
                        } else {
                            exoTrackSelection = b(definition.f12389a, iArr, definition.f12391c, bandwidthMeter, (ImmutableList) y.get(i2));
                        }
                        exoTrackSelectionArr[i2] = exoTrackSelection;
                    }
                }
            }
            return exoTrackSelectionArr;
        }

        /* access modifiers changed from: protected */
        public AdaptiveTrackSelection b(TrackGroup trackGroup, int[] iArr, int i2, BandwidthMeter bandwidthMeter, ImmutableList<AdaptationCheckpoint> immutableList) {
            return new AdaptiveTrackSelection(trackGroup, iArr, i2, bandwidthMeter, (long) this.f12355a, (long) this.f12356b, (long) this.f12357c, this.f12358d, this.f12359e, this.f12360f, this.f12361g, immutableList, this.f12362h);
        }

        public Factory(int i2, int i3, int i4, float f2) {
            this(i2, i3, i4, AdaptiveTrackSelection.D, AdaptiveTrackSelection.E, f2, 0.75f, Clock.f9502a);
        }

        public Factory(int i2, int i3, int i4, float f2, float f3, Clock clock) {
            this(i2, i3, i4, AdaptiveTrackSelection.D, AdaptiveTrackSelection.E, f2, f3, clock);
        }

        public Factory(int i2, int i3, int i4, int i5, int i6, float f2) {
            this(i2, i3, i4, i5, i6, f2, 0.75f, Clock.f9502a);
        }

        public Factory(int i2, int i3, int i4, int i5, int i6, float f2, float f3, Clock clock) {
            this.f12355a = i2;
            this.f12356b = i3;
            this.f12357c = i4;
            this.f12358d = i5;
            this.f12359e = i6;
            this.f12360f = f2;
            this.f12361g = f3;
            this.f12362h = clock;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, int i2, BandwidthMeter bandwidthMeter, long j2, long j3, long j4, int i3, int i4, float f2, float f3, List<AdaptationCheckpoint> list, Clock clock) {
        super(trackGroup, iArr, i2);
        BandwidthMeter bandwidthMeter2;
        long j5;
        if (j4 < j2) {
            Log.n(z, "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            bandwidthMeter2 = bandwidthMeter;
            j5 = j2;
        } else {
            bandwidthMeter2 = bandwidthMeter;
            j5 = j4;
        }
        this.f12348j = bandwidthMeter2;
        this.f12349k = j2 * 1000;
        this.f12350l = j3 * 1000;
        this.f12351m = j5 * 1000;
        this.f12352n = i3;
        this.o = i4;
        this.p = f2;
        this.q = f3;
        this.r = ImmutableList.B(list);
        this.s = clock;
        this.t = 1.0f;
        this.v = 0;
        this.w = C.f9084b;
        this.y = -2147483647L;
    }

    private int B(long j2, long j3) {
        long D2 = D(j3);
        int i2 = 0;
        for (int i3 = 0; i3 < this.f12364d; i3++) {
            if (j2 == Long.MIN_VALUE || !b(i3, j2)) {
                Format i4 = i(i3);
                if (A(i4, i4.b3, D2)) {
                    return i3;
                }
                i2 = i3;
            }
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public static ImmutableList<ImmutableList<AdaptationCheckpoint>> C(ExoTrackSelection.Definition[] definitionArr) {
        ImmutableList.Builder builder;
        ArrayList arrayList = new ArrayList();
        for (ExoTrackSelection.Definition definition : definitionArr) {
            if (definition == null || definition.f12390b.length <= 1) {
                builder = null;
            } else {
                builder = ImmutableList.r();
                builder.g(new AdaptationCheckpoint(0, 0));
            }
            arrayList.add(builder);
        }
        long[][] H2 = H(definitionArr);
        int[] iArr = new int[H2.length];
        long[] jArr = new long[H2.length];
        for (int i2 = 0; i2 < H2.length; i2++) {
            long[] jArr2 = H2[i2];
            jArr[i2] = jArr2.length == 0 ? 0 : jArr2[0];
        }
        z(arrayList, jArr);
        ImmutableList<Integer> I = I(H2);
        for (int i3 = 0; i3 < I.size(); i3++) {
            int intValue = I.get(i3).intValue();
            int i4 = iArr[intValue] + 1;
            iArr[intValue] = i4;
            jArr[intValue] = H2[intValue][i4];
            z(arrayList, jArr);
        }
        for (int i5 = 0; i5 < definitionArr.length; i5++) {
            if (arrayList.get(i5) != null) {
                jArr[i5] = jArr[i5] * 2;
            }
        }
        z(arrayList, jArr);
        ImmutableList.Builder r2 = ImmutableList.r();
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            ImmutableList.Builder builder2 = (ImmutableList.Builder) arrayList.get(i6);
            r2.g(builder2 == null ? ImmutableList.I() : builder2.e());
        }
        return r2.e();
    }

    private long D(long j2) {
        long J = J(j2);
        if (this.r.isEmpty()) {
            return J;
        }
        int i2 = 1;
        while (i2 < this.r.size() - 1 && this.r.get(i2).f12353a < J) {
            i2++;
        }
        AdaptationCheckpoint adaptationCheckpoint = this.r.get(i2 - 1);
        AdaptationCheckpoint adaptationCheckpoint2 = this.r.get(i2);
        long j3 = adaptationCheckpoint.f12353a;
        long j4 = adaptationCheckpoint.f12354b;
        return j4 + ((long) ((((float) (J - j3)) / ((float) (adaptationCheckpoint2.f12353a - j3))) * ((float) (adaptationCheckpoint2.f12354b - j4))));
    }

    private long E(List<? extends MediaChunk> list) {
        if (list.isEmpty()) {
            return C.f9084b;
        }
        MediaChunk mediaChunk = (MediaChunk) Iterables.w(list);
        long j2 = mediaChunk.f12284g;
        if (j2 == C.f9084b) {
            return C.f9084b;
        }
        long j3 = mediaChunk.f12285h;
        return j3 != C.f9084b ? j3 - j2 : C.f9084b;
    }

    private long G(MediaChunkIterator[] mediaChunkIteratorArr, List<? extends MediaChunk> list) {
        int i2 = this.u;
        if (i2 >= mediaChunkIteratorArr.length || !mediaChunkIteratorArr[i2].next()) {
            for (MediaChunkIterator mediaChunkIterator : mediaChunkIteratorArr) {
                if (mediaChunkIterator.next()) {
                    return mediaChunkIterator.d() - mediaChunkIterator.a();
                }
            }
            return E(list);
        }
        MediaChunkIterator mediaChunkIterator2 = mediaChunkIteratorArr[this.u];
        return mediaChunkIterator2.d() - mediaChunkIterator2.a();
    }

    private static long[][] H(ExoTrackSelection.Definition[] definitionArr) {
        long[][] jArr = new long[definitionArr.length][];
        for (int i2 = 0; i2 < definitionArr.length; i2++) {
            ExoTrackSelection.Definition definition = definitionArr[i2];
            if (definition == null) {
                jArr[i2] = new long[0];
            } else {
                jArr[i2] = new long[definition.f12390b.length];
                int i3 = 0;
                while (true) {
                    int[] iArr = definition.f12390b;
                    if (i3 >= iArr.length) {
                        break;
                    }
                    long j2 = (long) definition.f12389a.d(iArr[i3]).b3;
                    long[] jArr2 = jArr[i2];
                    if (j2 == -1) {
                        j2 = 0;
                    }
                    jArr2[i3] = j2;
                    i3++;
                }
                Arrays.sort(jArr[i2]);
            }
        }
        return jArr;
    }

    private static ImmutableList<Integer> I(long[][] jArr) {
        ListMultimap<K, V> j2 = MultimapBuilder.h().a().a();
        for (int i2 = 0; i2 < jArr.length; i2++) {
            long[] jArr2 = jArr[i2];
            if (jArr2.length > 1) {
                int length = jArr2.length;
                double[] dArr = new double[length];
                int i3 = 0;
                while (true) {
                    long[] jArr3 = jArr[i2];
                    double d2 = 0.0d;
                    if (i3 >= jArr3.length) {
                        break;
                    }
                    long j3 = jArr3[i3];
                    if (j3 != -1) {
                        d2 = Math.log((double) j3);
                    }
                    dArr[i3] = d2;
                    i3++;
                }
                int i4 = length - 1;
                double d3 = dArr[i4] - dArr[0];
                int i5 = 0;
                while (i5 < i4) {
                    double d4 = dArr[i5];
                    i5++;
                    j2.put(Double.valueOf(d3 == 0.0d ? 1.0d : (((d4 + dArr[i5]) * 0.5d) - dArr[0]) / d3), Integer.valueOf(i2));
                }
            }
        }
        return ImmutableList.B(j2.values());
    }

    private long J(long j2) {
        long i2 = this.f12348j.i();
        this.y = i2;
        long j3 = (long) (((float) i2) * this.p);
        long b2 = this.f12348j.b();
        if (b2 == C.f9084b || j2 == C.f9084b) {
            return (long) (((float) j3) / this.t);
        }
        float f2 = (float) j2;
        return (long) ((((float) j3) * Math.max((f2 / this.t) - ((float) b2), 0.0f)) / f2);
    }

    private long K(long j2, long j3) {
        if (j2 == C.f9084b) {
            return this.f12349k;
        }
        if (j3 != C.f9084b) {
            j2 -= j3;
        }
        return Math.min((long) (((float) j2) * this.q), this.f12349k);
    }

    private static void z(List<ImmutableList.Builder<AdaptationCheckpoint>> list, long[] jArr) {
        long j2 = 0;
        for (long j3 : jArr) {
            j2 += j3;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ImmutableList.Builder builder = list.get(i2);
            if (builder != null) {
                builder.g(new AdaptationCheckpoint(j2, jArr[i2]));
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean A(Format format, int i2, long j2) {
        return ((long) i2) <= j2;
    }

    /* access modifiers changed from: protected */
    public long F() {
        return this.f12351m;
    }

    /* access modifiers changed from: protected */
    public boolean L(long j2, List<? extends MediaChunk> list) {
        long j3 = this.w;
        return j3 == C.f9084b || j2 - j3 >= 1000 || (!list.isEmpty() && !((MediaChunk) Iterables.w(list)).equals(this.x));
    }

    public long a() {
        return this.y;
    }

    public int e() {
        return this.u;
    }

    @CallSuper
    public void h() {
        this.x = null;
    }

    @CallSuper
    public void j() {
        this.w = C.f9084b;
        this.x = null;
    }

    public int l(long j2, List<? extends MediaChunk> list) {
        int i2;
        int i3;
        long b2 = this.s.b();
        if (!L(b2, list)) {
            return list.size();
        }
        this.w = b2;
        this.x = list.isEmpty() ? null : (MediaChunk) Iterables.w(list);
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long G0 = Util.G0(((MediaChunk) list.get(size - 1)).f12284g - j2, this.t);
        long F2 = F();
        if (G0 < F2) {
            return size;
        }
        Format i4 = i(B(b2, E(list)));
        for (int i5 = 0; i5 < size; i5++) {
            MediaChunk mediaChunk = (MediaChunk) list.get(i5);
            Format format = mediaChunk.f12281d;
            if (Util.G0(mediaChunk.f12284g - j2, this.t) >= F2 && format.b3 < i4.b3 && (i2 = format.l3) != -1 && i2 <= this.o && (i3 = format.k3) != -1 && i3 <= this.f12352n && i2 < i4.l3) {
                return i5;
            }
        }
        return size;
    }

    public void m(long j2, long j3, long j4, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
        long b2 = this.s.b();
        long G2 = G(mediaChunkIteratorArr, list);
        int i2 = this.v;
        if (i2 == 0) {
            this.v = 1;
            this.u = B(b2, G2);
            return;
        }
        int i3 = this.u;
        int c2 = list.isEmpty() ? -1 : c(((MediaChunk) Iterables.w(list)).f12281d);
        if (c2 != -1) {
            i2 = ((MediaChunk) Iterables.w(list)).f12282e;
            i3 = c2;
        }
        int B2 = B(b2, G2);
        if (B2 != i3 && !b(i3, b2)) {
            Format i4 = i(i3);
            Format i5 = i(B2);
            long K = K(j4, G2);
            int i6 = i5.b3;
            int i7 = i4.b3;
            if ((i6 > i7 && j3 < K) || (i6 < i7 && j3 >= this.f12350l)) {
                B2 = i3;
            }
        }
        if (B2 != i3) {
            i2 = 3;
        }
        this.v = i2;
        this.u = B2;
    }

    public int p() {
        return this.v;
    }

    public void r(float f2) {
        this.t = f2;
    }

    @Nullable
    public Object s() {
        return null;
    }

    public AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, BandwidthMeter bandwidthMeter) {
        this(trackGroup, iArr, 0, bandwidthMeter, 10000, 25000, 25000, D, E, 0.7f, 0.75f, ImmutableList.I(), Clock.f9502a);
    }
}
