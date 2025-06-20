package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.google.android.material.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

class DateStrings {
    private DateStrings() {
    }

    static Pair<String, String> a(@Nullable Long l2, @Nullable Long l3) {
        return b(l2, l3, (SimpleDateFormat) null);
    }

    static Pair<String, String> b(@Nullable Long l2, @Nullable Long l3, @Nullable SimpleDateFormat simpleDateFormat) {
        if (l2 == null && l3 == null) {
            return Pair.a(null, null);
        }
        if (l2 == null) {
            return Pair.a(null, d(l3.longValue(), simpleDateFormat));
        }
        if (l3 == null) {
            return Pair.a(d(l2.longValue(), simpleDateFormat), null);
        }
        Calendar v = UtcDates.v();
        Calendar x = UtcDates.x();
        x.setTimeInMillis(l2.longValue());
        Calendar x2 = UtcDates.x();
        x2.setTimeInMillis(l3.longValue());
        if (simpleDateFormat != null) {
            return Pair.a(simpleDateFormat.format(new Date(l2.longValue())), simpleDateFormat.format(new Date(l3.longValue())));
        } else if (x.get(1) == x2.get(1)) {
            return x.get(1) == v.get(1) ? Pair.a(g(l2.longValue(), Locale.getDefault()), g(l3.longValue(), Locale.getDefault())) : Pair.a(g(l2.longValue(), Locale.getDefault()), n(l3.longValue(), Locale.getDefault()));
        } else {
            return Pair.a(n(l2.longValue(), Locale.getDefault()), n(l3.longValue(), Locale.getDefault()));
        }
    }

    static String c(long j2) {
        return d(j2, (SimpleDateFormat) null);
    }

    static String d(long j2, @Nullable SimpleDateFormat simpleDateFormat) {
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j2));
        }
        return q(j2) ? f(j2) : m(j2);
    }

    static String e(Context context, long j2, boolean z, boolean z2, boolean z3) {
        String j3 = j(j2);
        if (z) {
            j3 = String.format(context.getString(R.string.I1), new Object[]{j3});
        }
        if (z2) {
            return String.format(context.getString(R.string.B1), new Object[]{j3});
        } else if (!z3) {
            return j3;
        } else {
            return String.format(context.getString(R.string.n1), new Object[]{j3});
        }
    }

    static String f(long j2) {
        return g(j2, Locale.getDefault());
    }

    static String g(long j2, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? UtcDates.c(locale).format(new Date(j2)) : UtcDates.o(locale).format(new Date(j2));
    }

    static String h(long j2) {
        return i(j2, Locale.getDefault());
    }

    static String i(long j2, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? UtcDates.p(locale).format(new Date(j2)) : UtcDates.k(locale).format(new Date(j2));
    }

    static String j(long j2) {
        return q(j2) ? h(j2) : o(j2);
    }

    static String k(Context context, int i2) {
        if (UtcDates.v().get(1) == i2) {
            return String.format(context.getString(R.string.s1), new Object[]{Integer.valueOf(i2)});
        }
        return String.format(context.getString(R.string.t1), new Object[]{Integer.valueOf(i2)});
    }

    static String l(long j2) {
        return Build.VERSION.SDK_INT >= 24 ? UtcDates.A(Locale.getDefault()).format(new Date(j2)) : DateUtils.formatDateTime((Context) null, j2, 8228);
    }

    static String m(long j2) {
        return n(j2, Locale.getDefault());
    }

    static String n(long j2, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? UtcDates.z(locale).format(new Date(j2)) : UtcDates.m(locale).format(new Date(j2));
    }

    static String o(long j2) {
        return p(j2, Locale.getDefault());
    }

    static String p(long j2, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? UtcDates.B(locale).format(new Date(j2)) : UtcDates.k(locale).format(new Date(j2));
    }

    private static boolean q(long j2) {
        Calendar v = UtcDates.v();
        Calendar x = UtcDates.x();
        x.setTimeInMillis(j2);
        return v.get(1) == x.get(1);
    }
}
