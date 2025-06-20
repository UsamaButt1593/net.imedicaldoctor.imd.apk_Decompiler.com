package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.functions.Supplier;
import java.util.HashMap;
import java.util.Map;

public enum HashMapSupplier implements Supplier<Map<Object, Object>> {
    INSTANCE;

    public static <K, V> Supplier<Map<K, V>> a() {
        return INSTANCE;
    }

    /* renamed from: b */
    public Map<Object, Object> get() {
        return new HashMap();
    }
}
