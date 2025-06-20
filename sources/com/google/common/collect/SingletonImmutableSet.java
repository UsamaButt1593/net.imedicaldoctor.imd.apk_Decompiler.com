package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
final class SingletonImmutableSet<E> extends ImmutableSet<E> {
    final transient E Y2;

    SingletonImmutableSet(E e2) {
        this.Y2 = Preconditions.E(e2);
    }

    public ImmutableList<E> b() {
        return ImmutableList.K(this.Y2);
    }

    /* access modifiers changed from: package-private */
    public int c(Object[] objArr, int i2) {
        objArr[i2] = this.Y2;
        return i2 + 1;
    }

    public boolean contains(@CheckForNull Object obj) {
        return this.Y2.equals(obj);
    }

    public final int hashCode() {
        return this.Y2.hashCode();
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return false;
    }

    /* renamed from: k */
    public UnmodifiableIterator<E> iterator() {
        return Iterators.Y(this.Y2);
    }

    public int size() {
        return 1;
    }

    public String toString() {
        return '[' + this.Y2.toString() + ']';
    }
}
