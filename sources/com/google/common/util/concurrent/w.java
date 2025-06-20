package com.google.common.util.concurrent;

import com.google.common.base.Function;
import java.util.List;

public final /* synthetic */ class w implements Function {
    public final Object apply(Object obj) {
        return Boolean.valueOf(((List) obj).contains(Throwable.class));
    }
}
