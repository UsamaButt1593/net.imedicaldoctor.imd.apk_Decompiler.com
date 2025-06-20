package kotlin;

import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import net.lingala.zip4j.util.InternalZipConstants;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\u001f\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\bH\u0001ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0004\u001a\"\u0010\n\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\bH\u0001ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0004\u001a\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000bH\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\"\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000bH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\r\u001a\u001a\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001a\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0017\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0017\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001f\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"", "v1", "v2", "c", "(II)I", "", "g", "(JJ)I", "Lkotlin/UInt;", "d", "e", "Lkotlin/ULong;", "h", "(JJ)J", "i", "", "v", "a", "(D)I", "b", "(D)J", "f", "(I)D", "j", "(J)D", "", "k", "(J)Ljava/lang/String;", "base", "l", "(JI)Ljava/lang/String;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@JvmName(name = "UnsignedKt")
public final class UnsignedKt {
    @PublishedApi
    public static final int a(double d2) {
        if (Double.isNaN(d2) || d2 <= f(0)) {
            return 0;
        }
        if (d2 >= f(-1)) {
            return -1;
        }
        return UInt.i(d2 <= 2.147483647E9d ? (int) d2 : UInt.i((int) (d2 - ((double) Integer.MAX_VALUE))) + UInt.i(Integer.MAX_VALUE));
    }

    @PublishedApi
    public static final long b(double d2) {
        if (Double.isNaN(d2) || d2 <= j(0)) {
            return 0;
        }
        if (d2 >= j(-1)) {
            return -1;
        }
        return ULong.i(d2 < 9.223372036854776E18d ? (long) d2 : ULong.i((long) (d2 - 9.223372036854776E18d)) - Long.MIN_VALUE);
    }

    @PublishedApi
    public static final int c(int i2, int i3) {
        return Intrinsics.t(i2 ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE);
    }

    @PublishedApi
    public static final int d(int i2, int i3) {
        return UInt.i((int) ((((long) i2) & InternalZipConstants.f30717k) / (((long) i3) & InternalZipConstants.f30717k)));
    }

    @PublishedApi
    public static final int e(int i2, int i3) {
        return UInt.i((int) ((((long) i2) & InternalZipConstants.f30717k) % (((long) i3) & InternalZipConstants.f30717k)));
    }

    @PublishedApi
    public static final double f(int i2) {
        return ((double) (Integer.MAX_VALUE & i2)) + (((double) ((i2 >>> 31) << 30)) * ((double) 2));
    }

    @PublishedApi
    public static final int g(long j2, long j3) {
        return Intrinsics.u(j2 ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE);
    }

    @PublishedApi
    public static final long h(long j2, long j3) {
        if (j3 < 0) {
            return Long.compare(j2 ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE) < 0 ? ULong.i(0) : ULong.i(1);
        }
        if (j2 >= 0) {
            return ULong.i(j2 / j3);
        }
        int i2 = 1;
        long j4 = ((j2 >>> 1) / j3) << 1;
        if (Long.compare(ULong.i(j2 - (j4 * j3)) ^ Long.MIN_VALUE, ULong.i(j3) ^ Long.MIN_VALUE) < 0) {
            i2 = 0;
        }
        return ULong.i(j4 + ((long) i2));
    }

    @PublishedApi
    public static final long i(long j2, long j3) {
        long j4;
        if (j3 < 0) {
            return Long.compare(j2 ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE) < 0 ? j2 : ULong.i(j2 - j3);
        }
        if (j2 >= 0) {
            j4 = j2 % j3;
        } else {
            long j5 = j2 - ((((j2 >>> 1) / j3) << 1) * j3);
            if (Long.compare(ULong.i(j5) ^ Long.MIN_VALUE, ULong.i(j3) ^ Long.MIN_VALUE) < 0) {
                j3 = 0;
            }
            j4 = j5 - j3;
        }
        return ULong.i(j4);
    }

    @PublishedApi
    public static final double j(long j2) {
        return (((double) (j2 >>> 11)) * ((double) 2048)) + ((double) (j2 & 2047));
    }

    @NotNull
    public static final String k(long j2) {
        return l(j2, 10);
    }

    @NotNull
    public static final String l(long j2, int i2) {
        if (j2 >= 0) {
            String l2 = Long.toString(j2, CharsKt.a(i2));
            Intrinsics.o(l2, "toString(this, checkRadix(radix))");
            return l2;
        }
        long j3 = (long) i2;
        long j4 = ((j2 >>> 1) / j3) << 1;
        long j5 = j2 - (j4 * j3);
        if (j5 >= j3) {
            j5 -= j3;
            j4++;
        }
        StringBuilder sb = new StringBuilder();
        String l3 = Long.toString(j4, CharsKt.a(i2));
        Intrinsics.o(l3, "toString(this, checkRadix(radix))");
        sb.append(l3);
        String l4 = Long.toString(j5, CharsKt.a(i2));
        Intrinsics.o(l4, "toString(this, checkRadix(radix))");
        sb.append(l4);
        return sb.toString();
    }
}
