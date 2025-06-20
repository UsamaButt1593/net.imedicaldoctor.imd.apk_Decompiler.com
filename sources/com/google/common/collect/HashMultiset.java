package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
public final class HashMultiset<E> extends AbstractMapBasedMultiset<E> {
    @GwtIncompatible
    @J2ktIncompatible
    private static final long Y2 = 0;

    HashMultiset(int i2) {
        super(i2);
    }

    public static <E> HashMultiset<E> o() {
        return q(3);
    }

    public static <E> HashMultiset<E> q(int i2) {
        return new HashMultiset<>(i2);
    }

    public static <E> HashMultiset<E> r(Iterable<? extends E> iterable) {
        HashMultiset<E> q = q(Multisets.l(iterable));
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
        return new ObjectCountHashMap<>(i2);
    }
}
