package com.google.common.graph;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
interface NetworkConnections<N, E> {
    Set<N> a();

    Set<N> b();

    Set<N> c();

    @CanIgnoreReturnValue
    @CheckForNull
    N d(E e2, boolean z);

    Set<E> e();

    N f(E e2);

    Set<E> g();

    @CanIgnoreReturnValue
    N h(E e2);

    Set<E> i();

    void j(E e2, N n2);

    Set<E> k(N n2);

    void l(E e2, N n2, boolean z);
}
