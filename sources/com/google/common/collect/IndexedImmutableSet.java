package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
abstract class IndexedImmutableSet<E> extends ImmutableSet<E> {
    IndexedImmutableSet() {
    }

    /* access modifiers changed from: package-private */
    public ImmutableList<E> H() {
        return new ImmutableList<E>() {
            public E get(int i2) {
                return IndexedImmutableSet.this.get(i2);
            }

            /* access modifiers changed from: package-private */
            public boolean j() {
                return IndexedImmutableSet.this.j();
            }

            public int size() {
                return IndexedImmutableSet.this.size();
            }
        };
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public int c(Object[] objArr, int i2) {
        return b().c(objArr, i2);
    }

    /* access modifiers changed from: package-private */
    public abstract E get(int i2);

    /* renamed from: k */
    public UnmodifiableIterator<E> iterator() {
        return b().iterator();
    }
}
