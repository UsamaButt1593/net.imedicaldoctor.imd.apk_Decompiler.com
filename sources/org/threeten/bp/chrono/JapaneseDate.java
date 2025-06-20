package org.threeten.bp.chrono;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Calendar;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public final class JapaneseDate extends ChronoDateImpl<JapaneseDate> implements Serializable {
    private static final long Y2 = -305327627230580483L;
    static final LocalDate Z2 = LocalDate.r2(1873, 1, 1);
    private transient int X2;
    private final LocalDate Y;
    private transient JapaneseEra Z;

    /* renamed from: org.threeten.bp.chrono.JapaneseDate$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31793a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.threeten.bp.temporal.ChronoField[] r0 = org.threeten.bp.temporal.ChronoField.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31793a = r0
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.DAY_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31793a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR_OF_ERA     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31793a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f31793a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f31793a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_WEEK_OF_MONTH     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f31793a     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_WEEK_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f31793a     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ERA     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.JapaneseDate.AnonymousClass1.<clinit>():void");
        }
    }

    JapaneseDate(LocalDate localDate) {
        if (!localDate.A(Z2)) {
            JapaneseEra u = JapaneseEra.u(localDate);
            this.Z = u;
            this.X2 = localDate.M0() - (u.A().M0() - 1);
            this.Y = localDate;
            return;
        }
        throw new DateTimeException("Minimum supported date is January 1st Meiji 6");
    }

    private JapaneseDate B2(int i2) {
        return C2(y(), i2);
    }

    private JapaneseDate C2(JapaneseEra japaneseEra, int i2) {
        return r2(this.Y.Z2(JapaneseChronology.Y2.D(japaneseEra, i2)));
    }

    public static JapaneseDate D1(ZoneId zoneId) {
        return w1(Clock.f(zoneId));
    }

    public static JapaneseDate F1(int i2, int i3, int i4) {
        return new JapaneseDate(LocalDate.r2(i2, i3, i4));
    }

    private Object G2() {
        return new Ser((byte) 1, this);
    }

    public static JapaneseDate T1(JapaneseEra japaneseEra, int i2, int i3, int i4) {
        Jdk8Methods.j(japaneseEra, "era");
        if (i2 >= 1) {
            LocalDate A = japaneseEra.A();
            LocalDate s = japaneseEra.s();
            LocalDate r2 = LocalDate.r2((A.M0() - 1) + i2, i3, i4);
            if (!r2.A(A) && !r2.z(s)) {
                return new JapaneseDate(japaneseEra, i2, r2);
            }
            throw new DateTimeException("Requested date is outside bounds of era " + japaneseEra);
        }
        throw new DateTimeException("Invalid YearOfEra: " + i2);
    }

    private ValueRange Y0(int i2) {
        Calendar instance = Calendar.getInstance(JapaneseChronology.X2);
        instance.set(0, this.Z.getValue() + 2);
        instance.set(this.X2, this.Y.w1() - 1, this.Y.h1());
        return ValueRange.k((long) instance.getActualMinimum(i2), (long) instance.getActualMaximum(i2));
    }

    public static JapaneseDate c1(TemporalAccessor temporalAccessor) {
        return JapaneseChronology.Y2.e(temporalAccessor);
    }

    private long e1() {
        return (long) (this.X2 == 1 ? (this.Y.k1() - this.Z.A().k1()) + 1 : this.Y.k1());
    }

    static JapaneseDate e2(JapaneseEra japaneseEra, int i2, int i3) {
        Jdk8Methods.j(japaneseEra, "era");
        if (i2 >= 1) {
            LocalDate A = japaneseEra.A();
            LocalDate s = japaneseEra.s();
            if (i2 != 1 || (i3 = i3 + (A.k1() - 1)) <= A.J()) {
                LocalDate B2 = LocalDate.B2((A.M0() - 1) + i2, i3);
                if (!B2.A(A) && !B2.z(s)) {
                    return new JapaneseDate(japaneseEra, i2, B2);
                }
                throw new DateTimeException("Requested date is outside bounds of era " + japaneseEra);
            }
            throw new DateTimeException("DayOfYear exceeds maximum allowed in the first year of era " + japaneseEra);
        }
        throw new DateTimeException("Invalid YearOfEra: " + i2);
    }

    public static JapaneseDate l1() {
        return w1(Clock.g());
    }

    static ChronoLocalDate p2(DataInput dataInput) throws IOException {
        return JapaneseChronology.Y2.b(dataInput.readInt(), dataInput.readByte(), dataInput.readByte());
    }

    private void q2(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        JapaneseEra u = JapaneseEra.u(this.Y);
        this.Z = u;
        this.X2 = this.Y.M0() - (u.A().M0() - 1);
    }

    private JapaneseDate r2(LocalDate localDate) {
        return localDate.equals(this.Y) ? this : new JapaneseDate(localDate);
    }

    public static JapaneseDate w1(Clock clock) {
        return new JapaneseDate(LocalDate.p2(clock));
    }

    /* access modifiers changed from: package-private */
    public void E2(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(b(ChronoField.YEAR));
        dataOutput.writeByte(b(ChronoField.MONTH_OF_YEAR));
        dataOutput.writeByte(b(ChronoField.DAY_OF_MONTH));
    }

    public int F() {
        return this.Y.F();
    }

    public int J() {
        Calendar instance = Calendar.getInstance(JapaneseChronology.X2);
        instance.set(0, this.Z.getValue() + 2);
        instance.set(this.X2, this.Y.w1() - 1, this.Y.h1());
        return instance.getActualMaximum(6);
    }

    public long c0() {
        return this.Y.c0();
    }

    /* renamed from: d1 */
    public JapaneseChronology x() {
        return JapaneseChronology.Y2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof JapaneseDate) {
            return this.Y.equals(((JapaneseDate) obj).Y);
        }
        return false;
    }

    public ValueRange f(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.f(this);
        }
        if (m(temporalField)) {
            ChronoField chronoField = (ChronoField) temporalField;
            int i2 = AnonymousClass1.f31793a[chronoField.ordinal()];
            if (i2 != 1) {
                return i2 != 2 ? x().E(chronoField) : Y0(1);
            }
            return Y0(6);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    /* renamed from: f2 */
    public JapaneseDate q(long j2, TemporalUnit temporalUnit) {
        return (JapaneseDate) super.q(j2, temporalUnit);
    }

    public ChronoPeriod h0(ChronoLocalDate chronoLocalDate) {
        Period T2 = this.Y.h0(chronoLocalDate);
        return x().C(T2.s(), T2.r(), T2.q());
    }

    /* renamed from: h1 */
    public JapaneseEra y() {
        return this.Z;
    }

    public int hashCode() {
        return x().v().hashCode() ^ this.Y.hashCode();
    }

    /* renamed from: i2 */
    public JapaneseDate h(TemporalAmount temporalAmount) {
        return (JapaneseDate) super.h(temporalAmount);
    }

    /* renamed from: j1 */
    public JapaneseDate o(long j2, TemporalUnit temporalUnit) {
        return (JapaneseDate) super.o(j2, temporalUnit);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j2 */
    public JapaneseDate K0(long j2) {
        return r2(this.Y.J2(j2));
    }

    /* renamed from: k1 */
    public JapaneseDate g(TemporalAmount temporalAmount) {
        return (JapaneseDate) super.g(temporalAmount);
    }

    public boolean m(TemporalField temporalField) {
        if (temporalField == ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH || temporalField == ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR || temporalField == ChronoField.ALIGNED_WEEK_OF_MONTH || temporalField == ChronoField.ALIGNED_WEEK_OF_YEAR) {
            return false;
        }
        return super.m(temporalField);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m2 */
    public JapaneseDate L0(long j2) {
        return r2(this.Y.L2(j2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n2 */
    public JapaneseDate S0(long j2) {
        return r2(this.Y.N2(j2));
    }

    public long p(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.j(this);
        }
        switch (AnonymousClass1.f31793a[((ChronoField) temporalField).ordinal()]) {
            case 1:
                return e1();
            case 2:
                return (long) this.X2;
            case 3:
            case 4:
            case 5:
            case 6:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
            case 7:
                return (long) this.Z.getValue();
            default:
                return this.Y.p(temporalField);
        }
    }

    public /* bridge */ /* synthetic */ long r(Temporal temporal, TemporalUnit temporalUnit) {
        return super.r(temporal, temporalUnit);
    }

    public final ChronoLocalDateTime<JapaneseDate> s(LocalTime localTime) {
        return super.s(localTime);
    }

    /* renamed from: u2 */
    public JapaneseDate l(TemporalAdjuster temporalAdjuster) {
        return (JapaneseDate) super.l(temporalAdjuster);
    }

    /* renamed from: w2 */
    public JapaneseDate q0(TemporalField temporalField, long j2) {
        if (!(temporalField instanceof ChronoField)) {
            return (JapaneseDate) temporalField.e(this, j2);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        if (p(chronoField) == j2) {
            return this;
        }
        int[] iArr = AnonymousClass1.f31793a;
        int i2 = iArr[chronoField.ordinal()];
        if (i2 == 1 || i2 == 2 || i2 == 7) {
            int a2 = x().E(chronoField).a(j2, chronoField);
            int i3 = iArr[chronoField.ordinal()];
            if (i3 == 1) {
                return r2(this.Y.J2(((long) a2) - e1()));
            }
            if (i3 == 2) {
                return B2(a2);
            }
            if (i3 == 7) {
                return C2(JapaneseEra.v(a2), this.X2);
            }
        }
        return r2(this.Y.q0(temporalField, j2));
    }

    JapaneseDate(JapaneseEra japaneseEra, int i2, LocalDate localDate) {
        if (!localDate.A(Z2)) {
            this.Z = japaneseEra;
            this.X2 = i2;
            this.Y = localDate;
            return;
        }
        throw new DateTimeException("Minimum supported date is January 1st Meiji 6");
    }
}
