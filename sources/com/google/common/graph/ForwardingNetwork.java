package com.google.common.graph;

import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class ForwardingNetwork<N, E> extends AbstractNetwork<N, E> {
    ForwardingNetwork() {
    }

    public boolean A() {
        return R().A();
    }

    public EndpointPair<N> B(E e2) {
        return R().B(e2);
    }

    public ElementOrder<E> E() {
        return R().E();
    }

    @CheckForNull
    public E F(EndpointPair<N> endpointPair) {
        return R().F(endpointPair);
    }

    public Set<E> K(N n2) {
        return R().K(n2);
    }

    /* access modifiers changed from: package-private */
    public abstract Network<N, E> R();

    public int c(N n2) {
        return R().c(n2);
    }

    public Set<E> d() {
        return R().d();
    }

    public boolean e(N n2, N n3) {
        return R().e(n2, n3);
    }

    public boolean f() {
        return R().f();
    }

    public ElementOrder<N> g() {
        return R().g();
    }

    public int h(N n2) {
        return R().h(n2);
    }

    public boolean i() {
        return R().i();
    }

    public Set<N> j(N n2) {
        return R().j(n2);
    }

    public boolean k(EndpointPair<N> endpointPair) {
        return R().k(endpointPair);
    }

    public Set<E> l(N n2) {
        return R().l(n2);
    }

    public Set<N> m() {
        return R().m();
    }

    public int n(N n2) {
        return R().n(n2);
    }

    public Set<E> u(EndpointPair<N> endpointPair) {
        return R().u(endpointPair);
    }

    @CheckForNull
    public E w(N n2, N n3) {
        return R().w(n2, n3);
    }

    public Set<E> x(N n2) {
        return R().x(n2);
    }

    public Set<E> y(E e2) {
        return R().y(e2);
    }

    public Set<E> z(N n2, N n3) {
        return R().z(n2, n3);
    }

    public Set<N> a(N n2) {
        return R().a((Object) n2);
    }

    public Set<N> b(N n2) {
        return R().b((Object) n2);
    }
}
