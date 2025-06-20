package com.google.common.collect;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public final /* synthetic */ class z implements BiConsumer {
    public final /* synthetic */ Function X;
    public final /* synthetic */ Function Y;
    public final /* synthetic */ BinaryOperator Z;
    public final /* synthetic */ Function s;

    public /* synthetic */ z(Function function, Function function2, Function function3, BinaryOperator binaryOperator) {
        this.s = function;
        this.X = function2;
        this.Y = function3;
        this.Z = binaryOperator;
    }

    public final void accept(Object obj, Object obj2) {
        TableCollectors.q((Table) obj, this.s.apply(obj2), this.X.apply(obj2), this.Y.apply(obj2), this.Z);
    }
}
