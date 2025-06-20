package org.threeten.bp;

import java.util.Locale;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public enum Month implements TemporalAccessor, TemporalAdjuster {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;
    
    public static final TemporalQuery<Month> f3 = null;
    private static final Month[] g3 = null;

    /* renamed from: org.threeten.bp.Month$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31778a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
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
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.threeten.bp.Month[] r0 = org.threeten.bp.Month.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31778a = r0
                org.threeten.bp.Month r1 = org.threeten.bp.Month.FEBRUARY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31778a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.Month r1 = org.threeten.bp.Month.APRIL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31778a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.Month r1 = org.threeten.bp.Month.JUNE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f31778a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.Month r1 = org.threeten.bp.Month.SEPTEMBER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f31778a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.threeten.bp.Month r1 = org.threeten.bp.Month.NOVEMBER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f31778a     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.threeten.bp.Month r1 = org.threeten.bp.Month.JANUARY     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f31778a     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.threeten.bp.Month r1 = org.threeten.bp.Month.MARCH     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f31778a     // Catch:{ NoSuchFieldError -> 0x0060 }
                org.threeten.bp.Month r1 = org.threeten.bp.Month.MAY     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f31778a     // Catch:{ NoSuchFieldError -> 0x006c }
                org.threeten.bp.Month r1 = org.threeten.bp.Month.JULY     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f31778a     // Catch:{ NoSuchFieldError -> 0x0078 }
                org.threeten.bp.Month r1 = org.threeten.bp.Month.AUGUST     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f31778a     // Catch:{ NoSuchFieldError -> 0x0084 }
                org.threeten.bp.Month r1 = org.threeten.bp.Month.OCTOBER     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f31778a     // Catch:{ NoSuchFieldError -> 0x0090 }
                org.threeten.bp.Month r1 = org.threeten.bp.Month.DECEMBER     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.Month.AnonymousClass2.<clinit>():void");
        }
    }

    static {
        f3 = new TemporalQuery<Month>() {
            /* renamed from: b */
            public Month a(TemporalAccessor temporalAccessor) {
                return Month.s(temporalAccessor);
            }
        };
        g3 = values();
    }

    public static Month s(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof Month) {
            return (Month) temporalAccessor;
        }
        try {
            if (!IsoChronology.X2.equals(Chronology.q(temporalAccessor))) {
                temporalAccessor = LocalDate.c1(temporalAccessor);
            }
            return y(temporalAccessor.b(ChronoField.MONTH_OF_YEAR));
        } catch (DateTimeException e2) {
            throw new DateTimeException("Unable to obtain Month from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName(), e2);
        }
    }

    public static Month y(int i2) {
        if (i2 >= 1 && i2 <= 12) {
            return g3[i2 - 1];
        }
        throw new DateTimeException("Invalid value for MonthOfYear: " + i2);
    }

    public int b(TemporalField temporalField) {
        return temporalField == ChronoField.MONTH_OF_YEAR ? getValue() : f(temporalField).a(p(temporalField), temporalField);
    }

    public String c(TextStyle textStyle, Locale locale) {
        return new DateTimeFormatterBuilder().r(ChronoField.MONTH_OF_YEAR, textStyle).Q(locale).d(this);
    }

    public Temporal e(Temporal temporal) {
        if (Chronology.q(temporal).equals(IsoChronology.X2)) {
            return temporal.a(ChronoField.MONTH_OF_YEAR, (long) getValue());
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public ValueRange f(TemporalField temporalField) {
        if (temporalField == ChronoField.MONTH_OF_YEAR) {
            return temporalField.h();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.f(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public int getValue() {
        return ordinal() + 1;
    }

    public <R> R i(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.a()) {
            return IsoChronology.X2;
        }
        if (temporalQuery == TemporalQueries.e()) {
            return ChronoUnit.MONTHS;
        }
        if (temporalQuery == TemporalQueries.b() || temporalQuery == TemporalQueries.c() || temporalQuery == TemporalQueries.f() || temporalQuery == TemporalQueries.g() || temporalQuery == TemporalQueries.d()) {
            return null;
        }
        return temporalQuery.a(this);
    }

    public int j(boolean z) {
        switch (AnonymousClass2.f31778a[ordinal()]) {
            case 1:
                return 32;
            case 2:
                return (z ? 1 : 0) + true;
            case 3:
                return z + true;
            case 4:
                return z + true;
            case 5:
                return z + true;
            case 6:
                return 1;
            case 7:
                return z + true;
            case 8:
                return z + true;
            case 9:
                return z + true;
            case 10:
                return z + true;
            case 11:
                return z + true;
            default:
                return z + true;
        }
    }

    public Month k() {
        return g3[(ordinal() / 3) * 3];
    }

    public boolean m(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.MONTH_OF_YEAR : temporalField != null && temporalField.c(this);
    }

    public long p(TemporalField temporalField) {
        if (temporalField == ChronoField.MONTH_OF_YEAR) {
            return (long) getValue();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.j(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public int u(boolean z) {
        int i2 = AnonymousClass2.f31778a[ordinal()];
        return i2 != 1 ? (i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) ? 30 : 31 : z ? 29 : 28;
    }

    public int v() {
        int i2 = AnonymousClass2.f31778a[ordinal()];
        if (i2 != 1) {
            return (i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) ? 30 : 31;
        }
        return 29;
    }

    public int w() {
        int i2 = AnonymousClass2.f31778a[ordinal()];
        if (i2 != 1) {
            return (i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) ? 30 : 31;
        }
        return 28;
    }

    public Month x(long j2) {
        return z(-(j2 % 12));
    }

    public Month z(long j2) {
        return g3[(ordinal() + (((int) (j2 % 12)) + 12)) % 12];
    }
}
