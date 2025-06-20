package org.threeten.bp.chrono;

import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import org.threeten.bp.Clock;
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

public final class MinguoDate extends ChronoDateImpl<MinguoDate> implements Serializable {
    private static final long Z = 1300372329181994526L;
    private final LocalDate Y;

    /* renamed from: org.threeten.bp.chrono.MinguoDate$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31795a;

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
                f31795a = r0
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.DAY_OF_MONTH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31795a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.DAY_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31795a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_WEEK_OF_MONTH     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f31795a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR_OF_ERA     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f31795a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.PROLEPTIC_MONTH     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f31795a     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f31795a     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ERA     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.MinguoDate.AnonymousClass1.<clinit>():void");
        }
    }

    MinguoDate(LocalDate localDate) {
        Jdk8Methods.j(localDate, DublinCoreProperties.f27398d);
        this.Y = localDate;
    }

    public static MinguoDate D1(ZoneId zoneId) {
        return w1(Clock.f(zoneId));
    }

    public static MinguoDate F1(int i2, int i3, int i4) {
        return MinguoChronology.X2.b(i2, i3, i4);
    }

    public static MinguoDate Y0(TemporalAccessor temporalAccessor) {
        return MinguoChronology.X2.e(temporalAccessor);
    }

    private long e1() {
        return ((((long) h1()) * 12) + ((long) this.Y.w1())) - 1;
    }

    private int h1() {
        return this.Y.M0() - 1911;
    }

    public static MinguoDate l1() {
        return w1(Clock.g());
    }

    static ChronoLocalDate m2(DataInput dataInput) throws IOException {
        return MinguoChronology.X2.b(dataInput.readInt(), dataInput.readByte(), dataInput.readByte());
    }

    private MinguoDate n2(LocalDate localDate) {
        return localDate.equals(this.Y) ? this : new MinguoDate(localDate);
    }

    private Object u2() {
        return new Ser((byte) 5, this);
    }

    public static MinguoDate w1(Clock clock) {
        return new MinguoDate(LocalDate.p2(clock));
    }

    public int F() {
        return this.Y.F();
    }

    /* renamed from: T1 */
    public MinguoDate q(long j2, TemporalUnit temporalUnit) {
        return (MinguoDate) super.q(j2, temporalUnit);
    }

    public long c0() {
        return this.Y.c0();
    }

    /* renamed from: c1 */
    public MinguoChronology x() {
        return MinguoChronology.X2;
    }

    /* renamed from: d1 */
    public MinguoEra y() {
        return (MinguoEra) super.y();
    }

