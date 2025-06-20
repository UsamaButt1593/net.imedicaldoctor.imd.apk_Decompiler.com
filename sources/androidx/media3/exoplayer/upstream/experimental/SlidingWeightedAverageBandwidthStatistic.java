package androidx.media3.exoplayer.upstream.experimental;

import androidx.annotation.VisibleForTesting;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.ArrayDeque;
import java.util.Deque;

@UnstableApi
public class SlidingWeightedAverageBandwidthStatistic implements BandwidthStatistic {

    /* renamed from: f  reason: collision with root package name */
    public static final int f12666f = 10;

    /* renamed from: a  reason: collision with root package name */
    private final ArrayDeque<Sample> f12667a;

    /* renamed from: b  reason: collision with root package name */
    private final SampleEvictionFunction f12668b;

    /* renamed from: c  reason: collision with root package name */
    private final Clock f12669c;

    /* renamed from: d  reason: collision with root package name */
    private double f12670d;

    /* renamed from: e  reason: collision with root package name */
    private double f12671e;

    public static class Sample {

        /* renamed from: a  reason: collision with root package name */
        public final long f12672a;

        /* renamed from: b  reason: collision with root package name */
        public final double f12673b;

        /* renamed from: c  reason: collision with root package name */
        public final long f12674c;

        public Sample(long j2, double d2, long j3) {
            this.f12672a = j2;
            this.f12673b = d2;
            this.f12674c = j3;
        }
    }

    public interface SampleEvictionFunction {
        boolean a(Deque<Sample> deque);
    }

    public SlidingWeightedAverageBandwidthStatistic() {
        this(g(10));
    }

    public static SampleEvictionFunction e(long j2) {
        return f(j2, Clock.f9502a);
    }

    @VisibleForTesting
    static SampleEvictionFunction f(long j2, Clock clock) {
        return new b(j2, clock);
    }

    public static SampleEvictionFunction g(long j2) {
        return new c(j2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean h(long j2, Clock clock, Deque deque) {
        return !deque.isEmpty() && ((Sample) Util.o((Sample) deque.peek())).f12674c + j2 < clock.b();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean i(long j2, Deque deque) {
        return ((long) deque.size()) >= j2;
    }

    public void a(long j2, long j3) {
        while (this.f12668b.a(this.f12667a)) {
            Sample remove = this.f12667a.remove();
            double d2 = this.f12670d;
            double d3 = remove.f12673b;
            this.f12670d = d2 - (((double) remove.f12672a) * d3);
            this.f12671e -= d3;
        }
        Sample sample = new Sample((j2 * 8000000) / j3, Math.sqrt((double) j2), this.f12669c.b());
        this.f12667a.add(sample);
        double d4 = this.f12670d;
        double d5 = sample.f12673b;
        this.f12670d = d4 + (((double) sample.f12672a) * d5);
        this.f12671e += d5;
    }

    public long b() {
        if (this.f12667a.isEmpty()) {
            return Long.MIN_VALUE;
        }
        return (long) (this.f12670d / this.f12671e);
    }

    public void reset() {
        this.f12667a.clear();
        this.f12670d = 0.0d;
        this.f12671e = 0.0d;
    }

    public SlidingWeightedAverageBandwidthStatistic(SampleEvictionFunction sampleEvictionFunction) {
        this(sampleEvictionFunction, Clock.f9502a);
    }

    @VisibleForTesting
    SlidingWeightedAverageBandwidthStatistic(SampleEvictionFunction sampleEvictionFunction, Clock clock) {
        this.f12667a = new ArrayDeque<>();
        this.f12668b = sampleEvictionFunction;
        this.f12669c = clock;
    }
}
