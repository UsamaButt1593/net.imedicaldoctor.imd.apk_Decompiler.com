package org.threeten.bp.chrono;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.dd.plist.ASCIIPropertyListParser;
import java.util.Comparator;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.jdk8.DefaultInterfaceTemporal;
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

public abstract class ChronoLocalDateTime<D extends ChronoLocalDate> extends DefaultInterfaceTemporal implements Temporal, TemporalAdjuster, Comparable<ChronoLocalDateTime<?>> {
    private static final Comparator<ChronoLocalDateTime<?>> s = new Comparator<ChronoLocalDateTime<?>>() {
        /* JADX WARNING: type inference failed for: r5v0, types: [org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.chrono.ChronoLocalDateTime<?>] */
        /* JADX WARNING: type inference failed for: r6v0, types: [org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.chrono.ChronoLocalDateTime<?>] */
        /* JADX WARNING: Unknown variable types count: 2 */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int compare(org.threeten.bp.chrono.ChronoLocalDateTime<?> r5, org.threeten.bp.chrono.ChronoLocalDateTime<?> r6) {
            /*
                r4 = this;
                org.threeten.bp.chrono.ChronoLocalDate r0 = r5.S()
                long r0 = r0.c0()
                org.threeten.bp.chrono.ChronoLocalDate r2 = r6.S()
                long r2 = r2.c0()
                int r0 = org.threeten.bp.jdk8.Jdk8Methods.b(r0, r2)
                if (r0 != 0) goto L_0x002a
                org.threeten.bp.LocalTime r5 = r5.U()
                long r0 = r5.j1()
                org.threeten.bp.LocalTime r5 = r6.U()
                long r5 = r5.j1()
                int r0 = org.threeten.bp.jdk8.Jdk8Methods.b(r0, r5)
            L_0x002a:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.ChronoLocalDateTime.AnonymousClass1.compare(org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.chrono.ChronoLocalDateTime):int");
        }
    };

    public static Comparator<ChronoLocalDateTime<?>> K() {
        return s;
    }

    public static ChronoLocalDateTime<?> w(TemporalAccessor temporalAccessor) {
        Jdk8Methods.j(temporalAccessor, "temporal");
        if (temporalAccessor instanceof ChronoLocalDateTime) {
            return (ChronoLocalDateTime) temporalAccessor;
        }
        Chronology chronology = (Chronology) temporalAccessor.i(TemporalQueries.a());
        if (chronology != null) {
            return chronology.y(temporalAccessor);
        }
        throw new DateTimeException("No Chronology found to create ChronoLocalDateTime: " + temporalAccessor.getClass());
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.chrono.ChronoLocalDateTime<?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean A(org.threeten.bp.chrono.ChronoLocalDateTime<?> r6) {
        /*
            r5 = this;
            org.threeten.bp.LocalTime r0 = r5.U()
            long r0 = r0.j1()
            org.threeten.bp.LocalTime r2 = r6.U()
            long r2 = r2.j1()
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x002a
            org.threeten.bp.chrono.ChronoLocalDate r0 = r5.S()
            long r0 = r0.c0()
            org.threeten.bp.chrono.ChronoLocalDate r6 = r6.S()
            long r2 = r6.c0()
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x002a
            r6 = 1
            goto L_0x002b
        L_0x002a:
            r6 = 0
        L_0x002b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.ChronoLocalDateTime.A(org.threeten.bp.chrono.ChronoLocalDateTime):boolean");
    }

    /* renamed from: D */
    public ChronoLocalDateTime<D> o(long j2, TemporalUnit temporalUnit) {
        return S().x().m(super.o(j2, temporalUnit));
    }

    /* renamed from: E */
    public ChronoLocalDateTime<D> g(TemporalAmount temporalAmount) {
        return S().x().m(super.g(temporalAmount));
    }

    /* renamed from: F */
    public abstract ChronoLocalDateTime<D> q(long j2, TemporalUnit temporalUnit);

    /* renamed from: J */
    public ChronoLocalDateTime<D> h(TemporalAmount temporalAmount) {
        return S().x().m(super.h(temporalAmount));
    }

    public long L(ZoneOffset zoneOffset) {
        Jdk8Methods.j(zoneOffset, TypedValues.CycleType.R);
        return ((S().c0() * 86400) + ((long) U().k1())) - ((long) zoneOffset.F());
    }

    public Instant Q(ZoneOffset zoneOffset) {
        return Instant.k0(L(zoneOffset), (long) U().A());
    }

    public abstract D S();

    public abstract LocalTime U();

    /* renamed from: c0 */
    public ChronoLocalDateTime<D> l(TemporalAdjuster temporalAdjuster) {
        return S().x().m(super.l(temporalAdjuster));
    }

    public Temporal e(Temporal temporal) {
        return temporal.a(ChronoField.EPOCH_DAY, S().c0()).a(ChronoField.NANO_OF_DAY, U().j1());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoLocalDateTime) && compareTo((ChronoLocalDateTime) obj) == 0;
    }

    /* renamed from: h0 */
    public abstract ChronoLocalDateTime<D> a(TemporalField temporalField, long j2);

    public int hashCode() {
        return S().hashCode() ^ U().hashCode();
    }

    public <R> R i(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.a()) {
            return x();
        }
        if (temporalQuery == TemporalQueries.e()) {
            return ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries.b()) {
            return LocalDate.w2(S().c0());
        }
        if (temporalQuery == TemporalQueries.c()) {
            return U();
        }
        if (temporalQuery == TemporalQueries.f() || temporalQuery == TemporalQueries.g() || temporalQuery == TemporalQueries.d()) {
            return null;
        }
        return super.i(temporalQuery);
    }

