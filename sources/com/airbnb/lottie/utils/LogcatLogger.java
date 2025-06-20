package com.airbnb.lottie.utils;

import android.util.Log;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieLogger;
import java.util.HashSet;
import java.util.Set;

public class LogcatLogger implements LottieLogger {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f17342a = new HashSet();

    public void a(String str) {
        e(str, (Throwable) null);
    }

    public void b(String str, Throwable th) {
        if (L.f16670a) {
            Log.d(L.f16671b, str, th);
        }
    }

    public void c(String str, Throwable th) {
        Set<String> set = f17342a;
        if (!set.contains(str)) {
            Log.w(L.f16671b, str, th);
            set.add(str);
        }
    }

    public void d(String str) {
        c(str, (Throwable) null);
    }

    public void e(String str, Throwable th) {
        if (L.f16670a) {
            Log.d(L.f16671b, str, th);
        }
    }
}
