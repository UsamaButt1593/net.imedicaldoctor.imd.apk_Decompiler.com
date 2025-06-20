package org.apache.commons.lang3.time;

import com.dd.plist.ASCIIPropertyListParser;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.lang3.Validate;

public class FastDatePrinter implements DatePrinter, Serializable {
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private static final ConcurrentMap<TimeZoneDisplayKey, String> cTimeZoneDisplayCache = new ConcurrentHashMap(7);
    private static final long serialVersionUID = 1;
    private final Locale mLocale;
    private transient int mMaxLengthEstimate;
    private final String mPattern;
    private transient Rule[] mRules;
    private final TimeZone mTimeZone;

    private static class CharacterLiteral implements Rule {
        private final char mValue;

        CharacterLiteral(char c2) {
            this.mValue = c2;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.mValue);
        }

        public int estimateLength() {
            return 1;
        }
    }

    private interface NumberRule extends Rule {
        void appendTo(StringBuffer stringBuffer, int i2);
    }

    private static class PaddedNumberField implements NumberRule {
        private final int mField;
        private final int mSize;

        PaddedNumberField(int i2, int i3) {
            if (i3 >= 3) {
                this.mField = i2;
                this.mSize = i3;
                return;
            }
            throw new IllegalArgumentException();
        }

        public final void appendTo(StringBuffer stringBuffer, int i2) {
            int i3;
            if (i2 < 100) {
                int i4 = this.mSize;
                while (true) {
                    i4--;
                    if (i4 >= 2) {
                        stringBuffer.append('0');
                    } else {
                        stringBuffer.append((char) ((i2 / 10) + 48));
                        stringBuffer.append((char) ((i2 % 10) + 48));
                        return;
                    }
                }
            } else {
                if (i2 < 1000) {
                    i3 = 3;
                } else {
                    Validate.isTrue(i2 > -1, "Negative values should not be possible", (long) i2);
                    i3 = Integer.toString(i2).length();
                }
                int i5 = this.mSize;
                while (true) {
                    i5--;
                    if (i5 >= i3) {
                        stringBuffer.append('0');
                    } else {
                        stringBuffer.append(Integer.toString(i2));
                        return;
                    }
                }
            }
        }

        public int estimateLength() {
            return 4;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(this.mField));
        }
    }

    private interface Rule {
        void appendTo(StringBuffer stringBuffer, Calendar calendar);

        int estimateLength();
    }

    private static class StringLiteral implements Rule {
        private final String mValue;

        StringLiteral(String str) {
            this.mValue = str;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.mValue);
        }

        public int estimateLength() {
            return this.mValue.length();
        }
    }

    private static class TextField implements Rule {
        private final int mField;
        private final String[] mValues;

        TextField(int i2, String[] strArr) {
            this.mField = i2;
            this.mValues = strArr;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.mValues[calendar.get(this.mField)]);
        }

        public int estimateLength() {
            int length = this.mValues.length;
            int i2 = 0;
            while (true) {
                length--;
                if (length < 0) {
                    return i2;
                }
                int length2 = this.mValues[length].length();
                if (length2 > i2) {
                    i2 = length2;
                }
            }
        }
    }

    private static class TimeZoneDisplayKey {
        private final Locale mLocale;
        private final int mStyle;
        private final TimeZone mTimeZone;

        TimeZoneDisplayKey(TimeZone timeZone, boolean z, int i2, Locale locale) {
            this.mTimeZone = timeZone;
            if (z) {
                this.mStyle = Integer.MIN_VALUE | i2;
            } else {
                this.mStyle = i2;
            }
            this.mLocale = locale;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TimeZoneDisplayKey)) {
                return false;
            }
            TimeZoneDisplayKey timeZoneDisplayKey = (TimeZoneDisplayKey) obj;
            return this.mTimeZone.equals(timeZoneDisplayKey.mTimeZone) && this.mStyle == timeZoneDisplayKey.mStyle && this.mLocale.equals(timeZoneDisplayKey.mLocale);
        }

        public int hashCode() {
            return (((this.mStyle * 31) + this.mLocale.hashCode()) * 31) + this.mTimeZone.hashCode();
        }
    }

    private static class TimeZoneNameRule implements Rule {
        private final String mDaylight;
        private final Locale mLocale;
        private final String mStandard;
        private final int mStyle;

        TimeZoneNameRule(TimeZone timeZone, Locale locale, int i2) {
            this.mLocale = locale;
            this.mStyle = i2;
            this.mStandard = FastDatePrinter.getTimeZoneDisplay(timeZone, false, i2, locale);
            this.mDaylight = FastDatePrinter.getTimeZoneDisplay(timeZone, true, i2, locale);
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            int i2;
            Locale locale;
            boolean z;
            TimeZone timeZone = calendar.getTimeZone();
            if (!timeZone.useDaylightTime() || calendar.get(16) == 0) {
                i2 = this.mStyle;
                locale = this.mLocale;
                z = false;
            } else {
                i2 = this.mStyle;
                locale = this.mLocale;
                z = true;
            }
            stringBuffer.append(FastDatePrinter.getTimeZoneDisplay(timeZone, z, i2, locale));
        }

        public int estimateLength() {
            return Math.max(this.mStandard.length(), this.mDaylight.length());
        }
    }

    private static class TimeZoneNumberRule implements Rule {
        static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true);
        static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
        final boolean mColon;

        TimeZoneNumberRule(boolean z) {
            this.mColon = z;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            int i2 = calendar.get(15) + calendar.get(16);
            if (i2 < 0) {
                stringBuffer.append('-');
                i2 = -i2;
            } else {
                stringBuffer.append('+');
            }
            int i3 = i2 / 3600000;
            stringBuffer.append((char) ((i3 / 10) + 48));
            stringBuffer.append((char) ((i3 % 10) + 48));
            if (this.mColon) {
                stringBuffer.append(ASCIIPropertyListParser.A);
            }
            int i4 = (i2 / 60000) - (i3 * 60);
            stringBuffer.append((char) ((i4 / 10) + 48));
            stringBuffer.append((char) ((i4 % 10) + 48));
        }

        public int estimateLength() {
            return 5;
        }
    }

    private static class TwelveHourField implements NumberRule {
        private final NumberRule mRule;

        TwelveHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        public void appendTo(StringBuffer stringBuffer, int i2) {
            this.mRule.appendTo(stringBuffer, i2);
        }

        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            int i2 = calendar.get(10);
            if (i2 == 0) {
                i2 = calendar.getLeastMaximum(10) + 1;
            }
            this.mRule.appendTo(stringBuffer, i2);
        }
    }

    private static class TwentyFourHourField implements NumberRule {
        private final NumberRule mRule;

        TwentyFourHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        public void appendTo(StringBuffer stringBuffer, int i2) {
            this.mRule.appendTo(stringBuffer, i2);
        }

        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            int i2 = calendar.get(11);
            if (i2 == 0) {
                i2 = calendar.getMaximum(11) + 1;
            }
            this.mRule.appendTo(stringBuffer, i2);
        }
    }

    private static class TwoDigitMonthField implements NumberRule {
        static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();

        TwoDigitMonthField() {
        }

        public final void appendTo(StringBuffer stringBuffer, int i2) {
            stringBuffer.append((char) ((i2 / 10) + 48));
            stringBuffer.append((char) ((i2 % 10) + 48));
        }

        public int estimateLength() {
            return 2;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(2) + 1);
        }
    }

    private static class TwoDigitNumberField implements NumberRule {
        private final int mField;

        TwoDigitNumberField(int i2) {
            this.mField = i2;
        }

        public final void appendTo(StringBuffer stringBuffer, int i2) {
            if (i2 < 100) {
                stringBuffer.append((char) ((i2 / 10) + 48));
                stringBuffer.append((char) ((i2 % 10) + 48));
                return;
            }
            stringBuffer.append(Integer.toString(i2));
        }

        public int estimateLength() {
            return 2;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(this.mField));
        }
    }

    private static class TwoDigitYearField implements NumberRule {
        static final TwoDigitYearField INSTANCE = new TwoDigitYearField();

        TwoDigitYearField() {
        }

        public final void appendTo(StringBuffer stringBuffer, int i2) {
            stringBuffer.append((char) ((i2 / 10) + 48));
            stringBuffer.append((char) ((i2 % 10) + 48));
        }

        public int estimateLength() {
            return 2;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(1) % 100);
        }
    }

    private static class UnpaddedMonthField implements NumberRule {
        static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();

        UnpaddedMonthField() {
        }

        public final void appendTo(StringBuffer stringBuffer, int i2) {
            if (i2 >= 10) {
                stringBuffer.append((char) ((i2 / 10) + 48));
                i2 %= 10;
            }
            stringBuffer.append((char) (i2 + 48));
        }

        public int estimateLength() {
            return 2;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(2) + 1);
        }
    }

    private static class UnpaddedNumberField implements NumberRule {
        private final int mField;

        UnpaddedNumberField(int i2) {
            this.mField = i2;
        }

        public final void appendTo(StringBuffer stringBuffer, int i2) {
            if (i2 >= 10) {
                if (i2 < 100) {
                    stringBuffer.append((char) ((i2 / 10) + 48));
                    i2 %= 10;
                } else {
                    stringBuffer.append(Integer.toString(i2));
                    return;
                }
            }
            stringBuffer.append((char) (i2 + 48));
        }

        public int estimateLength() {
            return 4;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(this.mField));
        }
    }

    protected FastDatePrinter(String str, TimeZone timeZone, Locale locale) {
        this.mPattern = str;
        this.mTimeZone = timeZone;
        this.mLocale = locale;
        init();
    }

    private String applyRulesToString(Calendar calendar) {
        return applyRules(calendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
    }

    static String getTimeZoneDisplay(TimeZone timeZone, boolean z, int i2, Locale locale) {
        TimeZoneDisplayKey timeZoneDisplayKey = new TimeZoneDisplayKey(timeZone, z, i2, locale);
        ConcurrentMap<TimeZoneDisplayKey, String> concurrentMap = cTimeZoneDisplayCache;
        String str = concurrentMap.get(timeZoneDisplayKey);
        if (str != null) {
            return str;
        }
        String displayName = timeZone.getDisplayName(z, i2, locale);
        String putIfAbsent = concurrentMap.putIfAbsent(timeZoneDisplayKey, displayName);
        return putIfAbsent != null ? putIfAbsent : displayName;
    }

    private void init() {
        List<Rule> parsePattern = parsePattern();
        Rule[] ruleArr = (Rule[]) parsePattern.toArray(new Rule[parsePattern.size()]);
        this.mRules = ruleArr;
        int length = ruleArr.length;
        int i2 = 0;
        while (true) {
            length--;
            if (length >= 0) {
                i2 += this.mRules[length].estimateLength();
            } else {
                this.mMaxLengthEstimate = i2;
                return;
            }
        }
    }

    private GregorianCalendar newCalendar() {
        return new GregorianCalendar(this.mTimeZone, this.mLocale);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init();
    }

    /* access modifiers changed from: protected */
    public StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        for (Rule appendTo : this.mRules) {
            appendTo.appendTo(stringBuffer, calendar);
        }
        return stringBuffer;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDatePrinter)) {
            return false;
        }
        FastDatePrinter fastDatePrinter = (FastDatePrinter) obj;
        return this.mPattern.equals(fastDatePrinter.mPattern) && this.mTimeZone.equals(fastDatePrinter.mTimeZone) && this.mLocale.equals(fastDatePrinter.mLocale);
    }

    public String format(long j2) {
        GregorianCalendar newCalendar = newCalendar();
        newCalendar.setTimeInMillis(j2);
        return applyRulesToString(newCalendar);
    }

    public Locale getLocale() {
        return this.mLocale;
    }

    public int getMaxLengthEstimate() {
        return this.mMaxLengthEstimate;
    }

    public String getPattern() {
        return this.mPattern;
    }

    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    public int hashCode() {
        return this.mPattern.hashCode() + ((this.mTimeZone.hashCode() + (this.mLocale.hashCode() * 13)) * 13);
    }

    /* access modifiers changed from: protected */
    public List<Rule> parsePattern() {
        Object obj;
        int i2;
        Object obj2;
        int i3;
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
        ArrayList arrayList = new ArrayList();
        String[] eras = dateFormatSymbols.getEras();
        String[] months = dateFormatSymbols.getMonths();
        String[] shortMonths = dateFormatSymbols.getShortMonths();
        String[] weekdays = dateFormatSymbols.getWeekdays();
        String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
        String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
        int length = this.mPattern.length();
        int i4 = 0;
        while (i4 < length) {
            int[] iArr = {i4};
            String parseToken = parseToken(this.mPattern, iArr);
            int i5 = iArr[0];
            int length2 = parseToken.length();
            if (length2 == 0) {
                return arrayList;
            }
            char charAt = parseToken.charAt(0);
            if (charAt != 'y') {
                if (charAt != 'z') {
                    switch (charAt) {
                        case '\'':
                            String substring = parseToken.substring(1);
                            if (substring.length() != 1) {
                                obj = new StringLiteral(substring);
                                break;
                            } else {
                                obj = new CharacterLiteral(substring.charAt(0));
                                break;
                            }
                        case 'K':
                            i3 = 10;
                            break;
                        case 'M':
                            if (length2 < 4) {
                                if (length2 != 3) {
                                    if (length2 != 2) {
                                        obj2 = UnpaddedMonthField.INSTANCE;
                                        break;
                                    } else {
                                        obj2 = TwoDigitMonthField.INSTANCE;
                                        break;
                                    }
                                } else {
                                    obj2 = new TextField(2, shortMonths);
                                    break;
                                }
                            } else {
                                obj2 = new TextField(2, months);
                                break;
                            }
                        case 'S':
                            i3 = 14;
                            break;
                        case 'W':
                            i3 = 4;
                            break;
                        case 'Z':
                            if (length2 != 1) {
                                obj2 = TimeZoneNumberRule.INSTANCE_COLON;
                                break;
                            } else {
                                obj2 = TimeZoneNumberRule.INSTANCE_NO_COLON;
                                break;
                            }
                        case 'a':
                            obj2 = new TextField(9, amPmStrings);
                            break;
                        case 'd':
                            i3 = 5;
                            break;
                        case 'h':
                            obj2 = new TwelveHourField(selectNumberRule(10, length2));
                            break;
                        case 'k':
                            obj2 = new TwentyFourHourField(selectNumberRule(11, length2));
                            break;
                        case 'm':
                            i3 = 12;
                            break;
                        case 's':
                            i3 = 13;
                            break;
                        case 'w':
                            obj2 = selectNumberRule(3, length2);
                            break;
                        default:
                            switch (charAt) {
                                case 'D':
                                    i3 = 6;
                                    break;
                                case 'E':
                                    obj2 = new TextField(7, length2 < 4 ? shortWeekdays : weekdays);
                                    break;
                                case 'F':
                                    i3 = 8;
                                    break;
                                case 'G':
                                    obj2 = new TextField(0, eras);
                                    break;
                                case 'H':
                                    obj2 = selectNumberRule(11, length2);
                                    break;
                                default:
                                    throw new IllegalArgumentException("Illegal pattern component: " + parseToken);
                            }
                    }
                    obj2 = selectNumberRule(i3, length2);
                } else {
                    obj2 = length2 >= 4 ? new TimeZoneNameRule(this.mTimeZone, this.mLocale, 1) : new TimeZoneNameRule(this.mTimeZone, this.mLocale, 0);
                }
            } else if (length2 == 2) {
                obj2 = TwoDigitYearField.INSTANCE;
            } else {
                if (length2 < 4) {
                    i2 = 1;
                    length2 = 4;
                } else {
                    i2 = 1;
                }
                obj = selectNumberRule(i2, length2);
                arrayList.add(obj);
                i4 = i5 + i2;
            }
            obj = obj2;
            i2 = 1;
            arrayList.add(obj);
            i4 = i5 + i2;
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public String parseToken(String str, int[] iArr) {
        StringBuilder sb = new StringBuilder();
        int i2 = iArr[0];
        int length = str.length();
        char charAt = str.charAt(i2);
        if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
            sb.append(charAt);
            while (true) {
                int i3 = i2 + 1;
                if (i3 >= length || str.charAt(i3) != charAt) {
                    break;
                }
                sb.append(charAt);
                i2 = i3;
            }
        } else {
            sb.append('\'');
            boolean z = false;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                char charAt2 = str.charAt(i2);
                if (charAt2 == '\'') {
                    int i4 = i2 + 1;
                    if (i4 >= length || str.charAt(i4) != '\'') {
                        z = !z;
                    } else {
                        sb.append(charAt2);
                        i2 = i4;
                    }
                } else if (z || ((charAt2 < 'A' || charAt2 > 'Z') && (charAt2 < 'a' || charAt2 > 'z'))) {
                    sb.append(charAt2);
                }
                i2++;
            }
            i2--;
        }
        iArr[0] = i2;
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public NumberRule selectNumberRule(int i2, int i3) {
        return i3 != 1 ? i3 != 2 ? new PaddedNumberField(i2, i3) : new TwoDigitNumberField(i2) : new UnpaddedNumberField(i2);
    }

    public String toString() {
        return "FastDatePrinter[" + this.mPattern + "," + this.mLocale + "," + this.mTimeZone.getID() + "]";
    }

    public String format(Calendar calendar) {
        return format(calendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
    }

    public String format(Date date) {
        GregorianCalendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return applyRulesToString(newCalendar);
    }

    public StringBuffer format(long j2, StringBuffer stringBuffer) {
        return format(new Date(j2), stringBuffer);
    }

    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof Date) {
            return format((Date) obj, stringBuffer);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj, stringBuffer);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue(), stringBuffer);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown class: ");
        sb.append(obj == null ? "<null>" : obj.getClass().getName());
        throw new IllegalArgumentException(sb.toString());
    }

    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        return applyRules(calendar, stringBuffer);
    }

    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        GregorianCalendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return applyRules(newCalendar, stringBuffer);
    }
}
