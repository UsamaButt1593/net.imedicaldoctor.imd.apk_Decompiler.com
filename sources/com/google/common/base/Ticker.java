package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class Ticker {

    /* renamed from: a  reason: collision with root package name */
    private static final Ticker f22302a = new Ticker() {
        public long a() {
            return System.nanoTime();
        }
    };

    protected Ticker() {
    }

    public static Ticker b() {
        return f22302a;
    }

    public abstract long a();
}
