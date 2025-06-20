package com.google.common.collect;

import com.google.common.collect.TableCollectors;
import java.util.function.BinaryOperator;

public final /* synthetic */ class D implements BinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BinaryOperator f22381a;

    public /* synthetic */ D(BinaryOperator binaryOperator) {
        this.f22381a = binaryOperator;
    }

    public final Object apply(Object obj, Object obj2) {
        return ((TableCollectors.ImmutableTableCollectorState) obj).a((TableCollectors.ImmutableTableCollectorState) obj2, this.f22381a);
    }
}
