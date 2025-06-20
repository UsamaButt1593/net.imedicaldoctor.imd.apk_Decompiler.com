package org.apache.commons.lang3.time;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class FastDateFormat extends Format implements DateParser, DatePrinter {
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private static final FormatCache<FastDateFormat> cache = new FormatCache<FastDateFormat>() {
        /* access modifiers changed from: protected */
        public FastDateFormat createInstance(String str, TimeZone timeZone, Locale locale) {
            return new FastDateFormat(str, timeZone, locale);
        }
    };
    private static final long serialVersionUID = 2;
    private final FastDateParser parser;
    private final FastDatePrinter printer;

    protected FastDateFormat(String str, TimeZone timeZone, Locale locale) {
        this(str, timeZone, locale, (Date) null);
    }

    public static FastDateFormat getDateInstance(int i2) {
        return cache.getDateInstance(i2, (TimeZone) null, (Locale) null);
    }

    public static FastDateFormat getDateTimeInstance(int i2, int i3) {
        return cache.getDateTimeInstance(i2, i3, (TimeZone) null, (Locale) null);
    }

    public static FastDateFormat getInstance() {
        return cache.getInstance();
    }

    public static FastDateFormat getTimeInstance(int i2) {
        return cache.getTimeInstance(i2, (TimeZone) null, (Locale) null);
    }

    /* access modifiers changed from: protected */
    public StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        return this.printer.applyRules(calendar, stringBuffer);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDateFormat)) {
            return false;
        }
        return this.printer.equals(((FastDateFormat) obj).printer);
    }

    public String format(long j2) {
        return this.printer.format(j2);
    }

    public Locale getLocale() {
        return this.printer.getLocale();
    }

    public int getMaxLengthEstimate() {
        return this.printer.getMaxLengthEstimate();
    }

    public String getPattern() {
        return this.printer.getPattern();
    }

    public TimeZone getTimeZone() {
        return this.printer.getTimeZone();
    }

    public int hashCode() {
        return this.printer.hashCode();
    }

    public Date parse(String str) throws ParseException {
        return this.parser.parse(str);
    }

    public Object parseObject(String str, ParsePosition parsePosition) {
        return this.parser.parseObject(str, parsePosition);
    }

    public String toString() {
        return "FastDateFormat[" + this.printer.getPattern() + "," + this.printer.getLocale() + "," + this.printer.getTimeZone().getID() + "]";
    }

    protected FastDateFormat(String str, TimeZone timeZone, Locale locale, Date date) {
        this.printer = new FastDatePrinter(str, timeZone, locale);
        this.parser = new FastDateParser(str, timeZone, locale, date);
    }

    public static FastDateFormat getDateInstance(int i2, Locale locale) {
        return cache.getDateInstance(i2, (TimeZone) null, locale);
    }

    public static FastDateFormat getDateTimeInstance(int i2, int i3, Locale locale) {
        return cache.getDateTimeInstance(i2, i3, (TimeZone) null, locale);
    }

    public static FastDateFormat getInstance(String str) {
        return cache.getInstance(str, (TimeZone) null, (Locale) null);
    }

    public static FastDateFormat getTimeInstance(int i2, Locale locale) {
        return cache.getTimeInstance(i2, (TimeZone) null, locale);
    }

    public String format(Calendar calendar) {
        return this.printer.format(calendar);
    }

    public Date parse(String str, ParsePosition parsePosition) {
        return this.parser.parse(str, parsePosition);
    }

    public static FastDateFormat getDateInstance(int i2, TimeZone timeZone) {
        return cache.getDateInstance(i2, timeZone, (Locale) null);
    }

    public static FastDateFormat getDateTimeInstance(int i2, int i3, TimeZone timeZone) {
        return getDateTimeInstance(i2, i3, timeZone, (Locale) null);
    }

    public static FastDateFormat getInstance(String str, Locale locale) {
        return cache.getInstance(str, (TimeZone) null, locale);
    }

    public static FastDateFormat getTimeInstance(int i2, TimeZone timeZone) {
        return cache.getTimeInstance(i2, timeZone, (Locale) null);
    }

    public String format(Date date) {
        return this.printer.format(date);
    }

    public static FastDateFormat getDateInstance(int i2, TimeZone timeZone, Locale locale) {
        return cache.getDateInstance(i2, timeZone, locale);
    }

    public static FastDateFormat getDateTimeInstance(int i2, int i3, TimeZone timeZone, Locale locale) {
        return cache.getDateTimeInstance(i2, i3, timeZone, locale);
    }

    public static FastDateFormat getInstance(String str, TimeZone timeZone) {
        return cache.getInstance(str, timeZone, (Locale) null);
    }

    public static FastDateFormat getTimeInstance(int i2, TimeZone timeZone, Locale locale) {
        return cache.getTimeInstance(i2, timeZone, locale);
    }

    public StringBuffer format(long j2, StringBuffer stringBuffer) {
        return this.printer.format(j2, stringBuffer);
    }

    public static FastDateFormat getInstance(String str, TimeZone timeZone, Locale locale) {
        return cache.getInstance(str, timeZone, locale);
    }

    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return this.printer.format(obj, stringBuffer, fieldPosition);
    }

    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        return this.printer.format(calendar, stringBuffer);
    }

    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        return this.printer.format(date, stringBuffer);
    }
}
