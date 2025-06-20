package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Objects;

@ElementTypesAreNonnullByDefault
final class StandardMutableNetwork<N, E> extends StandardNetwork<N, E> implements MutableNetwork<N, E> {
    StandardMutableNetwork(NetworkBuilder<? super N, ? super E> networkBuilder) {
        super(networkBuilder);
    }

    @CanIgnoreReturnValue
    private NetworkConnections<N, E> V(N n2) {
        NetworkConnections<N, E> W = W();
        Preconditions.g0(this.f22638f.i(n2, W) == null);
        return W;
    }

    private NetworkConnections<N, E> W() {
        return f() ? A() ? DirectedMultiNetworkConnections.p() : DirectedNetworkConnections.n() : A() ? UndirectedMultiNetworkConnections.p() : UndirectedNetworkConnections.m();
    }

    @CanIgnoreReturnValue
    public boolean G(EndpointPair<N> endpointPair, E e2) {
        Q(endpointPair);
        return M(endpointPair.g(), endpointPair.h(), e2);
    }

    @CanIgnoreReturnValue
    public boolean I(E e2) {
        Preconditions.F(e2, "edge");
        N f2 = this.f22639g.f(e2);
        boolean z = false;
        if (f2 == null) {
            return false;
        }
        NetworkConnections f3 = this.f22638f.f(f2);
        Objects.requireNonNull(f3);
        NetworkConnections networkConnections = f3;
        Object f4 = networkConnections.f(e2);
        NetworkConnections f5 = this.f22638f.f(f4);
        Objects.requireNonNull(f5);
        NetworkConnections networkConnections2 = f5;
        networkConnections.h(e2);
        if (i() && f2.equals(f4)) {
            z = true;
        }
        networkConnections2.d(e2, z);
        this.f22639g.j(e2);
        return true;
    }

    @CanIgnoreReturnValue
    public boolean M(N n2, N n3, E e2) {
        Preconditions.F(n2, "nodeU");
        Preconditions.F(n3, "nodeV");
        Preconditions.F(e2, "edge");
        boolean z = false;
        if (T(e2)) {
            EndpointPair B = B(e2);
            EndpointPair k2 = EndpointPair.k(this, n2, n3);
            Preconditions.z(B.equals(k2), "Edge %s already exists between the following nodes: %s, so it cannot be reused to connect the following nodes: %s.", e2, B, k2);
            return false;
        }
        NetworkConnections f2 = this.f22638f.f(n2);
        if (!A()) {
            if (f2 == null || !f2.b().contains(n3)) {
                z = true;
            }
            Preconditions.y(z, "Nodes %s and %s are already connected by a different edge. To construct a graph that allows parallel edges, call allowsParallelEdges(true) on the Builder.", n2, n3);
        }
        boolean equals = n2.equals(n3);
        if (!i()) {
            Preconditions.u(!equals, "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", n2);
        }
        if (f2 == null) {
            f2 = V(n2);
        }
        f2.j(e2, n3);
        NetworkConnections f3 = this.f22638f.f(n3);
        if (f3 == null) {
            f3 = V(n3);
        }
        f3.l(e2, n2, equals);
        this.f22639g.i(e2, n2);
        return true;
    }

    @CanIgnoreReturnValue
    public boolean p(N n2) {
        Preconditions.F(n2, "node");
        if (U(n2)) {
            return false;
        }
        V(n2);
        return true;
    }

    @CanIgnoreReturnValue
    public boolean q(N n2) {
        Preconditions.F(n2, "node");
        NetworkConnections f2 = this.f22638f.f(n2);
        if (f2 == null) {
            return false;
        }
        UnmodifiableIterator k2 = ImmutableList.B(f2.e()).iterator();
        while (k2.hasNext()) {
            I(k2.next());
        }
        this.f22638f.j(n2);
        return true;
    }
}
