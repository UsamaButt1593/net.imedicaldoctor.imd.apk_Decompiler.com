package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@Beta
@ElementTypesAreNonnullByDefault
public final class Graphs {

    private enum NodeVisitState {
        PENDING,
        COMPLETE
    }

    private static class TransposedGraph<N> extends ForwardingGraph<N> {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final Graph<N> f22615a;

        TransposedGraph(Graph<N> graph) {
            this.f22615a = graph;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: S */
        public Graph<N> Q() {
            return this.f22615a;
        }

        public boolean e(N n2, N n3) {
            return Q().e(n3, n2);
        }

        public int h(N n2) {
            return Q().n(n2);
        }

        public boolean k(EndpointPair<N> endpointPair) {
            return Q().k(Graphs.q(endpointPair));
        }

        public Set<EndpointPair<N>> l(N n2) {
            return new IncidentEdgeSet<N>(this, n2) {
                /* access modifiers changed from: private */
                public /* synthetic */ EndpointPair c(EndpointPair endpointPair) {
                    return EndpointPair.j(TransposedGraph.this.Q(), endpointPair.h(), endpointPair.g());
                }

                public Iterator<EndpointPair<N>> iterator() {
                    return Iterators.c0(TransposedGraph.this.Q().l(this.s).iterator(), new l(this));
                }
            };
        }

        public int n(N n2) {
            return Q().h(n2);
        }

        public Set<N> a(N n2) {
            return Q().b((Object) n2);
        }

        public Set<N> b(N n2) {
            return Q().a((Object) n2);
        }
    }

    private static class TransposedNetwork<N, E> extends ForwardingNetwork<N, E> {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final Network<N, E> f22616a;

        TransposedNetwork(Network<N, E> network) {
            this.f22616a = network;
        }

        public EndpointPair<N> B(E e2) {
            EndpointPair B = R().B(e2);
            return EndpointPair.k(this.f22616a, B.h(), B.g());
        }

        @CheckForNull
        public E F(EndpointPair<N> endpointPair) {
            return R().F(Graphs.q(endpointPair));
        }

        public Set<E> K(N n2) {
            return R().x(n2);
        }

        /* access modifiers changed from: package-private */
        public Network<N, E> R() {
            return this.f22616a;
        }

        public boolean e(N n2, N n3) {
            return R().e(n3, n2);
        }

        public int h(N n2) {
            return R().n(n2);
        }

        public boolean k(EndpointPair<N> endpointPair) {
            return R().k(Graphs.q(endpointPair));
        }

        public int n(N n2) {
            return R().h(n2);
        }

        public Set<E> u(EndpointPair<N> endpointPair) {
            return R().u(Graphs.q(endpointPair));
        }

        @CheckForNull
        public E w(N n2, N n3) {
            return R().w(n3, n2);
        }

        public Set<E> x(N n2) {
            return R().K(n2);
        }

        public Set<E> z(N n2, N n3) {
            return R().z(n3, n2);
        }

        public Set<N> a(N n2) {
            return R().b((Object) n2);
        }

        public Set<N> b(N n2) {
            return R().a((Object) n2);
        }
    }

    private static class TransposedValueGraph<N, V> extends ForwardingValueGraph<N, V> {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final ValueGraph<N, V> f22617a;

        TransposedValueGraph(ValueGraph<N, V> valueGraph) {
            this.f22617a = valueGraph;
        }

        @CheckForNull
        public V C(N n2, N n3, @CheckForNull V v) {
            return T().C(n3, n2, v);
        }

        /* access modifiers changed from: package-private */
        public ValueGraph<N, V> T() {
            return this.f22617a;
        }

        public boolean e(N n2, N n3) {
            return T().e(n3, n2);
        }

        public int h(N n2) {
            return T().n(n2);
        }

        public boolean k(EndpointPair<N> endpointPair) {
            return T().k(Graphs.q(endpointPair));
        }

        public int n(N n2) {
            return T().h(n2);
        }

