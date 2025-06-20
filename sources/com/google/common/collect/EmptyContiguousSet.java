package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.itextpdf.xmp.XMPConst;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
final class EmptyContiguousSet<C extends Comparable> extends ContiguousSet<C> {

    @GwtIncompatible
    @J2ktIncompatible
    private static final class SerializedForm<C extends Comparable> implements Serializable {
        private static final long X = 0;
        private final DiscreteDomain<C> s;

        private SerializedForm(DiscreteDomain<C> discreteDomain) {
            this.s = discreteDomain;
        }

        private Object a() {
            return new EmptyContiguousSet(this.s);
        }
    }

    EmptyContiguousSet(DiscreteDomain<C> discreteDomain) {
        super(discreteDomain);
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void m(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public boolean I() {
        return true;
    }

    public ImmutableList<C> b() {
        return ImmutableList.I();
    }

    public boolean contains(@CheckForNull Object obj) {
        return false;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj instanceof Set) {
            return ((Set) obj).isEmpty();
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public int indexOf(@CheckForNull Object obj) {
        return -1;
    }

    public boolean isEmpty() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return false;
    }

    /* renamed from: k */
    public UnmodifiableIterator<C> iterator() {
        return Iterators.u();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m1 */
    public ContiguousSet<C> y0(C c2, boolean z) {
        return this;
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    @J2ktIncompatible
    public Object n() {
        return new SerializedForm(this.a3);
    }

    public ContiguousSet<C> n1(ContiguousSet<C> contiguousSet) {
        return this;
    }

    public Range<C> o1() {
        throw new NoSuchElementException();
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public ImmutableSortedSet<C> p0() {
        return ImmutableSortedSet.u0(Ordering.z().E());
    }

    public Range<C> p1(BoundType boundType, BoundType boundType2) {
        throw new NoSuchElementException();
    }

    @GwtIncompatible
    /* renamed from: q0 */
    public UnmodifiableIterator<C> descendingIterator() {
        return Iterators.u();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s1 */
    public ContiguousSet<C> P0(C c2, boolean z, C c3, boolean z2) {
        return this;
    }

    public int size() {
        return 0;
    }

    public String toString() {
        return XMPConst.o2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v1 */
    public ContiguousSet<C> U0(C c2, boolean z) {
        return this;
    }

    /* renamed from: w1 */
    public C first() {
        throw new NoSuchElementException();
    }

    /* renamed from: x1 */
    public C last() {
        throw new NoSuchElementException();
    }
}
