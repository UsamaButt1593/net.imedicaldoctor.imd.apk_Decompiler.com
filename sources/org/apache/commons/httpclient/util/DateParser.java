package org.apache.commons.httpclient.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateParser {
    private static final Collection DEFAULT_PATTERNS = Arrays.asList(new String[]{"EEE MMM d HH:mm:ss yyyy", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE, dd MMM yyyy HH:mm:ss zzz"});
    public static final String PATTERN_ASCTIME = "EEE MMM d HH:mm:ss yyyy";
    public static final String PATTERN_RFC1036 = "EEEE, dd-MMM-yy HH:mm:ss zzz";
    public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";

    private DateParser() {
    }

    public static Date parseDate(String str) throws DateParseException {
        return parseDate(str, (Collection) null);
    }

    public static Date parseDate(String str, Collection<String> collection) throws DateParseException {
        if (str != null) {
            if (collection == null) {
                collection = DEFAULT_PATTERNS;
            }
            if (str.length() > 1 && str.startsWith("'") && str.endsWith("'")) {
                str = str.substring(1, str.length() - 1);
            }
            SimpleDateFormat simpleDateFormat = null;
            for (String str2 : collection) {
                if (simpleDateFormat == null) {
                    simpleDateFormat = new SimpleDateFormat(str2, Locale.US);
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
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
