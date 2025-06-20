package com.google.firebase.installations.time;

public class SystemClock implements Clock {

    /* renamed from: a  reason: collision with root package name */
    private static SystemClock f24606a;

    private SystemClock() {
    }

    public static SystemClock b() {
        if (f24606a == null) {
            f24606a = new SystemClock();
        }
        return f24606a;
    }

    public long a() {
        return System.currentTimeMillis();
    }
}
