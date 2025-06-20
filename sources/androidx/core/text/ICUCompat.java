package androidx.core.text;

import android.annotation.SuppressLint;
import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public final class ICUCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6191a = "ICUCompat";

    /* renamed from: b  reason: collision with root package name */
    private static Method f6192b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f6193c;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static String a(Locale locale) {
            return locale.getScript();
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static ULocale a(Object obj) {
            return ULocale.addLikelySubtags((ULocale) obj);
        }

        @DoNotInline
        static ULocale b(Locale locale) {
            return ULocale.forLocale(locale);
        }

        @DoNotInline
        static String c(Object obj) {
            return ((ULocale) obj).getScript();
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 24) {
            try {
                f6193c = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
            } catch (Exception e2) {
                throw new IllegalStateException(e2);
            }
        }
    }

    private ICUCompat() {
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static String a(Locale locale) {
        String locale2 = locale.toString();
        try {
            Method method = f6193c;
            if (method != null) {
                return (String) method.invoke((Object) null, new Object[]{locale2});
            }
        } catch (IllegalAccessException | InvocationTargetException e2) {
            Log.w(f6191a, e2);
        }
        return locale2;
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static String b(String str) {
        try {
            Method method = f6192b;
            if (method != null) {
                return (String) method.invoke((Object) null, new Object[]{str});
            }
        } catch (IllegalAccessException | InvocationTargetException e2) {
            Log.w(f6191a, e2);
        }
        return null;
    }

    @Nullable
    public static String c(@NonNull Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.c(Api24Impl.a(Api24Impl.b(locale)));
        }
        try {
            return Api21Impl.a((Locale) f6193c.invoke((Object) null, new Object[]{locale}));
        } catch (IllegalAccessException | InvocationTargetException e2) {
            Log.w(f6191a, e2);
            return Api21Impl.a(locale);
        }
    }
}
