package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@GwtCompatible
@ElementTypesAreNonnullByDefault
final class CollectPreconditions {
    CollectPreconditions() {
    }

    static void a(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        } else if (obj2 == null) {
            throw new NullPointerException("null value in entry: " + obj + "=null");
        }
    }

    @CanIgnoreReturnValue
    static int b(int i2, String str) {
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i2);
    }

    @CanIgnoreReturnValue
    static long c(long j2, String str) {
        if (j2 >= 0) {
            return j2;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + j2);
    }

    static void d(int i2, String str) {
        if (i2 <= 0) {
            throw new IllegalArgumentException(str + " must be positive but was: " + i2);
        }
    }

    static void e(boolean z) {
        Preconditions.h0(z, "no calls to next() since the last call to remove()");
    }
}
