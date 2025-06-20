package com.google.android.gms.internal.common;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.jspecify.nullness.NullMarked;

@NullMarked
public final class zzah {
    @CanIgnoreReturnValue
    static Object[] zza(Object[] objArr, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            if (objArr[i3] != null) {
                i3++;
            } else {
                throw new NullPointerException("at index " + i3);
            }
        }
        return objArr;
    }
}
