package kotlin.random;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001b\u0010\n\u001a\u00020\u0000*\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\u001b\u0010\r\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\t\u001a\u00020\fH\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a\u0017\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001b\u0010\u0013\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001f\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001f\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u001cH\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001f\u0010!\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u001fH\u0000¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"", "seed", "Lkotlin/random/Random;", "a", "(I)Lkotlin/random/Random;", "", "b", "(J)Lkotlin/random/Random;", "Lkotlin/ranges/IntRange;", "range", "h", "(Lkotlin/random/Random;Lkotlin/ranges/IntRange;)I", "Lkotlin/ranges/LongRange;", "i", "(Lkotlin/random/Random;Lkotlin/ranges/LongRange;)J", "value", "g", "(I)I", "bitCount", "j", "(II)I", "from", "until", "", "e", "(II)V", "f", "(JJ)V", "", "d", "(DD)V", "", "", "c", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/String;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nRandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Random.kt\nkotlin/random/RandomKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,383:1\n1#2:384\n*E\n"})
public final class RandomKt {
    @NotNull
    @SinceKotlin(version = "1.3")
    public static final Random a(int i2) {
        return new XorWowRandom(i2, i2 >> 31);
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    public static final Random b(long j2) {
        return new XorWowRandom((int) j2, (int) (j2 >> 32));
    }

    @NotNull
    public static final String c(@NotNull Object obj, @NotNull Object obj2) {
        Intrinsics.p(obj, "from");
        Intrinsics.p(obj2, "until");
        return "Random range is empty: [" + obj + ", " + obj2 + ").";
    }

    public static final void d(double d2, double d3) {
        if (d3 <= d2) {
            throw new IllegalArgumentException(c(Double.valueOf(d2), Double.valueOf(d3)).toString());
        }
    }

    public static final void e(int i2, int i3) {
        if (i3 <= i2) {
            throw new IllegalArgumentException(c(Integer.valueOf(i2), Integer.valueOf(i3)).toString());
        }
    }

    public static final void f(long j2, long j3) {
        if (j3 <= j2) {
            throw new IllegalArgumentException(c(Long.valueOf(j2), Long.valueOf(j3)).toString());
        }
    }

    public static final int g(int i2) {
        return 31 - Integer.numberOfLeadingZeros(i2);
    }

    @SinceKotlin(version = "1.3")
    public static final int h(@NotNull Random random, @NotNull IntRange intRange) {
        Intrinsics.p(random, "<this>");
        Intrinsics.p(intRange, "range");
        if (intRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + intRange);
        } else if (intRange.k() < Integer.MAX_VALUE) {
            return random.n(intRange.j(), intRange.k() + 1);
        } else {
            return intRange.j() > Integer.MIN_VALUE ? random.n(intRange.j() - 1, intRange.k()) + 1 : random.l();
        }
    }

    @SinceKotlin(version = "1.3")
    public static final long i(@NotNull Random random, @NotNull LongRange longRange) {
        Intrinsics.p(random, "<this>");
        Intrinsics.p(longRange, "range");
        if (!longRange.isEmpty()) {
            int i2 = (longRange.k() > Long.MAX_VALUE ? 1 : (longRange.k() == Long.MAX_VALUE ? 0 : -1));
            long j2 = longRange.j();
            if (i2 < 0) {
                return random.q(j2, longRange.k() + 1);
            }
            return j2 > Long.MIN_VALUE ? random.q(longRange.j() - 1, longRange.k()) + 1 : random.o();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + longRange);
    }

    public static final int j(int i2, int i3) {
        return (i2 >>> (32 - i3)) & ((-i3) >> 31);
    }
}
