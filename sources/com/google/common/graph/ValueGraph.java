package com.google.common.graph;

import com.google.common.annotations.Beta;
import java.util.Set;
import javax.annotation.CheckForNull;

@Beta
@ElementTypesAreNonnullByDefault
public interface ValueGraph<N, V> extends BaseGraph<N> {
    @CheckForNull
    V C(N n2, N n3, @CheckForNull V v);

    /* bridge */ /* synthetic */ Iterable a(Object obj);

    Set<N> a(N n2);

    /* bridge */ /* synthetic */ Iterable b(Object obj);

    Set<N> b(N n2);

    int c(N n2);

    Set<EndpointPair<N>> d();

    boolean e(N n2, N n3);

    boolean equals(@CheckForNull Object obj);

    boolean f();

    ElementOrder<N> g();

    int h(N n2);

    int hashCode();

    boolean i();

    Set<N> j(N n2);

    boolean k(EndpointPair<N> endpointPair);

    Set<EndpointPair<N>> l(N n2);

    Set<N> m();

    int n(N n2);

    ElementOrder<N> o();

    Graph<N> t();

    @CheckForNull
    V v(EndpointPair<N> endpointPair, @CheckForNull V v);
}
