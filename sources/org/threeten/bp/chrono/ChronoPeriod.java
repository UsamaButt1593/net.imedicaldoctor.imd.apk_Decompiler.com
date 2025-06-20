package org.threeten.bp.chrono;

import java.util.List;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalUnit;

public abstract class ChronoPeriod implements TemporalAmount {
    public static ChronoPeriod d(ChronoLocalDate chronoLocalDate, ChronoLocalDate chronoLocalDate2) {
        Jdk8Methods.j(chronoLocalDate, "startDateInclusive");
        Jdk8Methods.j(chronoLocalDate2, "endDateExclusive");
        return chronoLocalDate.h0(chronoLocalDate2);
    }

    public abstract Temporal a(Temporal temporal);

    public abstract Temporal b(Temporal temporal);

    public abstract List<TemporalUnit> c();

    public abstract long e(TemporalUnit temporalUnit);

    public abstract boolean equals(Object obj);

    public abstract Chronology f();

    public boolean g() {
        for (TemporalUnit e2 : c()) {
            if (e(e2) < 0) {
                return true;
            }
        }
        return false;
    }

    public boolean h() {
        for (TemporalUnit e2 : c()) {
            if (e(e2) != 0) {
                return false;
            }
        }
        return true;
    }

    public abstract int hashCode();

    public abstract ChronoPeriod i(TemporalAmount temporalAmount);

    public abstract ChronoPeriod j(int i2);

    public ChronoPeriod k() {
        return j(-1);
    }

    public abstract ChronoPeriod l();

    public abstract ChronoPeriod m(TemporalAmount temporalAmount);

    public abstract String toString();
}
