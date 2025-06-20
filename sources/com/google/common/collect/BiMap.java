package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public interface BiMap<K, V> extends Map<K, V> {
    @CanIgnoreReturnValue
    @CheckForNull
    V k0(@ParametricNullness K k2, @ParametricNullness V v);

    @CanIgnoreReturnValue
    @CheckForNull
    V put(@ParametricNullness K k2, @ParametricNullness V v);

    void putAll(Map<? extends K, ? extends V> map);

    BiMap<V, K> q2();

    /* bridge */ /* synthetic */ Collection values();

    Set<V> values();
}
