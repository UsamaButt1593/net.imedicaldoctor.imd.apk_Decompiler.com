package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CompatibleWith;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public interface Multiset<E> extends Collection<E> {

    public interface Entry<E> {
        @ParametricNullness
        E a();

        boolean equals(@CheckForNull Object obj);

        int getCount();

        int hashCode();

        String toString();
    }

    @CanIgnoreReturnValue
    boolean D0(@ParametricNullness E e2, int i2, int i3);

    @CanIgnoreReturnValue
    int F(@CompatibleWith("E") @CheckForNull Object obj, int i2);

    @CanIgnoreReturnValue
    int Q(@ParametricNullness E e2, int i2);

    @CanIgnoreReturnValue
    boolean add(@ParametricNullness E e2);

    boolean contains(@CheckForNull Object obj);

    boolean containsAll(Collection<?> collection);

    Set<E> e();

    Set<Entry<E>> entrySet();

    boolean equals(@CheckForNull Object obj);

    int hashCode();

    Iterator<E> iterator();

    int l1(@CompatibleWith("E") @CheckForNull Object obj);

    @CanIgnoreReturnValue
    int r0(@ParametricNullness E e2, int i2);

    @CanIgnoreReturnValue
    boolean remove(@CheckForNull Object obj);

    @CanIgnoreReturnValue
    boolean removeAll(Collection<?> collection);

    @CanIgnoreReturnValue
    boolean retainAll(Collection<?> collection);

    int size();

    String toString();
}
