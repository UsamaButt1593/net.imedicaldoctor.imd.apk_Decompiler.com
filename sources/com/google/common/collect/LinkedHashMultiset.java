package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
public final class LinkedHashMultiset<E> extends AbstractMapBasedMultiset<E> {
    LinkedHashMultiset(int i2) {
        super(i2);
    }

    public static <E> LinkedHashMultiset<E> o() {
        return q(3);
    }

    public static <E> LinkedHashMultiset<E> q(int i2) {
        return new LinkedHashMultiset<>(i2);
    }

    public static <E> LinkedHashMultiset<E> r(Iterable<? extends E> iterable) {
        LinkedHashMultiset<E> q = q(Multisets.l(iterable));
        Iterables.a(q, iterable);
        return q;
    }

    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object obj) {
        return super.contains(obj);
    }

    public /* bridge */ /* synthetic */ Set e() {
        return super.e();
    }

    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public ObjectCountHashMap<E> k(int i2) {
        return new ObjectCountLinkedHashMap(i2);
    }
}
