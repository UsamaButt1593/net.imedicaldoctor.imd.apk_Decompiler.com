package com.google.common.graph;

import com.google.common.base.Optional;

@ElementTypesAreNonnullByDefault
abstract class AbstractGraphBuilder<N> {

    /* renamed from: a  reason: collision with root package name */
    final boolean f22580a;

    /* renamed from: b  reason: collision with root package name */
    boolean f22581b = false;

    /* renamed from: c  reason: collision with root package name */
    ElementOrder<N> f22582c = ElementOrder.d();

    /* renamed from: d  reason: collision with root package name */
    ElementOrder<N> f22583d = ElementOrder.i();

    /* renamed from: e  reason: collision with root package name */
    Optional<Integer> f22584e = Optional.a();

    AbstractGraphBuilder(boolean z) {
        this.f22580a = z;
    }
}
