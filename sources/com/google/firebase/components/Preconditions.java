package com.google.firebase.components;

import com.google.errorprone.annotations.CanIgnoreReturnValue;

public final class Preconditions {
    public static void a(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    @CanIgnoreReturnValue
    public static <T> T b(T t) {
        t.getClass();
        return t;
    }

    @CanIgnoreReturnValue
    public static <T> T c(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static void d(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }
}
