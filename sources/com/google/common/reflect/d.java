package com.google.common.reflect;

import com.google.common.base.Function;
import com.google.common.reflect.Types;
import java.lang.reflect.Type;

public final /* synthetic */ class d implements Function {
    public final /* synthetic */ Types.JavaVersion s;

    public /* synthetic */ d(Types.JavaVersion javaVersion) {
        this.s = javaVersion;
    }

    public final Object apply(Object obj) {
        return this.s.e((Type) obj);
    }
}
