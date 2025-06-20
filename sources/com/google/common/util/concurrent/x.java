package com.google.common.util.concurrent;

import com.google.common.base.Function;
import java.lang.reflect.Constructor;
import java.util.Arrays;

public final /* synthetic */ class x implements Function {
    public final Object apply(Object obj) {
        return Arrays.asList(((Constructor) obj).getParameterTypes());
    }
}
