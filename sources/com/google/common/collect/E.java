package com.google.common.collect;

import com.google.common.collect.TableCollectors;
import java.util.function.Function;

public final /* synthetic */ class E implements Function {
    public final Object apply(Object obj) {
        return ((TableCollectors.ImmutableTableCollectorState) obj).c();
    }
}
