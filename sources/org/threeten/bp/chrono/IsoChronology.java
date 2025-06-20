package org.threeten.bp.chrono;

import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import org.threeten.bp.Clock;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.ValueRange;

public final class IsoChronology extends Chronology implements Serializable {
    public static final IsoChronology X2 = new IsoChronology();
    private static final long Y2 = -1440403870442975015L;

    private IsoChronology() {
    }

    private Object H() {
        return X2;
    }

    public int D(Era era, int i2) {
        if (era instanceof IsoEra) {
            return era == IsoEra.CE ? i2 : 1 - i2;
        }
        throw new ClassCastException("Era must be IsoEra");
    }

    public ValueRange E(ChronoField chronoField) {
        return chronoField.h();
    }

    /* renamed from: Q */
    public LocalDate b(int i2, int i3, int i4) {
        return LocalDate.r2(i2, i3, i4);
    }

    /* renamed from: R */
    public LocalDate c(Era era, int i2, int i3, int i4) {
        return b(D(era, i2), i3, i4);
    }

    /* renamed from: S */
    public LocalDate e(TemporalAccessor temporalAccessor) {
        return LocalDate.c1(temporalAccessor);
    }

    /* renamed from: T */
    public LocalDate f(long j2) {
        return LocalDate.w2(j2);
    }

    /* renamed from: U */
    public LocalDate g() {
        return h(Clock.g());
    }

    /* renamed from: W */
    public LocalDate h(Clock clock) {
        Jdk8Methods.j(clock, "clock");
        return e(LocalDate.p2(clock));
    }

    /* renamed from: Z */
    public LocalDate i(ZoneId zoneId) {
        return h(Clock.f(zoneId));
    }

    /* renamed from: a0 */
    public LocalDate j(int i2, int i3) {
        return LocalDate.B2(i2, i3);
    }

    /* renamed from: c0 */
    public LocalDate k(Era era, int i2, int i3) {
        return j(D(era, i2), i3);
    }

    /* renamed from: d0 */
    public IsoEra o(int i2) {
        return IsoEra.j(i2);
    }

