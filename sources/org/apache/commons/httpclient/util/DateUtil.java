package org.apache.commons.httpclient.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtil {
    private static final Collection DEFAULT_PATTERNS = Arrays.asList(new String[]{"EEE MMM d HH:mm:ss yyyy", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE, dd MMM yyyy HH:mm:ss zzz"});
    private static final Date DEFAULT_TWO_DIGIT_YEAR_START;
    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    public static final String PATTERN_ASCTIME = "EEE MMM d HH:mm:ss yyyy";
    public static final String PATTERN_RFC1036 = "EEEE, dd-MMM-yy HH:mm:ss zzz";
    public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";

    static {
        Calendar instance = Calendar.getInstance();
        instance.set(2000, 0, 1, 0, 0);
        DEFAULT_TWO_DIGIT_YEAR_START = instance.getTime();
    }

    private DateUtil() {
    }

    public static String formatDate(Date date) {
        return formatDate(date, "EEE, dd MMM yyyy HH:mm:ss zzz");
    }

    public static Date parseDate(String str) throws DateParseException {
        return parseDate(str, (Collection) null, (Date) null);
    }

    public static String formatDate(Date date, String str) {
        if (date == null) {
            throw new IllegalArgumentException("date is null");
        } else if (str != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
            simpleDateFormat.setTimeZone(GMT);
            return simpleDateFormat.format(date);
        } else {
            throw new IllegalArgumentException("pattern is null");
        }
    }

    public static Date parseDate(String str, Collection collection) throws DateParseException {
        return parseDate(str, collection, (Date) null);
    }

    public static Date parseDate(String str, Collection<String> collection, Date date) throws DateParseException {
        if (str != null) {
            if (collection == null) {
                collection = DEFAULT_PATTERNS;
            }
            if (date == null) {
                date = DEFAULT_TWO_DIGIT_YEAR_START;
            }
            if (str.length() > 1 && str.startsWith("'") && str.endsWith("'")) {
                str = str.substring(1, str.length() - 1);
            }
            SimpleDateFormat simpleDateFormat = null;
            for (String str2 : collection) {
                if (simpleDateFormat == null) {
                    simpleDateFormat = new SimpleDateFormat(str2, Locale.US);
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                    simpleDateFormat.set2DigitYearStart(date);
                } else {
                    simpleDateFormat.applyPattern(str2);
                }
                try {
                    return simpleDateFormat.parse(str);
                } catch (ParseException unused) {
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Unable to parse the date ");
            stringBuffer.append(str);
            throw new DateParseException(stringBuffer.toString());
        }
        throw new IllegalArgumentException("dateValue is null");
    }
}
