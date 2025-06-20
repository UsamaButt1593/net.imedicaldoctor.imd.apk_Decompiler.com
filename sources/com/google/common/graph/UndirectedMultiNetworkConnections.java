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
final class UndirectedMultiNetworkConnections<N, E> extends AbstractUndirectedNetworkConnections<N, E> {
    @CheckForNull
    @LazyInit

    /* renamed from: b  reason: collision with root package name */
    private transient Reference<Multiset<N>> f22652b;

    private UndirectedMultiNetworkConnections(Map<E, N> map) {
        super(map);
    }

    /* access modifiers changed from: private */
    public Multiset<N> n() {
        Multiset<N> multiset = (Multiset) o(this.f22652b);
        if (multiset != null) {
            return multiset;
        }
        HashMultiset<N> r = HashMultiset.r(this.f22586a.values());
        this.f22652b = new SoftReference(r);
        return r;
    }

    @CheckForNull
    private static <T> T o(@CheckForNull Reference<T> reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    static <N, E> UndirectedMultiNetworkConnections<N, E> p() {
        return new UndirectedMultiNetworkConnections<>(new HashMap(2, 1.0f));
    }

    static <N, E> UndirectedMultiNetworkConnections<N, E> q(Map<E, N> map) {
        return new UndirectedMultiNetworkConnections<>(ImmutableMap.g(map));
    }

    public Set<N> a() {
        return Collections.unmodifiableSet(n().e());
    }

    @CheckForNull
    public N d(E e2, boolean z) {
        if (!z) {
            return h(e2);
        }
        return null;
    }

    public N h(E e2) {
        N h2 = super.h(e2);
        Multiset multiset = (Multiset) o(this.f22652b);
        if (multiset != null) {
            Preconditions.g0(multiset.remove(h2));
        }
        return h2;
    }

    public void j(E e2, N n2) {
        super.j(e2, n2);
        Multiset multiset = (Multiset) o(this.f22652b);
        if (multiset != null) {
            Preconditions.g0(multiset.add(n2));
        }
    }

    public Set<E> k(final N n2) {
        return new MultiEdgesConnecting<E>(this.f22586a, n2) {
            public int size() {
                return UndirectedMultiNetworkConnections.this.n().l1(n2);
            }
        };
    }

    public void l(E e2, N n2, boolean z) {
        if (!z) {
            j(e2, n2);
        }
    }
}
