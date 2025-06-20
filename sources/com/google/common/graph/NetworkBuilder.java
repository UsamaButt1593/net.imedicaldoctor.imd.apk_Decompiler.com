package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.graph.ImmutableNetwork;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@Beta
@ElementTypesAreNonnullByDefault
public final class NetworkBuilder<N, E> extends AbstractGraphBuilder<N> {

    /* renamed from: f  reason: collision with root package name */
    boolean f22628f = false;

    /* renamed from: g  reason: collision with root package name */
    ElementOrder<? super E> f22629g = ElementOrder.d();

    /* renamed from: h  reason: collision with root package name */
    Optional<Integer> f22630h = Optional.a();

    private NetworkBuilder(boolean z) {
        super(z);
    }

    private <N1 extends N, E1 extends E> NetworkBuilder<N1, E1> d() {
        return this;
    }

    public static NetworkBuilder<Object, Object> e() {
        return new NetworkBuilder<>(true);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.common.graph.Network<N, E>, com.google.common.graph.Network] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <N, E> com.google.common.graph.NetworkBuilder<N, E> i(com.google.common.graph.Network<N, E> r2) {
        /*
            com.google.common.graph.NetworkBuilder r0 = new com.google.common.graph.NetworkBuilder
            boolean r1 = r2.f()
            r0.<init>(r1)
            boolean r1 = r2.A()
            com.google.common.graph.NetworkBuilder r0 = r0.a(r1)
            boolean r1 = r2.i()
            com.google.common.graph.NetworkBuilder r0 = r0.b(r1)
            com.google.common.graph.ElementOrder r1 = r2.g()
            com.google.common.graph.NetworkBuilder r0 = r0.k(r1)
            com.google.common.graph.ElementOrder r2 = r2.E()
            com.google.common.graph.NetworkBuilder r2 = r0.f(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.NetworkBuilder.i(com.google.common.graph.Network):com.google.common.graph.NetworkBuilder");
    }

    public static NetworkBuilder<Object, Object> l() {
        return new NetworkBuilder<>(false);
    }

    @CanIgnoreReturnValue
    public NetworkBuilder<N, E> a(boolean z) {
        this.f22628f = z;
        return this;
    }

    @CanIgnoreReturnValue
    public NetworkBuilder<N, E> b(boolean z) {
        this.f22581b = z;
        return this;
    }

    public <N1 extends N, E1 extends E> MutableNetwork<N1, E1> c() {
        return new StandardMutableNetwork(this);
    }

    public <E1 extends E> NetworkBuilder<N, E1> f(ElementOrder<E1> elementOrder) {
        NetworkBuilder<N, E1> d2 = d();
        d2.f22629g = (ElementOrder) Preconditions.E(elementOrder);
        return d2;
    }

    @CanIgnoreReturnValue
    public NetworkBuilder<N, E> g(int i2) {
        this.f22630h = Optional.f(Integer.valueOf(Graphs.b(i2)));
        return this;
    }

    @CanIgnoreReturnValue
    public NetworkBuilder<N, E> h(int i2) {
        this.f22584e = Optional.f(Integer.valueOf(Graphs.b(i2)));
        return this;
    }

    public <N1 extends N, E1 extends E> ImmutableNetwork.Builder<N1, E1> j() {
        return new ImmutableNetwork.Builder<>(d());
    }

    public <N1 extends N> NetworkBuilder<N1, E> k(ElementOrder<N1> elementOrder) {
        NetworkBuilder<N1, E> d2 = d();
        d2.f22582c = (ElementOrder) Preconditions.E(elementOrder);
        return d2;
    }
}
