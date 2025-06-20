package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
final class Platform {
    private Platform() {
    }

    static <T> T[] a(Object[] objArr, int i2, int i3, T[] tArr) {
        return Arrays.copyOfRange(objArr, i2, i3, tArr.getClass());
    }

    static <E extends Enum<E>> Class<E> b(E e2) {
        return e2.getDeclaringClass();
    }

    static <T> T[] c(T[] tArr, int i2) {
        if (tArr.length != 0) {
            tArr = Arrays.copyOf(tArr, 0);
        }
        return Arrays.copyOf(tArr, i2);
    }

    static <K, V> Map<K, V> d(int i2) {
        return CompactHashMap.z(i2);
    }

    static <E> Set<E> e(int i2) {
        return CompactHashSet.o(i2);
    }

    static <K, V> Map<K, V> f(int i2) {
        return CompactLinkedHashMap.j0(i2);
    }

    static <E> Set<E> g(int i2) {
        return CompactLinkedHashSet.d0(i2);
    }

    static <E> Set<E> h() {
        return CompactHashSet.j();
    }

    static <K, V> Map<K, V> i() {
        return CompactHashMap.t();
    }

    static int j(int i2) {
        return i2;
    }

    static int k(int i2) {
        return i2;
    }

    @J2ktIncompatible
    static MapMaker l(MapMaker mapMaker) {
        return mapMaker.l();
    }
}
