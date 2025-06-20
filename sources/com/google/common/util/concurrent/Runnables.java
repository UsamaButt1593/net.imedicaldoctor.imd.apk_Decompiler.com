package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class Runnables {

    /* renamed from: a  reason: collision with root package name */
    private static final Runnable f23202a = new Runnable() {
        public void run() {
        }
    };

    private Runnables() {
    }

    public static Runnable a() {
        return f23202a;
    }
}
