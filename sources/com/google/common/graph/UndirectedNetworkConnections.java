package com.google.common.graph;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

@ElementTypesAreNonnullByDefault
final class UndirectedNetworkConnections<N, E> extends AbstractUndirectedNetworkConnections<N, E> {
    UndirectedNetworkConnections(Map<E, N> map) {
        super(map);
    }

    static <N, E> UndirectedNetworkConnections<N, E> m() {
        return new UndirectedNetworkConnections<>(HashBiMap.h(2));
    }

    static <N, E> UndirectedNetworkConnections<N, E> n(Map<E, N> map) {
        return new UndirectedNetworkConnections<>(ImmutableBiMap.N(map));
    }

    public Set<N> a() {
        return Collections.unmodifiableSet(((BiMap) this.f22586a).values());
    }

    public Set<E> k(N n2) {
        return new EdgesConnecting(((BiMap) this.f22586a).q2(), n2);
    }
}
