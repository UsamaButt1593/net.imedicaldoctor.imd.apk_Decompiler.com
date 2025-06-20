package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.DoNotMock;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ImmutableTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
    private static final long Y = 912559;

    @DoNotMock
    public static final class Builder<R, C, V> {

        /* renamed from: a  reason: collision with root package name */
        private final List<Table.Cell<R, C, V>> f22420a = Lists.q();
        @CheckForNull

        /* renamed from: b  reason: collision with root package name */
        private Comparator<? super R> f22421b;
        @CheckForNull

        /* renamed from: c  reason: collision with root package name */
        private Comparator<? super C> f22422c;

        public ImmutableTable<R, C, V> a() {
            return b();
        }

        public ImmutableTable<R, C, V> b() {
            int size = this.f22420a.size();
            if (size != 0) {
                return size != 1 ? RegularImmutableTable.H(this.f22420a, this.f22421b, this.f22422c) : new SingletonImmutableTable((Table.Cell) Iterables.z(this.f22420a));
            }
            return ImmutableTable.s();
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public Builder<R, C, V> c(Builder<R, C, V> builder) {
            this.f22420a.addAll(builder.f22420a);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<R, C, V> d(Comparator<? super C> comparator) {
            this.f22422c = (Comparator) Preconditions.F(comparator, "columnComparator");
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<R, C, V> e(Comparator<? super R> comparator) {
            this.f22421b = (Comparator) Preconditions.F(comparator, "rowComparator");
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<R, C, V> f(Table.Cell<? extends R, ? extends C, ? extends V> cell) {
            if (cell instanceof Tables.ImmutableCell) {
                Preconditions.F(cell.b(), "row");
                Preconditions.F(cell.a(), "column");
                Preconditions.F(cell.getValue(), "value");
                this.f22420a.add(cell);
            } else {
                g(cell.b(), cell.a(), cell.getValue());
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<R, C, V> g(R r, C c2, V v) {
            this.f22420a.add(ImmutableTable.g(r, c2, v));
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<R, C, V> h(Table<? extends R, ? extends C, ? extends V> table) {
            for (Table.Cell<? extends R, ? extends C, ? extends V> f2 : table.I()) {
                f(f2);
            }
            return this;
        }
    }

    static final class SerializedForm implements Serializable {
        private static final long Y2 = 0;
        private final Object[] X;
        private final int[] X2;
        private final Object[] Y;
        private final int[] Z;
        private final Object[] s;

        private SerializedForm(Object[] objArr, Object[] objArr2, Object[] objArr3, int[] iArr, int[] iArr2) {
            this.s = objArr;
            this.X = objArr2;
            this.Y = objArr3;
            this.Z = iArr;
            this.X2 = iArr2;
        }

        static SerializedForm a(ImmutableTable<?, ?, ?> immutableTable, int[] iArr, int[] iArr2) {
            return new SerializedForm(immutableTable.n().toArray(), immutableTable.j0().toArray(), immutableTable.values().toArray(), iArr, iArr2);
        }

        /* access modifiers changed from: package-private */
        public Object b() {
            Object[] objArr = this.Y;
            if (objArr.length == 0) {
                return ImmutableTable.s();
            }
            int i2 = 0;
            if (objArr.length == 1) {
                return ImmutableTable.t(this.s[0], this.X[0], objArr[0]);
            }
            ImmutableList.Builder builder = new ImmutableList.Builder(objArr.length);
            while (true) {
                Object[] objArr2 = this.Y;
                if (i2 >= objArr2.length) {
                    return RegularImmutableTable.K(builder.e(), ImmutableSet.E(this.s), ImmutableSet.E(this.X));
                }
                builder.g(ImmutableTable.g(this.s[this.Z[i2]], this.X[this.X2[i2]], objArr2[i2]));
                i2++;
            }
        }
    }

    ImmutableTable() {
    }

    public static <R, C, V> Builder<R, C, V> e() {
        return new Builder<>();
    }

    static <R, C, V> Table.Cell<R, C, V> g(R r, C c2, V v) {
        return Tables.c(Preconditions.F(r, "rowKey"), Preconditions.F(c2, "columnKey"), Preconditions.F(v, "value"));
    }

    public static <R, C, V> ImmutableTable<R, C, V> l(Table<? extends R, ? extends C, ? extends V> table) {
        return table instanceof ImmutableTable ? (ImmutableTable) table : o(table.I());
    }

    static <R, C, V> ImmutableTable<R, C, V> o(Iterable<? extends Table.Cell<? extends R, ? extends C, ? extends V>> iterable) {
        Builder e2 = e();
        for (Table.Cell f2 : iterable) {
            e2.f(f2);
        }
        return e2.a();
    }

    public static <R, C, V> ImmutableTable<R, C, V> s() {
        return SparseImmutableTable.a3;
    }

    public static <R, C, V> ImmutableTable<R, C, V> t(R r, C c2, V v) {
        return new SingletonImmutableTable(r, c2, v);
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void u(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    /* access modifiers changed from: package-private */
    public final Object A() {
        return q();
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void B0(Table<? extends R, ? extends C, ? extends V> table) {
        throw new UnsupportedOperationException();
    }

    public /* bridge */ /* synthetic */ boolean D(@CheckForNull Object obj) {
        return super.D(obj);
    }

    public boolean I0(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return z(obj, obj2) != null;
    }

    @CanIgnoreReturnValue
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final V N(R r, C c2, V v) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    /* access modifiers changed from: package-private */
    public final Iterator<V> d() {
        throw new AssertionError("should never be called");
    }

    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final UnmodifiableIterator<Table.Cell<R, C, V>> a() {
        throw new AssertionError("should never be called");
    }

    /* renamed from: h */
    public ImmutableSet<Table.Cell<R, C, V>> I() {
        return (ImmutableSet) super.I();
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    /* renamed from: i */
    public ImmutableMap<R, V> E(C c2) {
        Preconditions.F(c2, "columnKey");
        return (ImmutableMap) MoreObjects.a((ImmutableMap) J0().get(c2), ImmutableMap.s());
    }

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* renamed from: j */
    public ImmutableSet<C> j0() {
        return J0().keySet();
    }

    /* renamed from: k */
    public abstract ImmutableMap<C, Map<R, V>> J0();

    public /* bridge */ /* synthetic */ boolean m0(@CheckForNull Object obj) {
        return super.m0(obj);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public abstract ImmutableSet<Table.Cell<R, C, V>> b();

    /* access modifiers changed from: package-private */
    public abstract SerializedForm q();

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public abstract ImmutableCollection<V> c();

    @CanIgnoreReturnValue
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        throw new UnsupportedOperationException();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* renamed from: v */
    public ImmutableMap<C, V> P0(R r) {
        Preconditions.F(r, "rowKey");
        return (ImmutableMap) MoreObjects.a((ImmutableMap) m().get(r), ImmutableMap.s());
    }

    /* renamed from: w */
    public ImmutableSet<R> n() {
        return m().keySet();
    }

    /* renamed from: x */
    public abstract ImmutableMap<R, Map<C, V>> m();

    /* renamed from: y */
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    @CheckForNull
    public /* bridge */ /* synthetic */ Object z(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.z(obj, obj2);
    }
}
