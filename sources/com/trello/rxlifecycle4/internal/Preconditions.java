package com.trello.rxlifecycle4.internal;

public final class Preconditions {
    private Preconditions() {
        throw new AssertionError("No instances.");
    }

    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}
