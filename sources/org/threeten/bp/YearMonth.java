package org.threeten.bp;

import androidx.media3.common.C;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.SignStyle;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
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

public final class YearMonth extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<YearMonth>, Serializable {
    private static final DateTimeFormatter X2 = new DateTimeFormatterBuilder().v(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).h('-').u(ChronoField.MONTH_OF_YEAR, 2).P();
    public static final TemporalQuery<YearMonth> Y = new TemporalQuery<YearMonth>() {
        /* renamed from: b */
        public YearMonth a(TemporalAccessor temporalAccessor) {
            return YearMonth.x(temporalAccessor);
        }
    };
    private static final long Z = 4183400860270640070L;
    private final int X;
    private final int s;

    /* renamed from: org.threeten.bp.YearMonth$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31784a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f31785b;

        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|(2:19|20)|21|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0078 */
        static {
            /*
                org.threeten.bp.temporal.ChronoUnit[] r0 = org.threeten.bp.temporal.ChronoUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31785b = r0
                r1 = 1
                org.threeten.bp.temporal.ChronoUnit r2 = org.threeten.bp.temporal.ChronoUnit.MONTHS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f31785b     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoUnit r3 = org.threeten.bp.temporal.ChronoUnit.YEARS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f31785b     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoUnit r4 = org.threeten.bp.temporal.ChronoUnit.DECADES     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f31785b     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoUnit r5 = org.threeten.bp.temporal.ChronoUnit.CENTURIES     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f31785b     // Catch:{ NoSuchFieldError -> 0x003e }
                org.threeten.bp.temporal.ChronoUnit r6 = org.threeten.bp.temporal.ChronoUnit.MILLENNIA     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r5 = f31785b     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.threeten.bp.temporal.ChronoUnit r6 = org.threeten.bp.temporal.ChronoUnit.ERAS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r7 = 6
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                org.threeten.bp.temporal.ChronoField[] r5 = org.threeten.bp.temporal.ChronoField.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f31784a = r5
                org.threeten.bp.temporal.ChronoField r6 = org.threeten.bp.temporal.ChronoField.MONTH_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x005a }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                int[] r1 = f31784a     // Catch:{ NoSuchFieldError -> 0x0064 }
                org.threeten.bp.temporal.ChronoField r5 = org.threeten.bp.temporal.ChronoField.PROLEPTIC_MONTH     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r1[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                int[] r0 = f31784a     // Catch:{ NoSuchFieldError -> 0x006e }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR_OF_ERA     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r0 = f31784a     // Catch:{ NoSuchFieldError -> 0x0078 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f31784a     // Catch:{ NoSuchFieldError -> 0x0082 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ERA     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.YearMonth.AnonymousClass2.<clinit>():void");
        }
    }

    private YearMonth(int i2, int i3) {
        this.s = i2;
        this.X = i3;
    }

    private long A() {
        return (((long) this.s) * 12) + ((long) (this.X - 1));
    }

    public static YearMonth C0(CharSequence charSequence) {
        return D0(charSequence, X2);
    }

    public static YearMonth D0(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.j(dateTimeFormatter, "formatter");
        return (YearMonth) dateTimeFormatter.r(charSequence, Y);
    }

    static YearMonth S0(DataInput dataInput) throws IOException {
        return r0(dataInput.readInt(), dataInput.readByte());
    }

    private Object Y0() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private YearMonth c1(int i2, int i3) {
        return (this.s == i2 && this.X == i3) ? this : new YearMonth(i2, i3);
    }

    public static YearMonth h0() {
        return k0(Clock.g());
    }

    public static YearMonth k0(Clock clock) {
        LocalDate p2 = LocalDate.p2(clock);
        return v0(p2.M0(), p2.l1());
    }

    private Object l1() {
        return new Ser((byte) 68, this);
    }

    public static YearMonth q0(ZoneId zoneId) {
        return k0(Clock.f(zoneId));
    }

    public static YearMonth r0(int i2, int i3) {
        ChronoField.YEAR.n((long) i2);
        ChronoField.MONTH_OF_YEAR.n((long) i3);
        return new YearMonth(i2, i3);
    }

    public static YearMonth v0(int i2, Month month) {
        Jdk8Methods.j(month, "month");
        return r0(i2, month.getValue());
    }

    public static YearMonth x(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof YearMonth) {
            return (YearMonth) temporalAccessor;
        }
        try {
            if (!IsoChronology.X2.equals(Chronology.q(temporalAccessor))) {
                temporalAccessor = LocalDate.c1(temporalAccessor);
            }
            return r0(temporalAccessor.b(ChronoField.YEAR), temporalAccessor.b(ChronoField.MONTH_OF_YEAR));
        } catch (DateTimeException unused) {
            throw new DateTimeException("Unable to obtain YearMonth from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
        }
    }

    public boolean D(YearMonth yearMonth) {
        return compareTo(yearMonth) > 0;
    }

    public boolean E(YearMonth yearMonth) {
        return compareTo(yearMonth) < 0;
    }

    public boolean F() {
        return IsoChronology.X2.x((long) this.s);
    }

    /* renamed from: G0 */
    public YearMonth q(long j2, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (YearMonth) temporalUnit.g(this, j2);
        }
        switch (AnonymousClass2.f31785b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return L0(j2);
            case 2:
                return R0(j2);
            case 3:
                return R0(Jdk8Methods.n(j2, 10));
            case 4:
                return R0(Jdk8Methods.n(j2, 100));
            case 5:
                return R0(Jdk8Methods.n(j2, 1000));
            case 6:
                ChronoField chronoField = ChronoField.ERA;
                return a(chronoField, Jdk8Methods.l(p(chronoField), j2));
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public boolean J(int i2) {
        return i2 >= 1 && i2 <= K();
    }

    public int K() {
        return y().u(F());
    }

    /* renamed from: K0 */
    public YearMonth h(TemporalAmount temporalAmount) {
        return (YearMonth) temporalAmount.b(this);
    }

    public int L() {
        return F() ? 366 : 365;
    }

    public YearMonth L0(long j2) {
        if (j2 == 0) {
            return this;
        }
        long j3 = (((long) this.s) * 12) + ((long) (this.X - 1)) + j2;
        return c1(ChronoField.YEAR.m(Jdk8Methods.e(j3, 12)), Jdk8Methods.g(j3, 12) + 1);
    }

    public int M0() {
        return this.s;
    }

    /* renamed from: Q */
    public YearMonth o(long j2, TemporalUnit temporalUnit) {
        return j2 == Long.MIN_VALUE ? q(Long.MAX_VALUE, temporalUnit).q(1, temporalUnit) : q(-j2, temporalUnit);
    }

    public YearMonth R0(long j2) {
        return j2 == 0 ? this : c1(ChronoField.YEAR.m(((long) this.s) + j2), this.X);
    }

    /* renamed from: S */
    public YearMonth g(TemporalAmount temporalAmount) {
        return (YearMonth) temporalAmount.a(this);
    }

    public YearMonth U(long j2) {
        return j2 == Long.MIN_VALUE ? L0(Long.MAX_VALUE).L0(1) : L0(-j2);
    }

    public int b(TemporalField temporalField) {
        return f(temporalField).a(p(temporalField), temporalField);
    }

    public YearMonth c0(long j2) {
        return j2 == Long.MIN_VALUE ? R0(Long.MAX_VALUE).R0(1) : R0(-j2);
    }

    /* renamed from: d1 */
    public YearMonth l(TemporalAdjuster temporalAdjuster) {
        return (YearMonth) temporalAdjuster.e(this);
    }

    public Temporal e(Temporal temporal) {
        if (Chronology.q(temporal).equals(IsoChronology.X2)) {
            return temporal.a(ChronoField.PROLEPTIC_MONTH, A());
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    /* renamed from: e1 */
    public YearMonth a(TemporalField temporalField, long j2) {
        if (!(temporalField instanceof ChronoField)) {
            return (YearMonth) temporalField.e(this, j2);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.n(j2);
        int i2 = AnonymousClass2.f31784a[chronoField.ordinal()];
        if (i2 == 1) {
            return h1((int) j2);
        }
        if (i2 == 2) {
            return L0(j2 - p(ChronoField.PROLEPTIC_MONTH));
        }
        if (i2 == 3) {
            if (this.s < 1) {
                j2 = 1 - j2;
            }
            return j1((int) j2);
        } else if (i2 == 4) {
            return j1((int) j2);
        } else {
            if (i2 == 5) {
                return p(ChronoField.ERA) == j2 ? this : j1(1 - this.s);
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof YearMonth)) {
            return false;
        }
        YearMonth yearMonth = (YearMonth) obj;
        return this.s == yearMonth.s && this.X == yearMonth.X;
    }

    public ValueRange f(TemporalField temporalField) {
        if (temporalField != ChronoField.YEAR_OF_ERA) {
            return super.f(temporalField);
        }
        return ValueRange.k(1, M0() <= 0 ? C.f9093k : 999999999);
    }

    public YearMonth h1(int i2) {
        ChronoField.MONTH_OF_YEAR.n((long) i2);
        return c1(this.s, i2);
    }

    public int hashCode() {
        return this.s ^ (this.X << 27);
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
        return super.i(temporalQuery);
    }

    public YearMonth j1(int i2) {
        ChronoField.YEAR.n((long) i2);
        return c1(i2, this.X);
    }

    /* access modifiers changed from: package-private */
    public void k1(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.s);
        dataOutput.writeByte(this.X);
    }

    public boolean m(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.YEAR || temporalField == ChronoField.MONTH_OF_YEAR || temporalField == ChronoField.PROLEPTIC_MONTH || temporalField == ChronoField.YEAR_OF_ERA || temporalField == ChronoField.ERA : temporalField != null && temporalField.c(this);
    }

    public boolean n(TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? temporalUnit == ChronoUnit.MONTHS || temporalUnit == ChronoUnit.YEARS || temporalUnit == ChronoUnit.DECADES || temporalUnit == ChronoUnit.CENTURIES || temporalUnit == ChronoUnit.MILLENNIA || temporalUnit == ChronoUnit.ERAS : temporalUnit != null && temporalUnit.f(this);
    }

    public long p(TemporalField temporalField) {
        int i2;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.j(this);
        }
        int i3 = AnonymousClass2.f31784a[((ChronoField) temporalField).ordinal()];
        int i4 = 1;
        if (i3 == 1) {
            i2 = this.X;
        } else if (i3 == 2) {
            return A();
        } else {
            if (i3 == 3) {
                int i5 = this.s;
                if (i5 < 1) {
                    i5 = 1 - i5;
                }
                return (long) i5;
            } else if (i3 == 4) {
                i2 = this.s;
            } else if (i3 == 5) {
                if (this.s < 1) {
                    i4 = 0;
                }
                return (long) i4;
            } else {
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
            }
        }
        return (long) i2;
    }

    public long r(Temporal temporal, TemporalUnit temporalUnit) {
        YearMonth x = x(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.e(this, x);
        }
        long A = x.A() - A();
        switch (AnonymousClass2.f31785b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return A;
            case 2:
                return A / 12;
            case 3:
                return A / 120;
            case 4:
                return A / 1200;
            case 5:
                return A / 12000;
            case 6:
                ChronoField chronoField = ChronoField.ERA;
                return x.p(chronoField) - p(chronoField);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public LocalDate s(int i2) {
        return LocalDate.r2(this.s, this.X, i2);
    }

    public String toString() {
        int i2;
        int abs = Math.abs(this.s);
        StringBuilder sb = new StringBuilder(9);
        if (abs < 1000) {
            int i3 = this.s;
            if (i3 < 0) {
                sb.append(i3 - 10000);
                i2 = 1;
            } else {
                sb.append(i3 + 10000);
                i2 = 0;
            }
            sb.deleteCharAt(i2);
        } else {
            sb.append(this.s);
        }
        sb.append(this.X < 10 ? "-0" : "-");
        sb.append(this.X);
        return sb.toString();
    }

    public LocalDate u() {
        return LocalDate.r2(this.s, this.X, K());
    }

    /* renamed from: v */
    public int compareTo(YearMonth yearMonth) {
        int i2 = this.s - yearMonth.s;
        return i2 == 0 ? this.X - yearMonth.X : i2;
    }

    public String w(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.j(dateTimeFormatter, "formatter");
        return dateTimeFormatter.d(this);
    }

    public Month y() {
        return Month.y(this.X);
    }

    public int z() {
        return this.X;
    }
}
