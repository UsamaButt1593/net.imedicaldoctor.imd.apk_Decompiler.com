package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingSetMultimap<K, V> extends ForwardingMultimap<K, V> implements SetMultimap<K, V> {
    /* access modifiers changed from: protected */
    /* renamed from: f1 */
    public abstract SetMultimap<K, V> a1();

    @CanIgnoreReturnValue
    public Set<V> b(@CheckForNull Object obj) {
        return a1().b(obj);
    }

    @CanIgnoreReturnValue
    public Set<V> c(@ParametricNullness K k2, Iterable<? extends V> iterable) {
        return a1().c((Object) k2, (Iterable) iterable);
    }

    public Set<V> get(@ParametricNullness K k2) {
        return a1().get((Object) k2);
    }

    public Set<Map.Entry<K, V>> j() {
        return a1().j();
    }
}
