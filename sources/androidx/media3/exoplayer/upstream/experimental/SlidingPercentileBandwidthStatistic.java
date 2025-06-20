package androidx.media3.exoplayer.upstream.experimental;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.TreeSet;

@UnstableApi
public class SlidingPercentileBandwidthStatistic implements BandwidthStatistic {

    /* renamed from: g  reason: collision with root package name */
    public static final int f12658g = 10;

    /* renamed from: h  reason: collision with root package name */
    public static final double f12659h = 0.5d;

    /* renamed from: a  reason: collision with root package name */
    private final int f12660a;

    /* renamed from: b  reason: collision with root package name */
    private final double f12661b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayDeque<Sample> f12662c;

    /* renamed from: d  reason: collision with root package name */
    private final TreeSet<Sample> f12663d;

    /* renamed from: e  reason: collision with root package name */
    private double f12664e;

    /* renamed from: f  reason: collision with root package name */
    private long f12665f;

    private static class Sample implements Comparable<Sample> {
        /* access modifiers changed from: private */
        public final double X;
        /* access modifiers changed from: private */
        public final long s;

        public Sample(long j2, double d2) {
            this.s = j2;
            this.X = d2;
        }

        /* renamed from: c */
        public int compareTo(Sample sample) {
            return Util.u(this.s, sample.s);
        }
    }

    public SlidingPercentileBandwidthStatistic() {
        this(10, 0.5d);
    }

    private long c() {
        if (this.f12662c.isEmpty()) {
            return Long.MIN_VALUE;
        }
        double d2 = this.f12664e * this.f12661b;
        Iterator<Sample> it2 = this.f12663d.iterator();
        double d3 = 0.0d;
        long j2 = 0;
        double d4 = 0.0d;
        while (it2.hasNext()) {
            Sample next = it2.next();
            double a2 = d3 + (next.X / 2.0d);
            if (a2 >= d2) {
                return j2 == 0 ? next.s : j2 + ((long) ((((double) (next.s - j2)) * (d2 - d4)) / (a2 - d4)));
            }
            j2 = next.s;
            double d5 = a2;
            d3 = (next.X / 2.0d) + a2;
            d4 = d5;
        }
        return j2;
    }

    public void a(long j2, long j3) {
        while (this.f12662c.size() >= this.f12660a) {
            Sample remove = this.f12662c.remove();
            this.f12663d.remove(remove);
            this.f12664e -= remove.X;
        }
        double sqrt = Math.sqrt((double) j2);
        Sample sample = new Sample((j2 * 8000000) / j3, sqrt);
        this.f12662c.add(sample);
        this.f12663d.add(sample);
        this.f12664e += sqrt;
        this.f12665f = c();
    }

    public long b() {
        return this.f12665f;
    }

    public void reset() {
        this.f12662c.clear();
        this.f12663d.clear();
        this.f12664e = 0.0d;
        this.f12665f = Long.MIN_VALUE;
    }

    public SlidingPercentileBandwidthStatistic(int i2, double d2) {
        Assertions.a(d2 >= 0.0d && d2 <= 1.0d);
        this.f12660a = i2;
        this.f12661b = d2;
        this.f12662c = new ArrayDeque<>();
        this.f12663d = new TreeSet<>();
        this.f12665f = Long.MIN_VALUE;
    }
}
