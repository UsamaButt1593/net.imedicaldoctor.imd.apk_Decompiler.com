package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
final class RegularImmutableSortedSet<E> extends ImmutableSortedSet<E> {
    static final RegularImmutableSortedSet<Comparable> b3 = new RegularImmutableSortedSet<>(ImmutableList.I(), Ordering.z());
    @VisibleForTesting
    final transient ImmutableList<E> a3;

    RegularImmutableSortedSet(ImmutableList<E> immutableList, Comparator<? super E> comparator) {
        super(comparator);
        this.a3 = immutableList;
    }

    private int b1(Object obj) throws ClassCastException {
        return Collections.binarySearch(this.a3, obj, f1());
    }

    /* access modifiers changed from: package-private */
    public ImmutableSortedSet<E> P0(E e2, boolean z, E e3, boolean z2) {
        return U0(e2, z).y0(e3, z2);
    }

    /* access modifiers changed from: package-private */
    public ImmutableSortedSet<E> U0(E e2, boolean z) {
        return X0(a1(e2, z), size());
    }

    /* access modifiers changed from: package-private */
    public RegularImmutableSortedSet<E> X0(int i2, int i3) {
        if (i2 == 0 && i3 == size()) {
            return this;
        }
        return i2 < i3 ? new RegularImmutableSortedSet<>(this.a3.subList(i2, i3), this.Y2) : ImmutableSortedSet.u0(this.Y2);
    }

    /* access modifiers changed from: package-private */
    public int Z0(E e2, boolean z) {
        int binarySearch = Collections.binarySearch(this.a3, Preconditions.E(e2), comparator());
        if (binarySearch >= 0) {
            return z ? binarySearch + 1 : binarySearch;
        }
        return ~binarySearch;
    }

    /* access modifiers changed from: package-private */
    public int a1(E e2, boolean z) {
        int binarySearch = Collections.binarySearch(this.a3, Preconditions.E(e2), comparator());
        if (binarySearch >= 0) {
            return z ? binarySearch : binarySearch + 1;
        }
        return ~binarySearch;
    }

    public ImmutableList<E> b() {
        return this.a3;
    }

    /* access modifiers changed from: package-private */
    public int c(Object[] objArr, int i2) {
        return this.a3.c(objArr, i2);
    }

    @CheckForNull
    public E ceiling(E e2) {
        int a1 = a1(e2, true);
        if (a1 == size()) {
            return null;
        }
        return this.a3.get(a1);
    }

    public boolean contains(@CheckForNull Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return b1(obj) >= 0;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).e();
        }
        if (!SortedIterables.b(comparator(), collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        UnmodifiableIterator k2 = iterator();
        Iterator<?> it2 = collection.iterator();
        if (!k2.hasNext()) {
            return false;
        }
        Object next = it2.next();
        Object next2 = k2.next();
        while (true) {
            try {
                int V0 = V0(next2, next);
                if (V0 < 0) {
                    if (!k2.hasNext()) {
                        return false;
                    }
                    next2 = k2.next();
                } else if (V0 == 0) {
                    if (!it2.hasNext()) {
                        return true;
                    }
                    next = it2.next();
                } else if (V0 > 0) {
                    break;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public Object[] d() {
        return this.a3.d();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0034 A[Catch:{ ClassCastException | NoSuchElementException -> 0x0046 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@javax.annotation.CheckForNull java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 1
            if (r6 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r6 instanceof java.util.Set
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            java.util.Set r6 = (java.util.Set) r6
            int r1 = r5.size()
            int r3 = r6.size()
            if (r1 == r3) goto L_0x0017
            return r2
        L_0x0017:
            boolean r1 = r5.isEmpty()
            if (r1 == 0) goto L_0x001e
            return r0
        L_0x001e:
            java.util.Comparator<? super E> r1 = r5.Y2
            boolean r1 = com.google.common.collect.SortedIterables.b(r1, r6)
            if (r1 == 0) goto L_0x0047
            java.util.Iterator r6 = r6.iterator()
            com.google.common.collect.UnmodifiableIterator r1 = r5.iterator()     // Catch:{ ClassCastException | NoSuchElementException -> 0x0046 }
        L_0x002e:
            boolean r3 = r1.hasNext()     // Catch:{ ClassCastException | NoSuchElementException -> 0x0046 }
            if (r3 == 0) goto L_0x0045
            java.lang.Object r3 = r1.next()     // Catch:{ ClassCastException | NoSuchElementException -> 0x0046 }
            java.lang.Object r4 = r6.next()     // Catch:{ ClassCastException | NoSuchElementException -> 0x0046 }
            if (r4 == 0) goto L_0x0044
            int r3 = r5.V0(r3, r4)     // Catch:{ ClassCastException | NoSuchElementException -> 0x0046 }
            if (r3 == 0) goto L_0x002e
        L_0x0044:
            return r2
        L_0x0045:
            return r0
        L_0x0046:
            return r2
        L_0x0047:
            boolean r6 = r5.containsAll(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.RegularImmutableSortedSet.equals(java.lang.Object):boolean");
    }

    /* access modifiers changed from: package-private */
    public Comparator<Object> f1() {
        return this.Y2;
    }

    public E first() {
        if (!isEmpty()) {
            return this.a3.get(0);
        }
        throw new NoSuchElementException();
    }

    @CheckForNull
    public E floor(E e2) {
        int Z0 = Z0(e2, true) - 1;
        if (Z0 == -1) {
            return null;
        }
        return this.a3.get(Z0);
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.a3.g();
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.a3.h();
    }

    @CheckForNull
    public E higher(E e2) {
        int a1 = a1(e2, false);
        if (a1 == size()) {
            return null;
        }
        return this.a3.get(a1);
    }

    /* access modifiers changed from: package-private */
    public int indexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            int binarySearch = Collections.binarySearch(this.a3, obj, f1());
            if (binarySearch >= 0) {
                return binarySearch;
            }
            return -1;
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return this.a3.j();
    }

    /* renamed from: k */
    public UnmodifiableIterator<E> iterator() {
        return this.a3.iterator();
    }

    public E last() {
        if (!isEmpty()) {
            return this.a3.get(size() - 1);
        }
        throw new NoSuchElementException();
    }

    @CheckForNull
    public E lower(E e2) {
        int Z0 = Z0(e2, false) - 1;
        if (Z0 == -1) {
            return null;
        }
        return this.a3.get(Z0);
    }

    /* access modifiers changed from: package-private */
    public ImmutableSortedSet<E> p0() {
        Comparator<? super E> reverseOrder = Collections.reverseOrder(this.Y2);
        return isEmpty() ? ImmutableSortedSet.u0(reverseOrder) : new RegularImmutableSortedSet(this.a3.Y(), reverseOrder);
    }

    @GwtIncompatible
    /* renamed from: q0 */
    public UnmodifiableIterator<E> descendingIterator() {
        return this.a3.Y().iterator();
    }

    public int size() {
        return this.a3.size();
    }

    /* access modifiers changed from: package-private */
    public ImmutableSortedSet<E> y0(E e2, boolean z) {
        return X0(0, Z0(e2, z));
    }
}
