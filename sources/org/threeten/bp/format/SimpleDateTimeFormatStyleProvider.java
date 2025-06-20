package org.threeten.bp.format;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.chrono.Chronology;

final class SimpleDateTimeFormatStyleProvider extends DateTimeFormatStyleProvider {

    /* renamed from: a  reason: collision with root package name */
    private static final ConcurrentMap<String, Object> f31847a = new ConcurrentHashMap(16, 0.75f, 2);

    SimpleDateTimeFormatStyleProvider() {
    }

    private int d(FormatStyle formatStyle) {
        return formatStyle.ordinal();
    }

    public Locale[] a() {
        return DateFormat.getAvailableLocales();
    }

    public DateTimeFormatter b(FormatStyle formatStyle, FormatStyle formatStyle2, Chronology chronology, Locale locale) {
        DateFormat dateFormat;
        if (formatStyle == null && formatStyle2 == null) {
            throw new IllegalArgumentException("Date and Time style must not both be null");
        }
        String str = chronology.v() + '|' + locale.toString() + '|' + formatStyle + formatStyle2;
        ConcurrentMap<String, Object> concurrentMap = f31847a;
        Object obj = concurrentMap.get(str);
        if (obj == null) {
            if (formatStyle != null) {
                int d2 = d(formatStyle);
                dateFormat = formatStyle2 != null ? DateFormat.getDateTimeInstance(d2, d(formatStyle2), locale) : DateFormat.getDateInstance(d2, locale);
            } else {
                dateFormat = DateFormat.getTimeInstance(d(formatStyle2), locale);
            }
            if (dateFormat instanceof SimpleDateFormat) {
                DateTimeFormatter Q = new DateTimeFormatterBuilder().o(((SimpleDateFormat) dateFormat).toPattern()).Q(locale);
                concurrentMap.putIfAbsent(str, Q);
                return Q;
            }
            concurrentMap.putIfAbsent(str, "");
            throw new IllegalArgumentException("Unable to convert DateFormat to DateTimeFormatter");
        } else if (!obj.equals("")) {
            return (DateTimeFormatter) obj;
        } else {
            throw new IllegalArgumentException("Unable to convert DateFormat to DateTimeFormatter");
        }
    }
}
