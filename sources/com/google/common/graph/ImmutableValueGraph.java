package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@Immutable(containerOf = {"N", "V"})
@Beta
public final class ImmutableValueGraph<N, V> extends StandardValueGraph<N, V> {

    public static class Builder<N, V> {

        /* renamed from: a  reason: collision with root package name */
        private final MutableValueGraph<N, V> f22621a;

        Builder(ValueGraphBuilder<N, V> valueGraphBuilder) {
            this.f22621a = valueGraphBuilder.d().i(ElementOrder.g()).b();
        }

        @CanIgnoreReturnValue
        public Builder<N, V> a(N n2) {
            this.f22621a.p(n2);
            return this;
        }

        public ImmutableValueGraph<N, V> b() {
            return ImmutableValueGraph.b0(this.f22621a);
        }

        @CanIgnoreReturnValue
        public Builder<N, V> c(EndpointPair<N> endpointPair, V v) {
            this.f22621a.J(endpointPair, v);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<N, V> d(N n2, N n3, V v) {
            this.f22621a.L(n2, n3, v);
            return this;
        }
    }

    private ImmutableValueGraph(ValueGraph<N, V> valueGraph) {
        super(ValueGraphBuilder.g(valueGraph), c0(valueGraph), (long) valueGraph.d().size());
    }

    private static <N, V> GraphConnections<N, V> Z(ValueGraph<N, V> valueGraph, N n2) {
        p pVar = new p(valueGraph, n2);
        return valueGraph.f() ? DirectedGraphConnections.y(n2, valueGraph.l(n2), pVar) : UndirectedGraphConnections.m(Maps.j(valueGraph.j(n2), pVar));
    }

    @Deprecated
    public static <N, V> ImmutableValueGraph<N, V> a0(ImmutableValueGraph<N, V> immutableValueGraph) {
        return (ImmutableValueGraph) Preconditions.E(immutableValueGraph);
    }

    public static <N, V> ImmutableValueGraph<N, V> b0(ValueGraph<N, V> valueGraph) {
        return valueGraph instanceof ImmutableValueGraph ? (ImmutableValueGraph) valueGraph : new ImmutableValueGraph<>(valueGraph);
    }

    private static <N, V> ImmutableMap<N, GraphConnections<N, V>> c0(ValueGraph<N, V> valueGraph) {
        ImmutableMap.Builder b2 = ImmutableMap.b();
        for (N next : valueGraph.m()) {
            b2.i(next, Z(valueGraph, next));
        }
        return b2.d();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object d0(ValueGraph valueGraph, Object obj, Object obj2) {
        Object C = valueGraph.C(obj, obj2, null);
        Objects.requireNonNull(C);
        return C;
    }

    @CheckForNull
    public /* bridge */ /* synthetic */ Object C(Object obj, Object obj2, @CheckForNull Object obj3) {
        return super.C(obj, obj2, obj3);
    }

    /* renamed from: Y */
    public ImmutableGraph<N> t() {
        return new ImmutableGraph<>(this);
    }

    public /* bridge */ /* synthetic */ Set a(Object obj) {
        return super.a(obj);
    }

    public /* bridge */ /* synthetic */ Set b(Object obj) {
        return super.b(obj);
    }

    public /* bridge */ /* synthetic */ boolean e(Object obj, Object obj2) {
        return super.e(obj, obj2);
    }

    public /* bridge */ /* synthetic */ boolean f() {
        return super.f();
    }

    public /* bridge */ /* synthetic */ ElementOrder g() {
        return super.g();
    }

    public /* bridge */ /* synthetic */ boolean i() {
        return super.i();
    }

    public /* bridge */ /* synthetic */ Set j(Object obj) {
        return super.j(obj);
    }

    public /* bridge */ /* synthetic */ boolean k(EndpointPair endpointPair) {
        return super.k(endpointPair);
    }

    public /* bridge */ /* synthetic */ Set l(Object obj) {
        return super.l(obj);
    }

    public /* bridge */ /* synthetic */ Set m() {
        return super.m();
    }

    public ElementOrder<N> o() {
        return ElementOrder.g();
    }

    @CheckForNull
    public /* bridge */ /* synthetic */ Object v(EndpointPair endpointPair, @CheckForNull Object obj) {
        return super.v(endpointPair, obj);
    }
}
