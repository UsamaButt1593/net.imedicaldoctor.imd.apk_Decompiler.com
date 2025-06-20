package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class CommonMatcher {
    CommonMatcher() {
    }

    public abstract int a();

    public abstract boolean b();

    public abstract boolean c(int i2);

    public abstract boolean d();

    public abstract String e(String str);

    public abstract int f();
}
