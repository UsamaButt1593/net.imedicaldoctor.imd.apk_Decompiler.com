package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.ImmutableValueGraph;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@Beta
@ElementTypesAreNonnullByDefault
public final class ValueGraphBuilder<N, V> extends AbstractGraphBuilder<N> {
    private ValueGraphBuilder(boolean z) {
        super(z);
    }

    private <N1 extends N, V1 extends V> ValueGraphBuilder<N1, V1> c() {
        return this;
    }

    public static ValueGraphBuilder<Object, Object> e() {
        return new ValueGraphBuilder<>(true);
    }

    public static <N, V> ValueGraphBuilder<N, V> g(ValueGraph<N, V> valueGraph) {
        return new ValueGraphBuilder(valueGraph.f()).a(valueGraph.i()).j(valueGraph.g()).i(valueGraph.o());
    }

    public static ValueGraphBuilder<Object, Object> k() {
        return new ValueGraphBuilder<>(false);
    }

    @CanIgnoreReturnValue
    public ValueGraphBuilder<N, V> a(boolean z) {
        this.f22581b = z;
        return this;
    }

    public <N1 extends N, V1 extends V> MutableValueGraph<N1, V1> b() {
        return new StandardMutableValueGraph(this);
    }

    /* access modifiers changed from: package-private */
    public ValueGraphBuilder<N, V> d() {
        ValueGraphBuilder<N, V> valueGraphBuilder = new ValueGraphBuilder<>(this.f22580a);
        valueGraphBuilder.f22581b = this.f22581b;
        valueGraphBuilder.f22582c = this.f22582c;
        valueGraphBuilder.f22584e = this.f22584e;
        valueGraphBuilder.f22583d = this.f22583d;
        return valueGraphBuilder;
    }

    @CanIgnoreReturnValue
    public ValueGraphBuilder<N, V> f(int i2) {
        this.f22584e = Optional.f(Integer.valueOf(Graphs.b(i2)));
        return this;
    }

    public <N1 extends N, V1 extends V> ImmutableValueGraph.Builder<N1, V1> h() {
        return new ImmutableValueGraph.Builder<>(c());
    }

    public <N1 extends N> ValueGraphBuilder<N1, V> i(ElementOrder<N1> elementOrder) {
        Preconditions.u(elementOrder.h() == ElementOrder.Type.UNORDERED || elementOrder.h() == ElementOrder.Type.STABLE, "The given elementOrder (%s) is unsupported. incidentEdgeOrder() only supports ElementOrder.unordered() and ElementOrder.stable().", elementOrder);
        ValueGraphBuilder<N1, V> c2 = c();
        c2.f22583d = (ElementOrder) Preconditions.E(elementOrder);
        return c2;
    }

    public <N1 extends N> ValueGraphBuilder<N1, V> j(ElementOrder<N1> elementOrder) {
        ValueGraphBuilder<N1, V> c2 = c();
        c2.f22582c = (ElementOrder) Preconditions.E(elementOrder);
        return c2;
    }
}