    /* renamed from: e2 */
    public MinguoDate h(TemporalAmount temporalAmount) {
        return (MinguoDate) super.h(temporalAmount);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MinguoDate) {
            return this.Y.equals(((MinguoDate) obj).Y);
        }
        return false;
    }

    public ValueRange f(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.f(this);
        }
        if (m(temporalField)) {
            ChronoField chronoField = (ChronoField) temporalField;
            int i2 = AnonymousClass1.f31795a[chronoField.ordinal()];
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                return this.Y.f(temporalField);
            }
            if (i2 != 4) {
                return x().E(chronoField);
            }
            ValueRange h2 = ChronoField.YEAR.h();
            return ValueRange.k(1, h1() <= 0 ? (-h2.e()) + 1912 : h2.d() - 1911);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f2 */
    public MinguoDate K0(long j2) {
        return n2(this.Y.J2(j2));
    }

    public ChronoPeriod h0(ChronoLocalDate chronoLocalDate) {
        Period T2 = this.Y.h0(chronoLocalDate);
        return x().C(T2.s(), T2.r(), T2.q());
    }

    public int hashCode() {
        return x().v().hashCode() ^ this.Y.hashCode();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i2 */
    public MinguoDate L0(long j2) {
        return n2(this.Y.L2(j2));
    }

    /* renamed from: j1 */
    public MinguoDate o(long j2, TemporalUnit temporalUnit) {
        return (MinguoDate) super.o(j2, temporalUnit);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j2 */
    public MinguoDate S0(long j2) {
        return n2(this.Y.N2(j2));
    }

    /* renamed from: k1 */
    public MinguoDate g(TemporalAmount temporalAmount) {
        return (MinguoDate) super.g(temporalAmount);
    }

    public long p(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.j(this);
        }
        int i2 = AnonymousClass1.f31795a[((ChronoField) temporalField).ordinal()];
        int i3 = 1;
        if (i2 == 4) {
            int h1 = h1();
            if (h1 < 1) {
                h1 = 1 - h1;
            }
            return (long) h1;
        } else if (i2 == 5) {
            return e1();
        } else {
            if (i2 == 6) {
                return (long) h1();
            }
            if (i2 != 7) {
                return this.Y.p(temporalField);
            }
            if (h1() < 1) {
                i3 = 0;
            }
            return (long) i3;
        }
    }

    /* renamed from: p2 */
    public MinguoDate l(TemporalAdjuster temporalAdjuster) {
        return (MinguoDate) super.l(temporalAdjuster);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        if (r2 != 7) goto L_0x0052;
     */
    /* renamed from: q2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.threeten.bp.chrono.MinguoDate q0(org.threeten.bp.temporal.TemporalField r8, long r9) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof org.threeten.bp.temporal.ChronoField
            if (r0 == 0) goto L_0x0092
            r0 = r8
            org.threeten.bp.temporal.ChronoField r0 = (org.threeten.bp.temporal.ChronoField) r0
            long r1 = r7.p(r0)
            int r3 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r3 != 0) goto L_0x0010
            return r7
        L_0x0010:
            int[] r1 = org.threeten.bp.chrono.MinguoDate.AnonymousClass1.f31795a
            int r2 = r0.ordinal()
            r2 = r1[r2]
            r3 = 7
            r4 = 6
            r5 = 4
            if (r2 == r5) goto L_0x003a
            r6 = 5
            if (r2 == r6) goto L_0x0025
            if (r2 == r4) goto L_0x003a
            if (r2 == r3) goto L_0x003a
            goto L_0x0052
        L_0x0025:
            org.threeten.bp.chrono.MinguoChronology r8 = r7.x()
            org.threeten.bp.temporal.ValueRange r8 = r8.E(r0)
            r8.b(r9, r0)
            long r0 = r7.e1()
            long r9 = r9 - r0
            org.threeten.bp.chrono.MinguoDate r8 = r7.L0(r9)
            return r8
        L_0x003a:
            org.threeten.bp.chrono.MinguoChronology r2 = r7.x()
            org.threeten.bp.temporal.ValueRange r2 = r2.E(r0)
            int r2 = r2.a(r9, r0)
            int r0 = r0.ordinal()
            r0 = r1[r0]
            if (r0 == r5) goto L_0x007b
            if (r0 == r4) goto L_0x006e
            if (r0 == r3) goto L_0x005d
        L_0x0052:
            org.threeten.bp.LocalDate r0 = r7.Y
            org.threeten.bp.LocalDate r8 = r0.q0(r8, r9)
            org.threeten.bp.chrono.MinguoDate r8 = r7.n2(r8)
            return r8
        L_0x005d:
            org.threeten.bp.LocalDate r8 = r7.Y
            int r9 = r7.h1()
            int r9 = 1912 - r9
            org.threeten.bp.LocalDate r8 = r8.Z2(r9)
            org.threeten.bp.chrono.MinguoDate r8 = r7.n2(r8)
            return r8
        L_0x006e:
            org.threeten.bp.LocalDate r8 = r7.Y
            int r2 = r2 + 1911
            org.threeten.bp.LocalDate r8 = r8.Z2(r2)
            org.threeten.bp.chrono.MinguoDate r8 = r7.n2(r8)
            return r8
        L_0x007b:
            org.threeten.bp.LocalDate r8 = r7.Y
            int r9 = r7.h1()
            r10 = 1
            if (r9 < r10) goto L_0x0087
            int r2 = r2 + 1911
            goto L_0x0089
        L_0x0087:
            int r2 = 1912 - r2
        L_0x0089:
            org.threeten.bp.LocalDate r8 = r8.Z2(r2)
            org.threeten.bp.chrono.MinguoDate r8 = r7.n2(r8)
            return r8
        L_0x0092:
            org.threeten.bp.temporal.Temporal r8 = r8.e(r7, r9)
            org.threeten.bp.chrono.MinguoDate r8 = (org.threeten.bp.chrono.MinguoDate) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.MinguoDate.q0(org.threeten.bp.temporal.TemporalField, long):org.threeten.bp.chrono.MinguoDate");
    }

    public /* bridge */ /* synthetic */ long r(Temporal temporal, TemporalUnit temporalUnit) {
        return super.r(temporal, temporalUnit);
    }

    /* access modifiers changed from: package-private */
    public void r2(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(b(ChronoField.YEAR));
        dataOutput.writeByte(b(ChronoField.MONTH_OF_YEAR));
        dataOutput.writeByte(b(ChronoField.DAY_OF_MONTH));
    }

    public final ChronoLocalDateTime<MinguoDate> s(LocalTime localTime) {
        return super.s(localTime);
    }
}
