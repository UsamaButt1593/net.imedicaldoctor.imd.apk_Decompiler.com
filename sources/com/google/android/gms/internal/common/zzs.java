package com.google.android.gms.internal.common;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.jspecify.nullness.NullMarked;

@NullMarked
public final class zzs {
    @CanIgnoreReturnValue
    public static int zza(int i2, int i3, String str) {
        String str2;
        if (i2 >= 0 && i2 < i3) {
            return i2;
        }
        if (i2 < 0) {
            str2 = zzy.zza("%s (%s) must not be negative", "index", Integer.valueOf(i2));
        } else if (i3 < 0) {
            throw new IllegalArgumentException("negative size: " + i3);
        } else {
            str2 = zzy.zza("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        throw new IndexOutOfBoundsException(str2);
    }

    @CanIgnoreReturnValue
    public static int zzb(int i2, int i3, String str) {
        if (i2 >= 0 && i2 <= i3) {
            return i2;
        }
        throw new IndexOutOfBoundsException(zzd(i2, i3, "index"));
    }

    public static void zzc(int i2, int i3, int i4) {
        String str;
        if (i2 < 0 || i3 < i2 || i3 > i4) {
            if (i2 < 0 || i2 > i4) {
                str = zzd(i2, i4, "start index");
            } else if (i3 < 0 || i3 > i4) {
                str = zzd(i3, i4, "end index");
            } else {
                str = zzy.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i2));
            }
            throw new IndexOutOfBoundsException(str);
        }
    }

    private static String zzd(int i2, int i3, String str) {
        if (i2 < 0) {
            return zzy.zza("%s (%s) must not be negative", str, Integer.valueOf(i2));
        } else if (i3 >= 0) {
            return zzy.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        } else {
            throw new IllegalArgumentException("negative size: " + i3);
        }
    }
}
