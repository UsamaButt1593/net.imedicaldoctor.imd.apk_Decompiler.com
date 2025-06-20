package com.airbnb.lottie.utils;

import com.airbnb.lottie.LottieLogger;

public class Logger {

    /* renamed from: a  reason: collision with root package name */
    private static LottieLogger f17343a = new LogcatLogger();

    public static void a(String str) {
        f17343a.a(str);
    }

    public static void b(String str, Throwable th) {
        f17343a.e(str, th);
    }

    public static void c(String str, Throwable th) {
        f17343a.b(str, th);
    }

    public static void d(LottieLogger lottieLogger) {
        f17343a = lottieLogger;
    }

    public static void e(String str) {
        f17343a.d(str);
    }

    public static void f(String str, Throwable th) {
        f17343a.c(str, th);
    }
}
