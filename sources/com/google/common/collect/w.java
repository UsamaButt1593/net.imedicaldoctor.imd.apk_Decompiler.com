package com.google.common.collect;

import com.google.common.collect.ImmutableTable;
import java.util.function.BinaryOperator;

public final /* synthetic */ class w implements BinaryOperator {
    public final Object apply(Object obj, Object obj2) {
        return ((ImmutableTable.Builder) obj).c((ImmutableTable.Builder) obj2);
    }
}
