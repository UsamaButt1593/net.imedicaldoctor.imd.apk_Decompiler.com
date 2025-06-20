package com.google.common.graph;

import java.util.Set;

@ElementTypesAreNonnullByDefault
interface BaseGraph<N> extends SuccessorsFunction<N>, PredecessorsFunction<N> {
    /* bridge */ /* synthetic */ Iterable a(Object obj);

    Set<N> a(N n2);

    /* bridge */ /* synthetic */ Iterable b(Object obj);

    Set<N> b(N n2);

    int c(N n2);

    Set<EndpointPair<N>> d();

    boolean e(N n2, N n3);

    boolean f();

    ElementOrder<N> g();

    int h(N n2);

    boolean i();

    Set<N> j(N n2);

    boolean k(EndpointPair<N> endpointPair);

    Set<EndpointPair<N>> l(N n2);

    Set<N> m();

    int n(N n2);

    ElementOrder<N> o();
}
