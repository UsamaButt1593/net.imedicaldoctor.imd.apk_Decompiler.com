package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.DoNotMock;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
@DoNotMock("Use ImmutableList.of or another implementation")
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] s = new Object[0];

    static abstract class ArrayBasedBuilder<E> extends Builder<E> {

        /* renamed from: b  reason: collision with root package name */
        Object[] f22386b;

        /* renamed from: c  reason: collision with root package name */
        int f22387c = 0;

        /* renamed from: d  reason: collision with root package name */
        boolean f22388d;

        ArrayBasedBuilder(int i2) {
            CollectPreconditions.b(i2, "initialCapacity");
            this.f22386b = new Object[i2];
        }

        private void i(int i2) {
            Object[] objArr = this.f22386b;
            if (objArr.length < i2) {
                this.f22386b = Arrays.copyOf(objArr, Builder.f(objArr.length, i2));
            } else if (this.f22388d) {
                this.f22386b = (Object[]) objArr.clone();
            } else {
                return;
            }
            this.f22388d = false;
        }

        @CanIgnoreReturnValue
        public Builder<E> b(E... eArr) {
            h(eArr, eArr.length);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> c(Iterable<? extends E> iterable) {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                i(this.f22387c + collection.size());
                if (collection instanceof ImmutableCollection) {
                    this.f22387c = ((ImmutableCollection) collection).c(this.f22386b, this.f22387c);
                    return this;
                }
            }
            super.c(iterable);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: g */
        public ArrayBasedBuilder<E> a(E e2) {
            Preconditions.E(e2);
            i(this.f22387c + 1);
            Object[] objArr = this.f22386b;
            int i2 = this.f22387c;
            this.f22387c = i2 + 1;
            objArr[i2] = e2;
            return this;
        }

        /* access modifiers changed from: package-private */
        public final void h(Object[] objArr, int i2) {
            ObjectArrays.c(objArr, i2);
            i(this.f22387c + i2);
            System.arraycopy(objArr, 0, this.f22386b, this.f22387c, i2);
            this.f22387c += i2;
        }
    }

    @DoNotMock
    public static abstract class Builder<E> {

        /* renamed from: a  reason: collision with root package name */
        static final int f22389a = 4;

        Builder() {
        }

        static int f(int i2, int i3) {
            if (i3 >= 0) {
                int i4 = i2 + (i2 >> 1) + 1;
                if (i4 < i3) {
                    i4 = Integer.highestOneBit(i3 - 1) << 1;
                }
                if (i4 < 0) {
                    return Integer.MAX_VALUE;
                }
                return i4;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }

        @CanIgnoreReturnValue
        public abstract Builder<E> a(E e2);

        @CanIgnoreReturnValue
        public Builder<E> b(E... eArr) {
            for (E a2 : eArr) {
                a(a2);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> c(Iterable<? extends E> iterable) {
            for (Object a2 : iterable) {
                a(a2);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> d(Iterator<? extends E> it2) {
            while (it2.hasNext()) {
                a(it2.next());
            }
            return this;
        }

        public abstract ImmutableCollection<E> e();
    }

    ImmutableCollection() {
    }

    @J2ktIncompatible
    private void m(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean add(E e2) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> b() {
        return isEmpty() ? ImmutableList.I() : ImmutableList.o(toArray());
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public int c(Object[] objArr, int i2) {
        UnmodifiableIterator k2 = iterator();
        while (k2.hasNext()) {
            objArr[i2] = k2.next();
            i2++;
        }
        return i2;
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean contains(@CheckForNull Object obj);

    /* access modifiers changed from: package-private */
    @CheckForNull
    public Object[] d() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public int g() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int h() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public abstract boolean j();

    /* renamed from: k */
    public abstract UnmodifiableIterator<E> iterator();

    /* access modifiers changed from: package-private */
    @J2ktIncompatible
    public Object n() {
        return new ImmutableList.SerializedForm(toArray());
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @J2ktIncompatible
    public final Object[] toArray() {
        return toArray(s);
    }

    @CanIgnoreReturnValue
    public final <T> T[] toArray(T[] tArr) {
        Preconditions.E(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] d2 = d();
            if (d2 != null) {
                return Platform.a(d2, h(), g(), tArr);
            }
            tArr = ObjectArrays.j(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        c(tArr, 0);
        return tArr;
    }
}
