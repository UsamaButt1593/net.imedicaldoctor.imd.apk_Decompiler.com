package org.threeten.bp.chrono;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import org.threeten.bp.Clock;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.ZoneId;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.ValueRange;

public final class MinguoChronology extends Chronology implements Serializable {
    public static final MinguoChronology X2 = new MinguoChronology();
    private static final long Y2 = 1039765215346859963L;
    static final int Z2 = 1911;

    /* renamed from: org.threeten.bp.chrono.MinguoChronology$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31794a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.threeten.bp.temporal.ChronoField[] r0 = org.threeten.bp.temporal.ChronoField.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31794a = r0
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.PROLEPTIC_MONTH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31794a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR_OF_ERA     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31794a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.MinguoChronology.AnonymousClass1.<clinit>():void");
        }
    }

    private MinguoChronology() {
    }

    private Object H() {
        return X2;
    }

    public int D(Era era, int i2) {
        if (era instanceof MinguoEra) {
            return era == MinguoEra.ROC ? i2 : 1 - i2;
        }
        throw new ClassCastException("Era must be MinguoEra");
    }

    public ValueRange E(ChronoField chronoField) {
        int i2 = AnonymousClass1.f31794a[chronoField.ordinal()];
        if (i2 == 1) {
            ValueRange h2 = ChronoField.PROLEPTIC_MONTH.h();
            return ValueRange.k(h2.e() - 22932, h2.d() - 22932);
        } else if (i2 == 2) {
            ValueRange h3 = ChronoField.YEAR.h();
            return ValueRange.l(1, h3.d() - 1911, (-h3.e()) + 1912);
        } else if (i2 != 3) {
            return chronoField.h();
        } else {
            ValueRange h4 = ChronoField.YEAR.h();
            return ValueRange.k(h4.e() - 1911, h4.d() - 1911);
        }
    }

    public ChronoZonedDateTime<MinguoDate> O(Instant instant, ZoneId zoneId) {
        return super.O(instant, zoneId);
    }

    public ChronoZonedDateTime<MinguoDate> P(TemporalAccessor temporalAccessor) {
        return super.P(temporalAccessor);
    }

    /* renamed from: Q */
    public MinguoDate b(int i2, int i3, int i4) {
        return new MinguoDate(LocalDate.r2(i2 + Z2, i3, i4));
    }

    /* renamed from: R */
    public MinguoDate c(Era era, int i2, int i3, int i4) {
        return (MinguoDate) super.c(era, i2, i3, i4);
    }

    /* renamed from: S */
    public MinguoDate e(TemporalAccessor temporalAccessor) {
        return temporalAccessor instanceof MinguoDate ? (MinguoDate) temporalAccessor : new MinguoDate(LocalDate.c1(temporalAccessor));
    }

    /* renamed from: T */
    public MinguoDate f(long j2) {
        return new MinguoDate(LocalDate.w2(j2));
    }

    /* renamed from: U */
    public MinguoDate g() {
        return (MinguoDate) super.g();
    }

    /* renamed from: W */
    public MinguoDate h(Clock clock) {
        Jdk8Methods.j(clock, "clock");
        return (MinguoDate) super.h(clock);
    }

    /* renamed from: Z */
    public MinguoDate i(ZoneId zoneId) {
        return (MinguoDate) super.i(zoneId);
    }

    /* renamed from: a0 */
    public MinguoDate j(int i2, int i3) {
        return new MinguoDate(LocalDate.B2(i2 + Z2, i3));
    }

    /* renamed from: c0 */
    public MinguoDate k(Era era, int i2, int i3) {
        return (MinguoDate) super.k(era, i2, i3);
    }

