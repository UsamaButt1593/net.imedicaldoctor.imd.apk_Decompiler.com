package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.NoSuchElementException;
import java.util.Queue;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingQueue<E> extends ForwardingCollection<E> implements Queue<E> {
    protected ForwardingQueue() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: E1 */
    public abstract Queue<E> a1();

    /* access modifiers changed from: protected */
    public boolean G1(@ParametricNullness E e2) {
        try {
            return add(e2);
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public E I1() {
        try {
            return element();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public E J1() {
        try {
            return remove();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    @ParametricNullness
    public E element() {
        return a1().element();
    }

    @CanIgnoreReturnValue
    public boolean offer(@ParametricNullness E e2) {
        return a1().offer(e2);
    }

    @CheckForNull
    public E peek() {
        return a1().peek();
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public E poll() {
        return a1().poll();
    }

    @ParametricNullness
    @CanIgnoreReturnValue
    public E remove() {
        return a1().remove();
    }
}
