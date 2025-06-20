package com.google.common.collect;

import com.google.common.collect.ImmutableTable;
import java.util.function.BiConsumer;
import java.util.function.Function;

public final /* synthetic */ class v implements BiConsumer {
    public final /* synthetic */ Function X;
    public final /* synthetic */ Function Y;
    public final /* synthetic */ Function s;

    public /* synthetic */ v(Function function, Function function2, Function function3) {
        this.s = function;
        this.X = function2;
        this.Y = function3;
    }

    public final void accept(Object obj, Object obj2) {
        ((ImmutableTable.Builder) obj).g(this.s.apply(obj2), this.X.apply(obj2), this.Y.apply(obj2));
    }
}
