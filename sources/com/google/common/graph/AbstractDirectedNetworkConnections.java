package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class AbstractDirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {

    /* renamed from: a  reason: collision with root package name */
    final Map<E, N> f22577a;

    /* renamed from: b  reason: collision with root package name */
    final Map<E, N> f22578b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f22579c;

    AbstractDirectedNetworkConnections(Map<E, N> map, Map<E, N> map2, int i2) {
        this.f22577a = (Map) Preconditions.E(map);
        this.f22578b = (Map) Preconditions.E(map2);
        this.f22579c = Graphs.b(i2);
        Preconditions.g0(i2 <= map.size() && i2 <= map2.size());
    }

    public Set<N> a() {
        return Sets.N(c(), b());
    }

    public N d(E e2, boolean z) {
        if (z) {
            int i2 = this.f22579c - 1;
            this.f22579c = i2;
            Graphs.b(i2);
        }
        N remove = this.f22577a.remove(e2);
        Objects.requireNonNull(remove);
        return remove;
    }

    public Set<E> e() {
        return new AbstractSet<E>() {
            /* renamed from: b */
            public UnmodifiableIterator<E> iterator() {
                return Iterators.f0((AbstractDirectedNetworkConnections.this.f22579c == 0 ? Iterables.f(AbstractDirectedNetworkConnections.this.f22577a.keySet(), AbstractDirectedNetworkConnections.this.f22578b.keySet()) : Sets.N(AbstractDirectedNetworkConnections.this.f22577a.keySet(), AbstractDirectedNetworkConnections.this.f22578b.keySet())).iterator());
            }

            public boolean contains(@CheckForNull Object obj) {
                return AbstractDirectedNetworkConnections.this.f22577a.containsKey(obj) || AbstractDirectedNetworkConnections.this.f22578b.containsKey(obj);
            }

            public int size() {
                return IntMath.t(AbstractDirectedNetworkConnections.this.f22577a.size(), AbstractDirectedNetworkConnections.this.f22578b.size() - AbstractDirectedNetworkConnections.this.f22579c);
            }
        };
    }

    public N f(E e2) {
        N n2 = this.f22578b.get(e2);
        Objects.requireNonNull(n2);
        return n2;
    }

    public Set<E> g() {
        return Collections.unmodifiableSet(this.f22577a.keySet());
    }

    public N h(E e2) {
        N remove = this.f22578b.remove(e2);
        Objects.requireNonNull(remove);
        return remove;
    }

    public Set<E> i() {
        return Collections.unmodifiableSet(this.f22578b.keySet());
    }

    public void j(E e2, N n2) {
        Preconditions.E(e2);
        Preconditions.E(n2);
        Preconditions.g0(this.f22578b.put(e2, n2) == null);
    }

    public void l(E e2, N n2, boolean z) {
        Preconditions.E(e2);
        Preconditions.E(n2);
        boolean z2 = true;
        if (z) {
            int i2 = this.f22579c + 1;
            this.f22579c = i2;
            Graphs.d(i2);
        }
        if (this.f22577a.put(e2, n2) != null) {
            z2 = false;
        }
        Preconditions.g0(z2);
    }
}
