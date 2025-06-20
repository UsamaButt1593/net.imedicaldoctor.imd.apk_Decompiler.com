package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
class ImmutableEntry<K, V> extends AbstractMapEntry<K, V> implements Serializable {
    private static final long Y = 0;
    @ParametricNullness
    final V X;
    @ParametricNullness
    final K s;

    ImmutableEntry(@ParametricNullness K k2, @ParametricNullness V v) {
        this.s = k2;
        this.X = v;
    }

    @ParametricNullness
    public final K getKey() {
        return this.s;
    }

    @ParametricNullness
    public final V getValue() {
        return this.X;
    }

    @ParametricNullness
    public final V setValue(@ParametricNullness V v) {
        throw new UnsupportedOperationException();
    }
}
