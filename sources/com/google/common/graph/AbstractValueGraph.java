package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@Beta
@ElementTypesAreNonnullByDefault
public abstract class AbstractValueGraph<N, V> extends AbstractBaseGraph<N> implements ValueGraph<N, V> {
    private static <N, V> Map<EndpointPair<N>, V> R(ValueGraph<N, V> valueGraph) {
        return Maps.j(valueGraph.d(), new f(valueGraph));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object S(ValueGraph valueGraph, EndpointPair endpointPair) {
        Object C = valueGraph.C(endpointPair.g(), endpointPair.h(), null);
        Objects.requireNonNull(C);
        return C;
    }

    public /* bridge */ /* synthetic */ Iterable a(Object obj) {
        return a(obj);
    }

    public /* bridge */ /* synthetic */ Iterable b(Object obj) {
        return b(obj);
    }

    public /* bridge */ /* synthetic */ int c(Object obj) {
        return super.c(obj);
    }

    public /* bridge */ /* synthetic */ Set d() {
        return super.d();
    }

    public /* bridge */ /* synthetic */ boolean e(Object obj, Object obj2) {
        return super.e(obj, obj2);
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ValueGraph)) {
            return false;
        }
        ValueGraph valueGraph = (ValueGraph) obj;
        return f() == valueGraph.f() && m().equals(valueGraph.m()) && R(this).equals(R(valueGraph));
    }

    public /* bridge */ /* synthetic */ int h(Object obj) {
        return super.h(obj);
    }

    public final int hashCode() {
        return R(this).hashCode();
    }

    public /* bridge */ /* synthetic */ boolean k(EndpointPair endpointPair) {
        return super.k(endpointPair);
    }

    public /* bridge */ /* synthetic */ Set l(Object obj) {
        return super.l(obj);
    }

    public /* bridge */ /* synthetic */ int n(Object obj) {
        return super.n(obj);
    }

    public /* bridge */ /* synthetic */ ElementOrder o() {
        return super.o();
    }

    public Graph<N> t() {
        return new AbstractGraph<N>() {
            public int c(N n2) {
                return AbstractValueGraph.this.c(n2);
            }

            public Set<EndpointPair<N>> d() {
                return AbstractValueGraph.this.d();
            }

            public boolean f() {
                return AbstractValueGraph.this.f();
            }

            public ElementOrder<N> g() {
                return AbstractValueGraph.this.g();
            }

            public int h(N n2) {
                return AbstractValueGraph.this.h(n2);
            }

            public boolean i() {
                return AbstractValueGraph.this.i();
            }

            public Set<N> j(N n2) {
                return AbstractValueGraph.this.j(n2);
            }

            public Set<N> m() {
                return AbstractValueGraph.this.m();
            }

            public int n(N n2) {
                return AbstractValueGraph.this.n(n2);
            }

            public ElementOrder<N> o() {
                return AbstractValueGraph.this.o();
            }

            public Set<N> a(N n2) {
                return AbstractValueGraph.this.a((Object) n2);
            }

            public Set<N> b(N n2) {
                return AbstractValueGraph.this.b((Object) n2);
            }
        };
    }

    public String toString() {
        return "isDirected: " + f() + ", allowsSelfLoops: " + i() + ", nodes: " + m() + ", edges: " + R(this);
    }
}
