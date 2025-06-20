package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.Immutable;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@Immutable(containerOf = {"N"})
@Beta
public abstract class EndpointPair<N> implements Iterable<N> {
    private final N X;
    private final N s;

    private static final class Ordered<N> extends EndpointPair<N> {
        private Ordered(N n2, N n3) {
            super(n2, n3);
        }

        public boolean c() {
            return true;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            return c() == endpointPair.c() && n().equals(endpointPair.n()) && o().equals(endpointPair.o());
        }

        public int hashCode() {
            return Objects.b(n(), o());
        }

        public /* bridge */ /* synthetic */ Iterator iterator() {
            return EndpointPair.super.iterator();
        }

        public N n() {
            return g();
        }

        public N o() {
            return h();
        }

        public String toString() {
            return "<" + n() + " -> " + o() + ">";
        }
    }

    private static final class Unordered<N> extends EndpointPair<N> {
        private Unordered(N n2, N n3) {
            super(n2, n3);
        }

        public boolean c() {
            return false;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            if (c() != endpointPair.c()) {
                return false;
            }
            return g().equals(endpointPair.g()) ? h().equals(endpointPair.h()) : g().equals(endpointPair.h()) && h().equals(endpointPair.g());
        }

        public int hashCode() {
            return g().hashCode() + h().hashCode();
        }

        public /* bridge */ /* synthetic */ Iterator iterator() {
            return EndpointPair.super.iterator();
        }

        public N n() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        public N o() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        public String toString() {
            return "[" + g() + ", " + h() + "]";
        }
    }

    private EndpointPair(N n2, N n3) {
        this.s = Preconditions.E(n2);
        this.X = Preconditions.E(n3);
    }

    static <N> EndpointPair<N> j(Graph<?> graph, N n2, N n3) {
        return graph.f() ? m(n2, n3) : q(n2, n3);
    }

    static <N> EndpointPair<N> k(Network<?, ?> network, N n2, N n3) {
        return network.f() ? m(n2, n3) : q(n2, n3);
    }

    public static <N> EndpointPair<N> m(N n2, N n3) {
        return new Ordered(n2, n3);
    }

    public static <N> EndpointPair<N> q(N n2, N n3) {
        return new Unordered(n3, n2);
    }

    public final N b(N n2) {
        if (n2.equals(this.s)) {
            return this.X;
        }
        if (n2.equals(this.X)) {
            return this.s;
        }
        throw new IllegalArgumentException("EndpointPair " + this + " does not contain node " + n2);
    }

    public abstract boolean c();

    /* renamed from: d */
    public final UnmodifiableIterator<N> iterator() {
        return Iterators.B(this.s, this.X);
    }

    public abstract boolean equals(@CheckForNull Object obj);

    public final N g() {
        return this.s;
    }

    public final N h() {
        return this.X;
    }

    public abstract int hashCode();

    public abstract N n();

    public abstract N o();
}
