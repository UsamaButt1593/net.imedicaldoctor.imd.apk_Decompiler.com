package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

@ElementTypesAreNonnullByDefault
class StandardNetwork<N, E> extends AbstractNetwork<N, E> {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f22633a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f22634b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f22635c;

    /* renamed from: d  reason: collision with root package name */
    private final ElementOrder<N> f22636d;

    /* renamed from: e  reason: collision with root package name */
    private final ElementOrder<E> f22637e;

    /* renamed from: f  reason: collision with root package name */
    final MapIteratorCache<N, NetworkConnections<N, E>> f22638f;

    /* renamed from: g  reason: collision with root package name */
    final MapIteratorCache<E, N> f22639g;

    StandardNetwork(NetworkBuilder<? super N, ? super E> networkBuilder) {
        this(networkBuilder, networkBuilder.f22582c.c(networkBuilder.f22584e.i(10).intValue()), networkBuilder.f22629g.c(networkBuilder.f22630h.i(20).intValue()));
    }

    public boolean A() {
        return this.f22634b;
    }

    public EndpointPair<N> B(E e2) {
        Object S = S(e2);
        NetworkConnections f2 = this.f22638f.f(S);
        Objects.requireNonNull(f2);
        return EndpointPair.k(this, S, f2.f(e2));
    }

    public ElementOrder<E> E() {
        return this.f22637e;
    }

    public Set<E> K(N n2) {
        return R(n2).g();
    }

    /* access modifiers changed from: package-private */
    public final NetworkConnections<N, E> R(N n2) {
        NetworkConnections<N, E> f2 = this.f22638f.f(n2);
        if (f2 != null) {
            return f2;
        }
        Preconditions.E(n2);
        throw new IllegalArgumentException(String.format("Node %s is not an element of this graph.", new Object[]{n2}));
    }

    /* access modifiers changed from: package-private */
    public final N S(E e2) {
        N f2 = this.f22639g.f(e2);
        if (f2 != null) {
            return f2;
        }
        Preconditions.E(e2);
        throw new IllegalArgumentException(String.format("Edge %s is not an element of this graph.", new Object[]{e2}));
    }

    /* access modifiers changed from: package-private */
    public final boolean T(E e2) {
        return this.f22639g.e(e2);
    }

    /* access modifiers changed from: package-private */
    public final boolean U(N n2) {
        return this.f22638f.e(n2);
    }

    public Set<E> d() {
        return this.f22639g.k();
    }

    public boolean f() {
        return this.f22633a;
    }

    public ElementOrder<N> g() {
        return this.f22636d;
    }

    public boolean i() {
        return this.f22635c;
    }

    public Set<N> j(N n2) {
        return R(n2).a();
    }

    public Set<E> l(N n2) {
        return R(n2).e();
    }

    public Set<N> m() {
        return this.f22638f.k();
    }

    public Set<E> x(N n2) {
        return R(n2).i();
    }

    public Set<E> z(N n2, N n3) {
        NetworkConnections R = R(n2);
        if (!this.f22635c && n2 == n3) {
            return ImmutableSet.K();
        }
        Preconditions.u(U(n3), "Node %s is not an element of this graph.", n3);
        return R.k(n3);
    }

    StandardNetwork(NetworkBuilder<? super N, ? super E> networkBuilder, Map<N, NetworkConnections<N, E>> map, Map<E, N> map2) {
        this.f22633a = networkBuilder.f22580a;
        this.f22634b = networkBuilder.f22628f;
        this.f22635c = networkBuilder.f22581b;
        this.f22636d = networkBuilder.f22582c.a();
        this.f22637e = networkBuilder.f22629g.a();
        this.f22638f = map instanceof TreeMap ? new MapRetrievalCache<>(map) : new MapIteratorCache<>(map);
        this.f22639g = new MapIteratorCache<>(map2);
    }

    public Set<N> a(N n2) {
        return R(n2).c();
    }

    public Set<N> b(N n2) {
        return R(n2).b();
    }
}
