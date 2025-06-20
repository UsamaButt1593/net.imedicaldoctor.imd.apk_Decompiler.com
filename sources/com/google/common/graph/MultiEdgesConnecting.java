package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class MultiEdgesConnecting<E> extends AbstractSet<E> {
    /* access modifiers changed from: private */
    public final Object X;
    private final Map<E, ?> s;

    MultiEdgesConnecting(Map<E, ?> map, Object obj) {
        this.s = (Map) Preconditions.E(map);
        this.X = Preconditions.E(obj);
    }

    /* renamed from: c */
    public UnmodifiableIterator<E> iterator() {
        final Iterator<Map.Entry<E, ?>> it2 = this.s.entrySet().iterator();
        return new AbstractIterator<E>() {
            /* access modifiers changed from: protected */
            @CheckForNull
            public E a() {
                while (it2.hasNext()) {
                    Map.Entry entry = (Map.Entry) it2.next();
                    if (MultiEdgesConnecting.this.X.equals(entry.getValue())) {
                        return entry.getKey();
                    }
                }
                return b();
            }
        };
    }

    public boolean contains(@CheckForNull Object obj) {
        return this.X.equals(this.s.get(obj));
    }
}
