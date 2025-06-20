package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
class StandardValueGraph<N, V> extends AbstractValueGraph<N, V> {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f22640a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f22641b;

    /* renamed from: c  reason: collision with root package name */
    private final ElementOrder<N> f22642c;

    /* renamed from: d  reason: collision with root package name */
    final MapIteratorCache<N, GraphConnections<N, V>> f22643d;

    /* renamed from: e  reason: collision with root package name */
    long f22644e;

    StandardValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        this(abstractGraphBuilder, abstractGraphBuilder.f22582c.c(abstractGraphBuilder.f22584e.i(10).intValue()), 0);
    }

    private final GraphConnections<N, V> T(N n2) {
        GraphConnections<N, V> f2 = this.f22643d.f(n2);
        if (f2 != null) {
            return f2;
        }
        Preconditions.E(n2);
        throw new IllegalArgumentException("Node " + n2 + " is not an element of this graph.");
    }

    @CheckForNull
    private final V V(N n2, N n3, @CheckForNull V v) {
        GraphConnections f2 = this.f22643d.f(n2);
        V e2 = f2 == null ? null : f2.e(n3);
        return e2 == null ? v : e2;
    }

    private final boolean W(N n2, N n3) {
        GraphConnections f2 = this.f22643d.f(n2);
        return f2 != null && f2.b().contains(n3);
    }

    @CheckForNull
    public V C(N n2, N n3, @CheckForNull V v) {
        return V(Preconditions.E(n2), Preconditions.E(n3), v);
    }

    /* access modifiers changed from: protected */
    public long N() {
        return this.f22644e;
    }

    /* access modifiers changed from: package-private */
    public final boolean U(@CheckForNull N n2) {
        return this.f22643d.e(n2);
    }

    public boolean e(N n2, N n3) {
        return W(Preconditions.E(n2), Preconditions.E(n3));
    }

    public boolean f() {
        return this.f22640a;
    }

    public ElementOrder<N> g() {
        return this.f22642c;
    }

    public boolean i() {
        return this.f22641b;
    }

    public Set<N> j(N n2) {
        return T(n2).a();
    }

    public boolean k(EndpointPair<N> endpointPair) {
        Preconditions.E(endpointPair);
        return O(endpointPair) && W(endpointPair.g(), endpointPair.h());
    }

    public Set<EndpointPair<N>> l(N n2) {
        final GraphConnections T = T(n2);
        return new IncidentEdgeSet<N>(this, this, n2) {
            public Iterator<EndpointPair<N>> iterator() {
                return T.g(this.s);
            }
        };
    }

    public Set<N> m() {
        return this.f22643d.k();
    }

    @CheckForNull
    public V v(EndpointPair<N> endpointPair, @CheckForNull V v) {
        P(endpointPair);
        return V(endpointPair.g(), endpointPair.h(), v);
    }

    StandardValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder, Map<N, GraphConnections<N, V>> map, long j2) {
        this.f22640a = abstractGraphBuilder.f22580a;
        this.f22641b = abstractGraphBuilder.f22581b;
        this.f22642c = abstractGraphBuilder.f22582c.a();
        this.f22643d = map instanceof TreeMap ? new MapRetrievalCache<>(map) : new MapIteratorCache<>(map);
        this.f22644e = Graphs.c(j2);
    }

    public Set<N> a(N n2) {
        return T(n2).c();
    }

    public Set<N> b(N n2) {
        return T(n2).b();
    }
}
