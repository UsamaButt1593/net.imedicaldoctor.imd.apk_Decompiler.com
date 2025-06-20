package com.google.common.graph;

import com.google.common.graph.GraphConstants;

@ElementTypesAreNonnullByDefault
final class StandardMutableGraph<N> extends ForwardingGraph<N> implements MutableGraph<N> {

    /* renamed from: a  reason: collision with root package name */
    private final MutableValueGraph<N, GraphConstants.Presence> f22631a;

    StandardMutableGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        this.f22631a = new StandardMutableValueGraph(abstractGraphBuilder);
    }

    public boolean D(N n2, N n3) {
        return this.f22631a.L(n2, n3, GraphConstants.Presence.EDGE_EXISTS) == null;
    }

    public boolean H(EndpointPair<N> endpointPair) {
        P(endpointPair);
        return D(endpointPair.g(), endpointPair.h());
    }

    /* access modifiers changed from: package-private */
    public BaseGraph<N> Q() {
        return this.f22631a;
    }

    public boolean p(N n2) {
        return this.f22631a.p(n2);
    }

    public boolean q(N n2) {
        return this.f22631a.q(n2);
    }

    public boolean r(N n2, N n3) {
        return this.f22631a.r(n2, n3) != null;
    }

    public boolean s(EndpointPair<N> endpointPair) {
        P(endpointPair);
        return r(endpointPair.g(), endpointPair.h());
    }
}
