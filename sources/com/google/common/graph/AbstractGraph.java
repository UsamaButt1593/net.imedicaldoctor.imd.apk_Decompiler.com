package com.google.common.graph;

import com.google.common.annotations.Beta;
import java.util.Set;
import javax.annotation.CheckForNull;

@Beta
@ElementTypesAreNonnullByDefault
public abstract class AbstractGraph<N> extends AbstractBaseGraph<N> implements Graph<N> {
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
        if (!(obj instanceof Graph)) {
            return false;
        }
        Graph graph = (Graph) obj;
        return f() == graph.f() && m().equals(graph.m()) && d().equals(graph.d());
    }

    public /* bridge */ /* synthetic */ int h(Object obj) {
        return super.h(obj);
    }

    public final int hashCode() {
        return d().hashCode();
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

    public String toString() {
        return "isDirected: " + f() + ", allowsSelfLoops: " + i() + ", nodes: " + m() + ", edges: " + d();
    }
}
