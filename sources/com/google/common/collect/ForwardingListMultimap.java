package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.List;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingListMultimap<K, V> extends ForwardingMultimap<K, V> implements ListMultimap<K, V> {
    protected ForwardingListMultimap() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: f1 */
    public abstract ListMultimap<K, V> a1();

    @CanIgnoreReturnValue
    public List<V> b(@CheckForNull Object obj) {
        return a1().b(obj);
    }

    @CanIgnoreReturnValue
    public List<V> c(@ParametricNullness K k2, Iterable<? extends V> iterable) {
        return a1().c((Object) k2, (Iterable) iterable);
    }

    public List<V> get(@ParametricNullness K k2) {
        return a1().get((Object) k2);
    }
}
