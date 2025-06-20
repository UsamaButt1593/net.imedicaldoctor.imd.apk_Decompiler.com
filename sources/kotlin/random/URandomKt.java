package kotlin.random;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.WasExperimental;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongRange;
import net.lingala.zip4j.util.InternalZipConstants;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\u0016\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001e\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a&\u0010\b\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001e\u0010\f\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0016\u0010\u000f\u001a\u00020\u000e*\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001e\u0010\u0011\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a&\u0010\u0013\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001e\u0010\u0016\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001e\u0010\u001a\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001e\u0010\u001e\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001cH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a2\u0010\"\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010 \u001a\u00020\u001c2\b\b\u0002\u0010!\u001a\u00020\u001cH\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\"\u0010%\u001a\u00020$2\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\"\u0010'\u001a\u00020$2\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0000ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lkotlin/random/Random;", "Lkotlin/UInt;", "g", "(Lkotlin/random/Random;)I", "until", "j", "(Lkotlin/random/Random;I)I", "from", "i", "(Lkotlin/random/Random;II)I", "Lkotlin/ranges/UIntRange;", "range", "h", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "Lkotlin/ULong;", "k", "(Lkotlin/random/Random;)J", "m", "(Lkotlin/random/Random;J)J", "n", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/ULongRange;", "l", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J", "Lkotlin/UByteArray;", "array", "d", "(Lkotlin/random/Random;[B)[B", "", "size", "c", "(Lkotlin/random/Random;I)[B", "fromIndex", "toIndex", "e", "(Lkotlin/random/Random;[BII)[B", "", "a", "(II)V", "b", "(JJ)V", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nURandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 URandom.kt\nkotlin/random/URandomKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,155:1\n1#2:156\n*E\n"})
public final class URandomKt {
    public static final void a(int i2, int i3) {
        if (Integer.compare(i3 ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE) <= 0) {
            throw new IllegalArgumentException(RandomKt.c(UInt.b(i2), UInt.b(i3)).toString());
        }
    }

    public static final void b(long j2, long j3) {
        if (Long.compare(j3 ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE) <= 0) {
            throw new IllegalArgumentException(RandomKt.c(ULong.b(j2), ULong.b(j3)).toString());
        }
    }

    @ExperimentalUnsignedTypes
    @NotNull
    @SinceKotlin(version = "1.3")
    public static final byte[] c(@NotNull Random random, int i2) {
        Intrinsics.p(random, "<this>");
        return UByteArray.g(random.d(i2));
    }

    @ExperimentalUnsignedTypes
    @NotNull
    @SinceKotlin(version = "1.3")
    public static final byte[] d(@NotNull Random random, @NotNull byte[] bArr) {
        Intrinsics.p(random, "$this$nextUBytes");
        Intrinsics.p(bArr, "array");
        random.e(bArr);
        return bArr;
    }

    @ExperimentalUnsignedTypes
    @NotNull
    @SinceKotlin(version = "1.3")
    public static final byte[] e(@NotNull Random random, @NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.p(random, "$this$nextUBytes");
        Intrinsics.p(bArr, "array");
        random.f(bArr, i2, i3);
        return bArr;
    }

    public static /* synthetic */ byte[] f(Random random, byte[] bArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = UByteArray.r(bArr);
        }
        return e(random, bArr, i2, i3);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int g(@NotNull Random random) {
        Intrinsics.p(random, "<this>");
        return UInt.i(random.l());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int h(@NotNull Random random, @NotNull UIntRange uIntRange) {
        Intrinsics.p(random, "<this>");
        Intrinsics.p(uIntRange, "range");
        if (uIntRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + uIntRange);
        } else if (Integer.compare(uIntRange.k() ^ Integer.MIN_VALUE, -1 ^ Integer.MIN_VALUE) < 0) {
            return i(random, uIntRange.j(), UInt.i(uIntRange.k() + 1));
        } else {
            return Integer.compare(uIntRange.j() ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE) > 0 ? UInt.i(i(random, UInt.i(uIntRange.j() - 1), uIntRange.k()) + 1) : g(random);
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int i(@NotNull Random random, int i2, int i3) {
        Intrinsics.p(random, "$this$nextUInt");
        a(i2, i3);
        return UInt.i(random.n(i2 ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int j(@NotNull Random random, int i2) {
        Intrinsics.p(random, "$this$nextUInt");
        return i(random, 0, i2);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long k(@NotNull Random random) {
        Intrinsics.p(random, "<this>");
        return ULong.i(random.o());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long l(@NotNull Random random, @NotNull ULongRange uLongRange) {
        Intrinsics.p(random, "<this>");
        Intrinsics.p(uLongRange, "range");
        if (!uLongRange.isEmpty()) {
            int a2 = Long.compare(uLongRange.k() ^ Long.MIN_VALUE, -1 ^ Long.MIN_VALUE);
            long j2 = uLongRange.j();
            if (a2 < 0) {
                return n(random, j2, ULong.i(uLongRange.k() + ULong.i(((long) 1) & InternalZipConstants.f30717k)));
            }
            if (Long.compare(j2 ^ Long.MIN_VALUE, 0 ^ Long.MIN_VALUE) <= 0) {
                return k(random);
            }
            long j3 = uLongRange.j();
            long j4 = ((long) 1) & InternalZipConstants.f30717k;
            return ULong.i(n(random, ULong.i(j3 - ULong.i(j4)), uLongRange.k()) + ULong.i(j4));
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + uLongRange);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long m(@NotNull Random random, long j2) {
        Intrinsics.p(random, "$this$nextULong");
        return n(random, 0, j2);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long n(@NotNull Random random, long j2, long j3) {
        Intrinsics.p(random, "$this$nextULong");
        b(j2, j3);
        return ULong.i(random.q(j2 ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }
}
