package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {
    static final RegularImmutableMultiset<Object> Z2 = new RegularImmutableMultiset<>(ObjectCountHashMap.c());
    private final transient int X2;
    @CheckForNull
    @LazyInit
    private transient ImmutableSet<E> Y2;
    final transient ObjectCountHashMap<E> Z;

    private final class ElementSet extends IndexedImmutableSet<E> {
        private ElementSet() {
        }

        public boolean contains(@CheckForNull Object obj) {
            return RegularImmutableMultiset.this.contains(obj);
        }

        /* access modifiers changed from: package-private */
        public E get(int i2) {
            return RegularImmutableMultiset.this.Z.j(i2);
        }

        /* access modifiers changed from: package-private */
        public boolean j() {
            return true;
        }

        public int size() {
            return RegularImmutableMultiset.this.Z.D();
        }
    }

    @GwtIncompatible
    private static class SerializedForm implements Serializable {
        private static final long Y = 0;
        final int[] X;
        final Object[] s;

        SerializedForm(Multiset<? extends Object> multiset) {
            int size = multiset.entrySet().size();
            this.s = new Object[size];
            this.X = new int[size];
            int i2 = 0;
            for (Multiset.Entry next : multiset.entrySet()) {
                this.s[i2] = next.a();
                this.X[i2] = next.getCount();
                i2++;
            }
        }

        /* access modifiers changed from: package-private */
        public Object a() {
            ImmutableMultiset.Builder builder = new ImmutableMultiset.Builder(this.s.length);
            int i2 = 0;
            while (true) {
                Object[] objArr = this.s;
                if (i2 >= objArr.length) {
                    return builder.e();
                }
                builder.k(objArr[i2], this.X[i2]);
                i2++;
            }
        }
    }

    RegularImmutableMultiset(ObjectCountHashMap<E> objectCountHashMap) {
        this.Z = objectCountHashMap;
        long j2 = 0;
        for (int i2 = 0; i2 < objectCountHashMap.D(); i2++) {
            j2 += (long) objectCountHashMap.l(i2);
        }
        this.X2 = Ints.z(j2);
    }

    /* renamed from: C */
    public ImmutableSet<E> e() {
        ImmutableSet<E> immutableSet = this.Y2;
        if (immutableSet != null) {
            return immutableSet;
        }
        ElementSet elementSet = new ElementSet();
        this.Y2 = elementSet;
        return elementSet;
    }

    /* access modifiers changed from: package-private */
    public Multiset.Entry<E> E(int i2) {
        return this.Z.h(i2);
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return false;
    }

    public int l1(@CheckForNull Object obj) {
        return this.Z.g(obj);
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public Object n() {
        return new SerializedForm(this);
    }

    public int size() {
        return this.X2;
    }
}
