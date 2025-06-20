package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.util.AbstractSet;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class AbstractBaseGraph<N> implements BaseGraph<N> {
    AbstractBaseGraph() {
    }

    /* access modifiers changed from: protected */
    public long N() {
        long j2 = 0;
        for (Object c2 : m()) {
            j2 += (long) c(c2);
        }
        Preconditions.g0((1 & j2) == 0);
        return j2 >>> 1;
    }

    /* access modifiers changed from: protected */
    public final boolean O(EndpointPair<?> endpointPair) {
        return endpointPair.c() == f();
    }

    /* access modifiers changed from: protected */
    public final void P(EndpointPair<?> endpointPair) {
        Preconditions.E(endpointPair);
        Preconditions.e(O(endpointPair), "Mismatch: endpoints' ordering is not compatible with directionality of the graph");
    }

    public /* bridge */ /* synthetic */ Iterable a(Object obj) {
        return a(obj);
    }

    public /* bridge */ /* synthetic */ Iterable b(Object obj) {
        return b(obj);
    }

    public int c(N n2) {
        int i2;
        int size;
        if (f()) {
            size = a((Object) n2).size();
            i2 = b((Object) n2).size();
        } else {
            Set j2 = j(n2);
            i2 = (!i() || !j2.contains(n2)) ? 0 : 1;
            size = j2.size();
        }
        return IntMath.t(size, i2);
    }

    public Set<EndpointPair<N>> d() {
        return new AbstractSet<EndpointPair<N>>() {
            /* renamed from: b */
            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return EndpointPairIterator.e(AbstractBaseGraph.this);
            }

            public boolean contains(@CheckForNull Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair endpointPair = (EndpointPair) obj;
                return AbstractBaseGraph.this.O(endpointPair) && AbstractBaseGraph.this.m().contains(endpointPair.g()) && AbstractBaseGraph.this.b(endpointPair.g()).contains(endpointPair.h());
            }

            public boolean remove(@CheckForNull Object obj) {
                throw new UnsupportedOperationException();
            }

            public int size() {
                return Ints.z(AbstractBaseGraph.this.N());
            }
        };
    }

    public boolean e(N n2, N n3) {
        Preconditions.E(n2);
        Preconditions.E(n3);
        return m().contains(n2) && b((Object) n2).contains(n3);
    }

    public int h(N n2) {
        return f() ? b((Object) n2).size() : c(n2);
    }

    public boolean k(EndpointPair<N> endpointPair) {
        Preconditions.E(endpointPair);
        if (!O(endpointPair)) {
            return false;
        }
        N g2 = endpointPair.g();
        return m().contains(g2) && b((Object) g2).contains(endpointPair.h());
    }

    public Set<EndpointPair<N>> l(N n2) {
        Preconditions.E(n2);
        Preconditions.u(m().contains(n2), "Node %s is not an element of this graph.", n2);
        return new IncidentEdgeSet<N>(this, this, n2) {
            /* access modifiers changed from: private */
            public /* synthetic */ EndpointPair h(Object obj) {
                return EndpointPair.m(obj, this.s);
            }

            /* access modifiers changed from: private */
            public /* synthetic */ EndpointPair j(Object obj) {
                return EndpointPair.m(this.s, obj);
            }

            /* access modifiers changed from: private */
            public /* synthetic */ EndpointPair k(Object obj) {
                return EndpointPair.q(this.s, obj);
            }

            /* renamed from: g */
            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return Iterators.f0(this.X.f() ? Iterators.j(Iterators.c0(this.X.a((Object) this.s).iterator(), new a(this)), Iterators.c0(Sets.f(this.X.b((Object) this.s), ImmutableSet.L(this.s)).iterator(), new b(this))) : Iterators.c0(this.X.j(this.s).iterator(), new c(this)));
            }
        };
    }

    public int n(N n2) {
        return f() ? a((Object) n2).size() : c(n2);
    }

    public ElementOrder<N> o() {
        return ElementOrder.i();
    }
}
