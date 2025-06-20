package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@Beta
@ElementTypesAreNonnullByDefault
public abstract class AbstractNetwork<N, E> implements Network<N, E> {
    private Predicate<E> N(final N n2, final N n3) {
        return new Predicate<E>() {
            public boolean apply(E e2) {
                return AbstractNetwork.this.B(e2).b(n2).equals(n3);
            }
        };
    }

    private static <N, E> Map<E, EndpointPair<N>> O(Network<N, E> network) {
        return Maps.j(network.d(), new d(network));
    }

    @CheckForNull
    public E F(EndpointPair<N> endpointPair) {
        Q(endpointPair);
        return w(endpointPair.g(), endpointPair.h());
    }

    /* access modifiers changed from: protected */
    public final boolean P(EndpointPair<?> endpointPair) {
        return endpointPair.c() == f();
    }

    /* access modifiers changed from: protected */
    public final void Q(EndpointPair<?> endpointPair) {
        Preconditions.E(endpointPair);
        Preconditions.e(P(endpointPair), "Mismatch: endpoints' ordering is not compatible with directionality of the graph");
    }

    public /* bridge */ /* synthetic */ Iterable a(Object obj) {
        return a(obj);
    }

    public /* bridge */ /* synthetic */ Iterable b(Object obj) {
        return b(obj);
    }

    public int c(N n2) {
        int size;
        Set z;
        if (f()) {
            size = K(n2).size();
            z = x(n2);
        } else {
            size = l(n2).size();
            z = z(n2, n2);
        }
        return IntMath.t(size, z.size());
    }

    public boolean e(N n2, N n3) {
        Preconditions.E(n2);
        Preconditions.E(n3);
        return m().contains(n2) && b((Object) n2).contains(n3);
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Network)) {
            return false;
        }
        Network network = (Network) obj;
        return f() == network.f() && m().equals(network.m()) && O(this).equals(O(network));
    }

    public int h(N n2) {
        return f() ? x(n2).size() : c(n2);
    }

    public final int hashCode() {
        return O(this).hashCode();
    }

    public boolean k(EndpointPair<N> endpointPair) {
        Preconditions.E(endpointPair);
        if (!P(endpointPair)) {
            return false;
        }
        return e(endpointPair.g(), endpointPair.h());
    }

    public int n(N n2) {
        return f() ? K(n2).size() : c(n2);
    }

    public Graph<N> t() {
        return new AbstractGraph<N>() {
            public Set<EndpointPair<N>> d() {
                return AbstractNetwork.this.A() ? super.d() : new AbstractSet<EndpointPair<N>>() {
                    /* access modifiers changed from: private */
                    public /* synthetic */ EndpointPair c(Object obj) {
                        return AbstractNetwork.this.B(obj);
                    }

                    public boolean contains(@CheckForNull Object obj) {
                        if (!(obj instanceof EndpointPair)) {
                            return false;
                        }
                        EndpointPair endpointPair = (EndpointPair) obj;
                        return AnonymousClass1.this.O(endpointPair) && AnonymousClass1.this.m().contains(endpointPair.g()) && AnonymousClass1.this.b(endpointPair.g()).contains(endpointPair.h());
                    }

                    public Iterator<EndpointPair<N>> iterator() {
                        return Iterators.c0(AbstractNetwork.this.d().iterator(), new e(this));
                    }

                    public int size() {
                        return AbstractNetwork.this.d().size();
                    }
                };
            }

            public boolean f() {
                return AbstractNetwork.this.f();
            }

            public ElementOrder<N> g() {
                return AbstractNetwork.this.g();
            }

            public boolean i() {
                return AbstractNetwork.this.i();
            }

            public Set<N> j(N n2) {
                return AbstractNetwork.this.j(n2);
            }

            public Set<N> m() {
                return AbstractNetwork.this.m();
            }

            public ElementOrder<N> o() {
                return ElementOrder.i();
            }

            public Set<N> a(N n2) {
                return AbstractNetwork.this.a((Object) n2);
            }

            public Set<N> b(N n2) {
                return AbstractNetwork.this.b((Object) n2);
            }
        };
    }

    public String toString() {
        return "isDirected: " + f() + ", allowsParallelEdges: " + A() + ", allowsSelfLoops: " + i() + ", nodes: " + m() + ", edges: " + O(this);
    }

    public Set<E> u(EndpointPair<N> endpointPair) {
        Q(endpointPair);
        return z(endpointPair.g(), endpointPair.h());
    }

    @CheckForNull
    public E w(N n2, N n3) {
        Set z = z(n2, n3);
        int size = z.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return z.iterator().next();
        }
        throw new IllegalArgumentException(String.format("Cannot call edgeConnecting() when parallel edges exist between %s and %s. Consider calling edgesConnecting() instead.", new Object[]{n2, n3}));
    }

    public Set<E> y(E e2) {
        EndpointPair B = B(e2);
        return Sets.f(Sets.N(l(B.g()), l(B.h())), ImmutableSet.L(e2));
    }

    public Set<E> z(N n2, N n3) {
        Set x = x(n2);
        Set K = K(n3);
        return Collections.unmodifiableSet(x.size() <= K.size() ? Sets.i(x, N(n2, n3)) : Sets.i(K, N(n3, n2)));
    }
}
