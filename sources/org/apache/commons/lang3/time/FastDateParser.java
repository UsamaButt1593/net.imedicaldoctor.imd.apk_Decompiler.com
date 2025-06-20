package org.apache.commons.lang3.time;

import com.dd.plist.ASCIIPropertyListParser;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FastDateParser implements DateParser, Serializable {
    private static final Strategy ABBREVIATED_YEAR_STRATEGY = new NumberStrategy(1) {
        /* access modifiers changed from: package-private */
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            int parseInt = Integer.parseInt(str);
            if (parseInt < 100) {
                parseInt = fastDateParser.adjustYear(parseInt);
            }
            calendar.set(1, parseInt);
        }
    };
    private static final Strategy DAY_OF_MONTH_STRATEGY = new NumberStrategy(5);
    private static final Strategy DAY_OF_WEEK_IN_MONTH_STRATEGY = new NumberStrategy(8);
    private static final Strategy DAY_OF_YEAR_STRATEGY = new NumberStrategy(6);
    private static final Strategy HOUR_OF_DAY_STRATEGY = new NumberStrategy(11);
    private static final Strategy HOUR_STRATEGY = new NumberStrategy(10);
    static final Locale JAPANESE_IMPERIAL = new Locale("ja", "JP", "JP");
    private static final Strategy LITERAL_YEAR_STRATEGY = new NumberStrategy(1);
    private static final Strategy MILLISECOND_STRATEGY = new NumberStrategy(14);
    private static final Strategy MINUTE_STRATEGY = new NumberStrategy(12);
    private static final Strategy MODULO_HOUR_OF_DAY_STRATEGY = new NumberStrategy(11) {
        /* access modifiers changed from: package-private */
        public int modify(int i2) {
            return i2 % 24;
        }
    };
    private static final Strategy MODULO_HOUR_STRATEGY = new NumberStrategy(10) {
        /* access modifiers changed from: package-private */
        public int modify(int i2) {
            return i2 % 12;
        }
    };
    private static final Strategy NUMBER_MONTH_STRATEGY = new NumberStrategy(2) {
        /* access modifiers changed from: package-private */
        public int modify(int i2) {
            return i2 - 1;
        }
    };
    private static final Strategy SECOND_STRATEGY = new NumberStrategy(13);
    private static final Strategy WEEK_OF_MONTH_STRATEGY = new NumberStrategy(4);
    private static final Strategy WEEK_OF_YEAR_STRATEGY = new NumberStrategy(3);
    private static final ConcurrentMap<Locale, Strategy>[] caches = new ConcurrentMap[17];
    private static final Pattern formatPattern = Pattern.compile("D+|E+|F+|G+|H+|K+|M+|S+|W+|Z+|a+|d+|h+|k+|m+|s+|w+|y+|z+|''|'[^']++(''[^']*+)*+'|[^'A-Za-z]++");
    private static final long serialVersionUID = 2;
    private final int century;
    private transient String currentFormatField;
    private final Locale locale;
    private transient Strategy nextStrategy;
    private transient Pattern parsePattern;
    private final String pattern;
    private final int startYear;
    private transient Strategy[] strategies;
    private final TimeZone timeZone;

    private static class CopyQuotedStrategy extends Strategy {
        private final String formatField;

        CopyQuotedStrategy(String str) {
            super();
            this.formatField = str;
        }

        /* access modifiers changed from: package-private */
        public boolean addRegex(FastDateParser fastDateParser, StringBuilder sb) {
            StringBuilder unused = FastDateParser.escapeRegex(sb, this.formatField, true);
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean isNumber() {
            char charAt = this.formatField.charAt(0);
            if (charAt == '\'') {
                charAt = this.formatField.charAt(1);
            }
            return Character.isDigit(charAt);
        }
    }

    private static class NumberStrategy extends Strategy {
        private final int field;

        NumberStrategy(int i2) {
            super();
            this.field = i2;
        }

        /* access modifiers changed from: package-private */
        public boolean addRegex(FastDateParser fastDateParser, StringBuilder sb) {
            String str;
            if (fastDateParser.isNextNumber()) {
                sb.append("(\\p{Nd}{");
                sb.append(fastDateParser.getFieldWidth());
                str = "}+)";
            } else {
                str = "(\\p{Nd}++)";
            }
            sb.append(str);
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean isNumber() {
            return true;
        }

        /* access modifiers changed from: package-private */
        public int modify(int i2) {
            return i2;
        }

        /* access modifiers changed from: package-private */
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            calendar.set(this.field, modify(Integer.parseInt(str)));
        }
    }

    private static abstract class Strategy {
        private Strategy() {
        }

        /* access modifiers changed from: package-private */
        public abstract boolean addRegex(FastDateParser fastDateParser, StringBuilder sb);

        /* access modifiers changed from: package-private */
        public boolean isNumber() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
        }
    }

    private static class TextStrategy extends Strategy {
        private final int field;
        private final Map<String, Integer> keyValues;

        TextStrategy(int i2, Calendar calendar, Locale locale) {
            super();
            this.field = i2;
            this.keyValues = FastDateParser.getDisplayNames(i2, calendar, locale);
        }

        /* access modifiers changed from: package-private */
        public boolean addRegex(FastDateParser fastDateParser, StringBuilder sb) {
            sb.append(ASCIIPropertyListParser.f18649g);
            for (String access$100 : this.keyValues.keySet()) {
                FastDateParser.escapeRegex(sb, access$100, false).append('|');
            }
            sb.setCharAt(sb.length() - 1, ASCIIPropertyListParser.f18650h);
            return true;
        }

        /* access modifiers changed from: package-private */
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            Integer num = this.keyValues.get(str);
            if (num == null) {
                StringBuilder sb = new StringBuilder(str);
                sb.append(" not in (");
                for (String append : this.keyValues.keySet()) {
                    sb.append(append);
                    sb.append(' ');
                }
                sb.setCharAt(sb.length() - 1, ASCIIPropertyListParser.f18650h);
                throw new IllegalArgumentException(sb.toString());
            }
            calendar.set(this.field, num.intValue());
        }
    }

    private static class TimeZoneStrategy extends Strategy {
        private static final int ID = 0;
        private static final int LONG_DST = 3;
        private static final int LONG_STD = 1;
        private static final int SHORT_DST = 4;
        private static final int SHORT_STD = 2;
        private final SortedMap<String, TimeZone> tzNames = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        private final String validTimeZoneChars;

        TimeZoneStrategy(Locale locale) {
            super();
            for (String[] strArr : DateFormatSymbols.getInstance(locale).getZoneStrings()) {
                if (!strArr[0].startsWith("GMT")) {
                    TimeZone timeZone = TimeZone.getTimeZone(strArr[0]);
                    if (!this.tzNames.containsKey(strArr[1])) {
                        this.tzNames.put(strArr[1], timeZone);
                    }
                    if (!this.tzNames.containsKey(strArr[2])) {
                        this.tzNames.put(strArr[2], timeZone);
                    }
                    if (timeZone.useDaylightTime()) {
                        if (!this.tzNames.containsKey(strArr[3])) {
                            this.tzNames.put(strArr[3], timeZone);
                        }
                        if (!this.tzNames.containsKey(strArr[4])) {
                            this.tzNames.put(strArr[4], timeZone);
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("(GMT[+\\-]\\d{0,1}\\d{2}|[+\\-]\\d{2}:?\\d{2}|");
            for (String access$100 : this.tzNames.keySet()) {
                FastDateParser.escapeRegex(sb, access$100, false).append('|');
            }
            sb.setCharAt(sb.length() - 1, ASCIIPropertyListParser.f18650h);
            this.validTimeZoneChars = sb.toString();
        }

        /* access modifiers changed from: package-private */
        public boolean addRegex(FastDateParser fastDateParser, StringBuilder sb) {
            sb.append(this.validTimeZoneChars);
            return true;
        }

        /* access modifiers changed from: package-private */
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            TimeZone timeZone;
            if (str.charAt(0) == '+' || str.charAt(0) == '-') {
                timeZone = TimeZone.getTimeZone("GMT" + str);
            } else if (str.startsWith("GMT")) {
                timeZone = TimeZone.getTimeZone(str);
            } else {
                timeZone = this.tzNames.get(str);
                if (timeZone == null) {
                    throw new IllegalArgumentException(str + " is not a supported timezone name");
                }
            }
            calendar.setTimeZone(timeZone);
        }
    }

    protected FastDateParser(String str, TimeZone timeZone2, Locale locale2) {
        this(str, timeZone2, locale2, (Date) null);
    }

    /* access modifiers changed from: private */
    public int adjustYear(int i2) {
        int i3 = this.century + i2;
        return i2 >= this.startYear ? i3 : i3 + 100;
    }

    /* access modifiers changed from: private */
    public static StringBuilder escapeRegex(StringBuilder sb, String str, boolean z) {
        sb.append("\\Q");
        int i2 = 0;
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (charAt != '\'') {
                if (charAt == '\\' && (i2 = i2 + 1) != str.length()) {
                    sb.append(charAt);
                    charAt = str.charAt(i2);
                    if (charAt == 'E') {
                        sb.append("E\\\\E\\");
                        charAt = 'Q';
                    }
                }
            } else if (!z) {
                continue;
            } else {
                i2++;
                if (i2 == str.length()) {
                    return sb;
                }
                charAt = str.charAt(i2);
            }
            sb.append(charAt);
            i2++;
        }
        sb.append("\\E");
        return sb;
    }

    private static ConcurrentMap<Locale, Strategy> getCache(int i2) {
        ConcurrentMap<Locale, Strategy> concurrentMap;
        ConcurrentMap<Locale, Strategy>[] concurrentMapArr = caches;
        synchronized (concurrentMapArr) {
            try {
                if (concurrentMapArr[i2] == null) {
                    concurrentMapArr[i2] = new ConcurrentHashMap(3);
                }
                concurrentMap = concurrentMapArr[i2];
            } catch (Throwable th) {
                throw th;
            }
        }
        return concurrentMap;
    }

    /* access modifiers changed from: private */
    public static Map<String, Integer> getDisplayNames(int i2, Calendar calendar, Locale locale2) {
        return calendar.getDisplayNames(i2, 0, locale2);
    }

    private Strategy getLocaleSpecificStrategy(int i2, Calendar calendar) {
        ConcurrentMap<Locale, Strategy> cache = getCache(i2);
        Strategy strategy = cache.get(this.locale);
        if (strategy == null) {
            strategy = i2 == 15 ? new TimeZoneStrategy(this.locale) : new TextStrategy(i2, calendar, this.locale);
            Strategy putIfAbsent = cache.putIfAbsent(this.locale, strategy);
            if (putIfAbsent != null) {
                return putIfAbsent;
            }
        }
        return strategy;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0071, code lost:
        return new org.apache.commons.lang3.time.FastDateParser.CopyQuotedStrategy(r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.apache.commons.lang3.time.FastDateParser.Strategy getStrategy(java.lang.String r5, java.util.Calendar r6) {
        /*
            r4 = this;
            r0 = 0
            char r1 = r5.charAt(r0)
            r2 = 121(0x79, float:1.7E-43)
            r3 = 2
            if (r1 == r2) goto L_0x0075
            r2 = 122(0x7a, float:1.71E-43)
            if (r1 == r2) goto L_0x0072
            switch(r1) {
                case 39: goto L_0x0056;
                case 75: goto L_0x0053;
                case 77: goto L_0x0044;
                case 83: goto L_0x0041;
                case 87: goto L_0x003e;
                case 90: goto L_0x0072;
                case 97: goto L_0x003b;
                case 100: goto L_0x0038;
                case 104: goto L_0x0035;
                case 107: goto L_0x0032;
                case 109: goto L_0x002f;
                case 115: goto L_0x002c;
                case 119: goto L_0x0029;
                default: goto L_0x0011;
            }
        L_0x0011:
            switch(r1) {
                case 68: goto L_0x0026;
                case 69: goto L_0x0020;
                case 70: goto L_0x001d;
                case 71: goto L_0x0018;
                case 72: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x006c
        L_0x0015:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = MODULO_HOUR_OF_DAY_STRATEGY
            return r5
        L_0x0018:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = r4.getLocaleSpecificStrategy(r0, r6)
            return r5
        L_0x001d:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = DAY_OF_WEEK_IN_MONTH_STRATEGY
            return r5
        L_0x0020:
            r5 = 7
        L_0x0021:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = r4.getLocaleSpecificStrategy(r5, r6)
            return r5
        L_0x0026:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = DAY_OF_YEAR_STRATEGY
            return r5
        L_0x0029:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = WEEK_OF_YEAR_STRATEGY
            return r5
        L_0x002c:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = SECOND_STRATEGY
            return r5
        L_0x002f:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = MINUTE_STRATEGY
            return r5
        L_0x0032:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = HOUR_OF_DAY_STRATEGY
            return r5
        L_0x0035:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = MODULO_HOUR_STRATEGY
            return r5
        L_0x0038:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = DAY_OF_MONTH_STRATEGY
            return r5
        L_0x003b:
            r5 = 9
            goto L_0x0021
        L_0x003e:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = WEEK_OF_MONTH_STRATEGY
            return r5
        L_0x0041:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = MILLISECOND_STRATEGY
            return r5
        L_0x0044:
            int r5 = r5.length()
            r0 = 3
            if (r5 < r0) goto L_0x0050
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = r4.getLocaleSpecificStrategy(r3, r6)
            goto L_0x0052
        L_0x0050:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = NUMBER_MONTH_STRATEGY
        L_0x0052:
            return r5
        L_0x0053:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = HOUR_STRATEGY
            return r5
        L_0x0056:
            int r6 = r5.length()
            if (r6 <= r3) goto L_0x006c
            org.apache.commons.lang3.time.FastDateParser$CopyQuotedStrategy r6 = new org.apache.commons.lang3.time.FastDateParser$CopyQuotedStrategy
            int r0 = r5.length()
            r1 = 1
            int r0 = r0 - r1
            java.lang.String r5 = r5.substring(r1, r0)
            r6.<init>(r5)
            return r6
        L_0x006c:
            org.apache.commons.lang3.time.FastDateParser$CopyQuotedStrategy r6 = new org.apache.commons.lang3.time.FastDateParser$CopyQuotedStrategy
            r6.<init>(r5)
            return r6
        L_0x0072:
            r5 = 15
            goto L_0x0021
        L_0x0075:
            int r5 = r5.length()
            if (r5 <= r3) goto L_0x007e
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = LITERAL_YEAR_STRATEGY
            goto L_0x0080
        L_0x007e:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = ABBREVIATED_YEAR_STRATEGY
        L_0x0080:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.FastDateParser.getStrategy(java.lang.String, java.util.Calendar):org.apache.commons.lang3.time.FastDateParser$Strategy");
    }

    private void init(Calendar calendar) {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        Matcher matcher = formatPattern.matcher(this.pattern);
        if (matcher.lookingAt()) {
            String group = matcher.group();
            this.currentFormatField = group;
            Strategy strategy = getStrategy(group, calendar);
            while (true) {
                matcher.region(matcher.end(), matcher.regionEnd());
                if (!matcher.lookingAt()) {
                    break;
                }
                String group2 = matcher.group();
                this.nextStrategy = getStrategy(group2, calendar);
                if (strategy.addRegex(this, sb)) {
                    arrayList.add(strategy);
                }
                this.currentFormatField = group2;
                strategy = this.nextStrategy;
            }
            this.nextStrategy = null;
            if (matcher.regionStart() == matcher.regionEnd()) {
                if (strategy.addRegex(this, sb)) {
                    arrayList.add(strategy);
                }
                this.currentFormatField = null;
                this.strategies = (Strategy[]) arrayList.toArray(new Strategy[arrayList.size()]);
                this.parsePattern = Pattern.compile(sb.toString());
                return;
            }
            throw new IllegalArgumentException("Failed to parse \"" + this.pattern + "\" ; gave up at index " + matcher.regionStart());
        }
        throw new IllegalArgumentException("Illegal pattern character '" + this.pattern.charAt(matcher.regionStart()) + "'");
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init(Calendar.getInstance(this.timeZone, this.locale));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDateParser)) {
            return false;
        }
        FastDateParser fastDateParser = (FastDateParser) obj;
        return this.pattern.equals(fastDateParser.pattern) && this.timeZone.equals(fastDateParser.timeZone) && this.locale.equals(fastDateParser.locale);
    }

    /* access modifiers changed from: package-private */
    public int getFieldWidth() {
        return this.currentFormatField.length();
    }

    public Locale getLocale() {
        return this.locale;
    }

    /* access modifiers changed from: package-private */
    public Pattern getParsePattern() {
        return this.parsePattern;
    }

    public String getPattern() {
        return this.pattern;
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public int hashCode() {
        return this.pattern.hashCode() + ((this.timeZone.hashCode() + (this.locale.hashCode() * 13)) * 13);
    }

    /* access modifiers changed from: package-private */
    public boolean isNextNumber() {
        Strategy strategy = this.nextStrategy;
        return strategy != null && strategy.isNumber();
    }

    public Date parse(String str) throws ParseException {
        Date parse = parse(str, new ParsePosition(0));
        if (parse != null) {
            return parse;
        }
        if (this.locale.equals(JAPANESE_IMPERIAL)) {
            throw new ParseException("(The " + this.locale + " locale does not support dates before 1868 AD)\n" + "Unparseable date: \"" + str + "\" does not match " + this.parsePattern.pattern(), 0);
        }
        throw new ParseException("Unparseable date: \"" + str + "\" does not match " + this.parsePattern.pattern(), 0);
    }

    public Object parseObject(String str) throws ParseException {
        return parse(str);
    }

    public String toString() {
        return "FastDateParser[" + this.pattern + "," + this.locale + "," + this.timeZone.getID() + "]";
    }

    protected FastDateParser(String str, TimeZone timeZone2, Locale locale2, Date date) {
        int i2;
        this.pattern = str;
        this.timeZone = timeZone2;
        this.locale = locale2;
        Calendar instance = Calendar.getInstance(timeZone2, locale2);
        if (date != null) {
            instance.setTime(date);
            i2 = instance.get(1);
        } else if (locale2.equals(JAPANESE_IMPERIAL)) {
            i2 = 0;
        } else {
            instance.setTime(new Date());
            i2 = instance.get(1) - 80;
        }
        int i3 = (i2 / 100) * 100;
        this.century = i3;
        this.startYear = i2 - i3;
        init(instance);
    }

    public Date parse(String str, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        Matcher matcher = this.parsePattern.matcher(str.substring(index));
        if (!matcher.lookingAt()) {
            return null;
        }
        Calendar instance = Calendar.getInstance(this.timeZone, this.locale);
        instance.clear();
        int i2 = 0;
        while (true) {
            Strategy[] strategyArr = this.strategies;
            if (i2 < strategyArr.length) {
                int i3 = i2 + 1;
                strategyArr[i2].setCalendar(this, instance, matcher.group(i3));
                i2 = i3;
            } else {
                parsePosition.setIndex(index + matcher.end());
                return instance.getTime();
            }
        }
    }

    public Object parseObject(String str, ParsePosition parsePosition) {
        return parse(str, parsePosition);
    }
}
