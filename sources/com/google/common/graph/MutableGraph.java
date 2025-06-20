package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@Beta
@ElementTypesAreNonnullByDefault
public interface MutableGraph<N> extends Graph<N> {
    @CanIgnoreReturnValue
    boolean D(N n2, N n3);

    @CanIgnoreReturnValue
    boolean H(EndpointPair<N> endpointPair);

    @CanIgnoreReturnValue
    boolean p(N n2);

    @CanIgnoreReturnValue
    boolean q(N n2);

    @CanIgnoreReturnValue
    boolean r(N n2, N n3);

    @CanIgnoreReturnValue
    boolean s(EndpointPair<N> endpointPair);
}
