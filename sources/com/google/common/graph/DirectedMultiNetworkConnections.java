package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
final class DirectedMultiNetworkConnections<N, E> extends AbstractDirectedNetworkConnections<N, E> {
    @CheckForNull
    @LazyInit

    /* renamed from: d  reason: collision with root package name */
    private transient Reference<Multiset<N>> f22596d;
    @CheckForNull
    @LazyInit

    /* renamed from: e  reason: collision with root package name */
    private transient Reference<Multiset<N>> f22597e;

    private DirectedMultiNetworkConnections(Map<E, N> map, Map<E, N> map2, int i2) {
        super(map, map2, i2);
    }

    @CheckForNull
    private static <T> T o(@CheckForNull Reference<T> reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    static <N, E> DirectedMultiNetworkConnections<N, E> p() {
        return new DirectedMultiNetworkConnections<>(new HashMap(2, 1.0f), new HashMap(2, 1.0f), 0);
    }

    static <N, E> DirectedMultiNetworkConnections<N, E> q(Map<E, N> map, Map<E, N> map2, int i2) {
        return new DirectedMultiNetworkConnections<>(ImmutableMap.g(map), ImmutableMap.g(map2), i2);
    }

    private Multiset<N> r() {
        Multiset<N> multiset = (Multiset) o(this.f22596d);
        if (multiset != null) {
            return multiset;
        }
        HashMultiset<N> r = HashMultiset.r(this.f22577a.values());
        this.f22596d = new SoftReference(r);
        return r;
    }

    /* access modifiers changed from: private */
    public Multiset<N> s() {
        Multiset<N> multiset = (Multiset) o(this.f22597e);
        if (multiset != null) {
            return multiset;
        }
        HashMultiset<N> r = HashMultiset.r(this.f22578b.values());
        this.f22597e = new SoftReference(r);
        return r;
    }

    public Set<N> b() {
        return Collections.unmodifiableSet(s().e());
    }

    public Set<N> c() {
        return Collections.unmodifiableSet(r().e());
    }

    public N d(E e2, boolean z) {
        N d2 = super.d(e2, z);
        Multiset multiset = (Multiset) o(this.f22596d);
        if (multiset != null) {
            Preconditions.g0(multiset.remove(d2));
        }
        return d2;
    }

    public N h(E e2) {
        N h2 = super.h(e2);
        Multiset multiset = (Multiset) o(this.f22597e);
        if (multiset != null) {
            Preconditions.g0(multiset.remove(h2));
        }
        return h2;
    }

    public void j(E e2, N n2) {
        super.j(e2, n2);
        Multiset multiset = (Multiset) o(this.f22597e);
        if (multiset != null) {
            Preconditions.g0(multiset.add(n2));
        }
    }

    public Set<E> k(final N n2) {
        return new MultiEdgesConnecting<E>(this.f22578b, n2) {
            public int size() {
                return DirectedMultiNetworkConnections.this.s().l1(n2);
            }
        };
    }

    public void l(E e2, N n2, boolean z) {
        super.l(e2, n2, z);
        Multiset multiset = (Multiset) o(this.f22596d);
        if (multiset != null) {
            Preconditions.g0(multiset.add(n2));
        }
    }
}
