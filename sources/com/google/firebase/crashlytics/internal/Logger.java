package com.google.firebase.crashlytics.internal;

import android.util.Log;

public class Logger {

    /* renamed from: c  reason: collision with root package name */
    public static final String f23504c = "FirebaseCrashlytics";

    /* renamed from: d  reason: collision with root package name */
    static final Logger f23505d = new Logger(f23504c);

    /* renamed from: a  reason: collision with root package name */
    private final String f23506a;

    /* renamed from: b  reason: collision with root package name */
    private int f23507b = 4;

    public Logger(String str) {
        this.f23506a = str;
    }

    private boolean a(int i2) {
        return this.f23507b <= i2 || Log.isLoggable(this.f23506a, i2);
    }

    public static Logger f() {
        return f23505d;
    }

    public void b(String str) {
        c(str, (Throwable) null);
    }

    public void c(String str, Throwable th) {
        if (a(3)) {
            Log.d(this.f23506a, str, th);
        }
    }

    public void d(String str) {
        e(str, (Throwable) null);
    }

    public void e(String str, Throwable th) {
        if (a(6)) {
            Log.e(this.f23506a, str, th);
        }
    }

    public void g(String str) {
        h(str, (Throwable) null);
    }

    public void h(String str, Throwable th) {
        if (a(4)) {
            Log.i(this.f23506a, str, th);
        }
    }

    public void i(int i2, String str) {
        j(i2, str, false);
    }

    public void j(int i2, String str, boolean z) {
        if (z || a(i2)) {
            Log.println(i2, this.f23506a, str);
        }
    }

    public void k(String str) {
        l(str, (Throwable) null);
    }

    public void l(String str, Throwable th) {
        if (a(2)) {
            Log.v(this.f23506a, str, th);
        }
    }

    public void m(String str) {
        n(str, (Throwable) null);
    }

    public void n(String str, Throwable th) {
        if (a(5)) {
            Log.w(this.f23506a, str, th);
        }
    }
}