        @CheckForNull
        public V v(EndpointPair<N> endpointPair, @CheckForNull V v) {
            return T().v(Graphs.q(endpointPair), v);
        }

        public Set<N> a(N n2) {
            return T().b((Object) n2);
        }

        public Set<N> b(N n2) {
            return T().a((Object) n2);
        }
    }

    private Graphs() {
    }

    private static boolean a(Graph<?> graph, Object obj, @CheckForNull Object obj2) {
        return graph.f() || !Objects.a(obj2, obj);
    }

    @CanIgnoreReturnValue
    static int b(int i2) {
        Preconditions.k(i2 >= 0, "Not true that %s is non-negative.", i2);
        return i2;
    }

    @CanIgnoreReturnValue
    static long c(long j2) {
        Preconditions.p(j2 >= 0, "Not true that %s is non-negative.", j2);
        return j2;
    }

    @CanIgnoreReturnValue
    static int d(int i2) {
        Preconditions.k(i2 > 0, "Not true that %s is positive.", i2);
        return i2;
    }

    @CanIgnoreReturnValue
    static long e(long j2) {
        Preconditions.p(j2 > 0, "Not true that %s is positive.", j2);
        return j2;
    }

    public static <N> MutableGraph<N> f(Graph<N> graph) {
        MutableGraph<N1> b2 = GraphBuilder.g(graph).f(graph.m().size()).b();
        for (N p : graph.m()) {
            b2.p(p);
        }
        for (EndpointPair next : graph.d()) {
            b2.D(next.g(), next.h());
        }
        return b2;
    }

    public static <N, E> MutableNetwork<N, E> g(Network<N, E> network) {
        MutableNetwork<N1, E1> c2 = NetworkBuilder.i(network).h(network.m().size()).g(network.d().size()).c();
        for (N p : network.m()) {
            c2.p(p);
        }
        for (E next : network.d()) {
            EndpointPair<N> B = network.B(next);
            c2.M(B.g(), B.h(), next);
        }
        return c2;
    }

    public static <N, V> MutableValueGraph<N, V> h(ValueGraph<N, V> valueGraph) {
        MutableValueGraph<N1, V1> b2 = ValueGraphBuilder.g(valueGraph).f(valueGraph.m().size()).b();
        for (N p : valueGraph.m()) {
            b2.p(p);
        }
        for (EndpointPair next : valueGraph.d()) {
            Object g2 = next.g();
            Object h2 = next.h();
            V C = valueGraph.C(next.g(), next.h(), null);
            java.util.Objects.requireNonNull(C);
            b2.L(g2, h2, C);
        }
        return b2;
    }

    public static <N> boolean i(Graph<N> graph) {
        int size = graph.d().size();
        if (size == 0) {
            return false;
        }
        if (!graph.f() && size >= graph.m().size()) {
            return true;
        }
        HashMap a0 = Maps.a0(graph.m().size());
        for (N o : graph.m()) {
            if (o(graph, a0, o, (N) null)) {
                return true;
            }
        }
        return false;
    }

    public static boolean j(Network<?, ?> network) {
        if (network.f() || !network.A() || network.d().size() <= network.t().d().size()) {
            return i(network.t());
        }
        return true;
    }

    public static <N> MutableGraph<N> k(Graph<N> graph, Iterable<? extends N> iterable) {
        MutableGraph<N1> b2 = (iterable instanceof Collection ? GraphBuilder.g(graph).f(((Collection) iterable).size()) : GraphBuilder.g(graph)).b();
        for (Object p : iterable) {
            b2.p(p);
        }
        for (N1 next : b2.m()) {
            for (Object next2 : graph.b((Object) next)) {
                if (b2.m().contains(next2)) {
                    b2.D(next, next2);
                }
            }
        }
        return b2;
    }

