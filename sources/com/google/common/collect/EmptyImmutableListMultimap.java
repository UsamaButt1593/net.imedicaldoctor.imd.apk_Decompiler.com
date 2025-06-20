package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
class EmptyImmutableListMultimap extends ImmutableListMultimap<Object, Object> {
    static final EmptyImmutableListMultimap d3 = new EmptyImmutableListMultimap();
    private static final long e3 = 0;

    private EmptyImmutableListMultimap() {
        super(ImmutableMap.s(), 0);
    }

    private Object f0() {
        return d3;
    }

    /* renamed from: m */
    public ImmutableMap<Object, Collection<Object>> g() {
        return super.g();
    }
}
