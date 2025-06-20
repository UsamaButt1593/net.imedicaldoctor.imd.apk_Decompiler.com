package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
class RegularImmutableAsList<E> extends ImmutableAsList<E> {
    private final ImmutableCollection<E> Y;
    private final ImmutableList<? extends E> Z;

    RegularImmutableAsList(ImmutableCollection<E> immutableCollection, ImmutableList<? extends E> immutableList) {
        this.Y = immutableCollection;
        this.Z = immutableList;
    }

    /* renamed from: H */
    public UnmodifiableListIterator<E> listIterator(int i2) {
        return this.Z.listIterator(i2);
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public int c(Object[] objArr, int i2) {
        return this.Z.c(objArr, i2);
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public Object[] d() {
        return this.Z.d();
    }

    /* access modifiers changed from: package-private */
    public ImmutableCollection<E> e0() {
        return this.Y;
    }

    /* access modifiers changed from: package-private */
    public ImmutableList<? extends E> f0() {
        return this.Z;
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.Z.g();
    }

    public E get(int i2) {
        return this.Z.get(i2);
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.Z.h();
    }

    RegularImmutableAsList(ImmutableCollection<E> immutableCollection, Object[] objArr) {
        this(immutableCollection, ImmutableList.o(objArr));
    }

    RegularImmutableAsList(ImmutableCollection<E> immutableCollection, Object[] objArr, int i2) {
        this(immutableCollection, ImmutableList.q(objArr, i2));
    }
}
