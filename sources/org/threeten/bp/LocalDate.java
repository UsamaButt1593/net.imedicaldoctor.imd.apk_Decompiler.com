package org.threeten.bp;

import androidx.media3.common.C;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.apache.commons.lang3.StringUtils;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.Era;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.zone.ZoneOffsetTransition;

public final class LocalDate extends ChronoLocalDate implements Temporal, TemporalAdjuster, Serializable {
    public static final LocalDate X2 = r2(Year.X, 1, 1);
    public static final LocalDate Y2 = r2(Year.Y, 12, 31);
    public static final TemporalQuery<LocalDate> Z2 = new TemporalQuery<LocalDate>() {
        /* renamed from: b */
        public LocalDate a(TemporalAccessor temporalAccessor) {
            return LocalDate.c1(temporalAccessor);
        }
    };
    private static final long a3 = 2942565459149668126L;
    private static final int b3 = 146097;
    static final long c3 = 719528;
    private final int X;
    private final short Y;
    private final short Z;

    /* renamed from: org.threeten.bp.LocalDate$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31773a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f31774b;

        /* JADX WARNING: Can't wrap try/catch for region: R(46:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Can't wrap try/catch for region: R(49:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Can't wrap try/catch for region: R(52:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x007b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0085 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x008f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0099 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00a3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00ad */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00b7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00c3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00cf */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00db */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00e7 */
        static {
            /*
                org.threeten.bp.temporal.ChronoUnit[] r0 = org.threeten.bp.temporal.ChronoUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31774b = r0
                r1 = 1
                org.threeten.bp.temporal.ChronoUnit r2 = org.threeten.bp.temporal.ChronoUnit.DAYS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f31774b     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoUnit r3 = org.threeten.bp.temporal.ChronoUnit.WEEKS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f31774b     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoUnit r4 = org.threeten.bp.temporal.ChronoUnit.MONTHS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f31774b     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoUnit r5 = org.threeten.bp.temporal.ChronoUnit.YEARS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f31774b     // Catch:{ NoSuchFieldError -> 0x003e }
                org.threeten.bp.temporal.ChronoUnit r6 = org.threeten.bp.temporal.ChronoUnit.DECADES     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = f31774b     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.threeten.bp.temporal.ChronoUnit r7 = org.threeten.bp.temporal.ChronoUnit.CENTURIES     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r6 = 7
                int[] r7 = f31774b     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.threeten.bp.temporal.ChronoUnit r8 = org.threeten.bp.temporal.ChronoUnit.MILLENNIA     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                r7 = 8
                int[] r8 = f31774b     // Catch:{ NoSuchFieldError -> 0x0060 }
                org.threeten.bp.temporal.ChronoUnit r9 = org.threeten.bp.temporal.ChronoUnit.ERAS     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r8[r9] = r7     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                org.threeten.bp.temporal.ChronoField[] r8 = org.threeten.bp.temporal.ChronoField.values()
                int r8 = r8.length
                int[] r8 = new int[r8]
                f31773a = r8
                org.threeten.bp.temporal.ChronoField r9 = org.threeten.bp.temporal.ChronoField.DAY_OF_MONTH     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r8[r9] = r1     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                int[] r1 = f31773a     // Catch:{ NoSuchFieldError -> 0x007b }
                org.threeten.bp.temporal.ChronoField r8 = org.threeten.bp.temporal.ChronoField.DAY_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x007b }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x007b }
                r1[r8] = r0     // Catch:{ NoSuchFieldError -> 0x007b }
            L_0x007b:
                int[] r0 = f31773a     // Catch:{ NoSuchFieldError -> 0x0085 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_WEEK_OF_MONTH     // Catch:{ NoSuchFieldError -> 0x0085 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0085 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0085 }
            L_0x0085:
                int[] r0 = f31773a     // Catch:{ NoSuchFieldError -> 0x008f }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR_OF_ERA     // Catch:{ NoSuchFieldError -> 0x008f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                int[] r0 = f31773a     // Catch:{ NoSuchFieldError -> 0x0099 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.DAY_OF_WEEK     // Catch:{ NoSuchFieldError -> 0x0099 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0099 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0099 }
            L_0x0099:
                int[] r0 = f31773a     // Catch:{ NoSuchFieldError -> 0x00a3 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH     // Catch:{ NoSuchFieldError -> 0x00a3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a3 }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x00a3 }
            L_0x00a3:
                int[] r0 = f31773a     // Catch:{ NoSuchFieldError -> 0x00ad }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR     // Catch:{ NoSuchFieldError -> 0x00ad }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ad }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x00ad }
            L_0x00ad:
                int[] r0 = f31773a     // Catch:{ NoSuchFieldError -> 0x00b7 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.EPOCH_DAY     // Catch:{ NoSuchFieldError -> 0x00b7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b7 }
                r0[r1] = r7     // Catch:{ NoSuchFieldError -> 0x00b7 }
            L_0x00b7:
                int[] r0 = f31773a     // Catch:{ NoSuchFieldError -> 0x00c3 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_WEEK_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x00c3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c3 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c3 }
            L_0x00c3:
                int[] r0 = f31773a     // Catch:{ NoSuchFieldError -> 0x00cf }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MONTH_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x00cf }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cf }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cf }
            L_0x00cf:
                int[] r0 = f31773a     // Catch:{ NoSuchFieldError -> 0x00db }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.PROLEPTIC_MONTH     // Catch:{ NoSuchFieldError -> 0x00db }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00db }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00db }
            L_0x00db:
                int[] r0 = f31773a     // Catch:{ NoSuchFieldError -> 0x00e7 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR     // Catch:{ NoSuchFieldError -> 0x00e7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e7 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e7 }
            L_0x00e7:
                int[] r0 = f31773a     // Catch:{ NoSuchFieldError -> 0x00f3 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ERA     // Catch:{ NoSuchFieldError -> 0x00f3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f3 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f3 }
            L_0x00f3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.LocalDate.AnonymousClass2.<clinit>():void");
        }
    }

    private LocalDate(int i2, int i3, int i4) {
        this.X = i2;
        this.Y = (short) i3;
        this.Z = (short) i4;
    }

    public static LocalDate B2(int i2, int i3) {
        long j2 = (long) i2;
        ChronoField.YEAR.n(j2);
        ChronoField.DAY_OF_YEAR.n((long) i3);
        boolean x = IsoChronology.X2.x(j2);
        if (i3 != 366 || x) {
            Month y = Month.y(((i3 - 1) / 31) + 1);
            if (i3 > (y.j(x) + y.u(x)) - 1) {
                y = y.z(1);
            }
            return S0(i2, y, (i3 - y.j(x)) + 1);
        }
        throw new DateTimeException("Invalid date 'DayOfYear 366' as '" + i2 + "' is not a leap year");
    }

    public static LocalDate C2(CharSequence charSequence) {
        return E2(charSequence, DateTimeFormatter.f31798h);
    }

    private long D1() {
        return (((long) this.X) * 12) + ((long) (this.Y - 1));
    }

    public static LocalDate E2(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.j(dateTimeFormatter, "formatter");
        return (LocalDate) dateTimeFormatter.r(charSequence, Z2);
    }

    static LocalDate P2(DataInput dataInput) throws IOException {
        return r2(dataInput.readInt(), dataInput.readByte(), dataInput.readByte());
    }

    private Object Q2() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private static LocalDate S0(int i2, Month month, int i3) {
        if (i3 <= 28 || i3 <= month.u(IsoChronology.X2.x((long) i2))) {
            return new LocalDate(i2, month.getValue(), i3);
        }
        if (i3 == 29) {
            throw new DateTimeException("Invalid date 'February 29' as '" + i2 + "' is not a leap year");
        }
        throw new DateTimeException("Invalid date '" + month.name() + StringUtils.SPACE + i3 + "'");
    }

    private static LocalDate S2(int i2, int i3, int i4) {
        int i5;
        if (i3 != 2) {
            if (i3 == 4 || i3 == 6 || i3 == 9 || i3 == 11) {
                i5 = 30;
            }
            return r2(i2, i3, i4);
        }
        i5 = IsoChronology.X2.x((long) i2) ? 29 : 28;
        i4 = Math.min(i4, i5);
        return r2(i2, i3, i4);
    }

    private Object b3() {
        return new Ser((byte) 3, this);
    }

    public static LocalDate c1(TemporalAccessor temporalAccessor) {
        LocalDate localDate = (LocalDate) temporalAccessor.i(TemporalQueries.b());
        if (localDate != null) {
            return localDate;
        }
        throw new DateTimeException("Unable to obtain LocalDate from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
    }

    private int d1(TemporalField temporalField) {
        switch (AnonymousClass2.f31773a[((ChronoField) temporalField).ordinal()]) {
            case 1:
                return this.Z;
            case 2:
                return k1();
            case 3:
                return ((this.Z - 1) / 7) + 1;
            case 4:
                int i2 = this.X;
                return i2 >= 1 ? i2 : 1 - i2;
            case 5:
                return j1().getValue();
            case 6:
                return ((this.Z - 1) % 7) + 1;
            case 7:
                return ((k1() - 1) % 7) + 1;
            case 8:
                throw new DateTimeException("Field too large for an int: " + temporalField);
            case 9:
                return ((k1() - 1) / 7) + 1;
            case 10:
                return this.Y;
            case 11:
                throw new DateTimeException("Field too large for an int: " + temporalField);
            case 12:
                return this.X;
            case 13:
                return this.X >= 1 ? 1 : 0;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    private long m2(LocalDate localDate) {
        return (((localDate.D1() * 32) + ((long) localDate.h1())) - ((D1() * 32) + ((long) h1()))) / 32;
    }

    public static LocalDate n2() {
        return p2(Clock.g());
    }

    public static LocalDate p2(Clock clock) {
        Jdk8Methods.j(clock, "clock");
        Instant c2 = clock.c();
        return w2(Jdk8Methods.e(c2.y() + ((long) clock.b().u().b(c2).F()), 86400));
    }

    public static LocalDate q2(ZoneId zoneId) {
        return p2(Clock.f(zoneId));
    }

    public static LocalDate r2(int i2, int i3, int i4) {
        ChronoField.YEAR.n((long) i2);
        ChronoField.MONTH_OF_YEAR.n((long) i3);
        ChronoField.DAY_OF_MONTH.n((long) i4);
        return S0(i2, Month.y(i3), i4);
    }

    public static LocalDate u2(int i2, Month month, int i3) {
        ChronoField.YEAR.n((long) i2);
        Jdk8Methods.j(month, "month");
        ChronoField.DAY_OF_MONTH.n((long) i3);
        return S0(i2, month, i3);
    }

    public static LocalDate w2(long j2) {
        long j3;
        long j4 = j2;
        ChronoField.EPOCH_DAY.n(j4);
        long j5 = 719468 + j4;
        if (j5 < 0) {
            long j6 = ((j4 + 719469) / 146097) - 1;
            j3 = j6 * 400;
            j5 += (-j6) * 146097;
        } else {
            j3 = 0;
        }
        long j7 = ((j5 * 400) + 591) / 146097;
        long j8 = j5 - ((((j7 * 365) + (j7 / 4)) - (j7 / 100)) + (j7 / 400));
        if (j8 < 0) {
            j7--;
            j8 = j5 - ((((365 * j7) + (j7 / 4)) - (j7 / 100)) + (j7 / 400));
        }
        int i2 = (int) j8;
        int i3 = ((i2 * 5) + 2) / 153;
        return new LocalDate(ChronoField.YEAR.m(j7 + j3 + ((long) (i3 / 10))), ((i3 + 2) % 12) + 1, (i2 - (((i3 * 306) + 5) / 10)) + 1);
    }

    public boolean A(ChronoLocalDate chronoLocalDate) {
        if (chronoLocalDate instanceof LocalDate) {
            return R0((LocalDate) chronoLocalDate) < 0;
        }
        return super.A(chronoLocalDate);
    }

    public LocalDateTime C0(int i2, int i3) {
        return s(LocalTime.k0(i2, i3));
    }

    public boolean D(ChronoLocalDate chronoLocalDate) {
        if (chronoLocalDate instanceof LocalDate) {
            return R0((LocalDate) chronoLocalDate) == 0;
        }
        return super.D(chronoLocalDate);
    }

    public LocalDateTime D0(int i2, int i3, int i4) {
        return s(LocalTime.q0(i2, i3, i4));
    }

    public boolean E() {
        return IsoChronology.X2.x((long) this.X);
    }

    public int F() {
        short s = this.Y;
        return s != 2 ? (s == 4 || s == 6 || s == 9 || s == 11) ? 30 : 31 : E() ? 29 : 28;
    }

    /* renamed from: F1 */
    public LocalDate o(long j2, TemporalUnit temporalUnit) {
        return j2 == Long.MIN_VALUE ? q(Long.MAX_VALUE, temporalUnit).q(1, temporalUnit) : q(-j2, temporalUnit);
    }

    public LocalDateTime G0(int i2, int i3, int i4, int i5) {
        return s(LocalTime.r0(i2, i3, i4, i5));
    }

    /* renamed from: G2 */
    public LocalDate q(long j2, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (LocalDate) temporalUnit.g(this, j2);
        }
        switch (AnonymousClass2.f31774b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return J2(j2);
            case 2:
                return M2(j2);
            case 3:
                return L2(j2);
            case 4:
                return N2(j2);
            case 5:
                return N2(Jdk8Methods.n(j2, 10));
            case 6:
                return N2(Jdk8Methods.n(j2, 100));
            case 7:
                return N2(Jdk8Methods.n(j2, 1000));
            case 8:
                ChronoField chronoField = ChronoField.ERA;
                return q0(chronoField, Jdk8Methods.l(p(chronoField), j2));
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    /* renamed from: I2 */
    public LocalDate h(TemporalAmount temporalAmount) {
        return (LocalDate) temporalAmount.b(this);
    }

    public int J() {
        return E() ? 366 : 365;
    }

    public LocalDate J2(long j2) {
        return j2 == 0 ? this : w2(Jdk8Methods.l(c0(), j2));
    }

    /* renamed from: K0 */
    public LocalDateTime s(LocalTime localTime) {
        return LocalDateTime.p2(this, localTime);
    }

    public OffsetDateTime L0(OffsetTime offsetTime) {
        return OffsetDateTime.Y0(LocalDateTime.p2(this, offsetTime.d1()), offsetTime.y());
    }

    public LocalDate L2(long j2) {
        if (j2 == 0) {
            return this;
        }
        long j3 = (((long) this.X) * 12) + ((long) (this.Y - 1)) + j2;
        return S2(ChronoField.YEAR.m(Jdk8Methods.e(j3, 12)), Jdk8Methods.g(j3, 12) + 1, this.Z);
    }

    public int M0() {
        return this.X;
    }

    public LocalDate M2(long j2) {
        return J2(Jdk8Methods.n(j2, 7));
    }

    public LocalDate N2(long j2) {
        return j2 == 0 ? this : S2(ChronoField.YEAR.m(((long) this.X) + j2), this.Y, this.Z);
    }

    /* access modifiers changed from: package-private */
    public int R0(LocalDate localDate) {
        int i2 = this.X - localDate.X;
        if (i2 != 0) {
            return i2;
        }
        int i3 = this.Y - localDate.Y;
        return i3 == 0 ? this.Z - localDate.Z : i3;
    }

    /* renamed from: T1 */
    public LocalDate g(TemporalAmount temporalAmount) {
        return (LocalDate) temporalAmount.a(this);
    }

    /* renamed from: T2 */
    public Period h0(ChronoLocalDate chronoLocalDate) {
        LocalDate c1 = c1(chronoLocalDate);
        long D1 = c1.D1() - D1();
        int i2 = c1.Z - this.Z;
        int i3 = (D1 > 0 ? 1 : (D1 == 0 ? 0 : -1));
        if (i3 > 0 && i2 < 0) {
            D1--;
            i2 = (int) (c1.c0() - L2(D1).c0());
        } else if (i3 < 0 && i2 > 0) {
            D1++;
            i2 -= c1.F();
        }
        return Period.A(Jdk8Methods.r(D1 / 12), (int) (D1 % 12), i2);
    }

    /* renamed from: U2 */
    public LocalDate l(TemporalAdjuster temporalAdjuster) {
        return temporalAdjuster instanceof LocalDate ? (LocalDate) temporalAdjuster : (LocalDate) temporalAdjuster.e(this);
    }

    /* renamed from: V2 */
    public LocalDate q0(TemporalField temporalField, long j2) {
        if (!(temporalField instanceof ChronoField)) {
            return (LocalDate) temporalField.e(this, j2);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.n(j2);
        switch (AnonymousClass2.f31773a[chronoField.ordinal()]) {
            case 1:
                return W2((int) j2);
            case 2:
                return X2((int) j2);
            case 3:
                return M2(j2 - p(ChronoField.ALIGNED_WEEK_OF_MONTH));
            case 4:
                if (this.X < 1) {
                    j2 = 1 - j2;
                }
                return Z2((int) j2);
            case 5:
                return J2(j2 - ((long) j1().getValue()));
            case 6:
                return J2(j2 - p(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 7:
                return J2(j2 - p(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 8:
                return w2(j2);
            case 9:
                return M2(j2 - p(ChronoField.ALIGNED_WEEK_OF_YEAR));
            case 10:
                return Y2((int) j2);
            case 11:
                return L2(j2 - p(ChronoField.PROLEPTIC_MONTH));
            case 12:
                return Z2((int) j2);
            case 13:
                return p(ChronoField.ERA) == j2 ? this : Z2(1 - this.X);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    public LocalDate W2(int i2) {
        return this.Z == i2 ? this : r2(this.X, this.Y, i2);
    }

    public LocalDate X2(int i2) {
        return k1() == i2 ? this : B2(this.X, i2);
    }

    /* access modifiers changed from: package-private */
    public long Y0(LocalDate localDate) {
        return localDate.c0() - c0();
    }

    public LocalDate Y2(int i2) {
        if (this.Y == i2) {
            return this;
        }
        ChronoField.MONTH_OF_YEAR.n((long) i2);
        return S2(this.X, i2, this.Z);
    }

    public LocalDate Z2(int i2) {
        if (this.X == i2) {
            return this;
        }
        ChronoField.YEAR.n((long) i2);
        return S2(i2, this.Y, this.Z);
    }

    /* access modifiers changed from: package-private */
    public void a3(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.X);
        dataOutput.writeByte(this.Y);
        dataOutput.writeByte(this.Z);
    }

    public int b(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? d1(temporalField) : super.b(temporalField);
    }

    public long c0() {
        long j2 = (long) this.X;
        long j3 = (long) this.Y;
        long j4 = 365 * j2;
        long j5 = (j2 >= 0 ? j4 + (((3 + j2) / 4) - ((99 + j2) / 100)) + ((j2 + 399) / 400) : j4 - (((j2 / -4) - (j2 / -100)) + (j2 / -400))) + (((367 * j3) - 362) / 12) + ((long) (this.Z - 1));
        if (j3 > 2) {
            j5 = !E() ? j5 - 2 : j5 - 1;
        }
        return j5 - c3;
    }

    public Temporal e(Temporal temporal) {
        return super.e(temporal);
    }

    /* renamed from: e1 */
    public IsoChronology x() {
        return IsoChronology.X2;
    }

    public LocalDate e2(long j2) {
        return j2 == Long.MIN_VALUE ? J2(Long.MAX_VALUE).J2(1) : J2(-j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LocalDate) && R0((LocalDate) obj) == 0;
    }

    public ValueRange f(TemporalField temporalField) {
        int F;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.f(this);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        if (chronoField.a()) {
            int i2 = AnonymousClass2.f31773a[chronoField.ordinal()];
            if (i2 == 1) {
                F = F();
            } else if (i2 == 2) {
                F = J();
            } else if (i2 == 3) {
                return ValueRange.k(1, (l1() != Month.FEBRUARY || E()) ? 5 : 4);
            } else if (i2 != 4) {
                return temporalField.h();
            } else {
                return ValueRange.k(1, M0() <= 0 ? C.f9093k : 999999999);
            }
            return ValueRange.k(1, (long) F);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public LocalDate f2(long j2) {
        return j2 == Long.MIN_VALUE ? L2(Long.MAX_VALUE).L2(1) : L2(-j2);
    }

    public int h1() {
        return this.Z;
    }

    public int hashCode() {
        int i2 = this.X;
        return (((i2 << 11) + (this.Y << 6)) + this.Z) ^ (i2 & -2048);
    }

    public <R> R i(TemporalQuery<R> temporalQuery) {
        return temporalQuery == TemporalQueries.b() ? this : super.i(temporalQuery);
    }

    public LocalDate i2(long j2) {
        return j2 == Long.MIN_VALUE ? M2(Long.MAX_VALUE).M2(1) : M2(-j2);
    }

    public DayOfWeek j1() {
        return DayOfWeek.s(Jdk8Methods.g(c0() + 3, 7) + 1);
    }

    public LocalDate j2(long j2) {
        return j2 == Long.MIN_VALUE ? N2(Long.MAX_VALUE).N2(1) : N2(-j2);
    }

    public int k1() {
        return (l1().j(E()) + this.Z) - 1;
    }

    public Month l1() {
        return Month.y(this.Y);
    }

    public boolean m(TemporalField temporalField) {
        return super.m(temporalField);
    }

    public long p(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.j(this);
        }
        if (temporalField == ChronoField.EPOCH_DAY) {
            return c0();
        }
        return temporalField == ChronoField.PROLEPTIC_MONTH ? D1() : (long) d1(temporalField);
    }

    public long r(Temporal temporal, TemporalUnit temporalUnit) {
        long Y0;
        long j2;
        LocalDate c1 = c1(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.e(this, c1);
        }
        switch (AnonymousClass2.f31774b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return Y0(c1);
            case 2:
                Y0 = Y0(c1);
                j2 = 7;
                break;
            case 3:
                return m2(c1);
            case 4:
                Y0 = m2(c1);
                j2 = 12;
                break;
            case 5:
                Y0 = m2(c1);
                j2 = 120;
                break;
            case 6:
                Y0 = m2(c1);
                j2 = 1200;
                break;
            case 7:
                Y0 = m2(c1);
                j2 = 12000;
                break;
            case 8:
                ChronoField chronoField = ChronoField.ERA;
                return c1.p(chronoField) - p(chronoField);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
        return Y0 / j2;
    }

    public LocalDateTime r0() {
        return LocalDateTime.p2(this, LocalTime.Z2);
    }

    public String toString() {
        int i2;
        int i3 = this.X;
        short s = this.Y;
        short s2 = this.Z;
        int abs = Math.abs(i3);
        StringBuilder sb = new StringBuilder(10);
        if (abs < 1000) {
            if (i3 < 0) {
                sb.append(i3 - 10000);
                i2 = 1;
            } else {
                sb.append(i3 + 10000);
                i2 = 0;
            }
            sb.deleteCharAt(i2);
        } else {
            if (i3 > 9999) {
                sb.append('+');
            }
            sb.append(i3);
        }
        String str = "-";
        sb.append(s < 10 ? "-0" : str);
        sb.append(s);
        if (s2 < 10) {
            str = "-0";
        }
        sb.append(str);
        sb.append(s2);
        return sb.toString();
    }

    /* renamed from: u */
    public int compareTo(ChronoLocalDate chronoLocalDate) {
        return chronoLocalDate instanceof LocalDate ? R0((LocalDate) chronoLocalDate) : super.compareTo(chronoLocalDate);
    }

    public String v(DateTimeFormatter dateTimeFormatter) {
        return super.v(dateTimeFormatter);
    }

    public ZonedDateTime v0(ZoneId zoneId) {
        ZoneOffsetTransition e2;
        Jdk8Methods.j(zoneId, "zone");
        LocalDateTime K0 = s(LocalTime.Z2);
        if (!(zoneId instanceof ZoneOffset) && (e2 = zoneId.u().e(K0)) != null && e2.k()) {
            K0 = e2.b();
        }
        return ZonedDateTime.p2(K0, zoneId);
    }

    public int w1() {
        return this.Y;
    }

    public Era y() {
        return super.y();
    }

    public boolean z(ChronoLocalDate chronoLocalDate) {
        if (chronoLocalDate instanceof LocalDate) {
            return R0((LocalDate) chronoLocalDate) > 0;
        }
        return super.z(chronoLocalDate);
    }
}
