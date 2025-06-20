package org.apache.commons.lang3.time;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class DateUtils {
    public static final long MILLIS_PER_DAY = 86400000;
    public static final long MILLIS_PER_HOUR = 3600000;
    public static final long MILLIS_PER_MINUTE = 60000;
    public static final long MILLIS_PER_SECOND = 1000;
    private static final int MODIFY_CEILING = 2;
    private static final int MODIFY_ROUND = 1;
    private static final int MODIFY_TRUNCATE = 0;
    public static final int RANGE_MONTH_MONDAY = 6;
    public static final int RANGE_MONTH_SUNDAY = 5;
    public static final int RANGE_WEEK_CENTER = 4;
    public static final int RANGE_WEEK_MONDAY = 2;
    public static final int RANGE_WEEK_RELATIVE = 3;
    public static final int RANGE_WEEK_SUNDAY = 1;
    public static final int SEMI_MONTH = 1001;
    private static final int[][] fields = {new int[]{14}, new int[]{13}, new int[]{12}, new int[]{11, 10}, new int[]{5, 5, 9}, new int[]{2, 1001}, new int[]{1}, new int[]{0}};

    static class DateIterator implements Iterator<Calendar> {
        private final Calendar endFinal;
        private final Calendar spot;

        DateIterator(Calendar calendar, Calendar calendar2) {
            this.endFinal = calendar2;
            this.spot = calendar;
            calendar.add(5, -1);
        }

        public boolean hasNext() {
            return this.spot.before(this.endFinal);
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Calendar next() {
            if (!this.spot.equals(this.endFinal)) {
                this.spot.add(5, 1);
                return (Calendar) this.spot.clone();
            }
            throw new NoSuchElementException();
        }
    }

    private static Date add(Date date, int i2, int i3) {
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            instance.add(i2, i3);
            return instance.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date addDays(Date date, int i2) {
        return add(date, 5, i2);
    }

    public static Date addHours(Date date, int i2) {
        return add(date, 11, i2);
    }

    public static Date addMilliseconds(Date date, int i2) {
        return add(date, 14, i2);
    }

    public static Date addMinutes(Date date, int i2) {
        return add(date, 12, i2);
    }

    public static Date addMonths(Date date, int i2) {
        return add(date, 2, i2);
    }

    public static Date addSeconds(Date date, int i2) {
        return add(date, 13, i2);
    }

    public static Date addWeeks(Date date, int i2) {
        return add(date, 3, i2);
    }

    public static Date addYears(Date date, int i2) {
        return add(date, 1, i2);
    }

    public static Calendar ceiling(Calendar calendar, int i2) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i2, 2);
            return calendar2;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    private static long getFragment(Calendar calendar, int i2, TimeUnit timeUnit) {
        long j2;
        int i3;
        if (calendar != null) {
            TimeUnit timeUnit2 = TimeUnit.DAYS;
            int i4 = timeUnit == timeUnit2 ? 0 : 1;
            if (i2 == 1) {
                i3 = calendar.get(6);
            } else if (i2 != 2) {
                j2 = 0;
                if (i2 != 1 || i2 == 2 || i2 == 5 || i2 == 6) {
                    j2 += timeUnit.convert((long) calendar.get(11), TimeUnit.HOURS);
                } else {
                    switch (i2) {
                        case 11:
                            break;
                        case 12:
                            break;
                        case 13:
                            break;
                        case 14:
                            return j2;
                        default:
                            throw new IllegalArgumentException("The fragment " + i2 + " is not supported");
                    }
                }
                j2 += timeUnit.convert((long) calendar.get(12), TimeUnit.MINUTES);
                j2 += timeUnit.convert((long) calendar.get(13), TimeUnit.SECONDS);
                return j2 + timeUnit.convert((long) calendar.get(14), TimeUnit.MILLISECONDS);
            } else {
                i3 = calendar.get(5);
            }
            j2 = timeUnit.convert((long) (i3 - i4), timeUnit2);
            if (i2 != 1) {
            }
            j2 += timeUnit.convert((long) calendar.get(11), TimeUnit.HOURS);
            j2 += timeUnit.convert((long) calendar.get(12), TimeUnit.MINUTES);
            j2 += timeUnit.convert((long) calendar.get(13), TimeUnit.SECONDS);
            return j2 + timeUnit.convert((long) calendar.get(14), TimeUnit.MILLISECONDS);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static long getFragmentInDays(Calendar calendar, int i2) {
        return getFragment(calendar, i2, TimeUnit.DAYS);
    }

    public static long getFragmentInHours(Calendar calendar, int i2) {
        return getFragment(calendar, i2, TimeUnit.HOURS);
    }

    public static long getFragmentInMilliseconds(Calendar calendar, int i2) {
        return getFragment(calendar, i2, TimeUnit.MILLISECONDS);
    }

    public static long getFragmentInMinutes(Calendar calendar, int i2) {
        return getFragment(calendar, i2, TimeUnit.MINUTES);
    }

    public static long getFragmentInSeconds(Calendar calendar, int i2) {
        return getFragment(calendar, i2, TimeUnit.SECONDS);
    }

    public static boolean isSameDay(Calendar calendar, Calendar calendar2) {
        if (calendar != null && calendar2 != null) {
            return calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static boolean isSameInstant(Calendar calendar, Calendar calendar2) {
        if (calendar != null && calendar2 != null) {
            return calendar.getTime().getTime() == calendar2.getTime().getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static boolean isSameLocalTime(Calendar calendar, Calendar calendar2) {
        if (calendar != null && calendar2 != null) {
            return calendar.get(14) == calendar2.get(14) && calendar.get(13) == calendar2.get(13) && calendar.get(12) == calendar2.get(12) && calendar.get(11) == calendar2.get(11) && calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1) && calendar.get(0) == calendar2.get(0) && calendar.getClass() == calendar2.getClass();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Iterator<?> iterator(Object obj, int i2) {
        if (obj == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (obj instanceof Date) {
            return iterator((Date) obj, i2);
        } else {
            if (obj instanceof Calendar) {
                return iterator((Calendar) obj, i2);
            }
            throw new ClassCastException("Could not iterate based on " + obj);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:81:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x012d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void modify(java.util.Calendar r16, int r17, int r18) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = 1
            int r4 = r0.get(r3)
            r5 = 280000000(0x10b07600, float:6.960157E-29)
            if (r4 > r5) goto L_0x014f
            r4 = 14
            if (r1 != r4) goto L_0x0015
            return
        L_0x0015:
            java.util.Date r5 = r16.getTime()
            long r6 = r5.getTime()
            int r4 = r0.get(r4)
            if (r2 == 0) goto L_0x0027
            r8 = 500(0x1f4, float:7.0E-43)
            if (r4 >= r8) goto L_0x0029
        L_0x0027:
            long r8 = (long) r4
            long r6 = r6 - r8
        L_0x0029:
            r4 = 13
            if (r1 != r4) goto L_0x002f
            r9 = 1
            goto L_0x0030
        L_0x002f:
            r9 = 0
        L_0x0030:
            int r4 = r0.get(r4)
            r10 = 30
            if (r9 != 0) goto L_0x0042
            if (r2 == 0) goto L_0x003c
            if (r4 >= r10) goto L_0x0042
        L_0x003c:
            long r11 = (long) r4
            r13 = 1000(0x3e8, double:4.94E-321)
            long r11 = r11 * r13
            long r6 = r6 - r11
        L_0x0042:
            r4 = 12
            if (r1 != r4) goto L_0x0047
            r9 = 1
        L_0x0047:
            int r11 = r0.get(r4)
            if (r9 != 0) goto L_0x0058
            if (r2 == 0) goto L_0x0051
            if (r11 >= r10) goto L_0x0058
        L_0x0051:
            long r9 = (long) r11
            r11 = 60000(0xea60, double:2.9644E-319)
            long r9 = r9 * r11
            long r6 = r6 - r9
        L_0x0058:
            long r9 = r5.getTime()
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 == 0) goto L_0x0066
            r5.setTime(r6)
            r0.setTime(r5)
        L_0x0066:
            int[][] r5 = fields
            int r6 = r5.length
            r7 = 0
            r9 = 0
        L_0x006b:
            if (r7 >= r6) goto L_0x0133
            r10 = r5[r7]
            int r11 = r10.length
            r12 = 0
        L_0x0071:
            r14 = 15
            r15 = 1001(0x3e9, float:1.403E-42)
            r8 = 2
            r4 = 5
            if (r12 >= r11) goto L_0x00c0
            r13 = r10[r12]
            if (r13 != r1) goto L_0x00ba
            if (r2 == r8) goto L_0x0083
            if (r2 != r3) goto L_0x00b9
            if (r9 == 0) goto L_0x00b9
        L_0x0083:
            if (r1 != r15) goto L_0x0098
            int r1 = r0.get(r4)
            if (r1 != r3) goto L_0x008f
            r0.add(r4, r14)
            goto L_0x00b9
        L_0x008f:
            r1 = -15
            r0.add(r4, r1)
            r0.add(r8, r3)
            goto L_0x00b9
        L_0x0098:
            r2 = 9
            if (r1 != r2) goto L_0x00b3
            r1 = 11
            int r2 = r0.get(r1)
            if (r2 != 0) goto L_0x00aa
            r2 = 12
            r0.add(r1, r2)
            goto L_0x00b9
        L_0x00aa:
            r2 = -12
            r0.add(r1, r2)
            r0.add(r4, r3)
            goto L_0x00b9
        L_0x00b3:
            r13 = 0
            r1 = r10[r13]
            r0.add(r1, r3)
        L_0x00b9:
            return
        L_0x00ba:
            r13 = 0
            int r12 = r12 + 1
            r4 = 12
            goto L_0x0071
        L_0x00c0:
            r12 = 9
            r13 = 0
            if (r1 == r12) goto L_0x00e4
            if (r1 == r15) goto L_0x00ca
        L_0x00c7:
            r11 = 12
            goto L_0x00fe
        L_0x00ca:
            r11 = r10[r13]
            if (r11 != r4) goto L_0x00c7
            int r4 = r0.get(r4)
            int r9 = r4 + -1
            if (r9 < r14) goto L_0x00d9
            int r4 = r4 + -16
            goto L_0x00da
        L_0x00d9:
            r4 = r9
        L_0x00da:
            r9 = 7
            if (r4 <= r9) goto L_0x00df
            r9 = 1
            goto L_0x00e0
        L_0x00df:
            r9 = 0
        L_0x00e0:
            r11 = 12
        L_0x00e2:
            r13 = 1
            goto L_0x0100
        L_0x00e4:
            r4 = 0
            r11 = r10[r4]
            r4 = 11
            if (r11 != r4) goto L_0x00c7
            int r4 = r0.get(r4)
            r11 = 12
            if (r4 < r11) goto L_0x00f5
            int r4 = r4 + -12
        L_0x00f5:
            r13 = r4
            r4 = 6
            if (r13 < r4) goto L_0x00fb
            r9 = 1
            goto L_0x00fc
        L_0x00fb:
            r9 = 0
        L_0x00fc:
            r4 = r13
            goto L_0x00e2
        L_0x00fe:
            r4 = 0
            r13 = 0
        L_0x0100:
            if (r13 != 0) goto L_0x0120
            r13 = 0
            r4 = r10[r13]
            int r4 = r0.getActualMinimum(r4)
            r9 = r10[r13]
            int r9 = r0.getActualMaximum(r9)
            r12 = r10[r13]
            int r12 = r0.get(r12)
            int r12 = r12 - r4
            int r9 = r9 - r4
            int r9 = r9 / r8
            if (r12 <= r9) goto L_0x011c
            r4 = 1
            goto L_0x011d
        L_0x011c:
            r4 = 0
        L_0x011d:
            r9 = r4
            r4 = r12
            goto L_0x0121
        L_0x0120:
            r13 = 0
        L_0x0121:
            if (r4 == 0) goto L_0x012d
            r8 = r10[r13]
            int r10 = r0.get(r8)
            int r10 = r10 - r4
            r0.set(r8, r10)
        L_0x012d:
            int r7 = r7 + 1
            r4 = 12
            goto L_0x006b
        L_0x0133:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "The field "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = " is not supported"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x014f:
            java.lang.ArithmeticException r0 = new java.lang.ArithmeticException
            java.lang.String r1 = "Calendar value too large for accurate calculations"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.DateUtils.modify(java.util.Calendar, int, int):void");
    }

    public static Date parseDate(String str, Locale locale, String... strArr) throws ParseException {
        return parseDateWithLeniency(str, locale, strArr, true);
    }

    public static Date parseDateStrictly(String str, Locale locale, String... strArr) throws ParseException {
        return parseDateWithLeniency(str, (Locale) null, strArr, false);
    }

    private static Date parseDateWithLeniency(String str, Locale locale, String[] strArr, boolean z) throws ParseException {
        if (str == null || strArr == null) {
            throw new IllegalArgumentException("Date and Patterns must not be null");
        }
        SimpleDateFormat simpleDateFormat = locale == null ? new SimpleDateFormat() : new SimpleDateFormat("", locale);
        simpleDateFormat.setLenient(z);
        ParsePosition parsePosition = new ParsePosition(0);
        for (String str2 : strArr) {
            simpleDateFormat.applyPattern(str2.endsWith("ZZ") ? str2.substring(0, str2.length() - 1) : str2);
            parsePosition.setIndex(0);
            String replaceAll = str2.endsWith("ZZ") ? str.replaceAll("([-+][0-9][0-9]):([0-9][0-9])$", "$1$2") : str;
            Date parse = simpleDateFormat.parse(replaceAll, parsePosition);
            if (parse != null && parsePosition.getIndex() == replaceAll.length()) {
                return parse;
            }
        }
        throw new ParseException("Unable to parse the date: " + str, -1);
    }

    public static Calendar round(Calendar calendar, int i2) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i2, 1);
            return calendar2;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    private static Date set(Date date, int i2, int i3) {
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setLenient(false);
            instance.setTime(date);
            instance.set(i2, i3);
            return instance.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date setDays(Date date, int i2) {
        return set(date, 5, i2);
    }

    public static Date setHours(Date date, int i2) {
        return set(date, 11, i2);
    }

    public static Date setMilliseconds(Date date, int i2) {
        return set(date, 14, i2);
    }

    public static Date setMinutes(Date date, int i2) {
        return set(date, 12, i2);
    }

    public static Date setMonths(Date date, int i2) {
        return set(date, 2, i2);
    }

    public static Date setSeconds(Date date, int i2) {
        return set(date, 13, i2);
    }

    public static Date setYears(Date date, int i2) {
        return set(date, 1, i2);
    }

    public static Calendar toCalendar(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return instance;
    }

    public static Calendar truncate(Calendar calendar, int i2) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i2, 0);
            return calendar2;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static int truncatedCompareTo(Calendar calendar, Calendar calendar2, int i2) {
        return truncate(calendar, i2).compareTo(truncate(calendar2, i2));
    }

    public static boolean truncatedEquals(Calendar calendar, Calendar calendar2, int i2) {
        return truncatedCompareTo(calendar, calendar2, i2) == 0;
    }

    public static Date ceiling(Object obj, int i2) {
        if (obj == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (obj instanceof Date) {
            return ceiling((Date) obj, i2);
        } else {
            if (obj instanceof Calendar) {
                return ceiling((Calendar) obj, i2).getTime();
            }
            throw new ClassCastException("Could not find ceiling of for type: " + obj.getClass());
        }
    }

    private static long getFragment(Date date, int i2, TimeUnit timeUnit) {
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            return getFragment(instance, i2, timeUnit);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static long getFragmentInDays(Date date, int i2) {
        return getFragment(date, i2, TimeUnit.DAYS);
    }

    public static long getFragmentInHours(Date date, int i2) {
        return getFragment(date, i2, TimeUnit.HOURS);
    }

    public static long getFragmentInMilliseconds(Date date, int i2) {
        return getFragment(date, i2, TimeUnit.MILLISECONDS);
    }

    public static long getFragmentInMinutes(Date date, int i2) {
        return getFragment(date, i2, TimeUnit.MINUTES);
    }

    public static long getFragmentInSeconds(Date date, int i2) {
        return getFragment(date, i2, TimeUnit.SECONDS);
    }

    public static boolean isSameDay(Date date, Date date2) {
        if (date == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date2);
        return isSameDay(instance, instance2);
    }

    public static boolean isSameInstant(Date date, Date date2) {
        if (date != null && date2 != null) {
            return date.getTime() == date2.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003b, code lost:
        r8 = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Iterator<java.util.Calendar> iterator(java.util.Calendar r8, int r9) {
        /*
            if (r8 == 0) goto L_0x0091
            r0 = -1
            r1 = 5
            r2 = 2
            r3 = 1
            r4 = 7
            switch(r9) {
                case 1: goto L_0x0042;
                case 2: goto L_0x0042;
                case 3: goto L_0x0042;
                case 4: goto L_0x0042;
                case 5: goto L_0x0026;
                case 6: goto L_0x0026;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "The range style "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r9 = " is not valid."
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r8.<init>(r9)
            throw r8
        L_0x0026:
            java.util.Calendar r8 = truncate((java.util.Calendar) r8, (int) r2)
            java.lang.Object r5 = r8.clone()
            java.util.Calendar r5 = (java.util.Calendar) r5
            r5.add(r2, r3)
            r5.add(r1, r0)
            r6 = 6
            if (r9 != r6) goto L_0x003d
            r6 = r5
            r5 = r8
        L_0x003b:
            r8 = 1
            goto L_0x0067
        L_0x003d:
            r6 = r5
            r2 = 1
            r5 = r8
            r8 = 7
            goto L_0x0067
        L_0x0042:
            java.util.Calendar r5 = truncate((java.util.Calendar) r8, (int) r1)
            java.util.Calendar r6 = truncate((java.util.Calendar) r8, (int) r1)
            if (r9 == r2) goto L_0x003b
            r2 = 3
            if (r9 == r2) goto L_0x0061
            r7 = 4
            if (r9 == r7) goto L_0x0055
            r8 = 7
            r2 = 1
            goto L_0x0067
        L_0x0055:
            int r9 = r8.get(r4)
            int r9 = r9 - r2
            int r8 = r8.get(r4)
            int r8 = r8 + r2
            r2 = r9
            goto L_0x0067
        L_0x0061:
            int r2 = r8.get(r4)
            int r8 = r2 + -1
        L_0x0067:
            if (r2 >= r3) goto L_0x006b
            int r2 = r2 + 7
        L_0x006b:
            if (r2 <= r4) goto L_0x006f
            int r2 = r2 + -7
        L_0x006f:
            if (r8 >= r3) goto L_0x0073
            int r8 = r8 + 7
        L_0x0073:
            if (r8 <= r4) goto L_0x0077
            int r8 = r8 + -7
        L_0x0077:
            int r9 = r5.get(r4)
            if (r9 == r2) goto L_0x0081
            r5.add(r1, r0)
            goto L_0x0077
        L_0x0081:
            int r9 = r6.get(r4)
            if (r9 == r8) goto L_0x008b
            r6.add(r1, r3)
            goto L_0x0081
        L_0x008b:
            org.apache.commons.lang3.time.DateUtils$DateIterator r8 = new org.apache.commons.lang3.time.DateUtils$DateIterator
            r8.<init>(r5, r6)
            return r8
        L_0x0091:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "The date must not be null"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.DateUtils.iterator(java.util.Calendar, int):java.util.Iterator");
    }

    public static Date parseDate(String str, String... strArr) throws ParseException {
        return parseDate(str, (Locale) null, strArr);
    }

    public static Date parseDateStrictly(String str, String... strArr) throws ParseException {
        return parseDateStrictly(str, (Locale) null, strArr);
    }

    public static Date round(Object obj, int i2) {
        if (obj == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (obj instanceof Date) {
            return round((Date) obj, i2);
        } else {
            if (obj instanceof Calendar) {
                return round((Calendar) obj, i2).getTime();
            }
            throw new ClassCastException("Could not round " + obj);
        }
    }

    public static Date truncate(Object obj, int i2) {
        if (obj == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (obj instanceof Date) {
            return truncate((Date) obj, i2);
        } else {
            if (obj instanceof Calendar) {
                return truncate((Calendar) obj, i2).getTime();
            }
            throw new ClassCastException("Could not truncate " + obj);
        }
    }

    public static int truncatedCompareTo(Date date, Date date2, int i2) {
        return truncate(date, i2).compareTo(truncate(date2, i2));
    }

    public static boolean truncatedEquals(Date date, Date date2, int i2) {
        return truncatedCompareTo(date, date2, i2) == 0;
    }

    public static Date ceiling(Date date, int i2) {
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            modify(instance, i2, 2);
            return instance.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Iterator<Calendar> iterator(Date date, int i2) {
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            return iterator(instance, i2);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date round(Date date, int i2) {
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            modify(instance, i2, 1);
            return instance.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date truncate(Date date, int i2) {
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            modify(instance, i2, 0);
            return instance.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }
}
