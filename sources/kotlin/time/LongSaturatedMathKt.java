package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a*\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\t\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a*\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0007\u001a\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a*\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a*\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0011\u001a*\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0011\u001a\u0014\u0010\u0019\u001a\u00020\u0018*\u00020\u0000H\b¢\u0006\u0004\b\u0019\u0010\u001a\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"", "value", "Lkotlin/time/DurationUnit;", "unit", "Lkotlin/time/Duration;", "duration", "d", "(JLkotlin/time/DurationUnit;J)J", "durationInUnit", "a", "(JJJ)J", "e", "b", "(J)J", "valueNs", "origin", "f", "(JJLkotlin/time/DurationUnit;)J", "origin1", "origin2", "h", "value1", "value2", "g", "", "c", "(J)Z", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nlongSaturatedMath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n1#1,81:1\n80#1:82\n80#1:83\n80#1:84\n80#1:85\n80#1:86\n80#1:87\n*S KotlinDebug\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n14#1:82\n17#1:83\n36#1:84\n46#1:85\n53#1:86\n57#1:87\n*E\n"})
public final class LongSaturatedMathKt {
    private static final long a(long j2, long j3, long j4) {
        if (!Duration.i0(j3) || (j2 ^ j4) >= 0) {
            return j2;
        }
        throw new IllegalArgumentException("Summing infinities of different signs");
    }

    private static final long b(long j2) {
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        Duration.Companion companion = Duration.X;
        return i2 < 0 ? companion.J() : companion.q();
    }

    public static final boolean c(long j2) {
        return ((j2 - 1) | 1) == Long.MAX_VALUE;
    }

    public static final long d(long j2, @NotNull DurationUnit durationUnit, long j3) {
        Intrinsics.p(durationUnit, "unit");
        long G0 = Duration.G0(j3, durationUnit);
        if (((j2 - 1) | 1) == Long.MAX_VALUE) {
            return a(j2, j3, G0);
        }
        if ((1 | (G0 - 1)) == Long.MAX_VALUE) {
            return e(j2, durationUnit, j3);
        }
        long j4 = j2 + G0;
        if (((j2 ^ j4) & (G0 ^ j4)) < 0) {
            return j2 < 0 ? Long.MIN_VALUE : Long.MAX_VALUE;
        }
        return j4;
    }

    private static final long e(long j2, DurationUnit durationUnit, long j3) {
        long m2 = Duration.m(j3, 2);
        long G0 = Duration.G0(m2, durationUnit);
        return (1 | (G0 - 1)) == Long.MAX_VALUE ? G0 : d(d(j2, durationUnit, m2), durationUnit, Duration.m0(j3, m2));
    }

    public static final long f(long j2, long j3, @NotNull DurationUnit durationUnit) {
        Intrinsics.p(durationUnit, "unit");
        return (1 | (j3 - 1)) == Long.MAX_VALUE ? Duration.Q0(b(j3)) : g(j2, j3, durationUnit);
    }

    private static final long g(long j2, long j3, DurationUnit durationUnit) {
        long j4 = j2 - j3;
        if (((j4 ^ j2) & (~(j4 ^ j3))) >= 0) {
            return DurationKt.n0(j4, durationUnit);
        }
        DurationUnit durationUnit2 = DurationUnit.MILLISECONDS;
        if (durationUnit.compareTo(durationUnit2) >= 0) {
            return Duration.Q0(b(j4));
        }
        long b2 = DurationUnitKt__DurationUnitJvmKt.b(1, durationUnit2, durationUnit);
        long j5 = (j2 % b2) - (j3 % b2);
        Duration.Companion companion = Duration.X;
        return Duration.p0(DurationKt.n0((j2 / b2) - (j3 / b2), durationUnit2), DurationKt.n0(j5, durationUnit));
    }

    public static final long h(long j2, long j3, @NotNull DurationUnit durationUnit) {
        Intrinsics.p(durationUnit, "unit");
        return ((j3 - 1) | 1) == Long.MAX_VALUE ? j2 == j3 ? Duration.X.W() : Duration.Q0(b(j3)) : (1 | (j2 - 1)) == Long.MAX_VALUE ? b(j2) : g(j2, j3, durationUnit);
    }
}
