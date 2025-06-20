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

public final class Year extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<Year>, Serializable {
    public static final int X = -999999999;
    private static final long X2 = -23038383694477807L;
    public static final int Y = 999999999;
    private static final DateTimeFormatter Y2 = new DateTimeFormatterBuilder().v(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).P();
    public static final TemporalQuery<Year> Z = new TemporalQuery<Year>() {
        /* renamed from: b */
        public Year a(TemporalAccessor temporalAccessor) {
            return Year.z(temporalAccessor);
        }
    };
    private final int s;

    /* renamed from: org.threeten.bp.Year$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31782a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f31783b;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|5|6|7|9|10|11|12|13|14|15|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0059 */
        static {
            /*
                org.threeten.bp.temporal.ChronoUnit[] r0 = org.threeten.bp.temporal.ChronoUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31783b = r0
                r1 = 1
                org.threeten.bp.temporal.ChronoUnit r2 = org.threeten.bp.temporal.ChronoUnit.YEARS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f31783b     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoUnit r3 = org.threeten.bp.temporal.ChronoUnit.DECADES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f31783b     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoUnit r4 = org.threeten.bp.temporal.ChronoUnit.CENTURIES     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = f31783b     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoUnit r4 = org.threeten.bp.temporal.ChronoUnit.MILLENNIA     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r3 = f31783b     // Catch:{ NoSuchFieldError -> 0x003e }
                org.threeten.bp.temporal.ChronoUnit r4 = org.threeten.bp.temporal.ChronoUnit.ERAS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                org.threeten.bp.temporal.ChronoField[] r3 = org.threeten.bp.temporal.ChronoField.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f31782a = r3
                org.threeten.bp.temporal.ChronoField r4 = org.threeten.bp.temporal.ChronoField.YEAR_OF_ERA     // Catch:{ NoSuchFieldError -> 0x004f }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004f }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x004f }
            L_0x004f:
                int[] r1 = f31782a     // Catch:{ NoSuchFieldError -> 0x0059 }
                org.threeten.bp.temporal.ChronoField r3 = org.threeten.bp.temporal.ChronoField.YEAR     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r0 = f31782a     // Catch:{ NoSuchFieldError -> 0x0063 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ERA     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.Year.AnonymousClass2.<clinit>():void");
        }
    }

    private Year(int i2) {
        this.s = i2;
    }

    public static boolean F(long j2) {
        return (3 & j2) == 0 && (j2 % 100 != 0 || j2 % 400 == 0);
    }

    static Year G0(DataInput dataInput) throws IOException {
        return k0(dataInput.readInt());
    }

    private Object K0() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static Year U() {
        return c0(Clock.g());
    }

    private Object Y0() {
        return new Ser((byte) 67, this);
    }

    public static Year c0(Clock clock) {
        return k0(LocalDate.p2(clock).M0());
    }

    public static Year h0(ZoneId zoneId) {
        return c0(Clock.f(zoneId));
    }

    public static Year k0(int i2) {
        ChronoField.YEAR.n((long) i2);
        return new Year(i2);
    }

    public static Year q0(CharSequence charSequence) {
        return r0(charSequence, Y2);
    }

    public static Year r0(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.j(dateTimeFormatter, "formatter");
        return (Year) dateTimeFormatter.r(charSequence, Z);
    }

    public static Year z(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof Year) {
            return (Year) temporalAccessor;
        }
        try {
            if (!IsoChronology.X2.equals(Chronology.q(temporalAccessor))) {
                temporalAccessor = LocalDate.c1(temporalAccessor);
            }
            return k0(temporalAccessor.b(ChronoField.YEAR));
        } catch (DateTimeException unused) {
            throw new DateTimeException("Unable to obtain Year from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
        }
    }

    public boolean A(Year year) {
        return this.s > year.s;
    }

    /* renamed from: C0 */
    public Year h(TemporalAmount temporalAmount) {
        return (Year) temporalAmount.b(this);
    }

    public boolean D(Year year) {
        return this.s < year.s;
    }

    public Year D0(long j2) {
        return j2 == 0 ? this : k0(ChronoField.YEAR.m(((long) this.s) + j2));
    }

    public boolean E() {
        return F((long) this.s);
    }

    public boolean J(MonthDay monthDay) {
        return monthDay != null && monthDay.E(this.s);
    }

    public int K() {
        return E() ? 366 : 365;
    }

    /* renamed from: L */
    public Year o(long j2, TemporalUnit temporalUnit) {
        return j2 == Long.MIN_VALUE ? q(Long.MAX_VALUE, temporalUnit).q(1, temporalUnit) : q(-j2, temporalUnit);
    }

    /* renamed from: L0 */
    public Year l(TemporalAdjuster temporalAdjuster) {
        return (Year) temporalAdjuster.e(this);
    }

    /* renamed from: Q */
    public Year g(TemporalAmount temporalAmount) {
        return (Year) temporalAmount.a(this);
    }

    /* renamed from: R0 */
    public Year a(TemporalField temporalField, long j2) {
        if (!(temporalField instanceof ChronoField)) {
            return (Year) temporalField.e(this, j2);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.n(j2);
        int i2 = AnonymousClass2.f31782a[chronoField.ordinal()];
        if (i2 == 1) {
            if (this.s < 1) {
                j2 = 1 - j2;
            }
            return k0((int) j2);
        } else if (i2 == 2) {
            return k0((int) j2);
        } else {
            if (i2 == 3) {
                return p(ChronoField.ERA) == j2 ? this : k0(1 - this.s);
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    public Year S(long j2) {
        return j2 == Long.MIN_VALUE ? D0(Long.MAX_VALUE).D0(1) : D0(-j2);
    }

    /* access modifiers changed from: package-private */
    public void S0(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.s);
    }

    public int b(TemporalField temporalField) {
        return f(temporalField).a(p(temporalField), temporalField);
    }

    public Temporal e(Temporal temporal) {
        if (Chronology.q(temporal).equals(IsoChronology.X2)) {
            return temporal.a(ChronoField.YEAR, (long) this.s);
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Year) && this.s == ((Year) obj).s;
    }

    public ValueRange f(TemporalField temporalField) {
        if (temporalField != ChronoField.YEAR_OF_ERA) {
            return super.f(temporalField);
        }
        return ValueRange.k(1, this.s <= 0 ? C.f9093k : 999999999);
    }

    public int getValue() {
        return this.s;
    }

    public int hashCode() {
        return this.s;
    }

    public <R> R i(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.a()) {
            return IsoChronology.X2;
        }
        if (temporalQuery == TemporalQueries.e()) {
            return ChronoUnit.YEARS;
        }
        if (temporalQuery == TemporalQueries.b() || temporalQuery == TemporalQueries.c() || temporalQuery == TemporalQueries.f() || temporalQuery == TemporalQueries.g() || temporalQuery == TemporalQueries.d()) {
            return null;
        }
        return super.i(temporalQuery);
    }

    public boolean m(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.YEAR || temporalField == ChronoField.YEAR_OF_ERA || temporalField == ChronoField.ERA : temporalField != null && temporalField.c(this);
    }

    public boolean n(TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? temporalUnit == ChronoUnit.YEARS || temporalUnit == ChronoUnit.DECADES || temporalUnit == ChronoUnit.CENTURIES || temporalUnit == ChronoUnit.MILLENNIA || temporalUnit == ChronoUnit.ERAS : temporalUnit != null && temporalUnit.f(this);
    }

    public long p(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.j(this);
        }
        int i2 = AnonymousClass2.f31782a[((ChronoField) temporalField).ordinal()];
        int i3 = 1;
        if (i2 == 1) {
            int i4 = this.s;
            if (i4 < 1) {
                i4 = 1 - i4;
            }
            return (long) i4;
        } else if (i2 == 2) {
            return (long) this.s;
        } else {
            if (i2 == 3) {
                if (this.s < 1) {
                    i3 = 0;
                }
                return (long) i3;
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    public long r(Temporal temporal, TemporalUnit temporalUnit) {
        Year z = z(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.e(this, z);
        }
        long j2 = ((long) z.s) - ((long) this.s);
        int i2 = AnonymousClass2.f31783b[((ChronoUnit) temporalUnit).ordinal()];
        if (i2 == 1) {
            return j2;
        }
        if (i2 == 2) {
            return j2 / 10;
        }
        if (i2 == 3) {
            return j2 / 100;
        }
        if (i2 == 4) {
            return j2 / 1000;
        }
        if (i2 == 5) {
            ChronoField chronoField = ChronoField.ERA;
            return z.p(chronoField) - p(chronoField);
        }
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
    }

    public LocalDate s(int i2) {
        return LocalDate.B2(this.s, i2);
    }

    public String toString() {
        return Integer.toString(this.s);
    }

    public YearMonth u(int i2) {
        return YearMonth.r0(this.s, i2);
    }

    public YearMonth v(Month month) {
        return YearMonth.v0(this.s, month);
    }

    /* renamed from: v0 */
    public Year q(long j2, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (Year) temporalUnit.g(this, j2);
        }
        int i2 = AnonymousClass2.f31783b[((ChronoUnit) temporalUnit).ordinal()];
        if (i2 == 1) {
            return D0(j2);
        }
        if (i2 == 2) {
            return D0(Jdk8Methods.n(j2, 10));
        }
        if (i2 == 3) {
            return D0(Jdk8Methods.n(j2, 100));
        }
        if (i2 == 4) {
            return D0(Jdk8Methods.n(j2, 1000));
        }
        if (i2 == 5) {
            ChronoField chronoField = ChronoField.ERA;
            return a(chronoField, Jdk8Methods.l(p(chronoField), j2));
        }
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
    }

    public LocalDate w(MonthDay monthDay) {
        return monthDay.s(this.s);
    }

    /* renamed from: x */
    public int compareTo(Year year) {
        return this.s - year.s;
    }

    public String y(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.j(dateTimeFormatter, "formatter");
        return dateTimeFormatter.d(this);
    }
}
