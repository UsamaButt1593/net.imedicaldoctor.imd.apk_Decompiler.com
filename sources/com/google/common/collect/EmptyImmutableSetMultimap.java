package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Comparator;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
class EmptyImmutableSetMultimap extends ImmutableSetMultimap<Object, Object> {
    static final EmptyImmutableSetMultimap f3 = new EmptyImmutableSetMultimap();
    private static final long g3 = 0;

    private EmptyImmutableSetMultimap() {
        super(ImmutableMap.s(), 0, (Comparator) null);
    }

    private Object m0() {
        return f3;
    }

    /* renamed from: m */
    public ImmutableMap<Object, Collection<Object>> g() {
        return super.g();
    }
}
