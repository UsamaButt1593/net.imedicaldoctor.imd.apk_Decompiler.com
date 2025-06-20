package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingSet<E> extends ForwardingCollection<E> implements Set<E> {
    protected ForwardingSet() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: E1 */
    public abstract Set<E> a1();

    /* access modifiers changed from: protected */
    public boolean G1(@CheckForNull Object obj) {
        return Sets.g(this, obj);
    }

    /* access modifiers changed from: protected */
    public int I1() {
        return Sets.k(this);
    }

    public boolean equals(@CheckForNull Object obj) {
        return obj == this || a1().equals(obj);
    }

    public int hashCode() {
        return a1().hashCode();
    }

    /* access modifiers changed from: protected */
    public boolean q1(Collection<?> collection) {
        return Sets.I(this, (Collection) Preconditions.E(collection));
    }
}
