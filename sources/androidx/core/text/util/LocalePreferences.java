package androidx.core.text.util;

import android.icu.number.NumberFormatter;
import android.icu.text.DateFormat;
import android.icu.text.DateTimePatternGenerator;
import android.icu.util.Calendar;
import android.icu.util.MeasureUnit;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Locale;

@RequiresApi(21)
public final class LocalePreferences {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6243a = "LocalePreferences";

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f6244b = {"BS", "BZ", "KY", "PR", "PW", "US"};

    /* renamed from: androidx.core.text.util.LocalePreferences$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f6245a;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0021 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002e */
        static {
            /*
                android.icu.text.DateFormat$HourCycle[] r0 = android.icu.text.DateFormat.HourCycle.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6245a = r0
                android.icu.text.DateFormat$HourCycle r1 = android.icu.text.DateFormat.HourCycle.HOUR_CYCLE_11     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f6245a     // Catch:{ NoSuchFieldError -> 0x0021 }
                android.icu.text.DateFormat$HourCycle r1 = android.icu.text.DateFormat.HourCycle.HOUR_CYCLE_12     // Catch:{ NoSuchFieldError -> 0x0021 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0021 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0021 }
            L_0x0021:
                int[] r0 = f6245a     // Catch:{ NoSuchFieldError -> 0x002e }
                android.icu.text.DateFormat$HourCycle r1 = android.icu.text.DateFormat.HourCycle.HOUR_CYCLE_23     // Catch:{ NoSuchFieldError -> 0x002e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r0 = f6245a     // Catch:{ NoSuchFieldError -> 0x003b }
                android.icu.text.DateFormat$HourCycle r1 = android.icu.text.DateFormat.HourCycle.HOUR_CYCLE_24     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.text.util.LocalePreferences.AnonymousClass1.<clinit>():void");
        }
    }

    @RequiresApi(24)
    private static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static String a(@NonNull Locale locale) {
            return Calendar.getInstance(locale).getType();
        }

        @DoNotInline
        static Locale b() {
            return Locale.getDefault(Locale.Category.FORMAT);
        }
    }

    @RequiresApi(33)
    private static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static String a(@NonNull Locale locale) {
            return b(DateTimePatternGenerator.getInstance(locale).getDefaultHourCycle());
        }

        private static String b(DateFormat.HourCycle hourCycle) {
            int i2 = AnonymousClass1.f6245a[hourCycle.ordinal()];
            if (i2 == 1) {
                return HourCycle.f6269b;
            }
            if (i2 == 2) {
                return HourCycle.f6270c;
            }
            if (i2 != 3) {
                return i2 != 4 ? "" : HourCycle.f6272e;
            }
            return HourCycle.f6271d;
        }

        @DoNotInline
        static String c(@NonNull Locale locale) {
            String identifier = NumberFormatter.with().usage("weather").unit(MeasureUnit.CELSIUS).locale(locale).format(1).getOutputUnit().getIdentifier();
            return identifier.startsWith(TemperatureUnit.f6276c) ? TemperatureUnit.f6276c : identifier;
        }
    }

    public static class CalendarType {

        /* renamed from: a  reason: collision with root package name */
        private static final String f6246a = "ca";

        /* renamed from: b  reason: collision with root package name */
        public static final String f6247b = "chinese";

        /* renamed from: c  reason: collision with root package name */
        public static final String f6248c = "dangi";

        /* renamed from: d  reason: collision with root package name */
        public static final String f6249d = "gregorian";

        /* renamed from: e  reason: collision with root package name */
        public static final String f6250e = "hebrew";

        /* renamed from: f  reason: collision with root package name */
        public static final String f6251f = "indian";

        /* renamed from: g  reason: collision with root package name */
        public static final String f6252g = "islamic";

        /* renamed from: h  reason: collision with root package name */
        public static final String f6253h = "islamic-civil";

        /* renamed from: i  reason: collision with root package name */
        public static final String f6254i = "islamic-rgsa";

        /* renamed from: j  reason: collision with root package name */
        public static final String f6255j = "islamic-tbla";

        /* renamed from: k  reason: collision with root package name */
        public static final String f6256k = "islamic-umalqura";

        /* renamed from: l  reason: collision with root package name */
        public static final String f6257l = "persian";

        /* renamed from: m  reason: collision with root package name */
        public static final String f6258m = "";

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        @Retention(RetentionPolicy.SOURCE)
        public @interface CalendarTypes {
        }

        private CalendarType() {
        }
    }

    public static class FirstDayOfWeek {

        /* renamed from: a  reason: collision with root package name */
        private static final String f6259a = "fw";

        /* renamed from: b  reason: collision with root package name */
        public static final String f6260b = "sun";

        /* renamed from: c  reason: collision with root package name */
        public static final String f6261c = "mon";

        /* renamed from: d  reason: collision with root package name */
        public static final String f6262d = "tue";

        /* renamed from: e  reason: collision with root package name */
        public static final String f6263e = "wed";

        /* renamed from: f  reason: collision with root package name */
        public static final String f6264f = "thu";

        /* renamed from: g  reason: collision with root package name */
        public static final String f6265g = "fri";

        /* renamed from: h  reason: collision with root package name */
        public static final String f6266h = "sat";