    public static <N, E> MutableNetwork<N, E> l(Network<N, E> network, Iterable<? extends N> iterable) {
        MutableNetwork<N1, E1> c2 = (iterable instanceof Collection ? NetworkBuilder.i(network).h(((Collection) iterable).size()) : NetworkBuilder.i(network)).c();
        for (Object p : iterable) {
            c2.p(p);
        }
        for (N1 next : c2.m()) {
            for (E next2 : network.x(next)) {
                N b2 = network.B(next2).b(next);
                if (c2.m().contains(b2)) {
                    c2.M(next, b2, next2);
                }
            }
        }
        return c2;
    }

    public static <N, V> MutableValueGraph<N, V> m(ValueGraph<N, V> valueGraph, Iterable<? extends N> iterable) {
        MutableValueGraph<N1, V1> b2 = (iterable instanceof Collection ? ValueGraphBuilder.g(valueGraph).f(((Collection) iterable).size()) : ValueGraphBuilder.g(valueGraph)).b();
        for (Object p : iterable) {
            b2.p(p);
        }
        for (N1 next : b2.m()) {
            for (Object next2 : valueGraph.b((Object) next)) {
                if (b2.m().contains(next2)) {
                    V C = valueGraph.C(next, next2, null);
                    java.util.Objects.requireNonNull(C);
                    b2.L(next, next2, C);
                }
            }
        }
        return b2;
    }

    public static <N> Set<N> n(Graph<N> graph, N n2) {
        Preconditions.u(graph.m().contains(n2), "Node %s is not an element of this graph.", n2);
        return ImmutableSet.B(Traverser.g(graph).b(n2));
    }

    private static <N> boolean o(Graph<N> graph, Map<Object, NodeVisitState> map, N n2, @CheckForNull N n3) {
        NodeVisitState nodeVisitState = map.get(n2);
        if (nodeVisitState == NodeVisitState.COMPLETE) {
            return false;
        }
        NodeVisitState nodeVisitState2 = NodeVisitState.PENDING;
        if (nodeVisitState == nodeVisitState2) {
            return true;
        }
        map.put(n2, nodeVisitState2);
        for (Object next : graph.b((Object) n2)) {
            if (a(graph, next, n3) && o(graph, map, next, n2)) {
                return true;
            }
        }
        map.put(n2, NodeVisitState.COMPLETE);
        return false;
    }

    public static <N> Graph<N> p(Graph<N> graph) {
        MutableGraph<N1> b2 = GraphBuilder.g(graph).a(true).b();
        if (graph.f()) {
            for (N next : graph.m()) {
                for (N D : n(graph, next)) {
                    b2.D(next, D);
                }
            }
        } else {
            HashSet hashSet = new HashSet();
            for (N next2 : graph.m()) {
                if (!hashSet.contains(next2)) {
                    Set<N> n2 = n(graph, next2);
                    hashSet.addAll(n2);
                    int i2 = 1;
                    for (N next3 : n2) {
                        int i3 = i2 + 1;
                        for (T D2 : Iterables.D(n2, i2)) {
                            b2.D(next3, D2);
                        }
                        i2 = i3;
                    }
                }
            }
        }
        return b2;
    }

    static <N> EndpointPair<N> q(EndpointPair<N> endpointPair) {
        return endpointPair.c() ? EndpointPair.m(endpointPair.o(), endpointPair.n()) : endpointPair;
    }

    public static <N> Graph<N> r(Graph<N> graph) {
        if (!graph.f()) {
            return graph;
        }
        return graph instanceof TransposedGraph ? ((TransposedGraph) graph).f22615a : new TransposedGraph(graph);
    }

    public static <N, E> Network<N, E> s(Network<N, E> network) {
        if (!network.f()) {
            return network;
        }
        return network instanceof TransposedNetwork ? ((TransposedNetwork) network).f22616a : new TransposedNetwork(network);
    }

    public static <N, V> ValueGraph<N, V> t(ValueGraph<N, V> valueGraph) {
        if (!valueGraph.f()) {
            return valueGraph;
        }
        return valueGraph instanceof TransposedValueGraph ? ((TransposedValueGraph) valueGraph).f22617a : new TransposedValueGraph(valueGraph);
    }
}
