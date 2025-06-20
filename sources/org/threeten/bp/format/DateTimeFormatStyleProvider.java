package org.threeten.bp.format;

import java.util.Locale;
import org.threeten.bp.chrono.Chronology;

abstract class DateTimeFormatStyleProvider {
    DateTimeFormatStyleProvider() {
    }

    static DateTimeFormatStyleProvider c() {
        return new SimpleDateTimeFormatStyleProvider();
    }

    public Locale[] a() {
        throw new UnsupportedOperationException();
    }

    public abstract DateTimeFormatter b(FormatStyle formatStyle, FormatStyle formatStyle2, Chronology chronology, Locale locale);
}