    /* renamed from: d0 */
    public MinguoEra o(int i2) {
        return MinguoEra.j(i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0084, code lost:
        if (r8.longValue() > 0) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008b, code lost:
        r0 = org.threeten.bp.jdk8.Jdk8Methods.q(1, r1.longValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a3, code lost:
        if (r8.longValue() <= 0) goto L_0x008b;
     */
    /* renamed from: e0 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.threeten.bp.chrono.MinguoDate J(java.util.Map<org.threeten.bp.temporal.TemporalField, java.lang.Long> r11, org.threeten.bp.format.ResolverStyle r12) {
        /*
            r10 = this;
            org.threeten.bp.temporal.ChronoField r0 = org.threeten.bp.temporal.ChronoField.EPOCH_DAY
            boolean r1 = r11.containsKey(r0)
            if (r1 == 0) goto L_0x0017
            java.lang.Object r11 = r11.remove(r0)
            java.lang.Long r11 = (java.lang.Long) r11
            long r11 = r11.longValue()
            org.threeten.bp.chrono.MinguoDate r11 = r10.f(r11)
            return r11
        L_0x0017:
            org.threeten.bp.temporal.ChronoField r0 = org.threeten.bp.temporal.ChronoField.PROLEPTIC_MONTH
            java.lang.Object r1 = r11.remove(r0)
            java.lang.Long r1 = (java.lang.Long) r1
            r2 = 1
            if (r1 == 0) goto L_0x004d
            org.threeten.bp.format.ResolverStyle r3 = org.threeten.bp.format.ResolverStyle.LENIENT
            if (r12 == r3) goto L_0x002d
            long r3 = r1.longValue()
            r0.n(r3)
        L_0x002d:
            org.threeten.bp.temporal.ChronoField r0 = org.threeten.bp.temporal.ChronoField.MONTH_OF_YEAR
            long r3 = r1.longValue()
            r5 = 12
            int r3 = org.threeten.bp.jdk8.Jdk8Methods.g(r3, r5)
            int r3 = r3 + r2
            long r3 = (long) r3
            r10.K(r11, r0, r3)
            org.threeten.bp.temporal.ChronoField r0 = org.threeten.bp.temporal.ChronoField.YEAR
            long r3 = r1.longValue()
            r5 = 12
            long r3 = org.threeten.bp.jdk8.Jdk8Methods.e(r3, r5)
            r10.K(r11, r0, r3)
        L_0x004d:
            org.threeten.bp.temporal.ChronoField r0 = org.threeten.bp.temporal.ChronoField.YEAR_OF_ERA
            java.lang.Object r1 = r11.remove(r0)
            java.lang.Long r1 = (java.lang.Long) r1
            r3 = 1
            if (r1 == 0) goto L_0x00e2
            org.threeten.bp.format.ResolverStyle r5 = org.threeten.bp.format.ResolverStyle.LENIENT
            if (r12 == r5) goto L_0x0064
            long r5 = r1.longValue()
            r0.n(r5)
        L_0x0064:
            org.threeten.bp.temporal.ChronoField r5 = org.threeten.bp.temporal.ChronoField.ERA
            java.lang.Object r5 = r11.remove(r5)
            java.lang.Long r5 = (java.lang.Long) r5
            r6 = 0
            if (r5 != 0) goto L_0x00a6
            org.threeten.bp.temporal.ChronoField r5 = org.threeten.bp.temporal.ChronoField.YEAR
            java.lang.Object r8 = r11.get(r5)
            java.lang.Long r8 = (java.lang.Long) r8
            org.threeten.bp.format.ResolverStyle r9 = org.threeten.bp.format.ResolverStyle.STRICT
            if (r12 != r9) goto L_0x009b
            if (r8 == 0) goto L_0x0097
            long r8 = r8.longValue()
            int r0 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x008b
        L_0x0086:
            long r0 = r1.longValue()
            goto L_0x0093
        L_0x008b:
            long r0 = r1.longValue()
            long r0 = org.threeten.bp.jdk8.Jdk8Methods.q(r3, r0)
        L_0x0093:
            r10.K(r11, r5, r0)
            goto L_0x00f7
        L_0x0097:
            r11.put(r0, r1)
            goto L_0x00f7
        L_0x009b:
            if (r8 == 0) goto L_0x0086
            long r8 = r8.longValue()
            int r0 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x008b
            goto L_0x0086
        L_0x00a6:
            long r8 = r5.longValue()
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x00b8
            org.threeten.bp.temporal.ChronoField r0 = org.threeten.bp.temporal.ChronoField.YEAR
            long r5 = r1.longValue()
        L_0x00b4:
            r10.K(r11, r0, r5)
            goto L_0x00f7
        L_0x00b8:
            long r8 = r5.longValue()
            int r0 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x00cb
            org.threeten.bp.temporal.ChronoField r0 = org.threeten.bp.temporal.ChronoField.YEAR
            long r5 = r1.longValue()
            long r5 = org.threeten.bp.jdk8.Jdk8Methods.q(r3, r5)
            goto L_0x00b4
        L_0x00cb:
            org.threeten.bp.DateTimeException r11 = new org.threeten.bp.DateTimeException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "Invalid value for era: "
            r12.append(r0)
            r12.append(r5)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x00e2:
            org.threeten.bp.temporal.ChronoField r0 = org.threeten.bp.temporal.ChronoField.ERA
            boolean r1 = r11.containsKey(r0)
            if (r1 == 0) goto L_0x00f7
            java.lang.Object r1 = r11.get(r0)
            java.lang.Long r1 = (java.lang.Long) r1
            long r5 = r1.longValue()
            r0.n(r5)
        L_0x00f7:
            org.threeten.bp.temporal.ChronoField r0 = org.threeten.bp.temporal.ChronoField.YEAR
            boolean r1 = r11.containsKey(r0)
            if (r1 == 0) goto L_0x043f
            org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MONTH_OF_YEAR
            boolean r5 = r11.containsKey(r1)
            java.lang.String r6 = "Strict mode rejected date parsed to a different month"
            if (r5 == 0) goto L_0x02e7
            org.threeten.bp.temporal.ChronoField r5 = org.threeten.bp.temporal.ChronoField.DAY_OF_MONTH
            boolean r7 = r11.containsKey(r5)
            if (r7 == 0) goto L_0x0189
            java.lang.Object r6 = r11.remove(r0)
            java.lang.Long r6 = (java.lang.Long) r6
            long r6 = r6.longValue()
            int r0 = r0.m(r6)
            org.threeten.bp.format.ResolverStyle r6 = org.threeten.bp.format.ResolverStyle.LENIENT
            if (r12 != r6) goto L_0x014c
            java.lang.Object r12 = r11.remove(r1)
            java.lang.Long r12 = (java.lang.Long) r12
            long r6 = r12.longValue()
            long r6 = org.threeten.bp.jdk8.Jdk8Methods.q(r6, r3)
            java.lang.Object r11 = r11.remove(r5)
            java.lang.Long r11 = (java.lang.Long) r11
            long r11 = r11.longValue()
            long r11 = org.threeten.bp.jdk8.Jdk8Methods.q(r11, r3)
            org.threeten.bp.chrono.MinguoDate r0 = r10.b(r0, r2, r2)
            org.threeten.bp.chrono.MinguoDate r0 = r0.L0(r6)
            org.threeten.bp.chrono.MinguoDate r11 = r0.K0(r11)
            return r11
        L_0x014c:
            org.threeten.bp.temporal.ValueRange r3 = r10.E(r1)
            java.lang.Object r4 = r11.remove(r1)
            java.lang.Long r4 = (java.lang.Long) r4
            long r6 = r4.longValue()
            int r1 = r3.a(r6, r1)
            org.threeten.bp.temporal.ValueRange r3 = r10.E(r5)
            java.lang.Object r11 = r11.remove(r5)
            java.lang.Long r11 = (java.lang.Long) r11
            long r6 = r11.longValue()
            int r11 = r3.a(r6, r5)
            org.threeten.bp.format.ResolverStyle r3 = org.threeten.bp.format.ResolverStyle.SMART
            if (r12 != r3) goto L_0x0184
            r12 = 28
            if (r11 <= r12) goto L_0x0184
            org.threeten.bp.chrono.MinguoDate r12 = r10.b(r0, r1, r2)
            int r12 = r12.F()
            int r11 = java.lang.Math.min(r11, r12)
        L_0x0184:
            org.threeten.bp.chrono.MinguoDate r11 = r10.b(r0, r1, r11)
            return r11
        L_0x0189:
            org.threeten.bp.temporal.ChronoField r5 = org.threeten.bp.temporal.ChronoField.ALIGNED_WEEK_OF_MONTH
            boolean r7 = r11.containsKey(r5)
            if (r7 == 0) goto L_0x02e7
            org.threeten.bp.temporal.ChronoField r7 = org.threeten.bp.temporal.ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH
            boolean r8 = r11.containsKey(r7)
            if (r8 == 0) goto L_0x0238
            java.lang.Object r8 = r11.remove(r0)
            java.lang.Long r8 = (java.lang.Long) r8
            long r8 = r8.longValue()
            int r0 = r0.m(r8)
            org.threeten.bp.format.ResolverStyle r8 = org.threeten.bp.format.ResolverStyle.LENIENT
            if (r12 != r8) goto L_0x01ec
            java.lang.Object r12 = r11.remove(r1)
            java.lang.Long r12 = (java.lang.Long) r12
            long r8 = r12.longValue()
            long r8 = org.threeten.bp.jdk8.Jdk8Methods.q(r8, r3)
            java.lang.Object r12 = r11.remove(r5)
            java.lang.Long r12 = (java.lang.Long) r12
            long r5 = r12.longValue()
            long r5 = org.threeten.bp.jdk8.Jdk8Methods.q(r5, r3)
            java.lang.Object r11 = r11.remove(r7)
            java.lang.Long r11 = (java.lang.Long) r11
            long r11 = r11.longValue()
            long r11 = org.threeten.bp.jdk8.Jdk8Methods.q(r11, r3)
            org.threeten.bp.chrono.MinguoDate r0 = r10.b(r0, r2, r2)
            org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.MONTHS
            org.threeten.bp.chrono.MinguoDate r0 = r0.q(r8, r1)
            org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.WEEKS
            org.threeten.bp.chrono.MinguoDate r0 = r0.q(r5, r1)
            org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.DAYS
            org.threeten.bp.chrono.MinguoDate r11 = r0.q(r11, r1)
            return r11
        L_0x01ec:
            java.lang.Object r3 = r11.remove(r1)
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            int r3 = r1.m(r3)
            java.lang.Object r4 = r11.remove(r5)
            java.lang.Long r4 = (java.lang.Long) r4
            long r8 = r4.longValue()
            int r4 = r5.m(r8)
            java.lang.Object r11 = r11.remove(r7)
            java.lang.Long r11 = (java.lang.Long) r11
            long r8 = r11.longValue()
            int r11 = r7.m(r8)
            org.threeten.bp.chrono.MinguoDate r0 = r10.b(r0, r3, r2)
            int r4 = r4 - r2
            int r4 = r4 * 7
            int r11 = r11 - r2
            int r4 = r4 + r11
            long r4 = (long) r4
            org.threeten.bp.temporal.ChronoUnit r11 = org.threeten.bp.temporal.ChronoUnit.DAYS
            org.threeten.bp.chrono.MinguoDate r11 = r0.q(r4, r11)
            org.threeten.bp.format.ResolverStyle r0 = org.threeten.bp.format.ResolverStyle.STRICT
            if (r12 != r0) goto L_0x0237
            int r12 = r11.b(r1)
            if (r12 != r3) goto L_0x0231
            goto L_0x0237
        L_0x0231:
            org.threeten.bp.DateTimeException r11 = new org.threeten.bp.DateTimeException
            r11.<init>(r6)
            throw r11
        L_0x0237:
            return r11
        L_0x0238:
            org.threeten.bp.temporal.ChronoField r7 = org.threeten.bp.temporal.ChronoField.DAY_OF_WEEK
            boolean r8 = r11.containsKey(r7)
            if (r8 == 0) goto L_0x02e7
            java.lang.Object r8 = r11.remove(r0)
            java.lang.Long r8 = (java.lang.Long) r8
            long r8 = r8.longValue()
            int r0 = r0.m(r8)
            org.threeten.bp.format.ResolverStyle r8 = org.threeten.bp.format.ResolverStyle.LENIENT
            if (r12 != r8) goto L_0x0293
            java.lang.Object r12 = r11.remove(r1)
            java.lang.Long r12 = (java.lang.Long) r12
            long r8 = r12.longValue()
            long r8 = org.threeten.bp.jdk8.Jdk8Methods.q(r8, r3)
            java.lang.Object r12 = r11.remove(r5)
            java.lang.Long r12 = (java.lang.Long) r12
            long r5 = r12.longValue()
            long r5 = org.threeten.bp.jdk8.Jdk8Methods.q(r5, r3)
            java.lang.Object r11 = r11.remove(r7)
            java.lang.Long r11 = (java.lang.Long) r11
            long r11 = r11.longValue()
            long r11 = org.threeten.bp.jdk8.Jdk8Methods.q(r11, r3)
            org.threeten.bp.chrono.MinguoDate r0 = r10.b(r0, r2, r2)
            org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.MONTHS
            org.threeten.bp.chrono.MinguoDate r0 = r0.q(r8, r1)
            org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.WEEKS
            org.threeten.bp.chrono.MinguoDate r0 = r0.q(r5, r1)
            org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.DAYS
            org.threeten.bp.chrono.MinguoDate r11 = r0.q(r11, r1)
            return r11
        L_0x0293:
            java.lang.Object r3 = r11.remove(r1)
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            int r3 = r1.m(r3)
            java.lang.Object r4 = r11.remove(r5)
            java.lang.Long r4 = (java.lang.Long) r4
            long r8 = r4.longValue()
            int r4 = r5.m(r8)
            java.lang.Object r11 = r11.remove(r7)
            java.lang.Long r11 = (java.lang.Long) r11
            long r8 = r11.longValue()
            int r11 = r7.m(r8)
            org.threeten.bp.chrono.MinguoDate r0 = r10.b(r0, r3, r2)
            int r4 = r4 - r2
            long r4 = (long) r4
            org.threeten.bp.temporal.ChronoUnit r2 = org.threeten.bp.temporal.ChronoUnit.WEEKS
            org.threeten.bp.chrono.MinguoDate r0 = r0.q(r4, r2)
            org.threeten.bp.DayOfWeek r11 = org.threeten.bp.DayOfWeek.s(r11)
            org.threeten.bp.temporal.TemporalAdjuster r11 = org.threeten.bp.temporal.TemporalAdjusters.k(r11)
            org.threeten.bp.chrono.MinguoDate r11 = r0.l(r11)
            org.threeten.bp.format.ResolverStyle r0 = org.threeten.bp.format.ResolverStyle.STRICT
            if (r12 != r0) goto L_0x02e6
            int r12 = r11.b(r1)
            if (r12 != r3) goto L_0x02e0
            goto L_0x02e6
        L_0x02e0:
            org.threeten.bp.DateTimeException r11 = new org.threeten.bp.DateTimeException
            r11.<init>(r6)
            throw r11
        L_0x02e6:
            return r11
        L_0x02e7:
            org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.DAY_OF_YEAR
            boolean r5 = r11.containsKey(r1)
            if (r5 == 0) goto L_0x0325
            java.lang.Object r5 = r11.remove(r0)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r0 = r0.m(r5)
            org.threeten.bp.format.ResolverStyle r5 = org.threeten.bp.format.ResolverStyle.LENIENT
            java.lang.Object r11 = r11.remove(r1)
            java.lang.Long r11 = (java.lang.Long) r11
            if (r12 != r5) goto L_0x0318
            long r11 = r11.longValue()
            long r11 = org.threeten.bp.jdk8.Jdk8Methods.q(r11, r3)
            org.threeten.bp.chrono.MinguoDate r0 = r10.j(r0, r2)
            org.threeten.bp.chrono.MinguoDate r11 = r0.K0(r11)
            return r11
        L_0x0318:
            long r11 = r11.longValue()
            int r11 = r1.m(r11)
            org.threeten.bp.chrono.MinguoDate r11 = r10.j(r0, r11)
            return r11
        L_0x0325:
            org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_WEEK_OF_YEAR
            boolean r5 = r11.containsKey(r1)
            if (r5 == 0) goto L_0x043f
            org.threeten.bp.temporal.ChronoField r5 = org.threeten.bp.temporal.ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR
            boolean r7 = r11.containsKey(r5)
            if (r7 == 0) goto L_0x03b2
            java.lang.Object r6 = r11.remove(r0)
            java.lang.Long r6 = (java.lang.Long) r6
            long r6 = r6.longValue()
            int r6 = r0.m(r6)
            org.threeten.bp.format.ResolverStyle r7 = org.threeten.bp.format.ResolverStyle.LENIENT
            if (r12 != r7) goto L_0x0374
            java.lang.Object r12 = r11.remove(r1)
            java.lang.Long r12 = (java.lang.Long) r12
            long r0 = r12.longValue()
            long r0 = org.threeten.bp.jdk8.Jdk8Methods.q(r0, r3)
            java.lang.Object r11 = r11.remove(r5)
            java.lang.Long r11 = (java.lang.Long) r11
            long r11 = r11.longValue()
            long r11 = org.threeten.bp.jdk8.Jdk8Methods.q(r11, r3)
            org.threeten.bp.chrono.MinguoDate r2 = r10.b(r6, r2, r2)
            org.threeten.bp.temporal.ChronoUnit r3 = org.threeten.bp.temporal.ChronoUnit.WEEKS
            org.threeten.bp.chrono.MinguoDate r0 = r2.q(r0, r3)
            org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.DAYS
            org.threeten.bp.chrono.MinguoDate r11 = r0.q(r11, r1)
            return r11
        L_0x0374:
            java.lang.Object r3 = r11.remove(r1)
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            int r1 = r1.m(r3)
            java.lang.Object r11 = r11.remove(r5)
            java.lang.Long r11 = (java.lang.Long) r11
            long r3 = r11.longValue()
            int r11 = r5.m(r3)
            org.threeten.bp.chrono.MinguoDate r3 = r10.b(r6, r2, r2)
            int r1 = r1 - r2
            int r1 = r1 * 7
            int r11 = r11 - r2
            int r1 = r1 + r11
            long r1 = (long) r1
            org.threeten.bp.chrono.MinguoDate r11 = r3.K0(r1)
            org.threeten.bp.format.ResolverStyle r1 = org.threeten.bp.format.ResolverStyle.STRICT
            if (r12 != r1) goto L_0x03b1
            int r12 = r11.b(r0)
            if (r12 != r6) goto L_0x03a9
            goto L_0x03b1
        L_0x03a9:
            org.threeten.bp.DateTimeException r11 = new org.threeten.bp.DateTimeException
            java.lang.String r12 = "Strict mode rejected date parsed to a different year"
            r11.<init>(r12)
            throw r11
        L_0x03b1:
            return r11
        L_0x03b2:
            org.threeten.bp.temporal.ChronoField r5 = org.threeten.bp.temporal.ChronoField.DAY_OF_WEEK
            boolean r7 = r11.containsKey(r5)
            if (r7 == 0) goto L_0x043f
            java.lang.Object r7 = r11.remove(r0)
            java.lang.Long r7 = (java.lang.Long) r7
            long r7 = r7.longValue()
            int r7 = r0.m(r7)
            org.threeten.bp.format.ResolverStyle r8 = org.threeten.bp.format.ResolverStyle.LENIENT
            if (r12 != r8) goto L_0x03f9
            java.lang.Object r12 = r11.remove(r1)
            java.lang.Long r12 = (java.lang.Long) r12
            long r0 = r12.longValue()
            long r0 = org.threeten.bp.jdk8.Jdk8Methods.q(r0, r3)
            java.lang.Object r11 = r11.remove(r5)
            java.lang.Long r11 = (java.lang.Long) r11
            long r11 = r11.longValue()
            long r11 = org.threeten.bp.jdk8.Jdk8Methods.q(r11, r3)
            org.threeten.bp.chrono.MinguoDate r2 = r10.b(r7, r2, r2)
            org.threeten.bp.temporal.ChronoUnit r3 = org.threeten.bp.temporal.ChronoUnit.WEEKS
            org.threeten.bp.chrono.MinguoDate r0 = r2.q(r0, r3)
            org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.DAYS
            org.threeten.bp.chrono.MinguoDate r11 = r0.q(r11, r1)
            return r11
        L_0x03f9:
            java.lang.Object r3 = r11.remove(r1)
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            int r1 = r1.m(r3)
            java.lang.Object r11 = r11.remove(r5)
            java.lang.Long r11 = (java.lang.Long) r11
            long r3 = r11.longValue()
            int r11 = r5.m(r3)
            org.threeten.bp.chrono.MinguoDate r3 = r10.b(r7, r2, r2)
            int r1 = r1 - r2
            long r1 = (long) r1
            org.threeten.bp.temporal.ChronoUnit r4 = org.threeten.bp.temporal.ChronoUnit.WEEKS
            org.threeten.bp.chrono.MinguoDate r1 = r3.q(r1, r4)
            org.threeten.bp.DayOfWeek r11 = org.threeten.bp.DayOfWeek.s(r11)
            org.threeten.bp.temporal.TemporalAdjuster r11 = org.threeten.bp.temporal.TemporalAdjusters.k(r11)
            org.threeten.bp.chrono.MinguoDate r11 = r1.l(r11)
            org.threeten.bp.format.ResolverStyle r1 = org.threeten.bp.format.ResolverStyle.STRICT
            if (r12 != r1) goto L_0x043e
            int r12 = r11.b(r0)
            if (r12 != r7) goto L_0x0438
            goto L_0x043e
        L_0x0438:
            org.threeten.bp.DateTimeException r11 = new org.threeten.bp.DateTimeException
            r11.<init>(r6)
            throw r11
        L_0x043e:
            return r11
        L_0x043f:
            r11 = 0
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.MinguoChronology.J(java.util.Map, org.threeten.bp.format.ResolverStyle):org.threeten.bp.chrono.MinguoDate");
    }

    public List<Era> p() {
        return Arrays.asList(MinguoEra.values());
    }

    public String s() {
        return "roc";
    }

    public String v() {
        return "Minguo";
    }

    public boolean x(long j2) {
        return IsoChronology.X2.x(j2 + 1911);
    }

    public ChronoLocalDateTime<MinguoDate> y(TemporalAccessor temporalAccessor) {
        return super.y(temporalAccessor);
    }
}
