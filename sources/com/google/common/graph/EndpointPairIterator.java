package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class EndpointPairIterator<N> extends AbstractIterator<EndpointPair<N>> {
    @CheckForNull
    N X2;
    private final BaseGraph<N> Y;
    Iterator<N> Y2;
    private final Iterator<N> Z;

    private static final class Directed<N> extends EndpointPairIterator<N> {
        private Directed(BaseGraph<N> baseGraph) {
            super(baseGraph);
        }

        /* access modifiers changed from: protected */
        @CheckForNull
        /* renamed from: f */
        public EndpointPair<N> a() {
            while (!this.Y2.hasNext()) {
                if (!d()) {
                    return (EndpointPair) b();
                }
            }
            N n2 = this.X2;
            Objects.requireNonNull(n2);
            return EndpointPair.m(n2, this.Y2.next());
        }
    }

    private static final class Undirected<N> extends EndpointPairIterator<N> {
        @CheckForNull
        private Set<N> Z2;

        private Undirected(BaseGraph<N> baseGraph) {
            super(baseGraph);
            this.Z2 = Sets.y(baseGraph.m().size() + 1);
        }

        /* access modifiers changed from: protected */
        @CheckForNull
        /* renamed from: f */
        public EndpointPair<N> a() {
            do {
                Objects.requireNonNull(this.Z2);
                while (this.Y2.hasNext()) {
                    N next = this.Y2.next();
                    if (!this.Z2.contains(next)) {
                        N n2 = this.X2;
                        Objects.requireNonNull(n2);
                        return EndpointPair.q(n2, next);
                    }
                }
                this.Z2.add(this.X2);
            } while (d());
            this.Z2 = null;
            return (EndpointPair) b();
        }
    }

    private EndpointPairIterator(BaseGraph<N> baseGraph) {
        this.X2 = null;
        this.Y2 = ImmutableSet.K().iterator();
        this.Y = baseGraph;
        this.Z = baseGraph.m().iterator();
    }

    static <N> EndpointPairIterator<N> e(BaseGraph<N> baseGraph) {
        return baseGraph.f() ? new Directed(baseGraph) : new Undirected(baseGraph);
    }

    /* access modifiers changed from: package-private */
    public final boolean d() {
        Preconditions.g0(!this.Y2.hasNext());
        if (!this.Z.hasNext()) {
            return false;
        }
        N next = this.Z.next();
        this.X2 = next;
        this.Y2 = this.Y.b((Object) next).iterator();
        return true;
    }
}
