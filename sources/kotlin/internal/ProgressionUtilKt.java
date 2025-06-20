package kotlin.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\u001a\u001f\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\t\u001a'\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0002\u0010\n\u001a'\u0010\b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\b\u0010\t\u001a'\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"", "a", "b", "e", "(II)I", "", "f", "(JJ)J", "c", "(III)I", "(JJJ)J", "start", "end", "step", "d", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
public final class ProgressionUtilKt {
    private static final int a(int i2, int i3, int i4) {
        return e(e(i2, i4) - e(i3, i4), i4);
    }

    private static final long b(long j2, long j3, long j4) {
        return f(f(j2, j4) - f(j3, j4), j4);
    }

    @PublishedApi
    public static final int c(int i2, int i3, int i4) {
        if (i4 > 0) {
            return i2 >= i3 ? i3 : i3 - a(i3, i2, i4);
        }
        if (i4 < 0) {
            return i2 <= i3 ? i3 : i3 + a(i2, i3, -i4);
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    @PublishedApi
    public static final long d(long j2, long j3, long j4) {
        int i2 = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
        if (i2 > 0) {
            return j2 >= j3 ? j3 : j3 - b(j3, j2, j4);
        }
        if (i2 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        } else if (j2 <= j3) {
            return j3;
        } else {
            return j3 + b(j2, j3, -j4);
        }
    }

    private static final int e(int i2, int i3) {
        int i4 = i2 % i3;
        return i4 >= 0 ? i4 : i4 + i3;
    }

    private static final long f(long j2, long j3) {
        long j4 = j2 % j3;
        return j4 >= 0 ? j4 : j4 + j3;
    }
}
