package com.google.common.reflect;

import com.google.common.base.Predicate;
import com.google.common.reflect.ClassPath;

public final /* synthetic */ class a implements Predicate {
    public final boolean apply(Object obj) {
        return ((ClassPath.ClassInfo) obj).j();
    }
}
