package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingMultiset<E> extends ForwardingCollection<E> implements Multiset<E> {

    protected class StandardElementSet extends Multisets.ElementSet<E> {
        public StandardElementSet() {
        }

        /* access modifiers changed from: package-private */
        public Multiset<E> h() {
            return ForwardingMultiset.this;
        }

        public Iterator<E> iterator() {
            return Multisets.h(h().entrySet().iterator());
        }
    }

    protected ForwardingMultiset() {
    }

    /* access modifiers changed from: protected */
    public String B1() {
        return entrySet().toString();
    }

    @CanIgnoreReturnValue
    public boolean D0(@ParametricNullness E e2, int i2, int i3) {
        return a1().D0(e2, i2, i3);
    }

    /* access modifiers changed from: protected */
    /* renamed from: E1 */
    public abstract Multiset<E> a1();

    @CanIgnoreReturnValue
    public int F(@CheckForNull Object obj, int i2) {
        return a1().F(obj, i2);
    }

    /* access modifiers changed from: protected */
    public boolean G1(@ParametricNullness E e2) {
        Q(e2, 1);
        return true;
    }

    /* access modifiers changed from: protected */
    public int I1(@CheckForNull Object obj) {
        for (Multiset.Entry entry : entrySet()) {
            if (Objects.a(entry.a(), obj)) {
                return entry.getCount();
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean J1(@CheckForNull Object obj) {
        return Multisets.i(this, obj);
    }

    /* access modifiers changed from: protected */
    public int K1() {
        return entrySet().hashCode();
    }

    /* access modifiers changed from: protected */
    public Iterator<E> L1() {
        return Multisets.n(this);
    }

    /* access modifiers changed from: protected */
    public int M1(@ParametricNullness E e2, int i2) {
        return Multisets.v(this, e2, i2);
    }

    /* access modifiers changed from: protected */
    public boolean N1(@ParametricNullness E e2, int i2, int i3) {
        return Multisets.w(this, e2, i2, i3);
    }

    /* access modifiers changed from: protected */
    public int P1() {
        return Multisets.o(this);
    }

    @CanIgnoreReturnValue
    public int Q(@ParametricNullness E e2, int i2) {
        return a1().Q(e2, i2);
    }

    public Set<E> e() {
        return a1().e();
    }

    public Set<Multiset.Entry<E>> entrySet() {
        return a1().entrySet();
    }

    public boolean equals(@CheckForNull Object obj) {
        return obj == this || a1().equals(obj);
    }

    /* access modifiers changed from: protected */
    public boolean f1(Collection<? extends E> collection) {
        return Multisets.c(this, collection);
    }

    public int hashCode() {
        return a1().hashCode();
    }

    /* access modifiers changed from: protected */
    public void i1() {
        Iterators.h(entrySet().iterator());
    }

    public int l1(@CheckForNull Object obj) {
        return a1().l1(obj);
    }

    /* access modifiers changed from: protected */
    public boolean m1(@CheckForNull Object obj) {
        return l1(obj) > 0;
    }

    /* access modifiers changed from: protected */
    public boolean p1(@CheckForNull Object obj) {
        return F(obj, 1) > 0;
    }

    /* access modifiers changed from: protected */
    public boolean q1(Collection<?> collection) {
        return Multisets.p(this, collection);
    }

    @CanIgnoreReturnValue
    public int r0(@ParametricNullness E e2, int i2) {
        return a1().r0(e2, i2);
    }

    /* access modifiers changed from: protected */
    public boolean s1(Collection<?> collection) {
        return Multisets.s(this, collection);
    }
}
