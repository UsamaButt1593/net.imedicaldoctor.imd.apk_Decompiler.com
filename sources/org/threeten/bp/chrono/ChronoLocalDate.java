package org.threeten.bp.chrono;

import java.util.Comparator;
import org.apache.commons.lang3.StringUtils;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
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

public abstract class ChronoLocalDate extends DefaultInterfaceTemporal implements Temporal, TemporalAdjuster, Comparable<ChronoLocalDate> {
    private static final Comparator<ChronoLocalDate> s = new Comparator<ChronoLocalDate>() {
        /* renamed from: a */
        public int compare(ChronoLocalDate chronoLocalDate, ChronoLocalDate chronoLocalDate2) {
            return Jdk8Methods.b(chronoLocalDate.c0(), chronoLocalDate2.c0());
        }
    };

    public static Comparator<ChronoLocalDate> U() {
        return s;
    }

    public static ChronoLocalDate w(TemporalAccessor temporalAccessor) {
        Jdk8Methods.j(temporalAccessor, "temporal");
        if (temporalAccessor instanceof ChronoLocalDate) {
            return (ChronoLocalDate) temporalAccessor;
        }
        Chronology chronology = (Chronology) temporalAccessor.i(TemporalQueries.a());
        if (chronology != null) {
            return chronology.e(temporalAccessor);
        }
        throw new DateTimeException("No Chronology found to create ChronoLocalDate: " + temporalAccessor.getClass());
    }

    public boolean A(ChronoLocalDate chronoLocalDate) {
        return c0() < chronoLocalDate.c0();
    }

    public boolean D(ChronoLocalDate chronoLocalDate) {
        return c0() == chronoLocalDate.c0();
    }

    public boolean E() {
        return x().x(p(ChronoField.YEAR));
    }

    public abstract int F();

    public int J() {
        return E() ? 366 : 365;
    }

    /* renamed from: K */
    public ChronoLocalDate o(long j2, TemporalUnit temporalUnit) {
        return x().l(super.o(j2, temporalUnit));
    }

    /* renamed from: L */
    public ChronoLocalDate g(TemporalAmount temporalAmount) {
        return x().l(super.g(temporalAmount));
    }

    /* renamed from: Q */
    public abstract ChronoLocalDate q(long j2, TemporalUnit temporalUnit);

    /* renamed from: S */
    public ChronoLocalDate h(TemporalAmount temporalAmount) {
        return x().l(super.h(temporalAmount));
    }

    public long c0() {
        return p(ChronoField.EPOCH_DAY);
    }

    public Temporal e(Temporal temporal) {
        return temporal.a(ChronoField.EPOCH_DAY, c0());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoLocalDate) && compareTo((ChronoLocalDate) obj) == 0;
    }

    public abstract ChronoPeriod h0(ChronoLocalDate chronoLocalDate);

    public int hashCode() {
        long c0 = c0();
        return x().hashCode() ^ ((int) (c0 ^ (c0 >>> 32)));
    }

    public <R> R i(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.a()) {
            return x();
        }
        if (temporalQuery == TemporalQueries.e()) {
            return ChronoUnit.DAYS;
        }
        if (temporalQuery == TemporalQueries.b()) {
            return LocalDate.w2(c0());
        }
        if (temporalQuery == TemporalQueries.c() || temporalQuery == TemporalQueries.f() || temporalQuery == TemporalQueries.g() || temporalQuery == TemporalQueries.d()) {
            return null;
        }
        return super.i(temporalQuery);
    }

    /* renamed from: k0 */
    public ChronoLocalDate l(TemporalAdjuster temporalAdjuster) {
        return x().l(super.l(temporalAdjuster));
    }

    public boolean m(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField.a();
        }
        return temporalField != null && temporalField.c(this);
    }

    public boolean n(TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            return temporalUnit.a();
        }
        return temporalUnit != null && temporalUnit.f(this);
    }

    /* renamed from: q0 */
    public abstract ChronoLocalDate a(TemporalField temporalField, long j2);

    public ChronoLocalDateTime<?> s(LocalTime localTime) {
        return ChronoLocalDateTimeImpl.k0(this, localTime);
    }

    public String toString() {
        long p = p(ChronoField.YEAR_OF_ERA);
        long p2 = p(ChronoField.MONTH_OF_YEAR);
        long p3 = p(ChronoField.DAY_OF_MONTH);
        StringBuilder sb = new StringBuilder(30);
        sb.append(x().toString());
        sb.append(StringUtils.SPACE);
        sb.append(y());
        sb.append(StringUtils.SPACE);
        sb.append(p);
        String str = "-";
        sb.append(p2 < 10 ? "-0" : str);
        sb.append(p2);
        if (p3 < 10) {
            str = "-0";
        }
        sb.append(str);
        sb.append(p3);
        return sb.toString();
    }

    /* renamed from: u */
    public int compareTo(ChronoLocalDate chronoLocalDate) {
        int b2 = Jdk8Methods.b(c0(), chronoLocalDate.c0());
        return b2 == 0 ? x().compareTo(chronoLocalDate.x()) : b2;
    }

    public String v(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.j(dateTimeFormatter, "formatter");
        return dateTimeFormatter.d(this);
    }

    public abstract Chronology x();

    public Era y() {
        return x().o(b(ChronoField.ERA));
    }

    public boolean z(ChronoLocalDate chronoLocalDate) {
        return c0() > chronoLocalDate.c0();
    }
}
