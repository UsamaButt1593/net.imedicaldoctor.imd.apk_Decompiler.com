package com.google.android.material.datepicker;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import com.itextpdf.tool.xml.html.HTML;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.StringUtils;

class UtcDates {

    /* renamed from: a  reason: collision with root package name */
    static final String f21388a = "UTC";

    /* renamed from: b  reason: collision with root package name */
    static AtomicReference<TimeSource> f21389b = new AtomicReference<>();

    private UtcDates() {
    }

    @TargetApi(24)
    static DateFormat A(Locale locale) {
        return d("yMMMM", locale);
    }

    @TargetApi(24)
    static DateFormat B(Locale locale) {
        return d("yMMMMEEEEd", locale);
    }

    @NonNull
    private static String C(@NonNull String str) {
        int b2 = b(str, "yY", 1, 0);
        if (b2 >= str.length()) {
            return str;
        }
        String str2 = "EMd";
        int b3 = b(str, str2, 1, b2);
        if (b3 < str.length()) {
            str2 = str2 + ",";
        }
        return str.replace(str.substring(b(str, str2, -1, b2) + 1, b3), StringUtils.SPACE).trim();
    }

    static void D(@Nullable TimeSource timeSource) {
        f21389b.set(timeSource);
    }

    static long a(long j2) {
        Calendar x = x();
        x.setTimeInMillis(j2);
        return f(x).getTimeInMillis();
    }

    private static int b(@NonNull String str, @NonNull String str2, int i2, int i3) {
        while (i3 >= 0 && i3 < str.length() && str2.indexOf(str.charAt(i3)) == -1) {
            if (str.charAt(i3) == '\'') {
                do {
                    i3 += i2;
                    if (i3 < 0) {
                        break;
                    } else if (i3 >= str.length()) {
                        break;
                    }
                } while (str.charAt(i3) == '\'');
            }
            i3 += i2;
        }
        return i3;
    }

    @TargetApi(24)
    static DateFormat c(Locale locale) {
        return d("MMMd", locale);
    }

    @TargetApi(24)
    private static DateFormat d(String str, Locale locale) {
        DateFormat a2 = DateFormat.getInstanceForSkeleton(str, locale);
        a2.setTimeZone(w());
        a2.setContext(DisplayContext.CAPITALIZATION_FOR_STANDALONE);
        return a2;
    }

    @NonNull
    static String e(@NonNull String str) {
        return str.replaceAll("[^dMy/\\-.]", "").replaceAll("d{1,2}", HTML.Tag.t).replaceAll("M{1,2}", "MM").replaceAll("y{1,4}", "yyyy").replaceAll("\\.$", "").replaceAll("My", "M/y");
    }

    static Calendar f(Calendar calendar) {
        Calendar y = y(calendar);
        Calendar x = x();
        x.set(y.get(1), y.get(2), y.get(5));
        return x;
    }

    static SimpleDateFormat g() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(e(((SimpleDateFormat) java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toPattern()), Locale.getDefault());
        simpleDateFormat.setTimeZone(u());
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    static String h(Resources resources, SimpleDateFormat simpleDateFormat) {
        String pattern = simpleDateFormat.toPattern();
        String string = resources.getString(R.string.H1);
        String string2 = resources.getString(R.string.G1);
        String string3 = resources.getString(R.string.F1);
        if (Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage())) {
            pattern = pattern.replaceAll("d+", "d").replaceAll("M+", "M").replaceAll("y+", "y");
        }
        return pattern.replace("d", string3).replace("M", string2).replace("y", string);
    }

    private static java.text.DateFormat i(int i2, Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(i2, locale);
        dateInstance.setTimeZone(u());
        return dateInstance;
    }

    static java.text.DateFormat j() {
        return k(Locale.getDefault());
    }

    static java.text.DateFormat k(Locale locale) {
        return i(0, locale);
    }

    static java.text.DateFormat l() {
        return m(Locale.getDefault());
    }

    static java.text.DateFormat m(Locale locale) {
        return i(2, locale);
    }

    static java.text.DateFormat n() {
        return o(Locale.getDefault());
    }

    static java.text.DateFormat o(Locale locale) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) m(locale);
        simpleDateFormat.applyPattern(C(simpleDateFormat.toPattern()));
        return simpleDateFormat;
    }

    @TargetApi(24)
    static DateFormat p(Locale locale) {
        return d("MMMMEEEEd", locale);
    }

    static java.text.DateFormat q(@NonNull java.text.DateFormat dateFormat) {
        java.text.DateFormat dateFormat2 = (java.text.DateFormat) dateFormat.clone();
        dateFormat2.setTimeZone(u());
        return dateFormat2;
    }

    static SimpleDateFormat r(String str) {
        return s(str, Locale.getDefault());
    }

    private static SimpleDateFormat s(String str, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
        simpleDateFormat.setTimeZone(u());
        return simpleDateFormat;
    }

    static TimeSource t() {
        TimeSource timeSource = f21389b.get();
        return timeSource == null ? TimeSource.e() : timeSource;
    }

    private static TimeZone u() {
        return TimeZone.getTimeZone(f21388a);
    }

    static Calendar v() {
        Calendar c2 = t().c();
        c2.set(11, 0);
        c2.set(12, 0);
        c2.set(13, 0);
        c2.set(14, 0);
        c2.setTimeZone(u());
        return c2;
    }

    @TargetApi(24)
    private static android.icu.util.TimeZone w() {
        return android.icu.util.TimeZone.getTimeZone(f21388a);
    }

    static Calendar x() {
        return y((Calendar) null);
    }

    static Calendar y(@Nullable Calendar calendar) {
        Calendar instance = Calendar.getInstance(u());
        if (calendar == null) {
            instance.clear();
        } else {
            instance.setTimeInMillis(calendar.getTimeInMillis());
        }
        return instance;
    }

    @TargetApi(24)
    static DateFormat z(Locale locale) {
        return d("yMMMd", locale);
    }
}
