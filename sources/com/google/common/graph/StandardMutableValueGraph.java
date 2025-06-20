package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Objects;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
final class StandardMutableValueGraph<N, V> extends StandardValueGraph<N, V> implements MutableValueGraph<N, V> {

    /* renamed from: f  reason: collision with root package name */
    private final ElementOrder<N> f22632f;

    StandardMutableValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        super(abstractGraphBuilder);
        this.f22632f = abstractGraphBuilder.f22583d.a();
    }

    @CanIgnoreReturnValue
    private GraphConnections<N, V> X(N n2) {
        GraphConnections<N, V> Y = Y();
        Preconditions.g0(this.f22643d.i(n2, Y) == null);
        return Y;
    }

    private GraphConnections<N, V> Y() {
        return f() ? DirectedGraphConnections.x(this.f22632f) : UndirectedGraphConnections.l(this.f22632f);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V J(EndpointPair<N> endpointPair, V v) {
        P(endpointPair);
        return L(endpointPair.g(), endpointPair.h(), v);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V L(N n2, N n3, V v) {
        Preconditions.F(n2, "nodeU");
        Preconditions.F(n3, "nodeV");
        Preconditions.F(v, "value");
        if (!i()) {
            Preconditions.u(!n2.equals(n3), "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", n2);
        }
        GraphConnections f2 = this.f22643d.f(n2);
        if (f2 == null) {
            f2 = X(n2);
        }
        V h2 = f2.h(n3, v);
        GraphConnections f3 = this.f22643d.f(n3);
        if (f3 == null) {
            f3 = X(n3);
        }
        f3.i(n2, v);
        if (h2 == null) {
            long j2 = this.f22644e + 1;
            this.f22644e = j2;
            Graphs.e(j2);
        }
        return h2;
    }

    public ElementOrder<N> o() {
        return this.f22632f;
    }

    @CanIgnoreReturnValue
    public boolean p(N n2) {
        Preconditions.F(n2, "node");
        if (U(n2)) {
            return false;
        }
        X(n2);
        return true;
    }

    @CanIgnoreReturnValue
    public boolean q(N n2) {
        Preconditions.F(n2, "node");
        GraphConnections f2 = this.f22643d.f(n2);
        if (f2 == null) {
            return false;
        }
        if (i() && f2.d(n2) != null) {
            f2.f(n2);
            this.f22644e--;
        }
        UnmodifiableIterator k2 = ImmutableList.B(f2.b()).iterator();
        while (k2.hasNext()) {
            Object next = k2.next();
            GraphConnections h2 = this.f22643d.h(next);
            Objects.requireNonNull(h2);
            h2.f(n2);
            Objects.requireNonNull(f2.d(next));
            this.f22644e--;
        }
        if (f()) {
            UnmodifiableIterator k3 = ImmutableList.B(f2.c()).iterator();
            while (k3.hasNext()) {
                Object next2 = k3.next();
                GraphConnections h3 = this.f22643d.h(next2);
                Objects.requireNonNull(h3);
                Preconditions.g0(h3.d(n2) != null);
                f2.f(next2);
                this.f22644e--;
            }
        }
        this.f22643d.j(n2);
        Graphs.c(this.f22644e);
        return true;
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V r(N n2, N n3) {
        Preconditions.F(n2, "nodeU");
        Preconditions.F(n3, "nodeV");
        GraphConnections f2 = this.f22643d.f(n2);
        GraphConnections f3 = this.f22643d.f(n3);
        if (f2 == null || f3 == null) {
            return null;
        }
        V d2 = f2.d(n3);
        if (d2 != null) {
            f3.f(n2);
            long j2 = this.f22644e - 1;
            this.f22644e = j2;
            Graphs.c(j2);
        }
        return d2;
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V s(EndpointPair<N> endpointPair) {
        P(endpointPair);
        return r(endpointPair.g(), endpointPair.h());
    }
}