    public abstract ChronoZonedDateTime<D> s(ZoneId zoneId);

    public String toString() {
        return S().toString() + ASCIIPropertyListParser.C + U().toString();
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.chrono.ChronoLocalDateTime<?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: u */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(org.threeten.bp.chrono.ChronoLocalDateTime<?> r3) {
        /*
            r2 = this;
            org.threeten.bp.chrono.ChronoLocalDate r0 = r2.S()
            org.threeten.bp.chrono.ChronoLocalDate r1 = r3.S()
            int r0 = r0.compareTo(r1)
            if (r0 != 0) goto L_0x0028
            org.threeten.bp.LocalTime r0 = r2.U()
            org.threeten.bp.LocalTime r1 = r3.U()
            int r0 = r0.compareTo(r1)
            if (r0 != 0) goto L_0x0028
            org.threeten.bp.chrono.Chronology r0 = r2.x()
            org.threeten.bp.chrono.Chronology r3 = r3.x()
            int r0 = r0.compareTo(r3)
        L_0x0028:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.ChronoLocalDateTime.compareTo(org.threeten.bp.chrono.ChronoLocalDateTime):int");
    }

    public String v(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.j(dateTimeFormatter, "formatter");
        return dateTimeFormatter.d(this);
    }

    public Chronology x() {
        return S().x();
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.chrono.ChronoLocalDateTime<?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean y(org.threeten.bp.chrono.ChronoLocalDateTime<?> r6) {
        /*
            r5 = this;
            org.threeten.bp.chrono.ChronoLocalDate r0 = r5.S()
            long r0 = r0.c0()
            org.threeten.bp.chrono.ChronoLocalDate r2 = r6.S()
            long r2 = r2.c0()
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x002d
            if (r4 != 0) goto L_0x002b
            org.threeten.bp.LocalTime r0 = r5.U()
            long r0 = r0.j1()
            org.threeten.bp.LocalTime r6 = r6.U()
            long r2 = r6.j1()
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 <= 0) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            r6 = 0
            goto L_0x002e
        L_0x002d:
            r6 = 1
        L_0x002e:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.ChronoLocalDateTime.y(org.threeten.bp.chrono.ChronoLocalDateTime):boolean");
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.chrono.ChronoLocalDateTime<?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean z(org.threeten.bp.chrono.ChronoLocalDateTime<?> r6) {
        /*
            r5 = this;
            org.threeten.bp.chrono.ChronoLocalDate r0 = r5.S()
            long r0 = r0.c0()
            org.threeten.bp.chrono.ChronoLocalDate r2 = r6.S()
            long r2 = r2.c0()
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x002d
            if (r4 != 0) goto L_0x002b
            org.threeten.bp.LocalTime r0 = r5.U()
            long r0 = r0.j1()
            org.threeten.bp.LocalTime r6 = r6.U()
            long r2 = r6.j1()
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            r6 = 0
            goto L_0x002e
        L_0x002d:
            r6 = 1
        L_0x002e:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.ChronoLocalDateTime.z(org.threeten.bp.chrono.ChronoLocalDateTime):boolean");
    }
}
