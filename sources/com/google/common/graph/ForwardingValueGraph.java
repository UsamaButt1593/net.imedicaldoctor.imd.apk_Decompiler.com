package com.google.common.graph;

import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class ForwardingValueGraph<N, V> extends AbstractValueGraph<N, V> {
    ForwardingValueGraph() {
    }

    @CheckForNull
    public V C(N n2, N n3, @CheckForNull V v) {
        return T().C(n2, n3, v);
    }

    /* access modifiers changed from: protected */
    public long N() {
        return (long) T().d().size();
    }

    /* access modifiers changed from: package-private */
    public abstract ValueGraph<N, V> T();

    public int c(N n2) {
        return T().c(n2);
    }

    public boolean e(N n2, N n3) {
        return T().e(n2, n3);
    }

    public boolean f() {
        return T().f();
    }

    public ElementOrder<N> g() {
        return T().g();
    }

    public int h(N n2) {
        return T().h(n2);
    }

    public boolean i() {
        return T().i();
    }

    public Set<N> j(N n2) {
        return T().j(n2);
    }

    public boolean k(EndpointPair<N> endpointPair) {
        return T().k(endpointPair);
    }

    public Set<N> m() {
        return T().m();
    }

    public int n(N n2) {
        return T().n(n2);
    }

    public ElementOrder<N> o() {
        return T().o();
    }

    @CheckForNull
    public V v(EndpointPair<N> endpointPair, @CheckForNull V v) {
        return T().v(endpointPair, v);
    }

    public Set<N> a(N n2) {
        return T().a((Object) n2);
    }

    public Set<N> b(N n2) {
        return T().b((Object) n2);
    }
}
