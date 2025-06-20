package org.threeten.bp.chrono;

import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.ZoneId;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjusters;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.ValueRange;

public final class JapaneseChronology extends Chronology implements Serializable {
    static final Locale X2 = new Locale(e3, "JP", "JP");
    public static final JapaneseChronology Y2 = new JapaneseChronology();
    private static final long Z2 = 459996390165777884L;
    private static final Map<String, String[]> a3;
    private static final Map<String, String[]> b3;
    private static final Map<String, String[]> c3;
    private static final String d3 = "en";
    private static final String e3 = "ja";

    /* renamed from: org.threeten.bp.chrono.JapaneseChronology$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31792a;

        /* JADX WARNING: Can't wrap try/catch for region: R(48:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|48) */
        /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00fc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0108 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.threeten.bp.temporal.ChronoField[] r0 = org.threeten.bp.temporal.ChronoField.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31792a = r0
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.DAY_OF_MONTH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31792a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.DAY_OF_WEEK     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31792a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MICRO_OF_DAY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f31792a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MICRO_OF_SECOND     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f31792a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.HOUR_OF_DAY     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f31792a     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.HOUR_OF_AMPM     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f31792a     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MINUTE_OF_DAY     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f31792a     // Catch:{ NoSuchFieldError -> 0x0060 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MINUTE_OF_HOUR     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f31792a     // Catch:{ NoSuchFieldError -> 0x006c }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.SECOND_OF_DAY     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f31792a     // Catch:{ NoSuchFieldError -> 0x0078 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.SECOND_OF_MINUTE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f31792a     // Catch:{ NoSuchFieldError -> 0x0084 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MILLI_OF_DAY     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f31792a     // Catch:{ NoSuchFieldError -> 0x0090 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MILLI_OF_SECOND     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f31792a     // Catch:{ NoSuchFieldError -> 0x009c }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.NANO_OF_DAY     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f31792a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.NANO_OF_SECOND     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f31792a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.CLOCK_HOUR_OF_DAY     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f31792a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.CLOCK_HOUR_OF_AMPM     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f31792a     // Catch:{ NoSuchFieldError -> 0x00cc }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.EPOCH_DAY     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = f31792a     // Catch:{ NoSuchFieldError -> 0x00d8 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.PROLEPTIC_MONTH     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r0 = f31792a     // Catch:{ NoSuchFieldError -> 0x00e4 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ERA     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                int[] r0 = f31792a     // Catch:{ NoSuchFieldError -> 0x00f0 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                int[] r0 = f31792a     // Catch:{ NoSuchFieldError -> 0x00fc }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR_OF_ERA     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                int[] r0 = f31792a     // Catch:{ NoSuchFieldError -> 0x0108 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MONTH_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x0108 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0108 }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0108 }
            L_0x0108:
                int[] r0 = f31792a     // Catch:{ NoSuchFieldError -> 0x0114 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.DAY_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x0114 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0114 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0114 }
            L_0x0114:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.JapaneseChronology.AnonymousClass1.<clinit>():void");
        }
    }

    static {
        HashMap hashMap = new HashMap();
        a3 = hashMap;
        HashMap hashMap2 = new HashMap();
        b3 = hashMap2;
        HashMap hashMap3 = new HashMap();
        c3 = hashMap3;
        hashMap.put(d3, new String[]{"Unknown", "K", "M", ExifInterface.d5, ExifInterface.R4, "H"});
        hashMap.put(e3, new String[]{"Unknown", "K", "M", ExifInterface.d5, ExifInterface.R4, "H"});
        hashMap2.put(d3, new String[]{"Unknown", "K", "M", ExifInterface.d5, ExifInterface.R4, "H"});
        hashMap2.put(e3, new String[]{"Unknown", "慶", "明", "大", "昭", "平"});
        hashMap3.put(d3, new String[]{"Unknown", "Keio", "Meiji", "Taisho", "Showa", "Heisei"});
        hashMap3.put(e3, new String[]{"Unknown", "慶応", "明治", "大正", "昭和", "平成"});
    }

    private JapaneseChronology() {
    }

    private Object H() {
        return Y2;
    }

    private JapaneseDate h0(Map<TemporalField, Long> map, ResolverStyle resolverStyle, JapaneseEra japaneseEra, int i2) {
        if (resolverStyle == ResolverStyle.LENIENT) {
            return j((japaneseEra.A().M0() + i2) - 1, 1).q(Jdk8Methods.q(map.remove(ChronoField.DAY_OF_YEAR).longValue(), 1), ChronoUnit.DAYS);
        }
        ChronoField chronoField = ChronoField.DAY_OF_YEAR;
        return k(japaneseEra, i2, E(chronoField).a(map.remove(chronoField).longValue(), chronoField));
    }

    private JapaneseDate i0(Map<TemporalField, Long> map, ResolverStyle resolverStyle, JapaneseEra japaneseEra, int i2) {
        if (resolverStyle == ResolverStyle.LENIENT) {
            long q = Jdk8Methods.q(map.remove(ChronoField.MONTH_OF_YEAR).longValue(), 1);
            return b((japaneseEra.A().M0() + i2) - 1, 1, 1).q(q, ChronoUnit.MONTHS).q(Jdk8Methods.q(map.remove(ChronoField.DAY_OF_MONTH).longValue(), 1), ChronoUnit.DAYS);
        }
        ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
        int a2 = E(chronoField).a(map.remove(chronoField).longValue(), chronoField);
        ChronoField chronoField2 = ChronoField.DAY_OF_MONTH;
        int a4 = E(chronoField2).a(map.remove(chronoField2).longValue(), chronoField2);
        if (resolverStyle != ResolverStyle.SMART) {
            return c(japaneseEra, i2, a2, a4);
        }
        if (i2 >= 1) {
            int M0 = (japaneseEra.A().M0() + i2) - 1;
            if (a4 > 28) {
                a4 = Math.min(a4, b(M0, a2, 1).F());
            }
            JapaneseDate Q = b(M0, a2, a4);
            if (Q.y() != japaneseEra) {
                if (Math.abs(Q.y().getValue() - japaneseEra.getValue()) > 1) {
                    throw new DateTimeException("Invalid Era/YearOfEra: " + japaneseEra + StringUtils.SPACE + i2);
                } else if (!(Q.b(ChronoField.YEAR_OF_ERA) == 1 || i2 == 1)) {
                    throw new DateTimeException("Invalid Era/YearOfEra: " + japaneseEra + StringUtils.SPACE + i2);
                }
            }
            return Q;
        }
        throw new DateTimeException("Invalid YearOfEra: " + i2);
    }

    public int D(Era era, int i2) {
        if (era instanceof JapaneseEra) {
            JapaneseEra japaneseEra = (JapaneseEra) era;
            int M0 = (japaneseEra.A().M0() + i2) - 1;
            ValueRange.k(1, (long) ((japaneseEra.s().M0() - japaneseEra.A().M0()) + 1)).b((long) i2, ChronoField.YEAR_OF_ERA);
            return M0;
        }
        throw new ClassCastException("Era must be JapaneseEra");
    }

    public ValueRange E(ChronoField chronoField) {
        int[] iArr = AnonymousClass1.f31792a;
        switch (iArr[chronoField.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                return chronoField.h();
            default:
                Calendar instance = Calendar.getInstance(X2);
                int i2 = 0;
                switch (iArr[chronoField.ordinal()]) {
                    case 19:
                        JapaneseEra[] E = JapaneseEra.E();
                        return ValueRange.k((long) E[0].getValue(), (long) E[E.length - 1].getValue());
                    case 20:
                        JapaneseEra[] E2 = JapaneseEra.E();
                        return ValueRange.k((long) JapaneseDate.Z2.M0(), (long) E2[E2.length - 1].s().M0());
                    case 21:
                        JapaneseEra[] E3 = JapaneseEra.E();
                        int M0 = (E3[E3.length - 1].s().M0() - E3[E3.length - 1].A().M0()) + 1;
                        int i3 = Integer.MAX_VALUE;
                        while (i2 < E3.length) {
                            i3 = Math.min(i3, (E3[i2].s().M0() - E3[i2].A().M0()) + 1);
                            i2++;
                        }
                        return ValueRange.m(1, 6, (long) i3, (long) M0);
                    case 22:
                        return ValueRange.m((long) (instance.getMinimum(2) + 1), (long) (instance.getGreatestMinimum(2) + 1), (long) (instance.getLeastMaximum(2) + 1), (long) (instance.getMaximum(2) + 1));
                    case 23:
                        JapaneseEra[] E4 = JapaneseEra.E();
                        int i4 = 366;
                        while (i2 < E4.length) {
                            i4 = Math.min(i4, (E4[i2].A().J() - E4[i2].A().k1()) + 1);
                            i2++;
                        }
                        return ValueRange.l(1, (long) i4, 366);
                    default:
                        throw new UnsupportedOperationException("Unimplementable field: " + chronoField);
                }
        }
    }

    public ChronoZonedDateTime<JapaneseDate> O(Instant instant, ZoneId zoneId) {
        return super.O(instant, zoneId);
    }

    public ChronoZonedDateTime<JapaneseDate> P(TemporalAccessor temporalAccessor) {
        return super.P(temporalAccessor);
    }

    /* renamed from: Q */
    public JapaneseDate b(int i2, int i3, int i4) {
        return new JapaneseDate(LocalDate.r2(i2, i3, i4));
    }

    /* renamed from: R */
    public JapaneseDate c(Era era, int i2, int i3, int i4) {
        if (era instanceof JapaneseEra) {
            return JapaneseDate.T1((JapaneseEra) era, i2, i3, i4);
        }
        throw new ClassCastException("Era must be JapaneseEra");
    }

    /* renamed from: S */
    public JapaneseDate e(TemporalAccessor temporalAccessor) {
        return temporalAccessor instanceof JapaneseDate ? (JapaneseDate) temporalAccessor : new JapaneseDate(LocalDate.c1(temporalAccessor));
    }

    /* renamed from: T */
    public JapaneseDate f(long j2) {
        return new JapaneseDate(LocalDate.w2(j2));
    }

    /* renamed from: U */
    public JapaneseDate g() {
        return (JapaneseDate) super.g();
    }

    /* renamed from: W */
    public JapaneseDate h(Clock clock) {
        Jdk8Methods.j(clock, "clock");
        return (JapaneseDate) super.h(clock);
    }

    /* renamed from: Z */
    public JapaneseDate i(ZoneId zoneId) {
        return (JapaneseDate) super.i(zoneId);
    }

    /* renamed from: a0 */
    public JapaneseDate j(int i2, int i3) {
        LocalDate B2 = LocalDate.B2(i2, i3);
        return b(i2, B2.w1(), B2.h1());
    }

    /* renamed from: c0 */
    public JapaneseDate k(Era era, int i2, int i3) {
        if (era instanceof JapaneseEra) {
            return JapaneseDate.e2((JapaneseEra) era, i2, i3);
        }
        throw new ClassCastException("Era must be JapaneseEra");
    }

    /* renamed from: d0 */
    public JapaneseEra o(int i2) {
        return JapaneseEra.v(i2);
    }

    /* renamed from: e0 */
    public JapaneseDate J(Map<TemporalField, Long> map, ResolverStyle resolverStyle) {
        ChronoField chronoField = ChronoField.EPOCH_DAY;
        if (map.containsKey(chronoField)) {
            return f(map.remove(chronoField).longValue());
        }
        ChronoField chronoField2 = ChronoField.PROLEPTIC_MONTH;
        Long remove = map.remove(chronoField2);
        if (remove != null) {
            if (resolverStyle != ResolverStyle.LENIENT) {
                chronoField2.n(remove.longValue());
            }
            K(map, ChronoField.MONTH_OF_YEAR, (long) (Jdk8Methods.g(remove.longValue(), 12) + 1));
            K(map, ChronoField.YEAR, Jdk8Methods.e(remove.longValue(), 12));
        }
        ChronoField chronoField3 = ChronoField.ERA;
        Long l2 = map.get(chronoField3);
        JapaneseEra d0 = l2 != null ? o(E(chronoField3).a(l2.longValue(), chronoField3)) : null;
        ChronoField chronoField4 = ChronoField.YEAR_OF_ERA;
        Long l3 = map.get(chronoField4);
        if (l3 != null) {
            int a2 = E(chronoField4).a(l3.longValue(), chronoField4);
            if (d0 == null && resolverStyle != ResolverStyle.STRICT && !map.containsKey(ChronoField.YEAR)) {
                List<Era> p = p();
                d0 = (JapaneseEra) p.get(p.size() - 1);
            }
            if (d0 != null && map.containsKey(ChronoField.MONTH_OF_YEAR) && map.containsKey(ChronoField.DAY_OF_MONTH)) {
                map.remove(chronoField3);
                map.remove(chronoField4);
                return i0(map, resolverStyle, d0, a2);
            } else if (d0 != null && map.containsKey(ChronoField.DAY_OF_YEAR)) {
                map.remove(chronoField3);
                map.remove(chronoField4);
                return h0(map, resolverStyle, d0, a2);
            }
        }
        ChronoField chronoField5 = ChronoField.YEAR;
        if (map.containsKey(chronoField5)) {
            ChronoField chronoField6 = ChronoField.MONTH_OF_YEAR;
            if (map.containsKey(chronoField6)) {
                ChronoField chronoField7 = ChronoField.DAY_OF_MONTH;
                if (map.containsKey(chronoField7)) {
                    int m2 = chronoField5.m(map.remove(chronoField5).longValue());
                    if (resolverStyle == ResolverStyle.LENIENT) {
                        return b(m2, 1, 1).L0(Jdk8Methods.q(map.remove(chronoField6).longValue(), 1)).K0(Jdk8Methods.q(map.remove(chronoField7).longValue(), 1));
                    }
                    int a4 = E(chronoField6).a(map.remove(chronoField6).longValue(), chronoField6);
                    int a5 = E(chronoField7).a(map.remove(chronoField7).longValue(), chronoField7);
                    if (resolverStyle == ResolverStyle.SMART && a5 > 28) {
                        a5 = Math.min(a5, b(m2, a4, 1).F());
                    }
                    return b(m2, a4, a5);
                }
                ChronoField chronoField8 = ChronoField.ALIGNED_WEEK_OF_MONTH;
                if (map.containsKey(chronoField8)) {
                    ChronoField chronoField9 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH;
                    if (map.containsKey(chronoField9)) {
                        int m3 = chronoField5.m(map.remove(chronoField5).longValue());
                        if (resolverStyle == ResolverStyle.LENIENT) {
                            long q = Jdk8Methods.q(map.remove(chronoField6).longValue(), 1);
                            return b(m3, 1, 1).q(q, ChronoUnit.MONTHS).q(Jdk8Methods.q(map.remove(chronoField8).longValue(), 1), ChronoUnit.WEEKS).q(Jdk8Methods.q(map.remove(chronoField9).longValue(), 1), ChronoUnit.DAYS);
                        }
                        int m4 = chronoField6.m(map.remove(chronoField6).longValue());
                        JapaneseDate f2 = b(m3, m4, 1).q((long) (((chronoField8.m(map.remove(chronoField8).longValue()) - 1) * 7) + (chronoField9.m(map.remove(chronoField9).longValue()) - 1)), ChronoUnit.DAYS);
                        if (resolverStyle != ResolverStyle.STRICT || f2.b(chronoField6) == m4) {
                            return f2;
                        }
                        throw new DateTimeException("Strict mode rejected date parsed to a different month");
                    }
                    ChronoField chronoField10 = ChronoField.DAY_OF_WEEK;
                    if (map.containsKey(chronoField10)) {
                        int m5 = chronoField5.m(map.remove(chronoField5).longValue());
                        if (resolverStyle == ResolverStyle.LENIENT) {
                            long q2 = Jdk8Methods.q(map.remove(chronoField6).longValue(), 1);
                            return b(m5, 1, 1).q(q2, ChronoUnit.MONTHS).q(Jdk8Methods.q(map.remove(chronoField8).longValue(), 1), ChronoUnit.WEEKS).q(Jdk8Methods.q(map.remove(chronoField10).longValue(), 1), ChronoUnit.DAYS);
                        }
                        int m6 = chronoField6.m(map.remove(chronoField6).longValue());
                        JapaneseDate u2 = b(m5, m6, 1).q((long) (chronoField8.m(map.remove(chronoField8).longValue()) - 1), ChronoUnit.WEEKS).l(TemporalAdjusters.k(DayOfWeek.s(chronoField10.m(map.remove(chronoField10).longValue()))));
                        if (resolverStyle != ResolverStyle.STRICT || u2.b(chronoField6) == m6) {
                            return u2;
                        }
                        throw new DateTimeException("Strict mode rejected date parsed to a different month");
                    }
                }
            }
            ChronoField chronoField11 = ChronoField.DAY_OF_YEAR;
            if (map.containsKey(chronoField11)) {
                int m7 = chronoField5.m(map.remove(chronoField5).longValue());
                ResolverStyle resolverStyle2 = ResolverStyle.LENIENT;
                Long remove2 = map.remove(chronoField11);
                if (resolverStyle != resolverStyle2) {
                    return j(m7, chronoField11.m(remove2.longValue()));
                }
                return j(m7, 1).K0(Jdk8Methods.q(remove2.longValue(), 1));
            }
            ChronoField chronoField12 = ChronoField.ALIGNED_WEEK_OF_YEAR;
            if (map.containsKey(chronoField12)) {
                ChronoField chronoField13 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR;
                if (map.containsKey(chronoField13)) {
                    int m8 = chronoField5.m(map.remove(chronoField5).longValue());
                    if (resolverStyle == ResolverStyle.LENIENT) {
                        return b(m8, 1, 1).q(Jdk8Methods.q(map.remove(chronoField12).longValue(), 1), ChronoUnit.WEEKS).q(Jdk8Methods.q(map.remove(chronoField13).longValue(), 1), ChronoUnit.DAYS);
                    }
                    JapaneseDate j2 = b(m8, 1, 1).K0((long) (((chronoField12.m(map.remove(chronoField12).longValue()) - 1) * 7) + (chronoField13.m(map.remove(chronoField13).longValue()) - 1)));
                    if (resolverStyle != ResolverStyle.STRICT || j2.b(chronoField5) == m8) {
                        return j2;
                    }
                    throw new DateTimeException("Strict mode rejected date parsed to a different year");
                }
                ChronoField chronoField14 = ChronoField.DAY_OF_WEEK;
                if (map.containsKey(chronoField14)) {
                    int m9 = chronoField5.m(map.remove(chronoField5).longValue());
                    if (resolverStyle == ResolverStyle.LENIENT) {
                        return b(m9, 1, 1).q(Jdk8Methods.q(map.remove(chronoField12).longValue(), 1), ChronoUnit.WEEKS).q(Jdk8Methods.q(map.remove(chronoField14).longValue(), 1), ChronoUnit.DAYS);
                    }
                    JapaneseDate u22 = b(m9, 1, 1).q((long) (chronoField12.m(map.remove(chronoField12).longValue()) - 1), ChronoUnit.WEEKS).l(TemporalAdjusters.k(DayOfWeek.s(chronoField14.m(map.remove(chronoField14).longValue()))));
                    if (resolverStyle != ResolverStyle.STRICT || u22.b(chronoField5) == m9) {
                        return u22;
                    }
                    throw new DateTimeException("Strict mode rejected date parsed to a different month");
                }
            }
        }
        return null;
    }

    public List<Era> p() {
        return Arrays.asList(JapaneseEra.E());
    }

    public String s() {
        return "japanese";
    }

    public String v() {
        return "Japanese";
    }

    public boolean x(long j2) {
        return IsoChronology.X2.x(j2);
    }

    public ChronoLocalDateTime<JapaneseDate> y(TemporalAccessor temporalAccessor) {
        return super.y(temporalAccessor);
    }
}
