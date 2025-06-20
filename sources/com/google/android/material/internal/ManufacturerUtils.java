package com.google.android.material.internal;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Locale;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ManufacturerUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f21521a = "lge";

    /* renamed from: b  reason: collision with root package name */
    private static final String f21522b = "samsung";

    /* renamed from: c  reason: collision with root package name */
    private static final String f21523c = "meizu";

    private ManufacturerUtils() {
    }

    @NonNull
    private static String a() {
        String str = Build.MANUFACTURER;
        return str != null ? str.toLowerCase(Locale.ENGLISH) : "";
    }

    public static boolean b() {
        return c() || e();
    }

    public static boolean c() {
        return a().equals(f21521a);
    }

    public static boolean d() {
        return a().equals(f21523c);
    }

    public static boolean e() {
        return a().equals(f21522b);
    }
}
