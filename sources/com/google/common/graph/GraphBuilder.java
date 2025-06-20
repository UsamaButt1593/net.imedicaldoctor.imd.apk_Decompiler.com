package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.ImmutableGraph;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;

@ElementTypesAreNonnullByDefault
@Beta
@DoNotMock
public final class GraphBuilder<N> extends AbstractGraphBuilder<N> {
    private GraphBuilder(boolean z) {
        super(z);
    }

    private <N1 extends N> GraphBuilder<N1> c() {
        return this;
    }

    public static GraphBuilder<Object> e() {
        return new GraphBuilder<>(true);
    }

    public static <N> GraphBuilder<N> g(Graph<N> graph) {
        return new GraphBuilder(graph.f()).a(graph.i()).j(graph.g()).i(graph.o());
    }

    public static GraphBuilder<Object> k() {
        return new GraphBuilder<>(false);
    }

    @CanIgnoreReturnValue
    public GraphBuilder<N> a(boolean z) {
        this.f22581b = z;
        return this;
    }

    public <N1 extends N> MutableGraph<N1> b() {
        return new StandardMutableGraph(this);
    }

    /* access modifiers changed from: package-private */
    public GraphBuilder<N> d() {
        GraphBuilder<N> graphBuilder = new GraphBuilder<>(this.f22580a);
        graphBuilder.f22581b = this.f22581b;
        graphBuilder.f22582c = this.f22582c;
        graphBuilder.f22584e = this.f22584e;
        graphBuilder.f22583d = this.f22583d;
        return graphBuilder;
    }

    @CanIgnoreReturnValue
    public GraphBuilder<N> f(int i2) {
        this.f22584e = Optional.f(Integer.valueOf(Graphs.b(i2)));
        return this;
    }

    public <N1 extends N> ImmutableGraph.Builder<N1> h() {
        return new ImmutableGraph.Builder<>(c());
    }

    public <N1 extends N> GraphBuilder<N1> i(ElementOrder<N1> elementOrder) {
        Preconditions.u(elementOrder.h() == ElementOrder.Type.UNORDERED || elementOrder.h() == ElementOrder.Type.STABLE, "The given elementOrder (%s) is unsupported. incidentEdgeOrder() only supports ElementOrder.unordered() and ElementOrder.stable().", elementOrder);
        GraphBuilder<N1> c2 = c();
        c2.f22583d = (ElementOrder) Preconditions.E(elementOrder);
        return c2;
    }

    public <N1 extends N> GraphBuilder<N1> j(ElementOrder<N1> elementOrder) {
        GraphBuilder<N1> c2 = c();
        c2.f22582c = (ElementOrder) Preconditions.E(elementOrder);
        return c2;
    }
}
