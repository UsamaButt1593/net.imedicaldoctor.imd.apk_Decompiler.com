package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingSortedSetMultimap<K, V> extends ForwardingSetMultimap<K, V> implements SortedSetMultimap<K, V> {
    protected ForwardingSortedSetMultimap() {
    }

    @CheckForNull
    public Comparator<? super V> i0() {
        return f1().i0();
    }

    /* access modifiers changed from: protected */
    /* renamed from: i1 */
    public abstract SortedSetMultimap<K, V> f1();

    public SortedSet<V> b(@CheckForNull Object obj) {
        return f1().b(obj);
    }

    public SortedSet<V> c(@ParametricNullness K k2, Iterable<? extends V> iterable) {
        return f1().c((Object) k2, (Iterable) iterable);
    }

    public SortedSet<V> get(@ParametricNullness K k2) {
        return f1().get((Object) k2);
    }
}
