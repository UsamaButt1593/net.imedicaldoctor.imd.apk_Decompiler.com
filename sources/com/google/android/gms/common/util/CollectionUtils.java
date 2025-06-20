package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.InlineMe;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@KeepForSdk
public final class CollectionUtils {
    private CollectionUtils() {
    }

    @KeepForSdk
    public static boolean a(@Nullable Collection<?> collection) {
        if (collection == null) {
            return true;
        }
        return collection.isEmpty();
    }

    @InlineMe(imports = {"java.util.Collections"}, replacement = "Collections.emptyList()")
    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> List<T> b() {
        return Collections.emptyList();
    }

    @InlineMe(imports = {"java.util.Collections"}, replacement = "Collections.singletonList(item)")
    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> List<T> c(@NonNull T t) {
        return Collections.singletonList(t);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> List<T> d(@NonNull T... tArr) {
        int length = tArr.length;
        if (length != 0) {
            return length != 1 ? Collections.unmodifiableList(Arrays.asList(tArr)) : Collections.singletonList(tArr[0]);
        }
        return Collections.emptyList();
    }

    @NonNull
    @KeepForSdk
    public static <K, V> Map<K, V> e(@NonNull K k2, @NonNull V v, @NonNull K k3, @NonNull V v2, @NonNull K k4, @NonNull V v3) {
        Map k5 = k(3, false);
        k5.put(k2, v);
        k5.put(k3, v2);
        k5.put(k4, v3);
        return Collections.unmodifiableMap(k5);
    }

    @NonNull
    @KeepForSdk
    public static <K, V> Map<K, V> f(@NonNull K k2, @NonNull V v, @NonNull K k3, @NonNull V v2, @NonNull K k4, @NonNull V v3, @NonNull K k5, @NonNull V v4, @NonNull K k6, @NonNull V v5, @NonNull K k7, @NonNull V v6) {
        Map k8 = k(6, false);
        k8.put(k2, v);
        k8.put(k3, v2);
        k8.put(k4, v3);
        k8.put(k5, v4);
        k8.put(k6, v5);
        k8.put(k7, v6);
        return Collections.unmodifiableMap(k8);
    }

    @NonNull
    @KeepForSdk
    public static <K, V> Map<K, V> g(@NonNull K[] kArr, @NonNull V[] vArr) {
        int length = kArr.length;
        int length2 = vArr.length;
        if (length != length2) {
            throw new IllegalArgumentException("Key and values array lengths not equal: " + length + " != " + length2);
        } else if (length == 0) {
            return Collections.emptyMap();
        } else {
            if (length == 1) {
                return Collections.singletonMap(kArr[0], vArr[0]);
            }
            Map k2 = k(length, false);
            for (int i2 = 0; i2 < kArr.length; i2++) {
                k2.put(kArr[i2], vArr[i2]);
            }
            return Collections.unmodifiableMap(k2);
        }
    }

    @NonNull
    @KeepForSdk
    public static <T> Set<T> h(int i2) {
        return i2 == 0 ? new ArraySet() : l(i2, true);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> Set<T> i(@NonNull T t, @NonNull T t2, @NonNull T t3) {
        Set l2 = l(3, false);
        l2.add(t);
        l2.add(t2);
        l2.add(t3);
        return Collections.unmodifiableSet(l2);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> Set<T> j(@NonNull T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.emptySet();
        }
        if (length == 1) {
            return Collections.singleton(tArr[0]);
        }
        if (length == 2) {
            T t = tArr[0];
            T t2 = tArr[1];
            Set l2 = l(2, false);
            l2.add(t);
            l2.add(t2);
            return Collections.unmodifiableSet(l2);
        } else if (length == 3) {
            return i(tArr[0], tArr[1], tArr[2]);
        } else {
            if (length != 4) {
                Set l3 = l(length, false);
                Collections.addAll(l3, tArr);
                return Collections.unmodifiableSet(l3);
            }
            T t3 = tArr[0];
            T t4 = tArr[1];
            T t5 = tArr[2];
            T t6 = tArr[3];
            Set l4 = l(4, false);
            l4.add(t3);
            l4.add(t4);
            l4.add(t5);
            l4.add(t6);
            return Collections.unmodifiableSet(l4);
        }
    }

    private static Map k(int i2, boolean z) {
        return i2 <= 256 ? new ArrayMap(i2) : new HashMap(i2, 1.0f);
    }

    private static Set l(int i2, boolean z) {
        if (i2 <= (true != z ? 256 : 128)) {
            return new ArraySet(i2);
        }
        return new HashSet(i2, true != z ? 1.0f : 0.75f);
    }
}
