package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.functions.Function;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class SorterFunction<T> implements Function<List<T>, List<T>> {
    final Comparator<? super T> s;

    public SorterFunction(Comparator<? super T> comparator) {
        this.s = comparator;
    }

    /* renamed from: a */
    public List<T> apply(List<T> list) {
        Collections.sort(list, this.s);
        return list;
    }
}
