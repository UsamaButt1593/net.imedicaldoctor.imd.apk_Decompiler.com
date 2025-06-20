package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@KeepForSdk
public final class ArrayUtils {
    private ArrayUtils() {
    }

    @NonNull
    @KeepForSdk
    public static <T> T[] a(@NonNull T[]... tArr) {
        if (tArr.length == 0) {
            return (Object[]) Array.newInstance(tArr.getClass(), 0);
        }
        int i2 = 0;
        for (T[] length : tArr) {
            i2 += length.length;
        }
        T[] copyOf = Arrays.copyOf(tArr[0], i2);
        int length2 = tArr[0].length;
        for (int i3 = 1; i3 < tArr.length; i3++) {
            T[] tArr2 = tArr[i3];
            int length3 = tArr2.length;
            System.arraycopy(tArr2, 0, copyOf, length2, length3);
            length2 += length3;
        }
        return copyOf;
    }

    @NonNull
    @KeepForSdk
    public static byte[] b(@NonNull byte[]... bArr) {
        if (bArr.length == 0) {
            return new byte[0];
        }
        int i2 = 0;
        for (byte[] length : bArr) {
            i2 += length.length;
        }
        byte[] copyOf = Arrays.copyOf(bArr[0], i2);
        int length2 = bArr[0].length;
        for (int i3 = 1; i3 < bArr.length; i3++) {
            byte[] bArr2 = bArr[i3];
            int length3 = bArr2.length;
            System.arraycopy(bArr2, 0, copyOf, length2, length3);
            length2 += length3;
        }
        return copyOf;
    }

    @KeepForSdk
    public static boolean c(@Nullable int[] iArr, int i2) {
        if (iArr != null) {
            for (int i3 : iArr) {
                if (i3 == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    @KeepForSdk
    public static <T> boolean d(@NonNull T[] tArr, @Nullable T t) {
        int length = tArr != null ? tArr.length : 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            } else if (!Objects.b(tArr[i2], t)) {
                i2++;
            } else if (i2 >= 0) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    @KeepForSdk
    public static <T> ArrayList<T> e() {
        return new ArrayList<>();
    }

    @KeepForSdk
    @Nullable
    public static <T> T[] f(@NonNull T[] tArr, @NonNull T... tArr2) {
        int length;
        int i2;
        if (tArr == null) {
            return null;
        }
        if (tArr2 == null || (length = tArr2.length) == 0) {
            return Arrays.copyOf(tArr, tArr.length);
        }
        T[] tArr3 = (Object[]) Array.newInstance(tArr2.getClass().getComponentType(), r3);
        if (length == 1) {
            i2 = 0;
            for (T t : tArr) {
                if (!Objects.b(tArr2[0], t)) {
                    tArr3[i2] = t;
                    i2++;
                }
            }
        } else {
            int i3 = 0;
            for (T t2 : tArr) {
                if (!d(tArr2, t2)) {
                    tArr3[i3] = t2;
                    i3++;
                }
            }
            i2 = i3;
        }
        if (tArr3 == null) {
            return null;
        }
        return i2 == tArr3.length ? tArr3 : Arrays.copyOf(tArr3, i2);
    }

    @NonNull
    @KeepForSdk
    public static <T> ArrayList<T> g(@NonNull T[] tArr) {
        ArrayList<T> arrayList = new ArrayList<>(r0);
        for (T add : tArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    @NonNull
    @KeepForSdk
    public static int[] h(@Nullable Collection<Integer> collection) {
        int i2 = 0;
        if (collection == null || collection.isEmpty()) {
            return new int[0];
        }
        int[] iArr = new int[collection.size()];
        for (Integer intValue : collection) {
            iArr[i2] = intValue.intValue();
            i2++;
        }
        return iArr;
    }

    @KeepForSdk
    @Nullable
    public static Integer[] i(@Nullable int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int length = iArr.length;
        Integer[] numArr = new Integer[length];
        for (int i2 = 0; i2 < length; i2++) {
            numArr[i2] = Integer.valueOf(iArr[i2]);
        }
        return numArr;
    }

    @KeepForSdk
    public static void j(@NonNull StringBuilder sb, @NonNull double[] dArr) {
        int length = dArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(dArr[i2]);
        }
    }

    @KeepForSdk
    public static void k(@NonNull StringBuilder sb, @NonNull float[] fArr) {
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(fArr[i2]);
        }
    }

    @KeepForSdk
    public static void l(@NonNull StringBuilder sb, @NonNull int[] iArr) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(iArr[i2]);
        }
    }

    @KeepForSdk
    public static void m(@NonNull StringBuilder sb, @NonNull long[] jArr) {
        int length = jArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(jArr[i2]);
        }
    }

    @KeepForSdk
    public static <T> void n(@NonNull StringBuilder sb, @NonNull T[] tArr) {
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(tArr[i2]);
        }
    }

    @KeepForSdk
    public static void o(@NonNull StringBuilder sb, @NonNull boolean[] zArr) {
        int length = zArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(zArr[i2]);
        }
    }

    @KeepForSdk
    public static void p(@NonNull StringBuilder sb, @NonNull String[] strArr) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append("\"");
            sb.append(strArr[i2]);
            sb.append("\"");
        }
    }
}
