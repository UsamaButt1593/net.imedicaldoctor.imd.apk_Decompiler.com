package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class ObjectArrays {
    private ObjectArrays() {
    }

    @CanIgnoreReturnValue
    static Object a(@CheckForNull Object obj, int i2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i2);
    }

    @CanIgnoreReturnValue
    static Object[] b(Object... objArr) {
        c(objArr, objArr.length);
        return objArr;
    }

    @CanIgnoreReturnValue
    static Object[] c(Object[] objArr, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            a(objArr[i3], i3);
        }
        return objArr;
    }

    public static <T> T[] d(@ParametricNullness T t, T[] tArr) {
        T[] j2 = j(tArr, tArr.length + 1);
        j2[0] = t;
        System.arraycopy(tArr, 0, j2, 1, tArr.length);
        return j2;
    }

    public static <T> T[] e(T[] tArr, @ParametricNullness T t) {
        T[] copyOf = Arrays.copyOf(tArr, tArr.length + 1);
        copyOf[tArr.length] = t;
        return copyOf;
    }

    @GwtIncompatible
    public static <T> T[] f(T[] tArr, T[] tArr2, Class<T> cls) {
        T[] i2 = i(cls, tArr.length + tArr2.length);
        System.arraycopy(tArr, 0, i2, 0, tArr.length);
        System.arraycopy(tArr2, 0, i2, tArr.length, tArr2.length);
        return i2;
    }

    static Object[] g(Object[] objArr, int i2, int i3) {
        Preconditions.f0(i2, i2 + i3, objArr.length);
        if (i3 == 0) {
            return new Object[0];
        }
        Object[] objArr2 = new Object[i3];
        System.arraycopy(objArr, i2, objArr2, 0, i3);
        return objArr2;
    }

    @CanIgnoreReturnValue
    private static Object[] h(Iterable<?> iterable, Object[] objArr) {
        int i2 = 0;
        for (Object obj : iterable) {
            objArr[i2] = obj;
            i2++;
        }
        return objArr;
    }

    @GwtIncompatible
    public static <T> T[] i(Class<T> cls, int i2) {
        return (Object[]) Array.newInstance(cls, i2);
    }

    public static <T> T[] j(T[] tArr, int i2) {
        return Platform.c(tArr, i2);
    }

    static void k(Object[] objArr, int i2, int i3) {
        Object obj = objArr[i2];
        objArr[i2] = objArr[i3];
        objArr[i3] = obj;
    }

    static Object[] l(Collection<?> collection) {
        return h(collection, new Object[collection.size()]);
    }

    static <T> T[] m(Collection<?> collection, T[] tArr) {
        int size = collection.size();
        if (tArr.length < size) {
            tArr = j(tArr, size);
        }
        h(collection, tArr);
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }

    static <T> T[] n(Object[] objArr, int i2, int i3, T[] tArr) {
        Preconditions.f0(i2, i2 + i3, objArr.length);
        if (tArr.length < i3) {
            tArr = j(tArr, i3);
        } else if (tArr.length > i3) {
            tArr[i3] = null;
        }
        System.arraycopy(objArr, i2, tArr, 0, i3);
        return tArr;
    }
}
