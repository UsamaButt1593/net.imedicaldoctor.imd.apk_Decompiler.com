package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import java.util.Arrays;
import javax.annotation.CheckForNull;
import kotlin.UShort;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
final class CompactHashing {

    /* renamed from: a  reason: collision with root package name */
    static final byte f22364a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static final int f22365b = 5;

    /* renamed from: c  reason: collision with root package name */
    static final int f22366c = 32;

    /* renamed from: d  reason: collision with root package name */
    static final int f22367d = 31;

    /* renamed from: e  reason: collision with root package name */
    static final int f22368e = 1073741823;

    /* renamed from: f  reason: collision with root package name */
    static final int f22369f = 3;

    /* renamed from: g  reason: collision with root package name */
    private static final int f22370g = 4;

    /* renamed from: h  reason: collision with root package name */
    private static final int f22371h = 256;

    /* renamed from: i  reason: collision with root package name */
    private static final int f22372i = 255;

    /* renamed from: j  reason: collision with root package name */
    private static final int f22373j = 65536;

    /* renamed from: k  reason: collision with root package name */
    private static final int f22374k = 65535;

    private CompactHashing() {
    }

    static Object a(int i2) {
        if (i2 < 2 || i2 > 1073741824 || Integer.highestOneBit(i2) != i2) {
            throw new IllegalArgumentException("must be power of 2 between 2^1 and 2^30: " + i2);
        } else if (i2 <= 256) {
            return new byte[i2];
        } else {
            return i2 <= 65536 ? new short[i2] : new int[i2];
        }
    }

    static int b(int i2, int i3) {
        return i2 & (~i3);
    }

    static int c(int i2, int i3) {
        return i2 & i3;
    }

    static int d(int i2, int i3, int i4) {
        return (i2 & (~i4)) | (i3 & i4);
    }

    static int e(int i2) {
        return (i2 < 32 ? 4 : 2) * (i2 + 1);
    }

    static int f(@CheckForNull Object obj, @CheckForNull Object obj2, int i2, Object obj3, int[] iArr, Object[] objArr, @CheckForNull Object[] objArr2) {
        int i3;
        int i4;
        int d2 = Hashing.d(obj);
        int i5 = d2 & i2;
        int h2 = h(obj3, i5);
        if (h2 == 0) {
            return -1;
        }
        int b2 = b(d2, i2);
        int i6 = -1;
        while (true) {
            i3 = h2 - 1;
            i4 = iArr[i3];
            if (b(i4, i2) != b2 || !Objects.a(obj, objArr[i3]) || (objArr2 != null && !Objects.a(obj2, objArr2[i3]))) {
                int c2 = c(i4, i2);
                if (c2 == 0) {
                    return -1;
                }
                int i7 = c2;
                i6 = i3;
                h2 = i7;
            }
        }
        int c3 = c(i4, i2);
        if (i6 == -1) {
            i(obj3, i5, c3);
        } else {
            iArr[i6] = d(iArr[i6], c3, i2);
        }
        return i3;
    }

    static void g(Object obj) {
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
    }

    static int h(Object obj, int i2) {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i2] & 255;
        }
        return obj instanceof short[] ? ((short[]) obj)[i2] & UShort.Z : ((int[]) obj)[i2];
    }

    static void i(Object obj, int i2, int i3) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i2] = (byte) i3;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i2] = (short) i3;
        } else {
            ((int[]) obj)[i2] = i3;
        }
    }

    static int j(int i2) {
        return Math.max(4, Hashing.a(i2 + 1, 1.0d));
    }
}
