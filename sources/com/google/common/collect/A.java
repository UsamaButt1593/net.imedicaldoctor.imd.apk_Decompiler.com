package com.google.common.collect;

import java.util.function.BinaryOperator;

public final /* synthetic */ class A implements BinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BinaryOperator f22362a;

    public /* synthetic */ A(BinaryOperator binaryOperator) {
        this.f22362a = binaryOperator;
    }

    public final Object apply(Object obj, Object obj2) {
        return TableCollectors.p(this.f22362a, (Table) obj, (Table) obj2);
    }
}
