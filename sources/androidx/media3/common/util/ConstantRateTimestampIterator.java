package androidx.media3.common.util;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;

@UnstableApi
public final class ConstantRateTimestampIterator implements TimestampIterator {

    /* renamed from: a  reason: collision with root package name */
    private final long f9517a;

    /* renamed from: b  reason: collision with root package name */
    private final float f9518b;

    /* renamed from: c  reason: collision with root package name */
    private final double f9519c;

    /* renamed from: d  reason: collision with root package name */
    private final long f9520d;

    /* renamed from: e  reason: collision with root package name */
    private double f9521e;

    /* renamed from: f  reason: collision with root package name */
    private int f9522f;

    public ConstantRateTimestampIterator(@IntRange(from = 1) long j2, @FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        this(j2, f2, 0);
    }

    /* renamed from: b */
    public ConstantRateTimestampIterator a() {
        return new ConstantRateTimestampIterator(this.f9517a, this.f9518b, this.f9520d);
    }

    public boolean hasNext() {
        return this.f9522f != 0;
    }

    public long next() {
        Assertions.i(hasNext());
        this.f9522f--;
        long round = Math.round(this.f9521e);
        this.f9521e += this.f9519c;
        return round;
    }

    public ConstantRateTimestampIterator(@IntRange(from = 1) long j2, @FloatRange(from = 0.0d, fromInclusive = false) float f2, @IntRange(from = 0) long j3) {
        boolean z = false;
        Assertions.a(j2 > 0);
        Assertions.a(f2 > 0.0f);
        Assertions.a(j3 >= 0 ? true : z);
        this.f9517a = j2;
        this.f9518b = f2;
        this.f9520d = j3;
        this.f9521e = (double) j3;
        this.f9522f = Math.round((((float) j2) / 1000000.0f) * f2);
        this.f9519c = (double) (1000000.0f / f2);
    }
}
