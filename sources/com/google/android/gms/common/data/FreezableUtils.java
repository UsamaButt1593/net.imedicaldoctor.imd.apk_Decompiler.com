package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import java.util.ArrayList;

public final class FreezableUtils {
    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> a(@NonNull ArrayList<E> arrayList) {
        ArrayList<T> arrayList2 = new ArrayList<>(arrayList.size());
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList2.add(((Freezable) arrayList.get(i2)).b());
        }
        return arrayList2;
    }

    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> b(@NonNull E[] eArr) {
        ArrayList<T> arrayList = new ArrayList<>(eArr.length);
        for (E b2 : eArr) {
            arrayList.add(b2.b());
        }
        return arrayList;
    }

    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> c(@NonNull Iterable<E> iterable) {
        ArrayList<T> arrayList = new ArrayList<>();
        for (E b2 : iterable) {
            arrayList.add(b2.b());
        }
        return arrayList;
    }
}
