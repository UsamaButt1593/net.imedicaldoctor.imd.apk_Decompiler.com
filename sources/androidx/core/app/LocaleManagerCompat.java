package androidx.core.app;

import android.app.LocaleManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.AnyThread;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.LocaleListCompat;
import java.util.Locale;

public final class LocaleManagerCompat {

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static String a(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static LocaleListCompat a(Configuration configuration) {
            return LocaleListCompat.c(configuration.getLocales().toLanguageTags());
        }
    }

    @RequiresApi(33)
    static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        @DoNotInline
        static LocaleList b(Object obj) {
            return ((LocaleManager) obj).getSystemLocales();
        }
    }

    private LocaleManagerCompat() {
    }

    @NonNull
    @AnyThread
    public static LocaleListCompat a(@NonNull Context context) {
        if (Build.VERSION.SDK_INT < 33) {
            return LocaleListCompat.c(AppLocalesStorageHelper.b(context));
        }
        Object c2 = c(context);
        return c2 != null ? LocaleListCompat.o(Api33Impl.a(c2)) : LocaleListCompat.g();
    }

    @VisibleForTesting
    static LocaleListCompat b(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? Api24Impl.a(configuration) : LocaleListCompat.c(Api21Impl.a(configuration.locale));
    }

    @RequiresApi(33)
    private static Object c(Context context) {
        return context.getSystemService("locale");
    }

    @NonNull
    @AnyThread
    public static LocaleListCompat d(@NonNull Context context) {
        LocaleListCompat g2 = LocaleListCompat.g();
        if (Build.VERSION.SDK_INT < 33) {
            return b(Resources.getSystem().getConfiguration());
        }
        Object c2 = c(context);
        return c2 != null ? LocaleListCompat.o(Api33Impl.b(c2)) : g2;
    }
}
