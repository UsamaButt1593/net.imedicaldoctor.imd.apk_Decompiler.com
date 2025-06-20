package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@Beta
@DoNotMock("Use NetworkBuilder to create a real instance")
public interface Network<N, E> extends SuccessorsFunction<N>, PredecessorsFunction<N> {
    boolean A();

    EndpointPair<N> B(E e2);

    ElementOrder<E> E();

    @CheckForNull
    E F(EndpointPair<N> endpointPair);

    Set<E> K(N n2);

    /* bridge */ /* synthetic */ Iterable a(Object obj);

    Set<N> a(N n2);

    /* bridge */ /* synthetic */ Iterable b(Object obj);

    Set<N> b(N n2);

    int c(N n2);

    Set<E> d();

    boolean e(N n2, N n3);

    boolean equals(@CheckForNull Object obj);

    boolean f();

    ElementOrder<N> g();

    int h(N n2);

    int hashCode();

    boolean i();

    Set<N> j(N n2);

    boolean k(EndpointPair<N> endpointPair);

    Set<E> l(N n2);

    Set<N> m();

    int n(N n2);

    Graph<N> t();

    Set<E> u(EndpointPair<N> endpointPair);

    @CheckForNull
    E w(N n2, N n3);

    Set<E> x(N n2);

    Set<E> y(E e2);

    Set<E> z(N n2, N n3);
}
