package kotlin.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.b;
import kotlin.c;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001a*\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0001\u0010\u0004\u001a*\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0006\u001a*\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0004\u001a*\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lkotlin/UInt;", "a", "b", "c", "(III)I", "Lkotlin/ULong;", "(JJJ)J", "start", "end", "", "step", "d", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
public final class UProgressionUtilKt {
    private static final int a(int i2, int i3, int i4) {
        int a2 = b.a(i2, i4);
        int a3 = b.a(i3, i4);
        int a4 = Integer.compare(a2 ^ Integer.MIN_VALUE, a3 ^ Integer.MIN_VALUE);
        int i5 = UInt.i(a2 - a3);
        return a4 >= 0 ? i5 : UInt.i(i5 + i4);
    }

    private static final long b(long j2, long j3, long j4) {
        long a2 = c.a(j2, j4);
        long a3 = c.a(j3, j4);
        int a4 = Long.compare(a2 ^ Long.MIN_VALUE, a3 ^ Long.MIN_VALUE);
        long i2 = ULong.i(a2 - a3);
        return a4 >= 0 ? i2 : ULong.i(i2 + j4);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final long c(long j2, long j3, long j4) {
        long b2;
        int i2 = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
        if (i2 > 0) {
            if (Long.compare(j2 ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE) >= 0) {
                return j3;
            }
            b2 = j3 - b(j3, j2, ULong.i(j4));
        } else if (i2 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        } else if (Long.compare(j2 ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE) <= 0) {
            return j3;
        } else {
            b2 = j3 + b(j2, j3, ULong.i(-j4));
        }
        return ULong.i(b2);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final int d(int i2, int i3, int i4) {
        int a2;
        if (i4 > 0) {
            if (Integer.compare(i2 ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE) >= 0) {
                return i3;
            }
            a2 = i3 - a(i3, i2, UInt.i(i4));
        } else if (i4 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        } else if (Integer.compare(i2 ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE) <= 0) {
            return i3;
        } else {
            a2 = i3 + a(i2, i3, UInt.i(-i4));
        }
        return UInt.i(a2);
    }
}
