package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@Beta
@ElementTypesAreNonnullByDefault
public interface MutableNetwork<N, E> extends Network<N, E> {
    @CanIgnoreReturnValue
    boolean G(EndpointPair<N> endpointPair, E e2);

    @CanIgnoreReturnValue
    boolean I(E e2);

    @CanIgnoreReturnValue
    boolean M(N n2, N n3, E e2);

    @CanIgnoreReturnValue
    boolean p(N n2);

    @CanIgnoreReturnValue
    boolean q(N n2);
}
