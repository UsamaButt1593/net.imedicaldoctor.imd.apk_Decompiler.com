package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.ArrayList;
import java.util.List;

public enum ArrayListSupplier implements Supplier<List<Object>>, Function<Object, List<Object>> {
    INSTANCE;

    public static <T, O> Function<O, List<T>> b() {
        return INSTANCE;
    }

    public static <T> Supplier<List<T>> c() {
        return INSTANCE;
    }

    /* renamed from: a */
    public List<Object> apply(Object obj) {
        return new ArrayList();
    }

    /* renamed from: e */
    public List<Object> get() {
        return new ArrayList();
    }
}
