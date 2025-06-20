package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Multiset;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
final class DescendingImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {
    private final transient ImmutableSortedMultiset<E> X2;

    DescendingImmutableSortedMultiset(ImmutableSortedMultiset<E> immutableSortedMultiset) {
        this.X2 = immutableSortedMultiset;
    }

    /* renamed from: B0 */
    public ImmutableSortedMultiset<E> D1(E e2, BoundType boundType) {
        return this.X2.e1(e2, boundType).c0();
    }

    /* access modifiers changed from: package-private */
    public Multiset.Entry<E> E(int i2) {
        return this.X2.entrySet().b().Y().get(i2);
    }

    @CheckForNull
    public Multiset.Entry<E> firstEntry() {
        return this.X2.lastEntry();
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return this.X2.j();
    }

    /* renamed from: j0 */
    public ImmutableSortedMultiset<E> c0() {
        return this.X2;
    }

    /* renamed from: k0 */
    public ImmutableSortedSet<E> e() {
        return this.X2.e().descendingSet();
    }

    public int l1(@CheckForNull Object obj) {
        return this.X2.l1(obj);
    }

    @CheckForNull
    public Multiset.Entry<E> lastEntry() {
        return this.X2.firstEntry();
    }

    /* renamed from: m0 */
    public ImmutableSortedMultiset<E> e1(E e2, BoundType boundType) {
        return this.X2.D1(e2, boundType).c0();
    }

    public int size() {
        return this.X2.size();
    }
}
