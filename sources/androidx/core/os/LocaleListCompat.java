package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.DoNotInline;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import androidx.core.text.ICUCompat;
import java.util.Locale;

public final class LocaleListCompat {

    /* renamed from: b  reason: collision with root package name */
    private static final LocaleListCompat f6058b = a(new Locale[0]);

    /* renamed from: a  reason: collision with root package name */
    private final LocaleListInterface f6059a;

    @RequiresApi(21)
    static class Api21Impl {

        /* renamed from: a  reason: collision with root package name */
        private static final Locale[] f6060a = {new Locale("en", "XA"), new Locale("ar", "XB")};

        private Api21Impl() {
        }

        @DoNotInline
        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }

        private static boolean b(Locale locale) {
            for (Locale equals : f6060a) {
                if (equals.equals(locale)) {
                    return true;
                }
            }
            return false;
        }

        @DoNotInline
        static boolean c(@NonNull Locale locale, @NonNull Locale locale2) {
            if (locale.equals(locale2)) {
                return true;
            }
            if (!locale.getLanguage().equals(locale2.getLanguage()) || b(locale) || b(locale2)) {
                return false;
            }
            String c2 = ICUCompat.c(locale);
            if (!c2.isEmpty()) {
                return c2.equals(ICUCompat.c(locale2));
            }
            String country = locale.getCountry();
            return country.isEmpty() || country.equals(locale2.getCountry());
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        @DoNotInline
        static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }

        @DoNotInline
        static LocaleList c() {
            return LocaleList.getDefault();
        }
    }

    private LocaleListCompat(LocaleListInterface localeListInterface) {
        this.f6059a = localeListInterface;
    }

    @NonNull
    public static LocaleListCompat a(@NonNull Locale... localeArr) {
        return Build.VERSION.SDK_INT >= 24 ? o(Api24Impl.a(localeArr)) : new LocaleListCompat(new LocaleListCompatWrapper(localeArr));
    }

    static Locale b(String str) {
        if (str.contains("-")) {
            String[] split = str.split("-", -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else if (!str.contains("_")) {
            return new Locale(str);
        } else {
            String[] split2 = str.split("_", -1);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    @NonNull
    public static LocaleListCompat c(@Nullable String str) {
        if (str == null || str.isEmpty()) {
            return g();
        }
        String[] split = str.split(",", -1);
        int length = split.length;
        Locale[] localeArr = new Locale[length];
        for (int i2 = 0; i2 < length; i2++) {
            localeArr[i2] = Api21Impl.a(split[i2]);
        }
        return a(localeArr);
    }

    @Size(min = 1)
    @NonNull
    public static LocaleListCompat e() {
        if (Build.VERSION.SDK_INT >= 24) {
            return o(Api24Impl.b());
        }
        return a(Locale.getDefault());
    }

    @Size(min = 1)
    @NonNull
    public static LocaleListCompat f() {
        if (Build.VERSION.SDK_INT >= 24) {
            return o(Api24Impl.c());
        }
        return a(Locale.getDefault());
    }

    @NonNull
    public static LocaleListCompat g() {
        return f6058b;
    }

    @RequiresApi(21)
    public static boolean k(@NonNull Locale locale, @NonNull Locale locale2) {
        return Build.VERSION.SDK_INT >= 33 ? LocaleList.matchesLanguageAndScript(locale, locale2) : Api21Impl.c(locale, locale2);
    }

    @RequiresApi(24)
    @NonNull
    public static LocaleListCompat o(@NonNull LocaleList localeList) {
        return new LocaleListCompat(new LocaleListPlatformWrapper(localeList));
    }

    @RequiresApi(24)
    @Deprecated
    public static LocaleListCompat p(Object obj) {
        return o(b.a(obj));
    }

    @Nullable
    public Locale d(int i2) {
        return this.f6059a.get(i2);
    }

    public boolean equals(Object obj) {
        return (obj instanceof LocaleListCompat) && this.f6059a.equals(((LocaleListCompat) obj).f6059a);
    }

    @Nullable
    public Locale h(@NonNull String[] strArr) {
        return this.f6059a.d(strArr);
    }

    public int hashCode() {
        return this.f6059a.hashCode();
    }

    @IntRange(from = -1)
    public int i(@Nullable Locale locale) {
        return this.f6059a.a(locale);
    }

    public boolean j() {
        return this.f6059a.isEmpty();
    }

    @IntRange(from = 0)
    public int l() {
        return this.f6059a.size();
    }

    @NonNull
    public String m() {
        return this.f6059a.b();
    }

    @Nullable
    public Object n() {
        return this.f6059a.c();
    }

    @NonNull
    public String toString() {
        return this.f6059a.toString();
    }
}
