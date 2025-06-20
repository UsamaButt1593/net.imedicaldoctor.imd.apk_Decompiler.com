package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class AbstractUndirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {

    /* renamed from: a  reason: collision with root package name */
    final Map<E, N> f22586a;

    AbstractUndirectedNetworkConnections(Map<E, N> map) {
        this.f22586a = (Map) Preconditions.E(map);
    }

    public Set<N> b() {
        return a();
    }

    public Set<N> c() {
        return a();
    }

    @CheckForNull
    public N d(E e2, boolean z) {
        if (!z) {
            return h(e2);
        }
        return null;
    }

    public Set<E> e() {
        return Collections.unmodifiableSet(this.f22586a.keySet());
    }

    public N f(E e2) {
        N n2 = this.f22586a.get(e2);
        Objects.requireNonNull(n2);
        return n2;
    }

    public Set<E> g() {
        return e();
    }

    public N h(E e2) {
        N remove = this.f22586a.remove(e2);
        Objects.requireNonNull(remove);
        return remove;
    }

    public Set<E> i() {
        return e();
    }

    public void j(E e2, N n2) {
        Preconditions.g0(this.f22586a.put(e2, n2) == null);
    }

    public void l(E e2, N n2, boolean z) {
        if (!z) {
            j(e2, n2);
        }
    }
}
