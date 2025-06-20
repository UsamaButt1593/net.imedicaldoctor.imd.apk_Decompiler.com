package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.util.Map;
import java.util.Set;

@ElementTypesAreNonnullByDefault
@Immutable(containerOf = {"N", "E"})
@Beta
public final class ImmutableNetwork<N, E> extends StandardNetwork<N, E> {

    public static class Builder<N, E> {

        /* renamed from: a  reason: collision with root package name */
        private final MutableNetwork<N, E> f22620a;

        Builder(NetworkBuilder<N, E> networkBuilder) {
            this.f22620a = networkBuilder.c();
        }

        @CanIgnoreReturnValue
        public Builder<N, E> a(EndpointPair<N> endpointPair, E e2) {
            this.f22620a.G(endpointPair, e2);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<N, E> b(N n2, N n3, E e2) {
            this.f22620a.M(n2, n3, e2);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<N, E> c(N n2) {
            this.f22620a.p(n2);
            return this;
        }

        public ImmutableNetwork<N, E> d() {
            return ImmutableNetwork.c0(this.f22620a);
        }
    }

    private ImmutableNetwork(Network<N, E> network) {
        super(NetworkBuilder.i(network), e0(network), d0(network));
    }

    private static <N, E> Function<E, N> Y(Network<N, E> network, N n2) {
        return new n(network, n2);
    }

    private static <N, E> NetworkConnections<N, E> a0(Network<N, E> network, N n2) {
        if (network.f()) {
            Map<K, V> j2 = Maps.j(network.K(n2), i0(network));
            Map<K, V> j3 = Maps.j(network.x(n2), j0(network));
            int size = network.z(n2, n2).size();
            return network.A() ? DirectedMultiNetworkConnections.q(j2, j3, size) : DirectedNetworkConnections.o(j2, j3, size);
        }
        Map<K, V> j4 = Maps.j(network.l(n2), Y(network, n2));
        return network.A() ? UndirectedMultiNetworkConnections.q(j4) : UndirectedNetworkConnections.n(j4);
    }

    @Deprecated
    public static <N, E> ImmutableNetwork<N, E> b0(ImmutableNetwork<N, E> immutableNetwork) {
        return (ImmutableNetwork) Preconditions.E(immutableNetwork);
    }

    public static <N, E> ImmutableNetwork<N, E> c0(Network<N, E> network) {
        return network instanceof ImmutableNetwork ? (ImmutableNetwork) network : new ImmutableNetwork<>(network);
    }

    private static <N, E> Map<E, N> d0(Network<N, E> network) {
        ImmutableMap.Builder b2 = ImmutableMap.b();
        for (E next : network.d()) {
            b2.i(next, network.B(next).g());
        }
        return b2.d();
    }

    private static <N, E> Map<N, NetworkConnections<N, E>> e0(Network<N, E> network) {
        ImmutableMap.Builder b2 = ImmutableMap.b();
        for (N next : network.m()) {
            b2.i(next, a0(network, next));
        }
        return b2.d();
    }

    private static <N, E> Function<E, N> i0(Network<N, E> network) {
        return new m(network);
    }

    private static <N, E> Function<E, N> j0(Network<N, E> network) {
        return new o(network);
    }

    public /* bridge */ /* synthetic */ boolean A() {
        return super.A();
    }

    public /* bridge */ /* synthetic */ EndpointPair B(Object obj) {
        return super.B(obj);
    }

    public /* bridge */ /* synthetic */ ElementOrder E() {
        return super.E();
    }

    public /* bridge */ /* synthetic */ Set K(Object obj) {
        return super.K(obj);
    }

    /* renamed from: Z */
    public ImmutableGraph<N> t() {
        return new ImmutableGraph<>(super.t());
    }

    public /* bridge */ /* synthetic */ Set a(Object obj) {
        return super.a(obj);
    }

    public /* bridge */ /* synthetic */ Set b(Object obj) {
        return super.b(obj);
    }

    public /* bridge */ /* synthetic */ Set d() {
        return super.d();
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

    public /* bridge */ /* synthetic */ Set l(Object obj) {
        return super.l(obj);
    }

    public /* bridge */ /* synthetic */ Set m() {
        return super.m();
    }

    public /* bridge */ /* synthetic */ Set x(Object obj) {
        return super.x(obj);
    }

    public /* bridge */ /* synthetic */ Set z(Object obj, Object obj2) {
        return super.z(obj, obj2);
    }
}