    /* renamed from: e0 */
    public LocalDateTime y(TemporalAccessor temporalAccessor) {
        return LocalDateTime.v0(temporalAccessor);
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
    /* renamed from: h0 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.threeten.bp.LocalDate J(java.util.Map<org.threeten.bp.temporal.TemporalField, java.lang.Long> r11, org.threeten.bp.format.ResolverStyle r12) {
        /*
            r10 = this;
            org.threeten.bp.temporal.ChronoField r0 = org.threeten.bp.temporal.ChronoField.EPOCH_DAY
            boolean r1 = r11.containsKey(r0)
            if (r1 == 0) goto L_0x0017
            java.lang.Object r11 = r11.remove(r0)
            java.lang.Long r11 = (java.lang.Long) r11
            long r11 = r11.longValue()
            org.threeten.bp.LocalDate r11 = org.threeten.bp.LocalDate.w2(r11)
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
            if (r1 == 0) goto L_0x0429
            org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MONTH_OF_YEAR
            boolean r5 = r11.containsKey(r1)
            java.lang.String r6 = "Strict mode rejected date parsed to a different month"
            if (r5 == 0) goto L_0x02db
            org.threeten.bp.temporal.ChronoField r5 = org.threeten.bp.temporal.ChronoField.DAY_OF_MONTH
            boolean r7 = r11.containsKey(r5)
            if (r7 == 0) goto L_0x018d
            java.lang.Object r3 = r11.remove(r0)
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            int r0 = r0.m(r3)
            java.lang.Object r1 = r11.remove(r1)
            java.lang.Long r1 = (java.lang.Long) r1
            long r3 = r1.longValue()
            int r1 = org.threeten.bp.jdk8.Jdk8Methods.r(r3)
            java.lang.Object r11 = r11.remove(r5)
            java.lang.Long r11 = (java.lang.Long) r11
            long r3 = r11.longValue()
            int r11 = org.threeten.bp.jdk8.Jdk8Methods.r(r3)
            org.threeten.bp.format.ResolverStyle r3 = org.threeten.bp.format.ResolverStyle.LENIENT
            if (r12 != r3) goto L_0x0156
            int r12 = org.threeten.bp.jdk8.Jdk8Methods.p(r1, r2)
            long r3 = (long) r12
            int r11 = org.threeten.bp.jdk8.Jdk8Methods.p(r11, r2)
            long r11 = (long) r11
            org.threeten.bp.LocalDate r0 = org.threeten.bp.LocalDate.r2(r0, r2, r2)
            org.threeten.bp.LocalDate r0 = r0.L2(r3)
            org.threeten.bp.LocalDate r11 = r0.J2(r11)
            return r11
        L_0x0156:
            org.threeten.bp.format.ResolverStyle r2 = org.threeten.bp.format.ResolverStyle.SMART
            if (r12 != r2) goto L_0x0188
            long r2 = (long) r11
            r5.n(r2)
            r12 = 4
            if (r1 == r12) goto L_0x0180
            r12 = 6
            if (r1 == r12) goto L_0x0180
            r12 = 9
            if (r1 == r12) goto L_0x0180
            r12 = 11
            if (r1 != r12) goto L_0x016d
            goto L_0x0180
        L_0x016d:
            r12 = 2
            if (r1 != r12) goto L_0x0183
            org.threeten.bp.Month r12 = org.threeten.bp.Month.FEBRUARY
            long r2 = (long) r0
            boolean r2 = org.threeten.bp.Year.F(r2)
            int r12 = r12.u(r2)
        L_0x017b:
            int r11 = java.lang.Math.min(r11, r12)
            goto L_0x0183
        L_0x0180:
            r12 = 30
            goto L_0x017b
        L_0x0183:
            org.threeten.bp.LocalDate r11 = org.threeten.bp.LocalDate.r2(r0, r1, r11)
            return r11
        L_0x0188:
            org.threeten.bp.LocalDate r11 = org.threeten.bp.LocalDate.r2(r0, r1, r11)
            return r11
        L_0x018d:
            org.threeten.bp.temporal.ChronoField r5 = org.threeten.bp.temporal.ChronoField.ALIGNED_WEEK_OF_MONTH
            boolean r7 = r11.containsKey(r5)
            if (r7 == 0) goto L_0x02db
            org.threeten.bp.temporal.ChronoField r7 = org.threeten.bp.temporal.ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH
            boolean r8 = r11.containsKey(r7)
            if (r8 == 0) goto L_0x0234
            java.lang.Object r8 = r11.remove(r0)
            java.lang.Long r8 = (java.lang.Long) r8
            long r8 = r8.longValue()
            int r0 = r0.m(r8)
            org.threeten.bp.format.ResolverStyle r8 = org.threeten.bp.format.ResolverStyle.LENIENT
            if (r12 != r8) goto L_0x01ea
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
            org.threeten.bp.LocalDate r0 = org.threeten.bp.LocalDate.r2(r0, r2, r2)
            org.threeten.bp.LocalDate r0 = r0.L2(r8)
            org.threeten.bp.LocalDate r0 = r0.M2(r5)
            org.threeten.bp.LocalDate r11 = r0.J2(r11)
            return r11
        L_0x01ea:
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
            org.threeten.bp.LocalDate r0 = org.threeten.bp.LocalDate.r2(r0, r3, r2)
            int r4 = r4 - r2
            int r4 = r4 * 7
            int r11 = r11 - r2
            int r4 = r4 + r11
            long r4 = (long) r4
            org.threeten.bp.LocalDate r11 = r0.J2(r4)
            org.threeten.bp.format.ResolverStyle r0 = org.threeten.bp.format.ResolverStyle.STRICT
            if (r12 != r0) goto L_0x0233
            int r12 = r11.b(r1)
            if (r12 != r3) goto L_0x022d
            goto L_0x0233
        L_0x022d:
            org.threeten.bp.DateTimeException r11 = new org.threeten.bp.DateTimeException
            r11.<init>(r6)
            throw r11
        L_0x0233:
            return r11
        L_0x0234:
            org.threeten.bp.temporal.ChronoField r7 = org.threeten.bp.temporal.ChronoField.DAY_OF_WEEK
            boolean r8 = r11.containsKey(r7)
            if (r8 == 0) goto L_0x02db
            java.lang.Object r8 = r11.remove(r0)
            java.lang.Long r8 = (java.lang.Long) r8
            long r8 = r8.longValue()
            int r0 = r0.m(r8)
            org.threeten.bp.format.ResolverStyle r8 = org.threeten.bp.format.ResolverStyle.LENIENT
            if (r12 != r8) goto L_0x0289
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
            org.threeten.bp.LocalDate r0 = org.threeten.bp.LocalDate.r2(r0, r2, r2)
            org.threeten.bp.LocalDate r0 = r0.L2(r8)
            org.threeten.bp.LocalDate r0 = r0.M2(r5)
            org.threeten.bp.LocalDate r11 = r0.J2(r11)
            return r11
        L_0x0289:
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
            org.threeten.bp.LocalDate r0 = org.threeten.bp.LocalDate.r2(r0, r3, r2)
            int r4 = r4 - r2
            long r4 = (long) r4
            org.threeten.bp.LocalDate r0 = r0.M2(r4)
            org.threeten.bp.DayOfWeek r11 = org.threeten.bp.DayOfWeek.s(r11)
            org.threeten.bp.temporal.TemporalAdjuster r11 = org.threeten.bp.temporal.TemporalAdjusters.k(r11)
            org.threeten.bp.LocalDate r11 = r0.l(r11)
            org.threeten.bp.format.ResolverStyle r0 = org.threeten.bp.format.ResolverStyle.STRICT
            if (r12 != r0) goto L_0x02da
            int r12 = r11.b(r1)
            if (r12 != r3) goto L_0x02d4
            goto L_0x02da
        L_0x02d4:
            org.threeten.bp.DateTimeException r11 = new org.threeten.bp.DateTimeException
            r11.<init>(r6)
            throw r11
        L_0x02da:
            return r11
        L_0x02db:
            org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.DAY_OF_YEAR
            boolean r5 = r11.containsKey(r1)
            if (r5 == 0) goto L_0x0319
            java.lang.Object r5 = r11.remove(r0)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r0 = r0.m(r5)
            org.threeten.bp.format.ResolverStyle r5 = org.threeten.bp.format.ResolverStyle.LENIENT
            java.lang.Object r11 = r11.remove(r1)
            java.lang.Long r11 = (java.lang.Long) r11
            if (r12 != r5) goto L_0x030c
            long r11 = r11.longValue()
            long r11 = org.threeten.bp.jdk8.Jdk8Methods.q(r11, r3)
            org.threeten.bp.LocalDate r0 = org.threeten.bp.LocalDate.B2(r0, r2)
            org.threeten.bp.LocalDate r11 = r0.J2(r11)
            return r11
        L_0x030c:
            long r11 = r11.longValue()
            int r11 = r1.m(r11)
            org.threeten.bp.LocalDate r11 = org.threeten.bp.LocalDate.B2(r0, r11)
            return r11
        L_0x0319:
            org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_WEEK_OF_YEAR
            boolean r5 = r11.containsKey(r1)
            if (r5 == 0) goto L_0x0429
            org.threeten.bp.temporal.ChronoField r5 = org.threeten.bp.temporal.ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR
            boolean r7 = r11.containsKey(r5)
            if (r7 == 0) goto L_0x03a2
            java.lang.Object r6 = r11.remove(r0)
            java.lang.Long r6 = (java.lang.Long) r6
            long r6 = r6.longValue()
            int r6 = r0.m(r6)
            org.threeten.bp.format.ResolverStyle r7 = org.threeten.bp.format.ResolverStyle.LENIENT
            if (r12 != r7) goto L_0x0364
            java.lang.Object r12 = r11.remove(r1)
            java.lang.Long r12 = (java.lang.Long) r12
            long r0 = r12.longValue()
            long r0 = org.threeten.bp.jdk8.Jdk8Methods.q(r0, r3)
            java.lang.Object r11 = r11.remove(r5)
            java.lang.Long r11 = (java.lang.Long) r11
            long r11 = r11.longValue()
            long r11 = org.threeten.bp.jdk8.Jdk8Methods.q(r11, r3)
            org.threeten.bp.LocalDate r2 = org.threeten.bp.LocalDate.r2(r6, r2, r2)
            org.threeten.bp.LocalDate r0 = r2.M2(r0)
            org.threeten.bp.LocalDate r11 = r0.J2(r11)
            return r11
        L_0x0364:
            java.lang.Object r3 = r11.remove(r1)
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            int r1 = r1.m(r3)
            java.lang.Object r11 = r11.remove(r5)
            java.lang.Long r11 = (java.lang.Long) r11
            long r3 = r11.longValue()
            int r11 = r5.m(r3)
            org.threeten.bp.LocalDate r3 = org.threeten.bp.LocalDate.r2(r6, r2, r2)
            int r1 = r1 - r2
            int r1 = r1 * 7
            int r11 = r11 - r2
            int r1 = r1 + r11
            long r1 = (long) r1
            org.threeten.bp.LocalDate r11 = r3.J2(r1)
            org.threeten.bp.format.ResolverStyle r1 = org.threeten.bp.format.ResolverStyle.STRICT
            if (r12 != r1) goto L_0x03a1
            int r12 = r11.b(r0)
            if (r12 != r6) goto L_0x0399
            goto L_0x03a1
        L_0x0399:
            org.threeten.bp.DateTimeException r11 = new org.threeten.bp.DateTimeException
            java.lang.String r12 = "Strict mode rejected date parsed to a different year"
            r11.<init>(r12)
            throw r11
        L_0x03a1:
            return r11
        L_0x03a2:
            org.threeten.bp.temporal.ChronoField r5 = org.threeten.bp.temporal.ChronoField.DAY_OF_WEEK
            boolean r7 = r11.containsKey(r5)
            if (r7 == 0) goto L_0x0429
            java.lang.Object r7 = r11.remove(r0)
            java.lang.Long r7 = (java.lang.Long) r7
            long r7 = r7.longValue()
            int r7 = r0.m(r7)
            org.threeten.bp.format.ResolverStyle r8 = org.threeten.bp.format.ResolverStyle.LENIENT
            if (r12 != r8) goto L_0x03e5
            java.lang.Object r12 = r11.remove(r1)
            java.lang.Long r12 = (java.lang.Long) r12
            long r0 = r12.longValue()
            long r0 = org.threeten.bp.jdk8.Jdk8Methods.q(r0, r3)
            java.lang.Object r11 = r11.remove(r5)
            java.lang.Long r11 = (java.lang.Long) r11
            long r11 = r11.longValue()
            long r11 = org.threeten.bp.jdk8.Jdk8Methods.q(r11, r3)
            org.threeten.bp.LocalDate r2 = org.threeten.bp.LocalDate.r2(r7, r2, r2)
            org.threeten.bp.LocalDate r0 = r2.M2(r0)
            org.threeten.bp.LocalDate r11 = r0.J2(r11)
            return r11
        L_0x03e5:
            java.lang.Object r3 = r11.remove(r1)
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            int r1 = r1.m(r3)
            java.lang.Object r11 = r11.remove(r5)
            java.lang.Long r11 = (java.lang.Long) r11
            long r3 = r11.longValue()
            int r11 = r5.m(r3)
            org.threeten.bp.LocalDate r3 = org.threeten.bp.LocalDate.r2(r7, r2, r2)
            int r1 = r1 - r2
            long r1 = (long) r1
            org.threeten.bp.LocalDate r1 = r3.M2(r1)
            org.threeten.bp.DayOfWeek r11 = org.threeten.bp.DayOfWeek.s(r11)
            org.threeten.bp.temporal.TemporalAdjuster r11 = org.threeten.bp.temporal.TemporalAdjusters.k(r11)
            org.threeten.bp.LocalDate r11 = r1.l(r11)
            org.threeten.bp.format.ResolverStyle r1 = org.threeten.bp.format.ResolverStyle.STRICT
            if (r12 != r1) goto L_0x0428
            int r12 = r11.b(r0)
            if (r12 != r7) goto L_0x0422
            goto L_0x0428
        L_0x0422:
            org.threeten.bp.DateTimeException r11 = new org.threeten.bp.DateTimeException
            r11.<init>(r6)
            throw r11
        L_0x0428:
            return r11
        L_0x0429:
            r11 = 0
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.IsoChronology.J(java.util.Map, org.threeten.bp.format.ResolverStyle):org.threeten.bp.LocalDate");
    }

    /* renamed from: i0 */
    public ZonedDateTime O(Instant instant, ZoneId zoneId) {
        return ZonedDateTime.q2(instant, zoneId);
    }

    /* renamed from: j0 */
    public ZonedDateTime P(TemporalAccessor temporalAccessor) {
        return ZonedDateTime.K0(temporalAccessor);
    }

    public List<Era> p() {
        return Arrays.asList(IsoEra.values());
    }

    public String s() {
        return "iso8601";
    }

    public String v() {
        return ExifInterface.r2;
    }

    public boolean x(long j2) {
        return (3 & j2) == 0 && (j2 % 100 != 0 || j2 % 400 == 0);
    }
}
