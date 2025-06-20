package com.google.common.reflect;

import com.google.common.base.Predicate;

public final /* synthetic */ class c implements Predicate {
    public final boolean apply(Object obj) {
        return ((Class) obj).isInterface();
    }
}
