package com.google.common.graph;

import java.util.Set;

@ElementTypesAreNonnullByDefault
abstract class ForwardingGraph<N> extends AbstractGraph<N> {
    ForwardingGraph() {
    }

    /* access modifiers changed from: protected */
    public long N() {
        return (long) Q().d().size();
    }

    /* access modifiers changed from: package-private */
    public abstract BaseGraph<N> Q();

    public int c(N n2) {
        return Q().c(n2);
    }

    public boolean e(N n2, N n3) {
        return Q().e(n2, n3);
    }

    public boolean f() {
        return Q().f();
    }

    public ElementOrder<N> g() {
        return Q().g();
    }

    public int h(N n2) {
        return Q().h(n2);
    }

    public boolean i() {
        return Q().i();
    }

    public Set<N> j(N n2) {
        return Q().j(n2);
    }

    public boolean k(EndpointPair<N> endpointPair) {
        return Q().k(endpointPair);
    }

    public Set<EndpointPair<N>> l(N n2) {
        return Q().l(n2);
    }

    public Set<N> m() {
        return Q().m();
    }

    public int n(N n2) {
        return Q().n(n2);
    }

    public ElementOrder<N> o() {
        return Q().o();
    }

    public Set<N> a(N n2) {
        return Q().a((Object) n2);
    }

    public Set<N> b(N n2) {
        return Q().b((Object) n2);
    }
}
