package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
final class Hashing {

    /* renamed from: a  reason: collision with root package name */
    private static final long f22382a = -862048943;

    /* renamed from: b  reason: collision with root package name */
    private static final long f22383b = 461845907;

    /* renamed from: c  reason: collision with root package name */
    private static final int f22384c = 1073741824;

    private Hashing() {
    }

    static int a(int i2, double d2) {
        int max = Math.max(i2, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max <= ((int) (d2 * ((double) highestOneBit)))) {
            return highestOneBit;
        }
        int i3 = highestOneBit << 1;
        if (i3 > 0) {
            return i3;
        }
        return 1073741824;
    }

    static boolean b(int i2, int i3, double d2) {
        return ((double) i2) > d2 * ((double) i3) && i3 < 1073741824;
    }

    static int c(int i2) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i2) * f22382a), 15)) * f22383b);
    }

    static int d(@CheckForNull Object obj) {
        return c(obj == null ? 0 : obj.hashCode());
    }
}
