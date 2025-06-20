package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingSortedSet<E> extends ForwardingSet<E> implements SortedSet<E> {
    protected ForwardingSortedSet() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: J1 */
    public abstract SortedSet<E> a1();

    /* access modifiers changed from: protected */
    public SortedSet<E> K1(@ParametricNullness E e2, @ParametricNullness E e3) {
        return tailSet(e2).headSet(e3);
    }

    @CheckForNull
    public Comparator<? super E> comparator() {
        return a1().comparator();
    }

    @ParametricNullness
    public E first() {
        return a1().first();
    }

    public SortedSet<E> headSet(@ParametricNullness E e2) {
        return a1().headSet(e2);
    }

    @ParametricNullness
    public E last() {
        return a1().last();
    }

    /* access modifiers changed from: protected */
    public boolean m1(@CheckForNull Object obj) {
        try {
            return ForwardingSortedMap.E1(comparator(), tailSet(obj).first(), obj) == 0;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean p1(@CheckForNull Object obj) {
        try {
            Iterator it2 = tailSet(obj).iterator();
            if (it2.hasNext()) {
                if (ForwardingSortedMap.E1(comparator(), it2.next(), obj) == 0) {
                    it2.remove();
                    return true;
                }
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public SortedSet<E> subSet(@ParametricNullness E e2, @ParametricNullness E e3) {
        return a1().subSet(e2, e3);
    }

    public SortedSet<E> tailSet(@ParametricNullness E e2) {
        return a1().tailSet(e2);
    }
}
