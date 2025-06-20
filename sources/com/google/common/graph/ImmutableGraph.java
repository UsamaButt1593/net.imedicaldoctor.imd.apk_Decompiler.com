package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.graph.GraphConstants;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.util.Set;

@ElementTypesAreNonnullByDefault
@Immutable(containerOf = {"N"})
@Beta
public class ImmutableGraph<N> extends ForwardingGraph<N> {

    /* renamed from: a  reason: collision with root package name */
    private final BaseGraph<N> f22618a;

    public static class Builder<N> {

        /* renamed from: a  reason: collision with root package name */
        private final MutableGraph<N> f22619a;

        Builder(GraphBuilder<N> graphBuilder) {
            this.f22619a = graphBuilder.d().i(ElementOrder.g()).b();
        }

        @CanIgnoreReturnValue
        public Builder<N> a(N n2) {
            this.f22619a.p(n2);
            return this;
        }

        public ImmutableGraph<N> b() {
            return ImmutableGraph.S(this.f22619a);
        }

        @CanIgnoreReturnValue
        public Builder<N> c(EndpointPair<N> endpointPair) {
            this.f22619a.H(endpointPair);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<N> d(N n2, N n3) {
            this.f22619a.D(n2, n3);
            return this;
        }
    }

    ImmutableGraph(BaseGraph<N> baseGraph) {
        this.f22618a = baseGraph;
    }

    private static <N> GraphConnections<N, GraphConstants.Presence> R(Graph<N> graph, N n2) {
        Function b2 = Functions.b(GraphConstants.Presence.EDGE_EXISTS);
        return graph.f() ? DirectedGraphConnections.y(n2, graph.l(n2), b2) : UndirectedGraphConnections.m(Maps.j(graph.j(n2), b2));
    }

    public static <N> ImmutableGraph<N> S(Graph<N> graph) {
        return graph instanceof ImmutableGraph ? (ImmutableGraph) graph : new ImmutableGraph<>(new StandardValueGraph(GraphBuilder.g(graph), U(graph), (long) graph.d().size()));
    }

    @Deprecated
    public static <N> ImmutableGraph<N> T(ImmutableGraph<N> immutableGraph) {
        return (ImmutableGraph) Preconditions.E(immutableGraph);
    }

    private static <N> ImmutableMap<N, GraphConnections<N, GraphConstants.Presence>> U(Graph<N> graph) {
        ImmutableMap.Builder b2 = ImmutableMap.b();
        for (N next : graph.m()) {
            b2.i(next, R(graph, next));
        }
        return b2.d();
    }

    /* access modifiers changed from: package-private */
    public BaseGraph<N> Q() {
        return this.f22618a;
    }

    public /* bridge */ /* synthetic */ Set a(Object obj) {
        return super.a(obj);
    }

    public /* bridge */ /* synthetic */ Set b(Object obj) {
        return super.b(obj);
    }

    public /* bridge */ /* synthetic */ int c(Object obj) {
        return super.c(obj);
    }

    public /* bridge */ /* synthetic */ boolean e(Object obj, Object obj2) {
        return super.e(obj, obj2);
    }

    public /* bridge */ /* synthetic */ boolean f() {
        return super.f();
    }

    public /* bridge */ /* synthetic */ ElementOrder g() {
        return super.g();
    }

    public /* bridge */ /* synthetic */ int h(Object obj) {
        return super.h(obj);
    }

    public /* bridge */ /* synthetic */ boolean i() {
        return super.i();
    }

    public /* bridge */ /* synthetic */ Set j(Object obj) {
        return super.j(obj);
    }

    public /* bridge */ /* synthetic */ boolean k(EndpointPair endpointPair) {
        return super.k(endpointPair);
    }

    public /* bridge */ /* synthetic */ Set l(Object obj) {
        return super.l(obj);
    }

    public /* bridge */ /* synthetic */ Set m() {
        return super.m();
    }

    public /* bridge */ /* synthetic */ int n(Object obj) {
        return super.n(obj);
    }

    public ElementOrder<N> o() {
        return ElementOrder.g();
    }
}
