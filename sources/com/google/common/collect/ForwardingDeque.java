package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Deque;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public abstract class ForwardingDeque<E> extends ForwardingQueue<E> implements Deque<E> {
    protected ForwardingDeque() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: K1 */
    public abstract Deque<E> a1();

    public void addFirst(@ParametricNullness E e2) {
        a1().addFirst(e2);
    }

    public void addLast(@ParametricNullness E e2) {
        a1().addLast(e2);
    }

    public Iterator<E> descendingIterator() {
        return a1().descendingIterator();
    }

    @ParametricNullness
    public E getFirst() {
        return a1().getFirst();
    }

    @ParametricNullness
    public E getLast() {
        return a1().getLast();
    }

    @CanIgnoreReturnValue
    public boolean offerFirst(@ParametricNullness E e2) {
        return a1().offerFirst(e2);
    }

    @CanIgnoreReturnValue
    public boolean offerLast(@ParametricNullness E e2) {
        return a1().offerLast(e2);
    }

    @CheckForNull
    public E peekFirst() {
        return a1().peekFirst();
    }

    @CheckForNull
    public E peekLast() {
        return a1().peekLast();
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public E pollFirst() {
        return a1().pollFirst();
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public E pollLast() {
        return a1().pollLast();
    }

    @ParametricNullness
    @CanIgnoreReturnValue
    public E pop() {
        return a1().pop();
    }

    public void push(@ParametricNullness E e2) {
        a1().push(e2);
    }

    @ParametricNullness
    @CanIgnoreReturnValue
    public E removeFirst() {
        return a1().removeFirst();
    }

    @CanIgnoreReturnValue
    public boolean removeFirstOccurrence(@CheckForNull Object obj) {
        return a1().removeFirstOccurrence(obj);
    }

    @ParametricNullness
    @CanIgnoreReturnValue
    public E removeLast() {
        return a1().removeLast();
    }

    @CanIgnoreReturnValue
    public boolean removeLastOccurrence(@CheckForNull Object obj) {
        return a1().removeLastOccurrence(obj);
    }
}
