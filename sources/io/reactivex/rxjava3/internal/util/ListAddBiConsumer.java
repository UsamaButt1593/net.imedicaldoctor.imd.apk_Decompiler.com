package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.functions.BiFunction;
import java.util.List;

public enum ListAddBiConsumer implements BiFunction<List, Object, List> {
    INSTANCE;

    public static <T> BiFunction<List<T>, T, List<T>> b() {
        return INSTANCE;
    }

    /* renamed from: a */
    public List apply(List list, Object obj) {
        list.add(obj);
        return list;
    }
}
