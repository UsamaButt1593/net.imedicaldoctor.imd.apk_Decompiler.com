package com.google.android.datatransport.runtime.logging;

import android.os.Build;
import android.util.Log;

public final class Logging {

    /* renamed from: a  reason: collision with root package name */
    private static final String f19525a = "TRuntime.";

    /* renamed from: b  reason: collision with root package name */
    private static final int f19526b = 23;

    private Logging() {
    }

    private static String a(String str, String str2) {
        String str3 = str + str2;
        return str3.length() > 23 ? str3.substring(0, 23) : str3;
    }

    public static void b(String str, String str2) {
        String g2 = g(str);
        if (Log.isLoggable(g2, 3)) {
            Log.d(g2, str2);
        }
    }

    public static void c(String str, String str2, Object obj) {
        String g2 = g(str);
        if (Log.isLoggable(g2, 3)) {
            Log.d(g2, String.format(str2, new Object[]{obj}));
        }
    }

    public static void d(String str, String str2, Object obj, Object obj2) {
        String g2 = g(str);
        if (Log.isLoggable(g2, 3)) {
            Log.d(g2, String.format(str2, new Object[]{obj, obj2}));
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        String g2 = g(str);
        if (Log.isLoggable(g2, 3)) {
            Log.d(g2, String.format(str2, objArr));
        }
    }

    public static void f(String str, String str2, Throwable th) {
        String g2 = g(str);
        if (Log.isLoggable(g2, 6)) {
            Log.e(g2, str2, th);
        }
    }

    private static String g(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return a(f19525a, str);
        }
        return f19525a + str;
    }

    public static void h(String str, String str2, Object obj) {
        String g2 = g(str);
        if (Log.isLoggable(g2, 4)) {
            Log.i(g2, String.format(str2, new Object[]{obj}));
        }
    }

    public static void i(String str, String str2, Object obj) {
        String g2 = g(str);
        if (Log.isLoggable(g2, 5)) {
            Log.w(g2, String.format(str2, new Object[]{obj}));
        }
    }
}
