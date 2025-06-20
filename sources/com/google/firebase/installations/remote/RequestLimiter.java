package com.google.firebase.installations.remote;

import androidx.annotation.GuardedBy;
import com.google.firebase.installations.Utils;
import java.util.concurrent.TimeUnit;

class RequestLimiter {

    /* renamed from: d  reason: collision with root package name */
    private static final long f24601d = TimeUnit.HOURS.toMillis(24);

    /* renamed from: e  reason: collision with root package name */
    private static final long f24602e = TimeUnit.MINUTES.toMillis(30);

    /* renamed from: a  reason: collision with root package name */
    private final Utils f24603a;
    @GuardedBy("this")

    /* renamed from: b  reason: collision with root package name */
    private long f24604b;
    @GuardedBy("this")

    /* renamed from: c  reason: collision with root package name */
    private int f24605c;

    RequestLimiter() {
        this.f24603a = Utils.c();
    }

    private synchronized long a(int i2) {
        if (!c(i2)) {
            return f24601d;
        }
        return (long) Math.min(Math.pow(2.0d, (double) this.f24605c) + ((double) this.f24603a.e()), (double) f24602e);
    }

    private static boolean c(int i2) {
        return i2 == 429 || (i2 >= 500 && i2 < 600);
    }

    private static boolean d(int i2) {
        return (i2 >= 200 && i2 < 300) || i2 == 401 || i2 == 404;
    }

    private synchronized void e() {
        this.f24605c = 0;
    }

    public synchronized boolean b() {
        return this.f24605c == 0 || this.f24603a.a() > this.f24604b;
    }

    public synchronized void f(int i2) {
        if (d(i2)) {
            e();
            return;
        }
        this.f24605c++;
        this.f24604b = this.f24603a.a() + a(i2);
    }

    RequestLimiter(Utils utils) {
        this.f24603a = utils;
    }
}
