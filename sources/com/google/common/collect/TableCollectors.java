package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

@GwtCompatible
@IgnoreJRERequirement
@ElementTypesAreNonnullByDefault
final class TableCollectors {

    private static final class ImmutableTableCollectorState<R, C, V> {

        /* renamed from: a  reason: collision with root package name */
        final List<MutableCell<R, C, V>> f22495a;

        /* renamed from: b  reason: collision with root package name */
        final Table<R, C, MutableCell<R, C, V>> f22496b;

        private ImmutableTableCollectorState() {
            this.f22495a = new ArrayList();
            this.f22496b = HashBasedTable.p();
        }

        /* access modifiers changed from: package-private */
        public ImmutableTableCollectorState<R, C, V> a(ImmutableTableCollectorState<R, C, V> immutableTableCollectorState, BinaryOperator<V> binaryOperator) {
            for (MutableCell next : immutableTableCollectorState.f22495a) {
                b(next.b(), next.a(), next.getValue(), binaryOperator);
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        public void b(R r, C c2, V v, BinaryOperator<V> binaryOperator) {
            MutableCell z = this.f22496b.z(r, c2);
            if (z == null) {
                MutableCell mutableCell = new MutableCell(r, c2, v);
                this.f22495a.add(mutableCell);
                this.f22496b.N(r, c2, mutableCell);
                return;
            }
            z.c(v, binaryOperator);
        }

        /* access modifiers changed from: package-private */
        public ImmutableTable<R, C, V> c() {
            return ImmutableTable.o(this.f22495a);
        }
    }

    @IgnoreJRERequirement
    private static final class MutableCell<R, C, V> extends Tables.AbstractCell<R, C, V> {
        private final C X;
        private V Y;
        private final R s;

        MutableCell(R r, C c2, V v) {
            this.s = Preconditions.F(r, "row");
            this.X = Preconditions.F(c2, "column");
            this.Y = Preconditions.F(v, "value");
        }

        public C a() {
            return this.X;
        }

        public R b() {
            return this.s;
        }

        /* access modifiers changed from: package-private */
        public void c(V v, BinaryOperator<V> binaryOperator) {
            Preconditions.F(v, "value");
            this.Y = Preconditions.F(binaryOperator.apply(this.Y, v), "mergeFunction.apply");
        }

        public V getValue() {
            return this.Y;
        }
    }

    private TableCollectors() {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ImmutableTableCollectorState j() {
        return new ImmutableTableCollectorState();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object n(Object obj, Object obj2) {
        throw new IllegalStateException("Conflicting values " + obj + " and " + obj2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Table p(BinaryOperator binaryOperator, Table table, Table table2) {
        for (Table.Cell cell : table2.I()) {
            q(table, cell.b(), cell.a(), cell.getValue(), binaryOperator);
        }
        return table;
    }

    /* access modifiers changed from: private */
    public static <R, C, V> void q(Table<R, C, V> table, @ParametricNullness R r, @ParametricNullness C c2, @ParametricNullness V v, BinaryOperator<V> binaryOperator) {
        Preconditions.E(v);
        V z = table.z(r, c2);
        if (z != null && (v = binaryOperator.apply(z, v)) == null) {
            table.remove(r, c2);
        } else {
            table.N(r, c2, v);
        }
    }

    static <T, R, C, V> Collector<T, ?, ImmutableTable<R, C, V>> r(Function<? super T, ? extends R> function, Function<? super T, ? extends C> function2, Function<? super T, ? extends V> function3) {
        Preconditions.F(function, "rowFunction");
        Preconditions.F(function2, "columnFunction");
        Preconditions.F(function3, "valueFunction");
        return Collector.of(new u(), new v(function, function2, function3), new w(), new x(), new Collector.Characteristics[0]);
    }

    static <T, R, C, V> Collector<T, ?, ImmutableTable<R, C, V>> s(Function<? super T, ? extends R> function, Function<? super T, ? extends C> function2, Function<? super T, ? extends V> function3, BinaryOperator<V> binaryOperator) {
        Preconditions.F(function, "rowFunction");
        Preconditions.F(function2, "columnFunction");
        Preconditions.F(function3, "valueFunction");
        Preconditions.F(binaryOperator, "mergeFunction");
        return Collector.of(new B(), new C(function, function2, function3, binaryOperator), new D(binaryOperator), new E(), new Collector.Characteristics[0]);
    }

    static <T, R, C, V, I extends Table<R, C, V>> Collector<T, ?, I> t(Function<? super T, ? extends R> function, Function<? super T, ? extends C> function2, Function<? super T, ? extends V> function3, BinaryOperator<V> binaryOperator, Supplier<I> supplier) {
        Preconditions.E(function);
        Preconditions.E(function2);
        Preconditions.E(function3);
        Preconditions.E(binaryOperator);
        Preconditions.E(supplier);
        return Collector.of(supplier, new z(function, function2, function3, binaryOperator), new A(binaryOperator), new Collector.Characteristics[0]);
    }

    static <T, R, C, V, I extends Table<R, C, V>> Collector<T, ?, I> u(Function<? super T, ? extends R> function, Function<? super T, ? extends C> function2, Function<? super T, ? extends V> function3, Supplier<I> supplier) {
        return t(function, function2, function3, new y(), supplier);
    }
}
