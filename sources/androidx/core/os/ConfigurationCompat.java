package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class ConfigurationCompat {

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static LocaleList a(Configuration configuration) {
            return configuration.getLocales();
        }

        @DoNotInline
        static void b(@NonNull Configuration configuration, @NonNull LocaleListCompat localeListCompat) {
            configuration.setLocales((LocaleList) localeListCompat.n());
        }
    }

    private ConfigurationCompat() {
    }

    @NonNull
    public static LocaleListCompat a(@NonNull Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return LocaleListCompat.o(Api24Impl.a(configuration));
        }
        return LocaleListCompat.a(configuration.locale);
    }

    public static void b(@NonNull Configuration configuration, @NonNull LocaleListCompat localeListCompat) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.b(configuration, localeListCompat);
        } else if (!localeListCompat.j()) {
            configuration.setLocale(localeListCompat.d(0));
        }
    }
}
