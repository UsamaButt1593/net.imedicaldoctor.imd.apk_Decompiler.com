package com.google.common.graph;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

@ElementTypesAreNonnullByDefault
final class DirectedNetworkConnections<N, E> extends AbstractDirectedNetworkConnections<N, E> {
    DirectedNetworkConnections(Map<E, N> map, Map<E, N> map2, int i2) {
        super(map, map2, i2);
    }

    static <N, E> DirectedNetworkConnections<N, E> n() {
        return new DirectedNetworkConnections<>(HashBiMap.h(2), HashBiMap.h(2), 0);
    }

    static <N, E> DirectedNetworkConnections<N, E> o(Map<E, N> map, Map<E, N> map2, int i2) {
        return new DirectedNetworkConnections<>(ImmutableBiMap.N(map), ImmutableBiMap.N(map2), i2);
    }

    public Set<N> b() {
        return Collections.unmodifiableSet(((BiMap) this.f22578b).values());
    }

    public Set<N> c() {
        return Collections.unmodifiableSet(((BiMap) this.f22577a).values());
    }

    public Set<E> k(N n2) {
        return new EdgesConnecting(((BiMap) this.f22578b).q2(), n2);
    }
}
