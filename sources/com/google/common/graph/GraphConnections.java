package com.google.common.graph;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
interface GraphConnections<N, V> {
    Set<N> a();

    Set<N> b();

    Set<N> c();

    @CanIgnoreReturnValue
    @CheckForNull
    V d(N n2);

    @CheckForNull
    V e(N n2);

    void f(N n2);

    Iterator<EndpointPair<N>> g(N n2);

    @CanIgnoreReturnValue
    @CheckForNull
    V h(N n2, V v);

    void i(N n2, V v);
}
