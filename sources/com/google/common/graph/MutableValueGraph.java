package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.CheckForNull;

@Beta
@ElementTypesAreNonnullByDefault
public interface MutableValueGraph<N, V> extends ValueGraph<N, V> {
    @CanIgnoreReturnValue
    @CheckForNull
    V J(EndpointPair<N> endpointPair, V v);

    @CanIgnoreReturnValue
    @CheckForNull
    V L(N n2, N n3, V v);

    @CanIgnoreReturnValue
    boolean p(N n2);

    @CanIgnoreReturnValue
    boolean q(N n2);

    @CanIgnoreReturnValue
    @CheckForNull
    V r(N n2, N n3);

    @CanIgnoreReturnValue
    @CheckForNull
    V s(EndpointPair<N> endpointPair);
}
