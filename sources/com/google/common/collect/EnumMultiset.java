package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class EnumMultiset<E extends Enum<E>> extends AbstractMultiset<E> implements Serializable {
    @GwtIncompatible
    private static final long a3 = 0;
    /* access modifiers changed from: private */
    public transient int[] X2;
    private transient Class<E> Y;
    private transient int Y2;
    /* access modifiers changed from: private */
    public transient E[] Z;
    private transient long Z2;

    abstract class Itr<T> implements Iterator<T> {
        int X = -1;
        int s = 0;

        Itr() {
        }

        /* access modifiers changed from: package-private */
        public abstract T a(int i2);

        public boolean hasNext() {
            while (this.s < EnumMultiset.this.Z.length) {
                int[] k2 = EnumMultiset.this.X2;
                int i2 = this.s;
                if (k2[i2] > 0) {
                    return true;
                }
                this.s = i2 + 1;
            }
            return false;
        }

        public T next() {
            if (hasNext()) {
                T a2 = a(this.s);
                int i2 = this.s;
                this.X = i2;
                this.s = i2 + 1;
                return a2;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            CollectPreconditions.e(this.X >= 0);
            if (EnumMultiset.this.X2[this.X] > 0) {
                EnumMultiset.m(EnumMultiset.this);
                EnumMultiset enumMultiset = EnumMultiset.this;
                EnumMultiset.n(enumMultiset, (long) enumMultiset.X2[this.X]);
                EnumMultiset.this.X2[this.X] = 0;
            }
            this.X = -1;
        }
    }

    private EnumMultiset(Class<E> cls) {
        this.Y = cls;
        Preconditions.d(cls.isEnum());
        E[] eArr = (Enum[]) cls.getEnumConstants();
        this.Z = eArr;
        this.X2 = new int[eArr.length];
    }

    @GwtIncompatible
    private void B(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Object readObject = objectInputStream.readObject();
        Objects.requireNonNull(readObject);
        Class<E> cls = (Class) readObject;
        this.Y = cls;
        E[] eArr = (Enum[]) cls.getEnumConstants();
        this.Z = eArr;
        this.X2 = new int[eArr.length];
        Serialization.f(this, objectInputStream);
    }

    @GwtIncompatible
    private void D(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.Y);
        Serialization.k(this, objectOutputStream);
    }

    static /* synthetic */ int m(EnumMultiset enumMultiset) {
        int i2 = enumMultiset.Y2;
        enumMultiset.Y2 = i2 - 1;
        return i2;
    }

    static /* synthetic */ long n(EnumMultiset enumMultiset, long j2) {
        long j3 = enumMultiset.Z2 - j2;
        enumMultiset.Z2 = j3;
        return j3;
    }

    private void q(Object obj) {
        Preconditions.E(obj);
        if (!z(obj)) {
            throw new ClassCastException("Expected an " + this.Y + " but got " + obj);
        }
    }

    public static <E extends Enum<E>> EnumMultiset<E> r(Class<E> cls) {
        return new EnumMultiset<>(cls);
    }

    public static <E extends Enum<E>> EnumMultiset<E> t(Iterable<E> iterable) {
        Iterator<E> it2 = iterable.iterator();
        Preconditions.e(it2.hasNext(), "EnumMultiset constructor passed empty Iterable");
        EnumMultiset<E> enumMultiset = new EnumMultiset<>(((Enum) it2.next()).getDeclaringClass());
        Iterables.a(enumMultiset, iterable);
        return enumMultiset;
    }

    public static <E extends Enum<E>> EnumMultiset<E> x(Iterable<E> iterable, Class<E> cls) {
        EnumMultiset<E> r = r(cls);
        Iterables.a(r, iterable);
        return r;
    }

    private boolean z(@CheckForNull Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        E e2 = (Enum) obj;
        int ordinal = e2.ordinal();
        E[] eArr = this.Z;
        return ordinal < eArr.length && eArr[ordinal] == e2;
    }

    @CanIgnoreReturnValue
    /* renamed from: C */
    public int r0(E e2, int i2) {
        int i3;
        q(e2);
        CollectPreconditions.b(i2, "count");
        int ordinal = e2.ordinal();
        int[] iArr = this.X2;
        int i4 = iArr[ordinal];
        iArr[ordinal] = i2;
        this.Z2 += (long) (i2 - i4);
        if (i4 != 0 || i2 <= 0) {
            if (i4 > 0 && i2 == 0) {
                i3 = this.Y2 - 1;
            }
            return i4;
        }
        i3 = this.Y2 + 1;
        this.Y2 = i3;
        return i4;
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean D0(@ParametricNullness Object obj, int i2, int i3) {
        return super.D0(obj, i2, i3);
    }

    @CanIgnoreReturnValue
    public int F(@CheckForNull Object obj, int i2) {
        if (obj == null || !z(obj)) {
            return 0;
        }
        Enum enumR = (Enum) obj;
        CollectPreconditions.b(i2, "occurrences");
        if (i2 == 0) {
            return l1(obj);
        }
        int ordinal = enumR.ordinal();
        int[] iArr = this.X2;
        int i3 = iArr[ordinal];
        if (i3 == 0) {
            return 0;
        }
        if (i3 <= i2) {
            iArr[ordinal] = 0;
            this.Y2--;
            this.Z2 -= (long) i3;
        } else {
            iArr[ordinal] = i3 - i2;
            this.Z2 -= (long) i2;
        }
        return i3;
    }

    public void clear() {
        Arrays.fill(this.X2, 0);
        this.Z2 = 0;
        this.Y2 = 0;
    }

    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object obj) {
        return super.contains(obj);
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.Y2;
    }

    public /* bridge */ /* synthetic */ Set e() {
        return super.e();
    }

    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    /* access modifiers changed from: package-private */
    public Iterator<E> g() {
        return new EnumMultiset<E>.Itr<E>() {
            /* access modifiers changed from: package-private */
            /* renamed from: b */
            public E a(int i2) {
                return EnumMultiset.this.Z[i2];
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Iterator<Multiset.Entry<E>> h() {
        return new EnumMultiset<E>.Itr<Multiset.Entry<E>>() {
            /* access modifiers changed from: package-private */
            /* renamed from: b */
            public Multiset.Entry<E> a(final int i2) {
                return new Multisets.AbstractEntry<E>() {
                    /* renamed from: b */
                    public E a() {
                        return EnumMultiset.this.Z[i2];
                    }

                    public int getCount() {
                        return EnumMultiset.this.X2[i2];
                    }
                };
            }
        };
    }

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public Iterator<E> iterator() {
        return Multisets.n(this);
    }

    public int l1(@CheckForNull Object obj) {
        if (obj == null || !z(obj)) {
            return 0;
        }
        return this.X2[((Enum) obj).ordinal()];
    }

    @CanIgnoreReturnValue
    /* renamed from: o */
    public int Q(E e2, int i2) {
        q(e2);
        CollectPreconditions.b(i2, "occurrences");
        if (i2 == 0) {
            return l1(e2);
        }
        int ordinal = e2.ordinal();
        int i3 = this.X2[ordinal];
        long j2 = (long) i2;
        long j3 = ((long) i3) + j2;
        Preconditions.p(j3 <= 2147483647L, "too many occurrences: %s", j3);
        this.X2[ordinal] = (int) j3;
        if (i3 == 0) {
            this.Y2++;
        }
        this.Z2 += j2;
        return i3;
    }

    public int size() {
        return Ints.z(this.Z2);
    }
}
