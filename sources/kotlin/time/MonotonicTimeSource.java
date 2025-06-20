package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.time.TimeSource;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\u0006J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\nø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0015\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\rø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0016\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lkotlin/time/MonotonicTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "<init>", "()V", "", "f", "()J", "", "toString", "()Ljava/lang/String;", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "e", "timeMark", "Lkotlin/time/Duration;", "d", "(J)J", "one", "another", "c", "(JJ)J", "duration", "b", "J", "zero", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@SinceKotlin(version = "1.3")
public final class MonotonicTimeSource implements TimeSource.WithComparableMarks {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final MonotonicTimeSource f29139b = new MonotonicTimeSource();

    /* renamed from: c  reason: collision with root package name */
    private static final long f29140c = System.nanoTime();

    private MonotonicTimeSource() {
    }

    private final long f() {
        return System.nanoTime() - f29140c;
    }

    public final long b(long j2, long j3) {
        return TimeSource.Monotonic.ValueTimeMark.h(LongSaturatedMathKt.d(j2, DurationUnit.NANOSECONDS, j3));
    }

    public final long c(long j2, long j3) {
        return LongSaturatedMathKt.h(j2, j3, DurationUnit.NANOSECONDS);
    }

    public final long d(long j2) {
        return LongSaturatedMathKt.f(f(), j2, DurationUnit.NANOSECONDS);
    }

    public long e() {
        return TimeSource.Monotonic.ValueTimeMark.h(f());
    }

    @NotNull
    public String toString() {
        return "TimeSource(System.nanoTime())";
    }
}
