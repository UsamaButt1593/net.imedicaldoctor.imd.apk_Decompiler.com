package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Map;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
final class EdgesConnecting<E> extends AbstractSet<E> {
    private final Object X;
    private final Map<?, E> s;

    EdgesConnecting(Map<?, E> map, Object obj) {
        this.s = (Map) Preconditions.E(map);
        this.X = Preconditions.E(obj);
    }

    @CheckForNull
    private E b() {
        return this.s.get(this.X);
    }

    /* renamed from: c */
    public UnmodifiableIterator<E> iterator() {
        Object b2 = b();
        return b2 == null ? ImmutableSet.K().iterator() : Iterators.Y(b2);
    }

    public boolean contains(@CheckForNull Object obj) {
        Object b2 = b();
        return b2 != null && b2.equals(obj);
    }

    public int size() {
        return b() == null ? 0 : 1;
    }
}
