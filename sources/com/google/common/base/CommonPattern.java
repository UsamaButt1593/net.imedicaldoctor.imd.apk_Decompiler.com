package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class CommonPattern {
    CommonPattern() {
    }

    public static CommonPattern a(String str) {
        return Platform.a(str);
    }

    public static boolean c() {
        return Platform.h();
    }

    public abstract int b();

    public abstract CommonMatcher d(CharSequence charSequence);

    public abstract String e();

    public abstract String toString();
}
