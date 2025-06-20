package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Map;

public final /* synthetic */ class F implements Function {
    public final Object apply(Object obj) {
        return ((Map) obj).keySet().iterator();
    }
}
