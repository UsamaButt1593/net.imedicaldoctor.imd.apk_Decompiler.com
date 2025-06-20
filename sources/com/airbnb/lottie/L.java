package com.airbnb.lottie;

import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class L {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f16670a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f16671b = "LOTTIE";

    /* renamed from: c  reason: collision with root package name */
    private static final int f16672c = 20;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f16673d = false;

    /* renamed from: e  reason: collision with root package name */
    private static String[] f16674e;

    /* renamed from: f  reason: collision with root package name */
    private static long[] f16675f;

    /* renamed from: g  reason: collision with root package name */
    private static int f16676g;

    /* renamed from: h  reason: collision with root package name */
    private static int f16677h;

    public static void a(String str) {
        if (f16673d) {
            int i2 = f16676g;
            if (i2 == 20) {
                f16677h++;
                return;
            }
            f16674e[i2] = str;
            f16675f[i2] = System.nanoTime();
            TraceCompat.b(str);
            f16676g++;
        }
    }

    public static float b(String str) {
        int i2 = f16677h;
        if (i2 > 0) {
            f16677h = i2 - 1;
            return 0.0f;
        } else if (!f16673d) {
            return 0.0f;
        } else {
            int i3 = f16676g - 1;
            f16676g = i3;
            if (i3 == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            } else if (str.equals(f16674e[i3])) {
                TraceCompat.d();
                return ((float) (System.nanoTime() - f16675f[f16676g])) / 1000000.0f;
            } else {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f16674e[f16676g] + ".");
            }
        }
    }

    public static void c(boolean z) {
        if (f16673d != z) {
            f16673d = z;
            if (z) {
                f16674e = new String[20];
                f16675f = new long[20];
            }
        }
    }
}