        /* renamed from: i  reason: collision with root package name */
        public static final String f6267i = "";

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        @Retention(RetentionPolicy.SOURCE)
        public @interface Days {
        }

        private FirstDayOfWeek() {
        }
    }

    public static class HourCycle {

        /* renamed from: a  reason: collision with root package name */
        private static final String f6268a = "hc";

        /* renamed from: b  reason: collision with root package name */
        public static final String f6269b = "h11";

        /* renamed from: c  reason: collision with root package name */
        public static final String f6270c = "h12";

        /* renamed from: d  reason: collision with root package name */
        public static final String f6271d = "h23";

        /* renamed from: e  reason: collision with root package name */
        public static final String f6272e = "h24";

        /* renamed from: f  reason: collision with root package name */
        public static final String f6273f = "";

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        @Retention(RetentionPolicy.SOURCE)
        public @interface HourCycleTypes {
        }

        private HourCycle() {
        }
    }

    public static class TemperatureUnit {

        /* renamed from: a  reason: collision with root package name */
        private static final String f6274a = "mu";

        /* renamed from: b  reason: collision with root package name */
        public static final String f6275b = "celsius";

        /* renamed from: c  reason: collision with root package name */
        public static final String f6276c = "fahrenhe";

        /* renamed from: d  reason: collision with root package name */
        public static final String f6277d = "kelvin";

        /* renamed from: e  reason: collision with root package name */
        public static final String f6278e = "";

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        @Retention(RetentionPolicy.SOURCE)
        public @interface TemperatureUnits {
        }

        private TemperatureUnit() {
        }
    }

    private LocalePreferences() {
    }

    private static String a(@NonNull Locale locale) {
        return p(java.util.Calendar.getInstance(locale).getFirstDayOfWeek());
    }

    private static String b(@NonNull Locale locale) {
        return android.text.format.DateFormat.getBestDateTimePattern(locale, "jm").contains("H") ? HourCycle.f6271d : HourCycle.f6270c;
    }

    @NonNull
    public static String c() {
        return f(true);
    }

    @NonNull
    public static String d(@NonNull Locale locale) {
        return e(locale, true);
    }

    @NonNull
    public static String e(@NonNull Locale locale, boolean z) {
        String v = v("ca", "", locale, z);
        if (v != null) {
            return v;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.a(locale);
        }
        return z ? CalendarType.f6249d : "";
    }

    @NonNull
    public static String f(boolean z) {
        return e(Build.VERSION.SDK_INT >= 24 ? Api24Impl.b() : g(), z);
    }

    private static Locale g() {
        return Locale.getDefault();
    }

    @NonNull
    public static String h() {
        return k(true);
    }

    @NonNull
    public static String i(@NonNull Locale locale) {
        return j(locale, true);
    }

    @NonNull
    public static String j(@NonNull Locale locale, boolean z) {
        String v = v("fw", "", locale, z);
        return v != null ? v : a(locale);
    }

    @NonNull
    public static String k(boolean z) {
        return j(Build.VERSION.SDK_INT >= 24 ? Api24Impl.b() : g(), z);
    }

    @NonNull
    public static String l() {
        return o(true);
    }

    @NonNull
    public static String m(@NonNull Locale locale) {
        return n(locale, true);
    }

    @NonNull
    public static String n(@NonNull Locale locale, boolean z) {
        String v = v("hc", "", locale, z);
        if (v != null) {
            return v;
        }
        return Build.VERSION.SDK_INT >= 33 ? Api33Impl.a(locale) : b(locale);
    }

    @NonNull
    public static String o(boolean z) {
        return n(Build.VERSION.SDK_INT >= 24 ? Api24Impl.b() : g(), z);
    }

    private static String p(int i2) {
        return (i2 < 1 || i2 > 7) ? "" : new String[]{FirstDayOfWeek.f6260b, FirstDayOfWeek.f6261c, FirstDayOfWeek.f6262d, FirstDayOfWeek.f6263e, FirstDayOfWeek.f6264f, FirstDayOfWeek.f6265g, FirstDayOfWeek.f6266h}[i2 - 1];
    }

    private static String q(Locale locale) {
        return Arrays.binarySearch(f6244b, locale.getCountry()) >= 0 ? TemperatureUnit.f6276c : TemperatureUnit.f6275b;
    }

    @NonNull
    public static String r() {
        return u(true);
    }

    @NonNull
    public static String s(@NonNull Locale locale) {
        return t(locale, true);
    }

    @NonNull
    public static String t(@NonNull Locale locale, boolean z) {
        String v = v("mu", "", locale, z);
        if (v != null) {
            return v;
        }
        return Build.VERSION.SDK_INT >= 33 ? Api33Impl.c(locale) : q(locale);
    }

    @NonNull
    public static String u(boolean z) {
        return t(Build.VERSION.SDK_INT >= 24 ? Api24Impl.b() : g(), z);
    }

    private static String v(String str, String str2, Locale locale, boolean z) {
        String unicodeLocaleType = locale.getUnicodeLocaleType(str);
        if (unicodeLocaleType != null) {
            return unicodeLocaleType;
        }
        if (!z) {
            return str2;
        }
        return null;
    }
}
