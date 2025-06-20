package com.google.common.graph;

import java.util.AbstractSet;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class IncidentEdgeSet<N> extends AbstractSet<EndpointPair<N>> {
    final BaseGraph<N> X;
    final N s;

    IncidentEdgeSet(BaseGraph<N> baseGraph, N n2) {
        this.X = baseGraph;
        this.s = n2;
    }

    public boolean contains(@CheckForNull Object obj) {
        if (!(obj instanceof EndpointPair)) {
            return false;
        }
        EndpointPair endpointPair = (EndpointPair) obj;
        if (this.X.f()) {
            if (!endpointPair.c()) {
                return false;
            }
            Object n2 = endpointPair.n();
            Object o = endpointPair.o();
            return (this.s.equals(n2) && this.X.b((Object) this.s).contains(o)) || (this.s.equals(o) && this.X.a((Object) this.s).contains(n2));
        } else if (endpointPair.c()) {
            return false;
        } else {
            Set<N> j2 = this.X.j(this.s);
            Object g2 = endpointPair.g();
            Object h2 = endpointPair.h();
            return (this.s.equals(h2) && j2.contains(g2)) || (this.s.equals(g2) && j2.contains(h2));
        }
    }

    public boolean remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.X.f() ? (this.X.n(this.s) + this.X.h(this.s)) - (this.X.b((Object) this.s).contains(this.s) ? 1 : 0) : this.X.j(this.s).size();
    }
}
