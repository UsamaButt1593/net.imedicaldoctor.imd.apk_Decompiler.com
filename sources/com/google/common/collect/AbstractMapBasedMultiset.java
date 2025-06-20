package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
abstract class AbstractMapBasedMultiset<E> extends AbstractMultiset<E> implements Serializable {
    @GwtIncompatible
    @J2ktIncompatible
    private static final long X2 = 0;
    transient ObjectCountHashMap<E> Y;
    transient long Z;

    abstract class Itr<T> implements Iterator<T> {
        int X = -1;
        int Y;
        int s;

        Itr() {
            this.s = AbstractMapBasedMultiset.this.Y.f();
            this.Y = AbstractMapBasedMultiset.this.Y.f22487d;
        }

        private void a() {
            if (AbstractMapBasedMultiset.this.Y.f22487d != this.Y) {
                throw new ConcurrentModificationException();
            }
        }

        /* access modifiers changed from: package-private */
        @ParametricNullness
        public abstract T b(int i2);

        public boolean hasNext() {
            a();
            return this.s >= 0;
        }

        @ParametricNullness
        public T next() {
            if (hasNext()) {
                T b2 = b(this.s);
                int i2 = this.s;
                this.X = i2;
                this.s = AbstractMapBasedMultiset.this.Y.t(i2);
                return b2;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            a();
            CollectPreconditions.e(this.X != -1);
            AbstractMapBasedMultiset abstractMapBasedMultiset = AbstractMapBasedMultiset.this;
            abstractMapBasedMultiset.Z -= (long) abstractMapBasedMultiset.Y.y(this.X);
            this.s = AbstractMapBasedMultiset.this.Y.u(this.s, this.X);
            this.X = -1;
            this.Y = AbstractMapBasedMultiset.this.Y.f22487d;
        }
    }

    AbstractMapBasedMultiset(int i2) {
        this.Y = k(i2);
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void m(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int h2 = Serialization.h(objectInputStream);
        this.Y = k(3);
        Serialization.g(this, objectInputStream, h2);
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void n(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.k(this, objectOutputStream);
    }

    public final boolean D0(@ParametricNullness E e2, int i2, int i3) {
        long j2;
        CollectPreconditions.b(i2, "oldCount");
        CollectPreconditions.b(i3, "newCount");
        int n2 = this.Y.n(e2);
        if (n2 == -1) {
            if (i2 != 0) {
                return false;
            }
            if (i3 > 0) {
                this.Y.v(e2, i3);
                this.Z += (long) i3;
            }
            return true;
        } else if (this.Y.l(n2) != i2) {
            return false;
        } else {
            ObjectCountHashMap<E> objectCountHashMap = this.Y;
            if (i3 == 0) {
                objectCountHashMap.y(n2);
                j2 = this.Z - ((long) i2);
            } else {
                objectCountHashMap.C(n2, i3);
                j2 = this.Z + ((long) (i3 - i2));
            }
            this.Z = j2;
            return true;
        }
    }

    @CanIgnoreReturnValue
    public final int F(@CheckForNull Object obj, int i2) {
        if (i2 == 0) {
            return l1(obj);
        }
        Preconditions.k(i2 > 0, "occurrences cannot be negative: %s", i2);
        int n2 = this.Y.n(obj);
        if (n2 == -1) {
            return 0;
        }
        int l2 = this.Y.l(n2);
        if (l2 > i2) {
            this.Y.C(n2, l2 - i2);
        } else {
            this.Y.y(n2);
            i2 = l2;
        }
        this.Z -= (long) i2;
        return l2;
    }

    @CanIgnoreReturnValue
    public final int Q(@ParametricNullness E e2, int i2) {
        if (i2 == 0) {
            return l1(e2);
        }
        boolean z = true;
        Preconditions.k(i2 > 0, "occurrences cannot be negative: %s", i2);
        int n2 = this.Y.n(e2);
        if (n2 == -1) {
            this.Y.v(e2, i2);
            this.Z += (long) i2;
            return 0;
        }
        int l2 = this.Y.l(n2);
        long j2 = (long) i2;
        long j3 = ((long) l2) + j2;
        if (j3 > 2147483647L) {
            z = false;
        }
        Preconditions.p(z, "too many occurrences: %s", j3);
        this.Y.C(n2, (int) j3);
        this.Z += j2;
        return l2;
    }

    public final void clear() {
        this.Y.a();
        this.Z = 0;
    }

    /* access modifiers changed from: package-private */
    public final int d() {
        return this.Y.D();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<E> g() {
        return new AbstractMapBasedMultiset<E>.Itr<E>() {
            /* access modifiers changed from: package-private */
            @ParametricNullness
            public E b(int i2) {
                return AbstractMapBasedMultiset.this.Y.j(i2);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Multiset.Entry<E>> h() {
        return new AbstractMapBasedMultiset<E>.Itr<Multiset.Entry<E>>() {
            /* access modifiers changed from: package-private */
            /* renamed from: c */
            public Multiset.Entry<E> b(int i2) {
                return AbstractMapBasedMultiset.this.Y.h(i2);
            }
        };
    }

    public final Iterator<E> iterator() {
        return Multisets.n(this);
    }

    /* access modifiers changed from: package-private */
    public void j(Multiset<? super E> multiset) {
        Preconditions.E(multiset);
        int f2 = this.Y.f();
        while (f2 >= 0) {
            multiset.Q(this.Y.j(f2), this.Y.l(f2));
            f2 = this.Y.t(f2);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract ObjectCountHashMap<E> k(int i2);

    public final int l1(@CheckForNull Object obj) {
        return this.Y.g(obj);
    }

    @CanIgnoreReturnValue
    public final int r0(@ParametricNullness E e2, int i2) {
        CollectPreconditions.b(i2, "count");
        ObjectCountHashMap<E> objectCountHashMap = this.Y;
        int w = i2 == 0 ? objectCountHashMap.w(e2) : objectCountHashMap.v(e2, i2);
        this.Z += (long) (i2 - w);
        return w;
    }

    public final int size() {
        return Ints.z(this.Z);
    }
}
